Feature: US-AISTAGER-001 Ana Sayfa, Kimlik Doğrulama ve Temel Navigasyon

  Background:
    Given Kullanıcı AiStager platformundadır

  @pozitif @slider
  Scenario: Öncesi ve Sonrası Slider alanının pürüzsüz çalışması
    Given Kullanıcı AiStager ana sayfasındadır
    When Kullanıcı Öncesi ve Sonrası Sihri alanındaki kaydırıcıyı sağa ve sola sürükler
    Then Önce ve Sonra görselleri orantılı ve dinamik olarak değişmelidir

  @pozitif @slider
  Scenario: Carousel navigasyon okları ve noktaları ile görsel değiştirme
    Given Kullanıcı AiStager ana sayfasındadır
    When Kullanıcı slider alanındaki sağ yön okuna veya alt kısımdaki carousel noktasına tıklar
    Then İlgili oda görseli yüklenmeli ve ilgili nokta aktif olarak vurgulanmalıdır

  @pozitif @navigation
  Scenario: Odanızı Yükleyin butonunun yönlendirmesi
    Given Kullanıcı AiStager ana sayfasındadır
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı ilgili yükleme veya kimlik doğrulama arayüzüne yönlendirilmelidir

  @pozitif @dil
  Scenario: Dil seçeneği üzerinden dil değiştirme
    Given Kullanıcı AiStager ana sayfasındadır
    When Kullanıcı dil menüsünden "TR" seçeneğine tıklar
    Then Sayfadaki tüm metinler seçilen dile göre güncellenmelidir

  @pozitif @header
  Scenario: Oturum açmış kullanıcının üst menü görünümü
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Üst menüde Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, dil seçeneği, hızlı render ayarları ve profil ikonu görünür olmalıdır
    And Logo tıklandığında ana sayfaya yönlendirme yapılmalıdır

  @pozitif @header
  Scenario: Ziyaretçi kullanıcının üst menü görünümü
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı ana sayfayı görüntüler
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları yer almalıdır
    And Üretimlerim menüsü ve profil ikonu gizli olmalıdır

  @pozitif @galeri
  Scenario: Galeri ilk açılış ve kategori filtreleme
    Given Kullanıcı AiStager ana sayfasındadır
    When Sayfa ilk açıldığında Tüm Tipler filtresinin aktif olduğu görülür
    And Kullanıcı Oturma Odası filtre butonuna tıklar
    Then Galeri yalnızca oturma odası tasarımlarını listelemelidir

  @pozitif @galeri @sosyal
  Scenario: Galeri kartı sosyal etkileşimleri ve beğeni artışı
    Given Kullanıcı AiStager ana sayfasındadır
    When Kullanıcı bir galeri kartındaki kullanıcı adını tıklar
    Then İlgili profil sayfasına yönlendirilmelidir
    When Kullanıcı galeri kartındaki Kalp Beğeni ikonuna tıklar
    Then Beğeni sayısı 1 artmalı ve ikon aktif duruma gelmelidir

  @pozitif @galeri @lazyload
  Scenario: Daha Fazla Tasarım Yükle ile sayfalama
    Given Kullanıcı ana sayfadaki galeri alanındadır ve filtre uygulanmıştır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtreleme kuralı bozulmadan alt alta yeni tasarım kartları yüklenmelidir

  @pozitif @akordeon
  Scenario: SSS Akordeon mantığı ve tekli açık kalma kuralı
    Given Kullanıcı ana sayfadaki SSS alanındadır
    When Kullanıcı birinci soruya tıklar
    Then İlgili cevap açılmalı ve ok yukarı dönmelidir
    When Kullanıcı farklı bir ikinci soruya tıklar
    Then İkinci sorunun cevabı açılmalı ve önceki açık olan soru otomatik olarak kapanmalıdır
    And Bize ulaşın linkine tıklandığında destek sayfasına yönlendirilmelidir

  @pozitif @bulten
  Scenario: Bülten alanına geçerli e-posta ile abone olma
    Given Kullanıcı footer alanındaki bülten formundadır
    When Kullanıcı geçerli bir e-posta adresi girer ve Abone Ol butonuna tıklar
    Then Başarı mesajı görüntülenmelidir
    And Footer linkleri, yasal metinler ve sosyal medya ikonları yeni sekmede doğru adreslere yönlendirmelidir

  @negatif @bulten @edge-case
  Scenario Outline: Bülten alanına geçersiz e-posta girişi
    Given Kullanıcı footer alanındaki bülten formundadır
    When Kullanıcı bülten alanına "<gecersiz_eposta>" girer ve Abone Ol butonuna tıklar
    Then Geçerli bir e-posta adresi giriniz validasyon hatası gösterilmelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | test            |
      | test@           |
      | test@domain     |

  @pozitif @login
  Scenario: Başarılı kullanıcı girişi ve şifre görünürlüğü
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı geçerli e-posta ve şifresini girer
    And Kullanıcı Göz ikonuna tıklayarak şifrenin görünür olmasını sağlar
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı ana panele yönlendirilmelidir

  @negatif @login @validasyon
  Scenario: Giriş sayfasında zorunlu alan bırakılması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakıp Giriş Yap butonuna tıklar
    Then Bu alan zorunludur uyarı mesajı alınmalıdır

  @negatif @login @validasyon
  Scenario: Giriş sayfasında geçersiz e-posta formatı
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı formata uygun olmayan e-posta girer ve Giriş Yap butonuna tıklar
    Then E-posta format hatası gösterilmelidir

  @negatif @login @guvenlik
  Scenario: Hatalı e-posta veya şifre kombinasyonu ile giriş denemesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıtlı olmayan veya hatalı bir şifre kombinasyonu girer ve Giriş Yap butonuna tıklar
    Then Genel bir E-posta veya şifre hatalı mesajı gösterilmelidir
    And Sistem spesifik bir bilgi sızdırmamalıdır

  @edge-case @login @guvenlik
  Scenario: Giriş alanlarında SQL Injection ve uzun karakter testleri
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarına SQL Injection metinleri veya aşırı uzun karakterler girer
    Then Sistem girdileri güvenle filtrelemeli ve 500 sunucu hatası alınmamalıdır

  @pozitif @register
  Scenario: Başarılı hesap oluşturma Kayıt Ol
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan bir e-posta adresi girer
    And Kullanıcı kurallara uygun en az 8 karakterli bir şifre girer
    And Kullanıcı zorunlu kullanıcı sözleşmesi onay kutucuğunu işaretler
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Kayıt başarılı olmalı ve aktivasyon veya ana panele yönlendirme yapılmalıdır

  @negatif @register @validasyon
  Scenario: Mevcut kullanımda olan e-posta ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Diğer alanları doldurup Hesap Oluştur butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda hatası alınmalıdır

  @negatif @register @validasyon
  Scenario: 8 karakterden kısa şifre ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı 8 karakterden kısa bir şifre girer ve Hesap Oluştur butonuna tıklar
    Then Şifre uzunluk uyarısı verilmelidir

  @negatif @register @validasyon
  Scenario: Şifrelerin uyuşmaması durumu
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı şifre ve şifreyi onayla alanlarına farklı değerler girer ve Hesap Oluştur butonuna tıklar
    Then Şifreler eşleşmiyor uyarı mesajı gösterilmelidir

  @negatif @register @validasyon
  Scenario: Sözleşme onay kutucuğu işaretlenmeden kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı tüm alanları geçerli doldurur ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
    And Kullanıcı Hesap Oluştur butonuna tıklar
    Then Sözleşmeyi kabul etmelisiniz uyarısı gösterilmelidir