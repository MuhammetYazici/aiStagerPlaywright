Feature: AiStager Platformu Virtual Staging ve Müşteri Talepleri Yönetimi

  Background:
    Given Kullanıcı AiStager platformuna erişim sağlar

  Scenario: Varsayılan kontroller ve başarılı sanal dekorasyon oluşturma
    Given Kullanıcı Virtual Staging sayfasında oturum açmış durumdadır
    Then Mevcut mobilyaları kaldır seçeneğinin varsayılan olarak aktif olduğu doğrulanır
    And Görünürlük seçeneklerinden "Herkese Açık" radyo butonunun seçili olduğu doğrulanır
    When Kullanıcı dosya yükleme alanına "oda.jpg" dosyasını yükler
    Then Yüklenen görselin önizlemesi ekranda görüntülenir
    When Kullanıcı Oda Türü alanından "Salon" seçeneğini seçer
    And Kullanıcı Tasarım Stili alanından "Modern" seçeneğini seçer
    And Dekorasyon Oluştur butonuna tıklar
    Then Dekorasyon Oluştur butonunun işlem sırasında devre dışı ve yükleniyor durumunda olduğu doğrulanır
    And İşlem tamamlandığında mobilyalandırılmış görsel ekranda render edilir

  Scenario Outline: Desteklenen görsel formatları ile dekorasyon oluşturma
    Given Kullanıcı Virtual Staging sayfasında oturum açmış durumdadır
    When Kullanıcı dosya yükleme alanına "<dosya_adi>" dosyasını yükler
    Then Yüklenen görselin önizlemesi ekranda görüntülenir
    When Kullanıcı Oda Türü alanından "Yatak Odası" seçeneğini seçer
    And Kullanıcı Tasarım Stili alanından "Minimalist" seçeneğini seçer
    And Dekorasyon Oluştur butonuna tıklar
    Then İşlem tamamlandığında mobilyalandırılmış görsel ekranda render edilir

    Examples:
      | dosya_adi |
      | salon.jpg |
      | salon.png |

  Scenario: Desteklenmeyen dosya formatı yüklendiğinde hata gösterimi
    Given Kullanıcı Virtual Staging sayfasında oturum açmış durumdadır
    When Kullanıcı dosya yükleme alanına "proje_taslagi.pdf" dosyasını yükler
    Then Desteklenmeyen dosya formatı uyarısı ekranda görüntülenir
    And Görsel önizleme alanı boş kalır
    And Dekorasyon Oluştur butonu tıklanamaz durumda olur

  Scenario Outline: Zorunlu alanlar eksik bırakıldığında dekorasyon oluşturma butonunun kısıtlanması
    Given Kullanıcı Virtual Staging sayfasında oturum açmış durumdadır
    When Kullanıcı görsel yükleme durumunu "<gorsel_durumu>" olarak ayarlar
    And Kullanıcı Oda Türü seçimini "<oda_turu>" olarak belirler
    And Kullanıcı Tasarım Stili seçimini "<tasarim_stili>" olarak belirler
    Then Dekorasyon Oluştur butonunun tıklanamaz durumda olduğu doğrulanır

    Examples:
      | gorsel_durumu | oda_turu | tasarim_stili |
      | Yuklenmedi    | Salon    | Modern        |
      | Yuklendi      | Secilmedi| Iskandinav    |
      | Yuklendi      | Mutfak   | Secilmedi     |
      | Yuklenmedi    | Secilmedi| Secilmedi     |

  Scenario: Prompt kullanarak başarılı görsel manipülasyonu
    Given Kullanıcı AI Edit sekmesine geçer ve kaynak görsel tanımlıdır
    Then Kaynak görsel seçeneğinin varsayılan olarak "Current image" olduğu doğrulanır
    When Kullanıcı metin alanına "Ortadaki sandalyeyi kaldır" komutunu yazar
    And Edit Photo butonuna tıklar
    Then Sistemin talebi işlediği görüntülenir
    And Orijinal görsel korunarak yeni düzenlenmiş versiyon ekranda sunulur

  Scenario: Prompt alanı boş bırakıldığında düzenleme işleminin engellenmesi
    Given Kullanıcı AI Edit sekmesine geçer ve kaynak görsel tanımlıdır
    When Kullanıcı komut giriş alanını boş bırakır
    Then Edit Photo butonunun devre dışı olduğu doğrulanır

  Scenario: Ürünler menüsünden Yapay Zeka Sanal Tur sayfasına yönlendirme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header menüsünde yer alan "Ürünler" sekmesini açar
    And Açılan menünün ikinci sırasındaki "Yapay Zeka Sanal Tur" seçeneğine tıklar
    Then Tarayıcı adres çubuğundaki URL değeri "aistager.ai/tr/ai-virtual-tour" olmalıdır

  Scenario: Ürünler menüsünden Sanal Dekorasyon API sayfasına yönlendirme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Header menüsünde yer alan "Ürünler" sekmesini açar
    And Açılan menünün üçüncü sırasındaki "Sanal Dekorasyon API" seçeneğine tıklar
    Then Tarayıcı adres çubuğundaki URL değeri "aistager.ai/tr/api" olmalıdır

  Scenario: Sanal Tur erken erişim talebinin başarıyla gönderilmesi
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına gider
    When Kullanıcı Erken Erişim Formu üzerindeki ad alanına "Ahmet Yılmaz" bilgisini girer
    And E-posta alanına "ahmet.yilmaz@example.com" bilgisini girer
    And Erken Erişim İsteyin butonuna tıklar
    Then Talep başarıyla kaydedilmelidir
    And Form ekranı kapanmalıdır
    And Ekranda onay bildirim mesajı görüntülenmelidir

  Scenario Outline: Erken erişim ve iletişim formlarında geçersiz e-posta validasyonu
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına gider
    When Kullanıcı E-posta alanına "<gecersiz_eposta>" bilgisini yazar
    And Formu gönder butonuna tıklar
    Then Geçersiz e-posta biçimi hata mesajı görüntülenir
    And Form gönderimi engellenir

    Examples:
      | gecersiz_eposta     |
      | ahmet.ornek.com     |
      | ahmet@              |
      | ahmet@domain        |
      | @example.com        |

  Scenario: Zorunlu alanlar doldurulmadan form gönderiminin engellenmesi
    Given Kullanıcı "aistager.ai/tr/api" sayfasına gider
    When Kullanıcı İletişime Geçin formundaki zorunlu alanları boş bırakır
    And Gönder butonuna tıklar
    Then Zorunlu alanların doldurulması gerektiğine dair uyarı mesajları görüntülenir
    And Form gönderilmez

  Scenario: API iletişim formunun gönderilmesi ve fiyatlandırma yönlendirmesi
    Given Kullanıcı "aistager.ai/tr/api" sayfasına gider
    When Kullanıcı İletişime Geçin formunu eksiksiz ve geçerli verilerle doldurur
    And Gönder butonuna tıklar
    Then Başarılı gönderim onay mesajı görüntülenir
    And Form alanı kapanır
    When Kullanıcı sayfanın alt bölümündeki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı "/pricing" sayfasına başarıyla yönlendirilmelidir