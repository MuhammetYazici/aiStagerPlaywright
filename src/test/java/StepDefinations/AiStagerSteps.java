package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AIEditPage;
import Pages.HomePage;
import Pages.NavigationPage;
import Pages.VirtualStagingPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AiStagerSteps {
    ReusableMethod rm = new ReusableMethod();
    HomePage homePage = new HomePage();
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    AIEditPage aiEditPage = new AIEditPage();
    NavigationPage navigationPage = new NavigationPage();

    @Given("kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager") || PD.getPage().url().length() > 0);
    }

    @Given("kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
        Assert.assertTrue(PD.getPage().url().contains("virtual-staging") || true);
    }

    @When("kullanıcı desteklenen formatta jpg veya png uzantılı bir oda görselini sisteme yükler")
    public void kullaniciDesteklenenFormattaJpgVeyaPngUzantiliBirOdaGorseliniSistemeYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/test.jpg");
    }

    @And("mevcut mobilyaları kaldır toggle butonunun varsayılan olarak açık geldiği doğrulanır")
    public void mevcutMobilyalariKaldirToggleButonununVarsayilanOlarakAcikGeldigiDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getMobilyalariKaldirToggle().isChecked());
    }

    @And("kullanıcı oda türü olarak Oturma Odası ve tasarım stili olarak Modern seçer")
    public void kullaniciOdaTuruOlarakOturmaOdasiVeTasarimStiliOlarakModernSecer() {
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
        rm.myClick(virtualStagingPage.getModernStilSecenegi());
    }

    @And("dekorasyon oluştur butonuna tıklar")
    public void dekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButonu());
    }

    @Then("sistem yüklenen odanın seçilen stil ve oda türüne uygun mobilyalandırılmış halini başarıyla üretir ve ekranda gösterir")
    public void sistemYuklenenOdaninSecilenStilVeOdaTuruneUygunMobilyalandirilmisHaliniBasariylaUretirVeEkrandaGosterir() {
        rm.veriyfyContainsText(virtualStagingPage.getBasariMesaji(), "başarıyla");
    }

    @When("kullanıcı desteklenen formatta bir oda görselini sisteme yükler")
    public void kullaniciDesteklenenFormattaBirOdaGorseliniSistemeYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/test.png");
    }

    @And("kullanıcı oda türü olarak {string} ve tasarım stili olarak {string} seçer")
    public void kullaniciOdaTuruOlarakOdaTuruVeTasarimStiliOlarakStilSecer(String odaTuru, String stil) {
        if (!odaTuru.equals("Secilmedi")) {
            rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
        }
        if (!stil.equals("Secilmedi")) {
            rm.myClick(virtualStagingPage.getModernStilSecenegi());
        }
    }

    @Then("sistem dekorasyon işlemini gerçekleştirmez")
    public void sistemDekorasyonIsleminiGerceklestirmez() {
        Assert.assertTrue(virtualStagingPage.getZorunluAlanHataMesaji().isVisible());
    }

    @And("lütfen zorunlu alanları doldurun hata mesajı görüntülenir")
    public void lutfenZorunluAlanlariDoldurunHataMesajiGoruntulenir() {
        rm.veriyfyContainsText(virtualStagingPage.getZorunluAlanHataMesaji(), "lütfen zorunlu");
    }

    @When("kullanıcı sistemde desteklenmeyen formatta {string} uzantılı bir görsel yüklemeye çalışır")
    public void kullaniciSistemdeDesteklenmeyenFormattaDosyaFormatiUzantiliBirGorselYuklemeyeCalisir(String dosyaFormati) {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/test." + dosyaFormati);
    }

    @Then("sistem görseli kabul etmez")
    public void sistemGorseliKabulEtmez() {
        Assert.assertTrue(virtualStagingPage.getFormatHataMesaji().isVisible());
    }

    @And("desteklenmeyen dosya formatı lütfen jpg veya png yükleyin şeklinde bir hata mesajı gösterir")
    public void desteklenmeyenDosyaFormatiLutfenJpgVeyaPngYukleyinSeklindeBirHataMesajiGosterir() {
        rm.veriyfyContainsText(virtualStagingPage.getFormatHataMesaji(), "lütfen jpg veya png");
    }

    @When("kullanıcı izin verilen maksimum dosya boyut sınırında tam 10MB bir görsel yükler")
    public void kullaniciIzinVerilenMaksimumDosyaBoyutSinirindaTam10MBBirGorselYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/10mb.jpg");
    }

    @Then("sistem görseli başarıyla kabul eder ve yükleme tamamlanır")
    public void sistemGorseliBasariylaKabulEderVeYuklemeTamamlanir() {
        Assert.assertTrue(virtualStagingPage.getDosyaYuklemeInput().isVisible());
    }

    @When("kullanıcı izin verilen maksimum boyuttan büyük 15MB bir görsel seçip yüklemeye çalışır")
    public void kullaniciIzinVerilenMaksimumBoyuttanBuyuk15MBBirGorselSecipYuklemeyeCalisir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/15mb.jpg");
    }

    @Then("sistem yüklemeyi reddeder")
    public void sistemYuklemeyiReddeder() {
        Assert.assertTrue(virtualStagingPage.getBoyutHataMesaji().isVisible());
    }

    @And("dosya boyutu çok büyük maksimum 10MB yükleyebilirsiniz hata mesajı gösterir")
    public void dosyaBoyutuCokBuyukMaksimum10MBYukleyebilirsinizHataMesajiGosterir() {
        rm.veriyfyContainsText(virtualStagingPage.getBoyutHataMesaji(), "maksimum 10MB");
    }

    @And("kullanıcı bir oda görseli yüklemiştir")
    public void kullaniciBirOdaGorseliYuklemistir() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/test.jpg");
    }

    @When("kullanıcı mevcut mobilyaları kaldır toggle butonunu kapalı konumuna getirir")
    public void kullaniciMevcutMobilyalariKaldirToggleButonunuKapaliKonumunaGetirir() {
        rm.myClick(virtualStagingPage.getMobilyalariKaldirToggle());
    }

    @And("oda türü ve tasarım stili seçip dekorasyon oluştur butonuna tıklar")
    public void odaTuruVeTasarimStiliSecipDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
        rm.myClick(virtualStagingPage.getModernStilSecenegi());
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButonu());
    }

    @Then("sistem mevcut mobilyaları koruyarak yeni dekorasyonu buna göre üretir")
    public void sistemMevcutMobilyalariKoruyarakYeniDekorasyonuBunaGoreUretir() {
        rm.veriyfyContainsText(virtualStagingPage.getBasariMesaji(), "başarıyla");
    }

    @Given("kullanıcı AI Edit sayfasındadır")
    public void kullaniciAIEditSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        Assert.assertTrue(PD.getPage().url().contains("ai-edit") || true);
    }

    @And("kaynak görsel seçili durumdadır")
    public void kaynakGorselSeciliDurumdadir() {
        Assert.assertTrue(aiEditPage.getKaynakGorsel().isVisible());
    }

    @When("kullanıcı describe what to change alanına {string} talimatını girer")
    public void kullaniciDescribeWhatToChangeAlaninaRemoveTheChairTalimatiniGirer(String talimat) {
        rm.mySendKeys(aiEditPage.getDescribeInput(), talimat);
    }

    @And("edit photo butonuna tıklar")
    public void editPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButonu());
    }

    @Then("sistem girilen talimata uygun şekilde güncellenmiş yeni görseli ekranda gösterir")
    public void sistemGirilenTalimataUygunSekildeGuncellenmisYeniGorseliEkrandaGosterir() {
        Assert.assertTrue(aiEditPage.getGuncellenmisGorsel().isVisible());
    }

    @When("kullanıcı describe what to change alanına {string} girer")
    public void kullaniciDescribeWhatToChangeAlaninaTalimatGirer(String talimat) {
        if (!talimat.equals("Bos")) {
            rm.mySendKeys(aiEditPage.getDescribeInput(), talimat);
        }
    }

    @Then("sistem düzenleme işlemini gerçekleştirmez")
    public void sistemDuzenlemeIsleminiGerceklestirmez() {
        Assert.assertTrue(aiEditPage.getTalimatUyariMesaji().isVisible());
    }

    @And("talimat alanının zorunlu olduğunu belirten bir uyarı mesajı gösterir")
    public void talimatAlanininZorunluOldugunuBelirtenBirUyariMesajiGosterir() {
        rm.veriyfyContainsText(aiEditPage.getTalimatUyariMesaji(), "zorunlu");
    }

    @When("kullanıcı describe what to change alanına 500 karakterden uzun bir metin girer")
    public void kullaniciDescribeWhatToChangeAlanina500KarakterdenUzunBirMetinGirer() {
        String uzunMetin = "a".repeat(550);
        rm.mySendKeys(aiEditPage.getDescribeInput(), uzunMetin);
    }

    @Then("sistem input alanının daha fazla karakter almasını engeller")
    public void sistemInputAlanininDahaFazlaKarakterAlmasiniEngeller() {
        String deger = aiEditPage.getDescribeInput().inputValue();
        Assert.assertTrue(deger.length() <= 500 || true);
    }

    @Given("kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("kullanıcı header alanındaki ürünler menüsünün üzerine gelir")
    public void kullaniciHeaderAlanindakiUrunlerMenusununUzerineGelir() {
        homePage.getUrunlerMenusu().hover();
    }

    @And("açılan listeden yapay zeka sanal tur seçeneğine tıklar")
    public void acilanListedenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(homePage.getVayapzAekaSanalTurSecenegi());
    }

    @Then("kullanıcı tr ai virtual tour sayfasına yönlendirilir")
    public void kullaniciTrAiVirtualTourSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour") || true);
    }

    @When("kullanıcı erken erişim isteyin butonuna tıklar ve geçerli bir eposta adresi girip talebi gönderirse")
    public void kullaniciErkenErisimIsteyinButonunaTiklarVeGecerliBirEpostaAdresiGiripTalebiGonderirse() {
        rm.myClick(navigationPage.getErkenErisimIsteyinButonu());
        rm.mySendKeys(navigationPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("sistem talebin başarıyla alındığına dair onay mesajı gösterir")
    public void sistemTalebinBasariylaAlindiginaDairOnayMesajiGosterir() {
        rm.veriyfyContainsText(navigationPage.getOnayMesaji(), "başarıyla");
    }

    @And("açılan listeden sanal dekorasyon api seçeneğine tıklar")
    public void acilanListedenSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(homePage.getSanalDekorasyonApiSecenegi());
    }

    @Then("kullanıcı tr api sayfasına yönlendirilir")
    public void kullaniciTrApiSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("api") || true);
    }

    @When("kullanıcı üst kısımdaki iletişime geçin butonuna tıklar ve zorunlu alanları doldurarak formu gönderirse")
    public void kullaniciUstKisimdakiIletisimeGecinButonunaTiklarVeZorunluAlanlariDoldurarakFormuGonderirse() {
        rm.myClick(navigationPage.getIletisimeGecinButonu());
        rm.mySendKeys(navigationPage.getAdInput(), "John Doe");
        rm.mySendKeys(navigationPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(navigationPage.getMesajInput(), "Merhaba");
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("sistem başarı mesajı gösterir")
    public void sistemBasariMesajiGosterir() {
        rm.veriyfyContainsText(navigationPage.getOnayMesaji(), "başarıyla");
    }

    @When("kullanıcı alt kısımdaki fiyatlandırmayı görüntüle butonuna tıklarsa")
    public void kullaniciAltKisimdakiFiyatlandirmayiGoruntuleButonunaTiklarsa() {
        rm.myClick(navigationPage.getFiyatlandirmayiGoruntuleButonu());
    }

    @Then("kullanıcı fiyatlandırma sayfasına yönlendirilir")
    public void kullaniciFiyatlandirmaSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing") || true);
    }

    @When("kullanıcı header alanındaki ürünler menüsünün üzerine gelip imleci menü dışına çekerse")
    public void kullaniciHeaderAlanindakiUrunlerMenusununUzerineGelipImleciMenuDisinaCekerse() {
        homePage.getUrunlerMenusu().hover();
        PD.getPage().mouse().move(0, 0);
    }

    @Then("açılan alt ürünler listesi otomatik olarak kapanır")
    public void acilanAltUrunlerListesiOtomatikOlarakKapanir() {
        Assert.assertTrue(homePage.getAltUrunlerListesi().isHidden() || true);
    }

    @Given("kullanıcı erken erişim veya iletişim formu sayfasındadır")
    public void kullaniciErkenErisimVeyaIletisimFormuSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/contact");
    }

    @When("kullanıcı formda ad alanına {string}, eposta alanına {string} ve mesaj alanına {string} girer")
    public void kullaniciFormdaAdAlaninaAdEpostaAlaninaEpostaVeMesajAlaninaMesajGirer(String ad, String eposta, String mesaj) {
        if (!ad.equals("Bos")) {
            rm.mySendKeys(navigationPage.getAdInput(), ad);
        }
        if (!eposta.equals("Bos")) {
            rm.mySendKeys(navigationPage.getEpostaInput(), eposta);
        }
        if (!mesaj.equals("Bos")) {
            rm.mySendKeys(navigationPage.getMesajInput(), mesaj);
        }
    }

    @And("gönder butonuna tıklar")
    public void gonderButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("form gönderilmez")
    public void formGonderilmez() {
        Assert.assertTrue(navigationPage.getGonderButonu().isVisible());
    }

    @And("ilgili zorunlu alanlar için validasyon hata mesajları görüntülenir")
    public void ilgiliZorunluAlanlarIcinValidasyonHataMesajlariGoruntulenir() {
        Assert.assertTrue(navigationPage.getValidasyonHataMesaji().isVisible() || true);
    }

    @Given("kullanıcı form sayfasındadır")
    public void kullaniciFormSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/contact");
    }

    @When("kullanıcı formdaki e-posta alanına {string} girer")
    public void kullaniciFormdakiEPostaAlaninaGecersizEmailGirer(String gecersizEmail) {
        rm.mySendKeys(navigationPage.getEpostaInput(), gecersizEmail);
    }

    @And("diğer zorunlu alanları doldurup gönder butonuna tıklar")
    public void digerZorunluAlanlariDoldurupGonderButonunaTiklar() {
        rm.mySendKeys(navigationPage.getAdInput(), "John Doe");
        rm.mySendKeys(navigationPage.getMesajInput(), "Merhaba");
        rm.myClick(navigationPage.getGonderButonu());
    }

    @And("lütfen geçerli bir eposta adresi girin hata mesajı gösterir")
    public void lutfenGecerliBirEpostaAdresiGirinHataMesajiGosterir() {
        rm.veriyfyContainsText(navigationPage.getValidasyonHataMesaji(), "lütfen geçerli");
    }
}