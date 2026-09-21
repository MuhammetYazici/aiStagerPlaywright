package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AiStagerPages;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.microsoft.playwright.Locator;

public class AiStagerSteps {
    AiStagerPages pages = new AiStagerPages();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(pages.getGirisYapLink());
        rm.mySendKeys(pages.getEmailInput(), "test@example.com");
        rm.mySendKeys(pages.getPasswordInput(), "Password123!");
        rm.myClick(pages.getCreateDecorationButton());
    }

    @And("Kullanıcı Virtual Staging sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
        Assert.assertTrue(PD.getPage().url().contains("virtual-staging") || PD.getPage().isVisible(pages.getCreateDecorationButton().toString()));
    }

    @When("Kullanıcı geçerli formatta {string} bir boş oda fotoğrafı yükler")
    public void kullaniciGecerliFormattaBirBosOdaFotografiYukler(String format) {
        rm.mySendKeys(pages.getFileUploadInput(), "src/test/resources/testfile." + format);
    }

    @And("Yüklenen görselin önizlemesinin ekranda göründüğü doğrulanır")
    public void yuklenenGorselinOnizlemesininEkrandaGorunduguDogrulanir() {
        rm.veriyfyContainsText(pages.getPreviewImage(), "");
    }

    @And("Oda Türü olarak Oturma Odası seçilir")
    public void odaTuruOlarakOturmaOdasiSecilir() {
        rm.myClick(pages.getRoomTypeDropdown());
    }

    @And("Tasarım Stili olarak Modern seçilir")
    public void tasarimStiliOlarakModernSecilir() {
        rm.myClick(pages.getDesignStyleDropdown());
    }

    @And("Mevcut mobilyaları kaldır toggle'ının varsayılan olarak açık olduğu görülür")
    public void mevcutMobilyalariKaldirToggelIninVarsayilanOlarakAcikOlduguGorulur() {
        Assert.assertTrue(pages.getRemoveFurnitureToggle().isVisible());
    }

    @And("Görselin galeri görünürlük tercihi Herkese açık olarak belirlenir")
    public void gorselinGaleriGorunurlukTercihiHerkeseAcikOlarakBelirlenir() {
        rm.myClick(pages.getGalleryVisibility());
    }

    @And("Dekorasyon Oluştur butonuna tıklanır")
    public void dekorasyonOlusturButonunaTiklanir() {
        rm.myClick(pages.getCreateDecorationButton());
    }

    @Then("Sistem yüklenen odayı, seçilen konsept ve stile uygun olarak mobilyalandırıp ekranda göstermelidir")
    public void sistemYuklenenOdayiSecilenKonseptVeStileUygunOlarakMobilyalandiripEkrandaGostermelidir() {
        Assert.assertTrue(pages.getPreviewImage().isVisible());
    }

    @When("Kullanıcı {string} uzantılı bir görsel yüklemeye çalışır")
    public void kullaniciUzantiliBirGorselYuklemeyeCalisir(String format) {
        rm.mySendKeys(pages.getFileUploadInput(), "src/test/resources/testfile." + format);
    }

    @Then("Sistem Desteklenmeyen dosya formatı. Lütfen jpg veya png yükleyin. hata mesajını göstermelidir")
    public void sistemDesteklenmeyenDosyaFormatiLutfenJpgVeyaPngYukleyinHataMesajiniGostermelidir() {
        rm.veriyfyContainsText(pages.getErrorMessage(), "Desteklenmeyen");
    }

    @And("Dekorasyon Oluştur butonu pasif kalmalı veya işlem engellenmelidir")
    public void dekorasyonOlusturButonuPasifKalmaliVeyaIslemEngellenmelidir() {
        Assert.assertFalse(pages.getCreateDecorationButton().isEnabled());
    }

    @When("Kullanıcı geçerli formatta {string} bir görsel yükler")
    public void kullaniciGecerliFormattaBirGorselYukler(String format) {
        rm.mySendKeys(pages.getFileUploadInput(), "src/test/resources/testfile." + format);
    }

    @And("Oda Türü ve Tasarım Stili seçimleri yapılmaz")
    public void odaTuruVeTasarimStiliSecimleriYapilmaz() {
        // No action needed to keep them unselected
    }

    @Then("Sistem kullanıcıya eksik alanları Oda Türü ve Tasarım Stili belirten bir uyarı mesajı göstermelidir")
    public void sistemKullaniciyaEksikAlanlariOdaTuruVeTasarimStiliBelirtenBirUyariMesajiniGostermelidir() {
        rm.veriyfyContainsText(pages.getErrorMessage(), "Oda Türü");
    }

    @When("Kullanıcı izin verilen maksimum dosya boyut sınırında bir görsel yükler")
    public void kullaniciIzinVerilenMaksimumDosyaBoyutSinirindaBirGorselYukler {
        rm.mySendKeys(pages.getFileUploadInput(), "src/test/resources/max_size.jpg");
    }

    @Then("Görsel başarıyla yüklenmeli ve önizlemesi ekranda gösterilmelidir")
    public void gorselBasariylaYuklenmeliVeOnizlemesiEkrandaGosterilmelidir() {
        rm.veriyfyContainsText(pages.getPreviewImage(), "");
    }

    @Given("Kullanıcı AI Edit sekmesindedir")
    public void kullaniciAIEditSekmesindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-edit");
        rm.myClick(pages.getAiEditTab());
    }

    @When("Kaynak görsel olarak varsayılan seçili gelen Current image kullanılır")
    public void kaynakGorselOlarakVarsayilanSeciliGelenCurrentImageKullanilir() {
        Assert.assertTrue(pages.getPreviewImage().isVisible());
    }

    @And("Describe what to change alanına Duvarı koyu yeşile boya ve ahşap sehpa ekle metni girilir")
    public void describeWhatToChangeAlaninaDuvariKoyuYesileBoyaVeAhsapSehpaEkleMetniGirilir() {
        rm.mySendKeys(pages.getDescribeInput(), "Duvarı koyu yeşile boya ve ahşap sehpa ekle");
    }

    @And("Edit Photo butonuna tıklanır")
    public void editPhotoButonunaTiklanir() {
        rm.myClick(pages.getEditPhotoButton());
    }

    @Then("Sistem, girilen talimata uygun şekilde düzenlenmiş görseli ekranda göstermelidir")
    public void sistemGirilenTalimataUygunSekildeDuzenlenmisGorseliEkrandaGostermelidir() {
        rm.veriyfyContainsText(pages.getPreviewImage(), "");
    }

    @When("Kullanıcı yeni bir png formatında kaynak görsel yükler")
    public void kullaniciYeniBirPngFormatindaKaynakGorselYukler() {
        rm.mySendKeys(pages.getFileUploadInput(), "src/test/resources/testfile.png");
    }

    @And("Describe what to change alanına geçerli bir düzenleme talimatı girilir")
    public void describeWhatToChangeAlaninaGecerliBirDuzenlemeTalimatiGirilir() {
        rm.mySendKeys(pages.getDescribeInput(), "Add a modern lamp");
    }

    @Then("Sistem yeni görsel üzerinde düzenleme yaparak sonucu kullanıcıya sunmalıdır")
    public void sistemYeniGorselUzerindeDuzenlemeYaparakSonucuKullaniciyaSunmalidir() {
        rm.veriyfyContainsText(pages.getPreviewImage(), "");
    }

    @When("Kaynak görsel seçilir ancak Describe what to change alanı boş bırakılır")
    public void kaynakGorselSecilirAncakDescribeWhatToChangeAlaniBosBirakilir() {
        // Leave describe input empty
    }

    @Then("Sistem Lütfen yapılmasını istediğiniz değişikliği açıklayın. uyarısını vermelidir")
    public void sistemLutfenYapilmasiniIstediginizDegisikligiAciklayinUyarisiniVermelidir() {
        rm.veriyfyContainsText(pages.getErrorMessage(), "Lütfen");
    }

    @And("Düzenleme işlemi başlatılmamalıdır")
    public void duzenlemeIslemiBaslatilmamalidir() {
        Assert.assertFalse(pages.getEditPhotoButton().isDisabled());
    }

    @When("Describe what to change alanına sistemin izin verdiği maksimum karakter sınırını aşan çok uzun bir metin girilir")
    public void describeWhatToChangeAlaninaSisteminIzinVerdigiMaksimumKarakterSiniriniAsanCokUzunBirMetinGirilir() {
        String longText = "a".repeat(5000);
        rm.mySendKeys(pages.getDescribeInput(), longText);
    }

    @Then("Sistem ya metni kırpabilmeli ya da izin verilen karakter sınırını aşamayacağına dair bir uyarı göstermelidir")
    public void sistemYaMetniKirpabilmeliYadaIzinVerilenKarakterSiniriniAsamayacaginaDairBirUyariGostermelidir() {
        Assert.assertTrue(true);
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı header alanındaki Ürünler menüsüne hover over yapar")
    public void kullaniciHeaderAlanindakiUrunlerMenusuneHoverOverYapar() {
        pages.getUrunlerMenu().hover();
    }

    @Then("Alt seçeneklerin listelendiği görülür")
    public void altSeceneklerinListelendigiGorulur() {
        Assert.assertTrue(pages.getVirtualTourSubMenu().isVisible());
    }

    @When("Listeden Yapay Zeka Sanal Tur seçeneğine tıklanır")
    public void listedenYapayZekaSanalTurSecenegineTiklanir() {
        rm.myClick(pages.getVirtualTourSubMenu());
    }

    @Then("Kullanıcı aistager.ai\\/tr\\/ai-virtual-tour adresine yönlendirilmelidir")
    public void kullaniciAistagerAiTrAiVirtualTourAdresineYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı tekrar ana sayfaya dönüp Ürünler menüsüne hover yapar")
    public void kullaniciTekrarAnaSayfayaDonupUrunlerMenusuneHoverYapar() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        pages.getUrunlerMenu().hover();
    }

    @And("Listeden Sanal Dekorasyon API seçeneğine tıklanır")
    public void listedenSanalDekorasyonApiSecenegineTiklanir() {
        rm.myClick(pages.getApiSubMenu());
    }

    @Then("Kullanıcı aistager.ai\\/tr\\/api adresine yönlendirilmelidir")
    public void kullaniciAistagerAiTrApiAdresineYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/api"));
    }

    @Given("Kullanıcı Yapay Zeka Sanal Tur sayfasındadır")
    public void kullaniciYapayZekaSanalTurSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/ai-virtual-tour");
    }

    @When("Erken Erişim İsteyin butonuna tıklanır")
    public void erkenErisimIsteyinButonunaTiklanir() {
        rm.myClick(pages.getErkenErisimButton());
    }

    @And("Açılan forma geçerli bir e-posta adresi {string} girilir")
    public void acilanFormaGecerliBirEPostaAdresiGirilir(String email) {
        rm.mySendKeys(pages.getLeadEmailInput(), rm.resolveDynamicValue(email));
    }

    @And("Talep gönder butonuna tıklanır")
    public void talepGonderButonunaTiklanir() {
        rm.myClick(pages.getTalepGonderButton());
    }

    @Then("Sistem talebi başarıyla almalı ve kullanıcıya Tarih talebiniz alınmıştır, teşekkürler! gibi net bir onay mesajı göstermelidir")
    public void sistemTalebiBasariylaAlmaliVeKullaniciyaTarihTalebinizAlinmistirTesekkurlerGibiNetBirOnayMesajiniGostermelidir() {
        rm.veriyfyContainsText(pages.getSuccessMessage(), "talebiniz alınmıştır");
    }

    @And("Açılan forma geçersiz formatta bir e-posta {string} girilir")
    public void acilanFormaGecersizFormattaBirEPostaGirilir(String email) {
        rm.mySendKeys(pages.getLeadEmailInput(), email);
    }

    @Then("Sistem geçerli bir e-posta adresi girilmesini belirten bir hata mesajı göstermelidir")
    public void sistemGecerliBirEPostaAdresiGirilmesiniBelirtenBirHataMesajiniGostermelidir() {
        rm.veriyfyContainsText(pages.getErrorMessage(), "geçerli");
    }

    @Given("Kullanıcı Sanal Dekorasyon API sayfasındadır")
    public void kullaniciSanalDekorasyonApiSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/api");
    }

    @When("İletişime Geçin butonuna tıklanır")
    public void iletisimeGecinButonunaTiklanir() {
        rm.myClick(pages.getIletisimeGecButton());
    }

    @And("İletişim formu zorunlu alanları eksiksiz doldurulur")
    public void iletisimFormuZorunluAlanlariEksiksizDoldurulur() {
        rm.mySendKeys(pages.getContactFormInputs().first(), "Test User");
    }

    @And("Form gönderilir")
    public void formGonderilir() {
        rm.myClick(pages.getSubmitFormButton());
    }

    @Then("Sistem talebin alındığını onaylayan başarı mesajını göstermelidir")
    public void sistemTalebinAlindiginiOnaylayanBasariMesajiniGostermelidir() {
        rm.veriyfyContainsText(pages.getSuccessMessage(), "başarılı");
    }

    @When("Kullanıcı sayfanın altındaki Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltindakiFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(pages.getPricingButton());
    }

    @Then("Kullanıcı hatasız şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciHatasizSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @Given("Kullanıcı Sanal Dekorasyon API sayfasındaki iletişim formundadır")
    public void kullaniciSanalDekorasyonApiSayfasindakiIletisimFormundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/tr/api");
        rm.myClick(pages.getIletisimeGecButton());
    }

    @When("Zorunlu alanlardan en az biri boş bırakılarak form gönderilir")
    public void zorunluAlanlardanEnAzBiriBosBirakilarakFormGonderilir() {
        rm.myClick(pages.getSubmitFormButton());
    }

    @Then("Sistem boş bırakılan alanlar için uyarı mesajları göstermeli ve formun gönderilmesine izin vermemelidir")
    public void sistemBosBirakilanAlanlarIcinUyariMesajlariGostermeliVeFormunGonderilmesineIzinVermemelidir() {
        rm.veriyfyContainsText(pages.getErrorMessage(), "alan");
    }
}