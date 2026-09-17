Feature: AiStager.ai Çözümler Modülü (İşletmeler) Navigasyon, CTA ve Etkileşim Doğrulaması
  As a web user
  I want to navigate through business solutions, interact with CTAs, sliders, and accordions
  So that I can use the platform smoothly and without errors

  Background:
    Given Kullanıcı "https://aistager.ai/tr/solutions" adresindedir

  @Positive @Navigation
  Scenario: AC1.1 - Gayrimenkul Acentesi sayfasına başarılı navigasyon
    When Kullanıcı sağdaki "İşletmeler" sütunundan "Gayrimenkul Acentesi" üzerine gelir
    And Görsel tepki (hover) alındıktan sonra "Gayrimenkul Acentesi" seçeneğine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasına yönlendirilmelidir

  @Positive @CTA
  Scenario Outline: AC1.2 - Gayrimenkul Acentesi CTA butonları yönlendirmesi
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasındadır
    When Sayfanın <Banner_Alani> alanındaki "<Buton_Adi>" butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/login" sayfasına yönlendirilmelidir

    Examples:
      | Banner_Alani | Buton_Adi                 |
      | üst          | Ücretsiz Denemeyi Başlat  |
      | alt          | Başlamak İçin Giriş Yapın |

  @StateManagement @Positive
  Scenario: AC1.3 - Gayrimenkul Acentesi sayfasında tarayıcı geçmişi (Geri tuşu) kararlılığı
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasındadır
    When Kullanıcı "Ücretsiz Denemeyi Başlat" butonuna tıklayarak login sayfasına gider
    And Tarayıcının "Geri" (Back) tuşuna basarak önceki sayfaya döner
    Then Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasına dönmelidir
    And Sayfa kararlılığını korumalı ve veri kaybı yaşanmamalıdır

  @UI @Positive
  Scenario: AC1.4 - Gayrimenkul Acentesi bileşen etkileşimleri (Slider ve SSS)
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasındadır
    When Kullanıcı "Dönüşümü Gör" alanındaki Öncesi/Sonrası slider'ını sağa ve sola kaydırır
    Then Slider akıcı bir şekilde çalışmalıdır
    When Kullanıcı bir SSS akordeon başlığına tıklar
    Then İlgili soru başlığının altındaki içerik dinamik olarak açılmalıdır

  @Positive @Navigation
  Scenario: AC2.1 - Mobilya AI sayfasına başarılı navigasyon
    When Kullanıcı "İşletmeler" menüsünden "Mobilya AI" seçeneğine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" sayfasına yönlendirilmelidir

  @Positive @CTA
  Scenario Outline: AC2.2 - Mobilya AI İletişim butonları yönlendirmesi
    Given Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" sayfasındadır
    When Sayfanın <Konum> alanındaki "Bizimle İletişime Geçin" butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/contact" sayfasına yönlendirilmelidir

    Examples:
      | Konum        |
      | üst          |
      | orta         |
      | yeşil banner |

  @StateManagement @Positive
  Scenario: AC2.3 - Mobilya AI sayfasında tarayıcı geçmişi (Geri tuşu) kontrolü
    Given Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" sayfasındadır
    When Kullanıcı "Bizimle İletişime Geçin" butonuna tıklayarak iletişim sayfasına gider
    And Tarayıcının "Geri" tuşu ile Mobilya AI sayfasına döner
    Then Arayüz kayması veya donma olmaksızın Mobilya AI sayfası görüntülenmelidir

  @UI @Positive @Negative
  Scenario: AC2.4 - Mobilya AI SSS akordeon açma/kapama döngüsü
    Given Kullanıcı "https://aistager.ai/tr/solutions/furniture-ai" sayfasındadır
    When Kullanıcı kapalı olan bir SSS akordeon bileşenine tıklar
    Then Akordeon içeriği açılmalıdır
    When Kullanıcı açık olan aynı SSS akordeon bileşenine tekrar tıklar
    Then Akordeon içeriği kapanmalıdır

  @Positive @Navigation
  Scenario: AC3.1 - Tasarım Şirketi sayfasına başarılı navigasyon
    When Kullanıcı "İşletmeler" menüsünden "Tasarım Şirketi" seçeneğine tıklar
    Then Kullanıcı "https://aistager.ai/tr/solutions/design-company" sayfasına yönlendirilmelidir

  @Positive @CTA
  Scenario Outline: AC3.2 - Tasarım Şirketi CTA butonları yönlendirmesi
    Given Kullanıcı "https://aistager.ai/tr/solutions/design-company" sayfasındadır
    When Kullanıcı "<CTA_Butonu>" butonuna tıklar
    Then Kullanıcı "https://aistager.ai/tr/login" sayfasına yönlendirilmelidir

    Examples:
      | CTA_Butonu               |
      | Görsel Yükle             |
      | Denemeye Başla           |
      | Ücretsiz Denemeyi Başlat |

  @UI @EdgeCase @Positive
  Scenario: AC3.3 - Tasarım Şirketi çoklu görsel alanında bağımsız slider testi
    Given Kullanıcı "https://aistager.ai/tr/solutions/design-company" sayfasındadır
    When Kullanıcı çiftli görsel alanındaki "Boş Mutfak" slider'ını hareket ettirir
    And Kullanıcı bağımsız olarak "Mobilyalı Oda" slider'ını hareket ettirir
    Then Her iki slider da takılmadan ve taşma yapmadan pürüzsüz çalışmalıdır

  @Negative @EdgeCase
  Scenario: Doğrudan URL erişimi ve geçersiz alt sayfa kontrolü
    When Kullanıcı tarayıcı adres çubuğuna doğrudan "https://aistager.ai/tr/solutions/olmayan-sektor" yazıp enter tuşuna basar
    Then Kullanıcı 404 sayfasına yönlendirilmeli veya ana çözümler sayfasına ("/solutions") yönlendirilmelidir

  @EdgeCase @UI
  Scenario: Hızlı arka arkaya tıklama (Rapid Clicking) ile CTA koruması
    Given Kullanıcı "https://aistager.ai/tr/solutions/real-estate-brokerage" sayfasındadır
    When Kullanıcı "Ücretsiz Denemeyi Başlat" butonuna çok kısa süre içinde üst üste 3 kez hızlıca tıklar
    Then Sistem birden fazla login sekmesi açmamalı ve tek bir yönlendirme gerçekleştirmelidir