package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getBeforeAfterSlider() {
        return page.locator(".before-after-slider, input[type='range']").first();
    }

    public Locator getFurnishedAndEmptyRoomIndicators() {
        return page.locator(".room-indicator, .slider-marker");
    }

    public Locator getLanguageDropdown() {
        return page.locator("button:has-text('EN'), select#language, .lang-selector");
    }

    public Locator getStaticAndDynamicTexts() {
        return page.locator("body");
    }

    public Locator getGalleryMenu() {
        return page.locator("a:has-text('Galeri'), a[href*='gallery']");
    }

    public Locator getLivingRoomFilter() {
        return page.locator("button:has-text('Oturma Odası'), label:has-text('Oturma Odası')");
    }

    public Locator getLivingRoomDesignsList() {
        return page.locator(".design-card, .gallery-item");
    }

    public Locator getLoadMoreDesignsButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), button:has-text('Load More')");
    }

    public Locator getFaqSection() {
        return page.locator("#faq, .faq-section");
    }

    public Locator getFaqAccordionOne() {
        return page.locator(".accordion-item:nth-child(1) button, .faq-item:nth-child(1)");
    }

    public Locator getFaqContentOne() {
        return page.locator(".accordion-item:nth-child(1) .content, .faq-content-1");
    }

    public Locator getFaqAccordionTwo() {
        return page.locator(".accordion-item:nth-child(2) button, .faq-item:nth-child(2)");
    }

    public Locator getFaqContentTwo() {
        return page.locator(".accordion-item:nth-child(2) .content, .faq-content-2");
    }

    public Locator getLoginButtonHeader() {
        return page.locator("a:has-text('Giriş Yap'), button:has-text('Giriş Yap')");
    }

    public Locator getFreeTrialButtonHeader() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getProductionsMenu() {
        return page.locator("a:has-text('Üretimlerim'), .productions-menu");
    }

    public Locator getProfileIcon() {
        return page.locator(".profile-icon, img[alt='Profile']");
    }

    public Locator getFastRenderMenu() {
        return page.locator("a:has-text('Hızlı Render')");
    }

    public Locator getCameraPanel() {
        return page.locator("a:has-text('Kamera Paneli')");
    }

    public Locator getNewsletterSection() {
        return page.locator(".newsletter-section, footer");
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta'], input[placeholder*='Email']");
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("button:has-text('Kayıt Ol'), button:has-text('Abone Ol'), button[type='submit']");
    }

    public Locator getSuccessNewsletterMessage() {
        return page.locator(".success-message, text=Başarıyla kayıt oldunuz");
    }

    public Locator getInvalidEmailWarning() {
        return page.locator("text=Geçerli bir e-posta adresi giriniz, .error-message");
    }
}