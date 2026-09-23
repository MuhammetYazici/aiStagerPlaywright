package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSihirSliderCizgisi() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getMobilyaliOdaAlani() {
        return page.locator(".after-image, [class*='after']");
    }

    public Locator getBosOdaAlani() {
        return page.locator(".before-image, [class*='before']");
    }

    public Locator getSliderSonrakiOk() {
        return page.locator("button.carousel-next, [class*='next']");
    }

    public Locator getCarouselNoktasi() {
        return page.locator(".carousel-dot, [class*='dot']");
    }

    public Locator getYuklenenOdaGorselleri() {
        return page.locator(".comparison-container, [class*='comparison']");
    }

    public Locator getAktifCarouselNoktasi() {
        return page.locator(".carousel-dot.active, [class*='active']");
    }

    public Locator getOdaniziYukleyinButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Odanızı Yükleyin"));
    }

    public Locator getOdaYuklemeArayuzu() {
        return page.locator(".upload-container, [class*='upload']");
    }

    public Locator getDilSecenegiDropdown() {
        return page.locator(".language-selector, [class*='lang']");
    }

    public Locator getDilSecenegiEn() {
        return page.locator("text=EN");
    }

    public Locator getStatikDinamikMetinler() {
        return page.locator("body");
    }

    public Locator getSiteLogosu() {
        return page.locator("header img, .logo");
    }

    public Locator getUrunlerMenusu() {
        return page.locator("text=Ürünler");
    }

    public Locator getAltUrunSecenekleriDropdown() {
        return page.locator(".dropdown-menu, [class*='dropdown']");
    }

    public Locator getUretimlerimPaneli() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilMenusuYIkonu() {
        return page.locator(".profile-icon, [class*='profile']");
    }

    public Locator getGirisYapButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getToplulukGalerisiAlani() {
        return page.locator(".community-gallery, [class*='gallery']");
    }

    public Locator getTumTipleriFiltresi() {
        return page.locator("text=Tüm Tipler");
    }

    public Locator getTasarimKartlari() {
        return page.locator(".design-card, [class*='card']");
    }

    public Locator getOdaTipiFiltreButonu() {
        return page.locator(".filter-btn, [class*='filter']");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getKalpIkonu() {
        return page.locator(".heart-icon, [class*='heart']");
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count, [class*='count']");
    }

    public Locator getDoluKalpIkonu() {
        return page.locator(".heart-icon.active, [class*='heart-filled']");
    }

    public Locator getFaqAlani() {
        return page.locator(".faq-section, [class*='faq']");
    }

    public Locator getBirinciSoru() {
        return page.locator(".faq-item").first();
    }

    public Locator getIkinciSoru() {
        return page.locator(".faq-item").nth(1);
    }

    public Locator getBultenFormu() {
        return page.locator(".newsletter-form, [class*='newsletter']");
    }

    public Locator getBultenInputAlani() {
        return page.locator("input[type='email'], input[placeholder*='example']");
    }

    public Locator getBultenGonderButonu() {
        return page.locator(".newsletter-form button, [class*='subscribe']");
    }

    public Locator getBasariliAbonelikMesaji() {
        return page.locator("text=Başarıyla abone oldunuz");
    }

    public Locator getFormValidasyonHatasi() {
        return page.locator(".error-message, [class*='error']");
    }
}