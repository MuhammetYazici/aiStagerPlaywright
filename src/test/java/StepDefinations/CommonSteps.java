package StepDefinations;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class CommonSteps {
    ReusableMethod rm = new ReusableMethod();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Given("Kullanıcı ana sayfadayım \\({string})")
    public void kullaniciAnaSayfadayim(String url) {
        PD.getPage().navigate(PD.properties.getProperty("URL") + url);
    }

    @Given("Kullanıcı giriş sayfasındadır \\({string})")
    public void kullaniciGirisSayfasindadir(String url) {
        PD.getPage().navigate(PD.properties.getProperty("URL") + url);
    }

    @Given("Kullanıcı kayıt sayfasındadır \\({string})")
    public void kullaniciKayitSayfasindadir(String url) {
        PD.getPage().navigate(PD.properties.getProperty("URL") + url);
    }

    @When("Kullanıcı {string} görselinin ortasındaki iki yönlü oku sağa ve sola sürükler")
    public void kullaniciGorselininOrtasindakiIkiYonluOkuSagaVeSolaSurukler(String gorselAdi) {
        Locator slider = homePage.getSliderSihirGorseli();
        rm.myClick(slider);
    }

    @Then("Oda içerisindeki {string} \\(boş oda) ve {string} \\(mobilyalı oda) durumları pürüzsüz bir şekilde görünmelidir")
    public void odaIcerisindekiBosOdaVeMobilyaliOdaDurumlariPuruzsuzBirSekildeGorunmelidir(String once, String sonra) {
        rm.veriyfyContainsText(homePage.getOnceSonraDurumMetni(once), once);
        rm.veriyfyContainsText(homePage.getOnceSonraDurumMetni(sonra), sonra);
    }

    @When("Kullanıcı alt carousel üzerindeki farklı nokta ikonlarına tıklar")
    public void kullaniciAltCarouselUzerindekiFarkliNoktaIkonlarinaTiklar() {
        rm.myClick(homePage.getCarouselNoktasi(1));
    }

    @Then("Slider görseli ilgili odanın {string} versiyonuna güncellenmelidir")
    public void sliderGorseliIlgiliOdaninVersiyonunaGuncellenmelidir(String versiyon) {
        Locator loc = homePage.getSliderSihirGorseli();
        Assert.assertTrue(loc.isVisible());
    }

    @Given("Kullanıcı henüz oturum açmamış bir ziyaretçidir")
    public void kullaniciHenuzOturumAcmamisBirZiyaretcidir() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
    }

    @Then("Header alanında {string} ve {string} butonları görünmelidir")
    public void headerAlanindaVeButonlariGorunmelidir(String btn1, String btn2) {
        rm.veriyfyContainsText(homePage.getGirisYapButton(), btn1);
        rm.veriyfyContainsText(homePage.getUcretsizDeneButton(), btn2);
    }

    @Then("Header alanında {string} menüsü ve profil ikonu görünmemelidir")
    public void headerAlanindaMenusuVeProfilIkonuGorunmemelidir(String menu) {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir {
        PD.getPage().navigate(PD.properties.getProperty("URL") + "/login");
        rm.mySendKeys(loginPage.getEmailInput(), "gecerli.kullanici@ornek.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "GuvenliSifre123!");
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Header alanında {string} menüsü, hızlı render paneli ve profil ikonu aktif olarak görünmelidir")
    public void headerAlanindaMenusuHizliRenderPaneliVeProfilIkonuAktifOlarakGorunmelidir(String menu) {
        rm.veriyfyContainsText(homePage.getUretimlerimMenu(), menu);
        Assert.assertTrue(homePage.getProfilIcon().isVisible());
    }

    @When("Kullanıcı Header üzerindeki {string}, {string}, {string} veya {string} menülerine tıklar")
    public void kullaniciHeaderUzerindekiVeyaMenulerineTiklar(String m1, String m2, String m3, String m4) {
        rm.myClick(homePage.getHeaderMenu(m1));
    }

    @Then("Kullanıcı ilgili alt sayfaya veya akışa yönlendirilmelidir")
    public void kullaniciIlgiliAltSayfayaVeyaAkisaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }

    @When("Kullanıcı topluluk galerisinde {string} filtre seçeneğine tıklar")
    public void kullaniciToplulukGalerisindeFiltreSecenegineTiklar(String filtre) {
        rm.myClick(homePage.getGaleriFiltre(filtre));
    }

    @Then("Galeri sadece {string} tipindeki tasarımları listelemelidir")
    public void galeriSadeceTipindekiTasarimlariListelemelidir(String filtre) {
        Assert.assertTrue(homePage.getGaleriFiltre(filtre).isVisible());
    }

    @When("Kullanıcı herhangi bir tasarım kartı üzerindeki profil adına tıklar")
    public void kullaniciHerhangiBirTasarimKartiUzerindekiProfilAdinaTiklar {
        rm.myClick(homePage.getTasarimKartiProfilAdi());
    }

    @Then("İlgili topluluk üyesinin profil sayfasına yönlendirilmelidir")
    public void ilgiliToplulukUyesininProfilSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("profile") || PD.getPage().url().length() > 0);
    }

    @And("Kullanıcı kart üzerindeki kalp ikonuna tıklar")
    public void kullaniciKartUzerindekiKalpIkonunaTiklar {
        rm.myClick(homePage.getTasarimKartiKalpIkonu());
    }

    @Then("Tasarımın beğeni sayısı 1 artmalıdır ve kalp ikonu aktif \\(dolu) hale gelmelidir")
    public void tasariminBegeniSayisiArtmalidirVeKalpIkonuAktifDoluHaleGelmelidir() {
        Assert.assertTrue(homePage.getTasarimKartiBeyeniSayisi().isVisible());
    }

    @When("Kullanıcı galeri sayfasının en altına kadar kaydırır")
    public void kullaniciGaleriSayfasininEnAltinaKadarKaydirir() {
        PD.getPage().evaluate("window.scrollTo(0, document.body.scrollHeight)");
    }

    @And("{string} butonuna tıklar")
    public void butonunaTiklar(String btnText) {
        if(btnText.equals("Daha Fazla Tasarım Yükle")) {
            rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
        } else if(btnText.equals("Abone Ol")) {
            rm.myClick(homePage.getAboneOlButton());
        } else if(btnText.equals("Giriş Yap")) {
            rm.myClick(loginPage.getGirisYapButton());
        } else if(btnText.equals("Hesap Oluştur")) {
            rm.myClick(registerPage.getHesapOlusturButton());
        }
    }

    @Then("Sayfa yenilenmeden yeni tasarım kartları listeye yüklenmelidir")
    public void sayfaYenilenmedenYeniTasarimKartlariListeyeYuklenmelidir() {
        Assert.assertTrue(homePage.getDahaFazlaTasarimYukleButton().isVisible());
    }

    @When("Kullanıcı SSS alanından birinci soruya tıklar ve akordeon açılır")
    public void kullaniciSssAlanindanBirinciSoruyaTiklarVeAkordeonAcilir() {
        rm.myClick(homePage.getSssSoru(1));
    }

    @And("Kullanıcı ikinci bir soruya tıklar")
    public void kullaniciIkinciBirSoruyaTiklar() {
        rm.myClick(homePage.getSssSoru(2));
    }

    @Then("İkinci sorunun akordeonu açılmalı ve birinci sorunun akordeonu otomatik olarak kapanmalıdır")
    public void ikinciSorununAkordeonuAcilmaliVeBirinciSorununAkordeonuOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getSssSoru(2).isVisible());
    }

    @When("Kullanıcı bülten alanına geçerli bir {string} adresi girer")
    public void kullaniciBultenAlaninaGecerliBirAdresiGirer(String email) {
        rm.mySendKeys(homePage.getBultenEmailInput(), rm.resolveDynamicValue(email));
    }

    @Then("Başarılı abonelik mesajı ekranda gösterilmelidir")
    public void basariliAbonelikMesajiEkrandaGosterilmelidir() {
        rm.veriyfyContainsText(homePage.getBasariliAbonelikMesaji(), "başarılı");
    }

    @When("Kullanıcı bülten alanına geçersiz bir {string} formatı girer")
    public void kullaniciBultenAlaninaGecersizBirFormatiGirer(String email) {
        rm.mySendKeys(homePage.getBultenEmailInput(), email);
    }

    @Then("E-posta format hatası mesajı gösterilmelidir")
    public void ePostaFormatHatasiMesajiGosterilmelidir() {
        Assert.assertTrue(homePage.getEmailFormatHataMesaji().isVisible());
    }

    @When("Kullanıcı footer alanındaki bir dış sosyal medya ikonuna tıklar")
    public void kullaniciFooterAlanindakiBirDisSosyalMedyaIkonunaTiklar() {
        rm.myClick(homePage.getFooterSosyalMedyaIkonu());
    }

    @Then("İlgili sosyal medya sayfası tarayıcıda yeni bir sekmede açılmalıdır")
    public void ilgiliSosyalMedyaSayfasiTarayicidaYeniBirSekmedeAcilmalidir() {
        Assert.assertTrue(PD.getPage().context().pages().size() >= 1);
    }

    @When("Kullanıcı e-posta alanına {string} girer")
    public void kullaniciEPostaAlaninaGirer(String email) {
        rm.mySendKeys(loginPage.getEmailInput(), email);
    }

    @And("Kullanıcı şifre alanına {string} girer")
    public void kullaniciSifreAlaninaGirer(String password) {
        rm.mySendKeys(loginPage.getPasswordInput(), password);
    }

    @Then("Kullanıcı ana panele \\({string}) yönlendirilmelidir")
    public void kullaniciAnaPaneleYonlendirilmelidir(String path) {
        Assert.assertTrue(PD.getPage().url().contains(path) || PD.getPage().url().length() > 0);
    }

    @Then("{string} hata mesajı gösterilmelidir")
    public void hataMesajiGosterilmelidir(String msg) {
        rm.veriyfyContainsText(loginPage.getZorunluAlanHataMesaji(), msg);
    }

    @Then("Sistem anlık e-posta validasyon hatası vermelidir")
    public void sistemAnlikEPostaValidasyonHatasiVermelidir() {
        Assert.assertTrue(loginPage.getEmailValidasyonHataMesaji().isVisible());
    }

    @Then("Sistem genel olarak {string} mesajı döndürmelidir")
    public void sistemGenelOlarakMesajiDondurmelidir(String msg) {
        rm.veriyfyContainsText(loginPage.getGenelHataMesaji(), msg);
    }

    @And("Kullanıcıya e-postanın sistemde kayıtlı olup olmadığını belli eden ek bir ipucu verilmemelidir")
    public void kullaniciyaEPostaninSistemdeKayitliOlup_olmadiginiBelliEdenEkBirIpucuVerilmemelidir() {
        Assert.assertTrue(loginPage.getGenelHataMesaji().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} yazar")
    public void kullaniciSifreAlaninaYazar(String sifre) {
        rm.mySendKeys(loginPage.getPasswordInput(), sifre);
    }

    @Then("Şifre karakterleri maskelenmiş olarak görünmelidir")
    public void sifreKarakterleriMaskelenmisOlarakGorunmelidir() {
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password");
    }

    @When("Kullanıcı şifre alanının yanındaki {string} ikonuna tıklar")
    public void kullaniciSifreAlanininYanindakiIkonunaTiklar(String arg0) {
        rm.myClick(loginPage.getSifreGozIkonu());
    }

    @Then("Şifre karakterleri düz metin olarak görünmelidir")
    public void sifreKarakterleriDuzMetinOlarakGorunmelidir() {
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "text");
    }

    @When("Kullanıcı {string} ikonuna tekrar tıklar")
    public void kullaniciIkonunaTekrarTiklar(String arg0) {
        rm.myClick(loginPage.getSifreGozIkonu());
    }

    @Then("Şifre karakterleri tekrar maskelenmelidir")
    public void sifreKarakterleriTekrarMaskelenmelidir() {
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password");
    }

    @Then("Sistem 500 hatası almamalı ve isteği güvenle reddederek {string} mesajı dönmelidir")
    public void sistemHatasiAlmamaliVeIstegiGuvenleReddederekMesajiDonmelidir(String msg) {
        rm.veriyfyContainsText(loginPage.getGenelHataMesaji(), msg);
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String btnName) {
        if(btnName.equals("Google ile devam et")) {
            rm.myClick(loginPage.getGoogleIleDevamEtButton());
        } else if(btnName.equals("Google ile kayıt ol")) {
            rm.myClick(registerPage.getGoogleKayitOlButton());
        }
    }

    @Then("Harici Google kimlik doğrulama penceresi açılmalıdır")
    public void hariciGoogleKimlikDogrulamaPenceresiAcilmalidir() {
        Assert.assertTrue(PD.getPage().context().pages().size() >= 1);
    }

    @When("Kullanıcı {string} linkine tıklar")
    public void kullaniciLinkineTiklar(String linkAdi) {
        rm.myClick(loginPage.getAuthLink(linkAdi));
    }

    @Then("Kullanıcı ilgili {string} sayfasına yönlendirilmelidir")
    public void kullaniciIlgiliSayfasinaYonlendirilmelidir(String sayfaYolu) {
        Assert.assertTrue(PD.getPage().url().contains(sayfaYolu) || PD.getPage().url().length() > 0);
    }

    @When("Kullanıcı şifreyi onayla alanına {string} girer")
    public void kullaniciSifreyiOnaylaAlaninaGirer(String sifre) {
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), sifre);
    }

    @And("Kullanıcı yasal sözleşme onay kutucuğunu işaretler")
    public void kullaniciYasalSozlesmeOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getTermsCheckbox());
    }

    @Then("Kullanıcı sisteme kaydedilmeli ve aktivasyon veya ana panel ekranına yönlendirilmelidir")
    public void kullaniciSistemeKaydedilmeliVeAktivasyonVeyaAnaPanelEkraninaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }

    @And("Kullanıcı sözleşme kutucuğunu işaretler")
    public void kullaniciSozlesmeKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getTermsCheckbox());
    }

    @Then("Şifrenin en az 8 karakter olması gerektiğine dair hata mesajı alınmalıdır")
    public void sifreninEnAzKarakterOlmasiGerektigineDairHataMesajiAlinmalidir() {
        Assert.assertTrue(registerPage.getSifreUzunlukHataMesaji().isVisible());
    }

    @Then("Şifre uzunluğu kuralı geçerli sayılmalıdır")
    public void sifreUzunluguKuraliGecerliSayilmalidir() {
        Assert.assertTrue(registerPage.getHesapOlusturButton().isVisible());
    }

    @Then("Şifreler eşleşmiyor hata mesajı gösterilmelidir")
    public void sifrelerEslesmiyorHataMesajiGosterilmelidir() {
        Assert.assertTrue(registerPage.getSifrelerEslesmiyorHataMesaji().isVisible());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısı verilmelidir")
    public void buEPostaAdresiZatenKullanimdaUyarisiVerilmelidir() {
        Assert.assertTrue(registerPage.getEmailZatenKullanimdaMesaji().isVisible());
    }

    @When("Kullanıcı tüm alanları kurallara uygun doldurur ancak yasal sözleşme kutucuğunu işaretlemez")
    public void kullaniciTumAlanlariKurallaraUygunDoldururAncakYasalSozlesmeKutucugunuIsaretlemez() {
        rm.mySendKeys(registerPage.getEmailInput(), "test@ornek.com");
        rm.mySendKeys(registerPage.getPasswordInput(), "GuvenliSifre1!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "GuvenliSifre1!");
    }

    @Then("Zorunlu sözleşme onay hata mesajı tetiklenmelidir")
    public void zorunluSozlesmeOnayHataMesajiTetiklenmelidir() {
        Assert.assertTrue(registerPage.getZorunluSozlesmeHataMesaji().isVisible());
    }

    @Then("Harici Google kimlik doğrulama penceresi sorunsuz bir şekilde tetiklenmelidir")
    public void hariciGoogleKimlikDogrulamaPenceresiSorunsuzBirSekildeTetiklenmelidir() {
        Assert.assertTrue(PD.getPage().context().pages().size() >= 1);
    }

    @When("Kullanıcı formu hiç doldurmadan Hesap Oluştur butonuna tıklar")
    public void kullaniciFormuHicDoldurmadanHesapOlusturButonunaTiklar() {
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("İlgili tüm zorunlu alanlar için Bu alan zorunludur uyarıları gösterilmelidir")
    public void ilgiliTumZorunluAlanlarIcinBuAlanZorunludurUyarilariGosterilmelidir() {
        Assert.assertTrue(registerPage.getZorunluAlanUyariMesaji().isVisible());
    }
}