package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AiStagerPage {
    private Page page;

    public AiStagerPage() {
        this.page = PD.getPage();
    }

    public Locator getSagYonOku() {
        return page.locator("button.slider-next, [aria-label='Next']");
    }

    public Locator getSliderGorseli() {
        return page.locator(".slider-image, .carousel-item.active");
    }

    public Locator getCaruselNoktasi(String noktaNumarasi) {
        return page.locator(".carousel-indicators button, .dot").nth(Integer.parseInt(noktaNumarasi) - 1);
    }

    public Locator getOdaGorseli(String odaNumarasi) {
        return page.locator(".carousel-item, .slide").nth(Integer.parseInt(odaNumarasi) - 1);
    }

    public Locator getSliderAlani() {
        return page.locator(".slider-container, .carousel");
    }

    public Locator getHeaderMenuOgesi(String ogeAdi) {
        return page.locator("nav a, header button").filter(new Locator.FilterOptions().setHasText(ogeAdi));
    }

    public Locator getGaleriFiltresi(String filtreAdi) {
        return page.locator(".filter-btn, button").filter(new Locator.FilterOptions().setHasText(filtreAdi));
    }

    public Locator getGaleriKarti(String kategori) {
        return page.locator(".gallery-card").filter(new Locator.FilterOptions().setHasText(kategori));
    }

    public Locator getBegeniIkonu() {
        return page.locator(".like-btn, .heart-icon").first();
    }

    public Locator getDahaFazlaTasarimYukleButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getSssSorusu(String soruNumarasi) {
        return page.locator(".faq-item, .accordion-header").nth(Integer.parseInt(soruNumarasi) - 1);
    }

    public Locator getSssIcerigi(String soruNumarasi) {
        return page.locator(".faq-content, .accordion-body").nth(Integer.parseInt(soruNumarasi) - 1);
    }

    public Locator getBultenEpostaInput() {
        return page.locator("input[type='email'], .newsletter-input").first();
    }

    public Locator getBultenAboneOlButonu() {
        return page.locator("button.subscribe-btn, form button[type='submit']").first();
    }

    public Locator getBultenSonucMesaji() {
        return page.locator(".newsletter-message, .alert");
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

    public Locator getGirisYapSubmitButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getKayitOlSubmitButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getHataMesajiDiv() {
        return page.locator(".error-message, .invalid-feedback, .alert-danger");
    }

    public Locator getSifreGozIkonu() {
        return page.locator(".toggle-password, .eye-icon").first();
    }

    public Locator getGoogleIleDevamEtButonu() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getTermsCheckbox() {
        return page.locator("#terms-accept");
    }

    public Locator getGirisYapBaglantisi() {
        return page.getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }
}