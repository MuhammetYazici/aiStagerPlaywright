package StepDefinations;

import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    Page page = PD.getPage();
    ReusableMethod rm = new ReusableMethod();

    @When("User verifies text contains {string} on page")
    public void userVerifiesTextContainsOnPage(String expectedText) {
        rm.veriyfyContainsText(page.locator("body"), expectedText);
    }
}