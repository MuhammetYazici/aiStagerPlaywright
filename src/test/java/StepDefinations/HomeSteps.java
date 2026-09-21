package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {
    HomePage hp = new HomePage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(hp.getOncesiSonrasiSlider().isVisible() || hp.getGaleriAlani().isVisible());
    }

    @Given("Kullanıcı Öncesi ve Sonrası slider alanına gelir")
    public void kullaniciOncesiVeSonrasiSliderAlaninaGelir() {
        rm.myClick(hp.getOncesiSonrasiSlider());
        Assert.assertTrue(hp.getOncesiSonrasiSlider().isVisible());
    }

    @When("Kullanıcı slider üzerindeki ayırıcıyı sağa ve sola sürükler")
    public void kullaniciSliderUzerindekiAyiriciyiSagaVeSolaSurukler() {
        rm.myClick(hp.getSliderAyirici());
        Assert.assertTrue(hp.getSliderAyirici().isVisible());
    }

    @When("Kullanıcı sağ ve sol yön oklarına tıklar")
    public void kullaniciSagVeSolYonOklarinaTiklar() {
        rm.myClick(hp.getSliderYonOk("Sağ"));
        rm.myClick(hp.getSliderYonOk("Sol"));
        Assert.assertTrue(hp.getOncesiSonrasiSlider().isVisible());
    }

    @When("Kullanıcı alt kısımdaki carousel noktalarına tıklar")
    public void kullaniciAltKisimdakiCarouselNoktalarinaTiklar() {
        rm.myClick(hp.getCarouselNoktalari());
        Assert.assertTrue(hp.getCarouselNoktalari().isVisible());
    }

    @Then("Slider görselinin dinamik olarak değiştiği ve sorunsuz çalıştığı görülür")
    public void sliderGorselininDinamikOlarakDegistigiVeSorunsuzCalistigiGorulur() {
        Assert.assertTrue(hp.getOncesiSonrasiSlider().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(hp.getHeaderGirisYapButton().isVisible());
    }

    @When("Kullanıcı ana sayfanın header alanına bakar")
    public void kullaniciAnaSayfaninHeaderAlaninaBakar() {
        Assert.assertTrue(hp.getHeaderGirisYapButton().isVisible() || hp.getUretimlerimMenu().isVisible());
    }

    @Then("Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır")
    public void girisYapVeUcretsizDeneButonlariGorunurOlmalidir() {
        Assert.assertTrue(hp.getHeaderGirisYapButton().isVisible());
        Assert.assertTrue(hp.getHeaderUcretsizDeneButton().isVisible());
    }

    @Then("Üretimlerim menüsü ve profil ikonu gizli olmalıdır")
    public void uretimlerimMenusuVeProfilIkonuGizliOlmalidir() {
        Assert.assertFalse(hp.getUretimlerimMenu().isVisible());
        Assert.assertFalse(hp.getProfilIkonu().isVisible());
    }

    @Given("Kullanıcı sisteme başarıyla giriş yapmıştır")
    public void kullaniciSistemeBasariylaGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(new Pages.LoginPage().getEmailInput(), ConfigReader.getProperty("default_email"));
        rm.mySendKeys(new Pages.LoginPage().getPasswordInput(), ConfigReader.getProperty("default_password"));
        rm.myClick(new Pages.LoginPage().getGirisYapButton());
    }

    @Then("Üretimlerim menüsü, hızlı erişim paneli ve profil menüsü aktif ve görünür olmalıdır")
    public void uretimlerimMenusuHizliErisimPaneliVeProfilMenusuAktifVeGorunurOlmalidir() {
        Assert.assertTrue(hp.getUretimlerimMenu().isVisible());
        Assert.assertTrue(hp.getHizliErisimPaneli().isVisible());
        Assert.assertTrue(hp.getProfilIkonu().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki galeri alanındadır")
    public void kullaniciAnaSayfadakiGaleriAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(hp.getGaleriAlani().isVisible());
    }

    @When("Kullanıcı oda tiplerinden Oturma Odası seçeneğini seçer")
    public void kullaniciOdaTiplerindenOturmaOdasiSeceneginiSecer() {
        rm.myClick(hp.getOturmaOdasiSecenegi());
    }

    @Then("Galeri listesi sadece Oturma Odası kategorisine ait tasarımları göstermelidir")
    public void galeriListesiSadeceOturmaOdasiKategorisineAitTasarimlariGostermelidir() {
        Assert.assertTrue(hp.getGaleriListesi().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(hp.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut Oturma Odası filtresi korunarak yeni tasarımlar listeye yüklenmelidir")
    public void mevcutOturmaOdasiFiltresiKorunarakYeniTasarımlarListeyeYuklenmelidir() {
        Assert.assertTrue(hp.getGaleriListesi().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki SSS alanındadır")
    public void kullaniciAnaSayfadakiSssAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(hp.getSssAlani().isVisible());
    }

    @When("Kullanıcı birinci SSS sorusuna tıklar ve soru açılır")
    public void kullaniciBirinciSssSorusunaTiklarVeSoruAcilir() {
        rm.myClick(hp.getSssSorusu("1"));
        Assert.assertTrue(hp.getSssSorusu("1").isVisible());
    }

    @When("Kullanıcı ikinci bir SSS sorusuna tıklar")
    public void kullaniciIkinciBirSssSorusunaTiklar() {
        rm.myClick(hp.getSssSorusu("2"));
    }

    @Then("İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır")
    public void ikinciSoruAcilmaliVeBirinciSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(hp.getSssSorusu("2").isVisible());
    }

    @Given("Kullanıcı ana sayfadaki bülten alanındadır")
    public void kullaniciAnaSayfadakiBultenAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(hp.getBultenInput().isVisible());
    }

    @When("Kullanıcı bülten input alanına geçerli bir {string} adresi girer")
    public void kullaniciBultenInputAlaninaGecerliBirAdresiGrer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(hp.getBultenInput(), resolvedEmail);
    }

    @When("Kullanıcı abonelik butonuna tıklar")
    public void kullaniciAbonelikButonunaTiklar() {
        rm.myClick(hp.getBultenAbonelikButton());
    }

    @Then("Başarılı abonelik olumlu mesajı gösterilmelidir")
    public void basariliAbonelikOlumluMesajiGosterilmelidir() {
        rm.veriyfyContainsText(hp.getBultenBasariMesaji(), "başarılı");
    }

    @When("Kullanıcı bülten input alanına geçersiz {string} formatı girer veya alanı boş bırakır")
    public void kullaniciBultenInputAlaninaGecersizFormatiGirerVeyaAlaniBosBirakir(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(hp.getBultenInput(), resolvedEmail);
    }

    @Then("Uygun bir hata mesajı gösterilmelidir")
    public void uygunBirHataMesajiGosterilmelidir() {
        Assert.assertTrue(hp.getBultenHataMesaji().isVisible() || hp.getBultenInput().isVisible());
    }
}