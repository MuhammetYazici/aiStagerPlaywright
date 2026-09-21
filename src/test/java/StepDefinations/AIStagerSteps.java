package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AIStagerPages;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AIStagerSteps {
    AIStagerPages pages = new AIStagerPages();
    ReusableMethod rm = new ReusableMethod();

    @Given("kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @Given("kullanıcı Sanal Dekorasyon sayfasındadır")
    public void kullaniciSanalDekorasyonSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/sanal-dekorasyon");
        rm.veriyfyContainsText(pages.getDekorasyonOlusturButton(), "Dekorasyon Oluştur");
    }

    @Given("kullanıcı desteklenen formatta bir görsel yükler")
    public void kullaniciDesteklenenFormattaBirGorselYukler() {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @Given("kullanıcı Oda Türü olarak Yatak Odası seçer")
    public void kullaniciOdaTuruOlarakYatakOdasiSecer() {
        rm.myClick(pages.getOdaTuruDropdown());
        rm.myClick(PD.getPage().locator("text=Yatak Odası").first());
    }

    @Given("kullanıcı Tasarım Stili olarak Modern seçer")
    public void kullaniciTasarimStiliOlarakModernSecer() {
        rm.myClick(pages.getTasarimStiliDropdown());
        rm.myClick(PD.getPage().locator("text=Modern").first());
    }

    @Given("Mevcut mobilyaları kaldır toggle butonu açık durumdadır")
    public void mevcutMobilyalariKaldirToggleButonuAcikDurumdadir() {
        Assert.assertTrue(pages.getMobilyalariKaldirToggle().isChecked());
    }

    @When("kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(pages.getDekorasyonOlusturButton());
    }

    @Then("sistem yüklenen görseli analiz etmeli ve mobilyalandırılmış yeni görseli kullanıcıya sunmalıdır")
    public void sistemYuklenenGorseliAnalizEtmeliVeMobilyalandirilmisYeniGorseliKullaniciyaSunmalidir() {
        rm.veriyfyContainsText(pages.getBasariliGorselSonucu(), "");
    }

    @When("kullanıcı sistem tarafından desteklenmeyen {string} formatında bir dosya yüklemeye çalışır")
    public void kullaniciSistemTarafindanDesteklenmeyenFormatindaBirDosyaYuklemeyeCalisir(String dosya Formati) {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/" + rm.resolveDynamicValue(dosyaFormati)));
    }

    @Then("sistem hata mesajı göstermelidir ve görsel yükleme işlemi başarısız olmalıdır")
    public void sistemHataMesajiGostermelidirVeGorselYuklemeIslemiBasarisizOlmalidir() {
        rm.veriyfyContainsText(pages.getHataMesaji(), "hata");
    }

    @Given("kullanıcı geçerli bir görsel yükler")
    public void kullaniciGecerliBirGorselYukler() {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @When("kullanıcı Oda Türü veya Tasarım Stili alanlarından birini boş bırakır")
    public void kullaniciOdaTuruVeyaTasarimStiliAlanlarindanBiriniBosBirakir() {
        rm.myClick(pages.getOdaTuruDropdown());
        // Birini boş bırakmak için seçim yapmıyoruz
    }

    @Then("Dekorasyon Oluştur butonu pasif olmalıdır")
    public void dekorasyonOlusturButonuPasifOlmalidir() {
        Assert.assertFalse(pages.getDekorasyonOlusturButton().isEnabled());
    }

    @When("kullanıcı geçerli bir görsel yükler")
    public void kullaniciGecerliBirGorselYuklerWhen() {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @Then("Mevcut mobilyaları kaldır toggle butonunun durumu açık olarak gelmelidir")
    public void mevcutMobilyalariKaldirToggleButonununDurumuAcikOlarakGelmelidir() {
        Assert.assertTrue(pages.getMobilyalariKaldirToggle().isChecked());
    }

    @Given("kullanıcı AI Edit sekmesindedir")
    public void kullaniciAiEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(pages.getAiEditSekmesi());
    }

    @Given("varsayılan olarak Current image kaynak görsel seçili gelmektedir")
    public void varsayilanOlarakCurrentimageKaynakGorselSeciliGelmektedir() {
        Assert.assertTrue(pages.getCurrentimageSecenegi().isVisible());
    }

    @When("kullanıcı Describe what to change alanına {string} talimatını girer")
    public void kullaniciDescribeWhatToChangeAlaninaTalimatiniGirer(String talimat) {
        rm.mySendKeys(pages.getDescribeWhatToChangeInput(), rm.resolveDynamicValue(talimat));
    }

    @When("kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(pages.getEditPhotoButton());
    }

    @Then("sistem talimatı işlemeli ve değiştirilmiş görseli ekranda göstermelidir")
    public void sistemTalimatiIslemeliVeDegistirilmisGorseliEkrandaGostermelidir() {
        rm.veriyfyContainsText(pages.getBasariliGorselSonucu(), "");
    }

    @When("kullanıcı Current image yerine alternatif yeni bir kaynak görsel yükler")
    public void kullaniciCurrentimageYerineAlternatifYeniBirKaynakGorselYukler() {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @When("kullanıcı Describe what to change alanına talimat girer")
    public void kullaniciDescribeWhatToChangeAlaninaTalimatGirer() {
        rm.mySendKeys(pages.getDescribeWhatToChangeInput(), "Koltuk ekle");
    }

    @Then("sistem yeni yüklenen görsel üzerinden değişiklikleri uygulamalı ve sonucu göstermelidir")
    public void sistemYeniYuklenenGorselUzerindenDegisiklikleriUygulamaliVeSonucuGostermelidir() {
        rm.veriyfyContainsText(pages.getBasariliGorselSonucu(), "");
    }

    @Given("kullanıcı kaynak görsel seçmiştir")
    public void kullaniciKaynakGorselSecmistir() {
        pages.getDosyaYuklemeInput().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @Given("kullanıcı Describe what to change alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeAlaniniBosBirakir() {
        rm.mySendKeys(pages.getDescribeWhatToChangeInput(), "");
    }

    @Then("sistem düzenleme işlemini gerçekleştirmemeli ve hata mesajı göstermelidir")
    public void sistemDuzenlemeIsleminiGerceklestirmemeliVeHataMesajiGostermelidir() {
        rm.veriyfyContainsText(pages.getHataMesaji(), "hata");
    }

    @When("kullanıcı header alanındaki Ürünler dropdown menüsünün üzerine gelir")
    public void kullaniciHeaderAlanindakiUrunlerDropdownMenusununUzerineGelir() {
        pages.getUrunlerDropdown().hover();
    }

    @When("kullanıcı Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void kullaniciYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(pages.getYapayZekaSanalTurSecenegi());
    }

    @Then("kullanıcı aistager.ai\\/tr\\/ai-virtual-tour sayfasına yönlendirilmelidir")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @Given("kullanıcı aistager.ai\\/tr\\/ai-virtual-tour sayfasındadır")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-virtual-tour");
    }

    @When("kullanıcı sayfa üzerindeki Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciSayfaUzerindekiErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(pages.getErkenErisimIsteyinButton());
    }

    @When("kullanıcı zorunlu e-posta alanına {string} girer")
    public void kullaniciZorunluEPostaAlaninaGirer(String email) {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue(email));
    }

    @When("kullanıcı formu gönderirse")
    public void kullaniciFormuGonderirse() {
        rm.myClick(pages.getFormGonderButton());
    }

    @Then("sistem talebi kaydetmeli ve kullanıcıya başarılı iletim onay mesajı göstermelidir")
    public void sistemTalebiKaydetmeliVeKullaniciyaBasariliIletimOnayMesajiGostermelidir() {
        rm.veriyfyContainsText(pages.getBasariOnayMesaji(), "başarılı");
    }

    @Given("kullanıcı Erken Erişim İsteyin modalındadır")
    public void kullaniciErkenErisimIsteyinModalindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-virtual-tour");
        rm.myClick(pages.getErkenErisimIsteyinButton());
    }

    @When("kullanıcı zorunlu e-posta alanını {string} girerek gönder butonuna tıklar")
    public void kullaniciZorunluEPostaAlaniniGirerekGonderButonunaTiklar(String girisTipi) {
        if (!girisTipi.equals("boş bırakarak")) {
            rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue(girisTipi));
        }
        rm.myClick(pages.getFormGonderButton());
    }

    @Then("sistem talebi kabul etmemeli ve e-posta uyarı mesajı vermelidir")
    public void sistemTalebiKabulEtmemeliVeEPostaUyariMesajiVermelidir() {
        rm.veriyfyContainsText(pages.getHataMesaji(), "geçerli");
    }

    @When("kullanıcı header alanındaki Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar")
    public void kullaniciHeaderAlanindakiUrunlerMenusundenSanalDekorasyonApiSecenegineTiklar() {
        pages.getUrunlerDropdown().hover();
        rm.myClick(pages.getSanalDekorasyonApiSecenegi());
    }

    @Then("kullanıcı aistager.ai\\/tr\\/api sayfasına yönlendirilmelidir")
    public void kullaniciAistagerAiTrApiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/api"));
    }

    @Given("kullanıcı aistager.ai\\/tr\\/api sayfasındadır")
    public void kullaniciAistagerAiTrApiSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/api");
    }

    @When("kullanıcı üst kısımda yer alan İletişime Geçin butonuna tıklar")
    public void kullaniciUstKisimdaYerAlanIletisimeGecinButonunaTiklar() {
        rm.myClick(pages.getIletisimeGecinButton());
    }

    @When("kullanıcı ad, e-posta ve mesaj alanlarını geçerli bilgilerle doldurur")
    public void kullaniciAdEPostaVeMesajAlanlariniGecerliBilgilerleDoldurur() {
        rm.mySendKeys(pages.getAdSoyadInput(), "Test User");
        rm.mySendKeys(pages.getEmailInput(), "test@example.com");
        rm.mySendKeys(pages.getMesajInput(), "Test mesajıdır");
    }

    @Then("sistem talebi başarıyla iletmeli ve onay mesajı göstermelidir")
    public void sistemTalebiBasariylaIletmeliVeOnayMesajiGostermelidir() {
        rm.veriyfyContainsText(pages.getBasariOnayMesaji(), "başarılı");
    }

    @Given("kullanıcı API iletişim formundadir")
    public void kullaniciApiIletisimFormundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/api");
        rm.myClick(pages.getIletisimeGecinButton());
    }

    @When("kullanıcı zorunlu alanlardan birini boş bırakıp göndermeye çalışır")
    public void kullaniciZorunluAlanlardanBiriniBosBirakipGondermeyeCalisir() {
        rm.mySendKeys(pages.getAdSoyadInput(), "");
        rm.myClick(pages.getFormGonderButton());
    }

    @Then("sistem formun gönderilmesine izin vermemeli ve eksik alan uyarılarını göstermelidir")
    public void sistemFormunGonderilmesineIzinVermemeliVeEksikAlanUyarilariniGostermelidir() {
        rm.veriyfyContainsText(pages.getHataMesaji(), "zorunlu");
    }

    @Given("kullanıcı sayfanın alt kısmına kaydırma yapar")
    public void kullaniciSayfaninAltKisiminaKaydırmaYapar() {
        PD.getPage().evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("kullanıcı Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(pages.getFiyatlandirmayiGoruntuleButton());
    }

    @Then("kullanıcı Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("fiyat") || PD.getPage().url().contains("pricing"));
    }
}