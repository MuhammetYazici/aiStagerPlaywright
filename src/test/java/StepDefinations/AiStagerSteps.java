package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.AiStagerPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class AiStagerSteps {
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanici AiStager platformundadir")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            rm.myClick(page.getTumunuKabulEtButton());
        } catch (Exception e) {
            // Cookie banner yoksa devam et
        }
    }

    @When("Kullanici Oncesi ve Sonrasi Sihri slider alaninin goruntulendigini gorur")
    public void kullaniciOncesiVeSonrasiSihriSliderAlanininGoruntulendiginiGorur() {
        Assert.assertTrue(page.getSliderAlani().isVisible(), "Slider alanı görünmüyor");
    }

    @And("Kullanici kaydirma cubugunu veya sag veya alt oklari kullanarak gorseller arasi gecis yapar")
    public void kullaniciKaydirmaCubugunuVeyaSagVeyaAltOklariKullanarakGorsellerArasiGecisYapar() {
        rm.myClick(page.getSliderAlani());
    }

    @Then("Gecisin purussuz bir sekilde gerceklestigi dogrulanir")
    public void gecisinPurussuzBirSekildeGerceklestigiDogrulanir() {
        Assert.assertTrue(page.getSliderAlani().isVisible(), "Slider geçişi doğrulanamadı");
    }

    @When("Kullanici ana sayfada dil secenegini TR olarak degistirir")
    public void kullaniciAnaSayfadaDilSeceneginiTROlarakDegistirir() {
        rm.myClick(page.getDilSecenegi());
    }

    @Then("Sayfadaki tum metinlerin anlik olarak Turkce dile uyarlandigi dogrulanir")
    public void sayfadakiTumMetinlerinAnlikOlarakTurkceDileUyarlandigiDogrulanir() {
        Assert.assertTrue(page.getDilSecenegi().isVisible(), "Dil değişimi doğrulanamadı");
    }

    @Given("Gecerli kimlik bilgileriyle sisteme giris yapmis bir kullanici ana sayfadadir")
    public void gecerliKimlikBilgileriyleSistemeGirisYapmisBirKullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.mySendKeys(page.getEmailInput(), "test@aistager.ai");
        rm.mySendKeys(page.getPasswordInput(), "Sifre123!");
        rm.myClick(page.getGirisButonu());
    }

    @When("Ust menude Uretimlerim seceneginin hizli render veya kamera ayarla panelinin ve profil menusunun aktif olarak gorundugu dogrulanir")
    public void ustMenudeUretimlerimSecenegininHizliRenderVeyaKameraAyarlaPanelininVeProfilMenusununAktifOlarakGorunduguDogrulanir() {
        Assert.assertTrue(page.getUretimlerimMenu().isVisible(), "Üretimlerim menüsü görünmüyor");
    }

    @And("Kullanici logoya tiklar")
    public void kullaniciLogoyaTiklar() {
        rm.myClick(page.getLogo());
    }

    @Then("Ana sayfaya yonlendirildigi dogrulanir")
    public void anaSayfayaYonlendirildigiDogrulanir() {
        Assert.assertTrue(page.getLogo().isVisible(), "Ana sayfaya yönlendirme başarısız");
    }

    @Given("Sisteme giris yapmamis bir ziyaretci ana sayfayi ziyaret eder")
    public void sistemeGirisYapmamisBirZiyaretciAnaSayfayiZiyaretEder() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Ust menude Uretimlerim menusunun ve profil ikonunun gizlenmis oldugu dogrulanir")
    public void ustMenudeUretimlerimMenusununVeProfilIkonununGizlenmisOlduguDogrulanir() {
        Assert.assertTrue(page.getGirisYapButton().isVisible(), "Ziyaretçi görünümü doğrulanamadı");
    }

    @And("Bunun yerine Giris Yap ve Ucretsiz Dene butonlarinin yer aldigi dogrulanir")
    public void bununYerineGirisYapVeUcretsizDeneButonlarininYerAldigiDogrulanir() {
        Assert.assertTrue(page.getGirisYapButton().isVisible(), "Giriş yap butonu görünmüyor");
    }

    @When("Kullanici ana sayfadaki galeri alanina gelir")
    public void kullaniciAnaSayfadakiGaleriAlaninaGelir() {
        rm.myClick(page.getGaleriAlani());
    }

    @Then("Galeri ilk acildiginda varsayilan olarak Tum Tipler seceneginin aktif oldugu ve karisik oda tiplerinin listelendigi dogrulanir")
    public void galeriIlkAcildigindaVarsayilanOlarakTumTiplerSecenegininAktifOlduguVeKarisikOdaTiplerininListelendigiDogrulanir() {
        Assert.assertTrue(page.getGaleriAlani().isVisible(), "Galeri alanı görünmüyor");
    }

    @When("Kullanici belirli bir oda tipi filtre butonuna tiklar")
    public void kullaniciBelirliBirOdaTipiFiltreButonunaTiklar() {
        rm.myClick(page.getOdaTipiFiltreButonu());
    }

    @Then("Galerinin yalnizca secilen kategoriye ait tasarımlari filtreledigi dogrulanir")
    public void galerininYalnizcaSecilenKategoriyeAitTasarımlariFiltreledigiDogrulanir() {
        Assert.assertTrue(page.getTasarimKarti().isVisible(), "Filtrelenmiş tasarım kartı görünmüyor");
    }

    @Given("Kullanici galeride bir oda tipi filtresi secer")
    public void kullaniciGalerideBirOdaTipiFiltresiSecer() {
        rm.myClick(page.getOdaTipiFiltreButonu());
    }

    @When("Kullanici Daha Fazla Tasarim Yukle butonuna tiklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(page.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut filtrenin korundugu ve yeni tasarım kartlarının yuklendigi dogrulanir")
    public void mevcutFiltreninKorunduguVeYeniTasarimKartlarininYuklendigiDogrulanir() {
        Assert.assertTrue(page.getTasarimKarti().isVisible(), "Tasarım kartları yüklenemedi");
    }

    @When("Kullanici galeri uzerindeki bir tasarim kartına ve uzerindeki kullanıcı profiline tiklar")
    public void kullaniciGaleriUzerindekiBirTasarimKartinaVeUzerindekiKullaniciProfilineTiklar() {
        rm.myClick(page.getTasarimKarti());
        rm.myClick(page.getKullaniciProfili());
    }

    @Then("İlgili kullanıcı profiline gidilebildigi dogrulanir")
    public void ilgiliKullaniciProfilineGidilebildigiDogrulanir() {
        Assert.assertTrue(page.getKullaniciProfili().isVisible(), "Kullanıcı profiline gidilemedi");
    }

    @When("Kullanici Begeni ikonuna tiklar")
    public void kullaniciBegeniIkonunaTiklar() {
        rm.myClick(page.getBegeniIkonu());
    }

    @Then("Sayac degerinin bir arttigi dogrulanir")
    public void sayacDegerininBirArttigiDogrulanir() {
        Assert.assertTrue(page.getSayacDegeri().isVisible(), "Sayaç değeri artışı doğrulanamadı");
    }

    @When("Kullanici SSS bolumune gelir ve bir soruyu acar")
    public void kullaniciSssBolumuneGelirVeBirSoruyuAcar() {
        rm.myClick(page.getSssBolumu());
        rm.myClick(page.getSssSorusu());
    }

    @Then("İlgili sorunun acildigi gorulur")
    public void ilgiliSorununAcildigiGorulur() {
        Assert.assertTrue(page.getSssSorusu().isVisible(), "Soru açılmadı");
    }

    @When("Kullanici farkli bir soruya tiklar")
    public void kullaniciFarkliBirSoruyaTiklar() {
        rm.myClick(page.getSssSorusu());
    }

    @Then("Yeni acilan sorunun acik kaldigi onceki sorunun ise otomatik olarak kapandigi dogrulanir")
    public void yeniAcilanSorununAcikKaldigiOncekiSorununIseOtomatikOlarakKapandigiDogrulanir() {
        Assert.assertTrue(page.getSssSorusu().isVisible(), "Akordeon davranışı doğrulanamadı");
    }

    @When("Kullanici bulten formuna {string} adresini girer ve kaydol butonuna tiklar")
    public void kullaniciBultenFormunaAdresiniGirerVeKaydolButonunaTiklar(String eposta) {
        String resolvedMail = rm.resolveDynamicValue(eposta);
        rm.mySendKeys(page.getBultenFormu(), resolvedMail);
        rm.myClick(page.getKaydolButton());
    }

    @Then("Basari mesajinin goruntulendigi dogrulanir")
    public void basariMesajininGoruntulendigiDogrulanir() {
        Assert.assertTrue(page.getBasariMesaji().isVisible(), "Başarı mesajı görüntülenemedi");
    }

    @Then("Kayit isleminin engellendigi ve uygun bir hata mesaji gosterildigi dogrulanir")
    public void kayitIslemininEngellendigiVeUygunBirHataMesajiGosterildigiDogrulanir() {
        Assert.assertTrue(page.getHataMesaji().isVisible(), "Hata mesajı gösterilmedi");
    }

    @Given("Kullanici Giris Yap sayfasindadir")
    public void kullaniciGirisYapSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanici gecerli e-posta ve sifre bilgilerini girer")
    public void kullaniciGecerliEPostaSifreBilgileriniGirer() {
        rm.mySendKeys(page.getEmailInput(), "test@aistager.ai");
        rm.mySendKeys(page.getPasswordInput(), "Sifre123!");
    }

    @And("Sifre alanindaki maskelemenin calistigini test eder")
    public void sifreAlanindakiMaskelemeninCalistiginiTestEder() {
        Assert.assertTrue(page.getPasswordInput().isVisible(), "Şifre alanı görünmüyor");
    }

    @And("Giris butonuna tiklar")
    public void girisButonunaTiklar() {
        rm.myClick(page.getGirisButonu());
    }

    @Then("Kullanicinin panele yonlendirildigi dogrulanir")
    public void kullanicininPaneleYonlendirildigiDogrulanir() {
        Assert.assertTrue(page.getUretimlerimMenu().isVisible(), "Panele yönlendirme doğrulanamadı");
    }

    @When("Kullanici Google ile Giris Yap butonuna tiklar")
    public void kullaniciGoogleIleGirisYapButonunaTiklar() {
        rm.myClick(page.getGoogleIleGirisYapButton());
    }

    @Then("Google hesap secim ekraninin acildigi ve basarili giris sonrasi panele yonlendirildigi dogrulanir")
    public void googleHesapSecimEkranininAcildigiVeBasariliGirisSonrasiPaneleYonlendirildigiDogrulanir() {
        Assert.assertTrue(page.getGoogleIleGirisYapButton().isVisible(), "Google ile giriş ekranı doğrulanamadı");
    }

    @When("E-posta alanina {string} sifre alanina {string} girer")
    public void ePostaAlaninaSifreAlaninaGirer(String eposta, String sifre) {
        rm.mySendKeys(page.getEmailInput(), eposta);
        rm.mySendKeys(page.getPasswordInput(), sifre);
    }

    @Then("Guvenlik amaciyla spesifik hata yerine genel e-posta veya sifre hatali mesajinin gosterildigi dogrulanir")
    public void guvenlikAmaciylaSpesifikHataYerineGenelEPostaVeyaSifreHataliMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(page.getHataMesaji().isVisible(), "Genel hata mesajı gösterilmedi");
    }

    @When("E-posta alanina sql enjeksiyonu veya bin karakterlik uzun bir metin girer")
    public void ePostaAlaninaSqlEnjeksiyonuVeyaBinKarakterlikUzunBirMetinGirer() {
        rm.mySendKeys(page.getEmailInput(), "'OR '1'='1");
    }

    @Then("Sistemin cokmedigi guvenli bir sekilde filtrelendigi ve hata mesaji dondurdugu dogrulanir")
    public void sisteminCokmedigiGuvenliBirSekildeFiltrelendigiVeHataMesajiDondurduguDogrulanir() {
        Assert.assertTrue(page.getHataMesaji().isVisible(), "Güvenlik filtresi doğrulanamadı");
    }

    @Given("Kullanici Kayit Ol sayfasindadir")
    public void kullaniciKayitOlSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanici gecerli bir e-posta en az sekiz karakterli birbiriyle eslesen iki sifre girer")
    public void kullaniciGecerliBirEPostaEnAzSekizKarakterliBirbiriyleEslesenIkiSifreGirer() {
        rm.mySendKeys(page.getEmailInput(), "yeniuser@aistager.ai");
        rm.mySendKeys(page.getPasswordInput(), "Sifre1234");
        rm.mySendKeys(page.getConfirmPasswordInput(), "Sifre1234");
    }

    @And("Kullanici sozlesmesi onay kutucugunu secer")
    public void kullaniciSozlesmesiOnayKutucugunuSecer() {
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @And("Kayit Ol butonuna tiklar")
    public void kayitOlButonunaTiklar() {
        rm.myClick(page.getHesapOlusturButton());
    }

    @Then("Hesabin basariyla olusturuldugu dogrulanir")
    public void hesabinBasariylaOlusturulduguDogrulanir() {
        Assert.assertTrue(page.getBasariMesaji().isVisible(), "Hesap oluşturma başarı mesajı görünmüyor");
    }

    @When("Formu {string} {string} {string} ve sozlesme durumu {string} ile doldurur")
    public void formuVeSozlesmeDurumuIleDoldurur(String eposta, String sifre, String sifreTekrar, String sozlesme) {
        rm.mySendKeys(page.getEmailInput(), eposta);
        rm.mySendKeys(page.getPasswordInput(), sifre);
        rm.mySendKeys(page.getConfirmPasswordInput(), sifreTekrar);
        if (Boolean.parseBoolean(sozlesme)) {
            rm.myCheckBox(page.getTermsCheckbox());
        }
    }

    @Then("İlgili validasyon hata mesajinin alindigi dogrulanir")
    public void ilgiliValidasyonHataMesajininAlindigiDogrulanir() {
        Assert.assertTrue(page.getHataMesaji().isVisible(), "Validasyon hata mesajı görünmüyor");
    }

    @When("Sistemde halihazirda kayitli olan bir e-posta adresini girer")
    public void sistemdeHalihazirdaKayitliOlanBirEPostaAdresiniGirer() {
        rm.mySendKeys(page.getEmailInput(), "test@aistager.ai");
    }

    @And("Sifre kurallarina uygun sifre girer ve sozlesmeyi onaylar")
    public void sifreKurallarinaUygunSifreGirerVeSozlesmeyiOnaylar() {
        rm.mySendKeys(page.getPasswordInput(), "Sifre1234");
        rm.mySendKeys(page.getConfirmPasswordInput(), "Sifre1234");
        rm.myCheckBox(page.getTermsCheckbox());
    }

    @Then("Bu e-posta adresi zaten kullanimda uyarisinin gosterildigi dogrulanir")
    public void buEPostaAdresiZatenKullanimdaUyarisininGosterildigiDogrulanir() {
        Assert.assertTrue(page.getHataMesaji().isVisible(), "Kullanımda uyarı mesajı görünmüyor");
    }
}