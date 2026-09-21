package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class HomePage {
    private Page page;

    public HomePage() {
        this.page = PD.getPage();
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email']");
    }

    public Locator getPasswordInput() {
        return page.locator("input[name='password']");
    }

    public Locator getConfirmPasswordInput() {
        return page.locator("input[name='confirmPassword']");
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getHesapOlusturButton() {
        return page.locator("button:has-text('Hesap Oluştur')");
    }

    public Locator getGirisYapLink() {
        return page.locator("a:has-text('Giriş yap')");
    }

    public Locator getTumuKabulEtButton() {
        return page.locator("button:has-text('Tümünü Kabul Et')");
    }

    public Locator getSliderComponent() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getGallerySection() {
        return page.locator(".gallery-section, [class*='gallery']");
    }

    public Locator getTumTiplerFilter() {
        return page.locator("text='Tüm Tipler'");
    }

    public Locator getOturmaOdasiFilter() {
        return page.locator("text='Oturma Odası'");
    }

    public Locator getHeartIcon() {
        return page.locator(".heart-icon, [class*='heart']").first();
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text='Daha Fazla Tasarım Yükle'");
    }

    public Locator getFaqFirstTitle() {
        return page.locator(".faq-item, [class*='faq']").first();
    }

    public Locator getFaqSecondTitle() {
        return page.locator(".faq-item, [class*='faq']").nth(1);
    }

    public Locator getBizeUlasinLink() {
        return page.locator("text='Bize ulaşın'");
    }

    public Locator getFooterNewsletterInput() {
        return page.locator("input[placeholder='you@example.com']").first();
    }

    public Locator getAboneOlButton() {
        return page.locator("button:has-text('Abone Ol')");
    }

    public Locator getGoogleIleDevamEtButton() {
        return page.locator("button:has-text('Google ile devam et')");
    }

    public Locator getGirisYapButton() {
        return page.locator("button:has-text('Giriş Yap')");
    }

    public Locator getPasswordEyeIcon() {
        return page.locator(".password-toggle, [class*='eye']").first();
    }
}