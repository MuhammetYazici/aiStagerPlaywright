Feature: AiStager.ai Ana Sayfa, Kimlik Doğrulama ve Kayıt Modülleri

  @Home @Slider @Positive
  Scenario: Kullanıcı ana sayfadaki Öncesi ve Sonrası slider alanını interaktif olarak yönetebilmelidir
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı slider üzerindeki sağ ok ikonuna tıkladığında veya resmi sağa sürüklediğinde
    Then Boş oda Önce görselinden mobilyalı oda Sonra görseline pürüzsüz bir geçiş olmalıdır
    And Kullanıcı alt kısımdaki carousel noktalarına tıkladığında ilgili görsellere dinamik olarak geçiş yapabilmelidir

  @Home @Header @DynamicUI
  Scenario: Ziyaretçi konumundaki kullanıcı için üst menü öğelerinin görüntülenmesi
    Given Ziyaretçi AiStager.ai ana sayfasındadır
    When Ziyaretçi üst menüyü incelediğinde
    Then Logo, Ürünler, Çözümler, Kaynaklar, Fiyatlandırma ve Dil Seçimi menüleri görünür olmalıdır
    And Giriş Yap ve Ücretsiz Dene butonları aktif ve erişilebilir olmalıdır

  @Home @Header @DynamicUI
  Scenario: Oturum açmış kullanıcı için üst menü öğelerinin dinamik olarak değişmesi
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı AiStager.ai ana sayfasına gittiğinde
    Then Giriş Yap ve Ücretsiz Dene butonları yerine Üretimlerim ve Profil ve Ayarlar ikonları görünür olmalıdır

  @Home @Gallery @Filtering @Positive
  Scenario: Topluluk galerisinde oda tipine göre filtreleme yapılması ve etkileşimler
    Given Kullanıcı AiStager.ai ana sayfasındaki Topluluk Galerisi alanındadır
    When Kullanıcı oda tipi filtresinden Oturma Odası seçeneğine tıkladığında
    Then Galeri listesi anında filtrelenmeli ve sadece Oturma Odası tasarımlarını göstermelidir
    When Kullanıcı bir tasarım kartı üzerindeki kalp ikonuna tıkladığında
    Then Tasarımın beğeni sayısı artmalı ve ikon aktif hale gelmelidir
    And Kullanıcı Daha Fazla Tasarım Yükle butonuna tıkladığında sonsuz kaydırma veya sayfalama ile yeni tasarımlar yüklenmelidir

  @Home @Accordion @FAQ
  Scenario: Sıkça Sorulan Sorular alanında aynı anda yalnızca bir akordeon başlığının açık kalması
    Given Kullanıcı ana sayfadaki Sıkça Sorulan Sorular bölümündedir
    When Kullanıcı birinci akordeon başlığına tıklayarak soruyu açtığında
    Then Birinci sorunun içeriği görünür olmalıdır
    When Kullanıcı ikinci bir akordeon başlığına tıkladığında
    Then İkinci sorunun içeriği açılmalı ve önceden açık olan birinci soru otomatik olarak kapanmalıdır

  @Home @Footer @Newsletter @EdgeCase
  Scenario: Bülten aboneliğine geçerli e-posta adresi ile kayıt olma
    Given Kullanıcı ana sayfanın footer alanındadır
    When Kullanıcı bülten alanına geçerli bir "test@example.com" adresi girer ve abone ol butonuna tıklar
    Then E-postanın başarıyla kaydedildiğine dair onay mesajı gösterilmelidir

  @Home @Footer @Newsletter @EdgeCase
  Scenario Outline: Bülten aboneliğine geçersiz veya boş e-posta girilmesi
    Given Kullanıcı ana sayfanın footer alanındadır
    When Kullanıcı bülten alanına "<GecersizEmail>" girer ve abone ol butonuna tıklar
    Then Sistem net bir uyarı mesajı üretmelidir

    Examples:
      | GecersizEmail |
      |               |
      | eksik-email   |
      | @domain.com   |

  @Home @Footer @EdgeCase
  Scenario: Footer linklerinin doğru yönlendirmesi
    Given Kullanıcı ana sayfanın footer alanındadır
    When Kullanıcı gizlilik politikaları veya sosyal medya ikonlarından birine tıkladığında
    Then İlgili sayfa doğru hedef URL'de yeni bir sekmede açılmalıdır

  @Login @Positive
  Scenario: Kayıtlı geçerli bilgilerle başarılı giriş yapılması ve şifre maskelemesi
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı geçerli e-posta adresini ve şifresini ilgili alanlara yazar
    And Kullanıcı şifre alanındaki göz ikonuna tıkladığında şifrenin karakterleri görünür olmalı, tekrar tıkladığında maskelenmelidir
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarılı bir şekilde sisteme giriş yapmalı ve Dashboard sayfasına yönlendirilmelidir

  @Login @Negative @Security
  Scenario: Giriş formunda boş bırakılan zorunlu alanların kontrolü
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then Zorunlu alanlar için Bu alan zorunludur uyarı mesajları gösterilmelidir

  @Login @Negative @Security
  Scenario Outline: Hatalı e-posta formatı ile giriş denemesi
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta alanına "<HataliFormat>" girer ve Giriş Yap butonuna tıklar
    Then Sistem uygun bir e-posta format uyarısı göstermelidir

    Examples:
      | HataliFormat |
      | testuser     |
      | test@.com    |

  @Login @Negative @Security
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile genel hata mesajı alınması
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı sisteme kayıtlı olmayan bir e-posta veya kayıtlı e-posta için yanlış şifre girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Güvenlik gereği sistem ipucu vermeden genel bir E-posta veya şifre hatalı mesajı döndürmelidir

  @Login @Negative @Security
  Scenario: Giriş alanlarında SQL Injection ve uzun karakter dizisi güvenliği
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta alanına "' OR '1'='1" veya çok uzun karakter dizileri girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem güvenlik filtrelerinden geçmeli, SQL Injection engellenmeli ve uygulama 500 hatası vermemelidir

  @Register @Positive @OAuth
  Scenario: Benzersiz e-posta ve kurallara uygun şifre ile yeni hesap oluşturulması
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı benzersiz bir e-posta adresi ve en az 8 karakterli kurallara uygun bir şifre girer
    And Kullanıcı zorunlu sözleşme onay kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Yeni hesap başarıyla oluşturulmalı ve kullanıcı yönlendirilmelidir

  @Register @Positive @OAuth
  Scenario: Google OAuth entegrasyonu ile kayıt olma
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı Google ile devam et seçeneğine tıklar
    Then Google kimlik doğrulama penceresi açılmalı ve başarılı onay sonrası kullanıcı sisteme kaydedilmelidir

  @Register @Negative @Validation
  Scenario: Kayıt formunda eksik alanlar ve onaylanmamış sözleşmeler
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı tüm alanları boş bırakarak veya sözleşme onay kutucuğunu işaretlemeden Kayıt Ol butonuna tıklar
    Then Sistem Bu alan zorunludur ve Sözleşmeyi kabul etmelisiniz hata mesajlarını üretmelidir

  @Register @Negative @Validation
  Scenario: Sistemde halihazırda var olan e-posta adresi ile kayıt denemesi
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı halihazırda sistemde kayıtlı olan bir e-posta adresi girer ve diğer bilgileri doldurup Kayıt Ol butonuna tıklar
    Then Sistem Bu e-posta adresi zaten kullanımda uyarısını dönmelidir

  @Register @Negative @Validation
  Scenario: Şifre ve Şifreyi Onayla alanlarının uyuşmaması
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı Şifre alanına "Password123" ve Şifreyi Onayla alanına "Different123" girer
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sistem şifrelerin eşleşmediğini belirterek kayıt işlemini engellemelidir