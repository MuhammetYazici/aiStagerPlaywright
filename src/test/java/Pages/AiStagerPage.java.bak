package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPage {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
    }

    public Locator getOncesiVeSonrasiKaydirici() {
        return page.locator(".before-after-slider, [class*='slider'], [class*='comparison']");
    }

    public Locator getOnceVeSonraGorselleri() {
        return page.locator(".before-after-image, img[alt*='Before'], img[alt*='After']");
    }

    public Locator getCarouselNoktalariVeyaOklar() {
        return page.locator(".carousel-dots button, .carousel-arrow, button[class*='arrow']");
    }

    public Locator getAktifVeyaYeniOdaGorselleri() {
        return page.locator(".carousel-item.active img, .room-gallery img");
    }

    public Locator getOdaniziYukleyinButonu() {
        return page.locator("button:has-text('Odanızı Yükleyin'), a:has-text('Odanızı Yükleyin')");
    }

    public Locator getDilSecimiMenusu() {
        return page.locator(".language-selector, select[name*='lang'], button:has-text('TR')");
    }

    public Locator getDinamikMetinler() {
        return page.locator("body");
    }

    public Locator getUrunlerMenu() {
        return page.locator("nav a:has-text('Ürünler'), button:has-text('Ürünler')");
    }

    public Locator getAltMenu() {
        return page.locator(".dropdown-menu, .submenu");
    }

    public Locator getUstMenuDetayLinki(String detayAdi) {
        return page.locator("nav a:has-text('" + detayAdi + "'), button:has-text('" + detayAdi + "')");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, img[alt*='profile'], [aria-label*='profile']");
    }

    public Locator getUretimlerimButonu() {
        return page.locator("nav a:has-text('Üretimlerim'), button:has-text('Üretimlerim')");
    }

    public Locator getGirisYapButonu() {
        return page.locator("a:has-text('Giriş yap'), button:has-text('Giriş Yap')");
    }

    public Locator getUcretsizDeneButonu() {
        return page.locator("a:has-text('Ücretsiz Dene'), button:has-text('Ücretsiz Dene')");
    }

    public Locator getGaleriBolumu() {
        return page.locator(".community-gallery, section:has-text('Galeri')");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("button:has-text('Tüm Tipler'), .filter-all");
    }

    public Locator getOturmaOdasiFiltreButonu() {
        return page.locator("button:has-text('Oturma Odası'), button:has-text('Living Room')");
    }

    public Locator getGaleriKartlari() {
        return page.locator(".gallery-card, .design-card");
    }

    public Locator getKalpIkonu() {
        return page.locator(".heart-icon, button[aria-label*='Like']");
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count, span[class*='like']");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.locator("button:has-text('Daha Fazla Tasarım Yükle')");
    }

    public Locator getSssBolumu() {
        return page.locator(".faq-section, section:has-text('Sıkça Sorulan Sorular')");
    }

    public Locator getSoruBasligi() {
        return page.locator(".faq-item h3, .faq-question");
    }

    public Locator getSssCevabi() {
        return page.locator(".faq-answer, .faq-content");
    }

    public Locator getBultenAlani() {
        return page.locator(".newsletter-section, input[placeholder*='e-posta']");
    }

    public Locator getBultenEpostaInput() {
        return page.locator("input[placeholder*='e-posta'], input[type='email']");
    }

    public Locator getAboneOlButonu() {
        return page.locator("button:has-text('Abone Ol'), button:has-text('Subscribe')");
    }

    public Locator getBultenSonucMesaji() {
        return page.locator(".newsletter-message, .alert, .toast");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getGirisYapSubmitButonu() {
        return page.locator("button[type='submit']:has-text('Giriş Yap')");
    }

    public Locator getAnaPanelDogrulama() {
        return page.locator(".dashboard, .main-panel, h1:has-text('Panel')");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".password-toggle-icon, button[aria-label*='Show password']");
    }

    public Locator getKayitOlLink() {
        return page.locator("a:has-text('Kayıt Ol'), a:has-text('Kayıt ol')");
    }

    public Locator getKayitOlSayfasiDogrulama() {
        return page.locator("form:has-text('Hesap Oluştur'), h1:has-text('Kayıt Ol')");
    }

    public Locator getSifremiUnuttumLink() {
        return page.locator("a:has-text('Şifremi Unuttum')");
    }

    public Locator getSifreSifirlamaSayfasiDogrulama() {
        return page.locator("form:has-text('Şifre'), h1:has-text('Şifre')");
    }

    public Locator getHataMesajiLocator() {
        return page.locator(".error-message, .invalid-feedback, text=Bu alan zorunludur, text=Lütfen, text=E-posta, text=şifre");
    }

    public Locator getSartlarCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getHesapOlusturButonu() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getAktivasyonEkranıDogrulama() {
        return page.locator("text=aktivasyon, text=Doğrulama, text=Welcome");
    }
}