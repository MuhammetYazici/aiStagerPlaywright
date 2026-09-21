Feature: AiStager.ai Ana Sayfa Etkileşimleri ve Navigasyon
  Bir web sitesi ziyaretçisi veya kayıtlı kullanıcısı olarak; 
  ana sayfadaki interaktif araçları sorunsuz kullanabilmek ve 
  navigasyon işlemlerini gerçekleştirebilmek istiyorum.

  @TC_HP_001 @Positive
  Scenario: Öncesi/Sonrası Slider alanının pürüzsüz çalışması
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı slider alanındaki sağ yön okuna tıklar
    Then Slider görseli bir sonraki adıma pürüzsüz geçiş yapmalıdır
    When Kullanıcı alt carusel noktalarından "3" numaralı noktaya tıklar
    Then Doğrudan 3 numaralı oda görseli aktif hale gelmelidir
    When Kullanıcı slider görselini fare ile sağa doğru sürükler (drag)
    Then Görselin öncesi/sonrası durumu sorunsuz şekilde güncellenmelidir

  @TC_HP_002 @Positive @Security
  Scenario Outline: Header menünün kullanıcı oturum durumuna göre dinamik şekillenmesi
    Given Kullanıcı "<Oturum_Durumu>" durumundadır
    When Kullanıcı ana sayfa header alanını inceler
    Then Üst menüde "<Gorunur_Ogeler>" görünür olmalıdır
    And Üst menüde "<Gizli_Ogeler>" gizli olmalıdır

    Examples:
      | Oturum_Durumu | Gorunur_Ogeler                         | Gizli_Ogeler                      |
      | Ziyaretçi     | Logo, Ürünler, Çözümler, Fiyatlandırma, Giriş Yap, Ücretsiz Dene | Üretimlerim, Profil İkonu         |
      | Giriş Yapmış  | Logo, Ürünler, Çözümler, Fiyatlandırma, Üretimlerim, Profil İkonu | Giriş Yap, Ücretsiz Dene          |

  @TC_HP_003 @Positive
  Scenario: Topluluk Galerisi filtreleme ve sonsuz yükleme (Daha Fazla Tasarım)
    Given Kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır
    When Kullanıcı galeri filtresinden "Oturma Odası" seçeneğine tıklar
    Then Seçilen filtre mor renk ile vurgulanmalıdır
    And Sadece "Oturma Odası" kategorisindeki kartlar listelenmelidir
    When Kullanıcı kartlar üzerinden beğeni (like) ikonuna tıklar
    Then İlgili kartın beğeni sayısı 1 artmalıdır ve ikon aktif olmalıdır
    When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Mevcut "Oturma Odası" filtresi bozulmadan alt alta yeni tasarım kartları yüklenmelidir

  @TC_HP_004 @Positive @EdgeCase
  Scenario: SSS (FAQ) akordeon yapısının tekli açık kalma kuralı
    Given Kullanıcı AiStager.ai ana sayfasındaki SSS (FAQ) bölümündedir
    When Kullanıcı 1 numaralı SSS sorusuna tıklar
    Then 1 numaralı sorunun içeriği açılmalıdır
    When Kullanıcı 2 numaralı SSS sorusuna tıklar
    Then 2 numaralı sorunun içeriği açılmalıdır
    And 1 numaralı sorunun içeriği otomatik olarak kapanmalıdır

  @TC_HP_005 @Validation @EdgeCase
  Scenario Outline: Bülten aboneliği alanının validasyon kuralları
    Given Kullanıcı ana sayfadaki bülten abonelik alanındadır
    When Kullanıcı bülten e-posta alanına "<Eposta_Girdisi>" girer ve abone ol butonuna tıklar
    Then Kullanıcı bülten alanında "<Sonuc_Tipi>" mesajını görmelidir

    Examples:
      | Eposta_Girdisi       | Sonuc_Tipi                                      |
      | test@example.com     | Başarılı abonelik mesajı ("Teşekkürler...")     |
      |                      | Bu alan zorunludur / Boş bırakılamaz uyarısı    |
      | test@com             | Geçersiz e-posta formatı uyarısı                |
      | uzunkarakter...@@.com| Geçersiz e-posta formatı uyarısı                |

