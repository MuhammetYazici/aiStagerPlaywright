Feature: Solutions Module Sub-page Navigations, Interactive Components and CTA Redirects

  Background:
    Given Kullanıcı "https://aistager.ai/tr/solutions" adresindedir
    And Kullanıcı sisteme giriş yapmamış (ziyaretçi) durumdadır

  @Positive @Navigation
  Scenario: Gayrimenkul Acentesi alt sayfasına başarılı navigasyon
    When Kullanıcı "İŞLETMELER" sütunundaki "Gayrimenkul Acentesi" üzerine hover yapar
    And Kullanıcı "Gayrimenkul Acentesi" öğesine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasına yönlendirilir
    And Sayfanın kırılmasız ve hatasız yüklendiği doğrulanır

  @Positive @CTA @BrowserHistory
  Scenario: Gayrimenkul Acentesi üst CTA yönlendirmesi ve tarayıcı "Geri" tuşu testi
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" adresindedir
    When Kullanıcı sayfa üstündeki "Ücretsiz Denemeyi Başlat" butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/login" sayfasına yönlendirilir
    When Kullanıcı tarayıcının "Geri" tuşuna basar
    Then Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasına geri döner
    And Sayfa kararlılığının korunduğu ve DOM state'inin kaybolmadığı doğrulanır

  @Positive @InteractiveUI @Slider
  Scenario: Gayrimenkul Acentesi Before/After slider bileşeninin pürüzsüz çalışması
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" adresindedir
    When Kullanıcı "Dönüşümü Gör" alanındaki Before/After slider tutacağını sağa ve sola sürükler
    Then Orijinal ve yapay zeka sahnelenmiş görsel geçişi pürüzsüz bir şekilde tetiklenir
    And Görsel alanlarında herhangi bir taşma veya kırılma yaşanmaz

  @Positive @InteractiveUI @Accordion
  Scenario: Gayrimenkul Acentesi SSS akordeon başlıklarının dinamik çalışması
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" adresindedir
    When Kullanıcı SSS akordeon başlıklarından birine tıklar
    Then İlgili yanıt alanının dinamik olarak açıldığı doğrulanır
    When Kullanıcı aynı akordeon başlığına tekrar tıklar
    Then İlgili yanıt alanının kapandığı doğrulanır

  @Positive @CTA
  Scenario: Gayrimenkul Acentesi alt banner CTA yönlendirmesi
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" adresindedir
    When Kullanıcı en alttaki mor banner üzerindeki CTA butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/login" sayfasına yönlendirilir

  @Positive @Navigation
  Scenario: Mobilya AI alt sayfasına başarılı navigasyon
    When Kullanıcı "İŞLETMELER" sütunundaki "Mobilya AI" öğesine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" sayfasına yönlendirilir

  @Positive @CTA @BrowserHistory @Outline
  Scenario Outline: Mobilya AI tüm iletişim butonlarının doğru yönlendirmesi
    Given Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" adresindedir
    When Kullanıcı sayfa üzerindeki "<ButonKonumu>" "Bizimle İletişime Geçin" butonuna tıklar
    Then Kullanıcı form kontrolü olmaksızın doğrudan "https://aistager.ai/tr/contact" sayfasına yönlendirilir
    When Kullanıcı tarayıcının "Geri" tuşuna basar
    Then Kullanıcı veri kaybı yaşamadan "https://aistager.ai/tr/solutions/furniture-ai" sayfasına döner

    Examples:
      | ButonKonumu |
      | Üst         |
      | Orta        |
      | Alt banner  |

  @Positive @InteractiveUI @Accordion
  Scenario: Mobilya AI SSS akordeon alanlarının çalışması
    Given Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" adresindedir
    When Kullanıcı Mobilya SSS alanındaki bir akordeon başlığına tıklar
    Then İlgili akordeon alanının doğru şekilde genişlediği doğrulanır
    When Kullanıcı başka bir SSS başlığına tıklar
    Then Önceki alanın kapandığı ve yeni alanın genişlediği doğrulanır

  @Positive @Navigation
  Scenario: Tasarım Şirketi alt sayfasına başarılı navigasyon
    When Kullanıcı "İŞLETMELER" sütunundaki "Tasarım Şirketi" öğesine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/design-company" sayfasına yönlendirilir

  @Positive @CTA @BrowserHistory @Outline
  Scenario Outline: Tasarım Şirketi ziyaretçi CTA yönlendirmeleri ve "Geri" tuşu testi
    Given Kullanıcı "https://aistager.ai/tr/solutions/design-company" adresindedir
    When Ziyaretçi durumundaki kullanıcı "<ButonAdi>" butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/login" sayfasına yönlendirilir
    When Kullanıcı tarayıcının "Geri" tuşuna basar
    Then Sayfa kararlılığı korunarak "https://aistager.ai/tr/solutions/design-company" sayfasına dönülür

    Examples:
      | ButonAdi       |
      | Görsel Yükle   |
      | Denemeye Başla |

  @Positive @InteractiveUI @Slider
  Scenario: Tasarım Şirketi çiftli görsel alanlarındaki bağımsız slider testi
    Given Kullanıcı "https://aistager.ai/tr/solutions/design-company" adresindedir
    When Kullanıcı sayfadaki yan yana bulunan birinci görselin slider'ını kaydırır
    And Kullanıcı ikinci görselin bağımsız slider'ını kaydırır
    Then Her iki slider'ın da herhangi bir taşma veya kırılma yaratmadan akıcı çalıştığı doğrulanır

  @EdgeCase @Responsive @TouchEvents
  Scenario: Mobil ve Dokunmatik (Touch) cihazlarda Slider bileşenlerinin testi
    Given Kullanıcı mobil görünümde (viewport) "https://aistager.ai/tr/solutions/real-estate-brokerage" adresindedir
    When Kullanıcı Before/After slider bileşeni üzerinde dokunma (touch event) hareketi gerçekleştirir
    Then Slider bileşeninin parmak hareketine duyarlı ve akıcı bir şekilde çalıştığı doğrulanır

  @EdgeCase @BrowserHistory @StatePreservation
  Scenario: Çoklu sayfa geçişleri sonrası tarayıcı "Geri" ve "İleri" geçmiş yönetimi
    Given Kullanıcı "https://aistager.ai/tr/solutions" adresindedir
    When Kullanıcı "Gayrimenkul Acentesi" sayfasına gider
    And Kullanıcı oradan "Ücretsiz Denemeyi Başlat" ile "/login" sayfasına geçer
    And Kullanıcı tarayıcıda iki kez "Geri" (Back) tuşuna basar
    Then Kullanıcı başarıyla ana çözümler sayfasına ("https://aistager.ai/tr/solutions") döner
    And Sayfa öğelerinin eksiksiz yüklendiği ve scroll pozisyonunun korunduğu doğrulanır

  @Negative @Navigation
  Scenario: Geçersiz veya var olmayan bir çözüm alt sayfasına doğrudan erişim denemesi
    When Kullanıcı doğrudan "https://aistager.ai/tr/solutions/olmayan-sayfa" adresine gitmeye çalışır
    Then Kullanıcı 404 sayfasına yönlendirilmeli veya ana çözümler sayfasına (`/solutions`) güvenli bir şekilde yönlendirilmelidir