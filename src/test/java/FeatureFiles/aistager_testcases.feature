İstediğiniz eksik adımlar ilgili senaryolara, doğru sıra ve birebir metinlerle eklenmiş olarak aşağıdadır:

```gherkin
@virtual_staging @ai_edit @navigation @lead_generation @api
Feature: AI Destekli Sanal Dekorasyon Ürün Keşfi ve API İletişim Akışları
  Kayıtlı kullanıcı olarak mülklerimi dijital olarak dekore edebilmeli
  mevcut görseller üzerinde yapay zeka ile değişiklikler yapabilmeli
  ana menü üzerinden ürünlere erişebilmeli erken erişim talebinde bulunabilmeli
  API iletişim formu doldurabilmeli ve fiyatlandırma sayfasına yönlendirilebilmeliyim

  Background:
    Given Kullanıcı sisteme giriş yapmıştır

  @positive @br-01
  Scenario: Geçerli formatta boş oda fotoğrafı yükleme
    Given Kullanıcı sisteme giriş yapmış ve ana sayfadadır
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı .jpg veya .png formatında geçerli bir oda fotoğrafı yükler
    Then Görsel başarıyla yüklenmeli
    And Yüklenen görselin önizlemesi ekranda görünmelidir

  @negative @br-01
  Scenario: Geçersiz formatta dosya yükleme girişimi
    Given Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı desteklenmeyen formatta bir dosya yükler örn .pdf veya .txt
    Then Sistem hata mesajı göstermelidir Desteklenmeyen dosya formatı
    And Görsel önizlemesi oluşmamalıdır

  @edge_case @br-01
  Scenario: İzin verilen maksimum dosya boyut sınırında görsel yükleme
    Given Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı sistemin izin verdiği maksimum dosya boyutuna sahip bir görsel yükler
    Then Görsel hatasız bir şekilde yüklenmeli ve önizlemesi gösterilmelidir

  @positive @br-02
  Scenario: Zorunlu dekorasyon parametrelerinin eksiksiz seçilmesi
    Given Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı "Oda Türü" olarak "Oturma Odası" seçer
    And Kullanıcı "Tasarım Stili" olarak "Modern" seçer
    And Mevcut mobilyaları kaldır toggle'ının varsayılan olarak açık olduğunu doğrular
    And Görsel görünürlük tercihi olarak Herkese açık galeride göster radyo butonunu seçer
    Then Tüm parametreler doğru şekilde seçilmiş olmalıdır

  @negative @br-02
  Scenario: Zorunlu alanlar seçilmeden işlem yapma
    Given Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı "Oda Türü" veya "Tasarım Stili" seçimini yapmaz
    Then Dekorasyon Oluştur butonunun pasif disabled olduğu görülmelidir

  @positive @br-03
  Scenario: Başarılı Virtual Staging üretimi
    Given Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı geçerli bir oda görseli yüklemiştir
    And Kullanıcı gerekli parametreleri ("Oda Türü" ve "Tasarım Stili") seçmiştir
    When Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then AI seçilen oda türü ve stil kurallarına uygun yeni görseli üretmelidir
    And Üretilen mobilyalandırılmış görsel kullanıcıya sunulmalıdır

  @positive @br-04 @br-05
  Scenario: Mevcut görsel üzerinden AI Edit ile nesne silme
    Given Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı "AI Edit" sekmesine geçiş yapar
    When Kullanıcı kaynak görsel olarak Current image seçeneğini seçer
    And Kullanıcı Describe what to change alanına Remove the chair metinsel talimatını yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Yapay zeka görseli talimata uygun şekilde revize etmeli ve yeni çıktıyı sunmalıdır

  @positive @br-04 @br-05
  Scenario: Yeni görsel yükleyerek AI Edit gerçekleştirme
    Given Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı "AI Edit" sekmesine geçiş yapar
    When Kullanıcı kaynak görsel olarak yeni bir görsel yükler
    And Kullanıcı Describe what to change alanına geçerli bir talimat yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Yapay zeka yüklenen yeni görsel üzerinde talimatı uygulamalıdır

  @negative @br-05
  Scenario: Boş talimat metni ile AI Edit çalıştırma denemesi
    Given Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı "AI Edit" sekmesindedir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem Talimat alanı boş bırakılamaz şeklinde bir uyarı göstermelidir

  @positive @br-06
  Scenario Outline: Ana menüden alt ürün sayfalarına yönlendirme
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler dropdown menüsüne hover over yapar
    And Açılan menüden "<Urun_Adi>" seçeneğine tıklar
    Then Kullanıcı "<Hedef_URL>" sayfasına yönlendirilmelidir

    Examples:
      | Urun_Adi                | Hedef_URL                    |
      | Yapay Zeka Sanal Tur    | aistager.ai/tr/ai-virtual-tour |
      | Sanal Dekorasyon API    | aistager.ai/tr/api           |

  @positive @br-07
  Scenario: Yapay Zeka Sanal Tur için başarılı erken erişim talebi
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan modal form alanına geçerli bir e-posta adresi girer
    And Gönder butonuna tıklar
    Then Sistem başarı onay mesajı göstermelidir

  @negative @br-07
  Scenario: Geçersiz e-posta ile erken erişim talebi gönderme
    Given Kullanıcı "Erken Erişim" modal/form alanındadır
    When Kullanıcı geçersiz bir e-posta formatı girer örn kullanici.com
    And Gönder butonuna tıklar
    Then Sistem e-posta format hatası mesajı göstermelidir

  @positive @br-08
  Scenario: Sanal Dekorasyon API sayfası üzerinden başarılı iletişim formu gönderimi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
    And İletişim formundaki ad, e-posta ve mesaj alanlarını geçerli bilgilerle doldurur
    And Formu gönderir
    Then Başarılı gönderim mesajı iletilmelidir

  @negative @br-08
  Scenario: Zorunlu alanları boş bırakarak API iletişim formu gönderme
    Given Kullanıcı API iletişim formundadır
    When Kullanıcı zorunlu alanlardan birini veya hepsini boş bırakarak gönder butonuna tıklar
    Then Sistem zorunlu alan uyarı mesajlarını göstermelidir

  @positive @br-08
  Scenario: Fiyatlandırma sayfasına başarılı yönlendirme
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfanın alt kısmındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız şekilde Fiyatlandırma sayfasına yönlendirilmelidir