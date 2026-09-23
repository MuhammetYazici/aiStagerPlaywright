package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("select[name='roomType'], div:has-text('Oturma Odası')");
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("select[name='designStyle'], div:has-text('Modern')");
    }

    public Locator getMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox'], .toggle-switch");
    }

    public Locator getGorunurlukSecenegi() {
        return page.locator("text=Herkese açık galeride göster");
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getDosyaYuklemeInput() {
        return page.locator("input[type='file']");
    }

    public Locator getGorselOnizleme() {
        return page.locator("img.preview-image, .image-preview-container");
    }

    public Locator getAIEditSekmesi() {
        return page.locator("text=AI Edit");
    }

    public Locator getCurrentImageSecenegi() {
        return page.locator("text=Current image");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='change'], input[placeholder*='Describe']");
    }

    public Locator getEditPhotoButonu() {
        return page.locator("button:has-text('Edit Photo')");
    }
}