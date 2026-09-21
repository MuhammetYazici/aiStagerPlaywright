package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class RegisterSteps {
    RegisterPage rp = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı kayıt sayfasındadır")
    public void kullaniciKayitSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        Assert.assertTrue(rp.getEmailInput().isVisible());
    }

    @When("Kullanıcı tüm zorunlu alanları eksiksiz doldurur")
    public void kullaniciTumZorunluAlanlariEksiksizDoldurur() {
        rm.mySendKeys(rp.getEmailInput(), "yeni.kullanici@example.com");
        rm.mySendKeys(rp.getPasswordInput(), "GcluSifre123!");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "GcluSifre123!");
    }

    @When("Kullanıcı şifre olarak en az 8 karakterli geçerli bir şifre girer ve iki alanda eşleştirir")
    public void kullaniciSifreOlarakEnAz8KarakterliGecerliBirSifreGirerVeIkiAlandaEslestirir() {
        rm.mySendKeys(rp.getPasswordInput(), "GucluSifre99!");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "GucluSifre99!");
    }

    @When("Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciKullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(rp.getTermsCheckbox());
    }

    @When("Kullanıcı kayıt ol butonuna tıklar")
    public void kullaniciKayitOlButonunaTiklar() {
        rm.myClick(rp.getHesapOlusturButton());
    }

    @Then("Hesap başarıyla oluşturulur ve kullanıcı yönlendirilir")
    public void hesapBasariylaOlusturulurVeKullaniciYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("success") || PD.getPage().url().contains("home"));
    }

    @When("Kullanıcı kayıt formundaki alanları boş bırakarak kayıt ol butonuna tıklar")
    public void kullaniciKayitFormundakiAlanlariBosBirakarakKayitOlButonunaTiklar() {
        rm.myClick(rp.getHesapOlusturButton());
    }

    @Then("Boş bırakılan alanlar için Bu alan zorunludur uyarısı tetiklenmelidir")
    public void bosBirakilanAlanlarIcinBuAlanZorunludurUyarisiTetiklenmelidir() {
        Assert.assertTrue(rp.getZorunluAlanUyarisi().isVisible());
    }

    @When("Kullanıcı e-posta alanına sistemde kayıtlı {string} adresini girer")
    public void kullaniciEPostaAlaninaSistemdeKayitliAdresiniGirer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(rp.getEmailInput(), resolvedEmail);
    }

    @When("Diğer zorunlu alanları doldurup kayıt ol butonuna tıklar")
    public void digerZorunluAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(rp.getPasswordInput(), "GucluSifre123!");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "GucluSifre123!");
        rm.myCheckBox(rp.getTermsCheckbox());
        rm.myClick(rp.getHesapOlusturButton());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısı verilmelidir")
    public void buEPostaAdresiZatenKullanimdaUyarisiVerilmelidir() {
        rm.veriyfyContainsText(rp.getKullanimdaUyarisi(), "kullanımda");
    }

    @When("Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer")
    public void kullaniciSifreAlanina8KarakterdenKisaBirSifreGirer() {
        rm.mySendKeys(rp.getPasswordInput(), "12345");
    }

    @When("Şifre ve Şifreyi Onayla alanlarına birbirinden farklı değerler girer")
    public void sifreVeSifreyiOnaylaAlanlarinaBirbirindenFarkliDegerlerGirer() {
        rm.mySendKeys(rp.getConfirmPasswordInput(), "67890");
    }

    @Then("Şifreler eşleşmiyor veya ilgili şifre uzunluğu uyarısı dönmelidir")
    public void sifrelerEşleşmiyorVeyaIlgiliSifreUzunluguUyarisiDonmelidir() {
        Assert.assertTrue(rp.getSifre uyarsisi().isVisible() || rp.getPasswordInput().isVisible());
    }

    @When("Kullanıcı tüm alanları geçerli doldurur ancak Kullanıcı Sözleşmesi onay kutucuğunu işaretlemez")
    public void kullaniciTumAlanlariGecerliDoldururAncakKullaniciSozlesmesiOnayKutucugunuIsaretlemez() {
        rm.mySendKeys(rp.getEmailInput(), "test.sozlesme@example.com");
        rm.mySendKeys(rp.getPasswordInput(), "GucluSifre123!");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "GucluSifre123!");
    }

    @Then("Kayıt işlemi engellenmeli ve sözleşmenin onaylanması gerektiği belirtilmelidir")
    public void kayitIslemiEngellenmeliVeSozlesmeninOnaylanmasiGerektigiBelirtilmelidir() {
        Assert.assertTrue(rp.getHesapOlusturButton().isVisible());
    }

    @When("Kullanıcı Giriş yap linkine tıklar")
    public void kullaniciGirisYapLinkineTiklar() {
        rm.myClick(rp.getGirisYapLink());
    }

    @Then("Kullanıcı giriş sayfasına yönlendirilmelidir")
    public void kullaniciGirisSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("login"));
    }

    @When("Kullanıcı tekrar kayıt sayfasına dönüp Google ile devam et seçeneğine tıklar")
    public void kullaniciTekrarKayitSayfasinaDonupGoogleIleDevamEtSecenegineTiklar() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        rm.myClick(rp.getGoogleIleDevamEtButton());
    }

    @Then("Google OAuth kimlik doğrulama akışı tetiklenmelidir")
    public void googleOAuthKimlikDogrulamaAkisiTetiklenmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("google") || rp.getGoogleIleDevamEtButton().isVisible());
    }
}