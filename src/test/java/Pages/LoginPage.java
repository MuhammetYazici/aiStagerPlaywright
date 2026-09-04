package Pages;


import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator emailInput(){
        return page.locator("//input[@type='email']");
    }

    public Locator passwordInput(){
        return page.locator("input[type='password']");
    }

    public Locator girisYapInput(){
        return page.getByText("Giriş Yap").last();
    }

    public Locator forgotPassword(){
        return page.getByText("Şifremi unuttum?");
    }

}
