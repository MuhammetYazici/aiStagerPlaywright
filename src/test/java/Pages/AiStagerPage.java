package Pages;
import com.microsoft.playwright.options.AriaRole;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPage {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
    }

    public Locator getTumunuKabulEtButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getSliderAlani() {
        return page.locator(".slider-container, [class*='slider']").first();
    }

    public Locator getDilSecenegi() {
        return page.locator("text=TR").first();
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Uretimlerim").first();
    }

    public Locator getKameraAyarlaPaneli() {
        return page.locator("[class*='camera'], [class*='panel']").first();
    }

    public Locator getProfilMenu() {
        return page.locator("[class*='profile'], img[alt*='profile']").first();
    }

    public Locator getLogo() {
        return page.locator("header img, nav img, a.logo").first();
    }

    public Locator getGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getUcretsizDeneButton() {
        return page.locator("text=Ucretsiz Dene").first();
    }

    public Locator getGaleriAlani() {
        return page.locator("[class*='gallery'], section.galeri").first();
    }

    public Locator getTumTiplerFiltre() {
        return page.locator("text=Tum Tipler").first();
    }

    public Locator getOdaTipiFiltreButonu() {
        return page.locator("[class*='filter-btn'], button.category").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarim Yukle").first();
    }

    public Locator getTasarimKarti() {
        return page.locator("[class*='design-card'], [class*='card']").first();
    }

    public Locator getKullaniciProfili() {
        return page.locator("[class*='user-profile'], .author-name").first();
    }

    public Locator getBegeniIkonu() {
        return page.locator("[class*='like'], svg[class*='heart']").first();
    }

    public Locator getSayacDegeri() {
        return page.locator("[class*='count'], .like-count").first();
    }

    public Locator getSssBolumu() {
        return page.locator("[class*='faq'], section.accordion").first();
    }

    public Locator getSssSorusu() {
        return page.locator("[class*='accordion-item'], .faq-question").first();
    }

    public Locator getBultenFormu() {
        return page.locator("input[type='email'], input[placeholder*='mail'], input[placeholder*='e-posta']").first();
    }

    public Locator getKaydolButton() {
        return page.locator("button:has-text('Kaydol'), button:has-text('Abone Ol')").first();
    }

    public Locator getBasariMesaji() {
        return page.locator("text=Basarili, text=Tesekkurler, [class*='success']").first();
    }

    public Locator getHataMesaji() {
        return page.locator("[class*='error'], [class*='alert'], text=hata").first();
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']").first();
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password'], input[type='password']").first();
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']").first();
    }

    public Locator getGirisButonu() {
        return page.locator("button:has-text('Giriş'), button[type='submit']").first();
    }

    public Locator getGoogleIleGirisYapButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getHesapOlusturButton() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }
}