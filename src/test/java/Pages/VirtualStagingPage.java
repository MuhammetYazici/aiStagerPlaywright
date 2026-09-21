package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class VirtualStagingPage extends BasePage {

    public Locator uploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator roomTypeSelect() {
        return page.locator("select[name='roomType'], div[role='combobox']").first();
    }

    public Locator designStyleSelect() {
        return page.locator("select[name='designStyle'], div[role='combobox']").nth(1);
    }

    public Locator removeExistingFurnitureToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator visibilityRadioButton() {
        return page.locator("input[type='radio']").first();
    }

    public Locator createDecorationButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator successMessage() {
        return page.locator(".success-message, div:has-text('Başarılı')");
    }

    public Locator errorMessage() {
        return page.locator(".error-message, div:has-text('Geçersiz'), div:has-text('zorunlu')");
    }

    public Locator aiEditPageLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AI Edit"));
    }
}