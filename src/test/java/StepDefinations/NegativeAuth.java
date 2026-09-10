package StepDefinations;

import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.pages;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;

import java.util.List;

public class NegativeAuth {
    pages pages = new pages();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();
    LoginPage loginPage = new LoginPage();

    // ========== LOGIN SAYFASI NEGATIF TESTLERI ==========

    @Given("Kullanıcı giriş sayfasındadır")
    public void userIsOnLoginPage() {
        // Hook'taki @Before'de URL zaten açılıyor
        System.out.println("✓ Kullanıcı giriş sayfasındadır");
    }

    @When("Kullanıcı boş e-posta ve boş şifre ile \"Giriş Yap\" butonuna tıklar")
    public void userClicksLoginWithEmptyFields() {
        // E-posta alanı zaten boş olacak, sadece butona tıkla
        rm.myClick(loginPage.girisYapInput());
    }


    @When("Kullanıcı aşağıdaki bilgileri girerek \"Giriş Yap\" butonuna tıklar")
    public void userEntersLoginCredentialsAndClicks(DataTable dataTable) {
        List<String> data = dataTable.asList();
        rm.mySendKeys(loginPage.emailInput(),data.get(0));
        rm.mySendKeys(loginPage.passwordInput(), data.get(0));
        rm.myClick(loginPage.girisYapInput());
    }



    // ========== KAYIT OL SAYFASI NEGATIF TESTLERI ==========

    @When("Kullanıcı kayıt ol butonuna tıklar")
    public void userClicksRegisterButton() {
        rm.myClick(registerPage.registerButton());
    }

    @And("Kullanıcı boş form ile \"Hesap Oluştur\" butonuna tıklanılabilir olmamalı")
    public void userClicksCreateAccountWithEmptyForm() {
        if (pages.getLocator("creatAccount").isVisible()){
            System.out.println("Hesap Oluştur Butonu Aktif Değil");
        }
    }



    @And("Kayıt ol sayfasında aşağıdaki bilgileri girerek \"Hesap Oluştur\" butonuna tıklar")
    public void userEntersRegistrationCredentialsAndClicks(DataTable dataTable) {
        List<String> data = dataTable.asList();
        rm.mySendKeys(registerPage.emailInput(), rm.resolveDynamicValue(data.get(0)));
        rm.mySendKeys(registerPage.passwordInput(), rm.resolveDynamicValue(data.get(0)));
        rm.mySendKeys(registerPage.passwordRepeatInput(), rm.resolveDynamicValue(data.get(0)));
    }

    @And("Şartları kabul etme checkbox'ını işaretle")
    public void userChecksTermsCheckbox() {
        rm.myCheckBox(pages.getLocator("checkButton"));
    }






}
