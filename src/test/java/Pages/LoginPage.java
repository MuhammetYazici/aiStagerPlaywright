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
        return page.locator("input[name='email'], input[placeholder='you@example.com']").first();
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']").first();
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button:has-text('Giriş Yap')").first();
    }

    public Locator getGozIkonu() {
        return page.locator(".eye-icon, [data-icon='eye']").first();
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')").first();
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur, .validation-error").first();
    }

    public Locator getGenelHataUyarısı() {
        return page.locator("text=E-posta veya şifre hatalı, .alert-danger").first();
    }
}