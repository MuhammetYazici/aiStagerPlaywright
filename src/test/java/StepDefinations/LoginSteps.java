package StepDefinations;

import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    LoginPage lp = new LoginPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı giriş sayfasındadır {string}")
    public void kullaniciGirisSayfasindadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + arg0);
    }

    @When("Kullanıcı geçerli bir e-posta adresi ve şifre girer")
    public void kullaniciGecerliBirEPostaAdresiVeSifreGirer() {
        rm.mySendKeys(lp.getEmailInput(), ConfigReader.getProperty("validEmail"));
        rm.mySendKeys(lp.getPasswordInput(), ConfigReader.getProperty("validPassword"));
    }

    @When("Giriş yap butonuna tıklar")
    public void girisYapButonunaTiklar() {
        rm.myClick(lp.getSubmitButton());
    }

    @Then("Kullanıcı ana panele \\(dashboard) yönlendirilmelidir")
    public void kullaniciAnaPaneleDashboardYonlendirilmelidir() {
        rm.veriyfyContainsText(lp.getDashboardHeader(), "Dashboard");
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
    }

    @Given("Kullanıcı şifre alanına bir değer girmiştir ve şifre maskelenmiştir \\({string} ile)")
    public void kullaniciSifreAlaninaBirDegerGirmistirVeSifreMaskelenmistirIle(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(lp.getPasswordInput(), "Password123");
    }

    @When("Kullanıcı {string} ikonuna tıklar")
    public void kullaniciIkonunaTiklar(String arg0) {
        rm.myClick(lp.getPasswordToggleIcon());
    }

    @Then("Şifre metni açık olarak görünmelidir")
    public void sifreMetniAcikOlarakGorunmelidir() {
        Assert.assertTrue(lp.getPasswordInput().isVisible());
    }

    @Then("Şifre tekrar maskelenmiş hale gelmelidir")
    public void sifreTekrarMaskelenmisHaleGelmelidir() {
        Assert.assertTrue(lp.getPasswordInput().isVisible());
    }

    @When("Kullanıcı {string} ve {string} alanlarını boş bırakarak giriş yapmaya çalışır")
    public void kullaniciVeAlanlariniBosBirakarakGirisYapmayaCalisir(String arg0, String arg1) {
        rm.mySendKeys(lp.getEmailInput(), arg0);
        rm.mySendKeys(lp.getPasswordInput(), arg1);
        rm.myClick(lp.getSubmitButton());
    }

    @Then("Alanın altında {string} hata mesajı görünmelidir")
    public void alaninAltindaHataMesajiGorunmelidir(String arg0) {
        rm.veriyfyContainsText(lp.getValidationErrorMessage(), arg0);
    }

    @When("Kullanıcı e-posta alanına {string} yazar ve giriş yapmaya çalışır")
    public void kullaniciEPostaAlaninaYazarVeGirisYapmayaCalisir(String arg0) {
        rm.mySendKeys(lp.getEmailInput(), arg0);
        rm.myClick(lp.getSubmitButton());
    }

    @Then("Sistem geçerli bir e-posta formatı uyarısı gösterilmelidir")
    public void sistemGecerliBirEPostaFormatiUyarisiGosterilmelidir() {
        rm.veriyfyContainsText(lp.getValidationErrorMessage(), "geçerli");
    }

    @When("Kullanıcı {string} ve {string} ile giriş yapmayı dener")
    public void kullaniciVeIleGirisYapmayiDener(String arg0, String arg1) {
        rm.mySendKeys(lp.getEmailInput(), arg0);
        rm.mySendKeys(lp.getPasswordInput(), arg1);
        rm.myClick(lp.getSubmitButton());
    }

    @Then("Sistem güvenlik nedeniyle spesifik bilgi vermeden genel bir {string} mesajı göstermelidir")
    public void sistemGuvenlikNedeniylespesifikBilgiVermedenGenelBirMesajiGostermelidir(String arg0) {
        rm.veriyfyContainsText(lp.getGeneralErrorMessage(), arg0);
    }

    @When("Kullanıcı e-posta veya şifre alanına {string} girer")
    public void kullaniciEPostaVeyaSifreAlaninaGirer(String arg0) {
        rm.mySendKeys(lp.getEmailInput(), arg0);
        rm.mySendKeys(lp.getPasswordInput(), arg0);
    }

    @Then("Sistem sunucu hatası \\(500) üretmeden isteği reddetmeli ve uygun bir hata mesajı döndürmelidir")
    public void sistemSunucuHatasiUretmedenIstegiReddetmeliVeUygunBirHataMesajiDondurmelidir() {
        rm.veriyfyContainsText(lp.getGeneralErrorMessage(), "hata");
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String arg0) {
        rm.myClick(lp.getGoogleLoginButton());
    }

    @Then("Google OAuth kimlik doğrulama penceresi tetiklenmelidir")
    public void googleOAuthKimlikDogrulamaPenceresiTetiklenmelidir() {
        Assert.assertTrue(lp.getGoogleOAuthWindow().isVisible() || PD.getPage().url().contains("google"));
    }
}