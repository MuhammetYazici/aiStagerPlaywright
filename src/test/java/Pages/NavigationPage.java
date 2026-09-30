package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getUrunlerDropdown() {
        return page.getByText("Ürünler");
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.getByText("Yapay Zeka Sanal Tur");
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.getByText("Sanal Dekorasyon API");
    }

    public Locator getErkenErisimIsteyinButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEpostaInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getGonderButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getOnayMesaji() {
        return page.locator(".success-message");
    }

    public Locator getIletisimeGecinButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }

    public Locator getIletisimFormuAdSoyad() {
        return page.getByPlaceholder("Ad Soyad");
    }

    public Locator getMesajAlani() {
        return page.getByPlaceholder("Mesajınız");
    }
}