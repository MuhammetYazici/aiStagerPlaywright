package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapButton() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("button:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("a:has-text('Üretimlerim')");
    }

    public Locator getProfilMenu() {
        return page.locator("a:has-text('Profil')");
    }

    public Locator getHizliErisimPaneli() {
        return page.locator(".hizli-erisim-paneli");
    }

    public Locator getSliderAlanindan() {
        return page.locator(".slider-container");
    }

    public Locator getSliderSagaKaydirButton() {
        return page.locator(".slider-next-arrow");
    }

    public Locator getSliderSolaKaydirButton() {
        return page.locator(".slider-prev-arrow");
    }

    public Locator getMobilyaliOdaGorseli() {
        return page.locator(".slider-image-furnished");
    }

    public Locator getBosOdaGorseli() {
        return page.locator(".slider-image-empty");
    }

    public Locator getCarouselNoktalari() {
        return page.locator(".carousel-dot");
    }

    public Locator getGaleriAlani() {
        return page.locator(".galeri-container");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("button:has-text('Oturma Odası')");
    }

    public Locator getGaleriKatlari() {
        return page.locator(".galeri-kart");
    }

    public Locator getDahaFazlaYukleButton() {
        return page.locator("button:has-text('Daha Fazla Yükle')");
    }

    public Locator getSssBolumu() {
        return page.locator(".faq-container");
    }

    public Locator getBirinciSoru() {
        return page.locator(".faq-item").nth(0);
    }

    public Locator getIkinciSoru() {
        return page.locator(".faq-item").nth(1);
    }

    public Locator getDilSecenegiHeader() {
        return page.locator(".language-selector");
    }

    public Locator getDilSecenegiEn() {
        return page.locator("button:has-text('EN')");
    }

    public Locator getStatikMetinler() {
        return page.locator("body");
    }

    public Locator getFooterBultenAlani() {
        return page.locator(".footer-newsletter");
    }

    public Locator getBultenEmailInput() {
        return page.locator("input[placeholder='you@example.com']");
    }

    public Locator getAboneOlButton() {
        return page.locator("button:has-text('Abone Ol')");
    }

    public Locator getBasariliBultenMesaji() {
        return page.locator(".alert-success-green");
    }

    public Locator getZorunluAlanHatasi() {
        return page.locator(".text-danger:has-text('zorunludur')");
    }

    public Locator getGecersizEpostaHatasi() {
        return page.locator(".text-danger:has-text('geçersiz')");
    }
}