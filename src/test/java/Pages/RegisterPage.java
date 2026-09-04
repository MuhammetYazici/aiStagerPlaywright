package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Locale;

public class RegisterPage {
    private final Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator emailInput(){
        return page.getByText("//input[@type='email']");
    }

    public Locator passwordInput(){
        return page.locator("(//input[@type='password'])[1]");
    }

    public Locator passwordRepeatInput(){
        return page.locator("(//input[@type='password'])[2]");
    }

    public Locator checkBoxButton(){
        return page.getByRole(AriaRole.CHECKBOX,new Page.GetByRoleOptions().setName("Kabul ediyorum: Hizmet Şartları ve Gizlilik Politikası"));
    }

    public Locator creatAccount(){
        return page.getByText("Hesap Oluştur");
    }

    public Locator control(){
        return page.getByText("Verify your email");
    }
}
