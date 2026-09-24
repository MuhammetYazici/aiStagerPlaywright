package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator emailInput() {
        return page.locator("input[type='email'], #email");
    }

    public Locator passwordInput() {
        return page.locator("input[type='password'], #password");
    }

    public Locator passwordToggleVisibilityIcon() {
        return page.locator(".password-toggle, svg.fa-eye, svg.fa-eye-slash");
    }

    public Locator submitLoginButton() {
        return page.locator("button[type='submit'], button:has-text('Giriş Yap'), button:has-text('Login')");
    }

    public Locator dashboardElement() {
        return page.locator(".dashboard, .main-panel, #dashboard");
    }

    public Locator requiredFieldError() {
        return page.locator(":text('bu alan zorunlu'), :text('required')");
    }

    public Locator invalidEmailFormatError() {
        return page.locator(":text('geçerli e-posta'), :text('valid email')");
    }

    public Locator generalAuthError() {
        return page.locator(".auth-error, :text('hatalı'), :text('invalid credentials')");
    }

    public Locator googleOAuthButton() {
        return page.locator("button:has-text('Google ile devam et'), button:has-text('Continue with Google')");
    }
}