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

    public Locator getCurrentImageView() {
        return page.getByText("Current image");
    }

    public Locator getGorselOnizleme() {
        return page.locator("img[alt*='preview'], img[src*='blob']");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.getByPlaceholder("Describe what to change");
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator getFileInput() {
        return page.locator("input[type='file']");
    }
}