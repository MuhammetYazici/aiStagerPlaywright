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
        return page.locator("input[name='email']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password']");
    }

    public Locator getGozIkonu() {
        return page.locator(".password-toggle, button.toggle-password, .eye-icon");
    }

    public Locator getGirisYapButonu() {
        return page.locator("button:has-text('Giriş Yap'), button[type='submit']");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, .alert-danger");
    }

    public Locator getSifreOnaylaInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getHesapOlusturButonu() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }
}