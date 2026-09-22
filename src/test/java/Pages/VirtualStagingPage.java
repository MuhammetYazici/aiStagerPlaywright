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

    public Locator getOdaTuruDropdown() {
        return page.locator("select[name='roomType'], div:has-text('Oda Türü')").first();
    }

    public Locator getOturmaOdasiSecenegi() {
        return page.locator("text=Oturma Odası").first();
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("select[name='designStyle'], div:has-text('Tasarım Stili')").first();
    }

    public Locator getModernSecenegi() {
        return page.locator("text=Modern").first();
    }

    public Locator getMevcutMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getRadyoButon() {
        return page.locator("input[type='radio']").first();
    }

    public Locator getDekorasyonOlusturButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getBasariliUretimGorseli() {
        return page.locator("img[alt*='generated'], .result-image").first();
    }

    public Locator getYuklemeHataMesaji() {
        return page.locator(".error-message, text=Desteklenmeyen, text=hata").first();
    }

    public Locator getZorunluAlanUyariMesaji() {
        return page.locator("text=seçilmesi gerektiğini, text=zorunlu").first();
    }

    public Locator getBosOdaGorseliYuklemeEkrani() {
        return page.locator(".upload-container, input[type='file']").first();
    }
}