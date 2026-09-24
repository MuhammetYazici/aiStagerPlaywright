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
        return page.locator("input[type='email'], input[name='email']").first();
    }

    public Locator getSifreInput() {
        return page.locator("input[type='password'], input[name='password']").first();
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap")).first();
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur").first();
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.locator("text=Geçerli bir e-posta adresi girin").first();
    }

    public Locator getGenelHataUyarisi() {
        return page.locator(".alert-danger, [class*='error']").first();
    }
}