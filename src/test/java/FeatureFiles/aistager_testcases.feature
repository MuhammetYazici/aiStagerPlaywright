İstenen eksik adımlar, mantıksal akışa ve senaryo gereksinimlerine uygun olarak ilgili Scenario'ların altına eklenmiştir. Güncellenmiş ve eksiksiz Gherkin senaryosu aşağıdadır:

```gherkin
Feature: AI Destekli Görsel İşleme ve Ürün Navigasyon Yönetimi

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @virtual-staging
  Scenario: Başarılı bir şekilde sanal dekorasyon oluşturma
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen ".jpg" formatında boş bir oda görseli yükler
    And Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak aktif olduğunu görür
    And Kullanıcı Oda Türü olarak "Yatak Odası" ve Tasarım Stili olarak "Modern" seçer
    And "Dekorasyon Oluştur" butonuna tıklar
    Then Sistem yüklenen odanın yapay zeka tarafından mobilyalandırılmış yeni halini ekranda göstermelidir

  @edge-case @virtual-staging
  Scenario: Farklı desteklenen formatta sanal dekorasyon oluşturma
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen ".png" formatında boş bir oda görseli yükler
    And Kullanıcı Oda Türü olarak "Oturma Odası" ve Tasarım Stili olarak "Skandinav" seçer
    And "Dekorasyon Oluştur" butonuna tıklar
    Then Sistem yüklenen odanın yapay zeka tarafından mobilyalandırılmış yeni halini ekranda göstermelidir

  @negative @virtual-staging
  Scenario: Desteklenmeyen dosya formatı ile görsel yükleme girişimi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatta bir dosya yükler ".gif"
    Then Sistem kullanıcıya uygun formatlarda dosya yüklemesi gerektiğine dair hata mesajı göstermelidir
    And Dekorasyon Oluştur butonu pasif kalmalıdır

  @edge-case @virtual-staging
  Scenario: Çok büyük boyutlu görsel yükleme sınırı
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı izin verilen maksimum boyut sınırını aşan bir ".jpg" görseli yükler
    Then Sistem görsel boyutunun çok büyük olduğuna dair bir uyarı mesajı göstermelidir

  @positive @ai-edit
  Scenario: Kaynak görsel üzerinde başarıyla AI Edit yapma
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasında AI Edit sekmesindedir
    When Kullanıcı mevcut kaynak görseli seçer
    And Describe what to change alanına "Add a blue rug under the bed" talimatını yazar
    And "Edit Photo" butonuna tıklar
    Then Sistem, girilen talimata uygun olarak görseli güncellemeli ve güncel hali ekranda göstermelidir

  @negative @ai-edit
  Scenario: Talimat alanı boş bırakılarak AI Edit yapma girişimi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasında AI Edit sekmesindedir
    When Kullanıcı kaynak görseli seçer
    And Describe what to change alanını boş bırakır
    And "Edit Photo" butonuna tıklar
    Then Sistem kullanıcının talimat girmesi gerektiğini belirten bir uyarı mesajı göstermelidir
    And Görsel düzenleme işlemi tetiklenmemelidir

  @edge-case @ai-edit
  Scenario: Yeni görsel yükleyerek AI Edit yapma
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasında AI Edit sekmesindedir
    When Kullanıcı sistemdeki kaynak görsel yerine yeni bir ".png" görseli yükler
    And Describe what to change alanına "Change wall color to light grey" yazar
    And "Edit Photo" butonuna tıklar
    Then Sistem yeni yüklenen görsel üzerinden talimatı uygulamalı ve sonucu ekranda göstermelidir

  @positive @navigation
  Scenario: Ürünler menüsü üzerinden Sanal Tur sayfasına yönlendirme
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler menüsünün üzerine gelir
    And Açılan dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı "/tr/ai-virtual-tour" sayfasına yönlendirilmelidir

  @positive @navigation
  Scenario: Ürünler menüsü üzerinden Sanal Dekorasyon API sayfasına yönlendirme
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı ana sayfadadır
    When Kullanıcı Header üzerindeki Ürünler menüsünün üzerine gelir
    And Açılan dropdown menüden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı "/tr/api" sayfasına yönlendirilmelidir

  @positive @lead-generation
  Scenario: Yapay Zeka Sanal Tur erken erişim formunun başarıyla gönderilmesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı "/tr/ai-virtual-tour" sayfasındadır
    When Kullanıcı erken erişim formundaki zorunlu alan olan E-posta adresini geçerli formatta girer "test@example.com"
    And Erken Erişim Talep Et butonuna tıklar
    Then Kullanıcı talebinin başarıyla alındığına dair onay mesajı görmelidir

  @negative @lead-generation
  Scenario: Eksik veya geçersiz e-posta ile erken erişim formu gönderme girişimi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı "/tr/ai-virtual-tour" sayfasındadır
    When Kullanıcı erken erişim formuna geçersiz bir e-posta adresi girer "gecersiz-eposta"
    And Erken Erişim Talep Et butonuna tıklar
    Then Sistem e-posta formatının hatalı olduğuna dair bir doğrulama mesajı göstermelidir
    And Form gönderilmemelidir

  @positive @lead-generation
  Scenario: Sanal Dekorasyon API iletişim formunun doldurulması ve fiyatlandırma yönlendirmesi
    Given Kullanıcı giriş yapmıştır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı "/tr/api" sayfazasındadır
    When Kullanıcı API iletişim formundaki zorunlu alanları doldurur
    And Gönder butonuna tıklar
    Then Başarılı gönderim mesajı ekranda görünmelidir
    When Kullanıcı sayfadaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı doğru şekilde Fiyatlandırma sayfasına yönlendirilmelidir