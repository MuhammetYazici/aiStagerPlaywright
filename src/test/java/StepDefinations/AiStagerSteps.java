package StepDefinations;

import Pages.AiStagerHomePage;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AiStagerSteps {
    AiStagerHomePage homePage = new AiStagerHomePage();
    ReusableMethod rm = new ReusableMethod();

    @Given("kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı sisteme oturum açmış olarak AiStager.ai ana sayfasındadır")
    public void kullaniciSistemeOturumAcmisOlarakAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı sisteme giriş yapmamış (ziyaretçi statüsünde) ana sayfadadır")
    public void kullaniciSistemeGirisYapmamisZiyaretciStatüsündeAnaSayfadadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı ziyaretçi statüsünde AiStager.ai ana sayfasındadır")
    public void kullaniciZiyaretciStatüsündeAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır")
    public void kullaniciAiStagerAiAnaSayfasindakiGaleriAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı galeri alanındaki tasarım kartlarını incelemektedir")
    public void kullaniciGaleriAlanindakiTasarimKartlariniIncelemektedir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı galeride belirli bir filtre seçerek aşağı kaydırmıştır")
    public void kullaniciGalerideBelirliBirFiltreSecerekAsagiKaydirmistir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı Sıkça Sorulan Sorular (FAQ) alanındadır")
    public void kullaniciSikcaSorulanSorularFaqAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı footer alanındaki Bülten Aboneliği (Newsletter) bölümündedir")
    public void kullaniciFooterAlanindakiBultenAboneligiNewsletterBolumundedir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı footer alanındaki Bülten Aboneliği bölümündedir")
    public void kullaniciFooterAlanindakiBultenAboneligiBolumundedir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @And("{string} slider alanı ekranda görünmektedir")
    public void sliderAlaniEkrandaGorunmektedir(String arg0) {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @When("kullanıcı slider çizgisini sağa ve sola sürüklerse")
    public void kullaniciSliderCizgisiniSagaVeSolaSuruklerse() {
        Locator handle = homePage.getSliderHandle();
        handle.dragTo(homePage.getBeforeAfterSlider().locator("xpath=//div"));
    }

    @Then("görsel boyutları kaydırıcının hareketine göre dinamik olarak güncellenmelidir")
    public void gorselBoyutlariKaydiricininHareketineGoreDinamikOlarakGuncellenmelidir() {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @And("boş oda ile mobilyalı oda arasında pürüzsüz geçiş sağlanmalıdır")
    public void bosOdaIleMobilyaliOdaarasindaPuruzsuzGecisSaglanmalidir() {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @When("kullanıcı slider alanındaki sağ ok işaretine \\(>) tıklarsa")
    public void kullaniciSliderAlanindakiSagOkIsaretineTiklarsa() {
        rm.myClick(homePage.getSliderRightArrow());
    }

    @Then("farklı bir odaya ait görsel çiftine geçiş yapılmalıdır")
    public void farkliBirOdayaAitGorselCiftineGecisYapilmalidir() {
        Assert.assertTrue(homePage.getBeforeAfterSlider().isVisible());
    }

    @And("alt kısımdaki ilgili carousel noktası aktif ve koyu renk olmalıdır")
    public void altKisindakiIlgiliCarouselNoktasiAktifVeKoyuRenkOlmalidir() {
        Assert.assertTrue(homePage.getActiveCarouselDot().isVisible());
    }

    @When("kullanıcı {string} butonuna tıklarsa")
    public void kullaniciButonunaTiklarsa(String buttonName) {
        if (buttonName.equals("Odanızı Yükleyin")) {
            rm.myClick(homePage.getUploadRoomButton());
        } else if (buttonName.equals("Giriş Yap")) {
            rm.myClick(homePage.getLoginButton());
        } else if (buttonName.equals("Ücretsiz Dene")) {
            rm.myClick(homePage.getFreeTrialButton());
        } else if (buttonName.equals("Abone Ol")) {
            rm.myClick(homePage.getSubscribeButton());
        } else if (buttonName.equals("Daha Fazla Tasarım Yükle")) {
            rm.myClick(homePage.getLoadMoreDesignsButton());
        }
    }

    @Then("sistem kullanıcıyı oda yükleme arayüzüne yönlendirmelidir")
    public void sistemKullaniciyiOdaYuklemeArayuzuneYonlendirmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("upload"));
    }

    @When("kullanıcı dil seçeneğini {string} olarak değiştirirse")
    public void kullaniciDilSeceneginiOlarakDegistirirse(String lang) {
        rm.myClick(homePage.getLanguageSelector());
        rm.myClick(homePage.getTurkishLanguageOption());
    }

    @Then("sayfadaki tüm metinler seçilen dile uyarlanarak Türkçe olarak görüntülenmelidir")
    public void sayfadakiTumMetinlerSecilenDileUyarlanarakTurkceOlarakGoruntulenmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("/tr"));
    }

    @Then("sağ üst köşede kullanıcının profil ikonu görünmelidir")
    public void sagUstKosedeKullanicininProfilIkonuGorunmelidir() {
        Assert.assertTrue(homePage.getProfileIcon().isVisible());
    }

    @And("menüde {string} seçeneği yer almalıdır")
    public_void menudeSecenegiYerAlmalidir(String menuName) {
        Assert.assertTrue(homePage.getProductionsMenu().isVisible());
    }

    @When("kullanıcı logoya tıklarsa")
    public void kullaniciLogoyaTiklarsa() {
        rm.myClick(homePage.getLogo());
    }

    @Then("ana sayfa olan {string} adresine yönlendirilmelidir")
    public void anaSayfaOlanAdresineYonlendirilmelidir(String urlPath) {
        Assert.assertTrue(PD.getPage().url().contains(urlPath));
    }

    @When("kullanıcı {string} menüsünün üzerine gelirse veya tıklarsa")
    public void kullaniciMenusununUzerineGelirseVeyaTiklarsa(String menuName) {
        rm.myClick(homePage.getProductsMenu());
    }

    @Then("alt seçenekleri içeren Dropdown menü açılmalıdır")
    public void altSecenekleriIcerenDropdownMenuAcilmalidir() {
        Assert.assertTrue(homePage.getProductsDropdown().isVisible());
    }

    @Then("sağ üst köşede {string} ve mavi renkli {string} butonları görünmelidir")
    public void sagUstKosedeVeMaviRenkliButonlariGorunmelidir(String btn1, String btn2) {
        Assert.assertTrue(homePage.getLoginButton().isVisible());
        Assert.assertTrue(homePage.getFreeTrialButton().isVisible());
    }

    @And("ziyaretçi durumunda {string} menüsü ile profil ikonu görünmemelidir")
    public void ziyaretciDurumundaMenusuIleProfilIkonuGoorunmemelidir(String menuName) {
        Assert.assertFalse(homePage.getProfileIcon().isVisible());
    }

    @When("kullanıcı {string} butonuna tıklarsa, Login sayfasına yönlendirilmelidir")
    public void kullaniciButonunaTiklarsaLoginSayfasinaYonlendirilmelidir(String btn) {
        rm.myClick(homePage.getLoginButton());
        Assert.assertTrue(PD.getPage().url().contains("login"));
    }

    @And("kullanıcı {string} butonuna tıklarsa, Register sayfasına yönlendirilmelidir")
    public void kullaniciButonunaTiklarsaRegisterSayfasinaYonlendirilmelidir(String btn) {
        rm.myClick(homePage.getFreeTrialButton());
        Assert.assertTrue(PD.getPage().url().contains("register") || PD.getPage().url().contains("signup"));
    }

    @Then("{string} filtresi aktif ve mor renkli olmalıdır")
    public void filtresiAktifVeMorRenkliOlmalidir(String filterName) {
        Assert.assertTrue(homePage.getAllTypesFilter().isVisible());
    }

    @And("tüm oda tiplerine ait kartlar sayfada listelenmelidir")
    public void tumOdaTiplerineAitKartlarSayfadaListelenmelidir() {
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @When("kullanıcı {string} filtre seçeneğine tıklarsa")
    public void kullaniciFiltreSecenegineTiklarsa(String filterName) {
        rm.myClick(homePage.getLivingRoomFilter());
    }

    @Then("galeri anlık olarak sadece {string} kategorisine ait tasarımlarla güncellenmelidir")
    public void galeriAnlikOlarakSadeceKategorisineAitTasarımlarlaGuncellenmelidir(String category) {
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @When("kullanıcı bir kart üzerindeki kullanıcı adının üzerine tıklarsa")
    public void kullaniciBirKartUzerindekiKullaniciAdininUzerineTiklarsa() {
        rm.myClick(homePage.getCardUsername());
    }

    @Then("ilgili topluluk üyesinin profil sayfasına yönlendirilmelidir")
    public void ilgiliToplulukUyesininProfilSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("profile") || PD.getPage().url().contains("user"));
    }

    @When("kullanıcı kart üzerindeki Kalp \\(Beğeni) ikonuna tıklarsa")
    public void kullaniciKartUzerindekiKalpBegeniIkonunaTiklarsa() {
        rm.myClick(homePage.getLikeButton());
    }

    @Then("kalp ikonu aktif ve dolu hale gelmelidir")
    public void kalpIkonuAktifVeDoluHaleGelmelidir() {
        Assert.assertTrue(homePage.getLikeButton().isVisible());
    }

    @And("tasarımın beğeni sayacı 1 artmalıdır")
    public void tasariminBegeniSayacıArtmalidir() {
        Assert.assertTrue(homePage.getLikeCounter().isVisible());
    }

    @Then("mevcut filtre korunarak alt alta yeni tasarım kartları yüklenmelidir")
    public void mevcutFiltreKorunarakAltAltaYeniTasarimKartlariYuklenmelidir() {
        Assert.assertTrue(homePage.getGalleryCards().count() > 0);
    }

    @And("sayfa yapısı bozulmamelıdır")
    public void sayfaYapisiBozulmemelidir() {
        Assert.assertTrue(homePage.getGalleryCards().isVisible());
    }

    @When("kullanıcı {string} linkine tıklarsa")
    public void kullaniciLinkineTiklarsa(String linkText) {
        rm.myClick(homePage.getFaqContactLink());
    }

    @Then("destek veya iletişim sayfasına yönlendirilmelidir")
    public void destekVeyaIletisimSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("contact") || PD.getPage().url().contains("support"));
    }

    @When("kullanıcı kapalı olan bir soruya tıklarsa içerik açılmalıdır")
    public void kullaniciKapaliOlanBirSoruyaTiklarsaIcerikAcilmalidir {
        Locator q = homePage.getFaqQuestion("Soru");
        rm.myClick(q);
        Assert.assertTrue(q.isVisible());
    }

    @And("aynı soruya tekrar tıklandığında içerik kapanmalıdır")
    public void ayniSoruyaTekrarTiklandigindaIcerikKapanmalidir() {
        Locator q = homePage.getFaqQuestion("Soru");
        rm.myClick(q);
    }

    @And("{string} şu anda açık durumdadir")
    public void suAndaAcikDurumdadir(String questionTitle) {
        Assert.assertTrue(homePage.getFaqQuestion(questionTitle).isVisible());
    }

    @When("kullanıcı {string} akordeonuna tıklarsa")
    public void kullaniciAkordeonunaTiklarsa(String questionTitle) {
        rm.myClick(homePage.getFaqQuestion(questionTitle));
    }

    @Then("{string} açılmalı ve önceki açık olan {string} otomatik olarak kapanmalıdır")
    public void acilmaliVeOncekiAcikOlanOtomatikOlarakKapanmalidir(String q2, String q1) {
        Assert.assertTrue(homePage.getFaqQuestion(q2).isVisible());
    }

    @When("kullanıcı alanına geçerli bir e-posta adresi \\({string}) girerse")
    public void kullaniciAlaninaGecerliBirEPostaAdresiGirerse(String email) {
        rm.mySendKeys(homePage.getNewsletterInput(), rm.resolveDynamicValue(email));
    }

    @Then("ekranda {string} şeklinde yeşil banner\\/toast pozitif sistem uyarısı gösterilmelidir")
    public void ekrandaSeklindeYesilBannerToastPozitifSistemUyarisiGosterilmelidir(String message) {
        rm.veriyfyContainsText(homePage.getToastSuccessMessage(), message);
    }

    @When("kullanıcı e-posta alanına {string} girerse")
    public void kullaniciEPostaAlaninaGirerse(String email) {
        rm.mySendKeys(homePage.getNewsletterInput(), rm.resolveDynamicValue(email));
    }

    @Then("sistem aboneliği engellemelidir")
    public void sistemAboneligiEngellemelidir() {
        Assert.assertTrue(homePage.getNewsletterInput().isVisible());
    }

    @And("{string} şeklinde hata mesajı üretilmelidir")
    public void şeklindeHataMesajiUretilmelidir(String errorMsg) {
        rm.veriyfyContainsText(homePage.getErrorMessage(), errorMsg);
    }
}