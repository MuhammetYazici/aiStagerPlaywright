Feature: AiStager.ai Platform Temel Modülleri ve Kimlik Doğrulama Yönetimi
  Ziyaretçi veya kayıtlı kullanıcı olarak platformun ana sayfa bileşenlerini kullanabilmeli,
  navigasyon yapabilmeli ve kimlik doğrulama süreçlerini güvenle gerçekleştirebilmeliyim.

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Öncesi ve Sonrası Sihri slider alanının dinamik kontrolü
    Given Kullanıcı ana sayfadadır
    And Kullanıcı Öncesi ve Sonrası Sihri slider alanını görmektedir
    When Kullanıcı sağ ok butonuna veya alt carousel noktalarından birine tıklar
    Then Kullanıcı görsel içeriğin dinamik olarak değiştiğini doğrular

  Scenario: Dil değişimi ile statik metinlerin güncellenmesi
    Given Kullanıcı ana sayfadadır
    And Kullanıcı mevcut dil seçeneğinin TR olduğunu görmektedir
    When Kullanıcı dil seçeneğini EN olarak değiştirir
    Then Kullanıcı tüm statik metinlerin anlık olarak İngilizceye güncellendiğini doğrular

  Scenario: Ziyaretçi Oturum Açılmamış görünüm kuralları
    Given Kullanıcı ana sayfadadır
    And Kullanıcı sistemde oturum açmamış bir ziyaretçidir
    Then Kullanıcı üst menüde Giriş Yap ve Ücretsiz Dene butonlarının görünür olduğunu doğrular
    And Kullanıcı Üretimlerim menüsü ve profil ikonunun gizlenmiş olduğunu doğrular

  Scenario: Oturum Açmış Kullanıcı görünüm kuralları
    Given Kullanıcı sisteme geçerli kimlik bilgileriyle başarıyla giriş yapmıştır
    Then Kullanıcı üst menüde Ürünler, Çözümler, Kaynaklar, Fiyatlandırma menülerinin erişilebilir olduğunu doğrular
    And Kullanıcı Üretimlerim, dil seçimi, Hızlı Render ve Profil menülerinin tam olarak erişilebilir olduğunu doğrular

  Scenario: Sayfa ilk açılışta varsayılan filtre durumu
    Given Kullanıcı ana sayfadaki galeri bölümündedir
    Then Kullanıcı galeri filtrelerinde Tüm Tipler seçeneğinin aktif olduğunu doğrular

  Scenario: Oda tipine göre anlık filtreleme ve daha fazla yükleme
    Given Kullanıcı ana sayfadaki galeri bölümündedir
    When Kullanıcı oda tipi filtresinden Oturma Odası seçeneğini seçer
    Then Kullanıcı galeri içeriğinin anlık olarak Oturma Odası tasarımlarına göre filtrelendiğini doğrular
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Kullanıcı mevcut Oturma Odası filtresini koruyarak alt tarafa yeni kartların yüklendiğini doğrular

  Scenario: Beğeni Kalp ve profil yönlendirmelerinin aktif çalışması
    Given Kullanıcı galeri bölümündeki bir tasarım kartını incelemektedir
    When Kullanıcı tasarım üzerindeki Beğeni Kalp ikonuna tıklar
    Then Kullanıcı beğeni sayısının anlık olarak arttığını doğrular
    When Kullanıcı ilgili kullanıcı profiline tıklar
    Then Kullanıcı profil sayfasına yönlendirildiğini doğrular

  Scenario: SSS akordeonunda aynı anda tek bir başlığın açık kalması
    Given Kullanıcı ana sayfadaki SSS FAQ bölümündedir
    And Kullanıcı 1 numaralı akordeon sorusunu açarak içeriğini görüntülemektedir
    When Kullanıcı 2 numaralı akordeon sorusuna tıklar
    Then Kullanıcı 2 numaralı sorunun açıldığını ve 1 numaralı sorunun otomatik olarak kapandığını doğrular

  Scenario: Geçerli e-posta adresi ile bülten aboneliği Pozitif
    Given Kullanıcı ana sayfanın footer alanındaki bülten kayıt formundadır
    When Kullanıcı bülten alanına geçerli bir "test@example.com" e-posta adresi girer
    And Kullanıcı Abone Ol butonuna tıklar
    Then Kullanıcı "Başarıyla abone oldunuz" başarı mesajını gördüğünü doğrular

  Scenario: Boş veya geçersiz e-posta ile bülten aboneliği Negatif Edge
    Given Kullanıcı ana sayfanın footer alanındaki bülten kayıt formundadır
    When Kullanıcı bülten alanını boş bırakıp veya "gecersiz-email" formatında giriş yapıp Abone Ol butonuna tıklar
    Then Kullanıcı sistemin hata mesajı döndüğünü ve aboneliğin gerçekleşmediğini doğrular

  Scenario: Footer linkleri ve sosyal medya ikonlarının yeni sekmede açılması
    Given Kullanıcı ana sayfanın footer alanındadır
    When Kullanıcı herhangi bir footer linkine veya sosyal medya ikonuna tıklar
    Then Kullanıcı ilgili hedefin tarayıcıda yeni bir sekmede açıldığını doğrular

  Scenario: Kayıt ve Giriş ekranlarında boş zorunlu alanlar Negatif
    Given Kullanıcı Kayıt Ol veya Giriş Yap sayfasındadır
    And Kullanıcı zorunlu alanları E-posta, Şifre vb. boş bırakarak Gönder butonuna tıklamaktadır
    Then Kullanıcı ilgili alanların altında Bu alan zorunludur uyarısının göründüğünü doğrular

  Scenario: Geçersiz e-posta formatı kontrolü Negatif
    Given Kullanıcı Kayıt Ol veya Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına "@" ve domain içermeyen "kullaniciadi" gibi geçersiz bir format girer
    Then Kullanıcı sistemin geçerli bir e-posta formatı uyarısı verdiğini doğrular

  Scenario: Kayıt ol ekranında şifre politikası ihlali Negatif
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı şifre alanına 8 karakterden kısa bir şifre "Ab1!" girer veya Şifreyi Onayla alanı ile eşleşmeyen bir değer girer
    Then Kullanıcı sistemin şifrenin en az 8 karakter olması ve eşleşmesi gerektiğine dair hata uyarısı verdiğini doğrular

  Scenario: Sistemde kayıtlı e-posta ile mükerrer kayıt denemesi Negatif
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı daha önceden sistemde kayıtlı olan "kayitli@example.com" e-posta adresi ile tekrar kayıt olmaya çalışır
    Then Kullanıcı "Bu e-posta adresi zaten kullanımda" hata mesajını aldığını doğrular

  Scenario: Zorunlu kullanıcı sözleşmesi onay kutucuğu Negatif Edge
    Given Kullanıcı Kayıt Ol sayfasındadır
    And Kullanıcı tüm bilgileri eksiksiz doldurduğu halde Kullanıcı Sözleşmesi onay kutucuğunu işaretlememektedir
    When Kullanıcı Kayıt Ol butonuna tıklar
    Then Kullanıcı sözleşmenin onaylanması gerektiğine dair bir uyarı aldığını ve kaydın tamamlanmadığını doğrular

  Scenario: Hatalı şifre veya e-posta ile giriş güvenliği Negatif
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı yanlış e-posta veya yanlış şifre kombinasyonu ile giriş yapmayı dener
    Then Kullanıcı sistemin güvenlik gereği hangi bilginin hatalı olduğunu sızdırmadan genel "E-posta veya şifre hatalı" uyarısı verdiğini doğrular

  Scenario: SQL Injection ve zararlı girdi koruması Güvenlik Edge
    Given Kullanıcı Giriş Yap veya Kayıt Ol sayfasındadır
    When Kullanıcı e-posta veya şifre alanlarına "'; DROP TABLE users;--" gibi SQL Injection veya zararlı script girdileri girer
    Then Kullanıcı sistemin bu girdileri güvenli bir şekilde filtrelediğini, hata verdiğini ve güvenlik zafiyeti oluşturmadığını doğrularştır