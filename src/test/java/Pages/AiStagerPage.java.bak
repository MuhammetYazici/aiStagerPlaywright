package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPage() {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
    }

    public Locator getBeforeAfterSlider() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getLanguageMenu() {
        return page.locator("text=TR, [class*='language']");
    }

    public Locator getOturmaOdasiFilter() {
        return page.locator("text=Oturma Odasi");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getFirstSssQuestion() {
        return page.locator(".faq-item, [class*='accordion']").first();
    }

    public Locator getSecondSssQuestion() {
        return page.locator(".faq-item, [class*='accordion']").nth(1);
    }

    public Locator getLoginButtonTop() {
        return page.getByText("Giriş yap", new Page.GetByTextOptions().setExact(true));
    }

    public Locator getFreeTrialButtonTop() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfileIcon() {
        return page.locator("[class*='profile'], [aria-label='Profile']");
    }

    public Locator getNavProducts() {
        return page.locator("text=ürün");
    }

    public Locator getNavSolutions() {
        return page.locator("text=çözüm");
    }

    public Locator getNavResources() {
        return page.locator("text=kaynak");
    }

    public Locator getNavPricing() {
        return page.locator("text=fiyatlandırma");
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("button:has-text('Abone Ol'), button:has-text('Gönder')");
    }

    public Locator getSuccessMessage() {
        return page.locator("text=Başarılı, text=Abone Olundu");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getRegisterSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getPasswordToggleIcon() {
        return page.locator("[class*='eye-icon'], [class*='visibility']");
    }

    public Locator getGoogleLoginButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getErrorMessage() {
        return page.locator("[class*='error'], [class*='alert']");
    }
}