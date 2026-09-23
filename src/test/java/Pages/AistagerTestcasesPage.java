package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AistagerTestcasesPage {
    private Page page;

    public AistagerTestcasesPage() {
        this.page = PD.getPage();
    }

    // İhtiyaca göre Locator metotları buraya eklenebilir.
    // Örnek:
    // public Locator getExampleLocator() {
    //     return this.page.locator("css-or-xpath");
    // }
}