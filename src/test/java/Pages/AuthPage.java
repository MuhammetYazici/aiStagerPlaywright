package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AuthPage {
    private Page page;

    public AuthPage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder='Şifrenizi tekrar girin']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("input#terms-accept, input[type='checkbox']");
    }

    public Locator getHesapOlusturButonu() {
        return page.locator("button:has-text('Hesap Oluştur'), button[type='submit']");
    }

    public Locator getGirisYapSubmitButonu() {
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator(":text('Bu alan zorunludur'), .error-text");
    }

    public Locator getEpostaFormatUyarisi() {
        return page.locator(":text('geçersiz'), :text('Geçersiz e-posta'), .error-email");
    }

    public Locator getGozIkonu() {
        return page.locator(".toggle-password, .eye-icon, button[aria-label*='password']");
    }

    public Locator getSifrePolitikaVeyaEslesmeHatasi() {
        return page.locator(".password-error, :text('şifre'), :text('eşleşmiyor')");
    }

    public Locator getSozlesmeHataUyarisi() {
        return page.locator(":text('sözleşme'), :text('kabul etmelisiniz')");
    }

    public Locator getGenelGirisHataMesaji() {
        return page.locator(":text('E-posta veya şifre hatalı'), .alert-danger");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator(":text('zaten kullanımda'), :text('Bu e-posta adresi zaten')");
    }

    public Locator getFormGenelAlan() {
        return page.locator("form");
    }
}