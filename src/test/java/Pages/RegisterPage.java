package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
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
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur'), button[type='submit']");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text='Bu alan zorunludur'");
    }

    public Locator getKullanimdaUyarisi() {
        return page.locator("text='Bu e-posta adresi zaten kullanımda'");
    }

    public Locator getSifre uyarsisi() {
        return page.locator("text='Şifreler eşleşmiyor'");
    }

    public Locator getGirisYapLink() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }
}