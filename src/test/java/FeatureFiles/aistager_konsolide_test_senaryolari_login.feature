Feature: Ana Sayfa Etkileşimleri ve Navigasyon Yönetimi
  Kullanıcıların ana sayfadaki slider, menü, galeri, SSS ve bülten formunu 
  sorunsuz bir şekilde kullanabilmesini test eder.

  @positive @slider
  Scenario: Slider ve Carousel bileşenlerinin pürüzsüz çalışması
    Given Kullanıcı ana sayfada "Öncesi ve Sonrası sihri" alanındadır
    When Kaydırıcı çizgisi sağa ve sola sürüklenir veya oklar ile alt noktalar tıklanır
    Then Görseller pürüzsüz geçiş yapmalı, ilgili oda görselleri yüklenmeli ve aktif nokta koyu renge dönüşmelidir

  @positive @header
  Scenario: Giriş yapmamış ziyaretçi için header menü kontrolü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Üst menü (Header) öğeleri incelenir
    Then "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Oturum gerektiren "Üretimlerim" linki ve profil ikonu gösterilmemelidir

  @positive @gallery
  Scenario: Topluluk tasarımları galerisinde filtreleme ve sayfalama
    Given Kullanıcı topluluk tasarımları galerisindedir
    When Belirli bir oda tipi filtresi seçilir
    And "Daha Fazla Tasarım Yükle" butonuna basılır
    Then Galeri sadece seçilen filtreye ait yeni tasarımları yüklemelidir
    And Beğeni (Kalp) sayısı anlık olarak güncellenmelidir

  @positive @faq
  Scenario: SSS akordeon bileşeninin tekli açık kalma kuralı
    Given SSS bölümünde bir soru halihazırda açık durumdadır
    When Farklı bir soru başlığına tıklanır
    Then Önceki açık soru otomatik olarak kapanmalı ve yeni tıklanan sorunun cevabı açılmalıdır

  @positive @newsletter
  Scenario: Bülten formuna geçerli e-posta ile abone olma
    Given Kullanıcı footer alanındaki bülten formundadır
    When Geçerli bir e-posta adresi girilip "Abone Ol" butonuna tıklanır
    Then "Başarıyla abone oldunuz" başarı mesajı gösterilmelidir

  @negative @newsletter @edge-case
  Scenario Outline: Bülten formuna geçersiz veya boş e-posta girişi
    Given Kullanıcı footer alanındaki bülten formundadır
    When "<Email>" değeri girilip "Abone Ol" butonuna tıklanır
    Then Uygun bir hata mesajı gösterilmeli ve abonelik gerçekleştirilmemelidir

    Examples:
      | Email            |
      |                  |
      | gecersiz-email   |
      | test@domain      |

Feature: Kullanıcı Kimlik Doğrulama ve Hesap Yönetimi
  Kullanıcıların sisteme güvenli bir şekilde giriş yapabilmesini, 
  yeni hesap oluşturabilmesini ve ilgili validasyonları test eder.

  @positive @login
  Scenario: Başarılı kullanıcı girişi
    Given Kullanıcı "/login" sayfasındadır ve geçerli kimlik bilgilerine sahiptir
    When E-posta ve şifre alanlarına geçerli bilgiler girilip "Giriş Yap" butonuna tıklanır
    Then Sistem kullanıcıyı doğrular ve ana panele (dashboard) yönlendirir

  @negative @login @edge-case
  Scenario Outline: Giriş sayfasında hatalı bilgi veya boş alan kontrolü
    Given Kullanıcı "/login" sayfasındadır
    When E-posta alanına "<Email>" ve şifre alanına "<Password>" girilip "Giriş Yap" butonuna tıklanır
    Then "E-posta veya şifre hatalı" veya ilgili zorunlu alan uyarı mesajı ekranda görüntülenmelidir
    And Giriş işlemi engellenmelidir

    Examples:
      | Email                  | Password     |
      |                        |              |
      | test@example.com       |              |
      |                        | Secret123!   |
      | yanlis@example.com     | YanlisSifre1 |
      | ' OR 1=1 --            | ' OR 1=1 --  |

  @positive @register
  Scenario: Başarılı yeni hesap oluşturma
    Given Kullanıcı "/register" sayfasındadır ve sistemde kayıtlı olmayan bir e-postaya sahiptir
    When E-posta ve kurallara uygun şifre alanları doldurulur
    And "Kabul ediyorum" sözleşme onay kutucuğu işaretlenir
    And "Hesap Oluştur" butonuna tıklanır
    Then Hesap başarıyla oluşturulur ve kullanıcı aktivasyon ekranına veya panoya yönlendirilir

  @negative @register @edge-case
  Scenario Outline: Kayıt ekranında validasyon ve kural ihlalleri
    Given Kullanıcı "/register" sayfasındadır
    When Kayıt formuna e-posta olarak "<Email>", şifre olarak "<Password>", şifre onay olarak "<ConfirmPassword>" girilir
    And Sözleşme kutucuğu "<ContractStatus>" durumunda bırakılır
    And "Hesap Oluştur" butonuna tıklanır
    Then İlgili hata mesajı ("<ExpectedError>") gösterilerek kayıt engellenmelidir

    Examples:
      | Email            | Password | ConfirmPassword | ContractStatus | ExpectedError                               |
      |                  | Secret12 | Secret12        | işaretli       | Bu alan zorunludur / Geçerli e-posta girin  |
      | test@example.com | kısa     | kısa            | işaretli       | Şifre en az 8 karakter olmalıdır            |
      | test@example.com | Pass1234 | Pass9999        | işaretli       | Şifreler eşleşmiyor                         |
      | test@example.com | Pass1234 | Pass1234        | işaretsiz      | Kullanım şartlarını kabul etmelisiniz       |

  @negative @register
  Scenario: Mükerrer (Daha önce kayıtlı) e-posta ile hesap açma engeli
    Given Kullanıcı "/register" sayfasındadır
    And Sistemde halihazırda kayıtlı olan bir "mevcut@example.com" e-posta adresi vardır
    When Bu e-posta adresi, geçerli şifre ve onay kutucuğu işaretli şekilde kayıt olunmak istenir
    Then "Bu e-posta adresi zaten kullanımda" uyarısı dönülmeli ve yeni hesap oluşturulmamalıdır

  @positive @register @ui
  Scenario: Şifre görünürlüğü ve OAuth entegrasyonu kontrolü
    Given Kullanıcı "/login" veya "/register" sayfasındadır
    When Şifre alanındaki "Göz" ikonuna tıklanır
    Then Şifre maskelenmiş metinden düz metne dönüşmeli (veya tam tersi) olmalıdır
    When "Google ile devam et" butonuna tıklanır
    Then Harici OAuth kimlik doğrulama akışı başlatılmalıdır