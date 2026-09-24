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

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getUploadedImagePreview() {
        return page.locator(".preview-image, img[alt='uploaded']");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, text='Geçersiz dosya formatı'");
    }

    public Locator getPreviewSize() {
        return page.locator(".preview-container");
    }

    public Locator getMaxSizeErrorMessage() {
        return page.locator("text='Dosya boyutu çok büyük'");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select[name='roomType'], [aria-label='Oda Türü']");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select[name='designStyle'], [aria-label='Tasarım Stili']");
    }

    public Locator getRemoveExistingFurnitureToggle() {
        return page.locator("input[type='checkbox'].remove-furniture, #remove-furniture");
    }

    public Locator getVisibilityRadioButton() {
        return page.locator("input[type='radio']").first();
    }

    public Locator getGenerateButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Generate')");
    }

    public Locator getLoadingAnimation() {
        return page.locator(".loading-spinner, .spinner");
    }

    public Locator getGeneratedResultImage() {
        return page.locator(".result-image, img[alt='staged']");
    }
}