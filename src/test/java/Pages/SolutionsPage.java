package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import Utilities.PD;

public class SolutionsPage {

    public Page page;

    public SolutionsPage() {
        this.page = PD.getPage();
    }

    public Locator getBusinessMenu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İŞLETMELER"))
                .or(page.locator("//button[contains(text(),'İŞLETMELER')]"))
                .or(page.locator("nav a:has-text('İŞLETMELER')"));
    }

    public Locator getSectorOption(String sectorName) {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName(sectorName))
                .or(page.locator("//a[contains(text(),'" + sectorName + "')]"));
    }

    public Locator getHeroCTA(String buttonText) {
        return page.locator("section.hero button:has-text('" + buttonText + "'), section.hero a:has-text('" + buttonText + "')")
                .or(page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText)))
                .or(page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName(buttonText)));
    }

    public Locator getCTAByLocation(String location, String buttonName) {
        String selector;
        if (location.contains("Üst")) {
            selector = "header, section:first-of-type";
        } else if (location.contains("3 Basit Adım")) {
            selector = "section:has-text('3 Basit Adımda'), div.steps-container";
        } else if (location.contains("Alt Yeşil Banner") || location.contains("Banner")) {
            selector = "div.green-banner, section.cta-banner, footer";
        } else {
            selector = "body";
        }
        return page.locator(selector + " button:has-text('" + buttonName + "'), " + selector + " a:has-text('" + buttonName + "')").first();
    }

    public Locator getSliderHandle(String sliderIdentifier) {
        if (sliderIdentifier != null && !sliderIdentifier.isEmpty()) {
            return page.locator("//section[contains(.,'" + sliderIdentifier + "')]//input[@type='range']")
                    .or(page.locator("//section[contains(.,'" + sliderIdentifier + "')]//div[contains(@class,'slider-handle')]"))
                    .or(page.locator("input[type='range']").first());
        }
        return page.locator("input[type='range'], div.slider-handle").first();
    }

    public Locator getFAQQuestion(String questionText) {
        return page.locator("//div[contains(@class,'faq')]//button[contains(.,'" + questionText + "')]")
                .or(page.locator("//h3[contains(text(),'" + questionText + "')]"))
                .or(page.locator("details summary:has-text('" + questionText + "')"));
    }

    public Locator getFAQAnswer(String questionText) {
        return page.locator("//div[contains(@class,'faq')]//button[contains(.,'" + questionText + "')]/following-sibling::div")
                .or(page.locator("details:has-text('" + questionText + "') p"))
                .or(page.locator("//div[contains(@class,'faq-answer')]"));
    }

    public void dragSliderToPercentage(Locator sliderHandle, double percentage) {
        BoundingBox box = sliderHandle.boundingBox();
        if (box != null) {
            double startX = box.x + box.width / 2;
            double startY = box.y + box.height / 2;
            double targetX = box.x + (box.width * (percentage / 100.0));

            page.mouse().move(startX, startY);
            page.mouse().down();
            page.mouse().move(targetX, startY);
            page.mouse().up();
        } else {
            sliderHandle.evaluate("el => el.value = " + percentage);
            sliderHandle.dispatchEvent("input");
            sliderHandle.dispatchEvent("change");
        }
    }

    public double getSliderValue(Locator sliderHandle) {
        String value = sliderHandle.getAttribute("value");
        if (value != null) {
            return Double.parseDouble(value);
        }
        String style = sliderHandle.getAttribute("style");
        if (style != null && style.contains("left:")) {
            String leftVal = style.replaceAll(".*left:\\s*([0-9.]+).*", "$1");
            return Double.parseDouble(leftVal);
        }
        return 50.0;
    }

    public Locator getActionButton(String buttonName) {
        return page.locator("button:has-text('" + buttonName + "'), a:has-text('" + buttonName + "')").first();
    }
}