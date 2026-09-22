package StepDefinations;

import Pages.AiStagerPage;
import Utilities.ConfigReader;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AiStagerSteps {

    // Playwright sayfa nesnesi veya Driver yönetimi projenizin altyapısına göre buraya bağlanır
    AiStagerPage aiStagerPage = new AiStagerPage(null); // Mock veya Driver'dan gelen Page nesnesiile başlatılmalıdır

    @Given("User is on the stager homepage")
    public void user_is_on_the_stager_homepage() {
        // Örnek adımimplementasyonu
        // aiStagerPage.navigateToUrl(ConfigReader.getProperty("url"));
    }

    @When("User performs an action")
    public void user_performs_an_action() {
        // Step içeriği
    }

    @Then("User should see the result")
    public void user_should_see_the_result() {
        // Assertion içeriği
    }
}