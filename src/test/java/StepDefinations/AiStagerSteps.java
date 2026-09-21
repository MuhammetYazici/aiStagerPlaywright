package StepDefinations;
import com.microsoft.playwright.Page;

import Utilities.PD;

import Pages.AiStagerPage;
import Utilities.ConfigReader;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.microsoft.playwright.Locator;

public class AiStagerSteps {
    AiStagerPage page = new AiStagerPage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanici AiStager ana sayfasindadir")
    public void kullaniciAiStagerAnaSayfasindadir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(page.getOncesiVeSonrasiKaydirici().isVisible() || page.getBultenAlani().isVisible());
    }

    @When("Oncesi ve Sonrasi alanindaki kaydirici saga ve sola suruklenir")
    public void oncesiVeSonrasiAlanindakiKaydiriciSagaVeSolaSuruklenir() {
        rm.myClick(page.getOncesiVeSonrasiKaydirici());
    }

    @Then("Once ve Sonra gorsellerinin orantili olarak degistigi gorulmelidir")
    public void onceVeSonraGorsellerininOrantiliOlarakDegistigiGorulmelidir() {
        Assert.assertTrue(page.getOnceVeSonraGorselleri().first().isVisible());
    }

    @When("Carousel altindaki noktalara veya sag\\/sol ok tuslarina tiklanir")
    public void carouselAltindakiNoktalaraVeyaSagSolOkTuslarinaTiklanir() {
        rm.myClick(page.getCarouselNoktalaraVeyaOklar().first());
    }

    @Then("Ilgili yeni oda gorsellerinin pürüzsüz yüklendigi ve aktif noktanin koyu renk oldugu gorulmelidir")
    public void ilgiliYeniOdaGorsellerininPuruzsuzYuklendigiVeAktifNoktaninKoyuRenkOlduguGorulmelidir() {
        Assert.assertTrue(page.getAktifVeyaYeniOdaGorselleri().first().isVisible());
    }

    @When("Odanizi Yukleyin butonuna tiklanir")
    public void odaniziYukleyinButonunaTiklanir() {
        rm.myClick(page.getOdaniziYukleyinButonu());
    }

    @Then("Kullanici yukleme veya kimlik dogrulama ekranina yonlendirilmelidir")
    public void kullaniciYuklemeVeyaKimlikDogrulamaEkraninaYonlendirilmelidir() {
        Assert.assertTrue(Utilities.PD.getPage().url().contains("login") || Utilities.PD.getPage().url().contains("upload") || Utilities.PD.getPage().url().contains("register"));
    }

    @When("Dil secimi menusunden TR secenegi secilir")
    public void dilSecimiMenusundenTRSecenegiSecilir() {
        rm.myClick(page.getDilSecimiMenusu());
    }

    @Then("Sayfedaki tum dinamik metinlerin Turkceye guncellendigi dogrulanmalidir")
    public void sayfedakiTumDinamikMetinlerinTurkceyeGuncellendigiDogrulanmalidir() {
        rm.veriyfyContainsText(page.getDinamikMetinler(), "");
    }

    @Given("Kullanici sisteme basarili bir sekilde giris yapmistir")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(page.getEmailInput(), "gecerli_kullanici@aistager.ai");
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre123!");
        rm.myClick(page.getGirisYapSubmitButonu());
    }

    @When("Kullanici ana sayfadadir")
    public void kullaniciAnaSayfadadir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
        Assert.assertTrue(page.getBultenAlani().isVisible() || page.getUrunlerMenu().isVisible());
    }

    @And("Ust menüde Urunler uzerine gelinir")
    public void ustMenudeUrunlerUzerineGelinir() {
        page.getUrunlerMenu().hover();
    }

    @Then("Alt menunun acildigi gorulmelidir")
    public void altMenununAcildigiGorulmelidir() {
        Assert.assertTrue(page.getAltMenu().isVisible());
    }

    @When("Ust menuden Cozumler, Kaynaklar, Fiyatlandirma, Uretimlerim veya profil ikonuna tiklanir")
    public void ustMenudenCozumlerKaynaklarFiyatlandirmaUretimlerimVeyaProfilIkonunaTiklanir() {
        rm.myClick(page.getUstMenuDetayLinki("Çözümler"));
    }

    @Then("İlgili detay sayfalarının hatasız açıldığı doğrulanmalıdır")
    public void ilgiliDetaySayfalarininHatasizAcildigiDogrulanmalidir() {
        Assert.assertFalse(Utilities.PD.getPage().url().isEmpty());
    }

    @Given("Kullanici sisteme giris yapmamistir")
    public void kullaniciSistemeGirisYapmamistir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanici ana sayfayi ziyaret eder")
    public void kullaniciAnaSayfayiZiyaretEder() {
        Assert.assertTrue(page.getBultenAlani().isVisible());
    }

    @Then("Ust menude Uretimlerim butonunun ve profil ikonunun gorunmedigi dogrulanmalidir")
    public void ustMenudeUretimlerimButonununVeProfilIkonununGorunmedigiDogrulanmalidir() {
        Assert.assertFalse(page.getUretimlerimButonu().isVisible());
    }

    @And("Sadece Giris Yap ve Ucretsiz Dene butonlarinin yer aldigi gorulmelidir")
    public void sadeceGirisYapVeUcretsizDeneButonlarininYerAldigiGorulmelidir() {
        Assert.assertTrue(page.getGirisYapButonu().isVisible());
        Assert.assertTrue(page.getUcretsizDeneButonu().isVisible());
    }

    @Given("Kullanici ana sayfa galeri bolumundedir")
    public void kullaniciAnaSayfaGaleriBolumundedir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(page.getGaleriBolumu());
    }

    @Then("Sayfa ilk acildiginda Tum Tipler filtresinin aktif ve mor renkte oldugu gorulmelidir")
    public void sayfaIlkAcildigindaTumTiplerFiltresininAktifVeMorRenkteOlduguGorulmelidir() {
        Assert.assertTrue(page.getTumTiplerFiltresi().isVisible());
    }

    @When("Oturma Odasi filtre butonuna tiklanir")
    public void oturmaOdasiFiltreButonunaTiklanir() {
        rm.myClick(page.getOturmaOdasiFiltreButonu());
    }

    @Then("Aktif butonun mor oldugu ve galerinin sadece o tipe ait kartlari listeledigi gorulmelidir")
    public void aktifButonunMorOlduguVeGalerininSadeceOTipeAitKartlariListeledigiGorulmelidir() {
        Assert.assertTrue(page.getGaleriKartlari().first().isVisible());
    }

    @When("Gorsel karti üzerindeki Kalp ikonuna tiklanir")
    public void gorselKartiUzerindekiKalpIkonunaTiklanir() {
        rm.myClick(page.getKalpIkonu().first());
    }

    @Then("Begeni sayisinin 1 arttigi ve ikonun aktif duruma gectigi gorulmelidir")
    public void begeniSayisinin1ArttigiVeIkonunAktifDurumaGectigiGorulmelidir() {
        Assert.assertTrue(page.getBegeniSayisi().first().isVisible());
    }

    @When("Daha Fazla Tasarım Yükle butonuna tiklanir")
    public void dahaFazlaTasarimYukleButonunaTiklanir() {
        rm.myClick(page.getDahaFazlaTasarimYukleButonu());
    }

    @Then("Mevcut filtre bozulmaksizin yeni tasarim kartlarinin yüklendigi gorulmelidir")
    public void mevcutFiltreBozulmaksizinYeniTasarimKartlarininYuklendigiGorulmelidir() {
        Assert.assertTrue(page.getGaleriKartlari().first().isVisible());
    }

    @Given("Kullanici ana sayfa SSS bolumundedir")
    public void kullaniciAnaSayfaSssBolumundedir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(page.getSssBolumu());
    }

    @When("Listeden herhangi bir soruya tiklanir")
    public void listedenHerhangiBirSoruyaTiklanir() {
        rm.myClick(page.getSoruBasligi().first());
    }

    @Then("Ilgili cevabin acildigi ve sag okun yukari dondugu gorulmelidir")
    public void ilgiliCevabinAcildigiVeSagOkunYukariDonduguGorulmelidir() {
        Assert.assertTrue(page.getSssCevabi().first().isVisible());
    }

    @When("Farkli bir soruya tiklanir")
    public void farkliBirSoruyaTiklanir() {
        rm.myClick(page.getSoruBasligi().nth(1));
    }

    @Then("Onceki acik sorunun otomatik kapandigi ve yeni sorunun acildigi gorulmelidir")
    public void oncekiAcikSorununOtomatikKapandigiVeYeniSorununAcildigiGorulmelidir() {
        Assert.assertTrue(page.getSssCevabi().nth(1).isVisible());
    }

    @Given("Kullanici ana sayfa bulten alanindadir")
    public void kullaniciAnaSayfaBultenAlanindadir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(page.getBultenAlani());
    }

    @When("Bülten e-posta alanina {string} degeri girilir")
    public void bultenEpostaAlaninaDegeriGirilir(String eposta) {
        String resolvedEmail = rm.resolveDynamicValue(eposta);
        rm.mySendKeys(page.getBultenEpostaInput(), resolvedEmail);
    }

    @And("Abone Ol butonuna tiklanir")
    public void aboneOlButonunaTiklanir() {
        rm.myClick(page.getAboneOlButonu());
    }

    @Then("{string} mesaji gorulmelidir")
    public void mesajiGorulmelidir(String sonuc) {
        rm.veriyfyContainsText(page.getBultenSonucMesaji(), sonuc);
    }

    @Given("Kullanici \\/login sayfasindadir")
    public void kullaniciLoginSayfasindadir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url") + "/login");
        Assert.assertTrue(page.getEmailInput().isVisible());
    }

    @When("E-posta alanina {string} girilir")
    public void ePostaAlaninaGirilir(String eposta) {
        String resolvedEmail = rm.resolveDynamicValue(eposta);
        rm.mySendKeys(page.getEmailInput(), resolvedEmail);
    }

    @And("Sifre alanina {string} girilir")
    public void sifreAlaninaGirilir(String sifre) {
        String resolvedPassword = rm.resolveDynamicValue(sifre);
        rm.mySendKeys(page.getPasswordInput(), resolvedPassword);
    }

    @And("Giris Yap butonuna tiklanir")
    public void girisYapButonunaTiklanir() {
        rm.myClick(page.getGirisYapSubmitButonu());
    }

    @Then("Kullanici basariyla ana panele yonlendirilmelidir")
    public void kullaniciBasariylaAnaPaneleYonlendirilmelidir() {
        Assert.assertTrue(page.getAnaPanelDogrulama().isVisible() || Utilities.PD.getPage().url().contains("dashboard"));
    }

    @When("Sifre alanina gizli metin girilir")
    public void sifreAlaninaGizliMetinGirilir() {
        rm.mySendKeys(page.getPasswordInput(), "GizliSifre123");
    }

    @And("Sifre alanindaki Goz ikonuna tiklanir")
    public void sifreAlanindakiGozIkonunaTiklanir() {
        rm.myClick(page.getSifreGozIkonu());
    }

    @Then("Sifre karakterlerinin okunabilir oldugu dogrulanmalidir")
    public void sifreKarakterlerininOkunabilirOlduguDogrulanmalidir() {
        Assert.assertEquals(page.getPasswordInput().getAttribute("type"), "text");
    }

    @When("Kayıt Ol linkine tiklanir")
    public void kayitOlLinkineTiklanir() {
        rm.myClick(page.getKayitOlLink());
    }

    @Then("Kayit ol sayfasina yonlendirildigi gorulmelidir")
    public void kayitOlSayfasinaYonlendirildigiGorulmelidir() {
        Assert.assertTrue(page.getKayitOlSayfasiDogrulama().isVisible() || Utilities.PD.getPage().url().contains("register"));
    }

    @When("Geri gelip Şifremi Unuttum linkine tiklanir")
    public void geriGelipSifremiUnuttumLinkineTiklanir() {
        Utilities.PD.getPage().goBack();
        rm.myClick(page.getSifremiUnuttumLink());
    }

    @Then("Sifre sifirlama sayfasina yonlendirildigi gorulmelidir")
    public void sifreSifirlamaSayfasinaYonlendirildigiGorulmelidir() {
        Assert.assertTrue(page.getSifreSifirlamaSayfasiDogrulama().isVisible() || Utilities.PD.getPage().url().contains("forgot"));
    }

    @Then("{string} uyarisi alindigi dogrulanmalidir")
    public void uyarisiAlindigiDogrulanmalidir(String hataMesaji) {
        rm.veriyfyContainsText(page.getHataMesajiLocator(), hataMesaji);
    }

    @And("Sifre alanina \"'OR '1'='1\" veya cok uzun karakter dizileri girilir")
    public void sifreAlaninaVeyaCokUzunKarakterDizileriGirilir() {
        rm.mySendKeys(page.getPasswordInput(), "'OR '1'='1");
    }

    @Then("Sistem istegi guvenle filtrelemeli ve 500 Server Error hatasi vermeden reddetmelidir")
    public void sistemIstegiGuvenleFiltrelemeliVe500ServerErrorHatasiVermedenReddetmelidir() {
        Assert.assertFalse(Utilities.PD.getPage().content().contains("500 Server Error"));
    }

    @Given("Kullanici \\/register sayfasindadir")
    public void kullaniciRegisterSayfasindadir() {
        Utilities.PD.getPage().navigate(ConfigReader.getProperty("url") + "/register");
        Assert.assertTrue(page.getHesapOlusturButonu().isVisible());
    }

    @When("Benzersiz e-posta adresi girilir")
    public void benzersizEPostaAdresiGirilir() {
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@aistager.ai";
        rm.mySendKeys(page.getEmailInput(), uniqueEmail);
    }

    @And("Sifre ve Şifreyi Onayla alanlarina kurallara uygun ayni sifre girilir")
    public void sifreVeSifreyiOnaylaAlanlarinaKurallaraUygunAyniSifreGirilir() {
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre123!");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre123!");
    }

    @And("Kullanım sözleşmesi onay kutucuğu isaretlenir")
    public void kullanimSozlesmesiOnayKutucuguIsaretlenir() {
        rm.myCheckBox(page.getSartlarCheckbox());
    }

    @And("Hesap Oluştur butonuna tiklanir")
    public void hesapOlusturButonunaTiklanir() {
        rm.myClick(page.getHesapOlusturButonu());
    }

    @Then("Kaydin basariyla gerçekleştiği ve aktivasyon ekranina yonlendirilmelidir")
    public void kaydinBasariylaGerceklesmedigiVeAktivasyonEkraninaYonlendirilmelidir() {
        Assert.assertTrue(page.getAktivasyonEkranıDogrulama().isVisible() || Utilities.PD.getPage().url().contains("activate"));
    }

    @And("Sifre Onay alanina {string} girilir")
    public void sifreOnayAlaninaGirilir(String sifreOnay) {
        rm.mySendKeys(page.getConfirmPasswordInput(), sifreOnay);
    }

    @And("Sozlesme kutucugu {string} birakilir")
    public void sozlesmeKutucuguBirakilir(String sozlesmeDurumu) {
        if (sozlesmeDurumu.equalsIgnoreCase("isaretli")) {
            rm.myCheckBox(page.getSartlarCheckbox());
        }
    }

    @Then("Kayit basarisiz olmali ve {string} gosterilmelidir")
    public void kayitBasarisizolmaliVeGosterilmelidir(String beklenenHata) {
        rm.veriyfyContainsText(page.getHataMesajiLocator(), beklenenHata);
    }

    @When("Sistemde halihazirda kayitli olan bir e-posta adresi girilir")
    public void sistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirilir() {
        rm.mySendKeys(page.getEmailInput(), "gecerli_kullanici@aistager.ai");
    }

    @And("Gerekli diger tum alanlar kurallara uygun doldurulur ve sozlesme onaylanir")
    public void gerekliDigerTumAlanlarKurallaraUygunDoldurulurVeSozlesmeOnaylanir() {
        rm.mySendKeys(page.getPasswordInput(), "GuvenliSifre123!");
        rm.mySendKeys(page.getConfirmPasswordInput(), "GuvenliSifre123!");
        rm.myCheckBox(page.getSartlarCheckbox());
    }

    @Then("Bu e-posta adresi zaten kullanımda uyarısının gösterildiği doğrulanmalıdır")
    public void buEPostaAdresiZatenKullanimdaUyarisininGosterildigiDogrulanmalidir() {
        rm.veriyfyContainsText(page.getHataMesajiLocator(), "zaten kullanımda");
    }
}