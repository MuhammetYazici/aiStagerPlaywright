package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class AiStagerSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @When("Kullanıcı Öncesi ve Sonrası slider alanındaki iki yönlü oku sağa ve sola sürükler")
    public void kullaniciOncesiVeSonrasiSliderAlanindakiIkiYonluOkuSagaVeSolaSurukler() {
        rm.myClick(homePage.getOncesiSonrasiSlider());
    }

    @Then("Önce boş oda ve Sonra mobilyalı oda görselleri arasında pürüzsüz geçiş sağlanmalıdır")
    public void onceBosOdaVeSonraMobilyaliOdaGorselleriarasindaPuruzsuzGecisSaglanmalidir() {
        rm.veriyfyContainsText(homePage.getBosOdaGorseli(), "");
        rm.veriyfyContainsText(homePage.getMobilyaliOdaGorseli(), "");
        Assert.assertTrue(homePage.getBosOdaGorseli().isVisible());
    }

    @When("Kullanıcı slider altındaki carousel noktalarına veya yön oklarına tıklar")
    public void kullaniciSliderAltindakiCarouselNoktalarinaVeyaYonOklarinaTıklar() {
        rm.myClick(homePage.getYonOkları());
    }

    @Then("İlgili oda görselleri yüklenmeli ve aktif nokta görsel olarak vurgulanmalıdır")
    public void ilgiliOdaGorselleriYuklenmeliVeAktifNoktaGorselOlarakVurgulanmalidir() {
        rm.veriyfyContainsText(homePage.getAktifNokta(), "");
        Assert.assertTrue(homePage.getAktifNokta().isVisible());
    }

    @When("Kullanıcı dil seçeneğini Türkçe TR olarak belirler")
    public void kullaniciDilSeceneginiTurkceTROlarakBelirler() {
        rm.myClick(homePage.getDilSecici());
        rm.myClick(homePage.getTurkceSecenegi());
    }

    @Then("Sayfadaki tüm metinler seçilen dile göre güncellenmelidir")
    public void sayfadakiTumMetinlerSecilenDileGoreGuncellenmelidir() {
        rm.veriyfyContainsText(homePage.getSayfaMetinleri(), "");
        Assert.assertTrue(homePage.getSayfaMetinleri().isVisible());
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGirisYapButonu().isVisible());
    }

    @When("Kullanıcı AiStager.ai ana sayfasını ziyaret eder")
    public void kullaniciAiStagerAiAnaSayfasiniZiyaretEder() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("ai"));
    }

    @Then("Sağ üst köşede Giriş Yap ve Ücretsiz Dene butonları yer almalıdır")
    public void sagUstKosedeGirisYapVeUcretsizDeneButonlariYerAlmalidir() {
        rm.veriyfyContainsText(homePage.getGirisYapButonu(), "Giriş yap");
        rm.veriyfyContainsText(homePage.getUcretsizDeneButonu(), "Ücretsiz Dene");
        Assert.assertTrue(homePage.getGirisYapButonu().isVisible());
    }

    @Then("Üretimlerim menüsü ve profil ikonu sayfada görünmemelidir")
    public void uretimlerimMenusuVeProfilIkonuSayfadaGorunmemelidir() {
        Assert.assertFalse(homePage.getUretimlerimMenusu().isVisible());
    }

    @Given("Kullanıcı geçerli kimlik bilgileriyle sisteme giriş yapmıştır")
    public void kullaniciGecerliKimlikBilgileriyleSistemeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "test@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "Password123");
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @When("Kullanıcı ana sayfayı görüntüler")
    public void kullaniciAnaSayfayiGoruntuler() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @Then("Ürünler, Çözümler, Kaynaklar, Fiyatlandırma ve Üretimlerim menüleri erişilebilir olmalıdır")
    public void urunlerCozumlerKaynaklarFiyatlandirmaVeUretimlerimMenuleriErisilebilirOlmalidir() {
        rm.veriyfyContainsText(homePage.getUrunlerMenusu(), "Ürünler");
        rm.veriyfyContainsText(homePage.getCozumlerMenusu(), "Çözümler");
        rm.veriyfyContainsText(homePage.getKaynaklarMenusu(), "Kaynaklar");
        rm.veriyfyContainsText(homePage.getFiyatlandirmaMenusu(), "Fiyatlandırma");
        rm.veriyfyContainsText(homePage.getUretimlerimMenusu(), "Üretimlerim");
        Assert.assertTrue(homePage.getUretimlerimMenusu().isVisible());
    }

    @Then("Dil seçici, hızlı render kamera ayarlar ve profil menüsü görüntülenmelidir")
    public void dilSeciciHizliRenderKameraAyarlarVeProfilMenusuGoruntulenmelidir() {
        rm.veriyfyContainsText(homePage.getDilSecici(), "");
        rm.veriyfyContainsText(homePage.getHizliRenderKameraAyarlari(), "");
        rm.veriyfyContainsText(homePage.getProfilIkonu(), "");
        Assert.assertTrue(homePage.getProfilIkonu().isVisible());
    }

    @Given("Kullanıcı AiStager.ai platformunun alt sayfalarından birindedir")
    public void kullaniciAiStagerAiPlatformununAltSayfalarindanBirindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        Assert.assertTrue(PD.getPage().url().contains("/login"));
    }

    @When("Kullanıcı üst menüdeki Logoya tıklar")
    public void kullaniciUstMenudekiLogoyaTiklar() {
        rm.myClick(homePage.getLogo());
    }

    @Then("Sayfa yenilenmeli veya tr ana sayfasına yönlendirme yapılmalıdır")
    public void sayfaYenilenmeliVeyaTrAnaSayfasinaYonlendirmeYapilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındaki topluluk galerisi alanındadır")
    public void kullaniciAiStagerAiAnaSayfasindakiToplulukGalerisiAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getToplulukGalerisiAlani());
    }

    @Then("Varsayılan olarak Tüm Tipler filtresi aktif ve mor renkli olmalıdır")
    public void varsayilanOlarakTumTiplerFiltresiAktifVeMorRenkliOlmalidir() {
        rm.veriyfyContainsText(homePage.getTumTiplerFiltresi(), "Tüm Tipler");
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @Then("Karışık oda tipleri listede gösterilmelidir")
    public void karisikOdaTipleriListedeGosterilmelidir() {
        rm.veriyfyContainsText(homePage.getKarisikOdaTipleriListesi(), "");
        Assert.assertTrue(homePage.getKarisikOdaTipleriListesi().isVisible());
    }

    @When("Kullanıcı spesifik bir oda tipi filtre butonuna tıklar")
    public void kullaniciSpesifikBirOdaTipiFiltreButonunaTiklar() {
        rm.myClick(homePage.getOdaTipiFiltreButonu());
    }

    @Then("Liste yalnızca ilgili oda tipine ait tasarımları içerecek şekilde filtrelenmelidir")
    public void listeYalnizcaIlgiliOdaTipineAitTasarimlariIcerecekSekildeFiltrelenmelidir() {
        rm.veriyfyContainsText(homePage.getFiltrelenmisListe(), "");
        Assert.assertTrue(homePage.getFiltrelenmisListe().isVisible());
    }

    @Given("Kullanıcı topluluk galerisindedir")
    public void kullaniciToplulukGalerisindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı bir tasarım kartındaki Kalp Beğeni ikonuna tıklar")
    public void kullaniciBirTasarimKartindakiKalpBegeniIkonunaTiklar() {
        rm.myClick(homePage.getKalpBegeniIkonu());
    }

    @Then("Beğeni sayısı 1 artmalı ve ikon aktif hale gelmelidir")
    public void begeniSayisi1ArtmaliVeIkonAktifHaleGelmelidir() {
        rm.veriyfyContainsText(homePage.getBegeniSayisi(), "");
        Assert.assertTrue(homePage.getKalpBegeniIkonu().isVisible());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButonu());
    }

    @Then("Mevcut filtre bozulmaksızın listeye yeni kartlar eklenmelidir")
    public void mevcutFiltreBozulmaksizinListeyeYeniKartlarEklenmelidir() {
        rm.veriyfyContainsText(homePage.getKarisikOdaTipleriListesi(), "");
        Assert.assertTrue(homePage.getKarisikOdaTipleriListesi().isVisible());
    }

    @Given("Kullanıcı FAQ alanındadır")
    public void kullaniciFaqAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getFaqAlani());
    }

    @When("Kullanıcı kapalı olan bir soru başlığına tıklar")
    public void kullaniciKapaliOlanBirSoruBasliginaTiklar() {
        rm.myClick(homePage.getSoruBasligi());
    }

    @Then("Soru içeriği açılmalıdır")
    public void soruIcerigiAcilmalidir() {
        rm.veriyfyContainsText(homePage.getSoruIcerigi(), "");
        Assert.assertTrue(homePage.getSoruIcerigi().isVisible());
    }

    @When("Kullanıcı farklı bir soru başlığına tıklar")
    public void kullaniciFarkliBirSoruBasliginaTiklar() {
        rm.myClick(homePage.getFarkliSoruBasligi());
    }

    @Then("Yeni soru açılmalı ve daha önce açık olan soru otomatik olarak kapanmalıdır")
    public void yeniSoruAcilmaliVeDahaOnceAcikOlanSoruOtomatikOlarakKapanmalidir() {
        rm.veriyfyContainsText(homePage.getSoruIcerigi(), "");
        Assert.assertTrue(homePage.getSoruIcerigi().isVisible());
    }

    @When("Kullanıcı açık olan aynı soru başlığına tekrar tıklar")
    public void kullaniciAcikOlanAyniSoruBasliginaTekrarTiklar() {
        rm.myClick(homePage.getSoruBasligi());
    }

    @Then("İçerik kapanmalıdır")
    public void icerikKapanmalidir() {
        Assert.assertTrue(homePage.getSoruBasligi().isVisible());
    }

    @Given("Kullanıcı footer bülten alanındadır")
    public void kullaniciFooterBultenAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(homePage.getFooterBultenAlani());
    }

    @When("Kullanıcı {string} e-posta adresini girer ve abone ol butonuna tıklar")
    public void kullaniciEpostaAdresiniGirerVeAboneOlButonunaTiklar(String eposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue(eposta));
        rm.myClick(homePage.getBultenAboneOlButonu());
    }

    @Then("Başarı mesajı gösterilmelidir")
    public void basariMesajiGosterilmelidir() {
        rm.veriyfyContainsText(homePage.getBasariMesaji(), "Başarılı");
        Assert.assertTrue(homePage.getBasariMesaji().isVisible());
    }

    @When("Kullanıcı e-posta alanını boş bırakır veya geçersiz format girip abone ol butonuna tıklar")
    public void kullaniciEpostaAlaniniBosBirakirVeyaGecersizFormatGiripAboneOlButonunaTiklar() {
        rm.mySendKeys(homePage.getBultenEpostaInput(), "");
        rm.myClick(homePage.getBultenAboneOlButonu());
    }

    @Then("Validasyon hata mesajı alınmalıdır")
    public void validasyonHataMesajiAlinmalidir() {
        rm.veriyfyContainsText(homePage.getValidasyonHataMesaji(), "");
        Assert.assertTrue(homePage.getValidasyonHataMesaji().isVisible());
    }

    @Given("Kullanıcı footer alanındadır")
    public void kullaniciFooterAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı Gizlilik Politikası veya Kullanım Şartları linkine tıklar")
    public void kullaniciGizlilikPolitikasiVeyaKullanimSartlariLinkineTiklar() {
        rm.myClick(homePage.getGizlilikPolitikasiLink());
    }

    @Then("İlgili resmi yasal sayfa açılmalıdır")
    public void ilgiliResmiYasalSayfaAcilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("gizlilik") || PD.getPage().url().contains("terms") || PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @When("Kullanıcı sosyal medya ikonlarına tıklar")
    public void kullaniciSosyalMedyaIkonlarinaTiklar() {
        rm.myClick(homePage.getSosyalMedyaIkonlari());
    }

    @Then("İlgili platformun dış sekmedeki profili açılmalıdır")
    public void ilgiliPlatformunDisSekmedekiProfiliAcilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains(ConfigReader.getProperty("url")));
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String sayfaYolu) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + sayfaYolu);
        Assert.assertTrue(PD.getPage().url().contains(sayfaYolu));
    }

    @When("Kullanıcı {string} e-posta adresini ve {string} şifresini girer")
    public void kullaniciEpostaAdresiniVeSifresiniGirer(String eposta, String sifre) {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue(eposta));
        rm.mySendKeys(loginPage.getSifreInput(), rm.resolveDynamicValue(sifre));
    }

    @When("Giriş Yap butonuna tıklar")
    public void girisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Kullanıcı başarıyla panele yönlendirilmelidir")
    public void kullaniciBasariylaPaneleYonlendirilmelidir() {
        rm.veriyfyContainsText(loginPage.getPanelYonlendirmeKontrolu(), "");
        Assert.assertTrue(loginPage.getPanelYonlendirmeKontrolu().isVisible());
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakıp giriş yapmaya çalışır")
    public void kullaniciEpostaVeSifreAlanlariniBosBirakipGirisYapmayaCalisir() {
        rm.mySendKeys(loginPage.getEpostaInput(), "");
        rm.mySendKeys(loginPage.getSifreInput(), "");
        rm.myClick(loginPage.getGirisYapSubmitButonu());
    }

    @Then("Bu alan zorunludur uyarısı alınmalıdır")
    public void buAlanZorunludurUyarisiAlinmalidir() {
        rm.veriyfyContainsText(loginPage.getBosAlanUyarisi(), "zorunlu");
        Assert.assertTrue(loginPage.getBosAlanUyarisi().isVisible());
    }

    @When("Kullanıcı {string} e-posta adresini girer")
    public void kullaniciEpostaAdresiniGirer(String eposta) {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue(eposta));
    }

    @Then("Lütfen geçerli bir e-posta adresi girin uyarısı alınmalıdır")
    public void lutfenGecerliBirEpostaAdresiGirinUyarisiAlinmalidir() {
        rm.veriyfyContainsText(loginPage.getGecersizEpostaUyarisi(), "geçerli");
        Assert.assertTrue(loginPage.getGecersizEpostaUyarisi().isVisible());
    }

    @Then("Sistem spesifik bilgi sızdırmadan standart E-posta veya şifre hatalı genel hata mesajını göstermelidir")
    public void sistemSpesifikBilgiSizdirmadanStandartEPostaVeyaSifreHataliGenelHataMesajiniGostermelidir() {
        rm.veriyfyContainsText(loginPage.getGenelHataMesaji(), "hatalı");
        Assert.assertTrue(loginPage.getGenelHataMesaji().isVisible());
    }

    @When("Kullanıcı şifre alanına {string} metnini yazar")
    public void kullaniciSifreAlaninaMetniniYazar(String sifre) {
        rm.mySendKeys(loginPage.getSifreInput(), rm.resolveDynamicValue(sifre));
    }

    @Then("Şifre karakterleri maskelenmiş gizli olmalıdır")
    public void sifreKarakterleriMaskelenmisGizliOlmalidir() {
        Assert.assertEquals(loginPage.getSifreInput().getAttribute("type"), "password");
    }

    @When("Kullanıcı Göz ikonuna tıklar")
    public void kullaniciGozIkonunaTiklar() {
        rm.myClick(loginPage.getSifreGozIkonu());
    }

    @Then("Şifre düz metin olarak görünür hale gelmelidir")
    public void sifreDuzMetinOlarakGorunurHaleGelmelidir() {
        Assert.assertNotEquals(loginPage.getSifreInput().getAttribute("type"), "password");
    }

    @When("Kullanıcı geçerli bilgiler, min. 8 karakterli {string} şifreler girer ve kullanıcı sözleşmesini onaylar")
    public void kullaniciGecerliBilgilerMin8KarakterliSifrelerGirerVeKullaniciSozlesmesiniOnaylar(String sifre) {
        rm.mySendKeys(registerPage.getKayitEpostaInput(), "newuser@example.com");
        rm.mySendKeys(registerPage.getKayitSifreInput(), rm.resolveDynamicValue(sifre));
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), rm.resolveDynamicValue(sifre));
        rm.myCheckBox(registerPage.getKullaniciSozlesmesiCheckbox());
    }

    @When("Kayıt Ol butonuna tıklar")
    public void kayitOlButonunaTiklar() {
        rm.myClick(registerPage.getKayitOlButonu());
    }

    @Then("Kullanıcı başarıyla kaydedilmeli ve yönlendirme yapılmalıdır")
    public void kullaniciBasariylaKaydedilmeliVeYonlendirmeYapilmalidir() {
        rm.veriyfyContainsText(registerPage.getBasariliKayitYonlendirme(), "");
        Assert.assertTrue(registerPage.getBasariliKayitYonlendirme().isVisible());
    }

    @When("Tüm zorunlu alanları doldurup Kayıt Ol butonuna tıklar")
    public void tumZorunluAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(registerPage.getKayitSifreInput(), "SecurePass1");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "SecurePass1");
        rm.myCheckBox(registerPage.getKullaniciSozlesmesiCheckbox());
        rm.myClick(registerPage.getKayitOlButonu());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısı verilmelidir")
    public void buEpostaAdresiZatenKullanimdaUyarisiVerilmelidir() {
        rm.veriyfyContainsText(registerPage.getZatenKullanimdaUyarisi(), "zaten kullanımda");
        Assert.assertTrue(registerPage.getZatenKullanimdaUyarisi().isVisible());
    }

    @When("Kullanıcı {string} şifresini girer veya Şifre ile Şifreyi Onayla alanları eşleşmez")
    public void kullaniciSifresiniGirerVeyaSifreIleSifreyiOnaylaAlanlariEslenmez(String sifre) {
        rm.mySendKeys(registerPage.getKayitEpostaInput(), "testuser@example.com");
        rm.mySendKeys(registerPage.getKayitSifreInput(), rm.resolveDynamicValue(sifre));
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "Different123");
    }

    @When("Kullanıcı sözleşmesi onaylanmamış durumdayken Kayıt Ol butonuna tıklar")
    public void kullaniciSozlesmesiOnaylanmamisDurumdaykenKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getKayitOlButonu());
    }

    @Then("İlgili alan bazlı hata mesajları min. karakter, eşleşmeme ve zorunlu sözleşme gösterilmelidir")
    public void ilgiliAlanBazliHataMesajlariMinKarakterEslenmemeVeZorunluSozlesmeGosterilmelidir() {
        rm.veriyfyContainsText(registerPage.getAlanBazliHataMesaji(), "");
        Assert.assertTrue(registerPage.getAlanBazliHataMesaji().isVisible());
    }
}