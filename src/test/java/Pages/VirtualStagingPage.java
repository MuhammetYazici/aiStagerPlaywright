package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class VirtualStagingPage {
    private Page page;

    public VirtualStagingPage() {
        this.page = PD.getPage();
    }

    public Locator getOdaTuruSelect() {
        return page.locator("text='Oda Türü'");
    }

    public Locator getTasarmStiliSelect() {
        return page.locator("text='Tasarım Stili'");
    }

    public Locator getMevcutMobilyalariKaldirToggle() {
        return page.locator("text='Mevcut mobilyaları kaldır'");
    }

    public Locator getDekorasyonOlusturButton() {
        return page.locator("button:has-text('Dekorasyon Oluştur')");
    }

    public Locator getYuklemeOnizlemesi() {
        return page.locator(".preview-container, img");
    }

    public Locator getHataMesajiLocator(String mesaj) {
        return page.locator("text='" + mesaj + "'");
    }

    public Locator getDosyaYuklemeInput() {
        return page.locator("input[type='file']");
    }

    public Locator getAiEditSekmesi() {
        return page.locator("text='AI Edit'");
    }

    public Locator getCurrentimageSecenegi() {
        return page.locator("text='Current image'");
    }

    public Locator getMetinAlani() {
        return page.locator("textarea, input[placeholder*='talimat'], input[placeholder*='change']");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getSonucGorseli() {
        return page.locator("img.result-image, .output-container img");
    }

    public Locator getIletisimeGecinButton() {
        return page.locator("button:has-text('İletişime Geçin'), a:has-text('İletişime Geçin')");
    }

    public Locator getAdAlani() {
        return page.locator("input[name='name'], input[placeholder*='Ad']");
    }

    public Locator getEpostaAlani() {
        return page.locator("input[name='email'], input[placeholder*='E-posta']");
    }

    public Locator getMesajAlani() {
        return page.locator("textarea[name='message'], textarea[placeholder*='Mesaj']");
    }

    public Locator getFormGonderButton() {
        return page.locator("button[type='submit']:has-text('Gönder'), button:has-text('Gönder')");
    }

    public Locator getBasariliMesaj() {
        return page.locator("text='başarıyla', text='Success', text='gönderildi'");
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.locator("text='Fiyatlandırmayı Görüntüle', a:has-text('Fiyatlandırma')");
    }
}