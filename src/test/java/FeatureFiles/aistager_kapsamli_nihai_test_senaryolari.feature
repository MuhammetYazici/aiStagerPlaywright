@AiStager_Core @Regression
Feature: AiStager.ai Temel Modüller, Kimlik Doğrulama ve Ana Sayfa Deneyimi
  Platform genelinde ziyaretçi ve kayıtlı kullanıcı deneyimlerinin,
  ana sayfa etkileşimlerinin, galeri filtrelerinin ve kimlik doğrulama süreçlerinin test edilmesi.

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @Homepage @Slider
  Scenario: Öncesi ve Sonrası slider alanının çift yönlü senkronize çalışması
    When Kullanıcı slider üzerindeki orta çizgiyi sağa veya sola sürükler
    Then Önce ve Sonra görselleri pürüzsüz bir şekilde değişir
    And İlgili oda tipine ait carousel noktası aktifleşir

  @Positive @Homepage @Slider
  Scenario: Slider yön okları ve nokta butonları ile görsel değişimi
    When Kullanıcı slider üzerindeki ok veya nokta butonlarına tıklar
    Then Önce ve Sonra görselleri değişir ve ilgili nokta aktifleşir

  @Positive @Navigation @Guest
  Scenario: Ziyaretçi kullanıcının üst menü görünümü
    Given Kullanıcı oturum açmamış bir ziyaretçidir
    Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünür
    And Üretimlerim ve profil ikonu menüde yer almaz

  @Positive @Navigation @Authenticated
  Scenario: Oturum açmış kullanıcının üst menü ve panel erişimi
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    Then Üst menüde ürünler ve çözümler dropdown menüleri görünür
    And Hızlı render ikonu ve profil menüsü aktif olarak görüntülenir
    When Kullanıcı platform logosuna tıklar
    Then Kullanıcı ana sayfaya yönlendirilir

  @Positive @Gallery
  Scenario: Galeri alanında varsayılan filtre ve oda tipi filtreleme
    Given Kullanıcı ana sayfa galeri alanındadır
    Then Varsayılan olarak Tüm Tipler filtresi aktif gelmelidir
    When Kullanıcı Oturma Odası oda tipi filtresini seçer
    Then Liste anlık olarak sadece Oturma Odası tasarımlarını gösterecek şekilde filtrelenir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Seçili olan oda tipi filtresi korunarak yeni tasarım kartları yüklenir

  @Positive @FAQ
  Scenario: SSS alanında aynı anda tek akordeonun açık kalması
    When Kullanıcı SSS alanından bir soruya tıklayarak akordeonu açar
    And Kullanıcı farklı bir soruya tıklar
    Then İlk açılan soru otomatik olarak kapanır
    And Yeni tıklanan soru açılır

  @Positive @Newsletter
  Scenario: Bülten aboneliğinin başarılı bir şekilde tamamlanması
    When Kullanıcı bülten alanına geçerli bir e-posta adresi girer
    And "Abone Ol" butonuna tıklar
    Then Başarılı kayıt yapıldığı yeşil uyarı mesajı ile teyit edilir

  @Negative @Newsletter @EdgeCase
  Scenario: Bülten alanına boş veya geçersiz e-posta girilmesi
    When Kullanıcı bülten alanını boş bırakır veya geçersiz bir e-posta girer
    And "Abone Ol" butonuna tıklar
    Then Form validasyon uyarı mesajı görüntülenir

  @Positive @Login
  Scenario: Kullanıcının geçerli bilgilerle sisteme giriş yapması
    Given Kullanıcı https://aistager.ai/tr/login adresindedir
    And Kullanıcı "/login" sayfasındadır
    When Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer
    And "Giriş Yap" butonuna tıklar
    Then Kullanıcı başarılı bir şekilde panele yönlendirilir

  @Negative @Login @Validation
  Scenario: Giriş sayfasında zorunlu alanların boş bırakılması
    Given Kullanıcı https://aistager.ai/tr/login adresindedir
    And Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak "Giriş Yap" butonuna tıklar
    Then İlgili alanların altında Bu alan zorunludur uyarı mesajı gösterilir

  @Negative @Login @Validation
  Scenario: Giriş sayfasında geçersiz e-posta formatı girilmesi
    Given Kullanıcı https://aistager.ai/tr/login adresindedir
    And Kullanıcı "/login" sayfasındadır
    When Kullanıcı geçersiz formatta bir e-posta adresi girer
    And "Giriş Yap" butonuna tıklar
    Then Geçerli bir e-posta adresi girin uyarı mesajı gösterilir

  @Negative @Login @Security
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi
    Given Kullanıcı https://aistager.ai/tr/login adresindedir
    And Kullanıcı "/login" sayfasındadır
    When Kullanıcı hatalı şifre veya sistemde kayıtlı olmayan bir e-posta girer
    And "Giriş Yap" butonuna tıklar
    Then Sistem güvenlik gereği spesifik bilgi vermeyerek genel bir E-posta veya şifre hatalı uyarısı döner

  @Negative @Login @Security @EdgeCase
  Scenario: Giriş formunda SQL Injection ve zararlı girdilerin filtrelenmesi
    Given Kullanıcı https://aistager.ai/tr/login adresindedir
    And Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta veya şifre alanına SQL Injection karakterleri girer
    And "Giriş Yap" butonuna tıklar
    Then Sistem girdileri filtreler, 500 sunucu hatasına sebep olmaz ve uygun hata mesajı gösterilir

  @Positive @Register
  Scenario: Kullanıcının kurallara uygun bilgilerle hesap oluşturması
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı geçerli bir e-posta adresi girer
    And Kullanıcı en az 8 karakterden oluşan ve birbiriyle eşleşen şifreler girer
    And Kullanıcı sözleşme onay kutucuğunu işaretler
    And "Kayıt Ol" butonuna tıklar
    Then Hesap başarıyla oluşturulur ve yönlendirme gerçekleştirilir

  @Positive @Register @UI
  Scenario: Kayıt olurken şifre maskeleme işlevselliği
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı şifre alanına bir değer yazar ve göz ikonuna tıklar
    Then Şifre karakterleri görünür hale gelir
    When Kullanıcı tekrar göz ikonuna tıklar
    Then Şifre tekrar maskelenir (yıldız veya nokta ile gizlenir)

  @Negative @Register @Validation
  Scenario: Kayıt sayfasında zorunlu alanların eksik bırakılması
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı formu boş bırakarak "Kayıt Ol" butonuna tıklar
    Then İlgili zorunlu alanlarda Bu alan zorunludur uyarı mesajı gösterilir

  @Negative @Register @Validation @EdgeCase
  Scenario: 8 karakterden kısa şifre ile kayıt denemesi
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı 8 karakterden kısa bir şifre girer ve kayıt olmaya çalışır
    Then Sistem şifre uzunluğu kuralı ile ilgili uyarı mesajı gösterilir

  @Negative @Register @Validation
  Scenario: Birbiriyle eşleşmeyen şifrelerle kayıt denemesi
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı Şifre ve Şifreyi Onayla alanlarına farklı değerler girer
    And "Kayıt Ol" butonuna tıklar
    Then Sistem Şifreler eşleşmiyor uyarı mesajını gösterir

  @Negative @Register @Validation
  Scenario: Sözleşme onay kutucuğu işaretlenmeden kayıt denemesi
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı tüm alanları doğru doldurur ancak onay kutucuğunu boş bırakır
    And "Kayıt Ol" butonuna tıklar
    Then Sistem Sözleşmeyi kabul etmelisiniz uyarı mesajını gösterir

  @Negative @Register @Security @EdgeCase
  Scenario: Sistemde zaten kayıtlı olan bir e-posta adresi ile kayıt denemesi
    Given Kullanıcı https://aistager.ai/tr/register adresindedir
    And Kullanıcı "/register" sayfasındadır
    When Kullanıcı halihazırda sistemde kayıtlı olan bir e-posta adresini girer
    And Diğer alanları kurallara uygun doldurarak "Kayıt Ol" butonuna tıklar
    Then Sistem Bu e-posta adresi zaten kullanımda uyarı mesajını gösterir