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
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getGozIkonu() {
        return page.locator(".toggle-password, button:has-text('göz'), .password-eye-icon");
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button[type='submit']:has-text('Giriş Yap'), button:has-text('Giriş yap')");
    }

    public Locator getDashboardPanel() {
        return page.locator(".dashboard-container, text=Panel, text=Üretimlerim");
    }

    public Locator getGoogleGirisButton() {
        return page.locator("button:has-text('Google ile devam et'), button:has-text('Google ile Giriş')");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur");
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.locator("text=Lütfen geçerli bir e-posta adresi girin");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı");
    }
}