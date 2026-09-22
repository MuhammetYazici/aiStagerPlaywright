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
        return page.locator(".eye-icon, button[aria-label*='password'], .show-password").first();
    }

    public Locator getGirisYapButonu() {
        return page.locator("button:has-text('Giriş yap'), button:has-text('Giriş Yap')").first();
    }

    public Locator getHataMesaji(String hata) {
        return page.locator("text=" + hata).first();
    }

    public Locator getGoogleIleDevamEtButonu() {
        return page.locator("button:has-text('Google ile devam et')").first();
    }

    public Locator getGecisLinki(String linkMetni) {
        return page.locator("a:has-text('" + linkMetni + "')").first();
    }
}