Feature: AiStager.ai Ana Sayfa Etkileşimleri, Galeri Filtreleme ve Kimlik Doğrulama
  AiStager.ai platformunun temel modüllerinin beklenen iş kurallarına uygun olarak çalışıp çalışmadığını doğrulamak

  Background:
    Given Kullanıcı AiStager.ai platformunun ana sayfasındadır

  @HP @Slider @Positive
  Scenario: Öncesi ve Sonrası Slider etkileşimi
    When Kullanıcı kaydırıcı çizgisini sağa ve sola sürükler
    Then Önce ve Sonra görselleri arasında pürüzsüz geçiş yapılabilmelidir
    And Yön okları veya alt carousel noktaları kullanılarak farklı odalara geçiş yapılabilmelidir

  @HP @Header @Ziyaretci @Positive
  Scenario: Ziyaretçi durumunda Header menü kontrolleri
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfa header alanını inceler
    Then Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üretimlerim ve profil ikonu görünmemelidir

  @HP @Header @OturumAcik @Positive
  Scenario: Oturum açmış kullanıcı durumunda Header menü kontrolleri
    Given Kullanıcı sisteme başarıyla giriş yapmıştır
    When Kullanıcı ana sayfa header alanını inceler
    Then Üretimlerim, hızlı erişim paneli ve profil ikonu aktif ve görünür olmalıdır

  @HP @Header @DilSecimi @Positive
  Scenario: Dil seçeneğinin değiştirilmesi
    When Kullanıcı dil seçeneği menüsüne tıklar
    And Kullanıcı farklı bir dil seçer
    Then Arayüz metinleri seçilen dile göre güncellenmelidir

  @HP @Gallery @Positive
  Scenario: Galeri ilk açılış ve filtreleme
    When Kullanıcı ana sayfa galeri alanına gelir
    Then Tüm Tipler filtresinin aktif olduğunu görür
    When Kullanıcı Oturma Odası oda tipi filtresine tıklar
    Then Galeri anlık olarak filtrelenmeli ve sadece oturma odası kartları listelenmelidir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtre bozulmaksızın yeni kartlar yüklenmelidir

  @HP @Accordion @Positive
  Scenario: SSS bileşeninin çalışması
    When Kullanıcı SSS alanındaki bir soruya tıklar
    Then İlgili yanıt açılır
    When Kullanıcı farklı bir soruya tıklar
    Then Önceki soru otomatik olarak kapanmalı ve yeni soru açılmalıdır

  @HP @Footer @Newsletter @Positive
  Scenario: Bülten alanına geçerli e-posta kaydı
    When Kullanıcı bülten alanına "ornek@email.com" adresini girer
    And Kullanıcı gönder butonuna tıklar
    Then Başarı mesajı görüntülenmelidir

  @HP @Footer @Newsletter @Negative @EdgeCase
  Scenario Outline: Bülten alanına geçersiz veya boş e-posta girişi
    When Kullanıcı bülten alanına "<gecersiz_eposta>" adresini girer
    And Kullanıcı gönder butonuna tıklar
    Then Hata mesajı gösterilmeli ve bülten kaydı yapılmamalıdır

    Examples:
      | gecersiz_eposta |
      |                 |
      | eksik@domain    |
      | hatali.com      |

  @Login @Positive
  Scenario: Başarılı kullanıcı girişi
    Given Kullanıcı login sayfasındadır
    When Kullanıcı geçerli e-posta adresini ve şifresini girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem kimlik doğrulamasını tamamlamalı ve kullanıcıyı ana panele dashboard sayfasına yönlendirmelidir

  @Login @UI @Positive
  Scenario: Şifre görünürlük ikonunun çalışması
    Given Kullanıcı login sayfasındadır
    When Kullanıcı şifre alanına bir değer girer
    And Kullanıcı şifre alanındaki Göz ikonuna tıklar
    Then Şifre metni görünür hale gelmelidir
    When Kullanıcı ikona tekrar tıklar
    Then Şifre tekrar maskelenmelidir

  @Login @Validation @Negative
  Scenario: Giriş formunda boş alan bırakılması
    Given Kullanıcı login sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakır
    And Kullanıcı Giriş Yap butonuna tıklar
    Then İlgili alanlarda Bu alan zorunludur uyarısı gösterilmelidir

  @Login @Validation @Negative
  Scenario: Hatalı e-posta formatı ile giriş denemesi
    Given Kullanıcı login sayfasındadır
    When Kullanıcı e-posta alanına "gecersiz-email" değerini girer
    Then E-posta format uyarısı gösterilmelidir

  @Login @Security @Negative
  Scenario Outline: Yanlış kimlik bilgileri ile giriş denemesi
    Given Kullanıcı login sayfasındadır
    When Kullanıcı "<eposta>" ve "<sifre>" bilgileri ile giriş yapmaya çalışır
    Then Sistem güvenlik nedeniyle genel E-posta veya şifre hatalı hata mesajını döndürmelidir

    Examples:
      | eposta               | sifre         |
      | kayitli@email.com    | YanlisSifre1! |
      | kayitsiz@email.com   | DogruSifre1!  |

  @Login @Security @EdgeCase
  Scenario: Giriş formunda SQL Injection denemeleri
    Given Kullanıcı login sayfasındadır
    When Kullanıcı e-posta alanına "'OR '1'='1" değerini girer
    Then Sistem bu girdileri filtrelemeli ve sunucu hatası vermeden uygun bir validasyon mesajı döndürmelidir

  @Register @Positive
  Scenario: Başarılı yeni kullanıcı kaydı
    Given Kullanıcı register sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta girer
    And Kullanıcı kurallara uygun bir şifre ve şifre onayını girer
    And Kullanıcı sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Sistem yeni hesabı başarıyla oluşturmalıdır

  @Register @Validation @Negative
  Scenario: Zaten kullanımda olan e-posta ile kayıt denemesi
    Given Kullanıcı register sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Kullanıcı gerekli diğer alanları doldurur
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Sistem kaydı engellemeli ve Bu e-posta adresi zaten kullanımda uyarısını göstermelidir

  @Register @Validation @Negative
  Scenario: Minimum karakter sınırının altında şifre oluşturma
    Given Kullanıcı register sayfasındadır
    When Kullanıcı şifre alanına "Ab1!" değerini girer
    Then Sistem şifre politikası validasyon hatası göstermelidir

  @Register @Validation @Negative
  Scenario: Şifrelerin uyuşmaması durumu
    Given Kullanıcı register sayfasındadır
    When Kullanıcı şifre alanına "Sifre123*" değerini girer
    And Kullanıcı Şifreyi Onayla alanına "FarkliSifre456*" değerini girer
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Sistem kaydı engellemeli ve Şifreler eşleşmiyor hata mesajını göstermelidir

  @Register @Validation @Negative @EdgeCase
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt denemesi
    Given Kullanıcı register sayfasındadır
    When Kullanıcı tüm zorunlu alanları doğru doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Sistem kaydı engellemeli ve sözleşme onayı gerektiğini belirten bir uyarı göstermelidir