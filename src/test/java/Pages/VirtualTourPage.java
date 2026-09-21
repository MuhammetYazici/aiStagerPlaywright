package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class VirtualTourPage extends BasePage {

    public Locator emailInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator submitFormButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator successNotification() {
        return page.locator(".success, div:has-text('başarı'), div:has-text('alındı')");
    }

    public Locator validationError() {
        return page.locator(".error, div:has-text('zorunlu'), div:has-text('geçerli')");
    }
}