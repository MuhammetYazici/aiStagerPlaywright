package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    public Locator productsMenu() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ürünler"));
    }

    public Locator aiVirtualTourSubMenu() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yapay Zeka Sanal Tur"));
    }

    public Locator aiVirtualStagingApiSubMenu() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sanal Dekorasyon API"));
    }
}