Feature: AiStager.ai Ana Sayfa Temel Bileşenleri ve Etkileşimleri
  Kullanıcı olarak ana sayfadaki slider, menüler, galeri, SSS ve bülten alanlarını 
  test kurallarına uygun şekilde deneyimleyebilmeliyim.

  Background:
    Given Kullanıcı AiStager.ai ana sayfasını ("/tr") ziyaret eder

  @positive @slider
  Scenario: BR-01 - Slider alanının iki yönlü ok ile dinamik olarak boyut değiştirmesi
    When Kullanıcı görselin ortasındaki iki yönlü kaydırıcıyı sağa ve sola sürükler
    Then "Önce" (boş oda) ve "Sonra" (mobilyalı oda) alanları pürüzsüz bir şekilde dinamik olarak boyut değiştirmelidir

  @positive @slider
  Scenario Outline: BR-02 - Navigasyon okları ve carousel noktaları ile oda görselleri değiştirme
    When Kullanıcı slider alanındaki "<etkilesim_tipi>" tıklar
    Then İlgili oda görselleri yüklenmelidir
    And Aktif carousel noktası koyu renk ile işaretlenmelidir

    Examples:
      | etkilesim_tipi |
      | Sağ ok         |
      | Sol ok         |
      | Alt noktalar   |

  @positive @navigation
  Scenario: BR-03 - "Odanızı Yükleyin" aksiyonu ve "TR" dil seçeneği
    When Kullanıcı "Odanızı Yükleyin" butonuna tıklar
    Then Kullanıcı oda yükleme veya giriş arayüzüne yönlendirilmelidir
    When Kullanıcı sayfa dilini "TR" olarak seçer
    Then Tüm sayfa metinleri seçilen dile güncellenmelidir

  @positive @auth
  Scenario: BR-04 - Oturum açmış kullanıcının ana sayfa ve menü erişimleri
    Given Kullanıcı sisteme giriş yapmış durumdadır
    When Kullanıcı Logoya tıklar
    Then Kullanıcı ana sayfaya ("/tr") yönlendirilir
    When Kullanıcı "Ürünler" ve "Çözümler/Kaynaklar/Fiyatlandırma" menülerine tıklar
    Then İlgili alt sayfalar açılır
    And "Üretimlerim", hızlı render kamera ayarları ve profil (mor yuvarlak "y" ikonu) menüleri görünür ve sorunsuz çalışır

  @positive @visitor
  Scenario: BR-05 - Ziyaretçi kullanıcının menü ve buton kısıtlamaları
    Given Kullanıcı sisteme giriş yapmamış (visitor) durumdadır
    When Kullanıcı "Giriş Yap" butonuna tıklar
    Then Kullanıcı login sayfasına yönlendirilir
    When Kullanıcı mavi "Ücretsiz Dene" butonuna tıklar
    Then Kullanıcı register sayfasına yönlendirilir
    And Ziyaretçi için "Üretimlerim" menüsü ve profil ikonu ekranda görünmemelidir

  @positive @gallery
  Scenario: BR-06 - Galeri ilk açılış ve oda tipi filtreleme
    Then Sayfa ilk açıldığında "Tüm Tipler" filtresi aktif (mor) olmalıdır
    When Kullanıcı farklı bir oda tipi butonuna tıklar
    Then İlgili buton aktifleşmeli ve galeri sadece o oda tipine ait tasarımları listelemelidir

  @positive @gallery
  Scenario: BR-07 - Topluluk galerisi kart etkileşimleri ve sayfalama
    When Kullanıcı bir tasarımın üzerindeki kullanıcı adğına tıklar
    Then İlgili topluluk üyesinin profil sayfasına gidilmelidir
    When Kullanıcı Kalp (Beğeni) ikonuna tıklar
    Then Kalp ikonu dolu hale gelmeli ve beğeni sayısı 1 artmalıdır
    When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Mevcut filtre korunarak listeye yeni tasarım kartları eklenmelidir

  @positive @faq
  Scenario: BR-08 - SSS akordeonunun açılma, kapanma ve tekli açılma kuralı
    When Kullanıcı bir SSS sorusuna tıklar
    Then İlgili cevap açılmalı ve soru oku yukarı bakmalıdır
    When Kullanıcı aynı soruya tekrar tıklar
    Then Cevap alanı kapanmalıdır
    When Kullanıcı birinci soru açıkken ikinci bir soruya tıklar
    Then Önceki soru otomatik olarak kapanmalı ve yeni tıklanan soru açılmalıdır
    When Kullanıcı SSS alanındaki "Bize ulaşın" linkine tıklar
    Then Kullanıcı doğrudan destek veya iletişim sayfasına yönlendirilmelidir

  @positive @newsletter
  Scenario: BR-09 - Geçerli e-posta ile başarılı bülten aboneliği
    When Kullanıcı bülten alanına geçerli bir e-posta adresi girer ("test@example.com")
    And Kullanıcı "Abone Ol" butonuna tıklar
    Then Yeşil ve olumlu renkli "Başarıyla abone oldunuz" mesajı gösterilmelidir

  @negative @newsletter @edge-case
  Scenario Outline: BR-10 - Geçersiz veya boş e-posta ile bülten aboneliği hata yönetimi
    When Kullanıcı bülten alanına "<gecersiz_eposta>" girer
    And Kullanıcı "Abone Ol" butonuna tıklar
    Then Sistem uyarıcı olarak "Geçerli bir e-posta adresi giriniz" hata mesajını göstermelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | test@           |
      | test.com        |
      | test@com        |