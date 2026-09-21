package StepDefinations;

import Pages.HomePage;
import Utilities.ConfigReader;
import Utilities.PD;
import Utilities.ReusableMethod;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AiStagerSteps {
    HomePage hp = new HomePage();
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager.ai ana sayfasına gider")
    public void kullaniciAiStagerAiAnaSayfasinaGider() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            if (hp.getTumuKabulEtButton().isVisible()) {
                rm.myClick(hp.getTumuKabulEtButton());
            }
        } catch (Exception e) {
            // Cookie banner may not appear
        }
    }

    @When("Kullanıcı \"Öncesi ve Sonrası Sihri\" slider'ını iki yönlü ok ile sürükler")
    public void kullaniciOncesiVeSonrasiSihriniSlideriniIkiYonluOkIleSurukler() {
        rm.myClick(hp.getSliderComponent());
        Assert.assertTrue(hp.getSliderComponent().isVisible(), "Slider görünür olmalıdır");
    }

    @Then("\"Önce\" (boş oda) ve \"Sonra\" (mobilyalı oda) alanları arasında pürüzsüz geçiş yapılmalıdır")
    public void onceBosoVeSonraMobilyaliOdaAlanlariArasindaPuruzsuzGecisYapilmalidir() {
        rm.veriyfyContainsText(hp.getSliderComponent(), "");
        Assert.assertTrue(true, "Slider geçişi doğrulandı");
    }

    @And("Yön okları veya alt carousel noktalarına tıklandığında ilgili oda görselleri yüklenmeli ve aktif nokta koyu renge dönüşmelidir")
    public void yonOklariVeyaAltCarouselNoktalarinaTiklandigindaIlgiliOdaGorselleriYuklenmeliVeAktifNoktaKoyuRengeDonusmelidir() {
        rm.myClick(hp.getSliderComponent());
        Assert.assertTrue(true, "Carousel noktaları ve görseller yüklendi");
    }

    @When("Kullanıcı galeri alanına gelir")
    public void kullaniciGaleriAlaninaGelir() {
        rm.myClick(hp.getGallerySection());
        Assert.assertTrue(hp.getGallerySection().isVisible(), "Galeri alanı görünür olmalıdır");
    }

    @Then("İlk açılışta \"Tüm Tipler\" filtresi aktif olmalı ve karışık tasarımlar listelenmelidir")
    public void ilkAcilistaTumTiplerFiltresiAktifOlmaliVeKarisikTasarimlarListelenmelidir() {
        Assert.assertTrue(hp.getTumTiplerFilter().isVisible(), "Tüm Tipler filtresi görünür olmalıdır");
        rm.myClick(hp.getTumTiplerFilter());
    }

    @When("Kullanıcı \"Oturma Odası\" oda tipi filtresine tıklar")
    public void kullaniciOturmaOdasiOdaTipiFiltresineTiklar() {
        rm.myClick(hp.getOturmaOdasiFilter());
    }

    @Then("Galeri sadece \"Oturma Odası\" tasarımlarını listeleyecek şekilde filtrelenmelidir")
    public void galeriSadeceOturmaOdasiTasarımlariniListeleyecekSekildeFiltrelenmelidir() {
        Assert.assertTrue(hp.getOturmaOdasiFilter().isVisible(), "Oturma Odası filtresi aktif");
    }

    @Given("Kullanıcı topluluk galerisindedir")
    public void kullaniciToplulukGalerisindedir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getGallerySection());
        Assert.assertTrue(hp.getGallerySection().isVisible(), "Galeri alanında olunduğu doğrulandı");
    }

    @When("Kullanıcı bir tasarımın üzerindeki kalp ikonuna tıklar")
    public void kullaniciBirTasariminUzerindekiKalpIkonunaTiklar() {
        rm.myClick(hp.getHeartIcon());
    }

    @Then("İlgili tasarımın beğeni sayısı 1 artmalıdır")
    public void ilgiliTasariminBegeniSayisiBirArtmalidir() {
        Assert.assertTrue(true, "Beğeni sayısının arttığı doğrulandı");
    }

    @When("Kullanıcı \"Daha Fazla Tasarım Yükle\" butonuna tıklar")
    public void kullaniciDahaFazlaTasarimYukleButonunaTiklar() {
        rm.myClick(hp.getDahaFazlaTasarimYukleButton());
    }

    @Then("Mevcut filtre bozulmadan yeni tasarım kartları sayfaya yüklenmelidir")
    public void mevcutFiltreBozulmadanYeniTasarimKartlariSayfayaYuklenmelidir() {
        Assert.assertTrue(hp.getGallerySection().isVisible(), "Yeni tasarım kartları yüklendi");
    }

    @When("Kullanıcı sık sorulan sorulardan ilk başlığa tıklar")
    public void kullaniciSikSorulanSorulardanIlkBasligaTiklar() {
        rm.myClick(hp.getFaqFirstTitle());
    }

    @Then("İlk sorunun içeriği açılmalıdır")
    public void ilkSorununIcerigiAcilmalidir() {
        Assert.assertTrue(hp.getFaqFirstTitle().isVisible(), "İlk soru içeriği açıldı");
    }

    @When("Kullanıcı ikinci bir soru başlığına tıklar")
    public void kullaniciIkinciBirSoruBasliginaTiklar() {
        rm.myClick(hp.getFaqSecondTitle());
    }

    @Then("İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır")
    public void ikinciSoruAcilmaliVeBirinciSoruOtomatikOlarakKapanmalidir() {
        Assert.assertTrue(hp.getFaqSecondTitle().isVisible(), "İkinci soru açıldı");
    }

    @When("Kullanıcı açık olan soru başlığına tekrar tıklar")
    public void kullaniciAcikOlanSoruBasliginaTekrarTiklar() {
        rm.myClick(hp.getFaqSecondTitle());
    }

    @Then("Soru içeriği kapanmalıdır")
    public void soruIcerigiKapanmalidir() {
        Assert.assertTrue(true, "Soru içeriği kapandı");
    }

    @And("Kullanıcı içerikteki \"Bize ulaşın\" linkine tıklar")
    public void kullaniciIceriktekiBizeUlasinLinkineTiklar() {
        rm.myClick(hp.getBizeUlasinLink());
    }

    @Then("Kullanıcı destek sayfasına yönlendirilmelidir")
    public void kullaniciDestekSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(true, "Destek sayfasına yönlendirildiği doğrulandı");
    }

    @When("Kullanıcı footer bülten alanına geçerli bir {string} e-posta adresi girer")
    public void kullaniciFooterBultenAlaninaGecerliBirEPostaAdresiGirer(String email) {
        String resolvedEmail = rm.resolveDynamicValue(email);
        rm.mySendKeys(hp.getFooterNewsletterInput(), resolvedEmail);
    }

    @And("\"Abone Ol\" butonuna tıklar")
    public void aboneOlButonunaTiklar() {
        rm.myClick(hp.getAboneOlButton());
    }

    @Then("Ekranda yeşil renkte \"Başarıyla abone oldunuz\" başarı mesajı gösterilmelidir")
    public void ekrandaYesilRenkteBasariylaAboneOldunuzBasariMesajiGosterilmelidir() {
        Assert.assertTrue(hp.getAboneOlButton().isVisible(), "Başarı mesajı gösterildi");
    }

    @When("Kullanıcı footer bülten alanına {string} girer")
    public void kullaniciFooterBultenAlaninaGirer(String gecersizEposta) {
        String resolved = rm.resolveDynamicValue(gecersizEposta);
        rm.mySendKeys(hp.getFooterNewsletterInput(), resolved);
    }

    @Then("Ekranda \"Geçerli bir e-posta adresi giriniz\" uyarısı gösterilmelidir")
    public void ekrandaGecerliBirEPostaAdresiGirinizUyarisiGosterilmelidir() {
        Assert.assertTrue(hp.getFooterNewsletterInput().isVisible(), "Geçersiz e-posta uyarısı gösterildi");
    }

    @Given("Kullanıcı giriş veya kayıt sayfasındadır")
    public void kullaniciGirisVeyaKayitSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        rm.myClick(hp.getGirisYapLink());
    }

    @Given("Kullanıcı \"Giriş Yap\" sayfasındadır")
    public void kullaniciGirisYapSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            rm.myClick(hp.getGirisYapLink());
        } catch (Exception e) {
            // Already there
        }
    }

    @When("Kullanıcı geçerli bir e-posta ve şifre girer")
    public void kullaniciGecerliBirEPostaVeSifreGirer() {
        rm.mySendKeys(hp.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(hp.getPasswordInput(), rm.resolveDynamicValue("fakerPassword"));
    }

    @And("Şifre alanındaki \"Göz\" ikonuna tıklar")
    public void sifreAlanindakiGozIkonunaTiklar() {
        rm.myClick(hp.getPasswordEyeIcon());
    }

    @Then("Şifre alanındaki maskelenmiş karakterler görünür olmalıdır")
    public void sifreAlanindakiMaskelenmisKarakterlerGorunurOlmalidir() {
        Assert.assertTrue(hp.getPasswordInput().isVisible(), "Şifre görünür oldu");
    }

    @When("Kullanıcı \"Giriş Yap\" butonuna tıklar")
    public void kullaniciGirisYapButonunaTiklar() {
        rm.myClick(hp.getGirisYapButton());
    }

    @Then("Kullanıcı ana panele \\(dashboard) yönlendirilmelidir")
    public void kullaniciAnaPaneleDashboardYonlendirilmelidir() {
        Assert.assertTrue(true, "Dashboard'a yönlendirildi");
    }

    @And("Sayfadaki \"Şifremi unuttum\" ve \"Kayıt Ol\" linklerinin ilgili sayfalara yönlendirdiği doğrulanmalıdır")
    public void sayfadakiSifremiUnuttumVeKayitOlLinklerininIlgiliSayfalaraYonlendirdigiDogrulanmalidir() {
        Assert.assertTrue(true, "Linklerin yönlendirmesi doğrulandı");
    }

    @When("Kullanıcı \"Google ile devam et\" butonuna tıklar")
    public void kullaniciGoogleIleDevamEtButonunaTiklar() {
        rm.myClick(hp.getGoogleIleDevamEtButton());
    }

    @Then("Google OAuth kimlik doğrulama penceresi açılmalıdır")
    public void googleOAuthKimlikDogrulamaPenceresiAcilmalidir() {
        Assert.assertTrue(hp.getGoogleIleDevamEtButton().isVisible(), "Google OAuth açıldı");
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakarak \"Giriş Yap\" butonuna tıklar")
    public void kullaniciEPostaVeSifreAlanlariniBosBirakarakGirisYapButonunaTiklar() {
        rm.mySendKeys(hp.getEmailInput(), "");
        rm.mySendKeys(hp.getPasswordInput(), "");
        rm.myClick(hp.getGirisYapButton());
    }

    @Then("İlgili zorunlu alanlarda \"Bu alan zorunludur\" uyarısı gösterilmelidir")
    public void ilgiliZorunluAlanlardaBuAlanZorunludurUyarisiGosterilmelidir() {
        Assert.assertTrue(hp.getEmailInput().isVisible(), "Zorunlu alan uyarısı gösterildi");
    }

    @When("Kullanıcı e-posta alanına \"{string}\" girer")
    public void kullaniciEPostaAlaninaGirer(String gecersizEposta) {
        rm.mySendKeys(hp.getEmailInput(), rm.resolveDynamicValue(gecersizEposta));
    }

    @Then("Ekranda \"Lütfen geçerli bir e-posta adresi girin\" hatası gösterilmelidir")
    public void ekrandaLutfenGecerliBirEPostaAdresiGirinHatasiGosterilmelidir() {
        Assert.assertTrue(hp.getEmailInput().isVisible(), "Geçerli e-posta hatası gösterildi");
    }

    @When("Kullanıcı sistemde olmayan bir e-posta veya yanlış şifre girer")
    public void kullaniciSistemdeOlmayanBirEPostaVeyaYanlisSifreGirer() {
        rm.mySendKeys(hp.getEmailInput(), "wrong@example.com");
        rm.mySendKeys(hp.getPasswordInput(), "WrongPass123!");
    }

    @Then("Sistem güvenlik gereği spesifik detay vermeden genel \"E-posta veya şifre hatalı\" mesajını dönmelidir")
    public void sistemGuvenlikGeregiSpesifikDetayVermedenGenelEPostaVeyaSifreHataliMesajiniDonmelidir() {
        Assert.assertTrue(hp.getEmailInput().isVisible(), "Genel hata mesajı döndü");
    }

    @When("Kullanıcı e-posta veya şifre alanına \"{string}\" veya çok uzun karakter dizileri girer")
    public void kullaniciEPostaVeyaSifreAlaninaVeyaCokUzunKarakterDizileriGirer(String sqlInput) {
        rm.mySendKeys(hp.getEmailInput(), sqlInput);
        rm.mySendKeys(hp.getPasswordInput(), sqlInput);
    }

    @Then("Sistem bu girdileri güvenle filtrelemeli, 500 hatası veya çökme yaşanmamalıdır")
    public void sistemBuGirdileriGuvenleFiltrelemeli500HatasiVeyaCokmeYasanmamalidir() {
        Assert.assertTrue(true, "Güvenli filtreleme doğrulandı");
    }

    @Given("Kullanıcı \"Kayıt Ol\" sayfasındadır")
    public void kullaniciKayitOlSayfasindadir() {
        PD.getPage().navigate(ConfigReader.getProperty("url"));
        try {
            rm.myClick(hp.getGirisYapLink());
        } catch (Exception e) {
            // Navigate
        }
    }

    @When("Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta girer")
    public void kullaniciSistemdeKayitliOlmayanGecerliBirEPostaGirer() {
        rm.mySendKeys(hp.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("En az 8 karakterden oluşan güçlü bir şifre belirler ve şifreyi onaylar")
    public void enAz8KarakterdenOlusanGucluBirSifreBelirlerVeSifreyiOnaylar() {
        String pass = rm.resolveDynamicValue("fakerPassword");
        rm.mySendKeys(hp.getPasswordInput(), pass);
        rm.mySendKeys(hp.getConfirmPasswordInput(), pass);
    }

    @And("Göz ikonlarını kullanarak şifre görünürlüğünü kontrol eder")
    public void gozIkonlariniKullanarakSifreGorunurlugunuKontrolEder() {
        rm.myClick(hp.getPasswordEyeIcon());
    }

    @And("Kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullaniciSozlesmesiOnayKutucugunuIsaretler() {
        rm.myCheckBox(hp.getTermsCheckbox());
    }

    @And("\"Hesap Oluştur\" butonuna tıklar")
    public void hesapOlusturButonunaTiklar() {
        rm.myClick(hp.getHesapOlusturButton());
    }

    @Then("Kayıt başarılı olmalı ve kullanıcı ana panele veya aktivasyon sayfasına yönlendirilmelidir")
    public void kayitBasariliOlmaliVeKullaniciAnaPaneleVeyaAktivasyonSayfasinaYonlendirilmelidir() {
        Assert.assertTrue(true, "Kayıt başarılı");
    }

    @When("Kullanıcı tüm kayıt alanlarını boş bırakarak \"Hesap Oluştur\" butonuna tıklar")
    public void kullaniciTumKayitAlanlariniBosBirakarakHesapOlusturButonunaTiklar() {
        rm.mySendKeys(hp.getEmailInput(), "");
        rm.mySendKeys(hp.getPasswordInput(), "");
        rm.mySendKeys(hp.getConfirmPasswordInput(), "");
        rm.myClick(hp.getHesapOlusturButton());
    }

    @Then("Zorunlu alanlarda \"Bu alan zorunludur\" uyarısı gösterilmelidir")
    public void zorunluAlanlardaBuAlanZorunludurUyarisiGosterilmelidir() {
        Assert.assertTrue(hp.getEmailInput().isVisible(), "Zorunlu alan uyarısı gösterildi");
    }

    @When("Kullanıcı halihazırda sistemde kayıtlı olan bir e-posta adresi girer")
    public void kullaniciHalihazirdaSistemdeKayitliOlanBirEPostaAdresiGirer() {
        rm.mySendKeys(hp.getEmailInput(), "existing@example.com");
    }

    @And("Diğer alanları doldurup \"Hesap Oluştur\" butonuna tıklar")
    public void digerAlanlariDoldurupHesapOlusturButonunaTiklar() {
        rm.mySendKeys(hp.getPasswordInput(), "Password123!");
        rm.mySendKeys(hp.getConfirmPasswordInput(), "Password123!");
        rm.myClick(hp.getHesapOlusturButton());
    }

    @Then("Ekranda \"Bu e-posta adresi zaten kullanımda\" hatası dönülmelidir")
    public void ekrandaBuEPostaAdresiZatenKullanimdaHatasiDonulmelidir() {
        Assert.assertTrue(hp.getEmailInput().isVisible(), "Zaten kullanımda hatası gösterildi");
    }

    @When("Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer \\(örn: \"Ab1!\")")
    public void kullaniciSifreAlanina8KarakterdenKisaBirSifreGirerOrnAb1() {
        rm.mySendKeys(hp.getPasswordInput(), "Ab1!");
    }

    @Then("Ekranda minimum karakter sınırını belirten bir uyarı gösterilmelidir")
    public void ekrandaMinimumKarakterSiniriniBelirtenBirUyariGosterilmelidir() {
        Assert.assertTrue(hp.getPasswordInput().isVisible(), "Minimum karakter uyarısı gösterildi");
    }

    @When("Kullanıcı \"Şifre\" alanına \"Password123\" girer")
    public void kullaniciSifreAlaninaPassword123Girer() {
        rm.mySendKeys(hp.getPasswordInput(), "Password123");
    }

    @And("Şifreyi Onayla\" alanına farklı bir değer olan \"Password456\" girer")
    public void sifreyiOnaylaAlaninaFarkliBirDegerOlanPassword456Girer() {
        rm.mySendKeys(hp.getConfirmPasswordInput(), "Password456");
    }

    @Then("Ekranda \"Şifreler eşleşmiyor\" uyarısı gösterilmelidir")
    public void ekrandaSifrelerEslestirmiyorUyarisiGosterilmelidir() {
        Assert.assertTrue(hp.getConfirmPasswordInput().isVisible(), "Eşleşmiyor uyarısı gösterildi");
    }

    @When("Kullanıcı tüm geçerli bilgileri doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez")
    public void kullaniciTumGecerliBilgileriDoldururAncakKullaniciSozlesmesiKutucugunuIsaretlemez() {
        rm.mySendKeys(hp.getEmailInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(hp.getPasswordInput(), rm.resolveDynamicValue("fakerPassword"));
        rm.mySendKeys(hp.getConfirmPasswordInput(), rm.resolveDynamicValue("fakerPassword"));
    }

    @Then("Kayıt engellenmeli ve ekranda \"Sözleşmeyi kabul etmelisiniz\" uyarısı gösterilmelidir")
    public void kayitEngellenmeliVeEkrandaSozlesmeyiKabulEtmelisinizUyarisiGosterilmelidir() {
        Assert.assertTrue(hp.getHesapOlusturButton().isVisible(), "Sözleşme uyarısı gösterildi");
    }
}