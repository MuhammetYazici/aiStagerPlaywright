Feature: AiStager.ai Ana Sayfa, Navigasyon, Galeri ve Kimlik Doğrulama Yönetimi
  Kullanıcıların ana sayfayı keşfetmesi, filtreleme yapması, bültene abone olması
  ve sisteme kayıt olup giriş yapabilmesi süreçlerini test eder.

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @slider
  Scenario: Öncesi ve Sonrası Slider alanının pürüzsüz çalışması
    Given Kullanıcı Öncesi ve Sonrası Sihri alanındadır
    When Kullanıcı slider çubuğunu sağa ve sola sürükler
    Then Önce ve Sonra görsellerinin boyutları dinamik ve pürüzsüz şekilde değişmelidir

  @positive @slider
  Scenario Outline: Slider yön okları ve carousel noktaları ile görsel değiştirme
    Given Kullanıcı slider alanındadır
    When Kullanıcı slider alanındaki <etkileşim> tıklar
    Then İlgili oda görseli yüklenmelidir
    And Aktif olan carousel noktası koyu renk ile görsel olarak vurgulanmalıdır

    Examples:
      | etkileşim |
      | sağ yön oku |
      | sol yön oku |
      | alt carousel noktası |

  @positive @navigation
  Scenario: Odanızı Yükleyin butonunun yönlendirmesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı görsel yükleme veya kimlik doğrulama ekranına yönlendirilmelidir

  @positive @localization
  Scenario: Dil seçeneğinin değiştirilmesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı dil seçeneğini "TR" olarak ayarlar
    Then Sayfadaki tüm statik metinler seçilen dile güncellenmelidir

  @positive @header
  Scenario: Oturum açmış kullanıcının header menüsünü görmesi
    Given Kullanıcı sisteme oturum açmış durumdadır
    When Kullanıcı ana sayfayı görüntüler
    Then Header üzerinde Logo, Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil Seçeneği, Hızlı Render Ayarları ve Profil İkonu yer almalıdır
    And Header üzerinde Giriş Yap ve Ücretsiz Dene butonları yer almamalıdır

  @positive @header
  Scenario: Ziyaretçi kullanıcının header menüsünü görmesi
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfayı görüntüler
    Then Header üzerinde Üretimlerim ve Profil alanları yer almamalıdır
    And Header üzerinde Giriş Yap ve Ücretsiz Dene butonları görünmelidir

  @positive @header
  Scenario: Header logo ve menü linklerinin yönlendirmesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header üzerindeki Logo ögesine tıklar
    Then Kullanıcı "/tr" adresine yönlendirilmelidir
    When Kullanıcı Ürünler veya Çözümler veya Kaynaklar veya Fiyatlandırma linklerinden birine tıklar
    Then Kullanıcı ilgili alt sayfaya yönlendirilmelidir

  @positive @gallery
  Scenario: Galeri ilk açılış durumu ve varsayılan filtre
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Topluluk Galerisi alanına kaydırır
    Then Tüm Tipler filtresi varsayılan olarak aktif ve mor renkli olmalıdır
    And Galeri karışık oda tasarımlarını listelemelidir

  @positive @gallery
  Scenario: Oda tipi filtreleme butonlarının çalışması
    Given Kullanıcı Topluluk Galerisi alanındadır
    When Kullanıcı farklı bir oda tipi filtre butonuna tıklar
    Then Tıklanan buton aktifleşmelidir
    And Galeri sadece ilgili oda tipine ait tasarımları filtrelemelidir

  @positive @gallery
  Scenario: Tasarım kartı kullanıcı adı ve beğeni etkileşimi
    Given Kullanıcı Topluluk Galerisi alanındadır
    When Kullanıcı bir tasarım kartı üzerindeki kullanıcı adına tıklar
    Then Kullanıcı ilgili profil sayfasına yönlendirilmelidir
    When Kullanıcı aynı kart üzerindeki Kalp ikonuna tıklar
    Then Beğeni sayısı 1 artmalı ve kalp ikonu aktif hale gelmelidir

  @positive @gallery
  Scenario: Daha fazla tasarım yükleme
    Given Kullanıcı Topluluk Galerisi alanındadır ve tasarımlar listelenmektedir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtreleme bozulmadan alt alta yeni tasarım kartları yüklenmelidir

  @positive @faq
  Scenario: SSS akordeon yapısının çalışması
    Given Kullanıcı Sıkça Sorulan Sorular alanındadır
    When Kullanıcı bir soruya tıklar
    Then İlgili cevap açılmalı ve soru oku yukarı bakmalıdır
    When Kullanıcı farklı bir başka soruya tıklar
    Then Önceki soru otomatik olarak kapanmalı ve yeni soru açılmalıdır

  @positive @faq
  Scenario: Bize ulaşın linkinin yönlendirmesi
    Given Kullanıcı Sıkça Sorulan Sorular alanındadır
    When Kullanıcı Bize ulaşın linkine tıklar
    Then Kullanıcı destek ve iletişim sayfasına yönlendirilmelidir

  @positive @newsletter
  Scenario: Bültene geçerli e-posta ile abone olma
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı bülten alanına "test@example.com" e-posta adresini girer
    And Abone Ol butonuna tıklar
    Then Başarı mesajı gösterilmelidir

  @negative @newsletter @edge-case
  Scenario Outline: Bültene boş veya geçersiz e-posta ile abone olma denemesi
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı bülten alanına "<gecersiz_eposta>" girer
    And Abone Ol butonuna tıklar
    Then Geçerli bir e-posta adresi giriniz hata mesajı gösterilmelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | testuser        |
      | test@.com       |
      | @domain.com     |

  @positive @footer
  Scenario: Footer kurumsal linkler ve sosyal medya yönlendirmeleri
    Given Kullanıcı footer alanındadır
    When Kullanıcı Gizlilik Politikası veya Kullanım Şartları yasal metin linklerine tıklar
    Then İlgili yasal sayfalar açılmalıdır
    When Kullanıcı sosyal medya ikonlarına tıklar
    Then İlgili sosyal medya hesapları yeni sekmede açılmalıdır

  @positive @login
  Scenario: Kayıtlı geçerli bilgilerle başarılı giriş yapma ve şifre görünürlüğü
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı sisteme kayıtlı geçerli e-postasını ve şifresini girer
    And Şifre alanındaki Göz ikonuna tıklar
    Then Şifrenin düz metin olarak görünür olduğu doğrulanır
    When Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı panele yönlendirilmelidir

  @negative @login @edge-case
  Scenario: Giriş formunda boş bırakılan zorunlu alanlar
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakıp Giriş Yap butonuna tıklar
    Then Zorunlu alanlar için Bu alan zorunludur uyarı mesajı gösterilmelidir

  @negative @login @edge-case
  Scenario Outline: Giriş formunda geçersiz e-posta formatı
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına "<gecersiz_format>" girer ve şifreyi doldurur
    And Giriş Yap butonuna tıklar
    Then Uygun format uyarısı gösterilmelidir

    Examples:
      | gecersiz_format |
      | user.com        |
      | user@domain     |
      | user@@domain.com|

  @negative @login @security
  Scenario Outline: Hatalı kimlik bilgileri ile tutarlı hata mesajı
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı "<eposta>" ve "<sifre>" bilgilerini girer
    And Giriş Yap butonuna tıklar
    Then Sistem spesifik bilgi sızdırmadan E-posta veya şifre hatalı genel hata mesajını göstermelidir

    Examples:
      | eposta               | sifre             |
      | kayitli@domain.com   | yanlissifre       |
      | kayitliolmayan@d.com | dogrusifre        |
      | kayitli@domain.com   | yanlisKombinasyon |

  @negative @login @security @edge-case
  Scenario: Giriş formunda SQL Injection ve uzun karakter girdileri testi
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı e-posta alanına SQL Injection karakterleri girer
    And Giriş Yap butonuna tıklar
    Then Sistem bu girdileri güvenli şekilde filtrelemelidir
    And Sunucu hatası üretilmeden uygun hata mesajı dönülmelidir

  @positive @register
  Scenario: Yeni ve geçerli bilgilerle başarılı kayıt olma
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan yeni bir e-posta adresi girer
    And En az 8 karakterli eşleşen güçlü şifreleri Şifre ve Şifre Tekrar alanlarına girer
    And Kullanım sözleşmesi onay kutusunu işaretler
    And Kayıt Ol butonuna tıklar
    Then Başarılı kayıt oluşturularak aktivasyon veya panele yönlendirme yapılmalıdır

  @negative @register @edge-case
  Scenario Outline: Kayıt formunda eksik ve hatalı veri girdileri
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı kayıt formunu şu verilerle doldurur: e-posta "<eposta>", şifre "<sifre>", şifre tekrar "<sifre_tekrar>", sözleşme onay durumu "<sozlesme_onay>"
    And Kayıt Ol butonuna tıklar
    Then İlgili "<hata_mesaji>" tetiklenmeli ve kayıt engellenmelidir

    Examples:
      | eposta             | sifre    | sifre_tekrar | sozlesme_onay | hata_mesaji                       |
      |                    | Pass1234 | Pass1234     | true          | Bu alan zorunludur                |
      | gecersiz-eposta    | Pass1234 | Pass1234     | true          | Geçerli bir e-posta adresi giriniz|
      | mevcut@domain.com  | Pass1234 | Pass1234     | true          | Bu e-posta adresi zaten kullanımda|
      | yeni@domain.com    | 12345    | 12345        | true          | En az 8 karakter olmalıdır        |
      | yeni@domain.com    | Pass1234 | Pass5678     | true          | Şifreler eşleşmiyor               |
      | yeni@domain.com    | Pass1234 | Pass1234     | false         | Bu alan zorunludur                |

  @positive @auth
  Scenario: OAuth entegrasyonu ve formlar arası geçiş linklerinin çalışması
    Given Kullanıcı kimlik doğrulama sayfasındadır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Google kimlik doğrulama ekranı açılmalıdır
    When Kullanıcı sayfa üzerindeki geçiş linklerine tıklar
    Then İlgili form veya sayfa sorunsuz şekilde açılmalıdır