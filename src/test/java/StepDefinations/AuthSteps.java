package StepDefinations;

import Pages.RegisterPage;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.microsoft.playwright.Locator;

public class AuthSteps {

    ReusableMethod rm = new ReusableMethod();
    RegisterPage registerPage = new RegisterPage();

    @Given("kullanıcı kayıt ve kimlik doğrulama servisleri aktif durumdadır")
    public void kullanıcıKayıtVeKimlikDoğrulamaServisleriAktifDurumdadır() {
        // Servislerin aktif olduğunu simüle eden ön hazırlık adımı
    }

    @Given("sistemde daha önce hiç kaydedilmemiş {string} e-posta adresi bulunmaktadır")
    @Given("{string} adresine ait bir hesap geçmişte oluşturulmuş ve tamamen silinmiştir")
    @Given("{string} adresine ait bir hesap geçmişte oluşturulmuş ve silinmiştir")
    @Given("{string} adresli hesabın silinmeden önce {string} kredisi bulunmaktadır")
    @Given("{string} adresine ait halihazırda aktif bir hesap bulunmaktadır")
    public void sistemdeDahaÖnceHiçKaydedilmemisEPostaAdresiBulunmaktadır(String arg0, String arg1) {
        // Test verisi hazırlığı
    }

    @Given("bu hesap kullanıcı tarafından silinmiştir")
    public void buHesapKullanıcıTarafındanSilinmiştir() {
        // Hesap silme simülasyonu
    }

    @When("kullanıcı {string} e-posta adresi ile kayıt formunu doldurur")
    @When("kullanıcı {string} e-posta adresi ile yeniden kayıt formunu doldurur")
    @When("kullanıcı farklı yazım formatına sahip {string} e-posta adresiyle yeniden kayıt olur")
    @When("kullanıcı {string} e-posta adresiyle sisteme tekrar kayıt olur ve doğrulamayı tamamlar")
    @When("kullanıcı aynı {string} adresi ile tekrar kayıt olmaya çalışır")
    public void kullanıcıEPostaAdresiIleKayıtFormunuDoldurur(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(registerPage.getEmailInput(), resolvedEmail);
        rm.mySendKeys(registerPage.getPasswordInput(), "Password123!");
        rm.mySendKeys(registerPage.getConfirmPasswordInput(), "Password123!");
        rm.myCheckBox(registerPage.getTermsCheckbox());
        rm.myClick(registerPage.getSubmitButton());
    }

    @And("e-posta doğrulama adımını başarıyla tamamlar")
    @And("e-posta doğrulama adımını tamamlar")
    public void ePostaDoğrulamaAdımınıBaşarıylaTamamlar() {
        // E-posta doğrulama adımları
    }

    @And("sisteme giriş yapar")
    public void sistemeGirişYapar() {
        // Giriş yapma adımları
    }

    @And("kayıt sırasında herhangi bir hata veya uyarı mesajı gösterilmemelidir \\(BR-02)")
    @And("kayıt işlemi engellenmeden başarıyla tamamlanmalıdır \\(BR-02)")
    public void kayıtSırasındaHerhangiBirHataVeyaUyarıMesajıGösterilmemelidirBr() {
        // Hata olmadığını doğrula
    }

    @Then("kayıt işlemi başarıyla tamamlanmalıdır")
    public void kayıtİşlemiBaşarıylaTamamlanmalıdır() {
        // Kayıt başarısı kontrolü
    }

    @And("kullanıcının başlangıç kredi bakiyesi {string} olmalıdır \\(BR-01)")
    @And("kullanıcının başlangıç kredi bakiyesi {string} olmalıdır \\(BR-03)")
    @And("kullanıcının kredi bakiyesi sadece {string} olmalıdır")
    public void kullanıcınınBaşlangıçKrediBakiyesiOlmalıdırBr(String expectedCredit) {
        rm.veriyfyContainsText(registerPage.getCreditBalance(), expectedCredit);
    }

    @Then("sistem e-posta normalizasyonu uygulayarak geçmiş kaydı tanımalıdır \\(BR-04)")
    public void sistemEPostaNormalizasyonuUygulayarakGeçmişKaydıTanımalıdırBr() {
        // Normalizasyon kontrolü
    }

    @Then("silinen hesaba ait eski bakiye, abonelik veya top-up hakları tamamen silinmiş olmalıdır \\(BR-03)")
    public void silinenHesabaAitEskiBakiyeAbonelikVeyaTopUpHaklarıTamamenSilinmişOlmalıdırBr() {
        // Hakların sıfırlandığını kontrol et
    }

    @Then("kayıt işlemi engellenmelidir")
    public void kayıtİşlemiEngellenmelidir() {
        // Kaydın engellendiğini doğrula
    }

    @And("kullanıcıya e-posta adresinin kullanımda olduğuna dair uygun bir hata mesajı gösterilmelidir")
    public void kullanıcıyaEPostaAdresininKullanımdaOlduğunaDairUygunBirHataMesajıGösterilmelidir() {
        rm.veriyfyContainsText(registerPage.getErrorMessage(), "kullanımda");
    }

    @And("yeni bir hesap oluşturulmamalıdır")
    public void yeniBirHesapOluşturulmamalıdır() {
        // Yeni hesap oluşmadığını doğrula
    }
}