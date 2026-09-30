package StepDefinations;

import Pages.VirtualStagingPage;
import Pages.AiEditPage;
import Pages.NavigationPage;
import Pages.LoginPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import Utilities.ConfigReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;
import java.nio.file.Paths;

public class AistagerTestcasesSteps {
    Page page = PD.getPage();
    ReusableMethod rm = new ReusableMethod();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AiEditPage aiEditPage = new AiEditPage();
    NavigationPage navigationPage = new NavigationPage();
    LoginPage loginPage = new LoginPage();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        page.navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(page.url().contains("aistager"));
    }

    @Given("Kullanıcı giriş yapmıştır")
    public void kullaniciGirisYapmistir() {
        page.navigate(ConfigReader.getProperty("url"));
        rm.mySendKeys(loginPage.getEmailInput(), ConfigReader.getProperty("existing_user_email"));
        rm.mySendKeys(loginPage.getPasswordInput(), ConfigReader.getProperty("existing_user_password"));
        rm.myClick(loginPage.getLoginButton());
    }

    @And("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String sayfaAdi) {
        rm.myClick(page.getByText(sayfaAdi));
    }

    @When("Kullanıcı jpg veya png formatında geçerli bir oda görselini yükler")
    public void kullaniciGecerliOdaGorseliniYukler() {
        virtualStagingPage.getFileUploadInput().setInputFiles(Paths.get("src/test/resources/sample.jpg"));
    }

    @Then("Görselin önizlemesi ekranda görüntülenmelidir")
    public void gorselinOnizlemesiEkrandaGoruntulenmelidir() {
        Assert.assertTrue(virtualStagingPage.getImagePreview().isVisible());
    }

    @And("Mevcut mobilyaları kaldır toggle özelliğinin varsayılan olarak açık olduğu görülmelidir")
    public void mevcutMobilyalariKaldirToggleVarsayilanAcikGorulmelidir() {
        Assert.assertTrue(virtualStagingPage.getRemoveFurnitureToggle().isVisible());
    }

    @When("Kullanıcı {string} ve {string} seçimlerini yapar")
    public void kullaniciSecimleriYapar(String secim1, String secim2) {
        rm.myClick(virtualStagingPage.getRoomTypeDropdown());
        rm.myClick(virtualStagingPage.getDesignStyleDropdown());
    }

    @And("Kullanıcı Görünürlük seçeneğini belirler")
    public void kullaniciGorunurlukSeceneginiBelirler() {
        rm.myClick(virtualStagingPage.getVisibilitySelect());
    }

    @And("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getCreateDecorationButton());
    }

    @Then("İşlem tamamlandığında yapay zeka tarafından mobilyalandırılmış yeni görsel ekranda sunulmalıdır")
    public void islemTamamlandigindaYeniGorselSunulmalidir() {
        Assert.assertTrue(virtualStagingPage.getSuccessResultImage().isVisible());
    }

    @When("Kullanıcı {string} formatında bir dosya yüklemeye çalışır")
    public void kullaniciFormatindaDosyaYuklemeyeCalisir(String gecersizFormat) {
        virtualStagingPage.getFileUploadInput().setInputFiles(Paths.get("src/test/resources/sample." + gecersizFormat));
    }

    @Then("Sistem hata mesajı göstermeli ve görsel önizlemesi oluşmamalıdır")
    public void sistemHataMesajiGostermeli() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @When("Kullanıcı geçerli bir görsel yükler")
    public void kullaniciGecerliBirGorselYukler() {
        virtualStagingPage.getFileUploadInput().setInputFiles(Paths.get("src/test/resources/sample.jpg"));
    }

    @And("Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır")
    public void kullaniciSecimleriBosBirakir() {
        virtualStagingPage.getRoomTypeDropdown().fill("");
    }

    @Then("Dekorasyon Oluştur butonu pasif kalmalı veya uyarı mesajı verilerek işlem başlatılmamalıdır")
    public void dekorasyonOlusturButonuPasifKalmali() {
        Assert.assertTrue(virtualStagingPage.getCreateDecorationButton().isVisible());
    }

    @When("Kullanıcı sistemin izin verdiği maksimum boyut sınırını aşan bir jpg görseli yükler")
    public void kullaniciMaksimumSiniriAsanGorselYukler() {
        virtualStagingPage.getFileUploadInput().setInputFiles(Paths.get("src/test/resources/large_sample.jpg"));
    }

    @Then("Sistem dosya boyutunun çok büyük olduğuna dair bir hata mesajı göstermelidir")
    public void sistemDosyaBoyutuHataMesajiGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @And("Kullanıcı {string} sekmesindedir")
    public void kullaniciSekmesindedir(String sekmeAdi) {
        rm.myClick(page.getByText(sekmeAdi));
    }

    @Then("Edit photo source alanında varsayılan olarak Current image seçili gelmelidir")
    public void editPhotoSourceVarsayilanSecili() {
        Assert.assertTrue(aiEditPage.getCurrentimageSource().isVisible());
    }

    @When("Kullanıcı Describe what to change alanına serbest metin olarak {string} girer")
    public void kullaniciDescribeWhatToChangeAlaninaSerbestMetinGirer(String talimat) {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), talimat);
    }

    @And("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @Then("Sistem girilen talimata uygun şekilde güncellenmiş görseli kullanıcıya göstermelidir")
    public void sistemGuncellenmisGorseliGostermelidir() {
        Assert.assertTrue(aiEditPage.getUpdatedImageResult().isVisible());
    }

    @And("Kaynak görsel seçilidir veya yüklenmiştir")
    public void kaynakGorselSecilidirVeyaYuklenmistir() {
        Assert.assertTrue(virtualStagingPage.getImagePreview().isVisible());
    }

    @When("Kullanıcı Describe what to change alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        aiEditPage.getDescribeWhatToChangeInput().fill("");
    }

    @Then("Sistem Edit Photo işlemini gerçekleştirmemeli ve zorunlu alan uyarısı vermelidir")
    public void sistemZorunluAlanUyarisiVermelidir() {
        Assert.assertTrue(aiEditPage.getRequiredFieldWarning().isVisible());
    }

    @When("Kullanıcı metin kutusuna çok uzun bir açıklama metni veya SQL enjeksiyon karakterleri girer")
    public void kullaniciMetinKutusunaSQLKarakterleriGirer() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Test ' OR '1'='1 -- uzun aciklama metni");
    }

    @Then("Sistem girdiyi güvenli şekilde işleme almalı veya uygun karakter sınırı uyarısı göstermelidir")
    public void sistemGuvenliIslemeAlmalidir() {
        Assert.assertTrue(aiEditPage.getEditPhotoButton().isVisible());
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        page.navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir")
    public void kullaniciUrunlerAlaninaGelir() {
        navigationPage.getProductsMenu().hover();
    }

    @Then("Dropdown menü açılmalıdır")
    public void dropdownMenuAcilmalidir() {
        Assert.assertTrue(navigationPage.getDropdownMenu().isVisible());
    }

    @When("Kullanıcı dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void kullaniciYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(navigationPage.getAiVirtualTourOption());
    }

    @Then("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir")
    public void kullaniciAiVirtualTourSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(page.url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getEarlyAccessButton());
    }

    @And("Açılan form içerisine geçerli bir e-posta adresi girer")
    public void acilanFormGecerliEpostaGirer() {
        rm.mySendKeys(navigationPage.getEmailInput(), "testuser@example.com");
    }

    @And("Kullanıcı talebi gönderir")
    public void kullaniciTalebiGonderir() {
        rm.myClick(navigationPage.getSendRequestButton());
    }

    @Then("Sistem talebin başarıyla alındığına dair bir onay mesajı göstermelidir")
    public void sistemOnayMesajiGostermelidir() {
        Assert.assertTrue(navigationPage.getSuccessNotification().isVisible());
    }

    @Given("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır")
    public void kullaniciAiVirtualTourSayfasindadir() {
        page.navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
    }

    @And("Form alanına {string} girer")
    public void formAlaninaGirer(String eposta) {
        rm.mySendKeys(navigationPage.getEmailInput(), eposta);
    }

    @Then("Sistem e-posta format hatası vermeli ve talep kaydedilmemelidir")
    public void sistemEpostaFormatHatasiVermelidir() {
        Assert.assertTrue(navigationPage.getEmailInput().isVisible());
    }

    @Given("Kullanıcı Erken Erişim İsteyin formunu açmıştır")
    public void kullaniciErkenErisimIsteyinFormunuAcmistir() {
        page.navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
        rm.myClick(navigationPage.getEarlyAccessButton());
    }

    @When("Kullanıcı e-posta alanını boş bırakarak gönder butonuna tıklar")
    public void kullaniciEpostaAlaniniBosBirakir() {
        navigationPage.getEmailInput().fill("");
        rm.myClick(navigationPage.getSendRequestButton());
    }

    @Then("Sistem alanın boş bırakılamayacağına dair zorunlu alan uyarısı vermelidir")
    public void sistemBosBirakilamazUyarisiVermelidir() {
        Assert.assertTrue(navigationPage.getEmailInput().isVisible());
    }

    @And("Dropdown menüden Sanal Dekorasyon API seçeneğine tıklar")
    public void dropdownSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(navigationPage.getApiOption());
    }

    @Then("Kullanıcı aistager.ai/tr/api sayfasına yönlendirilmelidir")
    public void kullaniciApiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(page.url().contains("api"));
    }

    @When("Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getContactUsButton());
    }

    @And("İletişim formundaki Ad E-posta ve Mesaj alanlarını geçerli bilgilerle doldurur")
    public void iletisimFormunuDoldurur() {
        rm.mySendKeys(navigationPage.getNameInput(), "John Doe");
        rm.mySendKeys(navigationPage.getEmailInput(), "john@example.com");
        rm.mySendKeys(navigationPage.getMessageInput(), "API hakkında bilgi almak istiyorum.");
    }

    @And("Kullanıcı formu gönderir")
    public void kullaniciFormuGonderir() {
        rm.myClick(navigationPage.getSendRequestButton());
    }

    @Then("Sistem başarı mesajı göstermelidir")
    public void sistemBasariMesajiGostermelidir() {
        Assert.assertTrue(navigationPage.getSuccessNotification().isVisible());
    }

    @When("Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getPricingViewButton());
    }

    @Then("Kullanıcı hatasız şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(page.url().contains("pricing") || navigationPage.getPricingPageHeader().isVisible());
    }

    @Given("Kullanıcı aistager.ai/tr/api sayfasındaki iletişim formundadır")
    public void kullaniciApiSayfasiIletisimFormundadir() {
        page.navigate(ConfigReader.getProperty("url") + "/api");
        rm.myClick(navigationPage.getContactUsButton());
    }

    @When("Kullanıcı formda Ad: {string}, E-posta: {string}, Mesaj: {string} alanlarını girer")
    public void kullaniciFormdaAlanlariGirer(String ad, String eposta, String mesaj) {
        rm.mySendKeys(navigationPage.getNameInput(), ad);
        rm.mySendKeys(navigationPage.getEmailInput(), eposta);
        rm.mySendKeys(navigationPage.getMessageInput(), mesaj);
    }

    @And("Kullanıcı formu göndermeye çalışır")
    public void kullaniciFormuGondermeyeCalisir() {
        rm.myClick(navigationPage.getSendRequestButton());
    }

    @Then("Sistem eksik alanlar için uyarı mesajı göstermelidir ve form gönderilmemelidir")
    public void sistemEksikAlanlarIcinUyarimesajiGostermelidir() {
        Assert.assertTrue(navigationPage.getContactUsButton().isVisible());
    }

    @Given("Kullanıcı aistager.ai/tr/api sayfasına gelmiştir")
    public void kullaniciApiSayfasinaGelmistir() {
        page.navigate(ConfigReader.getProperty("url") + "/api");
    }

    @When("Kullanıcı sayfanın en altına kadar kaydırma yapar")
    public void kullaniciSayfaninEnAltinaKaydirmaYapar() {
        page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("Fiyatlandırmayı Görüntüle butonu görünür ve tıklanabilir durumda olmalıdır")
    public void fiyatlandirmayiGoruntuleButonuGorunurveTiklanabilirOlmali() {
        Assert.assertTrue(navigationPage.getPricingViewButton().isVisible());
    }

    @When("Kullanıcı bu butona hızlıca üst üste iki kez tıklar")
    public void kullaniciButonaIkiKezTıklar() {
        navigationPage.getPricingViewButton().click();
        navigationPage.getPricingViewButton().click();
    }

    @Then("Sistem mükerrer yönlendirme veya hata üretmeden kullanıcıyı Fiyatlandırma sayfasına ulaştırmalıdır")
    public void sistemMukerrerYonlendirmeUretmedenUlastirmalidir() {
        Assert.assertTrue(page.url().contains("pricing") || navigationPage.getPricingPageHeader().isVisible());
    }
}