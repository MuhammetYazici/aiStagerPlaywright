package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;
import Utilities.ConfigReader;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getSifreInput() {
        return page.getByPlaceholder("Min. 8 karakter");
    }

    public Locator getGirisYapSubmitButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getGozIkonu() {
        return page.locator(".eye-icon, [class*='password-toggle']").first();
    }

    public Locator getSifremiUnuttumLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Şifremi unuttum?"));
    }

    public Locator getKayitOlLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kayıt ol"));
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getZorunluAlanUyarisi() {
        return page.getByText("zorunludur", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.getByText("Lütfen geçerli bir e-posta adresi girin", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getGenelGuvenlikMesaji() {
        return page.getByText("E-posta veya şifre hatalı", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getGirisYapLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getHesapOlusturButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public void navigateToLogin() {
        page.navigate(ConfigReader.getProperty("url"));
    }

    public Locator getPasswordInput() {
        return page.getByPlaceholder("••••••••");
    }

    public Locator getAcceptCookiesButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[name='email'], #email");
    }

    public Locator getLoginButton() {
        return page.locator("button[type='submit'], input[type='submit'], .login-button");
    }

    public Locator getGirisYapButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }
}