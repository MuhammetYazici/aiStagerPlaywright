Feature: AiStager.ai Platform Temel Erişim, Kimlik Doğrulama ve Ana Sayfa Etkileşimleri
  Kullanıcı olarak, ana sayfayı keşfetmek, sisteme güvenli giriş yapmak ve yeni hesap oluşturmak istiyorum.

  @Home @BR-HP-01 @Positive
  Scenario: Öncesi ve Sonrası Sihri slider alanının sorunsuz çalışması
    Given kullanıcı AiStager.ai ana sayfasını açar
    When "Öncesi ve Sonrası Sihri" slider alanına gelir
    And kullanıcı slider üzerindeki yan okları "<" ve ">" kullanır veya sürüklege (drag) hareketi yapar
    Then oda görselinin "Önce (Boş Oda)" ve "Sonra (Mobilyalı Oda)" arasında pürüzsüz geçiş yaptığı görülür
    And alt carousel noktalarının aktif duruma göre güncellendiği doğrulanır

  @Home @BR-HP-02 @Positive
  Scenario: Ziyaretçi durumunda üst menü (Header) görünürlüğü
    Given kullanıcı siteye henüz giriş yapmamış bir ziyaretçi olarak ana sayfayı açar
    When üst menüyü (Header) inceler
    Then "Giriş Yap" ve "Ücretsiz Dene" butonlarının görünür olduğunu görür
    And "Üretimlerim" ve profil ikonunun ise gizli olduğunu doğrular

  @Home @BR-HP-02 @Positive
  Scenario: Giriş yapılmış durumda üst menü (Header) görünürlüğü
    Given kullanıcı sisteme başarılı bir şekilde giriş yapar ve ana sayfaya döner
    When üst menüyü (Header) inceler
    Then logolar, Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil seçeneği, Hızlı Render ve Profil menülerinin aktif olarak çalıştığını görür

  @Home @BR-HP-03 @Positive
  Scenario: Topluluk galerisinde varsayılan filtre ve oda tipi filtreleme
    Given kullanıcı ana sayfadaki "Topluluk Galerisi" alanına gelir
    When varsayılan olarak "Tüm Tipler" filtresinin aktif olduğunu görür
    And "Oturma Odası" filtre seçeneğine tıklar
    Then galeri listesinin anlık olarak sadece "Oturma Odası" tasarımlarını gösterecek şekilde filtrelendiğini doğrular
    When "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then mevcut filtre bozulmadan yeni tasarımların listeye eklendiğini (pagination/infinite scroll) doğrular

  @Home @BR-HP-04 @Positive @EdgeCase
  Scenario: Akordeon SSS alanında aynı anda tek bir sorunun açık kalması
    Given kullanıcı ana sayfadaki Sıkça Sorulan Sorular (SSS) bölümüne gelir
    When birinci akordeon başlığına tıklayarak soruyu açar ve cevabı görür
    And ikinci bir akordeon başlığına tıklar
    Then yeni açılan sorunun detayının görüntülendiğini ve önceki birinci sorunun otomatik olarak kapandığını doğrular

  @Home @BR-HP-05 @Positive
  Scenario: Footer bülten alanına geçerli e-posta ile abone olma
    Given kullanıcı ana sayfanın footer (altbilgi) alanındaki bülten aboneliği bölümüne gelir
    When e-posta alanına geçerli bir formatta "kullanici@example.com" girer
    And "Abone Ol" butonuna tıklar
    Then başarılı abonelik mesajının görüntülendiğini doğrular

  @Home @BR-HP-05 @Negative @EdgeCase
  Scenario Outline: Footer bülten alanına geçersiz veya boş e-posta girilmesi
    Given kullanıcı footer bülten alanındaki e-posta inputuna "<eposta>" girer
    When "Abone Ol" butonuna tıklar
    Then uygun bir hata mesajı alındığı doğrulanır

    Examples:
      | eposta          |
      |                 |
      | gecersiz-email  |
      | test@domain     |
      | @domain.com     |

  @Login @BR-LOG-01 @Positive
  Scenario: Kullanıcının geçerli kimlik bilgileriyle başarılı giriş yapması
    Given kullanıcı "/login" sayfasına gider
    When e-posta alanına "kayitli.kullanici@AiStager.ai" girer
    And şifre alanına geçerli şifresini girer
    And "Giriş Yap" butonuna tıklar
    Then kullanıcının başarıyla ana panele ("/dashboard") yönlendirildiği doğrulanır

  @Login @BR-LOG-02 @Positive
  Scenario: Şifre alanında maskeleme ve göz ikonu işlevselliği
    Given kullanıcı "/login" sayfasına gider
    When şifre alanına "GuvenliSifre123" yazar
    Then şifrenin varsayılan olarak maskelendiğini ("••••••••••••") görür
    When şifre alanının sağındaki "Göz" ikonuna tıklar
    Then şifre metninin ("GuvenliSifre123") görünür hale geldiğini doğrular

  @Login @BR-LOG-03 @Negative
  Scenario: Giriş sayfasında zorunlu alanların boş bırakılması
    Given kullanıcı "/login" sayfasına gider
    When e-posta ve şifre alanlarını boş bırakarak doğrudan "Giriş Yap" butonuna tıklar
    Then ilgili alanların altında "Bu alan zorunludur" uyarı mesajlarının çıktığını doğrular

  @Login @BR-LOG-03 @Negative
  Scenario: Geçersiz e-posta formatı ile giriş denemesi
    Given kullanıcı "/login" sayfasına gider
    When e-posta alanına format dışı bir değer "yanlisformat.com" girer
    And şifre alanına "Sifre123!" girer
    And "Giriş Yap" butonuna tıklar
    Then uygun bir e-posta format uyarısı gösterildiğini doğrulanır

  @Login @BR-LOG-03 @Negative @Security
  Scenario Outline: Kayıtlı olmayan e-posta veya yanlış şifre ile güvenli giriş denemesi (Anti-Enumeration)
    Given kullanıcı "/login" sayfasına gider
    When e-posta alanına "<eposta>" girer
    And şifre alanına "<sifre>" girer
    And "Giriş Yap" butonuna tıklar
    Then saldırganlara ipucu vermemek adına genel ve sabit bir hata mesajı olan "E-posta veya şifre hatalı" uyarısının gösterildiğini doğrular

    Examples:
      | eposta                    | sifre           |
      | kayitli olmayan@mail.com  | DogruSifre123!  |
      | kayitli.kullanici@Ai.ai   | YanlisSifre!    |

  @Login @BR-LOG-03 @Negative @Security @EdgeCase
  Scenario: Giriş formunda SQL Injection ve uzun karakter dizisi testleri
    Given kullanıcı "/login" sayfasına gider
    When e-posta alanına "' OR '1'='1" veya çok uzun karakter dizileri girer
    And şifre alanına "' OR '1'='1" girer
    And "Giriş Yap" butonuna tıklar
    Then sistemin bu girdileri güvenle filtrelediği, 500 (Internal Server Error) hatasına sebep olmadığı ve uygun validasyon mesajı döndürdüğü doğrulanır

  @Login @BR-LOG-04 @Positive
  Scenario: Google ile alternatif giriş yapma
    Given kullanıcı "/login" sayfasına gider
    When "Google ile devam et" butonuna tıklar
    Then Google OAuth kimlik doğrulama ekranının tetiklendiğini doğrular

  @Register @BR-REG-01 @Positive
  Scenario: Kullanıcının geçerli bilgilerle başarılı bir şekilde kayıt olması
    Given kullanıcı "/register" sayfasına gider
    When sisteme kayıtlı olmayan bir e-posta adresi "yeni.kullanici@AiStager.ai" girer
    And şifre politikasına uygun bir şifre ("GuvenliSifre1!") ve "Şifreyi Onayla" alanına aynı şifreyi girer
    And zorunlu kullanıcı sözleşmesi onay kutucuğunu (checkbox) işaretler
    And "Kayıt Ol" butonuna tıklar
    Then hesabın başarıyla oluşturulduğu ve yönlendirmenin yapıldığı doğrulanır

  @Register @BR-REG-02 @Negative
  Scenario: Sistemde halihazırda kayıtlı e-posta ile kayıt denemesi
    Given kullanıcı "/register" sayfasına gider
    When sistemde zaten kayıtlı olan bir e-posta adresi girer
    And şifre ve sözleşme onayını tamamlayıp "Kayıt Ol" butonuna tıklar
    Then "Bu e-posta adresi zaten kullanımda" uyarısının gösterildiğini doğrular

  @Register @BR-REG-02 @Negative @EdgeCase
  Scenario: 8 karakterden kısa şifre ile kayıt denemesi
    Given kullanıcı "/register" sayfasına gider
    When geçerli bir e-posta girer
    And şifre ve şifre onayı alanlarına 8 karakterden kısa bir değer girer (Örn: "Ab1!us")
    And zorunlu sözleşmeyi onaylar ve "Kayıt Ol" butonuna tıklar
    Then şifrenin en az 8 karakter olması gerektiğine dair politika uyarısının gösterildiğini doğrular

  @Register @BR-REG-02 @Negative
  Scenario: Şifre ve Şifreyi Onayla alanlarının uyuşmaması
    Given kullanıcı "/register" sayfasına gider
    When geçerli e-posta girer
    And şifre alanına "GuvenliSifre1!" ve "Şifreyi Onayla" alanına "FarkliSifre2@" girer
    And sözleşmeyi onaylayıp "Kayıt Ol" butonuna tıklar
    Then şifrelerin eşleşmediğine dair hata mesajının gösterildiğini doğrulanır

  @Register @BR-REG-02 @Negative
  Scenario: Zorunlu kullanıcı sözleşmesi onaylanmadan kayıt denemesi
    Given kullanıcı "/register" sayfasına gider
    When geçerli e-posta ve kurallara uygun şifreleri girer
    And kullanıcı sözleşmesi onay kutucuğunu (checkbox) işaretlemez
    And "Kayıt Ol" butonuna tıklar
    Then sözleşmenin onaylanmasının zorunlu olduğuna dair bir uyarı mesajı alındığı doğrulanır

  @Register @BR-REG-03 @Positive
  Scenario: Kayıt ekranından Giriş Yap sayfasına geçiş yapma
    Given kullanıcı "/register" sayfasına gider
    When sayfa üzerindeki "Giriş yap" bağlantısına (link) tıklar
    Then kullanıcının sorunsuz bir şekilde `/login` sayfasına yönlendirildiği doğrulanır