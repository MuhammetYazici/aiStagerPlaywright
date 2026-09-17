package StepDefinations;

import Pages.RegisterPage;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {

    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("kullanıcı kayıt sayfasında bulunur")
    public void kullanıcıKayıtSayfasındaBulunur() {
        // Sayfa açılışı ve hazırlık adımları Hooks veya burada yapılabilir
    }

    @Given("sistemde daha önce hiç kayıt olmamış {string} e-posta adresi vardır")
    @Given("daha önce açılıp {string} özelliği ile silinmiş {string} e-posta adresi vardır")
    @Given("daha önce silinmiş olan {string} e-posta adresi vardır")
    public void sistemdeEpostaAdresiVardır(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        // Hazırlık simülasyonu
    }

    @Given("daha önce silinmiş olan {string} e-posta adresi vardır")
    public void dahaOnceSilinmisOlanEpostaAdresiVardir(String orijinalEposta) {
        String resolvedEmail = rm.resolveDynamicValue(orijinalEposta);
    }

    @When("kullanıcı {string} adresi ile yeni bir kayıt oluşturur")
    @When("kullanıcı silinmiş olan {string} adresi ile yeniden kayıt oluşturur")
    @When("kullanıcı bu e-postanın farklı bir varyasyonu olan {string} ile yeniden kayıt oluşturur")
    public void kullanıcıYeniKayıtOluşturur(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(registerPage.getEmailInput(), resolvedEmail);
        rm.mySendKeys(registerPage.getPasswordInput(), "Test1234*");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Test1234*");
        rm.myCheckBox(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getSubmitButton());
    }

    @And("e-posta doğrulama adımı tamamlanır")
    public void ePostaDoğrulamaAdımıTamamlanır() {
        // E-posta doğrulama adımı simülasyonu
    }

    @And("kullanıcı sisteme giriş yapar")
    public void kullanıcıSistemeGirişYapar() {
        // Giriş adımları gerekiyorsa burada tamamlanır
    }

    @Then("kayıt işlemi başarılı olmalı")
    @Then("kayıt işlemi herhangi bir hata almadan başarılı olmalı")
    public void kayıtİşlemiBaşarılıOlmalı() {
        rm.veriyfyContainsText(registerPage.getSuccessMessage(), "başarılı");
    }

    @Then("kullanıcı kredi bakiyesinin {string} olduğunu görmelidir")
    public void kullanıcıKrediBakiyesininOlduğunuGörmelidir(String expectedCredit) {
        rm.veriyfyContainsText(registerPage.getCreditBalance(), expectedCredit);
    }
}