package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getVirtualStagingHeader() {
        return page.locator("text=Virtual Staging");
    }

    public Locator getUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("text=Oda Türü");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("text=Tasarım Stili");
    }

    public Locator getRemoveFurnitureToggle() {
        return page.locator("text=Mevcut mobilyaları kaldır");
    }

    public Locator getVisibilityPreference() {
        return page.locator("input[type='radio']").first();
    }

    public Locator getGenerateButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getResultImage() {
        return page.locator("img.result-image");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message");
    }

    public Locator getAiEditTab() {
        return page.locator("text=AI Edit");
    }

    public Locator getEditPhotoSourceDefault() {
        return page.locator("text=Current image");
    }

    public Locator getDescribePromptInput() {
        return page.locator("textarea[placeholder*='Describe']");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }
}