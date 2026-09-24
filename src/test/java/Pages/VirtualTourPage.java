package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualTourPage {
    private Page page;

    public VirtualTourPage() {
        this.page = PD.getPage();
    }

    public Locator getErkenErisimIsteyinButonu() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getAdSoyadInput() {
        return page.locator("input[name='fullName'], input[placeholder*='Ad']");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='email']");
    }

    public Locator getGonderButonu() {
        return page.locator("button[type='submit']:has-text('Gönder'), button:has-text('Gönder')");
    }

    public Locator getOnayMesaji() {
        return page.locator("text=başarılı, text=talebi alır");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text=zorunlu");
    }
}