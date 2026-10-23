package StepDefinations;

import Pages.AistagerTestcasesPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AistagerTestcasesSteps {

    private final AistagerTestcasesPage page;
    private final TestContext context;

    public AistagerTestcasesSteps(TestContext context) {
        this.context = context;
        this.page = new AistagerTestcasesPage();
    }

    @Given("Kullanıcı AiStager platformuna erişim sağlar")
    public void kullaniciAiStagerPlatformunaErisimSaglar() {
        page.verifyHomePageDisplayed();
    }

    @Given("Kullanıcı Virtual Staging sayfasında oturum açmış durumdadır")
    public void kullaniciVirtualStagingSayfasindaOturumAcmisDurumdadir() {
        page.acceptCookies();
        page.login("user@example.com", "Password123*");
    }

    @Then("Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak aktif olduğu doğrulanır")
    public void mevcutMobilyalariKaldirSecenegininVarsayilanOlarakAktifOlduguDogrulanir() {
        page.verifyRemoveFurnitureOptionChecked();
    }

    @Then("Görünürlük seçeneklerinden {string} radyo butonunun seçili olduğu doğrulanır")
    public void gorunurlukSeceneklerindenRadyoButonununSeciliOlduguDogrulanir(String radioName) {
        page.verifyPublicVisibilityChecked();
    }

    @When("Kullanıcı dosya yükleme alanına {string} dosyasını yükler")
    public void kullaniciDosyaYuklemeAlaninaDosyasiniYukler(String dosyaAdi) {
        page.uploadImage(dosyaAdi);
    }

    @Then("Yüklenen görselin önizlemesi ekranda görüntülenir")
    public void yuklenenGorselinOnizlemesiEkrandaGoruntulenir() {
        page.verifyPreviewImageDisplayed();
    }

    @When("Kullanıcı Oda Türü alanından {string} seçeneğini seçer")
    public void kullaniciOdaTuruAlanindanSeceneginiSecer(String odaTuru) {
        page.selectRoomType(odaTuru);
    }

    @When("Kullanıcı Tasarım Stili alanından {string} seçeneğini seçer")
    public void kullaniciTasarimStiliAlanindanSeceneginiSecer(String tasarimStili) {
        page.selectDesignStyle(tasarimStili);
    }

    @When("Dekorasyon Oluştur butonuna tıklar")
    public void dekorasyonOlusturButonunaTiklar() {
        page.clickCreateDecoration();
    }

    @Then("Dekorasyon Oluştur butonunun işlem sırasında devre dışı ve yükleniyor durumunda olduğu doğrulanır")
    public void dekorasyonOlusturButonununIslemSirasindaDevreDisiVeYukleniyorDurumundaOlduguDogrulanir() {
        page.verifyCreateDecorationButtonDisabled();
    }

    @Then("İşlem tamamlandığında mobilyalandırılmış görsel ekranda render edilir")
    public void islemTamamlandigindaMobilyalandirilmisGorselEkrandaRenderEdilir() {
        page.verifyResultImageDisplayed();
    }

    @Then("Desteklenmeyen dosya formatı uyarısı ekranda görüntülenir")
    public void desteklenmeyenDosyaFormatiUyarisiEkrandaGoruntulenir() {
        page.verifyUnsupportedFormatAlertDisplayed();
    }

    @Then("Görsel önizleme alanı boş kalır")
    public void gorselOnizlemeAlaniBosKalir() {
        page.verifyPreviewImageHidden();
    }

    @Then("Dekorasyon Oluştur butonu tıklanamaz durumda olur")
    public void dekorasyonOlusturButonuTiklanamazDurumdaOlur() {
        page.verifyCreateDecorationButtonDisabled();
    }

    @When("Kullanıcı görsel yükleme durumunu {string} olarak ayarlar")
    public void kullaniciGorselYuklemeDurumunuOlarakAyarlar(String gorselDurumu) {
        if ("Yuklendi".equalsIgnoreCase(gorselDurumu)) {
            page.uploadImage("sample.jpg");
        }
    }

    @When("Kullanıcı Oda Türü seçimini {string} olarak belirler")
    public void kullaniciOdaTuruSeciminiOlarakBelirler(String odaTuru) {
        if (!"Secilmedi".equalsIgnoreCase(odaTuru)) {
            page.selectRoomType(odaTuru);
        }
    }

    @When("Kullanıcı Tasarım Stili seçimini {string} olarak belirler")
    public void kullaniciTasarimStiliSeciminiOlarakBelirler(String tasarimStili) {
        if (!"Secilmedi".equalsIgnoreCase(tasarimStili)) {
            page.selectDesignStyle(tasarimStili);
        }
    }

    @Then("Dekorasyon Oluştur butonunun tıklanamaz durumda olduğu doğrulanır")
    public void dekorasyonOlusturButonununTiklanamazDurumdaOlduguDogrulanir() {
        page.verifyCreateDecorationButtonDisabled();
    }

    @Given("Kullanıcı AI Edit sekmesine geçer ve kaynak görsel tanımlıdır")
    public void kullaniciAiEditSekmesineGecerVeKaynakGorselTanimlidir() {
        page.clickAiEditTab();
    }

    @Then("Kaynak görsel seçeneğinin varsayılan olarak {string} olduğu doğrulanır")
    public void kaynakGorselSecenegininVarsayilanOlarakOlduguDogrulanir(String sourceOption) {
        page.verifyCurrentImageRadioChecked();
    }

    @When("Kullanıcı metin alanına {string} komutunu yazar")
    public void kullaniciMetinAlaninaKomutunuYazar(String prompt) {
        page.enterEditPrompt(prompt);
    }

    @When("Edit Photo butonuna tıklar")
    public void editPhotoButonunaTiklar() {
        page.clickEditPhoto();
    }

    @Then("Sistemin talebi işlediği görüntülenir")
    public void sisteminTalebiIsledigiGoruntulenir() {
        page.verifyProcessingState();
    }

    @Then("Orijinal görsel korunarak yeni düzenlenmiş versiyon ekranda sunulur")
    public void orijinalGorselKorunarakYeniDuzenlenmisVersiyonEkrandaSunulur() {
        page.verifyEditedImageDisplayed();
    }

    @When("Kullanıcı komut giriş alanını boş bırakır")
    public void kullaniciKomutGirisAlaniniBosBirakir() {
        page.clearEditPrompt();
    }

    @Then("Edit Photo butonunun devre dışı olduğu doğrulanır")
    public void editPhotoButonununDevreDisiOlduguDogrulanir() {
        page.verifyEditPhotoButtonDisabled();
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        page.verifyHomePageDisplayed();
    }

    @When("Kullanıcı Header menüsünde yer alan {string} sekmesini açar")
    public void kullaniciHeaderMenusundeYerAlanSekmesiniAcar(String menuAdi) {
        page.openProductsMenu();
    }

    @When("Açılan menünün ikinci sırasındaki {string} seçeneğine tıklar")
    public void acilanMenununIkinciSirasindakiSecenegineTiklar(String secenekAdi) {
        page.clickAiVirtualTour();
    }

    @Then("Tarayıcı adres çubuğundaki URL değeri {string} olmalıdır")
    public void tarayiciAdresCubugundakiUrlDegeriOlmalidir(String expectedUrlFragment) {
        page.verifyCurrentUrl(expectedUrlFragment);
    }

    @When("Açılan menünün üçüncü sırasındaki {string} seçeneğine tıklar")
    public void acilanMenununUcuncuSirasindakiSecenegineTiklar(String secenekAdi) {
        page.clickVirtualStagingApi();
    }

    @Given("Kullanıcı {string} sayfasına gider")
    public void kullaniciSayfasinaGider(String targetUrl) {
        page.verifyCurrentUrl(targetUrl);
    }

    @When("Kullanıcı Erken Erişim Formu üzerindeki ad alanına {string} bilgisini girer")
    public void kullaniciErkenErisimFormuUzerindekiAdAlaninaBilgisiniGirer(String fullName) {
        page.fillEarlyAccessFullName(fullName);
    }

    @When("E-posta alanına {string} bilgisini girer")
    public void ePostaAlaninaBilgisiniGirer(String email) {
        page.fillEarlyAccessEmail(email);
    }

    @When("Erken Erişim İsteyin butonuna tıklar")
    public void erkenErisimIsteyinButonunaTiklar() {
        page.clickRequestEarlyAccess();
    }

    @Then("Talep başarıyla kaydedilmelidir")
    public void talepBasariylaKaydedilmelidir() {
        page.verifyEarlyAccessRequestSuccess();
    }

    @Then("Form ekranı kapanmalıdır")
    public void formEkraniKapanmalidir() {
        page.verifyEarlyAccessFormClosed();
    }

    @Then("Ekranda onay bildirim mesajı görüntülenmelidir")
    public void ekrandaOnayBildirimMesajiGoruntulenmelidir() {
        page.verifyConfirmationNotificationDisplayed();
    }

    @When("Kullanıcı E-posta alanına {string} bilgisini yazar")
    public void kullaniciEPostaAlaninaBilgisiniYazar(String email) {
        page.fillContactEmail(email);
    }

    @When("Formu gönder butonuna tıklar")
    public void formuGonderButonunaTiklar() {
        page.clickSubmit();
    }

    @Then("Geçersiz e-posta biçimi hata mesajı görüntülenir")
    public void gecersizEPostaBicimiHataMesajiGoruntulenir() {
        page.verifyInvalidEmailErrorDisplayed();
    }

    @Then("Form gönderimi engellenir")
    public void formGonderimiEngellenir() {
        page.verifyEarlyAccessFormVisible();
    }

    @When("Kullanıcı İletişime Geçin formundaki zorunlu alanları boş bırakır")
    public void kullaniciIletisimeGecinFormundakiZorunluAlanlariBosBirakir() {
        page.clearContactEmail();
    }

    @When("Gönder butonuna tıklar")
    public void gonderButonunaTiklar() {
        page.clickSubmit();
    }

    @Then("Zorunlu alanların doldurulması gerektiğine dair uyarı mesajları görüntülenir")
    public void zorunluAlanlarinDoldurulmasiGerektigineDairUyariMesajlariGoruntulenir() {
        page.verifyRequiredFieldErrorDisplayed();
    }

    @Then("Form gönderilmez")
    public void formGonderilmez() {
        page.verifyContactFormVisible();
    }

    @When("Kullanıcı İletişime Geçin formunu eksiksiz ve geçerli verilerle doldurur")
    public void kullaniciIletisimeGecinFormunuEksiksizVeGecerliVerilerleDoldurur() {
        page.fillEarlyAccessFullName("Ahmet Yılmaz");
        page.fillContactEmail("ahmet.yilmaz@example.com");
    }

    @Then("Başarılı gönderim onay mesajı görüntülenir")
    public void basariliGonderimOnayMesajiGoruntulenir() {
        page.verifyContactSuccessMessageDisplayed();
    }

    @Then("Form alanı kapanır")
    public void formAlaniKapanir() {
        page.verifyContactFormClosed();
    }

    @When("Kullanıcı sayfanın alt bölümündeki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltBolumundekiFiyatlandirmayiGoruntuleButonunaTiklar() {
        page.clickViewPricing();
    }

    @Then("Kullanıcı {string} sayfasına başarıyla yönlendirilmelidir")
    public void kullaniciSayfasinaBasariylaYonlendirilmelidir(String expectedUrlFragment) {
        page.verifyCurrentUrl(expectedUrlFragment);
    }
}