package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getKaydirici() {
        return page.locator(".before-after-slider, input[type='range']");
    }

    public Locator getBosOdaGorseli() {
        return page.locator("text=Önce");
    }

    public Locator getMobilyaliOdaGorseli() {
        return page.locator("text=Sonra");
    }

    public Locator getSagYonOku() {
        return page.locator("button.next-arrow, .carousel-next");
    }

    public Locator getAktifBelirtecNoktasi() {
        return page.locator(".dot.active, .pagination-bullet-active");
    }

    public Locator getDilSecenegi() {
        return page.locator("button.language-selector, select#language");
    }

    public Locator getTurkceMetinKontrol() {
        return page.locator("body");
    }

    public Locator getOdaniziYukleyinButton() {
        return page.locator("button:has-text('Odanızı Yükleyin'), a:has-text('Odanızı Yükleyin')");
    }

    public Locator getGirisYapButton() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş yap')");
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("button:has-text('Ücretsiz Dene'), a:has-text('Ücretsiz Dene')");
    }

    public Locator getUretimlerimIkonu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, img[alt='Profile']");
    }

    public Locator getLogo() {
        return page.locator(".logo, img[alt='Logo']");
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

    public Locator getHizliRenderKameraAyarlari() {
        return page.locator(".camera-settings, .render-settings");
    }

    public Locator getTumTiplerFiltre() {
        return page.locator("text=Tüm Tipler");
    }

    public Locator getOturmaOdasiFiltre() {
        return page.locator("text=Oturma Odası");
    }

    public Locator getGaleriIcerikleri() {
        return page.locator(".gallery-item");
    }

    public Locator getKalpBegeniIkonyu() {
        return page.locator(".heart-icon, button.like-btn").first();
    }

    public Locator getKalpSayac() {
        return page.locator(".like-count").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getKullaniciAdiLink() {
        return page.locator(".author-name, .user-profile-link").first();
    }

    public Locator getSssBolumu() {
        return page.locator("text=Sıkça Sorulan Sorular");
    }

    public Locator getSoru1Basligi() {
        return page.locator("text=Soru 1");
    }

    public Locator getSoru1Cevabi() {
        return page.locator(".accordion-content").first();
    }

    public Locator getSoru2Basligi() {
        return page.locator("text=Soru 2");
    }

    public Locator getSoru2Cevabi() {
        return page.locator(".accordion-content").nth(1);
    }

    public Locator getFooterBolumu() {
        return page.locator("footer");
    }

    public Locator getBultenEpostaInput() {
        return page.locator("footer input[type='email']");
    }

    public Locator getBultenGonderButton() {
        return page.locator("footer button[type='submit']");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=Başarılı");
    }

    public Locator getGizlilikYasalLink() {
        return page.locator("footer a:has-text('Gizlilik Politikası')");
    }

    public Locator getValidasyonHataMesaji() {
        return page.locator(".error-message, .invalid-feedback");
    }

    public Locator getProductsMenu() {
        return page.locator("text='Ürünler', span:has-text('Ürünler')");
    }

    public Locator getSubMenuVirtualTour() {
        return page.locator("text='Yapay Zeka Sanal Tur'");
    }

    public Locator getSubMenuAPI() {
        return page.locator("text='Sanal Dekorasyon API'");
    }

    public Locator getEarlyAccessButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='example']");
    }

    public Locator getSubmitRequestButton() {
        return page.locator("button:has-text('Talebi Gönder'), button[type='submit']");
    }

    public Locator getSuccessMessage() {
        return page.locator("text='Talebiniz alınmıştır', text='başarılı', .success-message");
    }

    public Locator getEmailErrorMessage() {
        return page.locator("text='geçerli bir e-posta', text='error'");
    }

    public Locator getContactUsButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getNameInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMessageInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getPricingButton() {
        return page.locator("text='Fiyatlandırmayı Görüntüle', a:has-text('Fiyatlandırma')");
    }
}