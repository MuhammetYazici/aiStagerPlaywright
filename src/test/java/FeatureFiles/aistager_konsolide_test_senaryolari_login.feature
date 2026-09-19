Feature: US_HP_001 - AiStager.ai Ana Sayfa Temel Fonksiyonları, Menü ve Galeri Yönetimi

  @regression @homepage @slider
  Scenario: Öncesi ve Sonrası Slider ile Carousel bileşenlerinin sorunsuz çalışması
    Given kullanıcı "https://aistager.ai/tr" adresindedir
    When kullanıcı ana sayfadaki "Öncesi ve Sonrası" görsel alanına gelir
    And kullanıcı ortadaki iki yönlü ok butonuna basılı tutarak sağa ve sola sürükler
    And kullanıcı slider altındaki ok butonlarına ve yuvarlak carousel noktalarına tıklar
    And kullanıcı "Odanızı Yükleyin" butonuna ve "TR" dil seçeneğine tıklar
    Then görsel geçişleri pürüzsüz gerçekleşmeli ve "Önce/Sonra" alanları dinamik boyutlanmalıdır
    And nokta ve ok seçimleri ilgili odayı ekrana getirmelidir
    And dil değişimi arayüz metinlerini güncellemelidir
    And "Odanızı Yükleyin" butonu kullanıcıyı ilgili oda yükleme arayüzüne yönlendirmelidir

  @smoke @header @logged_in
  Scenario: Giriş yapmış kullanıcı için Üst Menü navigasyonunun kontrolü
    Given kullanıcı sisteme oturum açmıştır ve ana sayfadadır
    When kullanıcı "Logo", "Ürünler", "Çözümler", "Kaynaklar" ve "Fiyatlandırma" menülerine tıklar veya hover yapar
    And kullanıcı "Üretimlerim", "Dil Seçeneği", "Hızlı Erişim Paneli" ve "Profil İkonu"na tıklar
    Then tüm menü öğeleri ilgili alt sayfaları, panelleri veya açılır menüleri hatasız olarak tetiklemelidir

  @smoke @header @visitor
  Scenario: Ziyaretçi (Giriş yapmamış) kullanıcı için Üst Menü ve gizli alanların kontrolü
    Given kullanıcı sisteme oturum açmamıştır ve ana sayfadadır
    When kullanıcı sağ üst alandaki "Giriş Yap" butonuna tıklar
    And kullanıcı "Ücretsiz Dene" butonuna tıklar
    And kullanıcı üst menüde "Üretimlerim" seçeneğini ve "Profil" ikonunu arar
    Then "Giriş Yap" butonu kullanıcıyı login sayfasına yönlendirmelidir
    And "Ücretsiz Dene" butonu kullanıcıyı register sayfasına yönlendirmelidir
    And "Üretimlerim" seçeneği ve profil ikonu ziyaretçi görünümünde kesinlikle görünmemelidir

  @regression @gallery @positive
  Scenario: Topluluk galerisinde filtreleme ve etkileşimler
    Given kullanıcı ana sayfa galeri alanındadır
    When kullanıcı spesifik oda tipi butonuna (örn. "Oturma Odası") tıklar
    And kullanıcı listelenen bir tasarımın üzerindeki Kalp (Beğeni) ikonuna tıklar
    And kullanıcı sayfanın altında bulunan "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then galeri sadece seçilen "Oturma Odası" tipindeki tasarımları içerecek şekilde filtrelenmelidir
    And kalp ikonu aktifleşmeli ve beğeni sayacı bir artmalıdır
    And "Daha Fazla Tasarım Yükle" butonuna basıldığında gelen yeni kartlar da mevcut filtre kuralına (Oturma Odası) uygun olmalıdır

  @regression @faq @positive
  Scenario: SSS (Sıkça Sorulan Sorular) akordeon menü mantığı ve yönlendirmeler
    Given kullanıcı SSS alanındadır
    When kullanıcı birinci SSS başlığına tıklar ve içeriğin açıldığını görür
    And kullanıcı içerikte yer alan "Bize ulaşın" linkine tıklar
    And kullanıcı birinci soru açık durumdayken ikinci bir SSS başlığına tıklar
    Then "Bize ulaşın" linki kullanıcıyı destek sayfasına yönlendirmelidir
    And ikinci soru açıldığında içeriği görünür olmalı ve önceki açılan ilk soru otomatik olarak kapanmalıdır

  @regression @newsletter @positive
  Scenario: Bülten aboneliği formuna geçerli e-posta ile kayıt olma (Pozitif Durum)
    Given kullanıcı Footer (Altbilgi) alanındadır
    When kullanıcı bülten e-posta alanına geçerli bir e-posta adresi ("test@example.com") girer
    And kullanıcı "Abone Ol" butonuna tıklar
    Then sistem kullanıcıya "Başarıyla abone oldunuz" şeklinde yeşil ve olumlu bir uyarı mesajı göstermelidir

  @regression @newsletter @negative @edge_case
  Scenario Outline: Bülten aboneliği formunun geçersiz veya boş girdilerle test edilmesi (Negatif / Sınır Durum)
    Given kullanıcı Footer (Altbilgi) alanındadır
    When kullanıcı bülten e-posta alanına "<eposta_girdisi>" girer
    And kullanıcı "Abone Ol" butonuna tıklar
    Then sistem kullanıcıya "Geçerli bir e-posta adresi giriniz" şeklinde hata mesajı vermelidir

    Examples:
      | eposta_girdisi    |
      |                   |
      | test@domain       |
      | test.domain.com   |
      | @domain.com       |
      | test@@domain.com  |