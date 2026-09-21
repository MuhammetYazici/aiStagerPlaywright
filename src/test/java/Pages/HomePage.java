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
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getSliderAyirici() {
        return page.locator(".slider-handle, [class*='handle']");
    }

    public Locator getSliderYonOk(String yon) {
        return page.locator("button:has-text('" + yon + "'), [aria-label*='" + yon + "']");
    }

    public Locator getCarouselNoktalari() {
        return page.locator(".carousel-dots button, [class*='dot']");
    }

    public Locator getHeaderGirisYapButton() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş Yap')");
    }

    public Locator getHeaderUcretsizDeneButton() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("a:has-text('Üretimlerim'), [href*='uretimlerim']");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label*='profil']");
    }

    public Locator getHizliErisimPaneli() {
        return page.locator(".quick-access, [class*='quick']");
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-container, [class*='gallery']");
    }

    public Locator getOturmaOdasiSecenegi() {
        return page.locator("text='Oturma Odası', [data-category*='oturma']");
    }

    public Locator getGaleriListesi() {
        return page.locator(".gallery-item, [class*='item']");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle'), a:has-text('Daha Fazla')");
    }

    public Locator getSssAlani() {
        return page.locator(".faq-container, [class*='faq']");
    }

    public Locator getSssSorusu(String sira) {
        return page.locator(".faq-item:nth-child(" + sira + ") .question, [class*='faq'] button").first();
    }

    public Locator getBultenInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getBultenAbonelikButton() {
        return page.locator("button:has-text('Abone Ol'), button:has-text('Kayıt Ol'), button[type='submit']");
    }

    public Locator getBultenBasariMesaji() {
        return page.locator(".success-message, [class*='success']");
    }

    public Locator getBultenHataMesaji() {
        return page.locator(".error-message, [class*='error']");
    }
}