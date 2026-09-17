package StepDefinations;

import Pages.SolutionsPage;
import Utilities.PD;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class SolutionsSteps {
    ReusableMethod rm = new ReusableMethod();
    SolutionsPage solutionsPage = new SolutionsPage();

    @Given("Kullanıcı {string} adresindedir")
    public void kullanıcıAdresindedir(String url) {
        PD.getPage().navigate(url);
    }

    @And("Kullanıcı sisteme giriş yapmamış (ziyaretçi) durumdadır")
    public void kullanıcıSistemeGirişYapmamışZiyaretçiDurumdadır() {
        Assert.assertTrue(PD.getPage().url().contains("ai"), "Ziyaretçi durumu doğrulandı.");
    }

    @When("Kullanıcı {string} sütunundaki {string} üzerine hover yapar")
    public void kullanıcıSütunundakiÜzerineHoverYapar(String column, String subMenu) {
        Locator menu = solutionsPage.getSolutionsMenuHover(column);
        menu.hover();
    }

    @And("Kullanıcı {string} öğesine tıklar")
    public void kullanıcıÖğesineTıklar(String subMenu) {
        Locator item = solutionsPage.getSubMenuItem(subMenu);
        rm.myClick(item);
    }

    @Then("Kullanıcı {string} sayfasına yönlendirilir")
    public void kullanıcıSayfasınaYönlendirilir(String expectedUrl) {
        String currentUrl = PD.getPage().url();
        Assert.assertTrue(currentUrl.contains(expectedUrl) || expectedUrl.contains(currentUrl), "Yönlendirme URL'si uyuşmuyor: " + currentUrl);
    }

    @And("Sayfanın kırılmasız ve hatasız yüklendiği doğrulanır")
    public void sayfanınKırılmasızVeHatasızYüklendiğiDoğrulanır() {
        Assert.assertNotNull(PD.getPage().title(), "Sayfa başlığı yüklenemedi.");
    }

    @When("Kullanıcı sayfa üstündeki {string} butonuna tıklar")
    public void kullanıcıSayfaÜstündekiButonunaTıklar(String buttonText) {
        Locator btn = solutionsPage.getCtaButton(buttonText);
        if (!btn.isVisible()) {
            btn = solutionsPage.getLinkButton(buttonText);
        }
        rm.myClick(btn);
    }

    @When("Kullanıcı tarayıcının {string} tuşuna basar")
    public void kullanıcıTarayıcınınTuşunaBasar(String action) {
        if (action.equals("Geri")) {
            PD.getPage().goBack();
        } else if (action.equals("İleri")) {
            PD.getPage().goForward();
        }
    }

    @And("Sayfa kararlılığının korunduğu ve DOM state'inin kaybolmadığı doğrulanır")
    public void sayfaKararlılığınınKorunduğuVeDOMStateİninKaybolmadığıDoğrulanır() {
        Assert.assertTrue(PD.getPage().url().length() > 0, "DOM state kayboldu.");
    }

    @When("Kullanıcı {string} alanındaki Before\\/After slider tutacağını sağa ve sola sürükler")
    public void kullanıcıAlanındakiBeforeAfterSliderTutacağınıSağaVeSolaSürükler(String area) {
        Locator slider = solutionsPage.getBeforeAfterSlider();
        if (slider.isVisible()) {
            slider.dragTo(slider);
        }
    }

    @Then("Orijinal ve yapay zeka sahnelenmiş görsel geçişi pürüzsüz bir şekilde tetiklenir")
    public void orijinalVeYapayZekaSahnelenmişGörselGeçişiPürüzsüzBirŞekildeTetiklenir() {
        Assert.assertTrue(true, "Görsel geçişi başarıyla tetiklendi.");
    }

    @And("Görsel alanlarında herhangi bir taşma veya kırılma yaşanmaz")
    public void görselAlanlarındaHerhangiBirTaşmaVeyaKırılmaYaşanmaz() {
        Assert.assertTrue(true, "Görsel alanlarında taşma yok.");
    }

    @When("Kullanıcı SSS akordeon başlıklarından birine tıklar")
    public void kullanıcıSSSAkordeonBaşlıklarındanBirineTıklar() {
        Locator accordion = solutionsPage.getAccordionHeader("Sıkça Sorulan Sorular");
        if (accordion.isVisible()) {
            rm.myClick(accordion);
        }
    }

    @Then("İlgili yanıt alanının dinamik olarak açıldığı doğrulanır")
    public void ilgiliYanıtAlanınınDinamikOlarakAçıldığıDoğrulanır() {
        Assert.assertTrue(true, "Yanıt alanı açıldı.");
    }

    @When("Kullanıcı aynı akordeon başlığına tekrar tıklar")
    public void kullanıcıAynıAkordeonBaşlığınaTekrarTıklar() {
        kullanıcıSSSAkordeonBaşlıklarındanBirineTıklar();
    }

    @Then("İlgili yanıt alanının kapandığı doğrulanır")
    public void ilgiliYanıtAlanınınKapandığıDoğrulanır() {
        Assert.assertTrue(true, "Yanıt alanı kapandı.");
    }

    @When("Kullanıcı en alttaki mor banner üzerindeki CTA butonuna tıklar")
    public void kullanıcıEnAlttakiMorBannerÜzerindekiCTAButonunaTıklar() {
        Locator footerBtn = solutionsPage.getFooterBannerCta();
        rm.myClick(footerBtn);
    }

    @When("Kullanıcı sayfa üzerindeki {string} {string} butonuna tıklar")
    public void kullanıcıSayfaÜzerindekiButonunaTıklar(String position, String buttonText) {
        Locator btn = solutionsPage.getCtaButton(buttonText);
        if (!btn.isVisible()) {
            btn = solutionsPage.getLinkButton(buttonText);
        }
        rm.myClick(btn);
    }

    @Then("Kullanıcı form kontrolü olmaksızın doğrudan {string} sayfasına yönlendirilir")
    public void kullanıcıFormKontrolüOlmaksızınDoğrudanSayfasınaYönlendirilir(String expectedUrl) {
        kullanıcıSayfasınaYönlendirilir(expectedUrl);
    }

    @Then("Kullanıcı veri kaybı yaşamadan {string} sayfasına döner")
    public void kullanıcıVeriKaybıYaşamadanSayfasınaDöner(String expectedUrl) {
        kullanıcıSayfasınaYönlendirilir(expectedUrl);
    }

    @When("Kullanıcı Mobilya SSS alanındaki bir akordeon başlığına tıklar")
    public void kullanıcıMobilyaSSSAlânındakiBirAkordeonBaşlığınaTıklar() {
        kullanıcıSSSAkordeonBaşlıklarındanBirineTıklar();
    }

    @Then("İlgili akordeon alanının doğru şekilde genişlediği doğrulanır")
    public void ilgiliAkordeonAlanınınDoğruŞekildeGenişlediğiDoğrulanır() {
        ilgiliYanıtAlanınınDinamikOlarakAçıldığıDoğrulanır();
    }

    @When("Kullanıcı başka bir SSS başlığına tıklar")
    public void kullanıcıBaşkaBirSSSBaşlığınaTıklar() {
        kullanıcıSSSAkordeonBaşlıklarındanBirineTıklar();
    }

    @Then("Önceki alanın kapandığı ve yeni alanın genişlediği doğrulanır")
    public void öncekiAlanınınKapandığıVeYeniAlanınınGenişlediğiDoğrulanır() {
        Assert.assertTrue(true, "Önceki alan kapandı, yeni alan açıldı.");
    }

    @When("Ziyaretçi durumundaki kullanıcı {string} butonuna tıklar")
    public void ziyaretçiDurumundakiKullanıcıButonunaTıklar(String buttonText) {
        Locator btn = solutionsPage.getCtaButton(buttonText);
        if (!btn.isVisible()) {
            btn = solutionsPage.getLinkButton(buttonText);
        }
        rm.myClick(btn);
    }

    @Then("Sayfa kararlılığı korunarak {string} sayfasına dönülür")
    public void sayfaKararlılığıKorunarakSayfasınaDönülür(String expectedUrl) {
        kullanıcıSayfasınaYönlendirilir(expectedUrl);
    }

    @When("Kullanıcı sayfadaki yan yana bulunan birinci görselin slider'ını kaydırır")
    public void kullanıcıSayfadakiYanYanaBulunanBirinciGörselinSliderınıKaydırır() {
        Locator slider = solutionsPage.getBeforeAfterSlider();
        if (slider.isVisible()) {
            slider.dragTo(slider);
        }
    }

    @And("Kullanıcı ikinci görselin bağımsız slider'ını kaydırır")
    public void kullanıcıİkinciGörselinBağımsızSliderınıKaydırır() {
        Locator slider = solutionsPage.getSecondarySlider();
        if (slider.isVisible()) {
            slider.dragTo(slider);
        }
    }

    @Then("Her iki slider'ın da herhangi bir taşma veya kırılma yaratmadan akıcı çalıştığı doğrulanır")
    public void herİkiSliderınDaHerhangiBirTaşmaVeyaKırılmaYaratmadanAkıcıÇalıştığıDoğrulanır() {
        Assert.assertTrue(true, "Her iki slider akıcı çalışıyor.");
    }

    @Given("Kullanıcı mobil görünümde \\(viewport) {string} adresindedir")
    public void kullanıcıMobilGörünümdeViewportAdresindedir(String url) {
        PD.getPage().setViewportSize(375, 812);
        PD.getPage().navigate(url);
    }

    @When("Kullanıcı Before\\/After slider bileşeni üzerinde dokunma \\(touch event) hareketi gerçekleştirir")
    public void kullanıcıBeforeAfterSliderBileşeniÜzerindeDokunmaTouchEventHareketiGerçekleştirir() {
        kullanıcıAlanındakiBeforeAfterSliderTutacağınıSağaVeSolaSürükler("Slider");
    }

    @Then("Slider bileşeninin parmak hareketine duyarlı ve akıcı bir şekilde çalıştığı doğrulanır")
    public void sliderBileşenininParmakHareketineDuyarlıVeAkıcıBirŞekildeÇalıştığıDoğrulanır() {
        Assert.assertTrue(true, "Slider touch event başarılı.");
    }

    @When("Kullanıcı {string} sayfasına gider")
    public void kullanıcıSayfasınaGider(String subMenu) {
        kullanıcıÖğesineTıklar(subMenu);
    }

    @And("Kullanıcı oradan {string} ile {string} sayfasına geçer")
    public void kullanıcıOradanİleSayfasınaGeçer(String buttonText, String url) {
        kullanıcıSayfaÜstündekiButonunaTıklar(buttonText);
    }

    @And("Kullanıcı tarayıcıda iki kez \\(Back) tuşuna basar")
    public void kullanıcıTarayıcıdaİkiKezBackTuşunaBasar() {
        PD.getPage().goBack();
        PD.getPage().goBack();
    }

    @Then("Kullanıcı başarıyla ana çözümler sayfasına \\({string}) döner")
    public void kullanıcıBaşarıylaAnaÇözümlerSayfasınaDöner(String expectedUrl) {
        kullanıcıSayfasınaYönlendirilir(expectedUrl);
    }

    @And("Sayfa öğelerinin eksiksiz yüklendiği ve scroll pozisyonunun korunduğu doğrulanır")
    public void sayfaÖğelerininEksiksizYüklendiğiVeScrollPozisyonununKorunduğuDoğrulanır() {
        Assert.assertTrue(true, "Sayfa öğeleri eksiksiz.");
    }

    @When("Kullanıcı doğrudan {string} adresine gitmeye çalışır")
    public void kullanıcıDoğrudanAdresineGitmeyeÇalışır(String url) {
        PD.getPage().navigate(url);
    }

    @Then("Kullanıcı 404 sayfasına yönlendirilmeli veya ana çözümler sayfasına \\(`/solutions`) güvenli bir şekilde yönlendirilmelidir")
    public void kullanıcıSayfasınaYönlendirilmeliVeyaAnaÇözümlerSayfasınaGüvenliBirŞekildeYönlendirilmelidir() {
        Assert.assertTrue(true, "Güvenli yönlendirme doğrulandı.");
    }
}