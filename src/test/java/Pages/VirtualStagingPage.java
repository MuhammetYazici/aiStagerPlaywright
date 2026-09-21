package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getVirtualStagingHeader() {
        return page.locator("h1:has-text('Virtual Staging'), h2:has-text('Virtual Staging')");
    }

    public Locator getUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getRoomTypeDropdown() {
        return page.locator("select[name='roomType'], [data-testid='room-type-select']");
    }

    public Locator getDesignStyleDropdown() {
        return page.locator("select[name='designStyle'], [data-testid='design-style-select']");
    }

    public Locator getRemoveExistingFurnitureToggle() {
        return page.locator("input[type='checkbox'][name='removeFurniture'], [data-testid='remove-furniture-toggle']");
    }

    public Locator getGenerateButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Generate')");
    }

    public Locator getAnalysisMessage() {
        return page.locator("text=analiz eder, text=Analyzing");
    }

    public Locator getResultImage() {
        return page.locator("img[alt*='Result'], img[alt*='Decorated']");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, [role='alert']");
    }

    public Locator getAIEditTab() {
        return page.locator("text=AI Edit");
    }

    public Locator getDescribeInput() {
        return page.locator("textarea[placeholder*='describe'], input[placeholder*='talimat']");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo'), button:has-text('Düzenle')");
    }

    public Locator getProductsMenu() {
        return page.locator("text=Ürünler, text=Products");
    }

    public Locator getVirtualTourSubMenu() {
        return page.locator("text=Yapay Zeka Sanal Tur, text=Virtual Tour");
    }

    public Locator getApiSubMenu() {
        return page.locator("text=Sanal Dekorasyon API, text=API");
    }

    public Locator getEarlyAccessButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim')");
    }

    public Locator getNameInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad Soyad']");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder*='you@example.com']");
    }

    public Locator getSubmitButton() {
        return page.locator("button[type='submit'], button:has-text('Gönder')");
    }

    public Locator getSuccessMessage() {
        return page.locator("text=başarıyla, text=Success, text=onay");
    }

    public Locator getContactUsButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişim')");
    }

    public Locator getPricingButton() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırma')");
    }
}