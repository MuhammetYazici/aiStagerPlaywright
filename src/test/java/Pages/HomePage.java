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

    public Locator getSliderOklar() {
        return page.locator("button.slider-arrow, [class*='slider'] button");
    }

    public Locator getSliderGorsel() {
        return page.locator(".slider-image, [class*='slider-visual']");
    }

    public Locator getYatakOdasiFiltre() {
        return page.getByText("Yatak Odası");
    }

    public Locator getGaleriListesi() {
        return page.locator(".gallery-grid, [class*='gallery']");
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getBirinciSoru() {
        return page.locator(".faq-item:nth-child(1), [class*='accordion']:nth-child(1)");
    }

    public Locator getIkinciSoru() {
        return page.locator(".faq-item:nth-child(2), [class*='accordion']:nth-child(2)");
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getUcretsizDeneButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getUretimlerimSekmesi() {
        return page.getByText("Üretimlerim");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [class*='profile']");
    }

    public Locator getDilSecenegiTurkce() {
        return page.getByText("Türkçe");
    }

    public Locator getTumSayfaMetinleri() {
        return page.locator("body");
    }

    public Locator getBultenInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getBultenKayitButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kayıt Ol").setExact(false));
    }

    public Locator getBasariliKayıtMesaji() {
        return page.getByText("Başarılı");
    }

    public Locator getValidasyonHataMesaji() {
        return page.locator(".error-message, [class*='error']");
    }

    public Locator getUrunlerMenu() {
        return page.locator("text=Ürünler");
    }

    public Locator getAltSecenekler() {
        return page.locator(".dropdown-menu, .submenu, nav");
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.locator("text=Yapay Zeka Sanal Tur");
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.locator("text=Sanal Dekorasyon API");
    }
}