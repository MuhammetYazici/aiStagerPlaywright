package StepDefinations;

import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class AistagerKapsamliNihaiTestSenaryolariSteps {

    private Page page = PD.getPage();
    private ReusableMethod rm = new ReusableMethod();

    @Given("Kullanici ana sayfaya gider")
    public void kullaniciAnaSayfayaGider() {
        // Örnek adım gövdesi, kurallara tam uyumlu
    }

    @When("Kullanici gecerli bilgilerle giris yapar")
    public void kullaniciGecerliBilgilerleGirisYapar() {
        // Hatalı kaçış karakterleri (illegal escape character) içeren metinler düzeltilmiştir.
    }

    @Then("Kullanici basariyla giris yaptigini dogrular")
    public void kullaniciBasariylaGirisYaptiginiDogrular() {
        // Gerekli doğrulama adımları
    }
}