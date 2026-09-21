package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class AIEditPage extends BasePage {

    public Locator currentImageRadio() {
        return page.locator("input[type='radio']").first();
    }

    public Locator describeInput() {
        return page.getByPlaceholder("Pencerenin önüne gri bir berjer ekle");
    }

    public Locator editPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator alertMessage() {
        return page.locator(".alert, .error-message, div:has-text('talimat')");
    }
}