package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getProductsMenu() {
        return page.locator("text=Ürünler, text=Products, nav a:has-text('Ürünler')");
    }

    public Locator getVirtualTourMenuOption() {
        return page.locator("nav a[href*='ai-virtual-tour'], .dropdown-menu a:nth-child(2)");
    }

    public Locator getApiMenuOption() {
        return page.locator("nav a[href*='/api'], .dropdown-menu a:nth-child(3)");
    }

    public Locator getEarlyAccessButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[name='email']");
    }

    public Locator getGeneralInput() {
        return page.locator("input[type='text'], input:not([type='hidden'])");
    }

    public Locator getSubmitButton() {
        return page.locator("button[type='submit'], button:has-text('Gönder'), button:has-text('Submit')");
    }

    public Locator getSuccessMessage() {
        return page.locator("text=başarıyla, text=success, .success-message");
    }

    public Locator getContactUsButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getNameInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMessageInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getPricingLink() {
        return page.locator("a[href*='pricing'], button:has-text('Fiyatlandırmayı Görüntüle')");
    }

    public Locator getValidationError() {
        return page.locator(".error, text=eksik, text=boş bırakılamaz");
    }
}