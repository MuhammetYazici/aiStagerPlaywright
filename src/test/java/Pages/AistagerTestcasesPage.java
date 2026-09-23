package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AistagerTestcasesPage {
    private Page page;

    public AistagerTestcasesPage() {
        this.page = PD.getPage();
    }

    // İhtiyaç duyulabilecek örnek bir element metodu (Mimaride 'cannot find symbol' hatalarını önlemek için)
    public Locator getElement(String locatorText) {
        return page.locator(locatorText);
    }
}