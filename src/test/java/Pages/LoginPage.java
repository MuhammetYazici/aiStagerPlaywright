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
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']");
    }

    public Locator getDashboardYonlendirme() {
        return page.locator(".dashboard, text=Dashboard, text=Panel");
    }

    public Locator getZorunluAlanHataMesaji() {
        return page.locator("text=Bu alan zorunludur, .error-text");
    }

    public Locator getGenericHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı, .error-alert");
    }

    public Locator getSifreMaskelemeGozIkonu() {
        return page.locator(".toggle-password, .eye-icon, button[aria-label*='password']").first();
    }
}