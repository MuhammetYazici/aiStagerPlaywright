Feature: Ana Sayfa ve Genel Navigasyon Yönetimi (Epic 1)

  Background:
    Given Kullanıcı AiStager.ai ana sayfasına gider

  @positive @homepage @slider
  Scenario: Öncesi ve Sonrası Slider bileşeninin pürüzsüz çalışması
    When Kullanıcı "Öncesi ve Sonrası Sihri" slider'ını iki yönlü ok ile sürükler
    Then "Önce" (boş oda) ve "Sonra" (mobilyalı oda) alanları arasında pürüzsüz geçiş yapılmalıdır
    And Yön okları veya alt carousel noktalarına tıklandığında ilgili oda görselleri yüklenmeli ve aktif nokta koyu renge dönüşmelidir

  @positive @homepage @gallery
  Scenario: Topluluk galerisinde oda tipi filtreleme yapılması
    When Kullanıcı galeri alanına gelir
    Then İlk açılışta "Tüm Tipler" filtresi aktif olmalı ve karışık tasarımlar listelenmelidir
    When Kullanıcı "Oturma Odası" oda tipi filtresine tıklar
    Then Galeri sadece "Oturma Odası" tasarımlarını listeleyecek şekilde filtrelenmelidir

  @positive @homepage @gallery
  Scenario: Topluluk galerisinde sosyal etkileşimler ve yeni tasarım yükleme
    Given Kullanıcı topluluk galerisindedir
    When Kullanıcı bir tasarımın üzerindeki kalp ikonuna tıklar
    Then İlgili tasarımın beğeni sayısı 1 artmalıdır
    When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Mevcut filtre bozulmadan yeni tasarım kartları sayfaya yüklenmelidir

  @positive @homepage @faq
  Scenario: Sık sorulan sorular (FAQ) akordeon yapısının çalışması
    When Kullanıcı sık sorulan sorulardan ilk başlığa tıklar
    Then İlk sorunun içeriği açılmalıdır
    When Kullanıcı ikinci bir soru başlığına tıklar
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır
    When Kullanıcı açık olan soru başlığına tekrar tıklar
    Then Soru içeriği kapanmalıdır
    And Kullanıcı içerikteki "Bize ulaşın" linkine tıklar
    Then Kullanıcı destek sayfasına yönlendirilmelidir

  @positive @homepage @newsletter
  Scenario: Bültene geçerli e-posta adresiyle başarılı abone olma
    When Kullanıcı footer bülten alanına geçerli bir "test@example.com" e-posta adresi girer
    And "Abone Ol" butonuna tıklar
    Then Ekranda yeşil renkte "Başarıyla abone oldunuz" başarı mesajı gösterilmelidir

  @negative @homepage @newsletter
  Scenario Outline: Bültene boş veya geçersiz e-posta adresi ile abone olma denemesi
    When Kullanıcı footer bülten alanına "<gecersiz_eposta>" girer
    And "Abone Ol" butonuna tıklar
    Then Ekranda "Geçerli bir e-posta adresi giriniz" uyarısı gösterilmelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | test-eposta     |
      | test@domain     |
      | @domain.com     |

