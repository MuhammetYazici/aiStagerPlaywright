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
        return page.locator("h1:has-text('Virtual Staging'), h2:has-text('Virtual Staging')");
    }

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getPreviewImage() {
        return page.locator("img[alt*='preview'], .preview-image, img.uploaded-image");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("text='Oda Türü', select[name*='room'], [aria-label*='Oda Türü']");
    }

    public Locator getRoomTypeOption(String optionText) {
        return page.locator("text='" + optionText + "'");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("text='Tasarım Stili', select[name*='style'], [aria-label*='Tasarım Stili']");
    }

    public Locator getDesignStyleOption(String optionText) {
        return page.locator("text='" + optionText + "'");
    }

    public Locator getRemoveFurnitureToggle() {
        return page.locator("input[type='checkbox'][name*='remove'], .toggle-switch");
    }

    public Locator getPublicGalleryCheckbox() {
        return page.locator("text='Herkese açık galeride göster', input[type='checkbox'][name*='public']");
    }

    public Locator getCreateDecorationButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Generate')");
    }

    public Locator getLoadingOrActiveButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Oluşturuluyor')");
    }

    public Locator getSuccessDecoratedImage() {
        return page.locator("img.result-image, .output-container img");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, [role='alert'], text='hata', text='çok büyük', text='boş bırakılamaz'");
    }

    public Locator getEmptyPreviewArea() {
        return page.locator(".empty-preview, .upload-placeholder");
    }

    public Locator getAiEditTab() {
        return page.locator("text='AI Edit', button:has-text('AI Edit')");
    }

    public Locator getCurrentImageViewSource() {
        return page.locator("text='Current image', input[value*='current']");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='describe'], input[placeholder*='talimat'], textarea");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo'), button:has-text('Düzenle')");
    }
}