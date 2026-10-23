Feature: AiStager.ai Sanal Dekorasyon, Yapay Zeka Düzenleme ve Ürün Yönetimi

  Background:
    Given Kullanıcı web sitesi ana sayfasına erişir

  Scenario: Geçerli parametreler ile başarılı sanal dekorasyon üretimi
    Given Kullanıcı oturum açarak "Virtual Staging" sayfasına gider
    When Kullanıcı "salon.jpg" dosyasını yükler
    Then Yüklenen görselin önizlemesi ekranda görüntülenmelidir
    And Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak açık durumda olduğu doğrulanır
    When Kullanıcı Oda Türü alanından "Oturma Odası" değerini seçer
    And Kullanıcı Tasarım Stili alanından "Modern" değerini seçer
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem görsel işleme sürecini başlatmalıdır
    And İşlem tamamlandığında seçilen parametrelere uygun mobilyalandırılmış çıktı görseli önizleme alanında sunulmalıdır

  Scenario Outline: Desteklenmeyen dosya formatı yüklendiğinde sistemin hata vermesi
    Given Kullanıcı oturum açarak "Virtual Staging" sayfasına gider
    When Kullanıcı sisteme geçersiz formattaki "<dosya_adi>" dosyasını yüklemeyi dener
    Then Ekranda yalnızca JPG veya PNG formatlarının desteklendiğini belirten hata mesajı görüntülenmelidir
    And Görsel önizleme alanı boş kalmalıdır

    Examples:
      | dosya_adi    |
      | plan.pdf     |
      | animasyon.gif|
      | model.bmp    |
      | metin.txt    |

  Scenario: Zorunlu parametreler seçilmeden dekorasyon sürecinin başlatılamaması
    Given Kullanıcı oturum açarak "Virtual Staging" sayfasına gider
    When Kullanıcı "bos-oda.png" dosyasını yükler
    And Görsel önizlemesinin ekranda olduğunu doğrular
    But Oda Türü ve Tasarım Stili dropdown alanlarını boş bırakır
    Then Dekorasyon Oluştur butonu pasif durumda olmalıdır ve işlem başlatılamamalıdır

  Scenario: Metin tabanlı talimat ile görsel üzerinde başarılı yapay zeka düzenlemesi yapma
    Given Kullanıcı oturum açarak "Virtual Staging" altındaki "AI Edit" sekmesine gider
    And Düzenlenecek kaynak görselin sistemde seçili olduğunu doğrular
    When Kullanıcı Describe what to change alanına "Remove the chair" talimatını girer
    And Edit Photo butonuna tıklar
    Then Sistem talimata uygun olarak işlenmiş yeni görseli ekranda başarıyla görüntülemelidir

  Scenario Outline: AI Edit alanına boş veya geçersiz girdi sağlandığında işlemin engellenmesi
    Given Kullanıcı oturum açarak "Virtual Staging" altındaki "AI Edit" sekmesine gider
    And Düzenlenecek kaynak görselin sistemde seçili olduğunu doğrular
    When Kullanıcı Describe what to change alanına "<gecersiz_girdi>" yazar
    Then Edit Photo butonu işlem başlatmamalıdır
    And Ekranda geçerli bir komut girilmesini isteyen doğrulama mesajı görüntülenmelidir

    Examples:
      | gecersiz_girdi |
      |                |
      |    !@#$%^&*    |
      | ??????         |

  Scenario: Menüden Yapay Zeka Sanal Tur sayfasına geçiş ve erken erişim formu gönderimi
    When Kullanıcı menüdeki Ürünler seçeneğine tıklar
    And Açılan menünün ikinci sırasındaki Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı doğrudan "/tr/ai-virtual-tour" adresine yönlendirilmelidir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Erken erişim formundaki e-posta alanına "test.kullanici@aistager.ai" yazar
    And Form gönder butonuna tıklar
    Then Kullanıcıya talebin alındığına dair onay bildirim mesajı gösterilmelidir

  Scenario: Geçersiz e-posta adresi ile erken erişim formu gönderiminin engellenmesi
    Given Kullanıcı doğrudan "/tr/ai-virtual-tour" sayfasına gider
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Erken erişim formundaki e-posta alanına "hatali-eposta-formati" yazar
    And Form gönder butonuna tıklar
    Then Form gönderilmemelidir
    And Ekranda geçerli bir e-posta adresi girilmesi gerektiğine dair hata uyarısı gösterilmelidir

  Scenario: Sanal Dekorasyon API iletişim formu iletimi ve fiyatlandırma navigasyonu
    When Kullanıcı menüdeki Ürünler seçeneğine tıklar
    And Açılan menünün üçüncü sırasındaki Sanal Dekorasyon API bağlantısına tıklar
    Then Kullanıcı doğrudan "/tr/api" adresine yönlendirilmelidir
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Açılan form üzerindeki tüm zorunlu alanları geçerli bilgilerle doldurur
    And Form gönder butonuna tıklar
    Then Ekranda formun başarıyla iletildiğini belirten onay bildirimi görüntülenmelidir
    When Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı ilgili Fiyatlandırma sayfasına hatasız yönlendirilmelidir

  Scenario: API iletişim formunun zorunlu alanlar doldurulmadan gönderilememesi
    Given Kullanıcı doğrudan "/tr/api" sayfasına gider
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Form üzerindeki zorunlu alanları doldurmadan Form gönder butonuna tıklar
    Then Form iletilmemelidir
    And Eksik alanların doldurulmasını belirten doğrulama uyarıları görüntülenmelidir