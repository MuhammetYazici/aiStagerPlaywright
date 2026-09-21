# language: tr
Feature: AiStager.ai Ana Sayfa, Kimlik Doğrulama ve Gezinme Süreçleri
  Kullanıcı Hikayesi: US-AI-001

  Background:
    Given Kullanıcı AiStager platformundadır

  @UI @Home @Positive
  Scenario: Öncesi ve Sonrası Sihri slider görselinin pürüzsüz değişimi
    When Kullanıcı Öncesi ve Sonrası Sihri kaydırıcısını sağa ve sola sürükler
    Then Önce boş oda ve Sonra mobilyalı oda görselleri dinamik olarak pürüzsüz şekilde değişmelidir

  @UI @Home @Positive
  Scenario: Carousel noktaları ve okları ile oda görsellerinin değiştirilmesi
    When Kullanıcı farklı bir oda görseline ait carousel noktasına veya yön okuna tıklar
    Then İlgili odaya ait görsel listelenmelidir
    And Tıklanan nokta aktif ve koyu renk durumuna gelmelidir

  @UI @Home @Positive
  Scenario: Odanızı Yükleyin butonunun yönlendirme işlevi
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı ilgili yükleme veya giriş arayüzüne yönlendirilmelidir

  @UI @Home @Positive
  Scenario: Dil seçeneğinin Türkçe olarak değiştirilmesi
    When Kullanıcı dil seçeneğini Türkçe TR olarak değiştirir
    Then Sayfadaki tüm metinler güncellenerek Türkçe olmalıdır

  @UI @Header @Positive
  Scenario: Oturum açmış kullanıcının üst menü öğelerini eksiksiz görmesi
    Given Kullanıcı sisteme oturum açmış durumdadır
    When Kullanıcı üst menüyü inceler
    Then Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil seçeneği, Hızlı Render paneli ve Profil y harfli ikon menüleri eksiksiz ve işlevsel olarak görünmelidir

  @UI @Header @Positive
  Scenario: Ziyaretçi kullanıcının üst menü görünürlüğü
    Given Kullanıcı siteyi ziyaret etmektedir ve oturum açmamıştır
    When Kullanıcı üst menüyü inceler
    Then Giriş Yap ve Ücretsiz Dene butonları görünmelidir
    And Üretimlerim sekmesi ve profil ikonu tamamen gizlenmiş olmalıdır

  @UI @Gallery @Positive
  Scenario: Galeri varsayılan filtre durumu ve oda tipi filtreleme
    Given Kullanıcı topluluk tasarımları galerisindedir
    Then Varsayılan olarak Tüm Tipler filtresi aktif ve mor renkli olmalıdır
    When Kullanıcı Oturma Odası gibi farklı bir oda tipi filtresine tıklar
    Then Galeri anlık olarak seçilen oda tipine göre filtrelenmelidir

  @UI @Gallery @Positive
  Scenario: Tasarım kartları üzerinden profile gitme ve beğeni artırma
    Given Kullanıcı topluluk tasarımları galerisindedir
    When Kullanıcı bir tasarım kartı üzerinden kullanıcı profiline tıklar
    Then İlgili kullanıcının profil sayfasına yönlendirilmelidir
    When Kullanıcı kart üzerindeki Kalp ikonuna tıklar
    Then Tasarımın beğeni sayısı 1 artmalıdır

  @UI @Gallery @Positive
  Scenario: Daha fazla tasarım yükleme
    Given Kullanıcı topluluk tasarımları galerisinde bir filtreleme yapmıştır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtreleme bozulmaksızın yeni tasarım kartları listenin altına eklenmelidir

  @UI @FAQ @Positive
  Scenario: SSS akordeon menülerinin dinamik çalışması
    Given Kullanıcı Sıkça Sorulan Sorular bölümündedir
    When Kullanıcı kapalı olan bir soru akordeonuna tıklar
    Then İlgili soru açılmalı ve ok yönü değişmelidir
    And Daha önce açık olan diğer soru otomatik olarak kapanmalı ve ok yönü eski haline gelmelidir

  @UI @Newsletter @Positive
  Scenario: Bülten formuna geçerli e-posta girişi
    Given Kullanıcı bülten abonelik formundadır
    When Kullanıcı bülten alanına geçerli bir e-posta adresi "test@example.com" girer ve gönderir
    Then Başarı mesajı görüntülenmelidir

  @UI @Newsletter @Negative @EdgeCase
  Scenario Outline: Bülten formuna geçersiz veya boş girdi yapılması
    Given Kullanıcı bülten abonelik formundadır
    When Kullanıcı bülten alanına "<Girdi>" girer ve gönderir
    Then Bülten formunda validasyon hatası verilmelidir

    Examples:
      | Girdi           |
      | boş             |
      | gecersiz-eposta |
      | test@com        |

  @UI @Footer @Positive
  Scenario: Footer yasal linkler, sosyal medya ve alt sayfa yönlendirmeleri
    Given Kullanıcı sayfanın en altındaki Footer bölümündedir
    When Kullanıcı yasal linklere ve alt sayfa yönlendirmelerine tıklar
    Then İlgili sayfalar hatasız açılmalıdır
    When Kullanıcı sosyal medya ikonlarına tıklar
    Then İlgili sosyal medya sayfaları yeni sekmede açılmalıdır

  @Auth @Login @Positive
  Scenario: Kayıtlı geçerli bilgiler ile başarılı giriş yapma
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı kayıtlı geçerli e-posta ve şifresini girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarılı şekilde Dashboard'a yönlendirilmelidir

  @Auth @Login @Positive
  Scenario: Şifre alanındaki göz ikonu işlevselliği
    Given Kullanıcı Giriş Yap sayfasında şifre alanına bir değer girmiştir
    When Kullanıcı şifre alanının yanındaki göz ikonuna tıklar
    Then Şifre karakterleri okunabilir görünür olmalıdır
    When Kullanıcı tekrar göz ikonuna tıklar
    Then Şifre karakterleri gizlenmelidir maskelenmelidir

  @Auth @Login @Positive
  Scenario: Google ile giriş desteği
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı Google ile Giriş Yap butonuna tıklar
    Then Google kimlik doğrulama ekranı açılmalı ve başarılı giriş sonrası Dashboard'a yönlendirilmelidir

  @Auth @Login @Negative
  Scenario Outline: Giriş formunda zorunlu alanların boş bırakılması
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı E-posta alanına "<Eposta>" ve Şifre alanına "<Sifre>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Bu alan zorunludur validasyon mesajı gösterilmelidir

    Examples:
      | Eposta           | Sifre     |
      | boş              | Sifre123* |
      | test@example.com | boş       |
      | boş              | boş       |

  @Auth @Login @Negative
  Scenario Outline: Hatalı e-posta formatı veya geçersiz kimlik bilgileri ile giriş denemesi
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı E-posta alanına "<Eposta>" ve Şifre alanına "<Sifre>" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Genel bir güvenlik mesajı olan E-posta veya şifre hatalı uyarısı gösterilmelidir

    Examples:
      | Eposta            | Sifre        | Açıklama                |
      | hatali-format     | Sifre123*    | Hatalı e-posta formatı  |
      | olmaksiz@mail.com | YanlisSifre1 | Kayıtlı olmayan e-posta |
      | kayitli@mail.com  | YanlisSifre1 | Yanlış şifre            |

  @Auth @Login @Security @EdgeCase
  Scenario: Giriş ekranında SQL Enjeksiyon girdilerine karşı güvenlik testi
    Given Kullanıcı Giriş Yap sayfasındadır
    When Kullanıcı E-posta alanına "'OR '1'='1" ve Şifre alanına "'OR '1'='1" girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistem istikrarını korumalı, hata vermemeli ve E-posta veya şifre hatalı genel uyarısını dönmelidir

  @Auth @Register @Positive
  Scenario: Geçerli bilgiler ile başarılı kayıt oluşturma
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı benzersiz bir e-posta adresi girer
    And Kullanıcı en az 8 karakterli birbiriyle eşleşen şifreler girer
    And Kullanıcı yasal sözleşme onay kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve yönlendirme yapılmalıdır

  @Auth @Register @Negative
  Scenario Outline: Kayıt formunda eksik alan bırakılması
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı formu eksik doldurur Eposta: "<Eposta>", Şifre: "<Sifre>", Onay: "<Onay>"
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then İlgili alanlar için net validasyon uyarıları dönülmelidir

    Examples:
      | Eposta        | Sifre     | Onay     |
      | boş           | Sifre123* | İşaretli |
      | yeni@mail.com | boş       | İşaretli |
      | yeni@mail.com | Sifre123* | Boş      |

  @Auth @Register @Negative
  Scenario Outline: Kayıt formunda geçersiz e-posta formatı veya kısa veya uyuşmayan şifreler
    Given Kullanıcı Kayıt Ol sayfasındadır
    When Kullanıcı E-posta alanına "<Eposta>", Şifre alanına "<Sifre>", Şifre Tekrar alanına "<SifreTekrar>" girer
    And Kullanıcı onay kutucuğunu işaretleyip Kayıt Ol butonuna tıklar
    Then Net validasyon uyarıları gösterilmelidir

    Examples:
      | Eposta        | Sifre     | SifreTekrar | Açıklama                 |
      | gecersiz-mail | Sifre123* | Sifre123*   | Geçersiz e-posta formatı |
      | yeni@mail.com | kısa      | kısa        | 8 karakterden kısa şifre |
      | yeni@mail.com | Sifre123* | Sifre999*   | Uyuşmayan şifreler       |

  @Auth @Register @Negative @EdgeCase
  Scenario: Halihazırda kullanımda olan e-posta ile kayıt denemesi
    Given Sistemde halihazırda kayıtlı bir "mevcut@mail.com" e-posta adresi bulunmaktadır
    When Kullanıcı Kayıt Ol sayfasında E-posta alanına "mevcut@mail.com" girer
    And Kullanıcı geçerli diğer alanları doldurup Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda şeklinde net bir validasyon uyarısı dönülmelidir