package StepDefinations;

import Pages.HomePage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Page;

public class AistagerTestcasesSteps {
    Page page = PD.getPage();
    ReusableMethod rm = new ReusableMethod();
    HomePage homePage = new HomePage();

    @Given("Kullanici ana sayfaya gider")
    public void kullaniciAnaSayfayaGider() {
        page.navigate("https://aistager.com");
    }

    @When("Kullanici erken erisim e-posta alanina {string} girer")
    public void kullaniciErkenErisimEpostaAlaninaGirer(String email) {
        rm.mySendKeys(homePage.getErkenErisimEpostaInput(), email);
    }

    @Then("Kullanici erken erisim e-posta alanina {string} girer ve islemi tamamlar")
    public void kullaniciErkenErisimEpostaAlaninaGirerVeIslemiTamamlar(String email) {
        rm.mySendKeys(homePage.getErkenErisimEpostaInput(), email);
    }

    @And("Ancak kullanici baska bir adim gerceklestirir")
    public void ancakKullaniciBaskaBirAdimGerceklestirir() {
        // Adım gövdesi
    }
}