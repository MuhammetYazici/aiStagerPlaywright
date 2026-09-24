Feature: AiStager.ai Ana Sayfa, Navigasyon ve Kimlik Doğrulama Modülleri
  AiStager.ai platformunun ana sayfa etkileşimleri, üst menü navigasyonları 
  ve kimlik doğrulama süreçlerinin doğru çalıştığını doğrulamak.

  Background:
    Given Kullanıcı AiStager.ai ana sayfasındadır

  @positive @homepage
  Scenario: Kullanıcı slider alanında Önce ve Sonra görselleri arasında geçiş yapabilmelidir
    When Kullanıcı slider üzerindeki iki yönlü oku sağa ve sola sürükler
    Then Boş oda Önce ve mobilyalı oda Sonra görselleri arasında pürüzsüz geçiş sağlanmalıdır
    And Kullanıcı carousel üzerindeki nokta butonlarına tıklar
    Then İlgili oda görseli yüklenmeli ve tıklanan nokta görsel olarak vurgulanmalıdır

  @positive @homepage @filters
  Scenario: Galeri ilk açılışta varsayılan filtre ile gelmeli ve dinamik filtrelenebilmelidir
    When Kullanıcı galeri alanına gelir
    Then Tüm Tipler filtresi aktif olmalı ve karışık tasarım kartları listelenmelidir
    When Kullanıcı Oturma Odası oda tipi filtresine tıklar
    Then Galeri dinamik olarak filtrelenmeli ve sadece Oturma Odası tasarımları gösterilmelidir
    When Kullanıcı bir tasarım kartı üzerinden topluluk üyesinin profiline tıklar
    Then İlgili kullanıcının profil sayfasına yönlendirilmelidir
    And Kullanıcı bir kartın kalp ikonuna tıklar
    Then Tasarımın beğeni sayısı artmalıdır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Sayfa yapısı bozulmadan yeni kartlar yüklenmeli ve mevcut filtreler korunmalıdır

  @positive @homepage @faq
  Scenario: SSS akordeon yapısının ve bülten aboneliğinin çalışması
    When Kullanıcı SSS alanından bir soruya tıklar
    Then İlgili sorunun cevabı açılmalıdır
    When Kullanıcı başka bir soruya tıklar
    Then Önceki açık soru otomatik olarak kapanmalı ve yeni soru açılmalıdır
    And Kullanıcı Bize ulaşın veya footer linklerine tıklar
    Then Doğru hedef sayfalara yönlendirilmelidir

  @positive @homepage @newsletter
  Scenario: Bülten alanına geçerli e-posta ile başarılı abonelik
    When Kullanıcı bülten alanına geçerli bir "test@aistager.ai" e-posta adresi girer
    And Kullanıcı abone ol butonuna tıklar
    Then Başarılı abonelik mesajı görüntülenmelidir

  @negative @homepage @newsletter
  Scenario: Bülten alanına boş veya geçersiz e-posta ile hata alınması
    When Kullanıcı bülten alanını boş bırakır veya "gecersiz-eposta" formatı girer
    And Kullanıcı abone ol butonuna tıklar
    Then Geçerli formatta e-posta hatası veya zorunlu alan mesajı gösterilmelidir

  @positive @navigation
  Scenario: Ziyaretçi durumundaki kullanıcının üst menü görünürlüğü
    Given Kullanıcı oturum açmamış bir ziyaretçidir
    Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üretimlerim paneli ve profil ikonu ziyaretçiye gizlenmiş olmalıdır

  @positive @navigation
  Scenario: Oturum açmış kullanıcının üst menü ve panel erişilebilirliği
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı üst menüdeki logo üzerine tıklar
    Then Ana sayfaya yönlendirilmelidir
    And Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Ürünler hover menüsü, sektörel çözümler, kaynaklar ve fiyatlandırma alanları erişilebilir olmalıdır
    And Üretimlerim paneli, hızlı render kamera ayarları ve kullanıcı profil menüsü aktif olmalıdır

  @positive @navigation
  Scenario: Arayüz dilinin değiştirilmesi
    When Kullanıcı dünya ikonlu dil seçeneğinden "TR" seçeneğine tıklar
    Then Arayüz metinleri Türkçe diline uyarlanmalıdır

  @positive @auth @login
  Scenario: Kayıtlı kullanıcı ile başarılı giriş yapma ve şifre görünürlüğü
    Given Kullanıcı Login sayfasındadır
    When Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer
    And Kullanıcı şifre alanındaki göz ikonuna tıklar
    Then Şifre karakterleri görünür hale gelmelidir
    When Kullanıcı giriş yap butonuna tıklar
    Then Kullanıcı başarılı bir şekilde ana panele dashboard yönlendirilmelidir

  @negative @auth @login
  Scenario: Boş alanlar ve geçersiz formatlarla giriş yapma denemesi
    Given Kullanıcı Login sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak giriş yap butonuna tıklar
    Then Bu alan zorunludur hata mesajı gösterilmelidir
    When Kullanıcı hatalı formatta bir e-posta adresi girer
    Then Geçerli e-posta formatı uyarısı gösterilmelidir

  @negative @auth @login @security
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş güvenliği
    Given Kullanıcı Login sayfasındadır
    When Kullanıcı sistemde olmayan e-posta veya yanlış şifre girer
    And Kullanıcı giriş yap butonuna tıklar
    Then Sistem güvenlik amacıyla genel E-posta veya şifre hatalı mesajı dönmelidir
    And SQL enjeksiyon denemeleri filtrelenmelidir

  @positive @auth @register
  Scenario: Yeni kullanıcının başarıyla kayıt olması
    Given Kullanıcı Register sayfasındadır
    When Kullanıcı geçerli bir e-posta adresi girer
    And Kullanıcı en az 8 karakterli birbiriyle eşleşen şifreler girer
    And Kullanıcı zorunlu sözleşme onay kutusunu seçer
    And Kullanıcı kayıt ol butonuna tıklar
    Then Kullanıcı başarıyla kayıt olabilmelidir

  @negative @auth @register
  Scenario: Zaten kayıtlı e-posta ile kayıt olma denemesi
    Given Kullanıcı Register sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Diğer tüm alanları geçerli doldurup kayıt ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısı verilmelidir

  @edgecase @auth @register
  Scenario: Kayıt olurken şifre eşleşmemesi ve sözleşme onayı eksikliği
    Given Kullanıcı Register sayfasındadır
    When Kullanıcı geçerli e-posta ve en az 8 karakterli birbiriyle eşleşmeyen şifreler girer
    And Kullanıcı sözleşmeyi onaylamaz
    And Kullanıcı kayıt ol butonuna tıklar
    Then Şifrelerin eşleşmediği ve sözleşmenin onaylanması gerektiği validasyon hataları gösterilmelidir

  @positive @auth @oauth
  Scenario: Google OAuth entegrasyonu ile devam etme
    Given Kullanıcı Login veya Register sayfasındadır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Google OAuth kimlik doğrulama penceresi tetiklenmelidir