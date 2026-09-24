package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getProductsDropdown() {
        return page.locator("text=Ürünler");
    }

    public Locator getVirtualTourOption() {
        return page.locator("text=Yapay Zeka Sanal Tur");
    }

    public Locator getApiOption() {
        return page.locator("text=Sanal Dekorasyon API");
    }

    public Locator getEarlyAccessButton() {
        return page.locator("text=Erken Erişim İsteyin");
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email']");
    }

    public Locator getSubmitButton() {
        return page.locator("button[type='submit']");
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message");
    }

    public Locator getContactUsButton() {
        return page.locator("text=İletişime Geçin");
    }

    public Locator getNameInput() {
        return page.locator("input[name='name']");
    }

    public Locator getMessageInput() {
        return page.locator("textarea[name='message']");
    }

    public Locator getPricingButton() {
        return page.locator("text=Fiyatlandırmayı Görüntüle");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, [role='alert'], .alert-danger");
    }
}