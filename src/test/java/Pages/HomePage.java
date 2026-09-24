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

    public Locator getSliderOrtaCizgi() {
        return page.locator(".slider-divider, [class*='slider'] input[type='range']").first();
    }

    public Locator getOnceSonraGorseller() {
        return page.locator(".before-after-container, [class*='comparison']").first();
    }

    public Locator getCarouselNoktasi() {
        return page.locator(".carousel-dot, [class*='dot']").first();
    }

    public Locator getSliderOkVeyaNoktaButonu() {
        return page.locator(".slider-arrow, .carousel-btn, button[class*='arrow']").first();
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap")).first();
    }

    public Locator getUcretsizDeneButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene")).first();
    }

    public Locator getUretimlerimIkonu() {
        return page.locator(".productions-icon, a[href*='production']").first();
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [class*='avatar']").first();
    }

    public Locator getUrunlerDropdown() {
        return page.locator("text=Ürünler").first();
    }

    public Locator getCozumlerDropdown() {
        return page.locator("text=Çözümler").first();
    }

    public Locator getHizliRenderIkonu() {
        return page.locator(".quick-render-icon, [class*='render']").first();
    }

    public Locator getPlatformLogosu() {
        return page.locator(".logo, img[alt*='Logo']").first();
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-container, [class*='gallery']").first();
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler").first();
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("text=Oturma Odası").first();
    }

    public Locator getOturmaOdasiTasarımlariListesi() {
        return page.locator(".gallery-item, [class*='design-card']").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle")).first();
    }

    public Locator getSssSorusu() {
        return page.locator(".faq-question, [class*='accordion']").first();
    }

    public Locator getFarkliSssSorusu() {
        return page.locator(".faq-question, [class*='accordion']").nth(1);
    }

    public Locator getBultenEpostaInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']").first();
    }

    public Locator getAboneOlButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Abone Ol")).first();
    }

    public Locator getBasariliKayitMesaji() {
        return page.locator(".success-message, [class*='success']").first();
    }

    public Locator getFormValidasyonUyarisi() {
        return page.locator(".error-message, [class*='validation']").first();
    }
}