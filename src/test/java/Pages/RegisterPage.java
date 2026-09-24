package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class RegisterPage {
    private Page page;

    public RegisterPage() {
        this.page = PD.getPage();
    }

    public Locator getKayitEpostaInput() {
        return page.locator("input[name='email'], input[type='email']");
    }

    public Locator getKayitSifreInput() {
        return page.locator("input[name='password'], input[type='password']").first();
    }

    public Locator getKayitSifreOnayInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder*='Şifrenizi tekrar']");
    }

    public Locator getSozlesmeCheckbox() {
        return page.locator("input[type='checkbox'], #terms-accept");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur'), button:has-text('Kayıt Ol')");
    }

    public Locator getBasariliHesapOlusturma() {
        return page.locator("text=Hesap başarıyla oluşturuldu");
    }

    public Locator getSozlesmeKabulEtmelisinizUyarisi() {
        return page.locator("text=Sözleşmeyi kabul etmelisiniz");
    }

    public Locator getZatenKullanimdaUyarisi() {
        return page.locator("text=Bu e-posta adresi zaten kullanımda");
    }

    public Locator getSifreUzunlukUyarisi() {
        return page.locator("text=En az 8 karakter");
    }

    public Locator getSifrelerEslesmiyorUyarisi() {
        return page.locator("text=Şifreler eşleşmiyor");
    }
}