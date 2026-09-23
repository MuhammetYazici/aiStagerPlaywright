package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class ApiPage {
    private Page page;

    public ApiPage() {
        this.page = PD.getPage();
    }

    public Locator getContactUsButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getNameInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getMessageInput() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getPricingButton() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırma')");
    }

    public Locator getSubmitButton() {
        return page.locator("button[type='submit'], button:has-text('Gönder')");
    }

    public Locator getSuccessMessage() {
        return page.locator("text='başarı', text='alındı', text='onay'");
    }

    public Locator getValidationError() {
        return page.locator("text='zorunlu', text='eksik', .error-message, [role='alert']");
    }

    public Locator getCharacterLimitError() {
        return page.locator("text='sınır', text='karakter', .error-message");
    }
}