Feature: Giriş Yap Modülü (Login)
  Kayıtlı bir kullanıcı olarak; güvenli bir şekilde sisteme giriş yapabilmek,
  şifremi görünür kılabilmek ve sosyal hesaplarımı kullanabilmek istiyorum.

  @TC_LOG_001 @Validation @Negative
  Scenario: Giriş sayfasında zorunlu alanların ve formatların validasyonu
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak "Giriş Yap" butonuna tıklar
    Then E-posta ve şifre alanları altında "Bu alan zorunludur" uyarıları gösterilmelidir
    When Kullanıcı e-posta alanına geçerli formatta olmayan "gecersiz-email" yazar
    And Şifre alanını doldurup "Giriş Yap" butonuna tıklar
    Then E-posta alanında uygun format uyarı mesajı gösterilmelidir

  @TC_LOG_002 @Security @Negative @EdgeCase
  Scenario Outline: Kimlik doğrulama güvenliği ve genel hata yönetimi (User Enumeration Koruması)
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta alanına "<Eposta>" ve şifre alanına "<Sifre>" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem kullanıcıya güvenlik amaçlı genel "<Hata_Mesaji>" uyarısını döndürmelidir

    Examples:
      | Eposta                  | Sifre          | Hata_Mesaji                  |
      | kayitsiz@example.com    | dogrusifre123  | E-posta veya şifre hatalı    |
      | kayitli@example.com     | yanlisSifre    | E-posta veya şifre hatalı    |
      | ' OR 1=1 --             | ' OR 1=1 --    | E-posta veya şifre hatalı    |
      | cokuzunkarakter...email | cokuzunsifre   | E-posta veya şifre hatalı    |

  @TC_LOG_003 @UI @Positive
  Scenario: Şifre görünürlüğü ve Sosyal Giriş entegrasyonu
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı şifre alanına "GuvenliSifre1!" yazar
    And Şifre alanının sağındaki "Göz" ikonuna tıklar
    Then Şifre karakterleri düz metin olarak görünür olmalıdır
    When Kullanıcı tekrar "Göz" ikonuna tıklar
    Then Şifre karakterleri maskelenmiş (yıldız/nokta) hale gelmelidir
    When Kullanıcı "Google ile devam et" butonuna tıklar
    Then Kullanıcı Google kimlik doğrulama ekranına yönlendirilmelidir

Feature: Kayıt Ol Modülü (Register)
  Yeni bir ziyaretçi olarak; kurallara uygun şifre ve e-posta ile 
  güvenli bir şekilde yeni hesap oluşturabilmek istiyorum.

  @TC_REG_001 @Validation @Negative @EdgeCase
  Scenario Outline: Kayıt ol validasyon kuralları ve hata mesajları
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı kayıt formunu e-posta: "<Eposta>", şifre: "<Sifre>", şifre onay: "<Sifre_Onay>" ve sözleşme kutusu: <Sozlesme> ile doldurur
    And Kullanıcı "Kayıt Ol" butonuna tıklar
    Then Kullanıcı register ekranında ilgili "<Hata_Mesaji>" uyarısını almalıdır

    Examples:
      | Eposta               | Sifre       | Sifre_Onay  | Sozlesme | Hata_Mesaji                     |
      | yeni@example.com     | kisa        | kisa        | true     | En az 8 karakter olmalıdır      |
      | yeni@example.com     | Sifre123!   | FarkliSifre | true     | Şifreler eşleşmiyor             |
      | kayitli@example.com  | Sifre123!   | Sifre123!   | true     | Bu e-posta adresi zaten kullanımda|
      | yeni@example.com     | Sifre123!   | Sifre123!   | false    | Sözleşmeyi kabul etmelisiniz    |

  @TC_REG_002 @Positive @Navigation
  Scenario: Başarılı kayıt süreci ve yönlendirmeler
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı sisteme kayıtlı olmayan geçerli bir e-posta girer
    And Kullanıcı kurallara uygun şifre girer ve şifreyi onaylar
    And Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı "Kayıt Ol" butonuna tıklar
    Then Kullanıcı başarılı bir şekilde aktivasyon ekranına veya ana panele yönlendirilmelidir
    When Kullanıcı sayfadaki "Giriş yap" bağlantısına tıklar
    Then Kullanıcı sorunsuz bir şekilde "/login" sayfasına yönlendirilmelidir