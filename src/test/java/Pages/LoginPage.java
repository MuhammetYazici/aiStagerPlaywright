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
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button[type='submit']:has-text('Giriş Yap')");
    }

    public Locator getAnaPanel() {
        return page.locator(".dashboard-main-panel");
    }

    public Locator getGenelHataMesaji() {
        return page.locator(".alert-danger:has-text('hatalı')");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".password-toggle-icon");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }

    public Locator getGoogleAuthEkran() {
        return page.locator("iframe[src*='accounts.google.com']");
    }
}