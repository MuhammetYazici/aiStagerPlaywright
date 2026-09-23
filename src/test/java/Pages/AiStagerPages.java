package Pages;

import com.microsoft.playwright.Page;
import Utilities.ConfigReader;

public class AiStagerPages {
    private Page page;

    public AiStagerPages(Page page) {
        this.page = page;
    }

    // Projenizin yapısına uygun örnek temel sayfa metotları
    public void navigateToUrl(String url) {
        page.navigate(url);
    }
}