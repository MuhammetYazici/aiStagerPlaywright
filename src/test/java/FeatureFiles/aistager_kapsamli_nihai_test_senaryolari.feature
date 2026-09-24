@AiStager @AnaSayfa @KimlikDogrulama @Navigasyon
Feature: AiStager.ai Platformu Keşfi, Navigasyon ve Kimlik Doğrulama
  Kullanıcı olarak platformu keşfetmek, ana sayfa araçlarını kullanmak,
  güvenli bir şekilde giriş yapmak veya üye olmak istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  @Pozitif @Slider
  Scenario: Öncesi ve Sonrası slider alanının pürüzsüz çalışması
    Given Kullanıcı "AiStager.ai" ana sayfasındadır
    When Kullanıcı Öncesi ve Sonrası Sihri kaydırıcısını sağa ve sola sürükler
    Then Önce boş oda ve Sonra mobilyalı oda görselleri pürüzsüz ve orantılı şekilde görünmelidir
    Then "Önce" (boş oda) ve "Sonra" (mobilyalı oda) görselleri pürüzsüz ve orantılı şekilde görünmelidir

  @Pozitif @Carousel
  Scenario: Carousel ve navigasyon okları ile sayfa belirteçlerinin çalışması
    When Kullanıcı slider altındaki sağ yön okuna tıklar
    Then Farklı bir odaya ait görsel aktif olmalı ve ilgili sayfa belirteç noktası koyu renkli duruma gelmelidir

  @Pozitif @AksiyonVeDil
  Scenario: Odanızı Yükleyin butonu yönlendirmesi ve dil değişimi
    When Kullanıcı dil seçeneğini Türkçe olarak değiştirir
    Then Sayfadaki tüm metinler anlık olarak Türkçe olarak güncellenmelidir
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı işlem arayüzü sayfasına yönlendirilmelidir

  @Pozitif @Ziyaretci
  Scenario: Ziyaretçi kullanıcının üst menü görünürlüğü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfasını açar
    Then Sağ üst köşede Giriş Yap ve mavi renkli Ücretsiz Dene butonları görünmelidir
    And Üretimlerim ve profil ikonu ekranda görünmemelidir

  @Pozitif @OturumAcikKullanici
  Scenario: Oturum açmış kullanıcının üst menü görünürlüğü
    Given Kullanıcı sisteme başarıyla giriş yapmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Logo, "Ürünler" dropdown menüsü, "Çözümler", "Kaynaklar", "Fiyatlandırma", "Üretimlerim" görünmelidir
    Then Logo Ürünler dropdown menüsü Çözümler Kaynaklar Fiyatlandırma Üretimlerim görünmelidir
    And Dil seçeneği hızlı render kamera ayarları ve profil ikonu eksiksiz erişilebilir olmalıdır

  @Pozitif @GaleriFiltre
  Scenario: Topluluk tasarımları galeri filtrelemesi ve sonsuz kaydırma
    Given Kullanıcı Topluluk Tasarımları galerisindedir ve varsayılan olarak Tüm Tipler aktiftir
    When Kullanıcı Oturma Odası filtre seçeneğine tıklar
    Then Galeri sadece Oturma Odası tipine ait içerikleri listelemelidir
    When Kullanıcı bir tasarımın kalp beğeni ikonuna tıklar
    Then Kalp ikonu dolu hale gelmeli ve sayaç 1 artmalıdır
    And Kullanıcı Daha Fazla Tasarım Yükle butonuna tıkladığında mevcut filtre korunarak yeni kartlar yüklenmelidir
    When Kullanıcı bir tasarımın kullanıcı adının üzerine tıklar
    Then İlgili kullanıcının profil sayfasına yönlendirilmelidir

  @Pozitif @Akordeon
  Scenario: SSS Akordeon bileşeninin tekli açık kalma kuralı
    Given Kullanıcı Sıkça Sorulan Sorular bölümündedir
    When Kullanıcı Soru 1 başlığına tıklar
    Then Soru 1 cevabı açılmalı ve ok yukarı yönelmelidir
    When Kullanıcı Soru 2 başlığına tıklar
    Then Soru 2 cevabı açılmalı ve Soru 1 otomatik olarak kapanmalıdır

  @Pozitif @Footer @Bulten
  Scenario: Bülten formuna geçerli e-posta girişi ve footer linkleri
    Given Kullanıcı sayfanın footer altbilgi bölümündedir
    When Kullanıcı bülten formuna geçerli bir e-posta adresi girer ve gönder butonuna tıklar
    Then Başarı mesajı görüntülenmelidir
    When Kullanıcı Gizlilik yasal linkine tıklar
    Then İlgili sayfa yeni sekmede açılmalıdır

  @Negatif @Footer @Bulten
  Scenario: Bülten formuna geçersiz veya boş e-posta girişi
    Given Kullanıcı sayfanın footer altbilgi bölümündedir
    When Kullanıcı bülten formunu boş bırakarak gönder butonuna tıklar veya geçersiz bir e-posta girer
    Then Validasyon hata mesajı alınmalıdır

  @Pozitif @Login
  Scenario: Başarılı kullanıcı girişi ve şifre maskeleme
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer
    And Kullanıcı şifre alanındaki Göz ikonuna tıklar
    Then Şifre metni görünür hale gelmelidir
    When Kullanıcı tekrar Göz ikonuna tıklar
    Then Şifre metni maskelenmelidir
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı ana panele dashboard yönlendirilmelidir

  @Pozitif @Login @Entegrasyon
  Scenario: Şifremi unuttum ve Google ile devam et entegrasyonları
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı Şifremi unuttum bağlantısına tıklar
    Then Şifre sıfırlama ekranına yönlendirilmelidir
    When Kullanıcı Giriş Yap sayfasına dönüp Google ile devam et butonuna tıklar
    Then Google kimlik doğrulama penceresi açılmalıdır

  @Negatif @Login @Validasyon
  Scenario: Giriş sayfasında boş alan ve geçersiz e-posta validasyonları
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then İlgili alanlar için Bu alan zorunludur uyarısı alınmalıdır
    When Kullanıcı e-posta alanına gecersisformat gibi hatalı bir format girer
    Then Lütfen geçerli bir e-posta adresi girin uyarısı gösterilmelidir

  @Negatif @Login @Guvenlik
  Scenario: Hatalı şifre, kayıtlı olmayan e-posta ve zararlı girdi testleri
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı kayıtlı olmayan e-posta veya hatalı şifre kombinasyonu girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Güvenlik gereği genel bir E-posta veya şifre hatalı mesajı dönülmelidir
    When Kullanıcı e-posta alanına SQL Injection karakterleri girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem çökmeden bu girdileri filtrelemeli ve hata mesajı döndürmelidir

  @Pozitif @Register
  Scenario: Başarılı kullanıcı kaydı ve Google ile kayıt
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı daha önce kullanılmamış benzersiz bir e-posta adresi girer
    And Kullanıcı en az 8 karakterli ve birbiriyle eşleşen şifreler girer
    And Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcı panele yönlendirilmelidir
    When Kullanıcı Kayıt Ol sayfasında Google ile devam et seçeneğini kullanır
    Then Google ile hızlı kayıt süreci başlatılmalıdır

  @Negatif @Register @Validasyon
  Scenario: Kayıt sayfasında zorunlu alan, e-posta formatı ve sözleşme eksikliği
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı tüm alanları boş bırakarak Kayıt Ol butonuna tıklar
    Then Bu alan zorunludur uyarıları gösterilmelidir
    When Kullanıcı geçersiz bir e-posta adresi ve şifre girer ancak sözleşme kutucuğunu işaretlemez
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sözleşmeyi kabul etmelisiniz uyarısı tetiklenmelidir

  @Negatif @Register @EdgeCase
  Scenario: Kayıt sayfasında mükerrer e-posta, kısa şifre ve şifre uyuşmazlığı
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısı verilmelidir
    When Kullanıcı 8 karakterden kısa bir şifre girer
    Then Şifre uzunluk uyarısı gösterilmelidir
    When Kullanıcı şifre ve şifre tekrarı alanlarına birbiriyle eşleşmeyen değerler girer
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Şifreler eşleşmiyor uyarısı ekranda belirmelidir