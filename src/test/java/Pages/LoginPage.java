package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[type='password']").first();
    }

    public Locator getLoginSubmitButton() {
        return page.locator("button[type='submit'], button:has-text('Giriş Yap')");
    }

    public Locator getRequiredFieldWarning() {
        return page.locator("text=Bu alan zorunludur, .error-text");
    }

    public Locator getGeneralLoginError() {
        return page.locator("text=E-posta veya şifre hatalı, .alert-error");
    }

    public Locator getPasswordEyeIcon() {
        return page.locator(".eye-icon, button.toggle-password, .password-toggle");
    }

    public Locator getInternalServerErrorWarning() {
        return page.locator("text=Internal Server Error");
    }
}