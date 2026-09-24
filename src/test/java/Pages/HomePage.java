package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getKaydirici() {
        return page.locator("input[type='range'], .slider-handle, div[role='slider']");
    }

    public Locator getSagYonOku() {
        return page.locator("button.next, .carousel-next, [aria-label='Next']");
    }

    public Locator getCarouselNoktasi() {
        return page.locator(".carousel-dots button, .dot");
    }

    public Locator getOdaniziYukleyinButonu() {
        return page.locator("button:has-text('Odanızı Yükleyin'), a:has-text('Odanızı Yükleyin')");
    }

    public Locator getDilMenusu() {
        return page.locator(".language-selector, select.language, button:has-text('TR')");
    }

    public Locator getUrunlerMenu() {
        return page.locator("nav a:has-text('Ürünler')");
    }

    public Locator getCozumlerMenu() {
        return page.locator("nav a:has-text('Çözümler')");
    }

    public Locator getKaynaklarMenu() {
        return page.locator("nav a:has-text('Kaynaklar')");
    }

    public Locator getFiyatlandirmaMenu() {
        return page.locator("nav a:has-text('Fiyatlandırma')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("nav a:has-text('Üretimlerim')");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label='Profil']");
    }

    public Locator getLogo() {
        return page.locator("img.logo, a.navbar-brand");
    }

    public Locator getGirisYapLink() {
        return page.locator("a:has-text('Giriş yap'), a:has-text('Giriş Yap')");
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("button:has-text('Oturma Odası')");
    }

    public Locator getGaleriKartiKullaniciAdi() {
        return page.locator(".gallery-card .username, .author-name");
    }

    public Locator getKalpBegeniIkonu() {
        return page.locator(".gallery-card .heart-icon, button.like-btn");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getBirinciSoru() {
        return page.locator(".accordion-item:nth-child(1) .accordion-header");
    }

    public Locator getIkinciSoru() {
        return page.locator(".accordion-item:nth-child(2) .accordion-header");
    }

    public Locator getBizeUlasinLink() {
        return page.locator("a:has-text('Bize ulaşın')");
    }

    public Locator getBultenInput() {
        return page.locator("footer input[type='email'], .newsletter-input");
    }

    public Locator getAboneOlButonu() {
        return page.locator("footer button:has-text('Abone Ol'), .newsletter-btn");
    }

    public Locator getBasariMesaji() {
        return page.locator(".success-message, .toast-success");
    }

    public Locator getFooterLinkleri() {
        return page.locator("footer a");
    }

    public Locator getTumunuKabulEtButonu() {
        return page.locator("button:has-text('Tümünü Kabul Et')");
    }

    public Locator getEpostaInput() {
        return page.locator("input[type='email'], input#email, input[name='email']");
    }
}