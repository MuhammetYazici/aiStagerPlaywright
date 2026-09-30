package StepDefinations;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Page;

import Pages.LoginPage;
import Pages.VirtualStagingPage;
import Pages.NavigationPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import Utilities.ConfigReader;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AistagerTestcasesSteps {
    LoginPage loginPage = new LoginPage();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    NavigationPage navigationPage = new NavigationPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadirdir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            rm.myClick(loginPage.getAcceptCookiesButton());
        } catch (Exception e) {
            System.out.println("Çerez banner'ı bulunamadı veya zaten kabul edildi.");
        }
    }

    @Given("Kullanıcı giriş yapmıştır")
    public void kullaniciGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), ConfigReader.getProperty("existing_user_email"));
        rm.mySendKeys(loginPage.getPasswordInput(), ConfigReader.getProperty("existing_user_password"));
        rm.myClick(loginPage.getLoginButton());
    }

    @And("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        Assert.assertTrue(PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("app") || PD.getPage().url().contains("tr"));
    }

    @And("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/virtual-staging");
        rm.veriyfyContainsText(virtualStagingPage.getVirtualStagingHeader(), "Virtual Staging");
    }

    @When("Kullanıcı desteklenen {string} formatında boş bir oda görseli yükler")
    public void kullaniciDesteklenenFormattaBosBirOdaGorseliYukler(String format) {
        System.out.println("Yüklenen görsel formatı: " + format);
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample_room" + format);
    }

    @And("Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak aktif olduğunu görür")
    public void mevcutMobilyalariKaldirSecenegininVarsayilanOlarakAktifOldugunuGorur() {
        Assert.assertTrue(virtualStagingPage.getRemoveFurnitureCheckbox().isChecked());
    }

    @And("Kullanıcı Oda Türü olarak {string} ve Tasarım Stili olarak {string} seçer")
    public void kullaniciOdaTuruOlarakVeTasarimStiliOlarakSecer(String odaTuru, String stil) {
        rm.mySendKeys(virtualStagingPage.getRoomTypeDropdown(), odaTuru);
        rm.mySendKeys(virtualStagingPage.getDesignStyleDropdown(), stil);
    }

    @And("{string} butonuna tıklar")
    public void butonunaTiklar(String butonAdi) {
        if (butonAdi.equals("Dekorasyon Oluştur")) {
            rm.myClick(virtualStagingPage.getCreateDecorationButton());
        } else if (butonAdi.equals("Edit Photo")) {
            rm.myClick(virtualStagingPage.getEditPhotoButton());
        } else if (butonAdi.equals("Erken Erişim Talep Et")) {
            rm.myClick(navigationPage.getEarlyAccessButton());
        } else if (butonAdi.equals("Gönder")) {
            rm.myClick(navigationPage.getSubmitButton());
        } else {
            rm.myClick(PD.getPage().getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName(butonAdi)));
        }
    }

    @Then("Sistem yüklenen odanın yapay zeka tarafından mobilyalandırılmış yeni halini ekranda göstermelidir")
    public void sistemYuklenenOdaninYapayZekaTarafindanMobilyalandirilmisYeniHaliniEkrandaGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getResultImage().isVisible());
    }

    @When("Kullanıcı desteklenmeyen formatta bir dosya yükler {string}")
    public void kullaniciDesteklenmeyenFormattaBirDosyaYukler(String format) {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample" + format);
    }

    @Then("Sistem kullanıcıya uygun formatlarda dosya yüklemesi gerektiğine dair hata mesajı göstermelidir")
    public void sistemKullaniciyaUygunFormatlardaDosyaYuklemesiGerektigineDairHataMesajiGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @And("Dekorasyon Oluştur butonu pasif kalmalıdır")
    public void dekorasyonOlusturButonuPasifKalmalidir() {
        Assert.assertFalse(virtualStagingPage.getCreateDecorationButton().isEnabled());
    }

    @When("Kullanıcı izin verilen maksimum boyut sınırını aşan bir {string} görseli yükler")
    public void kullaniciIzinVerilenMaksimumBoyutSiniriniAsanBirGorseliYukler(String format) {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/large_image" + format);
    }

    @Then("Sistem görsel boyutunun çok büyük olduğuna dair bir uyarı mesajı göstermelidir")
    public void sistemGorselBoyutununCokBuyukOldugunaDairBirUyariMesajiGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @And("Kullanıcı Virtual Staging sayfasında AI Edit sekmesindedir")
    public void kullaniciVirtualStagingSayfasindaAIEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/virtual-staging/ai-edit");
        rm.myClick(virtualStagingPage.getAiEditTab());
    }

    @When("Kullanıcı mevcut kaynak görseli seçer")
    public void kullaniciMevcutKaynakGorseliSecer() {
        rm.myClick(virtualStagingPage.getSourceImageSelector());
    }

    @And("Describe what to change alanına {string} talimatını yazar")
    public void describeWhatToChangeAlaninaTalimatiniYazar(String talimat) {
        rm.mySendKeys(virtualStagingPage.getDescribeInput(), talimat);
    }

    @Then("Sistem, girilen talimata uygun olarak görseli güncellemeli ve güncel hali ekranda göstermelidir")
    public void sistemGirilenTalimataUygunOlarakGorseliGuncellemeliVeGuncelHaliEkrandaGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getResultImage().isVisible());
    }

    @And("Describe what to change alanını boş bırakır")
    public void describeWhatToChangeAlaniniBosBirakir() {
        virtualStagingPage.getDescribeInput().fill("");
    }

    @Then("Sistem kullanıcının talimat girmesi gerektiğini belirten bir uyarı mesajı göstermelidir")
    public void sistemKullanicininTalimatGirmesiGerektiginiBelirtenBirUyariMesajiGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @And("Görsel düzenleme işlemi tetiklenmemelidir")
    public void gorselDuzenlemeIslemiTetiklenmemelidir() {
        Assert.assertFalse(virtualStagingPage.getResultImage().isVisible());
    }

    @When("Kullanıcı sistemdeki kaynak görsel yerine yeni bir {string} görseli yükler")
    public void kullaniciSistemdekiKaynakGorselYerineYeniBirGorseliYukler(String format) {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/new_image" + format);
    }

    @Then("Sistem yeni yüklenen görsel üzerinden talimatı uygulamalı ve sonucu ekranda göstermelidir")
    public void sistemYeniYuklenenGorselUzerindenTalimatiUygulamaliVeSonucuEkrandaGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getResultImage().isVisible());
    }

    @And("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr");
        Assert.assertTrue(PD.getPage().url().contains("/tr"));
    }

    @When("Kullanıcı Header üzerindeki Ürünler menüsünün üzerine gelir")
    public void kullaniciHeaderUzerindekiUrunlerMenusununUzerineGelir() {
        navigationPage.getProductsMenu().hover();
    }

    @And("Açılan dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanDropdownMenudenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(navigationPage.getVirtualTourOption());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidir(String urlPath) {
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @And("Açılan dropdown menüden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanDropdownMenudenSanalDekorasyonAPIsecenegineTiklar() {
        rm.myClick(navigationPage.getApiOption());
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String urlPath) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + urlPath);
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("Kullanıcı erken erişim formundaki zorunlu alan olan E-posta adresini geçerli formatta girer {string}")
    public void kullaniciErkenErisimFormundakiZorunluAlanOlanEpostaAdresiniGecerliFormattaGirer(String email) {
        rm.mySendKeys(navigationPage.getEarlyAccessEmailInput(), email);
    }

    @Then("Kullanıcı talebinin başarıyla alındığına dair onay mesajı görmelidir")
    public void kullaniciTalebininBasariylaAlindiginaDairOnayMesajiGormelidir() {
        Assert.assertTrue(navigationPage.getSuccessMessage().isVisible());
    }

    @When("Kullanıcı erken erişim formuna geçersiz bir e-posta adresi girer {string}")
    public void kullaniciErkenErisimFormunaGecersizBirEpostaAdresiGirer(String gecersizEmail) {
        rm.mySendKeys(navigationPage.getEarlyAccessEmailInput(), gecersizEmail);
    }

    @Then("Sistem e-posta formatının hatalı olduğuna dair bir doğrulama mesajı göstermelidir")
    public void sistemEpostaFormatininHataliOldugunaDairBirDogrulamaMesajiGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getErrorMessage().isVisible());
    }

    @And("Form gönderilmemelidir")
    public void formGonderilmemelidir() {
        Assert.assertFalse(navigationPage.getSuccessMessage().isVisible());
    }

    @Given("Kullanıcı {string} sayfazasındadır")
    public void kullaniciSayfazasindadir(String urlPath) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + urlPath);
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("Kullanıcı API iletişim formundaki zorunlu alanları doldurur")
    public void kullaniciApiIletisimFormundakiZorunluAlanlariDoldurur() {
        rm.mySendKeys(navigationPage.getApiFormNameInput(), "Test User");
        rm.mySendKeys(navigationPage.getApiFormEmailInput(), "api_test@example.com");
    }

    @Then("Başarılı gönderim mesajı ekranda görünmelidir")
    public void basariliGonderimMesajiEkrandaGorunmelidir() {
        Assert.assertTrue(navigationPage.getSuccessMessage().isVisible());
    }

    @When("Kullanıcı sayfadaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfadakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getPricingButton());
    }

    @Then("Kullanıcı doğru şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciDogruSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing") || PD.getPage().url().contains("fiyat"));
    }
}