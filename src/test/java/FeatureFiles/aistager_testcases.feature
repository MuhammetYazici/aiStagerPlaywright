Feature: AI Stager Platformu Fonksiyonel Testleri

  Background:
    Given kullanıcı ana sayfadadır

  @US-01 @Positive
  Scenario: Geçerli formatta görsel yükleme ve zorunlu alanlarla dekorasyon oluşturמה
    Given kullanıcı Sanal Dekorasyon sayfasındadır
    And kullanıcı desteklenen formatta bir görsel yükler
    And kullanıcı Oda Türü olarak Yatak Odası seçer
    And kullanıcı Tasarım Stili olarak Modern seçer
    And Mevcut mobilyaları kaldır toggle butonu açık durumdadır
    When kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then sistem yüklenen görseli analiz etmeli ve mobilyalandırılmış yeni görseli kullanıcıya sunmalıdır

  @US-01 @Negative @EdgeCase
  Scenario Outline: Desteklenmeyen dosya formatında görsel yükleme reddi
    Given kullanıcı Sanal Dekorasyon sayfasındadır
    When kullanıcı sistem tarafından desteklenmeyen <dosya_formati> formatında bir dosya yüklemeye çalışır
    Then sistem hata mesajı göstermelidir ve görsel yükleme işlemi başarısız olmalıdır

    Examples:
      | dosya_formati |
      | "dosya.pdf"   |
      | "animasyon.gif"|

  @US-01 @Negative
  Scenario: Zorunlu alanlar seçilmeden Dekorasyon Oluştur butonunun pasif kalması
    Given kullanıcı Sanal Dekorasyon sayfasındadır
    And kullanıcı geçerli bir görsel yükler
    When kullanıcı Oda Türü veya Tasarım Stili alanlarından birini boş bırakır
    Then Dekorasyon Oluştur butonu pasif olmalıdır

  @US-01 @Positive
  Scenario: Mevcut mobilyaları kaldır varsayılan ayarının kontrolü
    Given kullanıcı Sanal Dekorasyon sayfasındadır
    When kullanıcı geçerli bir görsel yükler
    Then Mevcut mobilyaları kaldır toggle butonunun durumu açık olarak gelmelidir

  @US-02 @Positive
  Scenario: Varsayılan kaynak görsel ve metinsel talimatla AI Edit yapılması
    Given kullanıcı AI Edit sekmesindedir
    And varsayılan olarak Current image kaynak görsel seçili gelmektedir
    When kullanıcı Describe what to change alanına "Duvarı maviye boya ve halı ekle" talimatını girer
    And kullanıcı Edit Photo butonuna tıklar
    Then sistem talimatı işlemeli ve değiştirilmiş görseli ekranda göstermelidir

  @US-02 @Positive
  Scenario: Alternatif kaynak görsel yükleyerek AI Edit yapılması
    Given kullanıcı AI Edit sekmesindedir
    When kullanıcı Current image yerine alternatif yeni bir kaynak görsel yükler
    And kullanıcı Describe what to change alanına talimat girer
    And kullanıcı Edit Photo butonuna tıklar
    Then sistem yeni yüklenen görsel üzerinden değişiklikleri uygulamalı ve sonucu göstermelidir

  @US-02 @Negative
  Scenario: Talimat girilmeden AI Edit yapılmasına izin verilmemesi
    Given kullanıcı AI Edit sekmesindedir
    And kullanıcı kaynak görsel seçmiştir
    And kullanıcı Describe what to change alanını boş bırakır
    When kullanıcı Edit Photo butonuna tıklar
    Then sistem düzenleme işlemini gerçekleştirmemeli ve hata mesajı göstermelidir

  @US-03 @Positive
  Scenario: Header menüsünden Yapay Zeka Sanal Tur sayfasına başarılı navigasyon
    When kullanıcı header alanındaki Ürünler dropdown menüsünün üzerine gelir
    And kullanıcı Yapay Zeka Sanal Tur seçeneğine tıklar
    Then kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir

  @US-03 @Positive
  Scenario: Sanal Tur sayfasında erken erişim talebi oluşturma ve başarılı onay alma
    Given kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When kullanıcı sayfa üzerindeki Erken Erişim İsteyin butonuna tıklar
    And kullanıcı zorunlu e-posta alanına "test@example.com" girer
    And kullanıcı formu gönderirse
    Then sistem talebi kaydetmeli ve kullanıcıya başarılı iletim onay mesajı göstermelidir

  @US-03 @Negative @EdgeCase
  Scenario Outline: Erken erişim formunda zorunlu alanların boş bırakılması
    Given kullanıcı Erken Erişim İsteyin modalındadır
    When kullanıcı zorunlu e-posta alanını <giris_tipi> girerek gönder butonuna tıklar
    Then sistem talebi kabul etmemeli ve e-posta uyarı mesajı vermelidir

    Examples:
      | giris_tipi      |
      | boş bırakarak   |
      | "gecersiz-email"|

  @US-04 @Positive
  Scenario: Header menüsünden Sanal Dekorasyon API sayfasına başarılı navigasyon
    When kullanıcı header alanındaki Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar
    Then kullanıcı aistager.ai/tr/api sayfasına yönlendirilmelidir

  @US-04 @Positive
  Scenario: Sanal Dekorasyon API sayfasından iletişim formu gönderimi
    Given kullanıcı aistager.ai/tr/api sayfasındadır
    When kullanıcı üst kısımda yer alan İletişime Geçin butonuna tıklar
    And kullanıcı ad, e-posta ve mesaj alanlarını geçerli bilgilerle doldurur
    And kullanıcı formu gönderirse
    Then sistem talebi başarıyla iletmeli ve onay mesajı göstermelidir

  @US-04 @Negative
  Scenario: API iletişim formunda eksik alanlarla gönderim denemesi
    Given kullanıcı API iletişim formundadır
    When kullanıcı zorunlu alanlardan birini boş bırakıp göndermeye çalışır
    Then sistem formun gönderilmesine izin vermemeli ve eksik alan uyarılarını göstermelidir

  @US-04 @Positive
  Scenario: Sanal Dekorasyon API sayfasından Fiyatlandırma sayfasına yönlendirme
    Given kullanıcı aistager.ai/tr/api sayfasındadır
    And kullanıcı sayfanın alt kısmına kaydırma yapar
    When kullanıcı Fiyatlandırmayı Görüntüle butonuna tıklar
    Then kullanıcı Fiyatlandırma sayfasına yönlendirilmelidir