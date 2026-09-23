package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AistagerTestcasesPage {
    private Page page;

    public AistagerTestcasesPage() {
        this.page = PD.getPage();
    }

    // İhtiyaç duyulabilecek temel bir örnek locator metodu eklenmiştir.
    // Projedeki senaryolara göre buraya yeni locator'lar eklenebilir.
    public Locator getElement(String locatorName) {
        return page.locator(locatorName);
    }
}