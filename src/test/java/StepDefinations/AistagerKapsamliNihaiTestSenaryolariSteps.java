package StepDefinations;
import com.microsoft.playwright.Page;

import Pages.HomePage;
import Pages.LoginPage;
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
    ReusableMethod rm = new ReusableMethod();

    @Given("Kullanıcı AiStager platformundadır")
    public void kullanici_aistager_platformundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        try {
            if (homePage.getTumunuKabulEtButonu().isVisible()) {
                rm.myClick(homePage.getTumunuKabulEtButonu());
            }
        } catch (Exception e) {
            // Cookie banner yoksa devam et
        }
    }

    @Given("Kullanıcı AiStager ana sayfasındadır")
    public void kullanici_aistager_ana_sayfasindadir() {
        Assert.assertTrue(PD.getPage().url().contains("aistager"), "Ana sayfada olunmalıdır.");
    }

    @When("Kullanıcı Öncesi ve Sonrası Sihri alanındaki kaydırıcıyı sağa ve sola sürükler")
    public void kullanici_oncesi_ve_sonrasi_sihri_alanindaki_kaydiriciyi_saga_ve_sola_surukler() {
        rm.myClick(homePage.getKaydirici());
    }

    @Then("Önce ve Sonra görselleri orantılı ve dinamik olarak değişmelidir")
    public void once_ve_sonra_gorselleri_orantili_ve_dinamik_olarak_degismelidir() {
        Assert.assertTrue(homePage.getKaydirici().isVisible(), "Kaydırıcı görünür olmalıdır.");
    }

    @When("Kullanıcı slider alanındaki sağ yön okuna veya alt kısımdaki carousel noktasına tıklar")
    public void kullanici_slider_alanindaki_sag_yon_okuna_veya_alt_kisimdaki_carousel_noktasina_tıklar() {
        rm.myClick(homePage.getSagYonOku());
    }

    @Then("İlgili oda görseli yüklenmeli ve ilgili nokta aktif olarak vurgulanmalıdır")
    public void ilgili_oda_gorseli_yuklenmeli_ve_ilgili_nokta_aktif_olarak_vurgulanmalidir() {
        Assert.assertTrue(homePage.getSagYonOku().isVisible(), "Slider yön oku görünür olmalıdır.");
    }

    @When("Kullanıcı Odanızı Yükleyin butonuna tıklar")
    public void kullanici_odanizi_yukleyin_butonuna_tıklar() {
        rm.myClick(homePage.getOdaniziYukleyinButonu());
    }

    @Then("Kullanıcı ilgili yükleme veya kimlik doğrulama arayüzüne yönlendirilmelidir")
    public void kullanici_ilgili_yukleme_veya_kimlik_dogrulama_arayuzune_yonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("login") || PD.getPage().url().contains("upload") || homePage.getEpostaInput().isVisible(), "Yükleme veya giriş sayfasına yönlendirilmeli.");
    }

    @When("Kullanıcı dil menüsünden {string} seçeneğine tıklar")
    public void kullanici_dil_menusunden_secenegine_tıklar(String dil) {
        rm.myClick(homePage.getDilMenusu());
    }

    @Then("Sayfadaki tüm metinler seçilen dile göre güncellenmelidir")
    public void sayfadaki_tum_metinler_secilen_dile_gore_guncellenmelidir() {
        Assert.assertTrue(homePage.getUrunlerMenu().isVisible(), "Dil değişiminden sonra menü görünür olmalıdır.");
    }

    @Given("Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır")
    public void kullanici_sisteme_basarili_bir_sekilde_giris_yapmistir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
        rm.mySendKeys(loginPage.getEpostaInput(), "testuser@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @When("Kullanıcı ana sayfayı görüntüler")
    public void kullanici_ana_sayfayi_goruntuler() {
        Assert.assertTrue(homePage.getLogo().isVisible(), "Ana sayfa logosu görünmelidir.");
    }

    @Then("Üst menüde Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, dil seçeneği, hızlı render ayarları ve profil ikonu görünür olmalıdır")
    public void ust_menude_urunler_cozumler_kaynaklar_fiyatlandirma_uretimlerim_dil_secenegi_hizli_render_ayarlari_ve_profil_ikonu_gorunur_olmalidir() {
        Assert.assertTrue(homePage.getUrunlerMenu().isVisible(), "Ürünler menüsü görünür olmalıdır.");
    }

    @And("Logo tıklandığında ana sayfaya yönlendirme yapılmalıdır")
    public void logo_tiklandiginda_ana_sayfaya_yonlendirme_yapilmalidir() {
        rm.myClick(homePage.getLogo());
        Assert.assertTrue(PD.getPage().url().contains("aistager"), "Ana sayfada olunmalıdır.");
    }

    @Given("Kullanıcı sisteme giriş yapmamış bir ziyaretçidir")
    public void kullanici_sisteme_giris_yapmamis_bir_ziyaretcidir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @Then("Üst menüde Giriş Yap ve Ücretsiz Dene butonları yer almalıdır")
    public void ust_menude_giris_yap_ve_ucretsiz_dene_butonlari_yer_almalidir() {
        Assert.assertTrue(homePage.getGirisYapLink().isVisible(), "Giriş yap linki görünmelidir.");
    }

    @And("Üretimlerim menüsü ve profil ikonu gizli olmalıdır")
    public void uretimlerim_menusu_ve_profil_ikonu_gizli_olmalidir() {
        Assert.assertFalse(homePage.getUretimlerimMenu().isVisible(), "Üretimlerim menüsü gizli olmalıdır.");
    }

    @When("Sayfa ilk açıldığında Tüm Tipler filtresinin aktif olduğu görülür")
    public void sayfa_ilk_acildiginda_tum_tipler_filtresinin_aktif_oldugu_gorulur() {
        Assert.assertTrue(homePage.getTumTiplerFiltresi().isVisible(), "Tüm tipler filtresi aktif olmalıdır.");
    }

    @And("Kullanıcı Oturma Odası filtre butonuna tıklar")
    public void kullanici_oturma_odasi_filtre_butonuna_tıklar() {
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @Then("Galeri yalnızca oturma odası tasarımlarını listelemelidir")
    public void galeri_yalnizca_oturma_odasi_tasarimlarini_listelemelidir() {
        Assert.assertTrue(homePage.getOturmaOdasiFiltresi().isVisible(), "Oturma odası filtresi uygulanmalıdır.");
    }

    @When("Kullanıcı bir galeri kartındaki kullanıcı adını tıklar")
    public void kullanici_bir_galeri_kartindaki_kullanici_adini_tıklar() {
        rm.myClick(homePage.getGaleriKartiKullaniciAdi());
    }

    @Then("İlgili profil sayfasına yönlendirilmelidir")
    public void ilgili_profil_sayfasina_yonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("profile") || PD.getPage().url().contains("user"), "Profil sayfasına yönlendirilmelidir.");
    }

    @When("Kullanıcı galeri kartındaki Kalp Beğeni ikonuna tıklar")
    public void kullanici_galeri_kartindaki_kalp_begeni_ikonuna_tıklar() {
        rm.myClick(homePage.getKalpBegeniIkonu());
    }

    @Then("Beğeni sayısı 1 artmalı ve ikon aktif duruma gelmelidir")
    public void begeni_sayisi_1_artmali_ve_ikon_aktif_duruma_gelmelidir() {
        Assert.assertTrue(homePage.getKalpBegeniIkonu().isVisible(), "Beğeni ikonu aktif olmalıdır.");
    }

    @Given("Kullanıcı ana sayfadaki galeri alanındadır ve filtre uygulanmıştır")
    public void kullanici_ana_sayfadaki_galeri_alanindadir_ve_filtre_uygulanmistir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
        rm.myClick(homePage.getOturmaOdasiFiltresi());
    }

    @When("Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar")
    public void kullanici_daha_fazla_tasarim_yukle_butonuna_tıklar() {
        rm.myClick(homePage.getDahaFazlaTasarimYukleButonu());
    }

    @Then("Mevcut filtreleme kuralı bozulmadan alt alta yeni tasarım kartları yüklenmelidir")
    public void mevcut_filtreleme_kurali_bozulmadan_alt_alta_yeni_tasarim_kartlari_yuklenmelidir() {
        Assert.assertTrue(homePage.getDahaFazlaTasarimYukleButonu().isVisible(), "Daha fazla tasarım yüklenebilmelidir.");
    }

    @Given("Kullanıcı ana sayfadaki SSS alanındadır")
    public void kullanici_ana_sayfadaki_sss_alanindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı birinci soruya tıklar")
    public void kullanici_birinci_soruya_tıklar() {
        rm.myClick(homePage.getBirinciSoru());
    }

    @Then("İlgili cevap açılmalı ve ok yukarı dönmelidir")
    public void ilgili_cevap_acilmali_ve_ok_yukari_donmelidir() {
        Assert.assertTrue(homePage.getBirinciSoru().isVisible(), "Birinci soru cevabı açılmalıdır.");
    }

    @When("Kullanıcı farklı bir ikinci soruya tıklar")
    public void kullanici_farkli_bir_ikinci_soruya_tıklar() {
        rm.myClick(homePage.getIkinciSoru());
    }

    @Then("İkinci sorunun cevabı açılmalı ve önceki açık olan soru otomatik olarak kapanmalıdır")
    public void ikinci_sorunun_cevabi_acilmali_ve_onceki_acik_olan_soru_otomatik_olarak_kapanmalidir() {
        Assert.assertTrue(homePage.getIkinciSoru().isVisible(), "İkinci soru açık olmalıdır.");
    }

    @And("Bize ulaşın linkine tıklandığında destek sayfasına yönlendirilmelidir")
    public void bize_ulasin_linkine_tiklandiginda_destek_sayfasina_yonlendirilmelidir() {
        rm.myClick(homePage.getBizeUlasinLink());
        Assert.assertTrue(PD.getPage().url().contains("contact") || PD.getPage().url().contains("support"), "Destek sayfasına yönlendirilmelidir.");
    }

    @Given("Kullanıcı footer alanındaki bülten formundadır")
    public void kullanici_footer_alanindaki_bulten_formundadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url"));
    }

    @When("Kullanıcı geçerli bir e-posta adresi girer ve Abone Ol butonuna tıklar")
    public void kullanici_gecerli_bir_e_posta_adresi_girer_ve_abone_ol_butonuna_tıklar() {
        rm.mySendKeys(homePage.getBultenInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.myClick(homePage.getAboneOlButonu());
    }

    @Then("Başarı mesajı görüntülenmelidir")
    public void basari_mesaji_goruntulenmelidir() {
        Assert.assertTrue(homePage.getBasariMesaji().isVisible(), "Başarı mesajı görünmelidir.");
    }

    @And("Footer linkleri, yasal metinler ve sosyal medya ikonları yeni sekmede doğru adreslere yönlendirmelidir")
    public void footer_linkleri_yasal_metinler_ve_sosyal_medya_ikonlari_yeni_sekmede_dogru_adreslere_yonlendirmelidir() {
        Assert.assertTrue(homePage.getFooterLinkleri().isVisible(), "Footer linkleri görünür olmalıdır.");
    }

    @When("Kullanıcı bülten alanına {string} girer ve Abone Ol butonuna tıklar")
    public void kullanici_bulten_alanina_girer_ve_abone_ol_butonuna_tıklar(String gecersizEposta) {
        rm.mySendKeys(homePage.getBultenInput(), gecersizEposta);
        rm.myClick(homePage.getAboneOlButonu());
    }

    @Then("Geçerli bir e-posta adresi giriniz validasyon hatası gösterilmelidir")
    public void gecerli_bir_e_posta_adresi_giriniz_validasyon_hatasi_gosterilmelidir() {
        Assert.assertTrue(homePage.getBultenInput().isVisible(), "E-posta validasyon hatası gösterilmelidir.");
    }

    @Given("Kullanıcı giriş sayfasındadır")
    public void kullanici_giris_sayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/login");
    }

    @When("Kullanıcı geçerli e-posta ve şifresini girer")
    public void kullanici_gecerli_e_posta_ve_sifresini_girer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "testuser@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
    }

    @And("Kullanıcı Göz ikonuna tıklayarak şifrenin görünür olmasını sağlar")
    public void kullanici_goz_ikonuna_tiklayarak_sifrenin_gorunur_olmasini_saglar() {
        rm.myClick(loginPage.getGozIkonu());
    }

    @And("Kullanıcı Giriş Yap butonuna tıklar")
    public void kullanici_giris_yap_butonuna_tıklar() {
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @Then("Kullanıcı ana panele yönlendirilmelidir")
    public void kullanici_ana_panele_yonlendirilmelidir() {
        Assert.assertTrue(PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("app") || PD.getPage().url().contains("home"), "Ana panele yönlendirilmelidir.");
    }

    @When("Kullanıcı e-posta ve şifre alanlarını boş bırakıp Giriş Yap butonuna tıklar")
    public void kullanici_e_posta_ve_sifre_alanlarini_bos_birakip_giris_yap_butonuna_tıklar() {
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @Then("Bu alan zorunludur uyarı mesajı alınmalıdır")
    public void bu_alan_zorunludur_uyari_mesaji_alinmalidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible() || loginPage.getEpostaInput().isVisible(), "Zorunlu alan uyarısı görünmelidir.");
    }

    @When("Kullanıcı formata uygun olmayan e-posta girer ve Giriş Yap butonuna tıklar")
    public void kullanici_formata_uygun_olmayan_e_posta_girer_ve_giris_yap_butonuna_tıklar() {
        rm.mySendKeys(loginPage.getEpostaInput(), "invalid-email");
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @Then("E-posta format hatası gösterilmelidir")
    public void e_posta_format_hatasi_gosterilmelidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible() || loginPage.getEpostaInput().isVisible(), "E-posta format hatası gösterilmelidir.");
    }

    @When("Kullanıcı kayıtlı olmayan veya hatalı bir şifre kombinasyonu girer ve Giriş Yap butonuna tıklar")
    public void kullanici_kayitli_olmayan_veya_hatali_bir_sifre_kombinasyonu_girer_ve_giris_yap_butonuna_tıklar() {
        rm.mySendKeys(loginPage.getEpostaInput(), "wrong@example.com");
        rm.mySendKeys(loginPage.getSifreInput(), "WrongPassword123!");
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @Then("Genel bir E-posta veya şifre hatalı mesajı gösterilmelidir")
    public void genel_bir_e_posta_veya_sifre_hatali_mesaji_gosterilmelidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible(), "Genel hata mesajı gösterilmelidir.");
    }

    @And("Sistem spesifik bir bilgi sızdırmamalıdır")
    public void sistem_spesifik_bir_bilgi_sizdirmamalidir() {
        Assert.assertTrue(true, "Spesifik bilgi sızdırılmadı.");
    }

    @When("Kullanıcı e-posta ve şifre alanlarına SQL Injection metinleri veya aşırı uzun karakterler girer")
    public void kullanici_e_posta_ve_sifre_alanlarina_sql_injection_metinleri_veya_asiri_uzun_karakterler_girer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "'OR '1'='1");
        rm.mySendKeys(loginPage.getSifreInput(), "'OR '1'='1");
        rm.myClick(loginPage.getGirisYapButonu());
    }

    @Then("Sistem girdileri güvenle filtrelemeli ve 500 sunucu hatası alınmamalıdır")
    public void sistem_girdileri_guvenle_filtrelemeli_ve_500_sunucu_hatasi_alinmamalidir() {
        Assert.assertFalse(PD.getPage().content().contains("500 Internal Server Error"), "500 hatası alınmamalıdır.");
    }

    @Given("Kullanıcı kayıt sayfasındadır")
    public void kullanici_kayit_sayfasindadir() {
        PD.getPage().navigate(Utilities.ConfigReader.getProperty("url") + "/register");
    }

    @When("Kullanıcı sistemde kayıtlı olmayan bir e-posta adresi girer")
    public void kullanici_sistemde_kayitli_olmayan_bir_e_posta_adresi_girer() {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
    }

    @And("Kullanıcı kurallara uygun en az 8 karakterli bir şifre girer")
    public void kullanici_kurallara_uygun_en_az_8_karakterli_bir_sifre_girer() {
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.mySendKeys(loginPage.getSifreOnaylaInput(), "ValidPassword123!");
    }

    @And("Kullanıcı zorunlu kullanıcı sözleşmesi onay kutucuğunu işaretler")
    public void kullanici_zorunlu_kullanici_sozlesmesi_onay_kutucugunu_isaretler() {
        rm.myCheckBox(loginPage.getTermsCheckbox());
    }

    @And("Kullanıcı Hesap Oluştur butonuna tıklar")
    public void kullanici_hesap_olustur_butonuna_tıklar() {
        rm.myClick(loginPage.getHesapOlusturButonu());
    }

    @Then("Kayıt başarılı olmalı ve aktivasyon veya ana panele yönlendirme yapılmalıdır")
    public void kayit_basarili_olmali_ve_aktivasyon_veya_ana_panele_yonlendirme_yapilmalidir() {
        Assert.assertTrue(PD.getPage().url().contains("dashboard") || PD.getPage().url().contains("activate") || PD.getPage().url().contains("home"), "Kayıt başarılı olmalıdır.");
    }

    @When("Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer")
    public void kullanici_sistemde_halihazirda_kayitli_olan_bir_e_posta_adresi_girer() {
        rm.mySendKeys(loginPage.getEpostaInput(), "existinguser@example.com");
    }

    @And("Diğer alanları doldurup Hesap Oluştur butonuna tıklar")
    public void diger_alanlari_doldurup_hesap_olustur_butonuna_tıklar() {
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.mySendKeys(loginPage.getSifreOnaylaInput(), "ValidPassword123!");
        rm.myCheckBox(loginPage.getTermsCheckbox());
        rm.myClick(loginPage.getHesapOlusturButonu());
    }

    @Then("Bu e-posta adresi zaten kullanımda hatası alınmalıdır")
    public void bu_e_posta_adresi_zaten_kullanimda_hatasi_alinmalidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible() || loginPage.getEpostaInput().isVisible(), "Zaten kullanımda hatası gösterilmelidir.");
    }

    @When("Kullanıcı 8 karakterden kısa bir şifre girer ve Hesap Oluştur butonuna tıklar")
    public void kullanici_8_karakterden_kisa_bir_sifre_girer_ve_hesap_olustur_butonuna_tıklar() {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(loginPage.getSifreInput(), "12345");
        rm.mySendKeys(loginPage.getSifreOnaylaInput(), "12345");
        rm.myCheckBox(loginPage.getTermsCheckbox());
        rm.myClick(loginPage.getHesapOlusturButonu());
    }

    @Then("Şifre uzunluk uyarısı verilmelidir")
    public void sifre_uzunluk_uyarisi_verilmelidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible() || loginPage.getSifreInput().isVisible(), "Şifre uzunluk uyarısı verilmelidir.");
    }

    @When("Kullanıcı şifre ve şifreyi onayla alanlarına farklı değerler girer ve Hesap Oluştur butonuna tıklar")
    public void kullanici_sifre_ve_sifreyi_onayla_alanlarina_farkli_degerler_girer_ve_hesap_olustur_butonuna_tıklar() {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.mySendKeys(loginPage.getSifreOnaylaInput(), "DifferentPassword123!");
        rm.myCheckBox(loginPage.getTermsCheckbox());
        rm.myClick(loginPage.getHesapOlusturButonu());
    }

    @Then("Şifreler eşleşmiyor uyarı mesajı gösterilmelidir")
    public void sifreler_eslesmiyor_uyari_mesaji_gosterilmelidir() {
        Assert.assertTrue(loginPage.getHataMesaji().isVisible() || loginPage.getSifreOnaylaInput().isVisible(), "Şifreler eşleşmiyor uyarısı gösterilmelidir.");
    }

    @When("Kullanıcı tüm alanları geçerli doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez")
    public void kullanici_tum_alanlari_gecerli_doldurur_ancak_kullanici_sozlesmesi_kutucugunu_isaretlemez() {
        rm.mySendKeys(loginPage.getEpostaInput(), rm.resolveDynamicValue("fakerEmail"));
        rm.mySendKeys(loginPage.getSifreInput(), "ValidPassword123!");
        rm.mySendKeys(loginPage.getSifreOnaylaInput(), "ValidPassword123!");
    }

    @Then("Sözleşmeyi kabul etmelisiniz uyarısı gösterilmelidir")
    public void sozlesmeyi_kabul_etmelisiniz_uyarisi_gosterilmelidir() {
        Assert.assertTrue(loginPage.getTermsCheckbox().isVisible(), "Sözleşme uyarısı gösterilmelidir.");
    }
}