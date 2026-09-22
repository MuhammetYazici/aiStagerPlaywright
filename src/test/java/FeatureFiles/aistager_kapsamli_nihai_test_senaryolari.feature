Feature: AiStager.ai Ana Sayfa, Kimlik Doğrulama ve Navigasyon Modülleri
  Kullanıcıların ana sayfa, giriş ve kayıt modüllerini iş kurallarına uygun şekilde kullanabilmesini test eder.

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Ziyaretçi Öncesi ve Sonrası Sihri slider alanını başarıyla kullanır
    Given Kullanıcı AiStager.ai ana sayfasındadır
    When Öncesi ve Sonrası Sihri alanındaki kaydırıcıyı sağa ve sola sürükler
    Then Önce ve Sonra görselleri dinamik ve pürüzsüz bir şekilde ölçeklenmelidir
    And Sağ sol oklar veya alt carousel noktalarına tıklandığında aktif oda görseli değişmelidir

  Scenario: Oturum açmamış ziyaretçi üst menüyü görüntüler
    Given Kullanıcı sisteme giriş yapmamış bir ziyaretçidir
    When Kullanıcı AiStager.ai ana sayfasını ziyaret eder
    Then Üst menüde Giriş Yap ve mavi renkli Ücretsiz Dene butonları görünmelidir
    And Üretimlerim alanı ve profil ikonu gizli olmalıdır

  Scenario: Sisteme giriş yapmış kullanıcı üst menüyü görüntüler
    Given Kullanıcı sisteme başarıyla giriş yapmıştır
    When Kullanıcı ana sayfayı görüntüler
    Then Ürünler, Çözümler, Kaynaklar, Fiyatlandırma, Üretimlerim, Dil seçeneği TR, Hızlı Render Kamera ayarları ve Profil ikonu erişilebilir olmalıdır

  Scenario: Kullanıcı oda tiplerine göre galeri filtrelemesi yapar
    Given Kullanıcı ana sayfa galeri bölümündedir
    When Sayfa ilk açıldığında Tüm Tipler filtresinin aktif ve mor renkli olduğu görülür
    And Kullanıcı farklı bir oda tipi filtresine tıklar
    Then Galeri sadece seçilen o tipten ait verileri listemelidir

  Scenario: Kullanıcı Daha Fazla Tasarım Yükle butonu ile yeni kartlar yükler
    Given Kullanıcı galeride filtreleme yapmıştır
    When Daha Fazla Tasarım Yükle butonuna tıklar
    Then Aktif filtre bozulmadan mevcut listenin altına yeni tasarım kartları yüklenmelidir

  Scenario: Kullanıcı galeri kartlarındaki etkileşimleri yönetir
    Given Kullanıcı galeri kartlarını incelemektedir
    When Bir kart üzerindeki Kalp ikonuna tıklar
    Then Beğeni sayısı anlık olarak 1 artmalıdır
    When Kart üzerindeki yazar ismine tıklar
    Then İlgili yazarın profil sayfasına yönlendirilmelidir

  Scenario: Kullanıcı SSS menüsünden aynı anda yalnızca bir soru açabilir
    Given Kullanıcı SSS Sıkça Sorulan Sorular alanındadır
    When SSS listesinden Soru 1 üzerine tıklayarak açar
    Then Soru 1 içeriği görünür olmalıdır
    When Kullanıcı Soru 2 üzerine tıklar
    Then Soru 2 açılmalı ve önceki açık olan Soru 1 otomatik olarak kapanmalıdır

  Scenario: Kullanıcı geçerli e-posta adresi ile bültene abone olur
    Given Kullanıcı footer bölümündeki bülten alanındadır
    When Geçerli bir e-posta adresi girer "test@example.com" ve Abone Ol butonuna tıklar
    Then Başarılı abonelik mesajı görüntülenmelidir

  Scenario: Kullanıcı geçersiz veya boş e-posta ile bültene abone olmaya çalışır
    Given Kullanıcı footer bölümündeki bülten alanındadır
    When E-posta alanını boş bırakır veya geçersiz format girer "gecersiz-email" ve Abone Ol butonuna tıklar
    Then Sistem hata mesajı üretmelidir

  Scenario: Kullanıcı footer linkleri ve sosyal medya ikonlarını kullanır
    Given Kullanıcı footer alanındadır
    When Yasal metinlere veya sosyal medya ikonlarına tıklar
    Then İlgili hedef doğru sayfayı yeni sekmede veya pencerede açmalıdır

  Scenario: Kullanıcı giriş formunu boş bırakarak giriş yapmaya çalışır
    Given Kullanıcı Giriş sayfasındadır
    When E-posta ve şifre alanlarını boş bırakarak Giriş Yap butonuna tıklar
    Then Her iki alan altında da Bu alan zorunludur uyarı mesajı görünmelidir

  Scenario: Kullanıcı geçersiz e-posta formatı ile giriş yapmaya çalışır
    Given Kullanıcı Giriş sayfasındadır
    When Geçersiz formatta e-posta girer "kullanici.com" ve şifresini yazar
    Then E-posta alanında format hatası uyarısı verilmelidir

  Scenario: Kullanıcı sisteme kayıtlı olmayan e-posta veya yanlış şifre ile giriş yapar
    Given Kullanıcı Giriş sayfasındadır
    When Sistemde kayıtlı olmayan bir e-posta ve/veya yanlış şifre girer
    And Giriş Yap butonuna tıklar
    Then Güvenlik gerekçesiyle spesifik bilgi verilmeden genel E-posta veya şifre hatalı mesajı gösterilmelidir

  Scenario: Kullanıcı giriş alanlarına zararlı payload girer
    Given Kullanıcı Giriş sayfasındadır
    When E-posta alanına SQL injection payload'ı girer "' OR '1'='1"
    And Giriş Yap butonuna tıklar
    Then Sistem 500 sunucu hatası üretmeden isteği güvenli bir şekilde reddetmelidir

  Scenario: Kullanıcı şifre alanındaki Göz ikonunu kullanır
    Given Kullanıcı Giriş sayfasındadır
    When Şifre alanına maskelenmiş karakterler girer "••••••••"
    And Şifre alanının yanındaki Göz ikonuna tıklar
    Then Maskelenmiş şifre düz metne dönüşmelidir

  Scenario: Kullanıcı Google OAuth ile giriş yapmayı dener
    Given Kullanıcı Giriş sayfasındadır
    When Google ile devam et butonuna tıklar
    Then Google kimlik doğrulama entegrasyonu başarılı bir şekilde tetiklenmelidir

  Scenario: Ziyaretçi kayıt formunu boş bırakarak hesap oluşturmaya çalışır
    Given Kullanıcı Kayıt sayfasındadır
    When Tüm alanları boş bırakarak Kayıt Ol butonuna tıklar
    Then İlgili alanların altında Bu alan zorunludur uyarıları görünmelidir

  Scenario: Ziyaretçi sistemde zaten kayıtlı bir e-posta ile kayıt olmaya çalışır
    Given Kullanıcı Kayıt sayfasındadır
    When Sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Gerekli diğer alanları doldurup Kayıt Ol butonuna tıklar
    Then Bu e-posta adresi zaten kullanımda hata mesajı dönmelidir

  Scenario: Ziyaretçi 8 karakterden kısa bir şifre ile kayıt olmaya çalışır
    Given Kullanıcı Kayıt sayfasındadır
    When Şifre alanına 8 karakterden az bir değer girer "Abc123"
    Then Şifre uzunluğunun en az 8 karakter olması gerektiğine dair uyarı verilmelidir

  Scenario: Ziyaretçi şifreler eşleşmediğinde kayıt olmaya çalışır
    Given Kullanıcı Kayıt sayfasındadır
    When Şifre alanına Password123 girer
    And Şifreyi Onayla alanına farklı bir şifre girer "Password124"
    And Kayıt Ol butonuna tıklar
    Then Şifreler eşleşmiyor uyarı mesajı verilmelidir

  Scenario: Ziyaretçi yasal sözleşmeleri onaylamadan kayıt olmaya çalışır
    Given Kullanıcı Kayıt sayfasındadır
    When Tüm form alanlarını geçerli bilgilerle doldurur
    And Kullanım Şartları Gizlilik Politikası sözleşme onay kutucuğunu işaretlemez
    And Kayıt Ol butonuna tıklar
    Then Sözleşmeyi kabul etmelisiniz uyarı mesajı görüntülenmelidir ve kayıt engellenmelidir

  Scenario: Ziyaretçi tüm kurallara uygun şekilde başarılı bir kayıt gerçekleştirir
    Given Kullanıcı Kayıt sayfasındadır
    When Geçerli ve sistemde kayıtlı olmayan bir e-posta adresi girer
    And Kurallara uygun en az 8 karakterli eşleşen şifreler girer
    And Kullanım Şartları Gizlilik Politikası sözleşme onay kutucuğunu işaretler
    And Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcı sisteme yönlendirilmelidir