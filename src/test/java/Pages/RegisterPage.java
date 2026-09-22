package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getKayitEpostaInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']").first();
    }

    public Locator getKayitSifreInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']").first();
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder='Şifrenizi tekrar girin']").first();
    }

    public Locator getKullaniciSozlesmesiCheckbox() {
        return page.locator("input#terms-accept, input[type='checkbox']").first();
    }

    public Locator getKayitOlButonu() {
        return page.locator("button[type='submit']:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')").first();
    }

    public Locator getBasariliKayitYonlendirme() {
        return page.locator(".welcome-message, text=Hoş geldiniz").first();
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda, .error").first();
    }

    public Locator getAlanBazliHataMesaji() {
        return page.locator(".error, text=en az 8 karakter, text=eşleşmiyor, text=onaylamalısınız").first();
    }
}