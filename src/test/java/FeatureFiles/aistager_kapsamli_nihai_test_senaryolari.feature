Feature: AiStager.ai Temel Modüller ve Kimlik Doğrulama Akışları
  Kullanıcı olarak AiStager.ai ana sayfasındaki interaktif araçları kullanabilmek, 
  dil ve oturum yönetimi ile güvenli kayıt ve giriş işlemlerini gerçekleştirebilmek istiyorum.

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Öncesi ve Sonrası Sihri slider alanının etkileşimli çalışması
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Kullanıcı slider üzerindeki iki yönlü oku sağa ve sola sürükler
    And Kullanıcı sağ ve sol yön oklarına tıklar
    And Kullanıcı alt carousel noktalarına tıklar
    Then Slider görseli ve geçişlerin akıcı bir şekilde senkronize çalıştığı doğrulanır

  Scenario: Web sitesi dilinin değiştirilmesi
    When Kullanıcı dil seçeneğini "TR" olarak değiştirir
    Then Sayfadaki tüm statik metinlerin anında Türkçe dile uyarlandığı doğrulanır

  Scenario: Oturum açmamış ziyaretçi kullanıcı için üst menü görünümü
    Given Kullanıcı sisteme giriş yapmamıştır
    When Kullanıcı AiStager ana sayfasına gider
    Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üst menüde Üretimlerim ve profil ikonunun gizli olduğu doğrulanır

  Scenario: Oturum açmış kullanıcı için üst menü görünümü
    Given Kullanıcı geçerli bilgileriyle sisteme giriş yapmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Üst menüde Üretimlerim, hızlı render paneli ve profil menüsünün aktif olarak erişilebilir olduğu doğrulanır

  Scenario: Galerinin varsayılan filtre ile açılması ve oda tipi filtreleme
    Given Kullanıcı ana sayfadaki galeri alanındadır
    Then Galeri varsayılan olarak Tüm Tipler filtresiyle açılmalıdır
    When Kullanıcı farklı bir oda tipi butonuna tıklar
    Then Galeri listesinin seçilen oda tipine göre dinamik olarak filtrelendiği doğrulanır

  Scenario: Daha Fazla Tasarım Yükle aksiyonunun mevcut filtreyi koruması
    Given Kullanıcı galeride spesifik bir oda tipi filtresi seçmiştir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Aktif olan filtre kuralı bozulmadan listeye yeni tasarım kartlarının eklendiği doğrulanır

  Scenario: Sıkça Sorulan Sorular alanının tekli açılma kuralı
    Given Kullanıcı SSS (Accordion) alanındadır
    When Kullanıcı bir soruya tıklayarak akordeonu açar
    And Kullanıcı farklı bir başka soruya tıklar
    Then İlk açılan sorunun otomatik olarak kapandığı ve sadece yeni tıklanan sorunun açık kaldığı doğrulanır

  Scenario: Bülten aboneliğine geçerli e-posta ile kayıt olma
    Given Kullanıcı bülten alanındadır
    When Kullanıcı geçerli bir e-posta adresi girer "test@example.com" ve abone ol butonuna tıklar
    Then Yeşil onay mesajının gösterildiği doğrulanır

  Scenario: Bülten aboneliğine geçersiz e-posta ile kayıt olma
    Given Kullanıcı bülten alanındadır
    When Kullanıcı geçersiz bir e-posta formatı girer "gecersiz-eposta" ve abone ol butonuna tıklar
    Then Bülten aboneliğinin gerçekleşmediği ve hata mesajı gösterildiği doğrulanır

  Scenario: Geçerli bilgilerle başarılı giriş yapma ve şifre görünürlüğü
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı geçerli e-posta adresini ve şifresini girer
    And Kullanıcı şifre alanındaki Göz ikonuna tıklar
    Then Şifrenin düz metin olarak görünür kılındığı doğrulanır
    When Kullanıcı Giriş Yap butonuna tıklar
    Then Kullanıcı başarıyla panele yönlendirilir

  Scenario: Zorunlu alanlar boşken giriş yapmayı deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then Bu alan zorunludur uyarı mesajlarının alındığı ve formun gönderilmediği doğrulanır

  Scenario: Hatalı e-posta veya şifre kombinasyonu ile giriş yapma
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıtlı olmayan veya hatalı bir şifre kombinasyonu girer ve Giriş Yap butonuna tıklar
    Then Kullanıcıya spesifik detay yerine genel bir hata mesajı "E-posta veya şifre hatalı" gösterildiği doğrulanır

  Scenario: Güvenlik testi SQL injection ve uzun karakter girdileri
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı e-posta alanına SQL injection payload veya aşırı uzun karakter dizisi girer
    And Kullanıcı Giriş Yap butonuna tıklar
    Then Sistemin güvenli filtreleme yaptığı, 500 sunucu hatası dönmediği ve uygun hata mesajı verdiği doğrulanır

  Scenario: Yeni hesabın başarıyla oluşturulması
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı geçerli ad, soyad ve benzersiz bir e-posta adresi girer
    And Kullanıcı minimum 8 karakterli geçerli bir şifre girer ve Şifreyi Onayla alanına aynı şifreyi yazar
    And Kullanıcı yasal sözleşmeleri onaylar
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Yeni hesabın başarıyla oluşturulduğu doğrulanır

  Scenario: Şifrelerin eşleşmemesi durumu
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı şifre alanına "Password123" ve Şifreyi Onayla alanına "Password456" girer
    And Kullanıcı diğer zorunlu alanları doldurup Kayıt Ol butonuna tıklar
    Then Kayıt işleminin bloke edildiği ve Şifreler eşleşmiyor validasyon mesajının gösterildiği doğrulanır

  Scenario: Zayıf şifre kullanımı
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı 8 karakterden kısa bir şifre girer "Abc1"
    And Kullanıcı kayıt formunu doldurup gönderir
    Then Kayıt işleminin gerçekleşmediği ve şifre uzunluğuyla ilgili uyarı mesajı verildiği doğrulanır

  Scenario: Eksik sözleşme onayı ile kayıt denemesi
    Given Kullanıcı kayıt sayfasındadır
    When Kullanıcı tüm metin alanlarını ve şifreleri doğru doldurur ancak sözleşme onay kutusunu işaretlemez
    And Kullanıcı Kayıt Ol butonuna tıklar
    Then Formun gönderilemediği ve sözleşmelerin onaylanması gerektiğine dair uyarı alındığı doğrulanır

  Scenario: Mükerrer e-posta ile kayıt olma
    Given Sistemde halihazırda kayıtlı bir "kullanan@example.com" e-posta adresi vardır
    When Kullanıcı kayıt sayfasında aynı e-posta adresini kullanarak kayıt olmaya çalışır
    Then Sistemin kayıt işlemini bloke ettiği ve e-postanın zaten kullanımda olduğuna dair hata mesajı verdiği doğrulanır