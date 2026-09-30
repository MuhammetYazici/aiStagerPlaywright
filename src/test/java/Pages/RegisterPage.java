package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getSifreInput() {
        return page.getByPlaceholder("Min. 8 karakter");
    }

    public Locator getSifreyiOnaylaInput() {
        return page.getByPlaceholder("Şifrenizi tekrar girin");
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("input[type='checkbox']");
    }

    public Locator getHesapOlusturButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getGozIkonu() {
        return page.locator(".eye-icon, [class*='password-toggle']").first();
    }

    public Locator getGirisYapBaglantisi() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getZorunluAlanUyarisi() {
        return page.getByText("zorunludur", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getEpostaFormatUyarisi() {
        return page.getByText("geçerli", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.getByText("zaten kullanımda", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getMinimumUzunlukUyarisi() {
        return page.getByText("en az 8 karakter", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getSifrelerEslesmiyorUyarısı() {
        return page.getByText("Şifreler eşleşmiyor", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getSozlesmeOnayUyarisi() {
        return page.getByText("sözleşme", new Page.GetByTextOptions().setExact(false));
    }
}