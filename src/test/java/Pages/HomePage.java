package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getOdaYonetimiAlani() {
        return page.locator("text=Öncesi ve Sonrası Sihri");
    }

    public Locator getSliderCubugu() {
        return page.locator(".slider-bar, input[type='range']").first();
    }

    public Locator getSliderAlani() {
        return page.locator(".slider-container, text=Öncesi ve Sonrası").first();
    }

    public Locator getSliderEtkilesim(String etkilesim) {
        return page.locator("text=" + etkilesim);
    }

    public Locator getOdaniziYukleyinButonu() {
        return page.locator("text=Odanızı Yükleyin");
    }

    public Locator getDilSecenegiDropdown() {
        return page.locator(".language-selector, text=TR").first();
    }

    public Locator getLogo() {
        return page.locator("header img, a[href*='/tr']").first();
    }

    public Locator getHeaderLink(String linkAdi) {
        return page.locator("header a:has-text('" + linkAdi + "')").first();
    }

    public Locator getToplulukGalerisiAlani() {
        return page.locator("text=Topluluk Galerisi");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler");
    }

    public Locator getOdaTipiFiltreButonu() {
        return page.locator(".gallery-filters button, .filter-item").first();
    }

    public Locator getTasarimKartiKullaniciAdi() {
        return page.locator(".gallery-card .username, .author-name").first();
    }

    public Locator getKalpIkonu() {
        return page.locator(".gallery-card svg.heart-icon, .like-button").first();
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getSikcaSorulanSorularAlani() {
        return page.locator("text=Sıkça Sorulan Sorular");
    }

    public Locator getSoruBasligi() {
        return page.locator(".faq-item, .accordion-header").first();
    }

    public Locator getBizeUlasinLink() {
        return page.locator("text=Bize ulaşın");
    }

    public Locator getFooterBultenAlani() {
        return page.locator("footer, .newsletter-section").first();
    }

    public Locator getBultenEmailInput() {
        return page.locator("footer input[type='email'], input[placeholder*='e-posta']").first();
    }

    public Locator getAboneOlButonu() {
        return page.locator("footer button:has-text('Abone Ol'), button:has-text('Kayıt Ol')").first();
    }

    public Locator getFooterAlani() {
        return page.locator("footer");
    }

    public Locator getYasalMetinLink(String linkMetni) {
        return page.locator("footer a:has-text('" + linkMetni + "')").first();
    }

    public Locator getSosyalMedyaIkonu() {
        return page.locator("footer .social-icons a, footer svg").first();
    }
}