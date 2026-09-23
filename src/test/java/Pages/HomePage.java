package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSagOkButonu() {
        return page.locator("button.next-slide, [aria-label='Next']");
    }

    public Locator getSolOkButonu() {
        return page.locator("button.prev-slide, [aria-label='Previous']");
    }

    public Locator getSliderGorseli() {
        return page.locator(".slider-image-container");
    }

    public Locator getSliderTutamagi() {
        return page.locator(".slider-handle");
    }

    public Locator getOncesiSonrasiOrani() {
        return page.locator(".comparison-ratio");
    }

    public Locator getIkinciCarouselNoktasi() {
        return page.locator(".carousel-dot:nth-child(2)");
    }

    public Locator getGirisYapButonu() {
        return page.locator("a:has-text('Giriş yap'), a:has-text('Giriş Yap')");
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("a:has-text('Üretimlerim')");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label='Profil']");
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-container");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("button:has-text('Oturma Odası'), [data-filter='oturma-odasi']");
    }

    public Locator getGaleriListesi() {
        return page.locator(".gallery-item.oturma-odasi, .gallery-grid");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), a:has-text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getSssBolumu() {
        return page.locator(".faq-section");
    }

    public Locator getBirinciSoruAkordeon() {
        return page.locator(".faq-item:nth-child(1) .faq-question, button:has-text('Birinci Soru')");
    }

    public Locator getIkinciSoruAkordeon() {
        return page.locator(".faq-item:nth-child(2) .faq-question, button:has-text('İkinci Soru')");
    }

    public Locator getIkinciSoruIcerik() {
        return page.locator(".faq-item:nth-child(2) .faq-answer");
    }

    public Locator getBirinciSoruIcerik() {
        return page.locator(".faq-item:nth-child(1) .faq-answer");
    }
}