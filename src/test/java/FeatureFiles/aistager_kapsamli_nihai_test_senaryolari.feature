# language: tr
Feature: US-AI-001 - Ana Sayfa, Kimlik Doğrulama ve Genel Navigasyon

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @homepage
  Scenario: Görsel karşılaştırma slider'ının sorunsuz çalışması
    When Kullanıcı Önce Sonra görsel karşılaştırma slider çubuğunu sağa ve sola sürükler
    Then Görsel boyutları ve slider çubuğu pürüzsüz bir şekilde hareket etmelidir

  @positive @homepage
  Scenario: Dil seçeneğinin değiştirilmesi
    When Kullanıcı dil menüsünden TR seçeneğini seçer
    Then Tüm ana sayfa metinleri dinamik olarak Türkçe olarak güncellenmelidir

  @positive @homepage
  Scenario: Galeri filtreleme ve daha fazla tasarım yükleme
    When Kullanıcı galeriden Oturma Odası filtresini seçer
    Then Sadece Oturma Odası kategorisine ait tasarım kartları listelenmelidir
    And Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut Oturma Odası filtresi korunarak liste genişletilmelidir

  @positive @homepage
  Scenario: SSS bileşeninin tekli açık kalma kuralı
    When Kullanıcı SSS bölümünden birinci soruyu açar
    Then Birinci soru açık ve içeriği görünür olmalıdır
    When Kullanıcı ikinci bir soruyu açar
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır

  @positive @navigation
  Scenario: Ziyaretçi durumunda üst menü görünürlüğü
    Given Kullanıcı sisteme giriş yapmamıştır Ziyaretçi
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir
    And Üst menüde Üretimlerim menüsü ve profil ikonu gizli olmalıdır

  @positive @navigation
  Scenario: Oturum açmış kullanıcı durumunda üst menü görünürlüğü
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    Then Üst menüde ürün, çözüm, kaynak ve fiyatlandırma linkleri aktif olmalıdır
    And Hızlı render paneli, Üretimlerim ve profil menüleri erişilebilir olmalıdır

  @positive @footer
  Scenario: Bülten alanına geçerli e-posta ile abone olma
    When Kullanıcı bülten alanına geçerli bir "test@ornek.com" e-posta adresi girer
    And Bülten gönder butonuna tıklar
    Then Başarılı abonelik mesajı görüntülenmelidir

  @negative @footer @edge_case
  Scenario Outline: Bülten alanına geçersiz veya boş e-posta girilmesi
    When Kullanıcı bülten alanına "<gecersiz_eposta>" girer
    And Bülten gönder butonuna tıklar
    Then Form gönderimi engellenmeli ve uygun hata mesajı gösterilmelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | test@           |
      | test.com        |
      | @ornek.com      |

  @negative @login @edge_case
  Scenario: Giriş formunda zorunlu alanların boş bırakılması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak giriş yapmaya çalışır
    Then Bu alan zorunludur uyarı mesajları gösterilmelidir

  @negative @login @edge_case
  Scenario Outline: Giriş formunda hatalı e-posta formatı girilmesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "<hatali_eposta>" girer
    Then Lütfen geçerli bir e-posta adresi girin hata mesajı gösterilmelidir

    Examples:
      | hatali_eposta |
      | yanlisformat  |
      | test@@com     |

  @negative @login
  Scenario: Kayıtlı olmayan veya hatalı şifre ile giriş denemesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı geçerli formatta fakat sisteme kayıtlı olmayan "olmayan@ornek.com" ve "YanlisSifre123" girer
    And Giriş yap butonuna tıklar
    Then Güvenlik nedeniyle genel E-posta veya şifre hatalı mesajı dönülmelidir

  @negative @login @security
  Scenario: Giriş ekranında SQL enjeksiyonu koruması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "admin' OR '1'='1" girer
    And Giriş yap butonuna tıklar
    Then Sistem çökmemeli 500 hatası alınmamalı ve giriş engellenerek hata mesajı gösterilmelidir

  @positive @register
  Scenario: Başarılı kullanıcı kaydı oluşturma
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı geçerli bir e-posta girer
    And Şifre alanına kurallara uygun en az 8 karakterli "GuvenliSifre1*" girer
    And Şifreyi Onayla alanına aynı şifreyi tekrar yazar
    And Kullanıcı sözleşmesi onay kutucuğunu işaretler
    And Kayıt ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve yönlendirme yapılmalıdır

  @negative @register @edge_case
  Scenario Outline: Kayıt olurken zayıf veya eşleşmeyen şifre girilmesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı şifre olarak "<sifre>" ve onay için "<sifre_onay>" girer
    And Kayıt ol butonuna tıklar
    Then Şifre kuralları veya eşleşmeme durumuna uygun hata mesajı gösterilmelidir

    Examples:
      | sifre       | sifre_onay  |
      | kisa1!      | kisa1!      |
      | Sifre1234   | FarkliSifre |

  @negative @register
  Scenario: Sistemde zaten kayıtlı olan e-posta ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı daha önce kayıt olmuş bir e-posta adresi girer
    And Tüm zorunlu alanları doldurup kayıt ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda hata mesajı gösterilmelidir

  @negative @register @edge_case
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt olma denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı tüm zorunlu kayıt alanlarını doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
    And Kayıt ol butonuna tıklar
    Then Sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir

  @positive @auth
  Scenario: Şifre alanındaki Göz ikonu işlevselliği
    Given Kullanıcı şifre değiştirme sayfasındadır
    When Kullanıcı şifre alanına gizli metin girer
    And Şifre alanının yanındaki Göz ikonuna tıklar
    Then Şifre metni görünür hale gelmelidir
    When Kullanıcı tekrar Göz ikonuna tıklar
    Then Şifre metni tekrar maskelenmiş gizli duruma gelmelidir

  @positive @auth
  Scenario: Google ile devam et OAuth entegrasyonu
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı Google ile Devam Et butonuna tıklar
    Then Kullanıcı Google kimlik doğrulama ekranına başarılı bir şekilde yönlendirilmelidir