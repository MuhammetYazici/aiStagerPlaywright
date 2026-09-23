package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder*='Min. 8 karakter']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder*='Şifrenizi tekrar']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getCreateAccountButton() {
        return page.locator("button[type='submit']:has-text('Hesap Oluştur'), button:has-text('Hesap Oluştur')");
    }

    public Locator getRegisterErrorMessage() {
        return page.locator(".error-message, .alert-danger, text=şifre");
    }

    public Locator getEmailAlreadyExistsError() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda");
    }

    public Locator getTermsWarningMessage() {
        return page.locator("text=sözleşme, text=kabul etmelisiniz, .terms-error");
    }

    public Locator getGoogleOAuthButton() {
        return page.locator("button:has-text('Google ile devam et'), button:has-text('Google')");
    }
}