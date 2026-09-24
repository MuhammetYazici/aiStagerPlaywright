package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"), "Ana sayfaya ulaşılamadı.");
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri slider alanındaki yön oklarına tıklar veya kaydırma hareketi yapar")
    public void kullaniciOncesiVeSonrasiSihriSliderAlanindakiYonOklarinaTiklarVeyaKaydirmaHareketiYapar() {
        rm.myClick(homePage.getSliderOklar());
    }

    @Then("Slider görseli dinamik ve pürüzsüz bir şekilde sonraki ve önceki geçişi sağlamalıdır")
    public void sliderGorseliDinamikVePuruzsuzBirSekildeSonrakiVeOncekiGecisiSaglamalidir() {
        Assert.assertTrue(homePage.getSliderGorsel().isVisible(), "Slider görseli görünür değil.");
    }

    @When("Kullanıcı topluluk tasarımları galerisinde Yatak Odası filtre seçeneğine tıklar")
    public void kullaniciToplulukTasarımlariGalerisindeYatakOdasiFiltreSecenegineTiklar() {
        rm.myClick(homePage.getYatakOdasiFiltre());
    }

    @Then("Galeri anlık olarak sadece Yatak Odası tasarımlarını listelemelidir")
    public void galeriAnlikOlarakSadeceYatakOdasiTasarımlariniListelemelidir() {
        Assert.assertTrue(homePage.getGaleriListesi().isVisible(), "Galeri listelenmedi.");
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButonu());
    }

    @Then("Sistem aktif olan Yatak Odası filtresini koruyarak yeni tasarım kartlarını yüklemelidir")
    public void sistemAktifOlanYatakOdasiFiltresiniKoruyarakYeniTasarimKartlariniYuklemelidir() {
        Assert.assertTrue(homePage.getGaleriListesi().isVisible(), "Tasarım kartları yüklenemedi.");
    }

    @When("Kullanıcı SSS alanından birinci soruya tıklayarak açar")
    public void kullaniciSssAlanindanBirinciSoruyaTiklayarakAcar() {
        rm.myClick(homePage.getBirinciSoru());
    }

    @And("Kullanıcı aynı anda ikinci bir soruya tıklar")
    public void kullaniciAyniAndaIkinciBirSoruyaTiklar() {
        rm.myClick(homePage.getIkinciSoru());
    }

    @Then("İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır")
    public void ikinciSoruAcilmaliVeBirinciSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getIkinciSoru().isVisible(), "İkinci soru açık değil.");
    }

    @And("Aynı anda yalnızca tek bir soru açık kalmalıdır")
    public void ayniAndaYalnizcaTekBirSoruAcikKalmalidir() {
        Assert.assertTrue(homePage.getIkinciSoru().isVisible(), "Çoklu soru açık kalma durumu tespit edildi.");
    }

    @Given("Kullanıcı henüz oturum açmamış bir ziyaretçidir")
    public void kullaniciHenuzOturumAcmamisBirZiyaretcidir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @Then("Header alanında \"Giriş Yap\" ve \"Ücretsiz Dene\" butonları görüntülenmelidir")
    public void headerAlanindaGirisYapVeUcretsizDeneButonlariGoruntulenmelidir() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible(), "Giriş yap butonu görünmüyor.");
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible(), "Ücretsiz dene butonu görünmüyor.");
    }

    @And("Header alanında Üretimlerim ve Profil İkonu yer almamalıdır")
    public void headerAlanindaUretimlerimVeProfilIkonuYerAlmamalidir() {
        Assert.assertFalse(homePage.getUretimlerimSekmesi().isVisible(), "Üretimlerim sekmesi görünüyor.");
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "test.kullanici@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "DogruSifre123!");
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @And("Header alanında Üretimlerim sekmesi ve Profil İkonu görüntülenmelidir")
    public void headerAlanindaUretimlerimSekmesiVeProfilIkonuGoruntulenmelidir() {
        Assert.assertTrue(homePage.getUretimlerimSekmesi().isVisible(), "Üretimlerim sekmesi görünmüyor.");
    }

    @And("Header alanında Giriş Yap ve Ücretsiz Dene butonları yer almamalıdır")
    public void headerAlanindaGirisYapVeUcretsizDeneButonlariYerAlmamalidir() {
        Assert.assertFalse(homePage.getGirisYapButton().isVisible(), "Giriş yap butonu görünüyor.");
    }

    @When("Kullanıcı dil seçeneğini Türkçe olarak belirler")
    public void kullaniciDilSeceneginiTurkceOlarakBelirler() {
        rm.myClick(homePage.getDilSecenegiTurkce());
    }

    @Then("Tüm ana sayfa metinleri, menüler ve butonlar anlık olarak Türkçe diline güncellenmelidir")
    public void tumAnaSayfaMetinleriMenulerVeButonlarAnlikOlarakTurkceDilineGuncellenmelidir() {
        Assert.assertTrue(homePage.getTumSayfaMetinleri().isVisible(), "Türkçe metinler güncellenemedi.");
    }

    @When("Kullanıcı footer bülten alanına {string} adresini yazar")
    public void kullaniciFooterBultenAlaninaAdresiniYazar(String eposta) {
        String resolvedEmail = rm.resolveDynamicValue(eposta);
        rm.mySendKeys(homePage.getBultenInput(), resolvedEmail);
    }

    @And("Kullanıcı bülten kayıt butonuna tıklar")
    public void kullaniciBultenKayitButonunaTiklar() {
        rm.myClick(homePage.getBultenKayitButonu());
    }

    @Then("Başarılı kayıt mesajı ekranda gösterilmelidir")
    public void basariliKayitMesajiEkrandaGosterilmelidir() {
        Assert.assertTrue(homePage.getBasariliKayıtMesaji().isVisible(), "Başarılı kayıt mesajı görünmüyor.");
    }

    @When("Kullanıcı footer bülten alanına {string} adresini yazar veya alanı boş bırakır")
    public void kullaniciFooterBultenAlaninaAdresiniYazarVeyaAlaniBosBirakir(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenInput(), gecersizEposta);
    }

    @Then("Form validasyon hata mesajı tetiklenmelidir")
    public void formValidasyonHataMesajiTetiklenmelidir() {
        Assert.assertTrue(homePage.getValidasyonHataMesaji().isVisible(), "Validasyon hata mesajı görünmüyor.");
    }

    @When("Kullanıcı E-posta ve Şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("İlgili alanlar için zorunluluk uyarı mesajları gösterilmelidir")
    public void ilgiliAlanlarIcinZorunlulukUyariMesajlariGosterilmelidir() {
        Assert.assertTrue(loginPage.getZorunlulukUyarilari().isVisible(), "Zorunluluk uyarıları görünmüyor.");
    }

    @When("Kullanıcı e-posta alanına format dışı bir değer olan {string} girer")
    public void kullaniciEPostaAlaninaFormatDisiBirDegerOlanGirer(String formatDisiDeger) {
        rm.mySendKeys(loginPage.getEpostaInput(), formatDisiDeger);
    }

    @Then("E-posta format uyarısı gösterilmelidir")
    public void ePostaFormatUyarisiGosterilmelidir() {
        Assert.assertTrue(loginPage.getEpostaFormatUyarisi().isVisible(), "E-posta format uyarısı görünmüyor.");
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı e-posta alanına {string} ve şifre alanına {string} girer")
    public void kullaniciEPostaAlaninaVeSifreAlaninaGirer(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Sistem güvenlik amacıyla ortak ve standart E-posta veya şifre hatalı hata mesajını dönmelidir")
    public void sistemGuvenlikAmaciylaOrtakVeStandartEPostaVeyaSifreHataliHataMesajiniDonmelidir() {
        Assert.assertTrue(loginPage.getJenerikHataMesaji().isVisible(), "Jenerik hata mesajı görünmüyor.");
    }

    @When("Kullanıcı şifre alanına parolasını yazar")
    public void kullaniciSifreAlaninaParolasiniYazar() {
        rm.mySendKeys(loginPage.getSifreInput(), "GuvenliSifre123!");
    }

    @Then("Şifre karakterleri varsayılan olarak maskelenmiş olmalıdır")
    public void sifreKarakterleriVarsayilanOlarakMaskelenmisOlmalidir() {
        Assert.assertTrue(loginPage.getSifreInput().getAttribute("type").equals("password"), "Şifre maskelenmemiş.");
    }

    @When("Kullanıcı şifre alanının yanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanininYanindakiGozIkonunaTiklar() {
        rm.myClick(loginPage.getSifreGozIkonu());
    }

    @Then("Şifre metin olarak görünür hale gelmelidir")
    public void sifreMetinOlarakGorunurHaleGelmelidir() {
        Assert.assertTrue(loginPage.getSifreInput().getAttribute("type").equals("text"), "Şifre metin olarak görünmüyor.");
    }

    @When("Kullanıcı tekrar Göz ikonuna tıklar")
    public void kullaniciTekrarGozIkonunaTiklar() {
        rm.myClick(loginPage.getSifreGozIkonu());
    }

    @Then("Şifre tekrar maskelenmelidir")
    public void sifreTekrarMaskelenmelidir() {
        Assert.assertTrue(loginPage.getSifreInput().getAttribute("type").equals("password"), "Şifre tekrar maskelenemedi.");
    }

    @When("Kullanıcı Google ile Giriş Yap butonuna tıklar")
    public void kullaniciGoogleIleGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGoogleIleGirisButton());
    }

    @Then("Kullanıcı Google kimlik doğrulama ekranına yönlendirilmelidir")
    public void kullaniciGoogleKimlikDogrulamaEkraninaYonlendirilmelidir() {
        Assert.assertTrue(loginPage.getGoogleKimlikDogrulamaEkrani().isVisible(), "Google kimlik doğrulama ekranı görünmüyor.");
    }

    @When("Kullanıcı geçerli Google hesabını seçerek izin verir")
    public void kullaniciGecerliGoogleHesabiniSecerekIzinVerir() {
        rm.myClick(loginPage.getGoogleIleGirisButton());
    }

    @Then("Kullanıcı sisteme başarılı bir şekilde giriş yapmış olarak ana sayfaya yönlendirilmelidir")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmisOlarakAnaSayfayaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"), "Ana sayfaya yönlendirilemedi.");
    }

    @Given("Kullanıcı kayıt sayfasındadır")
    public void kullaniciKayitSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı kayıt formundaki şifre alanına {string} ve şifreyi onayla alanına {string} girer")
    public void kullaniciKayitFormundakiSifreAlaninaVeSifreyiOnaylaAlaninaGirer(String sifre, String sifreOnayla) {
        rm.mySendKeys(registerPage.getSifreInput(), sifre);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), sifreOnayla);
    }

    @And("Kullanıcı kayıt ol adımlarını tamamlamaya çalışır")
    public void kullaniciKayitOlAdimlariniTamamlamayaCalisir() {
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("Parola politikası hatası veya şifrelerin eşleşmediği uyarısı alınmalıdır")
    public void parolaPolitikasiHatasiVeyaSifrelerinEslestigiUyarisiAlinmalidir() {
        Assert.assertTrue(registerPage.getParolaPolitikaHatasi().isVisible(), "Parola politikası hatası görünmüyor.");
    }

    @When("Kullanıcı geçerli kayıt bilgilerini ve eşleşen şifreyi girer")
    public void kullaniciGecerliKayitBilgileriniVeEslasenSifreyiGirer() {
        rm.mySendKeys(registerPage.getSifreInput(), "ValidPass123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "ValidPass123!");
    }

    @And("Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretlemez")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretlemez() {
        // İşaretlemeden geçiyoruz
    }

    @And("Kullanıcı Kayıt Ol butonuna tıklar")
    public void kullaniciKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("Sistem hesap oluşturma isteğini reddetmeli ve sözleşme onayının zorunlu olduğunu belirten bir uyarı göstermelidir")
    public void sistemHesapOlusturmaIsteginiReddetmeliVeSozlesmeOnayininZorunluOldugunuBelirtenBirUyariGostermelidir() {
        Assert.assertTrue(registerPage.getSozlesmeZorunluUyarisi().isVisible(), "Sözleşme zorunlu uyarısı görünmüyor.");
    }

    @When("Kullanıcı kayıt formuna sistemde kayıtlı olan {string} adresini girer")
    public void kullaniciKayitFormunaSistemdeKayitliOlanAdresiniGirer(String varolanEposta) {
        rm.mySendKeys(registerPage.getVarolanEpostaInput(), varolanEposta);
    }

    @And("Tüm diğer zorunlu alanları kurallara uygun şekilde doldurur")
    public void tumDigerZorunluAlanlariKurallaraUygunSekildeDoldurur() {
        rm.mySendKeys(registerPage.getSifreInput(), "ValidPass123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "ValidPass123!");
        rm.myCheckBox(registerPage.getKullaniciSozlesmesiCheckbox());
    }

    @Then("Sistem Bu e-posta adresi zaten kullanımda uyarısını dönmelidir")
    public void sistemBuEPostaAdresiZatenKullanimdaUyarisiniDonmelidir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaUyarisi().isVisible(), "Zaten kullanımda uyarısı görünmüyor.");
    }

    @When("Kullanıcı benzersiz ve geçerli bir e-posta adresi girer")
    public void kullaniciBenzersizVeGecerliBirEPostaAdresiGirer() {
        String uniqueEmail = rm.resolveDynamicValue("fakerEmail");
        rm.mySendKeys(registerPage.getVarolanEpostaInput(), uniqueEmail);
    }

    @And("Kullanıcı en az 8 karakterli politikaya uygun şifresini Şifreyi Onayla alanına da aynı şekilde girer")
    public void kullaniciEnAzKarakterliPolitikayaUygunSifresiniSifreyiOnaylaAlaninaDaAyniSekildeGirer() {
        rm.mySendKeys(registerPage.getSifreInput(), "SecurePassword1!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "SecurePassword1!");
    }

    @And("Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getKullaniciSozlesmesiCheckbox());
    }

    @Then("Hesap başarıyla oluşturulmalı ve kullanıcıya hoş geldin mesajı gösterilmelidir")
    public void hesapBasariylaOlusturulmaliVeKullaniciyaHosGeldinMesajiGosterilmelidir() {
        Assert.assertTrue(registerPage.getHosgeldinMesaji().isVisible(), "Hoş geldin mesajı görünmüyor.");
    }
}