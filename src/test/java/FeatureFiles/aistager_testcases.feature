Feature: AiStager Platformu Sanal Dekorasyon ve Ürün Keşfi Yönetimi
  Sisteme giriş yapmış ve yapmamış kullanıcıların sanal dekorasyon, 
  AI edit yapma, navigasyon ve erken erişim formu işlemlerini test eder.

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @staging
  Scenario: Başarılı Virtual Staging Oluşturma
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta "jpg" bir boş oda fotoğrafı yükler
    And Yüklenen görselin önizlemesinin ekranda göründüğü doğrulanır
    And Oda Türü olarak Oturma Odası seçilir
    And Tasarım Stili olarak Modern seçilir
    And Mevcut mobilyaları kaldır toggle'ının varsayılan olarak açık olduğu görülür
    And Görselin galeri görünürlük tercihi Herkese açık olarak belirlenir
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem yüklenen odayı, seçilen konsept ve stile uygun olarak mobilyalandırıp ekranda göstermelidir

  @negative @staging
  Scenario Outline: Desteklenmeyen Formatlarda Görsel Yükleme
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı "<gecersiz_format>" uzantılı bir görsel yüklemeye çalışır
    Then Sistem Desteklenmeyen dosya formatı. Lütfen jpg veya png yükleyin. hata mesajını göstermelidir
    And Dekorasyon Oluştur butonu pasif kalmalı veya işlem engellenmelidir

    Examples:
      | gecersiz_format |
      | gif             |
      | bmp             |
      | pdf             |
      | tiff            |

  @edge-case @staging
  Scenario: Zorunlu Alanlar Eksikken Virtual Staging Oluşturma
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta "png" bir görsel yükler
    And Oda Türü ve Tasarım Stili seçimleri yapılmaz
    And Dekorasyon Oluştur butonuna tıklanır
    Then Sistem kullanıcıya eksik alanları Oda Türü ve Tasarım Stili belirten bir uyarı mesajı göstermelidir

  @edge-case @staging
  Scenario: Maksimum Boyut Sınırındaki Görselin Yüklenmesi
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı izin verilen maksimum dosya boyut sınırında bir görsel yükler
    Then Görsel başarıyla yüklenmeli ve önizlemesi ekranda gösterilmelidir

  @positive @ai-edit
  Scenario: Varsayılan Görsel ile Başarılı AI Edit Uygulama
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı AI Edit sekmesindedir
    When Kaynak görsel olarak varsayılan seçili gelen Current image kullanılır
    And Describe what to change alanına Duvarı koyu yeşile boya ve ahşap sehpa ekle metni girilir
    And Edit Photo butonuna tıklanır
    Then Sistem, girilen talimata uygun şekilde düzenlenmiş görseli ekranda göstermelidir

  @positive @ai-edit
  Scenario: Yeni Yüklenen Görsel ile Başarılı AI Edit Uygulama
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı AI Edit sekmesindedir
    When Kullanıcı yeni bir png formatında kaynak görsel yükler
    And Describe what to change alanına geçerli bir düzenleme talimatı girilir
    And Edit Photo butonuna tıklanır
    Then Sistem yeni görsel üzerinde düzenleme yaparak sonucu kullanıcıya sunmalıdır

  @negative @ai-edit
  Scenario: Boş Talimat Metni ile AI Edit Çalıştırma
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı AI Edit sekmesindedir
    When Kaynak görsel seçilir ancak Describe what to change alanı boş bırakılır
    And Edit Photo butonuna tıklanır
    Then Sistem Lütfen yapılmasını istediğiniz değişikliği açıklayın. uyarısını vermelidir
    And Düzenleme işlemi başlatılmamalıdır

  @edge-case @ai-edit
  Scenario: Çok Uzun Metin Girişi ile AI Edit
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    And Kullanıcı AI Edit sekmesindedir
    When Describe what to change alanına sistemin izin verdiği maksimum karakter sınırını aşan çok uzun bir metin girilir
    Then Sistem ya metni kırpabilmeli ya da izin verilen karakter sınırını aşamayacağına dair bir uyarı göstermelidir

  @positive @navigation
  Scenario: Ürünler Menüsü Hover ve Sayfa Yönlendirmeleri
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler menüsüne hover over yapar
    Then Alt seçeneklerin listelendiği görülür
    When Listeden Yapay Zeka Sanal Tur seçeneğine tıklanır
    Then Kullanıcı aistager.ai/tr/ai-virtual-tour adresine yönlendirilmelidir
    When Kullanıcı tekrar ana sayfaya dönüp Ürünler menüsüne hover yapar
    And Listeden Sanal Dekorasyon API seçeneğine tıklanır
    Then Kullanıcı aistager.ai/tr/api adresine yönlendirilmelidir

  @positive @lead-gen
  Scenario: Yapay Zeka Sanal Tur Erken Erişim Talebi Oluşturma
    Given Kullanıcı Yapay Zeka Sanal Tur sayfasındadır
    When Erken Erişim İsteyin butonuna tıklanır
    And Açılan forma geçerli bir e-posta adresi "test@example.com" girilir
    And Talep gönder butonuna tıklanır
    Then Sistem talebi başarıyla almalı ve kullanıcıya Tarih talebiniz alınmıştır, teşekkürler! gibi net bir onay mesajı göstermelidir

  @negative @lead-gen
  Scenario Outline: Geçersiz E-posta ile Erken Erişim Talebi Gönderme
    Given Kullanıcı Yapay Zeka Sanal Tur sayfasındadır
    When Erken Erişim İsteyin butonuna tıklanır
    And Açılan forma geçersiz formatta bir e-posta "<gecersiz_email>" girilir
    And Talep gönder butonuna tıklanır
    Then Sistem geçerli bir e-posta adresi girilmesini belirten bir hata mesajı göstermelidir

    Examples:
      | gecersiz_email    |
      | test              |
      | test@.com         |
      | @example.com      |
      | test.com          |

  @positive @lead-gen
  Scenario: Sanal Dekorasyon API İletişim Formu Gönderimi ve Fiyatlandırma Yönlendirmesi
    Given Kullanıcı Sanal Dekorasyon API sayfasındadır
    When İletişime Geçin butonuna tıklanır
    And İletişim formu zorunlu alanları eksiksiz doldurulur
    And Form gönderilir
    Then Sistem talebin alındığını onaylayan başarı mesajını göstermelidir
    When Kullanıcı sayfanın altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  @edge-case @lead-gen
  Scenario: İletişim Formunda Zorunlu Alanların Boş Bırakılması
    Given Kullanıcı Sanal Dekorasyon API sayfasındaki iletişim formundadır
    When Zorunlu alanlardan en az biri boş bırakılarak form gönderilir
    Then Sistem boş bırakılan alanlar için uyarı mesajları göstermeli ve formun gönderilmesine izin vermemelidir