package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email']").first();
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password']").first();
    }

    public Locator getGirisYapButton() {
        return page.locator("button:has-text('Giriş Yap')").first();
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur").first();
    }

    public Locator getGecersizEmailUyarisi() {
        return page.locator("text=geçerli").first();
    }

    public Locator getGenelGuvenlikUyarisi() {
        return page.locator("text=E-posta veya şifre hatalı").first();
    }

    public Locator getGozIkonu() {
        return page.locator(".password-toggle-icon").first();
    }
}