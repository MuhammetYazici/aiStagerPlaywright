package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getDosyaYuklemeAlani() {
        return page.locator("input[type='file']");
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("select[name='roomType'], div:has-text('Oda Türü')");
    }

    public Locator getYatakOdasiSecenegi() {
        return page.locator("text=Yatak Odası");
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("select[name='designStyle'], div:has-text('Tasarım Stili')");
    }

    public Locator getModernSecenegi() {
        return page.locator("text=Modern");
    }

    public Locator getMevcutMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getBasariGorseli() {
        return page.locator("img[alt*='generated'], .generated-image");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, div:has-text('Geçersiz dosya formatı'), div:has-text('Lütfen zorunlu alanları doldurun')");
    }
}