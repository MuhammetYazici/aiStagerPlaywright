package Pages;

import com.microsoft.playwright.Page;
import Utilities.ConfigReader;

public class AiStagerPage {
    private Page page;

    public AiStagerPage(Page page) {
        this.page = page;
    }

    // Örnek temel Playwright aksiyon metotları (Step tanımlarında kullanılan senaryolara göre genişletilebilir)
    public void navigateToUrl(String url) {
        page.navigate(url);
    }

    public void clickElement(String selector) {
        page.click(selector);
    }

    public void fillInput(String selector, String text) {
        page.fill(selector, text);
    }

    public String getElementText(String selector) {
        return page.textContent(selector);
    }
}