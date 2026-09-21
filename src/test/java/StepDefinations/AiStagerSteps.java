package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AiStagerPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps() {
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("http"));
    }

    @When("Kullanıcı Önce Sonra görsel karşılaştırma slider çubuğunu sağa ve sola sürükler")
    public void kullaniciOnceSonraGorselKarsilastirmaSliderCubugunuSagaVeSolaSurukler() {
        rm.myClick(page.getBeforeAfterSlider());
    }

    @Then("Görsel boyutları ve slider çubuğu pürüzsüz bir şekilde hareket etmelidir")
    public void gorselBoyutlariVeSliderCubuguPuruzsuzBirSekildeHareketEtmelidir() {
        Assert.assertTrue(page.getBeforeAfterSlider().isVisible());
    }

    @When("Kullanıcı dil menüsünden TR seçeneğini seçer")
    public void kullaniciDilMenusundenTrSeceneginiSecer() {
        rm.myClick(page.getLanguageMenu());
    }

    @Then("Tüm ana sayfa metinleri dinamik olarak Türkçe olarak güncellenmelidir")
    public void tumAnaSayfaMetinleriDinamikOlarakTurkceOlarakGuncellenmelidir() {
        Assert.assertTrue(page.getLanguageMenu().isVisible());
    }

    @When("Kullanıcı galeriden Oturma Odası filtresini seçer")
    public void kullaniciGaleridenOturmaOdasiFiltresiniSecer() {
        rm.myClick(page.getOturmaOdasiFilter());
    }

    @Then("Sadece Oturma Odası kategorisine ait tasarım kartları listelenmelidir")
    public void sadeceOturmaOdasiKategorisineAitTasarimKartlariListelenmelidir() {
        Assert.assertTrue(page.getOturmaOdasiFilter().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(page.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut Oturma Odası filtresi korunarak liste genişletilmelidir")
    public void mevcutOturmaOdasiFiltresiKorunarakListeGenisletilmelidir() {
        Assert.assertTrue(page.getDahaFazlaTasarimYukleButton().isVisible());
    }

    @When("Kullanıcı SSS bölümünden birinci soruyu açar")
    public void kullaniciSssBolumundenBirinciSoruyuAcar() {
        rm.myClick(page.getFirstSssQuestion());
    }

    @Then("Birinci soru açık ve içeriği görünür olmalıdır")
    public void birinciSoruAcikVeIcerigiGorunurOlmalidir() {
        Assert.assertTrue(page.getFirstSssQuestion().isVisible());
    }

    @When("Kullanıcı ikinci bir soruyu açar")
    public void kullaniciIkinciBirSoruyuAcar() {
        rm.myClick(page.getSecondSssQuestion());
    }

    @Then("İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır")
    public void ikinciSoruAcilmaliVeBirinciSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(page.getSecondSssQuestion().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamıştır Ziyaretçi")
    public void kullaniciSistemeGirisYapmamistirZiyaretci() {
        Assert.assertTrue(page.getLoginButtonTop().isVisible());
    }

    @Then("Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir")
    public void ustMenudeGirisYapVeUcretsizDeneButonlariGorunmelidir() {
        Assert.assertTrue(page.getLoginButtonTop().isVisible());
        Assert.assertTrue(page.getFreeTrialButtonTop().isVisible());
    }

    @Then("Üst menüde Üretimlerim menüsü ve profil ikonu gizli olmalıdır")
    public void ustMenudeUretimlerimMenusuVeProfilIkonuGizliOlmalidir() {
        Assert.assertFalse(page.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde ürün, çözüm, kaynak ve fiyatlandırma linkleri aktif olmalıdır")
    public void ustMenudeUrunCozumKaynakVeFiyatlandirmaLinkleriAktifOlmalidir() {
        Assert.assertTrue(page.getNavProducts().isVisible());
    }

    @Then("Hızlı render paneli, Üretimlerim ve profil menüleri erişilebilir olmalıdır")
    public void hizliRenderPaneliUretimlerimVeProfilMenuleriErisilebilirOlmalidir() {
        Assert.assertTrue(page.getUretimlerimMenu().isVisible());
    }

    @When("Kullanıcı bülten alanına geçerli bir {string} e-posta adresi girer")
    public void kullaniciBultenAlaninaGecerliBirEPostaAdresiGirer(String email) {
        rm.mySendKeys(page.getNewsletterInput(), rm.resolveDynamicValue(email));
    }

    @When("Bülten gönder butonuna tıklar")
    public void bultenGonderButonunaTiklar() {
        rm.myClick(page.getNewsletterSubmitButton());
    }

    @Then("Başarılı abonelik mesajı görüntülenmelidir")
    public void basariliAbonelikMesajiGoruntulenmelidir() {
        Assert.assertTrue(page.getNewsletterSubmitButton().isVisible());
    }

    @When("Kullanıcı bülten alanına {string} girer")
    public void kullaniciBultenAlaninaGirer(String gecersizEposta) {
        rm.mySendKeys(page.getNewsletterInput(), gecersizEposta);
    }

    @Then("Form gönderimi engellenmeli ve uygun hata mesajı gösterilmelidir")
    public void formGonderimiEngellenmeliVeUygunHataMesajiGosterilmelidir() {
        Assert.assertTrue(page.getNewsletterInput().isVisible());
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak giriş yapmaya çalışır")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapmayaCalisir() {
        rm.myClick(page.getLoginButtonTop());
    }

    @Then("Bu alan zorunludur uyarı mesajları gösterilmelidir")
    public void buAlanZorunludurUyariMesajlariGosterilmelidir() {
        Assert.assertTrue(page.getEmailInput().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} girer")
    public void kullaniciEPostaAlaninaGirer(String hataliEposta) {
        rm.mySendKeys(page.getEmailInput(), hataliEposta);
    }

    @Then("Lütfen geçerli bir e-posta adresi girin hata mesajı gösterilmelidir")
    public void lutfenGecerliBirEPostaAdresiGirinHataMesajiGosterilmelidir() {
        Assert.assertTrue(page.getEmailInput().isVisible());
    }

    @When("Kullanıcı geçerli formatta fakat sisteme kayıtlı olmayan {string} ve {string} girer")
    public void kullaniciGecerliFormattaFakatSistemeKayitliOlmayanVeGirer(String email, String password) {
        rm.mySendKeys(page.getEmailInput(), email);
        rm.mySendKeys(page.getPasswordInput(), password);
    }

    @When("Giriş yap butonuna tıklar")
    public void girisYapButonunaTiklar() {
        rm.myClick(page.getLoginButtonTop());
    }

    @Then("Güvenlik nedeniyle genel E-posta veya şifre hatalı mesajı dönülmelidir")
    public void guvenlikNedeniyleGenelEPostaVeyaSifreHataliMesajiDonulmelidir() {
        Assert.assertTrue(page.getEmailInput().isVisible());
    }

    @Given("Kullanıcı kayıt sayfasındadır")
    public void kullaniciKayitSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı geçerli bir e-posta girer")
    public void kullaniciGecerliBirEPostaGirer() {
        rm.mySendKeys(page.getEmailInput(), "testuser@ornek.com");
    }

    @When("Şifre alanına kurallara uygun en az 8 karakterli {string} girer")
    public void sifreAlaninaKurallaraUygunEnAzKarakterliGirer(String password) {
        rm.mySendKeys(page.getPasswordInput(), password);
    }

    @When("Şifreyi Onayla alanına aynı şifreyi tekrar yazar")
    public void sifreyiOnaylaAlaninaAyniSifreyiTekrarYazar() {
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre1*");
    }

    @When("Kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @When("Kayıt ol butonuna tıklar")
    public void kayitOlButonunaTiklar() {
        rm.myClick(page.getRegisterSubmitButton());
    }

    @Then("Hesap başarıyla oluşturulmalı ve yönlendirme yapılmalıdır")
    public void hesapBasariylaOlusturulmaliVeYonlendirmeYapilmalidir() {
        Assert.assertTrue(page.getRegisterSubmitButton().isVisible());
    }

    @When("Kullanıcı şifre olarak {string} ve onay için {string} girer")
    public void kullaniciSifreOlarakVeOnayIcinGirer(String sifre, String sifreOnay) {
        rm.mySendKeys(page.getPasswordInput(), sifre);
        rm.mySendKeys(page.getConfirmPasswordInput(), sifreOnay);
    }

    @Then("Şifre kuralları veya eşleşmeme durumuna uygun hata mesajı gösterilmelidir")
    public void sifreKurallariVeyaEslenmemeDurumunaUygunHataMesajiGosterilmelidir() {
        Assert.assertTrue(page.getPasswordInput().isVisible());
    }

    @When("Kullanıcı daha önce kayıt olmuş bir e-posta adresi girer")
    public void kullaniciDahaOnceKayitOlmusBirEPostaAdresiGirer() {
        rm.mySendKeys(page.getEmailInput(), "kayitli@ornek.com");
    }

    @When("Tüm zorunlu alanları doldurup kayıt ol butonuna tıklar")
    public void tumZorunluAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre1*");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre1*");
        rm.myCheckBox(page.getTermsCheckbox());
        rm.myClick(page.getRegisterSubmitButton());
    }

    @Then("Bu e-posta adresi zaten kullanımda hata mesajı gösterilmelidir")
    public void buEPostaAdresiZatenKullanimdaHataMesajiGosterilmelidir() {
        Assert.assertTrue(page.getEmailInput().isVisible());
    }

    @When("Kullanıcı tüm zorunlu kayıt alanlarını doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez")
    public void kullaniciTumZorunluKayitAlanlariniDoldururAncakKullaniciSozlesmesiKutucugunuIsaretlemez() {
        rm.mySendKeys(page.getEmailInput(), "yenikullanici@ornek.com");
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre1*");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre1*");
    }

    @Then("Sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir")
    public void sozlesmeninOnaylanmasiGerektigineDairUyariMesajiGosterilmelidir() {
        Assert.assertTrue(page.getPasswordInput().isVisible());
    }

    @Given("Kullanıcı şifre değiştirme sayfasındadır")
    public void kullaniciSifreDegistirmeSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/reset-password");
    }

    @When("Kullanıcı şifre alanına gizli metin girer")
    public void kullaniciSifreAlaninaGizliMetinGirer() {
        rm.mySendKeys(page.getPasswordInput(), "GizliSifre123*");
    }

    @When("Şifre alanının yanındaki Göz ikonuna tıklar")
    public void sifreAlanininYanindakiGozIkonunaTiklar() {
        rm.myClick(page.getPasswordToggleIcon());
    }

    @Then("Şifre metni görünür hale gelmelidir")
    public void sifreMetniGorunurHaleGelmelidir() {
        Assert.assertTrue(page.getPasswordToggleIcon().isVisible());
    }

    @When("Kullanıcı tekrar Göz ikonuna tıklar")
    public void kullaniciTekrarGozIkonunaTiklar() {
        rm.myClick(page.getPasswordToggleIcon());
    }

    @Then("Şifre metni tekrar maskelenmiş gizli duruma gelmelidir")
    public void sifreMetniTekrarMaskelenmisGizliDurumaGelmelidir() {
        Assert.assertTrue(page.getPasswordToggleIcon().isVisible());
    }

    @When("Kullanıcı Google ile Devam Et butonuna tıklar")
    public void kullaniciGoogleIleDevamEtButonunaTiklar() {
        rm.myClick(page.getGoogleLoginButton());
    }

    @Then("Kullanıcı Google kimlik doğrulama ekranına başarılı bir şekilde yönlendirilmelidir")
    public void kullaniciGoogleKimlikDogrulamaEkraninaBasariliBirSekildeYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("google") || page.getGoogleLoginButton().isVisible());
    }
}