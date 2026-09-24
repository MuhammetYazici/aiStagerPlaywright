package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Pages.NavigationPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AistagerTestcasesSteps {

    VirtualStagingPage vsPage = new VirtualStagingPage();
    NavigationPage navPage = new NavigationPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanici AiStager platformundadir")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır")
    public void kullaniciSistemeGirisYapmisVeVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
        rm.veriyfyContainsText(vsPage.getVirtualStagingHeader(), "Virtual Staging");
    }

    @When("Kullanıcı geçerli {string} veya {string} formatında bir oda görseli yükler")
    public void kullaniciGecerliFormattaBirOdaGorseliYukler(String format1, String format2) {
        rm.mySendKeys(vsPage.getUploadInput(), "src/test/resources/test_images/sample" + format1);
    }

    @When("Kullanıcı \"Oda Türü\" (Room Type) seçer")
    public void kullaniciOdaTuruSecer() {
        rm.myClick(vsPage.getRoomTypeDropdown());
    }

    @When("Kullanıcı \"Tasarım Stili\" (Design Style) seçer")
    public void kullaniciTasarimStiliSecer() {
        rm.myClick(vsPage.getDesignStyleDropdown());
    }

    @When("\"Mevcut mobilyaları kaldır\" toggle'ının varsayılan olarak \"açık\" olduğunu görür")
    public void mevcutMobilyalariKaldirToggleIninVarsayilanOlarakAcikOldugunuGorur() {
        Assert.assertTrue(vsPage.getRemoveFurnitureToggle().isVisible());
    }

    @When("Kullanıcı görünürlük tercihlerinden birini seçer")
    public void kullaniciGorunurlukTercihlerindenBiriniSecer() {
        rm.myClick(vsPage.getVisibilityPreference());
    }

    @When("Kullanıcı dekorasyon oluşturma butonuna tıklar")
    public void kullaniciDekorasyonOlusturmaButonunaTiklar() {
        rm.myClick(vsPage.getGenerateButton());
    }

    @When("Kullanıcı dekorasyon oluşturma işlemini tetikler")
    public void kullaniciDekorasyonOlusturmaIsleminiTetikler() {
        rm.myClick(vsPage.getGenerateButton());
    }

    @Then("Sistem yapay zeka destekli işlenmiş nihai görseli kullanıcıya sunmalıdır")
    public void sistemYapayZekaDestekliIslenmisNihaiGorseliKullaniciyaSunmalidir() {
        Assert.assertTrue(vsPage.getResultImage().isVisible());
    }

    @When("Kullanıcı {string} formatında bir dosya yüklemeye çalışır")
    public void kullaniciFormatindaBirDosyaYuklemeyeCalisir(String gecersizFormat) {
        rm.mySendKeys(vsPage.getUploadInput(), "src/test/resources/test_images/sample" + gecersizFormat);
    }

    @Then("Sistem kullanıcıya dosya formatının desteklenmediğine dair hata mesajı göstermelidir")
    public void sistemKullaniciyaDosyaFormatininDesteklenmedigineDairHataMesajiGostermelidir() {
        rm.veriyfyContainsText(vsPage.getErrorMessage(), "desteklenmiyor");
    }

    @Then("Dekorasyon olusturma butonu pasif kalmalidir")
    public void dekorasyonOlusturmaButonuPasifKalmalidir() {
        Assert.assertFalse(vsPage.getGenerateButton().isEnabled());
    }

    @When("Kullanıcı görsel yükler ancak \"Oda Türü\" veya \"Tasarım Stili\" seçimlerinden birini boş bırakır")
    public void kullaniciGorselYuklerAncakSecimlerdenBiriniBosBirakir() {
        rm.mySendKeys(vsPage.getUploadInput(), "src/test/resources/test_images/sample.jpg");
    }

    @Then("Sistem eksik alanların doldurulması gerektiğine dair uyarı mesajı göstermelidir")
    public void sistemEksikAlanlarinDoldurulmasiGerektigineDairUyariMesajiGostermelidir() {
        rm.veriyfyContainsText(vsPage.getErrorMessage(), "eksik");
    }

    @Given("Kullanıcı giriş yapmış, Virtual Staging sayfasında ve \"AI Edit\" sekmesi aktif durumdadır")
    public void kullaniciGirisYapmisVirtualStagingSayfasindaVeAiEditSekmesiAktifDurumdadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
        rm.myClick(vsPage.getAiEditTab());
    }

    @When("\"Edit photo source\" alanında varsayılan olarak \"Current image\" seçili olduğunu görür")
    public void editPhotoSourceAlanindaVarsayilanOlarakSeciliOldugunuGorur() {
        Assert.assertTrue(vsPage.getEditPhotoSourceDefault().isVisible());
    }

    @When("Kullanıcı \"Describe what to change\" alanına geçerli bir metinsel talimat (prompt) girer")
    public void kullaniciAlaninaGecerliBirMetinselTalimatGirer() {
        rm.mySendKeys(vsPage.getDescribePromptInput(), "Add a modern carpet");
    }

    @When("Kullanıcı \"Edit Photo\" butonuna tıklar")
    public void kullaniciButonunaTiklar() {
        rm.myClick(vsPage.getEditPhotoButton());
    }

    @Then("Sistem, girilen talimata uygun olarak guncellenmis yeni gorseli ekranda gostermelidir")
    public void sistemGirilenTalimataUygunOlarakGuncellenmisYeniGorseliEkrandaGostermelidir() {
        Assert.assertTrue(vsPage.getResultImage().isVisible());
    }

    @When("Kullanıcı alternatif bir kaynak görsel yükler")
    public void kullaniciAlternatifBirKaynakGorselYukler() {
        rm.mySendKeys(vsPage.getUploadInput(), "src/test/resources/test_images/alternative.jpg");
    }

    @When("Kullanıcı \"Describe what to change\" alanına talimat yazar")
    public void kullaniciAlaninaTalimatYazar() {
        rm.mySendKeys(vsPage.getDescribePromptInput(), "Change wall color to blue");
    }

    @Then("Sistem yüklenen alternatif görsel üzerinden düzenleme yaparak yeni sonucu göstermelidir")
    public void sistemYuklenenAlternatifGorselUzerindenDuzenlemeYaparakYeniSonucuGostermelidir() {
        Assert.assertTrue(vsPage.getResultImage().isVisible());
    }

    @When("Kullanıcı \"Describe what to change\" alanını boş bırakır")
    public void kullaniciAlaniniBosBirakir() {
        // Leave empty deliberately
    }

    @Then("Sistem metin girişinin zorunlu olduğuna dair hata mesajı göstermelidir")
    public void sistemMetinGirisininZorunluOldugunaDairHataMesajiGostermelidir() {
        rm.veriyfyContainsText(vsPage.getErrorMessage(), "zorunlu");
    }

    @Given("Kullanıcı giriş yapmış ve ana sayfadadır")
    public void kullaniciGirisYapmisVeAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Header üzerindeki \"Ürünler\" dropdown menüsüne hover yapar")
    public void kullaniciHeaderUzerindekiDropdownMenusuneHoverYapar() {
        navPage.getProductsDropdown().hover();
    }

    @When("Açılan listedeki 2. sıra olan \"Yapay Zeka Sanal Tur\" seçeneğine tıklar")
    public void acilanListedekiSirOlanSecenegineTiklar() {
        rm.myClick(navPage.getVirtualTourOption());
    }

    @Then("Kullanıcı \"aistager.ai/tr/ai-virtual-tour\" sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı sayfa içerisindeki \"Erken Erişim İsteyin\" butonuna tıklar")
    public void kullaniciSayfaIcerisindekiButonunaTiklar() {
        rm.myClick(navPage.getEarlyAccessButton());
    }

    @When("Açılan formda zorunlu e-posta adresini girer ve formu gonderir")
    public void acilanFormdaZorunluEPostaAdresiniGirerVeFormuGonderir() {
        rm.mySendKeys(navPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(navPage.getSubmitButton());
    }

    @Then("Talep sistem tarafindan basariyla kaydedilmeli ve ekranda bir onay mesaji gosterilmelidir")
    public void talepSistemTarafindanBasariylaKaydedilmeliVeEkrandaBirOnayMesajiGosterilmelidir() {
        rm.veriyfyContainsText(navPage.getSuccessMessage(), "başarılı");
    }

    @Given("Kullanıcı \"aistager.ai/tr/ai-virtual-tour\" sayfasındadır")
    public void kullaniciSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
    }

    @When("Açılan forma geçersiz bir e-posta adresi (örn: \"test@domain\") girer ve gönderir")
    public void acilanFormaGecersizBirEPostaAdresiGirerVeGonderir() {
        rm.mySendKeys(navPage.getEmailInput(), "test@domain");
        rm.myClick(navPage.getSubmitButton());
    }

    @Then("Sistem gecerli bir e-posta adresi girilmesi gerektigine dair hata mesaji gostermelidir")
    public void sistemGecerliBirEPostaAdresiGirilmesiGerektigineDairHataMesajiGostermelidir() {
        rm.veriyfyContainsText(navPage.getErrorMessage(), "geçerli");
    }

    @When("Kullanıcı Header'daki \"Ürünler\" dropdown menüsünden 3. sıra olan \"Sanal Dekorasyon API\" seçeneğine tıklar")
    public void kullaniciHeaderDakiDropdownMenusundenSirOlanSecenegineTiklar() {
        navPage.getProductsDropdown().hover();
        rm.myClick(navPage.getApiOption());
    }

    @Then("Kullanıcı \"aistager.ai/tr/api\" sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidirApi() {
        Assert.assertTrue(PD.getPage().url().contains("/api"));
    }

    @When("Kullanıcı sayfanın üst kısmındaki \"İletişime Geçin\" butonuna tıklar")
    public void kullaniciSayfaninUstKismindakiButonunaTiklar() {
        rm.myClick(navPage.getContactUsButton());
    }

    @When("Açılan iletişim formundaki zorunlu alanları (ad, e-posta, mesaj) doldurur ve gönderir")
    public void acilanIletisimFormundakiZorunluAlanlariDoldururVeGonderir() {
        rm.mySendKeys(navPage.getNameInput(), "Test User");
        rm.mySendKeys(navPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(navPage.getMessageInput(), "Hello API integration");
        rm.myClick(navPage.getSubmitButton());
    }

    @Then("Kullanıcıya başarı (onay) mesajı iletilmelidir")
    public void kullaniciyaBasariMesajiIletilmelidir() {
        rm.veriyfyContainsText(navPage.getSuccessMessage(), "başarılı");
    }

    @Given("Kullanıcı \"aistager.ai/tr/api\" sayfasındadır")
    public void kullaniciSayfasindadirApi() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
    }

    @When("Kullanıcı sayfanın alt kısmındaki \"Fiyatlandırmayı Görüntüle\" butonuna tıklar")
    public void kullaniciSayfaninAltKismindakiButonunaTiklar() {
        rm.myClick(navPage.getPricingButton());
    }

    @Then("Kullanıcı hatasız bir şekilde Fiyatlandırma (Pricing) sayfasına yönlendirilmelidir")
    public void kullaniciHatasizBirSekildeSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @When("Zorunlu alanlardan (Ad, E-posta, Mesaj) en az birini boş bırakarak gönder butonuna tıklar")
    public void zorunluAlanlardanEnAzBiriniBosBirakarakGonderButonunaTiklar() {
        rm.mySendKeys(navPage.getNameInput(), "Test User");
        rm.myClick(navPage.getSubmitButton());
    }

    @Then("Sistem eksik alanlarla ilgili validasyon hata mesajlari gostermelidir")
    public void sistemEksikAlanlarlaIlgiliValidasyonHataMesajlariGostermelidir() {
        rm.veriyfyContainsText(navPage.getErrorMessage(), "eksik");
    }
}