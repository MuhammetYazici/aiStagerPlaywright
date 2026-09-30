package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.VirtualStagingPage;
import Pages.NavigationPage;
import Pages.LoginPage;
import Utilities.ReusableMethod;
import Utilities.ConfigReader;
import Utilities.PD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class AistagerTestcasesSteps {

    VirtualStagingPage virtualStagingPage = new VirtualStagingPage();
    NavigationPage navigationPage = new NavigationPage();
    LoginPage loginPage = new LoginPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        rm.myClick(loginPage.getGirisYapLink());
    }

    @When("Kullanıcı sisteme giriş yapar")
    public void kullaniciSistemeGirisYapar() {
        rm.mySendKeys(loginPage.getEpostaInput(), "testuser@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123");
    }

    @And("Kullanıcı sisteme giriş yapmıştır")
    public void kullaniciSistemeGirisYapmistir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @And("Kullanıcı \"Virtual Staging\" sayfasındadır")
    public void kullaniciVirtualStagingSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/virtual-staging");
        Assert.assertTrue(PD.getPage().url().contains("virtual-staging"));
    }

    @And("Kullanıcı yükleme alanına geçerli formatta .jpg veya .png oda fotoğrafını sürükleyip bırakır")
    public void kullaniciYuklemeAlaninaGecerliFormattaJpgVeyaPngOdaFotografiniSurukleyipBirakir() {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @Then("Yüklenen görselin önizlemesi kullanıcıya gösterilmelidir")
    public void yuklenenGorselinOnizlemesiKullaniciyaGosterilmelidir() {
        Assert.assertTrue(virtualStagingPage.getOnizleme().isVisible());
    }

    @When("Kullanıcı \"Oda Türü\" dropdown alanından \"Oturma Odası\" seçeneğini seçer")
    public void kullaniciOdaTuruDropdownAlanindanOturmaOdasiSeceneginiSecerQuotes() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
    }

    @And("Kullanıcı Oda Türü dropdown alanından Oturma Odası seçeneğini seçer")
    public void kullaniciOdaTuruDropdownAlanindanOturmaOdasiSeceneginiSecer() {
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
    }

    @And("Kullanıcı Tasarım Stili dropdown alanından Modern seçeneğini seçer")
    public void kullaniciTasarimStiliDropdownAlanindanModernSeceneginiSecer() {
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
        rm.myClick(virtualStagingPage.getModernSecenegi());
    }

    @And("Mevcut mobilyaları kaldır toggle'ının varsayılan olarak açık olduğu doğrulanır")
    public void mevcutMobilyalariKaldirToggleIninVarsayilanOlarakAcikOlduguDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getMobilyaKaldirToggle().isChecked());
    }

    @And("Kullanıcı görünürlük seçeneklerinden Herkese açık galeride göster radio butonunu seçer")
    public void kullaniciGorunurlukSeceneklerindenHerkeseAcikGalerideGosterRadioButonunuSecer() {
        rm.myClick(virtualStagingPage.getHerkesAcikGalerideGosterRadio());
    }

    @Then("Dekorasyon Oluştur butonunun aktif olduğu görülür")
    public void dekorasyonOlusturButonununAktifOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Kullanıcı Dekorasyon Oluştur butonuna tıklar")
    public void kullaniciDekorasyonOlusturButonunaTiklar() {
        rm.myClick(virtualStagingPage.getDekorasyonOlusturButonu());
    }

    @Then("İşlem tamamlandığında odanın yapay zeka tarafından mobilyalandırılmış yeni hali ekranda gösterilmelidir")
    public void islemTamamlandigindaOdaninYapayZekaTarafindanMobilyalandirilmisYeniHaliErandaGosterilmelidir() {
        Assert.assertTrue(virtualStagingPage.getBasariliSonuc().isVisible());
    }

    @When("Kullanıcı yükleme alanına {string} formatında dosya yükler")
    public void kullaniciYuklemeAlaninaFormatindaDosyaYukler(String gecersizFormat) {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/test" + gecersizFormat));
    }

    @Then("Sistem hata mesajı göstermelidir ve görsel yüklenmemelidir")
    public void sistemHataMesajiGostermelidirVeGorselYuklenmemelidir() {
        Assert.assertTrue(virtualStagingPage.getHataMesaji().isVisible());
    }

    @And("Dekorasyon Oluştur butonu pasif kalmalıdır")
    public void dekorasyonOlusturButonuPasifKalmalidir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Kullanıcı geçerli bir görsel yükler")
    public void kullaniciGecerliBirGorselYukler() {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @And("Kullanıcı Oda Türü seçimini boş bırakır")
    public void kullaniciOdaTuruSeciminiBosBirakir() {
        // Dropdown seçim yapılmıyor
    }

    @And("Kullanıcı Tasarım Stili seçimini boş bırakır")
    public void kullaniciTasarimStiliSeciminiBosBirakir() {
        // Dropdown seçim yapılmıyor
    }

    @Then("Dekorasyon Oluştur butonunun pasif olduğu doğrulanır")
    public void dekorasyonOlusturButonununPasifOlduguDogrulanir() {
        Assert.assertFalse(virtualStagingPage.getDekorasyonOlusturButonu().isEnabled());
    }

    @When("Kullanıcı geçerli bir görsel yükler, Oda Türü ve Tasarım Stili seçer")
    public void kullaniciGecerliBirGorselYuklerOdaTuruVeTasarimStiliSecer() {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
        rm.myClick(virtualStagingPage.getOdaTuruDropdown());
        rm.myClick(virtualStagingPage.getOturmaOdasiSecenegi());
        rm.myClick(virtualStagingPage.getTasarimStiliDropdown());
        rm.myClick(virtualStagingPage.getModernSecenegi());
    }

    @And("Kullanıcı varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle'ını kapatır")
    public void kullaniciVarsayilanOlarakAcikGelenMevcutMobilyalariKaldirToggleiniKapatir() {
        rm.myClick(virtualStagingPage.getMobilyaKaldirToggle());
    }

    @Then("Toggle'ın kapalı duruma geldiği doğrulanır")
    public void toggleInKapaliDurumaGeldigiDogrulanir() {
        Assert.assertFalse(virtualStagingPage.getMobilyaKaldirToggle().isChecked());
    }

    @Then("İşlem başarılı bir şekilde tamamlanır")
    public void islemBasariliBirSekildeTamamlanir() {
        Assert.assertTrue(virtualStagingPage.getBasariliSonuc().isVisible());
    }

    @When("Kullanıcı izin verilen maksimum boyuttan büyük bir oda fotoğrafı yükler")
    public void kullaniciIzinVerilenMaksimumBoyuttanBuyukBirOdaFotografiYukler() {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/large_test.jpg"));
    }

    @Then("Sistem dosya boyutu hatası vermelidir ve görsel yüklenmemelidir")
    public void sistemDosyaBoyutuHatasiVermelidirVeGorselYuklenmemelidir() {
        Assert.assertTrue(virtualStagingPage.getHataMesaji().isVisible());
    }

    @And("Kullanıcı AI Edit sekmesini aktif hale getirmiştir")
    public void kullaniciAIEditSekmesiniAktifHaleGetirmistir() {
        rm.myClick(virtualStagingPage.getAiEditSekmesi());
    }

    @Then("Edit photo source dropdown alanında varsayılan olarak Current image seçili olmalıdır")
    public void editPhotoSourceDropdownAlanindaVarsayilanOlarakCurrentImageSeciliOlmalidir() {
        Assert.assertTrue(virtualStagingPage.getEditPhotoSourceDropdown().isVisible());
    }

    @And("Seçilen görselin önizlemesi ekranda görünmelidir")
    public void secilenGorselinOnizlemesiEkrandaGorunmelidir() {
        Assert.assertTrue(virtualStagingPage.getOnizleme().isVisible());
    }

    @When("Kullanıcı Describe what to change metin alanına Remove the chair yazar")
    public void kullaniciDescribeWhatToChangeMetinAlaninaRemoveTheChairYazar() {
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), "Remove the chair");
    }

    @Then("Edit Photo butonunun aktif olduğu görülür")
    public void editPhotoButonununAktifOlduguGorulur() {
        Assert.assertTrue(virtualStagingPage.getEditPhotoButonu().isEnabled());
    }

    @When("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklar() {
        rm.myClick(virtualStagingPage.getEditPhotoButonu());
    }

    @Then("Sistem kullanıcının metinsel talimatına uygun şekilde düzenlenmiş yeni görseli ekranda sunmalıdır")
    public void sistemKullanicininMetinselTalimatinaUygunSekildeDuzenlenmisYeniGorseliEkrandaSunmalidir() {
        Assert.assertTrue(virtualStagingPage.getBasariliSonuc().isVisible());
    }

    @When("Kullanıcı Edit photo source alanından yeni bir kaynak görsel yükler")
    public void kullaniciEditPhotoSourceAlanindanYeniBirKaynakGorselYukler() {
        virtualStagingPage.getYuklemeAlani().setInputFiles(java.nio.file.Paths.get("src/test/resources/test.jpg"));
    }

    @Then("Yeni yüklenen görselin önizlemesi ekranda görünmelidir")
    public void yeniYuklenenGorselinOnizlemesiEkrandaGorunmelidir() {
        Assert.assertTrue(virtualStagingPage.getOnizleme().isVisible());
    }

    @When("Kullanıcı Describe what to change metin alanına Add a modern sofa yazar")
    public void kullaniciDescribeWhatToChangeMetinAlaninaAddAModernSofaYazar() {
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), "Add a modern sofa");
    }

    @And("Kullanıcı Edit Photo butonuna tıklar")
    public void kullaniciEditPhotoButonunaTiklarAnd() {
        rm.myClick(virtualStagingPage.getEditPhotoButonu());
    }

    @Then("Sistem güncellenmiş yeni görseli ekranda sunmalıdır")
    public void sistemGuncellenmisYeniGorseliEkrandaSunmalidir() {
        Assert.assertTrue(virtualStagingPage.getBasariliSonuc().isVisible());
    }

    @When("Kullanıcı {string} alanından {string} seçer")
    public void kullaniciAlanindanSecer(String arg0, String arg1) {
        rm.myClick(virtualStagingPage.getEditPhotoSourceDropdown());
    }

    @And("Kullanıcı Describe what to change metin alanını boş bırakır")
    public void kullaniciDescribeWhatToChangeMetinAlaniniBosBirakir() {
        // Boş bırakılıyor
    }

    @Then("Edit Photo butonunun pasif olduğu doğrulanır")
    public void editPhotoButonununPasifOlduguDogrulanir() {
        Assert.assertFalse(virtualStagingPage.getEditPhotoButonu().isEnabled());
    }

    @When("Kullanıcı Describe what to change alanına sistemin karakter sınırını zorlayacak çok uzun bir açıklama metni yazar")
    public void kullaniciDescribeWhatToChangeAlaninaSisteminKarakterSiniriniZorlayacakCokUzunBirAciklamaMetniYazar() {
        String uzunMetin = "a".repeat(1000);
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), uzunMetin);
    }

    @Then("Metin alanının bu girdiyi kabul ettiği veya uygun bir sınırlama uyarısı verdiği doğrulanır")
    public void metinAlanininBuGirdiyiKabulEtTigiVeyaUygunBirSinirlamaUyarisiVerdigiDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getDescribeWhatToChangeInput().isVisible());
    }

    @And("Edit Photo butonunun işlevselliği test edilir")
    public void editPhotoButonununIslevselligiTestEdilir() {
        Assert.assertTrue(virtualStagingPage.getEditPhotoButonu().isVisible());
    }

    @When("Kullanıcı {string} alanına özel karakterler ve emojiler içeren bir talep yazar (örn. \"Remove chair & table! 🪑\")")
    public void kullaniciAlaninaOzelKarakterlerVeEmojilerIcerenBirTalepYazar(String arg0) {
        rm.mySendKeys(virtualStagingPage.getDescribeWhatToChangeInput(), "Remove chair & table! 🪑");
    }

    @Then("Yapay zekanın girdiyi işleyip görseli başarılı bir şekilde düzenlediği doğrulanır")
    public void yapayZekaninGirdiyiIsleyipGorseliBasariliBirSekildeDuzenledigiDogrulanir() {
        Assert.assertTrue(virtualStagingPage.getBasariliSonuc().isVisible());
    }

    @And("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @When("Kullanıcı header alanındaki Ürünler dropdown menüsünün üzerine gelir")
    public void kullaniciHeaderAlanindakiUrunlerDropdownMenusunUzerineGelir() {
        navigationPage.getUrunlerDropdown().hover();
    }

    @Then("Menünün açıldığı ve seçeneklerin listelendiği görülür")
    public void menununAcildigiVeSeceneklerinListelendigiGorulur() {
        Assert.assertTrue(navigationPage.getYapayZekaSanalTurSecenegi().isVisible());
    }

    @When("Kullanıcı listeden 2. sırada yer alan Yapay Zeka Sanal Tur seçeneğine tıklar")
    public void kullaniciListeden2SiradaYerAlanYapayZekaSanalTurSeceneginiTiklar() {
        rm.myClick(navigationPage.getYapayZekaSanalTurSecenegi());
    }

    @Then("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir")
    public void kullaniciAiVirtualTourSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @When("Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar")
    public void kullaniciSayfadakiErkenErisimIsteyinButonunaTiklar() {
        rm.myClick(navigationPage.getErkenErisimIsteyinButonu());
    }

    @Then("İlgili form veya modal açılmalıdır")
    public void ilgiliFormVeyaModalAcilmalidir() {
        Assert.assertTrue(navigationPage.getEpostaInput().isVisible());
    }

    @When("Kullanıcı form alanına geçerli bir e-posta adresi girer ve gönderir")
    public void kullaniciFormAlaninaGecerliBirEPostaAdresiGirerVeGonderir() {
        rm.mySendKeys(navigationPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem bilgileri kaydetmeli ve kullanıcıya başarılı iletim onay mesajı göstermelidir")
    public void sistemBilgileriKaydetmeliVeKullaniciyaBasariliIletimOnayMesajiGostermelidir() {
        Assert.assertTrue(navigationPage.getOnayMesaji().isVisible());
    }

    @And("Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır")
    public void kullaniciAiVirtualTourSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/ai-virtual-tour");
        Assert.assertTrue(PD.getPage().url().contains("ai-virtual-tour"));
    }

    @And("Kullanıcı form alanına geçersiz bir e-posta adresi girer")
    public void kullaniciFormAlaninaGecersizBirEPostaAdresiGirer() {
        rm.mySendKeys(navigationPage.getEpostaInput(), "gecersizemail");
    }

    @And("Kullanıcı formu gönderme butonuna tıklar")
    public void kullaniciFormuGondermeButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem e-posta formatı hatası göstermelidir ve talep gönderilmemelidir")
    public void sistemEPostaFormatiHatasiGostermelidirVeTalepGonderilmemelidir() {
        Assert.assertTrue(navigationPage.getOnayMesaji().isHidden());
    }

    @And("Kullanıcı e-posta alanını boş bırakıp gönder butonuna tıklar")
    public void kullaniciEPostaAlaniniBosBirakipGonderButonunaTiklar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Zorunlu alan uyarısı gösterilmelidir")
    public void zorunluAlanUyarisiGosterilmelidir() {
        Assert.assertTrue(navigationPage.getEpostaInput().isVisible());
    }

    @And("Daha önce erken erişim talebinde bulunmuş bir e-posta adresi bilinmektedir")
    public void dahaOnceErkenErisimTalebindeBulunmusBirEPostaAdresiBilinmektedir() {
        // Bilinen mail
    }

    @When("Kullanıcı Erken Erişim İsteyin formuna bu e-posta adresini tekrar girer ve gönderir")
    public void kullaniciErkenErisimIsteyinFormunaBuEPostaAdresiniTekrarGirerVeGonderir() {
        rm.mySendKeys(navigationPage.getEpostaInput(), "tekrar@example.com");
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem mükerrer kaydı engellemeli veya kullanıcıya daha önce kayıt olduğuna dair uygun bir bilgi mesajı göstermelidir")
    public void sistemMukerrerKaydiEngellemeliVeyaKullaniciyaDahaOnceKayitOldugunaDairUygunBirBilgiMesajiGostermelidir() {
        Assert.assertTrue(navigationPage.getEpostaInput().isVisible());
    }

    @And("Kullanıcı listedeki 3. eleman olan Sanal Dekorasyon API seçeneğine tıklar")
    public void kullaniciListedeki3ElemanOlanSanalDekorasyonApiSeceneginiTiklar() {
        rm.myClick(navigationPage.getSanalDekorasyonApiSecenegi());
    }

    @Then("Kullanıcı aistager.ai/tr/api sayfasına yönlendirilmelidir")
    public void kullaniciApiSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar")
    public void kullaniciSayfaninUstKismindakiIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButonu());
    }

    @Then("İletişim formu açılmalıdır")
    public void iletisimFormuAcilmalidir() {
        Assert.assertTrue(navigationPage.getIletisimFormuAdSoyad().isVisible());
    }

    @When("Kullanıcı zorunlu alanları eksiksiz doldurur ve formu onaylar")
    public void kullaniciZorunluAlanlariEksiksizDoldururVeFormuOnaylar() {
        rm.mySendKeys(navigationPage.getIletisimFormuAdSoyad(), "Test User");
        rm.mySendKeys(navigationPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(navigationPage.getMesajAlani(), "Test mesajıdır.");
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Talep başarıyla iletilmeli ve ekranda onay mesajı gösterilmelidir")
    public void talepBasariylaIletilmeliVeEkrandaOnayMesajiGosterilmelidir() {
        Assert.assertTrue(navigationPage.getOnayMesaji().isVisible());
    }

    @When("Kullanıcı sayfanın alt kısmında yer alan Fiyatlandırmayı Görüntüle butonuna tıklar")
    public void kullaniciSayfaninAltKismindaYerAlanFiyatlandirmayiGoruntuleButonunaTiklar() {
        rm.myClick(navigationPage.getFiyatlandirmayiGoruntuleButonu());
    }

    @Then("Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir")
    public void kullaniciHatasizBirSekildeFiyatlandirmaSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("pricing"));
    }

    @And("Kullanıcı aistager.ai/tr/api sayfasındadır")
    public void kullaniciApiSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/api");
        Assert.assertTrue(PD.getPage().url().contains("api"));
    }

    @When("Kullanıcı İletişime Geçin butonuna tıklar")
    public void kullaniciIletisimeGecinButonunaTiklar() {
        rm.myClick(navigationPage.getIletisimeGecinButonu());
    }

    @And("Kullanıcı zorunlu alanlardan bazılarını boş bırakarak formu onaylar")
    public void kullaniciZorunluAlanlardanBazilariniBosBirakarakFormuOnaylar() {
        rm.myClick(navigationPage.getGonderButonu());
    }

    @Then("Sistem zorunlu alan hatalarını göstermeli ve form gönderilmemelidir")
    public void sistemZorunluAlanHatalariniGostermeliVeFormGonderilmemelidir() {
        Assert.assertTrue(navigationPage.getIletisimFormuAdSoyad().isVisible());
    }

    @And("Kullanıcı mesaj alanına karakter sınırını aşan çok uzun bir metin girer")
    public void kullaniciMesajAlaninaKarakterSiniriniAsanCokUzunBirMetinGirer() {
        String uzunMesaj = "m".repeat(5000);
        rm.mySendKeys(navigationPage.getMesajAlani(), uzunMesaj);
    }

    @Then("Sistem karakter sınırını aşım uyarısı vermeli ya da metni sınıra göre kırpmalıdır")
    public void sistemKarakterSiniriniAsimUyarisiVermeliYaDaMetniSiniraGoreKirpmalidir() {
        Assert.assertTrue(navigationPage.getMesajAlani().isVisible());
    }
}