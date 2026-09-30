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

    public Locator getOdaniziYukleyinButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Odanızı Yükleyin"));
    }

    public Locator getOdaTuruSelect() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tüm Tipler"));
    }

    public Locator getTasarimStiliSelect() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oturma Odası"));
    }

    public Locator getDekorasyonOlusturButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getToggleMobilya() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("View comparison 1"));
    }

    public Locator getVirtualStagingHeader() {
        return page.getByText("Virtual Staging");
    }

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getRemoveFurnitureCheckbox() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select, [role='combobox']").first();
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select, [role='combobox']").nth(1);
    }

    public Locator getCreateDecorationButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getResultImage() {
        return page.locator("img.result-image, .ai-result-container img").first();
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, .alert-danger").first();
    }

    public Locator getAiEditTab() {
        return page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("AI Edit"));
    }

    public Locator getSourceImageSelector() {
        return page.locator(".source-image-item, img.selectable-image").first();
    }

    public Locator getDescribeInput() {
        return page.getByPlaceholder("Describe what to change");
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }
}