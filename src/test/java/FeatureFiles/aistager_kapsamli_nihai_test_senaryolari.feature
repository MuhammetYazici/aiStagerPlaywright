Feature: AiStager.ai Ana Sayfa Deneyimi, Navigasyon, Bülten ve Kimlik Doğrulama Modülleri
  Kullanıcı olarak AiStager.ai platformunu pürüzsüz deneyimlemek, modüller arası gezinmek 
  ve güvenli bir şekilde üye olup oturum açabilmek istiyorum.

  Background:
    Given Kullanıcı AiStager.ai ana sayfasındadır

  @UI @Slider @Positive
  Scenario: Öncesi ve Sonrası Sihri slider alanının pürüzsüz geçiş yapması
    When Kullanıcı Öncesi ve Sonrası Sihri slider alanındaki yön oklarına tıklar veya kaydırma hareketi yapar
    Then Slider görseli dinamik ve pürüzsüz bir şekilde sonraki ve önceki geçişi sağlamalıdır

  @UI @Gallery @Positive
  Scenario: Topluluk tasarımları galerisinde oda tiplerine göre anlık filtreleme ve Pagination uyumu
    When Kullanıcı topluluk tasarımları galerisinde Yatak Odası filtre seçeneğine tıklar
    Then Galeri anlık olarak sadece Yatak Odası tasarımlarını listelemelidir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Sistem aktif olan Yatak Odası filtresini koruyarak yeni tasarım kartlarını yüklemelidir

  @UI @Accordion @Positive
  Scenario: Sıkça Sorulan Sorular alanında tekli açılım kuralı
    When Kullanıcı SSS alanından birinci soruya tıklayarak açar
    And Kullanıcı aynı anda ikinci bir soruya tıklar
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır
    And Aynı anda yalnızca tek bir soru açık kalmalıdır

  @UI @Header @Visitor
  Scenario: Ziyaretçi rolündeki kullanıcı için header menü öğelerinin görüntülenmesi
    Given Kullanıcı henüz oturum açmamış bir ziyaretçidir
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görüntülenmelidir
    And Header alanında Üretimlerim ve Profil İkonu yer almamalıdır

  @UI @Header @Authenticated @Positive
  Scenario: Giriş yapmış kullanıcı için header menü öğelerinin görüntülenmesi
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görüntülenmelidir
    And Header alanında Üretimlerim sekmesi ve Profil İkonu görüntülenmelidir
    And Header alanında Giriş Yap ve Ücretsiz Dene butonları yer almamalıdır

  @UI @Localization @Positive
  Scenario: Dil seçeneğinin tüm sayfa metinlerini anlık güncellemesi
    When Kullanıcı dil seçeneğini Türkçe olarak belirler
    Then Tüm ana sayfa metinleri, menüler ve butonlar anlık olarak Türkçe diline güncellenmelidir

  @Newsletter @Positive
  Scenario Outline: Bülten alanına geçerli e-posta ile kayıt olma
    When Kullanıcı footer bülten alanına "<GecerliEposta>" adresini yazar
    And Kullanıcı bülten kayıt butonuna tıklar
    Then Başarılı kayıt mesajı ekranda gösterilmelidir

    Examples:
      | GecerliEposta            |
      | test.kullanici@example.com |
      | user_123@aistager.ai     |

  @Newsletter @Negative @EdgeCase
  Scenario Outline: Bülten alanına geçersiz veya boş giriş yapıldığında validasyon hatası alınması
    When Kullanıcı footer bülten alanına "<GecersizEposta>" adresini yazar veya alanı boş bırakır
    And Kullanıcı bülten kayıt butonuna tıklar
    Then Form validasyon hata mesajı tetiklenmelidir

    Examples:
      | GecersizEposta |
      |                |
      | eksiksiz-email |
      | @domain.com    |
      | test@.com      |

  @Auth @Login @Negative
  Scenario: Giriş formunda zorunlu alanların boş bırakılması
    When Kullanıcı E-posta ve Şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then İlgili alanlar için zorunluluk uyarı mesajları gösterilmelidir

  @Auth @Login @Negative
  Scenario: Geçersiz e-posta formatı ile giriş denemesi
    When Kullanıcı e-posta alanına format dışı bir değer olan "gecersiz-email" girer
    Then E-posta format uyarısı gösterilmelidir

  @Auth @Login @Negative
  Scenario Outline: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesinde jenerik hata mesajı
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "<Eposta>" ve şifre alanına "<Sifre>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem güvenlik amacıyla ortak ve standart E-posta veya şifre hatalı hata mesajını dönmelidir

    Examples:
      | Eposta                    | Sifre          | Senaryo Açıklaması          |
      | kayitli olmayan@test.com  | DogruSifre123! | Kayıtlı olmayan e-posta     |
      | kayitli.uye@example.com   | YanlisSifre!   | Kayıtlı e-posta, yanlış şifre|

  @Auth @Login @Positive
  Scenario: Şifre alanında maskeleme işlevselliği
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı şifre alanına parolasını yazar
    Then Şifre karakterleri varsayılan olarak maskelenmiş olmalıdır
    When Kullanıcı şifre alanının yanındaki Göz ikonuna tıklar
    Then Şifre metin olarak görünür hale gelmelidir
    When Kullanıcı tekrar Göz ikonuna tıklar
    Then Şifre tekrar maskelenmelidir

  @Auth @Login @OAuth @Positive
  Scenario: Google OAuth ile sorunsuz giriş entegrasyonu
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı Google ile Giriş Yap butonuna tıklar
    Then Kullanıcı Google kimlik doğrulama ekranına yönlendirilmelidir
    When Kullanıcı geçerli Google hesabını seçerek izin verir
    Then Kullanıcı sisteme başarılı bir şekilde giriş yapmış olarak ana sayfaya yönlendirilmelidir

  @Auth @Register @Negative
  Scenario Outline: Kayıt esnasında zayıf veya eşleşmeyen şifre denemeleri
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı kayıt formundaki şifre alanına "<Sifre>" ve şifreyi onayla alanına "<SifreOnayla>" girer
    And Kullanıcı kayıt ol adımlarını tamamlamaya çalışır
    Then Parola politikası hatası veya şifrelerin eşleşmediği uyarısı alınmalıdır

    Examples:
      | Sifre      | SifreOnayla | Kural İhlali Durumu                |
      | Ab1!       | Ab1!        | 8 karakterden kısa şifre           |
      | 12345678   | 12345678    | Harf veya özel karakter içermeyen şifre |
      | Password1! | Password2!  | Şifreler birbiriyle eşleşmiyor     |

  @Auth @Register @Negative
  Scenario: Kullanıcı Sözleşmesi onay kutucuğu işaretlenmeden kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı geçerli kayıt bilgilerini ve eşleşen şifreyi girer
    And Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretlemez
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sistem hesap oluşturma isteğini reddetmeli ve sözleşme onayının zorunlu olduğunu belirten bir uyarı göstermelidir

  @Auth @Register @Negative
  Scenario: Halihazırda sistemde var olan bir e-posta adresi ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı kayıt formuna sistemde kayıtlı olan "varolan.uye@example.com" adresini girer
    And Tüm diğer zorunlu alanları kurallara uygun şekilde doldurur
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sistem Bu e-posta adresi zaten kullanımda uyarısını dönmelidir

  @Auth @Register @Positive
  Scenario: Başarılı kullanıcı kayıt süreci
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı benzersiz ve geçerli bir e-posta adresi girer
    And Kullanıcı en az 8 karakterli politikaya uygun şifresini Şifreyi Onayla alanına da aynı şekilde girer
    And Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcıya hoş geldin mesajı gösterilmelidir