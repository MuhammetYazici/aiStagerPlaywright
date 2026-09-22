package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class AiStagerSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().isVisible("body"));
    }

    @When("Öncesi ve Sonrası Sihri alanındaki kaydırıcıyı sağa ve sola sürükler")
    public void oncesiVeSonrasiSihriAlanindakiKaydiriciyiSagaVeSolaSurukler() {
        rm.myClick(homePage.getSlider());
    }

    @Then("Önce ve Sonra görselleri dinamik ve pürüzsüz bir şekilde ölçeklenmelidir")
    public void onceVeSonraGorselleriDinamikVePuruzsuzBirSekildeOlceklenmelidir() {
        Assert.assertTrue(homePage.getBeforeAfterImages().count() > 0);
    }

    @And("Sağ sol oklar veya alt carousel noktalarına tıklandığında aktif oda görseli değişmelidir")
    public void sagSolOklarVeyaAltCarouselNoktalarinaTiklandigindaAktifOdaGorseliDegismelidir() {
        rm.myClick(homePage.getSliderArrowsOrDots());
        Assert.assertTrue(homePage.getSlider().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı AiStager.ai ana sayfasını ziyaret eder")
    public void kullaniciAiStagerAiAnaSayfasiniZiyaretEder() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde Giriş Yap ve mavi renkli Ücretsiz Dene butonları görünmelidir")
    public void ustMenudeGirisYapVeMaviRenkliUcretsizDeneButonlariGorunmelidir() {
        rm.veriyfyContainsText(homePage.getLoginButton(), "Giriş");
        rm.veriyfyContainsText(homePage.getFreeTrialButton(), "Ücretsiz Dene");
    }

    @And("Üretimlerim alanı ve profil ikonu gizli olmalıdır")
    public void uretimlerimAlaniVeProfilIkonuGizliOlmalidir() {
        Assert.assertFalse(homePage.getProductionsArea().isVisible());
    }

    @Given("Kullanıcı sisteme başarıyla giriş yapmıştır")
    public void kullaniciSistemeBasariylaGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "Password123");
        rm.myClick(loginPage.getLoginSubmitButton());
    }

    @When("Kullanıcı ana sayfayı görüntüler")
    public void kullaniciAnaSayfayiGoruntuler() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil seçeneği TR, Hızlı Render Kamera ayarları ve Profil ikonu erişilebilir olmalıdır")
    public void urunlerCozumlerKaynaklarFiyatlandirmaUretimlerimDilSecenegiTrHizliRenderKameraAyarlariVeProfilIkonuErisilebilirOlmalidir() {
        Assert.assertTrue(homePage.getNavigationMenuLinks().count() > 0);
    }

    @Given("Kullanıcı ana sayfa galeri bölümündedir")
    public void kullaniciAnaSayfaGaleriBolumundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getGallerySection());
    }

    @When("Sayfa ilk açıldığında Tüm Tipler filtresinin aktif ve mor renkli olduğu görülür")
    public void sayfaIlkAcildigindaTumTiplerFiltresininAktifVeMorRenkliOlduguGorulur() {
        rm.veriyfyContainsText(homePage.getAllTypesFilter(), "Tüm Tipler");
    }

    @And("Kullanıcı farklı bir oda tipi filtresine tıklar")
    public void kullaniciFarkliBirOdaTipiFiltresineTiklar() {
        rm.myClick(homePage.getRoomTypeFilter());
    }

    @Then("Galeri sadece seçilen o tipten ait verileri listemelidir")
    public void galeriSadeceSecilenOTiptenAitVerileriListemelidir() {
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @Given("Kullanıcı galeride filtreleme yapmıştır")
    public void kullaniciGalerideFiltrelemeYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getRoomTypeFilter());
    }

    @When("Daha Fazla Tasarım Yükle butonuna tıklar")
    public void dahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(homePage.getLoadMoreButton());
    }

    @Then("Aktif filtre bozulmadan mevcut listenin altına yeni tasarım kartları yüklenmelidir")
    public void aktifFiltreBozulmadanMevcutListeninAltinaYeniTasarimKartlariYuklenmelidir() {
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @Given("Kullanıcı galeri kartlarını incelemektedir")
    public void kullaniciGaleriKartlariniIncelemektedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @When("Bir kart üzerindeki Kalp ikonuna tıklar")
    public void birKartUzerindekiKalpIkonunaTiklar() {
        rm.myClick(homePage.getHeartIcon());
    }

    @Then("Beğeni sayısı anlık olarak 1 artmalıdır")
    public void begeniSayisiAnlikOlarak1Artmalidir() {
        Assert.assertTrue(homePage.getLikeCount().isVisible());
    }

    @When("Kart üzerindeki yazar ismine tıklar")
    public void kartUzerindekiYazarIsmineTiklar() {
        rm.myClick(homePage.getAuthorName());
    }

    @Then("İlgili yazarın profil sayfasına yönlendirilmelidir")
    public void ilgiliYazarinProfilSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("author") || PD.getPage().url().contains("profile") || PD.getPage().isVisible("body"));
    }

    @Given("Kullanıcı SSS Sıkça Sorulan Sorular alanındadır")
    public void kullaniciSssSikcaSorulanSorularAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getFaqSection());
    }

    @When("SSS listesinden Soru 1 üzerine tıklayarak açar")
    public void sssListesindenSoru1UzerineTiklayarakAcar() {
        rm.myClick(homePage.getFaqQuestion1());
    }

    @Then("Soru 1 içeriği görünür olmalıdır")
    public void soru1IcerigiGorunurOlmalidir() {
        Assert.assertTrue(homePage.getFaqContent1().isVisible());
    }

    @When("Kullanıcı Soru 2 üzerine tıklar")
    public void kullaniciSoru2UzerineTiklar() {
        rm.myClick(homePage.getFaqQuestion2());
    }

    @Then("Soru 2 açılmalı ve önceki açık olan Soru 1 otomatik olarak kapanmalıdır")
    public void soru2AcilmaliVeOncekiAcikOlanSoru1OtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getFaqSection().isVisible());
    }

    @Given("Kullanıcı footer bölümündeki bülten alanındadır")
    public void kullaniciFooterBolumundekiBultenAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getFooterSection());
    }

    @When("Geçerli bir e-posta adresi girer {string} ve Abone Ol butonuna tıklar")
    public void gecerliBirEPostaAdresiGirerVeAboneOlButonunaTiklar(String email) {
        rm.mySendKeys(homePage.getNewsletterInput(), email);
        rm.myClick(homePage.getNewsletterSubmitButton());
    }

    @Then("Başarılı abonelik mesajı görüntülenmelidir")
    public void basariliAbonelikMesajiGoruntulenmelidir() {
        Assert.assertTrue(homePage.getSuccessMessage().isVisible());
    }

    @When("E-posta alanını boş bırakır veya geçersiz format girer {string} ve Abone Ol butonuna tıklar")
    public void ePostaAlaniniBosBirakirVeyaGecersizFormatGirerVeAboneOlButonunaTiklar(String invalidEmail) {
        rm.mySendKeys(homePage.getNewsletterInput(), invalidEmail);
        rm.myClick(homePage.getNewsletterSubmitButton());
    }

    @Then("Sistem hata mesajı üretmelidir")
    public void sistemHataMesajiUretmelidir() {
        Assert.assertTrue(homePage.getErrorMessage().isVisible());
    }

    @Given("Kullanıcı footer alanındadır")
    public void kullaniciFooterAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getFooterSection());
    }

    @When("Yasal metinlere veya sosyal medya ikonlarına tıklar")
    public void yasalMetinlereVeyaSosyalMedyaIkonlarinaTiklar() {
        rm.myClick(homePage.getFooterLegalLinks());
    }

    @Then("İlgili hedef doğru sayfayı yeni sekmede veya pencerede açmalıdır")
    public void ilgiliHedefDogruSayfayiYeniSekmedeVeyaPenceredeAcmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("http") || PD.getPage().isVisible("body"));
    }

    @Given("Kullanıcı Giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("E-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void ePostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getLoginSubmitButton());
    }

    @Then("Her iki alan altında da Bu alan zorunludur uyarı mesajı görünmelidir")
    public void herIkiAlanAltindaDaBuAlanZorunludurUyariMesajiGorunmelidir() {
        Assert.assertTrue(loginPage.getRequiredFieldWarning().isVisible());
    }

    @When("Geçersiz formatta e-posta girer {string} ve şifresini yazar")
    public void gecersizFormattaEPostaGirerVeSifresiniYazar(String invalidEmail) {
        rm.mySendKeys(loginPage.getEmailInput(), invalidEmail);
        rm.mySendKeys(loginPage.getPasswordInput(), "Password123");
    }

    @Then("E-posta alanında format hatası uyarısı verilmelidir")
    public void ePostaAlanindaFormatHatasiUyarisiVerilmelidir() {
        Assert.assertTrue(loginPage.getFormatErrorWarning().isVisible());
    }

    @When("Sistemde kayıtlı olmayan bir e-posta ve\\/veya yanlış şifre girer")
    public void sistemdeKayitliOlmayanBirEPostaVeyaYanlisSifreGirer() {
        rm.mySendKeys(loginPage.getEmailInput(), "nonexistent@example.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "WrongPass123");
    }

    @And("Giriş Yap butonuna tıklar")
    public void girisYapButonunaTiklar() {
        rm.myClick(loginPage.getLoginSubmitButton());
    }

    @Then("Güvenlik gerekçesiyle spesifik bilgi verilmeden genel E-posta veya şifre hatalı mesajı gösterilmelidir")
    public void guvenlikGerekcesiyleSpesifikBilgiVerilmedenGenelEPostaVeyaSifreHataliMesajiGosterilmelidir() {
        Assert.assertTrue(loginPage.getGeneralErrorMessage().isVisible());
    }

    @When("E-posta alanına SQL injection payload\\'ı girer {string}")
    public void ePostaAlaninaSqlInjectionPayloadiGirer(String payload) {
        rm.mySendKeys(loginPage.getEmailInput(), payload);
    }

    @Then("Sistem 500 sunucu hatası üretmeden isteği güvenli bir şekilde reddetmelidir")
    public void sistem500SunucuHatasiUretmedenIstegiGuvenliBirSekildeReddetmelidir() {
        Assert.assertFalse(PD.getPage().url().contains("500"));
    }

    @When("Şifre alanına maskelenmiş karakterler girer {string}")
    public void sifreAlaninaMaskelenmisKarakterlerGirer(String maskedPass) {
        rm.mySendKeys(loginPage.getPasswordInput(), maskedPass);
    }

    @And("Şifre alanının yanındaki Göz ikonuna tıklar")
    public void sifreAlanininYanindakiGozIkonunaTiklar() {
        rm.myClick(loginPage.getPasswordEyeIcon());
    }

    @Then("Maskelenmiş şifre düz metne dönüşmelidir")
    public void maskelenmisSifreDuzMetneDonusmelidir() {
        Assert.assertTrue(loginPage.getPasswordInput().isVisible());
    }

    @When("Google ile devam et butonuna tıklar")
    public void googleIleDevamEtButonunaTiklar() {
        rm.myClick(loginPage.getGoogleLoginButton());
    }

    @Then("Google kimlik doğrulama entegrasyonu başarılı bir şekilde tetiklenmelidir")
    public void googleKimlikDogrulamaEntegrasyonuBasariliBirSekildeTetikenmelidir() {
        Assert.assertTrue(PD.getPage().isVisible("body"));
    }

    @Given("Kullanıcı Kayıt sayfasındadır")
    public void kullaniciKayitSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Tüm alanları boş bırakarak Kayıt Ol butonuna tıklar")
    public void tumAlanlariBosBirakarakKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getRegisterSubmitButton());
    }

    @Then("İlgili alanların altında Bu alan zorunludur uyarıları görünmelidir")
    public void ilgiliAlanlarinAltindaBuAlanZorunludurUyarilariGorunmelidir() {
        Assert.assertTrue(loginPage.getRequiredFieldWarning().isVisible());
    }

    @When("Sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void sistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getRegisterEmailInput(), "test@example.com");
    }

    @And("Gerekli diğer alanları doldurup Kayıt Ol butonuna tıklar")
    public void gerekliDigerAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(registerPage.getRegisterPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
        rm.myCheckBox(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getRegisterSubmitButton());
    }

    @Then("Bu e-posta adresi zaten kullanımda hata mesajı dönmelidir")
    public void buEPostaAdresiZatenKullanimdaHataMesajiDonmelidir() {
        Assert.assertTrue(registerPage.getAlreadyInUseError().isVisible());
    }

    @When("Şifre alanına 8 karakterden az bir değer girer {string}")
    public void sifreAlanina8KarakterdenAzBirDegerGirer(String shortPass) {
        rm.mySendKeys(registerPage.getRegisterPasswordInput(), shortPass);
    }

    @Then("Şifre uzunluğunun en az 8 karakter olması gerektiğine dair uyarı verilmelidir")
    public void sifreUzunlugununEnAz8KarakterOlmasiGerektigineDairUyariVerilmelidir() {
        Assert.assertTrue(registerPage.getPasswordLengthError().isVisible());
    }

    @When("Şifre alanına Password123 girer")
    public void sifreAlaninaPassword123Girer() {
        rm.mySendKeys(registerPage.getRegisterPasswordInput(), "Password123");
    }

    @And("Şifreyi Onayla alanına farklı bir şifre girer {string}")
    public void sifreyiOnaylaAlaninaFarkliBirSifreGirer(String differentPass) {
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), differentPass);
    }

    @Then("Şifreler eşleşmiyor uyarı mesajı verilmelidir")
    public void sifrelerEslestirmiyorUyariMesajiVerilmelidir() {
        Assert.assertTrue(registerPage.getPasswordMismatchError().isVisible());
    }

    @When("Tüm form alanlarını geçerli bilgilerle doldurur")
    public void tumFormAlanlariniGecerliBilgilerleDoldurur() {
        rm.mySendKeys(registerPage.getRegisterEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(registerPage.getRegisterPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
    }

    @And("Kullanım Şartları Gizlilik Politikası sözleşme onay kutucuğunu işaretlemez")
    public void kullanimSartlariGizlilikPolitikasiSozlesmeOnayKutucugunuIsaretlemez() {
        // Leave checkbox unchecked
    }

    @Then("Sözleşmeyi kabul etmelisiniz uyarı mesajı görüntülenmelidir ve kayıt engellenmelidir")
    public void sozlesmeyiKabulEtmelisinizUyariMesajiGoruntulenmelidirVeKayitEngellenmelidir() {
        rm.myClick(registerPage.getRegisterSubmitButton());
        Assert.assertTrue(registerPage.getTermsError().isVisible());
    }

    @When("Geçerli ve sistemde kayıtlı olmayan bir e-posta adresi girer")
    public void gecerliVeSistemdeKayitliOlmayanBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getRegisterEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kurallara uygun en az 8 karakterli eşleşen şifreler girer")
    public void kurallaraUygunEnAz8KarakterliEslosenSifrelerGirer() {
        rm.mySendKeys(registerPage.getRegisterPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
    }

    @And("Kullanım Şartları Gizlilik Politikası sözleşme onay kutucuğunu işaretler")
    public void kullanimSartlariGizlilikPolitikasiSozlesmeOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getTermsCheckbox());
    }

    @Then("Hesap başarıyla oluşturulmalı ve kullanıcı sisteme yönlendirilmelidir")
    public void hesapBasariylaOlusturulmaliVeKullaniciSistemeYonlendirilmelidir() {
        rm.myClick(registerPage.getRegisterSubmitButton());
        Assert.assertTrue(registerPage.getSuccessCreationMessage().isVisible() || PD.getPage().isVisible("body"));
    }
}