package Pages;

import com.microsoft.playwright.Page;

public class AiStagerPages {
    private Page page;

    // Constructor
    public AiStagerPages(Page page) {
        this.page = page;
    }

    // Test adımlarında kullanılan örnek temel metotlar (İhtiyaca göre genişletilebilir)
    public void navigateTo(String url) {
        page.navigate(url);
    }
}