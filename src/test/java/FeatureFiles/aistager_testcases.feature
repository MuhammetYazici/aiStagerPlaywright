İstediğiniz adımlar, ilgili senaryolara mevcut hiçbir adımı bozmadan, doğru sıra ve birebir aynı metinlerle eklenmiştir. İşte senaryonun tam ve eksiksiz hali:

```gherkin
Feature: AiStager.ai Temel Yetkinlikler ve Navigasyon Akışları

  Background:
    Given Kullanıcı AiStager platformundadır

  @Positive @AC1
  Scenario: Başarılı bir şekilde Virtual Staging oluşturulması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta .jpg veya .png bir boş oda fotoğrafı yükler
    And Görselin başarıyla önizlemesi görüntülenir
    And Oda Türü dropdown alanından "Oturma Odası" seçilir
    And Tasarım Stili dropdown alanından "Modern" seçilir
    And Mevcut mobilyaları kaldır toggle'ının açık (active) olduğu doğrulanır
    And Görünürlük seçeneği olarak Herkese açık galeride göster seçilir
    And "Dekorasyon Oluştur" butonuna tıklanır
    Then Sistem odayı analiz eder ve seçilen stil ve oda türüne uygun mobilyalandırılmış yeni görseli ekranda gösterir

  @Negative @AC1
  Scenario Outline: Desteklenmeyen dosya formatları ile görsel yükleme denemesi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı <GecersizFormat> uzantılı bir dosya yüklemeye çalışır
    Then Sistem <HataMesaji> içeren bir hata mesajı göstermelidir
    And Dekorasyon Oluştur butonu pasif kalmalıdır

    Examples:
      | GecersizFormat | HataMesaji                                                |
      | .gif           | Desteklenmeyen dosya formatı .jpg veya .png yükleyiniz    |
      | .pdf           | Desteklenmeyen dosya formatı .jpg veya .png yükleyiniz    |

  @Negative @AC1
  Scenario: Zorunlu parametreler seçilmeden dekorasyon oluşturma denemesi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı geçerli bir .jpg formatında oda fotoğrafı yükler
    And "Oda Türü" ve "Tasarım Stili" alanlarını boş bırakır
    Then Dekorasyon Oluştur butonunun pasif olduğu görülür

  @EdgeCase @AC1
  Scenario: Maksimum dosya boyutunda görsel yükleyerek Virtual Staging oluşturulması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasındadır
    When Kullanıcı sistemin kabul ettiği maksimum dosya boyutundaki .png formatlı görseli yükler
    And Görsel önizlemesinin yüklendiği doğrulanır
    And "Oda Türü" olarak "Yatak Odası" ve "Tasarım Stili" olarak "Skandinav" seçilir
    And "Dekorasyon Oluştur" butonuna tıklanır
    Then Sistem görseli başarıyla işler ve yeni dekorasyonu oluşturur

  @Positive @AC2
  Scenario: Mevcut görsel üzerinde AI Edit ile başarılı değişiklik yapılması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasında AI Edit sekmesindedir
    When Edit photo source alanında Current image seçeneğinin seçili olduğu doğrulanır ve önizleme gösterilir
    And Describe what to change alanına Remove the chair metni girilir
    And "Edit Photo" butonuna tıklanır
    Then Sistem girilen talimata uygun olarak görsel üzerinde değişiklik yapar ve sonucu kullanıcıya sunar

  @Negative @AC2
  Scenario: AI Edit alanında boş talimat ile düzenleme isteği gönderilmesi
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasında AI Edit sekmesindedir
    When Kullanıcı kaynak görseli seçer
    And Describe what to change alanını boş bırakır
    And "Edit Photo" butonuna tıklanır
    Then Sistem boş talimat hatası vermeli ve işlem yapılmamalıdır

  @EdgeCase @AC2
  Scenario: Çok uzun metin talimatı ile AI Edit yapılması
    Given Kullanıcı giriş yapmış ve Virtual Staging sayfasında AI Edit sekmesindedir
    When Kullanıcı yeni bir görsel yükler
    And Describe what to change alanına sistemin karakter sınırına yakın çok uzun bir metin talimatı girilir
    And "Edit Photo" butonuna tıklanır
    Then Sistem metni işleyerek düzenleme sürecini başlatır veya uygun bir yönlendirme yapar

  @Positive @AC3
  Scenario: Yapay Zeka Sanal Tur sayfasına gidilmesi ve erken erişim talebi oluşturulması
    Given Kullanıcı ana sayfada oturum açmıştır
    When Kullanıcı header alanındaki Ürünler dropdown menüsüne hover yapar
    And Açılan listeden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilir
    When Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar
    And Açılan forma geçerli bir e-posta adresi "test@example.com" girilir
    And Talebi gönder butonuna tıklanır
    Then Sistem başarılı gönderim onay mesajını göstermelidir

  @Negative @AC3
  Scenario Outline: Erken erişim formuna geçersiz e-posta adresi girilmesi
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklayarak formu açar
    And E-posta alanına "<GecersizEmail>" girer
    And Gönder butonuna tıklar
    Then Sistem Geçersiz e-posta formatı uyarısı göstermelidir

    Examples:
      | GecersizEmail    |
      | invalid-email    |
      | test@.com        |
      | @domain.com      |

  @EdgeCase @AC3
  Scenario: Erken erişim formunun boş e-posta ile gönderilmesi
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklayarak formu açar
    And E-posta alanını boş bırakıp gönder butonuna tıklar
    Then Sistem alanın zorunlu olduğuna dair bir uyarı mesajı göstermelidir

  @Positive @AC4
  Scenario: Sanal Dekorasyon API sayfasına yönlendirme ve iletişim formu doldurma
    Given Kullanıcı ana sayfada oturum açmıştır
    When Kullanıcı header alanındaki Ürünler dropdown menüsüne hover yapar
    And Açılan listeden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/api sayfasına yönlendirilir
    When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
    And İletişim formundaki Ad, E-posta ve Mesaj alanları geçerli bilgilerle doldurulur
    And Formu gönder butonuna tıklanır
    Then Sistem başarılı gönderim onay mesajı iletmelidir

  @Positive @AC4
  Scenario: Sanal Dekorasyon API sayfasından Fiyatlandırma sayfasına yönlendirme
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfanın alt kısmında yer alan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  @Negative @AC4
  Scenario: API iletişim formunda zorunlu alanların eksik bırakılması
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Formdaki alanlardan biri veya birkaçı boş bırakılarak gönder butonuna basılır
    Then Sistem eksik alanlar için uyarı mesajları göstermelidir

  @EdgeCase @AC4
  Scenario: API iletişim formuna çok uzun mesaj metni girilmesi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Ad ve E-posta alanları doldurulur
    And Mesaj alanına izin verilen maksimum karakter sınırını aşan çok uzun bir metin girilip gönderilir
    Then Sistem karakter sınırını belirten bir hata mesajı vermeli veya metni kırparak işleme devam etmelidir