Feature: Ana Sayfa Etkileşimleri ve Navigasyon
  Kullanıcılar ana sayfadaki slider, üst menü, galeri, SSS ve footer bileşenleriyle sorunsuz bir şekilde etkileşime girebilmelidir.

  Scenario: Öncesi ve Sonrası görselleri arasında pürüzsüz geçiş yapma (Pozitif)
    Given Kullanıcı ana sayfada "Önce ve Sonra" slider alanındadır
    When Kullanıcı kaydırıcı çizgisini sağa ve sola sürükler
    Then "Önce" (boş oda) ve "Sonra" (mobilyalı oda) görselleri arasında pürüzsüz geçiş sağlanmalıdır

  Scenario: Yön okları ve alt carousel noktaları ile farklı oda görselleri yükleme (Pozitif)
    Given Kullanıcı slider alanındadır
    When Kullanıcı yön oklarına tıklar veya alt carousel noktalarından birini seçer
    Then Farklı odalara ait yeni görseller yüklenmelidir

  Scenario: Ziyaretçi rolü için header görünümü (Pozitif)
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfayı ziyaret eder
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görünür olmalıdır

  Scenario: Oturum açmış kullanıcı rolü için header görünümü (Pozitif)
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı ana sayfayı ziyaret eder
    Then Header alanında "Üretimlerim" ve profil ikonu yer almalıdır

  Scenario: Üst menü linklerinin doğru yönlendirmesi (Pozitif)
    Given Kullanıcı ana sayfadadır
    When Kullanıcı "Ürünler", "Çözümler", "Kaynaklar" veya "Fiyatlandırma" linklerine sırayla tıklar
    Then İlgili hedeflenen sayfalara yönlendirilmelidir

  Scenario: Galeri tasarımlarını filtreleme ve beğenme (Pozitif)
    Given Kullanıcı "Topluluk Tasarımları Galerisi" bölümündedir
    When Kullanıcı "Oturma Odası" filtresini seçer
    And Bir tasarım kartı üzerindeki kalp ikonuna tıklar
    Then Tasarımlar filtrelenmeli ve kalp ikonu beğenildi durumuna geçmelidir

  Scenario: Sayfa yenilenmeden yeni tasarım kartları yükleme (Pozitif)
    Given Kullanıcı galeri alanının alt kısmındadır
    When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Sayfa yenilenmeden yeni tasarım kartları listeye eklenmelidir

  Scenario: SSS akordeon menüsünün tekli açık kalma kuralı (Pozitif)
    Given Kullanıcı SSS bölümündedir
    When Kullanıcı bir soruya tıklayarak açar
    And Ardından farklı bir yeni soruya tıklar
    Then Yeni soru açılmalı ve önceki soru otomatik olarak kapanmalıdır

  Scenario: SSS içinden destek sayfasına yönlendirme (Pozitif)
    Given Kullanıcı SSS bölümündedir
    When Kullanıcı metin içindeki "Bize ulaşın" linkine tıklar
    Then Kullanıcı destek sayfasına yönlendirilmelidir

  Scenario: Geçerli e-posta ile bülten aboneliği (Pozitif)
    Given Kullanıcı footer bölümündedir
    When Kullanıcı bülten alanına geçerli bir e-posta adresi girer ve abone ol butonuna tıklar
    Then Aboneliğin başarılı olduğuna dair onay mesajı görülmelidir

  Scenario: Geçersiz e-posta formatı ile bülten aboneliği (Negatif / Edge Case)
    Given Kullanıcı footer bölümündedir
    When Kullanıcı bülten alanına "@gecersis" gibi geçersiz bir e-posta formatı girer ve abone ol butonuna tıklar
    Then Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı dönmelidir

  Scenario: Footer linkleri ve sosyal medya yönlendirmeleri (Pozitif)
    Given Kullanıcı footer bölümündedir
    When Kullanıcı yasal metin linklerine, footer menü linklerine ve sosyal medya ikonlarına tıklar
    Then Her biri doğru hedef sayfaya veya harici sosyal medya hesabına yönlendirmelidir

