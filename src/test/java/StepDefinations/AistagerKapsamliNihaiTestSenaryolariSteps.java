package StepDefinations;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Pages.AistagerKapsamliNihaiTestSenaryolariPage;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    AistagerKapsamliNihaiTestSenaryolariPage page = new AistagerKapsamliNihaiTestSenaryolariPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanici ana sayfaya gider")
    public void kullaniciAnaSayfayaGider() {
        // Gerekli yönlendirme işlemleri
    }

    @Then("Sayfa basliginin {string} oldugunu dogrular")
    public void sayfaBasligininOldugunuDogrular(String expectedText) {
        rm.veriyfyContainsText(page.getGeneralLocator(), expectedText);
    }

    @When("Kullanici {string} butonuna tiklar")
    public void kullaniciButonunaTiklar(String buttonName) {
        rm.myClick(page.getLocatorByText(buttonName));
    }

    @And("Kullanici {string} alanina {string} yazar")
    public void kullaniciAlaninaYazar(String fieldName, String text) {
        rm.mySendKeys(page.getLocatorByText(fieldName), text);
    }
}