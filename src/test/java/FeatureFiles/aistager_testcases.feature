Feature: AiStager Platformu Kapsamlı Test Senaryoları
  Kayıtlı veya ziyaretçi bir kullanıcı olarak, yapay zeka destekli sanal dekorasyon, 
  görsel düzenleme, sanal tur erken erişim talebi ve API sayfaları üzerinde 
  işlemleri gerçekleştirebilmek istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  # --- US-01: Sanal Dekorasyon (Virtual Staging) Oluşturma (Pozitif) ---

  Scenario: Varsayılan ayarlar ile başarılı sanal dekorasyon üretimi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Desteklenen formatta ".jpg" veya ".png" bir oda fotoğrafı yüklenir
    Then Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak açık olduğu görülür
    When "Oda Türü" ve "Tasarım Stili" seçimleri yapılır
    And Dekorasyon Oluştur butonunun aktif olduğu görülür
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem yüklenen odayı analiz eder ve seçilen stile uygun mobilyalandırılmış yeni görseli ekranda gösterir

  # --- US-01: Sanal Dekorasyon (Virtual Staging) Oluşturma (Negatif) ---

  Scenario: Desteklenmeyen dosya formatı yükleme denemesi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Desteklenmeyen formatta bir dosya ".gif", ".pdf" veya ".txt" yüklenir
    Then Sistem hata mesajı gösterir ve görselin yüklenmesine izin vermez
    And Dekorasyon Oluştur butonu pasif kalır

  Scenario: Zorunlu alanlar eksikken dekorasyon oluşturma butonunun pasif olması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Görsel yüklenir ancak Oda Türü veya Tasarım Stili seçimlerinden biri boş bırakılır
    Then Dekorasyon Oluştur butonunun pasif olduğu doğrulanır

  # --- US-01: Sanal Dekorasyon (Virtual Staging) Oluşturma (Sınır Durumları) ---

  Scenario: İzin verilen maksimum veya minimum boyut veya çözünürlükteki görsel ile işlem
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Sistem sınırlarında kabul edilen minimum veya maksimum dosya boyutunda geçerli bir ".jpg" görseli yüklenir
    And "Oda Türü" ve "Tasarım Stili" seçimleri yapılır
    And Dekorasyon Oluştur butonuna tıklanır
    Then İşlemin başarıyla tamamlandığı ve görselin üretildiği doğrulanır

  Scenario: Mevcut mobilyaları kaldır seçeneğinin manuel olarak kapatılması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Desteklenen formatta bir oda fotoğrafı yüklenir
    And "Mevcut mobilyaları kaldır" seçeneği manuel olarak kapatılır (disabled yapılır)
    And "Oda Türü" ve "Tasarım Stili" seçimleri yapılır
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem mevcut mobilyaları koruyarak yeni dekorasyon çıktısı üretir

  # --- US-02: AI ile Görsel Düzenleme (AI Edit) (Pozitif) ---

  Scenario: Varsayılan kaynak görsel ile başarılı metin tabanlı düzenleme
    Given Kullanıcı "AI Edit" sekmesindedir
    Then "Edit photo source" alanında varsayılan olarak "Current image" (mevcut görsel) seçili olduğu görülür
    When Describe what to change alanına geçerli bir talimat olan "Remove the chair" girilir
    And "Edit Photo" butonuna tıklanır
    Then Yapay zeka talimatı işler ve güncellenmiş görseli kullanıcıya sunar

  # --- US-02: AI ile Görsel Düzenleme (AI Edit) (Negatif) ---

  Scenario: Talimat alanı boş bırakıldığında düzenleme yapamaması
    Given Kullanıcı "AI Edit" sekmesindedir
    And Kaynak görsel hazırdır
    When Describe what to change alanı tamamen boş bırakılır
    Then Edit Photo butonunun pasif olduğu veya işlemin tetiklenemediği doğrulanır
    And Sistem kullanıcıya uyarı mesajı gösterir

  # --- US-02: AI ile Görsel Düzenleme (AI Edit) (Sınır Durumları) ---

  Scenario: Çok uzun veya özel karakter içeren talimat metni girilmesi
    Given Kullanıcı "AI Edit" sekmesindedir
    And Kaynak görsel hazırdır
    When Describe what to change alanına izin verilen maksimum karakter sınırında ve özel karakterler içeren bir prompt girilir
    And "Edit Photo" butonuna tıklanır
    Then Sistemin bu girdiyi hata vermeden işlediği veya uygun bir yönlendirme yaptığı doğrulanır

  # --- US-03: Ürünler Menüsü Üzerinden Yapay Zeka Sanal Tur Erken Erişim Talebi (Pozitif) ---

  Scenario: Menü üzerinden Sanal Tur sayfasına ulaşım ve erken erişim formu gönderme
    When Header'daki "Ürünler" menüsüne mause ile gelinir (hover yapılır)
    Then Alt seçeneklerin açıldığı görülür
    When Açılan menüden Yapay Zeka Sanal Tur seçeneğine tıklanır
    Then Kullanıcı ai-virtual-tour sayfasına yönlendirilir
    When Sayfadaki Erken Erişim İsteyin butonuna tıklanır
    And Erken erişim formu geçerli bilgilerle doldurulup gönderilir
    Then Sistem talebi alır ve başarılı onay mesajı gösterir

  # --- US-03: Ürünler Menüsü Üzerinden Yapay Zeka Sanal Tur Erken Erişim Talebi (Negatif) ---

  Scenario: Erken erişim formunun zorunlu alanları eksik doldurulması
    Given Kullanıcı ai-virtual-tour sayfasındadır
    When Erken Erişim İsteyin butonuna tıklanıp form açılır
    And Zorunlu alanlar boş bırakılarak gönderilmeye çalışılır
    Then Sistem formun gönderilmesine izin vermez ve hata mesajları gösterir

  # --- US-03: Ürünler Menüsü Üzerinden Yapay Zeka Sanal Tur Erken Erişim Talebi (Sınır Durumları) ---

  Scenario: Ürünler menüsü üzerinden hızlı hover ve tıklama testleri
    When Header içindeki Ürünler menüsü üzerine hızlıca gelinip uzaklaşılır
    Then Alt menünün kararsız kalmadan kapandığı doğrulanır
    And Tekrar menü üzerine gelinip Yapay Zeka Sanal Tur seçeneğine sorunsuz bir şekilde tıklanabildiği doğrulanır

  # --- US-04: Sanal Dekorasyon API Sayfası ve İletişim / Fiyatlandırma Akışı (Pozitif) ---

  Scenario: API sayfasına yönlendirme, başarılı iletişim formu ve fiyatlandırma geçişi
    When Header içindeki Ürünler menüsünden Sanal Dekorasyon API seçeneğine tıklanır
    Then Kullanıcı api sayfasına yönlendirilir
    When Sayfadaki İletişime Geçin butonuna tıklanır
    And İletişim formu zorunlu alanları geçerli verilerle doldurulup gönderilir
    Then Sistem başarılı gönderim mesajı gösterir
    When Sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklanır
    Then Kullanıcı Fiyatlandırma sayfasına başarıyla yönlendirilir

  # --- US-04: Sanal Dekorasyon API Sayfası ve İletişim / Fiyatlandırma Akışı (Negatif) ---

  Scenario: API iletişim formu zorunlu alanlar eksikken gönderilememelidir
    Given Kullanıcı api sayfasındadır
    When İletişime Geçin formundaki zorunlu alanlardan biri boş bırakılarak gönderilmeye çalışılır
    Then Sistem formu göndermez ve ilgili alan için zorunlu alan uyarı mesajı gösterir

  # --- US-04: Sanal Dekorasyon API Sayfası ve İletişim / Fiyatlandırma Akışı (Sınır Durumları) ---

  Scenario: Geçersiz e-posta formatı ile API iletişim formu gönderimi
    Given Kullanıcı api sayfasındadır
    When "İletişime Geçin" formundaki e-posta alanına kurallara uygun olmayan bir metin (örn. "testuser") girilir
    And Form gönderilmeye çalışılır
    Then Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı gösterir