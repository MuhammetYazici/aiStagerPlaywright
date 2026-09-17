Feature: US-SOL-001 - Çözümler Modülü İşletme Sayfaları ve Etkileşim Yönetimi

  Background:
    Given kullanıcı "https://aistager.ai/tr/solutions" adresindedir

  @pozitif @navigation
  Scenario: Çözümler sayfasının başarıyla yüklenmesi ve işletmeler panelinin görüntülenmesi
    Given sayfa kırılma olmadan kararlı bir şekilde yüklenmelidir
    Then sağ tarafta "İŞLETMELER" dikey sütun paneli listelenmelidir

  @pozitif @navigation
  Scenario Outline: İşletme kartlarına hover yapılması ve doğru alt sayfalara yönlendirilmesi
    Given "İŞLETMELER" sütunundaki "<IsletmeAdi>" kartının üzerine gelindiğinde görsel tepki alınmalıdır
    When karta tıklandığında kullanıcı "<HedefUrl>" adresine sorunsuz yönlendirilmelidir

    Examples:
      | IsletmeAdi          | HedefUrl                                 |
      | Gayrimenkul Acentesi| https://aistager.ai/tr/solutions/real-estate-brokerage |
      | Mobilya AI          | https://aistager.ai/tr/solutions/furniture-ai          |
      | Tasarım Şirketi     | https://aistager.ai/tr/solutions/design-company        |

  @sinir @edge-case
  Scenario: Var olmayan veya geçersiz bir işletme dikey URL'sine doğrudan erişim denemesi
    When kullanıcı doğrudan "https://aistager.ai/tr/solutions/gecersiz-dikey" adresine gitmelidir
    Then sistem 404 hata sayfasına yönlendirmeli veya ana Çözümler sayfasına güvenli yönlendirme yapmalıdır

  @pozitif @cta
  Scenario Outline: Gayrimenkul ve Tasarım sayfalarındaki CTA butonları ile giriş sayfasına yönlendirme
    Given kullanici "<IsletmeSayfasi>" sayfasında bulunmalıdır
    When sayfadaki "<CtaButonu>" butonuna tıklandığında
    Then ziyaretçi doğrudan "https://aistager.ai/tr/login" sayfasına yönlendirilmelidir

    Examples:
      | IsletmeSayfasi                                         | CtaButonu               |
      | https://aistager.ai/tr/solutions/real-estate-brokerage | Ücretsiz Denemeyi Başlat|
      | https://aistager.ai/tr/solutions/real-estate-brokerage | Görsel Yükle            |
      | https://aistager.ai/tr/solutions/design-company        | Denemeye Başla          |

  @pozitif @cta
  Scenario Outline: Mobilya AI sayfasındaki banner butonları ile iletişim sayfasına yönlendirme
    Given kullanici "https://aistager.ai/tr/solutions/furniture-ai" sayfasında bulunmalıdır
    When sayfanın "<BannerKonumu>" kısmındaki "Bizimle İletişime Geçin" butonuna tıklandığında
    Then kullanıcı doğrudan "https://aistager.ai/tr/contact" sayfasına yönlendirilmelidir

    Examples:
      | BannerKonumu |
      | üst          |
      | orta         |
      | alt          |

  @pozitif @history
  Scenario: Tarayıcı Geri tuşu (History Management) ile önceki işletme sayfasına dönüş
    Given kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasında olmalıdır
    And "Ücretsiz Denemeyi Başlat" butonuna tıklayarak "https://aistager.ai/tr/login" sayfasına gitmelidir
    When tarayıcının "Geri" (Back) butonuna basılmalıdır
    Then kullanıcı tekrar "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasına dönmelidir
    And sayfa kararlılığını korumalı, veri kaybı veya arayüz kayması yaşanmadığı DOM üzerinde doğrulanmalıdır

  @pozitif @slider
  Scenario: Önce / Sonra Slider bileşeninin akıcı çalışması
    Given kullanıcı üzerinde görsel karşılaştırma slider'ı bulunan bir işletme sayfasında olmalıdır
    When slider sağa ve sola sürükleme (drag) işlemlerine akıcı ve gecikmesiz yanıt vermelidir
    Then orijinal ve Yapay Zeka Sahnelenmiş katmanlar arası geçişler pürüzsüz bir şekilde tetiklenmelidir

  @negatif @slider
  Scenario: Slider bileşeninin sınır değerler (Edge Case) dışına sürüklenme denemesi
    When kullanıcı slider tutamacını ekran sınırlarının tamamen dışına sürüklemeye çalışmalıdır
    Then slider bileşeni takılmamalı, minimum veya maksimum sınırlarında kilitlenerek kararlı kalmalıdır

  @pozitif @accordion
  Scenario: SSS Akordeon bileşeninin açılıp kapanması
    Given kullanıcı Sıkça Sorulan Sorular (SSS) alanında bulunmalıdır
    When kapalı durumdaki bir soru başlığına tıklandığında alan aşağı doğru genişlemeli ve gizli cevap metni açılmalıdır
    And açık olan aynı soru başlığına tekrar tıklandığında alan kapanmalıdır

  @sinir @accordion
  Scenario: Akordeon bileşeninde çoklu etkileşim yönetimi
    Given kullanıcı SSS alanındaki birinci soruya tıklayarak açmalıdır
    When sayfayı yenilemeden hemen ikinci soruya tıklamalıdır
    Then ikinci soru açılırken sistem hata vermemeli ve arayüz bozulmamalıdır