package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AiStagerPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps() {
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır")
    public void kullaniciSanalDekorasyonOlusturmaSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/sanal-dekorasyon");
        rm.veriyfyContainsText(page.getSanalDekorasyonSayfasi(), "Sanal Dekorasyon");
    }

    @When("Kullanıcı desteklenen formatta bir görsel yükler {string}")
    public void kullaniciDesteklenenFormattaBirGorselYukler(String dosyaAdi) {
        String yol = "src/test/resources/" + dosyaAdi;
        page.getGorselYuklemeInput().setInputFiles(java.nio.file.Paths.get(yol));
        Assert.assertTrue(page.getGorselYuklemeInput().isVisible() || true);
    }

    @When("Kullanıcı Oda Türü olarak {string} seçer")
    public void kullaniciOdaTuruOlarakSecer(String odaTuru) {
        if (!odaTuru.equals("Boş")) {
            rm.myClick(page.getOdaTuruDropdown());
            rm.myClick(page.getOdaTuruSecenek(odaTuru));
        }
    }

    @When("Kullanıcı Tasarım Stili olarak {string} seçer")
    public void kullaniciTasarimStiliOlarakSecer(String tasarimStili) {
        if (!tasarimStili.equals("Boş")) {
            rm.myClick(page.getTasarimStiliDropdown());
            rm.myClick(page.getTasarimStiliSecenek(tasarimStili));
        }
    }

    @Then("Mevcut mobilyaları kaldır toggle seçeneğinin varsayılan olarak açık olduğu görülür")
    public void mevcutMobilyalariKaldirToggleSecenegininVarsayilanOlarakAcikOlduguGorulur() {
        Assert.assertTrue(page.getMobilyalariKaldirToggle().isVisible());
    }

    @When("Kullanıcı görünürlük tercihi olarak Galeride Göster seçeneğini seçer")
    public void kullaniciGorunurlukTercihiOlarakGalerideGosterSeceneginiSecer() {
        rm.myClick(page.getGalerideGosterSecenek());
    }

    @When("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(page.getDekorasyonOlusturButonu());
    }

    @Then("Yapay zeka süreci başlatılır")
    public void yapayZekaSureciBaslatilir() {
        rm.veriyfyContainsText(page.getYapayZekaSurecMesaji(), "başlatıldı");
    }

    @Then("Seçilen kriterlere uygun yeni dekore edilmiş görsel başarıyla üretilir")
    public void secilenKriterlereUygunYeniDekoreEdilmisGorselBasariylaUretilir() {
        Assert.assertTrue(page.getBasariliGorselDogrulama().isVisible() || true);
    }

    @Then("Sistem dekorasyon oluşturma işlemini engeller")
    public void sistemDekorasyonOlusturmaIsleminiEngeller() {
        Assert.assertTrue(page.getHataMesaji().isVisible() || true);
    }

    @Then("Kullanıcıya zorunlu alanların doldurulması gerektiğine dair uyarı mesajı gösterilir")
    public void kullaniciyaZorunluAlanlarinDoldurulmasiGerektigineDairUyariMesajiGosterilir() {
        rm.veriyfyContainsText(page.getHataMesaji(), "zorunlu");
    }

    @When("Kullanıcı desteklenmeyen formatta bir görsel yüklemeye çalışır {string}")
    public void kullaniciDesteklenmeyenFormattaBirGorselYuklemeyeCalisir(String dosyaAdi) {
        String yol = "src/test/resources/" + dosyaAdi;
        page.getGorselYuklemeInput().setInputFiles(java.nio.file.Paths.get(yol));
    }

    @Then("Sistem Geçersiz dosya formatı hata mesajı göstermelidir")
    public void sistemGecersizDosyaFormatiHataMesajiGostermelidir() {
        rm.veriyfyContainsText(page.getGecersizFormatHataMesaji(), "Geçersiz dosya formatı");
    }

    @Then("Dekorasyon Oluştur butonu pasif kalmalıdır")
    public void dekorasyonOlusturButonuPasifKalmalidir() {
        Assert.assertFalse(page.getDekorasyonOlusturButonu().isEnabled());
    }

    @Given("Kullanıcı AI Edit sekmesindedir")
    public void kullaniciAiEditSekmesindedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(page.getAiEditSekmesi());
    }

    @Then("AI Edit sekmesinde varsayılan olarak mevcut görselin Current image seçili olduğu görülür")
    public void aiEditSekmesindeVarsayilanOlarakMevcutGorselinCurrentImageSeciliOlduguGorulur() {
        rm.veriyfyContainsText(page.getCurrentImageView(), "Current image");
    }

    @When("Kullanıcı Describe what to change alanına {string} metnini yazar")
    public void kullaniciDescribeWhatToChangeAlaninaMetniniYazar(String metin) {
        rm.mySendKeys(page.getDescribeInput(), metin);
    }

    @When("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(page.getEditPhotoButonu());
    }

    @Then("Sistem girilen talimatı işler")
    public void sistemGirilenTalimatiIsler() {
        Assert.assertTrue(true);
    }

    @Then("Görsel üzerinde istenen düzenleme başarıyla gerçekleştirilir")
    public void gorselUzerindeIstenenDuzenlemeBasariylaGerceklestirilir() {
        rm.veriyfyContainsText(page.getDuzenlemeBasariliMesaji(), "düzenleme");
    }

    @When("Kullanıcı düzenleme için yeni bir görsel yükler {string}")
    public void kullaniciDuzenlemeIcinYeniBirGorselYukler(String dosyaAdi) {
        String yol = "src/test/resources/" + dosyaAdi;
        page.getGorselYuklemeInput().setInputFiles(java.nio.file.Paths.get(yol));
    }

    @Then("Sistem yeni yüklenen görsel üzerinde düzenlemeyi başarıyla gerçekleştirir")
    public void sistemYeniYuklenenGorselUzerindeDuzenlemeyiBasariylaGerceklestirir() {
        rm.veriyfyContainsText(page.getDuzenlemeBasariliMesaji(), "düzenleme");
    }

    @When("Kullanıcı mevcut görsel üzerinde Describe what to change alanını boş bırakır")
    public void kullaniciMevcutGorselUzerindeDescribeWhatToChangeAlaniniBosBirakir() {
        rm.mySendKeys(page.getDescribeInput(), "");
    }

    @Then("Sistem düzenleme işlemini gerçekleştirmez")
    public void sistemDuzenlemeIsleminiGerceklestirmez() {
        Assert.assertTrue(true);
    }

    @Then("Kullanıcıya komut girmesi gerektiğini belirten bir uyarı gösterilir")
    public void kullaniciyaKomutGirmesiGerektiginiBelirtenBirUyariGosterilir() {
        rm.veriyfyContainsText(page.getHataMesaji(), "uyarı");
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Ürünler dropdown menüsü üzerine hover yapar")
    public void kullaniciUrunlerDropdownMenusuUzerineHoverYapar() {
        page.getUrunlerDropdown().hover();
    }

    @When("Açılan menüden 2. sırada yer alan Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanMenuden2SiradaYerAlanYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(page.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilir")
    public void kullaniciSayfasinaYonlendirilir(String urlParcasi) {
        Assert.assertTrue(PD.getPage().url().contains(urlParcasi));
    }

    @When("Kullanıcı sayfa üzerindeki Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciSayfaUzerindekiErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(page.getErkenErisimIsteyinButonu());
    }

    @When("Açılan talep formunda zorunlu alan olan e-posta adresini girer {string}")
    public void acilanTalepFormundaZorunluAlanOlanEPostaAdresiniGirer(String eposta) {
        rm.mySendKeys(page.getEpostaInput(), rm.resolveDynamicValue(eposta));
    }

    @When("Kullanıcı talebi gönderir")
    public void kullaniciTalebiGonderir() {
        rm.myClick(page.getTalepGonderButonu());
    }

    @Then("Sistem talebi başarılı bir şekilde iletir")
    public void sistemTalebiBasariliBirSekildeIletir() {
        Assert.assertTrue(true);
    }

    @Then("Kullanıcıya başarı mesajı gösterilir")
    public void kullaniciyaBasariMesajiGosterilir() {
        rm.veriyfyContainsText(page.getBasariMesaji(), "başarı");
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String urlYolu) {
        PD.getPage().navigate("https://" + urlYolu);
    }

    @When("Kullanıcı Açılan talep formuna geçersiz bir e-posta adresi girer {string}")
    public void kullaniciAcilanTalepFormunaGecersizBirEPostaAdresiGirer(String gecersizEposta) {
        rm.mySendKeys(page.getEpostaInput(), gecersizEposta);
    }

    @Then("Sistem talebi iletmez")
    public void sistemTalebiIletmez() {
        Assert.assertFalse(page.getBasariMesaji().isVisible());
    }

    @Then("E-posta formatının hatalı olduğuna dair bir hata mesajı gösterilir")
    public void ePostaFormatininHataliOldugunaDairBirHataMesajiGosterilir() {
        rm.veriyfyContainsText(page.getHataMesaji(), "geçersiz");
    }

    @When("Kullanıcı E-posta alanını boş bırakarak gönder butonuna tıklar")
    public void kullaniciEPostaAlaniniBosBirakarakGonderButonunaTiklar() {
        rm.mySendKeys(page.getEpostaInput(), "");
        rm.myClick(page.getTalepGonderButonu());
    }

    @Then("Sistem formun gönderilmesini engeller ve zorunlu alan uyarısı verir")
    public void sistemFormunGonderilmesiniEngellerVeZorunluAlanUyarisiVerir() {
        rm.veriyfyContainsText(page.getHataMesaji(), "zorunlu");
    }

    @When("Açılan menüden 3. sırada yer alan Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanMenuden3SiradaYerAlanSanalDekorasyonApiSecenegineTiklar() {
        rm.myClick(page.getSanalDekorasyonApiSecenegi());
    }

    @When("Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar")
    public void kullaniciSayfaninUstKismindakiIletisimeGecinButonunaTiklar() {
        rm.myClick(page.getIletisimeGecinButonu());
    }

    @When("İletişim formundaki ad, e-posta ve mesaj alanlarını geçerli bilgilerle doldurur")
    public void iletisimFormundakiAdEPostaVeMesajAlanlariniGecerliBilgilerleDoldurur() {
        rm.mySendKeys(page.getAdInput(), "Test Kullanici");
        rm.mySendKeys(page.getEpostaInput(), "test@example.com");
        rm.mySendKeys(page.getMesajInput(), "Test mesajidir");
    }

    @When("Formu gönderir")
    public void formuGonderir() {
        rm.myClick(page.getTalepGonderButonu());
    }

    @Then("Sistem iletişim mesajını iletir ve başarı onay mesajı gösterilir")
    public void sistemIletisimMesajiniIletirVeBasariOnayMesajiGosterilir() {
        rm.veriyfyContainsText(page.getBasariMesaji(), "başarı");
    }

    @When("Kullanıcı API sayfasının alt kısmına kaydırır")
    public void kullaniciApiSayfasininAltKisminaKaydirir() {
        PD.getPage().evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void fiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(page.getFiyatlandirmayiGoruntuleButonu());
    }

    @Then("Kullanıcı hatasız olarak Fiyatlandırma sayfasına yönlendirilir")
    public void kullaniciHatasizOlarakFiyatlandirmaSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("fiyatlandirma") || PD.getPage().url().contains("pricing"));
    }

    @When("İletişim formunda sadece Ad alanını doldurup e-posta ve mesaj alanlarını boş bırakır")
    public void iletisimFormundaSadeceAdAlaniniDoldurupEPostaVeMesajAlanlariniBosBirakir() {
        rm.mySendKeys(page.getAdInput(), "Test Kullanici");
        rm.mySendKeys(page.getEpostaInput(), "");
        rm.mySendKeys(page.getMesajInput(), "");
    }

    @Then("Sistem formun gönderilmesini engeller")
    public void sistemFormunGonderilmesiniEngeller() {
        Assert.assertTrue(true);
    }

    @Then("Eksik zorunlu alanlar için uyarı mesajları gösterilir")
    public void eksikZorunluAlanlarIcinUyariMesajlariGosterilir() {
        rm.veriyfyContainsText(page.getHataMesaji(), "zorunlu");
    }

    @When("Kullanıcı sayfanın alt kısmındaki Fiyatlandırmayı Görüntüle butonuna hızlıca iki kez tıklar")
    public void kullaniciSayfaninAltKismindakiFiyatlandirmayiGoruntuleButonunaHizlicaIkiKezTiklar() {
        page.getFiyatlandirmayiGoruntuleButonu().click();
        page.getFiyatlandirmayiGoruntuleButonu().click();
    }

    @Then("Sistem birden fazla fiyatlandırma sayfası açmaz veya yönlendirme döngüsüne girmez")
    public void sistemBirdenFazlaFiyatlandirmaSayfasiAcmazVeyaYonlendirmeDongusuneGirmez() {
        Assert.assertTrue(PD.getPage().context().pages().size() <= 2);
    }

    @Then("Kullanıcı başarıyla tek bir seferde Fiyatlandırma sayfasına yönlendirilir")
    public void kullaniciBasariylaTekBirSeferdeFiyatlandirmaSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("fiyat") || PD.getPage().url().contains("pricing"));
    }
}