package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[name='email']").first();
    }

    public Locator getPasswordInput() {
        return page.locator("input[type='password'], input[name='password']").first();
    }

    public Locator getSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getDashboardHeader() {
        return page.locator("text='Dashboard', text='Ana Panel'");
    }

    public Locator getPasswordToggleIcon() {
        return page.locator(".toggle-password, .eye-icon").first();
    }

    public Locator getValidationErrorMessage() {
        return page.locator(".validation-error, text='Bu alan zorunludur'").first();
    }

    public Locator getGeneralErrorMessage() {
        return page.locator(".error-alert, text='E-posta veya şifre hatalı'").first();
    }

    public Locator getGoogleLoginButton() {
        return page.locator("text='Google ile devam et', button:has-text('Google')").first();
    }

    public Locator getGoogleOAuthWindow() {
        return page.locator("iframe[src*='google'], .google-oauth-container").first();
    }
}