package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[name='email']").first();
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input#password").first();
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input#confirmPassword").first();
    }

    public Locator getTermsCheckbox() {
        return page.locator("input[type='checkbox'], input[name='terms']").first();
    }

    public Locator getRegisterButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kayıt Ol"));
    }

    public Locator getSuccessNotification() {
        return page.locator("text='başarıyla', text='aktivasyon'").first();
    }

    public Locator getPasswordMismatchError() {
        return page.locator("text='Şifreler eşleşmiyor'").first();
    }

    public Locator getEmailInUseError() {
        return page.locator("text='Bu e-posta adresi zaten kullanımda'").first();
    }

    public Locator getTermsRequiredError() {
        return page.locator("text='sözleşme', text='onay'").first();
    }

    public Locator getLoginLink() {
        return page.locator("text='Giriş yap'").first();
    }

    public Locator getGoogleRegisterButton() {
        return page.locator("text='Google ile devam et', button:has-text('Google')").first();
    }
}