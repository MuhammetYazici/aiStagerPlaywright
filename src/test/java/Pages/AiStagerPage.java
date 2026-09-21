package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPage {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
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

    public Locator getSubmitButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getLoginButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getGoogleButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getSlider() {
        return page.locator(".slider, input[type='range']").first();
    }

    public Locator getCarouselItem() {
        return page.locator(".carousel-item, button[role='tab']").first();
    }

    public Locator getUploadButton() {
        return page.locator("button:has-text('Odanızı Yükleyin'), a:has-text('Odanızı Yükleyin')").first();
    }

    public Locator getLanguageDropdown() {
        return page.locator(".language-selector, select").first();
    }

    public Locator getHeaderMenu() {
        return page.locator("header");
    }

    public Locator getGalleryFilter() {
        return page.locator(".gallery-filter, button:has-text('Tüm Tipler')").first();
    }

    public Locator getGalleryCard() {
        return page.locator(".gallery-card, .design-card").first();
    }

    public Locator getLikeButton() {
        return page.locator(".like-button, svg.heart").first();
    }

    public Locator getLoadMoreButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')").first();
    }

    public Locator getFaqAccordion() {
        return page.locator(".accordion-item, .faq-item").first();
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']").first();
    }

    public Locator getNewsletterSubmit() {
        return page.locator("button:has-text('Gönder'), button[type='submit']").first();
    }

    public Locator getFooter() {
        return page.locator("footer");
    }

    public Locator getPasswordToggle() {
        return page.locator(".password-toggle, .eye-icon").first();
    }
}