package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPages {
    private Page page;

    public AiStagerPages() {
        this.page = PD.getPage();
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getProfilIkonu() {
        return page.locator(".profile-icon, [data-testid='profile-icon']");
    }

    public Locator getUretimlerimAlani() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getSliderAlani() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getAltOkVeyaNokta() {
        return page.locator(".slider-dots button, .slider-arrow");
    }

    public Locator getOdaniziYukleyinButton() {
        return page.locator("text=Odanızı Yükleyin");
    }

    public Locator getOturmaOdasiFiltresi() {
        return page.locator("text=Oturma Odası");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getSssSoruBasligi() {
        return page.locator(".faq-item h3, .faq-question").first();
    }

    public Locator getIkinciSssSoruBasligi() {
        return page.locator(".faq-item h3, .faq-question").nth(1);
    }

    public Locator getFaqCevabi() {
        return page.locator(".faq-answer, .faq-content").first();
    }

    public Locator getBultenEmailInput() {
        return page.locator("footer input[type='email'], .newsletter-input");
    }

    public Locator getAboneOlButton() {
        return page.locator("footer button:has-text('Abone Ol'), .newsletter-btn");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=Başarıyla abone oldunuz");
    }

    public Locator getValidasyonHataMesaji() {
        return page.locator(".error-message, [class*='error']");
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[placeholder='Min. 8 karakter']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword'], input[placeholder='Şifrenizi tekrar girin']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept, input[type='checkbox']");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }
}