package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualTourPage {
    private Page page;

    public VirtualTourPage() {
        this.page = PD.getPage();
    }

    public Locator getEarlyAccessButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim')");
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email'], input[name='email']");
    }

    public Locator getSubmitButton() {
        return page.locator("button[type='submit'], button:has-text('Gönder')");
    }

    public Locator getSuccessNotification() {
        return page.locator("text='başarıyla', text='onay', [role='alert']");
    }

    public Locator getEmailErrorMessage() {
        return page.locator("text='geçerli', text='zorunlu', .error-message");
    }
}