Feature: Kimlik Doğrulama ve Hesap Yönetimi (Epic 2)

  Background:
    Given Kullanıcı giriş veya kayıt sayfasındadır

  @positive @login
  Scenario: Geçerli bilgilerle başarılı giriş yapma ve şifre görünürlüğü
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When Kullanıcı geçerli bir e-posta ve şifre girer
    And Şifre alanındaki "Göz" ikonuna tıklar
    Then Şifre alanındaki maskelenmiş karakterler görünür olmalıdır
    When Kullanıcı "Giriş Yap" butonuna tıklar
    Then Kullanıcı ana panele (dashboard) yönlendirilmelidir
    And Sayfadaki "Şifremi unuttum" ve "Kayıt Ol" linklerinin ilgili sayfalara yönlendirdiği doğrulanmalıdır

  @positive @login @oauth
  Scenario: Google hesabı ile giriş yapmayı tetikleme
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When Kullanıcı "Google ile devam et" butonuna tıklar
    Then Google OAuth kimlik doğrulama penceresi açılmalıdır

  @negative @login
  Scenario: Giriş formunda zorunlu alanların boş bırakılması
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak "Giriş Yap" butonuna tıklar
    Then İlgili zorunlu alanlarda "Bu alan zorunludur" uyarısı gösterilmelidir

  @negative @login
  Scenario Outline: Geçersiz e-posta formatı ile giriş yapma denemesi
    When Kullanıcı e-posta alanına "<gecersiz_eposta>" girer
    And "Giriş Yap" butonuna tıklar
    Then Ekranda "Lütfen geçerli bir e-posta adresi girin" hatası gösterilmelidir

    Examples:
      | gecersiz_eposta |
      | yanlisformat    |
      | format@.com     |
      | format@@com     |

  @negative @login @security
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi
    When Kullanıcı sistemde olmayan bir e-posta veya yanlış şifre girer
    And "Giriş Yap" butonuna tıklar
    Then Sistem güvenlik gereği spesifik detay vermeden genel "E-posta veya şifre hatalı" mesajını dönmelidir

  @edgecase @login @security
  Scenario: Giriş formunda SQL Injection ve zararlı karakter testleri
    When Kullanıcı e-posta veya şifre alanına "' OR '1'='1" veya çok uzun karakter dizileri girer
    And "Giriş Yap" butonuna tıklar
    Then Sistem bu girdileri güvenle filtrelemeli, 500 hatası veya çökme yaşanmamalıdır

  @positive @register
  Scenario: Kurallara uygun bilgilerle başarılı kayıt olma
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan geçerli bir e-posta girer
    And En az 8 karakterden oluşan güçlü bir şifre belirler ve şifreyi onaylar
    And Göz ikonlarını kullanarak şifre görünürlüğünü kontrol eder
    And Kullanıcı sözleşmesi onay kutucuğunu işaretler
    And "Hesap Oluştur" butonuna tıklar
    Then Kayıt başarılı olmalı ve kullanıcı ana panele veya aktivasyon sayfasına yönlendirilmelidir

  @negative @register
  Scenario: Kayıt formunda zorunlu alanların boş bırakılması
    When Kullanıcı tüm kayıt alanlarını boş bırakarak "Hesap Oluştur" butonuna tıklar
    Then Zorunlu alanlarda "Bu alan zorunludur" uyarısı gösterilmelidir

  @negative @register
  Scenario: Sistemde zaten kayıtlı olan e-posta ile kayıt olma denemesi
    When Kullanıcı halihazırda sistemde kayıtlı olan bir e-posta adresi girer
    And Diğer alanları doldurup "Hesap Oluştur" butonuna tıklar
    Then Ekranda "Bu e-posta adresi zaten kullanımda" hatası dönülmelidir

  @negative @register
  Scenario: Çok kısa şifre ile kayıt olma denemesi
    When Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer (örn: "Ab1!")
    And "Hesap Oluştur" butonuna tıklar
    Then Ekranda minimum karakter sınırını belirten bir uyarı gösterilmelidir

  @negative @register
  Scenario: Eşleşmeyen şifreler ile kayıt olma denemesi
    When Kullanıcı "Şifre" alanına "Password123" girer
    And "Şifreyi Onayla" alanına farklı bir değer olan "Password456" girer
    And "Hesap Oluştur" butonuna tıklar
    Then Ekranda "Şifreler eşleşmiyor" uyarısı gösterilmelidir

  @negative @register
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt olma denemesi
    When Kullanıcı tüm geçerli bilgileri doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
    And "Hesap Oluştur" butonuna tıklar
    Then Kayıt engellenmeli ve ekranda "Sözleşmeyi kabul etmelisiniz" uyarısı gösterilmelidir