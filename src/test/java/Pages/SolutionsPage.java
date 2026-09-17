package Pages;

import Utilities.PD;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class SolutionsPage {
    private Page page;

    public SolutionsPage() {
        this.page = PD.getPage();
    }

    public Locator getBusinessMenu(String menuText) {
        return page.locator("text=" + menuText);
    }

    public Locator getSubMenuItem(String subMenuText) {
        return page.locator("text=" + subMenuText);
    }

    public Locator getCtaButton(String buttonText) {
        return page.locator("button:has-text('" + buttonText + "'), a:has-text('" + buttonText + "')").first();
    }

    public Locator getCookieAcceptAllButton() {
        return page.locator("button:has-text('Tümünü Kabul Et')");
    }

    public Locator getFaqAccordion(String questionText) {
        return page.locator("text=" + questionText);
    }

    public Locator getSlider(String sliderName) {
        return page.locator("text=" + sliderName).locator("..").locator("input[type='range'], .slider, [role='slider']").first();
    }
}