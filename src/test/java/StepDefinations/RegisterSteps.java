package StepDefinations;

import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterSteps {
    RegisterPage rp = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı kayıt ol sayfasındadır {string}")
    public void kullaniciKayitOlSayfasindadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + arg0);
    }

    @When("Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta adresi girer")
    public void kullaniciSistemdeKayitliOlmayanGecerliBirEPostaAdresiGirer() {
        rm.mySendKeys(rp.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @When("En az 8 karakterden oluşan güçlü bir şifre belirler ve şifreyi onaylar")
    public void enAzKarakterdenOlusanGucluBirSifreBelirlerVeSifreyiOnaylar() {
        String pass = "StrongPass123";
        rm.mySendKeys(rp.getPasswordInput(), pass);
        rm.mySendKeys(rp.getConfirmPasswordInput(), pass);
    }

    @When("Kullanıcı sözleşmesi onay kutucuğunu seçer")
    public void kullaniciSozlesmesiOnayKutucugunuSecer() {
        rm.myCheckBox(rp.getTermsCheckbox());
    }

    @When("{string} butonuna tıklar")
    public void butonunaTiklar(String arg0) {
        rm.myClick(rp.getRegisterButton());
    }

    @Then("Kullanıcı başarıyla kaydedilmeli ve aktivasyon veya ana panele yönlendirilmelidir")
    public void kullaniciBasariylaKaydedilmeliVeAktivasyonVeyaAnaPaneleYonlendirilmelidir() {
        rm.veriyfyContainsText(rp.getSuccessNotification(), "başarıyla");
    }

    @Given("Kullanıcı kayıt ol sayfasındadır")
    public void kullaniciKayitOlSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı {string} alanına {string} yazar")
    public void kullaniciAlaninaYazar(String arg0, String arg1) {
        if (arg0.equals("Şifre")) {
            rm.mySendKeys(rp.getPasswordInput(), arg1);
        } else if (arg0.equals("Şifreyi Onayla")) {
            rm.mySendKeys(rp.getConfirmPasswordInput(), arg1);
        }
    }

    @When("Kayıt olma işlemini tetikler")
    public void kayitOlmaIsleminiTetikler() {
        rm.myClick(rp.getRegisterButton());
    }

    @Then("Sistem {string} uyarısı vermelidir")
    public void sistemUyarisiVermelidir(String arg0) {
        rm.veriyfyContainsText(rp.getPasswordMismatchError(), arg0);
    }

    @Given("Sistemde kayıtlı olan bir {string} e-posta adresi bulunmaktadır")
    public void sistemdeKayitliOlanBirEPostaAdresiBulunmaktadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı kayıt sayfasında bu e-posta adresini girer")
    public void kullaniciKayitSayfasindaBuEPostaAdresiniGirer() {
        rm.mySendKeys(rp.getEmailInput(), "mevcut@example.com");
    }

    @When("Gerekli diğer alanları doldurup kayıt olmaya çalışır")
    public void gerekliDigerAlanlariDoldurupKayitOlmayaCalisir() {
        rm.mySendKeys(rp.getPasswordInput(), "Password123");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "Password123");
        rm.myCheckBox(rp.getTermsCheckbox());
        rm.myClick(rp.getRegisterButton());
    }

    @Then("Sistem {string} hatası dönmelidir")
    public void sistemHatasiDonmelidir(String arg0) {
        rm.veriyfyContainsText(rp.getEmailInUseError(), arg0);
    }

    @Given("Kullanıcı kayıt ol sayfasında tüm zorunlu metin alanlarını kurallara uygun doldurmuştur")
    public void kullaniciKayitOlSayfasindaTumZorunluMetinAlanlariniKurallaraUygunDoldurmustur() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        rm.mySendKeys(rp.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(rp.getPasswordInput(), "StrongPass123");
        rm.mySendKeys(rp.getConfirmPasswordInput(), "StrongPass123");
    }

    @When("Kullanıcı sözleşme onay kutucuğunu işaretlemeden {string} butonuna tıklar")
    public void kullaniciSozlesmeOnayKutucugunuIsaretlemedenButonunaTiklar(String arg0) {
        rm.myClick(rp.getRegisterButton());
    }

    @Then("Kayıt işlemi tamamlanmamalı ve sözleşmenin onaylanması gerektiğine dair uyarı verilmelidir")
    public void kayitIslemiTamamlanmamaliVeSozlesmeninOnaylanmasiGerektigineDairUyariVerilmelidir() {
        rm.veriyfyContainsText(rp.getTermsRequiredError(), "onay");
    }

    @When("Kullanıcı {string} bağlantısına tıklar")
    public void kullaniciBaglantisinaTiklar(String arg0) {
        rm.myClick(rp.getLoginLink());
    }

    @Then("Giriş sayfasına {string} yönlendirilmelidir")
    public void girisSayfasinaYonlendirilmelidir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains(arg0));
    }

    @When("Kullanıcı tekrar kayıt sayfasına dönüp {string} seçeneğine tıklar")
    public void kullaniciTekrarKayitSayfasinaDonupSecenegineTiklar(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        rm.myClick(rp.getGoogleRegisterButton());
    }

    @Then("Google ile hızlı kayıt \\(OAuth) akışı tetiklenmelidir")
    public void googleIleHizliKayitOAuthAkisiTetiklenmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("google"));
    }
}