package StepDefinations;

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
    ReusableMethod rm = new ReusableMethod();

    // ========== LOGIN SAYFASI NEGATIF TESTLERI ==========

    @Given("Kullanıcı giriş sayfasındadır")
    public void userIsOnLoginPage() {
        // Hook'taki @Before'de URL zaten açılıyor
        System.out.println("✓ Kullanıcı giriş sayfasındadır");
    }

    @When("Kullanıcı boş e-posta ve boş şifre ile \"Giriş Yap\" butonuna tıklar")
    public void userClicksLoginWithEmptyFields() {
        // E-posta alanı zaten boş olacak, sadece butona tıkla
        rm.myClick(pages.getLocator("girisYapButton"));
    }


    @When("Kullanıcı aşağıdaki bilgileri girerek \"Giriş Yap\" butonuna tıklar")
    public void userEntersLoginCredentialsAndClicks(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        for (List<String> row : data) {
            String locatorKey = row.get(0);
            String value = row.get(1);

            // Dinamik değerleri değiştir
            if (value.equalsIgnoreCase("fakerEmail")) {
                value = ConfigReader.getRandomEmail();
            } else if (value.equalsIgnoreCase("fakerPassword")) {
                value = ConfigReader.getRandomPassword();
            }

            rm.mySendKeys(pages.getLocator(locatorKey), value);
        }
        rm.myClick(pages.getLocator("girisYapButton"));
    }



    // ========== KAYIT OL SAYFASI NEGATIF TESTLERI ==========

    @When("Kullanıcı kayıt ol butonuna tıklar")
    public void userClicksRegisterButton(DataTable dataTable) {
        String locator = dataTable.asList().get(0);
        rm.myClick(pages.getLocator(locator));
    }

    @And("Kullanıcı boş form ile \"Hesap Oluştur\" butonuna tıklar")
    public void userClicksCreateAccountWithEmptyForm() {
        rm.myClick(pages.getLocator("creatAccount"));
    }



    @And("Kayıt ol sayfasında aşağıdaki bilgileri girerek \"Hesap Oluştur\" butonuna tıklar")
    public void userEntersRegistrationCredentialsAndClicks(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        for (List<String> row : data) {
            String locatorKey = row.get(0);
            String value = row.get(1);

            // Dinamik değerleri değiştir
            if (value.equalsIgnoreCase("fakerEmail")) {
                value = ConfigReader.getRandomEmail();
            } else if (value.equalsIgnoreCase("fakerPassword")) {
                value = ConfigReader.getRandomPassword();
            }

            rm.mySendKeys(pages.getLocator(locatorKey), value);
        }
    }

    @And("Şartları kabul etme checkbox'ını işaretle")
    public void userChecksTermsCheckbox() {
        rm.myCheckBox(pages.getLocator("checkButton"));
    }






}
