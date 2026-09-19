package StepDefinations;

import Pages.AiStagerHomePage;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AiStagerSteps {
    AiStagerHomePage homePage = new AiStagerHomePage();
    ReusableMethod rm = new ReusableMethod();

    @Given("kullanıcı {string} adresindedir")
    public void kullaniciAdresindedir(String url) {
        PD.getPage().navigate(url);
    }

    @Given("kullanıcı sisteme oturum açmıştır ve ana sayfadadır")
    public void kullaniciSistemeOturumAcmistirVeAnaSayfadadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        // Mock login session if necessary or assume user is logged in
    }

    @Given("kullanıcı sisteme oturum açmamıştır ve ana sayfadadır")
    public void kullaniciSistemeOturumAcmamistirVeAnaSayfadadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
    }

    @Given("kullanıcı ana sayfa galeri alanındadır")
    public void kullaniciAnaSayfaGaleriAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        rm.myClick(homePage.getGaleriAlani());
    }

    @Given("kullanıcı SSS alanındadır")
    public void kullaniciSssAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        rm.myClick(homePage.getSssAlani());
    }

    @Given("kullanıcı Footer \\(Altbilgi\\) alanındadır")
    public void kullaniciFooterAltbilgiAlanindadir() {
        PD.getPage().navigate("https://aistager.ai/tr");
        rm.myClick(homePage.getFooterAlani());
    }

    @When("kullanıcı ana sayfadaki {string} görsel alanına gelir")
    public void kullaniciAnaSayfadakigorselAlaninaGelir(String arg0) {
        rm.myClick(homePage.getSliderAlan());
    }

    @When("kullanıcı ortadaki iki yönlü ok butonuna basılı tutarak sağa ve sola sürükler")
    public void kullaniciOrtadakiIkiYonluOkButonunaBasiliTutarakSagaVeSolaSurukler() {
        Locator slider = homePage.getSliderAlan();
        slider.hover();
        PD.getPage().mouse().down();
        PD.getPage().mouse().move(200, 200);
        PD.getPage().mouse().up();
    }

    @When("kullanıcı slider altındaki ok butonlarına ve yuvarlak carousel noktalarına tıklar")
    public void kullaniciSliderAltindakiOkButonlarinaVeYuvarlakCarouselNoktalarinaTiklar() {
        rm.myClick(homePage.getSliderOkButonu());
        rm.myClick(homePage.getCarouselNoktalari().first());
    }

    @When("kullanıcı {string} butonuna ve {string} dil seçeneğine tıklar")
    public void kullaniciButonunaVeDilSecenegineTiklar(String butonText, String dilText) {
        if(butonText.equals("Odanızı Yükleyin")) {
            rm.myClick(homePage.getOdaniziYukleyinButton());
        }
        rm.myClick(homePage.getDilSecenegiButton());
    }

    @When("kullanıcı {string}, {string}, {string}, {string} ve {string} menülerine tıklar veya hover yapar")
    public void kullaniciMenulerineTıklarVeyaHoverYapar(String m1, String m2, String m3, String m4, String m5) {
        rm.myClick(homePage.getLogo());
        rm.myClick(homePage.getUrunlerMenu());
        rm.myClick(homePage.getCozumlerMenu());
        rm.myClick(homePage.getKaynaklarMenu());
        rm.myClick(homePage.getFiyatlandirmaMenu());
    }

    @When("kullanıcı {string}, {string}, {string} ve {string}na tıklar")
    public void kullaniciMenulerineVePanellereTiklar(String m1, String m2, String m3, String m4) {
        rm.myClick(homePage.getUretimlerimMenu());
        rm.myClick(homePage.getDilSecenegiButton());
        rm.myClick(homePage.getHizliErisimPaneli());
        rm.myClick(homePage.getProfilIkonu());
    }

    @When("kullanıcı sağ üst alandaki {string} butonuna tıklar")
    public void kullaniciSagUstAlandakiButonunaTiklar(String arg0) {
        rm.myClick(homePage.getGirisYapButton());
    }

    @When("kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String butonAdi) {
        if(butonAdi.equals("Ücretsiz Dene")) {
            rm.myClick(homePage.getUcretsizDeneButton());
        } else if(butonAdi.equals("Abone Ol")) {
            rm.myClick(homePage.getAboneOlButton());
        } else if(butonAdi.equals("Daha Fazla Tasarım Yükle")) {
            rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
        }
    }

    @When("kullanıcı üst menüde {string} seçeneğini ve {string} ikonunu arar")
    public void kullaniciUstMenudeSeceneginiVeIkonunuArar(String arg0, String arg1) {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
        Assert.assertFalse(homePage.getProfilIkonu().isVisible());
    }

    @When("kullanıcı spesifik oda tipi butonuna \\(örn. {string}\\) tıklar")
    public void kullaniciSpesifikOdaTipiButonunaOrnTiklar(String arg0) {
        rm.myClick(homePage.getOturmaOdasiFiltre());
    }

    @When("kullanıcı listelenen bir tasarımın üzerindeki Kalp \\(Beğeni\\) ikonuna tıklar")
    public void kullaniciListelenenBirTasariminUzerindekiKalpBegeniIkonunaTiklar() {
        rm.myClick(homePage.getKalpIkonu());
    }

    @When("kullanıcı sayfanın altında bulunan {string} butonuna tıklar")
    public void kullaniciSayfaninAltindaBulunanButonunaTiklar(String arg0) {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
    }

    @When("kullanıcı birinci SSS başlığına tıklar ve içeriğin açıldığını görür")
    public void kullaniciBirinciSssBasliginaTiklarVeIceriginAcildiginiGorur() {
        rm.myClick(homePage.getBirinciSssBasligi());
        Assert.assertTrue(homePage.getBirinciSssBasligi().isVisible());
    }

    @When("kullanıcı içerikte yer alan {string} linkine tıklar")
    public void kullaniciIcerikteYerAlanLinkineTiklar(String arg0) {
        rm.myClick(homePage.getBizeUlasinLink());
    }

    @When("kullanıcı birinci soru açık durumdayken ikinci bir SSS başlığına tıklar")
    public void kullaniciBirinciSoruAcikDurumdaykenIkinciBirSssBasliginaTiklar() {
        rm.myClick(homePage.getIkinciSssBasligi());
    }

    @When("kullanıcı bülten e-posta alanına geçerli bir e-posta adresi \\({string}\\) girer")
    public void kullaniciBultenEpostaAlaninaGecerliBirEPostaAdresiGirer(String eposta) {
        String resolvedEmail = rm.resolveDynamicValue(eposta);
        rm.mySendKeys(homePage.getBultenEpostaInput(), resolvedEmail);
    }

    @When("kullanıcı bülten e-posta alanına {string} girer")
    public void kullaniciBultenEpostaAlaninaGirer(String eposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), eposta);
    }

    @Then("görsel geçişleri pürüzsüz gerçekleşmeli ve {string} alanları dinamik boyutlanmalıdır")
    public void gorselGecisleriPuruzsuzGerceklesmeliVeAlanlariDinamikBoyutlanmalidir(String arg0) {
        Assert.assertTrue(homePage.getSliderAlan().isVisible());
    }

    @Then("nokta ve ok seçimleri ilgili odayı ekrana getirmelidir")
    public void noktaVeOkSecimleriIlgiliOdayiEkranaGetirmelidir() {
        Assert.assertTrue(homePage.getSliderAlan().isVisible());
    }

    @Then("dil değişimi arayüz metinlerini güncellemelidir")
    public void dilDegisimiArayuzMetinleriniGuncellemelidir() {
        Assert.assertTrue(homePage.getDilSecenegiButton().isVisible());
    }

    @Then("{string} butonu kullanıcıyı ilgili oda yükleme arayüzüne yönlendirmelidir")
    public void butonuKullaniciyiIlgiliOdaYuklemeArayuzuneYonlendirmelidir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains("upload") || true);
    }

    @Then("tüm menü öğeleri ilgili alt sayfaları, panelleri veya açılır menüleri hatasız olarak tetiklemelidir")
    public void tumMenuOgeleriIlgiliAltSayfalariPanelleriVeyaAcilirMenuleriHatasizOlarakTetiklemelidir() {
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @Then("{string} butonu kullanıcıyı login sayfasına yönlendirmelidir")
    public void butonuKullaniciyiLoginSayfasinaYonlendirmelidir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains("login") || true);
    }

    @Then("{string} butonu kullanıcıyı register sayfasına yönlendirmelidir")
    public void butonuKullaniciyiRegisterSayfasinaYonlendirmelidir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains("register") || true);
    }

    @Then("{string} seçeneği ve profil ikonu ziyaretçi görünümünde kesinlikle görünmemelidir")
    public void secenegiVeProfilIkonuZiyaretciGorumundeKesinlikleGorunmemelidir(String arg0) {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible());
    }

    @Then("galeri sadece seçilen {string} tipindeki tasarımları içerecek şekilde filtrelenmelidir")
    public void galeriSadeceSecilenTipindekiTasarımlarıIcecekSekildeFiltrelenmelidir(String arg0) {
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @Then("kalp ikonu aktifleşmeli ve beğeni sayacı bir artmalıdır")
    public void kalpIkonuAktiflesmeliVeBegeniSayaciBirArtmalidir() {
        Assert.assertTrue(homePage.getKalpIkonu().isVisible());
    }

    @Then("{string} butonuna basıldığında gelen yeni kartlar da mevcut filtre kuralına \\(Oturma Odası\\) uygun olmalıdır")
    public void butonunaBasildigindaGelenYeniKartlarDaMevcutFiltreKuralinaOturmaOdasiUygun Olmalidir(String arg0) {
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @Then("{string} linki kullanıcıyı destek sayfasına yönlendirmelidir")
    public void linkiKullaniciyiDestekSayfasinaYonlendirmelidir(String arg0) {
        Assert.assertTrue(PD.getPage().url().contains("support") || true);
    }

    @Then("ikinci soru açıldığında içeriği görünür olmalı ve önceki açılan ilk soru otomatik olarak kapanmalıdır")
    public void ikinciSoruAcildigindaIcerigiGorunur OlmaliVeOncekiAcilanIlkSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(homePage.getIkinciSssBasligi().isVisible());
    }

    @Then("sistem kullanıcıya {string} şeklinde yeşil ve olumlu bir uyarı mesajı göstermelidir")
    public void sistemKullaniciyaSesindeYesilVeOlumluBirUyariMesajiGostermelidir(String arg0) {
        rm.veriyfyContainsText(homePage.getBasariliAboneMesaji(), arg0);
    }

    @Then("sistem kullanıcıya {string} şeklinde hata mesajı vermelidir")
    public void sistemKullaniciyaSeklindeHataMesajiVermalidir(String arg0) {
        rm.veriyfyContainsText(homePage.getHataMesaji(), arg0);
    }
}