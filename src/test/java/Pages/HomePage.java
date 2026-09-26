package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapButton() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş Yap')").first();
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("text=Ücretsiz Dene").first();
    }

    public Locator getUretimlerimBaglantisi() {
        return page.locator("text=Üretimlerim").first();
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label='Profil']").first();
    }

    public Locator getLogo() {
        return page.locator("header img, .logo").first();
    }

    public Locator getUrunlerDropdown() {
        return page.locator("text=Ürünler").first();
    }

    public Locator getCozumler() {
        return page.locator("text=Çözümler").first();
    }

    public Locator getKaynaklar() {
        return page.locator("text=Kaynaklar").first();
    }

    public Locator getFiyatlandirma() {
        return page.locator("text=Fiyatlandırma").first();
    }

    public Locator getDilSecici() {
        return page.locator(".language-selector, select.lang").first();
    }

    public Locator getHizliRender() {
        return page.locator("text=Hızlı Render").first();
    }

    public Locator getSliderCubugu() {
        return page.locator(".slider-handle, .comparison-slider").first();
    }

    public Locator getSliderGorSEti() {
        return page.locator(".comparison-container").first();
    }

    public Locator getCarouselNoktalari() {
        return page.locator(".carousel-dot, .swiper-pagination-bullet").first();
    }

    public Locator getToplulukGalerisi() {
        return page.locator("text=Topluluk Galerisi, .community-gallery").first();
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler").first();
    }

    public Locator getOdaTipiFiltresi() {
        return page.locator(".filter-item, .room-filter").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle").first();
    }

    public Locator getTasarimKartlari() {
        return page.locator(".design-card").first();
    }

    public Locator getBegeniKalp() {
        return page.locator(".like-btn, .heart-icon").first();
    }

    public Locator getSssBaslik() {
        return page.locator(".faq-item, .accordion-header").first();
    }

    public Locator getSssYanit() {
        return page.locator(".faq-content, .accordion-body").first();
    }

    public Locator getBultenEmailInput() {
        return page.locator("input[type='email'], .newsletter-input").first();
    }

    public Locator getAboneOlButton() {
        return page.locator("button:has-text('Abone Ol')").first();
    }

    public Locator getBasariliOnayMesaji() {
        return page.locator(".success-message, text=başarılı").first();
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text=hata").first();
    }
}