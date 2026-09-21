Feature: AiStager Platformu Kapsamlı Test Senaryoları
  Kullanıcı olarak, yapay zeka destekli sanal dekorasyon, kaynak görsel düzenleme, ürün keşfi, erken erişim ve API iletişim akışlarını sorunsuz bir şekilde gerçekleştirmek istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @US-01
  Scenario: Başarılı Sanal Dekorasyon Üretimi Varsayılan Ayarlar
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta jpg veya png uzantılı bir oda fotoğrafı yükler
    And Mevcut mobilyaları kaldır toggle unsurunun varsayılan olarak açık olduğunu görür
    And Oda Türü alanından Yatak Odası seçimini yapar
    And Tasarım Stili alanından Modern seçimini yapar
    And Kullanıcı gizlilik tercihini Herkese Açık olarak belirler
    And Dekorasyon Oluştur butonuna tıklar
    Then Sistem yüklenen odayı analiz eder
    And Seçilen stile uygun mobilyalandırılmış görseli ekranda gösterir

  @Positive @US-01
  Scenario: Toggle ayarını değiştirerek Sanal Dekorasyon Üretimi
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta bir oda fotoğrafı yükler
    And Mevcut mobilyaları kaldır toggle unsurunu kapatır
    And Oda Türü ve Tasarım Stili seçimlerini yapar
    And Dekorasyon Oluştur butonuna tıklar
    Then Sistem mevcut eşyaları koruyarak seçilen stile uygun dekorasyon görselini üretir

  @Negative @US-01
  Scenario Outline: Desteklenmeyen dosya formatı ile görsel yükleme
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı "<gecersiz_format>" uzantılı bir dosya yüklemeye çalışır
    Then Sistem kullanıcının yükleme yapamayacağını belirten bir hata mesajı gösterir
    And Dekorasyon Oluştur butonu pasif kalır

    Examples:
      | gecersiz_format |
      | .gif            |
      | .bmp            |
      | .pdf            |
      | .exe            |

  @EdgeCase @US-01
  Scenario: Sınır değerde çok büyük boyutlu görsel yükleme
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı sistemin kabul ettiği maksimum boyut sınırının üzerinde bir görsel yükler
    Then Sistem dosya boyutunun çok büyük olduğuna dair uyarı mesajı gösterir

  @Negative @US-01
  Scenario Outline: Zorunlu alanlar eksikken dekorasyon oluşturma denemesi
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    And Kullanıcı geçerli bir görsel yüklemiştir
    When Kullanıcı "<oda_turu>" seçer ve "<tasarim_stili>" seçer
    And Dekorasyon Oluştur butonuna tıklar
    Then Sistem zorunlu alanların eksik olduğunu belirten bir uyarı gösterir
    And Dekorasyon işlemi başlatılmaz

    Examples:
      | oda_turu  | tasarim_stili |
      | Seçilmedi | Modern        |
      | Oturma O. | Seçilmedi     |
      | Seçilmedi | Seçilmedi     |

  @Positive @US-02
  Scenario: Varsayılan Mevcut görsel üzerinde başarılı AI Edit uygulaması
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındaki AI Edit sekmesindedir
    When Edit photo source alanında varsayılan olarak Current image seçili olduğunu görür
    And Kullanıcı Describe what to change alanına geçerli bir talimat yazar Remove the chair
    And Edit Photo butonuna tıklar
    Then Sistem girilen talimata uygun olarak görseli işler
    And Düzenlenmiş nihai çıktıyı ekranda gösterir

  @Positive @US-02
  Scenario: Yeni yüklenen görsel üzerinde başarılı AI Edit uygulaması
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındaki AI Edit sekmesindedir
    When Kullanıcı Edit photo source alanından yeni bir görsel yükler
    And Kullanıcı Describe what to change alanına talimat yazar Add a modern floor lamp
    And Edit Photo butonuna tıklar
    Then Sistem yeni yüklenen görseli işler ve düzenlenmiş çıktıyı gösterir

  @Negative @US-02
  Scenario: Talimat metni Prompt boş bırakıldığında AI Edit denemesi
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındaki AI Edit sekmesindedir
    And Kaynak görsel hazırdır
    When Kullanıcı Describe what to change alanını boş bırakır
    And Edit Photo butonuna tıklar
    Then Sistem metin alanının zorunlu olduğuna dair bir hata mesajı gösterir
    And Düzenleme işlemi gerçekleştirilmez

  @EdgeCase @US-02
  Scenario: Çok uzun metinsel talimat girilmesi
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındaki AI Edit sekmesindedir
    And Kaynak görsel hazırdır
    When Kullanıcı Describe what to change alanına sistemin izin verdiği karakter sınırını aşan çok uzun bir metin girer
    Then Sistem karakter sınırını aşamayacağını belirten bir uyarı gösterir

  @Positive @US-03
  Scenario: Header menüsü üzerinden ürün sayfalarına navigasyon
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir
    And Açılan alt menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı ai-virtual-tour sayfasına yönlendirilir
    When Kullanıcı tekrar Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı api sayfasına yönlendirilir

  @Positive @US-03
  Scenario: Yapay Zeka Sanal Tur Erken Erişim Talebinin Başarıyla Gönderilmesi
    Given Kullanıcı ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna basar
    And Açılan form alanına geçerli bir e-posta adresi girer ve talebi gönderir
    Then Sistem talebi başarıyla alır
    And Kullanıcıya başarılı gönderim onay mesajı gösterir

  @Negative @US-03
  Scenario Outline: Geçersiz e-posta ile Erken Erişim Talebi Oluşturma
    Given Kullanıcı ai-virtual-tour sayfasındadır
    When Kullanıcı form alanına geçersiz bir e-posta adresi girer "<gecersiz_email>"
    And Talebi gönder butonuna tıklar
    Then Sistem e-posta formatının hatalı olduğuna dair bir uyarı mesajı gösterir
    And Talep gönderilmez

    Examples:
      | gecersiz_email |
      | test-email     |
      | test@.com      |
      | @domain.com    |

  @Positive @US-03
  Scenario: Sanal Dekorasyon API İletişim Formunun Başarıyla Gönderilmesi ve Fiyatlandırma Yönlendirmesi
    Given Kullanıcı Sanal Dekorasyon API sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Zorunlu iletişim alanlarını Ad E-posta Mesaj eksiksiz ve geçerli bilgilerle doldurur
    And Formu gönderir
    Then Sistem iletişim talebini başarıyla iletir ve onay mesajı gösterir
    When Kullanıcı sayfanın altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı başarılı bir şekilde Fiyatlandırma sayfasına yönlendirilir

  @Negative @US-03
  Scenario: Sanal Dekorasyon API İletişim Formu zorunlu alan kontrolü
    Given Kullanıcı Sanal Dekorasyon API sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Zorunlu alanları boş bırakarak formu göndermeye çalışır
    Then Sistem zorunlu alanların doldurulması gerektiğine dair hata mesajları gösterir
    And Form gönderilmez