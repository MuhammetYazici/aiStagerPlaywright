package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {
    protected Page page;

    // Parametresiz constructor: Alt sınıfların super() yazma zorunluluğunu kaldırır
    public BasePage() {
        this.page = PD.getPage();
    }

    public BasePage(Page page) {
        this.page = page;
    }

    public void verifyContainsText(Locator locator, String text) {
        assertThat(locator).containsText(text);
    }

    public void myClick(Locator locator) {
        locator.click(); // Playwright'ın yerleşik auto-wait'i yeterlidir
    }

    public void mySendKeys(Locator locator, String text) {
        locator.fill(text);
    }

    public void mySelectValue(Locator locator, String value) {
        locator.selectOption(value);
    }

    public void mySelectLabel(Locator locator, String label) {
        locator.selectOption(new SelectOption().setLabel(label));
    }

    public void myCheckBox(Locator locator) {
        locator.check();
    }
}