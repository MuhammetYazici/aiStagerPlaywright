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
        return page.locator("h1:has-text('Virtual Staging'), text=Virtual Staging");
    }

    public Locator getUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select[name='roomType'], [data-testid='room-type']");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select[name='designStyle'], [data-testid='design-style']");
    }

    public Locator getRemoveExistingFurnitureToggle() {
        return page.locator("input[type='checkbox'][name='removeFurniture'], [aria-label*='mobilya']");
    }

    public Locator getCreateDecorationButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Create Decoration')");
    }

    public Locator getProcessingIndicator() {
        return page.locator(".spinner, text=İşleniyor, text=Processing");
    }

    public Locator getResultImage() {
        return page.locator("img.result-image, [data-testid='result-image']");
    }

    public Locator getLoginPromptModal() {
        return page.locator("text=Giriş yap, text=Login, .login-modal");
    }

    public Locator getMandatoryFieldWarning() {
        return page.locator("text=zorunlu, text=required, .error-message");
    }

    public Locator getFileFormatError() {
        return page.locator("text=desteklenmiyor, text=invalid format, .error-message");
    }
}