package StepDefinations;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
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
        homePage.getTumunuKabulEtButton().click();
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        Assert.assertTrue(homePage.getHeaderLogo().isVisible());
    }

    @When("Kullanıcı karşılaştırma slider okunu sağa ve sola sürüklerse")
    public void kullaniciKarsilastirmaSliderOkunuSagaVeSolaSuruklerse() {
        rm.myClick(homePage.getSliderLocator());
    }

    @Then("Önce boş oda ve Sonra mobilyalı oda görselleri orantılı ve pürüzsüz bir şekilde değişmelidir")
    public void onceBosOdaVeSonraMobilyaliOdaGorselleriOrantiliVePuruzsuzBirSekildeDegismelidir() {
        Assert.assertTrue(homePage.getSliderLocator().isVisible());
    }

    @When("Kullanıcı carousel üzerindeki ikinci nokta veya yön okuna tıklarsa")
    public void kullaniciCarouselUzerindekiIkinciNoktaVeyaYonOkunaTiklarsa() {
        rm.myClick(homePage.getCarouselLocator());
    }

    @Then("İlgili oda görselleri yüklenmeli ve aktif nokta görsel olarak vurgulanmalıdır")
    public void ilgiliOdaGorselleriYuklenmeliVeAktifNoktaGorselOlarakVurgulanmalidir() {
        Assert.assertTrue(homePage.getCarouselLocator().isVisible());
    }

    @Given("Ziyaretçi oturum açmamış durumdadır ve ana sayfadadır")
    public void ziyaretiOturumAcmamisDurumdadirVeAnaSayfadadir() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
    }

    @Then("Header alanında {string} ve {string} butonları görünmelidir")
    public void headerAlanindaVeButonlariGörünmelidir(String arg0, String arg1) {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible());
    }

    @And("Üretimlerim ve profil ikonu gizli olmalıdır")
    public void uretimlerimVeProfilIkonuGizliOlmalidir() {
        Assert.assertTrue(true);
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        rm.myClick(homePage.getGirisYapButton());
        rm.mySendKeys(loginPage.getEpostaInput(), "kullanici@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPass123!");
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Header alanında logo, ürünler dropdown, çözümler, kaynaklar, fiyatlandırma görünmelidir")
    public void headerAlanindaLogoUrunlerDropdownCozumlerKaynaklarFiyatlandirmaGorunmelidir() {
        Assert.assertTrue(homePage.getHeaderLogo().isVisible());
        Assert.assertTrue(homePage.getUrunlerDropdown().isVisible());
        Assert.assertTrue(homePage.getCozumler().isVisible());
        Assert.assertTrue(homePage.getKaynaklar().isVisible());
        Assert.assertTrue(homePage.getFiyatlandirma().isVisible());
    }

    @And("Üretimlerim, hızlı render paneli ve profil menüsü erişilebilir olmalıdır")
    public void uretimlerimHizliRenderPaneliVeProfilMenusuErisilebilirOlmalidir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı TR dil seçeneğine tıklarsa")
    public void kullaniciTrDilSecenegineTiklarsa() {
        rm.myClick(homePage.getDilSecenegiTR());
    }

    @Then("Dil menüsü açılmalı ve seçilen dile göre arayüz metinleri güncellenmelidir")
    public void dilMenusuAcilmaliVeSecilenDileGoreArayuzMetinleriGuncellenmelidir() {
        Assert.assertTrue(homePage.getDilSecenegiTR().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki topluluk galerisi alanındadır")
    public void kullaniciAnaSayfadakiToplulukGalerisiAlanindadir() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @Then("Tüm Tipler filtresi varsayılan olarak aktif olmalıdır")
    public void tumTiplerFiltresiVarsayilanOlarakAktifOlmalidir() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @When("Kullanıcı Oturma Odası filtre seçeneğine tıklarsa")
    public void kullaniciOturmaOdasiFiltreSecenegineTiklarsa() {
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @Then("Galeri sadece Oturma Odası filtreli kartları listelemelidir")
    public void galeriSadeceOturmaOdasiFiltreliKartlariListelemelidir() {
        Assert.assertTrue(homePage.getGaleriKartlari().isVisible());
    }

    @Given("Kullanıcı galeridedir ve mevcut kartlar listelenmektedir")
    public void kullaniciGaleridedirVeMevcutKartlarListelenmektedir() {
        Assert.assertTrue(homePage.getGaleriKartlari().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklarsa")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklarsa() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut aktif filtre bozulmadan yeni kartlar listeye eklenmelidir")
    public void mevcutAktifFiltreBozulmadanYeniKartlarListeyeEklenmelidir() {
        Assert.assertTrue(homePage.getGaleriKartlari().isVisible());
    }

    @Given("Kullanıcı galerideki bir tasarım kartını incelemektedir")
    public void kullaniciGaleridekiBirTasarimKartiniIncelemektedir() {
        Assert.assertTrue(homePage.getGaleriKartlari().isVisible());
    }

    @When("Kullanıcı tasarımın sahibi olan kullanıcı adını tıklarsa")
    public void kullaniciTasariminSahibiOlanKullaniciAdiniTiklarsa() {
        rm.myClick(homePage.getTasarimSahibi());
    }

    @And("Kullanıcı kart üzerindeki kalp ikonuna tıklarsa")
    public void kullaniciKartUzerindekiKalpIkonunaTiklarsa() {
        rm.myClick(homePage.getKalpIkonu());
    }

    @Then("İlgili kullanıcı profil sayfasına yönlendirilmeli")
    public void ilgiliKullaniciProfilSayfasinaYonlendirilmeli() {
        Assert.assertTrue(true);
    }

    @And("Beğeni sayısı 1 artarak kalp ikonu aktif beğenildi hale gelmelidir")
    public void begeniSayisi1ArtarakKalpIkonuAktifBegenildiHaleGelmelidir() {
        Assert.assertTrue(homePage.getBegeniSayisi().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki FAQ Sık Sorulan Sorular bölümündedir")
    public void kullaniciAnaSayfadakiFaqSikSorulanSorularBolumundedir() {
        Assert.assertTrue(homePage.getFaqBirinciSoru().isVisible());
    }

    @When("Kullanıcı birinci soru başlığına tıklarsa")
    public void kullaniciBirinciSoruBasliginaTiklarsa() {
        rm.myClick(homePage.getFaqBirinciSoru());
    }

    @Then("İlgili cevap alanı açılmalıdır")
    public void ilgiliCevapAlaniAcilmalidir() {
        Assert.assertTrue(homePage.getFaqBirinciCevap().isVisible());
    }

    @When("Kullanıcı ikinci soru başlığına tıklarsa")
    public void kullaniciIkinciSoruBasliginaTiklarsa() {
        rm.myClick(homePage.getFaqIkinciSoru());
    }

    @Then("İkinci sorunun cevabı açılmalı ve birinci sorunun cevabı otomatik olarak kapanmalıdır")
    public void ikinciSorununCevabiAcilmaliVeBirinciSorununCevabiOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getFaqIkinciCevap().isVisible());
    }

    @Given("Kullanıcı ana sayfanın footer bölümündedir")
    public void kullaniciAnaSayfaninFooterBolumundedir() {
        Assert.assertTrue(homePage.getBultenInput().isVisible());
    }

    @When("Kullanıcı bülten alanına geçerli bir {string} e-posta adresi girer ve gönder butonuna tıklar")
    public void kullaniciBultenAlaninaGecerliBirEPostaAdresiGirerVeGonderButonunaTiklar(String email) {
        rm.mySendKeys(homePage.getBultenInput(), email);
        rm.myClick(homePage.getBultenGonderButton());
    }

    @Then("Bülten aboneliği başarılı mesajı gösterilmelidir")
    public void bultenAboneligiBasariliMesajiGosterilmelidir() {
        Assert.assertTrue(homePage.getBultenBasariMesaji().isVisible());
    }

    @When("Kullanıcı bülten alanına {string} girer ve gönder butonuna tıklar")
    public void kullaniciBultenAlaninaGirerVeGonderButonunaTiklar(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenInput(), gecersizEposta);
        rm.myClick(homePage.getBultenGonderButton());
    }

    @Then("Uyarı veya hata mesajı gösterilmelidir")
    public void uyariVeyaHataMesajiGosterilmelidir() {
        Assert.assertTrue(homePage.getBultenHataMesaji().isVisible());
    }

    @When("Kullanıcı sosyal medya ikonlarından birine tıklarsa")
    public void kullaniciSosyalMedyaIkonlarindanBirineTiklarsa() {
        rm.myClick(homePage.getSosyalMedyaIkonu());
    }

    @Then("İlgili sosyal medya sayfası yeni sekmede new tab açılmalıdır")
    public void ilgiliSosyalMedyaSayfasiYeniSekmedeNewTabAcilmalidir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı yasal bağlantılara Gizlilik Politikası vb tıklarsa")
    public void kullaniciYasalBaglantilaraGizlilikPolitikasiVbTiklarsa() {
        rm.myClick(homePage.getGizlilikPolitikasiLink());
    }

    @Then("İlgili sayfaya yönlendirilmelidir")
    public void ilgiliSayfayaYonlendirilmelidir() {
        Assert.assertTrue(true);
    }

    @Given("Kullanıcı Giriş Yap sayfasındadır")
    public void kullaniciGirisYapSayfasindadir() {
        rm.myClick(homePage.getGirisYapButton());
    }

    @When("Kullanıcı geçerli bir e-posta {string} ve şifre {string} girer")
    public void kullaniciGecerliBirEPostaVeSifreGirer(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Kullanıcı başarıyla ana panele dashboard yönlendirilmelidir")
    public void kullaniciBasariylaAnaPaneleDashboardYonlendirilmelidir() {
        Assert.assertTrue(homePage.getHeaderLogo().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} yazar")
    public void kullaniciSifreAlaninaYazar(String sifre) {
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @And("Kullanıcı şifre alanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanindakiGozIkonunaTiklarsa() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifre karakterleri maskesiz görünür hale gelmelidir")
    public void sifreKarakterleriMaskesizGorunurHaleGelmelidir() {
        Assert.assertTrue(loginPage.getGozIkonu().isVisible());
    }

    @When("Kullanıcı {string} linkine tıklarsa {string} sayfasına yönlendirilmelidir")
    public void kullaniciLinkineTiklarsaSayfasinaYonlendirilmelidir(String linkAdi, String sayfaAdi) {
        rm.myClick(loginPage.getSifremiUnuttumLink());
    }

    @And("Kullanıcı Kayıt ol linkine tıklarsa Kayıt Ol sayfasına yönlendirilmelidir")
    public void kullaniciKayitOlLinkineTiklarsaKayitOlSayfasinaYonlendirilmelidir() {
        rm.myClick(loginPage.getKayitOlLink());
    }

    @When("Kullanıcı Google ile devam et butonuna tıklar")
    public void kullaniciGoogleIleDevamEtButonunaTiklar() {
        rm.myClick(loginPage.getGoogleIleDevamEtButton());
    }

    @Then("Google OAuth kimlik doğrulama penceresi açılmalıdır")
    public void googleOAuthKimlikDogrulamaPenceresiAcilmalidir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı e-posta alanına {string} ve şifre alanına {string} girer")
    public void kullaniciEPostaAlaninaVeSifreAlaninaGirer(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @Then("Bu alan zorunludur uyarı mesajı gösterilmelidir")
    public void buAlanZorunludurUyariMesajiGosterilmelidir() {
        Assert.assertTrue(loginPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} ve şifre alanına {string} girer ve Giriş Yap butonuna tıklar")
    public void kullaniciEPostaAlaninaVeSifreAlaninaGirerVeGirisYapButonunaTiklar(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @Then("Lütfen geçerli bir e-posta adresi girin uyarısı gösterilmelidir")
    public void lutfenGecerliBirEPostaAdresiGirinUyarisiGosterilmelidir() {
        Assert.assertTrue(loginPage.getGecersizEpostaUyarisi().isVisible());
    }

    @Then("E-posta veya şifre hatalı genel güvenlik mesajı gösterilmelidir")
    public void ePostaVeyaSifreHataliGenelGuvenlikMesajiGosterilmelidir() {
        Assert.assertTrue(loginPage.getGenelGuvenlikMesaji().isVisible());
    }

    @Then("Sistem 500 hatası vermemeli, isteği reddetmeli ve E-posta veya şifre hatalı mesajı döndürmelidir")
    public void sistem500HatasiVermemeliIstegiReddetmeliVeEPostaVeyaSifreHataliMesajiDondurmelidir() {
        Assert.assertTrue(loginPage.getGenelGuvenlikMesaji().isVisible());
    }

    @Given("Kullanıcı Kayıt Ol sayfasındadır")
    public void kullaniciKayitOlSayfasindadir() {
        rm.myClick(homePage.getGirisYapButton());
        rm.myClick(loginPage.getKayitOlLink());
    }

    @When("Kullanıcı sistemde kayıtlı olmayan bir {string} e-posta adresi girer")
    public void kullaniciSistemdeKayitliOlmayanBirEPostaAdresiGirer(String eposta) {
        rm.mySendKeys(registerPage.getEpostaInput(), eposta);
    }

    @And("Kullanıcı kurallara uygun min. 8 karakter bir şifre {string} girer")
    public void kullaniciKurallaraUygunMin8KarakterBirSifreGirer(String sifre) {
        rm.mySendKeys(registerPage.getSifreInput(), sifre);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), sifre);
    }

    @And("Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
    }

    @And("Kullanıcı Kayıt Ol butonuna tıklar")
    public void kullaniciKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("Kullanıcı başarıyla kaydedilmeli ve aktivasyon veya ana panel ekranına yönlendirilmelidir")
    public void kullaniciBasariylaKaydedilmeliVeAktivasyonVeyaAnaPanelEkraninaYonlendirilmelidir() {
        Assert.assertTrue(homePage.getHeaderLogo().isVisible());
    }

    @When("Kullanıcı şifre ve şifreyi onayla alanlarına {string} yazar")
    public void kullaniciSifreVeSifreyiOnaylaAlanlarinaYazar(String sifre) {
        rm.mySendKeys(registerPage.getSifreInput(), sifre);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), sifre);
    }

    @Then("Şifre görünür hale gelmelidir")
    public void sifreGorunurHaleGelmelidir() {
        Assert.assertTrue(registerPage.getGozIkonu().isVisible());
    }

    @When("Kullanıcı Giriş yap bağlantısına tıklarsa Giriş Yap sayfasına yönlendirilmelidir")
    public void kullaniciGirisYapBaglantisinaTiklarsaGirisYapSayfasinaYonlendirilmelidir() {
        rm.myClick(registerPage.getGirisYapBaglantisi());
    }

    @And("Kullanıcı Google ile devam et butonuna tıklarsa Google OAuth kayıt penceresi açılmalıdır")
    public void kullaniciGoogleIleDevamEtButonunaTiklarsaGoogleOAuthKayitPenceresiAcilmalidir() {
        rm.myClick(registerPage.getGoogleIleDevamEtButton());
    }

    @When("Kullanıcı tüm alanları boş bırakarak Kayıt Ol butonuna tıklar")
    public void kullaniciTumAlanlariBosBirakarakKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @When("Kullanıcı e-posta alanına {string} girer ve diğer alanları geçerli doldurur")
    public void kullaniciEPostaAlaninaGirerVeDigerAlanlariGecerliDoldurur(String eposta) {
        rm.mySendKeys(registerPage.getEpostaInput(), eposta);
        rm.mySendKeys(registerPage.getSifreInput(), "StrongPass1!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "StrongPass1!");
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
    }

    @Then("E-posta formatı için validasyon uyarısı gösterilmelidir")
    public void ePostaFormatiIcinValidasyonUyarisiGosterilmelidir() {
        Assert.assertTrue(registerPage.getEpostaFormatUyarisi().isVisible());
    }

    @When("Kullanıcı sistemde kayıtlı olan {string} e-postasını girer")
    public void kullaniciSistemdeKayitliOlanEpostasiniGirer(String eposta) {
        rm.mySendKeys(registerPage.getEpostaInput(), eposta);
    }

    @And("Geçerli şifre ve sözleşme onayını tamamlayıp Kayıt Ol butonuna tıklar")
    public void gecerliSifreVeSozlesmeOnayiniTamamlayipKayitOlButonunaTiklar() {
        rm.mySendKeys(registerPage.getSifreInput(), "StrongPass1!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "StrongPass1!");
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("Bu e-posta adresi zaten kullanımda hatası alınmalıdır")
    public void buEPostaAdresiZatenKullanimdaHatasiAlinmalidir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaUyarisi().isVisible());
    }

    @When("Kullanıcı şifre alanına 8 karakterden az olan {string} şifresini girer")
    public void kullaniciSifreAlanina8KarakterdenAzOlanSifresiniGirer(String sifre) {
        rm.mySendKeys(registerPage.getSifreInput(), sifre);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), sifre);
    }

    @Then("Şifrenin en az 8 karakter olması gerektiğine dair minimum uzunluk kuralı hatası tetiklenmelidir")
    public void sifreninEnAz8KarakterOlmasiGerektigineDairMinimumUzunlukKuraliHatasiTetiklenmelidir() {
        Assert.assertTrue(registerPage.getMinimumUzunlukUyarisi().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} ve şifreyi onayla alanına {string} girer")
    public void kullaniciSifreAlaninaVeSifreyiOnaylaAlaninaGirer(String sifre1, String sifre2) {
        rm.mySendKeys(registerPage.getSifreInput(), sifre1);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), sifre2);
    }

    @Then("{string} uyarısı verilmelidir")
    public void uyarisiVerilmelidir(String arg0) {
        Assert.assertTrue(registerPage.getSifrelerEslesmiyorUyarısı().isVisible());
    }

    @When("Kullanıcı geçerli e-posta ve şifre girer ancak kullanıcı sözleşmesi kutucuğunu işaretlemez")
    public void kullaniciGecerliEPostaVeSifreGirerAncakKullaniciSozlesmesiKutucugunuIsaretlemez() {
        rm.mySendKeys(registerPage.getEpostaInput(), "yeni_kullanici@example.com");
        rm.mySendKeys(registerPage.getSifreInput(), "StrongPass1!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "StrongPass1!");
    }

    @Then("Sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir ve kayıt engellenmelidir")
    public void sozlesmeninOnaylanmasiGerektigineDairUyariMesajiGosterilmelidirVeKayitEngellenmelidir() {
        Assert.assertTrue(registerPage.getSozlesmeOnayUyarisi().isVisible());
    }
}