package StepDefinations;

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

public class CommonSteps {
    ReusableMethod rm = new ReusableMethod();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Given("Kullanıcı ana sayfada {string} alanındadır")
    public void kullaniciAnaSayfadaAlanindadir(String arg0) {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullaniciSistemeGirisYapmamisBirZiyaretcidir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Üst menü \\(Header) öğeleri incelenir")
    public void ustMenuHeaderOgeleriIncelenir() {
        // Kontrol adımı
    }

    @Then("{string} ve {string} butonları görünmelidir")
    arg0 arg1 butonlariGorunmelidir(String arg0, String arg1) {
    }

    @Then("Oturum gerektiren {string} linki ve profil ikonu gösterilmemelidir")
    public void oturumGerektirenLinkiveProfilIkonuGosterilmemelidir(String arg0) {
    }

    @Given("Kullanıcı topluluk tasarımları galerisindedir")
    public void kullaniciToplulukTasarimlariGalerisindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Belirli bir oda tipi filtresi seçilir")
    public void belirliBirOdaTipiFiltresiSecilir() {
    }

    @When("{string} butonuna basılır")
    public void butonunaBasilir(String arg0) {
    }

    @Then("Galeri sadece seçilen filtreye ait yeni tasarımları yüklemelidir")
    public void galeriSadeceSecilenFiltreyeAitYeniTasarimlariYuklemelidir() {
    }

    @Then("Beğeni \\(Kalp) sayısı anlık olarak güncellenmelidir")
    public void begeniKalpSayisiAnlikOlarakGuncellenmelidir() {
    }

    @Given("SSS bölümünde bir soru halihazırda açık durumdadır")
    public void sssBolumundeBirSoruHalihazirdaAcikDurumdadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Farklı bir soru başlığına tıklanır")
    public void farkliBirSoruBasliginaTiklanir() {
    }

    @Then("Önceki açık soru otomatik olarak kapanmalı ve yeni tıklanan sorunun cevabı açılmalıdır")
    public void oncekiAcikSoruOtomatikOlarakKapanmaliVeYeniTiklananSorununCevabiAcilmalidir() {
    }

    @Given("Kullanıcı footer alanındaki bülten formundadır")
    public void kullaniciFooterAlanindakiBultenFormundadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
    }

    @When("Geçerli bir e-posta adresi girilip {string} butonuna tıklanır")
    public void gecerliBirEPostaAdresiGirilipButonunaTiklanir(String arg0) {
        String email = rm.resolveDynamicValue("fakerEmail");
        rm.mySendKeys(homePage.getEmailInput(), email);
        rm.myClick(homePage.getAboneOlButton());
    }

    @Then("{string} başarı mesajı gösterilmelidir")
    public void basariMesajiGosterilmelidir(String arg0) {
        rm.veriyfyContainsText(homePage.getBasariMesaji(), arg0);
    }

