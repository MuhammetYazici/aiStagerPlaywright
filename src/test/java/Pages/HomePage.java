package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSliderKaydirici() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getSliderYonOkleri() {
        return page.locator("button[class*='arrow'], .slider-nav-btn");
    }

    public Locator getGirisYapButton() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş yap')");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label='Profile']");
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
        return page.locator(".render-panel, text=Hızlı Render");
    }

    public Locator getToplulukBolumu() {
        return page.locator("text=Topluluk Tasarımlarımızı Keşfedin");
    }

    public Locator getYatakOdasiFiltresi() {
        return page.locator("text=Yatak Odası");
    }

    public Locator getTasarimKartlari() {
        return page.locator(".design-card");
    }

    public Locator getTasarimciProfili() {
        return page.locator(".designer-profile-link, .creator-name").first();
    }

    public Locator getBegeniButonu() {
        return page.locator(".like-button, [aria-label='Like']").first();
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getSssSorusu() {
        return page.locator(".faq-question, .accordion-item").first();
    }

    public Locator getIkinciSssSorusu() {
        return page.locator(".faq-question, .accordion-item").nth(1);
    }

    public Locator getFooterBultenInput() {
        return page.locator("footer input[type='email'], .newsletter-input");
    }

    public Locator getAboneOlButton() {
        return page.locator("footer button:has-text('Abone Ol'), .newsletter-btn");
    }

    public Locator getBasariliBultenMesaji() {
        return page.locator("text=Başarılı, text=Abone");
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.locator("text=geçerli e-posta, text=Geçersiz");
    }
}