package Pages;

import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    public Locator getGirisYapButton() {
        return page.locator("a:text('Giriş yap')");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("a:text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("a:text('Üretimlerim')");
    }

    public Locator getProfilIcon() {
        return page.locator(".profile-icon, [aria-label='Profil']");
    }

    public Locator getHizliRenderPaneli() {
        return page.locator(".render-panel");
    }

    public Locator getHeaderMenu(String menuAdi) {
        return page.locator("nav a:text('" + menuAdi + "'), header a:text('" + menuAdi + "')");
    }

    public Locator getSliderSihirGorseli() {
        return page.locator(".before-after-slider, .slider-handle");
    }

    public Locator getOnceSonraDurumMetni(String durum) {
        return page.locator("text='" + durum + "'");
    }

    public Locator getCarouselNoktasi(int index) {
        return page.locator(".carousel-dots button, .carousel-dots span").nth(index);
    }

    public Locator getGaleriFiltre(String filtreAdi) {
        return page.locator("button:text('" + filtreAdi + "'), .filter-item:text('" + filtreAdi + "')");
    }

    public Locator getTasarimKartiProfilAdi() {
        return page.locator(".design-card .profile-name").first();
    }

    public Locator getTasarimKartiKalpIkonu() {
        return page.locator(".design-card .heart-icon").first();
    }

    public Locator getTasarimKartiBeyeniSayisi() {
        return page.locator(".design-card .like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getSssSoru(int soruSirasi) {
        return page.locator(".faq-accordion .faq-item").nth(soruSirasi - 1);
    }

    public Locator getBultenEmailInput() {
        return page.locator("input[type='email'], input[placeholder*='email']").first();
    }

    public Locator getAboneOlButton() {
        return page.locator("button:text('Abone Ol')");
    }

    public Locator getBasariliAbonelikMesaji() {
        return page.locator(".subscription-success, text='Abonelik başarılı'");
    }

    public Locator getEmailFormatHataMesaji() {
        return page.locator(".error-message, text='Geçersiz e-posta'");
    }

    public Locator getFooterSosyalMedyaIkonu() {
        return page.locator("footer .social-icons a").first();
    }
}