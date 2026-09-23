package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class ApiPage {
    private Page page;

    public ApiPage() {
        this.page = PD.getPage();
    }

    public Locator getIletisimeGecinButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getApiEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='E-posta']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getFormuGonderButton() {
        return page.locator("button:has-text('Formu Gönder'), button[type='submit']");
    }

    public Locator getBasariliGonderimMesaji() {
        return page.locator("text=Başarılı, text=Teşekkürler");
    }

    public Locator getZorunluAlanUyariMesaji() {
        return page.locator("text=zorunlu, text=required, .error");
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.locator("a:has-text('Fiyatlandırmayı Görüntüle'), button:has-text('Fiyatlandırmayı Görüntüle')");
    }
}