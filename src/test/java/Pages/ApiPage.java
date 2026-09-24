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

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='email']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getFormGonderButonu() {
        return page.locator("button[type='submit']:has-text('Gönder')");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=başarılı, text=gönderildi");
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırmayı Görüntüle')");
    }

    public Locator getZorunluAlanUyariMesaji() {
        return page.locator(".error-message, text=zorunlu");
    }
}