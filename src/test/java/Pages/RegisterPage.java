package Pages;

import Utilities.PD;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class RegisterPage {
    Page page;

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

    public Locator getSuccessMessage() {
        return page.locator(".success-message, text=Kayıt başarılı");
    }

    public Locator getCreditBalance() {
        return page.locator(".credit-balance, text=Kredi");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, text=geçersiz");
    }

    public Locator getAcceptAllCookiesButton() {
        return page.locator("button:has-text('Tümünü Kabul Et')");
    }
}