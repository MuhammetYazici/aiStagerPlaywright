Feature: AiStager.ai Ana Sayfa, Navigasyon, Bülten, Giriş ve Kayıt İşlevleri
  Kullanıcı olarak platformun ana sayfasını gezmek, topluluk tasarımlarını incelemek,
  bültene abone olmak, SSS bölümünü kullanmak ve güvenli bir şekilde üye olup giriş yapmak istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  @TC_HP_001 @Positive
  Scenario: Öncesi ve Sonrası Sihri slider alanının dinamik çalışması
    Given Kullanıcı ana sayfadadır
    When Kullanıcı Öncesi ve Sonrası Sihri slider alanına gider
    And kullanıcı iki yönlü kaydırma çubuğunu sağa ve sola sürükler
    Then o an oda görselinin dinamik ve pürüzsüz şekilde değiştiği görülür
    When kullanıcı sağ ve sol ok tuşlarına tıklar
    Then görsellerin sırasıyla değiştiği doğrulanır
    When kullanıcı alt kısımdaki carousel noktalarından birine tıklar
    Then ilgili oda görselinin doğrudan yüklendiği doğrulanır

  @TC_HP_002 @Positive @Visitor
  Scenario: Oturum açmamış ziyaretçi kullanıcı için Header görünümü
    Given Ziyaretçi ana sayfadadır
    When üst menüyü inceler
    Then Giriş Yap ve Ücretsiz Dene butonlarının görünür olduğunu görür
    And Üretimlerim menüsünün ve profil ikonunun gizli olduğunu doğrular

  @TC_HP_002 @Positive @LoggedIn
  Scenario: Oturum açmış kullanıcı için Header görünümü
    Given Kayıtlı kullanıcı geçerli bilgileriyle sisteme giriş yapar
    When ana sayfada üst menüyü inceler
    Then Üretimlerim menüsünün hızlı render ve kamera ayarlarının ve profil ikonunun erişilebilir olduğunu görür

  @TC_HP_002 @Positive @Navigation
  Scenario: Genel Header linkleri ve logo yönlendirmesi
    Given Kullanıcı ana sayfadadır
    When üst menüdeki logoya tıklar
    Then ana sayfaya yönlendirildiği doğrulanır
    When kullanıcı sırasıyla Ürünler Çözümler Kaynaklar ve Fiyatlandırma linklerine tıklar
    Then ilgili sayfalara sorunsuz yönlendirildiği doğrulanır
    And çoklu dil desteğinin aktif olduğu ve çalıştığı doğrulanır

  @TC_HP_003 @Positive @Gallery
  Scenario: Galeri ilk açılış ve oda tipi filtreleme
    Given Kullanıcı ana sayfa galeri alanına gider
    When sayfa ilk açıldığında Tüm Tipler filtresinin aktif olduğu görülür
    And kullanıcı farklı bir oda tipi filtresine Yatak Odası tıklar
    Then galerinin anlık olarak güncellendiği ve seçilen filtrenin korunduğu görülür
    When kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then mevcut filtre korunarak yeni tasarım kartlarının listeye eklendiği doğrulanır

  @TC_HP_003 @Positive @CardInteractions
  Scenario: Tasarım kartı kullanıcı adı ve beğeni etkileşimi
    Given Kullanıcı galeri alanındaki bir tasarım kartını inceler
    When tasarım kartındaki kullanıcı adının üzerine tıklar
    Then ilgili kullanıcının profil sayfasına yönlendirildiği doğrulanır
    When kullanıcı kart üzerindeki kalp ikonuna tıklar
    Then beğeni sayısının anlık olarak 1 arttığı doğrulanır

  @TC_HP_004 @Positive @Accordion
  Scenario: Sıkça Sorulan Sorular SSS akordeon yapısının kontrolü
    Given Kullanıcı SSS alanına kaydırır
    When ilk akordeon başlığına tıklar ve içeriğin açıldığını görür
    And kullanıcı farklı bir akordeon başlığına tıklar
    Then yeni sorunun açıldığı ve önceki açık olan sorunun otomatik olarak kapandığı doğrulanır
    And aynı anda yalnızca bir akordeon başlığının açık kaldığı doğrulanır

  @TC_HP_005 @Positive @Newsletter
  Scenario: Bülten alanına geçerli e-posta ile başarılı kayıt
    Given Kullanıcı footer alanındadır
    When bülten formuna geçerli bir e-posta adresi girer "test@example.com"
    And Abone Ol butonuna tıklar
    Then olumlu geri bildirim mesajının gösterildiği doğrulanır

  @TC_HP_005 @Negative @Newsletter
  Scenario: Bülten alanına geçersiz veya boş e-posta girişi
    Given Kullanıcı footer alanındadır
    When bülten formunu boş bırakır veya geçersiz bir e-posta girer "gecersiz-eposta"
    And Abone Ol butonuna tıklar
    Then uygun bir hata mesajının gösterildiği doğrulanır

  @TC_HP_006 @Positive @Footer
  Scenario: Footer kurumsal linkler ve sosyal medya ikonlarının yeni sekmede açılması
    Given Kullanıcı footer alanındadır
    When kurumsal linklere yasal metinlere Gizlilik Kullanım Şartları ve sosyal medya ikonlarına tıklar
    Then ilgili hedef sayfaların tarayıcıda yeni sekmede açıldığı doğrulanır

  @TC_LOG_001 @Positive @Login
  Scenario: Kayıtlı e-posta ve doğru şifre ile başarılı giriş
    Given Kullanıcı Giriş Yap sayfasına gider
    When geçerli e-posta adresini ve şifresini ilgili alanlara girer
    And şifre alanındaki Göz ikonuna tıklayarak şifrenin görünür veya gizli yapılabildiğini test eder
    And Giriş Yap butonuna tıklar
    Then sisteme başarılı bir şekilde giriş yaptığı ve ana sayfaya yönlendirildiği doğrulanır

  @TC_LOG_001 @Positive @OAuth
  Scenario: Google ile OAuth üzerinden başarılı giriş
    Given Kullanıcı Giriş Yap sayfasına gider
    When Google ile Giriş Yap butonuna tıklar
    And Google hesap seçim ekranından hesabını seçerek onay verir
    Then sisteme başarılı bir şekilde giriş yaptığı doğrulanır

  @TC_LOG_001 @Positive @Navigation
  Scenario: Giriş sayfasından yönlendirme linklerinin çalışması
    Given Kullanıcı Giriş Yap sayfasına gider
    When Şifremi unuttum linkine tıklar şifre sıfırlama sayfasına gittiğini doğrular ve geri döner
    And Kayıt ol linkine tıklar kayıt sayfasına başarılı şekilde yönlendirildiğini doğrular

  @TC_LOG_002 @Negative @Login @Validation
  Scenario: Giriş sayfasında boş bırakılan zorunlu alanlar
    Given Kullanıcı Giriş Yap sayfasına gider
    When e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then zorunlu alanlar için Bu alan zorunludur uyarı mesajlarının gösterildiği doğrulanır

  @TC_LOG_002 @Negative @Login @Validation
  Scenario: Giriş sayfasında geçersiz e-posta formatı
    Given Kullanıcı Giriş Yap sayfasına gider
    When e-posta alanına format dışı bir metin girer "kullanici@"
    And Giriş Yap butonuna tıklar
    Then geçersiz e-posta formatı uyarı mesajının gösterildiği doğrulanır

  @TC_LOG_002 @Negative @Login @Security
  Scenario: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi User Enumeration koruması
    Given Kullanıcı Giriş Yap sayfasına gider
    When kayıtlı olmayan bir e-posta veya kayıtlı hesaba yanlış şifre girer
    And Giriş Yap butonuna tıklar
    Then güvenlik gerekçesiyle sistemin genel bir hata mesajı E-posta veya şifre hatalı döndüğü doğrulanır

  @TC_LOG_002 @EdgeCase @Security
  Scenario: Giriş alanlarında SQL Enjeksiyonu ve zararlı girdilerin engellenmesi
    Given Kullanıcı Giriş Yap sayfasına gider
    When e-posta veya şifre alanına SQL enjeksiyon girdileri yazar "' OR '1'='1"
    And Giriş Yap butonuna tıklar
    Then zararlı girdilerin güvenlik filtreleriyle engellendiği ve sistemin 500 Internal Server Error hatası vermediği doğrulanır

  @TC_REG_001 @Positive @Register
  Scenario: Kurallara uygun bilgilerle başarılı hesap oluşturma
    Given Kullanıcı Kayıt Ol sayfasına gider
    When sistemde daha önce kayıtlı olmayan benzersiz bir e-posta adresi girer
    And kurallara uygun minimum 8 karakter güçlü bir şifre girer ve şifreyi onayla alanında aynı şifreyi yazar
    And Kullanım Sözleşmesi Şartlar onay kutucuğunu işaretler
    And Kayıt Ol butonuna tıklar
    Then hesabın başarılı bir şekilde oluşturulduğu ve doğrulama veya başarı mesajı alındığı doğrulanır

  @TC_REG_001 @Positive @OAuth
  Scenario: Google ile hızlı kayıt OAuth
    Given Kullanıcı Kayıt Ol sayfasına gider
    When Google ile Kayıt Ol butonuna tıklar
    And Google hesap izinlerini onaylar
    Then hesabın hızlı bir şekilde oluşturulduğu ve sisteme giriş yapıldığı doğrulanır

  @TC_REG_002 @Negative @Register @Validation
  Scenario: Kayıt sayfasında boş bırakılan zorunlu alanlar
    Given Kullanıcı Kayıt Ol sayfasına gider
    When tüm alanları boş bırakarak Kayıt Ol butonuna tıklar
    Then zorunlu alanlar için Bu alan zorunludur hata mesajlarının verildiği doğrulanır

  @TC_REG_002 @Negative @Register @BusinessRule
  Scenario: Zaten kullanımda olan e-posta adresi ile kayıt denemesi
    Given Kullanıcı Kayıt Ol sayfasına gider
    When sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And diğer zorunlu alanları doldurup Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısının gösterildiği doğrulanır

  @TC_REG_002 @Negative @Register @Validation
  Scenario: 8 karakterden kısa şifre veya şifrelerin uyuşmaması durumu
    Given Kullanıcı Kayıt Ol sayfasına gider
    When şifre alanına 8 karakterden kısa bir değer girer "Ab1!"
    And Şifreyi Onayla alanına ilk şifre ile eşleşmeyen farklı bir şifre yazar
    And Kayıt Ol butonuna tıklar
    Then şifrenin minimum 8 karakter olması gerektiği ve şifrelerin eşleşmediğine dair hata mesajlarının gösterildiği doğrulanır

  @TC_REG_002 @Negative @Register @BusinessRule
  Scenario: Kullanım Sözleşmesi onay kutucuğu işaretlenmeden kayıt denemesi
    Given Kullanıcı Kayıt Ol sayfasına gider
    When geçerli e-posta ve kurallara uygun şifre bilgilerini doldurur
    And Kullanım Sözleşmesi Şartlar onay kutucuğunu işaretlemez
    And Kayıt Ol butonuna tıklar
    Then kayıt işleminin tamamlanamadığı ve sözleşmenin onaylanması gerektiğine dair uyarı verildiği doğrulanır