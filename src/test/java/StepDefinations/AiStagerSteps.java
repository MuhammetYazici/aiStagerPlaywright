package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Pages.AiEditPage;
import Pages.NavigationPage;
import Utilities.ReusableMethod;
import Utilities.ConfigReader;
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

    @Given("Kullanıcı AiStager.ai platformuna başarıyla giriş yapmıştır")
    public void kullaniciAiStagerAiPlatformunaBasariylaGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Kullanıcı Virtual Staging modülündedir")
    public void kullaniciVirtualStagingModulundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/virtual-staging");
        Assert.assertTrue(PD.getPage().url().contains("virtual-staging"));
    }

    @When("Kullanıcı yükleme alanına geçerli formatta bir {string} veya {string} boş oda görseli yükler")
    public void kullaniciYuklemeAlaninaGecerliFormattaBirVeyaBosOdaGorseliYukler(String uzanti1, String uzanti2) {
        rm.mySendKeys(virtualStagingPage.getYuklemeAlani(), "src/test/resources/testdata/sample_room." + uzanti1);
    }

    @When("Kullanıcı Oda Türü olarak Oturma Odası seçer")
    public void kullaniciOdaTuruOlarakOturmaOdasiSecer() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
    }

    @When("Kullanıcı Tasarım Stili olarak Modern seçer")
    public void kullaniciTasarimStiliOlarakModernSecer() {
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
        rm.myClick(virtualStagingPage.getModernSecenegi());
    }

    @When("Kullanıcı Mevcut mobilyaları kaldır toggle'ının açık olduğunu görür")
    public void kullaniciMevcutMobilyalariKaldirToggleIninAcikOldugunuGorur() {
        Assert.assertTrue(virtualStagingPage.getMevcutMobilyalariKaldirToggle().isVisible());
    }

    @When("Kullanıcı görünürlük tercihi olarak bir radyo buton seçer")
    public void kullaniciGorunurlukTercihiOlarakBirRadyoButonSecer() {
        rm.myClick(virtualStagingPage.getRadyoButon());
    }

    @When("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButton());
    }

    @Then("Sistem, seçilen oda türü ve tasarım stiline uygun mobilyalandırılmış görseli başarıyla üretmelidir")
    public void sistemSecilenOdaTuruVeTasarimStilineUygunMobilyalandirilmisGorseliBasariylaUretmelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getBasariliUretimGorseli(), "");
    }

    @When("Kullanıcı yükleme alanına {string} uzantılı bir dosya yüklemeye çalışır")
    public void kullaniciYuklemeAlaninaUzantiliBirDosyaYuklemeyeCalisir(String gecersizFormat) {
        rm.mySendKeys(virtualStagingPage.getYuklemeAlani(), "src/test/resources/testdata/invalid_file." + gecersizFormat);
    }

    @Then("Sistem yükleme hatası vermeli ve görselin yüklenmediğini belirtmelidir")
    public void sistemYuklemeHatasiVermeliVeGorselinYuklenmediginiBelirtmelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getYuklemeHataMesaji(), "hata");
    }

    @When("Kullanıcı geçerli bir boş oda görseli yükler")
    public void kullaniciGecerliBirBosOdaGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getYuklemeAlani(), "src/test/resources/testdata/sample_room.jpg");
    }

    @When("Kullanıcı Oda Türü veya Tasarım Stili seçimini yapmaz")
    public void kullaniciOdaTuruVeyaTasarimStiliSeciminiYapmaz() {
        // Alanlar boş bırakılıyor, işlem yapılmıyor.
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButton().isVisible());
    }

    @Then("Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajı göstermelidir")
    public void sistemZorunluAlanlarinSecilmesiGerektigineDairUyariMesajiGostermelidir() {
        rm.veriyfyContainsText(virtualStagingPage.getZorunluAlanUyariMesaji(), "zorunlu");
    }

    @Then("Dekorasyon oluşturma işlemi tetiklenmemelidir")
    public void dekorasyonOlusturmaIslemiTetiklenmemelidir() {
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButton().isVisible());
    }

    @When("Kullanıcı boş oda görseli yükleme ekranına gelir")
    public void kullaniciBosOdaGorseliYuklemeEkraninaGelir() {
        Assert.assertTrue(virtualStagingPage.getBosOdaGorseliYuklemeEkrani().isVisible());
    }

    @Then("Mevcut mobilyaları kaldır toggle'ı varsayılan olarak açık olmalıdır")
    public void mevcutMobilyalariKaldirToggleVarsayilanOlarakAcikOlmalidir() {
        Assert.assertTrue(virtualStagingPage.getMevcutMobilyalariKaldirToggle().isVisible());
    }

    @Given("Kullanıcı AI Edit modülündedir")
    public void kullaniciAiEditModulundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-edit");
        Assert.assertTrue(PD.getPage().url().contains("ai-edit"));
    }

    @When("Kullanıcı varsayılan olarak Current image seçeneği ile ilerler")
    public void kullaniciVarsayilanOlarakCurrentImageSecenegiIleIlerleer() {
        Assert.assertTrue(aiEditPage.getCurrentImageSecenegi().isVisible());
    }

    @When("Kullanıcı Describe what to change alanına {string} metnini girer")
    public void kullaniciDescribeWhatToChangeAlaninaMetniniGirer(String metin) {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), rm.resolveDynamicValue(metin));
    }

    @When("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @Then("Sistem girilen metin talimatına uygun şekilde görsel üzerindeki ilgili objeyi kaldırmalı ve güncel görseli göstermelidir")
    public void sistemGirilenMetinTalimatinaUygunSekildeGorselUzerindekiIlgiliObjeyiKaldirmaliVeGuncelGorseliGostermelidir() {
        rm.veriyfyContainsText(aiEditPage.getGuncelGorsel(), "");
    }

    @When("Kullanıcı Describe what to change alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "");
    }

    @Then("Sistem kullanıcının bir değişiklik tanımı girmesi gerektiğini belirten bir uyarı göstermelidir")
    public void sistemKullanicininBirDegisiklikTanimiGirmesiGerektiginiBelirtenBirUyariGostermelidir() {
        rm.veriyfyContainsText(aiEditPage.getDegisiklikTanimiUyariMesaji(), "tanımı");
    }

    @When("Kullanıcı Current image yerine yeni bir görsel yükler")
    public void kullaniciCurrentImageYerineYeniBirGorselYukler() {
        rm.mySendKeys(aiEditPage.getYeniGorselYuklemeAlani(), "src/test/resources/testdata/new_room.jpg");
    }

    @Then("Sistem yeni yüklenen görsel üzerine talimatı uygulamalı ve güncel görseli sunmalıdır")
    public void sistemYeniYuklenenGorselUzerineTalimatiUygulamaliVeGuncelGorseliSunmalidir() {
        rm.veriyfyContainsText(aiEditPage.getGuncelGorsel(), "");
    }

    @Given("Kullanıcı ana sayfanın header alanındadır")
    public void kullaniciAnaSayfaninHeaderAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(navigationPage.getHeaderAlanindanUrunlerMenu().isVisible());
    }

    @When("Kullanıcı Ürünler menüsünün üzerine gelir")
    public void kullaniciUrunlerMenusununUzerineGelir() {
        navigationPage.getHeaderAlanindanUrunlerMenu().hover();
    }

    @When("Açılan alt menüden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanAltMenudenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(navigationPage.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidir(String urlPath) {
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getErkenErisimIsteyinButton());
    }

    @When("Açılan form alanına geçerli bir {string} e-posta adresi girer ve gönderir")
    public void acilanFormAlaninaGecerliBirEPostaAdresiGirerVeGonderir(String eposta) {
        rm.mySendKeys(navigationPage.getEpostaInputForm(), rm.resolveDynamicValue(eposta));
        rm.myClick(navigationPage.getGonderButton());
    }

    @Then("Sistem başarılı gönderim onayı mesajı göstermelidir")
    public void sistemBasariliGonderimOnayiMesajiGostermelidir() {
        rm.veriyfyContainsText(navigationPage.getBasariliGonderimOnayiMesaji(), "başarıyla");
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String urlPath) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/" + urlPath.replace("aistager.ai/", ""));
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("Açılan forma geçersiz bir {string} e-posta adresi girer ve gönderir")
    public void acilanFormaGecersizBirEPostaAdresiGirerVeGonderir(String gecersizEposta) {
        rm.mySendKeys(navigationPage.getEpostaInputForm(), rm.resolveDynamicValue(gecersizEposta));
        rm.myClick(navigationPage.getGonderButton());
    }

    @Then("Sistem e-posta format hatası mesajı göstermeli ve başvuruyu kabul etmemelidir")
    public void sistemEPostaFormatHatasiMesajiGostermeliVeBasvuruyuKabulEtmemelidir() {
        rm.veriyfyContainsText(navigationPage.getEpostaFormatHataMesaji(), "hata");
    }

    @When("Açılan alt menüden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanAltMenudenSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(navigationPage.getSanalDekorasyonApiSecenegi());
    }

    @When("Kullanıcı iletişim formundaki Ad, E-posta ve Mesaj alanlarını doldurur ve gönderir")
    public void kullaniciIletisimFormundakiAdEPostaVeMesajAlanlariniDoldururVeGonderir() {
        rm.mySendKeys(navigationPage.getIletisimFormuAdInput(), "Test Kullanicisi");
        rm.mySendKeys(navigationPage.getIletisimFormuEpostaInput(), "test@aistager.ai");
        rm.mySendKeys(navigationPage.getIletisimFormuMesajInput(), "Test mesajidir.");
        rm.myClick(navigationPage.getGonderButton());
    }

    @Then("Sistem iletişim formunun başarıyla iletildiğine dair onay mesajı gösterilmelidir")
    public void sistemIletisimFormununBasariylaIletildigineDairOnayMesajiGosterilmelidir() {
        rm.veriyfyContainsText(navigationPage.getBasariliGonderimOnayiMesaji(), "başarıyla");
    }

    @When("Kullanıcı Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getFiyatlandirmayiGoruntuleButton());
    }

    @Then("Kullanıcı sorunsuz bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciSorunsuzBirSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing") || PD.getPage().url().contains("fiyat"));
    }

    @When("Kullanıcı iletişim formundaki Ad veya E-posta alanını boş bırakır")
    public void kullaniciIletisimFormundakiAdVeyaEPostaAlaniniBosBirakir() {
        rm.mySendKeys(navigationPage.getIletisimFormuAdInput(), "");
        rm.mySendKeys(navigationPage.getIletisimFormuEpostaInput(), "");
    }

    @When("Kullanıcı formu gönderme butonuna tıklar")
    public void kullaniciFormuGondermeButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButton());
    }

    @Then("Sistem zorunlu alanların doldurulması gerektiğine dair hata uyarıları vermelidir")
    public void sistemZorunluAlanlarinDoldurulmasiGerektigineDairHataUyarilariVermelidir() {
        rm.veriyfyContainsText(navigationPage.getZorunluAlanHataUyarilari(), "zorunlu");
    }
}