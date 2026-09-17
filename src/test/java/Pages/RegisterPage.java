package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

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

    public Locator getSubmitButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getLoginLink() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getCreditBalance() {
        return page.locator(".credit-balance, [data-testid='credit-balance']");
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, :text('Kayıt başarılı')");
    }
}