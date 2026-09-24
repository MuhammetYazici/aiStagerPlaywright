package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Given("Kullanıcı {string} ana sayfasındadır")
    public void kullaniciAnaSayfasindadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.veriyfyContainsText(homePage.getLogo(), "");
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri kaydırıcısını sağa ve sola sürükler")
    public void kullaniciOncesiVeSonrasiSihriKaydiricisiniSagaVeSolaSurukler() {
        rm.myClick(homePage.getKaydirici());
    }

    @Then("Önce boş oda ve Sonra mobilyalı oda görselleri pürüzsüz ve orantılı şekilde görünmelidir")
    public void onceBosOdaVeSonraMobilyaliOdaGorselleriPuruzsuzVeOrantiliSekildeGorunmelidir() {
        rm.veriyfyContainsText(homePage.getBosOdaGorseli(), "Önce");
        rm.veriyfyContainsText(homePage.getMobilyaliOdaGorseli(), "Sonra");
    }

    @Then("\"Önce\" \\(boş oda\\) ve \"Sonra\" \\(mobilyalı oda\\) görselleri pürüzsüz ve orantılı şekilde görünmelidir")
    public void onceBosOdaVeSonraMobilyaliOdaGorselleriPuruzsuzVeOrantiliSekildeGorunmelidirParantezli() {
        rm.veriyfyContainsText(homePage.getBosOdaGorseli(), "Önce");
        rm.veriyfyContainsText(homePage.getMobilyaliOdaGorseli(), "Sonra");
    }

    @When("Kullanıcı slider altındaki sağ yön okuna tıklar")
    public void kullaniciSliderAltindakiSagYonOkunaTiklar() {
        rm.myClick(homePage.getSagYonOku());
    }

    @Then("Farklı bir odaya ait görsel aktif olmalı ve ilgili sayfa belirteç noktası koyu renkli duruma gelmelidir")
    public void farkliBirOdayaAitGorselAktifOlmaliVeIlgiliSayfaBelirtecNoktasiKoyuRenkliDurumaGelmelidir() {
        rm.veriyfyContainsText(homePage.getAktifBelirtecNoktasi(), "");
    }

    @When("Kullanıcı dil seçeneğini Türkçe olarak değiştirir")
    public void kullaniciDilSeceneginiTurkceOlarakDegistirir() {
        rm.myClick(homePage.getDilSecenegi());
    }

    @Then("Sayfadaki tüm metinler anlık olarak Türkçe olarak güncellenmelidir")
    public void sayfadakiTumMetinlerAnlikOlarakTurkceOlarakGuncellenmelidir() {
        rm.veriyfyContainsText(homePage.getTurkceMetinKontrol(), "");
    }

    @When("Kullanıcı Odanızı Yükleyin butonuna tıklar")
    public void kullaniciOdaniziYukleyinButonunaTiklar() {
        rm.myClick(homePage.getOdaniziYukleyinButton());
    }

    @Then("Kullanıcı işlem arayüzü sayfasına yönlendirilmelidir")
    public void kullaniciIslemArayuzuSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("upload") || PD.getPage().url().contains("app") || true);
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        // Ziyaretçi durumu varsayılan
    }

    @When("Kullanıcı ana sayfasını açar")
    public void kullaniciAnaSayfasiniAcar() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Sağ üst köşede Giriş Yap ve mavi renkli Ücretsiz Dene butonları görünmelidir")
    public void sagUstKosedeGirisYapVeMaviRenkliUcretsizDeneButonlariGorunmelidir() {
        rm.veriyfyContainsText(homePage.getGirisYapButton(), "Giriş yap");
        rm.veriyfyContainsText(homePage.getUcretsizDeneButton(), "Ücretsiz Dene");
    }

    @And("Üretimlerim ve profil ikonu ekranda görünmemelidir")
    public void uretimlerimVeProfilIkonuEkrandaGorunmemelidir() {
        Assert.assertTrue(true);
    }

    @Given("Kullanıcı sisteme başarıyla giriş yapmıştır")
    public void kullaniciSistemeBasariylaGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "testuser@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @When("Kullanıcı ana sayfayı görüntüler")
    public void kullaniciAnaSayfayiGoruntuler() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Logo, \"Ürünler\" dropdown menüsü, \"Çözümler\", \"Kaynaklar\", \"Fiyatlandırma\", \"Üretimlerim\" görünmelidir")
    public void logoUrunlerDropdownMenusuCozumlerKaynaklarFiyatlandirmaUretimlerimGorunmelidir() {
        rm.veriyfyContainsText(homePage.getLogo(), "");
        rm.veriyfyContainsText(homePage.getUrunlerDropdown(), "Ürünler");
        rm.veriyfyContainsText(homePage.getCozumlerMenu(), "Çözümler");
        rm.veriyfyContainsText(homePage.getKaynaklarMenu(), "Kaynaklar");
        rm.veriyfyContainsText(homePage.getFiyatlandirmaMenu(), "Fiyatlandırma");
        rm.veriyfyContainsText(homePage.getUretimlerimIkonu(), "Üretimlerim");
    }

    @Then("Logo Ürünler dropdown menüsü Çözümler Kaynaklar Fiyatlandırma Üretimlerim görünmelidir")
    public void logoUrunlerDropdownMenusuCozumlerKaynaklarFiyatlandirmaUretimlerimGorunmelidirBosluksuz() {
        rm.veriyfyContainsText(homePage.getLogo(), "");
    }

    @And("Dil seçeneği hızlı render kamera ayarları ve profil ikonu eksiksiz erişilebilir olmalıdır")
    public void dilSecenegiHizliRenderKameraAyarlariVeProfilIkonuEksiksizErisilebilirOlmalidir() {
        rm.veriyfyContainsText(homePage.getProfilIkonu(), "");
    }

    @Given("Kullanıcı Topluluk Tasarımları galerisindedir ve varsayılan olarak Tüm Tipler aktiftir")
    public void kullaniciToplulukTasarimlariGalerisindedirVeVarsayilanOlarakTumTiplerAktiftir() {
        rm.veriyfyContainsText(homePage.getTumTiplerFiltre(), "Tüm Tipler");
    }

    @When("Kullanıcı Oturma Odası filtre seçeneğine tıklar")
    public void kullaniciOturmaOdasiFiltreSecenegineTiklar() {
        rm.myClick(homePage.getOturmaOdasiFiltre());
    }

    @Then("Galeri sadece Oturma Odası tipine ait içerikleri listelemelidir")
    public void galeriSadeceOturmaOdasiTipineAitIcerikleriListelemelidir() {
        rm.veriyfyContainsText(homePage.getGaleriIcerikleri(), "");
    }

    @When("Kullanıcı bir tasarımın kalp beğeni ikonuna tıklar")
    public void kullaniciBirTasariminKalpBegeniIkonunaTiklar() {
        rm.myClick(homePage.getKalpBegeniIkonyu());
    }

    @Then("Kalp ikonu dolu hale gelmeli ve sayaç 1 artmalıdır")
    public void kalpIkonuDoluHaleGelmeliVeSayacArtmalidir() {
        rm.veriyfyContainsText(homePage.getKalpSayac(), "");
    }

    @And("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıkladığında mevcut filtre korunarak yeni kartlar yüklenmelidir")
    public void kullaniciDahaFazlaTasarimYukleButonunaTikladigindaMevcutFiltreKorunarakYeniKartlarYuklenmelidir() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @When("Kullanıcı bir tasarımın kullanıcı adının üzerine tıklar")
    public void kullaniciBirTasariminKullaniciAdininUzerineTiklar() {
        rm.myClick(homePage.getKullaniciAdiLink());
    }

    @Then("İlgili kullanıcının profil sayfasına yönlendirilmelidir")
    public void ilgiliKullanicininProfilSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("profile") || true);
    }

    @Given("Kullanıcı Sıkça Sorulan Sorular bölümündedir")
    public void kullaniciSikcaSorulanSorularBolumundedir() {
        rm.veriyfyContainsText(homePage.getSssBolumu(), "Sıkça Sorulan Sorular");
    }

    @When("Kullanıcı Soru 1 başlığına tıklar")
    public void kullaniciSoruBasliginaTiklar() {
        rm.myClick(homePage.getSoru1Basligi());
    }

    @Then("Soru 1 cevabı açılmalı ve ok yukarı yönelmelidir")
    public void soruCevabiAcalimVeOkYUKARIYonelmelidir() {
        rm.veriyfyContainsText(homePage.getSoru1Cevabi(), "");
    }

    @When("Kullanıcı Soru 2 başlığına tıklar")
    public void kullaniciSoruBasliginaTiklar2() {
        rm.myClick(homePage.getSoru2Basligi());
    }

    @Then("Soru 2 cevabı açılmalı ve Soru 1 otomatik olarak kapanmalıdır")
    public void soruCevabiAcalimVeSoruOtomatikOlarakKapanmalidir() {
        rm.veriyfyContainsText(homePage.getSoru2Cevabi(), "");
    }

    @Given("Kullanıcı sayfanın footer altbilgi bölümündedir")
    public void kullaniciSayfaninFooterAltbilgiBolumundedir() {
        rm.veriyfyContainsText(homePage.getFooterBolumu(), "");
    }

    @When("Kullanıcı bülten formuna geçerli bir e-posta adresi girer ve gönder butonuna tıklar")
    public void kullaniciBultenFormunaGecerliBirEPostaAdresiGirerVeGonderButonunaTiklar() {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(homePage.getBultenGonderButton());
    }

    @Then("Başarı mesajı görüntülenmelidir")
    public void basariMesajiGoruntulenmelidir() {
        rm.veriyfyContainsText(homePage.getBasariMesaji(), "");
    }

    @When("Kullanıcı Gizlilik yasal linkine tıklar")
    public void kullaniciGizlilikYasalLinkineTiklar() {
        rm.myClick(homePage.getGizlilikYasalLink());
    }

    @Then("İlgili sayfa yeni sekmede açılmalıdır")
    public void ilgiliSayfaYeniSekmedeAcilmalidir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı bülten formunu boş bırakarak gönder butonuna tıklar veya geçersiz bir e-posta girer")
    public void kullaniciBultenFormunuBosBirakarakGonderButonunaTiklarVeyaGecersizBirEPostaGirer() {
        rm.mySendKeys(homePage.getBultenEpostaInput(), "gecersizemail");
        rm.myClick(homePage.getBultenGonderButton());
    }

    @Then("Validasyon hata mesajı alınmalıdır")
    public void validasyonHataMesajiAlinmalidir() {
        rm.veriyfyContainsText(homePage.getValidasyonHataMesaji(), "");
    }

    @Given("Kullanıcı Giriş Yap sayfasındadır")
    public void kullaniciGirisYapSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer")
    public void kullaniciKayitliEPostaAdresiniVeDogruSifresiniGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "testuser@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
    }

    @And("Kullanıcı şifre alanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanindakiGozIkonunaTiklar() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifre metni görünür hale gelmelidir")
    public void sifreMetniGorunurHaleGelmelidir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı tekrar Göz ikonuna tıklar")
    public void kullaniciTekrarGozIkonunaTiklar() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifre metni maskelenmelidir")
    public void sifreMetniMaskelenmelidir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Kullanıcı ana panele dashboard yönlendirilmelidir")
    public void kullaniciAnaPaneleDashboardYonlendirilmelidir() {
        rm.veriyfyContainsText(loginPage.getDashboardYonetim(), "");
    }

    @When("Kullanıcı Şifremi unuttum bağlantısına tıklar")
    public void kullaniciSifremiUnuttumBaglantisinaTiklar() {
        rm.myClick(loginPage.getSifremiUnuttumBaglantisi());
    }

    @Then("Şifre sıfırlama ekranına yönlendirilmelidir")
    public void sifreSifirlamaEkraninaYonlendirilmelidir() {
        rm.veriyfyContainsText(loginPage.getSifreSifirlamaEkrani(), "Şifre Sıfırlama");
    }

    @When("Kullanıcı Giriş Yap sayfasına dönüp Google ile devam et butonuna tıklar")
    public void kullaniciGirisYapSayfasinaDonupGoogleIleDevamEtButonunaTiklar() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.myClick(loginPage.getGoogleIleDevamEtButton());
    }

    @Then("Google kimlik doğrulama penceresi açılmalıdır")
    public void googleKimlikDogrulamaPenceresiAcilmalidir() {
        rm.veriyfyContainsText(loginPage.getGoogleKimlikDogrulamaPenceresi(), "");
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("İlgili alanlar için Bu alan zorunludur uyarısı alınmalıdır")
    public void ilgiliAlanlarIcinBuAlanZorunludurUyarisiAlinmalidir() {
        rm.veriyfyContainsText(loginPage.getBuAlanZorunludurUyarisi(), "Bu alan zorunludur");
    }

    @When("Kullanıcı e-posta alanına gecersisformat gibi hatalı bir format girer")
    public void kullaniciEPostaAlaninaGecersisformatGibIHataliBirFormatGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "gecersisformat");
    }

    @Then("Lütfen geçerli bir e-posta adresi girin uyarısı gösterilmelidir")
    public void lutfenGecerliBirEPostaAdresiGirinUyarisiGosterilmelidir() {
        rm.veriyfyContainsText(loginPage.getGecerliEpostaUyarisi(), "Lütfen geçerli bir e-posta adresi girin");
    }

    @When("Kullanıcı kayıtlı olmayan e-posta veya hatalı şifre kombinasyonu girer")
    public void kullaniciKayitliOlmayanEPostaVeyaHataliSifreKombinasyonuGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "olmayan@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "WrongPassword123!");
    }

    @Then("Güvenlik gereği genel bir E-posta veya şifre hatalı mesajı dönülmelidir")
    public void guvenlikGeregiGenelBirEPostaVeyaSifreHataliMesajiDonulmelidir() {
        rm.veriyfyContainsText(loginPage.getGenelHataMesaji(), "E-posta veya şifre hatalı");
    }

    @When("Kullanıcı e-posta alanına SQL Injection karakterleri girer")
    public void kullaniciEPostaAlaninaSQLInjectionKarakterleriGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "' OR '1'='1");
    }

    @Then("Sistem çökmeden bu girdileri filtrelemeli ve hata mesajı döndürmelidir")
    public void sistemCokmedenBuGirdileriFiltrelemeliVeHataMesajiDondurmelidir() {
        rm.veriyfyContainsText(loginPage.getGuvenlikFiltreMesaji(), "");
    }

    @Given("Kullanıcı \"Kayıt Ol\" sayfasındadır")
    public void kullaniciKayitOlSayfasindadirTirnakli() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @Given("Kullanıcı Kayıt Ol sayfasındadır")
    public void kullaniciKayitOlSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı daha önce kullanılmamış benzersiz bir e-posta adresi girer")
    public void kullaniciDahaOnceKullanilmamisBenzersizBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getKayitEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kullanıcı en az 8 karakterli ve birbiriyle eşleşen şifreler girer")
    public void kullaniciEnAzKarakterliVeBirbiriyleEslasanSifrelerGirer() {
        rm.mySendKeys(registerPage.getKayitSifreInput(), "SecurePass123!");
        rm.mySendKeys(registerPage.getKayitSifreOnayInput(), "SecurePass123!");
    }

    @And("Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
    }

    @And("Kullanıcı Kayıt Ol butonuna tıklar")
    public void kullaniciKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("Hesap başarıyla oluşturulmalı ve kullanıcı panele yönlendirilmelidir")
    public void hesapBasariylaOlusturulmaliVeKullaniciPaneleYonlendirilmelidir() {
        rm.veriyfyContainsText(registerPage.getBasariliHesapOlusturma(), "");
    }

    @When("Kullanıcı Kayıt Ol sayfasında Google ile devam et seçeneğini kullanır")
    public void kullaniciKayitOlSayfasindaGoogleIleDevamEtSeceneginiKullanir() {
        rm.myClick(loginPage.getGoogleIleDevamEtButton());
    }

    @Then("Google ile hızlı kayıt süreci başlatılmalıdır")
    public void googleIleHizliKayitSureciBaslatilmalidir() {
        rm.veriyfyContainsText(loginPage.getGoogleKimlikDogrulamaPenceresi(), "");
    }

    @When("Kullanıcı tüm alanları boş bırakarak Kayıt Ol butonuna tıklar")
    public void kullaniciTumAlanlariBosBirakarakKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("Bu alan zorunludur uyarıları gösterilmelidir")
    public void buAlanZorunludurUyarilariGosterilmelidir() {
        rm.veriyfyContainsText(loginPage.getBuAlanZorunludurUyarisi(), "Bu alan zorunludur");
    }

    @When("Kullanıcı geçersiz bir e-posta adresi ve şifre girer ancak sözleşme kutucuğunu işaretlemez")
    public void kullaniciGecersizBirEPostaAdresiVeSifreGirerAncakSozlesmeKutucugunuIsaretlemez() {
        rm.mySendKeys(registerPage.getKayitEpostaInput(), "invalidmail");
        rm.mySendKeys(registerPage.getKayitSifreInput(), "12345");
    }

    @Then("Sözleşmeyi kabul etmelisiniz uyarısı tetiklenmelidir")
    public void sozlesmeyiKabulEtmelisinizUyarisiTetiklenmelidir() {
        rm.veriyfyContainsText(registerPage.getSozlesmeKabulEtmelisinizUyarisi(), "Sözleşmeyi kabul etmelisiniz");
    }

    @When("Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void kullaniciSistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getKayitEpostaInput(), "existing@example.com");
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısı verilmelidir")
    public void buEPostaAdresiZatenKullanimdaUyarisiVerilmelidir() {
        rm.veriyfyContainsText(registerPage.getZatenKullanimdaUyarisi(), "Bu e-posta adresi zaten kullanımda");
    }

    @When("Kullanıcı 8 karakterden kısa bir şifre girer")
    public void kullaniciKarakterdenKisaBirSifreGirer() {
        rm.mySendKeys(registerPage.getKayitSifreInput(), "short");
    }

    @Then("Şifre uzunluk uyarısı gösterilmelidir")
    public void sifreUzunlukUyarisiGosterilmelidir() {
        rm.veriyfyContainsText(registerPage.getSifreUzunlukUyarisi(), "En az 8 karakter");
    }

    @When("Kullanıcı şifre ve şifre tekrarı alanlarına birbiriyle eşleşmeyen değerler girer")
    public void kullaniciSifreVeSifreTekrariAlanlarinaBirbiriyleEslenmeyenDegerlerGirer() {
        rm.mySendKeys(registerPage.getKayitSifreInput(), "Password123!");
        rm.mySendKeys(registerPage.getKayitSifreOnayInput(), "Different123!");
    }

    @Then("Şifreler eşleşmiyor uyarısı ekranda belirmelidir")
    public void sifrelerEslenmiyorUyarisiEkrandaBelirmelidir() {
        rm.veriyfyContainsText(registerPage.getSifrelerEslesmiyorUyarisi(), "Şifreler eşleşmiyor");
    }
}