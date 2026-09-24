package Pages;
import com.microsoft.playwright.options.AriaRole;

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

    public Locator getGirisYapSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap").setExact(false));
    }

    public Locator getZorunlulukUyarilari() {
        return page.locator(".error, [class*='validation']");
    }

    public Locator getEpostaFormatUyarisi() {
        return page.locator(".email-error, [class*='email-validation']");
    }

    public Locator getJenerikHataMesaji() {
        return page.locator(".alert-danger, [class*='alert']");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".password-toggle, [class*='eye-icon']");
    }

    public Locator getGoogleIleGirisButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getGoogleKimlikDogrulamaEkrani() {
        return page.locator("iframe[src*='google'], #credential_picker_container");
    }
}