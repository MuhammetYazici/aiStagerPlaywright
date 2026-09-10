package Utilities;

import com.microsoft.playwright.*;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

import javax.sql.rowset.BaseRowSet;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class PD {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    private static final String tracePath = "src/test/resources/TraceViewer/";
    private static final String videoPath = "src/test/resources/Video/";

    public static Page getPage() {
        if (page == null) {
            playwright = Playwright.create();
            String browserName = ConfigReader.getProperty("browser");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(true).setArgs(Arrays.asList("--start-maximized"));
            ;

            switch (browserName.toLowerCase()) {
                case "chromium":
                    browser = playwright.chromium().launch(launchOptions);
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(launchOptions);
                    break;
                case "edge":
                    launchOptions.setChannel("msedge");
                    browser = playwright.chromium().launch(launchOptions);
                    break;
                case "chrome":
                    launchOptions.setChannel("chrome");
                    browser = playwright.chromium().launch(launchOptions);
                    break;
                default:
                    String message = "Tarayıcı ismi geçersiz. " + browserName;
                    message += "Lütfen geçerli bir tarayıcı ismi giriniz [Edge, Firefox, Chrome,Chromium]";
            }

            int width = ConfigReader.getIntProperty("width");
            int height = ConfigReader.getIntProperty("height");

            Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get(videoPath))
                    .setViewportSize(width,height);

            context = browser.newContext(contextOptions);
            ;
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            page = context.newPage();
        }
        return page;
    }

    public static void quitPage(Scenario scenario) {
        Video video = null;

        if (page != null) {
            video = page.video();
        }

        try {
            if (scenario.isFailed()) {
                context.tracing().stop(new Tracing.StopOptions()
                        .setPath(Paths.get(getTracePath(scenario))));
            } else {
                context.tracing().stop();
                cleanupOldTraces(tracePath);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("TraceViewer kaydetme işlemi başarısız. " + e);
        } finally {
            contextClose();

            if (video != null) {
                try {
                    if (scenario.isFailed()) {
                        Path customVideoPath = Paths.get(getVideoPath(scenario));
                        video.saveAs(customVideoPath);
                        video.delete();
                        System.out.println("Hata vidosu kaydedildi: " + customVideoPath);
                    } else {
                        video.delete();
                        cleanupOldTraces(videoPath);
                    }
                } catch (Exception e) {
                    System.err.println("⚠ Video kaydetme işlemi başarısız: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            cleanUp();
        }
    }

    private static void contextClose(){
        if (context != null){ context.close();}
    }

    private static void cleanUp() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        page = null;
        context = null;
        browser = null;
        playwright = null;
    }

    public static String getTracePath(Scenario scenario) {
        String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String tarih = new SimpleDateFormat("__HH__mm__ss__ddMMyyyy").format(new Date());
        return tracePath + name + "_" + tarih + "_trace.zip";
    }

    public static String getVideoPath(Scenario scenario) {
        String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String tarih = new SimpleDateFormat("__HH__mm__ss__ddMMyyyy").format(new Date());
        return videoPath + name + "_" + tarih + ".webm";
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
