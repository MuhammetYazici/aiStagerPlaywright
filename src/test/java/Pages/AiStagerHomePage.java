package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerHomePage {
    private Page page;

    public AiStagerHomePage() {
        this.page = PD.getPage();
    }

    public Locator getBeforeAfterSlider() {
        return page.locator("div.slider-container, [data-testid='before-after-slider']");
    }

    public Locator getSliderHandle() {
        return page.locator("div.slider-handle, .react-compare-slider-handle");
    }

    public Locator getSliderRightArrow() {
        return page.locator("button.slider-next, .carousel-control-next, button:has-text('>')");
    }

    public Locator getActiveCarouselDot() {
        return page.locator(".carousel-dot.active, .swiper-pagination-bullet-active");
    }

    public Locator getUploadRoomButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Odanızı Yükleyin"));
    }

    public Locator getLanguageSelector() {
        return page.locator("button.language-selector, select#language, div.language-dropdown");
    }

    public Locator getTurkishLanguageOption() {
        return page.locator("text=TR, [data-value='tr'], option[value='tr']");
    }

    public Locator getProfileIcon() {
        return page.locator("div.profile-icon, img.avatar, [data-testid='user-profile']");
    }

    public Locator getProductionsMenu() {
        return page.locator("a:has-text('Üretimlerim'), [href*='productions']");
    }

    public Locator getLogo() {
        return page.locator("a.logo, img.brand-logo, header a[href*='tr']");
    }

    public Locator getProductsMenu() {
        return page.locator("button:has-text('Ürünler'), a:has-text('Ürünler')");
    }

    public Locator getProductsDropdown() {
        return page.locator("div.dropdown-menu, .products-submenu");
    }

    public Locator getLoginButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getFreeTrialButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getAllTypesFilter() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all.active");
    }

    public Locator getGalleryCards() {
        return page.locator("div.gallery-card, .design-card");
    }

    public Locator getLivingRoomFilter() {
        return page.locator("button:has-text('Oturma Odası'), [data-filter='living-room']");
    }

    public Locator getCardUsername() {
        return page.locator("div.gallery-card span.username, .creator-name").first();
    }

    public Locator getLikeButton() {
        return page.locator("button.like-btn, svg.heart-icon").first();
    }

    public Locator getLikeCounter() {
        return page.locator("span.like-count").first();
    }

    public Locator getLoadMoreDesignsButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getFaqContactLink() {
        return page.locator("a:has-text('Bize ulaşın'), a[href*='contact']");
    }

    public Locator getFaqQuestion(String questionText) {
        return page.locator(String.format("div.faq-item:has-text('%s'), button.accordion-header:has-text('%s')", questionText, questionText));
    }

    public Locator getNewsletterInput() {
        return page.locator("input#newsletter-email, footer input[type='email']");
    }

    public Locator getSubscribeButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Abone Ol"));
    }

    public Locator getToastSuccessMessage() {
        return page.locator("div.toast-success, div:has-text('Başarıyla abone oldunuz')");
    }

    public Locator getErrorMessage() {
        return page.locator("div.error-message, div:has-text('Geçerli bir e-posta adresi giriniz')");
    }
}