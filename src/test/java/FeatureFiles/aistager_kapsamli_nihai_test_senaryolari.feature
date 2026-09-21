Feature: US_HP_001 - Ana Sayfa Etkileşimleri ve Navigasyon

  Background:
    Given Kullanıcı ana sayfadadır

  @positive @homepage
  Scenario: Öncesi ve Sonrası Slider alanının farklı yöntemlerle etkileşimi
    Given Kullanıcı Öncesi ve Sonrası slider alanına gelir
    When Kullanıcı slider üzerindeki ayırıcıyı sağa ve sola sürükler
    And Kullanıcı sağ ve sol yön oklarına tıklar
    And Kullanıcı alt kısımdaki carousel noktalarına tıklar
    Then Slider görselinin dinamik olarak değiştiği ve sorunsuz çalıştığı görülür

  @positive @homepage @visitor
  Scenario: Ziyaretçi durumundaki kullanıcı için header menü görünürlüğü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfanın header alanına bakar
    Then Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üretimlerim menüsü ve profil ikonu gizli olmalıdır

  @positive @homepage @logged_in
  Scenario: Oturum açmış kullanıcı için header menü görünürlüğü
    Given Kullanıcı sisteme başarıyla giriş yapmıştır
    When Kullanıcı ana sayfanın header alanına bakar
    Then Üretimlerim menüsü, hızlı erişim paneli ve profil menüsü aktif ve görünür olmalıdır

  @positive @homepage @gallery
  Scenario: Oda tiplerine göre galeri filtreleme ve Daha Fazla aksiyonu
    Given Kullanıcı ana sayfadaki galeri alanındadır
    When Kullanıcı oda tiplerinden Oturma Odası seçeneğini seçer
    Then Galeri listesi sadece Oturma Odası kategorisine ait tasarımları göstermelidir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut Oturma Odası filtresi korunarak yeni tasarımlar listeye yüklenmelidir

  @positive @homepage @faq
  Scenario: SSS bileşeninde tekil soru açılma kuralı
    Given Kullanıcı ana sayfadaki SSS alanındadır
    When Kullanıcı birinci SSS sorusuna tıklar ve soru açılır
    And Kullanıcı ikinci bir SSS sorusuna tıklar
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır

  @positive @homepage @newsletter
  Scenario: Bülten alanına geçerli e-posta adresi ile başarılı abonelik
    Given Kullanıcı ana sayfadaki bülten alanındadır
    When Kullanıcı bülten input alanına geçerli bir "test@example.com" adresi girer
    And Kullanıcı abonelik butonuna tıklar
    Then Başarılı abonelik olumlu mesajı gösterilmelidir

  @negative @homepage @newsletter
  Scenario Outline: Bülten alanına geçersiz veya boş e-posta adresi girilmesi
    Given Kullanıcı ana sayfadaki bülten alanındadır
    When Kullanıcı bülten input alanına geçersiz "<email>" formatı girer veya alanı boş bırakır
    And Kullanıcı abonelik butonuna tıklar
    Then Uygun bir hata mesajı gösterilmelidir

    Examples:
      | email           |
      | gecersiz-email  |
      |                 |

---

