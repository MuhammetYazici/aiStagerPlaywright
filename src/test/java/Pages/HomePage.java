package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getOnceSonraCizgisi() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getSliderOklarVeyaNoktalar() {
        return page.locator("button[class*='arrow'], .carousel-dot, [class*='bullet']");
    }

    public Locator getOdaGorselleri() {
        return page.locator("img[alt*='room'], .room-image, [class*='image']");
    }

    public Locator getOdaniziYukleyinButonu() {
        return page.locator("text=Odanızı Yükleyin, button:has-text('Yükle')");
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

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [aria-label*='profil']");
    }

    public Locator getHeaderLogo() {
        return page.locator("header img, .logo, a[href='/']");
    }

    public Locator getUrunlerDropdown() {
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

    public Locator getDilSecenegiTR() {
        return page.locator("text=TR, [aria-label*='TR']");
    }

    public Locator getHizliKameraAyarlari() {
        return page.locator(".camera-settings, [aria-label*='kamera']");
    }

    public Locator getGaleriBolumu() {
        return page.locator(".gallery-section, #gallery");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler, button:has-text('Tüm Tipler')");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("text=Oturma Odası, button:has-text('Oturma Odası')");
    }

    public Locator getGaleriKartlari() {
        return page.locator(".gallery-card, .room-card");
    }

    public Locator getKalpBegeniIkonu() {
        return page.locator(".heart-icon, svg[class*='heart'], button:has(.heart)");
    }

    public Locator getBegeniSayaci() {
        return page.locator(".like-count, [class*='count']");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("text=Daha Fazla Tasarım Yükle, button:has-text('Daha Fazla')");
    }

    public Locator getSssBolumu() {
        return page.locator(".faq-section, #faq");
    }

    public Locator getBirinciSoru() {
        return page.locator(".faq-item:nth-child(1), .accordion-item:nth-child(1)");
    }

    public Locator getBirinciSoruCevabi() {
        return page.locator(".faq-item:nth-child(1) .content, .accordion-content:nth-child(1)");
    }

    public Locator getIkinciSoru() {
        return page.locator(".faq-item:nth-child(2), .accordion-item:nth-child(2)");
    }

    public Locator getIkinciSoruCevabi() {
        return page.locator(".faq-item:nth-child(2) .content, .accordion-content:nth-child(2)");
    }

    public Locator getFooterBultenAlani() {
        return page.locator("footer .newsletter, input[type='email']");
    }

    public Locator getBultenEpostaInput() {
        return page.locator("footer input[type='email'], input[placeholder*='ornek']");
    }

    public Locator getBultenGonderButonu() {
        return page.locator("footer button[type='submit'], button:has-text('Abone Ol'), button:has-text('Gönder')");
    }

    public Locator getBasariMesaji() {
        return page.locator(".success-message, text=Başarılı");
    }

    public Locator getHataUyarisi() {
        return page.locator(".error-message, text=hata, text=geçerli");
    }

    public Locator getFooterBolumu() {
        return page.locator("footer");
    }

    public Locator getGizlilikPolitikasiLink() {
        return page.locator("footer a:has-text('Gizlilik Politikası')");
    }

    public Locator getKullanimSartlariLink() {
        return page.locator("footer a:has-text('Kullanım Şartları'), footer a:has-text('Hizmet Şartları')");
    }

    public Locator getSosyalMedyaIkonlari() {
        return page.locator("footer .social-icons a, footer svg[class*='social']");
    }
}