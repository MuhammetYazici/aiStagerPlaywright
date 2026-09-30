package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class ApiPage {
    private Page page;

    public ApiPage() {
        this.page = PD.getPage();
    }

    public Locator getIletisimeGecinButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getAdSoyadInput() {
        return page.locator("input[name*='name']").first();
    }

    public Locator getEmailInput() {
        return page.locator("input[type='email']").first();
    }

    public Locator getMesajInput() {
        return page.locator("textarea").first();
    }

    public Locator getFormGonderButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getOnayMesaji() {
        return page.locator(".success-message, [role='status']");
    }

    public Locator getFormatHatasiMesaji() {
        return page.locator(".error-message, :invalid");
    }
}