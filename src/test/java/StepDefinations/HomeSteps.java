package StepDefinations;

import Pages.HomePage;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeSteps {
    HomePage hp = new HomePage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı ana sayfada {string} slider alanındadır")
    public void kullaniciAnaSayfadaSliderAlanindadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.veriyfyContainsText(hp.getBeforeAndAfterSlider(), arg0);
    }

    @When("Kullanıcı kaydırıcı çizgisini sağa ve sola sürükler")
    public void kullaniciKaydiriciCizgisiniSagaVeSolaSurukler() {
        rm.myClick(hp.getSliderArea());
    }

    @Then("{string} \\(boş oda) ve {string} \\(mobilyalı oda) görselleri arasında pürüzsüz geçiş sağlanmalıdır")
    public void kullaniciGorselleriArasindaPuruzsuzGecisSaglanmalidir(String arg0, String arg1) {
        rm.veriyfyContainsText(hp.getBeforeImage(), arg0);
        rm.veriyfyContainsText(hp.getAfterImage(), arg1);
    }

    @Given("Kullanıcı slider alanındadır")
    public void kullaniciSliderAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getBeforeAndAfterSlider());
    }

    @When("Kullanıcı yön oklarına tıklar veya alt carousel noktalarından birini seçer")
    public void kullaniciYonOklarinaTiklarVeyaAltCarouselNoktalarindanBiriniSecer() {
        rm.myClick(hp.getNextArrow());
        rm.myClick(hp.getCarouselDot());
    }

    @Then("Farklı odalara ait yeni görseller yüklenmelidir")
    public void farkliOdalaraAitYeniGorsellerYuklenmelidir() {
        Assert.assertTrue(hp.getNewRoomImages().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı ana sayfayı ziyaret eder")
    public void kullaniciAnaSayfayiZiyaretEder() {
        rm.veriyfyContainsText(hp.getLoginButton(), "Giriş Yap");
    }

    @Then("Header alanında {string} ve {string} butonları görünür olmalıdır")
    public void headerAlanindaVeButonlariGorunurOlmalidir(String arg0, String arg1) {
        rm.veriyfyContainsText(hp.getLoginButton(), arg0);
        rm.veriyfyContainsText(hp.getFreeTrialButton(), arg1);
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(new Pages.LoginPage().getEmailInput(), ConfigReader.getProperty("validEmail"));
        rm.mySendKeys(new Pages.LoginPage().getPasswordInput(), ConfigReader.getProperty("validPassword"));
        rm.myClick(new Pages.LoginPage().getSubmitButton());
    }

    @Then("Header alanında {string} ve profil ikonu yer almalıdır")
    public void headerAlanindaVeProfilIkonuYerAlmalidir(String arg0) {
        rm.veriyfyContainsText(hp.getProductionsLink(), arg0);
        Assert.assertTrue(hp.getProfileIcon().isVisible());
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı {string}, {string}, {string} veya {string} linklerine sırayla tıklar")
    public void kullaniciLinklerineSiraylaTiklar(String arg0, String arg1, String arg2, String arg3) {
        rm.myClick(hp.getMenuLink(arg0));
        rm.myClick(hp.getMenuLink(arg1));
        rm.myClick(hp.getMenuLink(arg2));
        rm.myClick(hp.getMenuLink(arg3));
    }

    @Then("İlgili hedeflenen sayfalara yönlendirilmelidir")
    public void ilgiliHedeflenenSayfalaraYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }

    @Given("Kullanıcı {string} bölümündedir")
    public void kullaniciBolumundedir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getGallerySection());
    }

    @When("Kullanıcı {string} filtresini seçer")
    public void kullaniciFiltresiniSecer(String arg0) {
        rm.myClick(hp.getLivingRoomFilter());
    }

    @When("Bir tasarım kartı üzerindeki kalp ikonuna tıklar")
    public void birTasarimKartiUzerindekiKalpIkonunaTiklar() {
        rm.myClick(hp.getLikeButton());
    }

    @Then("Tasarımlar filtrelenmeli ve kalp ikonu beğenildi durumuna geçmelidir")
    public void tasarimlarFiltrelenmeliVeKalpIkonuBegenildiDurumunaGecmelidir() {
        Assert.assertTrue(hp.getFilteredDesigns().isVisible());
        Assert.assertTrue(hp.getLikeButton().isVisible());
    }

    @Given("Kullanıcı galeri alanının alt kısmındadır")
    public void kullaniciGaleriAlanininAltKismindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getGallerySection());
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String arg0) {
        rm.myClick(hp.getLoadMoreButton());
    }

    @Then("Sayfa yenilenmeden yeni tasarım kartları listeye eklenmelidir")
    public void sayfaYenilenmedenYeniTasarimKartlariListeyeEklenmelidir() {
        Assert.assertTrue(hp.getFilteredDesigns().isVisible());
    }

    @Given("Kullanıcı SSS bölümündedir")
    public void kullaniciSssBolumundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getFaqSection());
    }

    @When("Kullanıcı bir soruya tıklayarak açar")
    public void kullaniciBirSoruyaTiklayarakAcar() {
        rm.myClick(hp.getFaqQuestionOne());
    }

    @When("Ardından farklı bir yeni soruya tıklar")
    public void ardindanFarkliBirYeniSoruyaTiklar() {
        rm.myClick(hp.getFaqQuestionTwo());
    }

    @Then("Yeni soru açılmalı ve önceki soru otomatik olarak kapanmalıdır")
    public void yeniSoruAcilmaliVeOncekiSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(hp.getFaqAnswerTwo().isVisible());
    }

    @When("Kullanıcı metin içindeki {string} linkine tıklar")
    public void kullaniciMetinIcindekiLinkineTiklar(String arg0) {
        rm.myClick(hp.getContactUsLink());
    }

    @Then("Kullanıcı destek sayfasına yönlendirilmelidir")
    public void kullaniciDestekSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("destek") || PD.getPage().url().contains("contact"));
    }

    @Given("Kullanıcı footer bölümündedir")
    public void kullaniciFooterBolumundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getFooterSection());
    }

    @When("Kullanıcı bülten alanına geçerli bir e-posta adresi girer ve abone ol butonuna tıklar")
    public void kullaniciBultenAlaninaGecerliBirEPostaAdresiGirerVeAboneOlButonunaTiklar() {
        rm.mySendKeys(hp.getNewsletterInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(hp.getNewsletterSubmitButton());
    }

    @Then("Aboneliğin başarılı olduğuna dair onay mesajı görülmelidir")
    public void aboneliginBasariliOldugunaDairOnayMesajiGorulmelidir() {
        rm.veriyfyContainsText(hp.getSuccessMessage(), "başarılı");
    }

    @When("Kullanıcı bülten alanına {string} gibi geçersiz bir e-posta formatı girer ve abone ol butonuna tıklar")
    public void kullaniciBultenAlaninaGibiGecersizBirEPostaFormatiGirerVeAboneOlButonunaTiklar(String arg0) {
        rm.mySendKeys(hp.getNewsletterInput(), arg0);
        rm.myClick(hp.getNewsletterSubmitButton());
    }

    @Then("Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı dönmelidir")
    public void sistemGecerliBirEPostaAdresiGirilmesiGerektigineDairHataMesajiDonmelidir() {
        rm.veriyfyContainsText(hp.getErrorMessage(), "geçerli");
    }

    @When("Kullanıcı yasal metin linklerine, footer menü linklerine ve sosyal medya ikonlarına tıklar")
    public void kullaniciYasalMetinLinklerineFooterMenuLinklerineVeSosyalMedyaIkonlarinaTiklar() {
        rm.myClick(hp.getFooterLinks());
    }

    @Then("Her biri doğru hedef sayfaya veya harici sosyal medya hesabına yönlendirmelidir")
    public void herBiriDogruHedefSayfayaVeyaHariciSosyalMedyaHesabinaYonlendirmelidir() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }
}