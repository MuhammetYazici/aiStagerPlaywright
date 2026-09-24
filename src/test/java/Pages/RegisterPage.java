package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getAdSoyadInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
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
        return page.locator("button:text('Hesap Oluştur'), button[type='submit']");
    }

    public Locator getBasariliKayitMesaji() {
        return page.locator("text='Hesabınız başarıyla oluşturuldu'");
    }

    public Locator getSifrelerEslenmiyorMesaji() {
        return page.locator("text='Şifreler eşleşmiyor'");
    }

    public Locator getSifreUzunlukUyarisi() {
        return page.locator("text='en az 8 karakter'");
    }

    public Locator getSozlesmeUyarisi() {
        return page.locator("text='sözleşme', text='onay'");
    }

    public Locator getZatenKullanimdaMesaji() {
        return page.locator("text='zaten kullanımda', text='kayıtlı'");
    }
}