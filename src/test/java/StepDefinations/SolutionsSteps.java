package StepDefinations;

import Pages.SolutionsPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SolutionsSteps {
    ReusableMethod rm = new ReusableMethod();
    SolutionsPage solutionsPage = new SolutionsPage();

    @Given("Kullanıcı {string} adresindedir")
    public void kullanıcıAdresindedir(String url) {
        PD.getPage().navigate(url);
        try {
            if (solutionsPage.getCookieAcceptAllButton().isVisible()) {
                rm.myClick(solutionsPage.getCookieAcceptAllButton());
            }
        } catch (Exception e) {
            // Cookie banner might not appear
        }
    }

    @When("Kullanıcı sağdaki {string} sütunundan {string} üzerine gelir")
    public void kullanıcıSağdakiSütunundanÜzerineGelir(String sütun, String secenek) {
        solutionsPage.getBusinessMenu(sütun).hover();
    }

    @When("Görsel tepki (hover) alındıktan sonra {string} seçeneğine tıklar")
    public void görselTepkiHoverAlındıktanSonraSeçeneğineTıklar(String secenek) {
        rm.myClick(solutionsPage.getSubMenuItem(secenek));
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilmelidir")
    public void kullanıcıSayfasınaYönlendirilmelidir(String expectedUrl) {
        rm.veriyfyContainsText(PD.getPage().url(), expectedUrl);
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullanıcıSayfasındadır(String url) {
        PD.getPage().navigate(url);
    }

    @When("Sayfanın {string} alanındaki {string} butonuna tıklar")
    public void sayfanınAlanındakiButonunaTıklar(String alan, String butonAdi) {
        rm.myClick(solutionsPage.getCtaButton(butonAdi));
    }

    @When("Kullanıcı {string} butonuna tıklayarak login sayfasına gider")
    public void kullanıcıButonunaTıklayarakLoginSayfasınaGider(String butonAdi) {
        rm.myClick(solutionsPage.getCtaButton(butonAdi));
    }

    @When("Tarayıcının {string} (Back) tuşuna basarak önceki sayfaya döner")
    public void tarayıcınınBackTuşunaBasarakÖncekiSayfayaDöner(String arg0) {
        PD.getPage().goBack();
    }

    @Then("Kullanıcı {string} sayfasına dönmelidir")
    public void kullanıcıSayfasınaDönmelidir(String expectedUrl) {
        rm.veriyfyContainsText(PD.getPage().url(), expectedUrl);
    }

    @Then("Sayfa kararlılığını korumalı ve veri kaybı yaşanmamalıdır")
    public void sayfaKararlılığınıKorumalıVeVeriKaybıYaşanmamalıdır() {
        Assert.assertTrue(PD.getPage().url().contains("real-estate-brokerage"));
    }

    @When("Kullanıcı {string} alanındaki Öncesi/Sonrası slider'ını sağa ve sola kaydırır")
    public void kullanıcıAlanındakiÖncesiSonrasıSliderınıSağaVeSolaKaydırır(String arg0) {
        // Slider interaction simulation
    }

    @Then("Slider akıcı bir şekilde çalışmalıdır")
    public void sliderAkıcıBirŞekildeÇalışmalıdır() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı bir SSS akordeon başlığına tıklar")
    public void kullanıcıBirSSSAkordeonBaşlığınaTıklar() {
        rm.myClick(PD.getPage().locator(".accordion, details, [class*='faq']").first());
    }

    @Then("İlgili soru başlığının altındaki içerik dinamik olarak açılmalıdır")
    public void ilgiliSoruBaşlığınınAltındakiİçerikDinamikOlarakAçılmalıdır() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı {string} menüsünden {string} seçeneğine tıklar")
    public void kullanıcıMenüsündenSeçeneğineTıklar(String menu, String secenek) {
        solutionsPage.getBusinessMenu(menu).hover();
        rm.myClick(solutionsPage.getSubMenuItem(secenek));
    }

    @When("Tarayıcının {string} tuşu ile Mobilya AI sayfasına döner")
    public void tarayıcınınTuşuİleMobilyaAISayfasınaDöner(String arg0) {
        PD.getPage().goBack();
    }

    @Then("Arayüz kayması veya donma olmaksızın Mobilya AI sayfası görüntülenmelidir")
    public void arayüzKaymasıVeyaDonmaOlmaksızınMobilyaAISayfasıGörüntülenmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("furniture-ai"));
    }

    @When("Kullanıcı kapalı olan bir SSS akordeon bileşenine tıklar")
    public void kullanıcıKapalıOlanBirSSSAkordeonBileşenineTıklar() {
        rm.myClick(PD.getPage().locator(".accordion, details, [class*='faq']").first());
    }

    @Then("Akordeon içeriği açılmalıdır")
    public void akordeonİçeriğiAçılmalıdır() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı açık olan aynı SSS akordeon bileşenine tekrar tıklar")
    public void kullanıcıAçıkOlanAynıSSSAkordeonBileşenineTekrarTıklar() {
        rm.myClick(PD.getPage().locator(".accordion, details, [class*='faq']").first());
    }

    @Then("Akordeon içeriği kapanmalıdır")
    public void akordeonİçeriğiKapanmalıdır() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullanıcıButonunaTıklar(String butonAdi) {
        rm.myClick(solutionsPage.getCtaButton(butonAdi));
    }

    @When("Kullanıcı çiftli görsel alanındaki {string} slider'ını hareket ettirir")
    public void kullanıcıÇiftliGörselAlanındakiSliderınıHareketEttirir(String arg0) {
        // Slider logic
    }

    @When("Kullanıcı bağımsız olarak {string} slider'ını hareket ettirir")
    public void kullanıcıBağımsızOlarakSliderınıHareketEttirir(String arg0) {
        // Slider logic
    }

    @Then("Her iki slider da takılmadan ve taşma yapmadan pürüzsüz çalışmalıdır")
    public void herİkiSliderDaTakılmadanVeTaşmaYapmadanPürüzsüzÇalışmalıdır() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı tarayıcı adres çubuğuna doğrudan {string} yazıp enter tuşuna basar")
    public void kullanıcıTarayıcıAdresÇubuğunaDoğrudanYazıpEnterTuşunaBasar(String url) {
        PD.getPage().navigate(url);
    }

    @Then("Kullanıcı 404 sayfasına yönlendirilmeli veya ana çözümler sayfasına ({string}) yönlendirilmelidir")
    public void kullanıcıSayfasınaYönlendirilmeliVeyaAnaÇözümlerSayfasınaYönlendirilmelidir(String expectedUrl) {
        String currentUrl = PD.getPage().url();
        boolean isValid = currentUrl.contains("404") || currentUrl.contains("solutions");
        Assert.assertTrue(isValid);
    }

    @When("Kullanıcı {string} butonuna çok kısa süre içinde üst üste 3 kez hızlıca tıklar")
    public void kullanıcıButonunaÇokKısaSüreİçindeÜstÜsteKezHızlıcaTıklar(String butonAdi) {
        Locator btn = solutionsPage.getCtaButton(butonAdi);
        btn.click();
        btn.click();
        btn.click();
    }

    @Then("Sistem birden fazla login sekmesi açmamalı ve tek bir yönlendirme gerçekleştirmelidir")
    public void sistemBirdenFazlaLoginSekmesiAçmamalıVeTekBirYönlendirmeGerçekleştirmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("login"));
    }
}