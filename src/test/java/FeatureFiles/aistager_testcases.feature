İstenen kayıp adımlar, ilgili senaryolara doğru sıra ve birebir aynı metinlerle eklenmiştir. Tam ve eksiksiz Gherkin senaryosu aşağıdadır:

```gherkin
Feature: Yapay Zeka Destekli Platform Yönetimi ve Servisleri
  Kullanıcılar platform üzerinde sanal dekorasyon, yapay zeka ile görsel düzenleme,
  sanal tur ve API entegrasyonu işlemlerini gerçekleştirebilmelidir.

  Background:
    Given Kullanıcı sisteme giriş yapmıştır

  Scenario: Geçerli formatta görsel yükleme ve parametre seçimiyle başarılı dekorasyon oluşturma
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta bir oda fotoğrafını yükler "oda.jpg"
    And Yüklenen fotoğrafın önizlemesinin ekranda göründüğü doğrulanır
    And Kullanıcı "Oda Türü" olarak "Oturma Odası" seçer
    And Kullanıcı "Tasarım Stili" olarak "Modern" seçer
    And Mevcut mobilyaları kaldır toggle ının varsayılan olarak açık olduğu doğrulanır
    And Kullanıcı görünürlük seçeneklerinden Herkese açık galeride göster seçeneğini seçer
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then İşlemin başladığı ve butonun aktif tıklanabilir olduğu doğrulanır
    And Yapay zeka ile mobilyalandırılmış yeni görsel ekranda başarıyla gösterilir

  Scenario Outline: Geçersiz formatta görsel yükleme girişimi
    Given Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı geçersiz formatta bir dosya yüklemeye çalışır "<gecersiz_dosya>"
    Then Sistem hata mesajı gösterir ve görsel yükleme reddedilir
    And Önizleme alanı boş kalır

    Examples:
      | gecersiz_dosya |
      | dosya.pdf      |
      | arsiv.zip      |
      | metin.txt      |

  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturma girişimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir oda fotoğrafı yükler "oda.png"
    And Kullanıcı "Oda Türü" ve "Tasarım Stili" seçimlerini boş bırakır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem zorunlu alanların seçilmesi gerektiğine dair uyarı mesajı gösterir
    And Yapay zeka üretim süreci başlamaz

  Scenario: İzin verilen maksimum dosya boyut sınırında görsel yükleme
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı izin verilen maksimum dosya boyutunda bir görsel yükler "max_boyut_oda.jpg"
    Then Görsel başarıyla yüklenir ve önizlemesi gösterilir

  Scenario: İzin verilen maksimum dosya boyutunu aşan görsel yükleme
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı maksimum dosya boyutunu aşan bir görsel yükler "buyuk_oda.jpg"
    Then Sistem Dosya boyutu çok büyük hatası gösterir ve görsel yüklenmez

  Scenario: Varsayılan kaynak görsel ve metin talimatı ile başarılı düzenleme
    Given Kullanıcı Virtual Staging sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif duruma getirmiştir
    When Edit photo source alanında varsayılan olarak Current image seçili olduğu doğrulanır
    And Kullanıcı Describe what to change alanına geçerli bir talimat girer "Remove the chair and add a plant"
    And Kullanıcı Edit Photo butonuna tıklar
    Then İşlemin tetiklendiği doğrulanır
    And Sistem girilen talimata uygun olarak güncellenmiş yeni görseli ekranda sunar

  Scenario: Alternatif kaynak görsel yükleyerek düzenleme yapma
    Given Kullanıcı Virtual Staging sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif duruma getirmiştir
    When Kullanıcı Edit photo source alanından alternatif bir görsel yükler "alternatif_oda.png"
    And Yüklenen alternatif görselin önizlemesi doğrulanır
    And Kullanıcı Describe what to change alanına talimat girer "Make the walls blue"
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem yeni görsel üzerinde talimatı uygulayarak güncellenmiş hali sunar

  Scenario: Talimat alanı boş bırakılarak düzenleme yapma girişimi
    Given Kullanıcı Virtual Staging sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif duruma getirmiştir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem Talimat alanı boş bırakılamaz şeklinde bir uyarı mesajı gösterir
    And Düzenleme süreci tetiklenmez

  Scenario: Ürünler menüsünden Sanal Tur sayfasına başarılı yönlendirme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler dropdown menüsüne gelir hover
    And Açılan listedeki 2 seçenek olan Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilir

  Scenario: Erken erişim talebinin başarıyla gönderilmesi
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan formda zorunlu e-posta alanını doldurur "test@example.com"
    And Kullanıcı formu gönderir
    Then Talebin başarıyla iletildiğina dair onay mesajı gösterilir

  Scenario: Geçersiz e-posta formatı ile erken erişim talebi gönderme
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    And Kullanıcı Erken Erişim İsteyin butonuna tıklar
    When Kullanıcı e-posta alanına geçersiz bir format girer "gecersiz-eposta"
    And Kullanıcı formu gönderir
    Then Sistem geçerli bir e-posta adresi girilmesi gerektiğine dair hata mesajı gösterir
    And Talep gönderilmez

  Scenario: E-posta alanı boş bırakılarak erken erişim talebi gönderme
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    And Kullanıcı Erken Erişim İsteyin butonuna tıklar
    When Kullanıcı e-posta alanını boş bırakarak gönder butonuna tıklar
    Then Alanın zorunlu olduğuna dair hata mesajı görüntülenir

  Scenario: Ürünler menüsünden Sanal Dekorasyon API sayfasına başarılı yönlendirme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler dropdown menüsüne gelir hover
    And Açılan listedeki 3 seçenek olan Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/api sayfasına yönlendirilir

  Scenario: API sayfası üzerinden başarılı iletişim formu gönderimi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
    And İletişim formundaki zorunlu alanları doldurur (Ad: "Ahmet", E-posta: "ahmet@corp.com", Mesaj: "API entegrasyonu hakkında bilgi istiyorum.")
    And Kullanıcı formu gönderir
    Then Sistem talebin alındığını belirten başarı onay mesajı gösterir

  Scenario: Fiyatlandırma sayfasına başarılı yönlendirme
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfanın alt kısmında bulunan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı doğru şekilde Fiyatlandırma Pricing sayfasına yönlendirilir

  Scenario: İletişim formunda zorunlu alanlar eksikken gönderim yapma
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    And Kullanıcı İletişime Geçin butonuna tıklar
    When Kullanıcı zorunlu alanlardan bazılarını boş bırakır Örn E-posta alanı boş
    And Kullanıcı formu gönderir
    Then Sistem eksik zorunlu alanlar için uyarı mesajları gösterir
    And Form gönderimi başarısız olur

  Scenario: İletişim formunda çok uzun karakterli mesaj girişi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    And Kullanıcı İletişime Geçin butonuna tıklar
    When Kullanıcı mesaj alanına sistem sınırlarını aşacak çok uzun metinler girer
    And Kullanıcı formu gönderir
    Then Sistem karakter sınır aşımı uyarısı gösterir veya metni kabul edilen sınıra göre kırpar