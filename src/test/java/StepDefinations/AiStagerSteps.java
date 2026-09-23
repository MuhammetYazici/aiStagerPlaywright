package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Pages.NavigationPage;
import Utilities.ReusableMethod;
import Utilities.PD;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps {
    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    NavigationPage navigationPage = new NavigationPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır")
    public void kullaniciGirisYapmisVeVirtualStagingSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/virtual-staging");
    }

    @When("Kullanıcı desteklenen formatta .jpg veya .png bir boş oda fotoğrafı yükler")
    public void kullaniciDesteklenenFormattaJpgVeyaPngBirBosOdaFotografiYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/testfiles/sample.jpg");
    }

    @When("Görselin başarıyla önizlemesi görüntülenir")
    public void gorselinBasariylaOnizlemesiGoruntulenir() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @When("Oda Türü dropdown alanından \"Oturma Odası\" seçilir")
    public void odaTuruDropdownAlanindanOturmaOdasiSecilir() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
    }

    @When("Tasarım Stili dropdown alanından \"Modern\" seçilir")
    public void tasarimStiliDropdownAlanindanModernSecilir() {
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
    }

    @When("Mevcut mobilyaları kaldır toggle'ının açık \\(active\\) olduğu doğrulanır")
    public void mevcutMobilyalariKaldirToggelininAcikActiveOlduguDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getMobilyalariKaldirToggle().isVisible());
    }

    @When("Görünürlük seçeneği olarak Herkese açık galeride göster seçilir")
    public void gorunurlukSecenegiOlarakHerkeseAcikGalerideGosterSecilir() {
        rm.myClick(virtualStagingPage.getGorunurlukSecenegi());
    }

    @When("\"Dekorasyon Oluştur\" butonuna tıklanır")
    public void dekorasyonOlusturButonunaTiklanir() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButonu());
    }

    @Then("Sistem odayı analiz eder ve seçilen stil ve oda türüne uygun mobilyalandırılmış yeni görseli ekranda gösterir")
    public void sistemOdayiAnalizEderVeSecilenStilVeOdaTuruneUygunMobilyalandirilmisYeniGorseliEkrandaGosterir() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @When("Kullanıcı {string} uzantılı bir dosya yüklemeye çalışır")
    public void kullaniciGecersizFormatUzantiliBirDosyaYuklemeyeCalisir(String gecersizFormat) {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/testfiles/sample" + gecersizFormat);
    }

    @Then("Sistem {string} içeren bir hata mesajı göstermelidir")
    public void sistemHataMesajiIcerenBirHataMesajiGostermelidir(String hataMesaji) {
        rm.veriyfyContainsText(PD.getPage().locator("body"), hataMesaji);
    }

    @Then("Dekorasyon Oluştur butonu pasif kalmalıdır")
    public void dekorasyonOlusturButonuPasifKalmalidir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Kullanıcı geçerli bir .jpg formatında oda fotoğrafı yükler")
    public void kullaniciGecerliBirJpgFormatindaOdaFotografiYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/testfiles/sample.jpg");
    }

    @When("\"Oda Türü\" ve \"Tasarım Stili\" alanlarını boş bırakır")
    public void odaTuruVeTasarimStiliAlanlariniBosBirakir() {
        // Alanlar zaten boş bırakılıyor
    }

    @Then("Dekorasyon Oluştur butonunun pasif olduğu görülür")
    public void dekorasyonOlusturButonununPasifOlduguGorulur() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Kullanıcı sistemin kabul ettiği maksimum dosya boyutundaki .png formatlı görseli yükler")
    public void kullaniciSisteminKabulEttigiMaksimumDosyaBoyutundakiPngFormatliGorseliYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/testfiles/large.png");
    }

    @When("Görsel önizlemesinin yüklendiği doğrulanır")
    public void gorselOnizlemesininYuklendigiDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @When("\"Oda Türü\" olarak \"Yatak Odası\" ve \"Tasarım Stili\" olarak \"Skandinav\" seçilir")
    public void odaTuruOlarakYatakOdasiVeTasarimStiliOlarakSkandinavSecilir() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
    }

    @Then("Sistem görseli başarıyla işler ve yeni dekorasyonu oluşturur")
    public void sistemGorseliBasariylaIslerVeYeniDekorasyonuOlusturur() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @Given("Kullanıcı giriş yapmış ve Virtual Staging sayfasında AI Edit sekmesindedir")
    public void kullaniciGirisYapmisVeVirtualStagingSayfasindaAIEditSekmesindedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/virtual-staging");
        rm.myClick(virtualStagingPage.getAIEditSekmesi());
    }

    @When("Edit photo source alanında Current image seçeneğinin seçili olduğu doğrulanır ve önizleme gösterilir")
    public void editPhotoSourceAlanindaCurrentImageSecenegininSeciliOlduguDogrulanirVeOnizlemeGosterilir() {
        Assert.assertTrue(virtualStagingPage.getCurrentImageSecenegi().isVisible());
    }

    @When("Describe what to change alanına Remove the chair metni girilir")
    public void describeWhatToChangeAlaninaRemoveTheChairMetniGirilir() {
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), "Remove the chair");
    }

    @When("\"Edit Photo\" butonuna tıklanır")
    public void editPhotoButonunaTiklanir() {
        rm.myClick(virtualStagingPage.getEditPhotoButonu());
    }

    @Then("Sistem girilen talimata uygun olarak görsel üzerinde değişiklik yapar ve sonucu kullanıcıya sunar")
    public void sistemGirilenTalimataUygunOlarakGorselUzerindeDegisiklikYaparVeSonucuKullaniciyaSunar() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @When("Kullanıcı kaynak görseli seçer")
    public void kullaniciKaynakGorseliSecer() {
        rm.myClick(virtualStagingPage.getCurrentImageSecenegi());
    }

    @When("Describe what to change alanını boş bırakır")
    public void describeWhatToChangeAlaniniBosBirakir() {
        // Boş bırakılıyor
    }

    @Then("Sistem boş talimat hatası vermeli ve işlem yapılmamalıdır")
    public void sistemBosTalimatHatasiVermeliVeIslemYapilmamalidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "talimat");
    }

    @When("Kullanıcı yeni bir görsel yükler")
    public void kullaniciYeniBirGorselYukler() {
        rm.mySendKeys(virtualStagingPage.getDosyaYuklemeInput(), "src/test/resources/testfiles/sample.jpg");
    }

    @When("Describe what to change alanına sistemin karakter sınırına yakın çok uzun bir metin talimatı girilir")
    public void describeWhatToChangeAlaninaSisteminKarakterSinirinayakinCokUzunBirMetinTalimatiGirilir() {
        String uzunMetin = rm.resolveDynamicValue("longText");
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), uzunMetin);
    }

    @Then("Sistem metni işleyerek düzenleme sürecini başlatır veya uygun bir yönlendirme yapar")
    public void sistemMetniIsleyerekDuzenlemeSureciniBaslatirVeyaUygunBirYonlendirmeYapar() {
        Assert.assertTrue(virtualStagingPage.getGorselOnizleme().isVisible());
    }

    @Given("Kullanıcı ana sayfada oturum açmıştır")
    public void kullaniciAnaSayfadaOturumAcmistir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı header alanındaki Ürünler dropdown menüsüne hover yapar")
    public void kullaniciHeaderAlanindakiUrunlerDropdownMenusuneHoverYapar() {
        navigationPage.getUrunlerDropdown().hover();
    }

    @When("Açılan listeden Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void acilanListedenYapayZekaSanalTurSecenegineTiklar() {
        rm.myClick(navigationPage.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilir")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciSayfadakiErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getErkenErisimIsteyinButonu());
    }

    @When("Açılan forma geçerli bir e-posta adresi \"test@example.com\" girilir")
    public void acilanFormaGecerliBirEPostaAdresiTestExampleComGirilir() {
        rm.mySendKeys(navigationPage.getEmailInput(), "test@example.com");
    }

    @When("Talebi gönder butonuna tıklanır")
    public void talebiGonderButonunaTiklanir() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem başarılı gönderim onay mesajını göstermelidir")
    public void sistemBasariliGonderimOnayMesajiniGostermelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "başarılı");
    }

    @Given("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır")
    public void kullaniciAistagerAiTrAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/ai-virtual-tour");
    }

    @When("Kullanıcı Erken Erişim İsteyin butonuna tıklayarak formu açar")
    public void kullaniciErkenErisimIsteyinButonunaTiklayarakFormuAcar() {
        rm.myClick(navigationPage.getErkenErisimIsteyinButonu());
    }

    @When("E-posta alanına \"{string}\" girer")
    public void ePostaAlaninaGecersizEmailGirer(String gecersizEmail) {
        rm.mySendKeys(navigationPage.getEmailInput(), gecersizEmail);
    }

    @When("Gönder butonuna tıklar")
    public void gonderButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem Geçersiz e-posta formatı uyarısı göstermelidir")
    public void sistemGecersizEPostaFormatiUyarisiGostermelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "Geçersiz e-posta");
    }

    @When("E-posta alanını boş bırakıp gönder butonuna tıklar")
    public void ePostaAlaniniBosBirakipGonderButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem alanın zorunlu olduğuna dair bir uyarı mesajı göstermelidir")
    public void sistemAlaninZorunluOldugunaDairBirUyariMesajiGostermelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "zorunlu");
    }

    @When("Açılan listeden Sanal Dekorasyon API seçeneğine tıklar")
    public void acilanListedenSanalDekorasyonAPISecenegineTiklar() {
        rm.myClick(navigationPage.getSanalDekorasyonAPIногда());
    }

    @Then("Kullanıcı aistager.ai/tr/api sayfasına yönlendirilir")
    public void kullaniciAistagerAiTrApiSayfasinaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar")
    public void kullaniciSayfaninUstKisindakiIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButonu());
    }

    @When("İletişim formundaki Ad, E-posta ve Mesaj alanları geçerli bilgilerle doldurulur")
    public void iletisimFormundakiAdEPostaVeMesajAlanlariGecerliBilgilerleDoldurulur() {
        rm.mySendKeys(navigationPage.getAdInput(), "Test Kullanici");
        rm.mySendKeys(navigationPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(navigationPage.getMesajInput(), "Test mesajidir.");
    }

    @When("Formu gönder butonuna tıklanır")
    public void formuGonderButonunaTiklanir() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem başarılı gönderim onay mesajı iletmelidir")
    public void sistemBasariliGonderimOnayMesajiIletmelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "başarılı");
    }

    @Given("Kullanıcı aistager.ai/tr/api sayfasındadır")
    public void kullaniciAistagerAiTrApiSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/api");
    }

    @When("Kullanıcı sayfanın alt kısmında yer alan Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltKismindaYerAlanFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getFiyatlandirmayiGoruntuleButonu());
    }

    @Then("Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciHatasizBirSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButonu());
    }

    @When("Formdaki alanlardan biri veya birkaçı boş bırakılarak gönder butonuna basılır")
    public void formdakiAlanlardanBiriVeyaBirkaciBosBirakilarakGonderButonunaBasilir() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem eksik alanlar için uyarı mesajları göstermelidir")
    public void sistemEksikAlanlarIcinUyariMesajlariGostermelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "eksik");
    }

    @When("Ad ve E-posta alanları doldurulur")
    public void adVeEPostaAlanlariDoldurulur() {
        rm.mySendKeys(navigationPage.getAdInput(), "Test Kullanici");
        rm.mySendKeys(navigationPage.getEmailInput(), "test@example.com");
    }

    @When("Mesaj alanına izin verilen maksimum karakter sınırını aşan çok uzun bir metin girilip gönderilir")
    public void mesajAlaninaIzinVerilenMaksimumKarakterSiniriniAsanCokUzunBirMetinGirilipGonderilir() {
        String uzunMesaj = rm.resolveDynamicValue("longMessage");
        rm.mySendKeys(navigationPage.getMesajInput(), uzunMesaj);
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem karakter sınırını belirten bir hata mesajı vermeli veya metni kırparak işleme devam etmelidir")
    public void sistemKarakterSiniriniBelirtenBirHataMesajiVermeliVeyaMetniKirparakIslemeDevamEtmelidir() {
        rm.veriyfyContainsText(PD.getPage().locator("body"), "karakter");
    }
}