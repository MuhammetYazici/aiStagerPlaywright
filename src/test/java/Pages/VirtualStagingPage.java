package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getVirtualStagingHeader() {
        return page.locator("h1");
    }

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getImagePreview() {
        return page.locator("img.preview-image, .image-preview");
    }

    public Locator getRemoveFurnitureToggle() {
        return page.locator("input[type='checkbox']");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select[name='roomType'], .room-type-select");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select[name='designStyle'], .design-style-select");
    }

    public Locator getCreateDecorationButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, .result-container");
    }

    public Locator getWarningMessage() {
        return page.locator(".warning-message, .error-message");
    }
}