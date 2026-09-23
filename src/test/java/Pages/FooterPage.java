package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class FooterPage {
    private Page page;

    public FooterPage() {
        this.page = PD.getPage();
    }

    public Locator getBultenEpostaAlani() {
        return page.locator("input[type='email'], footer input[placeholder*='e-posta'], footer input[name='email']");
    }

    public Locator getAboneOlButonu() {
        return page.locator("footer button:has-text('Abone Ol'), button:has-text('Abone ol')");
    }

    public Locator getBasariliAbonelikMesaji() {
        return page.locator(".success-message, :text('Başarılı abonelik')");
    }

    public Locator getSistemHataMesaji() {
        return page.locator(".error-message, .alert-danger, :text('Geçersiz')");
    }

    public Locator getGizlilikPolitikasiBaglantisi() {
        return page.locator("footer a:has-text('Gizlilik Politikası'), a:has-text('Gizlilik Politikası')");
    }

    public Locator getKullanimSartlariBaglantisi() {
        return page.locator("footer a:has-text('Kullanım Şartları'), a:has-text('Hizmet Şartları')");
    }

    public Locator getInstagramIkonu() {
        return page.locator("a[href*='instagram'], .instagram-icon, [aria-label='Instagram']");
    }
}