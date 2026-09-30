package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getProductsMenu() {
        return page.getByText("Ürünler");
    }

    public Locator getDropdownMenu() {
        return page.locator("nav");
    }

    public Locator getAiVirtualTourOption() {
        return page.getByText("Yapay Zeka Sanal Tur");
    }

    public Locator getEarlyAccessButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEmailInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getSendRequestButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getSuccessNotification() {
        return page.getByText("başarıyla");
    }

    public Locator getVirtualTourPageHeader() {
        return page.getByText("ai-virtual-tour");
    }

    public Locator getApiOption() {
        return page.getByText("Sanal Dekorasyon API");
    }

    public Locator getApiPageHeader() {
        return page.getByText("api");
    }

    public Locator getContactUsButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getNameInput() {
        return page.getByPlaceholder("Ad");
    }

    public Locator getMessageInput() {
        return page.getByPlaceholder("Mesaj");
    }

    public Locator getPricingViewButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }

    public Locator getPricingPageHeader() {
        return page.getByText("Fiyatlandırma");
    }
}