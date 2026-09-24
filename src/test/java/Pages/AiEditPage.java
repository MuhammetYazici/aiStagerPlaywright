package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiEditPage {
    private Page page;

    public AiEditPage() {
        this.page = PD.getPage();
    }

    public Locator getEditPhotoSource() {
        return page.locator("text=Current image, [name='editPhotoSource']");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='Describe'], input[placeholder*='Describe']");
    }

    public Locator getEditPhotoButonu() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getUyariMesaji() {
        return page.locator(".warning-message, text=uyarı");
    }
}