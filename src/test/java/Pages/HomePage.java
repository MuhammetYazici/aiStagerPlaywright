package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getUcretsizDeneButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getTumunuKabulEtButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getSliderLocator() {
        return page.locator(".comparison-slider, [class*='slider']");
    }

    public Locator getCarouselLocator() {
        return page.locator(".carousel-dot, [class*='carousel']");
    }

    public Locator getHeaderLogo() {
        return page.locator("header img, .navbar-brand");
    }

    public Locator getUrunlerDropdown() {
        return page.getByText("Ürünler");
    }

    public Locator getCozumler() {
        return page.getByText("Çözümler");
    }

    public Locator getKaynaklar() {
        return page.getByText("Kaynaklar");
    }

    public Locator getFiyatlandirma() {
        return page.getByText("Fiyatlandırma");
    }

    public Locator getUretimlerim() {
        return page.getByText("Üretimlerim");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [class*='avatar']");
    }

    public Locator getDilSecenegiTR() {
        return page.getByText("TR", new Page.GetByTextOptions().setExact(true));
    }

    public Locator getDilMenusu() {
        return page.locator(".language-menu, [class*='dropdown-menu']");
    }

    public Locator getTumTiplerFiltresi() {
        return page.getByText("Tüm Tipler");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.getByText("Oturma Odası");
    }

    public Locator getGaleriKartlari() {
        return page.locator(".gallery-card, [class*='gallery']");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getTasarimSahibi() {
        return page.locator(".author-name, [class*='creator']").first();
    }

    public Locator getKalpIkonu() {
        return page.locator(".fa-heart, [class*='heart']").first();
    }

    public Locator getBegeniSayisi() {
        return page.locator(".like-count, [class*='likes']").first();
    }

    public Locator getFaqBirinciSoru() {
        return page.locator(".faq-item h3, .accordion-item").first();
    }

    public Locator getFaqBirinciCevap() {
        return page.locator(".faq-answer, .accordion-body").first();
    }

    public Locator getFaqIkinciSoru() {
        return page.locator(".faq-item h3, .accordion-item").nth(1);
    }

    public Locator getFaqIkinciCevap() {
        return page.locator(".faq-answer, .accordion-body").nth(1);
    }

    public Locator getBultenInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getBultenGonderButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getBultenBasariMesaji() {
        return page.getByText("başarılı", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getBultenHataMesaji() {
        return page.getByText("geçerli", new Page.GetByTextOptions().setExact(false));
    }

    public Locator getSosyalMedyaIkonu() {
        return page.locator(".social-icons a, [class*='social']").first();
    }

    public Locator getGizlilikPolitikasiLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gizlilik Politikası"));
    }

    public Locator getUrunlerMenu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ürünler"));
    }

    public Locator getSanalTurLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yapay Zeka Sanal Tur"));
    }

    public Locator getSanalDekorasyonApiLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("API"));
    }

    public Locator getEpostaInput() {
        return page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-posta"));
    }

    public Locator getAboneOlButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Abone Ol"));
    }

    public Locator getFiyatlandirmaGosterButton() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fiyatlandırma"));
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.getByText("Yapay Zeka Sanal Tur");
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.getByText("Sanal Dekorasyon API");
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }

    public Locator getTumuKabulEtButton() {
        return page.locator("text=Tümü Kabul Et");
    }
}