package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AistagerKapsamliNihaiTestSenaryolariPage {
    private Page page;

    public AistagerKapsamliNihaiTestSenaryolariPage() {
        this.page = PD.getPage();
    }

    public Locator getGeneralLocator() {
        return page.locator("body");
    }

    public Locator getLocatorByText(String text) {
        // Metne veya placeholder değerine göre dinamik locator döndürür
        return page.locator("text=" + text).first();
    }
}