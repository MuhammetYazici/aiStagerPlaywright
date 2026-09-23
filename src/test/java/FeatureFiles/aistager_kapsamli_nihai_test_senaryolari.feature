# language: tr
Feature: AiStager.ai Çekirdek Modülleri, Navigasyon ve Kimlik Doğrulama
  Kullanıcıların ana sayfa bileşenlerini kullanabilmesi, çoklu dil desteğinden yararlanabilmesi,
  galeriyi filtreleyebilmesi, bültene abone olabilmesi ve güvenli bir şekilde
  giriş/kayıt işlemlerini gerçekleştirebilmesi amaçlanmaktadır.

  Background:
    Given Kullanıcı AiStager platformundadır
    And Şu anki dil seçeneği "TR" olarak ayarlanmıştır

  Scenario: Ziyaretçi için header menü görünürlüğü
    Given Kullanıcı ana sayfadadır
    And Kullanıcı sisteme giriş yapmamıştır
    Then Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üretimlerim ve profil menüleri gizli olmalıdır

  Scenario: Oturum açmış kullanıcı için hızlı erişim menülerinin aktif olması
    Given Kullanıcı ana sayfadadır
    And Kullanıcı geçerli kimlik bilgileriyle sisteme giriş yapmıştır
    Then Hızlı erişim panelleri, Üretimlerim ve profil menüleri aktif ve görünür olmalıdır

  Scenario: Slider görsel geçişlerinin test edilmesi
    Given Kullanıcı ana sayfadaki slider alanındadır
    When Kullanıcı kaydırıcıyı sağa ve sola çeker
    Then Mobilyalı ve boş oda geçişleri pürüzsüz görünmelidir
    And Oklar ile alt carousel noktaları görsellerle senkronize çalışmalıdır

  Scenario: Oda tipi filtreleme ve Daha Fazla Yükle aksiyonu
    Given Kullanıcı ana sayfadaki galeri alanındadır
    When Kullanıcı Oturma Odası oda tipi filtresini seçer
    Then Galeri dinamik olarak sadece Oturma Odası tasarımlarını filtrelemelidir
    And Kullanıcı Daha Fazla Yükle butonuna tıkladığında mevcut filtre korunarak yeni kartlar listeye eklenmelidir

  Scenario: Sıkça Sorulan Sorular akordeonunun tekli çalışma kuralı
    Given Kullanıcı ana sayfadaki SSS bölümündedir
    When Kullanıcı birinci soruya tıklayarak açmıştır
    And Kullanıcı ikinci bir soruya tıklamıştır
    Then İkinci soru açılmalı ve birinci soru otomatik olarak kapanmalıdır

  Scenario: Dil değişimi ile anlık metin güncellemesi
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki dil seçeneğine tıklar
    And Dil seçeneği EN olarak değiştirilir
    Then Sayfadaki tüm statik metinler anlık olarak İngilizceye güncellenmelidir

  Scenario: Geçerli e-posta ile başarılı bülten aboneliği
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı bülten formuna "test@ornek.com" geçerli e-postasını girer
    And Kullanıcı abone ol butonuna tıklar
    Then Başarılı abonelik belirten yeşil uyarı mesajı görüntülenmelidir

  Scenario: Boş e-posta ile bülten aboneliği denemesi
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı e-posta alanını boş bırakarak abone ol butonuna tıklar
    Then Sistem Bu alan zorunludur veya geçerli bir hata mesajı dönmelidir

  Scenario: Geçersiz e-posta formatı ile bülten aboneliği denemesi
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı bülten formuna "gecersiz-eposta" formatında metin girer
    And Kullanıcı abone ol butonuna tıklar
    Then Sistem geçersiz e-posta formatı hatası vermelidir

  Scenario: Geçerli bilgilerle başarılı giriş yapılması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı geçerli "eposta@ornek.com" ve "GuvenliSifre1." girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarılı şekilde ana panele yönlendirilmelidir

  Scenario: Giriş sayfasında zorunlu alanların boş bırakılması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak giriş yapmaya çalışır
    Then İlgili alanların altında Bu alan zorunludur uyarı mesajı görünmelidir

  Scenario: Geçersiz e-posta formatı ile giriş denemesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına "hatali-format" yazar
    Then Sistem standart e-posta formatı uyarısı vermelidir

  Scenario: Yanlış şifre veya kayıtlı olmayan e-posta ile giriş
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı yanlış şifre veya sistemde kayıtlı olmayan bir e-posta girer
    And Giriş yap butonuna tıklar
    Then Güvenlik amacıyla genel bir hata mesajı olan E-posta veya şifre hatalı gösterilmelidir

  Scenario: Şifre alanında göz ikonu ile maskeleme ve açma fonksiyonu
    Given Kullanıcı giriş sayfasındaki şifre alanına metin girer
    When Kullanıcı şifre alanındaki göz ikonuna tıklar
    Then Şifre karakterleri okunabilir hale gelmeli, tekrar tıklandığında maskelenmelidir

  Scenario: Geçerli bilgilerle başarılı kayıt oluşturulması
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı geçerli ad, soyad, "yeni@ornek.com" e-posta ve "GuvenliSifre1." şifresini girer
    And Kullanıcı kullanıcı sözleşmesini onaylar
    And Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve aktivasyon geçişi sağlanmalıdır

  Scenario: Kayıt olurken şifre politikasının ihlal edilmesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı şifre alanına 8 karakterden kısa bir değer girer
    Then Sistem şifrenin en az 8 karakter olması gerektiğine dair hata mesajı vermelidir

  Scenario: Kayıt olurken şifrelerin eşleşmemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı Şifre alanına "GuvenliSifre1." ve Şifreyi Onayla alanına "FarkliSifre2." girer
    Then Sistem iki şifrenin eşleşmediğine dair hata mesajı vermelidir

  Scenario: Zaten kayıtlı e-posta adresi ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Kayıt ol butonuna tıklar
    Then Sistem net bir şekilde Bu e-posta adresi zaten kullanımda uyarısı vermelidir

  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı tüm zorunlu alanları doğru doldurur ancak kullanıcı sözleşmesini onaylamaz
    Then Kayıt işlemi engellenmeli ve sözleşme onay uyarısı gösterilmelidir

  Scenario: Form alanlarına SQL Injection veya zararlı özel karakterler girilmesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı form alanlarına SQL Injection denemesi içeren metinler girer
    Then Sistem bu girdileri güvenli bir şekilde filtrelemelidir
    And Sunucu tarafında hata üretmek yerine uygun bir validasyon hatası dönmelidir

  Scenario: Google ile devam et entegrasyonunun tetiklenmesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı Google ile Devam Et butonuna tıklar
    Then Google kimlik doğrulama ekranı başarılı bir şekilde tetiklenmelidir