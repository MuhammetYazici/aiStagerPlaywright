package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSlider() {
        return page.locator(".slider-container, [class*='slider']");
    }

    public Locator getBeforeAfterImages() {
        return page.locator("img[alt*='Before'], img[alt*='After'], [class*='comparison']");
    }

    public Locator getSliderArrowsOrDots() {
        return page.locator(".carousel-dot, button[class*='arrow'], [class*='indicator']");
    }

    public Locator getLoginButton() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş Yap')");
    }

    public Locator getFreeTrialButton() {
        return page.locator("button:has-text('Ücretsiz Dene'), a:has-text('Ücretsiz Dene')");
    }

    public Locator getProductionsArea() {
        return page.locator("[class*='productions'], text=Üretimlerim");
    }

    public Locator getProfileIcon() {
        return page.locator("[class*='profile-icon'], [aria-label*='Profile']");
    }

    public Locator getNavigationMenuLinks() {
        return page.locator("nav a, header a");
    }

    public Locator getGallerySection() {
        return page.locator(".gallery-section, [class*='gallery']");
    }

    public Locator getAllTypesFilter() {
        return page.locator("button:has-text('Tüm Tipler'), [class*='filter']:has-text('Tüm Tipler')");
    }

    public Locator getRoomTypeFilter() {
        return page.locator(".room-filter-item, [class*='filter-btn']").first();
    }

    public Locator getGalleryCards() {
        return page.locator(".gallery-card, [class*='card']");
    }

    public Locator getLoadMoreButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), button:has-text('Load More')");
    }

    public Locator getHeartIcon() {
        return page.locator("button[class*='heart'], [class*='like-icon']").first();
    }

    public Locator getLikeCount() {
        return page.locator("[class*='like-count']").first();
    }

    public Locator getAuthorName() {
        return page.locator("[class*='author-name'], [class*='creator']").first();
    }

    public Locator getFaqSection() {
        return page.locator(".faq-section, [class*='faq']");
    }

    public Locator getFaqQuestion1() {
        return page.locator(".faq-item:nth-child(1), [class*='faq']:has-text('Soru 1')").first();
    }

    public Locator getFaqContent1() {
        return page.locator(".faq-content:nth-child(1), [class*='faq-answer']").first();
    }

    public Locator getFaqQuestion2() {
        return page.locator(".faq-item:nth-child(2), [class*='faq']:has-text('Soru 2')").first();
    }

    public Locator getFooterSection() {
        return page.locator("footer");
    }

    public Locator getNewsletterInput() {
        return page.locator("footer input[type='email'], [placeholder*='email']");
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("footer button:has-text('Abone Ol'), footer button[type='submit']");
    }

    public Locator getSuccessMessage() {
        return page.locator("[class*='success'], text=Başarılı");
    }

    public Locator getErrorMessage() {
        return page.locator("[class*='error'], [class*='alert']");
    }

    public Locator getFooterLegalLinks() {
        return page.locator("footer a");
    }
}