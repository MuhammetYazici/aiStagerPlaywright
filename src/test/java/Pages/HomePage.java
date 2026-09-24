package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator beforeAfterSlider() {
        return page.locator(".before-after-slider, [data-testid='slider']");
    }

    public Locator sliderHandle() {
        return page.locator(".slider-handle, .react-compare-slider-handle");
    }

    public Locator beforeImage() {
        return page.locator(".before-image, [alt*='Before'], [alt*='Önce']");
    }

    public Locator afterImage() {
        return page.locator(".after-image, [alt*='After'], [alt*='Sonra']");
    }

    public Locator carouselDots() {
        return page.locator(".carousel-dots button, .swiper-pagination-bullet");
    }

    public Locator gallerySection() {
        return page.locator("#gallery, .gallery-section");
    }

    public Locator allTypesFilter() {
        return page.locator("button:has-text('Tüm Tipler'), [data-filter='all']");
    }

    public Locator livingRoomFilter() {
        return page.locator("button:has-text('Oturma Odası'), [data-filter='living-room']");
    }

    public Locator designCards() {
        return page.locator(".design-card, .gallery-item");
    }

    public Locator communityProfileLink() {
        return page.locator(".community-profile, .creator-avatar");
    }

    public Locator likeButton() {
        return page.locator(".like-button, button svg.fa-heart");
    }

    public Locator likeCount() {
        return page.locator(".like-count");
    }

    public Locator loadMoreButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), button:has-text('Load More')");
    }

    public Locator faqSection() {
        return page.locator(".faq-section, #faq");
    }

    public Locator faqQuestion(String questionText) {
        return page.locator(String.format(".faq-item:has-text('%s'), button:has-text('%s')", questionText, questionText));
    }

    public Locator faqAnswer() {
        return page.locator(".faq-answer, .accordion-content");
    }

    public Locator contactUsFooterLink() {
        return page.locator("footer a:has-text('Bize ulaşın'), footer a:has-text('Contact')");
    }

    public Locator newsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta'], input[placeholder*='email']");
    }

    public Locator newsletterSubscribeButton() {
        return page.locator("button:has-text('Abone Ol'), button:has-text('Subscribe')");
    }

    public Locator newsletterSuccessMessage() {
        return page.locator(".success-message, :text('Başarılı'), :text('Success')");
    }

    public Locator newsletterErrorMessage() {
        return page.locator(".error-message, :text('geçerli'), :text('zorunlu'), :text('valid')");
    }

    public Locator loginButtonTopMenu() {
        return page.locator("header a:has-text('Giriş Yap'), header a:has-text('Login')");
    }

    public Locator freeTrialButtonTopMenu() {
        return page.locator("header a:has-text('Ücretsiz Dene'), header a:has-text('Free Trial')");
    }

    public Locator productionsPanel() {
        return page.locator(".productions-panel, :text('Üretimlerim')");
    }

    public Locator profileIcon() {
        return page.locator(".profile-icon, img[alt*='Profile']");
    }

    public Locator logo() {
        return page.locator("header img.logo, header a.logo");
    }

    public Locator productsHoverMenu() {
        return page.locator("text='Ürünler', text='Products'");
    }

    public Locator sectorSolutionsMenu() {
        return page.locator("text='Sektörel Çözümler', text='Solutions'");
    }

    public Locator resourcesMenu() {
        return page.locator("text='Kaynaklar', text='Resources'");
    }

    public Locator pricingMenu() {
        return page.locator("text='Fiyatlandırma', text='Pricing'");
    }

    public Locator fastRenderCameraSettings() {
        return page.locator(".camera-settings, :text('Kamera Ayarları')");
    }

    public Locator languageSelector() {
        return page.locator(".language-selector, svg.fa-globe, .globe-icon");
    }

    public Locator languageOptionTr() {
        return page.locator("li:has-text('TR'), button:has-text('TR')");
    }
}