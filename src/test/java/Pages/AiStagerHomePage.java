package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerHomePage {
    private Page page;

    public AiStagerHomePage() {
        this.page = PD.getPage();
    }

    public Locator getCookieAcceptAllButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getLoginLink() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getNewsletterEmailInput() {
        return page.locator("input[placeholder='you@example.com']");
    }

    public Locator getNewsletterSubscribeButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Abone Ol"));
    }

    public Locator getSuccessMessage() {
        return page.locator("text=Başarıyla abone oldunuz");
    }

    public Locator getErrorMessage() {
        return page.locator("text=Geçerli bir e-posta adresi giriniz");
    }
}