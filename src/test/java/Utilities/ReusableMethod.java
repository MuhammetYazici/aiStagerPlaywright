package Utilities;

import Utilities.PD;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static org.testng.Assert.assertTrue;

public class ReusableMethod {
    private Page page;

    public ReusableMethod() {
        this.page = PD.getPage();
    }

    public void myClick(Locator locator) {
        locator.waitFor();
        locator.click();
    }

    public void mySendKeys(Locator locator, String text) {
        locator.waitFor();
        locator.fill(text);
    }

    public void myVerifyContainsText(Locator locator, String text) {
        locator.waitFor();
        assertTrue(locator.textContent().contains(text));
    }

    public void myCheckBox(Locator locator) {
        locator.waitFor();
        if (!locator.isChecked()) {
            locator.click();
        }
    }
}