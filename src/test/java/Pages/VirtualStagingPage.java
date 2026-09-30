package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getYuklemeAlani() {
        return page.locator("input[type='file']");
    }

    public Locator getOnizleme() {
        return page.locator(".preview-image, img");
    }

    public Locator getOdaTuruDropdown() {
        return page.getByText("Oda Türü");
    }

    public Locator getOturmaOdasiSecenegi() {
        return page.getByText("Oturma Odası");
    }

    public Locator getTasarimStiliDropdown() {
        return page.getByText("Tasarım Stili");
    }

    public Locator getModernSecenegi() {
        return page.getByText("Modern");
    }

    public Locator getMobilyaKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getHerkesAcikGalerideGosterRadio() {
        return page.getByText("Herkese açık galeride göster");
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getBasariliSonuc() {
        return page.locator(".result-image, canvas");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message");
    }

    public Locator getAiEditSekmesi() {
        return page.getByText("AI Edit");
    }

    public Locator getEditPhotoSourceDropdown() {
        return page.getByText("Current image");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.getByPlaceholder("Describe what to change");
    }

    public Locator getEditPhotoButonu() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }
}