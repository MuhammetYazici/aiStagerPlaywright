İstenen adımlar, ilgili senaryolara doğru sıra ve birebir metinlerle eklenerek senaryonun eksiksiz hali aşağıda verilmiştir:

```gherkin
Feature: AiStager.ai Ana Sayfa, Header ve Kimlik Doğrulama Modülleri
  Kullanıcı olarak ana sayfadaki bileşenleri kullanabilmek ve
  güvenli kimlik doğrulama süreçlerini tamamlayabilmek istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  @AnaSayfa @Slider @Pozitif
  Scenario: Öncesi ve Sonrası Slider bileşeninin ve Yükleme butonunun çalışması
    Given Kullanıcı ana sayfasındadır
    When Kullanıcı slider üzerindeki Önce Sonra çizgisini sağa ve sola sürükler
    And Kullanıcı slider yan oklarına veya alt carousel noktalarına tıklar
    Then Oda görselleri pürüzsüz bir geçişle yüklenmelidir
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then Kullanıcı doğru aksiyon sayfasına yönlendirilmelidir

  @Header @Ziyaretci @Pozitif
  Scenario: Oturum açmamış ziyaretçi için Header görünümü
    Given Ziyaretçi ana sayfadadır ve oturum açmamıştır
    Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir
    And Üst menüde Üretimlerim menüsü ve profil ikonu gizli olmalıdır

  @Header @Uye @Pozitif
  Scenario: Oturum açmış kayıtlı kullanıcı için Header görünümü
    Given Kayıtlı kullanıcı sisteme başarılı giriş yapmıştır
    Then Üst menüde Logo, Ürünler dropdown, Çözümler, Kaynaklar, Fiyatlandırma görünmelidir
    And Üst menüde Üretimlerim, dil seçeneği TR, hızlı kamera ayarları ve profil ikonu eksiksiz erişilebilir olmalıdır

  @Galeri @Filtreleme @Pozitif
  Scenario: Galeri odalarının filtrelenmesi ve etkileşimleri
    Given Kullanıcı ana sayfa galeri bölümündedir
    Then Varsayılan olarak Tüm Tipler filtresi aktif gelmelidir
    When Kullanıcı Oturma Odası oda tipi filtresine tıklar
    Then Galeri anında Oturma Odası kartlarıyla güncellenmelidir
    When Kullanıcı bir kart üzerindeki Kalp Beğeni ikonuna tıklar
    Then Beğeni sayaç sayısı anlık 1 artmalıdır
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Mevcut filtre korunarak alt alta yeni tasarım kartları yüklenmelidir

  @SSS @Akordeon @Pozitif
  Scenario: Sıkça Sorulan Sorular SSS akordeonunun tekli çalışması
    Given Kullanıcı ana sayfadaki SSS bölümündedir
    When Kullanıcı listeden birinci soruya tıklar
    Then Birinci sorunun cevabı açılmalıdır
    When Kullanıcı ikinci bir soruya tıklar
    Then İkinci sorunun cevabı açılmalı ve birinci sorunun cevabı otomatik olarak kapanmalıdır

  @Footer @Bulten @Pozitif
  Scenario: Bülten alanına geçerli e-posta adresi ile abone olma
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı e-posta alanına geçerli bir "test@ornek.com" adresi girer
    And Kullanıcı bülten gönder butonuna tıklar
    Then Başarı mesajı görüntülenmelidir

  @Footer @Bulten @Negatif
  Scenario: Bülten alanına boş veya geçersiz e-posta ile abone olma
    Given Kullanıcı footer bülten alanındadır
    When Kullanıcı e-posta alanını boş bırakır veya geçersiz bir metin girer
    And Kullanıcı bülten gönder butonuna tıklar
    Then Hata uyarısı gösterilmelidir

  @Footer @Linkler @EdgeCase
  Scenario: Footer yasal metinler ve sosyal medya linklerinin yeni sekmede açılması
    Given Kullanıcı footer bölümündedir
    When Kullanıcı Gizlilik Politikası, Kullanım Şartları veya sosyal medya ikonlarına tıklar
    Then İlgili hedef adresler yeni bir sekmede açılmalıdır

  @Auth @Validation @Negatif
  Scenario: Giriş ve Kayıt formlarında zorunlu alanların boş bırakılması
    Given Kullanıcı "Giriş Yap" veya "Kayıt Ol" sayfasındadır
    When Kullanıcı tüm zorunlu alanları boş bırakarak form gönderimine tıklar
    Then Alanların altında Bu alan zorunludur uyarısı verilmelidir

  @Auth @Validation @Negatif
  Scenario: Hatalı e-posta formatı girilmesi
    Given Kullanıcı "Giriş Yap" veya "Kayıt Ol" sayfasındadır
    When Kullanıcı e-posta alanına @domain veya eksik karakterli hatalı bir format girer
    Then Lütfen geçerli bir e-posta adresi girin uyarısı gösterilmelidir

  @Auth @Register @Validation @Negatif
  Scenario: Kayıt Ol ekranında geçersiz şifre veya eşleşmeme durumu
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When Kullanıcı şifre alanına 8 karakterden az bir şifre girer
    And Kullanıcı Şifreyi Onayla alanına farklı bir değer girer
    And Kullanıcı sözleşme kutucuğunu işaretlemeden kayıt ol butonuna tıklar
    Then Şifreler eşleşmiyor uyarısı veya şifre uzunluk kuralı hatası dönülmelidir
    And Kullanıcı sözleşme onay kutucuğu seçilmediği sürece kaydın tamamlanmadığı görülmelidir

  @Auth @Register @Pozitif
  Scenario: Başarılı yeni kullanıcı kaydı oluşturma
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When Kullanıcı geçerli bir e-posta ve en az 8 karakterli eşleşen şifreler girer
    And Kullanıcı kullanıcı sözleşmesi kutucuğunu işaretler
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Kayıt başarıyla tamamlanmalı ve kullanıcı yönlendirilmelidir

  @Auth @Login @Negatif
  Scenario: Kayıtlı olmayan e-posta veya yanlış şifre ile giriş denemesi
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When Kullanıcı sistemde kayıtlı olmayan bir e-posta veya hatalı şifre girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Güvenlik gereği genel bir E-posta veya şifre hatalı mesajı gösterilmelidir

  @Auth @Register @Negatif
  Scenario: Sistemde zaten kayıtlı e-posta ile tekrar kayıt olma
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When Kullanıcı sisteme önceden kayıt olmuş bir e-posta adresi girer
    And Kullanıcı kayıt olmaya çalışır
    Then Bu e-posta adresi zaten kullanımda uyarısı dönülmelidir

  @Auth @UI @Pozitif
  Scenario: Şifre alanlarında Göz ikonu ile maskeleme kontrolü
    Given Kullanıcı şifre içeren bir form alanına veri girmiştir
    When Kullanıcı şifre inputunun sağındaki Göz ikonuna tıklar
    Then Şifrenin düz metin olarak göründüğü doğrulanmalıdır
    When Kullanıcı Göz ikonuna tekrar tıklar
    Then Şifrenin tekrar nokta veya yıldız ile maskelendiği görülmelidir

  @Auth @Security @EdgeCase
  Scenario: Güvenlik testleri SQL Injection ve uzun karakter girdileri
    Given Kullanıcı "Giriş Yap" veya "Kayıt Ol" sayfasındadır
    When Kullanıcı input alanlarına SQL Injection karakterleri "' OR '1'='1" veya aşırı uzun metinler girer
    And Kullanıcı formu gönderir
    Then Sistem bu girdileri güvenle filtrelemelidir
    And Hiçbir şekilde 5xx sunucu hatası veya uygulama çökmesi yaşanmamalıdır

  @Auth @OAuth @Pozitif
  Scenario: Google OAuth ile sosyal giriş ve kayıt yönlendirmesi
    Given Kullanıcı "Giriş Yap" veya "Kayıt Ol" sayfasındadır
    When Kullanıcı Google ile devam et butonuna tıklar
    Then Kullanıcı Gmail hesap seçimi ve yetkilendirme penceresine sorunsuz yönlendirilmelidir