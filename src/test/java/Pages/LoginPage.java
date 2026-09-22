package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']").first();
    }

    public Locator getHataMesaji(String hataMesaji) {
        return page.locator("text=" + hataMesaji);
    }

    public Locator getGozIkonu() {
        return page.locator(".password-toggle-icon, [aria-label='Show password']");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }
}