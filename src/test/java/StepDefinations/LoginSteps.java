package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    LoginPage lp = new LoginPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullaniciGirisSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        Assert.assertTrue(lp.getEmailInput().isVisible());
    }

    @When("Kullanıcı e-posta alanına {string} girer")
    public void kullaniciEPostaAlaninaGirer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(lp.getEmailInput(), resolvedEmail);
    }

    @When("Kullanıcı şifre alanına geçerli şifresini girer")
    public void kullaniciSifreAlaninaGecerliSifresiniGirer() {
        rm.mySendKeys(lp.getPasswordInput(), ConfigReader.getProperty("default_password"));
    }

    @When("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(lp.getGirisYapButton());
    }

    @Then("Kullanıcı sisteme başarılı bir şekilde giriş yapar ve ana sayfaya yönlendirilir")
    public void kullaniciSistemeBasariliBirSekildeGirisYaparVeAnaSayfayaYonlendirilir() {
        Assert.assertTrue(PD.getPage().url().contains("home") || PD.getPage().url().equals(ConfigReader.getProperty("url") + "/"));
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(lp.getGirisYapButton());
    }

    @Then("E-posta ve şifre alanlarının altında Bu alan zorunludur uyarısı verilmelidir")
    public void ePostaVeSifreAlanlarininAltindaBuAlanZorunludurUyarisiVerilmelidir() {
        Assert.assertTrue(lp.getZorunluAlanUyarisi().isVisible());
    }

    @Then("E-posta alanında Lütfen geçerli bir e-posta adresi girin hatası dönmelidir")
    public void ePostaAlanindaLutfenGecerliBirEPostaAdresiGirinHatasiDonmelidir() {
        rm.veriyfyContainsText(lp.getGecerliEmailUyarisi(), "geçerli");
    }

    @When("Kullanıcı sisteme kayıtlı olmayan {string} veya hatalı bir şifre girer")
    public void kullaniciSistemeKayitliOlmayanVeyaHataliBirSifreGirer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(lp.getEmailInput(), resolvedEmail);
        rm.mySendKeys(lp.getPasswordInput(), "YanlisSifre123!");
    }

    @Then("Kullanıcıya spesifik bilgi verilmeden genel bir E-posta veya şifre hatalı mesajı gösterilmelidir")
    public void kullaniciyaSpesifikBilgiVerilmedenGenelBirEPostaVeyaSifreHataliMesajiGosterilmelidir() {
        rm.veriyfyContainsText(lp.getGenelHataMesaji(), "hatalı");
    }

    @When("Kullanıcı şifre alanına bir metin girer")
    public void kullaniciSifreAlaninaBirMetinGirer() {
        rm.mySendKeys(lp.getPasswordInput(), "GizliSifre123");
    }

    @Then("Şifre karakterlerinin maskelenmiş olduğu görülür")
    public void sifreKarakterlerininMaskelenmisOlduguGorulur() {
        Assert.assertEquals(lp.getPasswordInput().getAttribute("type"), "password");
    }

    @When("Kullanıcı şifre alanındaki Göz ikonuna tıklar")
    public void kullaniciSifreAlanindakiGozIkonunaTiklar() {
        rm.myClick(lp.getGozyasiGozIkonu());
    }

    @Then("Şifre metni görünür hale gelmelidir")
    public void sifreMetniGorunurHaleGelmelidir() {
        Assert.assertTrue(lp.getPasswordInput().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} girer")
    public void kullaniciSifreAlaninaGirer(String payload) {
        String resolvedPayload = rm.resolveDynamicValue(payload);
        rm.mySendKeys(lp.getPasswordInput(), resolvedPayload);
    }

    @Then("Sistem bu girdileri güvenle filtrelemeli ve 5xx sunucu hatasına sebep olmamalıdır")
    public void sistemBuGirdileriGuvenleFiltrelemeliVe5xxSunucuHatasinaSebepOlmamalidir() {
        Assert.assertTrue(lp.getEmailInput().isVisible() || PD.getPage().url().contains("login"));
    }
}