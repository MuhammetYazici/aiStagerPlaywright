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
        return page.locator("input[name='password'], input[placeholder*='karakter']");
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder*='tekrar']");
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getFormGonderimButonu() {
        return page.locator("button[type='submit']");
    }

    public Locator getKayitOlButonu() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')");
    }

    public Locator getGirisYapGonderButonu() {
        return page.locator("button:has-text('Giriş Yap'), button:has-text('Giriş yap')");
    }

    public Locator getBuAlanZorunludurUyarisi() {
        return page.locator("text=Bu alan zorunludur, .error:has-text('zorunlu')");
    }

    public Locator getGecerliEpostaUyarisi() {
        return page.locator("text=Lütfen geçerli bir e-posta adresi girin");
    }

    public Locator getSifrelerEslesmiyorUyarisi() {
        return page.locator("text=Şifreler eşleşmiyor, text=uzunluk kuralı");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda");
    }

    public Locator getGozIkonu() {
        return page.locator(".eye-icon, button[aria-label*='şifre'], [class*='password-toggle']");
    }

    public Locator getGoogleIleDevamEtButonu() {
        return page.locator("button:has-text('Google ile devam et')");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı, text=güvenlik gereği");
    }
}