package Utilities;

import com.microsoft.playwright.*;
import io.cucumber.java.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class PD {
    private static Playwright playwright;
    private static Browser browser;

    private static final ThreadLocal<BrowserContext> threadContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> threadPage = new ThreadLocal<>();

    private static final String TRACE_PATH = "src/test/resources/TraceViewer/";
    private static final String VIDEO_PATH = "src/test/resources/Video/";


    private PD() {
    }


    public static synchronized void initBrowser() {
        if (playwright == null) {
            playwright = Playwright.create();

            String browserName = ConfigReader.getProperty("browser");
            if (browserName == null) {
                browserName = "chromium";
            }

            boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                    .setHeadless(isHeadless)
                    .setArgs(Arrays.asList("--start-maximized"));

            switch (browserName) {
                case "firefox":
                    browser = playwright.firefox().launch(launchOptions);
                    break;
                case "chrome":
                    launchOptions.setChannel("chrome");
                    browser = playwright.chromium().launch(launchOptions);
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(launchOptions);
                    break;
                case "edge":
                    launchOptions.setChannel("msedge");
                    browser = playwright.chromium().launch(launchOptions);
                    break;
                case "chromium":
                default:
                    browser = playwright.chromium().launch(launchOptions);
                    break;

            }
        }
    }


    public static Page getPage() {

        if (browser == null) {
            initBrowser();
        }

        if (threadPage.get() == null) {
            int width = ConfigReader.getIntProperty("width");
            int height = ConfigReader.getIntProperty("height");

            Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get(VIDEO_PATH))
                    .setViewportSize(width > 0 ? width : 1920, height > 0 ? height : 1080);


            BrowserContext context = browser.newContext(contextOptions);

            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();

            threadContext.set(context);
            threadPage.set(page);
        }

        return threadPage.get();
    }



    public static void closePage(Scenario scenario) {
        Page page = threadPage.get();
        BrowserContext context = threadContext.get();

        if (context == null) {
            return;
        }

        Video video;

        if (page != null) {
            video = page.video();
        } else {
            video = null;
        }

        try {
            if (scenario.isFailed()) {
                Path tracePath = Paths.get(getTracePath(scenario));
                context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
                System.out.println("❌ Test patladı! Trace kaydedildi: " + tracePath);
            }else {
                context.tracing().stop();
                cleanupOldTraces(TRACE_PATH);
            }
        }catch (Exception e){
            System.out.println("⚠ Trace durdurulurken hata oluştu: "+ e.getMessage());
        }finally {
            try {
                if (page != null){
                    page.close();
                }
                context.close();
            }catch (Exception e){
                System.out.println("⚠ Context kapatılırken hata: "+ e.getMessage());
            }

            if (video != null){
                try {
                    if (scenario.isFailed()){
                        Path videoPath = Paths.get(getVideoPath(scenario));
                        video.saveAs(videoPath);
                        video.delete();
                        System.out.println("Video kaydedildi:"+ videoPath);
                    }else {
                        video.delete();
                        cleanupOldTraces(VIDEO_PATH);
                    }
                }catch (Exception e){
                    System.out.println("⚠ Video dosyası işlenirken hata: "+ e.getMessage());
                }
            }

            threadPage.remove();
            threadContext.remove();

        }
    }


    public static synchronized void quitBrowser(){
        if (browser != null){
            browser.close();
            browser = null;
        }

        if (playwright != null){
            playwright.close();
            playwright = null;
        }
    }


    public static String getTracePath(Scenario scenario) {
        String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String tarih = new SimpleDateFormat("__HH__mm__ss__ddMMyyyy").format(new Date());
        return TRACE_PATH + name + "_" + tarih + "_trace.zip";
    }

    public static String getVideoPath(Scenario scenario) {
        String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String tarih = new SimpleDateFormat("__HH__mm__ss__ddMMyyyy").format(new Date());
        return VIDEO_PATH + name + "_" + tarih + ".webm";
    }

    private static void cleanupOldTraces(String path) {
        final long EXPIRATION_TIME = 86400000;
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            long now = System.currentTimeMillis();
            for (File file : files) {
                if (now - file.lastModified() > EXPIRATION_TIME) {
                    if (!file.delete()) {
                        System.err.println("istediğiniz dosya silinemedi: " + file.getPath());
                    }
                }
            }
        }
    }

}
