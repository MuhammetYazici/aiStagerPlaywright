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
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getSifreOnaylaInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder='Şifrenizi tekrar girin']");
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getKayitOlButton() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')");
    }

    public Locator getHataMesaji(String hataMesaji) {
        return page.locator("text=" + hataMesaji);
    }
}