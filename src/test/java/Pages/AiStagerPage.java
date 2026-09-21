package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;
import com.microsoft.playwright.options.AriaRole;

public class AiStagerPage {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
    }

    public Locator getSliderLine() {
        return page.locator(".slider-line, [role='slider']");
    }

    public Locator getBeforeAfterImages() {
        return page.locator(".before-after-image, img");
    }

    public Locator getNavigationArrows() {
        return page.locator(".carousel-arrow, button[aria-label*='Next'], button[aria-label*='Prev']");
    }

    public Locator getLoginButtonHeader() {
        return page.getByText("Giriş yap", new Page.GetByTextOptions().setExact(true));
    }

    public Locator getFreeTrialButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getMyProductions() {
        return page.getByText("Üretimlerim");
    }

    public Locator getProfileIcon() {
        return page.locator(".profile-icon, [aria-label='Profile']");
    }

    public Locator getLanguageMenu() {
        return page.locator(".language-selector, select, .dropdown-toggle");
    }

    public Locator getDifferentLanguageOption() {
        return page.locator(".language-option, option:nth-child(2)");
    }

    public Locator getGalleryArea() {
        return page.locator(".gallery-container, section.gallery");
    }

    public Locator getAllTypesFilter() {
        return page.getByText("Tüm Tipler");
    }

    public Locator getLivingRoomFilter() {
        return page.getByText("Oturma Odası");
    }

    public Locator getGalleryCards() {
        return page.locator(".gallery-card, .card");
    }

    public Locator getLoadMoreButton() {
        return page.getByText("Daha Fazla Tasarım Yükle");
    }

    public Locator getFaqQuestion() {
        return page.locator(".faq-question, .accordion-header").first();
    }

    public Locator getFaqAnswer() {
        return page.locator(".faq-answer, .accordion-body").first();
    }

    public Locator getSecondFaqQuestion() {
        return page.locator(".faq-question, .accordion-header").nth(1);
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='email']").first();
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("button[type='submit'], .newsletter-btn").first();
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, .alert-success");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, .alert-danger");
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

    public Locator getSubmitLoginButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getDashboardElement() {
        return page.locator(".dashboard, #dashboard");
    }

    public Locator getPasswordToggleEyeIcon() {
        return page.locator(".password-toggle-icon, .eye-icon");
    }

    public Locator getRequiredFieldError() {
        return page.getByText("Bu alan zorunludur");
    }

    public Locator getEmailFormatError() {
        return page.getByText("E-posta format uyarısı");
    }

    public Locator getGeneralLoginError() {
        return page.getByText("E-posta veya şifre hatalı");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getCreateAccountButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getAlreadyUsedEmailError() {
        return page.getByText("Bu e-posta adresi zaten kullanımda");
    }

    public Locator getPasswordPolicyError() {
        return page.getByText("şifre politikası validasyon hatası");
    }

    public Locator getPasswordMatchError() {
        return page.getByText("Şifreler eşleşmiyor");
    }

    public Locator getTermsRequiredError() {
        return page.getByText("sözleşme onayı gerektiğini belirten bir uyarı");
    }
}