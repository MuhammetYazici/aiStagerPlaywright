package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AIEditPage;
import Pages.HomePage;
import Pages.VirtualStagingPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AistagerTestcasesSteps {

    ReusableMethod rm = new ReusableMethod();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AIEditPage aiEditPage = new AIEditPage();
    HomePage homePage = new HomePage();

    @Given("Kullanici AiStager platformundadir")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Given("Kullanici Virtual Staging sayfasindadir")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
    }

    @When("Kullanıcı {string} formatındaki boş oda görselini sürükle-bırak yöntemiyle yükler")
    public void kullaniciFormatindakiBosOdaGorseliniSurukleBirakYontemiyleYukler(String format) {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample" + format);
    }

    @Then("Gorsel sisteme basarili bir sekilde yuklenmelidir")
    public void gorselSistemeBasariliBirSekildeYuklenmelidir() {
        Assert.assertTrue(virtualStagingPage.getUploadedImagePreview().isVisible());
    }

    @And("Yuklenen gorselin onizlemesi kullaniciya gosterilmelidir")
    public void yuklenenGorselinOnizlemesiKullaniciyaGosterilmelidir() {
        Assert.assertTrue(virtualStagingPage.getUploadedImagePreview().isVisible());
    }

    @When("Kullanıcı {string} formatındaki bir dosyayı yüklemeye çalışır")
    public void kullaniciFormatindakiBirDosyayiYuklemeyeCalisir(String gecersizFormat) {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample" + gecersizFormat);
    }

    @Then("Sistem Gecersiz dosya formati hata mesaji gostermelidir")
    public void sistemGecersizDosyaFormatiHataMesajiGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getErrorMessage(), "Geçersiz");
    }

    @And("Onizleme alani bos kalmalidir")
    public void onizlemeAlaniBosKalmalidir() {
        Assert.assertFalse(virtualStagingPage.getPreviewSize().isVisible());
    }

    @When("Kullanıcı izin verilen maksimum dosya boyutunda bir .jpg görseli yükler")
    public void kullaniciIzinVerilenMaksimumDosyaBoyutundaBirJpgGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/max_size.jpg");
    }

    @Then("Görsel başarıyla yüklenmeli ve önizlemesi gösterilmelidir")
    public void gorselBasariylaYuklenmeliVeOnizlemesiGosterilmelidir() {
        Assert.assertTrue(virtualStagingPage.getUploadedImagePreview().isVisible());
    }

    @When("Kullanıcı izin verilen maksimum boyuttan daha büyük bir görsel yüklemeye çalışır")
    public void kullaniciIzinVerilenMaksimumBoyuttanDahaBuyukBirGorselYuklemeyeCalisir() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/oversized.jpg");
    }

    @Then("Sistem Dosya boyutu cok buyuk uyarisi vermelidir")
    public void sistemDosyaBoyutuCokBuyukUyarisiVermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getMaxSizeErrorMessage(), "büyük");
    }

    @When("Kullanıcı \"Oda Türü\" olarak \"Oturma Odası\" seçer")
    public void kullaniciOdaTuruOlarakOturmaOdasiSecer() {
        rm.mySendKeys(virtualStagingPage.getRoomTypeDropdown(), "Oturma Odası");
    }

    @And("Kullanıcı \"Tasarım Stili\" olarak \"Modern\" seçer")
    public void kullaniciTasarimStiliOlarakModernSecer() {
        rm.mySendKeys(virtualStagingPage.getDesignStyleDropdown(), "Modern");
    }

    @Then("Mevcut mobilyalari kaldir toggle'inin varsayilan olarak acik ON geldigi gorulmelidir")
    public void mevcutMobilyalariKaldirToggleIninVarsayilanOlarakAcikONGeldigiGorulmelidir() {
        Assert.assertTrue(virtualStagingPage.getRemoveExistingFurnitureToggle().isChecked());
    }

    @And("Kullanıcı gorunurluk tercihlerinden bir radio buton secebilmelidir")
    public void kullaniciGorunurlukTercihlerindenBirRadioButonSecebilmelidir() {
        rm.myClick(virtualStagingPage.getVisibilityRadioButton());
        Assert.assertTrue(virtualStagingPage.getVisibilityRadioButton().isChecked());
    }

    @When("Kullanıcı \"Oda Türü\" alanını \"{string}\" ve \"Tasarım Stili\" alanını \"{string}\" bırakır")
    public void kullaniciOdaTuruAlaniniVeTasarimStiliAlaniniBirakir(String odaTuru, String stil) {
        if (!odaTuru.equals("Secilmedi")) {
            rm.mySendKeys(virtualStagingPage.getRoomTypeDropdown(), odaTuru);
        }
        if (!stil.equals("Secilmedi")) {
            rm.mySendKeys(virtualStagingPage.getDesignStyleDropdown(), stil);
        }
    }

    @Then("Dekorasyon Olustur butonunun pasif disabled oldugu gorulmelidir")
    public void dekorasyonOlusturButonununPasifDisabledOlduguGorulmelidir() {
        Assert.assertFalse(virtualStagingPage.getGenerateButton().isEnabled());
    }

    @Given("Kullanici gecerli bir oda gorseli yuklemistir")
    public void kullaniciGecerliBirOdaGorseliYuklemistir() {
        rm.mySendKeys(virtualStagingPage.getFileUploadInput(), "src/test/resources/testdata/sample.jpg");
    }

    @And("Kullanıcı \"Oda Türü\" ve \"Tasarım Stili\" seçimlerini yapmıştır")
    public void kullaniciOdaTuruVeTasarimStiliSecimleriniYapmistir() {
        rm.mySendKeys(virtualStagingPage.getRoomTypeDropdown(), "Oturma Odası");
        rm.mySendKeys(virtualStagingPage.getDesignStyleDropdown(), "Modern");
    }

    @When("Kullanıcı \"Dekorasyon Oluştur\" butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getGenerateButton());
    }

    @Then("Sistem yuklenme animasyonu gostermelidir")
    public void sistemYuklenmeAnimasyonuGostermelidir() {
        Assert.assertTrue(virtualStagingPage.getLoadingAnimation().isVisible());
    }

    @And("Seçilen oda türü ve stile uygun mobilyalandırılmış yeni görsel kullanıcıya sunulmalıdır")
    public void secilenOdaTuruVeStileUygunMobilyalandirilmisYeniGorselKullaniciyaSunulmalidir() {
        Assert.assertTrue(virtualStagingPage.getGeneratedResultImage().isVisible());
    }

    @Given("Kullanici AI Edit sekmesindedir")
    public void kullaniciAIEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
    }

    @When("Kullanıcı \"Current image\" (Mevcut kaynak görsel) seçeneğini kullanır")
    public void kullaniciCurrentImageMevcutKaynakGorselSeceneginiKullanir() {
        rm.myClick(aiEditPage.getCurrentImageOption());
    }

    @And("\"Describe what to change\" alanına \"Remove the chair\" metinsel talimatını girer")
    public void describeWhatToChangeAlaninaRemoveTheChairMetinselTalimatiniGirer(String talimat) {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), talimat);
    }

    @And("Kullanıcı \"Edit Photo\" butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @Then("İlgili değişiklik (koltuğun kaldırılması) görsel üzerinde başarıyla gerçekleştirilmelidir")
    public void ilgiliDegisiklikKoltugunKaldirilmasiGorselUzerindeBasariylaGerceklestirilmelidir() {
        Assert.assertTrue(aiEditPage.getEditedImageResult().isVisible());
    }

    @When("Kullanıcı düzenleme için yeni bir görsel yükler")
    public void kullaniciDuzenlemeIcinYeniBirGorselYukler() {
        rm.mySendKeys(aiEditPage.getNewImageUploadInput(), "src/test/resources/testdata/sample.jpg");
    }

    @And("\"Describe what to change\" alanına geçerli bir İngilizce komut girer")
    public void describeWhatToChangeAlaninaGecerliBirIngilizceKomutGirer() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Add a modern plant");
    }

    @Then("Değişiklik uygulanmış yeni görsel ekranda gösterilmelidir")
    public void degisiklikUygulanmisYeniGorselEkrandaGosterilmelidir() {
        Assert.assertTrue(aiEditPage.getEditedImageResult().isVisible());
    }

    @Given("Kullanici AI Edit sekmesinde bir gorsel secmistir")
    public void kullaniciAIEditSekmesindeBirGorselSecmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        rm.mySendKeys(aiEditPage.getNewImageUploadInput(), "src/test/resources/testdata/sample.jpg");
    }

    @When("Kullanıcı \"Describe what to change\" alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "");
    }

    @Then("Sistem \"Lütfen yapılacak değişikliği açıklayın\" uyarısı vermelidir")
    public void sistemLutfenYapilacakDegisikligiAciklayinUyarisiVermelidir() {
        rm.veriyfyContainsText(aiEditPage.getWarningMessage(), "Lütfen");
    }

    @And("İşlem gerçekleştirilmemelidir")
    public void islemGerceklestirilmemelidir() {
        Assert.assertFalse(aiEditPage.getEditedImageResult().isVisible());
    }

    @When("Kullanıcı \"Describe what to change\" alanına rastgele karakterler veya anlamsiz metin girer")
    public void kullaniciDescribeWhatToChangeAlaninaRastgeleKarakterlerVeyaAnlamsizMetinGirer() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "asdfghjklasdfghjk");
    }

    @Then("Sistem komutu isleyemedigini belirten bir hata mesaji veya kibar bir uyari gostermelidir")
    public void sistemKomutuIsleyemediginiBelirtenBirHataMesajiVeyaKibarBirUyariGostermelidir() {
        Assert.assertTrue(aiEditPage.getErrorGenericMessage().isVisible());
    }

    @Given("Kullanıcı ana sayfadadır (\"aistager.ai/tr\")")
    public void kullaniciAnaSayfadadirAistagerAiTr() {
        PD.getPage().navigate("https://" + "aistager.ai/tr");
    }

    @When("Kullanıcı ana sayfadaki header alanında \"Ürünler\" menüsünün üzerine gelir (hover over)")
    public void kullaniciAnaSayfadakiHeaderAlanindaUrunlerMenusununUzerineGelirHoverOver() {
        homePage.getProductsMenu().hover();
    }

    @Then("Alt secenekler (\"Yapay Zeka Sanal Tur\" ve \"Sanal Dekorasyon API\") listelenmelidir")
    public void altSeceneklerYapayZekaSanalTurVeSanalDekorasyonApiListelenmelidir() {
        Assert.assertTrue(homePage.getSubMenuVirtualTour().isVisible());
        Assert.assertTrue(homePage.getSubMenuAPI().isVisible());
    }

    @When("Kullanıcı \"Ürünler\" menüsünden \"Yapay Zeka Sanal Tur\" seçeneğine tıklar")
    public void kullaniciUrunlerMenusundenYapayZekaSanalTurSecenegineTiklar() {
        homePage.getProductsMenu().hover();
        rm.myClick(homePage.getSubMenuVirtualTour());
    }

    @Then("Kullanıcı \"aistager.ai/tr/ai-virtual-tour\" sayfasına yönlendirilmelidir")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı \"Erken Erişim İsteyin\" butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(homePage.getEarlyAccessButton());
    }

    @And("Acan formda zorunlu e-posta alanina gecerli bir e-posta adresi girer \"test@example.com\"")
    public void acanFormdaZorunluEPostaAlaninaGecerliBirEPostaAdresiGirerTestExampleCom() {
        rm.mySendKeys(homePage.getEmailInput(), "test@example.com");
    }

    @And("Talebi gonder butonuna tıklar")
    public void talebiGonderButonunaTiklar() {
        rm.myClick(homePage.getSubmitRequestButton());
    }

    @Then("Sistem basarili onay mesaji Talebiniz alinmistir gostermelidir")
    public void sistemBasariliOnayMesajiTalebinizAlinmistirGostermelidir() {
        rm.veriyfyContainsText(homePage.getSuccessMessage(), "alınmıştır");
    }

    @Given("Kullanıcı \"aistager.ai/tr/ai-virtual-tour\" sayfasındadır ve Erken Erişim formu açıktır")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasindadirVeErkenErisimFormuAciktir() {
        PD.getPage().navigate("https://aistager.ai/tr/ai-virtual-tour");
        rm.myClick(homePage.getEarlyAccessButton());
    }

    @When("Kullanıcı e-posta alanına geçersiz bir format girer (\"gecersiz-eposta\")")
    public void kullaniciEPostaAlaninaGecersizBirFormatGirerGecersizEposta() {
        rm.mySendKeys(homePage.getEmailInput(), "gecersiz-eposta");
    }

    @Then("Sistem gecerli bir e-posta adresi girilmesi gerektigini belirten bir hata mesaji gostermelidir")
    public void sistemGecerliBirEPostaAdresiGirilmesiGerektiginiBelirtenBirHataMesajiGostermelidir() {
        Assert.assertTrue(homePage.getEmailErrorMessage().isVisible());
    }

    @When("Kullanıcı e-posta alanını boş bırakarak gönder butonuna tıklar")
    public void kullaniciEPostaAlaniniBosBirakarakGonderButonunaTiklar() {
        rm.mySendKeys(homePage.getEmailInput(), "");
        rm.myClick(homePage.getSubmitRequestButton());
    }

    @Then("Sistem zorunlu alan uyarisi vermelidir")
    public void sistemZorunluAlanUyarisiVermelidir() {
        Assert.assertTrue(homePage.getEmailErrorMessage().isVisible());
    }

    @When("Kullanıcı \"Ürünler\" menüsünden \"Sanal Dekorasyon API\" seçeneğine tıklar")
    public void kullaniciUrunlerMenusundenSanalDekorasyonApiSecenegineTiklar() {
        homePage.getProductsMenu().hover();
        rm.myClick(homePage.getSubMenuAPI());
    }

    @Then("Kullanıcı \"aistager.ai/tr/api\" sayfasına yönlendirilmelidir")
    public void kullaniciAistagerAiTrApiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/api"));
    }

    @When("Kullanıcı \"İletişime Geçin\" butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(homePage.getContactUsButton());
    }

    @And("İletişim formundaki \"Ad\", \"E-posta\" ve \"Mesaj\" zorunlu alanlarını geçerli bilgilerle doldurur")
    public void iletisimFormundakiAdEPostaVeMesajZorunluAlanlariniGecerliBilgilerleDoldurur() {
        rm.mySendKeys(homePage.getNameInput(), "Test User");
        rm.mySendKeys(homePage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(homePage.getMessageInput(), "Hello, I want to integrate API.");
    }

    @And("Gönder butonuna tıklar")
    public void gonderButonunaTiklar() {
        rm.myClick(homePage.getSubmitRequestButton());
    }

    @Then("Talep basariyla iletilmeli ve kullaniciya basari onay mesaji gosterilmelidir")
    public void talepBasariylaIletilmeliVeKullaniciyaBasariOnayMesajiGosterilmelidir() {
        rm.veriyfyContainsText(homePage.getSuccessMessage(), "başarılı");
    }

    @Given("Kullanıcı \"aistager.ai/tr/api\" sayfasındadır ve iletişim formu açıktır")
    public void kullaniciAistagerAiTrApiSayfasindadirVeIletisimFormuAciktir() {
        PD.getPage().navigate("https://aistager.ai/tr/api");
        rm.myClick(homePage.getContactUsButton());
    }

    @When("Kullanıcı \"Ad\" ve \"Mesaj\" alanlarını doldurup \"E-posta\" alanını boş bırakır")
    public void kullaniciAdVeMesajAlanlariniDoldurupEPostaAlaniniBosBirakir() {
        rm.mySendKeys(homePage.getNameInput(), "Test User");
        rm.mySendKeys(homePage.getMessageInput(), "Hello");
        rm.mySendKeys(homePage.getEmailInput(), "");
    }

    @Then("Sistem eksik alanlar icin uyari mesajlari gostermelidir")
    public void sistemEksikAlanlarIcinUyariMesajlariGostermelidir() {
        Assert.assertTrue(homePage.getEmailErrorMessage().isVisible());
    }

    @Given("Kullanıcı \"aistager.ai/tr/api\" sayfasındadır")
    public void kullaniciAistagerAiTrApiSayfasindadir() {
        PD.getPage().navigate("https://aistager.ai/tr/api");
    }

    @When("Kullanıcı sayfadaki \"Fiyatlandırmayı Görüntüle\" butonuna tıklar")
    public void kullaniciSayfadakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(homePage.getPricingButton());
    }

    @Then("Kullanıcı hatasız bir sekilde Fiyatlandirma sayfasina yonlendirilmelidir")
    public void kullaniciHatasizBirSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }
}