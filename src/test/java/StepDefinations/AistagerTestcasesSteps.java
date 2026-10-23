package StepDefinations;

import Pages.AistagerTestcasesPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;

public class AistagerTestcasesSteps {

    private final AistagerTestcasesPage page;
    private final TestContext context;

    public AistagerTestcasesSteps(TestContext context) {
        this.context = context;
        this.page = new AistagerTestcasesPage();
    }

    @Given("Kullanıcı web sitesi ana sayfasına erişir")
    public void kullaniciWebSitesiAnaSayfasinaErisir() {
        page.navigateToHomePage();
    }

    @Given("Kullanıcı oturum açarak \"Virtual Staging\" sayfasına gider")
    public void kullaniciOturumAcarakVirtualStagingSayfasinaGider() {
        page.clickVirtualStagingButton();
    }

    @When("Kullanıcı {string} dosyasını yükler")
    public void kullaniciDosyasiniYukler(String fileName) {
        page.uploadFile(fileName);
    }

    @Then("Yüklenen görselin önizlemesi ekranda görüntülenmelidir")
    public void yuklenenGorselinOnizlemesiEkrandaGoruntulenmelidir() {
        page.verifyPreviewImageVisible();
    }

    @And("Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak açık durumda olduğu doğrulanır")
    public void mevcutMobilyalariKaldirSecenegininVarsayilanOlarakAcikDurumdaOlduguDogrulanir() {
        page.verifyRemoveFurnitureSwitchChecked();
    }

    @When("Kullanıcı Oda Türü alanından {string} değerini seçer")
    public void kullaniciOdaTuruAlanindanDegeriniSecer(String roomType) {
        page.selectRoomType(roomType);
    }

    @And("Kullanıcı Tasarım Stili alanından {string} değerini seçer")
    public void kullaniciTasarimStiliAlanindanDegeriniSecer(String designStyle) {
        page.selectDesignStyle(designStyle);
    }

    @And("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        page.clickCreateDecorationButton();
    }

    @Then("Sistem görsel işleme sürecini başlatmalıdır")
    public void sistemGorselIslemeSureciniBaslatmalidir() {
        page.verifyProcessingStatusVisible();
    }

    @And("İşlem tamamlandığında seçilen parametrelere uygun mobilyalandırılmış çıktı görseli önizleme alanında sunulmalıdır")
    public void islemTamamlandigindaSecilenParametrelereUygunMobilyalandirilmisCiktiGorseliOnizlemeAlanindaSunulmalidir() {
        page.verifyResultImageVisible();
    }

    @When("Kullanıcı sisteme geçersiz formattaki {string} dosyasını yüklemeyi dener")
    public void kullaniciSistemeGecersizFormattakiDosyasiniYuklemeyiDener(String fileName) {
        page.uploadFile(fileName);
    }

    @Then("Ekranda yalnızca JPG veya PNG formatlarının desteklendiğini belirten hata mesajı görüntülenmelidir")
    public void ekrandaYalnizcaJpgVeyaPngFormatlarininDesteklendiginiBelirtenHataMesajiGoruntulenmelidir() {
        page.verifyInvalidFormatErrorMessage();
    }

    @And("Görsel önizleme alanı boş kalmalıdır")
    public void gorselOnizlemeAlaniBosKalmalidir() {
        page.verifyPreviewImageHidden();
    }

    @And("Görsel önizlemesinin ekranda olduğunu doğrular")
    public void gorselOnizlemesininEkrandaOldugunuDogrular() {
        page.verifyPreviewImageVisible();
    }

    @But("Oda Türü ve Tasarım Stili dropdown alanlarını boş bırakır")
    public void odaTuruVeTasarimStiliDropdownAlanlariniBosBirakir() {
        page.verifyRoomTypeDropdownEmpty();
    }

    @Then("Dekorasyon Oluştur butonu pasif durumda olmalıdır ve işlem başlatılamamalıdır")
    public void dekorasyonOlusturButonuPasifDurumdaOlmalidirVeIslemBaslatilamamalidir() {
        page.verifyCreateDecorationButtonDisabled();
    }

    @Given("Kullanıcı oturum açarak \"Virtual Staging\" altındaki \"AI Edit\" sekmesine gider")
    public void kullaniciOturumAcarakVirtualStagingAltindakiAiEditSekmesineGider() {
        page.clickAiEditTab();
    }

    @And("Düzenlenecek kaynak görselin sistemde seçili olduğunu doğrular")
    public void duzenlenecekKaynakGorselinSistemdeSeciliOldugunuDogrular() {
        page.verifySourceImageVisible();
    }

    @When("Kullanıcı Describe what to change alanına {string} talimatını girer")
    public void kullaniciDescribeWhatToChangeAlaninaTalimatiniGirer(String instruction) {
        page.fillDescribeWhatToChange(instruction);
    }

    @And("Edit Photo butonuna tıklar")
    public void editPhotoButonunaTiklar() {
        page.clickEditPhotoButton();
    }

    @Then("Sistem talimata uygun olarak işlenmiş yeni görseli ekranda başarıyla görüntülemelidir")
    public void sistemTalimataUygunOlarakIslenmisYeniGorseliEkrandaBasariylaGoruntulemelidir() {
        page.verifyEditedImageVisible();
    }

