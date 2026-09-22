Feature: Yapay Zeka Destekli Görsel Dekorasyon ve Ürün Keşfi
  Kullanıcı olarak platform üzerinde sanal dekorasyon yapmak, AI Edit ile değişiklikler gerçekleştirmek,
  ürünlere ulaşabilmek ve erken erişim talebinde bulunabilmek istiyorum.

  Background:
    Given kullanıcı AiStager platformundadır

  @positive @staging
  Scenario: Başarılı Sanal Dekorasyon Oluşturma
    Given kullanıcı Virtual Staging sayfasındadır
    When kullanıcı desteklenen formatta jpg veya png uzantılı bir oda görselini sisteme yükler
    And mevcut mobilyaları kaldır toggle butonunun varsayılan olarak açık geldiği doğrulanır
    And kullanıcı oda türü olarak Oturma Odası ve tasarım stili olarak Modern seçer
    And dekorasyon oluştur butonuna tıklar
    Then sistem yüklenen odanın seçilen stil ve oda türüne uygun mobilyalandırılmış halini başarıyla üretir ve ekranda gösterir

  @negative @staging @validation
  Scenario Outline: Eksik Parametrelerle Sanal Dekorasyon Oluşturma
    Given kullanıcı Virtual Staging sayfasındadır
    When kullanıcı desteklenen formatta bir oda görselini sisteme yükler
    And kullanıcı oda türü olarak OdaTuru ve tasarım stili olarak Stil seçer
    And dekorasyon oluştur butonuna tıklar
    Then sistem dekorasyon işlemini gerçekleştirmez
    And lütfen zorunlu alanları doldurun hata mesajı görüntülenir

    Examples:
      | OdaTuru      | Stil        |
      | Oturma Odası | Secilmedi   |
      | Secilmedi    | Modern      |
      | Secilmedi    | Secilmedi   |

  @edge_case @staging @file_format
  Scenario Outline: Desteklenmeyen Dosya Formatı ile Görsel Yükleme
    Given kullanıcı Virtual Staging sayfasındadır
    When kullanıcı sistemde desteklenmeyen formatta DosyaFormati uzantılı bir görsel yüklemeye çalışır
    Then sistem görseli kabul etmez
    And desteklenmeyen dosya formatı lütfen jpg veya png yükleyin şeklinde bir hata mesajı gösterir

    Examples:
      | DosyaFormati |
      | gif          |
      | bmp          |
      | webp         |
      | pdf          |
      | tiff         |

  @edge_case @staging @file_size
  Scenario: Maksimum Dosya Boyutu Sınırında Görsel Yükleme
    Given kullanıcı Virtual Staging sayfasındadır
    When kullanıcı izin verilen maksimum dosya boyut sınırında tam 10MB bir görsel yükler
    Then sistem görseli başarıyla kabul eder ve yükleme tamamlanır

  @negative @staging @file_size
  Scenario: İzin Verilen Boyuttan Büyük Görsel Yükleme
    Given kullanıcı Virtual Staging sayfasındadır
    When kullanıcı izin verilen maksimum boyuttan büyük 15MB bir görsel seçip yüklemeye çalışır
    Then sistem yüklemeyi reddeder
    And dosya boyutu çok büyük maksimum 10MB yükleyebilirsiniz hata mesajı gösterir

  @positive @staging @toggle
  Scenario: Mevcut Mobilyaları Kaldır Toggle Durumunu Değiştirme
    Given kullanıcı Virtual Staging sayfasındadır
    And kullanıcı bir oda görseli yüklemiştir
    When kullanıcı mevcut mobilyaları kaldır toggle butonunu kapalı konumuna getirir
    And oda türü ve tasarım stili seçip dekorasyon oluştur butonuna tıklar
    Then sistem mevcut mobilyaları koruyarak yeni dekorasyonu buna göre üretir

  @positive @ai_edit
  Scenario: Kaynak Görsel Üzerinde Başarılı AI Edit Uygulama
    Given kullanıcı AI Edit sayfasındadır
    And kaynak görsel seçili durumdadır
    When kullanıcı describe what to change alanına remove the chair talimatını girer
    And edit photo butonuna tıklar
    Then sistem girilen talimata uygun şekilde güncellenmiş yeni görseli ekranda gösterir

  @negative @ai_edit @validation
  Scenario Outline: Boş veya Geçersiz Talimat ile AI Edit Uygulama
    Given kullanıcı AI Edit sayfasındadır
    And kaynak görsel seçili durumdadır
    When kullanıcı describe what to change alanına Talimat girer
    And edit photo butonuna tıklar
    Then sistem düzenleme işlemini gerçekleştirmez
    And talimat alanının zorunlu olduğunu belirten bir uyarı mesajı gösterir

    Examples:
      | Talimat   |
      | Bos       |
      |           |

  @edge_case @ai_edit @character_limit
  Scenario: Maksimum Karakter Sınırını Aşan AI Edit Talimatı
    Given kullanıcı AI Edit sayfasındadır
    And kaynak görsel seçili durumdadır
    When kullanıcı describe what to change alanına 500 karakterden uzun bir metin girer
    Then sistem input alanının daha fazla karakter almasını engeller

  @positive @navigation
  Scenario: Yapay Zeka Sanal Tur Sayfasına Ulaşım ve Erken Erişim Talebi
    Given kullanıcı ana sayfadadır
    When kullanıcı header alanındaki ürünler menüsünün üzerine gelir
    And açılan listeden yapay zeka sanal tur seçeneğine tıklar
    Then kullanıcı tr ai virtual tour sayfasına yönlendirilir
    When kullanıcı erken erişim isteyin butonuna tıklar ve geçerli bir eposta adresi girip talebi gönderirse
    Then sistem talebin başarıyla alındığına dair onay mesajı gösterir

  @positive @navigation
  Scenario: Sanal Dekorasyon API Sayfası İletişim ve Fiyatlandırma Yönlendirmesi
    Given kullanıcı ana sayfadadır
    When kullanıcı header alanındaki ürünler menüsünün üzerine gelir
    And açılan listeden sanal dekorasyon api seçeneğine tıklar
    Then kullanıcı tr api sayfasına yönlendirilir
    When kullanıcı üst kısımdaki iletişime geçin butonuna tıklar ve zorunlu alanları doldurarak formu gönderirse
    Then sistem başarı mesajı gösterir
    When kullanıcı alt kısımdaki fiyatlandırmayı görüntüle butonuna tıklarsa
    Then kullanıcı fiyatlandırma sayfasına yönlendirilir

  @edge_case @navigation
  Scenario: Header Ürünler Menüsü Dışına Tıklama
    Given kullanıcı ana sayfadadır
    When kullanıcı header alanındaki ürünler menüsünün üzerine gelip imleci menü dışına çekerse
    Then açılan alt ürünler listesi otomatik olarak kapanır

  @negative @forms @validation
  Scenario Outline: Erken Erişim veya İletişim Formunu Eksik Alanlarla Gönderme
    Given kullanıcı erken erişim veya iletişim formu sayfasındadır
    When kullanıcı formda ad alanına Ad, eposta alanına Eposta ve mesaj alanına Mesaj girer
    And gönder butonuna tıklar
    Then form gönderilmez
    And ilgili zorunlu alanlar için validasyon hata mesajları görüntülenir

    Examples:
      | Ad       | Eposta           | Mesaj   |
      | Bos      | test@example.com | Merhaba |
      | John Doe | Bos              | Merhaba |
      | John Doe | test@example.com | Bos     |
      | Bos      | Bos              | Bos     |

  @edge_case @forms @email_format
  Scenario Outline: Geçersiz E-posta Formatı ile Form Gönderimi
    Given kullanıcı form sayfasındadır
    When kullanıcı formdaki e-posta alanına GecersizEmail girer
    And diğer zorunlu alanları doldurup gönder butonuna tıklar
    Then form gönderilmez
    And lütfen geçerli bir eposta adresi girin hata mesajı gösterir

    Examples:
      | GecersizEmail              |
      | plainaddress               |
      | domain.com                 |
      | Joe Smith email@domain.com |
      | email@domain               |
      | email@.com                 |