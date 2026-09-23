package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getOdaGorseliInput() {
        return page.locator("input[type='file']").first();
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("text=Oda Türü");
    }

    public Locator getYatakOdasiSecenegi() {
        return page.locator("text=Yatak Odası");
    }

    public Locator getOturmaOdasiSecenegi() {
        return page.locator("text=Oturma Odası");
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("text=Tasarım Stili");
    }

    public Locator getModernSecenegi() {
        return page.locator("text=Modern");
    }

    public Locator getSkandinavSecenegi() {
        return page.locator("text=Skandinav");
    }

    public Locator getMevcutMobilyalariKaldirToggle() {
        return page.locator("text=Mevcut mobilyaları kaldır");
    }

    public Locator getDekorasyonOlusturButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getHerkeseAcikGaleriRadio() {
        return page.locator("text=Herkese açık galeride göster");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text='Desteklenmeyen dosya formatı'");
    }
}