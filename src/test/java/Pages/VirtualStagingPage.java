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

    public Locator getMevcutMobilyalariKaldirCheckbox() {
        return page.locator("input[name='removeFurniture'], text=Mevcut mobilyaları kaldır");
    }

    public Locator getOdaTuruSecimi() {
        return page.locator("select[name='roomType'], .room-type-selector");
    }

    public Locator getTasarimStiliSecimi() {
        return page.locator("select[name='designStyle'], .design-style-selector");
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getBasariMesaji() {
        return page.locator(".success-message, text=İşlem başarıyla tamamlandı");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text=hata");
    }
}