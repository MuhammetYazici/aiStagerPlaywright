package Pages;

import com.microsoft.playwright.Locator;

public class RegisterPage extends BasePage {

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
        return page.locator("button:text('Hesap Oluştur')");
    }

    public Locator getSifreUzunlukHataMesaji() {
        return page.locator("text='en az 8 karakter'");
    }

    public Locator getSifrelerEslesmiyorHataMesaji() {
        return page.locator("text='Şifreler eşleşmiyor'");
    }

    public Locator getEmailZatenKullanimdaMesaji() {
        return page.locator("text='Bu e-posta adresi zaten kullanımda'");
    }

    public Locator getZorunluSozlesmeHataMesaji() {
        return page.locator("text='sözleşme', text='zorunlu'");
    }

    public Locator getGoogleKayitOlButton() {
        return page.locator("button:text('Google ile kayıt ol')");
    }

    public Locator getZorunluAlanUyariMesaji() {
        return page.locator("text='Bu alan zorunludur'");
    }
}