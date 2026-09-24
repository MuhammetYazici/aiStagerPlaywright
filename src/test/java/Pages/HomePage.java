package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSliderOklar() {
        return page.locator("button.slider-arrow, .swiper-button-next, .swiper-button-prev");
    }

    public Locator getSliderNoktalar() {
        return page.locator(".swiper-pagination-bullet");
    }

    public Locator getSliderGorsel() {
        return page.locator(".slider-image, .comparison-slider");
    }

    public Locator getDilSecenegi(String dil) {
        return page.locator("text=" + dil);
    }

    public Locator getStatikMetinler() {
        return page.locator("body");
    }

    public Locator getGirisYapButonu() {
        return page.locator("a:text('Giriş yap'), button:text('Giriş Yap')");
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("a:text('Ücretsiz Dene'), button:text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text='Üretimlerim'");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [data-testid='profile-icon']");
    }

    public Locator getHizliRenderPaneli() {
        return page.locator(".quick-render-panel");
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-section");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text='Tüm Tipler'");
    }

    public Locator getOdaTipiButonu(String odaTipi) {
        return page.locator("button:text('" + odaTipi + "'), .room-type-filter:text('" + odaTipi + "')");
    }

    public Locator getGaleriListesi() {
        return page.locator(".gallery-grid-item");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("button:text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getSssAlani() {
        return page.locator(".faq-section, .accordion");
    }

    public Locator getSoruBasligi(int index) {
        return page.locator(".faq-question").nth(index);
    }

    public Locator getBultenAlani() {
        return page.locator(".newsletter-section");
    }

    public Locator getBultenEmailInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getBultenAboneOlButonu() {
        return page.locator("button:text('Abone Ol')");
    }

    public Locator getYesilOnayMesaji() {
        return page.locator(".success-message, text='Başarıyla'");
    }

    public Locator getBultenHataMesaji() {
        return page.locator(".error-message, text='Geçersiz'");
    }
}