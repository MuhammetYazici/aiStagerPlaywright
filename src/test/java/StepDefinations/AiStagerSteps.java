package StepDefinations;

import Pages.AiStagerPages;
import Utilities.ConfigReader;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;

public class AiStagerSteps {
    
    // AiStagerPages sınıfının tanımlandığından ve doğru import edildiğinden emin olunur
    AiStagerPages aiStagerPages = new AiStagerPages(null); // Veya Playwright Page nesnesiile başlatma

    @Given("Kullanici ana sayfaya gider")
    public void kullanici_ana_sayfaya_gider() {
        // Örnek adımimplementasyonu
        // aiStagerPages.navigateToUrl(ConfigReader.getProperty("url"));
    }
}