package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getUrunlerDropdown() {
        return page.locator("text=Ürünler");
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.locator("text=Yapay Zeka Sanal Tur");
    }

    public Locator getSanalDekorasyonAPIногда() {
        return page.locator("text=Sanal Dekorasyon API");
    }

    public Locator getErkenErisimIsteyinButonu() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[placeholder='you@example.com']");
    }

    public Locator getGonderButonu() {
        return page.locator("button:has-text('Gönder'), button:has-text('Talebi gönder')");
    }

    public Locator getIletisimeGecinButonu() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırmayı Görüntüle')");
    }
}