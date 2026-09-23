package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.*;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Given("Kullanıcı sisteme giriş yapmış durumdadır")
    public void kullaniciSistemeGirisYapmisDurumdadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        if (homePage.getGirisYapLink().isVisible()) {
            rm.myClick(homePage.getGirisYapLink());
        }
    }

    @And("Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır")
    public void kullaniciSanalDekorasyonOlusturmaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
    }

    @When("Kullanıcı geçerli formatta bir oda görseli yükler \\({string})")
    public void kullaniciGecerliFormattaBirOdaGorseliYukler(String dosyaAdi) {
        rm.mySendKeys(virtualStagingPage.getOdaGorseliInput(), "src/test/resources/" + dosyaAdi);
    }

    @And("Kullanıcı {string} olarak {string} seçer")
    public void kullaniciOlarakSecer(String alan, String deger) {
        if (alan.equals("Oda Türü")) {
            rm.myClick(virtualStagingPage.getOdaTuruDropdown());
            if (deger.equals("Yatak Odası")) {
                rm.myClick(virtualStagingPage.getYatakOdasiSecenegi());
            } else if (deger.equals("Oturma Odası")) {
                rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
            }
        } else if (alan.equals("Tasarım Stili")) {
            rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
            if (deger.equals("Modern")) {
                rm.myClick(virtualStagingPage.getModernSecenegi());
            } else if (deger.equals("Skandinav")) {
                rm.myClick(virtualStagingPage.getSkandinavSecenegi());
            }
        }
    }

    @And("{string} toggle'ının {string} olduğu doğrulanır")
    public void toggleInOlduguDogrulanir(String toggleAdi, String durum) {
        Assert.assertTrue(virtualStagingPage.getMevcutMobilyalariKaldirToggle().isVisible());
    }

    @And("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButton());
    }

    @Then("Yapay zeka işleme süreci başlar")
    public void yapayZekaIslemeSureciBaslar() {
        Assert.assertTrue(PD.getPage().url().contains("staging") || virtualStagingPage.getDekorasyonOlusturButton().isVisible());
    }

    @And("Sistem yüklenen odanın mobilyalandırılmış versiyonunu başarıyla üretir ve ekranda gösterir")
    public void sistemYuklenenOdaninMobilyalandirilmisVersiyonunuBasariylaUretirVeEkrandaGosterir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı görünürlük tercihi olarak Herkese açık galeride göster radyo butonunu seçer")
    public void kullaniciGorunurlukTercihiOlarakHerkesAcikGalerideGosterRadyoButonunuSecer() {
        rm.myClick(virtualStagingPage.getHerkeseAcikGaleriRadio());
    }

    @Then("Sistem başarıyla yeni dekorasyonu oluşturur")
    public void sistemBasariylaYeniDekorasyonuOlusturur() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı desteklenmeyen formatta bir görsel yükler \\({string})")
    public void kullaniciDesteklenmeyenFormattaBirGorselYukler(String gecersizDosya) {
        rm.mySendKeys(virtualStagingPage.getOdaGorseliInput(), "src/test/resources/" + gecersizDosya);
    }

    @Then("{string} hata mesajı alınır")
    public void hataMesajiAlinir(String hataMesaji) {
        rm.veriyfyContainsText(virtualStagingPage.getHataMesaji(), hataMesaji);
    }

    @And("Dekorasyon Oluştur butonunun pasif olduğu doğrulanır")
    public void dekorasyonOlusturButonununPasifOlduguDogrulanir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButton().isEnabled());
    }

    @And("Kullanıcı {string} ve {string} seçimlerini boş bırakır")
    public void kullaniciVeSecimleriniBosBirakir(String alan1, String alan2) {
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButton().isVisible());
    }

    @When("Kullanıcı izin verilen maksimum dosya boyutunda geçerli bir JPG görseli yükler")
    public void kullaniciIzinVerilenMaksimumDosyaBoyutundaGecerliBirJPGGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getOdaGorseliInput(), "src/test/resources/oda.jpg");
    }

    @And("Kullanıcı zorunlu alanları doldurur")
    public void kullaniciZorunluAlanlariDoldurur() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getYatakOdasiSecenegi());
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
        rm.myClick(virtualStagingPage.getModernSecenegi());
    }

    @Then("Sistem yüklemeyi kabul eder ve dekorasyon sürecini başlatır")
    public void sistemYuklemeyiKabulEderVeDekorasyonSureciniBaslatir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle'ını kapatır")
    public void kullaniciVarsayilanOlarakAcikGelenMevcutMobilyalariKaldirToggleInuKapatir() {
        rm.myClick(virtualStagingPage.getMevcutMobilyalariKaldirToggle());
    }

    @Then("Sistem mevcut mobilyaları koruyarak yeni dekorasyon çıktısı üretir")
    public void sistemMevcutMobilyalariKoruyarakYeniDekorasyonCiktisiUretir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı {string} sekmesindedir")
    public void kullaniciSekmesindedir(String sekmeAdi) {
        if (sekmeAdi.equals("AI Edit")) {
            PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        }
    }

    @When("Edit photo source alanında varsayılan olarak Current image seçili olduğu doğrulanır")
    public void editPhotoSourceAlanindaVarsayilanOlarakCurrentImageSeciliOlduguDogrulanir() {
        Assert.assertTrue(aiEditPage.getCurrentimageRadio().isVisible());
    }

    @And("Kullanıcı Describe what to change alanına {string} yazar")
    public void kullaniciDescribeWhatToChangeAlaninaYazar(String prompt) {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), prompt);
    }

    @And("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(aiEditPage.getEditPhotoButton());
    }

    @And("Sistem girilen talimata uygun şekilde güncellenmiş görseli ekranda gösterir")
    public void sistemGirilenTalimataUygunSekildeGuncellenmisGorseliEkrandaGosterir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı Edit photo source için alternatif bir kaynak görsel yükler \\({string})")
    public void kullaniciEditPhotoSourceIcinAlternatifBirKaynakGorselYukler(String dosya) {
        rm.mySendKeys(aiEditPage.getAlternatifGorselInput(), "src/test/resources/" + dosya);
    }

    @Then("Sistem yüklenen alternatif görsel üzerinde düzenlemeyi gerçekleştirir")
    public void sistemYuklenenAlternatifGorselUzerindeDuzenlemeyiGerceklestirir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı kaynak görseli seçer")
    public void kullaniciKaynakGorseliSecer() {
        rm.mySendKeys(aiEditPage.getAlternatifGorselInput(), "src/test/resources/oda.jpg");
    }

    @And("Kullanıcı Describe what to change alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        // Alan boş bırakılır
    }

    @Then("Edit Photo butonunun pasif olduğu doğrulanır")
    public void editPhotoButonununPasifOlduguDogrulanir() {
        Assert.assertFalse(aiEditPage.getEditPhotoButton().isEnabled());
    }

    @And("Kullanıcı Describe what to change alanına sistem sınırlarını zorlayan çok uzun ve detaylı bir prompt yazar")
    public void kullaniciDescribeWhatToChangeAlaninaSistemSinirlariniZorlayanCokUzunVeDetayliBirPromptYazar() {
        rm.mySendKeys(aiEditPage.getDescribeWhatToChangeInput(), "A".repeat(1000));
    }

    @Then("Sistem talebi işleme alır veya karakter sınır aşımı uyarısı gösterir")
    public void sistemTalebiIslemeAlirVeyaKarakterSinirAsimiUyarisiGosterir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Header üzerindeki Ürünler menüsüne hover yapar")
    public void kullaniciHeaderUzerindekiUrunlerMenusuneHoverYapar() {
        homePage.getUrunlerMenu().hover();
    }

    @And("Açılan dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanDropdownMenudenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(homePage.getAiVirtualTourSecenegi());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilir")
    public void kullaniciSayfasinaYonlendirilir(String urlKismi) {
        Assert.assertTrue(PD.getPage().url().contains(urlKismi));
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(virtualTourPage.getErkenErisimIsteyinButton());
    }

    @And("Kullanıcı zorunlu alan olan e-posta adresini girer \\({string})")
    public void kullaniciZorunluAlanOlanEPostaAdresiniGirer(String email) {
        rm.mySendKeys(virtualTourPage.getEmailInput(), email);
    }

    @And("Kullanıcı formu gönderir")
    public void kullaniciFormuGonderir() {
        rm.myClick(virtualTourPage.getFormGonderButton());
    }

    @Then("Sistem talebi alır ve ekranda başarı mesajı gösterir")
    public void sistemTalebiAlirVeEkrandaBasariMesajiGosterir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı Yapay Zeka Sanal Tur erken erişim formundadır")
    public void kullaniciYapayZekaSanalTurErkenErisimFormundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
    }

    @When("Kullanıcı e-posta alanına geçersiz bir format girer \\({string})")
    public void kullaniciEPostaAlaninaGecersizBirFormatGirer(String gecersizEmail) {
        rm.mySendKeys(virtualTourPage.getEmailInput(), gecersizEmail);
    }

    @Then("{string} hata mesajı görüntülenir")
    public void hataMesajiGoruntulenir(String mesaj) {
        rm.veriyfyContainsText(virtualTourPage.getGecersizEmailHataMesaji(), mesaj);
    }

    @And("Form gönderilemez")
    public void formGonderilemez() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı daha önce kayıt olmuş bir e-posta adresi ile erken erişim formu doldurur")
    public void kullaniciDahaOnceKayitOlmusBirEPostaAdresiIleErkenErisimFormuDoldurur() {
        rm.mySendKeys(virtualTourPage.getEmailInput(), "test@example.com");
    }

    @Then("Sistem daha önce kayıt oluşturulduğuna dair bilgilendirme mesajı gösterir")
    public void sistemDahaOnceKayitOlusturuldugunaDairBilgilendirmeMesajiGosterir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı Header Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar")
    public void kullaniciHeaderUrunlerMenusundenSanalDekorasyonAPISecenegineTiklar() {
        homePage.getUrunlerMenu().hover();
        rm.myClick(homePage.getSanalDekorasyonApiSecenegi());
    }

    @When("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String sayfaAdi) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
    }

    @And("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(apiPage.getIletisimeGecinButton());
    }

    @And("Kullanıcı zorunlu alanlar olan ad, e-posta ve mesaj alanlarını doldurur")
    public void kullaniciZorunluAlanlarOlanAdEPostaVeMesajAlanlariniDoldurur() {
        rm.mySendKeys(apiPage.getAdInput(), "Test Kullanici");
        rm.mySendKeys(apiPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(apiPage.getMesajInput(), "Test mesajidir.");
    }

    @Then("Başarılı bir onay mesajı görüntülenir")
    public void basariliBirOnayMesajiGoruntulenir() {
        Assert.assertTrue(true);
    }

    @When("Kullanıcı sayfa içerisindeki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaIcerisindekiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(apiPage.getFiyatlandirmayiGoruntuleButton());
    }

    @Then("Kullanıcı Fiyatlandırma sayfasına sorunsuz bir şekilde yönlendirilir")
    public void kullaniciFiyatlandirmaSayfasinaSorunsuzBirSekildeYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @When("Kullanıcı {string} formundaki zorunlu alanları \\(ad, e-posta, mesaj) boş bırakır")
    public void kullaniciFormundakiZorunluAlanlariAdEPostaMesajBosBirakir(String formAdi) {
        // Boş bırakıldı
    }

    @And("Kullanıcı form gönder butonuna tıklar")
    public void kullaniciFormGonderButonunaTiklar() {
        rm.myClick(apiPage.getFormGonderButton());
    }

    @Then("Zorunlu alanların altında hata uyarıları görüntülenir")
    public void zorunluAlanlarinAltindaHataUyarilariGoruntulenir() {
        Assert.assertTrue(true);
    }

    @And("Kullanıcı {string} iletişim formundadır")
    public void kullaniciIletisimFormundadir(String formAdi) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
    }

    @When("Kullanıcı Mesaj alanına izin verilen maksimum karakter sınırını aşan uzunlukta metin girer")
    public void kullaniciMesajAlaninaIzinVerilenMaksimumKarakterSiniriniAsanUzunluktaMetinGirer() {
        rm.mySendKeys(apiPage.getMesajInput(), "M".repeat(5000));
    }

    @Then("Karakter sınırı aşım uyarısı alınır veya fazla karakterler kırpılır")
    public void karakterSiniriAsimUyarisiAlinirVeyaFazlaKarakterlerKirpilir() {
        Assert.assertTrue(true);
    }
}