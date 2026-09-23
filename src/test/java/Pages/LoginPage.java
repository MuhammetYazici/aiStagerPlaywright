package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[type='password']");
    }

    public Locator getSifreGozIkonu() {
        return page.locator("[class*='eye'], [class*='password-toggle']");
    }

    public Locator getGirisYapSubmitButton() {
        return page.locator("button[type='submit'], text=Giriş Yap");
    }

    public Locator getGoogleIleGirisButton() {
        return page.locator("text=Google ile");
    }

    public Locator getGoogleHesapSecimEkranı() {
        return page.locator("[id*='account'], [class*='google']");
    }

    public Locator getSifremiUnuttumLink() {
        return page.locator("text=Şifremi unuttum");
    }

    public Locator getKayıtOlLink() {
        return page.locator("text=Kayıt ol, text=Hesabınız yok mu");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur");
    }

    public Locator getGecersizEpostaUyarisi() {
        return page.locator("text=Geçersiz e-posta");
    }

    public Locator getGenelHataMesaji() {
        return page.locator("text=E-posta veya şifre hatalı");
    }

    public Locator getSqlEnjeksiyonEngelMesaji() {
        return page.locator("text=Hata, [class*='error']");
    }
}