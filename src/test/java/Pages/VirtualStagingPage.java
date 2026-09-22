package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getDosyaYuklemeInput() {
        return page.locator("input[type='file']");
    }

    public Locator getMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getOturmaOdasiSecenegi() {
        return page.locator("text=Oturma Odası");
    }

    public Locator getModernStilSecenegi() {
        return page.locator("text=Modern");
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=başarıyla üretildi");
    }

    public Locator getZorunluAlanHataMesaji() {
        return page.locator("text=lütfen zorunlu alanları doldurun");
    }

    public Locator getFormatHataMesaji() {
        return page.locator("text=lütfen jpg veya png yükleyin");
    }

    public Locator getBoyutHataMesaji() {
        return page.locator("text=maksimum 10MB yükleyebilirsiniz");
    }
}