Feature: AiStager.ai Platform Temel Özellikleri ve Ürün Navigasyonu

  Background:
    Given Kullanıcı AiStager.ai platformuna başarıyla giriş yapmıştır

  @positive @virtual-staging
  Scenario: Geçerli parametrelerle başarılı Virtual Staging Dekorasyon Oluşturma
    Given Kullanıcı Virtual Staging modülündedir
    When Kullanıcı yükleme alanına geçerli formatta bir "jpg" veya "png" boş oda görseli yükler
    And Kullanıcı Oda Türü olarak Oturma Odası seçer
    And Kullanıcı Tasarım Stili olarak Modern seçer
    And Kullanıcı Mevcut mobilyaları kaldır toggle'ının açık olduğunu görür
    And Kullanıcı görünürlük tercihi olarak bir radyo buton seçer
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem, seçilen oda türü ve tasarım stiline uygun mobilyalandırılmış görseli başarıyla üretmelidir

  @negative @virtual-staging
  Scenario Outline: Geçersiz dosya formatı ile Virtual Staging görsel yükleme engeli
    Given Kullanıcı Virtual Staging modülündedir
    When Kullanıcı yükleme alanına "<gecersiz_format>" uzantılı bir dosya yüklemeye çalışır
    Then Sistem yükleme hatası vermeli ve görselin yüklenmediğini belirtmelidir

    Examples:
      | gecersiz_format |
      | pdf             |
      | exe             |
      | txt             |
      | gif             |

  @edge-case @virtual-staging
  Scenario: Zorunlu alanlar eksikken dekorasyon oluşturma girişiminin engellenmesi
    Given Kullanıcı Virtual Staging modülündedir
    When Kullanıcı geçerli bir boş oda görseli yükler
    And Kullanıcı Oda Türü veya Tasarım Stili seçimini yapmaz
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajı göstermelidir
    And Dekorasyon oluşturma işlemi tetiklenmemelidir

  @positive @virtual-staging
  Scenario: Mevcut mobilyaları kaldır toggle varsayılan durum kontrolü
    Given Kullanıcı Virtual Staging modülündedir
    When Kullanıcı boş oda görseli yükleme ekranına gelir
    Then Mevcut mobilyaları kaldır toggle'ı varsayılan olarak açık olmalıdır

  @positive @ai-edit
  Scenario: Mevcut görsel üzerinden metin tabanlı başarılı AI Edit işlemi
    Given Kullanıcı AI Edit modülündedir
    When Kullanıcı varsayılan olarak Current image seçeneği ile ilerler
    And Kullanıcı Describe what to change alanına "Remove the chair" metnini girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem girilen metin talimatına uygun şekilde görsel üzerindeki ilgili objeyi kaldırmalı ve güncel görseli göstermelidir

  @edge-case @ai-edit
  Scenario: Boş metin talimatı ile AI Edit işlemi
    Given Kullanıcı AI Edit modülündedir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem kullanıcının bir değişiklik tanımı girmesi gerektiğini belirten bir uyarı göstermelidir

  @positive @ai-edit
  Scenario: Yeni görsel yükleyerek AI Edit işlemi gerçekleştirme
    Given Kullanıcı AI Edit modülündedir
    When Kullanıcı Current image yerine yeni bir görsel yükler
    And Kullanıcı Describe what to change alanına "Add a modern floor lamp to the corner" girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem yeni yüklenen görsel üzerine talimatı uygulamalı ve güncel görseli sunmalıdır

  @positive @navigation @lead-gen
  Scenario: Yapay Zeka Sanal Tur sayfasına erişim ve erken erişim formu gönderimi
    Given Kullanıcı ana sayfanın header alanındadır
    When Kullanıcı Ürünler menüsünün üzerine gelir
    And Açılan alt menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilmelidir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan form alanına geçerli bir "test@aistager.ai" e-posta adresi girer ve gönderir
    Then Sistem başarılı gönderim onayı mesajı göstermelidir

  @negative @lead-gen
  Scenario: Sanal Tur erken erişim formuna geçersiz e-posta girişi
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan forma geçersiz bir "gecersiz-eposta" e-posta adresi girer ve gönderir
    Then Sistem e-posta format hatası mesajı göstermeli ve başvuruyu kabul etmemelidir

  @positive @navigation @lead-gen
  Scenario: Sanal Dekorasyon API sayfasına erişim, iletişim formu doldurma ve Fiyatlandırma yönlendirmesi
    Given Kullanıcı ana sayfanın header alanındadır
    When Kullanıcı Ürünler menüsünün üzerine gelir
    And Açılan alt menüden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilmelidir
    When Kullanıcı iletişim formundaki Ad, E-posta ve Mesaj alanlarını doldurur ve gönderir
    Then Sistem iletişim formunun başarıyla iletildiğine dair onay mesajı gösterilmelidir
    When Kullanıcı Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı sorunsuz bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  @edge-case @api-form
  Scenario: API iletişim formunda zorunlu alanların eksik bırakılması
    Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
    When Kullanıcı iletişim formundaki Ad veya E-posta alanını boş bırakır
    And Kullanıcı formu gönderme butonuna tıklar
    Then Sistem zorunlu alanların doldurulması gerektiğine dair hata uyarıları vermelidir