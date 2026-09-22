package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AIEditPage;
import Pages.LoginPage;
import Pages.NavigationPage;
import Pages.VirtualStagingPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AiStagerSteps {
    LoginPage loginPage = new LoginPage();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AIEditPage aiEditPage = new AIEditPage();
    NavigationPage navigationPage = new NavigationPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı sisteme giriş yapmış durumdadır")
    public void kullaniciSistemeGirisYapmisDurumdadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            rm.myClick(loginPage.getCookiesKabulEtButton());
        } catch (Exception e) {
            // Cookie banner might not appear
        }
    }

    @Given("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/virtual-staging");
    }

    @When("Kullanıcı desteklenen formatta .jpg veya .png bir boş oda görseli yükler")
    public void kullaniciDesteklenenFormattaJpgVeyaPngBirBosOdaGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample_room.jpg");
    }

    @Then("Görselin önizlemesi ekranda görünmelidir")
    public void gorselinOnizlemesiEkrandaGorunmelidir() {
        Assert.assertTrue(virtualStagingPage.getImagePreview().isVisible());
    }

    @And("Mevcut mobilyaları kaldır toggle unsurunun varsayılan olarak açık geldiği görülmelidir")
    public void mevcutMobilyalariKaldirToggleUnsurununVarsayilanOlarakAcikGeldigiGorunmelidir() {
        Assert.assertTrue(virtualStagingPage.getRemoveFurnitureToggle().isChecked());
    }

    @And("Kullanıcı Oda Türü olarak Oturma Odası seçer")
    public void kullaniciOdaTuruOlarakOturmaOdasiSecer() {
        virtualStagingPage.getRoomTypeDropdown().selectOption("Oturma Odası");
    }

    @And("Kullanıcı Tasarım Stili olarak Modern seçer")
    public void kullaniciTasarimStiliOlarakModernSecer() {
        virtualStagingPage.getDesignStyleDropdown().selectOption("Modern");
    }

    @And("Kullanıcı görünürlük tercihlerini belirler")
    public void kullaniciGorunurlukTercihleriniBelirler() {
        rm.myClick(virtualStagingPage.getRemoveFurnitureToggle());
    }

    @And("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getCreateDecorationButton());
    }

    @Then("AI süreci başlamalı ve işlem tamamlandığında oda seçilen stil ve türde mobilyalandırılmış olarak sunulmalıdır")
    public void aiSureciBaslamaliVeIslemTamamlandigindaOdaSecilenStilVeTurdeMobilyalandirilmisOlarakSunulmalidir() {
        rm.veriyfyContainsText(virtualStagingPage.getSuccessMessage(), "Success");
    }

    @When("Kullanıcı desteklenen formatta bir boş oda görseli yükler")
    public void kullaniciDesteklenenFormattaBirBosOdaGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample_room.jpg");
    }

    @And("Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır")
    public void kullaniciOdaTuruVeyaTasarimStiliSecimlerindenBiriniVeyaIkisiniBosBirakir() {
        // Leaving dropdowns unselected intentionally
        Assert.assertTrue(virtualStagingPage.getRoomTypeDropdown().isVisible());
    }

    @Then("Sistem dekorasyon oluşturma işlemine izin vermemeli ve uyarı mesajı göstermelidir")
    public void sistemDekorasyonOlusturmaIslemineIzinVermemeliVeUyariMesajiGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getWarningMessage(), "gerekli");
    }

    @When("Kullanıcı desteklenmeyen formatta örn .gif veya .bmp bir dosya yüklemeye çalışır")
    public void kullaniciDesteklenmeyenFormattaOrnGifVeyaBmpBirDosyaYuklemeyeCalisir() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample.gif");
    }

    @Then("Sistem dosyanın kabul edilmediğine dair bir hata mesajı göstermelidir")
    public void sistemDosyaninKabulEdilmedigineDairBirHataMesajiGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getWarningMessage(), "format");
    }

    @Given("Kullanıcı AI Edit sekmesindedir")
    public void kullaniciAIEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-edit");
    }

    @And("Kaynak görsel olarak varsayılan seçili gelen Current image kullanılmaktadır")
    public void kaynakGorselOlarakVarsayilanSeciliGelenCurrentImageKullanilmaktadir() {
        Assert.assertTrue(aiEditPage.getCurrentImage().isVisible());
    }

    @When("Kullanıcı Describe what to change alanına {string} metin talimatını girer")
    public void kullaniciDescribeWhatToChangeAlaninaMetinTalimatiniGirer(String metinTalimati) {
        rm.mySendKeys(aiEditPage.getDescribeInput(), metinTalimati);
    }

    @And("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @Then("Sistem girilen metin talimatını işlemelidir")
    public void sistemGirilenMetinTalimatiniIslemelidir() {
        rm.veriyfyContainsText(aiEditPage.getAIEditResult(), "Success");
    }

    @And("Görsel üzerinde istenen değişiklikler uygulanarak güncel görsel kullanıcıya sunulmalıdır")
    public void gorselUzerindeIstenenDegisikliklerUygulanarakGuncelGorselKullaniciyaSunulmalidir() {
        Assert.assertTrue(aiEditPage.getAIEditResult().isVisible());
    }

    @When("Kullanıcı AI Edit için yeni bir görsel yükler")
    public void kullaniciAIEditIcinYeniBirGorselYukler() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample_room.jpg");
    }

    @And("Kullanıcı Describe what to change alanına geçerli bir metin talimatı girer")
    public void kullaniciDescribeWhatToChangeAlaninaGecerliBirMetinTalimatiGirer() {
        rm.mySendKeys(aiEditPage.getDescribeInput(), "Add a modern lamp");
    }

    @Then("Sistem güncel görseli başarıyla oluşturup sunmalıdır")
    public void sistemGuncelGorseliBasariylaOlusturupSunmalidir() {
        Assert.assertTrue(aiEditPage.getAIEditResult().isVisible());
    }

    @When("Kullanıcı Describe what to change alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        // Leaving input empty intentionally
        Assert.assertTrue(aiEditPage.getDescribeInput().isVisible());
    }

    @Then("Sistem işleme izin vermemeli ve metin girilmesi gerektiğini belirten bir uyarı göstermelidir")
    public void sistemIslemeIzinVermemeliVeMetinGirilmesiGerektiginiBelirtenBirUyariGostermelidir() {
        rm.veriyfyContainsText(aiEditPage.getAIEditWarning(), "gerekli");
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı header alanındaki Ürünler menüsüne hover yapar")
    public void kullaniciHeaderAlanindakiUrunlerMenusuneHoverYapar() {
        navigationPage.getUrunlerMenu().hover();
    }

    @And("Açılan listeden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanListedenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(navigationPage.getVirtualTourLink());
    }

    @Then("Kullanıcı doğru hedef URL olan \\/tr\\/ai-virtual-tour sayfasına yönlendirilmelidir")
    public void kullaniciDogruHedefUrlOlanTrAiVirtualTourSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/tr/ai-virtual-tour"));
    }

    @Given("Kullanıcı \\/tr\\/ai-virtual-tour sayfasındadır")
    public void kullaniciTrAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-virtual-tour");
    }

    @When("Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciSayfadakiErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getErkenErisimButton());
    }

    @And("Açılan kayıt formunda zorunlu alan olan e-posta adresini girer")
    public void acilanKayitFormundaZorunluAlanOlanEPostaAdresiniGirer() {
        rm.mySendKeys(navigationPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Formu gönderir")
    public void formuGonderir() {
        rm.myClick(navigationPage.getFormSubmitButton());
    }

    @Then("Sistem başarılı kayıt onay mesajını göstermelidir")
    public void sistemBasariliKayitOnayMesajiniGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getSuccessMessage(), "Başarılı");
    }

    @When("Kullanıcı E-posta alanını boş bırakarak formu göndermeye çalışır")
    public void kullaniciEPostaAlaniniBosBirakarakFormuGondermeyeCalisir() {
        rm.myClick(navigationPage.getErkenErisimButton());
        rm.myClick(navigationPage.getFormSubmitButton());
    }

    @Then("Sistem hata mesajı vermeli ve formun gönderilmesini engellemelidir")
    public void sistemHataMesajiVermeliVeFormunGonderilmesiniEngellemelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getWarningMessage(), "zorunlu");
    }

    @And("Açılan listeden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanListedenSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(navigationPage.getAPILink());
    }

    @Then("Kullanıcı doğru hedef URL olan \\/tr\\/api sayfasına yönlendirilmelidir")
    public void kullaniciDogruHedefUrlOlanTrApiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/tr/api"));
    }

    @Given("Kullanıcı \\/tr\\/api sayfasındadır")
    public void kullaniciTrApiSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/api");
    }

    @When("Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar")
    public void kullaniciSayfaUstundekiIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButton());
    }

    @And("İletişim formundaki ad, e-posta ve mesaj alanlarını eksiksiz doldurur")
    public void iletisimFormundakiAdEPostaVeMesajAlanlariniEksiksizDoldurur() {
        rm.mySendKeys(navigationPage.getAdInput(), "Test User");
        rm.mySendKeys(navigationPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(navigationPage.getMesajInput(), "Hello, I want to test API.");
    }

    @Then("Sistem başarılı gönderim mesajı göstermelidir")
    public void sistemBasariliGonderimMesajiGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getSuccessMessage(), "Gönderildi");
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButton());
    }

    @And("Ad, e-posta veya mesaj alanlarından birini boş bırakarak formu gönderir")
    public void adEPostaVeyaMesajAlanlarindanBiriniBosBirakarakFormuGonderir() {
        rm.mySendKeys(navigationPage.getAdInput(), "Test User");
        // Leaving email and message blank intentionally
        rm.myClick(navigationPage.getFormSubmitButton());
    }

    @Then("Sistem eksik alanlar için validasyon uyarıları göstermelidir")
    public void sistemEksikAlanlarIcinValidasyonUyarilariGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getWarningMessage(), "gerekli");
    }

    @When("Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaAltindakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getFiyatlandirmayiGoruntuleButton());
    }

    @Then("Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciHatasizBirSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/pricing"));
    }
}