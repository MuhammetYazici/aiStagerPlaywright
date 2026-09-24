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

    public Locator getEpostaInput() {
        return page.locator("input[type='email'], input[name='email']").first();
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input#password").first();
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword'], input#confirmPassword").first();
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getKayitOlButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kayıt Ol")).first();
    }

    public Locator getGozIkonu() {
        return page.locator(".toggle-password, [class*='eye-icon']").first();
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur").first();
    }

    public Locator getSifreUzunlukUyarisi() {
        return page.locator("text=en az 8 karakter").first();
    }

    public Locator getSifrelerEslenmiyorUyarisi() {
        return page.locator("text=Şifreler eşleşmiyor").first();
    }

    public Locator getSozlesmeUyarisi() {
        return page.locator("text=Sözleşmeyi kabul etmelisiniz").first();
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda").first();
    }
}