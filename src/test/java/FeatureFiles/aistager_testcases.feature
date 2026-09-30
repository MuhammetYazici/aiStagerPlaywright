Feature: AiStager Platform Test Senaryoları

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @US-01
  Scenario: Geçerli formatta görsel yükleme ve başarılı dekorasyon oluşturma
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı jpg veya png formatında geçerli bir oda görselini yükler
    Then Görselin önizlemesi ekranda görüntülenmelidir
    And Mevcut mobilyaları kaldır toggle özelliğinin varsayılan olarak açık olduğu görülmelidir
    When Kullanıcı "Oda Türü" ve "Tasarım Stili" seçimlerini yapar
    And Kullanıcı Görünürlük seçeneğini belirler
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then İşlem tamamlandığında yapay zeka tarafından mobilyalandırılmış yeni görsel ekranda sunulmalıdır

  @Negative @US-01
  Scenario Outline: Desteklenmeyen dosya formatı ile görsel yükleme denemesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı "<gecersiz_format>" formatında bir dosya yüklemeye çalışır
    Then Sistem hata mesajı göstermeli ve görsel önizlemesi oluşmamalıdır

    Examples:
      | gecersiz_format |
      | pdf             |
      | gif             |
      | tiff            |
      | exe             |

  @Negative @US-01
  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturma denemesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı geçerli bir görsel yükler
    And Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Dekorasyon Oluştur butonu pasif kalmalı veya uyarı mesajı verilerek işlem başlatılmamalıdır

  @EdgeCase @US-01
  Scenario: Çok büyük boyutlu dosya yükleme sınırı
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı sistemin izin verdiği maksimum boyut sınırını aşan bir jpg görseli yükler
    Then Sistem dosya boyutunun çok büyük olduğuna dair bir hata mesajı göstermelidir

  @Positive @US-02
  Scenario Outline: Mevcut kaynak görsel ile metin komutu kullanarak fotoğraf düzenleme
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "AI Edit" sekmesindedir
    Then Edit photo source alanında varsayılan olarak Current image seçili gelmelidir
    When Kullanıcı Describe what to change alanına serbest metin olarak "<talimat>" girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem girilen talimata uygun şekilde güncellenmiş görseli kullanıcıya göstermelidir

    Examples:
      | talimat                   |
      | Remove the chair          |
      | Add a modern floor lamp   |
      | Change wall color to blue |

  @Negative @US-02
  Scenario: Boş metin komutu ile düzenleme yapma denemesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "AI Edit" sekmesindedir
    And Kaynak görsel seçilidir veya yüklenmiştir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem Edit Photo işlemini gerçekleştirmemeli ve zorunlu alan uyarısı vermelidir

  @EdgeCase @US-02
  Scenario: Çok uzun veya özel karakter içeren metin komutu girilmesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı "AI Edit" sekmesindedir
    And Kaynak görsel seçilidir veya yüklenmiştir
    When Kullanıcı metin kutusuna çok uzun bir açıklama metni veya SQL enjeksiyon karakterleri girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem girdiyi güvenli şekilde işleme almalı veya uygun karakter sınırı uyarısı göstermelidir

  @Positive @US-03
  Scenario: Ürünler menüsünden Sanal Tur sayfasına gitme ve erken erişim talebi oluşturma
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir
    Then Dropdown menü açılmalıdır
    When Kullanıcı dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan form içerisine geçerli bir e-posta adresi girer
    And Kullanıcı talebi gönderir
    Then Sistem talebin başarıyla alındığına dair bir onay mesajı göstermelidir

  @Negative @US-03
  Scenario Outline: Geçersiz e-posta formatı ile erken erişim talebi gönderme
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Form alanına "<gecersiz_eposta>" girer
    And Kullanıcı talebi gönderir
    Then Sistem e-posta format hatası vermeli ve talep kaydedilmemelidir

    Examples:
      | gecersiz_eposta |
      | testuser        |
      | test@.com       |
      | test@domain     |
      | @domain.com     |

  @EdgeCase @US-03
  Scenario: Boş e-posta alanı ile erken erişim talebi gönderme
    Given Kullanıcı Erken Erişim İsteyin formunu açmıştır
    When Kullanıcı e-posta alanını boş bırakarak gönder butonuna tıklar
    Then Sistem alanın boş bırakılamayacağına dair zorunlu alan uyarısı vermelidir

  @Positive @US-04
  Scenario: API sayfasına erişim, iletişim formu doldurma ve fiyatlandırma sayfasına gitme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir
    And Dropdown menüden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/api sayfasına yönlendirilmelidir
    When Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar
    And İletişim formundaki Ad E-posta ve Mesaj alanlarını geçerli bilgilerle doldurur
    And Kullanıcı formu gönderir
    Then Sistem başarı mesajı göstermelidir
    When Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  @Negative @US-04
  Scenario Outline: API iletişim formunda eksik alan bırakarak gönderme denemesi
    Given Kullanıcı aistager.ai/tr/api sayfasındaki iletişim formundadır
    When Kullanıcı formda Ad: "<ad>", E-posta: "<eposta>", Mesaj: "<mesaj>" alanlarını girer
    And Kullanıcı formu göndermeye çalışır
    Then Sistem eksik alanlar için uyarı mesajı göstermelidir ve form gönderilmemelidir

    Examples:
      | ad   | eposta        | mesaj              |
      |      | test@test.com | API hakkında bilgi |
      | John |               | API hakkında bilgi |
      | John | test@test.com |                    |

  @EdgeCase @US-04
  Scenario: Sayfa altındaki Fiyatlandırma butonunun görünürlüğü ve erişilebilirliği
    Given Kullanıcı aistager.ai/tr/api sayfasına gelmiştir
    When Kullanıcı sayfanın en altına kadar kaydırma yapar
    Then Fiyatlandırmayı Görüntüle butonu görünür ve tıklanabilir durumda olmalıdır
    When Kullanıcı bu butona hızlıca üst üste iki kez tıklar
    Then Sistem mükerrer yönlendirme veya hata üretmeden kullanıcıyı Fiyatlandırma sayfasına ulaştırmalıdır