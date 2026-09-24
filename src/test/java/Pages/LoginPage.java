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
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getGozIkonu() {
        return page.locator(".password-toggle-icon, .eye-icon");
    }

    public Locator getGirisYapSubmitButonu() {
        return page.locator("button:text('Giriş Yap'), button[type='submit']");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text='Bu alan zorunludur'");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text='E-posta veya şifre hatalı'");
    }

    public Locator getPanelBasligi() {
        return page.locator(".dashboard, text='Panel'");
    }
}