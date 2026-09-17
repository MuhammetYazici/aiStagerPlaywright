Feature: AiStager.ai Ana Sayfa Temel Bileşenleri ve Etkileşim Yönetimi
  Kullanıcı olarak, AiStager.ai ana sayfasına geldiğimde platformun ana özelliklerini, 
  ürün çözümlerini, galeri ve formları hatasız bir şekilde kullanabilmek istiyorum.

  @regression @slider @positive
  Scenario: Öncesi ve Sonrası Slider bileşeninin pürüzsüz çalışması (BR-01.1)
    Given kullanıcı AiStager.ai ana sayfasındadır
    And "Öncesi ve Sonrası" slider alanı ekranda görünmektedir
    When kullanıcı slider çizgisini sağa ve sola sürüklerse
    Then görsel boyutları kaydırıcının hareketine göre dinamik olarak güncellenmelidir
    And boş oda ile mobilyalı oda arasında pürüzsüz geçiş sağlanmalıdır

  @regression @slider @positive
  Scenario: Slider yön okları ve carousel noktaları ile oda değiştirme (BR-01.2)
    Given kullanıcı AiStager.ai ana sayfasındadır
    When kullanıcı slider alanındaki sağ ok işaretine (>) tıklarsa
    Then farklı bir odaya ait görsel çiftine geçiş yapılmalıdır
    And alt kısımdaki ilgili carousel noktası aktif ve koyu renk olmalıdır

  @regression @slider @navigation @positive
  Scenario: Slider üzerinden oda yükleme sayfasına yönlendirme (BR-01.3)
    Given kullanıcı AiStager.ai ana sayfasındadır
    When kullanıcı "Odanızı Yükleyin" butonuna tıklarsa
    Then sistem kullanıcıyı oda yükleme arayüzüne yönlendirmelidir

  @regression @localization @positive
  Scenario: Dil seçeneği değişikliği ile metinlerin uyarlanması (BR-01.4)
    Given kullanıcı AiStager.ai ana sayfasındadır
    When kullanıcı dil seçeneğini "TR" olarak değiştirirse
    Then sayfadaki tüm metinler seçilen dile uyarlanarak Türkçe olarak görüntülenmelidir

  @smoke @header @logged_in @positive
  Scenario: Oturum açmış kullanıcı için üst menü ve profil kontrolleri
    Given kullanıcı sisteme oturum açmış olarak AiStager.ai ana sayfasındadır
    Then sağ üst köşede kullanıcının profil ikonu görünmelidir
    And menüde "Üretimlerim" seçeneği yer almalıdır
    When kullanıcı logoya tıklarsa
    Then ana sayfa olan "/tr" adresine yönlendirilmelidir

  @regression @header @logged_in @positive
  Scenario: Oturum açmış kullanıcı için Ürünler dropdown menüsünün çalışması
    Given kullanıcı sisteme oturum açmış olarak AiStager.ai ana sayfasındadır
    When kullanıcı "Ürünler" menüsünün üzerine gelirse veya tıklarsa
    Then alt seçenekleri içeren Dropdown menü açılmalıdır

  @smoke @header @guest @positive
  Scenario: Ziyaretçi (Oturum açmamış) kullanıcı için üst menü kontrolleri
    Given kullanıcı sisteme giriş yapmamış (ziyaretçi statüsünde) ana sayfadadır
    Then sağ üst köşede "Giriş Yap" ve mavi renkli "Ücretsiz Dene" butonları görünmelidir
    And ziyaretçi durumunda "Üretimlerim" menüsü ile profil ikonu görünmemelidir

  @regression @header @guest @navigation @positive
  Scenario: Ziyaretçi kullanıcı için kayıt ve giriş yönlendirmeleri
    Given kullanıcı ziyaretçi statüsünde AiStager.ai ana sayfasındadır
    When kullanıcı "Giriş Yap" butonuna tıklarsa, Login sayfasına yönlendirilmelidir
    And kullanıcı "Ücretsiz Dene" butonuna tıklarsa, Register sayfasına yönlendirilmelidir

  @regression @gallery @positive
  Scenario: Galeri ilk açılışta tüm tiplerin listelenmesi (BR-03.1)
    Given kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır
    Then "Tüm Tipler" filtresi aktif ve mor renkli olmalıdır
    And tüm oda tiplerine ait kartlar sayfada listelenmelidir

  @regression @gallery @positive
  Scenario: Oda tipi filtrelerine tıklanarak galeri güncellenmesi (BR-03.2)
    Given kullanıcı AiStager.ai ana sayfasındaki galeri alanındadır
    When kullanıcı "Oturma Odası" filtre seçeneğine tıklarsa
    Then galeri anlık olarak sadece "Oturma Odası" kategorisine ait tasarımlarla güncellenmelidir

  @regression @gallery @navigation @positive
  Scenario: Topluluk üyesi profil sayfasına yönlendirme (BR-03.3)
    Given kullanıcı galeri alanındaki tasarım kartlarını incelemektedir
    When kullanıcı bir kart üzerindeki kullanıcı adının üzerine tıklarsa
    Then ilgili topluluk üyesinin profil sayfasına yönlendirilmelidir

  @regression @gallery @positive
  Scenario: Tasarım kartını beğenme (Like) işlevi (BR-03.4)
    Given kullanıcı galeri alanındaki bir tasarım kartını incelemektedir
    When kullanıcı kart üzerindeki Kalp (Beğeni) ikonuna tıklarsa
    Then kalp ikonu aktif ve dolu hale gelmelidir
    And tasarımın beğeni sayacı 1 artmalıdır

  @regression @gallery @edge_case @positive
  Scenario: Daha fazla tasarım yükleme ve sayfa yapısının korunması (BR-03.5)
    Given kullanıcı galeride belirli bir filtre seçerek aşağı kaydırmıştır
    When kullanıcı "Daha Fazla Tasarım Yükle" butonuna basarsa
    Then mevcut filtre korunarak alt alta yeni tasarım kartları yüklenmelidir
    And sayfa yapısı bozulmamelıdır

  @regression @faq @navigation @positive
  Scenario: SSS alanından destek sayfasına yönlendirme (BR-04.1)
    Given kullanıcı Sıkça Sorulan Sorular (FAQ) alanındadır
    When kullanıcı "Bize ulaşın" linkine tıklarsa
    Then destek veya iletişim sayfasına yönlendirilmelidir

  @regression @faq @positive
  Scenario: Akordeon yapısının açılıp kapanması (BR-04.2)
    Given kullanıcı Sıkça Sorulan Sorular (FAQ) alanındadır
    When kullanıcı kapalı olan bir soruya tıklarsa içerik açılmalıdır
    And aynı soruya tekrar tıklandığında içerik kapanmalıdır

  @regression @faq @edge_case @positive
  Scenario: Akordeon yapısında aynı anda tek soru kuralı (BR-04.3)
    Given kullanıcı Sıkça Sorulan Sorular (FAQ) alanındadır
    And "1. Soru" şu anda açık durumdadır
    When kullanıcı "2. Soru" akordeonuna tıklarsa
    Then "2. Soru" açılmalı ve önceki açık olan "1. Soru" otomatik olarak kapanmalıdır

  @regression @newsletter @positive
  Scenario: Bülten aboneliğinin geçerli e-posta ile başarıyla tamamlanması (BR-05.1)
    Given kullanıcı footer alanındaki Bülten Aboneliği (Newsletter) bölümündedir
    When kullanıcı alanına geçerli bir e-posta adresi ("test@example.com") girerse
    And "Abone Ol" butonuna tıklarsa
    Then ekranda "Başarıyla abone oldunuz" şeklinde yeşil banner/toast pozitif sistem uyarısı gösterilmelidir

  @regression @newsletter @negative
  Scenario Outline: Bülten aboneliğinin geçersiz veya boş girişlerle engellenmesi (BR-05.2)
    Given kullanıcı footer alanındaki Bülten Aboneliği bölümündedir
    When kullanıcı e-posta alanına "<eposta>" girerse
    And "Abone Ol" butonuna tıklarsa
    Then sistem aboneliği engellemelidir
    And "Geçerli bir e-posta adresi giriniz" şeklinde hata mesajı üretilmelidir

    Examples:
      | eposta          |
      |                 |
      | testexample.com |