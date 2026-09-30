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

    public Locator getFileInput() {
        return page.locator("input[type='file']");
    }

    public Locator getGorselOnizleme() {
        return page.locator("img[alt*='preview'], img[src*='blob']");
    }

    public Locator getOdaTuruDropdown(String odaTuru) {
        return page.getByText(odaTuru);
    }

    public Locator getTasarimStiliDropdown(String stil) {
        return page.getByText(stil);
    }

    public Locator getMevcutMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox'], [role='switch']").first();
    }

    public Locator getRadioButon() {
        return page.locator("input[type='radio']").first();
    }

    public Locator getDekorasyonOlusturButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, [role='alert']");
    }
}