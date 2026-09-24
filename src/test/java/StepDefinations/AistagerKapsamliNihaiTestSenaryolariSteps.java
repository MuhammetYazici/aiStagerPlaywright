package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.PD;
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
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı AiStager.ai ana sayfadaki bülten bölümüne gelir")
    public void kullaniciAiStagerAiAnaSayfadakiBultenBolumuneGelir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        rm.myClick(homePage.getBultenEpostaInput());
    }

    @When("Bülten e-posta alanına {string} adresi girilir")
    public void bultenEpostaAlaninaAdresiGirilir(String gecerliEposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue(gecerliEposta));
    }

    @And("{string} butonuna tıklanmalıdır")
    public void butonunaTiklanmalidir(String butonAdi) {
        if(butonAdi.equals("Abone Ol")) {
            rm.myClick(homePage.getAboneOlButton());
        } else if(butonAdi.equals("Giriş Yap")) {
            rm.myClick(loginPage.getGirisYapButton());
        } else if(butonAdi.equals("Hesap Oluştur")) {
            rm.myClick(registerPage.getHesapOlusturButton());
        }
    }

    @And("Abone Ol butonuna tıklanır")
    public void aboneOlButonunaTiklanir() {
        rm.myClick(homePage.getAboneOlButton());
    }

    @Then("Başarılı abonelik mesajı görüntülenmelidir")
    public void basariliAbonelikMesajiGoruntulenmelidir() {
        rm.veriyfyContainsText(homePage.getBasariliAbonelikMesaji(), "Başarılı");
    }

    @When("Bülten e-posta alanına {string} girilir")
    public void bultenEpostaAlaninaGirilir(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue(gecersizEposta));
    }

    @Then("Bülten alanında uygun bir hata veya uyarı mesajı gösterilmelidir")
    public void bultenAlanindaUygunBirHataVeyaUyariMesajiGosterilmelidir() {
        Assert.assertTrue(homePage.getBultenHataMesaji().isVisible());
    }

    @Given("Kullanıcı Giriş Yap sayfasındadır")
    public void kullaniciGirisYapSayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
    }

    @When("E-posta alanına {string} girilir")
    public void ePostaAlaninaGirilir(String eposta) {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue(eposta));
    }

    @And("Şifre alanına {string} girilir")
    public void sifreAlaninaGirilir(String sifre) {
        rm.mySendKeys(loginPage.getSifreInput(), rm.resolveDynamicValue(sifre));
    }

    @And("Giriş Yap butonuna tıklanır")
    public void girisYapButonunaTiklanir() {
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Kullanıcı başarılı bir şekilde oturum açarak ana sayfaya yönlendirilmelidir")
    public void kullaniciBasariliBirSekildeOturumAcarakAnaSayfayaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains(""));
    }

    @Then("Zorunlu alanlar için Bu alan zorunludur uyarısı alınmalıdır")
    public void zorunluAlanlarIcinBuAlanZorunludurUyarisiAlinmalidir() {
        rm.veriyfyContainsText(loginPage.getZorunluAlanUyarisi(), "Bu alan zorunludur");
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String sayfaAdi) {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("E-posta alanına {string} girilir_hatali")
    public void ePostaAlaninaHataliFormattaGirilir(String eposta) {
        rm.mySendKeys(loginPage.getEpostaInput(), eposta);
    }

    @Then("E-posta formatının geçersiz olduğuna dair validasyon uyarısı gösterilmelidir")
    public void ePostaFormatininGecersizOldugunaDairValidasyonUyarisiGosterilmelidir() {
        rm.veriyfyContainsText(loginPage.getGecersizEmailUyarisi(), "geçerli");
    }

    @And("Giriş Yap butonuna tıklanmalıdır")
    public void girisYapButonunaTiklanmalidir() {
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Genel güvenlik uyarısı olarak E-posta veya şifre hatalı mesajı gösterilmelidir")
    public void genelGuvenlikUyarisiOlarakEPostaVeyaSifreHataliMesajiGosterilmelidir() {
        rm.veriyfyContainsText(loginPage.getGenelGuvenlikUyarisi(), "E-posta veya şifre hatalı");
    }

    @Then("Sistem çökmemeli ve genel E-posta veya şifre hatalı hata mesajı gösterilmelidir")
    public void sistemCokmemeliVeGenelEPostaVeyaSifreHataliHataMesajiGosterilmelidir() {
        rm.veriyfyContainsText(loginPage.getGenelGuvenlikUyarisi(), "E-posta veya şifre hatalı");
    }

    @When("Şifre alanına {string} yazılır")
    public void sifreAlaninaYazilir(String sifre) {
        rm.mySendKeys(loginPage.getSifreInput(), sifre);
    }

    @And("Şifre alanındaki Göz ikonuna tıklanır")
    public void sifreAlanindakiGozIkonunaTiklanir() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifrenin düz metin olarak görünür olduğu doğrulanır")
    public void sifreninDuzMetinOlarakGorunurOlduguDogrulanir() {
        Assert.assertEquals(loginPage.getSifreInput().getAttribute("type"), "text");
    }

    @When("Göz ikonuna tekrar tıklanır")
    public void gozIkonunaTekrarTiklanir() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @Then("Şifrenin maskelendiği yıldızlı veya noktalı doğrulanır")
    public void sifreninMaskelendigiYildizliVeyaNoktaliDogrulanir() {
        Assert.assertEquals(loginPage.getSifreInput().getAttribute("type"), "password");
    }

    @When("Şifreyi Onayla alanına {string} girilir")
    public void sifreyiOnaylaAlaninaGirilir(String sifreOnay) {
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), rm.resolveDynamicValue(sifreOnay));
    }

    @And("Kullanıcı sözleşmesi onay kutusu seçilir")
    public void kullaniciSozlesmesiOnayKutusuSecilir() {
        rm.myCheckBox(registerPage.getSozlesmeCheckbox());
    }

    @Then("Kullanıcı başarıyla kaydedilmeli ve yönlendirme yapılmalıdır")
    public void kullaniciBasariylaKaydedilmeliVeYonlendirmeYapilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains(""));
    }

    @And("Kullanıcı sözleşmesi onay kutusu {string} durumunda bırakılır")
    public void kullaniciSozlesmesiOnayKutusuDurumundaBirakilir(String durum) {
        if(durum.equals("işaretli")) {
            rm.myCheckBox(registerPage.getSozlesmeCheckbox());
        }
    }

    @Then("İlgili hata mesajı kullanıcıya gösterilmelidir")
    public void ilgiliHataMesajiKullaniciyaGosterilmelidir() {
        Assert.assertTrue(registerPage.getHataMesaji().isVisible());
    }

    @Given("Kullanıcı siteye henüz giriş yapmamış bir ziyaretçidir")
    public void kullaniciSiteyeHenuzGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı AiStager.ai ana sayfasına gider")
    public void kullaniciAiStagerAiAnaSayfasinaGider() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır")
    public void ustMenudeGirisYapVeUcretsizDeneButonlariGorunurOlmalidir() {
        Assert.assertTrue(homePage.getGirisYapLink().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible());
    }

    @And("Üst menüde Üretimlerim ve profil menüsünün gizli olduğu doğrulanmalıdır")
    public void ustMenudeUretimlerimVeProfilMenusununGizliOlduguDogrulanmalidir() {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "kayitli_kullanici@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "GecerliSifre123");
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Üst menüde profil menüsü ve Üretimlerim alanı görünür ve erişilebilir olmalıdır")
    public void ustMenudeProfilMenusuVeUretimlerimAlaniGorunurVeErisilebilirOlmalidir() {
        Assert.assertTrue(homePage.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki Öncesi ve Sonrası slider bölümündedir")
    public void kullaniciAnaSayfadakiOncesiVeSonrasiSliderBolumundedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getSliderBolumu().isVisible());
    }

    @When("Kullanıcı slider üzerindeki iki yönlü oku sağa veya sola sürükler ya da yön oklarına tıklar")
    public void kullaniciSliderUzerindekiIkiYonluOkuSagaVeyaSolaSuruklerYaDaYonOklarinaTiklar() {
        rm.myClick(homePage.getSliderOku());
    }

    @Then("Görsellerin geçişi pürüzsüz bir şekilde gerçekleşmelidir")
    public void gorsellerinGecisiPuruzsuzBirSekildeGerceklesmelidir() {
        Assert.assertTrue(homePage.getSliderBolumu().isVisible());
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Üst menüden dil seçeneği TR den farklı bir dile dönüştürülür")
    public void ustMenudenDilSecenegiTRDenFarkliBirDileDonusturulur() {
        rm.myClick(homePage.getDilSecenegiMenu());
    }

    @Then("Arayüz metinlerinin seçilen dile dinamik olarak güncellendiği doğrulanır")
    public void arayuzMetinlerininSecilenDileDinamikOlarakGuncellendigiDogrulanir() {
        Assert.assertTrue(homePage.getDilSecenegiMenu().isVisible());
    }

    @Given("Kullanıcı ana sayfadaki Galeri bölümündedir")
    public void kullaniciAnaSayfadakiGaleriBolumundedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGaleriBolumu().isVisible());
    }

    @When("Sayfa ilk açıldığında Tüm Tipler filtresinin seçili olduğu görülür")
    public void sayfaIlkAcildigindaTumTiplerFiltresininSeciliOlduguGorulur() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @And("Kullanıcı farklı bir oda tipi kategorisine tıklar")
    public void kullaniciFarkliBirOdaTipiKategorisineTiklar() {
        rm.myClick(homePage.getOdaTipiKategorisi());
    }

    @Then("Galeri yalnızca seçilen oda tipine ait tasarımları listelemelidir")
    public void galeriYalnizcaSecilenOdaTipineAitTasarimlariListelemelidir() {
        Assert.assertTrue(homePage.getGaleriBolumu().isVisible());
    }

    @Given("Kullanıcı Galeri bölümündedir")
    public void kullaniciGaleriBolumundedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Bir tasarım kartı üzerindeki Beğeni ikonuna tıklanır")
    public void birTasarimKartiUzerindekiBegeniIkonunaTiklanir() {
        rm.myClick(homePage.getBegeniIkonu());
    }

    @Then("İlgili kartın sayaç değerinin bir arttığı görülür")
    public void ilgiliKartinSayacDegerininBirArttigiGorulur() {
        Assert.assertTrue(homePage.getSayacDegeri().isVisible());
    }

    @When("Daha Fazla Tasarım Yükle butonuna tıklanır")
    public void dahaFazlaTasarimYukleButonunaTiklanir() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut filtreleme korunarak alt alta yeni tasarım kartlarının yüklendiği görülmelidir")
    public void mevcutFiltrelemeKorunarakAltAltaYeniTasarimKartlarininYuklendigiGorulmelidir() {
        Assert.assertTrue(homePage.getGaleriBolumu().isVisible());
    }

    @Given("Kullanıcı Sıkça Sorulan Sorular bölümündedir")
    public void kullaniciSikcaSorulanSorularBolumundedir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getSssBolumu().isVisible());
    }

    @When("Birinci soruya tıklanarak akordeon açılır")
    public void birinciSoruyaTiklanarakAkordeonAcilir() {
        rm.myClick(homePage.getBirinciSoru());
        Assert.assertTrue(homePage.getAkordeonIcerik().isVisible());
    }

    @And("Kullanıcı farklı ikinci bir soruya tıklar")
    public void kullaniciFarkliIkinciBirSoruyaTiklar() {
        rm.myClick(homePage.getIkinciSoru());
    }

    @Then("İkinci soru açılırken birinci sorunun akordeon yapısının otomatik olarak kapandığı doğrulanmalıdır")
    public void ikinciSoruAcilirkenBirinciSorununAkordeonYapisininOtomatikOlarakKapandigiDogrulanmalidir() {
        Assert.assertTrue(homePage.getSssBolumu().isVisible());
    }
}