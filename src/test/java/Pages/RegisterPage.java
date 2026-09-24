package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email']").first();
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password']").first();
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword']").first();
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("#terms-accept").first();
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur')").first();
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message").first();
    }
}