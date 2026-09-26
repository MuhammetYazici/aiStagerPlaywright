İstediğiniz eksik adımlar ilgili senaryolara, mevcut hiçbir adımı bozmadan veya değiştirmeden doğru sıra ve birebir metinlerle eklenmiştir. İşte senaryonun TAM ve eksiksiz hali:

```gherkin
Feature: AiStager.ai Çekirdek Modüller ve Kimlik Doğrulama Süreçleri

  Background:
    Given Kullanıcı AiStager.ai ana sayfasındadır

  Scenario: Pozitif - Öncesi ve Sonrası Slider alanında sürükleme ve nokta ile geçiş yapılması
    When Kullanıcı Öncesi ve Sonrası Sihri slider alanındaki sürükleme çubuğunu sağa ve sola sürükler
    Then Mobilyalı ve boş oda görselleri arasında pürüzsüz geçiş sağlanmalıdır
    When Kullanıcı slider altındaki carousel noktalarından birine tıklar
    Then İlgili görsel seti ekranda hatasız görüntülenmelidir

  Scenario: Sınır Durumu - Dil değişiminin slider ve sayfa metinlerine etkisi
    When Kullanıcı dil seçeneğini alternatif bir dille değiştirir
    Then Sayfadaki tüm metinler ve slider açıklamaları seçilen dile güncellenmelidir

  Scenario: Pozitif - Ziyaretçi durumunda header menü görünürlüğü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üretimlerim bağlantısı ve profil ikonu gizli olmalıdır

  Scenario: Pozitif - Oturum açmış kullanıcı durumunda header menü fonksiyonelliği
    Given Kullanıcı kimlik doğrulaması yaparak sisteme giriş yapmıştır
    Then Header alanında Logo, Ürünler Dropdown, Çözümler, Kaynaklar, Fiyatlandırma görünmelidir
    And Üretimlerim, Dil seçici, Hızlı Render ve Profil menüleri tam fonksiyonel olarak yer almalıdır

  Scenario: Pozitif - Varsayılan galeri görünümü ve filtreleme
    When Kullanıcı topluluk galerisi alanına gider
    Then Tüm Tipler filtresi varsayılan olarak aktif olmalıdır
    When Kullanıcı farklı bir oda tipi filtresine tıklar
    Then Galeri anında seçilen oda tipine göre filtrelenmelidir

  Scenario: Pozitif - Daha Fazla Tasarım Yükle aksiyonu
    Given Kullanıcı belirli bir oda tipine göre filtreleme yapmıştır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtre korunarak alt alta yeni tasarım kartları yüklenmelidir
    And Tasarım kartlarındaki Beğeni Kalp ve kullanıcı profili yönlendirmeleri çalışmalıdır

  Scenario: Pozitif - SSS akordeon yapısının tekli çalışması
    When Kullanıcı SSS bölümünden bir başlığa tıklayarak yanıtı açar
    Then İlgili SSS yanıtı görünür hale gelmelidir
    When Kullanıcı farklı ikinci bir SSS başlığına tıklar
    Then İkinci başlığın yanıtı açılırken, ilk açılan SSS başlığı otomatik olarak kapanmalıdır

  Scenario: Pozitif - Geçerli e-posta ile bülten aboneliği
    When Kullanıcı bülten alanındaki e-posta inputuna geçerli bir e-posta adresi girer
    And "Abone Ol" butonuna tıklar
    Then Sistem başarılı kayıt için yeşil onay mesajı göstermelidir

  Scenario Outline: Negatif - Geçersiz veya boş e-posta ile bülten aboneliği
    When Kullanıcı bülten inputuna "<gecersiz_eposta>" girer
    And "Abone Ol" butonuna tıklar
    Then Sistem net bir hata mesajı göstermelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | testuser        |
      | test@.com       |
      | @domain.com     |

  Scenario: Pozitif - Başarılı kullanıcı girişi
    Given Kullanıcı login sayfasındadır
    When Kullanıcı geçerli bir e-posta ve şifre girer
    And "Giriş Yap" butonuna tıklar
    Then Kullanıcı başarıyla sisteme giriş yaparak yönlendirilmelidir

  Scenario: Pozitif - Başarılı yeni hesap oluşturma
    Given Kullanıcı register sayfasındadır
    When Kullanıcı geçerli bir e-posta, en az 8 karakterden oluşan bir şifre girer
    And Şifreyi Onayla alanına aynı şifreyi tekrar yazar
    And Kullanıcı sözleşmesi onay kutucuğunu işaretler
    And "Kayıt Ol" butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve onay mesajı gösterilmelidir

  Scenario: Pozitif - Şifre maskeleme ve Google OAuth
    Given Kullanıcı login veya register sayfasındadır
    When Kullanıcı şifre alanına bir değer yazar
    And Şifre alanının yanındaki Göz ikonuna tıklar
    Then Şifre karakterleri düz metin olarak görünür olmalıdır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Google OAuth kimlik doğrulama penceresi tetiklenmelidir

  Scenario Outline: Negatif - Login ve Register zorunlu alan ve format validasyonları
    Given Kullanıcı "<sayfa>" sayfasındadır
    When Kullanıcı zorunlu alanları boş bırakarak gönder butonuna tıklar
    Then Bu alan zorunludur uyarı mesajı görünmelidir

    Examples:
      | sayfa     |
      | login     |
      | register  |

  Scenario: Negatif - Yanlış şifre veya kayıtlı olmayan e-posta ile giriş
    Given Kullanıcı login sayfasındadır
    When Kullanıcı sisteme kayıtlı olmayan e-posta veya yanlış şifre kombinasyonu girer
    And "Giriş Yap" butonuna tıklar
    Then Sistem güvenlik gereği genel tipte E-posta veya şifre hatalı uyarısı vermelidir

  Scenario: Negatif - Kayıt ekranı şifre uyumsuzluğu ve min karakter kontrolü
    Given Kullanıcı register sayfasındadır
    When Kullanıcı 8 karakterden az bir şifre girer veya eşleşmeyen şifre onayı yazar
    And "Kayıt Ol" butonuna tıklar
    Then Şifrenin en az 8 karakter olması gerektiği veya eşleşmediğine dair hata mesajı alınmalıdır

  Scenario: Negatif - Kayıt ekranında eksik sözleşme onayı
    Given Kullanıcı register sayfasındadır
    When Kullanıcı tüm alanları doğru doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
    And "Kayıt Ol" butonuna tıklar
    Then Sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir

  Scenario: Sınır Durumu - Güvenlik testleri ve uzun karakter girdileri
    Given Kullanıcı login veya register sayfasındadır
    When Kullanıcı input alanlarına SQL Injection karakterleri veya aşırı uzun karakter dizileri girer
    And İşlem butonuna tıklar
    Then Sistem girdileri güvenle filtrelemeli ve Internal Server Error hatası yerine uygun form validasyon uyarısı dönmelidir