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

    public Locator getSifreInput() {
        return page.locator("input[name='password']");
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getKayitOlButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getParolaPolitikaHatasi() {
        return page.locator(".password-error, [class*='error']");
    }

    public Locator getKullaniciSozlesmesiCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getSozlesmeZorunluUyarisi() {
        return page.locator(".terms-error, [class*='terms']");
    }

    public Locator getVarolanEpostaInput() {
        return page.locator("input[name='email']");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.getByText("zaten kullanımda");
    }

    public Locator getHosgeldinMesaji() {
        return page.getByText("Hoş geldin");
    }
}