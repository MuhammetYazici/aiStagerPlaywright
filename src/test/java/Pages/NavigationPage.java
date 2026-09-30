package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getProductsMenu() {
        return page.getByText("Ürünler");
    }

    public Locator getVirtualTourOption() {
        return page.getByText("Yapay Zeka Sanal Tur");
    }

    public Locator getApiOption() {
        return page.getByText("Sanal Dekorasyon API");
    }

    public Locator getEarlyAccessEmailInput() {
        return page.getByPlaceholder("you@example.com").first();
    }

    public Locator getEarlyAccessButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim Talep Et"));
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, .toast-success, text=başarıyla").first();
    }

    public Locator getApiFormNameInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']").first();
    }

    public Locator getApiFormEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='E-posta']").first();
    }

    public Locator getSubmitButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getPricingButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }
}