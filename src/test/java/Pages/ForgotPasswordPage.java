package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ForgotPasswordPage {
    private final Page page;

    public ForgotPasswordPage() {
        this.page = PD.getPage();
    }

    public Locator forgotPassEmail(){
        return page.locator("[type='email']");
    }

    public Locator sifirlamaButton(){
        return page.getByText("Sıfırlama E-postası Gönder");
    }

    public Locator message(){
        return page.locator("//div[@class='text-center mb-7']/following-sibling::div[1]");
    }


}
