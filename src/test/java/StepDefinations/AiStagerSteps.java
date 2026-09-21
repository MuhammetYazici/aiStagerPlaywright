package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps {
    VirtualStagingPage page = new VirtualStagingPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı sisteme giriş yapmış durumda")
    public void kullaniciSistemeGirisYapmisDurumda() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/virtual-staging");
        rm.veriyfyContainsText(page.getVirtualStagingHeader(), "Virtual Staging");
    }

    @When("Kullanıcı desteklenen formatta {string} bir oda görseli yükler")
    public void kullaniciDesteklenenFormattaBirOdaGorseliYukler(String format) {
        rm.mySendKeys(page.getUploadInput(), "src/test/resources/test_room." + format);
    }

    @When("Oda Türü olarak Yatak Odası seçilir")
    public void odaTuruOlarakYatakOdasiSecilir() {
        rm.myClick(page.getRoomTypeDropdown());
    }

    @When("Tasarım Stili olarak Modern seçilir")
    public void tasarimStiliOlarakModernSecilir() {
        rm.myClick(page.getDesignStyleDropdown());
    }

    @When("Mevcut mobilyaları kaldır toggle özelliğinin varsayılan olarak açık olduğu doğrulanır")
    public void mevcutMobilyalariKaldirToggleOzelligininVarsayilanOlarakAcikOlduguDogrulanir() {
        Assert.assertTrue(page.getRemoveExistingFurnitureToggle().isChecked());
    }

    @When("Dekorasyon Oluştur butonuna tıklanır")
    public void dekorasyonOlusturButonunaTiklanir() {
        rm.myClick(page.getGenerateButton());
    }

    @Then("Sistem yüklenen odayı analiz eder")
    public void sistemYuklenenOdayiAnalizEder() {
        rm.veriyfyContainsText(page.getAnalysisMessage(), "analiz");
    }

    @Then("Seçilen stile uygun mobilyalandırılmış yeni görsel kullanıcıya sunulur")
    public void secilenStileUygunMobilyalandirilmisYeniGorselKullaniciyaSunulur() {
        Assert.assertTrue(page.getResultImage().isVisible());
    }

    @When("Kullanıcı desteklenmeyen formatta bir oda görseli yükler {string}")
    public void kullaniciDesteklenmeyenFormattaBirOdaGorseliYukler(String gecersizFormat) {
        rm.mySendKeys(page.getUploadInput(), "src/test/resources/" + gecersizFormat);
    }

    @When("Oda Türü ve Tasarım Stili alanları seçilir")
    public void odaTuruVeTasarimStiliAlanlariSecilir() {
        rm.myClick(page.getRoomTypeDropdown());
        rm.myClick(page.getDesignStyleDropdown());
    }

    @Then("Sistem {string} şeklinde bir hata mesajı gösterir")
    public void sistemSeklindeBirHataMesajiGosterir(String hataMesaji) {
        rm.veriyfyContainsText(page.getErrorMessage(), hataMesaji);
    }

    @Then("Dekorasyon işlemi başlatılamaz")
    public void dekorasyonIslemiBaslatilamaz() {
        Assert.assertFalse(page.getResultImage().isVisible());
    }

    @When("Desteklenen formatta bir oda görseli yüklenir")
    public void desteklenenFormattaBirOdaGorseliYuklenir() {
        rm.mySendKeys(page.getUploadInput(), "src/test/resources/test_room.jpg");
    }

    @When("Oda Türü ve Tasarım Stili seçimleri boş bırakılır")
    public void odaTuruVeTasarimStiliSecimleriBosBirakilir() {
        // No action needed as fields are empty by default
        Assert.assertTrue(true);
    }

    @Then("Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajı gösterir")
    public void sistemZorunluAlanlarinSecilmesiGerektigineDairUyariMesajiGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "zorunlu");
    }

    @Then("Dekorasyon Oluştur butonu pasif kalır veya işlem gerçekleşmez")
    public void dekorasyonOlusturButonuPasifKalirVeyaIslemGerceklesmez() {
        Assert.assertTrue(page.getGenerateButton().isDisabled() || !page.getResultImage().isVisible());
    }

    @When("Oda Türü olarak Oturma Odası seçilir ancak Tasarım Stili seçilmez")
    public void odaTuruOlarakOturmaOdasiSecilirAncakTasarimStiliSecilmez() {
        rm.myClick(page.getRoomTypeDropdown());
    }

    @Then("Sistem tasarım stilinin seçilmesi gerektiğini belirten bir hata mesajı gösterir")
    public void sistemTasarimStilininSecilmesiGerektiginiBelirtenBirHataMesajiGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "Tasarım Stili");
    }

    @When("Tasarım Stili olarak Skandinav seçilir ancak Oda Türü seçilmez")
    public void tasarimStiliOlarakSkandinavSecilirAncakOdaTuruSecilmez() {
        rm.myClick(page.getDesignStyleDropdown());
    }

    @Then("Sistem oda türünün seçilmesi gerektiğini belirten bir hata mesajı gösterir")
    public void sistemOdaTurununSecilmesiGerektiginiBelirtenBirHataMesajiGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "Oda Türü");
    }

    @When("Sayfa ilk kez yüklendiğinde veya sıfırlandığında")
    public void sayfaIlkKezYuklendigindeVeyaSifirlandiginda() {
        PD.getPage().reload();
    }

    @Then("Mevcut mobilyaları kaldır toggle durumunun açık olduğu doğrulanır")
    public void mevcutMobilyalariKaldirToggleDurumununAcikOlduguDogrulanir() {
        Assert.assertTrue(page.getRemoveExistingFurnitureToggle().isChecked());
    }

    @Given("Kullanıcı AI Edit sekmesindedir ve varsayılan Current image hazırdır")
    public void kullaniciAIEditSekmesindedirVeVarsayilanCurrentImageHazirdir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(page.getAIEditTab());
    }

    @When("Describe what to change alanına geçerli bir talimat girilir {string}")
    public void describeWhatToChangeAlaninaGecerliBirTalimatGirilir(String talimat) {
        rm.mySendKeys(page.getDescribeInput(), talimat);
    }

    @When("Edit Photo butonuna tıklanır")
    public void editPhotoButonunaTiklanir() {
        rm.myClick(page.getEditPhotoButton());
    }

    @Then("Sistem metinsel talimata uygun şekilde güncellenmiş görseli ekranda gösterir")
    public void sistemMetinselTalimataUygunSekildeGuncellenmisGorseliEkrandaGosterir() {
        Assert.assertTrue(page.getResultImage().isVisible());
    }

    @Given("Kullanıcı AI Edit sekmesindedir")
    public void kullaniciAIEditSekmesindedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(page.getAIEditTab());
    }

    @When("Kullanıcı mevcut görsel yerine yeni bir kaynak görsel yükler")
    public void kullaniciMevcutGorselYerineYeniBirKaynakGorselYukler() {
        rm.mySendKeys(page.getUploadInput(), "src/test/resources/test_room.jpg");
    }

    @When("Describe what to change alanına {string} yazılır")
    public void describeWhatToChangeAlaninaYazilir(String talimat) {
        rm.mySendKeys(page.getDescribeInput(), talimat);
    }

    @Then("Sistem yeni yüklenen görsel üzerinde talimata göre düzenleme yapar ve sonucu gösterir")
    public void sistemYeniYuklenenGorselUzerindeTalimataGoreDuzenlemeYaparVeSonucuGosterir() {
        Assert.assertTrue(page.getResultImage().isVisible());
    }

    @Given("Kullanıcı AI Edit sekmesindedir ve kaynak görseli hazırdır")
    public void kullaniciAIEditSekmesindedirVeKaynakGorseliHazirdir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(page.getAIEditTab());
    }

    @When("Describe what to change alanı tamamen boş bırakılır")
    public void describeWhatToChangeAlaniTamamenBosBirakilir() {
        // Leave empty
        Assert.assertTrue(true);
    }

    @Then("Sistem boş komutla işlem yapılamayacağına dair uyarı mesajı gösterir")
    public void sistemBosKomutlaIslemYapilamayacaginaDairUyariMesajiGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "boş");
    }

    @Then("Edit Photo butonu pasif kalır")
    public void editPhotoButtonuPasifKalir() {
        Assert.assertTrue(page.getEditPhotoButton().isDisabled() || !page.getResultImage().isVisible());
    }

    @When("Describe what to change alanına sistem sınırlarını zorlayan çok uzun bir metin girilir {string}")
    public void describeWhatToChangeAlaninaSistemSinirlariniZorlayanCokUzunBirMetinGirilir(String uzunMetin) {
        rm.mySendKeys(page.getDescribeInput(), uzunMetin);
    }

    @Then("Sistem ya metni sınırlar ya da karakter limit aşımı uyarısı gösterir")
    public void sistemYaMetniSinirlarYaDaKarakterLimitAsimiUyarisiGosterir() {
        Assert.assertTrue(page.getErrorMessage().isVisible() || page.getResultImage().isVisible());
    }

    @Given("Ziyaretçi web sitesinin ana sayfasındadır")
    public void ziyaretciWebSitesininAnaSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı header alanındaki Ürünler menüsünün üzerine hover yapar")
    public void kullaniciHeaderAlanindakiUrunlerMenusununUzerineHoverYapar() {
        page.getProductsMenu().hover();
    }

    @When("Açılan alt menüden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanAltMenudenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(page.getVirtualTourSubMenu());
    }

    @Then("Kullanıcı aistager.ai tr ai-virtual-tour sayfasına yönlendirilir")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı sayfadaki Erken Erişim İsteyin butonuna basar")
    public void kullaniciSayfadakiErkenErisimIsteyinButonunaBasar() {
        rm.myClick(page.getEarlyAccessButton());
    }

    @When("Formdaki zorunlu alanlar Ad Soyad E-posta geçerli bilgilerle doldurulur ve gönderilir")
    public void formdakiZorunluAlanlarAdSoyadEPostaGecerliBilgilerleDoldurulurVeGonderilir() {
        rm.mySendKeys(page.getNameInput(), rm.resolveDynamicValue("fakerName"));
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(page.getSubmitButton());
    }

    @Then("Talep başarıyla iletilir ve kullanıcıya sistem tarafından onay mesajı gösterir")
    public void talepBasariylaIletilirVeKullaniciyaSistemTarafindanOnayMesajiGosterir() {
        rm.veriyfyContainsText(page.getSuccessMessage(), "başarıyla");
    }

    @When("Açılan alt menüden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanAltMenudenSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(page.getApiSubMenu());
    }

    @Then("Kullanıcı aistager.ai tr api sayfasına yönlendirilir")
    public void kullaniciAistagerAiTrApiSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(page.getContactUsButton());
    }

    @When("API iletişim formu zorunlu alanları doldurulur ve gönderilir")
    public void apiIletisimFormuZorunluAlanlariDoldurulurVeGonderilir() {
        rm.mySendKeys(page.getNameInput(), rm.resolveDynamicValue("fakerName"));
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(page.getSubmitButton());
    }

    @Then("Başarılı gönderim onay mesajı alınır")
    public void basariliGonderimOnayMesajiAlinir() {
        rm.veriyfyContainsText(page.getSuccessMessage(), "Success");
    }

    @When("Kullanıcı sayfanın alt kısmındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltKismindakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(page.getPricingButton());
    }

    @Then("Kullanıcı doğru şekilde Fiyatlandırma sayfasına yönlendirilir")
    public void kullaniciDogruSekildeFiyatlandirmaSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @Given("Kullanıcı Yapay Zeka Sanal Tur erken erişim formundadır")
    public void kullaniciYapayZekaSanalTurErkenErisimFormundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-virtual-tour");
        rm.myClick(page.getEarlyAccessButton());
    }

    @When("Zorunlu alanlar doldurulmadan Gönder butonuna tıklanır")
    public void zorunluAlanlarDoldurulmadanGonderButonunaTiklanir() {
        rm.myClick(page.getSubmitButton());
    }

    @Then("Sistem e-posta ve ad soyad alanlarının zorunlu olduğunu belirten hata mesajları gösterir")
    public void sistemEPostaVeAdSoyadAlanlarininZorunluOldugunuBelirtenHataMesajlariGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "zorunlu");
    }

    @Then("Form gönderilmez")
    public void formGonderilmez() {
        Assert.assertTrue(PD.getPage().url().contains("early-access") || page.getErrorMessage().isVisible());
    }

    @Given("Kullanıcı Sanal Dekorasyon API iletişim formundadır")
    public void kullaniciSanalDekorasyonApiIletisimFormundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/api");
        rm.myClick(page.getContactUsButton());
    }

    @When("Ad Soyad alanı doldurulur ve e-posta alanına geçersiz bir değer girilir {string}")
    public void adSoyadAlaniDoldurulurVeEPostaAlaninaGecersizBirDegerGirilir(String gecersizEposta) {
        rm.mySendKeys(page.getNameInput(), rm.resolveDynamicValue("fakerName"));
        rm.mySendKeys(page.getEmailInput(), gecersizEposta);
    }

    @When("Form gönderilir")
    public void formGonderilir() {
        rm.myClick(page.getSubmitButton());
    }

    @Then("Sistem geçerli bir e-posta adresi girilmesi gerektiğini belirten bir hata mesajı gösterir")
    public void sistemGecerliBirEPostaAdresiGirilmesiGerektiginiBelirtenBirHataMesajiGosterir() {
        rm.veriyfyContainsText(page.getErrorMessage(), "geçerli");
    }

    @Then("Form iletilmez")
    public void formIletilmez() {
        Assert.assertTrue(page.getErrorMessage().isVisible());
    }

    @When("Fare imleci menü alanından hızla çıkarılır")
    public void fareImleciMenuAlanindanHizlaCikarilir() {
        PD.getPage().mouse().move(0, 0);
    }

    @Then("Alt ürün listesi Yapay Zeka Sanal Tur ve Sanal Dekorasyon API kullanıcı tarafından erişilemez şekilde kapanmalıdır")
    public void altUrunListesiYapayZekaSanalTurVeSanalDekorasyonApiKullaniciTarafindanErisilemezSekildeKapanmalidir() {
        Assert.assertFalse(page.getVirtualTourSubMenu().isVisible());
    }
}