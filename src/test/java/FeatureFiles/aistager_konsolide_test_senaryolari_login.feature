Feature: AiStager.ai Platformu Temel Fonksiyonları
  Kullanıcıların ana sayfa etkileşimleri, giriş ve kayıt olma süreçlerinin
  pozitif, negatif ve sınır (edge case) durumlarının test edilmesi.

  @UserStory1 @LandingPage @BR-HP-001
  Scenario: Kullanıcının Öncesi/Sonrası Slider görselini sağa sola sürüklemesi
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı "Öncesi/Sonrası" kaydırıcısını (slider) sağa ve sola sürükler
    Then "Önce" (boş oda) ve "Sonra" (mobilyalı oda) görselleri dinamik ve pürüzsüz bir şekilde geçiş yapmalıdır

  @UserStory1 @LandingPage @BR-HP-001
  Scenario: Carousel altındaki yön okları ve noktalar ile görsel değiştirme
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı carousel altındaki yön oklarına veya nokta ikonlarına tıklar
    Then İlgili oda görselleri yüklenmeli ve tıklanan nokta görsel olarak aktif (vurgulanmış) olmalıdır

  @UserStory1 @LandingPage @BR-HP-002
  Scenario: Oturum açmış kullanıcının üst menü görünürlüğü
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı ana sayfanın üst menüsünü (header) inceler
    Then Logoya tıklandığında ana sayfaya dönülebilmelidir
    And Açılır menüler (Ürünler, Çözümler vb.) kullanılabilir olmalıdır
    And "Üretimlerim" sayfası ve profil ikonu menüde görünür ve erişilebilir olmalıdır

  @UserStory1 @LandingPage @BR-HP-002
  Scenario: Ziyaretçi (oturum açmamış) kullanıcının üst menü görünürlüğü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfanın üst menüsünü (header) inceler
    Then "Üretimlerim" menüsü ve profil ikonu gizli olmalıdır
    And "Giriş Yap" ve "Ücretsiz Dene" butonları aktif ve görünür olmalıdır

  @UserStory1 @LandingPage @BR-HP-003
  Scenario: Topluluk galerisinin varsayılan filtre ile başlaması
    Given Kullanıcı AiStager.ai ana sayfasındaki Topluluk Galerisi alanındadır
    Then Galeri varsayılan olarak "Tüm Tipler" filtresi ile başlamalıdır

  @UserStory1 @LandingPage @BR-HP-003
  Scenario: Oda tipi filtreleme ile galerinin güncellenmesi
    Given Kullanıcı Topluluk Galerisi alanındadır
    When Kullanıcı farklı bir oda tipi filtresine tıklar
    Then Galeri anlık olarak filtrelenmeli ve sadece ilgili tasarımları göstermelidir

  @UserStory1 @LandingPage @BR-HP-003
  Scenario: Tasarımları beğenme ve daha fazla tasarım yükleme
    Given Kullanıcı Topluluk Galerisi alanındadır
    When Kullanıcı bir tasarımın kalp ikonuna tıklar
    Then Beğeni sayısı (kalp sayacı) bir artmalıdır
    When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Mevcut filtre bozulmadan yeni içerikler listeye eklenmelidir

  @UserStory1 @LandingPage @BR-HP-004
  Scenario: SSS (Akordeon) alanında aynı anda tek bir başlığın açık olması
    Given Kullanıcı ana sayfadaki Sıkça Sorulan Sorular (SSS) bölümündedir
    When Kullanıcı bir akordeon başlığına tıklayarak soruyu açar
    And Kullanıcı farklı bir soru başlığına tıklar
    Then Yeni tıklanan soru açılmalı ve önceden açık olan soru otomatik olarak kapanmalıdır

  @UserStory1 @LandingPage @BR-HP-004 @Positive
  Scenario: Bülten aboneliğine geçerli e-posta ile kayıt olma
    Given Kullanıcı bülten aboneliği alanındadır
    When Kullanıcı bülten input alanına geçerli bir e-posta adresi girer ve abone ol butonuna tıklar
    Then Başarılı abonelik mesajı görüntülenmelidir

  @UserStory1 @LandingPage @BR-HP-004 @Negative @EdgeCase
  Scenario Outline: Bülten aboneliğine geçersiz veya boş e-posta girişi
    Given Kullanıcı bülten aboneliği alanındadır
    When Kullanıcı bülten input alanına "<eposta>" girer ve abone ol butonuna tıklar
    Then Sistem hata mesajı üretmelidir

    Examples:
      | eposta          |
      |                 |
      | gecersiz-eposta |
      | test@.com       |

  @UserStory2 @Login @BR-LOG-001 @Positive
  Scenario: Kayıtlı geçerli bilgiler ile başarılı giriş ve şifre maskeleme
    Given Kullanıcı "Login" sayfasındadır
    When Kullanıcı kayıtlı geçerli e-postasını ve şifresini girer
    And Şifre alanındaki "Göz" ikonuna tıklar
    Then Şifre metin olarak görünür olmalıdır
    When Kullanıcı tekrar "Göz" ikonuna tıklar
    Then Şifre maskelenmeli (noktalanmalıdır)
    When Kullanıcı "Giriş Yap" butonuna tıklar
    Then Kullanıcı ana panele (dashboard) yönlendirilmelidir

  @UserStory2 @Login @BR-LOG-001
  Scenario: Giriş sayfasındaki yönlendirme linklerinin aktif olması
    Given Kullanıcı "Login" sayfasındadır
    Then "Şifremi Unuttum", "Kayıt Ol" ve "Google ile Devam Et" yönlendirmeleri aktif ve tıklanabilir olmalıdır

  @UserStory2 @Login @BR-LOG-002 @Negative
  Scenario: Giriş formunda boş bırakılan zorunlu alanlar
    Given Kullanıcı "Login" sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak "Giriş Yap" butonuna tıklar
    Then İlgili alanların altında "Bu alan zorunludur" uyarı mesajı görünmelidir

  @UserStory2 @Login @BR-LOG-002 @Negative
  Scenario: Giriş formunda geçersiz e-posta formatı
    Given Kullanıcı "Login" sayfasındadır
    When Kullanıcı e-posta alanına hatalı formatta "yanlisformat" girer
    Then "Lütfen geçerli bir e-posta adresi girin" uyarı mesajı alınmalıdır

  @UserStory2 @Login @BR-LOG-002 @Negative @Security
  Scenario Outline: Sistemde kayıtlı olmayan veya yanlış şifre ile giriş denemesi
    Given Kullanıcı "Login" sayfasındadır
    When Kullanıcı "<eposta>" ve "<sifre>" ile giriş yapmaya çalışır
    Then Kullanıcıya güvenlik gereği spesifik bir açık verilmeden genel "E-posta veya şifre hatalı" mesajı gösterilmelidir

    Examples:
      | eposta               | sifre         |
      | kayitsiz@stager.ai   | DogruSifre123 |
      | kayitli@stager.ai    | YanlisSifre   |
      | kayitsiz@stager.ai   | YanlisSifre   |

  @UserStory2 @Login @BR-LOG-002 @EdgeCase @Security
  Scenario: Giriş formunda SQL enjeksiyonu ve aşırı uzun karakter testi
    Given Kullanıcı "Login" sayfasındadır
    When Kullanıcı e-posta alanına "' OR '1'='1" veya aşırı uzun karakter dizisi girer
    And Şifre alanına güvenlik test verisi girip giriş yapmaya çalışır
    Then Sistem girdileri filtrelemeli ve uygulama 500 (Server Error) hatası vermemelidir

  @UserStory3 @Register @BR-REG-001 @Positive
  Scenario: Yeni ve geçerli bilgiler ile başarılı kayıt olma
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan yeni bir e-posta adresi girer
    And Kurallara uygun ve birbiriyle eşleşen şifreler belirler
    And Kullanıcı sözleşmesi onay kutucuğunu işaretler
    And "Hesap Oluştur" butonuna tıklar
    Then Kayıt başarılı olmalı ve kullanıcı aktivasyon veya ana panele yönlendirilmelidir

  @UserStory3 @Register @BR-REG-002 @Negative
  Scenario: Kayıt formunda zorunlu alanların boş bırakılması
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı tüm alanları boş bırakarak "Hesap Oluştur" butonuna tıklar
    Then Boş bırakılan alanlar için "Bu alan zorunludur" uyarısı çıkmalıdır

  @UserStory3 @Register @BR-REG-002 @Negative
  Scenario: Kayıt formunda geçersiz e-posta formatı girişi
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı e-posta alanına "gecersireposta.com" girer
    Then "Lütfen geçerli bir e-posta adresi girin" hatası alınmalıdır

  @UserStory3 @Register @BR-REG-002 @Negative
  Scenario: Sistemde halihazırda var olan e-posta ile mükerrer kayıt denemesi
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Diğer tüm alanları geçerli doldurup "Hesap Oluştur" butonuna tıklar
    Then "Bu e-posta adresi zaten kullanımda" uyarısı verilmelidir

  @UserStory3 @Register @BR-REG-002 @Negative @EdgeCase
  Scenario: Kayıt formunda zayıf ve eşleşmeyen şifre denemeleri
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı şifre alanına 8 karakterden kısa bir şifre girer
    Then Şifre uzunluk uyarısı gösterilmelidir
    When Kullanıcı "Şifre" ve "Şifreyi Onayla" alanlarına birbirinden farklı değerler girer
    And "Hesap Oluştur" butonuna tıklar
    Then "Şifreler eşleşmiyor" hatası dönmelidir

  @UserStory3 @Register @BR-REG-002 @Negative
  Scenario: Kullanıcı sözleşmesi onay kutucuğu işaretlenmeden kayıt denemesi
    Given Kullanıcı "Register" sayfasındadır
    When Kullanıcı geçerli e-posta ve şifre bilgilerini girer
    And Kullanıcı sözleşmesi onay kutucuğunu işaretlemeden "Hesap Oluştur" butonuna tıklar
    Then Kayıt işlemi tamamlanamamalı ve sözleşme onay uyarısı alınmalıdır