Feature: Ana Sayfa, Navigasyon ve Kimlik Doğrulama US-AI-001
  Kullanıcıların ana sayfayı gezinebilmesi, slider, galeri, SSS ve bülten özelliklerini 
  kullanabilmesi, ayrıca güvenli bir şekilde Giriş Yapıp Kayıt Olabilmesi

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Kullanıcı slider alanını interaktif olarak kullanabilmelidir Pozitif
    When Kullanıcı Öncesi ve Sonrası Sihri alanındaki kaydırıcıyı sağa ve sola sürükler
    Then Mobilyalı ve boş oda görselleri arasında pürüzsüz geçiş sağlanmalıdır
    When Kullanıcı yön oklarına veya nokta göstergelerine tıklar
    Then Görsel değişimi sorunsuz bir şekilde gerçekleşmelidir

  Scenario: Ziyaretçi konumundaki kullanıcı üst menüyü doğru görmelidir Pozitif
    Given Kullanıcı sisteme giriş yapmamıştır ziyaretçi
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir
    And Üst menüde Üretimlerim menüsü ve profil ikonu kesinlikle görünmemelidir

  Scenario: Oturum açmış kullanıcı üst menüyü tam yetkiyle görmelidir Pozitif
    Given Kullanıcı geçerli kimlik bilgileriyle oturum açmıştır
    Then Üst menüde logo, ürünler, çözümler, kaynaklar ve fiyatlandırma menüleri görünmelidir
    And Üst menüde Üretimlerim, hızlı render paneli ve profil menüsü aktif olarak çalışmalıdır

  Scenario: Topluluk tasarımları filtrelenebilmeli ve detaylarına gidilebilmelidir Pozitif
    When Kullanıcı Topluluk Tasarımlarımızı Keşfedin alanına gider
    And Kullanıcı oda tiplerine göre bir filtre seçer Yatak Odası
    Then Sadece seçilen oda tipine ait tasarım kartları listelenmelidir
    When Kullanıcı bir tasarım kartı üzerindeki tasarımcı profiline tıklar
    Then İlgili tasarımcının profil sayfasına yönlendirilmelidir
    When Kullanıcı bir içeriği beğenir
    Then Beğeni sayısı anlık olarak artmalıdır

  Scenario: Filtreleme yapılmışken yeni tasarımlar yüklenebilmelidir Edge Case
    Given Kullanıcı topluluk galerisinde bir oda tipine göre filtreleme yapmıştır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtre bozulmaksızın alt kısma yeni tasarım kartları yüklenmelidir

  Scenario: SSS alanındaki akordeon menüler tekil olarak çalışmalıdır Pozitif
    When Kullanıcı SSS alanından bir soruya tıklar ve akordeon açılır
    And Kullanıcı farklı bir soruya tıklar
    Then Yeni tıklanan soru açılmalı ve daha önce açık olan soru otomatik olarak kapanmalıdır

  Scenario: Geçerli e-posta ile bülten aboneliği başarılı olmalıdır Pozitif
    When Kullanıcı footer bülten alanına geçerli bir e-posta adresi "test@example.com" girer
    And Kullanıcı abone ol butonuna tıklar
    Then Başarılı bülten aboneliği mesajı görüntülenmelidir

  Scenario: Geçersiz e-posta formatı ile bülten aboneliği engellenmelidir Negatif
    When Kullanıcı footer bülten alanına geçersiz bir e-posta adresi "gecersiz-eposta" girer
    And Kullanıcı abone ol butonuna tıklar
    Then Sistem geçerli e-posta formatı uyarısı vermelidir

  Scenario: Kayıtlı ve doğru bilgilerle başarılı giriş yapılabilmelidir Pozitif
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıtlı e-posta adresini ve doğru şifresini girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarılı bir şekilde ana panele yönlendirilmelidir

  Scenario Outline: Boş alan veya hatalı giriş denemelerinde uygun hata mesajı alınmalıdır Negatif
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "<eposta>" ve şifre alanına "<sifre>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem "<hata_mesaji>" uyarısını göstermelidir

    Examples:
      | eposta               | sifre       | hata_mesaji                |
      |                      |             | Bu alan zorunludur         |
      | gecersiz-format      | 123456      | Geçersiz e-posta formatı   |
      | dogru@example.com    | yanlissifre | E-posta veya şifre hatalı  |

  Scenario: SQL Injection girişimleri güvenlik amacıyla filtrelenmelidir Edge Case
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "'OR '1'='1" ve şifre alanına "'OR '1'='1" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem girdileri filtreleyerek girişe izin vermemeli ve hata mesajı göstermelidir

  Scenario: Şifre alanındaki maskeleme Göz ikonu ile yönetilebilmelidir Pozitif
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı şifre alanına bir değer girer
    And Şifrenin varsayılan olarak maskelenmiş yıldızlı noktalı olduğu görülür
    When Kullanıcı şifre alanının yanındaki Göz ikonuna tıklar
    Then Şifre düz metin olarak görünür olmalıdır
    When Kullanıcı tekrar Göz ikonuna tıklar
    Then Şifre tekrar maskelenmelidir

  Scenario: Google ile OAuth üzerinden giriş yapılabilmelidir Pozitif
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Kullanıcı Google kimlik doğrulama ekranına yönlendirilmeli ve izin sonrası sisteme giriş yapabilmelidir

  Scenario: Kurallara uygun yeni kullanıcı kaydı başarılı olabilmelidir Pozitif
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı benzersiz yeni bir e-posta adresi girer
    And Kullanıcı en az 8 karakterden oluşan güçlü bir şifre girer ve Şifreyi Onayla alanına aynı şifreyi yazar
    And Kullanıcı Kullanıcı Sözleşmesi ni onaylar
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcı sisteme yönlendirilmelidir

  Scenario Outline: Kayıt ol kurallarına uymayan durumlarda hata alınmalıdır Negatif ve Edge Case
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı formu şu verilerle doldurur: eposta "<eposta>", sifre "<sifre>", sifre_tekrar "<sifre_tekrar>", sozlesme <sozlesme>
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sistem ilgili "<hata_mesaji>" uyarısını göstermelidir

    Examples:
      | eposta             | sifre    | sifre_tekrar | sozlesme | hata_mesaji                             |
      | yeni@example.com   | 12345    | 12345        | True     | Şifre en az 8 karakterden oluşmalıdır   |
      | yeni@example.com   | Password1| Password2    | True     | Şifreler eşleşmiyor                     |
      | yeni@example.com   | Password1| Password1    | False    | Kullanıcı Sözleşmesi onaylanmalıdır     |

  Scenario: Sistemde kayıtlı e-posta adresi ile tekrar kayıt olunamamalıdır Negatif
    Given Kullanıcı kayıt sayfasındadır
    And Sistemde hali hazırda kayıtlı olan bir e-posta adresi bulunmaktadır "kayitli@example.com"
    When Kullanıcı e-posta alanına "kayitli@example.com" yazar ve diğer zorunlu alanları kurallara uygun doldurur
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Sistem Bu e-posta adresi zaten kullanımda uyarısını dönmelidir