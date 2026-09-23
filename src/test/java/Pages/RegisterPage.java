package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getKayitEpostaAlani() {
        return page.locator("input[name='email']");
    }

    public Locator getKayitSifreAlani() {
        return page.locator("input[name='password']");
    }

    public Locator getSifreyiOnaylaAlani() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getKayitOlButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getHataMesajiDiv() {
        return page.locator(".error-message, [class*='error']");
    }

    public Locator getKullaniciSozlesmesiCheckbox() {
        return page.locator("input#terms-accept, input[type='checkbox']");
    }

    public Locator getSozlesmeOnayUyarisi() {
        return page.locator("text=Sözleşme");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda");
    }

    public Locator getBasariliKayitMesaji() {
        return page.locator("text=Hesabınız başarıyla oluşturuldu");
    }

    public Locator getGoogleIleDevamEtButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getGoogleDogrulamaPenceresi() {
        return page.locator("iframe[src*='accounts.google.com'], .google-login-modal");
    }
}