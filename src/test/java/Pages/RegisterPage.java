package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getRegisterEmailInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getRegisterPasswordInput() {
        return page.locator("input[name='password'], input[type='password']").first();
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder*='Şifrenizi tekrar']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getRegisterSubmitButton() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')");
    }

    public Locator getAlreadyInUseError() {
        return page.locator("text=zaten kullanımda, text=already in use");
    }

    public Locator getPasswordLengthError() {
        return page.locator("text=en az 8 karakter, text=minimum 8");
    }

    public Locator getPasswordMismatchError() {
        return page.locator("text=şifreler eşleşmiyor, text=match");
    }

    public Locator getTermsError() {
        return page.locator("text=Sözleşmeyi kabul etmelisiniz, text=terms");
    }

    public Locator getSuccessCreationMessage() {
        return page.locator("text=başarıyla oluşturuldu, text=success");
    }
}