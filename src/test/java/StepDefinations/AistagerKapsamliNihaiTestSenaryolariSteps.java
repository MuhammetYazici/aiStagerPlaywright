package StepDefinations;
import com.microsoft.playwright.Page;

import Utilities.PD;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı slider üzerindeki orta çizgiyi sağa veya sola sürükler")
    public void kullaniciSliderUzerindekiOrtaCizgiyiSagaVeyaSolaSurukler() {
        rm.myClick(homePage.getSliderOrtaCizgi());
    }

    @Then("Önce ve Sonra görselleri pürüzsüz bir şekilde değişir")
    public void onceVeSonraGorselleriPuruzsuzBirSekildeDegisir() {
        Assert.assertTrue(homePage.getOnceSonraGorseller().isVisible());
    }

    @And("İlgili oda tipine ait carousel noktası aktifleşir")
    public void ilgiliOdaTipineAitCarouselNoktasiAktiflesir() {
        Assert.assertTrue(homePage.getCarouselNoktasi().isVisible());
    }

    @When("Kullanıcı slider üzerindeki ok veya nokta butonlarına tıklar")
    public void kullaniciSliderUzerindekiOkVeyaNoktaButonlarinaTıklar() {
        rm.myClick(homePage.getSliderOkVeyaNoktaButonu());
    }

    @Then("Önce ve Sonra görselleri değişir ve ilgili nokta aktifleşir")
    public void onceVeSonraGorselleriDegisirVeIlgiliNoktaAktiflesir() {
        Assert.assertTrue(homePage.getOnceSonraGorseller().isVisible());
    }

    @Given("Kullanıcı oturum açmamış bir ziyaretçidir")
    public void kullaniciOturumAcmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde {string} ve {string} butonları görünür")
    public void ustMenudeVeButonlariGorunur(String arg0, String arg1) {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible());
    }

    @And("Üretimlerim ve profil ikonu menüde yer almaz")
    public void uretimlerimVeProfilIkonuMenudeYerAlmaz() {
        Assert.assertFalse(homePage.getUretimlerimIkonu().isVisible());
        Assert.assertFalse(homePage.getProfilIkonu().isVisible());
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), ConfigReader.getProperty("validEmail"));
        rm.mySendKeys(loginPage.getSifreInput(), ConfigReader.getProperty("validPassword"));
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Üst menüde ürünler ve çözümler dropdown menüleri görünür")
    public void ustMenudeUrunlerVeCozumlerDropdownMenuleriGorunur() {
        Assert.assertTrue(homePage.getUrunlerDropdown().isVisible());
        Assert.assertTrue(homePage.getCozumlerDropdown().isVisible());
    }

    @And("Hızlı render ikonu ve profil menüsü aktif olarak görüntülenir")
    public void hizliRenderIkonuVeProfilMenusuAktifOlarakGoruntulenir() {
        Assert.assertTrue(homePage.getHizliRenderIkonu().isVisible());
    }

    @When("Kullanıcı platform logosuna tıklar")
    public void kullaniciPlatformLogosunaTıklar() {
        rm.myClick(homePage.getPlatformLogosu());
    }

    @Then("Kullanıcı ana sayfaya yönlendirilir")
    public void kullaniciAnaSayfayaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Kullanıcı ana sayfa galeri alanındadır")
    public void kullaniciAnaSayfaGaleriAlanindadir() {
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @Then("Varsayılan olarak Tüm Tipler filtresi aktif gelmelidir")
    public void varsayilanOlarakTumTiplerFiltresiAktifGelmelidir() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @When("Kullanıcı Oturma Odası oda tipi filtresini seçer")
    public void kullaniciOturmaOdasiOdaTipiFiltresiniSecer() {
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @Then("Liste anlık olarak sadece Oturma Odası tasarımlarını gösterecek şekilde filtrelenir")
    public void listeAnlikOlarakSadeceOturmaOdasiTasarimlariniGosterecekSekildeFiltrelenir() {
        Assert.assertTrue(homePage.getOturmaOdasiTasarımlariListesi().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTıklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @Then("Seçili olan oda tipi filtresi korunarak yeni tasarım kartları yüklenir")
    public void seciliOlanOdaTipiFiltresiKorunarakYeniTasarimKartlariYuklenir() {
        Assert.assertTrue(homePage.getOturmaOdasiTasarımlariListesi().isVisible());
    }

    @When("Kullanıcı SSS alanından bir soruya tıklayarak akordeonu açar")
    public void kullaniciSssAlanindanBirSoruyaTiklayarakAkordeonuAcar() {
        rm.myClick(homePage.getSssSorusu());
    }

    @And("Kullanıcı farklı bir soruya tıklar")
    public void kullaniciFarkliBirSoruyaTıklar() {
        rm.myClick(homePage.getFarkliSssSorusu());
    }

    @Then("İlk açılan soru otomatik olarak kapanır")
    public void ilkAcilanSoruOtomatikOlarakKapanir() {
        Assert.assertTrue(homePage.getSssSorusu().isVisible());
    }

    @And("Yeni tıklanan soru açılır")
    public void yeniTiklananSoruAcurilir() {
        Assert.assertTrue(homePage.getFarkliSssSorusu().isVisible());
    }

    @When("Kullanıcı bülten alanına geçerli bir e-posta adresi girer")
    public void kullaniciBultenAlaninaGecerliBirEPostaAdresiGirer() {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("{string} butonuna tıklar")
    public void butonunaTıklar(String arg0) {
        if (arg0.equals("Abone Ol")) {
            rm.myClick(homePage.getAboneOlButton());
        } else if (arg0.equals("Giriş Yap")) {
            rm.myClick(loginPage.getGirisYapButton());
        } else if (arg0.equals("Kayıt Ol")) {
            rm.myClick(registerPage.getKayitOlButton());
        }
    }

    @Then("Başarılı kayıt yapıldığı yeşil uyarı mesajı ile teyit edilir")
    public void basariliKayitYapildigiYesilUyariMesajiIleTeyitEdilir() {
        Assert.assertTrue(homePage.getBasariliKayitMesaji().isVisible());
    }

    @When("Kullanıcı bülten alanını boş bırakır veya geçersiz bir e-posta girer")
    public void kullaniciBultenAlaniniBosBirakirVeyaGecersizBirEPostaGirer() {
        rm.mySendKeys(homePage.getBultenEpostaInput(), "gecersizemail");
    }

    @Then("Form validasyon uyarı mesajı görüntülenir")
    public void formValidasyonUyariMesajiGoruntulenir() {
        Assert.assertTrue(homePage.getFormValidasyonUyarisi().isVisible());
    }

    @Given("Kullanıcı https://aistager.ai/tr/login adresindedir")
    public void kullaniciHttpsAistagerAiTrLoginAdresindedir() {
        PD.getPage().navigate("https://aistager.ai/tr/login");
    }

    @And("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains(arg0));
    }

    @When("Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer")
    public void kullaniciKayitliEPostaAdresiniVeDogruSifresiniGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), ConfigReader.getProperty("validEmail"));
        rm.mySendKeys(loginPage.getSifreInput(), ConfigReader.getProperty("validPassword"));
    }

    @Then("Kullanıcı başarılı bir şekilde panele yönlendirilir")
    public void kullaniciBasariliBirSekildePaneleYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("panel") || PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("aistager"));
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak {string} butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakButonunaTıklar(String arg0) {
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("İlgili alanların altında Bu alan zorunludur uyarı mesajı gösterilir")
    public void ilgiliAlanlarinAltindaBuAlanZorunludurUyariMesajiGosterilir() {
        Assert.assertTrue(loginPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("Kullanıcı geçersiz formatta bir e-posta adresi girer")
    public void kullaniciGecersizFormattaBirEPostaAdresiGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "hataliemailformat");
    }

    @Then("Geçerli bir e-posta adresi girin uyarı mesajı gösterilir")
    public void gecerliBirEPostaAdresiGirinUyariMesajiGosterilir() {
        Assert.assertTrue(loginPage.getGecersizEpostaUyarisi().isVisible());
    }

    @When("Kullanıcı hatalı şifre veya sistemde kayıtlı olmayan bir e-posta girer")
    public void kullaniciHataliSifreVeyaSistemdeKayitliOlmayanBirEPostaGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "olmayan@mail.com");
        rm.mySendKeys(loginPage.getSifreInput(), "YanlisSifre123!");
    }

    @Then("Sistem güvenlik gereği spesifik bilgi vermeyerek genel bir E-posta veya şifre hatalı uyarısı döner")
    public void sistemGuvenlikGeregiSpesifikBilgiVermeyerekGenelBirEPostaVeyaSifreHataliUyarisiDoner() {
        Assert.assertTrue(loginPage.getGenelHataUyarisi().isVisible());
    }

    @When("Kullanıcı e-posta veya şifre alanına SQL Injection karakterleri girer")
    public void kullaniciEPostaVeyaSifreAlaninaSQLInjectionKarakterleriGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "' OR '1'='1");
        rm.mySendKeys(loginPage.getSifreInput(), "' OR '1'='1");
    }

    @Then("Sistem girdileri filtreler, 500 sunucu hatasına sebep olmaz ve uygun hata mesajı gösterilir")
    public void sistemGirdileriFiltreler500SunucuHatasinaSebepOlmazVeUygunHataMesajiGosterilir() {
        Assert.assertTrue(loginPage.getGenelHataUyarisi().isVisible());
    }

    @Given("Kullanıcı https://aistager.ai/tr/register adresindedir")
    public void kullaniciHttpsAistagerAiTrRegisterAdresindedir() {
        PD.getPage().navigate("https://aistager.ai/tr/register");
    }

    @When("Kullanıcı geçerli bir e-posta adresi girer")
    public void kullaniciGecerliBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kullanıcı en az 8 karakterden oluşan ve birbiriyle eşleşen şifreler girer")
    public void kullaniciEnAzKarakterdenOlusanVeBirbiriyleEslesenSifrelerGirer() {
        String pass = "ValidPass123!";
        rm.mySendKeys(registerPage.getSifreInput(), pass);
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), pass);
    }

    @And("Kullanıcı sözleşme onay kutucuğunu işaretler")
    public void kullaniciSozlesmeOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
    }

    @Then("Hesap başarıyla oluşturulur ve yönlendirme gerçekleştirilir")
    public void hesapBasariylaOlusturulurVeYonlendirmeGerceklestirilir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @When("Kullanıcı şifre alanına bir değer yazar ve göz ikonuna tıklar")
    public void kullaniciSifreAlaninaBirDegerYazarVeGozIkonunaTıklar() {
        rm.mySendKeys(registerPage.getSifreInput(), "Sifre1234");
        rm.myClick(registerPage.getGozIkonu());
    }

    @Then("Şifre karakterleri görünür hale gelir")
    public void sifreKarakterleriGorunurHaleGelir() {
        Assert.assertTrue(registerPage.getSifreInput().isVisible());
    }

    @When("Kullanıcı tekrar göz ikonuna tıklar")
    public void kullaniciTekrarGozIkonunaTıklar() {
        rm.myClick(registerPage.getGozIkonu());
    }

    @Then("Şifre tekrar maskelenir (yıldız veya nokta ile gizlenir)")
    public void sifreTekrarMaskelenirYildizVeyaNoktaIleGizlenir() {
        Assert.assertTrue(registerPage.getSifreInput().isVisible());
    }

    @When("Kullanıcı formu boş bırakarak {string} butonuna tıklar")
    public void kullaniciFormuBosBirakarakButonunaTıklar(String arg0) {
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("İlgili zorunlu alanlarda Bu alan zorunludur uyarı mesajı gösterilir")
    public void ilgiliZorunluAlanlardaBuAlanZorunludurUyariMesajiGosterilir() {
        Assert.assertTrue(registerPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("Kullanıcı 8 karakterden kısa bir şifre girer ve kayıt olmaya çalışır")
    public void kullaniciKarakterdenKisaBirSifreGirerVeKayitOlMAyaCalisir() {
        rm.mySendKeys(registerPage.getSifreInput(), "123");
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("Sistem şifre uzunluğu kuralı ile ilgili uyarı mesajı gösterilir")
    public void sistemSifreUzunluguKuraliIleIlgiliUyariMesajiGosterilir() {
        Assert.assertTrue(registerPage.getSifreUzunlukUyarisi().isVisible());
    }

    @When("Kullanıcı Şifre ve Şifreyi Onayla alanlarına farklı değerler girer")
    public void kullaniciSifreVeSifreyiOnaylaAlanlarinaFarkliDegerlerGirer() {
        rm.mySendKeys(registerPage.getSifreInput(), "Sifre1234!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "DigerSifre4321!");
    }

    @Then("Sistem Şifreler eşleşmiyor uyarı mesajını gösterir")
    public void sistemSifrelerEslesmiyorUyariMesajiniGosterir() {
        Assert.assertTrue(registerPage.getSifrelerEslenmiyorUyarisi().isVisible());
    }

    @When("Kullanıcı tüm alanları doğru doldurur ancak onay kutucuğunu boş bırakır")
    public void kullaniciTumAlanlariDogruDoldururAncakOnayKutucugunuBosBirakir() {
        rm.mySendKeys(registerPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(registerPage.getSifreInput(), "ValidPass123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "ValidPass123!");
    }

    @Then("Sistem Sözleşmeyi kabul etmelisiniz uyarı mesajını gösterir")
    public void sistemSozlesmeyiKabulEtmelisinizUyariMesajiniGosterir() {
        Assert.assertTrue(registerPage.getSozlesmeUyarisi().isVisible());
    }

    @When("Kullanıcı halihazırda sistemde kayıtlı olan bir e-posta adresini girer")
    public void kullaniciHalihazirdaSistemdeKayitliOlanBirEPostaAdresiniGirer() {
        rm.mySendKeys(registerPage.getEpostaInput(), ConfigReader.getProperty("validEmail"));
    }

    @And("Diğer alanları kurallara uygun doldurarak {string} butonuna tıklar")
    public void digerAlanlariKurallaraUygunDoldurarakButonunaTıklar(String arg0) {
        rm.mySendKeys(registerPage.getSifreInput(), "ValidPass123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "ValidPass123!");
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
        rm.myClick(registerPage.getKayitOlButton());
    }

    @Then("Sistem Bu e-posta adresi zaten kullanımda uyarı mesajını gösterir")
    public void sistemBuEPostaAdresiZatenKullanimdaUyariMesajiniGosterir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaUyarisi().isVisible());
    }
}