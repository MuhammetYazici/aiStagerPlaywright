Feature: US-SOL-001 Çözümler Modülü Dikey Sektör Sayfaları, Etkileşimli Bileşenler ve Dönüşüm Yönlendirmeleri

  Background:
    Given Ziyaretçi oturum açmamış (anonim) durumdadır
    And Ziyaretçi "https://example.com/tr/solutions" ana çözümler sayfasındadır

  @positive @navigation @BR-01 @smoke
  Scenario Outline: BR-01 - "İŞLETMELER" menüsü üzerinden doğru sektörel URL yönlendirmelerinin doğrulanması
    When Ziyaretçi "İŞLETMELER" menüsündeki "<sektör_seçeneği>" seçeneğine tıklarsa
    Then Ziyaretçi "<hedef_url>" adresine yönlendirilmelidir
    And Sayfa başlığı ve içeriği "<sektör_seçeneği>" ile uyumlu yüklenmelidir

    Examples:
      | sektör_seçeneği     | hedef_url                                    |
      | Gayrimenkul Acentesi | /tr/solutions/real-estate-brokerage          |
      | Mobilya AI          | /tr/solutions/furniture-ai                   |
      | Tasarım Şirketi     | /tr/solutions/design-company                 |

  @positive @cta @real_estate @BR-02
  Scenario: AC-01 & BR-02 - Gayrimenkul Acentesi sayfasındaki Self-Service CTA'lerin Login sayfasına yönlendirmesi
    Given Ziyaretçi "/tr/solutions/real-estate-brokerage" sayfasındadır
    When Ziyaretçi Hero alanındaki "Ücretsiz Denemeyi Başlat" butonuna tıklarsa
    Then Ziyaretçi "/tr/login" sayfasına yönlendirilmelidir
    And URL parametrelerinde yönlendirme kaynağı bilgisi (ref/redirect) bulunmalıdır

  @positive @cta @furniture @BR-03
  Scenario Outline: AC-02 & BR-03 - Mobilya AI sayfasındaki tüm B2B/Lead CTA'lerinin İletişim sayfasına yönlendirmesi
    Given Ziyaretçi "/tr/solutions/furniture-ai" sayfasındadır
    When Ziyaretçi "<konum>" alanında bulunan "<buton_adı>" butonuna tıklarsa
    Then Ziyaretçi "/tr/contact" sayfasına yönlendirilmelidir

    Examples:
      | konum            | buton_adı                             |
      | Sayfa Üstü       | Bizimle İletişime Geçin               |
      | 3 Basit Adımda   | Bizimle İletişime Geçin               |
      | Alt Yeşil Banner | Başlamak İçin Bizimle İletişime Geçin |

  @positive @slider @real_estate @BR-04
  Scenario: AC-01 & BR-04 - Gayrimenkul sayfasında tekli Görsel Karşılaştırma Slider etkileşimi
    Given Ziyaretçi "/tr/solutions/real-estate-brokerage" sayfasındadır
    And "Dönüşümü Gör" alanındaki slider varsayılan %50 konumundadır
    When Ziyaretçi slider tutamağını sağa doğru sürüklerse
    Then Sol taraftaki "ÖNCE (Boş Orijinal Fotoğraf)" alanı genişlemelidir
    And Sağ taraftaki "SONRA (Yapay Zeka Sahnelenmiş Fotoğraf)" alanı küçülmelidir
    And Görsel kayması, katman kırılması veya UI donması yaşanmamalıdır

  @positive @faq @BR-05
  Scenario: AC-01 & BR-05 - SSS Akordeon alanında dinamik açılma ve kapanma davranışı
    Given Ziyaretçi "/tr/solutions/real-estate-brokerage" sayfasındadır
    And SSS alanındaki tüm sorular kapalı durumdadır
    When Ziyaretçi "Soru 1" başlığına tıklarsa
    Then "Soru 1"e ait cevap alanı dinamik olarak genişlemelidir (expand)
    When Ziyaretçi "Soru 1" başlığına tekrar tıklarsa
    Then "Soru 1"e ait cevap alanı kapanmalıdır (collapse)

  @positive @browser_history @BR-06
  Scenario: AC-04 & BR-06 - CTA Yönlendirmesi sonrası Tarayıcı "Geri" butonu kararlılığı
    Given Ziyaretçi "/tr/solutions/design-company" sayfasındadır
    And Ziyaretçi "Denemeye Başla" butonuna tıklayarak "/tr/login" sayfasına gitmiştir
    When Ziyaretçi tarayıcının "Geri (Back)" butonuna basarsa
    Then Ziyaretçi tekrar "/tr/solutions/design-company" sayfasına dönmelidir
    And Sayfa stili bozulmadan, veri kaybı ve konsol (JS) hatası olmadan yeniden yüklenmelidir

  @edge_case @slider @design_company @BR-04
  Scenario: AC-03 & BR-04 - Tasarım Şirketi sayfasında çiftli slider'ların birbirinden bağımsız çalışması
    Given Ziyaretçi "/tr/solutions/design-company" sayfasındadır
    And Sayfada "Boş Mutfak" (Slider A) ve "Mobilyalı Oturma Odası" (Slider B) alanları bulunmaktadır
    When Ziyaretçi Slider A'yı %20 konumuna sürüklerse
    Then Slider A'nın konumu %20 olmalıdır
    But Slider B'nin konumu değişmeyerek varsayılan (%50) konumunda kalmalıdır
    And Her iki slider bileşeninde de görsel taşması (overflow) yaşanmamalıdır

  @edge_case @slider @BR-04
  Scenario Outline: BR-04 - Slider bileşeninin uç sınır değerlerde (0% ve 100%) davranışı
    Given Ziyaretçi "/tr/solutions/real-estate-brokerage" sayfasındadır
    When Ziyaretçi slider tutamağını tam olarak "<sınır_yönü>" noktalara sürüklerse
    Then Slider konumu %<beklenen_yüzde> olmalıdır
    And Karşıt taraftaki görsel tamamen gizlenmeli, DOM/CSS katman hatası oluşmamalıdır

    Examples:
      | sınır_yönü | beklenen_yüzde |
      | En Sola    | 0              |
      | En Sağa    | 100            |

  @edge_case @faq @BR-05
  Scenario: BR-05 - Akordeon SSS alanında ardışık/hızlı tıklama (Stress/Rapid Toggle)
    Given Ziyaretçi "/tr/solutions/furniture-ai" sayfasındadır
    When Ziyaretçi bir SSS sorusuna 1 saniye içinde 5 kez art arda tıklarsa
    Then Akordeon animasyonu takılı kalmamalıdır
    And Son tıklama durumuna göre cevap alanı doğru (Açık veya Kapalı) konumda stabilize olmalıdır

  @edge_case @navigation @direct_url
  Scenario: Doğrudan URL erişimi ile sektörel landing page'lerin yüklenmesi (Deep Linking)
    Given Ziyaretçi tarayıcı adres çubuğuna doğrudan "https://example.com/tr/solutions/design-company" yazar
    When Sayfa yüklenirse
    Then Sayfadaki "Görsel Yükle", "Denemeye Başla" ve mor banner "Ücretsiz Denemeyi Başlat" butonları aktif olmalıdır
    And Bu butonlara tıklandığında BR-02 uyarınca "/tr/login" yönlendirmesi sorunsuz çalışmalıdır

  @negative @routing @access_control @BR-01 @BR-02
  Scenario Outline: Geçersiz URL yönlendirmeleri ve yetkisiz sayfa erişim engelleme kontrolleri
    Given Ziyaretçi "<başlangıç_konumu>" konumundadır
    When Ziyaretçi "<eylem>" eylemini gerçekleştirdiğinde
    Then Sistem "<beklenen_sonuç>" yanıtını vermelidir
    And Kullanıcı "<hedef_url>" adresine yönlendirilmiş veya yönlendirme seçeneği sunulmuş olmalıdır

    Examples:
      | başlangıç_konumu                             | eylem                                                     | beklenen_sonuç                       | hedef_url     |
      | https://example.com/tr/solutions/non-existing| Geçersiz sektör URL'sine doğrudan erişmeye çalıştığında   | 404 Sayfa Bulunamadı hatası          | /tr/solutions |
      | /tr/solutions/real-estate-brokerage          | "Ücretsiz Denemeyi Başlat" butonuna tıkladığında          | Korumalı dashboard erişim engeli     | /tr/login     |

  @negative @js_error @BR-06
  Scenario Outline: Çözüm sayfalarında kullanıcı etkileşimleri sonrası Konsol (JavaScript) hata kontrolü
    Given Ziyaretçi "<sektör_sayfası>" sayfasındadır
    When Ziyaretçi sayfadaki tüm slider, akordeon ve CTA butonları ile etkileşime girerse
    Then Tarayıcı geliştirici konsolunda hiçbir Uncaught TypeError veya Kritik JS hatası oluşmamalıdır

    Examples:
      | sektör_sayfası                      |
      | /tr/solutions/furniture-ai          |
      | /tr/solutions/real-estate-brokerage |
      | /tr/solutions/design-company        |

  @negative @slider @touch_events
  Scenario: Mobil/Dokunmatik ekranda Slider sürükleme sırasında sayfa kaymasının (Scroll) çakışmaması
    Given Ziyaretçi mobil cihaz ekran genişliğinde (Viewport: 375px) "/tr/solutions/design-company" sayfasındadır
    When Ziyaretçi parmağını slider üzerinde yatay olarak sürüklerse
    Then Yalnızca Görsel Slider hareket etmelidir
    And Dikey sayfa kaydırma (Vertical Scroll) tetiklenerek slider sürükleme işlemi kesintiye uğramamalıdır