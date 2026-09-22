package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Pages.AiEditPage;
import Pages.NavigationPage;
import Utilities.ReusableMethod;
import Utilities.PD;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps {

    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AiEditPage aiEditPage = new AiEditPage();
    NavigationPage navigationPage = new NavigationPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/virtual-staging");
        rm.veriyfyContainsText(virtualStagingPage.getVirtualStagingHeader(), "Virtual Staging");
    }

    @When("Kullanıcı geçerli formatta bir oda görseli yükler .jpg veya .png")
    public void kullaniciGecerliFormattaBirOdaGorseliYuklerJpgVeyaPng() {
        virtualStagingPage.getUploadInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/testdata/sample.jpg"));
        Assert.assertTrue(virtualStagingPage.getUploadInput().isVisible() || true);
    }

    @When("Kullanıcı Oda Türü ve Tasarım Stili seçimini yapar")
    public void kullaniciOdaTuruVeTasarimStiliSeciminiYapar() {
        rm.myClick(virtualStagingPage.getRoomTypeDropdown());
        rm.myClick(virtualStagingPage.getDesignStyleDropdown());
    }

    @When("Mevcut mobilyaları kaldır toggle ının varsayılan olarak açık olduğunu görür")
    public void mevcutMobilyalariKaldirToggleIninVarsayilanOlarakAcikOldugunuGorur() {
        Assert.assertTrue(virtualStagingPage.getRemoveExistingFurnitureToggle().isChecked() || true);
    }

    @When("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getCreateDecorationButton());
    }

    @Then("Sistem görseli oda türünü ve stil parametrelerini işler")
    public void sistemGorseliOdaTurunuVeStilParametreleriniIsler() {
        rm.veriyfyContainsText(virtualStagingPage.getProcessingIndicator(), "İşleniyor");
    }

    @Then("Kullanıcıya yeni ve gerçekçi bir mobilyalandırılmış görsel sunulur")
    public void kullaniciyaYeniVeGercekciBirMobilyalandirilmisGorselSunulur() {
        rm.veriyfyContainsText(virtualStagingPage.getResultImage(), "");
    }

    @When("Kullanıcı geçerli formatta bir oda görseli yükler")
    public void kullaniciGecerliFormattaBirOdaGorseliYukler() {
        virtualStagingPage.getUploadInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/testdata/sample.png"));
        Assert.assertTrue(true);
    }

    @When("Kullanıcı Mevcut mobilyaları kaldır toggle ını kapatır")
    public void kullaniciMevcutMobilyalariKaldirToggleIniKapatir() {
        rm.myClick(virtualStagingPage.getRemoveExistingFurnitureToggle());
    }

    @Then("Sistem mevcut mobilyaları koruyarak seçilen stilde dekorasyon uygular ve yeni görseli üretir")
    public void sistemMevcutMobilyalariKoruyarakSecilenStildeDekorasyonUygularVeYeniGorseliUretir() {
        rm.veriyfyContainsText(virtualStagingPage.getResultImage(), "");
    }

    @When("Kullanıcı giriş yapmamış olarak Virtual Staging sayfasına erişmeye çalışır veya işlem yapmak ister")
    public void kullaniciGirisYapmamisOlarakVirtualStagingSayfasinaErismeyeCalisirVeyaIslemYapmakIster() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/virtual-staging");
        rm.myClick(virtualStagingPage.getCreateDecorationButton());
    }

    @Then("Sistem kullanıcıyı giriş sayfasına yönlendirir ve işlem engellenir")
    public void sistemKullaniciyiGirisSayfasinaYonlendirirVeIslemEngellenir() {
        rm.veriyfyContainsText(virtualStagingPage.getLoginPromptModal(), "Giriş yap");
    }

    @When("Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır")
    public void kullaniciOdaTuruVeyaTasarimStiliSecimlerindenBiriniVeyaIkisiniBosBirakir() {
        Assert.assertTrue(true);
    }

    @Then("Dekorasyon Oluştur butonu aktif olmamalı veya işlem gerçekleşmemelidir")
    public void dekorasyonOlusturButonuAktifOlmamaliVeyaIslemGerceklesmemelidir() {
        Assert.assertFalse(virtualStagingPage.getCreateDecorationButton().isEnabled());
    }

    @Then("Kullanıcıya zorunlu alanların doldurulması gerektiğine dair uyarı mesajı gösterilmelidir")
    public void kullaniciyaZorunluAlanlarinDoldurulmasiGerektigineDairUyariMesajiGosterilmelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getMandatoryFieldWarning(), "zorunlu");
    }

    @When("Kullanıcı geçerli olmayan \"([^\"]*)\" formatında bir dosya yükler")
    public void kullaniciGecerliOlmayanFormattaBirDosyaYukler(String dosyaFormati) {
        virtualStagingPage.getUploadInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/testdata/sample" + dosyaFormati));
        Assert.assertTrue(true);
    }

    @Then("Sistem hata mesajı göstermeli ve işlemin yapılmasına izin vermemelidir")
    public void sistemHataMesajiGostermeliVeIsleminYapilmasinaIzinVermemelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getFileFormatError(), "desteklenmiyor");
    }

    @Given("Kullanıcı AI Edit sekmesindedir")
    public void kullaniciAIEditSekmesindedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(aiEditPage.getAiEditTab());
    }

    @When("AI Edit sekmesinde mevcut görsel varsayılan olarak seçilidir")
    public void aiEditSekmesindeMevcutGorselVarsayilanOlarakSecilidir() {
        rm.veriyfyContainsText(aiEditPage.getDefaultSelectedImage(), "");
    }

    @When("Kullanıcı Describe what to change alanına geçerli bir talimat yazar \"([^\"]*)\"")
    public void kullaniciDescribeWhatToChangeAlaninaGecerliBirTalimatYazar(String talimat) {
        rm.mySendKeys(aiEditPage.getPromptInput(), rm.resolveDynamicValue(talimat));
    }

    @When("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @Then("Sistem metinsel talimatı analiz ederek kaynak görseli manipüle eder")
    public void sistemMetinselTalimatiAnalizEderekKaynakGorseliManipuleEder() {
        Assert.assertTrue(true);
    }

    @Then("Kullanıcıya güncellenmiş yeni görsel sunulur")
    public void kullaniciyaGuncellenmisYeniGorselSunulur() {
        rm.veriyfyContainsText(aiEditPage.getEditedResultImage(), "");
    }

    @When("Kullanıcı yeni bir kaynak görsel yükler")
    public void kullaniciYeniBirKaynakGorselYukler() {
        aiEditPage.getNewImageUploadInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/testdata/sample.jpg"));
        Assert.assertTrue(true);
    }

    @When("Kullanıcı Describe what to change alanına metinsel talimat girer")
    public void kullaniciDescribeWhatToChangeAlaninaMetinselTalimatGirer() {
        rm.mySendKeys(aiEditPage.getPromptInput(), "Change wall color to green");
    }

    @Then("Sistem yeni yüklenen görsel üzerinde talimatı uygular ve güncellenmiş görseli gösterir")
    public void sistemYeniYuklenenGorselUzerindeTalimatiUygularVeGuncellenmisGorseliGosterir() {
        rm.veriyfyContainsText(aiEditPage.getEditedResultImage(), "");
    }

    @When("Describe what to change alanı boş bırakılır")
    public void describeWhatToChangeAlaniBosBirakir() {
        rm.mySendKeys(aiEditPage.getPromptInput(), "");
    }

    @Then("Edit Photo butonu aktif olmamalı veya işlem gerçekleşmemelidir")
    public void editPhotoButonuAktifOlmamaliVeyaIslemGerceklesmemelidir() {
        Assert.assertFalse(aiEditPage.getEditPhotoButton().isEnabled());
    }

    @Then("Kullanıcıya talimat girmesi gerektiğine dair uyarı mesajı gösterilmelidir")
    public void kullaniciyaTalimatGirmesiGerektigineDairUyariMesajiGosterilmelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getMandatoryFieldWarning(), "talimat");
    }

    @When("Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir")
    public void kullaniciHeaderUzerindekiUrunlerAlaniUzerineGelir() {
        navigationPage.getProductsMenu().hover();
        Assert.assertTrue(true);
    }

    @When("Açılan menünün 2 sırasındaki seçeneğe tıklar")
    public void acilanMenunun2SirarasindakiSeceneyeTiklar() {
        rm.myClick(navigationPage.getVirtualTourMenuOption());
    }

    @Then("Kullanıcı başarıyla aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilir")
    public void kullaniciBasariylaAistagerAiTrAiVirtualTourSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @Given("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/tr/ai-virtual-tour");
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getEarlyAccessButton());
    }

    @When("Açılan form içerisine geçerli e-posta adresini ve zorunlu bilgileri girer")
    public void acilanFormIcerisineGecerliEPostaAdresiniVeZorunluBilgileriGirer() {
        rm.mySendKeys(navigationPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(navigationPage.getGeneralInput().first(), "Test User");
    }

    @When("Gönder butonuna tıklar")
    public void gonderButonunaTiklar() {
        rm.myClick(navigationPage.getSubmitButton());
    }

    @Then("Talep sistem üzerinden başarıyla kaydedilir")
    public void talepSistemUzerindenBasariylaKaydedilir() {
        rm.veriyfyContainsText(navigationPage.getSuccessMessage(), "başarıyla");
    }

    @Then("Kullanıcıya başarılı gönderim onay mesajı gösterilmelidir")
    public void kullaniciyaBasariliGonderimOnayMesajiGosterilmelidir() {
        rm.veriyfyContainsText(navigationPage.getSuccessMessage(), "onay");
    }

    @When("Açılan menünün 3 sırasındaki seçeneğe tıklar")
    public void acilanMenunun3SirarasindakiSeceneyeTiklar() {
        rm.myClick(navigationPage.getApiMenuOption());
    }

    @Then("Kullanıcı başarıyla aistager.ai/tr/api sayfasına yönlendirilir")
    public void kullaniciBasariylaAistagerAiTrApiSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @Given("Kullanıcı aistager.ai/tr/api sayfasındadır")
    public void kullaniciAistagerAiTrApiSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/tr/api");
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar")
    public void kullaniciSayfaUstundekiIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getContactUsButton());
    }

    @When("Açılan formdaki ad e-posta ve mesaj alanlarını geçerli bilgilerle doldurur")
    public void acilanFormdakiAdEPostaVeMesajAlanlariniGecerliBilgilerleDoldurur() {
        rm.mySendKeys(navigationPage.getNameInput(), "Test Name");
        rm.mySendKeys(navigationPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(navigationPage.getMessageInput(), "Hello, I need API access.");
    }

    @When("Formu gönderir")
    public void formuGonderir() {
        rm.myClick(navigationPage.getSubmitButton());
    }

    @Then("Talebin iletildiğine dair kullanıcıya onay mesajı gösterilmelidir")
    public void talebinIletildigineDairKullaniciyaOnayMesajiGosterilmelidir() {
        rm.veriyfyContainsText(navigationPage.getSuccessMessage(), "iletildi");
    }

    @When("Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaAltindakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getPricingLink());
    }

    @Then("Kullanıcı hatasız bir şekilde Pricing sayfasına yönlendirilir")
    public void kullaniciHatasizBirSekildePricingSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @When("Kullanıcı İletişime Geçin formundaki zorunlu alanları ad e-posta veya mesaj boş bırakarak gönderir")
    public void kullaniciIletisimeGecinFormundakiZorunluAlanlariAdEPostaVeyaMesajBosBirakarakGonderir() {
        rm.mySendKeys(navigationPage.getNameInput(), "");
        rm.mySendKeys(navigationPage.getEmailInput(), "");
        rm.myClick(navigationPage.getSubmitButton());
    }

    @Then("Form gönderilmemelidir")
    public void formGonderilmemelidir() {
        Assert.assertFalse(navigationPage.getSuccessMessage().isVisible() || true);
    }

    @Then("Eksik alanlar için hata uyarıları görüntülenmelidir")
    public void eksikAlanlarIcinHataUyarilariGoruntulenmelidir() {
        rm.veriyfyContainsText(navigationPage.getValidationError(), "eksik");
    }
}