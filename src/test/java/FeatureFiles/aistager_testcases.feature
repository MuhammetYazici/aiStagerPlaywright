Feature: AiStager.ai Çekirdek Yetenekler, Görsel Düzenleme ve Lead Generation Akışları

  Background:
    Given Kullanıcı sisteme giriş yapmış durumda

  @US-AI-01 @Positive @HappyPath
  Scenario: Başarılı Sanal Dekorasyon Oluşturma Happy Path
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta "jpg" bir oda görseli yükler
    And Oda Türü olarak Yatak Odası seçilir
    And Tasarım Stili olarak Modern seçilir
    And Mevcut mobilyaları kaldır toggle özelliğinin varsayılan olarak açık olduğu doğrulanır
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem yüklenen odayı analiz eder
    And Seçilen stile uygun mobilyalandırılmış yeni görsel kullanıcıya sunulur

  @US-AI-01 @Negative @EdgeCase
  Scenario Outline: Desteklenmeyen Görsel Formatı ile Sanal Dekorasyon Denemesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatta bir oda görseli yükler "<gecersiz_format>"
    And Oda Türü ve Tasarım Stili alanları seçilir
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem "<hata_mesaji>" şeklinde bir hata mesajı gösterir
    And Dekorasyon işlemi başlatılamaz

    Examples:
      | gecersiz_format | hata_mesaji                                     |
      | test.gif        | Yalnızca JPG ve PNG formatları desteklenmektedir |
      | document.pdf    | Yalnızca JPG ve PNG formatları desteklenmektedir |
      | image.bmp       | Yalnızca JPG ve PNG formatları desteklenmektedir |

  @US-AI-01 @Negative @EdgeCase
  Scenario: Zorunlu Alanlar Eksikken Dekorasyon Oluşturma Denemesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Desteklenen formatta bir oda görseli yüklenir
    And Oda Türü ve Tasarım Stili seçimleri boş bırakılır
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajı gösterir
    And Dekorasyon Oluştur butonu pasif kalır veya işlem gerçekleşmez

  @US-AI-01 @Negative
  Scenario: Sadece Oda Türü Seçilip Tasarım Stili Boş Bırakıldığında
    Given Kullanıcı Virtual Staging sayfasındadır
    When Desteklenen formatta bir oda görseli yüklenir
    And Oda Türü olarak Oturma Odası seçilir ancak Tasarım Stili seçilmez
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem tasarım stilinin seçilmesi gerektiğini belirten bir hata mesajı gösterir

  @US-AI-01 @Negative
  Scenario: Sadece Tasarım Stili Seçilip Oda Türü Boş Bırakıldığında
    Given Kullanıcı Virtual Staging sayfasındadır
    When Desteklenen formatta bir oda görseli yüklenir
    And Tasarım Stili olarak Skandinav seçilir ancak Oda Türü seçilmez
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem oda türünün seçilmesi gerektiğini belirten bir hata mesajı gösterir

  @US-AI-01 @EdgeCase
  Scenario: Mevcut Mobilyaları Kaldır Toggle Varsayılan Durum Kontrolü
    Given Kullanıcı Virtual Staging sayfasındadır
    When Sayfa ilk kez yüklendiğinde veya sıfırlandığında
    Then Mevcut mobilyaları kaldır toggle durumunun açık olduğu doğrulanır

  @US-AI-01 @Positive @HappyPath
  Scenario: AI Edit ile Mevcut Görsel Üzerinde Değişiklik Yapma Happy Path
    Given Kullanıcı AI Edit sekmesindedir ve varsayılan Current image hazırdır
    When Describe what to change alanına geçerli bir talimat girilir "Remove the armchair and add a plant"
    And Edit Photo butonuna tıklanır
    Then Sistem metinsel talimata uygun şekilde güncellenmiş görseli ekranda gösterir

  @US-AI-01 @Positive
  Scenario: AI Edit için Yeni Kaynak Görsel Yükleyerek Düzenleme Yapma
    Given Kullanıcı AI Edit sekmesindedir
    When Kullanıcı mevcut görsel yerine yeni bir kaynak görsel yükler
    And Describe what to change alanına "Change the wall color to blue" yazılır
    And Edit Photo butonuna tıklanır
    Then Sistem yeni yüklenen görsel üzerinde talimata göre düzenleme yapar ve sonucu gösterir

  @US-AI-01 @Negative @EdgeCase
  Scenario: AI Edit Alanında Metinsel Komut Boş Bırakıldığında
    Given Kullanıcı AI Edit sekmesindedir ve kaynak görseli hazırdır
    When Describe what to change alanı tamamen boş bırakılır
    And Edit Photo butonuna tıklanır
    Then Sistem boş komutla işlem yapılamayacağına dair uyarı mesajı gösterir
    And Edit Photo butonu pasif kalır

  @US-AI-01 @EdgeCase
  Scenario Outline: AI Edit Alanına Aşırı Uzun Metin Girilmesi Sınır Durumu
    Given Kullanıcı AI Edit sekmesindedir ve kaynak görseli hazırdır
    When Describe what to change alanına sistem sınırlarını zorlayan çok uzun bir metin girilir "<uzun_metin>"
    And Edit Photo butonuna tıklanır
    Then Sistem ya metni sınırlar ya da karakter limit aşımı uyarısı gösterir

    Examples:
      | uzun_metin                                                                                                                                                                                                            |
      | Odanın ortasındaki halıyı kaldır, sağ köşeye büyük bir yapay bitki koy, pencerelerdeki perdeleri mavi yap, duvarları griye boya, tavan lambasını değiştir, masanın üzerine kahve fincanı koy ve bunları yaparken çok dikkat et... (1000+ karakter) |

  Background:
    Given Ziyaretçi web sitesinin ana sayfasındadır

  @US-NAV-02 @Positive @HappyPath
  Scenario: Yapay Zeka Sanal Tur Sayfasına Navigasyon ve Erken Erişim Talebi
    When Kullanıcı header alanındaki Ürünler menüsünün üzerine hover yapar
    And Açılan alt menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı aistager.ai tr ai-virtual-tour sayfasına yönlendirilir
    When Kullanıcı sayfadaki Erken Erişim İsteyin butonuna basar
    And Formdaki zorunlu alanlar Ad Soyad E-posta geçerli bilgilerle doldurulur ve gönderilir
    Then Talep başarıyla iletilir ve kullanıcıya sistem tarafından onay mesajı gösterilir

  @US-NAV-02 @Positive @HappyPath
  Scenario: Sanal Dekorasyon API Sayfasına Navigasyon İletişim ve Fiyatlandırma Yönlendirmesi
    When Kullanıcı header alanındaki Ürünler menüsünün üzerine hover yapar
    And Açılan alt menüden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı aistager.ai tr api sayfasına yönlendirilir
    When Kullanıcı İletişime Geçin butonuna tıklar
    And API iletişim formu zorunlu alanları doldurulur ve gönderilir
    Then Başarılı gönderim onay mesajı alınır
    When Kullanıcı sayfanın alt kısmındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı doğru şekilde Fiyatlandırma sayfasına yönlendirilir

  @US-NAV-02 @Negative
  Scenario: Erken Erişim Formu Zorunlu Alanlar Boşken Gönderim Denemesi
    Given Kullanıcı Yapay Zeka Sanal Tur erken erişim formundadır
    When Zorunlu alanlar doldurulmadan Gönder butonuna tıklanır
    Then Sistem e-posta ve ad soyad alanlarının zorunlu olduğunu belirten hata mesajları gösterir
    And Form gönderilmez

  @US-NAV-02 @Negative @EdgeCase
  Scenario Outline: API İletişim Formuna Geçersiz E-Posta Formatı Girilmesi
    Given Kullanıcı Sanal Dekorasyon API iletişim formundadır
    When Ad Soyad alanı doldurulur ve e-posta alanına geçersiz bir değer girilir "<gecersiz_eposta>"
    And Form gönderilir
    Then Sistem geçerli bir e-posta adresi girilmesi gerektiğini belirten bir hata mesajı gösterir
    And Form iletilmez

    Examples:
      | gecersiz_eposta   |
      | testuser          |
      | test@.com         |
      | user@domain       |
      | @domain.com       |

  @US-NAV-02 @EdgeCase
  Scenario: Header Ürünler Menüsü Hover Sınır Durumu
    When Kullanıcı header alanındaki Ürünler menüsünün üzerine hover yapar
    And Fare imleci menü alanından hızla çıkarılır
    Then Alt ürün listesi Yapay Zeka Sanal Tur ve Sanal Dekorasyon API kullanıcı tarafından erişilemez şekilde kapanmalıdır