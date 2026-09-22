package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiEditPage {
    private Page page;

    public AiEditPage() {
        this.page = PD.getPage();
    }

    public Locator getAiEditTab() {
        return page.locator("text=AI Edit, a:has-text('AI Edit')");
    }

    public Locator getDefaultSelectedImage() {
        return page.locator("img.default-preview, [data-selected='true']");
    }

    public Locator getPromptInput() {
        return page.locator("textarea[placeholder*='Describe'], input[placeholder*='Describe'], #prompt-input");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo'), button:has-text('Fotoğrafı Düzenle')");
    }

    public Locator getEditedResultImage() {
        return page.locator("img.edited-result, [data-testid='edited-image']");
    }

    public Locator getNewImageUploadInput() {
        return page.locator("input[type='file']");
    }
}