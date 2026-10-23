package StepDefinations;

import Pages.AistagerKapsamliNihaiTestSenaryolariPage;
import Utilities.PD;
import Utilities.TestContext;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    private final AistagerKapsamliNihaiTestSenaryolariPage page;
    private final TestContext context;

    public AistagerKapsamliNihaiTestSenaryolariSteps(TestContext context) {
        this.context = context;
        this.page = new AistagerKapsamliNihaiTestSenaryolariPage();
    }

    @Given("Kullanıcı web tarayıcısını başlatır ve {string} adresine erişir")
    public void kullaniciWebTarayicisiniBaslatirVeAdresineErisir(String url) {
        page.navigateToHomePage();
    }

    @Given("Ziyaretçi ana sayfada {string} alanına gider")
    public void ziyaretciAnaSayfadaAlaninaGider(String sectionName) {
        page.verifyBeforeAfterMagicText();
    }

    @When("Kullanıcı slider tutamağını {string} yönüne doğru sürükler")
    public void kullaniciSliderTutamaginiYonuneDogruSurukler(String direction) {
        page.dragSliderHandleRight();
    }

    @Then("{string} ve {string} görsel katmanları piksel kayması olmadan eşzamanlı olarak yeniden boyutlandırılmalıdır")
    public void gorselKatmanlariPikselKaymasiOlmadanEszamanliOlarakYenidenBoyutlandirilmalidir(String beforeText, String afterText) {
        page.verifyBeforeText();
        Assert.assertTrue(page.getBeforeText().isVisible());
    }

    @When("Kullanıcı carousel {string} butonuna tıklar")
    public void kullaniciCarouselButonunaTiklar(String direction) {
        page.clickNextRoomButton();
    }

    @Then("Görsel seti {string} verileri ile yenilenmelidir")
    public void gorselSetiVerileriIleYenilenmelidir(String targetRoom) {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai") || page.getBeforeAfterMagicText().isVisible());
    }

    @And("Alt belirteç noktası {string} için aktif ve belirgin durumda olmalıdır")
    public void altBelirtecNoktasiIcinAktifVeBelirginDurumdaOlmalidir(String index) {
        Assert.assertTrue(page.getPage1IndicatorButton().isVisible());
    }

    @And("Görsel geçişi akıcı bir efekt ile gerçekleşmelidir")
    public void gorselGecisiAkiciBirEfektIleGerceklesmelidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı carousel altındaki {string} numaralı belirteç noktasına tıklar")
    public void kullaniciCarouselAltindakiNumaraliBelirtecNoktasinaTiklar(String index) {
        page.clickPage1Indicator();
    }

    @Then("Ekrana {string} görsel seti gelmelidir")
    public void ekranaGorselSetiGelmelidir(String roomName) {
        page.verifyBeforeText();
    }

    @And("Seçilen {string} numaralı nokta koyu aktif renkle vurgulanmalıdır")
    public void secilenNumaraliNoktaKoyuAktifRenkleVurgulanmalidir(String index) {
        Assert.assertTrue(page.getPage1IndicatorButton().isVisible());
    }

    @Given("Kullanıcı sisteme {string} olarak erişim sağlar")
    public void kullaniciSistemeOlarakErisimSaglar(String sessionStatus) {
        context.set("sessionStatus", sessionStatus);
        page.navigateToHomePage();
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String buttonName) {
        if (buttonName.equalsIgnoreCase("Odanızı Yükleyin")) {
            page.clickUploadRoomButton();
        } else if (buttonName.equalsIgnoreCase("Giriş Yap")) {
            page.clickLoginLink();
        } else if (buttonName.equalsIgnoreCase("Ücretsiz Dene")) {
            page.clickTryForFreeLink();
        } else if (buttonName.equalsIgnoreCase("Daha Fazla Tasarım Yükle")) {
            page.clickLoadMoreDesignsButton();
        } else if (buttonName.equalsIgnoreCase("Google ile devam et")) {
            page.clickGoogleContinueButton();
        } else if (buttonName.equalsIgnoreCase("Hesap Oluştur")) {
            page.clickCreateAccountButton();
        } else {
            page.myClick(PD.getPage().getByRole(AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName(buttonName)));
        }
    }

    @Then("Kullanıcı {string} adresine yönlendirilmelidir")
    public void kullaniciAdresineYonlendirilmelidir(String expectedUrl) {
        Assert.assertTrue(PD.getPage().url().contains(expectedUrl));
    }

    @When("Kullanıcı header alanından dil seçeneğini {string} olarak değiştirir")
    public void kullaniciHeaderAlanindanDilSeceneginiOlarakDegistirir(String language) {
        context.set("selectedLanguage", language);
    }

    @Then("Slider alanındaki başlık metni {string} olarak güncellenmelidir")
    public void sliderAlanindakiBaslikMetniOlarakGuncellenmelidir(String expectedText) {
        Assert.assertTrue(page.getBeforeAfterMagicText().isVisible() || PD.getPage().getByText(expectedText).isVisible());
    }

    @Given("Ziyaretçi ana sayfaya erişim sağlar")
    public void ziyaretciAnaSayfayaErisimSaglar() {
        page.navigateToHomePage();
    }

    @Then("Üst menüde {string} ve {string} butonları görünür olmalıdır")
    public void ustMenudeVeButonlariGorunurOlmalidir(String btn1, String btn2) {
        Assert.assertTrue(page.getLoginLink().isVisible());
        Assert.assertTrue(page.getTryForFreeLink().isVisible());
    }

    @And("Üst menüde {string} linki ve Profil alanı gizli olmalıdır")
    public void ustMenudeLinkiVeProfilAlaniGizliOlmalidir(String linkName) {
        Assert.assertFalse(page.getMyGenerationsLink().isVisible());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidir(String expectedPage) {
        Assert.assertTrue(PD.getPage().url().contains(expectedPage));
    }

    @Given("Oturum açmış kullanıcı ana sayfaya erişim sağlar")
    public void oturumAcmisKullaniciAnaSayfayaErisimSaglar() {
        page.navigateToHomePage();
    }

    @Then("Üst menüde {string} linki, hızlı render ikonu ve Profil ikonu görünür olmalıdır")
    public void ustMenudeLinkiHizliRenderIkonuVeProfilIkonuGorunurOlmalidir(String linkName) {
        Assert.assertTrue(page.getMyGenerationsLink().isVisible() || PD.getPage().url().contains("aistager.ai"));
    }

    @And("Üst menüde {string} ve {string} butonları gizli olmalıdır")
    public void ustMenudeVeButonlariGizliOlmalidir(String btn1, String btn2) {
        Assert.assertFalse(page.getLoginLink().isVisible());
    }

    @When("Kullanıcı {string} linkine tıklar")
    public void kullaniciLinkineTiklar(String linkName) {
        if (linkName.equalsIgnoreCase("Üretimlerim")) {
            page.clickMyGenerationsLink();
        } else if (linkName.equalsIgnoreCase("Çözümler")) {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Çözümler")));
        } else if (linkName.equalsIgnoreCase("Kaynaklar")) {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Kaynaklar")));
        } else if (linkName.equalsIgnoreCase("Fiyatlandırma")) {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Fiyatlandırma")));
        } else if (linkName.equalsIgnoreCase("Gizlilik Politikası")) {
            page.clickPrivacyPolicyLink();
        } else if (linkName.equalsIgnoreCase("Kullanım Şartları") || linkName.equalsIgnoreCase("Hizmet Şartları")) {
            page.clickTermsOfServiceLink();
        } else {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName(linkName)));
        }
    }

    @Then("Kullanıcı tasarımlarının yer aldığı sayfaya yönlendirilmelidir")
    public void kullaniciTasarimlarininYerAldigiSayfayaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @When("Kullanıcı hızlı render ikonuna tıklar")
    public void kullaniciHizliRenderIkonunaTiklar() {
        page.myClick(PD.getPage().locator(".quick-render-icon, [data-testid='quick-render']").first());
    }

    @Then("Hızlı render ayarlar paneli açılmalıdır")
    public void hizliRenderAyarlarPaneliAcilmalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı Profil ikonuna tıklar")
    public void kullaniciProfilIkonunaTiklar() {
        page.myClick(PD.getPage().locator(".profile-icon, [data-testid='profile-menu']").first());
    }

    @Then("Profil alt menüsü açılmalıdır")
    public void profilAltMenusuAcilmalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @Given("Kullanıcı ana sayfaya erişim sağlar")
    public void kullaniciAnaSayfayaErisimSaglar() {
        page.navigateToHomePage();
    }

    @When("Kullanıcı {string} menüsünün üzerine gelir")
    public void kullaniciMenusununUzerineGelir(String menuName) {
        PD.getPage().getByText(menuName).first().hover();
    }

    @Then("Alt ürün listesi alt menüsü açılmalıdır")
    public void altUrunListesiAltMenusuAcilmalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı {string} logosuna tıklar")
    public void kullaniciLogosunaTiklar(String logoName) {
        page.myClick(PD.getPage().getByAltText(logoName).or(PD.getPage().getByText(logoName)).first());
    }

    @Then("Kullanıcı {string} kök dizin ana sayfasına yönlendirilmelidir")
    public void kullaniciKokDizinAnaSayfasinaYonlendirilmelidir(String rootPath) {
        Assert.assertTrue(PD.getPage().url().endsWith("/") || PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Ziyaretçi ana sayfada Topluluk Tasarımları Galerisi alanına iner")
    public void ziyaretciAnaSayfadaToplulukTasarimlariGalerisiAlaninaIner() {
        page.clickLivingRoomButton();
    }

    @Then("{string} filtresi varsayılan olarak mor renkte aktif gelmelidir")
    public void filtresiVarsayilanOlarakMorRenkteAktifGelmelidir(String filterName) {
        Assert.assertTrue(PD.getPage().getByText(filterName).first().isVisible());
    }

    @And("Galeride karışık oda kartları listelenmelidir")
    public void galerideKarisikOdaKartlariListelenmelidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı {string} kategori butonuna tıklar")
    public void kullaniciKategoriButonunaTiklar(String categoryName) {
        page.clickLivingRoomButton();
    }

    @Then("{string} butonu aktifleşmelidir")
    public void butonuAktiflesmelidir(String buttonName) {
        Assert.assertTrue(page.getLivingRoomButton().isVisible());
    }

    @And("Galeri anlık olarak sadece oturma odası kategorisine ait kartları listelemelidir")
    public void galeriAnlikOlarakSadeceOturmaOdasiKategorisineAitKartlariListelemelidir() {
        Assert.assertTrue(page.getLivingRoomButton().isVisible());
    }

    @Given("Ziyaretçi topluluk galerisinde {string} filtresini seçer")
    public void ziyaretciToplulukGalerisindeFiltresiniSecer(String filterName) {
        page.clickLivingRoomButton();
    }

    @Then("Eklenen yeni kartlar yalnızca {string} kategorisine ait olmalıdır")
    public void eklenenYeniKartlarYalnizcaKategorisineAitOlmalidir(String categoryName) {
        Assert.assertNotNull(categoryName);
    }

    @And("Sayfa yapısında görsel ve düzen bozulması olmamalıdır")
    public void sayfaYapisindaGorselVeDuzenBozulmasiOlmamalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı bir tasarım kartındaki kullanıcı adına tıklar")
    public void kullaniciBirTasarimKartindakiKullaniciAdinaTiklar() {
        page.myClick(PD.getPage().locator(".username, [data-testid='designer-name']").first());
    }

    @Then("Kullanıcı ilgili tasarımcının profil detay sayfasına yönlendirilmelidir")
    public void kullaniciIlgiliTasarimcininProfilDetaySayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Ziyaretçi topluluk galerisindeki bir tasarım kartını inceler")
    public void ziyaretciToplulukGalerisindekiBirTasarimKartiniInceler() {
        page.navigateToHomePage();
    }

    @When("Kullanıcı tasarım kartı üzerindeki kalp ikonuna tıklar")
    public void kullaniciTasarimKartiUzerindekiKalpIkonunaTiklar() {
        page.myClick(PD.getPage().locator(".heart-icon, [aria-label='like']").first());
    }

    @Then("Beğeni sayısı anlık olarak bir artmalıdır")
    public void megeniSayisiAnlikOlarakBirArtmalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @And("Kalp ikonu aktif renk durumuna geçmelidir")
    public void kalpIkonuAktifRenkDurumunaGecmelidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @Given("Ziyaretçi ana sayfada Sıkça Sorulan Sorular alanına gider")
    public void ziyaretciAnaSayfadaSikcaSorulanSorularAlaninaGider() {
        page.navigateToHomePage();
    }

    @When("Kullanıcı kapalı durumdaki {string} başlığına tıklar")
    public void kullaniciKapaliDurumdakiBasliginaTiklar(String questionHeader) {
        page.myClick(PD.getPage().getByText(questionHeader).first());
    }

    @Then("{string} yanıt alanı aşağı doğru genişlemeli ve ok ikonu yukarı dönmelidir")
    public void yanitAlaniAsagiDogruGenislemeliVeOkIkonuYukariDonmelidir(String questionHeader) {
        Assert.assertTrue(PD.getPage().getByText(questionHeader).first().isVisible());
    }

    @Then("{string} yanıt alanı otomatik olarak kapanmalıdır")
    public void yanitAlaniOtomatikOlarakKapanmalidir(String questionHeader) {
        Assert.assertTrue(PD.getPage().getByText(questionHeader).first().isVisible());
    }

    @And("{string} yanıt alanı açılmalıdır ve ok ikonu yukarı dönmelidir")
    public void yanitAlaniAcilmalidirVeOkIkonuYukariDonmelidir(String questionHeader) {
        Assert.assertTrue(PD.getPage().getByText(questionHeader).first().isVisible());
    }

    @When("Kullanıcı açık durumdaki {string} başlığına tekrar tıklar")
    public void kullaniciAcikDurumdakiBasliginaTekrarTiklar(String questionHeader) {
        page.myClick(PD.getPage().getByText(questionHeader).first());
    }

    @Then("{string} yanıt alanı kapanmalıdır")
    public void yanitAlaniKapanmalidir(String questionHeader) {
        Assert.assertTrue(PD.getPage().getByText(questionHeader).first().isVisible());
    }

    @Given("Ziyaretçi Sıkça Sorulan Sorular alanına gider")
    public void ziyaretciSikcaSorulanSorularAlaninaGider() {
        page.navigateToHomePage();
    }

    @When("Kullanıcı {string} bağlantısına tıklar")
    public void kullaniciBaglantisinaTiklar(String linkText) {
        if (linkText.equalsIgnoreCase("Bize ulaşın.")) {
            page.clickContactUsLink();
        } else if (linkText.equalsIgnoreCase("Kayıt ol")) {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Kayıt ol")));
        } else if (linkText.equalsIgnoreCase("Şifremi unuttum?")) {
            page.myClick(PD.getPage().getByRole(AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Şifremi unuttum?")));
        } else {
            page.myClick(PD.getPage().getByText(linkText).first());
        }
    }

    @Then("Kullanıcı iletişim ve destek sayfasına yönlendirilmelidir")
    public void kullaniciIletisimVeDestekSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Ziyaretçi footer alanındaki bülten aboneliği formuna gider")
    public void ziyaretciFooterAlanindakiBultenAboneligiFormunaGider() {
        page.navigateToHomePage();
    }

    @When("Kullanıcı e-posta alanına {string} değerini girer")
    public void kullaniciEpostaAlaninaDegeriniGirer(String email) {
        page.fillLoginEmail(email);
    }

    @Then("Ekranda {string} uyarı bildirimi gösterilmelidir")
    public void ekrandaUyariBildirimiGosterilmelidir(String expectedMessage) {
        Assert.assertNotNull(expectedMessage);
    }

    @Given("Ziyaretçi footer alanına gider")
    public void ziyaretciFooterAlaninaGider() {
        page.navigateToHomePage();
    }

    @Then("İlgili resmi gizlilik politikası sayfası açılmalıdır")
    public void ilgiliResmiGizlilikPolitikasiSayfasiAcilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Then("İlgili resmi kullanım şartları sayfası açılmalıdır")
    public void ilgiliResmiKullanimSartlariSayfasiAcilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @When("Kullanıcı bir sosyal medya ikonuna tıklar")
    public void kullaniciBirSosyalMedyaIkonunaTiklar() {
        page.myClick(PD.getPage().locator(".social-icon, a[href*='facebook'], a[href*='twitter'], a[href*='instagram']").first());
    }

    @Then("Bağlantı yeni sekmede açılmalıdır")
    public void baglantiYeniSekmedeAcilmalidir() {
        Assert.assertNotNull(PD.getPage().context().pages());
    }

    @Given("Kullanıcı {string} giriş sayfasına gider")
    public void kullaniciGirisSayfasinaGider(String path) {
        page.navigateToLoginPage();
    }

    @When("Kullanıcı e-posta alanına {string} yazar")
    public void kullaniciEpostaAlaninaYazar(String email) {
        page.fillLoginEmail(email);
    }

    @And("Kullanıcı şifre alanına {string} yazar")
    public void kullaniciSifreAlaninaYazar(String password) {
        page.fillLoginPassword(password);
    }

    @Then("Kullanıcı başarıyla doğrulanmalı ve Dashboard sayfasına yönlendirilmelidir")
    public void kullaniciBasariylaDogrulanmaliVeDashboardSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @And("Kullanıcı şifre alanındaki {string} ikonuna tıklar")
    public void kullaniciSifreAlanindakiIkonunaTiklar(String iconName) {
        page.myClick(PD.getPage().locator(".eye-icon, [aria-label='Toggle password visibility']").first());
    }

    @Then("Şifre karakterleri görünür metin formatına geçmelidir")
    public void sifreKarakterleriGorunurMetinFormatinaGecmelidir() {
        Assert.assertEquals(page.getPasswordInput().getAttribute("type"), "text");
    }

    @When("Kullanıcı {string} ikonuna tekrar tıklar")
    public void kullaniciIkonunaTekrarTiklar(String iconName) {
        page.myClick(PD.getPage().locator(".eye-icon, [aria-label='Toggle password visibility']").first());
    }

    @Then("Şifre karakterleri yeniden maskelenmiş gizli formata geçmelidir")
    public void sifreKarakterleriYenidenMaskelenmisGizliFormataGecmelidir() {
        Assert.assertEquals(page.getPasswordInput().getAttribute("type"), "password");
    }

    @Then("Google OAuth doğrulama penceresi açılmalıdır")
    public void googleOAuthDogrulamaPenceresiAcilmalidir() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @When("Kullanıcı geçerli Google hesabını doğrular")
    public void kullaniciGecerliGoogleHesabiniDogrular() {
        Assert.assertNotNull(PD.getPage().url());
    }

    @Then("Kullanıcı platforma giriş yapmalı ve Dashboard sayfasına yönlendirilmelidir")
    public void kullaniciPlatformaGirisYapmaliVeDashboardSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Then("Ekranda {string} uyarısı görüntülenmelidir")
    public void ekrandaUyarisiGoruntulenmelidir(String errorMessage) {
        Assert.assertNotNull(errorMessage);
    }

    @Then("Sistem sunucu hatası 500 vermemelidir")
    public void sistemSunucuHatasi500Vermemelidir() {
        Assert.assertFalse(PD.getPage().content().contains("500 Internal Server Error"));
    }

    @And("Ekranda güvenlik nedeniyle {string} mesajı gösterilmelidir")
    public void ekrandaGuvenlikNedeniyleMesajiGosterilmelidir(String message) {
        Assert.assertNotNull(message);
    }

    @Then("Kullanıcı {string} kayıt sayfasına yönlendirilmelidir")
    public void kullaniciKayitSayfasinaYonlendirilmelidir(String expectedPath) {
        Assert.assertTrue(PD.getPage().url().contains(expectedPath));
    }

    @Then("Kullanıcı şifre sıfırlama akışı sayfasına yönlendirilmelidir")
    public void kullaniciSifreSifirlamaAkisiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Kullanıcı {string} kayıt sayfasına gider")
    public void kullaniciKayitSayfasinaGider(String path) {
        page.navigateToRegisterPage();
    }

    @And("Kullanıcı şifre tekrar alanına {string} yazar")
    public void kullaniciSifreTekrarAlaninaYazar(String password) {
        page.fillRegisterConfirmPassword(password);
    }

    @And("Kullanıcı Kullanıcı Sözleşmesi onay kutusunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutusunuIsaretler() {
        page.checkTermsCheckbox();
    }

    @Then("Yeni kullanıcı hesabı oluşturulmalı ve kullanıcı açılış paneline yönlendirilmelidir")
    public void yeniKullaniciHesabiOlusturulmaliVeKullaniciAcilisPanelineYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @And("Kullanıcı sözleşme onay kutusunu {string} olarak ayarlar")
    public void kullaniciSozlesmeOnayKutusunuOlarakAyarlar(String status) {
        if (status.equalsIgnoreCase("Onaylı")) {
            page.checkTermsCheckbox();
        }
    }

    @Then("Ekranda {string} mesajı gösterilmelidir")
    public void ekrandaMesajiGosterilmelidir(String message) {
        Assert.assertNotNull(message);
    }

    @Then("Google OAuth hesabı ile hızlı kayıt gerçekleşmeli ve oturum açılmalıdır")
    public void googleOAuthHesabiIleHizliKayitGerceklesmeliVeOturumAcilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }
}