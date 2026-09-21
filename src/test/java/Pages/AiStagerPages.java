package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPages {
    private Page page;

    public AiStagerPages() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapLink() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getVirtualStagingMenu() {
        return page.locator("a:has-text('Virtual Staging'), a:has-text('Sanal Dekorasyon')");
    }

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getPreviewImage() {
        return page.locator("img[alt*='preview'], .preview-container img, img");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select[name='roomType'], [role='combobox']:has-text('Oda Türü'), div:has-text('Oda Türü')");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select[name='style'], [role='combobox']:has-text('Tasarım Stili'), div:has-text('Tasarım Stili')");
    }

    public Locator getRemoveFurnitureToggle() {
        return page.locator("input[type='checkbox'], [role='switch']");
    }

    public Locator getGalleryVisibility() {
        return page.locator("select[name='visibility'], input[value='public']");
    }

    public Locator getCreateDecorationButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Generate')");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, [role='alert'], div:has-text('desteklenmeyen'), div:has-text('Lütfen')");
    }

    public Locator getAiEditTab() {
        return page.locator("a:has-text('AI Edit'), button:has-text('AI Edit')");
    }

    public Locator getDescribeInput() {
        return page.locator("textarea, input[placeholder*='Describe'], input[placeholder*='değişikliği']");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo'), button:has-text('Düzenle')");
    }

    public Locator getUrunlerMenu() {
        return page.locator("nav a:has-text('Ürünler'), span:has-text('Ürünler')");
    }

    public Locator getVirtualTourSubMenu() {
        return page.locator("a:has-text('Yapay Zeka Sanal Tur'), a:has-text('Virtual Tour')");
    }

    public Locator getApiSubMenu() {
        return page.locator("a:has-text('Sanal Dekorasyon API'), a:has-text('API')");
    }

    public Locator getErkenErisimButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim')");
    }

    public Locator getLeadEmailInput() {
        return page.locator("input[type='email'], input[placeholder*='email']");
    }

    public Locator getTalepGonderButton() {
        return page.locator("button:has-text('Talep gönder'), button:has-text('Gönder')");
    }

    public Locator getSuccessMessage() {
        return page.locator(".success-message, [role='status'], div:has-text('alınmıştır'), div:has-text('teşekkürler')");
    }

    public Locator getIletisimeGecButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişim')");
    }

    public Locator getContactFormInputs() {
        return page.locator("form input, form textarea");
    }

    public Locator getSubmitFormButton() {
        return page.locator("form button[type='submit']");
    }

    public Locator getPricingButton() {
        return page.locator("a:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırma')");
    }
}