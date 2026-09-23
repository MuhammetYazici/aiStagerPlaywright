package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getYuklemeAlani() {
        return page.locator("input[type='file']");
    }

    public Locator getOnizlemeGorseli() {
        return page.locator(".preview-image, img[alt*='preview'], .uploaded-image");
    }

    public Locator getMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("select[name='roomType'], .room-type-select, text=Oda Türü");
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("select[name='designStyle'], .design-style-select, text=Tasarım Stili");
    }

    public Locator getGorunurlukSecenegi(String gorunurluk) {
        return page.locator("text=" + gorunurluk);
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur'), button:has-text('Generate')");
    }

    public Locator getBasariliSonucGorseli() {
        return page.locator(".result-image, img[alt*='Staged'], .output-image");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, .alert-danger, text=hata");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator(".warning-message, .error, text=seçilmedi, text=zorunlu");
    }

    public Locator getAiEditSekmesi() {
        return page.locator("text=AI Edit, text=Edit");
    }

    public Locator getCurrentimageSecimi() {
        return page.locator("text=Current image, input[value='current']");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='Describe'], input[placeholder*='Describe']");
    }

    public Locator getEditPhotoButonu() {
        return page.locator("button:has-text('Edit Photo'), button:has-text('Düzenle')");
    }
}