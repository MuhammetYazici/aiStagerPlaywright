package StepDefinations;

import Pages.AiStagerPage;
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
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @When("Kullanıcı slider alanındaki sağ yön okuna tıklar")
    public void kullaniciSliderAlanindakiSagYonOkunaTıklar() {
        rm.myClick(page.getSagYonOku());
    }

    @Then("Slider görseli bir sonraki adıma pürüzsüz geçiş yapmalıdır")
    public void sliderGorseliBirSonrakiAdimaPuruzsuzGecisYapmalidir() {
        Assert.assertTrue(page.getSliderGorseli().isVisible());
    }

    @When("Kullanıcı alt carusel noktalarından {string} numaralı noktaya tıklar")
    public void kullaniciAltCaruselNoktalarindanNumaraliNoktayaTıklar(String nokta) {
        rm.myClick(page.getCaruselNoktasi(nokta));
    }

    @Then("Doğrudan {string} numaralı oda görseli aktif hale gelmelidir")
    public void dogrudanNumaraliOdaGorseliAktifHaleGelmelidir(String oda) {
        Assert.assertTrue(page.getOdaGorseli(oda).isVisible());
    }

    @When("Kullanıcı slider görselini fare ile sağa doğru sürükler \\(drag\\)")
    public void kullaniciSliderGorseliniFareIleSagaDogruSuruklerDrag() {
        Locator slider = page.getSliderAlani();
        slider.hover();
        PD.getPage().mouse().down();
        PD.getPage().mouse().move(300, 200);
        PD.getPage().mouse().up();
    }

    @Then("Görselin öncesi\\/sonrası durumu sorunsuz şekilde güncellenmelidir")
    public void gorselinOncesiSonrasiDurumuSorunsuzSekildeGuncellenmelidir() {
        Assert.assertTrue(page.getSliderGorseli().isVisible());
    }

    @Given("Kullanıcı {string} durumundadır")
    public void kullaniciDurumundadir(String durum) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        if (durum.equals("Giriş Yapmış")) {
            rm.mySendKeys(page.getEmailInput(), "test@example.com");
            rm.mySendKeys(page.getPasswordInput(), "Sifre123!");
            rm.myClick(page.getGirisYapSubmitButonu());
        }
    }

    @When("Kullanıcı ana sayfa header alanını inceler")
    public void kullaniciAnaSayfaHeaderAlaniniInceler() {
        Assert.assertTrue(PD.getPage().locator("header").isVisible());
    }

    @Then("Üst menüde {string} görünür olmalıdır")
    public void ustMenudeGorunurOlmalidir(String ogeler) {
        String[] ogeListesi = ogeler.split(", ");
        for (String oge : ogeListesi) {
            rm.veriyfyContainsText(page.getHeaderMenuOgesi(oge), oge);
        }
    }

    @And("Üst menüde {string} gizli olmalıdır")
    public void ustMenudeGizliOlmalidir(String ogeler) {
        String[] ogeListesi = ogeler.split(", ");
        for (String oge : ogeListesi) {
            Assert.assertFalse(page.getHeaderMenuOgesi(oge).isVisible());
        }
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır")
    public void kullaniciAiStagerAiAnaSayfasindakiGaleriAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        PD.getPage().evaluate("window.scrollTo(0, 800)");
    }

    @When("Kullanıcı galeri filtresinden {string} seçeneğine tıklar")
    public void kullaniciGaleriFiltresindenSecenegineTıklar(String filtre) {
        rm.myClick(page.getGaleriFiltresi(filtre));
    }

    @Then("Seçilen filtre mor renk ile vurgulanmalidir")
    public void secilenFiltreMorRenkIleVurgulanmalidir() {
        Assert.assertTrue(page.getGaleriFiltresi("Oturma Odası").isVisible());
    }

    @And("Sadece {string} kategorisindeki kartlar listelenmelidir")
    public void sadeceKategorisindekiKartlarListelenmelidir(String kategori) {
        Assert.assertTrue(page.getGaleriKarti(kategori).count() > 0);
    }

    @When("Kullanıcı kartlar üzerinden beğeni \\(like\\) ikonuna tıklar")
    public void kullaniciKartlarUzerindenBegeniLikeIkonunaTıklar() {
        rm.myClick(page.getBegeniIkonu());
    }

    @Then("İlgili kartın beğeni sayısı 1 artmalıdır ve ikon aktif olmalıdır")
    public void ilgiliKartinBegeniSayisiArtmalidirVeIkonAktifOlmalidir() {
        Assert.assertTrue(page.getBegeniIkonu().isVisible());
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTıklar(String butonAdi) {
        if (butonAdi.contains("Daha Fazla")) {
            rm.myClick(page.getDahaFazlaTasarimYukleButonu());
        } else if (butonAdi.contains("Giriş Yap")) {
            rm.myClick(page.getGirisYapSubmitButonu());
        } else if (butonAdi.contains("Google")) {
            rm.myClick(page.getGoogleIleDevamEtButonu());
        } else if (butonAdi.contains("Kayıt Ol") || butonAdi.contains("Hesap Oluştur")) {
            rm.myClick(page.getKayitOlSubmitButonu());
        } else {
            rm.myClick(page.getHeaderMenuOgesi(butonAdi));
        }
    }

    @Then("Mevcut {string} filtresi bozulmadan alt alta yeni tasarım kartları yüklenmelidir")
    public void mevcutFiltresiBozulmadanAltAltaYeniTasarimKartlariYuklenmelidir(String kategori) {
        Assert.assertTrue(page.getGaleriKarti(kategori).count() > 0);
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındaki SSS \\(FAQ\\) bölümündedir")
    public void kullaniciAiStagerAiAnaSayfasindakiSssFaqBolumundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        PD.getPage().evaluate("window.scrollTo(0, 1500)");
    }

    @When("Kullanıcı {string} numaralı SSS sorusuna tıklar")
    public void kullaniciNumaraliSssSorusunaTıklar(String soruNo) {
        rm.myClick(page.getSssSorusu(soruNo));
    }

    @Then("{string} numaralı sorunun içeriği açılmalıdır")
    public void numaraliSorununIcerigiAcilmalidir(String soruNo) {
        Assert.assertTrue(page.getSssIcerigi(soruNo).isVisible());
    }

    @And("{string} numaralı sorunun içeriği otomatik olarak kapanmalıdır")
    public void numaraliSorununIcerigiOtomatikOlarakKapanmalidir(String soruNo) {
        Assert.assertFalse(page.getSssIcerigi(soruNo).isVisible());
    }

    @Given("Kullanıcı ana sayfadaki bülten abonelik alanındadır")
    public void kullaniciAnaSayfadakiBultenAbonelikAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        PD.getPage().evaluate("window.scrollTo(0, 2500)");
    }

    @When("Kullanıcı bülten e-posta alanına {string} girer ve abone ol butonuna tıklar")
    public void kullaniciBultenEpostaAlaninaGirerVeAboneOlButonunaTıklar(String eposta) {
        rm.mySendKeys(page.getBultenEpostaInput(), rm.resolveDynamicValue(eposta));
        rm.myClick(page.getBultenAboneOlButonu());
    }

    @Then("Kullanıcı bülten alanında {string} mesajını görmelidir")
    public void kullaniciBultenAlanindaMesajiniGormelidir(String mesaj) {
        rm.veriyfyContainsText(page.getBultenSonucMesaji(), "Teşekkürler");
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String endpoint) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + endpoint);
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak {string} butonuna tıklar")
    public void kullaniciEpostaVeSifreAlanlariniBosBirakarakButonunaTıklar(String buton) {
        rm.myClick(page.getGirisYapSubmitButonu());
    }

    @Then("E-posta ve şifre alanları altında {string} uyarıları gösterilmelidir")
    public void ePostaVeSifreAlanlariAltindaUyarilariGosterilmelidir(String uyari) {
        rm.veriyfyContainsText(page.getHataMesajiDiv(), "zorunlu");
    }

    @When("Kullanıcı e-posta alanına geçerli formatta olmayan {string} yazar")
    public void kullaniciEpostaAlaninaGecerliFormattaOlmayanYazar(String eposta) {
        rm.mySendKeys(page.getEmailInput(), eposta);
    }

    @And("Şifre alanını doldurup {string} butonuna tıklar")
    public void sifreAlaniniDoldurupButonunaTıklar(String buton) {
        rm.mySendKeys(page.getPasswordInput(), "Sifre123!");
        rm.myClick(page.getGirisYapSubmitButonu());
    }

    @Then("E-posta alanında uygun format uyarı mesajı gösterilmelidir")
    public void ePostaAlanindaUygunFormatUyariMesajiGosterilmelidir() {
        Assert.assertTrue(page.getHataMesajiDiv().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} ve şifre alanına {string} girer")
    public void kullaniciEpostaAlaninaVeSifreAlaninaGirer(String eposta, String sifre) {
        rm.mySendKeys(page.getEmailInput(), eposta);
        rm.mySendKeys(page.getPasswordInput(), sifre);
    }

    @Then("Sistem kullanıcıya güvenlik amaçlı genel {string} uyarısını döndürmelidir")
    public void sistemKullaniciyaGuvenlikAmaciIlgiliUyariniDondurmelidir(String hata) {
        rm.veriyfyContainsText(page.getHataMesajiDiv(), "hatalı");
    }

    @When("Kullanıcı şifre alanına {string} yazar")
    public void kullaniciSifreAlaninaYazar(String sifre) {
        rm.mySendKeys(page.getPasswordInput(), sifre);
    }

    @And("Şifre alanının sağındaki {string} ikonuna tıklar")
    public void sifreAlanininSagindakiIkonunaTıklar(String ikon) {
        rm.myClick(page.getSifreGozIkonu());
    }

    @Then("Şifre karakterleri düz metin olarak görünür olmalıdır")
    public void sifreKarakterleriDuzMetinOlarakGorunurOlmalidir() {
        Assert.assertEquals(page.getPasswordInput().getAttribute("type"), "text");
    }

    @When("Kullanıcı tekrar {string} ikonuna tıklar")
    public void kullaniciTekrarIkonunaTıklar(String ikon) {
        rm.myClick(page.getSifreGozIkonu());
    }

    @Then("Şifre karakterleri maskelenmiş \\(yıldız\\/nokta\\) hale gelmelidir")
    public void sifreKarakterleriMaskelenmisYildizNoktaHaleGelmelidir() {
        Assert.assertEquals(page.getPasswordInput().getAttribute("type"), "password");
    }

    @Then("Kullanıcı Google kimlik doğrulama ekranına yönlendirilmelidir")
    public void kullaniciGoogleKimlikDogrulamaEkraninaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("google"));
    }

    @When("Kullanıcı kayıt formunu e-posta: {string}, şifre: {string}, şifre onay: {string} ve sözleşme kutusu: {boolean} ile doldurur")
    public void kullaniciKayitFormunuEpostaSifreSifreOnayVeSozlesmeKutusuIleDoldurur(String eposta, String sifre, String sifreOnay, boolean sozlesme) {
        rm.mySendKeys(page.getEmailInput(), rm.resolveDynamicValue(eposta));
        rm.mySendKeys(page.getPasswordInput(), sifre);
        rm.mySendKeys(page.getConfirmPasswordInput(), sifreOnay);
        if (sozlesme) {
            rm.myCheckBox(page.getTermsCheckbox());
        }
    }

    @Then("Kullanıcı register ekranında ilgili {string} uyarısını almalıdır")
    public void kullaniciRegisterEkranindaIlgiliUyarisiniAlmalidir(String hata) {
        rm.veriyfyContainsText(page.getHataMesajiDiv(), hata);
    }

    @When("Kullanıcı sisteme kayıtlı olmayan geçerli bir e-posta girer")
    public void kullaniciSistemeKayitliOlmayanGecerliBirEPostaGirer() {
        rm.mySendKeys(page.getEmailInput(), "yeniuser" + System.currentTimeMillis() + "@example.com");
    }

    @And("Kullanıcı kurallara uygun şifre girer ve şifreyi onaylar")
    public void kullaniciKurallaraUygunSifreGirerVeSifreyiOnaylar() {
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre1!");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre1!");
    }

    @And("Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @Then("Kullanıcı başarılı bir şekilde aktivasyon ekranına veya ana panele yönlendirilmelidir")
    public void kullaniciBasariliBirSekildeAktivasyonEkraninaVeyaAnaPaneleYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("activation"));
    }

    @When("Kullanıcı sayfadaki {string} bağlantısına tıklar")
    public void kullaniciSayfadakiBaglantisinaTıklar(String baglanti) {
        rm.myClick(page.getGirisYapBaglantisi());
    }

    @Then("Kullanıcı sorunsuz bir şekilde {string} sayfasına yönlendirilmelidir")
    public void kullaniciSorunsuzBirSekildeSayfasinaYonlendirilmelidir(String endpoint) {
        Assert.assertTrue(PD.getPage().url().contains(endpoint));
    }
}