# FEATURE: US_LOG_001 - Kullanıcı Giriş Süreçleri

  Background:
    Given Kullanıcı giriş sayfasındadır

  @positive @login
  Scenario: Kayıtlı kullanıcı ile başarılı e-posta ve şifre girişi
    When Kullanıcı e-posta alanına "kayitli.kullanici@example.com" girer
    And Kullanıcı şifre alanına geçerli şifresini girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı sisteme başarılı bir şekilde giriş yapar ve ana sayfaya yönlendirilir

  @negative @login
  Scenario: Giriş sayfasında zorunlu alanların boş bırakılması
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then E-posta ve şifre alanlarının altında Bu alan zorunludur uyarısı verilmelidir

  @negative @login
  Scenario: Geçersiz e-posta formatı ile giriş denemesi
    When Kullanıcı e-posta alanına "hatali-email-formati" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then E-posta alanında Lütfen geçerli bir e-posta adresi girin hatası dönmelidir

  @negative @security @login
  Scenario Outline: Hatalı şifre veya kayıtlı olmayan e-posta ile genel hata yönetimi
    When Kullanıcı sisteme kayıtlı olmayan "<email>" veya hatalı bir şifre girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcıya spesifik bilgi verilmeden genel bir E-posta veya şifre hatalı mesajı gösterilmelidir

    Examples:
      | email                |
      | olmayan@example.com  |
      | hatali.sifre@test.com|

  @positive @login
  Scenario: Şifre alanında maskeleme ve görünürlük toggle özelliği
    When Kullanıcı şifre alanına bir metin girer
    Then Şifre karakterlerinin maskelenmiş olduğu görülür
    When Kullanıcı şifre alanındaki Göz ikonuna tıklar
    Then Şifre metni görünür hale gelmelidir

  @edge_case @security @login
  Scenario Outline: Şifre alanına tehlikeli girdiler veya aşırı uzun karakter dizisi girilmesi
    When Kullanıcı şifre alanına "<payload>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem bu girdileri güvenle filtrelemeli ve 5xx sunucu hatasına sebep olmamalıdır

    Examples:
      | payload                          |
      | ' OR '1'='1                      |
      | 1000 karakterden oluşan metin    |

---

# FEATURE: US_REG_001 - Yeni Kullanıcı Kayıt Süreçleri

  Background:
    Given Kullanıcı kayıt sayfasındadır

  @positive @register
  Scenario: Yeni ve geçerli bilgilerle başarılı kayıt oluşturma
    When Kullanıcı tüm zorunlu alanları eksiksiz doldurur
    And Kullanıcı şifre olarak en az 8 karakterli geçerli bir şifre girer ve iki alanda eşleştirir
    And Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı kayıt ol butonuna tıklar
    Then Hesap başarıyla oluşturulur ve kullanıcı yönlendirilir

  @negative @register
  Scenario: Kayıt sayfasında zorunlu alanların boş bırakılması
    When Kullanıcı kayıt formundaki alanları boş bırakarak kayıt ol butonuna tıklar
    Then Boş bırakılan alanlar için Bu alan zorunludur uyarısı tetiklenmelidir

  @negative @register
  Scenario: Sistemde halihazırda kayıtlı e-posta ile kayıt denemesi
    When Kullanıcı e-posta alanına sistemde kayıtlı "varolan.kullanici@example.com" adresini girer
    And Diğer zorunlu alanları doldurup kayıt ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısı verilmelidir

  @negative @register
  Scenario: Şifre politikasının ihlali ve şifrelerin uyuşmaması durumu
    When Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer
    And Şifre ve Şifreyi Onayla alanlarına birbirinden farklı değerler girer
    And Kullanıcı kayıt ol butonuna tıklar
    Then Şifreler eşleşmiyor veya ilgili şifre uzunluğu uyarısı dönmelidir

  @negative @register
  Scenario: Yasal sözleşme onay kutucuğu işaretlenmeden kayıt denemesi
    When Kullanıcı tüm alanları geçerli doldurur ancak Kullanıcı Sözleşmesi onay kutucuğunu işaretlemez
    And Kullanıcı kayıt ol butonuna tıklar
    Then Kayıt işlemi engellenmeli ve sözleşmenin onaylanması gerektiği belirtilmelidir

  @positive @register
  Scenario: Kayıt sayfasından Giriş yap veya Google ile devam et seçeneklerine geçiş
    When Kullanıcı Giriş yap linkine tıklar
    Then Kullanıcı giriş sayfasına yönlendirilmelidir
    When Kullanıcı tekrar kayıt sayfasına dönüp Google ile devam et seçeneğine tıklar
    Then Google OAuth kimlik doğrulama akışı tetiklenmelidir