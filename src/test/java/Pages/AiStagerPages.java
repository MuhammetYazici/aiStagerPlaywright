package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPages {
    private Page page;

    public AiStagerPages() {
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

    public Locator getLoginButton() {
        return page.locator("button:has-text('Giriş yap'), button[type='submit']").first();
    }

    public Locator getRegisterButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getGoogleLoginButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }

    public Locator getAcceptAllCookiesButton() {
        return page.locator("button:has-text('Tümünü Kabul Et')");
    }

    public Locator getSliderRightArrow() {
        return page.locator(".slider-right-arrow, [aria-label='Next'], button.right-arrow").first();
    }

    public Locator getBeforeAfterSlider() {
        return page.locator(".before-after-slider, .slider-container").first();
    }

    public Locator getCarouselDots() {
        return page.locator(".carousel-dot, .swiper-pagination-bullet").first();
    }

    public Locator getHeaderLogo() {
        return page.locator("header img, .logo, a:has-text('AiStager')").first();
    }

    public Locator getProductsMenu() {
        return page.locator("nav a:has-text('Ürünler'), a:has-text('Ürünler')").first();
    }

    public Locator getSolutionsMenu() {
        return page.locator("nav a:has-text('Çözümler'), a:has-text('Çözümler')").first();
    }

    public Locator getResourcesMenu() {
        return page.locator("nav a:has-text('Kaynaklar'), a:has-text('Kaynaklar')").first();
    }

    public Locator getPricingMenu() {
        return page.locator("nav a:has-text('Fiyatlandırma'), a:has-text('Fiyatlandırma')").first();
    }

    public Locator getLanguageSelector() {
        return page.locator(".language-selector, select.lang").first();
    }

    public Locator getFreeTrialButton() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')").first();
    }

    public Locator getMyProductionsIcon() {
        return page.locator("a:has-text('Üretimlerim'), .productions-icon").first();
    }

    public Locator getProfileSettingsIcon() {
        return page.locator("a:has-text('Profil'), .profile-icon").first();
    }

    public Locator getCommunityGallerySection() {
        return page.locator("#community-gallery, .community-gallery").first();
    }

    public Locator getRoomTypeFilter() {
        return page.locator("select.room-filter, button:has-text('Oturma Odası')").first();
    }

    public Locator getGalleryList() {
        return page.locator(".gallery-grid, .design-list").first();
    }

    public Locator getHeartIcon() {
        return page.locator(".heart-icon, button.like-btn").first();
    }

    public Locator getLoadMoreDesignsButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')").first();
    }

    public Locator getFaqSection() {
        return page.locator("#faq, .faq-section").first();
    }

    public Locator getFirstFaqAccordion() {
        return page.locator(".accordion-item:nth-child(1), .faq-item:nth-child(1)").first();
    }

    public Locator getSecondFaqAccordion() {
        return page.locator(".accordion-item:nth-child(2), .faq-item:nth-child(2)").first();
    }

    public Locator getFooterSection() {
        return page.locator("footer, .footer").first();
    }

    public Locator getNewsletterInput() {
        return page.locator("footer input[type='email'], input[placeholder*='email']").first();
    }

    public Locator getNewsletterSubscribeButton() {
        return page.locator("footer button:has-text('Abone Ol'), footer button[type='submit']").first();
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, .toast-success, div:has-text('başarıyla')").first();
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, .invalid-feedback, div:has-text('zorunludur')").first();
    }

    public Locator getPrivacyPolicyLink() {
        return page.locator("footer a:has-text('Gizlilik Politikası')").first();
    }

    public Locator getPasswordToggleIcon() {
        return page.locator(".password-toggle, button.toggle-password, .eye-icon").first();
    }
}