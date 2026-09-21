package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getBeforeAndAfterSlider() {
        return page.locator("text='Önce ve Sonra'");
    }

    public Locator getSliderHandle() {
        return page.locator(".slider-handle, [role='slider']").first();
    }

    public Locator getBeforeImage() {
        return page.locator("text='Önce'");
    }

    public Locator getAfterImage() {
        return page.locator("text='Sonra'");
    }

    public Locator getSliderArea() {
        return page.locator(".slider-container").first();
    }

    public Locator getNextArrow() {
        return page.locator(".carousel-next, button[aria-label='Next']").first();
    }

    public Locator getCarouselDot() {
        return page.locator(".carousel-dot, .dot").first();
    }

    public Locator getNewRoomImages() {
        return page.locator(".room-image, .carousel-item").first();
    }

    public Locator getLoginButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getFreeTrialButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getProductionsLink() {
        return page.locator("text='Üretimlerim'");
    }

    public Locator getProfileIcon() {
        return page.locator(".profile-icon, [aria-label='Profil']").first();
    }

    public Locator getMenuLink(String menuName) {
        return page.locator("text='" + menuName + "'");
    }

    public Locator getGallerySection() {
        return page.locator("text='Topluluk Tasarımları Galerisi'");
    }

    public Locator getLivingRoomFilter() {
        return page.locator("text='Oturma Odası'");
    }

    public Locator getLikeButton() {
        return page.locator(".like-icon, button.heart").first();
    }

    public Locator getFilteredDesigns() {
        return page.locator(".design-card");
    }

    public Locator getLoadMoreButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getFaqSection() {
        return page.locator("text='SSS'");
    }

    public Locator getFaqQuestionOne() {
        return page.locator(".faq-question").first();
    }

    public Locator getFaqQuestionTwo() {
        return page.locator(".faq-question").nth(1);
    }

    public Locator getFaqAnswerOne() {
        return page.locator(".faq-answer").first();
    }

    public Locator getFaqAnswerTwo() {
        return page.locator(".faq-answer").nth(1);
    }

    public Locator getContactUsLink() {
        return page.locator("text='Bize ulaşın'");
    }

    public Locator getFooterSection() {
        return page.locator("footer");
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']").first();
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("footer button, button:has-text('Abone Ol')").first();
    }

    public Locator getSuccessMessage() {
        return page.locator("text='başarılı', text='Teşekkürler'").first();
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, text='geçerli', text='zorunlu'").first();
    }

    public Locator getFooterLinks() {
        return page.locator("footer a").first();
    }
}