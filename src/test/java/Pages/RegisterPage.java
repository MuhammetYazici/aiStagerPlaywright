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
        return page.locator("#terms-accept, input[type='checkbox']").first();
    }

    public Locator getHesapOlusturButonu() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')").first();
    }

    public Locator getHataMesaji(String hata) {
        return page.locator("text=" + hata).first();
    }
}