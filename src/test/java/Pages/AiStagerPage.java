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

    public Locator getBeforeAfterSlider() {
        return page.locator(".before-after-slider, [class*='slider']");
    }

    public Locator getLanguageMenu() {
        return page.locator("text=TR, [class*='language']");
    }

    public Locator getOturmaOdasiFilter() {
        return page.locator("text=Oturma Odasi");
    }

    public Locator getDahaFazlaTasarimYukleButton() {
        return page.locator("text=Daha Fazla Tasarım Yükle");
    }

    public Locator getFirstSssQuestion() {
        return page.locator(".faq-item, [class*='accordion']").first();
    }

    public Locator getSecondSssQuestion() {
        return page.locator(".faq-item, [class*='accordion']").nth(1);
    }

    public Locator getLoginButtonTop() {
        return page.getByText("Giriş yap", new Page.GetByTextOptions().setExact(true));
    }

    public Locator getFreeTrialButtonTop() {
        return page.locator("text=Ücretsiz Dene");
    }

    public Locator getUretimlerimMenu() {
        return page.locator("text=Üretimlerim");
    }

    public Locator getProfileIcon() {
        return page.locator("[class*='profile'], [aria-label='Profile']");
    }

    public Locator getNavProducts() {
        return page.locator("text=ürün");
    }

    public Locator getNavSolutions() {
        return page.locator("text=çözüm");
    }

    public Locator getNavResources() {
        return page.locator("text=kaynak");
    }

    public Locator getNavPricing() {
        return page.locator("text=fiyatlandırma");
    }

    public Locator getNewsletterInput() {
        return page.locator("input[type='email'], input[placeholder*='e-posta']");
    }

    public Locator getNewsletterSubmitButton() {
        return page.locator("button:has-text('Abone Ol'), button:has-text('Gönder')");
    }

    public Locator getSuccessMessage() {
        return page.locator("text=Başarılı, text=Abone Olundu");
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

    public Locator getRegisterSubmitButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public Locator getPasswordToggleIcon() {
        return page.locator("[class*='eye-icon'], [class*='visibility']");
    }

    public Locator getGoogleLoginButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getErrorMessage() {
        return page.locator("[class*='error'], [class*='alert']");
    }

    public Locator getSanalDekorasyonSayfasi() {
        return page.locator("text=Sanal Dekorasyon");
    }

    public Locator getGorselYuklemeInput() {
        return page.locator("input[type='file']");
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("text=Oda Türü");
    }

    public Locator getOdaTuruSecenek(String odaTuru) {
        return page.locator("text=" + odaTuru);
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("text=Tasarım Stili");
    }

    public Locator getTasarimStiliSecenek(String tasarimStili) {
        return page.locator("text=" + tasarimStili);
    }

    public Locator getMobilyalariKaldirToggle() {
        return page.locator("text=Mevcut mobilyaları kaldır");
    }

    public Locator getGalerideGosterSecenek() {
        return page.locator("text=Galeride Göster");
    }

    public Locator getDekorasyonOlusturButonu() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getYapayZekaSurecMesaji() {
        return page.locator("text=Yapay zeka süreci başlatıldı");
    }

    public Locator getBasariliGorselDogrulama() {
        return page.locator("img[alt='Decorated Room']");
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, text=zorunlu");
    }

    public Locator getGecersizFormatHataMesaji() {
        return page.locator("text=Geçersiz dosya formatı");
    }

    public Locator getAiEditSekmesi() {
        return page.locator("text=AI Edit");
    }

    public Locator getCurrentImageView() {
        return page.locator("text=Current image");
    }

    public Locator getDescribeInput() {
        return page.locator("placeholder='Describe what to change'");
    }

    public Locator getEditPhotoButonu() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getDuzenlemeBasariliMesaji() {
        return page.locator("text=düzenleme başarıyla gerçekleştirildi");
    }

    public Locator getUrunlerDropdown() {
        return page.locator("text=Ürünler");
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.locator("text=Yapay Zeka Sanal Tur");
    }

    public Locator getErkenErisimIsteyinButonu() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim İsteyin')");
    }

    public Locator getEpostaInput() {
        return page.locator("input[name='email'], input[placeholder='you@example.com']");
    }

    public Locator getTalepGonderButonu() {
        return page.locator("button:has-text('Gönder'), button:submit");
    }

    public Locator getBasariMesaji() {
        return page.locator("text=başarı");
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.locator("text=Sanal Dekorasyon API");
    }

    public Locator getIletisimeGecinButonu() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea");
    }

    public Locator getFiyatlandirmayiGoruntuleButonu() {
        return page.locator("text=Fiyatlandırmayı Görüntüle");
    }
}