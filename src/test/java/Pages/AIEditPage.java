package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AIEditPage {
    private Page page;

    public AIEditPage() {
        this.page = PD.getPage();
    }

    public Locator getKaynakGorsel() {
        return page.locator(".source-image, img").first();
    }

    public Locator getDescribeInput() {
        return page.locator("input[placeholder*='describe'], textarea[placeholder*='describe']");
    }

    public Locator getEditPhotoButonu() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getGuncellenmisGorsel() {
        return page.locator(".result-image, img").last();
    }

    public Locator getTalimatUyariMesaji() {
        return page.locator("text=zorunlu");
    }
}