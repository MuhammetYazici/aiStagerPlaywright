# language: tr
@US-AISTAGER-001 @AiStager
Feature: AiStager.ai Ana Sayfa, Kimlik Doğrulama ve Navigasyon Modülleri
  Bir platform ziyaretçisi veya kayıtlı kullanıcısı olarak, ana sayfadaki etkileşimli araçları kullanmak,
  üst menü üzerinden sayfalara erişmek ve güvenli bir şekilde üye olmak veya giriş yapmak istiyorum.

  Background:
    Given Kullanici AiStager platformundadir

  @TC_HP_001 @Positive
  Scenario: Oncesi ve Sonrasi Sihri slider alaninin dinamik kullanimi
    When Kullanici Oncesi ve Sonrasi Sihri slider alaninin goruntulendigini gorur
    And Kullanici kaydirma cubugunu veya sag veya alt oklari kullanarak gorseller arasi gecis yapar
    Then Gecisin purussuz bir sekilde gerceklestigi dogrulanir

  @TC_HP_001 @Positive
  Scenario: Dil seceneginin degistirilmesi ve anlik uyarlama
    When Kullanici ana sayfada dil secenegini TR olarak degistirir
    Then Sayfadaki tum metinlerin anlik olarak Turkce dile uyarlandigi dogrulanir

  @TC_HP_002 @Positive
  Scenario: Oturum acmis kullanicinin menu ve panel gorunurlugu
    Given Gecerli kimlik bilgileriyle sisteme giris yapmis bir kullanici ana sayfadadir
    When Ust menude Uretimlerim seceneginin hizli render veya kamera ayarla panelinin ve profil menusunun aktif olarak gorundugu dogrulanir
    And Kullanici logoya tiklar
    Then Ana sayfaya yonlendirildigi dogrulanir

  @TC_HP_002_VISITOR @Positive
  Scenario: Ziyaretci durumundaki kullanicinin menu gorunurlugu
    Given Sisteme giris yapmamis bir ziyaretci ana sayfayi ziyaret eder
    Then Ust menude Uretimlerim menusunun ve profil ikonunun gizlenmis oldugu dogrulanir
    And Bunun yerine Giris Yap ve Ucretsiz Dene butonlarinin yer aldigi dogrulanir

  @TC_HP_003_REV @Positive
  Scenario: Galeri varsayilan gorunumu ve oda tipi filtreleme
    When Kullanici ana sayfadaki galeri alanina gelir
    Then Galeri ilk acildiginda varsayilan olarak Tum Tipler seceneginin aktif oldugu ve karisik oda tiplerinin listelendigi dogrulanir
    When Kullanici belirli bir oda tipi filtre butonuna tiklar
    Then Galerinin yalnizca secilen kategoriye ait tasarımlari filtreledigi dogrulanir

  @TC_HP_003_REV @Positive
  Scenario: Galeride Daha Fazla Tasarim Yukle aksiyonu
    Given Kullanici galeride bir oda tipi filtresi secer
    When Kullanici Daha Fazla Tasarim Yukle butonuna tiklar
    Then Mevcut filtrenin korundugu ve yeni tasarım kartlarının yuklendigi dogrulanir

  @TC_HP_003_REV @Positive
  Scenario: Tasarim kartlari uzerinden profil ziyareti ve begeni artirma
    When Kullanici galeri uzerindeki bir tasarim kartına ve uzerindeki kullanıcı profiline tiklar
    Then İlgili kullanıcı profiline gidilebildigi dogrulanir
    When Kullanici Begeni ikonuna tiklar
    Then Sayac degerinin bir arttigi dogrulanir

  @TC_HP_004 @Positive
  Scenario: Sikca Sorulan Sorular akordeon menu davranisi
    When Kullanici SSS bolumune gelir ve bir soruyu acar
    Then İlgili sorunun acildigi gorulur
    When Kullanici farkli bir soruya tiklar
    Then Yeni acilan sorunun acik kaldigi onceki sorunun ise otomatik olarak kapandigi dogrulanir

  @TC_HP_005 @Positive
  Scenario: Bülten kayıt formuna geçerli e-posta girişi
    When Kullanici bulten formuna "test@aistager.ai" adresini girer ve kaydol butonuna tiklar
    Then Basari mesajinin goruntulendigi dogrulanir

  @TC_HP_005 @Negative @EdgeCase
  Scenario Outline: Bülten kayıt formuna geçersiz veya boş e-posta girişi
    When Kullanici bulten formuna "<gecersiz_eposta>" adresini girer ve kaydol butonuna tiklar
    Then Kayit isleminin engellendigi ve uygun bir hata mesaji gosterildigi dogrulanir

    Examples:
      | gecersiz_eposta |
      |                 |
      | test@           |
      | test.com        |
      | @aistager.ai    |

  @TC_LOG_001 @Positive
  Scenario: Geçerli bilgilerle başarılı giriş yapma
    Given Kullanici Giris Yap sayfasindadir
    When Kullanici gecerli e-posta ve sifre bilgilerini girer
    And Sifre alanindaki maskelemenin calistigini test eder
    And Giris butonuna tiklar
    Then Kullanicinin panele yonlendirildigi dogrulanir

  @TC_LOG_001 @Positive
  Scenario: Google ile OAuth üzerinden giriş yapma
    Given Kullanici Giris Yap sayfasindadir
    When Kullanici Google ile Giris Yap butonuna tiklar
    Then Google hesap secim ekraninin acildigi ve basarili giris sonrasi panele yonlendirildigi dogrulanir

  @TC_LOG_002 @Negative @Security
  Scenario Outline: Geçersiz veya eksik bilgilerle giriş denemesi
    Given Kullanici Giris Yap sayfasindadir
    When E-posta alanina "<eposta>" sifre alanina "<sifre>" girer
    And Giris butonuna tiklar
    Then Guvenlik amaciyla spesifik hata yerine genel e-posta veya sifre hatali mesajinin gosterildigi dogrulanir

    Examples:
      | eposta              | sifre       |
      |                     |             |
      | kayitli@aistager.ai | yanlissifre |
      | olmasimail@test.com | dogrusifre  |

  @TC_LOG_002 @EdgeCase @Security
  Scenario: Giriş sayfasında SQL Injection ve aşırı uzun karakter testi
    Given Kullanici Giris Yap sayfasindadir
    When E-posta alanina sql enjeksiyonu veya bin karakterlik uzun bir metin girer
    Then Sistemin cokmedigi guvenli bir sekilde filtrelendigi ve hata mesaji dondurdugu dogrulanir

  @TC_REG_001 @Positive
  Scenario: Yeni kullanıcı kaydı oluşturma
    Given Kullanici Kayit Ol sayfasindadir
    When Kullanici gecerli bir e-posta en az sekiz karakterli birbiriyle eslesen iki sifre girer
    And Kullanici sozlesmesi onay kutucugunu secer
    And Kayit Ol butonuna tiklar
    Then Hesabin basariyla olusturuldugu dogrulanir

  @TC_REG_001 @Negative
  Scenario Outline: Eksik veya hatalı kurallarla kayıt olma denemeleri
    Given Kullanici Kayit Ol sayfasindadir
    When Formu "<eposta>" "<sifre>" "<sifre_tekrar>" ve sozlesme durumu "<sozlesme>" ile doldurur
    And Kayit Ol butonuna tiklar
    Then İlgili validasyon hata mesajinin alindigi dogrulanir

    Examples:
      | eposta           | sifre    | sifre_tekrar | sozlesme |
      | yeni@aistager.ai | 12345    | 12345        | true     |
      | yeni@aistager.ai | Sifre123 | SifreABC     | true     |
      | yeni@aistager.ai | Sifre123 | Sifre123     | false    |
      |                  | Sifre123 | Sifre123     | true     |

  @TC_REG_002 @Negative
  Scenario: Halihazırda kayıtlı e-posta adresi ile mükerrer kayıt engelleme
    Given Kullanici Kayit Ol sayfasindadir
    When Sistemde halihazirda kayitli olan bir e-posta adresini girer
    And Sifre kurallarina uygun sifre girer ve sozlesmeyi onaylar
    And Kayit Ol butonuna tiklar
    Then Bu e-posta adresi zaten kullanimda uyarisinin gosterildigi dogrulanir