    @When("Kullanıcı Describe what to change alanına {string} yazar")
    public void kullaniciDescribeWhatToChangeAlaninaYazar(String instruction) {
        page.fillDescribeWhatToChange(instruction);
    }

    @Then("Edit Photo butonu işlem başlatmamalıdır")
    public void editPhotoButonuIslemBaslatmamalidir() {
        page.verifyEditPhotoButtonDisabled();
    }

    @And("Ekranda geçerli bir komut girilmesini isteyen doğrulama mesajı görüntülenmelidir")
    public void ekrandaGecerliBirKomutGirilmesiniIsteyenDogrulamaMesajiGoruntulenmelidir() {
        page.verifyInvalidCommandWarningVisible();
    }

    @When("Kullanıcı menüdeki Ürünler seçeneğine tıklar")
    public void kullaniciMenudekiUrunlerSecenegineTiklar() {
        page.clickProductsMenuButton();
    }

    @And("Açılan menünün ikinci sırasındaki Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanMenununIkinciSirasindakiYapayZekaSanalTurSecenegineTiklar() {
        page.clickAiVirtualTourLink();
    }

    @Then("Kullanıcı doğrudan \"/tr/ai-virtual-tour\" adresine yönlendirilmelidir")
    public void kullaniciDogrudanTrAiVirtualTourAdresineYonlendirilmelidir() {
        page.verifyVirtualTourUrl();
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        page.clickRequestEarlyAccessButton();
    }

    @And("Erken erişim formundaki e-posta alanına {string} yazar")
    public void erkenErisimFormundakiEpostaAlaninaYazar(String email) {
        page.fillEmailField(email);
    }

    @And("Form gönder butonuna tıklar")
    public void formGonderButonunaTiklar() {
        page.clickSubmitButton();
    }

    @Then("Kullanıcıya talebin alındığına dair onay bildirim mesajı gösterilmelidir")
    public void kullaniciyaTalebinAlindiginaDairOnayBildirimMesajiGosterilmelidir() {
        page.verifyRequestReceivedConfirmationMessage();
    }

    @Given("Kullanıcı doğrudan \"/tr/ai-virtual-tour\" sayfasına gider")
    public void kullaniciDogrudanTrAiVirtualTourSayfasinaGider() {
        page.navigateToVirtualTourPage();
    }

    @Then("Form gönderilmemelidir")
    public void formGonderilmemelidir() {
        page.verifySubmitButtonEnabled();
    }

    @And("Ekranda geçerli bir e-posta adresi girilmesi gerektiğine dair hata uyarısı gösterilmelidir")
    public void ekrandaGecerliBirEpostaAdresiGirilmesiGerektigineDairHataUyarisiGosterilmelidir() {
        page.verifyInvalidEmailErrorMessage();
    }

    @And("Açılan menünün üçüncü sırasındaki Sanal Dekorasyon API bağlantısına tıklar")
    public void acilanMenununUcuncuSirasindakiSanalDekorasyonApiBaglantisinaTiklar() {
        page.clickApiLink();
    }

    @Then("Kullanıcı doğrudan \"/tr/api\" adresine yönlendirilmelidir")
    public void kullaniciDogrudanTrApiAdresineYonlendirilmelidir() {
        page.verifyApiUrl();
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        page.clickContactUsButton();
    }

    @And("Açılan form üzerindeki tüm zorunlu alanları geçerli bilgilerle doldurur")
    public void acilanFormUzerindekiTumZorunluAlanlariGecerliBilgilerleDoldurur() {
        page.fillFullNameField("Test Kullanıcı");
        page.fillEmailField("test@aistager.ai");
    }

    @Then("Ekranda formun başarıyla iletildiğini belirten onay bildirimi görüntülenmelidir")
    public void ekrandaFormunBasariylaIletildiginiBelirtenOnayBildirimiGoruntulenmelidir() {
        page.verifyFormSubmittedConfirmationMessage();
    }

    @When("Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaAltindakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        page.clickViewPricingLink();
    }

    @Then("Kullanıcı ilgili Fiyatlandırma sayfasına hatasız yönlendirilmelidir")
    public void kullaniciIlgiliFiyatlandirmaSayfasinaHatasizYonlendirilmelidir() {
        page.verifyPricingUrl();
    }

    @Given("Kullanıcı doğrudan \"/tr/api\" sayfasına gider")
    public void kullaniciDogrudanTrApiSayfasinaGider() {
        page.navigateToApiPage();
    }

    @And("Form üzerindeki zorunlu alanları doldurmadan Form gönder butonuna tıklar")
    public void formUzerindekiZorunluAlanlariDoldurmadanFormGonderButonunaTiklar() {
        page.clickSubmitButton();
    }

    @Then("Form iletilmemelidir")
    public void formIletilmemelidir() {
        page.verifySubmitButtonEnabled();
    }

    @And("Eksik alanların doldurulmasını belirten doğrulama uyarıları görüntülenmelidir")
    public void eksikAlanlarinDoldurulmasiniBelirtenDogrulamaUyarilariGoruntulenmelidir() {
        page.verifyRequiredFieldErrorVisible();
    }
}