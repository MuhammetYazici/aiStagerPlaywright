# language: tr
Feature: AiStager.ai - Ana Sayfa, Kimlik Doğrulama ve Temel Navigasyon
  Kullanıcı olarak ana sayfadaki bileşenleri kullanabilmek,
  sisteme güvenli giriş yapabilmek ve yeni hesap oluşturabilmek istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  @regression @home @positive
  Scenario: Öncesi ve Sonrası Sihri slider alanının dinamik çalışması
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı Öncesi ve Sonrası Sihri slider alanındaki görseli sağa sola sürükler veya ok butonlarına tıklar
    Then Mobilyalı ve boş oda arasındaki görsel geçiş pürüzsüz bir şekilde gerçekleşmelidir
    And Kullanıcı alt carousel noktalarını kullanarak da görseller arasında geçiş yapabilmelidir

  @regression @home @positive
  Scenario: Giriş yapmış kullanıcının üst menü görünümü
    Given Kullanıcı sisteme geçerli kimlik bilgileriyle giriş yapmıştır
    When Kullanıcı AiStager.ai ana sayfasına gider
    Then Üst menüde Üretimlerim menüsü ve Profil ikonu görünür olmalıdır
    And "Giriş Yap" ve "Ücretsiz Dene" butonları görünmemelidir

  @regression @home @positive
  Scenario: Ziyaretçi kullanıcının üst menü görünümü
    Given Kullanıcı sisteme giriş yapmamıştır ziyaretçidir
    When Kullanıcı AiStager.ai ana sayfasına gider
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üretimlerim ve profil alanları gizli olmalıdır

  @regression @home @positive
  Scenario: Topluluk tasarımları galerisinde filtreleme ve etkileşimler
    Given Kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır
    When Kullanıcı oda tiplerinden Oturma Odası filtresini seçer
    Then Galeri kartları sadece Oturma Odası tasarımlarını gösterecek şekilde güncellenmelidir
    When Kullanıcı bir kart üzerinden beğeni kalp ikonuna tıklar
    Then Tasarımın beğeni sayısı artmalıdır
    And Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklandığında yeni tasarımlar yüklenmelidir

  @regression @home @positive
  Scenario: SSS Akordeon alanının tekli açılma kuralı
    Given Kullanıcı ana sayfadaki SSS Akordeon alanındadır
    When Kullanıcı birinci akordeon başlığına tıklayarak içeriği açar
    And Kullanıcı ikinci bir akordeon başlığına tıklar
    Then İkinci akordeonun içeriği açılmalı ve birinci akordeon otomatik olarak kapanmalıdır

  @regression @home @positive
  Scenario: Footer bülten alanına geçerli e-posta kaydı
    Given Kullanıcı ana sayfanın footer bölümündeki bülten alanındadır
    When Kullanıcı bülten alanına geçerli bir "test@example.com" e-posta adresi girer ve gönder butonuna tıklar
    Then Başarılı bülten kayıt mesajı görüntülenmelidir

  @regression @home @negative @edge-case
  Scenario Outline: Footer bülten alanına geçersiz e-posta girilmesi
    Given Kullanıcı ana sayfanın footer bölümündeki bülten alanındadır
    When Kullanıcı bülten alanına "<gecersiz_eposta>" girer ve gönder butonuna tıklar
    Then Hatalı e-posta uyarı mesajı görüntülenmelidir

    Examples:
      | gecersiz_eposta |
      | test.com        |
      | test@.com       |
      | @example.com    |
      | boş_değer       |

  @smoke @login @positive
  Scenario: Kayıtlı kullanıcı ile başarılı giriş yapma Pozitif
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı geçerli "kayitli_kullanici@example.com" e-posta adresini girer
    And Kullanıcı doğru şifresini şifre alanına yazar
    And Kullanıcı şifre alanındaki göz ikonuna tıklayarak şifrenin maskesini kaldırır ve görünür olduğunu doğrular
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarıyla ana panele dashboard yönlendirilmelidir

  @login @positive
  Scenario: Google ile OAuth üzerinden başarılı giriş yapma
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı Google ile Giriş Yap butonuna tıklar
    And Google hesap seçimi ve yetkilendirme adımlarını tamamlar
    Then Kullanıcı başarıyla sisteme giriş yaparak ana panele yönlendirilmelidir

  @login @negative
  Scenario: Giriş formunda boş alan bırakılması
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then İlgili alanların altında Bu alan zorunludur uyarı mesajları görünmelidir

  @login @negative
  Scenario Outline: Giriş formunda geçersiz e-posta formatı girilmesi
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına "<hatali_eposta>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Lütfen geçerli bir e-posta adresi girin uyarı mesajı alınmalıdır

    Examples:
      | hatali_eposta   |
      | yalniseposta    |
      | eposta@domain   |
      | eposta..com     |

  @login @negative @security
  Scenario Outline: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi Güvenlik
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına "<eposta>" ve şifre alanına "<sifre>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem kullanıcı güvenliği User Enumeration gereği genel olarak E-posta veya şifre hatalı mesajı döndürmelidir

    Examples:
      | eposta                       | sifre          |
      | kayitli_kullanici@example.com| YanlisSifre123 |
      | kayitsiz_eposta@example.com  | DogruSifre123  |

  @login @security @edge-case
  Scenario: Giriş formunda SQL Injection ve anormal uzunlukta girdi testi
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına "' OR '1'='1" veya çok uzun karakter dizileri girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem güvenlik açıklarına karşı girdileri filtrelemeli ve E-posta veya şifre hatalı veya format hatası döndürerek güvenle engellemelidir

  @smoke @register @positive
  Scenario: Yeni ve geçerli bilgilerle başarılı kayıt olma Pozitif
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan yeni bir e-posta adresi girer
    And Kullanıcı minimum 8 karakterden oluşan şifresini Şifre ve Şifreyi Onayla alanlarına aynı şekilde girer
    And Kullanıcı Kullanıcı sözleşmesi Terms and Conditions onay kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcıya yönlendirme yapılmalıdır

  @register @positive
  Scenario: Google ile hızlı kayıt OAuth olma
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı Google ile Kayıt Ol butonuna tıklar
    And Google hesap izinlerini onaylar
    Then Yeni hesap başarıyla oluşturulmalı ve sisteme giriş yapılmalıdır

  @register @negative
  Scenario: Zorunlu alanların boş bırakılması ile kayıt denemesi
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı tüm kayıt alanlarını boş bırakarak Kayıt Ol butonuna tıklar
    Then Zorunlu alanlar için Bu alan zorunludur uyarı mesajları gösterilmelidir

  @register @negative
  Scenario: Sistemde zaten kayıtlı olan e-posta ile kayıt olma
    Given Sistemde hali hazırda kayıtlı olan bir "mevcut_kullanici@example.com" adresi bulunmaktadır
    When Kullanıcı Kayıt Ol sayfasındaki e-posta alanına "mevcut_kullanici@example.com" girer
    And Diğer tüm alanları geçerli doldurup sözleşmeyi onaylayarak Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda hata mesajı gösterilmelidir

  @register @negative @edge-case
  Scenario Outline: Şifre kuralları ve uyuşmazlığı validasyonları
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı şifre alanına "<sifre>" ve şifreyi onayla alanına "<sifre_onayla>" girer
    And Diğer zorunlu alanları doldurup sözleşmeyi onaylayarak Kayıt Ol butonuna tıklar
    Then "<hata_mesaji>" uyarısı alınmalıdır

    Examples:
      | sifre       | sifre_onayla | hata_mesaji                      |
      | Ab1!        | Ab1!         | Şifre en az 8 karakter olmalıdır |
      | Sifre1234   | Sifre1235    | Şifreler birbiriyle uyuşmuyor    |

  @register @negative
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt olma denemesi
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı geçerli e-posta ve şifre bilgilerini girer
    But Kullanıcı Kullanıcı sözleşmesi Terms and Conditions onay kutucuğunu işaretlemez
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Kayıt işlemi tamamlanmamalı ve sözleşmenin onaylanması gerektiğine dair uyarı alınmalıdır