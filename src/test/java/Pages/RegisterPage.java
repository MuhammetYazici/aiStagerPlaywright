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
        return page.locator("input[name='email'], input[placeholder='you@example.com']").first();
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']").first();
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder='Şifrenizi tekrar girin']").first();
    }

    public Locator getTermsCheckbox() {
        return page.locator("input#terms-accept, input[type='checkbox']").first();
    }

    public Locator getKayitOlButton() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')").first();
    }

    public Locator getHesapOlusturOnayMesaji() {
        return page.locator("text=Hesap başarıyla oluşturuldu, .success-alert").first();
    }

    public Locator getSifreKriterHataMesaji() {
        return page.locator("text=en az 8 karakter, text=eşleşmiyor").first();
    }

    public Locator getSozlesmeHataMesaji() {
        return page.locator("text=Sözleşmenin onaylanması gerekiyor").first();
    }

    public Locator getGonderButton() {
        return page.locator("button[type='submit']").first();
    }

    public Locator getSecurityInput() {
        return page.locator("input[type='text'], input[type='email']").first();
    }

    public Locator getIslemButton() {
        return page.locator("button[type='submit']").first();
    }
}