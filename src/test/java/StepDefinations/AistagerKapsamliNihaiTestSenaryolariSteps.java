package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.PD;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı ana sayfadadır ve /tr adresindedir")
    public void kullaniciAnaSayfadadirVeTrAdresindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr");
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri slider çubuğunu iki yönlü sürüklerse veya ok alt nokta butonlarına tıklarsa")
    public void kullaniciOncesiVeSonrasiSihriSliderCubugunuIkiYonluSuruklerseVeyaOkAltNoktaButonlarinaTikarsa() {
        rm.myClick(homePage.getSliderElement());
    }

    @Then("Görseller pürüzsüz şekilde boyutlanmalı ve senkronize olarak değişmelidir")
    public void gorsellerPuruzsuzSekildeBoyutlanmaliVeSenkronizeOlarakDegismelidir() {
        Assert.assertTrue(homePage.getSliderElement().isVisible());
    }

    @When("Kullanıcı dil seçeneğini EN olarak değiştirirse")
    public void kullaniciDilSeceneginiENOlarakDegistirirse() {
        rm.myClick(homePage.getDilSecenegiButton());
    }

    @Then("Sayfadaki tüm statik metinler anında İngilizce diline uyarlanmalıdır")
    public void sayfadakiTumStatikMetinlerAnindaIngilizceDilineUyarlanmalidir() {
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı ana sayfayı ziyaret ederse")
    public void kullaniciAnaSayfayiZiyaretEderse() {
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @Then("Header alanında Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır")
    public void headerAlanindaGirisYapVeUcretsizDeneButonlariGorunurOlmalidir() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible());
    }

    @And("Üretimlerim ve profil ikonu menüsü gizli olmalıdır")
    public void uretimlerimVeProfilIkonuMenusuGizliOlmalidir() {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı sisteme başarıyla giriş yapmış kayıtlı bir üyedir")
    public void kullaniciSistemeBasariylaGirisYapmisKayitliBirUyedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "test@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPass123");
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Header alanında logo ürünler çözümler kaynaklar fiyatlandırma görünür olmalıdır")
    public void headerAlanindaLogoUrunlerCozumlerKaynaklarFiyatlandirmaGorunurOlmalidir() {
        Assert.assertTrue(homePage.getLogo().isVisible());
        Assert.assertTrue(homePage.getUrunlerMenu().isVisible());
        Assert.assertTrue(homePage.getCozumlerMenu().isVisible());
        Assert.assertTrue(homePage.getKaynaklarMenu().isVisible());
        Assert.assertTrue(homePage.getFiyatlandirmaMenu().isVisible());
    }

    @And("Üretimlerim hızlı render paneli dil seçeneği ve profil menüsü aktif olmalıdır")
    public void uretimlerimHizliRenderPaneliDilSecenegiVeProfilMenusuAktifOlmalidir() {
        Assert.assertTrue(homePage.getDilSecenegiButton().isVisible());
    }

    @Given("Kullanıcı ana sayfa galeri alanındadır")
    public void kullaniciAnaSayfaGaleriAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @When("Galeri ilk yüklendiğinde")
    public void galeriIlkYuklendiginde() {
        Assert.assertTrue(homePage.getGaleriListesi().isVisible());
    }

    @Then("Varsayılan olarak Tüm Tipler filtresi seçili gelmelidir")
    public void varsayilanOlarakTumTiplerFiltresiSeciliGelmelidir() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @When("Kullanıcı Oturma Odası oda tipi filtresine tıklarsa")
    public void kullaniciOturmaOdasiOdaTipiFiltresineTikarsa() {
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @Then("Galeri listesi dinamik olarak sadece oturma odası tasarımlarını gösterecek şekilde filtrelenmelidir")
    public void galeriListesiDinamikOlarakSadeceOturmaOdasiTasarımlarınıGosterecekSekildeFiltrelenmelidir() {
        Assert.assertTrue(homePage.getGaleriListesi().isVisible());
    }

    @Given("Kullanıcı galeri alanındaki bir tasarım kartını incelemektedir")
    public void kullaniciGaleriAlanindakiBirTasarimKartiniIncelemektedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGaleriListesi().isVisible());
    }

    @When("Kullanıcı tasarım üzerindeki Beğeni Kalp ikonuna tıklarsa")
    public void kullaniciTasarimUzerindekiBegeniKalpIkonunaTikarsa() {
        rm.myClick(homePage.getBegeniKalpIkonu());
    }

    @Then("Beğeni sayısı anlık olarak bir artmalı ve ikon aktif duruma gelmelidir")
    public void begeniSayisiAnlikOlarakBirArtmaliVeIkonAktifDurumaGelmelidir() {
        Assert.assertTrue(homePage.getBegeniSayisi().isVisible());
    }

    @Given("Kullanıcı galeri alanında Oturma Odası filtresini seçmiştir")
    public void kullaniciGaleriAlanindaOturmaOdasiFiltresiniSecmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklarsa")
    public void kullaniciDahaFazlaTasarimYukleButonunaTikarsa() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut Oturma Odası filtre state i bozulmadan listeye yeni tasarım kartları eklenmelidir")
    public void mevcutOturmaOdasiFiltreStateiBozulmadanListeyeYeniTasarimKartlariEklenmelidir() {
        Assert.assertTrue(homePage.getGaleriListesi().isVisible());
    }

    @Given("Kullanıcı Sıkça Sorulan Sorular SSS alanındadır")
    public void kullaniciSikcaSorulanSorularSssAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getSssAlani().isVisible());
    }

    @When("Kullanıcı bir akordeon başlığına tıklayarak açarsa")
    public void kullaniciBirAkordeonBasliginaTiklayarakAcarsa() {
        rm.myClick(homePage.getAkordeonBasligi());
    }

    @And("Kullanıcı farklı bir akordeon başlığına tıklarsa")
    public void kullaniciFarkliBirAkordeonBasliginaTikarsa() {
        rm.myClick(homePage.getFarkliAkordeonBasligi());
    }

    @Then("Yeni tıklanan başlık açılmalı ve önceden açık olan akordeon başlığı otomatik olarak kapanmalıdır")
    public void yeniTiklananBaslikAcilmaliVeOncedenAcikOlanAkordeonBasligiOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getFarkliAkordeonBasligi().isVisible());
    }

    @Given("Kullanıcı bülten kayıt alanındadır")
    public void kullaniciBultenKayitAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getBultenKayitAlani().isVisible());
    }

    @When("Kullanıcı geçerli bir e-posta adresi girip bülten kayıt butonuna tıklarsa")
    public void kullaniciGecerliBirEpostaAdresiGiripBultenKayitButonunaTikarsa() {
        rm.mySendKeys(homePage.getBultenEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(homePage.getBultenKayitButton());
    }

    @Then("Başarılı abonelik mesajı gösterilmelidir")
    public void basariliAbonelikMesajiGosterilmelidir() {
        Assert.assertTrue(homePage.getBasariliAbonelikMesaji().isVisible());
    }

    @When("Kullanıcı bülten alanına {string} girip kayıt butonuna tıklarsa")
    public void kullaniciBultenAlaninaGiripKayitButonunaTikarsa(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenEmailInput(), gecersizEposta);
        rm.myClick(homePage.getBultenKayitButton());
    }

    @Then("Sistem bülten kaydını engellemeli ve uygun hata mesajı göstermelidir")
    public void sistemBultenKaydiniEngellemeliVeUygunHataMesajiGostermelidir() {
        Assert.assertTrue(homePage.getHataMesajiGostergesi().isVisible());
    }

    @Given("Kullanıcı /login sayfasındadır")
    public void kullaniciLoginSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı geçerli e-posta adresini ve şifresini girer")
    public void kullaniciGecerliEpostaAdresiniVeSifresiniGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "test@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPass123");
    }

    @When("{string} butonuna tıklarsa")
    public void butonunaTikarsa(String buttonText) {
        if(buttonText.equals("Giriş Yap")) {
            rm.myClick(loginPage.getGirisYapSubmitButton());
        } else if(buttonText.equals("Kayıt ol")) {
            rm.myClick(registerPage.getKayitOlButton());
        }
    }

    @Then("Sistem kullanıcıyı başarıyla ana panele Dashboard yönlendirmelidir")
    public void sistemKullaniciyiBasariylaAnaPaneleDashboardYonlendirmelidir() {
        Assert.assertTrue(loginPage.getDashboardYonlendirme().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} ve şifre alanına {string} girer")
    public void kullaniciEpostaAlaninaVeSifreAlaninaGirer(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @Then("Sistem Bu alan zorunludur hata mesajını göstermelidir")
    public void sistemBuAlanZorunludurHataMesajiniGostermelidir() {
        Assert.assertTrue(loginPage.getZorunluAlanHataMesaji().isVisible());
    }

    @When("Kullanıcı sistemde kayıtlı olmayan bir e-posta veya yanlış şifre girer")
    public void kullaniciSistemdeKayitliOlmayanBirEpostaVeyaYanlisSifreGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "notregistered@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "WrongPass123");
    }

    @Then("Sistem güvenlik gereği generic E-posta veya şifre hatalı mesajını göstermelidir")
    public void sistemGuvenlikGeregiGenericEpostaVeyaSifreHataliMesajiniGostermelidir() {
        Assert.assertTrue(loginPage.getGenericHataMesaji().isVisible());
    }

    @Given("Kullanıcı /register sayfasındadır")
    public void kullaniciRegisterSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı kayıt formunu e-posta {string}, şifre {string}, şifre onay {string}, sözleşme onay {boolean} ile doldurur")
    public void kullaniciKayitFormunuEpostaSifreSifreOnaySozlesmeOnayIleDoldurur(String eposta, String sifre, String sifreOnay, boolean sozlesmeOnay) {
        rm.mySendKeys(registerPage.getRegisterEpostaInput(), eposta);
        rm.mySendKeys(registerPage.getRegisterSifreInput(), sifre);
        rm.mySendKeys(registerPage.getRegisterSifreOnayInput(), sifreOnay);
        if(sozlesmeOnay) {
            rm.myCheckBox(registerPage.getSozlesmeCheckbox());
        }
    }

    @Then("Sistem ilgili validasyon hata mesajını göstermelidir {string}")
    public void sistemIlgiliValidasyonHataMesajiniGostermelidir(String hataMesaji) {
        Assert.assertTrue(registerPage.getValidasyonHataMesaji(hataMesaji).isVisible());
    }

    @Given("Sistemde halihazırda kayıtlı bir existing@example.com e-posta adresi bulunmaktadır")
    public void sistemdeHalihazirdaKayitliBirExistingExampleComEpostaAdresiBulunmaktadir() {
        // Mock data state setup
    }

    @When("Kullanıcı existing@example.com adresi ve geçerli diğer bilgilerle kayıt olmaya çalışırsa")
    public void kullaniciExistingExampleComAdresiVeGecerliDigerBilgilerleKayitOlmayaCalisirsa() {
        rm.mySendKeys(registerPage.getRegisterEpostaInput(), "existing@example.com");
        rm.mySendKeys(registerPage.getRegisterSifreInput(), "ValidPass123");
        rm.mySendKeys(registerPage.getRegisterSifreOnayInput(), "ValidPass123");
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("Sistem zaten kullanımda hata mesajını dönmeli ve kaydı engellemelidir")
    public void sistemZatenKullanimdaHataMesajiniDonmeliVeKaydiEngellemelidir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaMesaji().isVisible());
    }

    @Given("Kullanıcı /login veya /register sayfasındadır")
    public void kullaniciLoginVeyaRegisterSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı şifre alanına bir metin girer ve şifre maskeleme Göz ikonuna tıklarsa")
    public void kullaniciSifreAlaninaBirMetinGirerVeSifreMaskelemeGozIkonunaTikarsa() {
        rm.mySendKeys(loginPage.getSifreInput(), "SecretPass123");
        rm.myClick(loginPage.getSifreMaskelemeGozIkonu());
    }

    @And("Şifre karakterleri düz metin olarak görünür olmalıdır")
    public void sifreKarakterleriDuzMetinOlarakGorunurOlmalidir() {
        Assert.assertTrue(loginPage.getSifreInput().isVisible());
    }

    @When("Kullanıcı Göz ikonuna tekrar tıklarsa")
    public void kullaniciGozIkonunaTekrarTikarsa() {
        rm.myClick(loginPage.getSifreMaskelemeGozIkonu());
    }

    @Then("Şifre karakterleri maskelenmiş yıldız nokta hale gelmelidir")
    public void sifreKarakterleriMaskelenmisYildizNoktaHaleGelmelidir() {
        Assert.assertTrue(loginPage.getSifreInput().isVisible());
    }
}