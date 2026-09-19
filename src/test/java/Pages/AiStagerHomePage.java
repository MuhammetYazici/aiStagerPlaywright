package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerHomePage {
    private Page page;

    public AiStagerHomePage() {
        this.page = PD.getPage();
    }

    public Locator getAnasayfaLink() {
        return page.locator("text=Ana Sayfa");
    }

    public Locator getSliderAlan() {
        return page.locator(".before-after-slider, text=Öncesi ve Sonrası");
    }

    public Locator getSliderOkButonu() {
        return page.locator(".slider-arrow, button:has-text('›')");
    }

    public Locator getCarouselNoktalari() {
        return page.locator(".carousel-dot, .swiper-pagination-bullet");
    }

    public Locator getOdaniziYukleyinButton() {
        return page.locator("text=Odanızı Yükleyin");
    }

    public Locator getDilSecenegiButton() {
        return page.locator("text=TR, .language-selector");
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

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getHizliErisimPaneli() {
        return page.locator(".quick-access-panel");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [data-testid='profile-icon']");
    }

    public Locator getGirisYapButton() {
        return page.locator("text=Giriş yap");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getGaleriAlani() {
        return page.locator(".gallery-section");
    }

    public Locator getOturmaOdasiFiltre() {
        return page.locator("text=Oturma Odası");
    }

    public Locator getKalpIkonu() {
        return page.locator(".heart-icon, svg.lucide-heart");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getSssAlani() {
        return page.locator(".faq-section, text=Sıkça Sorulan Sorular");
    }

    public Locator getBirinciSssBasligi() {
        return page.locator(".faq-item").first();
    }

    public Locator getBizeUlasinLink() {
        return page.locator("text=Bize ulaşın");
    }

    public Locator getIkinciSssBasligi() {
        return page.locator(".faq-item").nth(1);
    }

    public Locator getFooterAlani() {
        return page.locator("footer");
    }

    public Locator getBultenEpostaInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getAboneOlButton() {
        return page.locator("button:has-text('Abone Ol')");
    }

    public Locator getBasariliAboneMesaji() {
        return page.locator("text=Başarıyla abone oldunuz");
    }

    public Locator getHataMesaji() {
        return page.locator("text=Geçerli bir e-posta adresi giriniz");
    }
}