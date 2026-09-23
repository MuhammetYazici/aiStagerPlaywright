package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class ApiPage {
    private Page page;

    public ApiPage() {
        this.page = PD.getPage();
    }

    public Locator getIletisimeGecinButonu() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getAdAlani() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMesajAlani() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getEpostaAlani() {
        return page.locator("input[type='email'], input[name='email']");
    }

    public Locator getFormGonderButonu() {
        return page.locator("button:has-text('Gönder'), button[type='submit']");
    }

    public Locator getOnayMesaji() {
        return page.locator(".success-message, text=başarıyla iletildi, text=onay");
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırma')");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator(".error, text=zorunlu, text=doldurun");
    }
}