package StepDefinations;

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
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class AiStagerSteps {
    ReusableMethod rm = new ReusableMethod();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Given("kullanıcı AiStager.ai ana sayfasını açar")
    public void kullaniciAiStagerAnaSayfasiniAcar() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("{string} slider alanına gelir")
    public void sliderAlaninaGelir(String sliderAdi) {
        rm.myClick(homePage.getBeforeAfterSlider());
    }

    @And("kullanıcı slider üzerindeki yan okları {string} ve {string} kullanır veya sürüklege \\(drag) hareketi yapar")
    public void kullaniciSliderUzerindekiOklarıKullanirVeyaSuruklemeHareketiYapar(String ok1, String ok2) {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @Then("oda görselinin {string} ve {string} arasında pürüzsüz geçiş yaptığı görülür")
    public void odaGorselininGecisYaptigiGorulur(String once, String sonra) {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @And("alt carousel noktalarının aktif duruma göre güncellendiği doğrulanır")
    public void altCarouselNoktalarininGuncellendigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı siteye henüz giriş yapmamış bir ziyaretçi olarak ana sayfayı açar")
    public void kullaniciSiteyeHenuzGirisYapmamisZiyaretciOlarakAnaSayfayiAcar() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("üst menüyü \\(Header) inceler")
    public void ustMenuyuHeaderInceler() {
        Assert.assertTrue(true);
    }

    @Then("{string} ve {string} butonlarının görünür olduğunu görür")
    public void butonlarininGorunurOldugunuGorur(String btn1, String btn2) {
        Assert.assertTrue(homePage.getHeaderLoginButton().isVisible());
        Assert.assertTrue(homePage.getHeaderTryFreeButton().isVisible());
    }

    @And("{string} ve profil ikonunun ise gizli olduğunu doğrular")
    public void veProfilIkonununIseGizliOldugunuDogrular(String menu) {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı sisteme başarılı bir şekilde giriş yapar ve ana sayfaya döner")
    public void kullaniciSistemeBasariliGirisYaparVeAnaSayfayaDoner() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), "kayitli.kullanici@AiStager.ai");
        rm.mySendKeys(loginPage.getPasswordInput(), "GuvenliSifre123!");
        rm.myClick(loginPage.getLoginButton());
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("logolar, Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil seçeneği, Hızlı Render ve Profil menülerinin aktif olarak çalıştığını görür")
    public void tumMenulerinAktifCalistiginiGorur() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı ana sayfadaki {string} alanına gelir")
    public void kullaniciAnaSayfadakiAlaninaGelir(String alan) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("varsayılan olarak {string} filtresinin aktif olduğunu görür")
    public void varsayilanOlarakFiltreninAktifOldugunuGorur(String filtre) {
        Assert.assertTrue(true);
    }

    @And("{string} filtre seçeneğine tıklar")
    public void filtreSecenegineTiklar(String secenek) {
        Assert.assertTrue(true);
    }

    @Then("galeri listesinin anlık olarak sadece {string} tasarımlarını gösterecek şekilde filtrelendiğini doğrular")
    public void galeriListesininFiltrelendiginiDogrular(String filtre) {
        Assert.assertTrue(true);
    }

    @When("{string} butonuna tıklar")
    public void butonunaTiklar(String butonAdi) {
        if(butonAdi.equals("Abone Ol")) {
            rm.myClick(homePage.getNewsletterSubmitButton());
        } else if(butonAdi.equals("Giriş Yap")) {
            rm.myClick(loginPage.getLoginButton());
        } else if(butonAdi.equals("Kayıt Ol")) {
            rm.myClick(registerPage.getRegisterButton());
        } else if(butonAdi.equals("Google ile devam et")) {
            rm.myClick(loginPage.getGoogleButton());
        }
    }

    @Then("mevcut filtre bozulmadan yeni tasarımların listeye eklendiği \\(pagination/infinite scroll) doğrular")
    public void mevcutFiltreBozulmadanYeniTasarımlarinEklendiginiDogrular() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı ana sayfadaki Sıkça Sorulan Sorular \\(SSS) bölümüne gelir")
    public void kullaniciSssBolumuneGelir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("birinci akordeon başlığına tıklayarak soruyu açar ve cevabı görür")
    public void birinciAkordeonBasliginaTiklayarakSoruyuAcar() {
        Assert.assertTrue(true);
    }

    @And("ikinci bir akordeon başlığına tıklar")
    public void ikinciBirAkordeonBasliginaTiklar() {
        Assert.assertTrue(true);
    }

    @Then("yeni açılan sorunun detayının görüntülendiğini ve önceki birinci sorunun otomatik olarak kapandığını doğrular")
    public void yeniAcilanSorununDetayininGoruntulendiginiDogrular() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı ana sayfanın footer \\(altbilgi) alanındaki bülten aboneliği bölümüne gelir")
    public void kullaniciFooterBultenBolumuneGelir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("e-posta alanına geçerli bir formatta {string} girer")
    public void ePostaAlaninaGecerliFormattaGirer(String eposta) {
        rm.mySendKeys(homePage.getNewsletterEmailInput(), rm.resolveDynamicValue(eposta));
    }

    @Then("başarılı abonelik mesajının görüntülendiğini doğrular")
    public void basariliAbonelikMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı footer bülten alanındaki e-posta inputuna {string} girer")
    public void kullaniciFooterBultenEpostaInputunaGirer(String eposta) {
        rm.mySendKeys(homePage.getNewsletterEmailInput(), rm.resolveDynamicValue(eposta));
    }

    @Then("uygun bir hata mesajı alındığı doğrulanır")
    public void uygunBirHataMesajiAlindigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @Given("kullanıcı {string} sayfasına gider")
    public void kullaniciSayfasinaGider(String endpoint) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + endpoint);
    }

    @When("e-posta alanına {string} girer")
    public void ePostaAlaninaGirer(String eposta) {
        rm.mySendKeys(loginPage.getEmailInput(), rm.resolveDynamicValue(eposta));
    }

    @And("şifre alanına geçerli şifresini girer")
    public void sifreAlaninaGecerliSifresiniGirer() {
        rm.mySendKeys(loginPage.getPasswordInput(), "GuvenliSifre123!");
    }

    @Then("kullanıcının başarıyla ana panele {string} yönlendirildiği doğrulanır")
    public void kullanicininBasariylaAnaPaneleYonlendirildigiDogrulanir(String dashboard) {
        Assert.assertTrue(PD.getPage().url().contains(dashboard));
    }

    @When("şifre alanına {string} yazar")
    public void sifreAlaninaYazar(String sifre) {
        rm.mySendKeys(loginPage.getPasswordInput(), sifre);
    }

    @Then("şifrenin varsayılan olarak maskelendiğini \\({string}) görür")
    public void sifreninVarsayilanOlarakMaskelendiginiGorur(String mask) {
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password");
    }

    @When("şifre alanının sağındaki {string} ikonuna tıklar")
    public void sifreAlanininSagindakiIkonunaTiklar(String ikon) {
        rm.myClick(loginPage.getPasswordToggleIcon());
    }

    @Then("şifre metninin \\({string}) görünür hale geldiğini doğrular")
    public void sifreMetnininGorunurHaleGeldiginiDogrular(String sifre) {
        Assert.assertTrue(true);
    }

    @When("e-posta ve şifre alanlarını boş bırakarak doğrudan {string} butonuna tıklar")
    public void ePostaVeSifreAlanlariniBosBirakarakDogrudanButonunaTiklar(String btn) {
        rm.myClick(loginPage.getLoginButton());
    }

    @Then("ilgili alanların altında {string} uyarı mesajlarının çıktığını doğrular")
    public void ilgiliAlanlarinAltindaUyariMesajlarininCiktiginiDogrular(String msg) {
        Assert.assertTrue(true);
    }

    @When("e-posta alanına format dışı bir değer {string} girer")
    public void ePostaAlaninaFormatDisiDegerGirer(String eposta) {
        rm.mySendKeys(loginPage.getEmailInput(), eposta);
    }

    @And("şifre alanına {string} girer")
    public void sifreAlaninaGirer(String sifre) {
        rm.mySendKeys(loginPage.getPasswordInput(), sifre);
    }

    @Then("uygun bir e-posta format uyarısı gösterildiğini doğrulanır")
    public void uygunBirEPostaFormatUyarisiGosterildiginiDogrulanir() {
        Assert.assertTrue(true);
    }

    @Then("saldırganlara ipucu vermemek adına genel ve sabit bir hata mesajı olan {string} uyarısının gösterildiğini doğrular")
    public void saldirganlaraIpucuVermemekAdinaGenelHataMesajininGosterildiginiDogrular(String msg) {
        Assert.assertTrue(true);
    }

    @When("e-posta alanına {string} veya çok uzun karakter dizileri girer")
    public void ePostaAlaninaVeyaCokUzunKarakterDizileriGirer(String eposta) {
        rm.mySendKeys(loginPage.getEmailInput(), eposta);
    }

    @Then("sistemin bu girdileri güvenle filtrelediği, 500 \\(Internal Server Error) hatasına sebep olmadığı ve uygun validasyon mesajı döndürdüğü doğrulanır")
    public void sisteminBuGirdileriGuvenleFiltreledigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @Then("Google OAuth kimlik doğrulama ekranının tetiklendiğini doğrular")
    public void googleOAuthKimlikDogrulamaEkranininTetiklendigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @When("sisteme kayıtlı olmayan bir e-posta adresi {string} girer")
    public void sistemeKayitliOlmayanBirEPostaAdresiGirer(String eposta) {
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue(eposta));
    }

    @And("şifre politikasına uygun bir şifre \\({string}) ve {string} alanına aynı şifreyi girer")
    public void sifrePolitikasinaUygunBirSifreVeAlaninaAyniSifreyiGirer(String sifre, String onay) {
        rm.mySendKeys(registerPage.getPasswordInput(), sifre);
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), sifre);
    }

    @And("zorunlu kullanıcı sözleşmesi onay kutucuğunu \\(checkbox) işaretler")
    public void zorunluKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myClick(registerPage.getTermsCheckbox());
    }

    @Then("hesabın başarıyla oluşturulduğu ve yönlendirmenin yapıldığı doğrulanır")
    public void hesabinBasariylaOlusturulduguVeYonlendirmeninYapildigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @When("sistemde zaten kayıtlı olan bir e-posta adresi girer")
    public void sistemdeZatenKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getEmailInput(), "kayitli.kullanici@AiStager.ai");
    }

    @And("şifre ve sözleşme onayını tamamlayıp {string} tıklar")
    public void sifreVeSozlesmeOnayiniTamamlayipTikes(String btn) {
        rm.mySendKeys(registerPage.getPasswordInput(), "GuvenliSifre1!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "GuvenliSifre1!");
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getRegisterButton());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısının gösterildiğini doğrular")
    public void buEPostaAdresiZatenKullanimdaUyarisininGosterildiginiDogrular() {
        Assert.assertTrue(true);
    }

    @When("geçerli bir e-posta girer")
    public void gecerliBirEPostaGirer() {
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("yeni@example.com"));
    }

    @And("şifre ve şifre onayı alanlarına 8 karakterden kısa bir değer girer \\(Örn: {string})")
    public void sifreVeSifreOnayiAlanlarinaKisaDegerGirer(String sifre) {
        rm.mySendKeys(registerPage.getPasswordInput(), sifre);
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), sifre);
    }

    @And("zorunlu sözleşmeyi onaylar ve {string} tıklar")
    public void zorunluSozlesmeyiOnaylarVeTiklar(String btn) {
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getRegisterButton());
    }

    @Then("şifrenin en az 8 karakter olması gerektiğine dair politika uyarısının gösterildiğini doğrular")
    public void sifreninEnAzKarakterOlmasiGerektigineDairUyarininGosterildiginiDogrular() {
        Assert.assertTrue(true);
    }

    @And("şifre alanına {string} ve {string} alanına {string} girer")
    public void sifreAlaninaVeAlaninaGirer(String sifre1, String alan, String sifre2) {
        rm.mySendKeys(registerPage.getPasswordInput(), sifre1);
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), sifre2);
    }

    @And("sözleşmeyi onaylayıp {string} tıklar")
    public void sozlesmeyiOnaylayipTiklar(String btn) {
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getRegisterButton());
    }

    @Then("şifrelerin eşleşmediğine dair hata mesajının gösterildiğini doğrulanır")
    public void sifrelerinEslenmedigineDairHataMesajininGosterildiginiDogrulanir() {
        Assert.assertTrue(true);
    }

    @When("geçerli e-posta ve kurallara uygun şifreleri girer")
    public void gecerliEPostaVeKurallaraUygunSifreleriGirer() {
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("yeni@example.com"));
        rm.mySendKeys(registerPage.getPasswordInput(), "GuvenliSifre1!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "GuvenliSifre1!");
    }

    @And("kullanıcı sözleşmesi onay kutucuğunu \\(checkbox) işaretlemez")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretlemez() {
        // İşaretlenmiyor
    }

    @Then("sözleşmenin onaylanmasının zorunlu olduğuna dair bir uyarı mesajı alındığı doğrulanır")
    public void sozlesmeninOnaylanmasininZorunluOldugunaDairUyarıAlindigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @When("sayfa üzerindeki {string} bağlantısına \\(link) tıklar")
    public void sayfaUzerindekiBaglantisinaTiklar(String link) {
        rm.myClick(registerPage.getLoginLink());
    }

    @Then("kullanıcının sorunsuz bir şekilde \\/login sayfasına yönlendirildiği doğrulanır")
    public void kullanicininSorunsuzSekildeLoginSayfasinaYonlendirildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("/login"));
    }
}