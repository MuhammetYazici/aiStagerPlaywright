package StepDefinations;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ForgotPassword {
    ReusableMethod rm = new ReusableMethod();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    LoginPage loginPage = new LoginPage();

    @When("The user clicks the forgot password button")
    public void theUserClicksTheForgotPasswordButton() {
        rm.myClick(loginPage.forgotPassword());
    }

    @And("The user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        rm.mySendKeys(forgotPasswordPage.forgotPassEmail(),rm.resolveDynamicValue(email));
    }

    @And("The user clicks the send reset email button")
    public void theUserClicksTheSendResetEmailButton() {
        rm.myClick(forgotPasswordPage.sifirlamaButton());
    }

    @Then("The {string} message should be displayed")
    public void theMessageShouldBeDisplayed(String expectedMessage) {
        rm.veriyfyContainsText(forgotPasswordPage.message(),expectedMessage);
    }
}
