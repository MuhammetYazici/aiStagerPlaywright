İstediğin adımlar, orijinal senaryodaki yapı ve kurallara sadık kalınarak, ilgili senaryoların altına doğru sıra ve birebir metinlerle eklenmiştir. İşte senaryonun **TAM ve eksiksiz** hali:

```gherkin
Feature: AiStager Platformu Uctan Uca Test Senaryolari
  Kullanici olarak AI destekli sanal dekorasyon, gorsel duzenleme, urun kesfi, 
  erken erisim talebi ve API iletisim akislarini sorunsuz bir sekilde gerceklestirmek istiyorum.

  Background:
    Given Kullanici AiStager platformundadir

  @positive @BR-01
  Scenario Outline: Desteklenen formatlarda basarili gorsel yukleme
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı "<format>" formatındaki boş oda görselini sürükle-bırak yöntemiyle yükler
    Then Gorsel sisteme basarili bir sekilde yuklenmelidir
    And Yuklenen gorselin onizlemesi kullaniciya gosterilmelidir

    Examples:
      | format |
      | .jpg   |
      | .png   |

  @negative @BR-01 @edge-case
  Scenario Outline: Desteklenmeyen formatlarda gorsel yukleme denemesi
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı "<gecersiz_format>" formatındaki bir dosyayı yüklemeye çalışır
    Then Sistem Gecersiz dosya formati hata mesaji gostermelidir
    And Onizleme alani bos kalmalidir

    Examples:
      | gecersiz_format |
      | .gif            |
      | .pdf            |
      | .webp           |
      | .txt            |

  @edge-case @BR-01
  Scenario: Maksimum dosya boyutu sinirindaki gorselin yuklenmesi
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı izin verilen maksimum dosya boyutunda bir .jpg görseli yükler
    Then Görsel başarıyla yüklenmeli ve önizlemesi gösterilmelidir

  @negative @BR-01 @edge-case
  Scenario: Maksimum dosya boyutunu asan gorsel yukleme denemesi
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı izin verilen maksimum boyuttan daha büyük bir görsel yüklemeye çalışır
    Then Sistem Dosya boyutu cok buyuk uyarisi vermelidir

  @positive @BR-02
  Scenario: Zorunlu alanlarin doldurulmasi ve varsayilan ayarların kontrolu
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı "Oda Türü" olarak "Oturma Odası" seçer
    And Kullanıcı "Tasarım Stili" olarak "Modern" seçer
    Then Mevcut mobilyalari kaldir toggle'inin varsayilan olarak acik ON geldigi gorulmelidir
    And Kullanıcı gorunurluk tercihlerinden bir radio buton secebilmelidir

  @negative @BR-02
  Scenario Outline: Zorunlu parametreler eksikken dekorasyon olusturma denemesi
    Given Kullanici Virtual Staging sayfasindadir
    When Kullanıcı "Oda Türü" alanını "<oda_turu>" ve "Tasarım Stili" alanını "<stil>" bırakır
    Then Dekorasyon Olustur butonunun pasif disabled oldugu gorulmelidir

    Examples:
      | oda_turu     | stil      |
      | Secilmedi    | Modern    |
      | Oturma Odasi | Secilmedi |
      | Secilmedi    | Secilmedi |

  @positive @BR-03
  Scenario: Basarili AI Staging Dekorasyon uretimi
    Given Kullanici gecerli bir oda gorseli yuklemistir
    And Kullanıcı "Oda Türü" ve "Tasarım Stili" seçimlerini yapmıştır
    When Kullanıcı "Dekorasyon Oluştur" butonuna tıklar
    Then Sistem yuklenme animasyonu gostermelidir
    And Seçilen oda türü ve stile uygun mobilyalandırılmış yeni görsel kullanıcıya sunulmalıdır

  @positive @BR-04
  Scenario: Mevcut kaynak gorsel ile basarili AI Edit yapilmasi
    Given Kullanici AI Edit sekmesindedir
    When Kullanıcı "Current image" (Mevcut kaynak görsel) seçeneğini kullanır
    And "Describe what to change" alanına "Remove the chair" metinsel talimatını girer
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then İlgili değişiklik (koltuğun kaldırılması) görsel üzerinde başarıyla gerçekleştirilmelidir

  @positive @BR-04
  Scenario: Yeni gorsel yukleyerek basarili AI Edit yapilmasi
    Given Kullanici AI Edit sekmesindedir
    When Kullanıcı düzenleme için yeni bir görsel yükler
    And "Describe what to change" alanına geçerli bir İngilizce komut girer
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Değişiklik uygulanmış yeni görsel ekranda gösterilmelidir

  @negative @BR-04 @edge-case
  Scenario: Metinsel komut alani bos birakilarak AI Edit tetiklenmesi
    Given Kullanici AI Edit sekmesinde bir gorsel secmistir
    When Kullanıcı "Describe what to change" alanını boş bırakır
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Sistem "Lütfen yapılacak değişikliği açıklayın" uyarısı vermelidir
    And İşlem gerçekleştirilmemelidir

  @edge-case @BR-04
  Scenario: Anlamsiz veya sisteme yabanci metinsel komut girilmesi
    Given Kullanici AI Edit sekmesinde bir gorsel secmistir
    When Kullanıcı "Describe what to change" alanına rastgele karakterler veya anlamsiz metin girer
    And Kullanıcı "Edit Photo" butonuna tıklar
    Then Sistem komutu isleyemedigini belirten bir hata mesaji veya kibar bir uyari gostermelidir

  @positive @BR-05
  Scenario: Urunler dropdown menusunun goruntulenmesi
    Given Kullanıcı ana sayfadadır ("aistager.ai/tr")
    When Kullanıcı ana sayfadaki header alanında "Ürünler" menüsünün üzerine gelir (hover over)
    Then Alt secenekler ("Yapay Zeka Sanal Tur" ve "Sanal Dekorasyon API") listelenmelidir

  @positive @BR-06
  Scenario: Yapay Zeka Sanal Tur sayfasina yonlendirme ve Erken Erisim talebi
    Given Kullanıcı ana sayfadadır ("aistager.ai/tr")
    When Kullanıcı "Ürünler" menüsünden "Yapay Zeka Sanal Tur" seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilmelidir
    When Kullanıcı "Erken Erişim İsteyin" butonuna tıklar
    And Acan formda zorunlu e-posta alanina gecerli bir e-posta adresi girer "test@example.com"
    And Talebi gonder butonuna tıklar
    Then Sistem basarili onay mesaji Talebiniz alinmistir gostermelidir

  @negative @BR-06 @edge-case
  Scenario: Erken Erisim formunda gecersiz e-posta adresi ile talep gonderme
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır ve Erken Erişim formu açıktır
    When Kullanıcı e-posta alanına geçersiz bir format girer ("gecersiz-eposta")
    And Talebi gonder butonuna tıklar
    Then Sistem gecerli bir e-posta adresi girilmesi gerektigini belirten bir hata mesaji gostermelidir

  @negative @BR-06 @edge-case
  Scenario: Erken Erisim formunda e-posta alani bos birakilarak gonderim denemesi
    Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır ve Erken Erişim formu açıktır
    When Kullanıcı e-posta alanını boş bırakarak gönder butonuna tıklar
    Then Sistem zorunlu alan uyarisi vermelidir

  @positive @BR-07
  Scenario: Sanal Dekorasyon API sayfasina yonlendirme ve iletisim formu doldurma
    Given Kullanıcı ana sayfadadır ("aistager.ai/tr")
    When Kullanıcı "Ürünler" menüsünden "Sanal Dekorasyon API" seçeneğine tıklar
    Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilmelidir
    When Kullanıcı "İletişime Geçin" butonuna tıklar
    And İletişim formundaki "Ad", "E-posta" ve "Mesaj" zorunlu alanlarını geçerli bilgilerle doldurur
    And Gönder butonuna tıklar
    Then Talep basariyla iletilmeli ve kullaniciya basari onay mesaji gosterilmelidir

  @negative @BR-07 @edge-case
  Scenario: Iletisim formunda eksik alanlarla API talebi gonderme
    Given Kullanıcı "aistager.ai/tr/api" sayfasındadır ve iletişim formu açıktır
    When Kullanıcı "Ad" ve "Mesaj" alanlarını doldurup "E-posta" alanını boş bırakır
    And Gönder butonuna tıklar
    Then Sistem eksik alanlar icin uyari mesajlari gostermelidir

  @positive @BR-07
  Scenario: Fiyatlandirma sayfasina yonlendirme
    Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
    When Kullanıcı sayfadaki "Fiyatlandırmayı Görüntüle" butonuna tıklar
    Then Kullanıcı hatasız bir sekilde Fiyatlandirma sayfasina yonlendirilmelidir