package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSliderArea() {
        return page.locator("div.slider-area, [data-testid='before-after-slider']");
    }

    public Locator getSliderNextButton() {
        return page.locator("button.slider-next, [aria-label='Next slide']");
    }

    public Locator getCarouselDots() {
        return page.locator("div.carousel-dots span, .carousel-dot");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilIcon() {
        return page.locator("[aria-label='Profil'], .profile-icon");
    }

    public Locator getGirisYapButton() {
        return page.locator("text=Giriş yap");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getGaleriAlani() {
        return page.locator("section.gallery-section, .community-gallery");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("button:has-text('Oturma Odası'), [data-filter='oturma-odasi']");
    }

    public Locator getGaleriKartlari() {
        return page.locator(".gallery-card, .design-card");
    }

    public Locator getBegeniKalpIkonu() {
        return page.locator(".like-icon, button.favorite-btn").first();
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getSssAkordeonAlani() {
        return page.locator(".faq-section, .accordion");
    }

    public Locator getBirinciAkordeonBasligi() {
        return page.locator(".accordion-item").nth(0).locator(".accordion-header");
    }

    public Locator getIkinciAkordeonBasligi() {
        return page.locator(".accordion-item").nth(1).locator(".accordion-header");
    }

    public Locator getIkinciAkordeonIcerigi() {
        return page.locator(".accordion-item").nth(1).locator(".accordion-content");
    }

    public Locator getBirinciAkordeonIcerigi() {
        return page.locator(".accordion-item").nth(0).locator(".accordion-content");
    }

    public Locator getBultenAlani() {
        return page.locator(".newsletter-section, footer form");
    }

    public Locator getBultenEmailInput() {
        return page.locator("footer input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getBultenGonderButton() {
        return page.locator("footer button[type='submit'], button:has-text('Gönder')");
    }

    public Locator getBultenBasariMesaji() {
        return page.locator("text=Başarılı, .success-message, text=bülten");
    }

    public Locator getBultenHataMesaji() {
        return page.locator(".error-message, text=geçerli bir e-posta");
    }
}