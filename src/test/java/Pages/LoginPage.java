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
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[type='password']").first();
    }

    public Locator getGozIkonu() {
        return page.locator(".eye-icon, button.toggle-password").first();
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']").first();
    }

    public Locator getDashboardYonetim() {
        return page.locator(".dashboard, .user-panel");
    }

    public Locator getSifremiUnuttumBaglantisi() {
        return page.locator("text=Şifremi unuttum");
    }

    public Locator getSifreSifirlamaEkrani() {
        return page.locator("text=Şifre Sıfırlama");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }

    public Locator getGoogleKimlikDogrulamaPenceresi() {
        return page.locator("iframe[src*='google'], .google-login-modal");
    }

    public Locator getBuAlanZorunludurUyarisi() {
        return page.locator("text=Bu alan zorunludur");
    }

    public Locator getGecerliEpostaUyarisi() {
        return page.locator("text=Lütfen geçerli bir e-posta adresi girin");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı");
    }

    public Locator getGuvenlikFiltreMesaji() {
        return page.locator("text=Geçersiz karakter");
    }
}