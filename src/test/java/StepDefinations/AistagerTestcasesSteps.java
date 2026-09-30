package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.*;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;
import java.nio.file.Paths;

public class AistagerTestcasesSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AiEditPage aiEditPage = new AiEditPage();
    VirtualTourPage virtualTourPage = new VirtualTourPage();
    ApiPage apiPage = new ApiPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        if(homePage.getTumuKabulEtButton().isVisible()) {
            rm.myClick(homePage.getTumuKabulEtButton());
        }
    }

    @Given("Kullanıcı sisteme giriş yapmıştır")
    public void kullaniciSistemeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), ConfigReader.getProperty("existing_user_email"));
        rm.mySendKeys(loginPage.getPasswordInput(), ConfigReader.getProperty("existing_user_password"));
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Given("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
    }

    @When("Kullanıcı geçerli formatta bir boş oda görseli yükler {string} veya {string}")
    public void kullaniciGecerliFormattaBosOdaGorseliYukler(String format1, String format2) {
        virtualStagingPage.getFileInput().setInputFiles(Paths.get("src/test/resources/sample.jpg"));
    }

    @Then("Kullanıcı yüklenen görselin önizlemesini görebilmelidir")
    public void kullaniciYuklenenGorselinOnizlemesiniGorebilmelidir() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @And("Oda Türü olarak {string} seçilir")
    public void odaTuruOlarakSecilir(String odaTuru) {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown(odaTuru));
    }

    @And("Tasarım Stili olarak {string} seçilir")
    public void tasarimStiliOlarakSecilir(String stil) {
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown(stil));
    }

    @And("Mevcut mobilyaları kaldır toggle ının varsayılan olarak açık olduğu görülür")
    public void mevcutMobilyalariKaldirToggleIninVarsayilanOlarakAcikOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getMevcutMobilyalariKaldirToggle().isChecked());
    }

    @And("Kullanıcı görünürlük tercihi için bir radio buton seçer")
    public void kullaniciGorunurlukTercihiIcinBirRadioButonSecer() {
        rm.myClick(virtualStagingPage.getRadioButon());
    }

    @And("Dekorasyon Oluştur butonunun aktif olduğu görülür")
    public void dekorasyonOlusturButonununAktifOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButton().isEnabled());
    }

    @When("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButton());
    }

    @Then("Sistem odayı seçilen oda türü ve stile uygun şekilde mobilyalandırarak kullanıcıya sunlar")
    public void sistemOdayiSecilenOdaTuruVeStileUygunSekildeMobilyalandirarakKullaniciyaSunar() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @When("Kullanıcı desteklenmeyen formatta bir görsel yükler {string} veya {string}")
    public void kullaniciDesteklenmeyenFormattaBirGorselYuklerVeya(String format1, String format2) {
        virtualStagingPage.getFileInput().setInputFiles(Paths.get("src/test/resources/sample.gif"));
    }

    @Then("Sistem hata mesajı gösterir ve görsel yükleme başarısız olur")
    public void sistemHataMesajiGosterirVeGorselYuklemeBasarisizOlur() {
        Assert.assertTrue(virtualStagingPage.getHataMesaji().isVisible());
    }

    @And("Dekorasyon Oluştur butonu pasif kalır")
    public void dekorasyonOlusturButonuPasifKalir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButton().isEnabled());
    }

    @When("Kullanıcı geçerli bir oda görseli yükler")
    public void kullaniciGecerliBirOdaGorseliYukler() {
        virtualStagingPage.getFileInput().setInputFiles(Paths.get("src/test/resources/sample.jpg"));
    }

    @And("Oda Türü ve Tasarım Stili seçimleri boş bırakılır")
    public void odaTuruVeTasarimStiliSecimleriBosBirakilir() {
        virtualStagingPage.getOdaTuruDropdown("Oturma Odası").click();
        virtualStagingPage.getOdaTuruDropdown("Oturma Odası").fill("");
    }

    @Then("Dekorasyon Oluştur butonunun pasif disabled olduğu görülür")
    public void dekorasyonOlusturButonununPasifDisabledOlduguGorulur() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButton().isEnabled());
    }

    @And("Oda Türü ve Tasarım Stili zorunlu seçimleri yapılır")
    public void odaTuruVeTasarimStiliZorunluSecimleriYapilir() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown("Oturma Odası"));
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown("Modern"));
    }

    @And("Varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle ı kullanıcı tarafından kapatılır")
    public void varsayilanOlarakAcikGelenMevcutMobilyalariKaldirToggleIKullaniciTarafindanKapatilir() {
        rm.myClick(virtualStagingPage.getMevcutMobilyalariKaldirToggle());
    }

    @Then("Sistem mevcut mobilyaları koruyarak yeni dekorasyonu uygular")
    public void sistemMevcutMobilyalariKoruyarakYeniDekorasyonuUygular() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String sayfaAdi) {
        if(sayfaAdi.equals("AI Edit")) {
            PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        }
    }

    @Then("AI Edit sekmesinde mevcut görselin {string} varsayılan olarak kaynak seçili olduğu görülür")
    public void aiEditSekmesindeMevcutGorselinVarsayilanOlarakKaynakSeciliOlduguGorulur(String currentImageText) {
        Assert.assertTrue(aiEditPage.getCurrentImageView().isVisible());
    }

    @And("Seçilen kaynak görselin önizlemesi ekranda görüntülenir")
    public void secilenKaynakGorselinOnizlemesiEkrandaGoruntulenir() {
        Assert.assertTrue(aiEditPage.getGorselOnizleme().isVisible());
    }

    @When("Kullanıcı Describe what to change alanına Remove the chair metinsel talimatını girer")
    public void kullaniciDescribeWhatToChangeAlaninaRemoveTheChairMetinselTalimatiniGirer() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Remove the chair");
    }

    @And("{string} butonuna tıklanır")
    public void butonunaTiklanir(String butonAdi) {
        if(butonAdi.equals("Edit Photo")) {
            rm.myClick(aiEditPage.getEditPhotoButton());
        } else if(butonAdi.equals("Gönder")) {
            rm.myClick(virtualTourPage.getFormGonderButton());
        }
    }

    @Then("Sistem kullanıcının metin talimatına uygun şekilde güncellenmiş yeni görseli ekranda gösterir")
    public void sistemKullanicininMetinTalimatinaUygunSekildeGuncellenmisYeniGorseliEkrandaGosterir() {
        Assert.assertTrue(aiEditPage.getGorselOnizleme().isVisible());
    }

    @When("Kullanıcı sistem üzerinden yeni bir kaynak görsel yükler")
    public void kullaniciSistemUzerindenYeniBirKaynakGorselYukler() {
        aiEditPage.getFileInput().setInputFiles(Paths.get("src/test/resources/sample.jpg"));
    }

    @Then("Yüklenen yeni görselin önizlemesi ekranda gösterilir")
    public void yuklenenYeniGorselinOnizlemesiEkrandaGosterilir() {
        Assert.assertTrue(aiEditPage.getGorselOnizleme().isVisible());
    }

    @And("Kullanıcı Describe what to change alanına düzenleme talimatı yazar")
    public void kullaniciDescribeWhatToChangeAlaninaDuzenlemeTalimatiYazar() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Add a plant");
    }

    @Then("Sistem güncellenmiş yeni görseli ekranda gösterir")
    public void sistemGuncellenmisYeniGorseliEkrandaGosterir() {
        Assert.assertTrue(aiEditPage.getGorselOnizleme().isVisible());
    }

    @And("Kaynak görsel seçilidir")
    public void kaynakGorselSecilidir() {
        Assert.assertTrue(aiEditPage.getCurrentImageView().isVisible());
    }

    @When("Describe what to change alanı boş bırakılır")
    public void describeWhatToChangeAlaniBosBirakilir() {
        aiEditPage.getDescribeWhatToChangeInput().fill("");
    }

    @Then("Sistem kullanıcıyı uyararak hata mesajı gösterir ve işlem gerçekleşmez")
    public void sistemKullaniciyiUyararakHataMesajiGosterirVeIslemGerceklesmez() {
        Assert.assertTrue(virtualStagingPage.getHataMesaji().isVisible());
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Header üzerindeki Ürünler menüsüne hover yapar")
    public void kullaniciHeaderUzerindekiUrunlerMenusuneHoverYapar() {
        homePage.getUrunlerMenu().hover();
    }

    @And("Açılan alt seçeneklerden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanAltSeceneklerdenYapayZekaSanalTurSecenegineTıklar() {
        rm.myClick(homePage.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilmelidir")
    public void kullaniciSayfasinaYonlendirilmelidir(String urlPath) {
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(virtualTourPage.getErkenErisimIsteyinButton());
    }

    @And("Açılan form üzerinden geçerli e-posta ve zorunlu bilgiler doldurulur")
    public void acilanFormUzerindenGecerliEPostaVeZorunluBilgilerDoldurulur() {
        rm.mySendKeys(virtualTourPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Form gönder butonuna tıklanır")
    public void formGonderButonunaTiklanir() {
        rm.myClick(virtualTourPage.getFormGonderButton());
    }

    @Then("Bilgilerin başarıyla gönderildiğine dair onay mesajı alınır")
    public void bilgilerinBasariylaGonderildigineDairOnayMesajiAlinir() {
        Assert.assertTrue(virtualTourPage.getOnayMesaji().isVisible());
    }

    @When("Kullanıcı {string} sayfasındaki Erken Erişim İsteyin formunu açar")
    public void kullaniciSayfasindakiErkenErisimIsteyinFormunuAcar(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
        rm.myClick(virtualTourPage.getErkenErisimIsteyinButton());
    }

    @And("E-posta alanı boş bırakılarak gönder butonuna tıklanır")
    public void ePostaAlaniBosBirakilarakGonderButonunaTiklanir() {
        virtualTourPage.getEmailInput().fill("");
        rm.myClick(virtualTourPage.getFormGonderButton());
    }

    @Then("Sistem zorunlu alan uyarı mesajlarını gösterir ve form gönderilmez")
    public void sistemZorunluAlanUyariMesajlariniGosterirVeFormGonderilmez() {
        Assert.assertTrue(virtualTourPage.getZorunluAlanUyari().isVisible());
    }

    @And("Açılan alt seçeneklerden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanAltSeceneklerdenSanalDekorasyonApiSecenegineTıklar() {
        rm.myClick(homePage.getSanalDekorasyonApiSecenegi());
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(apiPage.getIletisimeGecinButton());
    }

    @And("Açılan iletişim formu zorunlu alanları doldurularak gönderilir")
    public void acilanIletisimFormuZorunluAlanlariDoldurularakGonderilir() {
        rm.mySendKeys(apiPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(apiPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(apiPage.getMesajInput(), "API Test Message");
        rm.myClick(apiPage.getFormGonderButton());
    }

    @Then("Talebin başarıyla iletildiğine dair onay mesajı görüntülenir")
    public void talebinBasariylaIletildigineDairOnayMesajiGoruntulenir() {
        Assert.assertTrue(apiPage.getOnayMesaji().isVisible());
    }

    @When("Kullanıcı sayfanın alt kısmında bulunan Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltKismindaBulunanFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(homePage.getFiyatlandirmayiGoruntuleButton());
    }

    @Then("Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilir")
    public void kullaniciHatasizBirSekildeFiyatlandirmaSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @When("Kullanıcı {string} sayfasındaki İletişime Geçin formunu açar")
    public void kullaniciSayfasindakiIletisimeGecinFormunuAcar(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
        rm.myClick(apiPage.getIletisimeGecinButton());
    }

    @And("Formdaki e-posta alanına format dışı bir metin girilir Örn: {string}")
    public void formdakiEPostaAlaninaFormatDisiBirMetinGirilirOrn(String gecersizEposta) {
        rm.mySendKeys(apiPage.getEmailInput(), gecersizEposta);
    }

    @And("Form gönderilir")
    public void formGonderilir() {
        rm.myClick(apiPage.getFormGonderButton());
    }

    @Then("Sistem e-posta format hatası mesajı gösterir ve talep iletilmez")
    public void sistemEPostaFormatHatasiMesajiGosterirVeTalepIletilmez() {
        Assert.assertTrue(apiPage.getFormatHatasiMesaji().isVisible());
    }
}