Feature: Kullanıcı Girişi
  Kayıtlı kullanıcılar sisteme e-posta ve şifre ile veya alternatif yöntemlerle güvenli bir şekilde giriş yapabilmelidir.

  Scenario: Kayıtlı geçerli bilgilerle başarılı giriş (Pozitif)
    Given Kullanıcı giriş sayfasındadır ("/login")
    When Kullanıcı geçerli bir e-posta adresi ve şifre girer
    And Giriş yap butonuna tıklar
    Then Kullanıcı ana panele (dashboard) yönlendirilmelidir

  Scenario: Şifre alanındaki "Göz" ikonu ile maskeleme ve metin gösterimi (Pozitif)
    Given Kullanıcı şifre alanına bir değer girmiştir ve şifre maskelenmiştir ("•" ile)
    When Kullanıcı "Göz" ikonuna tıklar
    Then Şifre metni açık olarak görünmelidir
    When Kullanıcı tekrar "Göz" ikonuna tıklar
    Then Şifre tekrar maskelenmiş hale gelmelidir

  Scenario Outline: Zorunlu alanların boş bırakılması (Negatif)
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı "<E-posta>" ve "<Şifre>" alanlarını boş bırakarak giriş yapmaya çalışır
    Then Alanın altında "Bu alan zorunludur" hata mesajı görünmelidir

    Examples:
      | E-posta          | Şifre        |
      |                  | ValidPass123 |
      | test@example.com |              |
      |                  |              |

  Scenario: Hatalı e-posta formatı girilmesi (Negatif)
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "hatali-format" yazar ve giriş yapmaya çalışır
    Then Sistem geçerli bir e-posta formatı uyarısı gösterilmelidir

  Scenario Outline: Yanlış şifre veya kayıtlı olmayan e-posta ile giriş denemesi (Negatif / Güvenlik)
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı "<E-posta>" ve "<Şifre>" ile giriş yapmayı dener
    Then Sistem güvenlik nedeniyle spesifik bilgi vermeden genel bir "E-posta veya şifre hatalı" mesajı göstermelidir

    Examples:
      | E-posta                 | Şifre          |
      | kayitli@example.com     | YanlisSifre123 |
      | kayitliolmayan@test.com | DogruSifre123  |

  Scenario Outline: Kötü niyetli girdilerin ve aşırı uzun karakterlerin filtrelenmesi (Edge Case / Güvenlik)
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta veya şifre alanına "<ZararliGirdi>" girer
    And Giriş yap butonuna tıklar
    Then Sistem sunucu hatası (500) üretmeden isteği reddetmeli ve uygun bir hata mesajı döndürmelidir

    Examples:
      | ZararliGirdi                                           |
      | ' OR '1'='1                                            |
      | <script>alert('hack')</script>                         |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa... (500 char) |

  Scenario: Google ile devam et seçeneğinin çalışması (Pozitif)
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı "Google ile devam et" butonuna tıklar
    Then Google OAuth kimlik doğrulama penceresi tetiklenmelidir

Feature: Yeni Hesap Oluşturma
  Ziyaretçiler sistemde yeni bir hesap oluşturabilmeli, validasyonlardan ve mükerrer kayıt kontrollerinden geçebilmelidir.

  Scenario: Kurallara uygun bilgilerle başarılı kayıt olma (Pozitif)
    Given Kullanıcı kayıt ol sayfasındadır ("/register")
    When Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta adresi girer
    And En az 8 karakterden oluşan güçlü bir şifre belirler ve şifreyi onaylar
    And Kullanıcı sözleşmesi onay kutucuğunu seçer
    And "Kayıt Ol" butonuna tıklar
    Then Kullanıcı başarıyla kaydedilmeli ve aktivasyon veya ana panele yönlendirilmelidir

  Scenario: Şifre ve Şifreyi Onayla alanlarının uyuşmaması (Negatif)
    Given Kullanıcı kayıt ol sayfasındadır
    When Kullanıcı "Şifre" alanına "Password123" yazar
    And "Şifreyi Onayla" alanına farklı bir değer olan "Password456" yazar
    And Kayıt olma işlemini tetikler
    Then Sistem "Şifreler eşleşmiyor" uyarısı vermelidir

  Scenario: Sistemde halihazırda var olan e-posta ile kayıt denemesi (Negatif / Edge Case)
    Given Sistemde kayıtlı olan bir "mevcut@example.com" e-posta adresi bulunmaktadır
    When Kullanıcı kayıt sayfasında bu e-posta adresini girer
    And Gerekli diğer alanları doldurup kayıt olmaya çalışır
    Then Sistem "Bu e-posta adresi zaten kullanımda" hatası dönmelidir

  Scenario: Sözleşme onay kutucuğu seçilmeden kayıt olmaya çalışılması (Negatif)
    Given Kullanıcı kayıt ol sayfasında tüm zorunlu metin alanlarını kurallara uygun doldurmuştur
    When Kullanıcı sözleşme onay kutucuğunu işaretlemeden "Kayıt Ol" butonuna tıklar
    Then Kayıt işlemi tamamlanmamalı ve sözleşmenin onaylanması gerektiğine dair uyarı verilmelidir

  Scenario: Kayıt sayfasından Giriş yap ve Google ile kayıt akışına geçiş (Pozitif)
    Given Kullanıcı kayıt ol sayfasındadır
    When Kullanıcı "Giriş yap" bağlantısına tıklar
    Then Giriş sayfasına ("/login") yönlendirilmelidir
    When Kullanıcı tekrar kayıt sayfasına dönüp "Google ile devam et" seçeneğine tıklar
    Then Google ile hızlı kayıt (OAuth) akışı tetiklenmelidir