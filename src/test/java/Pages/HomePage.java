package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getOncesiSonrasiSlider() {
        return page.locator(".slider-handle, input[type='range']").first();
    }

    public Locator getBosOdaGorseli() {
        return page.locator(".before-image, img.room-before").first();
    }

    public Locator getMobilyaliOdaGorseli() {
        return page.locator(".after-image, img.room-after").first();
    }

    public Locator getCarouselNoktalari() {
        return page.locator(".carousel-dot, .slider-dot").first();
    }

    public Locator getYonOkları() {
        return page.locator(".carousel-next, .slider-arrow-right").first();
    }

    public Locator getAktifNokta() {
        return page.locator(".carousel-dot.active, .slider-dot.active").first();
    }

    public Locator getDilSecici() {
        return page.locator(".language-selector, select#language").first();
    }

    public Locator getTurkceSecenegi() {
        return page.locator("text=Türkçe, option[value='tr']").first();
    }

    public Locator getSayfaMetinleri() {
        return page.locator("body").first();
    }

    public Locator getGirisYapButonu() {
        return page.locator("text=Giriş yap, a:has-text('Giriş yap')").first();
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("text=Ücretsiz Dene, button:has-text('Ücretsiz Dene')").first();
    }

    public Locator getUretimlerimMenusu() {
        return page.locator("text=Üretimlerim").first();
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, img.avatar").first();
    }

    public Locator getUrunlerMenusu() {
        return page.locator("text=Ürünler").first();
    }

    public Locator getCozumlerMenusu() {
        return page.locator("text=Çözümler").first();
    }

    public Locator getKaynaklarMenusu() {
        return page.locator("text=Kaynaklar").first();
    }

    public Locator getFiyatlandirmaMenusu() {
        return page.locator("text=Fiyatlandırma").first();
    }

    public Locator getHizliRenderKameraAyarlari() {
        return page.locator(".camera-settings, text=Hızlı Render").first();
    }

    public Locator getLogo() {
        return page.locator("header img, .logo").first();
    }

    public Locator getToplulukGalerisiAlani() {
        return page.locator(".community-gallery, #gallery").first();
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all.active").first();
    }

    public Locator getKarisikOdaTipleriListesi() {
        return page.locator(".gallery-grid, .room-card").first();
    }

    public Locator getOdaTipiFiltreButonu() {
        return page.locator(".filter-btn, button:has-text('Oturma Odası')").first();
    }

    public Locator getFiltrelenmisListe() {
        return page.locator(".filtered-gallery-grid").first();
    }

    public Locator getKalpBegeniIkonu() {
        return page.locator(".heart-icon, button.like-btn").first();
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("text=Daha Fazla Tasarım Yükle, button:has-text('Daha Fazla')").first();
    }

    public Locator getFaqAlani() {
        return page.locator(".faq-section, #faq").first();
    }

    public Locator getSoruBasligi() {
        return page.locator(".faq-question, .accordion-header").first();
    }

    public Locator getSoruIcerigi() {
        return page.locator(".faq-answer, .accordion-body").first();
    }

    public Locator getFarkliSoruBasligi() {
        return page.locator(".faq-question").nth(1);
    }

    public Locator getFooterBultenAlani() {
        return page.locator(".footer-newsletter, footer input[type='email']").first();
    }

    public Locator getBultenEpostaInput() {
        return page.locator("footer input[type='email'], input#newsletter-email").first();
    }

    public Locator getBultenAboneOlButonu() {
        return page.locator("footer button:has-text('Abone Ol'), button#subscribe").first();
    }

    public Locator getBasariMesaji() {
        return page.locator(".success-message, text=Başarılı").first();
    }

    public Locator getValidasyonHataMesaji() {
        return page.locator(".error-message, text=Geçersiz").first();
    }

    public Locator getGizlilikPolitikasiLink() {
        return page.locator("a:has-text('Gizlilik Politikası')").first();
    }

    public Locator getKullanimSartlariLink() {
        return page.locator("a:has-text('Hizmet Şartları')").first();
    }

    public Locator getSosyalMedyaIkonlari() {
        return page.locator(".social-icons a, .social-icon").first();
    }
}