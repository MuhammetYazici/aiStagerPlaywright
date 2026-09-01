package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class pages {
    private final Page page;

    public pages() {
        this.page = PD.getPage();
    }

    public Locator getLocator(String locate){
        switch (locate){
            case "giris Yap":
                return page.getByText("Giriş Yap").first();
            case "kayit ol":
                return page.getByText("Kayıt ol");
            case "email":
                return page.locator("//input[@type='email']");
            case "password":
                return page.locator("(//input[@type='password'])[1]");
            case "passwordRepeat":
                return page.locator("(//input[@type='password'])[2]");
            case "checkButton":
                return page.getByRole(AriaRole.CHECKBOX,new Page.GetByRoleOptions().setName("Kabul ediyorum: Hizmet Şartları ve Gizlilik Politikası"));
            case "creatAccount":
                return page.getByText("Hesap Oluştur");
            case "text":
                return page.getByText("Verify your email");
            case "girisYapButton":
                return page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Giriş Yap"));
            case "passwordLogin":
                return page.locator("input[type='password']");
            
            // Negatif Test Senaryoları için Locator'lar
            case "emailValidationError":
                return page.locator("//span[@class='error-message'] | //div[@class='field-error'] | //p[contains(@class,'error')]").first();
            case "passwordValidationError":
                return page.locator("//span[@class='error-message'] | //div[@class='field-error'] | //p[contains(@class,'error')]").nth(1);
            case "loginErrorMessage":
                return page.locator("//div[@class='alert alert-danger'] | //div[contains(@class,'error')] | //*[contains(text(),'E-posta veya şifre hatalı')]");
            case "requiredFieldError":
                return page.locator("//span[contains(text(),'Bu alan zorunludur')] | //p[contains(text(),'zorunlu')] | //div[contains(@class,'required')]");
            case "userNotFoundError":
                return page.locator("//*[contains(text(),'Kullanıcı bulunamadı')] | //*[contains(text(),'Bu kullanıcı kayıtlı değil')]");
            case "emailAlreadyExistsError":
                return page.locator("//*[contains(text(),'zaten kullanımda')] | //*[contains(text(),'Bu e-posta adresi')] | //*[contains(text(),'already registered')]");
            case "passwordPolicyError":
                return page.locator("//*[contains(text(),'8 karakter')] | //*[contains(text(),'Şifre en az')] | //*[contains(text(),'password policy')]");
            case "passwordMismatchError":
                return page.locator("//*[contains(text(),'eşleşmiyor')] | //*[contains(text(),'Şifreler eşleşmelidir')] | //*[contains(text(),'match')]");
            
            default:
                throw new IllegalArgumentException("Aranan locator bulunamadı. "+locate);
        }
    }

}
