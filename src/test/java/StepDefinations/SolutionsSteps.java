package StepDefinations;

import Pages.SolutionsPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.ConsoleMessage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SolutionsSteps {

    SolutionsPage solutionsPage = new SolutionsPage();
    ReusableMethod rm = new ReusableMethod();
    List<String> consoleJsErrors = new ArrayList<>();

    @Given("Ziyaretçi oturum açmamış \\(anonim) durumdadır")
    public void ziyaretciOturumAcmamisDurumdadir() {
        PD.getPage().context().clearCookies();
    }

    @Given("Ziyaretçi {string} ana çözümler sayfasındadır")
    public void ziyaretciAnaCozumlerSayfasindadir(String url) {
        String resolvedUrl = rm.resolveDynamicValue(url);
        PD.getPage().navigate(resolvedUrl);
    }

    @When("Ziyaretçi {string} menüsündeki {string} seçeneğine tıklarsa")
    public void ziyaretciMenusundekiSecenegeTiklarsa(String menuName, String sectorOption) {
        rm.myClick(solutionsPage.getBusinessMenu());
        rm.myClick(solutionsPage.getSectorOption(sectorOption));
    }

    @Then("Ziyaretçi {string} adresine yönlendirilmelidir")
    public void ziyaretciAdresineYonlendirilmelidir(String expectedTargetUrl) {
        String resolvedTarget = rm.resolveDynamicValue(expectedTargetUrl);
        PD.getPage().waitForURL("**" + resolvedTarget + "**");
        Assert.assertTrue(PD.getPage().url().contains(resolvedTarget), "Beklenen URL bulunamadı: " + resolvedTarget);
    }

    @Then("Sayfa başlığı ve içeriği {string} ile uyumlu yüklenmelidir")
    public void sayfaBasligiVeIcerigiIleUyumluYuklenmelidir(String sectorOption) {
        String resolvedSector = rm.resolveDynamicValue(sectorOption);
        rm.veriyfyContainsText(PD.getPage().locator("h1, title, main"), resolvedSector);
    }

    @Given("Ziyaretçi {string} sayfasındadır")
    public void ziyaretciSayfasindadir(String pagePath) {
        String resolvedPath = rm.resolveDynamicValue(pagePath);
        String fullUrl = resolvedPath.startsWith("http") ? resolvedPath : "https://example.com" + resolvedPath;
        PD.getPage().navigate(fullUrl);
    }

    @When("Ziyaretçi Hero alanındaki {string} butonuna tıklarsa")
    public void ziyaretciHeroAlanindakiButonunaTiklarsa(String buttonText) {
        rm.myClick(solutionsPage.getHeroCTA(buttonText));
    }

    @Then("URL parametrelerinde yönlendirme kaynağı bilgisi \\(ref\\/redirect) bulunmalıdır")
    public void urlParametrelerindeYonlendirmeKaynagiBilgisiBulunmalidir() {
        String currentUrl = PD.getPage().url();
        boolean hasRefOrRedirect = currentUrl.contains("ref=") || currentUrl.contains("redirect=") || currentUrl.contains("source=");
        Assert.assertTrue(hasRefOrRedirect, "URL parametrelerinde redirect/ref bilgisi bulunamadı: " + currentUrl);
    }

    @When("Ziyaretçi {string} alanında bulunan {string} butonuna tıklarsa")
    public void ziyaretciAlanindaBulunanButonunaTiklarsa(String location, String buttonName) {
        rm.myClick(solutionsPage.getCTAByLocation(location, buttonName));
    }

    @Given("{string} alanındaki slider varsayılan %50 konumundadır")
    public void alanindakiSliderVarsayilanKonumundadir(String sliderArea) {
        Locator handle = solutionsPage.getSliderHandle(sliderArea);
        double value = solutionsPage.getSliderValue(handle);
        Assert.assertEquals(value, 50.0, 5.0, "Slider varsayılan konumu %50 değil!");
    }

    @When("Ziyaretçi slider tutamağını sağa doğru sürüklerse")
    public void ziyaretciSliderTutamaginiSagaDogruSuruklerse() {
        Locator handle = solutionsPage.getSliderHandle("");
        solutionsPage.dragSliderToPercentage(handle, 80.0);
    }

    @Then("Sol taraftaki {string} alanı genişlemelidir")
    public void solTaraftakiAlaniGenislemlidir(String beforeLabel) {
        Locator beforeImage = PD.getPage().locator(".before-image, div[class*='before']").first();
        Assert.assertTrue(beforeImage.isVisible(), "Önce alanı görünür değil!");
    }

    @Then("Sağ taraftaki {string} alanı küçülmelidir")
    public void sagTaraftakiAlaniKuculmelidir(String afterLabel) {
        Locator afterImage = PD.getPage().locator(".after-image, div[class*='after']").first();
        Assert.assertTrue(afterImage.isVisible(), "Sonra alanı mevcut değil!");
    }

    @Then("Görsel kayması, katman kırılması veya UI donması yaşanmamalıdır")
    public void gorselKaymasiKatmanKirilmasiVeyaUIDonmasiYasanmamalidir() {
        Object isOverflowing = PD.getPage().evaluate("() => document.body.scrollWidth > window.innerWidth");
        Assert.assertFalse((Boolean) isOverflowing, "Sayfada yatay taşma/katman kırılması tespit edildi!");
    }

    @Given("SSS alanındaki tüm sorular kapalı durumdadır")
    public void sssAlanindakiTumSorularKapaliDurumdadir() {
        Locator answers = PD.getPage().locator(".faq-answer, details p");
        for (int i = 0; i < answers.count(); i++) {
            Assert.assertFalse(answers.nth(i).isVisible(), "SSS sorusu başlangıçta kapalı olmalıydı!");
        }
    }

    @When("Ziyaretçi {string} başlığına tıklarsa")
    public void ziyaretciBasliginaTiklarsa(String questionText) {
        rm.myClick(solutionsPage.getFAQQuestion(questionText));
    }

    @Then("{string}e ait cevap alanı dinamik olarak genişlemelidir \\(expand)")
    public void eAitCevapAlaniDinamikOlarakGenislemelidirExpand(String questionText) {
        Locator answer = solutionsPage.getFAQAnswer(questionText);
        PD.getPage().waitForCondition(answer::isVisible);
        Assert.assertTrue(answer.isVisible(), "SSS cevap alanı açılmadı!");
    }

    @When("Ziyaretçi {string} başlığına tekrar tıklarsa")
    public void ziyaretciBasliginaTekrarTiklarsa(String questionText) {
        rm.myClick(solutionsPage.getFAQQuestion(questionText));
    }

    @Then("{string}e ait cevap alanı kapanmalıdır \\(collapse)")
    public void eAitCevapAlaniKapanmalidirCollapse(String questionText) {
        Locator answer = solutionsPage.getFAQAnswer(questionText);
        PD.getPage().waitForCondition(() -> !answer.isVisible());
        Assert.assertFalse(answer.isVisible(), "SSS cevap alanı kapanmadı!");
    }

    @Given("Ziyaretçi {string} butonuna tıklayarak {string} sayfasına gitmiştir")
    public void ziyaretciButonunaTiklayarakSayfasinaGitmistir(String buttonName, String targetPage) {
        rm.myClick(solutionsPage.getActionButton(buttonName));
        PD.getPage().waitForURL("**" + targetPage + "**");
    }

    @When("Ziyaretçi tarayıcının {string} butonuna basarsa")
    public void ziyaretciTarayicininButonunaBasarsa(String backButton) {
        PD.getPage().goBack();
    }

    @Then("Ziyaretçi tekrar {string} sayfasına dönmelidir")
    public void ziyaretciTekrarSayfasinaDonmelidir(String expectedPath) {
        Assert.assertTrue(PD.getPage().url().contains(expectedPath), "Geri basıldığında beklenen sayfaya dönülemedi!");
    }

    @Then("Sayfa stili bozulmadan, veri kaybı ve konsol \\(JS) hatası olmadan yeniden yüklenmelidir")
    public void sayfaStiliBozulmadanVeriKaybiVeKonsolHatasiOlmadanYenidenYuklenmelidir() {
        Assert.assertTrue(consoleJsErrors.isEmpty(), "JS Konsol hatası tespit edildi: " + consoleJsErrors);
    }

    @Given("Sayfada {string} \\(Slider A) ve {string} \\(Slider B) alanları bulunmaktadır")
    public void sayfadaSliderAVeSliderBAlanlariBulunmaktadir(String sliderA, String sliderB) {
        Assert.assertTrue(solutionsPage.getSliderHandle(sliderA).isVisible(), "Slider A bulunamadı!");
        Assert.assertTrue(solutionsPage.getSliderHandle(sliderB).isVisible(), "Slider B bulunamadı!");
    }

    @When("Ziyaretçi Slider A'yı %20 konumuna sürüklerse")
    public void ziyaretciSliderAYiPercent20KonumunaSuruklerse() {
        Locator sliderA = solutionsPage.getSliderHandle("Boş Mutfak");
        solutionsPage.dragSliderToPercentage(sliderA, 20.0);
    }

    @Then("Slider A'nın konumu %20 olmalıdır")
    public void sliderANinKonumuPercent20Olmalidir() {
        Locator sliderA = solutionsPage.getSliderHandle("Boş Mutfak");
        double val = solutionsPage.getSliderValue(sliderA);
        Assert.assertEquals(val, 20.0, 5.0, "Slider A %20 konumunda değil!");
    }

    @Then("Slider B'nin konumu değişmeyerek varsayılan \\(%50) konumunda kalmalıdır")
    public void sliderBNinKonumuDegismeyerekVarsayilanKonumundaKalmalidir() {
        Locator sliderB = solutionsPage.getSliderHandle("Mobilyalı Oturma Odası");
        double val = solutionsPage.getSliderValue(sliderB);
        Assert.assertEquals(val, 50.0, 5.0, "Slider B konumu etkilendi ve değişti!");
    }

    @Then("Her iki slider bileşeninde de görsel taşması \\(overflow) yaşanmamalıdır")
    public void herIkiSliderBilesenindeDeGorselTasmasiYasanmamalidir() {
        Object overflow = PD.getPage().evaluate("() => Array.from(document.querySelectorAll('img')).some(i => i.scrollWidth > i.clientWidth)");
        Assert.assertFalse((Boolean) overflow, "Görsel taşması tespit edildi!");
    }

    @When("Ziyaretçi slider tutamağını tam olarak {string} noktalara sürüklerse")
    public void ziyaretciSliderTutamaginiTamOlarakNoktalaraSuruklerse(String direction) {
        Locator slider = solutionsPage.getSliderHandle("");
        if (direction.equalsIgnoreCase("En Sola")) {
            solutionsPage.dragSliderToPercentage(slider, 0.0);
        } else {
            solutionsPage.dragSliderToPercentage(slider, 100.0);
        }
    }

    @Then("Slider konumu %{int} olmalıdır")
    public void sliderKonumuPercentOlmalidir(int expectedPercentage) {
        Locator slider = solutionsPage.getSliderHandle("");
        double val = solutionsPage.getSliderValue(slider);
        Assert.assertEquals(val, (double) expectedPercentage, 2.0, "Slider sınır değer konumu eşleşmedi!");
    }

    @Then("Karşıt taraftaki görsel tamamen gizlenmeli, DOM\\/CSS katman hatası oluşmamalıdır")
    public void karsitTaraftakiGorselTamamenGizlenmeliDOMCSSKatmanHatasiOlusmamalidir() {
        Object hasError = PD.getPage().evaluate("() => document.querySelector('.slider-container') === null");
        Assert.assertFalse((Boolean) hasError, "DOM katman hatası oluştu!");
    }

    @When("Ziyaretçi bir SSS sorusuna 1 saniye içinde 5 kez art arda tıklarsa")
    public void ziyaretciBirSSSSorusuna1SaniyeIcinde5KezArtArdaTiklarsa() {
        Locator faq = solutionsPage.getFAQQuestion("Soru 1");
        for (int i = 0; i < 5; i++) {
            faq.click();
        }
    }

    @Then("Akordeon animasyonu takılı kalmamalıdır")
    public void akordeonAnimasyonuTakiliKalmamalidir() {
        PD.getPage().waitForTimeout(1000);
        Locator answer = solutionsPage.getFAQAnswer("Soru 1");
        boolean isAnimating = (Boolean) answer.evaluate("el => el.classList.contains('animating') || el.style.transitionDuration !== ''");
        Assert.assertFalse(isAnimating, "Akordeon animasyonu takılı kaldı!");
    }

    @Then("Son tıklama durumuna göre cevap alanı doğru \\(Açık veya Kapalı) konumda stabilize olmalıdır")
    public void sonTiklamaDurumunaGoreCevapAlaniDogruKonumdaStabilizeOlmalidir() {
        Locator answer = solutionsPage.getFAQAnswer("Soru 1");
        Assert.assertTrue(answer.isVisible(), "5 hızlı tıklama sonrası cevap alanı stabilize açılmadı!");
    }

    @Given("Ziyaretçi tarayıcı adres çubuğuna doğrudan {string} yazar")
    public void ziyaretciTarayiciAdresCubugunaDogrudanYazar(String directUrl) {
        String resolvedUrl = rm.resolveDynamicValue(directUrl);
        PD.getPage().navigate(resolvedUrl);
    }

    @When("Sayfa yüklenirse")
    public void sayfaYuklenirse() {
        PD.getPage().waitForLoadState();
    }

    @Then("Sayfadaki {string}, {string} ve mor banner {string} butonları aktif olmalıdır")
    public void sayfadakiVeMorBannerButonlariAktifOlmalidir(String btn1, String btn2, String btn3) {
        Assert.assertTrue(solutionsPage.getActionButton(btn1).isEnabled(), btn1 + " butonu aktif değil!");
        Assert.assertTrue(solutionsPage.getActionButton(btn2).isEnabled(), btn2 + " butonu aktif değil!");
        Assert.assertTrue(solutionsPage.getActionButton(btn3).isEnabled(), btn3 + " butonu aktif değil!");
    }

    @Then("Bu butonlara tıklandığında BR-02 uyarınca {string} yönlendirmesi sorunsuz çalışmalıdır")
    public void buButonlaraTiklandigindaBRUyarincaYonlendirmesiSorunsuzCalismalidir(String expectedRedirect) {
        rm.myClick(solutionsPage.getActionButton("Ücretsiz Denemeyi Başlat"));
        PD.getPage().waitForURL("**" + expectedRedirect + "**");
        Assert.assertTrue(PD.getPage().url().contains(expectedRedirect), "Deep link CTA yönlendirmesi başarısız!");
    }

    @Given("Ziyaretçi {string} konumundadır")
    public void ziyaretciKonumundadir(String startLocation) {
        String resolved = rm.resolveDynamicValue(startLocation);
        PD.getPage().navigate(resolved);
    }

    @When("Ziyaretçi {string} eylemini gerçekleştirdiğinde")
    public void ziyaretciEyleminiGerceklestirdiginde(String action) {
        if (action.contains("Ücretsiz Denemeyi Başlat")) {
            rm.myClick(solutionsPage.getHeroCTA("Ücretsiz Denemeyi Başlat"));
        }
    }

    @Then("Sistem {string} yanıtını vermelidir")
    public void sistemYanitiniVermelidir(String expectedResponse) {
        if (expectedResponse.contains("404")) {
            rm.veriyfyContainsText(PD.getPage().locator("body"), "404");
        } else {
            Assert.assertTrue(PD.getPage().url().contains("/tr/login"), "Korumalı dashboard erişim engeli çalışmadı!");
        }
    }

    @Then("Kullanıcı {string} adresine yönlendirilmiş veya yönlendirme seçeneği sunulmuş olmalıdır")
    public void kullaniciAdresineYonlendirilmisVeyaYonlendirmeSecenegiSunulmusOlmalidir(String targetUrl) {
        Assert.assertTrue(PD.getPage().url().contains(targetUrl) || PD.getPage().locator("a[href*='" + targetUrl + "']").isVisible(),
                "Kullanıcı beklenen adrese yönlendirilmedi!");
    }

    @When("Ziyaretçi sayfadaki tüm slider, akordeon ve CTA butonları ile etkileşime girerse")
    public void ziyaretciSayfadakiTumSliderAkordeonVeCTAButonlariIleEtkilesimeGirerse() {
        consoleJsErrors.clear();
        PD.getPage().onConsoleMessage((ConsoleMessage msg) -> {
            if ("error".equalsIgnoreCase(msg.type())) {
                consoleJsErrors.add(msg.text());
            }
        });

        if (solutionsPage.getSliderHandle("").isVisible()) {
            solutionsPage.dragSliderToPercentage(solutionsPage.getSliderHandle(""), 70.0);
        }
        if (solutionsPage.getFAQQuestion("Soru 1").isVisible()) {
            rm.myClick(solutionsPage.getFAQQuestion("Soru 1"));
        }
    }

    @Then("Tarayıcı geliştirici konsolunda hiçbir Uncaught TypeError veya Kritik JS hatası oluşmamalıdır")
    public void tarayiciGelistiriciKonsolundaHicbirUncaughtTypeErrorVeyaKritikJSHatasiOlusmamalidir() {
        List<String> criticalErrors = consoleJsErrors.stream()
                .filter(err -> err.contains("TypeError") || err.contains("Uncaught"))
                .toList();
        Assert.assertTrue(criticalErrors.isEmpty(), "Kritik JS hataları bulundu: " + criticalErrors);
    }

    @Given("Ziyaretçi mobil cihaz ekran genişliğinde \\(Viewport: 375px) {string} sayfasındadır")
    public void ziyaretciMobilCihazEkranGenisligindeViewport375pxSayfasindadir(String pagePath) {
        PD.getPage().setViewportSize(375, 812);
        PD.getPage().navigate("https://example.com" + rm.resolveDynamicValue(pagePath));
    }

    @When("Ziyaretçi parmağını slider üzerinde yatay olarak sürüklerse")
    public void ziyaretciParmaginiSliderUzerindeYatayOlarakSuruklerse() {
        Locator slider = solutionsPage.getSliderHandle("");
        solutionsPage.dragSliderToPercentage(slider, 30.0);
    }

    @Then("Yalnızca Görsel Slider hareket etmelidir")
    public void yalnizcaGorselSliderHareketEtmelidir() {
        Locator slider = solutionsPage.getSliderHandle("");
        double val = solutionsPage.getSliderValue(slider);
        Assert.assertEquals(val, 30.0, 5.0, "Mobil görünümde slider hareket etmedi!");
    }

    @Then("Dikey sayfa kaydırma \\(Vertical Scroll) tetiklenerek slider sürükleme işlemi kesintiye uğramamalıdır")
    public void dikeySayfaKaydirmaVerticalScrollTetiklenerekSliderSuruklemeIslemiKesintiyeUgramamalidir() {
        Object scrollY = PD.getPage().evaluate("() => window.scrollY");
        Assert.assertEquals(((Number) scrollY).intValue(), 0, "Dikey scroll tetiklendi ve slider sürüklemesi kesintiye uğradı!");
    }
}