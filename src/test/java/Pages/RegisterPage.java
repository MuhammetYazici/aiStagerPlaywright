package Pages;

import Utilities.PD;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
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

    public Locator getCreateAccountButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getLoginLink() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getCreditBalance() {
        return page.locator(".credit-balance, [data-testid='credit-balance']");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, [role='alert']");
    }
}