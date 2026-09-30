package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class AiEditPage {
    private Page page;

    public AiEditPage() {
        this.page = PD.getPage();
    }

    public Locator getAiEditTab() {
        return page.getByText("AI Edit");
    }

    public Locator getCurrentimageSource() {
        return page.getByText("Current image");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.getByPlaceholder("Describe what to change");
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator getUpdatedImageResult() {
        return page.locator("img");
    }

    public Locator getRequiredFieldWarning() {
        return page.getByText("zorunlu");
    }
}