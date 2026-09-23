package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualTourPage {
    private Page page;

    public VirtualTourPage() {
        this.page = PD.getPage();
    }

    public Locator getErkenErisimIsteyinButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email']");
    }

    public Locator getFormGonderButton() {
        return page.locator("button:has-text('Gönder'), button[type='submit']");
    }

    public Locator getBasariMesaji() {
        return page.locator("text='Başarılı', text='teşekkürler', text='kayıt'");
    }

    public Locator getGecersizEmailHataMesaji() {
        return page.locator("text='Lütfen geçerli bir e-posta adresi girin'");
    }
}