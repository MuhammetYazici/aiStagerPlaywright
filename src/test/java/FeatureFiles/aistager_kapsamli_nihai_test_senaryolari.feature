@AiStager_Core @Authentication @Homepage
Feature: AiStager.ai Çekirdek Modüller ve Kimlik Doğrulama Akışları
  Platform ziyaretçilerinin ana sayfa etkileşimlerini gerçekleştirebilmesi, 
  bültene kayıt olabilmesi ve kimlik doğrulama süreçlerini 
  güvenli ve hatasız bir şekilde tamamlayabilmesi amaçlanmaktadır.

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @Homepage
  Scenario: Öncesi ve Sonrası kaydırıcısının pürüzsüz çalışması
    Given Kullanıcı https://aistager.ai/tr ana sayfasındadır
    When Kullanıcı Öncesi ve Sonrası Sihri alanındaki iki yönlü kaydırıcıyı sağa ve sola kaydırır
    Then Mobilyalı ve boş oda geçişleri dinamik ve pürüzsüz bir şekilde görüntülenmelidir
    And Sayfa belirteçleri aktif durumu doğru yansıtmalıdır

  @Positive @Homepage @Localization
  Scenario: Çoklu dil desteğinin anlık değişimi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı üst menüden dil seçeneğini EN olarak değiştirir
    Then Sayfadaki tüm statik ve dinamik metinler İngilizce diline anında uyarlanmalıdır

  @Positive @Gallery
  Scenario: Galeri filtreleme ve sonsuz kaydırma uyumu
    Given Kullanıcı Galeri sayfasındadır
    When Kullanıcı Oturm Odası filtresini seçer
    Then Sadece oturum odası tasarımları listelenir
    When Kullanıcı sayfanın sonuna gelip Daha Fazla Tasarım Yükle butonuna tıklar
    Then Oturma Odası filtresi bozulmadan yeni tasarım kartları listeye eklenmelidir

  @EdgeCase @Homepage
  Scenario: Akordeon SSS yapısında aynı anda tek bir başlığın açık kalması
    Given Kullanıcı Sıkça Sorulan Sorular alanındadır
    When Kullanıcı 1 numaralı akordeon başlığına tıklayarak içeriğini açar
    Then 1 numarali soru içeriği görünür olur
    When Kullanıcı 2 numaralı akordeon başlığına tıklar
    Then 2 numaralı soru içeriği açılırken 1 numaralı soru içeriği otomatik olarak kapanmalıdır

  @Positive @Navigation
  Scenario: Ziyaretçi kullanıcı görünüm ve yetkileri
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfayı ziyaret eder
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üretimlerim menüsü ve Profil İkonu sayfada gizli olmalıdır

  @Positive @Navigation
  Scenario: Oturum açmış kullanıcı görünüm ve yetkileri
    Given Kullanıcı geçerli kimlik bilgileriyle sisteme giriş yapmıştır
    When Kullanıcı ana sayfayı ziyaret eder
    Then Header alanında Profil İkonu, Hızlı Render ve Kamera Paneli ile Üretimlerim menüsü aktif olarak görünmelidir

  @Positive @Newsletter
  Scenario: Bülten alanına geçerli e-posta ile başarılı kayıt
    Given Kullanıcı ana sayfadaki bülten kayıt alanındadır
    When Kullanıcı bülten alanına "test.kullanici@example.com" girer ve kayıt butonuna tıklar
    Then Sistem başarılı kayıt için yeşil onay mesajı göstermelidir

  @Negative @Newsletter
  Scenario Outline: Bülten alanına geçersiz e-posta formatı girişi
    Given Kullanıcı ana sayfadaki bülten kayıt alanındadır
    When Kullanıcı bülten alanına "<gecersiz_email>" girer ve kayıt butonuna tıklar
    Then Sistem Geçerli bir e-posta adresi giriniz uyarısını göstermelidir

    Examples:
      | gecersiz_email |
      | bos_deger      |
      | test@          |
      | test.com       |
      | test@com       |

  @Negative @Login
  Scenario: Giriş yap sayfasında zorunlu alan kontrolü
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakıp Giriş Yap butonuna tıklar
    Then E-posta ve şifre alanlarının altında Bu alan zorunludur uyarı mesajı görünmelidir

  @Negative @Login @Security
  Scenario Outline: Hatalı veya kayıtlı olmayan bilgilerle giriş denemesi
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına "<email>" ve şifre alanına "<sifre>" girip Giriş Yap butonuna tıklar
    Then Sistem spesifik bir hata yerine genel E-posta veya şifre hatalı uyarısı dönmelidir

    Examples:
      | email                   | sifre         |
      | kayitli_degil@test.com  | DogruSifre123 |
      | kayitli_user@test.com   | YanlisSifre   |

  @Positive @Login
  Scenario: Şifre alanında maskeleme ve görünürlük kontrolü
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı şifre alanına "GizliSifre123" yazar
    Then Şifre karakterleri maskelenmiş olarak görünmelidir
    When Kullanıcı şifre alanındaki göz ikonuna tıklar
    Then Şifre düz metin olarak okunabilir hale gelmelidir

  @EdgeCase @Login @Security
  Scenario: Giriş sayfasında SQL Injection ve zararlı girdi koruması
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına "'OR '1'='1" ve şifre alanına "'OR '1'='1" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem Internal Server Error hatası üretmemelidir
    And İstek engellenerek genel hata mesajı gösterilmelidir

  @Negative @Register
  Scenario Outline: Zayıf veya eşleşmeyen şifrelerle kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı geçerli bir e-posta girer
    And Kullanıcı şifre alanına "<sifre>" ve şifre onay alanına "<sifre_onay>" girer
    And Kullanıcı sözleşme kutucuğunu işaretleyip Hesap Oluştur butonuna tıklar
    Then Sistem şifre uzunluğu veya eşleşmeme durumuna uygun hata mesajı göstermelidir

    Examples:
      | sifre    | sifre_onay |
      | 12345    | 12345      |
      | Sifre123 | Sifre124   |

  @Negative @Register
  Scenario: Sistemde halihazırda kayıtlı e-posta ile kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı sistemde kayıtlı olan "mevcut_kullanici@test.com" adresini girer
    And Geçerli şifre kurallarına uygun şifre girip sözleşmeyi onaylar ve Hesap Oluştur butonuna tıklar
    Then Sistem Bu e-posta adresi zaten kullanımda hata mesajını döndürmelidir

  @Negative @Register
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı tüm zorunlu alanları geçerli doldurur
    And Kullanıcı "Kullanıcı Sözleşmesi" onay kutucuğunu İŞARETLEMEZ
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Hesap oluşturma işlemi engellenmeli ve sözleşme onaylama uyarısı gösterilmelidir

  @Positive @Register
  Scenario: Google ile Sosyal Medya Entegrasyonu üzerinden kayıt ve giriş
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Sistem ilgili Google OAuth izin penceresini tetiklemelidir