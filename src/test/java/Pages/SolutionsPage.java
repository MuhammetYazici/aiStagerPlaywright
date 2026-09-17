package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class SolutionsPage {
    private Page page;

    public SolutionsPage() {
        this.page = PD.getPage();
    }

    public Locator getSolutionsMenuHover(String menuText) {
        return page.getByText(menuText, new Page.GetByTextOptions().setExact(true));
    }

    public Locator getSubMenuItem(String subMenuText) {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName(subMenuText));
    }

    public Locator getCtaButton(String buttonText) {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText));
    }

    public Locator getLinkButton(String buttonText) {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName(buttonText));
    }

    public Locator getBeforeAfterSlider() {
        return page.locator("input[type='range'], .slider-handle, [role='slider']").first();
    }

    public Locator getAccordionHeader(String accordionText) {
        return page.getByText(accordionText);
    }

    public Locator getAccordionContent() {
        return page.locator(".accordion-content, [data-state='open']").first();
    }

    public Locator getFooterBannerCta() {
        return page.locator("footer, .bg-purple-600, .bg-primary").getByRole(com.microsoft.playwright.options.AriaRole.BUTTON).first();
    }

    public Locator getSecondarySlider() {
        return page.locator("input[type='range'], .slider-handle, [role='slider']").nth(1);
    }
}