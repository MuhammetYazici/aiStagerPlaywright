package Pages;

import Utilities.PD;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getSifreInput() {
        return page.locator("input[name='password'], input[type='password']");
    }

    public Locator getSifreyiOnaylaInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder*='tekrar']");
    }

    public Locator getKullanimSozlesmesiCheckbox() {
        return page.locator("input[type='checkbox'], #terms-accept");
    }

    public Locator getKayıtOlButton() {
        return page.locator("button[type='submit'], text=Hesap Oluştur");
    }

    public Locator getGoogleIleKayıtButton() {
        return page.locator("text=Google ile devam et");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=başarılı, text=oluşturuldu");
    }

    public Locator getZorunluAlanUyarisi() {
        return page.locator("text=Bu alan zorunludur");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=zaten kullanımda, text=kayıtlı");
    }

    public Locator getSifreKriterUyarisi() {
        return page.locator("text=en az 8 karakter, text=eşleşmiyor");
    }

    public Locator getSozlesmeOnayUyarisi() {
        return page.locator("text=sözleşme, text=onaylanması");
    }
}