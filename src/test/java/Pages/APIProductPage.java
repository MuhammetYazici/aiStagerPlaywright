package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class APIProductPage extends BasePage {

    public Locator contactFormInput() {
        return page.locator("input[name='name'], input[type='text']").first();
    }

    public Locator sendContactButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geç"));
    }

    public Locator pricingButton() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }
}