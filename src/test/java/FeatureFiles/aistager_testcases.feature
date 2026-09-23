Feature: US-01 ve US-02 Sanal Dekorasyon, AI Edit ve API İletişim Akışları

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @US-01 @BR-01 @BR-02 @BR-03 @BR-04
  Scenario Outline: Kullanıcı geçerli parametrelerle başarılı bir Sanal Dekorasyon oluşturabilmelidir
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı "<dosya_adi>" adında ve "<dosya_formati>" formatındaki oda görselini yükleme alanına sürükleyip bırakır
    Then Yüklenen görselin önizlemesi ekranda gösterilmelidir
    And Mevcut mobilyaları kaldır toggle özelliğinin varsayılan olarak açık olduğu görülmelidir
    When Kullanıcı Oda Türü olarak "<oda_turu>" seçer
    And Kullanıcı Tasarım Stili olarak "<tasarim_stili>" seçer
    And Kullanıcı görünürlük tercihlerini "<gorunurluk>" olarak belirler
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then İşlem süreci başlamalı ve AI işleme tamamlandığında odanın mobilyalandırılmış yeni hali ekranda gösterilmelidir

    Examples:
      | dosya_adi | dosya_formati | oda_turu     | tasarim_stili | gorunurluk   |
      | salon_01  | .jpg          | Oturma Odası | Modern        | Herkese Açık |
      | yatak_02  | .png          | Yatak Odası  | İskandinav    | Gizli        |

  @negative @US-01 @BR-01
  Scenario: Desteklenmeyen dosya formatında görsel yükleme girişimi
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatlardaki bir dosyayı yükleme alanına yüklemeye çalışır
    Then Sistem hata mesajı vermeli ve görsel yükleme işlemine izin vermemelidir

  @negative @US-01 @BR-02
  Scenario Outline: Zorunlu parametreler eksik bırakıldığında dekorasyon oluşturulamaması
    Given Kullanıcı sisteme giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir görsel yükler
    And Kullanıcı Oda Türü alanını "<oda_turu>" bırakır
    And Kullanıcı Tasarım Stili alanını "<tasarim_stili>" bırakır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Dekorasyon Oluştur butonu pasif kalmalı veya zorunlu alan uyarı mesajı gösterilmelidir

    Examples:
      | oda_turu        | tasarim_stili   |
      | Boş Seçilmedi   | Modern          |
      | Oturma Odası    | Boş Seçilmedi   |
      | Boş Seçilmedi   | Boş Seçilmedi   |

  @positive @US-01 @BR-05 @BR-06 @BR-07
  Scenario: Kullanıcı kaynak görsel üzerinde başarılı bir AI Edit işlemi gerçekleştirebilmelidir
    Given Kullanıcı sisteme giriş yapmış, Virtual Staging sayfasında ve AI Edit sekmesi aktiftir
    And Edit photo source alanında varsayılan olarak Current image seçili olduğu görülür
    When Kullanıcı Describe what to change alanına Remove the chair and add a plant metinsel talimatını girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then İşlem başlamalı ve sistem girilen talimata uygun olarak güncellenmiş görseli kullanıcıya sunmalıdır

  @negative @US-01 @BR-06 @BR-07
  Scenario: Metinsel talimat boş bırakıldığında AI Edit işleminin engellenmesi
    Given Kullanıcı sisteme giriş yapmış, Virtual Staging sayfasında ve AI Edit sekmesi aktiftir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem Lütfen bir değişiklik tanımlayın şeklinde bir uyarı mesajı göstermelidir ve işlem başlamamalıdır

  @positive @US-02 @BR-08 @BR-09
  Scenario: Kullanıcı menüden Yapay Zeka Sanal Tur sayfasına gidip erken erişim talebi oluşturabilmelidir
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler menüsünün üzerine gelir
    And Açılan dropdown menüden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir
    When Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar
    And Açılan form içerisindeki zorunlu e-posta alanına geçerli bir e-posta adresi girer
    And Kullanıcı talebi gönderir
    Then Talep başarıyla iletilmeli ve kullanıcıya onay mesajı gösterilmelidir

  @negative @US-02 @BR-09
  Scenario: Erken Erişim formunda geçersiz e-posta adresi ile talep oluşturma girişimi
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır ve Erken Erişim İsteyin formu açıktır
    When Kullanıcı e-posta alanına geçersiz bir format olan "gecersiz-eposta" girer
    And Kullanıcı talebi göndermeye çalışır
    Then Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı göstermelidir

  @positive @US-02 @BR-10 @BR-11 @BR-12
  Scenario: Kullanıcı Sanal Dekorasyon API sayfasına gidip iletişim formu doldurabilmeli ve fiyatlandırma sayfasına yönlendirilebilmelidir
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler menüsünün üzerine gelir
    And Kullanıcı header "Ürünler" dropdown menüsünden 3. seçenek olan "Sanal Dekorasyon API" seçeneğine tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/api sayfasına yönlendirilmelidir
    When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
    And Açılan formda Ad E-posta ve Mesaj zorunlu alanlarını geçerli bilgilerle doldurur
    And Kullanıcı formu gönderir
    Then Talep başarıyla iletilmeli ve onay mesajı alınmalıdır
    When Kullanıcı sayfanın alt kısmında bulunan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  @negative @US-02 @BR-11
  Scenario: API iletişim formunda zorunlu alanlar eksikken formun gönderilememesi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır ve iletişim formu açıktır
    When Kullanıcı Ad ve Mesaj alanlarını doldurup E-posta alanını boş bırakır
    And Kullanıcı header "Ürünler" dropdown menüsünden 3. seçenek olan "Sanal Dekorasyon API" seçeneğine tıklar
    And Kullanıcı formu gönderme butonuna tıklar
    Then Sistem formun gönderilmesini engellemeli ve ilgili zorunlu alanlar için uyarı mesajları göstermelidir