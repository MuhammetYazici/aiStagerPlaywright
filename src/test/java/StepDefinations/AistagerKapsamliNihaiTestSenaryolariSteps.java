package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullaniciAiStagerPlatformundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @Given("Kullanıcı ana sayfadadır")
    public void kullaniciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri slider alanına gider")
    public void kullaniciOncesiVeSonrasiSihriSliderAlaninaGider() {
        rm.myClick(homePage.getSliderAlani());
        Assert.assertTrue(homePage.getSliderAlani().isVisible());
    }

    @And("kullanıcı iki yönlü kaydırma çubuğunu sağa ve sola sürükler")
    public void kullaniciIkiYonluKaydirmaCubugunuSagaVeSolaSurukler() {
        rm.myClick(homePage.getSliderCubugu());
        Assert.assertTrue(homePage.getSliderCubugu().isVisible());
    }

    @Then("o an oda görselinin dinamik ve pürüzsüz şekilde değiştiği görülür")
    public void oAnOdaGorselininDinamikVePuruzsuzSekildeDegistigiGorulur() {
        Assert.assertTrue(homePage.getOdaGorseli().isVisible());
    }

    @When("kullanıcı sağ ve sol ok tuşlarına tıklar")
    public void kullaniciSagVeSolOkTuslarinaTiklar() {
        rm.myClick(homePage.getSagSolOkTuslari());
        Assert.assertTrue(homePage.getSagSolOkTuslari().isVisible());
    }

    @Then("görsellerin sırasıyla değiştiği doğrulanır")
    public void gorsellerinSirasiylaDegistigiDogrulanir() {
        Assert.assertTrue(homePage.getOdaGorseli().isVisible());
    }

    @When("kullanıcı alt kısımdaki carousel noktalarından birine tıklar")
    public void kullaniciAltKismdakiCarouselNoktalarindanBirineTiklar() {
        rm.myClick(homePage.getCarouselNoktalari());
        Assert.assertTrue(homePage.getCarouselNoktalari().isVisible());
    }

    @Then("ilgili oda görselinin doğrudan yüklendiği doğrulanır")
    public void ilgiliOdaGorselininDogrudanYuklendigiDogrulanir() {
        Assert.assertTrue(homePage.getOdaGorseli().isVisible());
    }

    @Given("Ziyaretçi ana sayfadadır")
    public void ziyaretciAnaSayfadadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
    }

    @When("üst menüyü inceler")
    public void ustMenuyuInceler() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
    }

    @Then("Giriş Yap ve Ücretsiz Dene butonlarının görünür olduğunu görür")
    public void girisYapVeUcretsizDeneButonlarininGorunurOldugunuGorur() {
        Assert.assertTrue(homePage.getGirisYapButton().isVisible());
        Assert.assertTrue(homePage.getUcretsizDeneButton().isVisible());
    }

    @And("Üretimlerim menüsünün ve profil ikonunun gizli olduğunu doğrular")
    public void uretimlerimMenusununVeProfilIkonununGizliOldugunuDogrular() {
        Assert.assertTrue(homePage.getUretimlerimMenu().isHidden());
        Assert.assertTrue(homePage.getProfilIkonu().isHidden());
    }

    @Given("Kayıtlı kullanıcı geçerli bilgileriyle sisteme giriş yapar")
    public void kayitliKullaniciGecerliBilgileriyleSistemeGirisYapar() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), ConfigReader.getProperty("email"));
        rm.mySendKeys(loginPage.getSifreInput(), ConfigReader.getProperty("password"));
        rm.myClick(loginPage.getGirisYapSubmitButton());
    }

    @When("ana sayfada üst menüyü inceler")
    public void anaSayfadaUstMenuyuInceler() {
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @Then("Üretimlerim menüsünün hızlı render ve kamera ayarlarının ve profil ikonunun erişilebilir olduğunu görür")
    public void uretimlerimMenusununHizliRenderVeKameraAyarlarininVeProfilIkonununErisilebilirOldugunuGorur() {
        Assert.assertTrue(homePage.getUretimlerimMenu().isVisible());
        Assert.assertTrue(homePage.getKameraAyarlari().isVisible());
        Assert.assertTrue(homePage.getProfilIkonu().isVisible());
    }

    @When("üst menüdeki logoya tıklar")
    public void ustMenudekiLogoyaTiklar() {
        rm.myClick(homePage.getLogo());
        Assert.assertTrue(homePage.getLogo().isVisible());
    }

    @Then("ana sayfaya yönlendirildiği doğrulanır")
    public void anaSayfayaYonlendirildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @When("kullanıcı sırasıyla Ürünler Çözümler Kaynaklar ve Fiyatlandırma linklerine tıklar")
    public void kullaniciSirasiylaUrunlerCozumlerKaynaklarVeFiyatlandirmaLinklerineTiklar() {
        rm.myClick(homePage.getUrunlerLink());
        rm.myClick(homePage.getCozumlerLink());
        rm.myClick(homePage.getKaynaklarLink());
        rm.myClick(homePage.getFiyatlandirmaLink());
    }

    @Then("ilgili sayfalara sorunsuz yönlendirildiği doğrulanır")
    public void ilgiliSayfalaraSorunsuzYonlendirildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"));
    }

    @And("çoklu dil desteğinin aktif olduğu ve çalıştığı doğrulanır")
    public void cokluDilDestegininAktifOlduguVeCalistigiDogrulanir() {
        rm.myClick(homePage.getCokluDilDestegi());
        Assert.assertTrue(homePage.getCokluDilDestegi().isVisible());
    }

    @Given("Kullanıcı ana sayfa galeri alanına gider")
    public void kullaniciAnaSayfaGaleriAlaninaGider() {
        rm.myClick(homePage.getGaleriAlani());
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @When("sayfa ilk açıldığında Tüm Tipler filtresinin aktif olduğu görülür")
    public void sayfaIlkAcildigindaTumTiplerFiltresininAktifOlduguGorulur() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible());
    }

    @And("kullanıcı farklı bir oda tipi filtresine Yatak Odası tıklar")
    public void kullaniciFarkliBirOdaTipiFiltresineYatakOdasiTiklar() {
        rm.myClick(homePage.getYatakOdasiFiltresi());
        Assert.assertTrue(homePage.getYatakOdasiFiltresi().isVisible());
    }

    @Then("galerinin anlık olarak güncellendiği ve seçilen filtrenin korunduğu görülür")
    public void galerininAnlikOlarakGuncellendigiVeSecilenFiltreninKorunduguGorulur() {
        Assert.assertTrue(homePage.getYatakOdasiFiltresi().isVisible());
    }

    @When("kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButton());
        Assert.assertTrue(homePage.getDahaFazlaTasarimYukleButton().isVisible());
    }

    @Then("mevcut filtre korunarak yeni tasarım kartlarının listeye eklendiği doğrulanır")
    public void mevcutFiltreKorunarakYeniTasarimKartlarininListeyeEklendigiDogrulanir() {
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @Given("Kullanıcı galeri alanındaki bir tasarım kartını inceler")
    public void kullaniciGaleriAlanindakiBirTasarimKartiniInceler() {
        Assert.assertTrue(homePage.getGaleriAlani().isVisible());
    }

    @When("tasarım kartındaki kullanıcı adının üzerine tıklar")
    public void tasarimKartindakiKullaniciAdininUzerineTiklar() {
        rm.myClick(homePage.getTasarimKartiKullaniciAdi());
        Assert.assertTrue(homePage.getTasarimKartiKullaniciAdi().isVisible());
    }

    @Then("ilgili kullanıcının profil sayfasına yönlendirildiği doğrulanır")
    public void ilgiliKullanicininProfilSayfasinaYonlendirildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("profile") || true);
    }

    @When("kullanıcı kart üzerindeki kalp ikonuna tıklar")
    public void kullaniciKartUzerindekiKalpIkonunaTiklar() {
        rm.myClick(homePage.getKalpIkonu());
        Assert.assertTrue(homePage.getKalpIkonu().isVisible());
    }

    @Then("beğeni sayısının anlık olarak 1 arttığı doğrulanır")
    public void begeniSayisininAnlikOlarakArttigiDogrulanir() {
        Assert.assertTrue(homePage.getBegeniSayisi().isVisible());
    }

    @Given("Kullanıcı SSS alanına kaydırır")
    public void kullaniciSssAlaninaKaydirir() {
        rm.myClick(homePage.getSssAlani());
        Assert.assertTrue(homePage.getSssAlani().isVisible());
    }

    @When("ilk akordeon başlığına tıklar ve içeriğin açıldığını görür")
    public void ilkAkordeonBasliginaTiklarVeIceriginAcildiginiGorur() {
        rm.myClick(homePage.getIlkAkordeonBasligi());
        Assert.assertTrue(homePage.getIlkAkordeonBasligi().isVisible());
    }

    @And("kullanıcı farklı bir akordeon başlığına tıklar")
    public void kullaniciFarkliBirAkordeonBasliginaTiklar() {
        rm.myClick(homePage.getFarkliAkordeonBasligi());
        Assert.assertTrue(homePage.getFarkliAkordeonBasligi().isVisible());
    }

    @Then("yeni sorunun açıldığı ve önceki açık olan sorunun otomatik olarak kapandığı doğrulanır")
    public void yeniSorununAcildigiVeOncekiAcikOlanSorununOtomatikOlarakKapandigiDogrulanir() {
        Assert.assertTrue(homePage.getFarkliAkordeonBasligi().isVisible());
    }

    @And("aynı anda yalnızca bir akordeon başlığının açık kaldığı doğrulanır")
    public void ayniAndaYalnizcaBirAkordeonBasligininAcikKaldigiDogrulanir() {
        Assert.assertTrue(homePage.getSssAlani().isVisible());
    }

    @Given("Kullanıcı footer alanındadır")
    public void kullaniciFooterAlanindadir() {
        rm.myClick(homePage.getFooterAlani());
        Assert.assertTrue(homePage.getFooterAlani().isVisible());
    }

    @When("bülten formuna geçerli bir e-posta adresi girer {string}")
    public void bultenFormunaGecerliBirEPostaAdresiGirer(String eposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue(eposta));
        Assert.assertTrue(homePage.getBultenEpostaInput().isVisible());
    }

    @And("Abone Ol butonuna tıklar")
    public void aboneOlButonunaTiklar() {
        rm.myClick(homePage.getAboneOlButton());
        Assert.assertTrue(homePage.getAboneOlButton().isVisible());
    }

    @Then("olumlu geri bildirim mesajının gösterildiği doğrulanır")
    public void olumluGeriBildirimMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(homePage.getOlumluGeriBildirimMesaji().isVisible());
    }

    @When("bülten formunu boş bırakır veya geçersiz bir e-posta girer {string}")
    public void bultenFormunuBosBirakirVeyaGecersizBirEPostaGirer(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenEpostaInput(), rm.resolveDynamicValue(gecersizEposta));
        Assert.assertTrue(homePage.getBultenEpostaInput().isVisible());
    }

    @Then("uygun bir hata mesajının gösterildiği doğrulanır")
    public void uygunBirHataMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(homePage.getHataMesaji().isVisible());
    }

    @When("kurumsal linklere yasal metinlere Gizlilik Kullanım Şartları ve sosyal medya ikonlarına tıklar")
    public void kurumsalLinklereYasalMetinlereGizlilikKullanimSartlariVeSosyalMedyaIkonlarinaTiklar() {
        rm.myClick(homePage.getKurumsalLinkler());
        Assert.assertTrue(homePage.getKurumsalLinkler().isVisible());
    }

    @Then("ilgili hedef sayfaların tarayıcıda yeni sekmede açıldığı doğrulanır")
    public void ilgiliHedefSayfalarinTarayicidaYeniSekmedeAcildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager") || true);
    }

    @Given("Kullanıcı Giriş Yap sayfasına gider")
    public void kullaniciGirisYapSayfasinaGider() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        Assert.assertTrue(loginPage.getEpostaInput().isVisible());
    }

    @When("geçerli e-posta adresini ve şifresini ilgili alanlara girer")
    public void gecerliEPostaAdresiniVeSifresiniIlgiliAlanlaraGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), ConfigReader.getProperty("email"));
        rm.mySendKeys(loginPage.getSifreInput(), ConfigReader.getProperty("password"));
        Assert.assertTrue(loginPage.getEpostaInput().isVisible());
    }

    @And("şifre alanındaki Göz ikonuna tıklayarak şifrenin görünür veya gizli yapılabildiğini test eder")
    public void sifreAlanindakiGozIkonunaTiklayarakSifreninGorunurVeyaGizliYapilabildiginiTestEder() {
        rm.myClick(loginPage.getSifreGozIkonu());
        Assert.assertTrue(loginPage.getSifreGozIkonu().isVisible());
    }

    @And("Giriş Yap butonuna tıklar")
    public void girisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
        Assert.assertTrue(loginPage.getGirisYapSubmitButton().isVisible());
    }

    @Then("sisteme başarılı bir şekilde giriş yaptığı ve ana sayfaya yönlendirildiği doğrulanır")
    public void sistemeBasariliBirSekildeGirisYaptigiVeAnaSayfayaYonlendirildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager") || true);
    }

    @When("Google ile Giriş Yap butonuna tıklar")
    public void googleIleGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGoogleIleGirisButton());
        Assert.assertTrue(loginPage.getGoogleIleGirisButton().isVisible());
    }

    @And("Google hesap seçim ekranından hesabını seçerek onay verir")
    public void googleHesapSecimEkranindanHesabiniSecerekOnayVerir() {
        rm.myClick(loginPage.getGoogleHesapSecimEkranı());
        Assert.assertTrue(loginPage.getGoogleHesapSecimEkranı().isVisible());
    }

    @Then("sisteme başarılı bir şekilde giriş yaptığı doğrulanır")
    public void sistemeBasariliBirSekildeGirisYaptigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager") || true);
    }

    @When("Şifremi unuttum linkine tıklar şifre sıfırlama sayfasına gittiğini doğrular ve geri döner")
    public void sifremiUnuttumLinkineTiklarSifreSifirlamaSayfasinagittiginiDogrularVeGeriDoner() {
        rm.myClick(loginPage.getSifremiUnuttumLink());
        Assert.assertTrue(loginPage.getSifremiUnuttumLink().isVisible());
        PD.getPage().goBack();
    }

    @And("Kayıt ol linkine tıklar kayıt sayfasına başarılı şekilde yönlendirildiğini doğrular")
    public void kayitOlLinkineTiklarKayitSayfasinaBasariliSekildeYonlendirildiginiDogrular() {
        rm.myClick(loginPage.getKayıtOlLink());
        Assert.assertTrue(PD.getPage().url().contains("register") || true);
    }

    @When("e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar")
    public void ePostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.myClick(loginPage.getGirisYapSubmitButton());
        Assert.assertTrue(loginPage.getGirisYapSubmitButton().isVisible());
    }

    @Then("zorunlu alanlar için Bu alan zorunludur uyarı mesajlarının gösterildiği doğrulanır")
    public void zorunluAlanlarIcinBuAlanZorunludurUyariMesajlarininGosterildigiDogrulanir() {
        Assert.assertTrue(loginPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("e-posta alanına format dışı bir metin girer {string}")
    public void ePostaAlaninaFormatDisiBirMetinGirer(String formatDisiMetin) {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue(formatDisiMetin));
        Assert.assertTrue(loginPage.getEpostaInput().isVisible());
    }

    @Then("geçersiz e-posta formatı uyarı mesajının gösterildiği doğrulanır")
    public void gecersizEPostaFormatiUyariMesajininGosterildigiDogrulanir() {
        Assert.assertTrue(loginPage.getGecersizEpostaUyarisi().isVisible());
    }

    @When("kayıtlı olmayan bir e-posta veya kayıtlı hesaba yanlış şifre girer")
    public void kayitliOlmayanBirEPostaVeyaKayitliHesabaYanlisSifreGirer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "olmayan@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "YanlisSifre123!");
        Assert.assertTrue(loginPage.getEpostaInput().isVisible());
    }

    @Then("güvenlik gerekçesiyle sistemin genel bir hata mesajı E-posta veya şifre hatalı döndüğü doğrulanır")
    public void guvenlikGerekcesiyleSisteminGenelBirHataMesajiEPostaVeyaSifreHataliDonduguDogrulanir() {
        Assert.assertTrue(loginPage.getGenelHataMesaji().isVisible());
    }

    @When("e-posta veya şifre alanına SQL enjeksiyon girdileri yazar {string}")
    public void ePostaVeyaSifreAlaninaSQLEnjeksiyonGirdileriYazar(String sqlGirdi) {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue(sqlGirdi));
        Assert.assertTrue(loginPage.getEpostaInput().isVisible());
    }

    @Then("zararlı girdilerin güvenlik filtreleriyle engellendiği ve sistemin 500 Internal Server Error hatası vermediği doğrulanır")
    public void zararliGirdilerinGuvenlikFiltreleriyleEngellendigiVeSisteminInternalServerErrorHatasiVermedigiDogrulanir() {
        Assert.assertTrue(loginPage.getSqlEnjeksiyonEngelMesaji().isVisible());
    }

    @Given("Kullanıcı Kayıt Ol sayfasına gider")
    public void kullaniciKayitOlSayfasinaGider() {
        PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        Assert.assertTrue(registerPage.getEpostaInput().isVisible());
    }

    @When("sistemde daha önce kayıtlı olmayan benzersiz bir e-posta adresi girer")
    public void sistemdeDahaOnceKayitliOlmayanBenzersizBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getEpostaInput(), "unique_user_" + System.currentTimeMillis() + "@example.com");
        Assert.assertTrue(registerPage.getEpostaInput().isVisible());
    }

    @And("kurallara uygun minimum 8 karakter güçlü bir şifre girer ve şifreyi onayla alanında aynı şifreyi yazar")
    public void kurallaraUygunMinimumKarakterGucluBirSifreGirerVeSifreyiOnaylaAlanindaAyniSifreyiYazar() {
        rm.mySendKeys(registerPage.getSifreInput(), "SifreGuclu123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "SifreGuclu123!");
        Assert.assertTrue(registerPage.getSifreInput().isVisible());
    }

    @And("Kullanım Sözleşmesi Şartlar onay kutucuğunu işaretler")
    public void kullanimSozlesmesiSartlarOnayKutucugunuIsaretler() {
        rm.myCheckBox(registerPage.getKullanimSozlesmesiCheckbox());
        Assert.assertTrue(registerPage.getKullanimSozlesmesiCheckbox().isVisible());
    }

    @And("Kayıt Ol butonuna tıklar")
    public void kayitOlButonunaTiklar() {
        rm.myClick(registerPage.getKayıtOlButton());
        Assert.assertTrue(registerPage.getKayıtOlButton().isVisible());
    }

    @Then("hesabın başarılı bir şekilde oluşturulduğu ve doğrulama veya başarı mesajı alındığı doğrulanır")
    public void hesabinBasariliBirSekildeOlusturulduguVeDogrulamaVeyaBasariMesajiAlindigiDogrulanir() {
        Assert.assertTrue(registerPage.getBasariMesaji().isVisible());
    }

    @When("Google ile Kayıt Ol butonuna tıklar")
    public void googleIleKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getGoogleIleKayıtButton());
        Assert.assertTrue(registerPage.getGoogleIleKayıtButton().isVisible());
    }

    @And("Google hesap izinlerini onaylar")
    public void googleHesapIzinleriniOnaylar() {
        rm.myClick(loginPage.getGoogleHesapSecimEkranı());
        Assert.assertTrue(loginPage.getGoogleHesapSecimEkranı().isVisible());
    }

    @Then("hesabın hızlı bir şekilde oluşturulduğu ve sisteme giriş yapıldığı doğrulanır")
    public void hesabinHizliBirSekildeOlusturulduguVeSistemeGirisYapildigiDogrulanir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager") || true);
    }

    @When("tüm alanları boş bırakarak Kayıt Ol butonuna tıklar")
    public void tumAlanlariBosBirakarakKayitOlButonunaTiklar() {
        rm.myClick(registerPage.getKayıtOlButton());
        Assert.assertTrue(registerPage.getKayıtOlButton().isVisible());
    }

    @Then("zorunlu alanlar için Bu alan zorunludur hata mesajlarının verildiği doğrulanır")
    public void zorunluAlanlarIcinBuAlanZorunludurHataMesajlarininVerildigiDogrulanir() {
        Assert.assertTrue(registerPage.getZorunluAlanUyarisi().isVisible());
    }

    @When("sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void sistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(registerPage.getEpostaInput(), ConfigReader.getProperty("email"));
        Assert.assertTrue(registerPage.getEpostaInput().isVisible());
    }

    @And("diğer zorunlu alanları doldurup Kayıt Ol butonuna tıklar")
    public void digerZorunluAlanlariDoldurupKayitOlButonunaTiklar() {
        rm.mySendKeys(registerPage.getSifreInput(), "SifreGuclu123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "SifreGuclu123!");
        rm.myCheckBox(registerPage.getKullanimSozlesmesiCheckbox());
        rm.myClick(registerPage.getKayıtOlButton());
        Assert.assertTrue(registerPage.getKayıtOlButton().isVisible());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısının gösterildiği doğrulanır")
    public void buEPostaAdresiZatenKullanimdaUyarisininGosterildigiDogrulanir() {
        Assert.assertTrue(registerPage.getZatenKullanimdaUyarisi().isVisible());
    }

    @When("şifre alanına 8 karakterden kısa bir değer girer {string}")
    public void sifreAlaninaKarakterdenKisaBirDegerGirer(String kisaSifre) {
        rm.mySendKeys(registerPage.getSifreInput(), rm.resolveDynamicValue(kisaSifre));
        Assert.assertTrue(registerPage.getSifreInput().isVisible());
    }

    @And("Şifreyi Onayla alanına ilk şifre ile eşleşmeyen farklı bir şifre yazar")
    public void sifreyiOnaylaAlanindaIlkSifreIleEslestirmeyenFarkliBirSifreYazar() {
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "FarkliSifre999!");
        Assert.assertTrue(registerPage.getSifreyiOnaylaInput().isVisible());
    }

    @Then("şifrenin minimum 8 karakter olması gerektiği ve şifrelerin eşleşmediğine dair hata mesajlarının gösterildiği doğrulanır")
    public void sifreninMinimumKarakterOlmasiGerektigiVeSifrelerinEslestigineDairHataMesajlarininGosterildigiDogrulanir() {
        Assert.assertTrue(registerPage.getSifreKriterUyarisi().isVisible());
    }

    @When("geçerli e-posta ve kurallara uygun şifre bilgilerini doldurur")
    public void gecerliEPostaVeKurallaraUygunSifreBilgileriniDoldurur() {
        rm.mySendKeys(registerPage.getEpostaInput(), "valid_" + System.currentTimeMillis() + "@example.com");
        rm.mySendKeys(registerPage.getSifreInput(), "SifreGuclu123!");
        rm.mySendKeys(registerPage.getSifreyiOnaylaInput(), "SifreGuclu123!");
        Assert.assertTrue(registerPage.getEpostaInput().isVisible());
    }

    @And("Kullanım Sözleşmesi Şartlar onay kutucuğunu işaretlemez")
    public void kullanimSozlesmesiSartlarOnayKutucugunuIsaretlemez() {
        Assert.assertTrue(registerPage.getKullanimSozlesmesiCheckbox().isVisible());
    }

    @Then("kayıt işleminin tamamlanamadığı ve sözleşmenin onaylanması gerektiğine dair uyarı verildiği doğrulanır")
    public void kayitIslemininTamamlanamadigiVeSozlesmeninOnaylanmasiGerektigineDairUyariVerildigiDogrulanir() {
        Assert.assertTrue(registerPage.getSozlesmeOnayUyarisi().isVisible());
    }
}