package StepDefinations;

import Pages.AiStagerPages;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class AiStagerSteps {
    AiStagerPages pages = new AiStagerPages();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager.ai ana sayfasındadır")
    public void kullaniciAiStagerAiAnaSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı {string} kaydırıcısını \\(slider) sağa ve sola sürükler")
    public void kullaniciKaydiricisiniSliderSagaVeSolaSurukler(String sliderName) {
        // Slider test implementation using ReusableMethod if needed
    }

    @Then("{string} \\(boş oda) ve {string} \\(mobilyalı oda) görselleri dinamik ve pürüzsüz bir şekilde geçiş yapmalıdır")
    public void bosOdaVeMobilyaliOdaGorselleriDinamikVePuruzsuzBirSekildeGecisYapmalidir(String arg0, String arg1) {
        
    }

    @When("Kullanıcı carousel altındaki yön oklarına veya nokta ikonlarına tıklar")
    public void kullaniciCarouselAltindakiYonOklarinaVeyaNoktaIkonlarinaTiklar() {
        
    }

    @Then("İlgili oda görselleri yüklenmeli ve tıklanan nokta görsel olarak aktif \\(vurgulanmış) olmalıdır")
    public void ilgiliOdaGorselleriYuklenmeliVeTiklananNoktaGorselOlarakAktifVurgulanmisOlmali() {
        
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullaniciSistemeBasariliBirSekildeGirisYapmistir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı ana sayfanın üst menüsünü \\(header) inceler")
    public void kullaniciAnaSayfaninUstMenusunuHeaderInceler() {
        
    }

    @Then("Logoya tıklandığında ana sayfaya dönülebilmelidir")
    public void logoyaTiklandigindaAnaSayfayaDonulebilmelidir() {
        
    }

    @And("Açılır menüler \\(Ürünler, Çözümler vb.) kullanılabilir olmalıdır")
    public void acilirMenulerUrunlerCozumlerVbKullanilabilirOlmalidir() {
        
    }

    @And("{string} sayfası ve profil ikonu menüde görünür ve erişilebilir olmalıdır")
    public void sayfasiVeProfilIkonuMenudeGorunurVeErisilebilirOlmalidir(String arg0) {
        
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("{string} menüsü ve profil ikonu gizli olmalıdır")
    public void menusuVeProfilIkonuGizliOlmalidir(String arg0) {
        
    }

    @And("{string} ve {string} butonları aktif ve görünür olmalıdır")
    public void veButonlariAktifVeGorunurOlmalidir(String arg0, String arg1) {
        
    }

    @Given("Kullanıcı AiStager.ai ana sayfasındaki Topluluk Galerisi alanındadır")
    public void kullaniciAiStagerAiAnaSayfasindakiToplulukGalerisiAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Then("Galeri varsayılan olarak {string} filtresi ile başlamalıdır")
    public void galeriVarsayilanOlarakFiltresiIleBaslamalidir(String arg0) {
        
    }

    @Given("Kullanıcı Topluluk Galerisi alanındadır")
    public void kullaniciToplulukGalerisiAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı farklı bir oda tipi filtresine tıklar")
    public void kullaniciFarkliBirOdaTipiFiltresineTiklar() {
        
    }

    @Then("Galeri anlık olarak filtrelenmeli ve sadece ilgili tasarımları göstermelidir")
    public void galeriAnlikOlarakFiltrelenmeliVeSadeceIlgiliTasarimlariGostermelidir() {
        
    }

    @When("Kullanıcı bir tasarımın kalp ikonuna tıklar")
    public void kullaniciBirTasariminKalpIkonunaTiklar() {
        
    }

    @Then("Beğeni sayısı \\(kalp sayacı) bir artmalıdır")
    public void begeniSayisiKalpSayaciBirArtmalidir() {
        
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciButonunaTiklar(String arg0) {
        
    }

    @Then("Mevcut filtre bozulmadan yeni içerikler listeye eklenmelidir")
    public void mevcutFiltreBozulmadanYeniIceriklerListeyeEklenmelidir() {
        
    }

    @Given("Kullanıcı ana sayfadaki Sıkça Sorulan Sorular \\(SSS) bölümündedir")
    public void kullaniciAnaSayfadakiSikcaSorulanSorularSssBolumundedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı bir akordeon başlığına tıklayarak soruyu açar")
    public void kullaniciBirAkordeonBasliginaTiklayarakSoruyuAcar() {
        
    }

    @And("Kullanıcı farklı bir soru başlığına tıklar")
    public void kullaniciFarkliBirSoruBasliginaTiklar() {
        
    }

    @Then("Yeni tıklanan soru açılmalı ve önceden açık olan soru otomatik olarak kapanmalıdır")
    public void yeniTiklananSoruAcilmaliVeOncedenAcikOlanSoruOtomatikOlarakKapanmalidir() {
        
    }

    @Given("Kullanıcı bülten aboneliği alanındadır")
    public void kullaniciBultenAboneligiAlanindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı bülten input alanına geçerli bir e-posta adresi girer ve abone ol butonuna tıklar")
    public void kullaniciBultenInputAlaninaGecerliBirEPostaAdresiGirerVeAboneOlButonunaTiklar() {
        
    }

    @Then("Başarılı abonelik mesajı görüntülenmelidir")
    public void basariliAbonelikMesajiGoruntulenmelidir() {
        
    }

    @When("Kullanıcı bülten input alanına {string} girer ve abone ol butonuna tıklar")
    public void kullaniciBultenInputAlaninaGirerVeAboneOlButonunaTiklar(String email) {
        
    }

    @Then("Sistem hata mesajı üretmelidir")
    public void sistemHataMesajiUretmelidir() {
        
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String pageName) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı kayıtlı geçerli e-postasını ve şifresini girer")
    public void kullaniciKayitliGecerliEPostasiniVeSifresiniGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(pages.getPasswordInput(), "ValidPassword123!");
    }

    @And("Şifre alanındaki {string} ikonuna tıklar")
    public void sifreAlanindakiIkonunaTiklar(String arg0) {
        
    }

    @Then("Şifre metin olarak görünür olmalıdır")
    public void sifreMetinOlarakGorunurOlmalidir() {
        
    }

    @When("Kullanıcı tekrar {string} ikonuna tıklar")
    public void kullaniciTekrarIkonunaTiklar(String arg0) {
        
    }

    @Then("Şifre maskelenmeli \\(noktalanmalıdır)")
    public void sifreMaskelenmeliNoktalanmalidir() {
        
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar(String arg0) {
        if(arg0.equals("Giriş Yap")) {
            // click login
        }
    }

    @Then("Kullanıcı ana panele \\(dashboard) yönlendirilmelidir")
    public void kullaniciAnaPaneleDashboardYonlendirilmelidir() {
        
    }

    @Then("{string}, {string} ve {string} yönlendirmeleri aktif ve tıklanabilir olmalıdır")
    public void yonlendirmeleriAktifVeTiklanabilirOlmalidir(String arg0, String arg1, String arg2) {
        
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak {string} butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakButonunaTiklar(String arg0) {
        
    }

    @Then("İlgili alanların altında {string} uyarı mesajı görünmelidir")
    public void ilgiliAlanlarinAltindaUyariMesajiGorunmelidir(String arg0) {
        
    }

    @When("Kullanıcı e-posta alanına hatalı formatta {string} girer")
    public void kullaniciEPostaAlaninaHataliFormattaGirer(String arg0) {
        rm.mySendKeys(pages.getEmailInput(), arg0);
    }

    @Then("{string} uyarı mesajı alınmalıdır")
    public void uyariMesajiAlinmalidir(String arg0) {
        
    }

    @When("Kullanıcı {string} ve {string} ile giriş yapmaya çalışır")
    public void kullaniciVeIleGirisYapmayaCalisir(String email, String password) {
        rm.mySendKeys(pages.getEmailInput(), email);
        rm.mySendKeys(pages.getPasswordInput(), password);
    }

    @Then("Kullanıcıya güvenlik gereği spesifik bir açık verilmeden genel {string} mesajı gösterilmelidir")
    public void kullaniciyaGuvenlikGeregiSpesifikBirAcikVerilmedenGenelMesajiGosterilmelidir(String arg0) {
        
    }

    @When("Kullanıcı e-posta alanına {string} veya aşırı uzun karakter dizisi girer")
    public void kullaniciEPostaAlaninaVeyaAsiriUzunKarakterDizisiGirer(String arg0) {
        rm.mySendKeys(pages.getEmailInput(), arg0);
    }

    @And("Şifre alanına güvenlik test verisi girip giriş yapmaya çalışır")
    public void sifreAlaninaGuvenlikTestVerisiGiripGirisYapmayaCalisir() {
        rm.mySendKeys(pages.getPasswordInput(), "Test12345!");
    }

    @Then("Sistem girdileri filtrelemeli ve uygulama 500 \\(Server Error) hatası vermemelidir")
    public void sistemGirdileriFiltrelemeliVeUygulamaServerErrorHatasiVermemelidir() {
        
    }

    @When("Kullanıcı sistemde kayıtlı olmayan yeni bir e-posta adresi girer")
    public void kullaniciSistemdeKayitliOlmayanYeniBirEPostaAdresiGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kurallara uygun ve birbiriyle eşleşen şifreler belirler")
    public void kurallaraUygunVeBirbiriyleEslasanSifrelerBelirler() {
        rm.mySendKeys(pages.getPasswordInput(), "StrongPass123!");
        rm.mySendKeys(pages.getConfirmPasswordInput(), "StrongPass123!");
    }

    @And("Kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(pages.getTermsCheckbox());
    }

    @Then("Kayıt başarılı olmalı ve kullanıcı aktivasyon veya ana panele yönlendirilmelidir")
    public void kayitBasariliOmaliVeKullaniciAktivasyonVeyaAnaPaneleYonlendirilmelidir() {
        rm.myClick(pages.getCreateAccountButton());
    }

    @When("Kullanıcı tüm alanları boş bırakarak {string} butonuna tıklar")
    public void kullaniciTumAlanlariBosBirakarakButonunaTiklar(String arg0) {
        rm.myClick(pages.getCreateAccountButton());
    }

    @Then("Boş bırakılan alanlar için {string} uyarısı çıkmalıdır")
    public void bosBirakilanAlanlarIcinUyarisiCikmalidir(String arg0) {
        
    }

    @When("Kullanıcı e-posta alanına {string} girer")
    public void kullaniciEPostaAlaninaGirer(String arg0) {
        rm.mySendKeys(pages.getEmailInput(), arg0);
    }

    @Then("{string} hatası alınmalıdır")
    public void hatasiAlinmalidir(String arg0) {
        
    }

    @When("Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void kullaniciSistemdeHalihazirdaKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(pages.getEmailInput(), "existing@stager.ai");
    }

    @And("Diğer tüm alanları geçerli doldurup {string} butonuna tıklar")
    public void digerTumAlanlariGecerliDoldurupButonunaTiklar(String arg0) {
        rm.mySendKeys(pages.getPasswordInput(), "StrongPass123!");
        rm.mySendKeys(pages.getConfirmPasswordInput(), "StrongPass123!");
        rm.myCheckBox(pages.getTermsCheckbox());
        rm.myClick(pages.getCreateAccountButton());
    }

    @Then("{string} uyarısı verilmelidir")
    public void uyarisiVerilmelidir(String arg0) {
        
    }

    @When("Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer")
    public void kullaniciSifreAlaninaKarakterdenKisaBirSifreGirer() {
        rm.mySendKeys(pages.getPasswordInput(), "short");
    }

    @Then("Şifre uzunluk uyarısı gösterilmelidir")
    public void sifreUzunlukUyarisiGosterilmelidir() {
        
    }

    @When("Kullanıcı {string} ve {string} alanlarına birbirinden farklı değerler girer")
    public void kullaniciVeAlanlarinaBirbirindenFarkliDegerlerGirer(String arg0, String arg1) {
        rm.mySendKeys(pages.getPasswordInput(), "Password123!");
        rm.mySendKeys(pages.getConfirmPasswordInput(), "Different123!");
    }

    @Then("{string} hatası dönmelidir")
    public void hatasiDonmelidir(String arg0) {
        
    }

    @When("Kullanıcı geçerli e-posta ve şifre bilgilerini girer")
    public void kullaniciGecerliEPostaVeSifreBilgileriniGirer() {
        rm.mySendKeys(pages.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(pages.getPasswordInput(), "StrongPass123!");
    }

    @And("Kullanıcı sözleşmesi onay kutucuğunu işaretlemeden {string} butonuna tıklar")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretlemedenButonunaTiklar(String arg0) {
        rm.myClick(pages.getCreateAccountButton());
    }

    @Then("Kayıt işlemi tamamlanamamalı ve sözleşme onay uyarısı alınmalıdır")
    public void kayitIslemiTamamlanamamaliVeSozlesmeOnayUyarisiAlinmalidir() {
        
    }
}