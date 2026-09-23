package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSliderElement() {
        return page.locator("input[type='range'], .slider-container");
    }

    public Locator getDilSecenegiButton() {
        return page.locator("button:has-text('EN'), .language-selector");
    }

    public Locator getGirisYapButton() {
        return page.locator("a:has-text('Giriş yap'), a:has-text('Giriş Yap')");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilIkonuMenu() {
        return page.locator(".profile-icon, [data-testid='profile-icon']");
    }

    public Locator getLogo() {
        return page.locator("header img, .logo");
    }

    public Locator getUrunlerMenu() {
        return page.locator("text=Ürünler");
    }

    public Locator getCozumlerMenu() {
        return page.locator("text=Çözümler");
    }

    public Locator getKaynaklarMenu() {
        return page.locator("text=Kaynaklar");
    }

    public Locator getFiyatlandirmaMenu() {
        return page.locator("text=Fiyatlandırma");
    }

    public Locator getHizliRenderPaneli() {
        return page.locator(".fast-render-panel");
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-section");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("button:has-text('Oturma Odasi'), button:has-text('Oturma Odası')");
    }

    public Locator getGaleriListesi() {
        return page.locator(".gallery-grid, .design-card");
    }

    public Locator getBegeniKalpIkonu() {
        return page.locator(".like-button, .heart-icon").first();
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), button:has-text('Daha fazla yükle')");
    }

    public Locator getSssAlani() {
        return page.locator(".faq-section, .accordion");
    }

    public Locator getAkordeonBasligi() {
        return page.locator(".accordion-header").first();
    }

    public Locator getFarkliAkordeonBasligi() {
        return page.locator(".accordion-header").nth(1);
    }

    public Locator getBultenKayitAlani() {
        return page.locator(".newsletter-section, input[type='email']");
    }

    public Locator getBultenEmailInput() {
        return page.locator(".newsletter-section input[type='email'], input[placeholder*='email']");
    }

    public Locator getBultenKayitButton() {
        return page.locator(".newsletter-section button, button:has-text('Abone Ol')");
    }

    public Locator getBasariliAbonelikMesaji() {
        return page.locator("text=Başarılı, text=Abone oldunuz, .success-message");
    }

    public Locator getHataMesajiGostergesi() {
        return page.locator(".error-message, text=zorunludur, text=hatalı");
    }

    public Locator getAiVirtualTourSecenegi() {
        return page.locator("text=Yapay Zeka Sanal Tur");
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.locator("text=Sanal Dekorasyon API");
    }

    public Locator getGirisYapLink() {
        return page.locator("text=Giriş Yap");
    }
}