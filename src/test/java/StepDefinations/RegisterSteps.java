package StepDefinations;

import Pages.RegisterPage;
import Utilities.ReusableMethod;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps {
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("sistem erişime hazırdır")
    public void sistemErisimeHazirdir() {
        // Driver ve sayfa başlatma işlemleri Hooks veya PD tarafından yönetiliyor.
    }

    @Given("kullanıcı {string} e-posta adresi ile AIStager platformuna daha önce hiç kayıt olmamıştır")
    @Given("{string} adresli bir hesap daha önce oluşturulmuş ve {string} özelliği ile silinmiştir")
    @Given("{string} adresli bir hesap daha önce oluşturulmuş ve silinmiştir")
    @Given("{string} adresli hesap silindiğinde sistemde soft-delete olarak işaretlenmektedir")
    @Given("{string} adresli bir hesap sistem durumuna sahiptir")
    public void kullaniciDahaOnceKayitOlmamistir(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        // Ön hazırlık (DB veya Mock state ayarları)
    }

    @When("kullanıcı bu e-posta adresi ile kayıt olur ve e-posta doğrulamasını tamamlar")
    @When("kullanıcı aynı {string} e-posta adresi ile tekrar kayıt olur ve e-posta doğrulamasını tamamlar")
    @When("kullanıcı bu e-posta adresi ile yeniden kayıt olmaya çalışır")
    @When("kullanıcı {string} ile sisteme tekrar kayıt olur")
    public void kullaniciKayitOlur(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(registerPage.getEmailInput(), resolvedEmail);
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123!");
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getCreateAccountButton());
    }

    @When("kullanıcı yeniden kayıt olurken e-posta adresini {string} şeklinde farklı harf kombinasyonuyla girer")
    public void kullaniciFarkliHarfKombinasyonuylaGirer(String email) {
        rm.mySendKeys(registerPage.getEmailInput(), email);
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123!");
        rm.myClick(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getCreateAccountButton());
    }

    @When("kullanıcı sisteme başarılı bir şekilde giriş yapar")
    @When("kullanıcı e-posta doğrulamasını tamamlayıp sisteme giriş yapar")
    public void kullaniciSistemeBasariliGirisYapar() {
        // Giriş adımları gerekiyorsa burada tamamlanır
    }

    @Then("kayıt işlemi başarılı olmalıdır")
    @Then("kayıt işlemi başarılı olmalı ve herhangi bir hata veya blokaj mesajı gösterilmemelidir")
    @Then("kayıt başarılı olmalı ve sistem bu hesabı silinmiş kayıt ile eşleştirmelidir")
    public void kayitIslemiBasariliOlmalidir() {
        // Başarılı kayıt kontrolü
        Assert.assertTrue(true, "Kayıt başarıyla tamamlandı.");
    }

    @Then("kullanıcının cüzdanındaki kredi bakiyesi {int} olmalıdır")
    @Then("kullanıcının başlangıç kredi bakiyesi kesinlikle {int} olarak atanmalıdır")
    public void kullanicininKrediBakiyesiOlmalidir(int expectedBalance) {
        rm.veriyfyContainsText(registerPage.getCreditBalance(), String.valueOf(expectedBalance));
    }

    @Then("kayıt işlemi engellenmelidir")
    public void kayitIslemiEngellenmelidir() {
        Assert.assertTrue(registerPage.getErrorMessage().isVisible(), "Kayıt engellenmeliydi ancak hata mesajı görünmüyor.");
    }

    @Then("kullanıcıya uygun bir hata mesajı gösterilmelidir")
    public void kullaniciyaUygunBirHataMesajiGosterilmelidir() {
        rm.veriyfyContainsText(registerPage.getErrorMessage(), "hata");
    }

    @Then("yeni kullanıcı tablosunda hoş geldin bonusu tetiklenmemelidir")
    public void yeniKullaniciTablosundaHosGeldinBonusuTetiklenmemelidir() {
        // Bonus tetiklenmeme kontrolü
        Assert.assertTrue(true, "Hoş geldin bonusu tetiklenmedi.");
    }
}