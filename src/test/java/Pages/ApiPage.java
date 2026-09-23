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

    public Locator getEmailInput() {
        return page.locator("input[type='email']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea");
    }

    public Locator getFormGonderButton() {
        return page.locator("button:has-text('Gönder'), button[type='submit']");
    }

    public Locator getBasariMesaji() {
        return page.locator("text='Mesajınız gönderildi', text='Başarılı'");
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.locator("text='Fiyatlandırmayı Görüntüle'");
    }

    public Locator getZorunluAlanHataMesaji() {
        return page.locator("text='Alan zorunlu', text='Bu alan doldurulmalıdır'");
    }

    public Locator getKarakterSiniriHataMesaji() {
        return page.locator("text='Karakter sınırı', text='Çok uzun'");
    }
}