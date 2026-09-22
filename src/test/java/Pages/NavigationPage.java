package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class NavigationPage {
    private Page page;

    public NavigationPage() {
        this.page = PD.getPage();
    }

    public Locator getHeaderAlanindanUrunlerMenu() {
        return page.locator("text=Ürünler, a:has-text('Ürünler')").first();
    }

    public Locator getYapayZekaSanalTurSecenegi() {
        return page.locator("text=Yapay Zeka Sanal Tur").first();
    }

    public Locator getErkenErisimIsteyinButton() {
        return page.locator("button:has-text('Erken Erişim İsteyin'), a:has-text('Erken Erişim')").first();
    }

    public Locator getEpostaInputForm() {
        return page.locator("input[type='email'], input[placeholder*='example']").first();
    }

    public Locator getGonderButton() {
        return page.locator("button:has-text('Gönder'), button[type='submit']").first();
    }

    public Locator getBasariliGonderimOnayiMesaji() {
        return page.locator("text=başarıyla, text=onay, text=teşekkürler").first();
    }

    public Locator getEpostaFormatHataMesaji() {
        return page.locator("text=geçersiz, text=format, text=hata").first();
    }

    public Locator getSanalDekorasyonApiSecenegi() {
        return page.locator("text=Sanal Dekorasyon API").first();
    }

    public Locator getIletisimFormuAdInput() {
        return page.locator("input[name='name'], input[placeholder*='Ad']").first();
    }

    public Locator getIletisimFormuEpostaInput() {
        return page.locator("input[name='email'], input[placeholder*='E-posta']").first();
    }

    public Locator getIletisimFormuMesajInput() {
        return page.locator("textarea, input[placeholder*='Mesaj']").first();
    }

    public Locator getFiyatlandirmayiGoruntuleButton() {
        return page.locator("button:has-text('Fiyatlandırmayı Görüntüle'), a:has-text('Fiyatlandırma')").first();
    }

    public Locator getZorunluAlanHataUyarilari() {
        return page.locator("text=zorunlu, text=doldurulması gerektiğine").first();
    }
}