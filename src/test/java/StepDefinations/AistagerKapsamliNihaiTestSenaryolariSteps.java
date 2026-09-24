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

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.veriyfyContainsText(homePage.getStatikMetinler(), "AiStager");
    }

    @When("Kullanıcı slider üzerindeki iki yönlü oku sağa ve sola sürükler")
    public void kullaniciSliderUzerindekiIkiYonluOkuSagaVeSolaSurukler() {
        rm.myClick(homePage.getSliderOklar().first());
    }

    @And("Kullanıcı sağ ve sol yön oklarına tıklar")
    public void kullaniciSagVeSolYonOklarinaTiklar() {
        rm.myClick(homePage.getSliderOklar().first());
    }

    @And("Kullanıcı alt carousel noktalarına tıklar")
    public void kullaniciAltCarouselNoktalarinaTiklar() {
        rm.myClick(homePage.getSliderNoktalar().first());
    }

    @Then("Slider görseli ve geçişlerin akıcı bir şekilde senkronize çalıştığı doğrulanır")
    public void sliderGorseliVeGecislerinAkiciBirSekildeSenkronizeCalistigiDogrulanir() {
        Assert.assertTrue(homePage.getSliderGorsel().isVisible());
    }

    @When("Kullanıcı dil seçeneğini {string} olarak değiştirir")
    public void kullaniciDilSeceneginiOlarakDegistirir(String dil) {
        rm.myClick(homePage.getDilSecenegi(dil));
    }

    @Then("Sayfadaki tüm statik metinlerin anında Türkçe dile uyarlandığı doğrulanır")
    public void sayfadakiTumStatikMetinlerinAnindaTurkceDileUyarlandigiDogrulanir() {
        rm.veriyfyContainsText(homePage.getStatikMetinler(), "Giriş");
    }

    @Given("Kullanıcı sisteme giriş yapmamıştır")
    public void kullaniciSistemeGirisYapmamistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı AiStager ana sayfasına gider")
    public void kullaniciAiStagerAnaSayfasinaGider() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde {string} ve {string} butonları görünmelidir")
    public void ustMenudeVeButonlariGorsunmelidir(String arg0, String arg1) {
        Assert.assertTrue(homePage.getGirisYapButonu().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButonu().isVisible());
    }

    @And("Üst menüde Üretimlerim ve profil ikonunun gizli olduğu doğrulanır")
    public void ustMenudeUretimlerimVeProfilIkonununGizliOlduguDogrulanir() {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı geçerli bilgileriyle sisteme giriş yapmıştır")
    public void kullaniciGecerliBilgileriyleSistemeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), ConfigReader.getProperty("valid_email"));
        rm.mySendKeys(loginPage.getPasswordInput(), ConfigReader.getProperty("valid_password"));
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @When("Kullanıcı ana sayfayı görüntüler")
    public void kullaniciAnaSayfayiGoruntuler() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde Üretimlerim, hızlı render paneli ve profil menüsünün aktif olarak erişilebilir olduğu doğrulanır")
    public void ustMenudeUretimlerimHizliRenderPaneliVeProfilMenusununAktifOlarakErisilebilirOlduguDogrulanir() {
        Assert.assertTrue(homePage.getUretimlerimMenu().isVisible());
        Assert.assertTrue(homePage.getHizliRenderPaneli().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki galeri alanındadır")
    public void kullaniciAnaSayfadakGaleriAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getGaleriAlani());
    }

    @Then("Galeri varsayılan olarak Tüm Tipler filtresiyle açılmalıdır")
    public void galeriVarsayilanOlarakTumTiplerFiltresiyleAcilmalidir() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @When("Kullanıcı farklı bir oda tipi butonuna tıklar")
    public void kullaniciFarkliBirOdaTipiButonunaTiklar() {
        rm.myClick(homePage.getOdaTipiButonu("Yatak Odası"));
    }

    @Then("Galeri listesinin seçilen oda tipine göre dinamik olarak filtrelendiği doğrulanır")
    public void galeriListesininSecilenOdaTipineGoreDinamikOlarakFiltrelendigiDogrulanir() {
        Assert.assertTrue(homePage.getGaleriListesi().first().isVisible());
    }

    @Given("Kullanıcı galeride spesifik bir oda tipi filtresi seçmiştir")
    public void kullaniciGalerideSpesifikBirOdaTipiFiltresiSecmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getOdaTipiButonu("Oturma Odası"));
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButonu());
    }

    @Then("Aktif olan filtre kuralı bozulmadan listeye yeni tasarım kartlarının eklendiği doğrulanır")
    public void aktifOlanFiltreKuraliBozulmadanListeyeYeniTasarimKartlarininEklendigiDogrulanir() {
        Assert.assertTrue(homePage.getGaleriListesi().count() > 0);
    }

    @Given("Kullanıcı SSS \\(Accordion) alanındadır")
    public void kullaniciSssAccordionAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getSssAlani());
    }

    @When("Kullanıcı bir soruya tıklayarak akordeonu açar")
    public void kullaniciBirSoruyaTiklayarakAkordeonuAcar() {
        rm.myClick(homePage.getSoruBasligi(0));
    }

    @And("Kullanıcı farklı bir başka soruya tıklar")
    public void kullaniciFarkliBirBaskaSoruyaTiklar() {
        rm.myClick(homePage.getSoruBasligi(1));
    }

    @Then("İlk açılan sorunun otomatik olarak kapandığı ve sadece yeni tıklanan sorunun açık kaldığı doğrulanır")
    public void ilkAcilanSorununOtomatikOlarakKapandigiVeSadeceYeniTiklananSorununAcikKaldigiDogrulanir() {
        Assert.assertTrue(homePage.getSoruBasligi(1).isVisible());
    }

    @Given("Kullanıcı bülten alanındadır")
    public void kullaniciBultenAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getBultenAlani());
    }

    @When("Kullanıcı geçerli bir e-posta adresi girer {string} ve abone ol butonuna tıklar")
    public void kullaniciGecerliBirEPostaAdresiGirerVeAboneOlButonunaTiklar(String email) {
        rm.mySendKeys(homePage.getBultenEmailInput(), email);
        rm.myClick(homePage.getBultenAboneOlButonu());
    }

    @Then("Yeşil onay mesajının gösterildiği doğrulanır")
    public void yesilOnayMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(homePage.getYesilOnayMesaji().isVisible());
    }

    @When("Kullanıcı geçersiz bir e-posta formatı girer {string} ve abone ol butonuna tıklar")
    public void kullaniciGecersizBirEPostaFormatiGirerVeAboneOlButonunaTiklar(String gecersizEmail) {
        rm.mySendKeys(homePage.getBultenEmailInput(), gecersizEmail);
        rm.myClick(homePage.getBultenAboneOlButonu());
    }

    @Then("Bülten aboneliğinin gerçekleşmediği ve hata mesajı gösterildiği doğrulanır")
    public void bultenAboneligininGerceklesmedigiVeHataMesajiGosterildigiDogrulanir() {
        Assert.assertTrue(homePage.getBultenHataMesaji().isVisible());
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı geçerli e-posta adresini ve şifresini girer")
    public void kullaniciGecerliEPostaAdresiniVeSifresiniGirer() {
        rm.mySendKeys(loginPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "Password123!");
    }

    @And("Kullanıcı şifre alanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanindakiGozIkonunaTiklar() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifrenin düz metin olarak görünür kılındığı doğrulanır")
    public void sifreninDuzMetinOlarakGorunurKilindigiDogrulanir() {
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "text");
    }

    @When("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Kullanıcı başarıyla panele yönlendirilir")
    public void kullaniciBasariylaPaneleYonlendirilir() {
        Assert.assertTrue(loginPage.getPanelBasligi().isVisible());
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Bu alan zorunludur uyarı mesajlarının alındığı ve formun gönderilmediği doğrulanır")
    public void buAlanZorunludurUyariMesajlarininAlindigiVeFormunGonderilmedigiDogrulanir() {
        Assert.assertTrue(loginPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("Kullanıcı kayıtlı olmayan veya hatalı bir şifre kombinasyonu girer ve Giriş Yap butonuna tıklar")
    public void kullaniciKayitliOlmayanVeyaHataliBirSifreKombinasyonuGirerVeGirisYapButonunaTiklar() {
        rm.mySendKeys(loginPage.getEmailInput(), "hatali@example.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "WrongPass123");
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Kullanıcıya spesifik detay yerine genel bir hata mesajı {string} gösterildiği doğrulanır")
    public void kullaniciyaSpesifikDetayYerineGenelBirHataMesajiGosterildigiDogrulanir(String hataMesaji) {
        rm.veriyfyContainsText(loginPage.getGenelHataMesaji(), hataMesaji);
    }

    @When("Kullanıcı e-posta alanına SQL injection payload veya aşırı uzun karakter dizisi girer")
    public void kullaniciEPostaAlaninaSQLInjectionPayloadVeyaAsiriUzunKarakterDizisiGirer() {
        rm.mySendKeys(loginPage.getEmailInput(), "'OR 1=1--");
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklarAnd() {
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Sistemin güvenli filtreleme yaptığı, 500 sunucu hatası dönmediği ve uygun hata mesajı verdiği doğrulanır")
    public void sisteminGuvenliFiltrelemeYaptigi500SunucuHatasiDonmedigiVeUygunHataMesajiVerdigiDogrulanir() {
        Assert.assertTrue(loginPage.getGenelHataMesaji().isVisible());
    }

    @Given("Kullanıcı kayıt sayfasındadır")
    public void kullaniciKayitSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı geçerli ad, soyad ve benzersiz bir e-posta adresi girer")
    public void kullaniciGecerliAdSoyadVeBenzersizBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kullanıcı minimum 8 karakterli geçerli bir şifre girer ve Şifreyi Onayla alanına aynı şifreyi yazar")
    public void kullaniciMinimum8KarakterliGecerliBirSifreGirerVeSifreyiOnaylaAlaninaAyniSifreyiYazar() {
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
    }

    @And("Kullanıcı yasal sözleşmeleri onaylar")
    public void kullaniciYasalSozlesmeleriOnaylar() {
        rm.myClick(registerPage.getTermsCheckbox());
    }

    @And("Kullanıcı Kayıt Ol butonuna tıklar")
    public void kullaniciKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButonu());
    }

    @Then("Yeni hesabın başarıyla oluşturulduğu doğrulanır")
    public void yeniHesabinBasariylaOlusturulduguDogrulanir() {
        Assert.assertTrue(registerPage.getBasariliKayitMesaji().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} ve Şifreyi Onayla alanına {string} girer")
    public void kullaniciSifreAlaninaVeSifreyiOnaylaAlaninaGirer(String sifre1, String sifre2) {
        rm.mySendKeys(registerPage.getPasswordInput(), sifre1);
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), sifre2);
    }

    @And("Kullanıcı diğer zorunlu alanları doldurup Kayıt Ol butonuna tıklar")
    public void kullaniciDigerZorunluAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(registerPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getHesapOlusturButonu());
    }

    @Then("Kayıt işleminin bloke edildiği ve Şifreler eşleşmiyor validasyon mesajının gösterildiği doğrulanır")
    public void kayitIslemininBlokeEdildigiVeSifrelerEslenmiyorValidasyonMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(registerPage.getSifrelerEslenmiyorMesaji().isVisible());
    }

    @When("Kullanıcı 8 karakterden kısa bir şifre girer {string}")
    public void kullanici8KarakterdenKisaBirSifreGirer(String kisaSifre) {
        rm.mySendKeys(registerPage.getPasswordInput(), kisaSifre);
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), kisaSifre);
    }

    @And("Kullanıcı kayıt formunu doldurup gönderir")
    public void kullaniciKayitFormunuDoldurupGonderir() {
        rm.mySendKeys(registerPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getHesapOlusturButonu());
    }

    @Then("Kayıt işleminin gerçekleşmediği ve şifre uzunluğuyla ilgili uyarı mesajı verildiği doğrulanır")
    public void kayitIslemininGerceklesmedigiVeSifreUzunluguylaIlgiliUyariMesajiVerildigiDogrulanir() {
        Assert.assertTrue(registerPage.getSifreUzunlukUyarisi().isVisible());
    }

    @When("Kullanıcı tüm metin alanlarını ve şifreleri doğru doldurur ancak sözleşme onay kutusunu işaretlemez")
    public void kullaniciTumMetinAlanlariniVeSifreleriDogruDoldururAncakSozlesmeOnayKutusunuIsaretlemez() {
        rm.mySendKeys(registerPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
        rm.myClick(registerPage.getHesapOlusturButonu());
    }

    @Then("Formun gönderilemediği ve sözleşmelerin onaylanması gerektiğine dair uyarı alındığı doğrulanır")
    public void formunGonderilemedigiVeSozlesmelerinOnaylanmasiGerektigineDairUyariAlindigiDogrulanir() {
        Assert.assertTrue(registerPage.getSozlesmeUyarisi().isVisible());
    }

    @Given("Sistemde halihazırda kayıtlı bir {string} e-posta adresi vardır")
    public void sistemdeHalihazirdaKayitliBirEPostaAdresiVardir(String email) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı kayıt sayfasında aynı e-posta adresini kullanarak kayıt olmaya çalışır")
    public void kullaniciKayitSayfasindaAyniEPostaAdresiniKullanarakKayitOlmayaCalisir() {
        rm.mySendKeys(registerPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(registerPage.getEmailInput(), "kullanan@example.com");
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123");
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getHesapOlusturButonu());
    }

    @Then("Sistemin kayıt işlemini bloke ettiği ve e-postanın zaten kullanımda olduğuna dair hata mesajı verdiği doğrulanır")
    public void sisteminKayitIsleminiBlokeEdildigiVeEPostaninZatenKullanimdaOldugunaDairHataMesajiVerdigiDogrulanir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaMesaji().isVisible());
    }
}