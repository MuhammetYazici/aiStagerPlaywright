package Pages;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[type='password']");
    }

    public Locator getGirisYapButton() {
        return page.locator("button:text('Giriş Yap'), button[type='submit']");
    }

    public Locator getZorunluAlanHataMesaji() {
        return page.locator("text='Bu alan zorunludur'");
    }

    public Locator getEmailValidasyonHataMesaji() {
        return page.locator("text='Geçerli bir e-posta'");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text='E-posta veya şifre hatalı'");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".toggle-password, .eye-icon");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:text('Google ile devam et')");
    }

    public Locator getAuthLink(String linkAdi) {
        return page.locator("a:text('" + linkAdi + "')");
    }
}