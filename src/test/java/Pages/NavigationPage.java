package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getAnaSayfaHeader() {
        return page.locator("header");
    }

    public Locator getUrunlerMenu() {
        return page.locator("text=Ürünler");
    }

    public Locator getVirtualTourLink() {
        return page.locator("a[href*='ai-virtual-tour']");
    }

    public Locator getAPILink() {
        return page.locator("a[href*='/tr/api']");
    }

    public Locator getErkenErisimButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email']");
    }

    public Locator getFormSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getIletisimeGecinButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea");
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }
}