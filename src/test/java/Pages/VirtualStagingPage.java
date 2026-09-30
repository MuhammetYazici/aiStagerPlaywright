package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getVirtualStagingHeader() {
        return page.getByText("Virtual Staging");
    }

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getImagePreview() {
        return page.locator("img");
    }

    public Locator getRemoveFurnitureToggle() {
        return page.getByText("Mevcut mobilyaları kaldır");
    }

    public Locator getRoomTypeDropdown() {
        return page.getByText("Oda Türü");
    }

    public Locator getDesignStyleDropdown() {
        return page.getByText("Tasarım Stili");
    }

    public Locator getVisibilitySelect() {
        return page.getByText("Görünürlük");
    }

    public Locator getCreateDecorationButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getSuccessResultImage() {
        return page.locator("img");
    }

    public Locator getErrorMessage() {
        return page.getByText("hata");
    }
}