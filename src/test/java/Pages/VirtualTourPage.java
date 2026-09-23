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

    public Locator getEpostaAlani() {
        return page.locator("input[type='email'], input[name='email']");
    }

    public Locator getTalepGonderButonu() {
        return page.locator("button:has-text('Gönder'), button[type='submit']");
    }

    public Locator getOnayMesaji() {
        return page.locator(".success-message, text=başarıyla, text=onay");
    }

    public Locator getGecersizEpostaHataMesaji() {
        return page.locator(".error, text=geçerli bir e-posta");
    }
}