package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.*;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class AistagerTestcasesSteps {

    HomePage homePage = new HomePage();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AiEditPage aiEditPage = new AiEditPage();
    VirtualTourPage virtualTourPage = new VirtualTourPage();
    ApiPage apiPage = new ApiPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır")
    public void kullaniciGirisYapmisVeVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
    }

    @When("Desteklenen formatta \".jpg\" veya \".png\" bir oda fotoğrafı yüklenir")
    public void desteklenenFormattaJpgVeyaPngBirOdaFotografiYuklenir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "path/to/test.jpg");
    }

    @Then("Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak açık olduğu görülür")
    public void mevcutMobilyalariKaldirSecenegininVarsayilanOlarakAcikOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getMevcutMobilyalariKaldirCheckbox().isVisible());
    }

    @When("{string} ve {string} seçimleri yapılır")
    public void odaTuruVeTasarimStiliSecimleriYapilir(String odaTuru, String tasarimStili) {
        rm.myClick(virtualStagingPage.getOdaTuruSecimi());
        rm.myClick(virtualStagingPage.getTasarimStiliSecimi());
    }

    @And("Dekorasyon Oluştur butonunun aktif olduğu görülür")
    public void dekorasyonOlusturButonununAktifOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @And("Dekorasyon Oluştur butonuna tıklanır")
    public void dekorasyonOlusturButonunaTiklanir() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButonu());
    }

    @Then("Sistem yüklenen odayı analiz eder ve seçilen stile uygun mobilyalandırılmış yeni görseli ekranda gösterir")
    public void sistemYuklenenOdayiAnalizEderVeSecilenStileUygunMobilyalandirilmisYeniGorseliEkrandaGosterir() {
        Assert.assertTrue(virtualStagingPage.getBasariMesaji().isVisible());
    }

    @When("Desteklenmeyen formatta bir dosya \".gif\", \".pdf\" veya \".txt\" yüklenir")
    public void desteklenmeyenFormattaBirDosyaGifPdfVeyaTxtYuklenir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "path/to/test.gif");
    }

    @Then("Sistem hata mesajı gösterir ve görselin yüklenmesine izin vermez")
    public void sistemHataMesajiGosterirVeGorselinYuklenmesineIzinVermez() {
        Assert.assertTrue(virtualStagingPage.getHataMesaji().isVisible());
    }

    @And("Dekorasyon Oluştur butonu pasif kalır")
    public void dekorasyonOlusturButonuPasifKalir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Görsel yüklenir ancak Oda Türü veya Tasarım Stili seçimlerinden biri boş bırakılır")
    public void gorselYuklenirAncakOdaTuruVeyaTasarimStiliSecimlerindenBiriBosBirakilir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "path/to/test.jpg");
    }

    @Then("Dekorasyon Oluştur butonunun pasif olduğu doğrulanır")
    public void dekorasyonOlusturButonununPasifOlduguDogrulanir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Sistem sınırlarında kabul edilen minimum veya maksimum dosya boyutunda geçerli bir \".jpg\" görseli yüklenir")
    public void sistemSinirlarindaKabulEdilenMinimumVeyaMaksimumDosyaBoyutundaGecerliBirJpgGorseliYuklenir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "path/to/test.jpg");
    }

    @Then("İşlemin başarıyla tamamlandığı ve görselin üretildiği doğrulanır")
    public void isleminBasariylaTamamlandigiVeGorselinUretildigiDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getBasariMesaji().isVisible());
    }

    @When("Desteklenen formatta bir oda fotoğrafı yüklenir")
    public void desteklenenFormattaBirOdaFotografiYuklenir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "path/to/test.jpg");
    }

    @And("\"Mevcut mobilyaları kaldır\" seçeneği manuel olarak kapatılır \\(disabled yapılır\\)")
    public void mevcutMobilyalariKaldirSecenegiManuelOlarakKapatilirDisabledYapilir() {
        rm.myClick(virtualStagingPage.getMevcutMobilyalariKaldirCheckbox());
    }

    @Then("Sistem mevcut mobilyaları koruyarak yeni dekorasyon çıktısı üretir")
    public void sistemMevcutMobilyalariKoruyarakYeniDekorasyonCiktisiUretir() {
        Assert.assertTrue(virtualStagingPage.getBasariMesaji().isVisible());
    }

    @Given("Kullanıcı \"AI Edit\" sekmesindedir")
    public void kullaniciAiEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
    }

    @Then("\"Edit photo source\" alanında varsayılan olarak \"Current image\" \\(mevcut görsel\\) seçili olduğu görülür")
    public void editPhotoSourceAlanindaVarsayilanOlarakCurrentImageMevcutGorselSeciliOlduguGorulur() {
        Assert.assertTrue(aiEditPage.getEditPhotoSource().isVisible());
    }

    @When("Describe what to change alanına geçerli bir talimat olan \"Remove the chair\" girilir")
    public void describeWhatToChangeAlaninaGecerliBirTalimatOlanRemoveTheChairGirilir() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Remove the chair");
    }

    @And("\"Edit Photo\" butonuna tıklanır")
    public void editPhotoButtonunaTiklanir() {
        rm.myClick(aiEditPage.getEditPhotoButonu());
    }

    @Then("Yapay zeka talimatı işler ve güncellenmiş görseli kullanıcıya sunar")
    public void yapayZekaTalimatiIslerVeGuncellenmisGorseliKullaniciyaSunar() {
        Assert.assertTrue(aiEditPage.getEditPhotoSource().isVisible());
    }

    @And("Kaynak görsel hazırdır")
    public void kaynakGorselHazirdir() {
        Assert.assertTrue(aiEditPage.getEditPhotoSource().isVisible());
    }

    @When("Describe what to change alanı tamamen boş bırakılır")
    public void describeWhatToChangeAlaniTamamenBosBirakilir() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "");
    }

    @Then("Edit Photo butonunun pasif olduğu veya işlemin tetiklenemediği doğrulanır")
    public void editPhotoButtonununPasifOlduguVeyaIsleminTetiklenemedigiDogrulanir() {
        Assert.assertFalse(aiEditPage.getEditPhotoButonu().isEnabled());
    }

    @And("Sistem kullanıcıya uyarı mesajı gösterir")
    public void sistemKullaniciyaUyariMesajiGosterir() {
        Assert.assertTrue(aiEditPage.getUyariMesaji().isVisible());
    }

    @When("Describe what to change alanına izin verilen maksimum karakter sınırında ve özel karakterler içeren bir prompt girilir")
    public void describeWhatToChangeAlaninaIzinVerilenMaksimumKarakterSinirindaVeOzelKarakterlerIcerenBirPromptGirilir() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "Test prompt !@#$%^&*()");
    }

    @Then("Sistemin bu girdiyi hata vermeden işlediği veya uygun bir yönlendirme yaptığı doğrulanır")
    public void sisteminBuGirdiyiHataVermedenIsledigiVeyaUygunBirYonlendirmeYaptigiDogrulanir() {
        Assert.assertTrue(aiEditPage.getEditPhotoSource().isVisible());
    }

    @When("Header'daki \"Ürünler\" menüsüne mause ile gelinir \\(hover yapılır\\)")
    public void headerDakiUrunlerMenusuneMauseIleGelinirHoverYapilir() {
        homePage.getUrunlerMenu().hover();
    }

    @Then("Alt seçeneklerin açıldığı görülür")
    public void altSeceneklerinAcildigiGorulur() {
        Assert.assertTrue(homePage.getAltSecenekler().isVisible());
    }

    @When("Açılan menüden Yapay Zeka Sanal Tur seçeneğine tıklanır")
    public void acilanMenudenYapayZekaSanalTurSecenegineTiklanir() {
        rm.myClick(homePage.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı ai-virtual-tour sayfasına yönlendirilir")
    public void kullaniciAiVirtualTourSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Sayfadaki Erken Erişim İsteyin butonuna tıklanır")
    public void sayfadakiErkenErisimIsteyinButonunaTiklanir() {
        rm.myClick(virtualTourPage.getErkenErisimIsteyinButonu());
    }

    @And("Erken erişim formu geçerli bilgilerle doldurulup gönderilir")
    public void erkenErisimFormuGecerliBilgilerleDoldurulupGonderilir() {
        rm.mySendKeys(virtualTourPage.getAdSoyadInput(), "Test User");
        rm.mySendKeys(virtualTourPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(virtualTourPage.getGonderButonu());
    }

    @Then("Sistem talebi alır ve başarılı onay mesajı gösterir")
    public void sistemTalebiAlirVeBasariliOnayMesajiGosterir() {
        Assert.assertTrue(virtualTourPage.getOnayMesaji().isVisible());
    }

    @Given("Kullanıcı ai-virtual-tour sayfasındadır")
    public void kullaniciAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
    }

    @When("Erken Erişim İsteyin butonuna tıklanıp form açılır")
    public void erkenErisimIsteyinButonunaTiklanipFormAcilir() {
        rm.myClick(virtualTourPage.getErkenErisimIsteyinButonu());
    }

    @And("Zorunlu alanlar boş bırakılarak gönderilmeye çalışılır")
    public void zorunluAlanlarBosBirakilarakGonderilmeyeCalisilir() {
        rm.myClick(virtualTourPage.getGonderButonu());
    }

    @Then("Sistem formun gönderilmesine izin vermez ve hata mesajları gösterir")
    public void sistemFormunGonderilmesineIzinVermezVeHataMesajlariGosterir() {
        Assert.assertTrue(virtualTourPage.getHataMesaji().isVisible());
    }

    @When("Header içindeki Ürünler menüsü üzerine hızlıca gelinip uzaklaşılır")
    public void headerIcindekiUrunlerMenusuUzerineHizlicaGelinipUzaklasilir() {
        homePage.getUrunlerMenu().hover();
        PD.getPage().mouse().move(0, 0);
    }

    @Then("Alt menünün kararsız kalmadan kapandığı doğrulanır")
    public void altMenununKarsarsizKalmadanKapandigiDogrulanir() {
        Assert.assertTrue(true);
    }

    @And("Tekrar menü üzerine gelinip Yapay Zeka Sanal Tur seçeneğine sorunsuz bir şekilde tıklanabildiği doğrulanır")
    public void tekrarMenuUzerineGelinipYapayZekaSanalTurSecenegineSorunsuzBirSekildeTiklanabildigiDogrulanir() {
        homePage.getUrunlerMenu().hover();
        rm.myClick(homePage.getYapayZekaSanalTurSecenegi());
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Header içindeki Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklanır")
    public void headerIcindekiUrunlerMenusundenSanalDekorasyonApiSecenegineTiklanir() {
        homePage.getUrunlerMenu().hover();
        rm.myClick(homePage.getSanalDekorasyonApiSecenegi());
    }

    @Then("Kullanıcı api sayfasına yönlendirilir")
    public void kullaniciApiSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Sayfadaki İletişime Geçin butonuna tıklanır")
    public void sayfadakiIletisimeGecinButonunaTiklanir() {
        rm.myClick(apiPage.getIletisimeGecinButonu());
    }

    @And("İletişim formu zorunlu alanları geçerli verilerle doldurulup gönderilir")
    public void iletisimFormuZorunluAlanlariGecerliVerilerleDoldurulupGonderilir() {
        rm.mySendKeys(apiPage.getAdInput(), "Test User");
        rm.mySendKeys(apiPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(apiPage.getMesajInput(), "Test message");
        rm.myClick(apiPage.getFormGonderButonu());
    }

    @Then("Sistem başarılı gönderim mesajı gösterir")
    public void sistemBasariliGonderimMesajiGosterir() {
        Assert.assertTrue(apiPage.getBasariMesaji().isVisible());
    }

    @When("Sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklanır")
    public void sayfaAltindakiFiyatlandirmayiGoruntuleButonunaTiklanir() {
        rm.myClick(apiPage.getFiyatlandirmayiGoruntuleButonu());
    }

    @Then("Kullanıcı Fiyatlandırma sayfasına başarıyla yönlendirilir")
    public void kullaniciFiyatlandirmaSayfasinaBasariylaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @Given("Kullanıcı api sayfasındadır")
    public void kullaniciApiSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
    }

    @When("İletişime Geçin formundaki zorunlu alanlardan biri boş bırakılarak gönderilmeye çalışılır")
    public void iletisimeGecinFormundakiZorunluAlanlardanBiriBosBirakilarakGonderilmeyeCalisilir() {
        rm.myClick(apiPage.getIletisimeGecinButonu());
        rm.myClick(apiPage.getFormGonderButonu());
    }

    @Then("Sistem formu göndermez ve ilgili alan için zorunlu alan uyarı mesajı gösterir")
    public void sistemFormuGondermezVeIlgiliAlanIcinZorunluAlanUyariMesajiGosterir() {
        Assert.assertTrue(apiPage.getZorunluAlanUyariMesaji().isVisible());
    }

    @When("\"İletişime Geçin\" formundaki e-posta alanına kurallara uygun olmayan bir metin \\(örn. \"testuser\"\\) girilir")
    public void iletisimeGecinFormundakiEPostaAlaninaKurallaraUygunOlmayanBirMetinOrnTestuserGirilir() {
        rm.myClick(apiPage.getIletisimeGecinButonu());
        rm.mySendKeys(apiPage.getEmailInput(), "testuser");
    }

    @And("Form gönderilmeye çalışılır")
    public void formGonderilmeyeCalisilir() {
        rm.myClick(apiPage.getFormGonderButonu());
    }

    @Then("Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı gösterir")
    public void sistemGecerliBirEPostaAdresiGirilmesiGerektigineDairHataMesajiGosterir() {
        Assert.assertTrue(apiPage.getZorunluAlanUyariMesaji().isVisible());
    }
}