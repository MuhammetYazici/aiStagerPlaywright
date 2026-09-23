@AiStager @US-AI-001
Feature: AiStager.ai Temel Modüller, Ana Sayfa, Kimlik Doğrulama ve Navigasyon
  Kullanıcıların ana sayfayı deneyimlemesi, header yetkilendirmelerini görmesi,
  galeri/akordeon/bülten ile etkileşime geçmesi ve kimlik doğrulama işlemlerini
  güvenli ve kurallara uygun şekilde yapabilmesi.

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @Homepage @Slider
  Scenario: Öncesi ve Sonrası Slider bileşeninin interaktif çalışması
    Given Kullanıcı ana sayfadadır ve /tr adresindedir
    When Kullanıcı Öncesi ve Sonrası Sihri slider çubuğunu iki yönlü sürüklerse veya ok alt nokta butonlarına tıklarsa
    Then Görseller pürüzsüz şekilde boyutlanmalı ve senkronize olarak değişmelidir

  @Positive @Homepage @Localization
  Scenario: Dil seçeneğinin anlık olarak değişmesi
    Given Kullanıcı ana sayfadadır ve /tr adresindedir
    When Kullanıcı dil seçeneğini EN olarak değiştirirse
    Then Sayfadaki tüm statik metinler anında İngilizce diline uyarlanmalıdır

  @Positive @Header @Visitor
  Scenario: Ziyaretçi durumunda header görünürlük kuralları
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfayı ziyaret ederse
    Then Header alanında Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üretimlerim ve profil ikonu menüsü gizli olmalıdır

  @Positive @Header @Member
  Scenario: Kayıtlı kullanıcı durumunda header görünürlük kuralları
    Given Kullanıcı sisteme başarıyla giriş yapmış kayıtlı bir üyedir
    When Kullanıcı ana sayfayı ziyaret ederse
    Then Header alanında logo ürünler çözümler kaynaklar fiyatlandırma görünür olmalıdır
    And Üretimlerim hızlı render paneli dil seçeneği ve profil menüsü aktif olmalıdır

  @Positive @Gallery
  Scenario: Galeri ilk açılış ve oda tipi filtreleme
    Given Kullanıcı ana sayfa galeri alanındadır
    When Galeri ilk yüklendiğinde
    Then Varsayılan olarak Tüm Tipler filtresi seçili gelmelidir
    When Kullanıcı Oturma Odası oda tipi filtresine tıklarsa
    Then Galeri listesi dinamik olarak sadece oturma odası tasarımlarını gösterecek şekilde filtrelenmelidir

  @Positive @Gallery
  Scenario: Beğeni aksiyonunun anlık yansıması
    Given Kullanıcı galeri alanındaki bir tasarım kartını incelemektedir
    When Kullanıcı tasarım üzerindeki Beğeni Kalp ikonuna tıklarsa
    Then Beğeni sayısı anlık olarak bir artmalı ve ikon aktif duruma gelmelidir

  @Positive @Gallery @EdgeCase
  Scenario: Filtre state i korunarak daha fazla tasarım yükleme
    Given Kullanıcı galeri alanında Oturma Odası filtresini seçmiştir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklarsa
    Then Mevcut Oturma Odası filtre state i bozulmadan listeye yeni tasarım kartları eklenmelidir

  @Positive @Accordion
  Scenario: Sıkça Sorulan Sorular akordeonunun tekli çalışması
    Given Kullanıcı Sıkça Sorulan Sorular SSS alanındadır
    When Kullanıcı bir akordeon başlığına tıklayarak açarsa
    And Kullanıcı farklı bir akordeon başlığına tıklarsa
    Then Yeni tıklanan başlık açılmalı ve önceden açık olan akordeon başlığı otomatik olarak kapanmalıdır

  @Positive @Newsletter
  Scenario: Bülten kaydının geçerli e-posta ile yapılması
    Given Kullanıcı bülten kayıt alanındadır
    When Kullanıcı geçerli bir e-posta adresi girip bülten kayıt butonuna tıklarsa
    Then Başarılı abonelik mesajı gösterilmelidir

  @Negative @Newsletter @EdgeCase
  Scenario Outline: Bülten kaydının boş veya geçersiz e-posta ile engellenmesi
    Given Kullanıcı bülten kayıt alanındadır
    When Kullanıcı bülten alanına "<GecersizEposta>" girip kayıt butonuna tıklarsa
    Then Sistem bülten kaydını engellemeli ve uygun hata mesajı göstermelidir

    Examples:
      | GecersizEposta |
      |                |
      | testuser       |
      | test@          |
      | @domain.com    |

  @Positive @Login
  Scenario: Başarılı kullanıcı girişi
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı geçerli e-posta adresini ve şifresini girer
    And "Giriş Yap" butonuna tıklarsa
    Then Sistem kullanıcıyı başarıyla ana panele Dashboard yönlendirmelidir

  @Negative @Login @Validation
  Scenario Outline: Giriş sayfasında zorunlu alan validasyonları
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına "<Eposta>" ve şifre alanına "<Sifre>" girer
    And "Giriş Yap" butonuna tıklarsa
    Then Sistem Bu alan zorunludur hata mesajını göstermelidir

    Examples:
      | Eposta           | Sifre       |
      |                  | ValidPass123|
      | test@example.com |             |
      |                  |             |

  @Negative @Login @Security
  Scenario: Hatalı giriş denemelerinde User Enumeration engelleme Generic Hata
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan bir e-posta veya yanlış şifre girer
    And "Giriş Yap" butonuna tıklarsa
    Then Sistem güvenlik gereği generic E-posta veya şifre hatalı mesajını göstermelidir

  @Negative @Register @Validation
  Scenario Outline: Kayıt olurken eksik veya geçersiz alan validasyonları
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı kayıt formunu e-posta "<Eposta>", şifre "<Sifre>", şifre onay "<SifreOnay>", sözleşme onay <SozlesmeOnay> ile doldurur
    And Kayıt ol butonuna tıklarsa
    Then Sistem ilgili validasyon hata mesajını göstermelidir "<HataMesaji>"

    Examples:
      | Eposta           | Sifre       | SifreOnay   | SozlesmeOnay | HataMesaji                  |
      |                  | ValidPass12 | ValidPass12 | true         | Bu alan zorunludur          |
      | test@example.com | short1      | short1      | true         | min 8 karakter              |
      | test@example.com | Pass12345   | Different9  | true         | şifre eşleşmiyor            |
      | test@example.com | ValidPass12 | ValidPass12 | false        | Kullanıcı Sözleşmesi zorunlu|
      | invalid-email    | ValidPass12 | ValidPass12 | true         | Geçerli e-posta zorunludur  |

  @Negative @Register @EdgeCase
  Scenario: Sistemde kayıtlı e-posta ile tekrar kayıt olmayı engelleme
    Given Kullanıcı /register sayfasındadır
    And Sistemde halihazırda kayıtlı bir existing@example.com e-posta adresi bulunmaktadır
    When Kullanıcı existing@example.com adresi ve geçerli diğer bilgilerle kayıt olmaya çalışırsa
    Then Sistem zaten kullanımda hata mesajını dönmeli ve kaydı engellemelidir

  @Positive @UI @PasswordMask
  Scenario: Şifre alanlarında göz ikonu ile maskeleme kontrolü
    Given Kullanıcı /login veya /register sayfasındadır
    When Kullanıcı şifre alanına bir metin girer ve şifre maskeleme Göz ikonuna tıklarsa
    Then Header alanında logo, ürünler, çözümler, kaynaklar, fiyatlandırma görünür olmalıdır
    And Şifre karakterleri düz metin olarak görünür olmalıdır
    When Kullanıcı Göz ikonuna tekrar tıklarsa
    Then Şifre karakterleri maskelenmiş yıldız nokta hale gelmelidir