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
        return page.locator("input[name='email'], input[placeholder='you@example.com']").first();
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']").first();
    }

    public Locator getGirisYapSubmitButonu() {
        return page.locator("button[type='submit'], button:has-text('Giriş Yap')").first();
    }

    public Locator getPanelYonlendirmeKontrolu() {
        return page.locator(".dashboard, text=Panel").first();
    }

    public Locator getBosAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur, .error").first();
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.locator("text=Lütfen geçerli bir e-posta adresi girin, .error").first();
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı, .alert-danger").first();
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".password-toggle, .eye-icon, button:has(svg)").first();
    }
}