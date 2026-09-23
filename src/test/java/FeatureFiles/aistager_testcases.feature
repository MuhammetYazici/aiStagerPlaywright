Feature: AiStager Platformu Yapay Zeka İşlemleri ve Kurumsal Çözümler
  Oturum açmış bir kullanıcı olarak, platform üzerindeki sanal dekorasyon, AI düzenleme, 
  sanal tur erken erişim talebi ve API çözümleri özelliklerini kullanmak istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  # --- FEATURE 1: Sanal Dekorasyon (Virtual Staging) Oluşturma ---

  Scenario: Varsayılan ayarlarla başarılı sanal dekorasyon oluşturma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler ("oda.jpg")
    And Kullanıcı "Oda Türü" olarak "Yatak Odası" seçer
    And Kullanıcı "Tasarım Stili" olarak "Modern" seçer
    And "Mevcut mobilyaları kaldır" toggle'ının "açık" olduğu doğrulanır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Yapay zeka işleme süreci başlar
    And Sistem yüklenen odanın mobilyalandırılmış versiyonunu başarıyla üretir ve ekranda gösterir

  Scenario: Görünürlük tercihi yapılarak başarılı dekorasyon oluşturma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler ("salon.png")
    And Kullanıcı "Oda Türü" olarak "Oturma Odası" seçer
    And Kullanıcı "Tasarım Stili" olarak "Skandinav" seçer
    And Kullanıcı görünürlük tercihi olarak Herkese açık galeride göster radyo butonunu seçer
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem başarıyla yeni dekorasyonu oluşturur

  Scenario Outline: Desteklenmeyen dosya formatı ile görsel yükleme denemesi
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı desteklenmeyen formatta bir görsel yükler ("<gecersiz_dosya>")
    Then "Desteklenmeyen dosya formatı. Lütfen JPG veya PNG yükleyin." hata mesajı alınır
    And Dekorasyon Oluştur butonunun pasif olduğu doğrulanır

    Examples:
      | gecersiz_dosya |
      | test.gif       |
      | model.pdf      |
      | photo.bmp      |

  Scenario: Zorunlu alanlar seçilmeden oluşturma denemesi
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler ("oda.jpg")
    And Kullanıcı "Oda Türü" ve "Tasarım Stili" seçimlerini boş bırakır
    Then Dekorasyon Oluştur butonunun pasif olduğu doğrulanır

  Scenario: Maksimum dosya boyut sınırında görsel yükleme
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı izin verilen maksimum dosya boyutunda geçerli bir JPG görseli yükler
    And Kullanıcı zorunlu alanları doldurur
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem yüklemeyi kabul eder ve dekorasyon sürecini başlatır

  Scenario: Mevcut mobilyaları kaldır toggle durumunu değiştirerek oluşturma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler ("oda.jpg")
    And Kullanıcı zorunlu alanları doldurur
    And Kullanıcı varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle'ını kapatır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem mevcut mobilyaları koruyarak yeni dekorasyon çıktısı üretir

  # --- FEATURE 2: Yapay Zeka ile Görsel Düzenleme (AI Edit) ---

  Scenario: Mevcut görsel üzerinde metinsel talimatla başarılı düzenleme
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "AI Edit" sekmesindedir
    When Edit photo source alanında varsayılan olarak Current image seçili olduğu doğrulanır
    And Kullanıcı Describe what to change alanına "Remove the chair and add a plant" yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Yapay zeka düzenleme süreci başlar
    And Sistem girilen talimata uygun şekilde güncellenmiş görseli ekranda gösterir

  Scenario: Alternatif kaynak görsel yükleyerek AI Edit yapma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "AI Edit" sekmesindedir
    When Kullanıcı Edit photo source için alternatif bir kaynak görsel yükler ("mutfak.jpg")
    And Kullanıcı Describe what to change alanına "Change wall color to blue" yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem yüklenen alternatif görsel üzerinde düzenlemeyi gerçekleştirir

  Scenario: Talimat girilmeden AI Edit yapma denemesi
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "AI Edit" sekmesindedir
    When Kullanıcı kaynak görseli seçer
    And Kullanıcı Describe what to change alanını boş bırakır
    Then Edit Photo butonunun pasif olduğu doğrulanır

  Scenario: Çok uzun metinsel talimat girilmesi
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "AI Edit" sekmesindedir
    When Kullanıcı kaynak görseli seçer
    And Kullanıcı Describe what to change alanına sistem sınırlarını zorlayan çok uzun ve detaylı bir prompt yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem talebi işleme alır veya karakter sınır aşımı uyarısı gösterir

  # --- FEATURE 3: Yapay Zeka Sanal Tur Erken Erişim Talebi ---

  Scenario: Ürünler menüsünden Sanal Tur sayfasına gidip erken erişim talebi oluşturma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler menüsüne hover yapar
    And Açılan dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Kullanıcı zorunlu alan olan e-posta adresini girer ("test@example.com")
    And Kullanıcı formu gönderir
    Then Sistem talebi alır ve ekranda başarı mesajı gösterir

  Scenario: Geçersiz e-posta adresi ile erken erişim talebi gönderme
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Yapay Zeka Sanal Tur erken erişim formundadır
    When Kullanıcı e-posta alanına geçersiz bir format girer ("gecersiz-email")
    And Kullanıcı formu gönderir
    Then "Lütfen geçerli bir e-posta adresi girin" hata mesajı görüntülenir
    And Form gönderilemez

  Scenario: Aynı e-posta adresi ile ikinci kez erken erişim talebinde bulunma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı Yapay Zeka Sanal Tur erken erişim formundadır
    When Kullanıcı daha önce kayıt olmuş bir e-posta adresi ile erken erişim formu doldurur
    And Kullanıcı formu gönderir
    Then Sistem daha önce kayıt oluşturulduğuna dair bilgilendirme mesajı gösterir

  # --- FEATURE 4: Sanal Dekorasyon API İletişim ve Fiyatlandırma Yönlendirmesi ---

  Scenario: API sayfasına erişim, iletişim formu doldurma ve fiyatlandırma sayfasına yönlenme
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı ana sayfadadır
    When Kullanıcı Header Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilir
    When Kullanıcı "Sanal Dekorasyon API" sayfasındadır
    And Kullanıcı İletişime Geçin butonuna tıklar
    And Kullanıcı zorunlu alanlar olan ad, e-posta ve mesaj alanlarını doldurur
    And Kullanıcı formu gönderir
    Then Başarılı bir onay mesajı görüntülenir
    When Kullanıcı sayfa içerisindeki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı Fiyatlandırma sayfasına sorunsuz bir şekilde yönlendirilir

  Scenario: API iletişim formunda zorunlu alanları boş bırakma
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "Sanal Dekorasyon API" sayfasındadır
    When Kullanıcı "İletişime Geçin" formundaki zorunlu alanları (ad, e-posta, mesaj) boş bırakır
    And Kullanıcı form gönder butonuna tıklar
    Then Zorunlu alanların altında hata uyarıları görüntülenir
    And Form başarıyla gönderilemez

  Scenario: Çok uzun mesaj karakteri ile API iletişim formu gönderme
    Given Kullanıcı sisteme giriş yapmış durumdadır
    And Kullanıcı "Sanal Dekorasyon API" iletişim formundadır
    When Kullanıcı Mesaj alanına izin verilen maksimum karakter sınırını aşan uzunlukta metin girer
    Then Karakter sınırı aşım uyarısı alınır veya fazla karakterler kırpılır