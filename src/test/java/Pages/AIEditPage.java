package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AIEditPage {
    private Page page;

    public AIEditPage() {
        this.page = PD.getPage();
    }

    public Locator getCurrentImageRadio() {
        return page.locator("input[type='radio'][value='current'], text=Current image");
    }

    public Locator getDescribeInput() {
        return page.locator("input[placeholder*='Describe'], textarea[placeholder*='Describe']");
    }

    public Locator getEditButonu() {
        return page.locator("button:has-text('Edit')");
    }

    public Locator getGuncelGorselSonucu() {
        return page.locator(".edited-image-result, img[alt*='edited']");
    }

    public Locator getAiEditHataMesaji() {
        return page.locator("div:has-text('Lütfen bir düzenleme talimatı girin')");
    }
}