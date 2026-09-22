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
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[type='password']");
    }

    public Locator getLoginSubmitButton() {
        return page.locator("button[type='submit']:has-text('Giriş'), button:has-text('Giriş Yap')");
    }

    public Locator getRequiredFieldWarning() {
        return page.locator("text=Bu alan zorunludur, [class*='error']:has-text('zorunlu')");
    }

    public Locator getFormatErrorWarning() {
        return page.locator("text=format, [class*='error']:has-text('geçersiz')");
    }

    public Locator getGeneralErrorMessage() {
        return page.locator("text=hatalı, text=E-posta veya şifre, [class*='alert']");
    }

    public Locator getPasswordEyeIcon() {
        return page.locator("[class*='eye-icon'], [class*='toggle-password']");
    }

    public Locator getGoogleLoginButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }
}