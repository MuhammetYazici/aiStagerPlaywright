İstenen adımlar, ilgili senaryolara doğru sırada ve birebir aynı metinlerle eklenerek senaryonun tam ve eksiksiz hali aşağıda verilmiştir:

```gherkin
Feature: AiStager Platformu Kapsamlı Test Senaryoları
  Emlak profesyonelleri ve mülk sahipleri için yapay zeka destekli sanal dekorasyon, düzenleme, API ve sanal tur özellikleri.

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Başarılı bir şekilde sanal dekorasyon oluşturma
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı desteklenen "jpg" formatında boş bir oda görseli yükler
    And "Oda Türü" olarak "Yatak Odası" seçer
    And "Tasarım Stili" olarak "Modern" seçer
    And "Mevcut mobilyaları kaldır" toggle'ının "açık" olduğunu görür
    And Görselin umumi galeride gösterilmesi için gizlilik tercihini belirler
    And "Dekorasyon Oluştur" butonuna tıklar
    Then Sistem yükleme önizlemesini göstermelidir
    And Yapay zeka süreci başarıyla tamamlanmalı ve mobilyalandırılmış yeni görsel kullanıcıya sunulmalıdır

  Scenario Outline: Desteklenmeyen veya geçersiz dosya formatı ile görsel yükleme
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen "<format>" formatında bir dosya yüklemeye çalışır
    Then Sistem "<hata_mesaji>" hata mesajını göstermelidir
    And Dekorasyon Oluştur butonu pasif kalmalı veya işlem engellenmelidir

    Examples:
      | format | hata_mesaji                     |
      | pdf    | Geçersiz dosya formatı jpg png  |
      | tiff   | Geçersiz dosya formatı jpg png  |
      | exe    | Geçersiz dosya formatı jpg png  |

  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturma denemesi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir görsel yükler
    But "Oda Türü" ve "Tasarım Stili" seçimlerini boş bırakır
    And "Dekorasyon Oluştur" butonuna tıklar
    Then Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajları göstermelidir

  Scenario: Varsayılan parametrelerin kontrolü
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı Virtual Staging sayfasına ilk kez erişir
    Then "Mevcut mobilyaları kaldır" toggle'ının varsayılan olarak "açık (active)" durumda geldiği doğrulanmalıdır

  Scenario: Başarılı bir şekilde metin tabanlı görsel düzenleme yapma
    Given Kullanıcı AI Edit sekmesinde aktif olarak bulunuyordur
    When Kullanıcı Edit photo source alanında varsayılan Current image seçeneğinin seçili olduğunu görür
    And Metin alanına "Remove the chair and add a plant" talimatını yazar
    And "Edit Photo" butonuna tıklar
    Then Sistem girilen talimata uygun olarak görseli güncellemeli
    And İşlenmiş yeni görsel ekranda kullanıcıya gösterilmelidir

  Scenario: Alternatif kaynak görsel yükleyerek AI Edit yapma
    Given Kullanıcı AI Edit sekmesinde aktif olarak bulunuyordur
    When Kullanıcı Edit photo source alanından farklı bir kaynak görsel yükler
    And Metin alanına geçerli bir düzenleme talimatı yazar
    And "Edit Photo" butonuna tıklar
    Then Sistem yüklenen yeni kaynak görsel üzerinden düzenleme işlemini gerçekleştirmelidir

  Scenario: Talimat metni boş bırakılarak düzenleme yapma denemesi
    Given Kullanıcı AI Edit sekmesinde aktif olarak bulunuyordur
    When Kullanıcı kaynak görseli seçer
    But Describe what to change alanını tamamen boş bırakır
    And "Edit Photo" butonuna tıklar
    Then Sistem Talimat alanı boş bırakılamaz şeklinde bir uyarı göstermelidir
    And İşlem gerçekleştirilmemelidir

  Scenario: Başarılı Navigasyon ve Erken Erişim Formu Gönderimi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Ürünler menüsünün üzerine gelir
    And Açılan menüde Yapay Zeka Sanal Tur seçeneğinin ikinci sırada yer aldığını görür ve tıklar
    When Kullanıcı "/tr/ai-virtual-tour" sayfasına gider
    Then Kullanıcı tr ai virtual tour sayfasına yönlendirilmelidir
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Erken erişim formuna geçerli bir eposta adresi girer ve gönderir
    Then Sistem formun başarıyla alındığına dair bir onay mesajı göstermelidir

  Scenario Outline: Geçersiz eposta formatı ile erken erişim talebinde bulunma
    Given Kullanıcı tr ai virtual tour sayfasındadır
    When Kullanıcı "Erken Erişim İsteyin" formundaki e-posta alanına geçersiz "<gecersiz_eposta>" girer
    And Formu gönderir
    Then Sistem eposta format hatası vermeli ve erken erişim talebi iletilmemelidir

    Examples:
      | gecersiz_eposta |
      | testuser        |
      | test at com     |
      | at domain com   |

  Scenario: Sanal Dekorasyon API iletişim formunun başarıyla gönderilmesi
    Given Kullanıcı "Ürünler" menüsünden "Sanal Dekorasyon API" seçeneğine tıklayarak "/tr/api" sayfasına ulaşmıştır
    When Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar
    And İletişim formundaki Ad E-posta ve Mesaj alanlarını geçerli bilgilerle doldurur
    And Formu gönderir
    Then Sistem başarılı gönderim mesajı göstermelidir

  Scenario: API sayfasından Fiyatlandırma sayfasına geçiş
    Given Kullanıcı tr api sayfasındadır
    When Kullanıcı API sayfasının alt kısmındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı başarılı bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  Scenario Outline: Eksik veri ile API iletişim formu gönderme denemesi
    Given Kullanıcı tr api sayfasındadır
    When Kullanıcı İletişime Geçin formunu açar
    And Ad alanına "<ad>", E-posta alanına "<eposta>", Mesaj alanına "<mesaj>" girer
    And Formu gönderme butonuna tıklar
    Then Sistem eksik alanlar için uyarı vermeli ve form gönderimini engellemelidir

    Examples:
      | ad   | eposta          | mesaj   |
      |      | test@test.com   | Merhaba |
      | John |                 | Merhaba |
      | John | test@test.com   |         |