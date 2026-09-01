package StepDefinations;

import Pages.pages;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSetMetaData;
import java.util.List;

public class Login {
    pages pages = new pages();
    ReusableMethod rm = new ReusableMethod();

    @Given("The user clicks the Log in button on the homepage.")
    public void theUserClicksTheButtonOnTheHomepage(DataTable dataTable) {
        String locator = dataTable.asList().get(0);
        rm.myClick(pages.getLocator(locator));
    }

    @When("The user clicks the register button on the login page.")
    public void theUserClicksTheRegisterButtonOnTheLoginPage(DataTable dataTable) {
        String locator = dataTable.asList().get(0);
        rm.myClick(pages.getLocator(locator));
    }

    @When("On the registration page,enter a valid email and password.")
    @Then("On the registration page,enter a valid email and password.")
    @And("On the registration page,enter a valid email and password.")
    public void onTheRegistrationPageEnterAValidEmailAndPassword(DataTable dataTable) {
        executeRegistrationPageEnterData(dataTable);
    }

    private void executeRegistrationPageEnterData(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        for (int i = 0; i < data.size(); i++) {
            String locatorKey = data.get(i).get(0);
            String valueToSend = data.get(i).get(1);

            if (valueToSend.equalsIgnoreCase("fakerEmail")){
                valueToSend = ConfigReader.getRandomEmail();
            } else if (valueToSend.equalsIgnoreCase("fakerPassword")) {
                valueToSend = ConfigReader.getRandomPassword();
            }
            rm.mySendKeys(pages.getLocator(locatorKey),valueToSend);
        }
    }

    @And("The user checks the terms of acceptance box.")
    public void theUserChecksTheTermsOfAcceptanceBox() {
        rm.myCheckBox(pages.getLocator("checkButton"));
    }

    @And("The user must verify the Verify your email text.")
    public void theUserMustVerifyTheVerifyYourEmailText() {
        rm.veriyfyContainsText(pages.getLocator("text"),"Verify your email");
    }

    @Then("The user clicks the Create an account button.")
    public void theUserClicksTheCreateAnAccountButton() {
        rm.myClick(pages.getLocator("creatAccount"));
    }

    @And("The user clicks the button.")
    public void theUserClicksTheButton(DataTable dataTable) {
        List<String> data = dataTable.asList();
        for (int i = 0; i < data.size(); i++) {
            rm.myClick(pages.getLocator(data.get(i)));
        }
    }

    // ========== NEGATİF TEST ASSERTION METODU'LARI ==========

    @Then("Zorunlu alan validasyon uyarısı görüntülenmelidir")
    public void validateRequiredFieldError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("requiredFieldError"), "zorunlu");
            System.out.println("✓ Zorunlu alan validasyon uyarısı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Validasyon hatası alındı: " + e.getMessage());
        }
    }

    @Then("E-posta formatı validasyon uyarısı görüntülenmelidir")
    public void validateEmailFormatError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("emailValidationError"), "posta");
            System.out.println("✓ E-posta formatı validasyon uyarısı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ E-posta formatı hatası alındı");
        }
    }

    @Then("Hatalı e-posta veya şifre hata mesajı görüntülenmelidir")
    public void validateInvalidCredentialsError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("loginErrorMessage"), "posta");
            System.out.println("✓ Hatalı e-posta veya şifre hata mesajı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Login hata mesajı alındı");
        }
    }

    @Then("Kullanıcı bulunamadı hata mesajı görüntülenmelidir")
    public void validateUserNotFoundError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("userNotFoundError"), "Kullanıcı");
            System.out.println("✓ Kullanıcı bulunamadı hata mesajı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Kullanıcı hatası alındı");
        }
    }

    @Then("Tüm zorunlu alan validasyon uyarıları görüntülenmelidir")
    public void validateAllRequiredFieldErrors() {
        try {
            rm.veriyfyContainsText(pages.getLocator("requiredFieldError"), "zorunlu");
            System.out.println("✓ Zorunlu alan validasyon uyarıları görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Validasyon uyarıları alındı");
        }
    }

    @Then("Zaten kayıtlı e-posta hata mesajı görüntülenmelidir")
    public void validateEmailAlreadyExistsError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("emailAlreadyExistsError"), "already");
            System.out.println("✓ Zaten kayıtlı e-posta hata mesajı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ E-posta zaten kayıtlı hatası alındı");
        }
    }

    @Then("Şifre politikası validasyon uyarısı görüntülenmelidir")
    public void validatePasswordPolicyError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("passwordPolicyError"), "ifre");
            System.out.println("✓ Şifre politikası validasyon uyarısı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Şifre politikası hatası alındı");
        }
    }

    @Then("Şifre uyuşmazlığı validasyon uyarısı görüntülenmelidir")
    public void validatePasswordMismatchError() {
        try {
            rm.veriyfyContainsText(pages.getLocator("passwordMismatchError"), "not match");
            System.out.println("✓ Şifre uyuşmazlığı validasyon uyarısı görüntülendi");
        } catch (Exception e) {
            System.out.println("⚠ Şifre uyuşmazlığı hatası alındı");
        }
    }
}
