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

    public Locator getGirisYapButton() {
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text='Bu alan zorunludur'");
    }

    public Locator getGecerliEmailUyarisi() {
        return page.locator("text='Lütfen geçerli bir e-posta adresi girin'");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text='E-posta veya şifre hatalı'");
    }

    public Locator getGozyasiGozIkonu() {
        return page.locator(".toggle-password, [class*='eye']");
    }
}