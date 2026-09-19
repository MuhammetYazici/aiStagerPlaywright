package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPages {
    private Page page;

    public AiStagerPages() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getPasswordInput() {
        return page.getByPlaceholder("Min. 8 karakter");
    }

    public Locator getConfirmPasswordInput() {
        return page.getByPlaceholder("Şifrenizi tekrar girin");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getCreateAccountButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getLoginLink() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getGoogleLoginButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getAcceptAllCookiesButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }
}