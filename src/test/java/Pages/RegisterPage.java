package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator emailInput() {
        return page.locator("input[type='email'], #register-email");
    }

    public Locator passwordInput() {
        return page.locator("input[name='password'], #register-password");
    }

    public Locator confirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], #confirm-password");
    }

    public Locator termsCheckbox() {
        return page.locator("input[type='checkbox'], #terms");
    }

    public Locator submitRegisterButton() {
        return page.locator("button[type='submit'], button:has-text('Kayıt Ol'), button:has-text('Register')");
    }

    public Locator emailAlreadyInUseError() {
        return page.locator(":text('zaten kullanımda'), :text('already in use')");
    }

    public Locator passwordMismatchError() {
        return page.locator(":text('eşleşmiyor'), :text('match')");
    }

    public Locator termsRequiredError() {
        return page.locator(":text('sözleşme'), :text('terms')");
    }

    public Locator googleOAuthButton() {
        return page.locator("button:has-text('Google ile devam et'), button:has-text('Continue with Google')");
    }
}