package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import Utilities.PD;

public class AIStagerPages {
    private Page page;

    public AIStagerPages() {
        this.page = PD.getPage();
    }

    public Locator getSanalDekorasyonLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sanal Dekorasyon"));
    }

    public Locator getDosyaYuklemeInput() {
        return page.locator("input[type='file']");
    }

    public Locator getOdaTuruDropdown() {
        return page.locator("select[name='roomType'], div:has-text('Oda Türü')").first();
    }

    public Locator getTasarimStiliDropdown() {
        return page.locator("select[name='designStyle'], div:has-text('Tasarım Stili')").first();
    }

    public Locator getMobilyalariKaldirToggle() {
        return page.locator("input[type='checkbox']").first();
    }

    public Locator getDekorasyonOlusturButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getBasariliGorselSonucu() {
        return page.locator("img[alt*='result'], div.result-container").first();
    }

    public Locator getHataMesaji() {
        return page.locator(".error-message, [role='alert']").first();
    }

    public Locator getAiEditSekmesi() {
        return page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("AI Edit")).first();
    }

    public Locator getCurrentimageSecenegi() {
        return page.locator("text=Current image").first();
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea, input[placeholder*='Describe']").first();
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator getUrunlerDropdown() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ürünler"));
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yapay Zeka Sanal Tur"));
    }

    public Locator getErkenErisimIsteyinButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEmailInput() {
        return page.locator("input[name='email'], input[type='email']").first();
    }

    public Locator getFormGonderButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder")).first();
    }

    public Locator getBasariOnayMesaji() {
        return page.locator("text=başarılı, text=success, .success-message").first();
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sanal Dekorasyon API"));
    }

    public Locator getIletisimeGecinButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getAdSoyadInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']").first();
    }

    public Locator getMesajInput() {
        return page.locator("textarea[name='message'], textarea").first();
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }
}