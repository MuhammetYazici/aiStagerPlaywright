Feature: AiStager.ai Platform Temel Yetkinlikleri ve Ürün Navigasyonu
  Sisteme giriş yapmış bir kullanıcı olarak, sanal dekorasyon yapabilmek,
  görselleri düzenleyebilmek, diğer ürünleri keşfedebilmek ve talep oluşturabilmek istiyorum.

  @Positive @VirtualStaging
  Scenario: Başarılı Sanal Dekorasyon Üretimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta geçerli bir görsel yükler BR-01
    And Kullanıcı zorunlu alanlar olan Oda Türü ve Tasarım Stili seçimini yapar BR-02
    And Mevcut mobilyaları kaldır toggle unsurunun varsayılan olarak açık olduğunu görür BR-03
    And Kullanıcı görünürlük tercihi için radyo butonlardan birini seçer BR-04
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem yapay zeka aracılığıyla odayı istenen konseptte mobilyalandırarak yeni görseli üretir BR-05
    And Başarılı üretim görseli ekranda görüntülenir

  @Negative @VirtualStaging
  Scenario Outline: Desteklenmeyen Format ile Sanal Dekorasyon Yükleme Girişimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatta <dosya_tipi> bir görsel yüklemeye çalışır BR-01
    Then Sistem Geçersiz dosya formatı hata mesajını gösterir
    And Dekorasyon Oluştur butonu pasif kalır veya işlem engellenir

    Examples:
      | dosya_tipi |
      | ".pdf"     |
      | ".gif"     |

  @Negative @VirtualStaging
  Scenario: Zorunlu Alanlar Eksikken Dekorasyon Oluşturma Girişimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir görsel yükler BR-01
    And Kullanıcı Oda Türü veya Tasarım Stili alanlarından birini veya ikisini boş bırakır BR-02
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem zorunlu alanların doldurulması gerektiğine dair uyarı mesajı gösterir
    And Yeni görsel üretim süreci başlamaz

  @EdgeCase @VirtualStaging
  Scenario: Maksimum İzin Verilen Boyutta Görsel Yükleme
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı sistem tarafından kabul edilen maksimum dosya boyut sınırındaki görseli yükler BR-01
    And Zorunlu alanları doldurur BR-02
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem yükleme işlemini başarıyla tamamlar ve görseli işler

  @EdgeCase @VirtualStaging
  Scenario: Mevcut Mobilyaları Kaldır Toggle Durumunun Manuel Değiştirilmesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir görsel yükler ve zorunlu alanları seçer BR-01 BR-02
    And Kullanıcı varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle unsurunu kapatır BR-03
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem mevcut mobilyaları koruyarak veya talimata göre dekorasyon çıktısı üretir

  @Positive @AIEdit
  Scenario: Current Image Üzerinden Başarılı AI Edit Yapılması
    Given Kullanıcı AI Edit sayfasındadır
    When Kullanıcı kaynak görsel olarak Current image seçimini yapar veya yeni bir görsel yükler BR-06
    And Kullanıcı Describe what to change alanına "Pencerenin önüne gri bir berjer ekle" serbest metin talimatını girer BR-07
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem girilen talimata uygun olarak görseli günceller ve yeni hali gösterir BR-07

  @Negative @AIEdit
  Scenario: Boş Talimat Metni ile AI Edit Yapma Girişimi
    Given Kullanıcı AI Edit sayfasındadır
    When Kullanıcı kaynak görsel seçer BR-06
    And Kullanıcı Describe what to change alanını boş bırakır BR-07
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem Lütfen bir düzenleme talimatı girin şeklinde uyarı mesajı verir
    And Düzenleme işlemi gerçekleştirilemez

  @EdgeCase @AIEdit
  Scenario: Anlamsız veya Çok Uzun Metin Talimatı ile AI Edit Girişimi
    Given Kullanıcı AI Edit sayfasındadır
    When Kullanıcı kaynak görsel seçer BR-06
    And Kullanıcı Describe what to change alanına sistemin işleyemeyeceği kadar uzun veya anlamsız karakter dizisi girer BR-07
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem işlemi yönetir ve kullanıcıya yapay zekanın talimatı anlamadığına dair bilgilendirme mesajı gösterir

  @Positive @Navigation
  Scenario: Header Üzerinden Alt Ürünlerin Listelenmesi
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı Header alanındaki Ürünler menüsünün üzerine hover yapar
    Then Alt ürünlerin Yapay Zeka Sanal Tur ve Sanal Dekorasyon API listelendiği doğrulanır BR-08

  @Positive @VirtualTour
  Scenario: Yapay Zeka Sanal Tur Erken Erişim Talebinin Başarıyla Gönderilmesi
    Given Kullanıcı Header Ürünler menüsünden Yapay Zeka Sanal Tur seçeneğine tıklar
    When Kullanıcı "/tr/ai-virtual-tour" sayfasına yönlendirildiğini doğrular BR-09
    And Kullanıcı sayfadaki Erken Erişim formunu geçerli bilgilerle doldurur
    And Kullanıcı formu gönderir
    Then Sistem başarı onay mesajı görüntüler ve talebin alındığını bildirir BR-09

  @Negative @VirtualTour
  Scenario: Eksik Bilgilerle Sanal Tur Erken Erişim Formu Gönderme Girişimi
    Given Kullanıcı "/tr/ai-virtual-tour" sayfasındadır BR-09
    When Kullanıcı erken erişim formundaki zorunlu e-posta alanını boş bırakır
    And Kullanıcı formu gönderir
    Then Sistem alanların zorunlu olduğuna dair hata mesajları gösterir
    And Talep iletilemez

  @Positive @APIProduct
  Scenario: Sanal Dekorasyon API İletişim Formu ve Fiyatlandırma Yönlendirmesi
    Given Kullanıcı Header Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar
    When Kullanıcı "/tr/api" sayfasına yönlendirildiğini doğrular BR-10
    And Kullanıcı sayfadaki iletişim formunu doldurup başarıyla gönderir BR-10
    And Kullanıcı sayfada yer alan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcının doğru fiyatlandırma hedef sayfasına yönlendirildiği doğrulanır BR-10

  @EdgeCase @APIProduct
  Scenario Outline: API Sayfasındaki Fiyatlandırma Butonunun Erişilebilirliği
    Given Kullanıcı "/tr/api" sayfasındadır BR-10
    When Sayfa <cihaz_tipi> ekran çözünürlüklerinde görüntülenir
    Then Fiyatlandırmayı Görüntüle butonunun her cihazda görünür ve tıklanabilir olduğu doğrulanır
    And Butona tıklandığında kullanıcıyı ilgili sayfaya hatasız ulaştırdığı onaylanır BR-10

    Examples:
      | cihaz_tipi |
      | Mobil      |
      | Tablet     |
      | Desktop    |