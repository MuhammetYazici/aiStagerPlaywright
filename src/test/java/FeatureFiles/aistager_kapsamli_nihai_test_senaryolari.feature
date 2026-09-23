Feature: Epic 1 ve Epic 2 - Ana Sayfa Navigasyon, Medya Yönetimi ve Kimlik Doğrulama

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @US-HP-001
  Scenario: Kaydırıcı çizgisini sağa ve sola sürükleyerek görsel değişimi inceleme
    Given Kullanıcı ana sayfada bulunur ("/tr")
    When Kullanıcı Öncesi ve Sonrası Sihri slider çizgisini sağa doğru sürükler
    Then Sonra mobilyalı oda alanının boyutu dinamik olarak artmalıdır
    When Kullanıcı slider çizgisini sola doğru sürükler
    Then Önce boş oda alanının boyutu dinamik olarak artmalıdır

  @positive @US-HP-001
  Scenario: Carousel okları ve noktaları ile görsel değiştirme
    Given Kullanıcı ana sayfada bulunur ("/tr")
    When Kullanıcı slider altındaki sonraki ok simgesine veya farklı bir carousel noktasına tıklar
    Then İlgili odanın öncesi ve sonrası görselleri yüklenmelidir
    And Tıklanan carousel noktası koyu renk ile aktif olarak işaretlenmelidir

  @positive @US-HP-001
  Scenario: Odanızı Yükleyin butonuna tıklama
    Given Kullanıcı ana sayfada bulunur ("/tr")
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı oda yükleme veya kimlik doğrulama giriş arayüzüne yönlendirilmelidir

  @positive @US-HP-001
  Scenario: Dil seçeneğini değiştirme
    Given Kullanıcı ana sayfada bulunur ("/tr")
    When Kullanıcı dil seçeneğini TR den farklı bir dile örn EN değiştirir
    Then Sayfadaki tüm statik ve dinamik metinler seçilen dile güncellenmelidir

  @positive @US-HP-002
  Scenario: Logoya tıklayarak ana sayfaya yönlendirilme
    Given Kullanıcı alt sayfalardan birindedir
    When Kullanıcı üst menüdeki site logosuna tıklar
    Then Kullanıcı ana sayfaya yönlendirilmeli veya sayfa yenilenmelidir

  @positive @US-HP-002
  Scenario: Ürünler menüsü açılır penceresini dropdown görüntüleme
    Given Kullanıcı ana sayfada bulunur ("/tr")
    When Kullanıcı Ürünler menüsünün üzerine gelir veya tıklar
    Then Alt ürün seçeneklerini içeren açılır menü dropdown açılmalıdır

  @positive @US-HP-002
  Scenario: Oturum açmış kullanıcı için üst menü görünürlüğü
    Given Kullanıcı sistemde oturum açmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Üst menüde Üretimlerim hızlı render paneli ve profil menüsü mor yuvarlak y ikonu görünür olmalıdır

  @positive @US-HP-002
  Scenario: Ziyaretçi oturum açmamış kullanıcı için üst menü görünürlüğü
    Given Kullanıcı sistemde oturum açmamıştır ziyaretçidir
    When Kullanıcı ana sayfayı görüntüler
    Then Üst menüde Üretimlerim ve profil ikonu gizli olmalıdır
    And "Giriş Yap" ve "Ücretsiz Dene" butonları görünür olmalıdır

  @positive @US-HP-003
  Scenario: Sayfa ilk açılışında varsayılan filtre durumu
    Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
    Then "Tüm Tipler" filtresi aktif (mor renkte) olmalıdır
    And Tüm oda tiplerine ait tasarım kartları galeride listelenmelidir

  @positive @US-HP-003
  Scenario: Oda tipine göre filtreleme yapma
    Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
    When Kullanıcı belirli bir oda tipi filtre butonuna tıklar
    Then Galeri yalnızca seçilen kategoriye ait tasarımlarla güncellenmelidir

  @edge @US-HP-003
  Scenario: Filtrelenmiş görünümde Daha Fazla Tasarım Yükle aksiyonu
    Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
    And Kullanıcı spesifik bir oda tipi filtresi seçmiştir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Yüklenen yeni tasarımlar da aktif filtrenin dışına çıkmamalı aynı kategoride olmalıdır

  @positive @US-HP-003
  Scenario: Tasarım kartını beğenme Like
    Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
    When Kullanıcı bir tasarım kartı üzerindeki Kalp ikonuna tıklar
    Then İlgili tasarımın beğeni sayısı anlık olarak 1 artmalıdır
    And Kalp ikonu dolu aktif hale gelmelidir

  @positive @US-HP-004
  Scenario: FAQ akordeon alanında tekli soru açılabilmesi kuralı
    Given Kullanıcı ana sayfadaki FAQ alanındadır
    When Kullanıcı birinci soruya tıklayarak açar
    And Kullanıcı ikinci bir soruya tıklar
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır

  @positive @US-HP-004
  Scenario: Bülten formuna geçerli e-posta ile abone olma
    Given Kullanıcı footer alanındaki bülten formundadır
    When Kullanıcı bülten input alanına geçerli bir e-posta adresi girer "test@example.com"
    And Kullanıcı gönder butonuna tıklar
    Then Başarılı abonelik mesajı Başarıyla abone oldunuz görüntülenmelidir

  @negative @US-HP-004
  Scenario Outline: Bülten formuna geçersiz veya boş giriş yapılması
    Given Kullanıcı footer alanındaki bülten formundadır
    When Kullanıcı bülten input alanına "<gecersiz_email>" girer
    And Kullanıcı gönder butonuna tıklar
    Then Form validasyon hatası tetiklenmeli ve abonelik gerçekleşmemelidir

    Examples:
      | gecersiz_email |
      |                |
      | test-email     |
      | test@.com      |
      | @domain.com    |

  @negative @US-LOG-001
  Scenario Outline: Boş alan bırakılması veya geçersiz e-posta formatı girilmesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "<email>" ve şifre alanına "<sifre>" girer
    And Kullanıcı giriş yap butonuna tıklar
    Then Form gönderimi engellenmeli ve ilgili alan altında zorunluluk veya format uyarısı gösterilmelidir

    Examples:
      | email          | sifre        |
      |                | Password123! |
      | test@          | Password123! |
      | test.com       |              |
      |                |              |

  @negative @US-LOG-001
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi User Enumeration Önlemi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme kayıtlı olmayan bir e-posta veya yanlış şifre girer
    And Kullanıcı giriş yap butonuna tıklar
    Then Sistem genel bir hata mesajı E-posta veya şifre hatalı döndürmelidir

  @positive @US-LOG-001
  Scenario: Şifre alanındaki Göz ikonu ile şifre maskeleme yönetimi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı şifre alanına bir değer yazar
    Then Şifre maskelenmiş gizli olarak görünmelidir
    When Kullanıcı şifre alanının yanındaki Göz ikonuna tıklar
    Then Şifre düz metin olarak görünür hale gelmelidir
    When Kullanıcı tekrar Göz ikonuna tıklar
    Then Şifre tekrar maskelenmelidir

  @edge @US-LOG-001
  Scenario: Güvenlik testi SQL Injection denemeleri
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "' OR '1'='1" ve şifre alanına "' OR '1'='1" girer
    And Kullanıcı giriş yap butonuna tıklar
    Then Sistem zararlı girdiyi güvenli şekilde filtrelemeli giriş başarısız olmalı ve sunucu 500 hatası üretmemelidir

  @negative @US-REG-001
  Scenario Outline: Şifre kuralı ve eşleşmeme kontrolü
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı kayıt formunu doldururken şifreye "<sifre>", şifreyi onayla alanına "<sifre_onay>" girer
    And Kullanıcı kayıt ol butonuna tıklar
    Then "<hata_mesaji>" uyarısı alınmalıdır

    Examples:
      | sifre     | sifre_onay | hata_mesaji                |
      | 123456    | 123456     | En az 8 karakter olmalıdır |
      | Pass123!  | Pass1234!  | Şifreler eşleşmiyor        |

  @negative @US-REG-001
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt olma denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı tüm zorunlu alanları geçerli verilerle doldurur
    And Kullanıcı Kullanıcı Sözleşmesi onay kutucuğunu işaretlemez
    And Kullanıcı kayıt ol butonuna tıklar
    Then Kayıt işlemi gerçekleşmemeli ve sözleşme onaylama uyarısı gösterilmelidir

  @negative @US-REG-001
  Scenario: Sistemde halihazırda kayıtlı bir e-posta ile kayıt olma
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı halihazırda sistemde var olan bir e-posta adresini girer
    And Tüm diğer alanları geçerli doldurup sözleşmeyi onaylar
    And Kullanıcı kayıt ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısı alınmalıdır

  @positive @US-REG-001
  Scenario: Başarılı e-posta ve şifre ile kayıt olma
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı benzersiz geçerli bir e-posta adresi ve kurallara uygun şifre girer
    And Şifreyi Onayla alanına aynı şifreyi yazar
    And Kullanıcı Sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı kayıt ol butonuna tıklar
    Then Hesabınız başarıyla oluşturuldu mesajı alınmalı ve kullanıcı paneline yönlendirilmelidir

  @positive @US-REG-001
  Scenario: Google OAuth kullanarak hızlı kayıt olma
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı Google ile Devam Et butonuna tıklar
    Then Google kimlik doğrulama penceresi açılmalı ve başarılı giriş sonrasında sistemde hesap oluşturularak kullanıcı oturum açmış olmalıdır