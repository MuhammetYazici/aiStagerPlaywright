package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getAdInput() {
        return page.locator("input[name='firstName']");
    }

    public Locator getSoyadInput() {
        return page.locator("input[name='lastName']");
    }

    public Locator getRegisterEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getRegisterPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getAktivasyonMesaji() {
        return page.locator(".activation-success");
    }

    public Locator getSifreUzunlukHatasi() {
        return page.locator(".text-danger:has-text('8 karakter')");
    }

    public Locator getSifreEslesmediHatasi() {
        return page.locator(".text-danger:has-text('eşleşmiyor')");
    }

    public Locator getZatenKayitliHatasi() {
        return page.locator(".text-danger:has-text('zaten kullanımda')");
    }

    public Locator getSozlesmeOnayHatasi() {
        return page.locator(".text-danger:has-text('sözleşme')");
    }
}