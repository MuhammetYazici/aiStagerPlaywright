Feature: Aistager Platform Modul Testleri

  Background:
    Given Kullanici AiStager platformundadir

  @US-VS-01 @Positive
  Scenario: Gecerli bilgilerle basarili sanal dekorasyon olusturma
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı geçerli "JPG" veya "PNG" formatında bir oda görseli yükler
    And Kullanıcı "Oda Türü" (Room Type) seçer
    And Kullanıcı "Tasarım Stili" (Design Style) seçer
    And "Mevcut mobilyaları kaldır" toggle'ının varsayılan olarak "açık" olduğunu görür
    And Kullanıcı görünürlük tercihlerinden birini seçer
    And Kullanıcı dekorasyon oluşturma butonuna tıklar
    And Kullanıcı dekorasyon oluşturma işlemini tetikler
    Then Sistem yapay zeka destekli işlenmiş nihai görseli kullanıcıya sunmalıdır

  @US-VS-01 @Negative @EdgeCase
  Scenario Outline: Gecersiz dosya formati ile gorsel yukleme denemesi
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı "<Gecersiz_Format>" formatında bir dosya yüklemeye çalışır
    Then Sistem kullanıcıya dosya formatının desteklenmediğine dair hata mesajı göstermelidir
    And Dekorasyon olusturma butonu pasif kalmalidir

    Examples:
      | Gecersiz_Format |
      | .gif            |
      | .pdf            |
      | .bmp            |
      | .webp           |

  @US-VS-01 @Negative
  Scenario: Zorunlu alanlar eksikken sanal dekorasyon olusturma denemesi
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı görsel yükler ancak "Oda Türü" veya "Tasarım Stili" seçimlerinden birini boş bırakır
    And Kullanıcı dekorasyon oluşturma butonuna tıklar
    Then Sistem eksik alanların doldurulması gerektiğine dair uyarı mesajı göstermelidir

  @US-VS-02 @Positive
  Scenario: Dogal dil talimati ile yapay zeka uzerinden gorsel duzenleme
    Given Kullanıcı giriş yapmış, Virtual Staging sayfasında ve "AI Edit" sekmesi aktif durumdadır
    When "Edit photo source" alanında varsayılan olarak "Current image" seçili olduğunu görür
    And Kullanıcı "Describe what to change" alanına geçerli bir metinsel talimat (prompt) girer
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Sistem, girilen talimata uygun olarak guncellenmis yeni gorseli ekranda gostermelidir

  @US-VS-02 @Positive
  Scenario: Alternatif kaynak gorsel yukleyerek AI Edit yapma
    Given Kullanıcı giriş yapmış, Virtual Staging sayfasında ve "AI Edit" sekmesi aktif durumdadır
    When Kullanıcı alternatif bir kaynak görsel yükler
    And Kullanıcı "Describe what to change" alanına talimat yazar
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Sistem yüklenen alternatif görsel üzerinden düzenleme yaparak yeni sonucu göstermelidir

  @US-VS-02 @Negative
  Scenario: Talimat prompt alani bos birakilarak AI Edit tetikleme denemesi
    Given Kullanıcı giriş yapmış, Virtual Staging sayfasında ve "AI Edit" sekmesi aktif durumdadır
    When Kullanıcı "Describe what to change" alanını boş bırakır
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Sistem metin girişinin zorunlu olduğuna dair hata mesajı göstermelidir

  @US-NAV-01 @Positive
  Scenario: Yapay Zeka Sanal Tur sayfasina navigasyon ve erken erisim talebi olusturma
    Given Kullanıcı giriş yapmış ve ana sayfadadır
    When Kullanıcı Header üzerindeki "Ürünler" dropdown menüsüne hover yapar
    And Açılan listedeki 2. sıra olan "Yapay Zeka Sanal Tur" seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilmelidir
    When Kullanıcı sayfa içerisindeki "Erken Erişim İsteyin" butonuna tıklar
    And Açılan formda zorunlu e-posta adresini girer ve formu gonderir
    Then Talep sistem tarafindan basariyla kaydedilmeli ve ekranda bir onay mesaji gosterilmelidir

  @US-NAV-01 @Negative
  Scenario: Erken erisim formunda gecersiz e-posta ile talep olusturma
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır
    When Kullanıcı "Erken Erişim İsteyin" butonuna tıklar
    And Açılan forma geçersiz bir e-posta adresi (örn: "test@domain") girer ve gönderir
    Then Sistem gecerli bir e-posta adresi girilmesi gerektigine dair hata mesaji gostermelidir

  @US-NAV-02 @Positive
  Scenario: Sanal Dekorasyon API sayfasina navigasyon ve basarili iletisim formu gonderimi
    Given Kullanıcı giriş yapmış ve ana sayfadadır
    When Kullanıcı Header'daki "Ürünler" dropdown menüsünden 3. sıra olan "Sanal Dekorasyon API" seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilmelidir
    When Kullanıcı sayfanın üst kısmındaki "İletişime Geçin" butonuna tıklar
    And Açılan iletişim formundaki zorunlu alanları (ad, e-posta, mesaj) doldurur ve gönderir
    Then Kullanıcıya başarı (onay) mesajı iletilmelidir

  @US-NAV-02 @Positive
  Scenario: Sanal Dekorasyon API sayfasindan Fiyatlandirma sayfasina yonlendirme
    Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
    When Kullanıcı sayfanın alt kısmındaki "Fiyatlandırmayı Görüntüle" butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma (Pricing) sayfasına yönlendirilmelidir

  @US-NAV-02 @Negative
  Scenario: API iletisim formunda zorunlu alanlar eksikken gonderme denemesi
    Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
    When Kullanıcı "İletişime Geçin" butonuna tıklar
    And Zorunlu alanlardan (Ad, E-posta, Mesaj) en az birini boş bırakarak gönder butonuna tıklar
    Then Sistem eksik alanlarla ilgili validasyon hata mesajlari gostermelidir