Feature: Yapay Zeka Destekli Platform Testleri

  Background:
    Given Kullanıcı AiStager platformundadır

  @US-001 @Positive @BR-001 @BR-002
  Scenario: Başarılı bir şekilde sanal dekorasyon oluşturma Mutlu Yol
    Given Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta bir boş oda görseli yükler ".jpg" veya ".png"
    Then Kullanıcı yüklenen görselin önizlemesini görebilmelidir
    And "Oda Türü" olarak "Oturma Odası" seçilir
    And "Tasarım Stili" olarak "Modern" seçilir
    And Mevcut mobilyaları kaldır toggle ının varsayılan olarak açık olduğu görülür
    And Kullanıcı görünürlük tercihi için bir radio buton seçer
    And Dekorasyon Oluştur butonunun aktif olduğu görülür
    When Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem odayı seçilen oda türü ve stile uygun şekilde mobilyalandırarak kullanıcıya sunar

  @US-001 @Negative @BR-001
  Scenario: Desteklenmeyen formatta görsel yükleme girişimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatta bir görsel yükler ".gif" veya ".bmp"
    Then Sistem hata mesajı gösterir ve görsel yükleme başarısız olur
    And Dekorasyon Oluştur butonu pasif kalır

  @US-001 @EdgeCase @BR-002
  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturma denemesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir oda görseli yükler
    And "Oda Türü" ve "Tasarım Stili" seçimleri boş bırakılır
    Then Dekorasyon Oluştur butonunun pasif disabled olduğu görülür

  @US-001 @EdgeCase @BR-002
  Scenario: Mevcut mobilyaları kaldır toggle durumunu değiştirme
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir oda görseli yükler
    And "Oda Türü" ve "Tasarım Stili" zorunlu seçimleri yapılır
    And Varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle ı kullanıcı tarafından kapatılır
    When Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem mevcut mobilyaları koruyarak yeni dekorasyonu uygular

  @US-002 @Positive @BR-004 @BR-005 @BR-006
  Scenario: Mevcut kaynak görsel ile yapay zeka destekli düzenleme yapma
    Given Kullanıcı "AI Edit" sayfasındadır
    Then AI Edit sekmesinde mevcut görselin "Current image" varsayılan olarak kaynak seçili olduğu görülür
    And Seçilen kaynak görselin önizlemesi ekranda görüntülenir
    When Kullanıcı Describe what to change alanına Remove the chair metinsel talimatını girer
    And "Edit Photo" butonuna tıklanır
    Then Sistem kullanıcının metin talimatına uygun şekilde güncellenmiş yeni görseli ekranda gösterir

  @US-002 @Positive @BR-004
  Scenario: Yeni görsel yükleyerek AI Edit aracını kullanma
    Given Kullanıcı "AI Edit" sayfasındadır
    When Kullanıcı sistem üzerinden yeni bir kaynak görsel yükler
    Then Yüklenen yeni görselin önizlemesi ekranda gösterilir
    And Kullanıcı Describe what to change alanına düzenleme talimatı yazar
    When "Edit Photo" butonuna tıklanır
    Then Sistem güncellenmiş yeni görseli ekranda gösterir

  @US-002 @Negative @BR-005
  Scenario: Metin talimatı girmeden düzenleme yapma denemesi
    Given Kullanıcı "AI Edit" sayfasındadır
    And Kaynak görsel seçilidir
    When Describe what to change alanı boş bırakılır
    And "Edit Photo" butonuna tıklanır
    Then Sistem kullanıcıyı uyararak hata mesajı gösterir ve işlem gerçekleşmez

  @US-003 @Positive @BR-007
  Scenario: Yapay Zeka Sanal Tur sayfasına gidilmesi ve erken erişim talebi oluşturulması
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler menüsüne hover yapar
    And Açılan alt seçeneklerden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilmelidir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan form üzerinden geçerli e-posta ve zorunlu bilgiler doldurulur
    And Form gönder butonuna tıklanır
    Then Bilgilerin başarıyla gönderildiğine dair onay mesajı alınır

  @US-003 @Negative @BR-007
  Scenario: Erken erişim formunu eksik bilgilerle gönderme denemesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındaki Erken Erişim İsteyin formunu açar
    And E-posta alanı boş bırakılarak gönder butonuna tıklanır
    Then Sistem zorunlu alan uyarı mesajlarını gösterir ve form gönderilmez

  @US-003 @Positive @BR-008
  Scenario: Sanal Dekorasyon API sayfası iletişim formu ve fiyatlandırma yönlendirmesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler menüsüne hover yapar
    And Açılan alt seçeneklerden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilmelidir
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Açılan iletişim formu zorunlu alanları doldurularak gönderilir
    Then Talebin başarıyla iletildiğine dair onay mesajı görüntülenir
    When Kullanıcı sayfanın alt kısmında bulunan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilir

  @US-003 @EdgeCase @BR-008
  Scenario: API İletişim formunda geçersiz e-posta formatı kullanımı
    Given Kullanıcı ana sayfadadır
    When Kullanıcı "aistager.ai/tr/api" sayfasındaki İletişime Geçin formunu açar
    And Formdaki e-posta alanına format dışı bir metin girilir Örn: "gecersiz-eposta"
    And Form gönderilir
    Then Sistem e-posta format hatası mesajı gösterir ve talep iletilmez