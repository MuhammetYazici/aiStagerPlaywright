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

    public Locator getEpostaAlani() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getSifreAlani() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getGirisYapSubmitButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getFormGonderimEngeliUyarisi() {
        return page.locator(".validation-error, [class*='alert']");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".password-toggle-icon, [class*='eye']");
    }
}