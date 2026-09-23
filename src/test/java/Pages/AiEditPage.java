package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiEditPage {
    private Page page;

    public AiEditPage() {
        this.page = PD.getPage();
    }

    public Locator getCurrentimageRadio() {
        return page.locator("text=Current image");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("placeholder='Describe what to change'");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getAlternatifGorselInput() {
        return page.locator("input[type='file']").first();
    }
}