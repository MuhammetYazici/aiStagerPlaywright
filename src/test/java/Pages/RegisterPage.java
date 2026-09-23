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
        return page.locator("input#terms-accept, input[type='checkbox']");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button[type='submit']:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')");
    }

    public Locator getGoogleKayıtButton() {
        return page.locator("button:has-text('Google ile devam et'), button:has-text('Google ile Kayıt Ol')");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur");
    }

    public Locator getAyniEmailHataMesaji() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda");
    }

    public Locator getHataMesajiDinamik(String mesaj) {
        return page.locator("text=" + mesaj);
    }

    public Locator getSozlesmeUyarisi() {
        return page.locator("text=sözleşme, text=onaylanması gerektiği");
    }
}