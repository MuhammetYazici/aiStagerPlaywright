# language: tr
@AiStager @US-AISTAGER-001
Feature: AiStager.ai Temel Modüller, Ana Sayfa, Kimlik Doğrulama ve Navigasyon Testleri
  Kullanıcı olarak ana sayfa bileşenlerini kullanabilmek, oturum durumuma göre header görmek
  ve güvenli kimlik doğrulama işlemleri yapmak istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  # ==========================================
  # 1. ANA SAYFA VE SLİDER KURALLARI (BR-HP-001)
  # ==========================================

  @Pozitif @Slider
  Scenario: Öncesi ve Sonrası slider alanının pürüzsüz çalışması
    When Kullanıcı Öncesi ve Sonrası slider alanındaki iki yönlü oku sağa ve sola sürükler
    Then Önce boş oda ve Sonra mobilyalı oda görselleri arasında pürüzsüz geçiş sağlanmalıdır

  @Pozitif @Slider
  Scenario: Slider altındaki noktalar ve oklar ile görsel değiştirme
    When Kullanıcı slider altındaki carousel noktalarına veya yön oklarına tıklar
    Then İlgili oda görselleri yüklenmeli ve aktif nokta görsel olarak vurgulanmalıdır

  @Pozitif @DilDestegi
  Scenario: Dil seçeneğinin değiştirilmesi
    When Kullanıcı dil seçeneğini Türkçe TR olarak belirler
    Then Sayfadaki tüm metinler seçilen dile göre güncellenmelidir

  # ==========================================
  # 2. ÜST MENÜ (HEADER) KURALLARI (BR-HP-002)
  # ==========================================

  @Pozitif @Header @Ziyaretci
  Scenario: Ziyaretçi durumunda oturum açılmamış header görünümü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı AiStager.ai ana sayfasını ziyaret eder
    Then Sağ üst köşede Giriş Yap ve Ücretsiz Dene butonları yer almalıdır
    And Üretimlerim menüsü ve profil ikonu sayfada görünmemelidir

  @Pozitif @Header @Kullanici
  Scenario: Oturum açılmış kullanıcı durumunda header görünümü
    Given Kullanıcı geçerli kimlik bilgileriyle sisteme giriş yapmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Ürünler, Çözümler, Kaynaklar, Fiyatlandırma ve Üretimlerim menüleri erişilebilir olmalıdır
    And Dil seçici, hızlı render kamera ayarlar ve profil menüsü görüntülenmelidir

  @Pozitif @Header
  Scenario: Logo tıklama ile ana sayfaya yönlendirme
    Given Kullanıcı AiStager.ai platformunun alt sayfalarından birindedir
    When Kullanıcı üst menüdeki Logoya tıklar
    Then Sayfa yenilenmeli veya tr ana sayfasına yönlendirme yapılmalıdır

  # ==========================================
  # 3. TOPLULUK GALERİSİ VE FİLTRELEME (BR-HP-003)
  # ==========================================

  @Pozitif @Galeri
  Scenario: Galeri varsayılan durumu ve filtreleme
    Given Kullanıcı AiStager.ai ana sayfasındaki topluluk galerisi alanındadır
    Then Varsayılan olarak Tüm Tipler filtresi aktif ve mor renkli olmalıdır
    And Karışık oda tipleri listede gösterilmelidir
    When Kullanıcı spesifik bir oda tipi filtre butonuna tıklar
    Then Liste yalnızca ilgili oda tipine ait tasarımları içerecek şekilde filtrelenmelidir

  @Pozitif @Galeri
  Scenario: Tasarım kartlarını beğenme ve daha fazla yükleme
    Given Kullanıcı topluluk galerisindedir
    When Kullanıcı bir tasarım kartındaki Kalp Beğeni ikonuna tıklar
    Then Beğeni sayısı 1 artmalı ve ikon aktif hale gelmelidir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtre bozulmaksızın listeye yeni kartlar eklenmelidir

  # ==========================================
  # 4. FAQ VE ALT BİLGİ (FOOTER) KURALLARI (BR-HP-004 & BR-HP-005)
  # ==========================================

  @Pozitif @FAQ
  Scenario: Sıkça Sorulan Sorular FAQ akordeon davranışı
    Given Kullanıcı FAQ alanındadır
    When Kullanıcı kapalı olan bir soru başlığına tıklar
    Then Soru içeriği açılmalıdır
    When Kullanıcı farklı bir soru başlığına tıklar
    Then Yeni soru açılmalı ve daha önce açık olan soru otomatik olarak kapanmalıdır
    When Kullanıcı açık olan aynı soru başlığına tekrar tıklar
    Then İçerik kapanmalıdır

  @Pozitif @Footer @Bulten
  Scenario: Bülten aboneliği başarılı durum
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı "test@example.com" e-posta adresini girer ve abone ol butonuna tıklar
    Then Başarı mesajı gösterilmelidir

  @Negatif @Footer @Bulten
  Scenario: Bülten aboneliği geçersiz veya boş e-posta durumu
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı e-posta alanını boş bırakır veya geçersiz format girip abone ol butonuna tıklar
    Then Validasyon hata mesajı alınmalıdır

  @Pozitif @Footer
  Scenario: Footer yasal linkler ve sosyal medya yönlendirmeleri
    Given Kullanıcı footer alanındadır
    When Kullanıcı Gizlilik Politikası veya Kullanım Şartları linkine tıklar
    Then İlgili resmi yasal sayfa açılmalıdır
    When Kullanıcı sosyal medya ikonlarına tıklar
    Then İlgili platformun dış sekmedeki profili açılmalıdır

  # ==========================================
  # 5. GİRİŞ YAP (LOGIN) KURALLARI (BR-LOG-001)
  # ==========================================

  @Pozitif @Login
  Scenario: Başarılı kullanıcı girişi
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı "test@example.com" e-posta adresini ve "Password123" şifresini girer
    And Giriş Yap butonuna tıklar
    Then Kullanıcı başarıyla panele yönlendirilmelidir

  @Negatif @Login
  Scenario: Boş bırakılan zorunlu alanlar ve geçersiz e-posta formatı
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakıp giriş yapmaya çalışır
    Then Bu alan zorunludur uyarısı alınmalıdır
    When Kullanıcı "testuser" e-posta adresini girer
    Then Lütfen geçerli bir e-posta adresi girin uyarısı alınmalıdır

  @Negatif @Login @Guvenlik
  Scenario: Hatalı kimlik bilgileri ile giriş denemesi
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı "unknown@example.com" e-posta adresini ve "WrongPass" şifresini girer
    And Giriş Yap butonuna tıklar
    Then Sistem spesifik bilgi sızdırmadan standart E-posta veya şifre hatalı genel hata mesajını göstermelidir

  @Pozitif @Login
  Scenario: Şifre alanında göz ikonu ile maskeleme
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı şifre alanına "Secret123" metnini yazar
    Then Şifre karakterleri maskelenmiş gizli olmalıdır
    When Kullanıcı Göz ikonuna tıklar
    Then Şifre düz metin olarak görünür hale gelmelidir

  @Negatif @Security @SQLInjection
  Scenario: Form alanlarında SQL Injection güvenlik testi
    Given Kullanıcı "/login" sayfasındadır
    When Kullanıcı e-posta alanına "' OR '1'='1" e-posta adresini yazar
    And Giriş Yap butonuna tıklar
    Then Sistem çökmeden girdileri filtrelemeli ve güvenli bir şekilde reddetmelidir

  # ==========================================
  # 6. KAYIT OL (REGISTER) KURALLARI (BR-REG-001)
  # ==========================================

  @Pozitif @Register
  Scenario: Başarılı yeni kullanıcı kaydı
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı geçerli bilgiler, min. 8 karakterli "SecurePass1" şifreler girer ve kullanıcı sözleşmesini onaylar
    And Kayıt Ol butonuna tıklar
    Then Kullanıcı başarıyla kaydedilmeli ve yönlendirme yapılmalıdır

  @Negatif @Register
  Scenario: Zaten kayıtlı e-posta adresiyle kayıt olma denemesi
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı "existing@example.com" e-posta adresini girer
    And Tüm zorunlu alanları doldurup Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda uyarısı verilmelidir

  @Negatif @Register
  Scenario: Kayıt formunda kural dışı girdiler ve eksik onaylar
    Given Kullanıcı "/register" sayfasındadır
    When Kullanıcı "123" şifresini girer veya Şifre ile Şifreyi Onayla alanları eşleşmez
    And Kullanıcı sözleşmesi onaylanmamış durumdayken Kayıt Ol butonuna tıklar
    Then İlgili alan bazlı hata mesajları min. karakter, eşleşmeme ve zorunlu sözleşme gösterilmelidir