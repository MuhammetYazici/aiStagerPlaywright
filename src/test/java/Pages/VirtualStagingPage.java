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

    public Locator getFileUploadInput() {
        return page.locator("input[type='file']");
    }

    public Locator getSuccessUploadMessage() {
        return page.locator(".success-message, text=Görsel başarıyla yüklendi");
    }

    public Locator getImagePreview() {
        return page.locator(".image-preview img, .preview-container");
    }

    public Locator getErrorMessage() {
        return page.locator(".error-message, text=Desteklenmeyen dosya formatı");
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("text=Oda Türü").locator("..").locator("select, [role='combobox']");
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("text=Tasarım Stili").locator("..").locator("select, [role='combobox']");
    }

    public Locator getToggleMobilyaKaldtir() {
        return page.locator("text=Mevcut mobilyaları kaldır").locator("..").locator("input[type='checkbox']");
    }

    public Locator getRadioHerkeseAcikGaleri() {
        return page.locator("text=Herkese açık galeride göster");
    }

    public Locator getDekorasyonOlusturButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getAiEditTab() {
        return page.locator("text=AI Edit");
    }

    public Locator getCurrentImageRadioButton() {
        return page.locator("text=Current image");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='describe'], input[placeholder*='describe'], textarea");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getAiReviseSuccessMessage() {
        return page.locator(".ai-result, text=revize");
    }

    public Locator getTalimatBosUyarisi() {
        return page.locator("text=Talimat alanı boş bırakılamaz");
    }
}