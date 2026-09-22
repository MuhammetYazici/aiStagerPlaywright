package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getErkenErisimIsteyinButonu() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEpostaInput() {
        return page.locator("input[type='email'], input[name='email']");
    }

    public Locator getGonderButonu() {
        return page.locator("button:has-text('Gönder'), button[type='submit']");
    }

    public Locator getOnayMesaji() {
        return page.locator("text=başarıyla alındı");
    }

    public Locator getIletisimeGecinButonu() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırmayı Görüntüle')");
    }

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea, input[name='message']");
    }

    public Locator getValidasyonHataMesaji() {
        return page.locator("text=lütfen geçerli bir eposta adresi girin");
    }
}