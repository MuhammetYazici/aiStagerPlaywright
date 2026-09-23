package StepDefinations;

import Pages.AistagerTestcasesPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.*;
import com.microsoft.playwright.Page;

public class AistagerTestcasesSteps {

    Page page = PD.getPage();
    ReusableMethod rm = new ReusableMethod();
    AistagerTestcasesPage aistagerPage = new AistagerTestcasesPage();

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        // Implementation
    }

    @When("User performs actions causing illegal escape character fix test")
    public void userPerformsActions() {
        // Örnek metot gövdesi, mimari kurallara uygun olarak korunmuştur.
    }

    @Then("The test should run successfully")
    public void theTestShouldRunSuccessfully() {
        // Implementation
    }
}