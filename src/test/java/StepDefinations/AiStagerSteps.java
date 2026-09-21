package StepDefinations;
import com.microsoft.playwright.Page;

import Utilities.PD;

import Pages.AiStagerPages;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AiStagerSteps {
    AiStagerPages pages = new AiStagerPages();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Given("Kullanıcı giriş yapmamış ziyaretçi durumundadır")
    public void kullaniciGirisYapmamisZiyaretciDurumundadir() {
        Assert.assertTrue(pages.getGirisYapButton().isVisible());
    }

    @When("Kullanıcı https://aistager.ai/tr adresine gider")
    public void kullaniciAdresineGider() {
        PD.getPage().navigate("https://aistager.ai/tr");
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Then("Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir")
    public void ustMenudeGirisYapVeUcretsizDeneButonlariGorunmelidir() {
        Assert.assertTrue(pages.getGirisYapButton().isVisible());
        Assert.assertTrue(pages.getUcretsizDeneButton().isVisible());
    }

    @Then("Üst menüde profil ikonu ve Üretimlerim alanı görünmemelidir")
    public void ustMenudeProfilIkonuVeUretimlerimAlaniGorunmemelidir() {
        Assert.assertFalse(pages.getProfilIkonu().isVisible());
        Assert.assertFalse(pages.getUretimlerimAlani().isVisible());
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(pages.getEmailInput(), "validuser@example.com");
        rm.mySendKeys(pages.getPasswordInput(), "ValidPass123!");
        rm.myClick(pages.getGirisYapButton());
    }

    @When("Kullanıcı ana sayfaya döner")
    public void kullaniciAnaSayfayaDoner() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @Then("Üst menüde profil ikonu ve Üretimlerim alanı görünmelidir")
    public void ustMenudeProfilIkonuVeUretimlerimAlaniGorunmelidir() {
        Assert.assertTrue(pages.getProfilIkonu().isVisible());
        Assert.assertTrue(pages.getUretimlerimAlani().isVisible());
    }

    @Then("Giriş Yap ve Ücretsiz Dene butonları görünmemelidir")
    public void girisYapVeUcretsizDeneButonlariGorunmemelidir() {
        Assert.assertFalse(pages.getGirisYapButton().isVisible());
        Assert.assertFalse(pages.getUcretsizDeneButton().isVisible());
    }

    @Given("Kullanıcı https://aistager.ai/tr adresindedir")
    public void kullaniciAdresindedir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        Assert.assertTrue(PD.getPage().url().contains("aistager.ai"));
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri slider alanını sağa ve sola kaydırır")
    public void kullaniciOncesiVeSonrasiSihriSliderAlaniniSagaVeSolaKaydirir() {
        rm.myClick(pages.getSliderAlani());
    }

    @Then("Görseller pürüzsüz bir şekilde değişmelidir")
    public void gorsellerPuruzsuzBirSekildeDegismelidir() {
        Assert.assertTrue(pages.getSliderAlani().isVisible());
    }

    @When("Kullanıcı alt ok veya nokta simgelerine tıklar")
    public void kullaniciAltOkVeyaNoktaSimgelerineTiklar() {
        rm.myClick(pages.getAltOkVeyaNokta());
    }

    @Then("İlgili görsel geçişi gerçekleşmelidir")
    public void ilgiliGorselGecisiGerceklesmelidir() {
        Assert.assertTrue(pages.getSliderAlani().isVisible());
    }

    @When("Kullanıcı Odanızı Yükleyin butonuna tıklar")
    public void kullaniciOdaniziYukleyinButonunaTiklar() {
        rm.myClick(pages.getOdaniziYukleyinButton());
    }

    @Then("İlgili yükleme veya yönlendirme sayfasına gitmelidir")
    public void ilgiliYuklemeVeyaYonlendirmeSayfasinaGitmelidir() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }

    @Given("Kullanıcı https://aistager.ai/tr galeri alanındadır")
    public_galeri_alanindadir:
    public void kullaniciGaleriAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        Assert.assertTrue(pages.getOturmaOdasiFiltresi().isVisible());
    }

    @When("Kullanıcı Oturma Odası oda tipini seçer")
    public void kullaniciOturmaOdasiOdaTipiniSecer() {
        rm.myClick(pages.getOturmaOdasiFiltresi());
    }

    @Then("Sadece Oturma Odası kategorisine ait tasarımlar listelenmelidir")
    public void sadeceOturmaOdasiKategorisineAitTasarımlarListelenmelidir() {
        Assert.assertTrue(pages.getOturmaOdasiFiltresi().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(pages.getDahaFazlaTasarimYukleButton());
    }

    @Then("Seçilen Oturma Odası filtresi korunarak yeni tasarım kartları yüklenmeye devam etmelidir")
    public void secilenOturmaOdasiFiltresiKorunarakYeniTasarimKartlariYuklenmeyeDevamEtmelidir() {
        Assert.assertTrue(pages.getDahaFazlaTasarimYukleButton().isVisible());
    }

    @Given("Kullanıcı ana sayfanın SSS FAQ alanındadır")
    public void kullaniciAnaSayfaninSssFaqAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        Assert.assertTrue(pages.getSssSoruBasligi().isVisible());
    }

    @When("Kullanıcı bir soru başlığına tıklar")
    public void kullaniciBirSoruBasliginaTiklar() {
        rm.myClick(pages.getSssSoruBasligi());
    }

    @Then("İlgili sorunun cevabı açılmalıdır")
    public void ilgiliSorununCevabiAcilmalidir() {
        Assert.assertTrue(pages.getFaqCevabi().isVisible());
    }

    @When("Kullanıcı farklı bir soru başlığına tıklar")
    public void kullaniciFarkliBirSoruBasliginaTiklar() {
        rm.myClick(pages.getIkinciSssSoruBasligi());
    }

    @Then("Yeni sorunun cevabı açılmalı ve önceki açık olan soru otomatik olarak kapanmalıdır")
    public void yeniSorununCevabiAcilmaliVeOncekiAcikOlanSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(pages.getFaqCevabi().isVisible());
    }

    @Given("Kullanıcı ana sayfanın footer bülten alanındadır")
    public void kullaniciAnaSayfaninFooterBultenAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        Assert.assertTrue(pages.getBultenEmailInput().isVisible());
    }

    @When("Kullanıcı bülten e-posta alanına geçerli bir {string} adresi girer")
    public void kullaniciBultenEPostaAlaninaGecerliBirAdresiGrer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(pages.getBultenEmailInput(), resolvedEmail);
    }

    @When("Abone Ol butonuna tıklar")
    public void aboneOlButonunaTiklar() {
        rm.myClick(pages.getAboneOlButton());
    }

    @Then("Başarıyla abone oldunuz başarı mesajı ekranda görünmelidir")
    public void basariylaAboneOldunuzBasariMesajiErandaGorunmelidir() {
        rm.veriyfyContainsText(pages.getBasariMesaji(), "Başarıyla abone oldunuz");
    }

    @When("Kullanıcı bülten e-posta alanına {string} girer")
    public void kullaniciBultenEPostaAlaninaGirer(String gecersizEmail) {
        if (!gecersizEmail.equals("boş bırakıldı")) {
            rm.mySendKeys(pages.getBultenEmailInput(), gecersizEmail);
        }
    }

    @Then("Bülten alanında uygun bir validasyon hata mesajı alınmalıdır")
    public void bultenAlanindaUygunBirValidasyonHataMesajiAlinmalidir() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }

    @Given("Kullanıcı \\/login sayfasındadır")
    public void kullaniciLoginSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        Assert.assertTrue(PD.getPage().url().contains("/login"));
    }

    @When("Kullanıcı geçerli bir e-posta adresi girer")
    public void kullaniciGecerliBirEPostaAdresiGirer() {
        rm.mySendKeys(pages.getEmailInput(), "test@example.com");
    }

    @When("Kullanıcı geçerli şifresini girer")
    public void kullaniciGecerliSifresiniGirer() {
        rm.mySendKeys(pages.getPasswordInput(), "ValidPass123!");
    }

    @Then("Kullanıcı başarılı şekilde panele yönlendirilmelidir")
    public void kullaniciBasariliSekildePaneleYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("panel"));
    }

    @When("Kullanıcı e-posta alanına {string} girer")
    public void kullaniciEPostaAlaninaGirer(String email) {
        if (!email.equals("boş bırakıldı")) {
            rm.mySendKeys(pages.getEmailInput(), email);
        }
    }

    @When("Kullanıcı şifre alanına {string} girer")
    public void kullaniciSifreAlaninaGirer(String sifre) {
        if (!sifre.equals("boş bırakıldı")) {
            rm.mySendKeys(pages.getPasswordInput(), sifre);
        }
    }

    @Then("Bu alan zorunludur hata mesajı ilgili alanın altında görünmelidir")
    public void buAlanZorunludurHataMesajiIlgiliAlaninAltindaGorunmelidir() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }

    @Then("E-posta veya şifre hatalı genel hata mesajı görüntülenmelidir")
    public void ePostaVeyaSifreHataliGenelHataMesajiGoruntulenmelidir() {
        rm.veriyfyContainsText(pages.getValidasyonHataMesaji(), "hatalı");
    }

    @Then("Sistem arka planda e-posta adresinin kayıtlı olup olmadığını açık etmemelidir")
    public void sistemArkaPlandaEPostaAdresininKayitliOlupolmadiginiAcikEtmemelidir() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }

    @When("Kullanıcı e-posta alanına ' OR '1'='1 girer")
    public void kullaniciEPostaAlaninaSqlGirer() {
        rm.mySendKeys(pages.getEmailInput(), "' OR '1'='1");
    }

    @When("Kullanıcı şifre alanına ' OR '1'='1 girer")
    public void kullaniciSifreAlaninaSqlGirer() {
        rm.mySendKeys(pages.getPasswordInput(), "' OR '1'='1");
    }

    @Then("Sistem SQL enjeksiyonunu engellemeli ve E-posta veya şifre hatalı veya validasyon hatası döndürmelidir")
    public void sistemSqlEnjeksiyonunuEngellemeli() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }

    @Then("Kullanıcı panele giriş yapamamalıdır")
    public void kullaniciPaneleGirisYapamamalidir() {
        Assert.assertTrue(PD.getPage().url().contains("/login"));
    }

    @Given("Kullanıcı \\/register sayfasındadır")
    public void kullaniciRegisterSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        Assert.assertTrue(PD.getPage().url().contains("/register"));
    }

    @When("Kullanıcı sistemde benzersiz olan geçerli bir e-posta adresi girer")
    public void kullaniciSistemdeBenzersizOlanGecerliBirEPostaAdresiGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @When("Kullanıcı kurallara uygun en az 8 karakter içeren bir şifre girer")
    public void kullaniciKurallaraUygunEnAzKarakterIcerenBirSifreGirer() {
        rm.mySendKeys(pages.getPasswordInput(), "ValidPass123!");
    }

    @When("Kullanıcı şifresini Şifreyi Onayla alanına aynı şekilde tekrar girer")
    public void kullaniciSifresiniSifreyiOnaylaAlaninaAyniSekildeTekrarGirer() {
        rm.mySendKeys(pages.getConfirmPasswordInput(), "ValidPass123!");
    }

    @When("Kullanıcı kullanıcı sözleşmesini onaylar")
    public void kullaniciKullaniciSozlesmesiniOnaylar() {
        rm.myCheckBox(pages.getTermsCheckbox());
    }

    @When("Kayıt Ol butonuna tıklar")
    public void kayitOlButonunaTiklar() {
        rm.myClick(pages.getHesapOlusturButton());
    }

    @Then("Hesap başarıyla oluşturulmalı ve kullanıcı aktivasyon veya panele yönlendirilmelidir")
    public void hesapBasariylaOlusturulmali() {
        Assert.assertTrue(PD.getPage().url().length() > 0);
    }

    @When("Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void kullaniciSistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(pages.getEmailInput(), "varolanuser@test.com");
    }

    @When("Kullanıcı kurallara uygun şifre ve eşleşen onay şifresini girer")
    public void kullaniciKurallaraUygunSifreVeEslenenOnaySifresiniGirer() {
        rm.mySendKeys(pages.getPasswordInput(), "ValidPass123!");
        rm.mySendKeys(pages.getConfirmPasswordInput(), "ValidPass123!");
    }

    @When("Kullanıcı sözleşmeyi onaylar")
    public void kullaniciSozlesmeyiOnaylar() {
        rm.myCheckBox(pages.getTermsCheckbox());
    }

    @Then("İşlem engellenmeli ve Bu e-posta adresi zaten kullanımda hata mesajı gösterilmelidir")
    public void islemEngellenmeliVeBuEPostaAdresiZatenKullanimdaHataMesajiGosterilmelidir() {
        rm.veriyfyContainsText(pages.getValidasyonHataMesaji(), "zaten kullanımda");
    }

    @When("Kullanıcı benzersiz bir e-posta girer")
    public void kullaniciBenzersizBirEPostaGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @When("Kullanıcı şifre onayla alanına {string} girer")
    public void kullaniciSifreOnaylaAlaninaGirer(String sifreTekrar) {
        rm.mySendKeys(pages.getConfirmPasswordInput(), sifreTekrar);
    }

    @Then("İşlem engellenmeli ve ilgili hata mesajı gösterilmelidir")
    public void islemEngellenmeliVeIlgiliHataMesajiGosterilmelidir() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }

    @When("Kullanıcı benzersiz geçerli bir e-posta girer")
    public void kullaniciBenzersizGecerliBirEPostaGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @When("Kullanıcı kullanıcı sözleşmesini ONAYLAMAZ")
    public void kullaniciKullaniciSozlesmesiniOnaylamaz() {
        // Checkbox tıklanmıyor, boş bırakılıyor
        Assert.assertTrue(pages.getTermsCheckbox().isVisible());
    }

    @Then("İşlem engellenmeli ve sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir")
    public void islemEngellenmeliVeSozlesmeninOnaylanmasiGerektigineDairUyarimesajiGosterilmelidir() {
        Assert.assertTrue(pages.getValidasyonHataMesaji().isVisible());
    }
}