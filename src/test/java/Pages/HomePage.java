package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapLink() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getTumunuKabulEtButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getAboneOlButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Abone Ol"));
    }

    public Locator getEmailInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getBasariMesaji() {
        return page.locator(".success-message, text=Başarıyla abone oldunuz");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text=Geçerli bir e-posta");
    }
}