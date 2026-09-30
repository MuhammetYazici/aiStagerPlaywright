package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class VirtualTourPage {
    private Page page;

    public VirtualTourPage() {
        this.page = PD.getPage();
    }

    public Locator getErkenErisimIsteyinButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email']");
    }

    public Locator getFormGonderButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getOnayMesaji() {
        return page.locator(".success-message, [role='status']");
    }

    public Locator getZorunluAlanUyari() {
        return page.locator(".error, :invalid");
    }
}