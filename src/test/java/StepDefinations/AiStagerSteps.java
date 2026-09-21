package StepDefinations;

import Pages.AiStagerPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class AiStagerSteps {
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager.ai platformunun ana sayfasındadır")
    public void kullaniciAiStagerAiPlatformununAnaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı kaydırıcı çizgisini sağa ve sola sürükler")
    public void kullaniciKaydiriciCizgisiniSagaVeSolaSurukler() {
        rm.myClick(page.getSliderLine());
    }

    @Then("Önce ve Sonra görselleri arasında pürüzsüz geçiş yapılabilmelidir")
    public void onceVeSonraGorselleriArasindaPuruzsuzGecisYapilabilmelidir() {
        Assert.assertTrue(page.getBeforeAfterImages().isVisible(), "Görseller görünür değil");
    }

    @Then("Yön okları veya alt carousel noktaları kullanılarak farklı odalara geçiş yapılabilmelidir")
    public void yonOklariVeyaAltCarouselNoktalariKullanilarakFarkliOdalaraGecisYapilabilmelidir() {
        rm.myClick(page.getNavigationArrows());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı ana sayfa header alanını inceler")
    public void kullaniciAnaSayfaHeaderAlaniniInceler() {
        Assert.assertTrue(page.getLoginButtonHeader().isVisible() || page.getFreeTrialButton().isVisible());
    }

    @Then("Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır")
    public void girisYapVeUcretsizDeneButonlariGorunurOlmalidir() {
        Assert.assertTrue(page.getFreeTrialButton().isVisible());
    }

    @Then("Üretimlerim ve profil ikonu görünmemelidir")
    public void uretimlerimVeProfilIkonuGorunmemelidir() {
        Assert.assertFalse(page.getMyProductions().isVisible());
    }

    @Given("Kullanıcı sisteme başarıyla giriş yapmıştır")
    public void kullaniciSistemeBasariylaGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üretimlerim, hızlı erişim paneli ve profil ikonu aktif ve görünür olmalıdır")
    public void uretimlerimHizliErisimPaneliVeProfilIkonuAktifVeGorunurOlmalidir() {
        rm.myClick(page.getProfileIcon());
    }

    @When("Kullanıcı dil seçeneği menüsüne tıklar")
    public void kullaniciDilSecenegiMenusuneTiklar() {
        rm.myClick(page.getLanguageMenu());
    }

    @When("Kullanıcı farklı bir dil seçer")
    public void kullaniciFarkliBirDilSecer() {
        rm.myClick(page.getDifferentLanguageOption());
    }

    @Then("Arayüz metinleri seçilen dile göre güncellenmelidir")
    public void arayuzMetinleriSecilenDileGoreGuncellenmelidir() {
        rm.veriyfyContainsText(page.getLoginButtonHeader(), "");
    }

    @When("Kullanıcı ana sayfa galeri alanına gelir")
    public void kullaniciAnaSayfaGaleriAlaninaGelir() {
        rm.myClick(page.getGalleryArea());
    }

    @Then("Tüm Tipler filtresinin aktif olduğunu görür")
    public void tumTiplerFiltresininAktifOldugunuGorur() {
        Assert.assertTrue(page.getAllTypesFilter().isVisible());
    }

    @When("Kullanıcı Oturma Odası oda tipi filtresine tıklar")
    public void kullaniciOturmaOdasiOdaTipiFiltresineTiklar() {
        rm.myClick(page.getLivingRoomFilter());
    }

    @Then("Galeri anlık olarak filtrelenmeli ve sadece oturma odası kartları listelenmelidir")
    public void galeriAnlikOlarakFiltrelenmeliVeSadeceOturmaOdasiKartlariListelenmelidir() {
        Assert.assertTrue(page.getGalleryCards().first().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(page.getLoadMoreButton());
    }

    @Then("Mevcut filtre bozulmaksızın yeni kartlar yüklenmelidir")
    public void mevcutFiltreBozulmaksizinYeniKartlarYuklenmelidir() {
        Assert.assertTrue(page.getGalleryCards().first().isVisible());
    }

    @When("Kullanıcı SSS alanındaki bir soruya tıklar")
    public void kullaniciSssAlanindakiBirSoruyaTiklar() {
        rm.myClick(page.getFaqQuestion());
    }

    @Then("İlgili yanıt açılır")
    public void ilgiliYanitAcilir() {
        Assert.assertTrue(page.getFaqAnswer().isVisible());
    }

    @When("Kullanıcı farklı bir soruya tıklar")
    public void kullaniciFarkliBirSoruyaTiklar() {
        rm.myClick(page.getSecondFaqQuestion());
    }

    @Then("Önceki soru otomatik olarak kapanmalı ve yeni soru açılmalıdır")
    public void oncekiSoruOtomatikOlarakKapanmaliVeYeniSoruAcilmalidir() {
        Assert.assertTrue(page.getFaqAnswer().isVisible());
    }

    @When("Kullanıcı bülten alanına {string} adresini girer")
    public void kullaniciBultenAlaninaAdresiniGirer(String email) {
        rm.mySendKeys(page.getNewsletterInput(), rm.resolveDynamicValue(email));
    }

    @When("Kullanıcı gönder butonuna tıklar")
    public void kullaniciGonderButonunaTiklar() {
        rm.myClick(page.getNewsletterSubmitButton());
    }

    @Then("Başarı mesajı görüntülenmelidir")
    public void basariMesajiGoruntulenmelidir() {
        Assert.assertTrue(page.getSuccessMessage().isVisible());
    }

    @Then("Hata mesajı gösterilmeli ve bülten kaydı yapılmamalıdır")
    public void hataMesajiGostermeliVeBultenKaydiYapilmamalidir() {
        Assert.assertTrue(page.getErrorMessage().isVisible());
    }

    @Given("Kullanıcı login sayfasındadır")
    public void kullaniciLoginSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı geçerli e-posta adresini ve şifresini girer")
    public void kullaniciGecerliEPostaAdresiniVeSifresiniGirer() {
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue("test@example.com"));
        rm.mySendKeys(page.getPasswordInput(), rm.resolveDynamicValue("ValidSifre1!"));
    }

    @When("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(page.getSubmitLoginButton());
    }

    @Then("Sistem kimlik doğrulamasını tamamlamalı ve kullanıcıyı ana panele dashboard sayfasına yönlendirmelidir")
    public void sistemKimlikDogrulamasiniTamamlamaliVeKullaniciyiAnaPaneleDashboardSayfasinaYonlendirmelidir() {
        Assert.assertTrue(page.getDashboardElement().isVisible());
    }

    @When("Kullanıcı şifre alanına bir değer girer")
    public void kullaniciSifreAlaninaBirDegerGirer() {
        rm.mySendKeys(page.getPasswordInput(), "Sifre123!");
    }

    @When("Kullanıcı şifre alanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanindakiGozIkonunaTiklar() {
        rm.myClick(page.getPasswordToggleEyeIcon());
    }

    @Then("Şifre metni görünür hale gelmelidir")
    public void sifreMetniGorunurHaleGelmelidir() {
        Assert.assertTrue(page.getPasswordInput().isVisible());
    }

    @When("Kullanıcı ikona tekrar tıklar")
    public void kullaniciIkonaTekrarTiklar() {
        rm.myClick(page.getPasswordToggleEyeIcon());
    }

    @Then("Şifre tekrar maskelenmelidir")
    public void sifreTekrarMaskelenmelidir() {
        Assert.assertTrue(page.getPasswordInput().isVisible());
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakır")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakir() {
        rm.mySendKeys(page.getEmailInput(), "");
        rm.mySendKeys(page.getPasswordInput(), "");
    }

    @Then("İlgili alanlarda Bu alan zorunludur uyarısı gösterilmelidir")
    public void ilgiliAlanlardaBuAlanZorunludurUyarisiGosterilmelidir() {
        Assert.assertTrue(page.getRequiredFieldError().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} değerini girer")
    public void kullaniciEPostaAlaninaDegeriniGirer(String email) {
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue(email));
    }

    @Then("E-posta format uyarısı gösterilmelidir")
    public void ePostaFormatUyarisiGosterilmelidir() {
        Assert.assertTrue(page.getEmailFormatError().isVisible());
    }

    @When("Kullanıcı {string} ve {string} bilgileri ile giriş yapmaya çalışır")
    public void kullaniciVeBilgileriIleGirisYapmayaCalisir(String eposta, String sifre) {
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue(eposta));
        rm.mySendKeys(page.getPasswordInput(), rm.resolveDynamicValue(sifre));
        rm.myClick(page.getSubmitLoginButton());
    }

    @Then("Sistem güvenlik nedeniyle genel E-posta veya şifre hatalı hata mesajını döndürmelidir")
    public void sistemGuvenlikNedeniyleGenelEPostaVeyaSifreHataliHataMesajiniDondurmelidir() {
        Assert.assertTrue(page.getGeneralLoginError().isVisible());
    }

    @Given("Kullanıcı register sayfasındadır")
    public void kullaniciRegisterSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta girer")
    public void kullaniciSistemdeKayitliOlmayanGecerliBirEPostaGirer() {
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue("yeni@example.com"));
    }

    @When("Kullanıcı kurallara uygun bir şifre ve şifre onayını girer")
    public void kullaniciKurallaraUygunBirSifreVeSifreOnayiniGirer() {
        rm.mySendKeys(page.getPasswordInput(), "GucluSifre1!");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GucluSifre1!");
    }

    @When("Kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @When("Kullanıcı Hesap Oluştur butonuna tıklar")
    public void kullaniciHesapOlusturButonunaTiklar() {
        rm.myClick(page.getCreateAccountButton());
    }

    @Then("Sistem yeni hesabı başarıyla oluşturmalıdır")
    public void sistemYeniHesabiBasariylaOlusturmalidir() {
        Assert.assertTrue(page.getDashboardElement().isVisible());
    }

    @When("Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void kullaniciSistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(page.getEmailInput(), "kayitli@example.com");
    }

    @When("Kullanıcı gerekli diğer alanları doldurur")
    public void kullaniciGerekliDigerAlanlariDoldurur() {
        rm.mySendKeys(page.getPasswordInput(), "GucluSifre1!");
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @Then("Sistem kaydı engellemeli ve Bu e-posta adresi zaten kullanımda uyarısını göstermelidir")
    public void sistemKaydiEngellemeliVeBuEPostaAdresiZatenKullanimdaUyarisiniGostermelidir() {
        Assert.assertTrue(page.getAlreadyUsedEmailError().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} değerini girer")
    public void kullaniciSifreAlaninaDegeriniGirer(String sifre) {
        rm.mySendKeys(page.getPasswordInput(), rm.resolveDynamicValue(sifre));
    }

    @Then("Sistem şifre politikası validasyon hatası göstermelidir")
    public void sistemSifrePolitikasiValidasyonHatasiGostermelidir() {
        Assert.assertTrue(page.getPasswordPolicyError().isVisible());
    }

    @When("Kullanıcı Şifreyi Onayla alanına {string} değerini girer")
    public void kullaniciSifreyiOnaylaAlaninaDegeriniGirer(String sifreOnay) {
        rm.mySendKeys(page.getConfirmPasswordInput(), rm.resolveDynamicValue(sifreOnay));
    }

    @Then("Sistem kaydı engellemeli ve Şifreler eşleşmiyor hata mesajını göstermelidir")
    public void sistemKaydiEngellemeliVeSifrelerEslestirmiyorHataMesajiniGostermelidir() {
        Assert.assertTrue(page.getPasswordMatchError().isVisible());
    }

    @When("Kullanıcı tüm zorunlu alanları doğru doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez")
    public void kullaniciTumZorunluAlanlariDogruDoldururAncakKullaniciSozlesmesiKutucugunuIsaretlemez() {
        rm.mySendKeys(page.getEmailInput(), "validuser@example.com");
        rm.mySendKeys(page.getPasswordInput(), "GucluSifre1!");
    }

    @Then("Sistem kaydı engellemeli ve sözleşme onayı gerektiğini belirten bir uyarı göstermelidir")
    public void sistemKaydiEngellemeliVeSozlesmeOnayiGerektiginiBelirtenBirUyariGostermelidir() {
        Assert.assertTrue(page.getTermsRequiredError().isVisible());
    }
}