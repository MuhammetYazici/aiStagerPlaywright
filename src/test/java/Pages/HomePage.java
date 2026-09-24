package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getBultenEpostaInput() {
        return page.locator("input[type='email']").first();
    }

    public Locator getAboneOlButton() {
        return page.locator("button:has-text('Abone Ol')").first();
    }

    public Locator getBasariliAbonelikMesaji() {
        return page.locator("text=Başarılı");
    }

    public Locator getBultenHataMesaji() {
        return page.locator("text=geçerli bir e-posta");
    }

    public Locator getGirisYapLink() {
        return page.locator("a:has-text('Giriş yap')").first();
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("button:has-text('Ücretsiz Dene')").first();
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim").first();
    }

    public Locator getProfilMenu() {
        return page.locator("text=Profil").first();
    }

    public Locator getSliderBolumu() {
        return page.locator(".slider-section").first();
    }

    public Locator getSliderOku() {
        return page.locator(".slider-arrow").first();
    }

    public Locator getDilSecenegiMenu() {
        return page.locator(".language-selector").first();
    }

    public Locator getGaleriBolumu() {
        return page.locator(".gallery-section").first();
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler").first();
    }

    public Locator getOdaTipiKategorisi() {
        return page.locator(".room-type-category").first();
    }

    public Locator getBegeniIkonu() {
        return page.locator(".like-icon").first();
    }

    public Locator getSayacDegeri() {
        return page.locator(".counter-value").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')").first();
    }

    public Locator getSssBolumu() {
        return page.locator(".faq-section").first();
    }

    public Locator getBirinciSoru() {
        return page.locator(".faq-question").first();
    }

    public Locator getIkinciSoru() {
        return page.locator(".faq-question").nth(1);
    }

    public Locator getAkordeonIcerik() {
        return page.locator(".faq-answer").first();
    }
}