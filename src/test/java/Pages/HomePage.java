package Pages;
import com.microsoft.playwright.options.AriaRole;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getSliderAlani() {
        return page.locator(".slider-container, [class*='slider']");
    }

    public Locator getSliderCubugu() {
        return page.locator("[class*='slider-handle'], [class*='range']");
    }

    public Locator getOdaGorseli() {
        return page.locator("[class*='room-image'], img[alt*='room']");
    }

    public Locator getSagSolOkTuslari() {
        return page.locator("button[class*='arrow'], button[class*='nav']");
    }

    public Locator getCarouselNoktalari() {
        return page.locator("[class*='dot'], [class*='indicator']");
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getUcretsizDeneButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfilIkonu() {
        return page.locator("[class*='profile-icon'], [data-testid='profile']");
    }

    public Locator getKameraAyarlari() {
        return page.locator("text=Kamera Ayarları");
    }

    public Locator getLogo() {
        return page.locator("header img, .logo");
    }

    public Locator getUrunlerLink() {
        return page.locator("text=Ürünler");
    }

    public Locator getCozumlerLink() {
        return page.locator("text=Çözümler");
    }

    public Locator getKaynaklarLink() {
        return page.locator("text=Kaynaklar");
    }

    public Locator getFiyatlandirmaLink() {
        return page.locator("text=Fiyatlandırma");
    }

    public Locator getCokluDilDestegi() {
        return page.locator("[class*='language'], select[class*='lang']");
    }

    public Locator getGaleriAlani() {
        return page.locator("[class*='gallery']");
    }

    public Locator getTumTiplerFiltresi() {
        return page.locator("text=Tüm Tipler");
    }

    public Locator getYatakOdasiFiltresi() {
        return page.locator("text=Yatak Odası");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getTasarimKartiKullaniciAdi() {
        return page.locator("[class*='designer-name'], [class*='card'] a");
    }

    public Locator getKalpIkonu() {
        return page.locator("[class*='heart'], [class*='like']");
    }

    public Locator getBegeniSayisi() {
        return page.locator("[class*='likes-count']");
    }

    public Locator getSssAlani() {
        return page.locator("[class*='faq'], text=Sıkça Sorulan Sorular");
    }

    public Locator getIlkAkordeonBasligi() {
        return page.locator("[class*='accordion-item']:first-child, [class*='faq-item']:first-child");
    }

    public Locator getFarkliAkordeonBasligi() {
        return page.locator("[class*='accordion-item']:nth-child(2), [class*='faq-item']:nth-child(2)");
    }

    public Locator getFooterAlani() {
        return page.locator("footer");
    }

    public Locator getBultenEpostaInput() {
        return page.locator("footer input[type='email'], [placeholder*='eposta']");
    }

    public Locator getAboneOlButton() {
        return page.locator("footer button, text=Abone Ol");
    }

    public Locator getOlumluGeriBildirimMesaji() {
        return page.locator("text=Başarıyla abone oldunuz, text=Teşekkürler");
    }

    public Locator getHataMesaji() {
        return page.locator("[class*='error'], text=geçersiz, text=zorunludur");
    }

    public Locator getKurumsalLinkler() {
        return page.locator("footer a");
    }
}