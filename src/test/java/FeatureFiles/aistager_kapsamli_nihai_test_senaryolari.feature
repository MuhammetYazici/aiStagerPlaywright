@AiStager @Regression
Feature: AiStager.ai Temel Modüller ve Akışlar
  Platformun Ana Sayfa, Giriş ve Kayıt modüllerine ait
  pozitif, negatif ve sınır durumların test edilmesi.

  @US-001 @HomePage @Positive
  Scenario: TC_HP_001 Öncesi ve Sonrası Sihri slider ve carousel yönetimi
    Given Kullanici AiStager ana sayfasindadir
    When Oncesi ve Sonrasi alanindaki kaydirici saga ve sola suruklenir
    Then Once ve Sonra gorsellerinin orantili olarak degistigi gorulmelidir
    When Carousel altindaki noktalara veya sag/sol ok tuslarina tiklanir
    Then Ilgili yeni oda gorsellerinin pürüzsüz yüklendigi ve aktif noktanin koyu renk oldugu gorulmelidir
    When Odanizi Yukleyin butonuna tiklanir
    Then Kullanici yukleme veya kimlik dogrulama ekranina yonlendirilmelidir

  @US-001 @HomePage @Localization
  Scenario: TC_HP_001_B Ana sayfa dil degistirme fonksiyonu
    Given Kullanici AiStager ana sayfasindadir
    When Dil secimi menusunden TR secenegi secilir
    Then Sayfedaki tum dinamik metinlerin Turkceye guncellendigi dogrulanmalidir

  @US-001 @Header @Positive
  Scenario: TC_HP_002 Oturum acmis kullanici icin ust menu navigasyonu
    Given Kullanici sisteme basarili bir sekilde giris yapmistir
    When Kullanici ana sayfadadir
    And Ust menüde Urunler uzerine gelinir
    Then Alt menunun acildigi gorulmelidir
    When Ust menuden Cozumler, Kaynaklar, Fiyatlandirma, Uretimlerim veya profil ikonuna tiklanir
    Then İlgili detay sayfalarının hatasız açıldığı doğrulanmalıdır

  @US-001 @Header @Visitor
  Scenario: TC_HP_002_VISITOR Ziyaretci durumu icin ust menu kisitlamalari
    Given Kullanici sisteme giris yapmamistir
    When Kullanici ana sayfayi ziyaret eder
    Then Ust menude Uretimlerim butonunun ve profil ikonunun gorunmedigi dogrulanmalidir
    And Sadece Giris Yap ve Ucretsiz Dene butonlarinin yer aldigi gorulmelidir

  @US-001 @Gallery @Positive
  Scenario: TC_HP_003_REV Topluluk galerisi filtreleme ve etkilesimleri
    Given Kullanici ana sayfa galeri bolumundedir
    Then Sayfa ilk acildiginda Tum Tipler filtresinin aktif ve mor renkte oldugu gorulmelidir
    When Oturma Odasi filtre butonuna tiklanir
    Then Aktif butonun mor oldugu ve galerinin sadece o tipe ait kartlari listeledigi gorulmelidir
    When Gorsel karti üzerindeki Kalp ikonuna tiklanir
    Then Begeni sayisinin 1 arttigi ve ikonun aktif duruma gectigi gorulmelidir
    When Daha Fazla Tasarım Yükle butonuna tiklanir
    Then Mevcut filtre bozulmaksizin yeni tasarim kartlarinin yüklendigi gorulmelidir

  @US-001 @FAQ @Positive
  Scenario: TC_HP_004 Sikca Sorulan Sorular etkilesimi
    Given Kullanici ana sayfa SSS bolumundedir
    When Listeden herhangi bir soruya tiklanir
    Then Ilgili cevabin acildigi ve sag okun yukari dondugu gorulmelidir
    When Farkli bir soruya tiklanir
    Then Onceki acik sorunun otomatik kapandigi ve yeni sorunun acildigi gorulmelidir

  @US-001 @Newsletter @EdgeCase
  Scenario Outline: TC_HP_005 Bulten aboneligi form validasyonlari
    Given Kullanici ana sayfa bulten alanindadir
    When Bülten e-posta alanina "<Eposta>" degeri girilir
    And Abone Ol butonuna tiklanir
    Then "<Sonuc>" mesaji gorulmelidir

    Examples:
      | Eposta                 | Sonuc                                    |
      | test@aistager.ai       | Basarili yesil uyari mesaji alinmalidir  |
      |                        | Gecerli bir e-posta adresi giriniz       |
      | gecersiz-eposta-formati| Gecerli bir e-posta adresi giriniz       |

  @US-002 @Login @Positive
  Scenario: TC_LOG_001 Gecerli bilgilerle basarili giris yapma
    Given Kullanici /login sayfasindadir
    When E-posta alanina "gecerli_kullanici@aistager.ai" girilir
    And Sifre alanina "GuvenliSifre123!" girilir
    And Giris Yap butonuna tiklanir
    Then Kullanici basariyla ana panele yonlendirilmelidir

  @US-002 @Login @UI
  Scenario: TC_LOG_002 Sifre gorunurluk ve navigasyon kontrolleri
    Given Kullanici /login sayfasindadir
    When Sifre alanina gizli metin girilir
    And Sifre alanindaki Goz ikonuna tiklanir
    Then Sifre karakterlerinin okunabilir oldugu dogrulanmalidir
    When Kayıt Ol linkine tiklanir
    Then Kayit ol sayfasina yonlendirildigi gorulmelidir
    When Geri gelip Şifremi Unuttum linkine tiklanir
    Then Sifre sifirlama sayfasina yonlendirildigi gorulmelidir

  @US-002 @Login @Negative
  Scenario Outline: TC_LOG_002_NEG Giris yapma negatif ve validasyon senaryolari
    Given Kullanici /login sayfasindadir
    When E-posta alanina "<Eposta>" girilir
    And Sifre alanina "<Sifre>" girilir
    And Giris Yap butonuna tiklanir
    Then "<HataMesaji>" uyarisi alindigi dogrulanmalidir

    Examples:
      | Eposta                    | Sifre            | HataMesaji                        |
      |                           |                  | Bu alan zorunludur                |
      | yanlisformat.com          | Sifre123!        | Lütfen geçerli bir e-posta adresi |
      | kayitsiz@aistager.ai      | YanlisSifre123   | E-posta veya şifre hatalı         |
      | gecerli_kullanici@ai.com  | HataliSifre      | E-posta veya şifre hatalı         |

  @US-002 @Login @Security @EdgeCase
  Scenario: TC_LOG_002_SEC Sifre alaninda SQL Injection ve asiri uzun girdi testi
    Given Kullanici /login sayfasindadir
    When E-posta alanina "test@aistager.ai" girilir
    And Sifre alanina "'OR '1'='1" veya cok uzun karakter dizileri girilir
    And Giris Yap butonuna tiklanir
    Then Sistem istegi guvenle filtrelemeli ve 500 Server Error hatasi vermeden reddetmelidir

  @US-003 @Register @Positive
  Scenario: TC_REG_001 Gecerli bilgilerle yeni kullanici kaydi olusturma
    Given Kullanici /register sayfasindadir
    When Benzersiz e-posta adresi girilir
    And Sifre ve Şifreyi Onayla alanlarina kurallara uygun ayni sifre girilir
    And Kullanım sözleşmesi onay kutucuğu isaretlenir
    And Hesap Oluştur butonuna tiklanir
    Then Kaydin basariyla gerçekleştiği ve aktivasyon ekranina yonlendirildigi gorulmelidir

  @US-003 @Register @Negative
  Scenario Outline: TC_REG_002_VAL Kayit ol sayfasi alan validasyonlari
    Given Kullanici /register sayfasindadir
    When E-posta alanina "<Eposta>" girilir
    And Sifre alanina "<Sifre>" girilir
    And Sifre Onay alanina "<SifreOnay>" girilir
    And Sozlesme kutucugu "<SozlesmeDurumu>" birakilir
    And Hesap Oluştur butonuna tiklanir
    Then Kayit basarisiz olmali ve "<BeklenenHata>" gosterilmelidir

    Examples:
      | Eposta               | Sifre     | SifreOnay | SozlesmeDurumu | BeklenenHata                       |
      |                      |           |           | isaretli       | Bu alan zorunludur                 |
      | gecersiz-mail        | 123456    | 123456    | isaretli       | Lütfen geçerli bir e-posta adresi  |
      | yeni@aistager.ai     | 12345     | 12345     | isaretli       | minimum uzunluk validasyon hatasi  |
      | yeni@aistager.ai     | Sifre123! | Sifre999! | isaretli       | Şifreler eşleşmiyor                |
      | yeni@aistager.ai     | Sifre123! | Sifre123! | isaretsiz      | sözleşme uyarısı                   |

  @US-003 @Register @EdgeCase
  Scenario: TC_REG_002_DUP Sistemde kayitli e-posta ile mukerrer kayit testi
    Given Kullanici /register sayfasindadir
    When Sistemde halihazirda kayitli olan bir e-posta adresi girilir
    And Gerekli diger tum alanlar kurallara uygun doldurulur ve sozlesme onaylanir
    And Hesap Oluştur butonuna tiklanir
    Then Bu e-posta adresi zaten kullanımda uyarısının gösterildiği doğrulanmalıdır