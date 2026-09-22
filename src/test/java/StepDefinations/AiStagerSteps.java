package StepDefinations;

import Pages.AiStagerPages;
import Utilities.ConfigReader;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;

public class AiStagerSteps {

    // Örnek olarak AiStagerPages sınıfının tanımlanması ve başlatılması
    // Playwright page nesnesinin projede nasıl yönetildiğine bağlı olarak burası güncellenebilir.
    AiStagerPages aiStagerPages;

    @Given("Kullanici ana sayfaya gider")
    public void kullanici_ana_sayfaya_gider() {
        // Örnek başlatma ve metod çağrısı
        // aiStagerPages = new AiStagerPages(Driver.getPage());
        // aiStagerPages.navigateTo(ConfigReader.getProperty("url"));
    }
}