    @When("{string} değeri girilip {string} butonuna tıklanır")
    public void degeriGirilipButonunaTiklanir(String email, String arg1) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(homePage.getEmailInput(), resolvedEmail);
        rm.myClick(homePage.getAboneOlButton());
    }

    @Then("Uygun bir hata mesajı gösterilmeli ve abonelik gerçekleştirilmemelidir")
    public void uygunBirHataMesajiGosterilmeliVeAbonelikGerceklestirilmemelidir() {
    }

    @Given("Kullanıcı {string} sayfasındadır ve geçerli kimlik bilgilerine sahiptir")
    public void kullaniciSayfasindadirVeGecerliKimlikBilgilerineSahiptir(String path) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + path);
    }

    @When("E-posta ve şifre alanlarına geçerli bilgiler girilip {string} butonuna tıklanır")
    public void ePostaVeSifreAlanlarinaGecerliBilgilerGirilipButonunaTiklanir(String arg0) {
        rm.mySendKeys(loginPage.getEmailInput(), "test@example.com");
        rm.mySendKeys(loginPage.getPasswordInput(), "Secret123!");
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("Sistem kullanıcıyı doğrular ve ana panele \\(dashboard) yönlendirir")
    public void sistemKullaniciyiDogrularVeAnaPaneleDashboardYonlendirir() {
    }

    @Given("Kullanıcı {string} sayfasındadır")
    public void kullaniciSayfasindadir(String path) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + path);
    }

    @When("E-posta alanına {string} ve şifre alanına {string} girilip {string} butonuna tıklanır")
    public void ePostaAlaninaVeSifreAlaninaGirilipButonunaTiklanir(String email, String password, String arg2) {
        rm.mySendKeys(loginPage.getEmailInput(), rm.resolveDynamicValue(email));
        rm.mySendKeys(loginPage.getPasswordInput(), rm.resolveDynamicValue(password));
        rm.myClick(loginPage.getGirisYapButton());
    }

    @Then("{string} veya ilgili zorunlu alan uyarı mesajı ekranda görüntülenmelidir")
    public void veyaIlgiliZorunluAlanUyariMesajiEkrandaGoruntulenmelidir(String arg0) {
    }

    @Then("Giriş işlemi engellenmelidir")
    public void girisIslemiEngellenmelidir() {
    }

    @Given("Kullanıcı {string} sayfasındadır ve sistemde kayıtlı olmayan bir e-postaya sahiptir")
    public void kullaniciSayfasindadirVeSistemdeKayitliOlmayanBirEPostayaSahiptir(String path) {
        PD.getPage().navigate(ConfigReader.getProperty("url") + path);
    }

    @When("E-posta ve kurallara uygun şifre alanları doldurulur")
    public void ePostaVeKurallaraUygunSifreAlanlariDoldurulur() {
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(registerPage.getPasswordInput(), "Secret123!");
    }

    @When("{string} sözleşme onay kutucuğu işaretlenir")
    public void sozlesmeOnayKutucuguIsaretlenir(String arg0) {
        rm.myCheckBox(registerPage.getTermsCheckbox());
    }

    @Then("Hesap başarıyla oluşturulur ve kullanıcı aktivasyon ekranına veya panoya yönlendirir")
    public void hesapBasariylaOlusturulurVeKullaniciAktivasyonEkraninaVeyaPanoyaYonlendirir() {
    }

    @When("Kayıt formuna e-posta olarak {string}, şifre olarak {string}, şifre onay olarak {string} girilir")
    public void kayitFormunaEPostaOlarakSifreOlarakSifreOnayOlarakGirilir(String email, String password, String confirmPassword) {
        rm.mySendKeys(registerPage.getEmailInput(), rm.resolveDynamicValue(email));
        rm.mySendKeys(registerPage.getPasswordInput(), rm.resolveDynamicValue(password));
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), rm.resolveDynamicValue(confirmPassword));
    }

    @When("Sözleşme kutucuğu {string} durumunda bırakılır")
    public void sozlesmeKutucuguDurumundaBirakilir(String status) {
        if (status.equals("işaretli")) {
            rm.myCheckBox(registerPage.getTermsCheckbox());
        }
    }

    @Then("İlgili hata mesajı \\({string}) gösterilerek kayıt engellenmelidir")
    public void ilgiliHataMesajiGosterilerekKayitEngellenmelidir(String expectedError) {
    }

    @Given("Sistemde halihazırda kayıtlı olan bir {string} e-posta adresi vardır")
    public void sistemdeHalihazirdaKayitliOlanBirEPostaAdresiVardir(String email) {
    }

    @When("Bu e-posta adresi, geçerli şifre ve onay kutucuğu işaretli şekilde kayıt olunmak istenir")
    public void buEPostaAdresiGecerliSifreVeOnayKutucuguIsaretliSekildeKayitOlunmakIstenir() {
        rm.mySendKeys(registerPage.getEmailInput(), "mevcut@example.com");
        rm.mySendKeys(registerPage.getPasswordInput(), "Secret123!");
        rm.myCheckBox(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getHesapOlusturButton());
    }

    @Then("{string} uyarısı dönülmeli ve yeni hesap oluşturulmamalıdır")
    public void uyarisiDonulmeliVeYeniHesapOlusturulmamalidir(String arg0) {
    }

    @When("Şifre alanındaki {string} ikonuna tıklanır")
    public void sifreAlanindakiIkonunaTiklanir(String arg0) {
    }

    @Then("Şifre maskelenmiş metinden düz metne dönüşmeli \\(veya tam tersi) olmalıdır")
    public void sifreMaskelenmisMetindenDuzMetneDonusmeliVeyaTamTersiOlmalidir() {
    }

    @When("{string} butonuna tıklanır")
    public void butonunaTiklanir(String arg0) {
        if (arg0.equals("Google ile devam et")) {
            rm.myClick(registerPage.getGoogleIleDevamEtButton());
        }
    }

    @Then("Harici OAuth kimlik doğrulama akışı başlatılmalıdır")
    public void hariciOAuthKimlikDogrulamaAkisiBaslatilmalidir() {
    }
}
===END_FILED===

===FILE:Runners/TestRunner.java===
package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinations", "Hooks"},
        tags = "@positive or @negative",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}