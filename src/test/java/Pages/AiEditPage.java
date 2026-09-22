package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiEditPage {
    private Page page;

    public AiEditPage() {
        this.page = PD.getPage();
    }

    public Locator getCurrentImageSecenegi() {
        return page.locator("text=Current image, input[value='current']").first();
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("input[placeholder*='Describe'], textarea[placeholder*='Describe']").first();
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getGuncelGorsel() {
        return page.locator("img.edited-image, .result-preview").first();
    }

    public Locator getDegisiklikTanimiUyariMesaji() {
        return page.locator("text=değişiklik tanımı, text=girmesi gerektiğini").first();
    }

    public Locator getYeniGorselYuklemeAlani() {
        return page.locator("input[type='file']").first();
    }
}