package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AIEditPage {
    private Page page;

    public AIEditPage() {
        this.page = PD.getPage();
    }

    public Locator getAIEditSection() {
        return page.locator("text=AI Edit");
    }

    public Locator getCurrentImage() {
        return page.locator(".current-image, img");
    }

    public Locator getDescribeInput() {
        return page.locator("input[placeholder*='Describe'], textarea[placeholder*='Describe']");
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator getAIEditResult() {
        return page.locator(".ai-edit-result, .result-image");
    }

    public Locator getAIEditWarning() {
        return page.locator(".error-message, .validation-warning");
    }
}