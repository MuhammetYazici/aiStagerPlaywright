Feature: AiStager.ai Ana Sayfa ve Kimlik Doğrulama Modülleri

Background:
  Given Kullanıcı AiStager platformundadır

@positive @home @slider
Scenario: Kullanıcı Önce ve Sonra görsellerini slider ile değiştirebilmelidir
  Given Kullanıcı AiStager.ai ana sayfasındadır
  When Kullanıcı karşılaştırma slider okunu sağa ve sola sürüklerse
  Then Önce boş oda ve Sonra mobilyalı oda görselleri orantılı ve pürüzsüz bir şekilde değişmelidir

@positive @home @carousel
Scenario: Carousel noktalarına veya yön oklarına tıklayarak ilgili oda görsellerini yükleme
  Given Kullanıcı AiStager.ai ana sayfasındadır
  When Kullanıcı carousel üzerindeki ikinci nokta veya yön okuna tıklarsa
  Then İlgili oda görselleri yüklenmeli ve aktif nokta görsel olarak vurgulanmalıdır

@positive @header @visitor
Scenario: Oturum açmamış ziyaretçi için header menü öğelerinin görüntülenmesi
  Given Ziyaretçi oturum açmamış durumdadır ve ana sayfadadır
  Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
  And Üretimlerim ve profil ikonu gizli olmalıdır

@positive @header @logged_in
Scenario: Oturum açmış kullanıcı için header menü öğelerinin görüntülenmesi
  Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
  Then Header alanında logo, ürünler dropdown, çözümler, kaynaklar, fiyatlandırma görünmelidir
  And Üretimlerim, hızlı render paneli ve profil menüsü erişilebilir olmalıdır

@positive @header @language
Scenario: Dil değiştirme menüsünün çalışması ve arayüzün güncellenmesi
  Given Kullanıcı AiStager.ai ana sayfasındadır
  When Kullanıcı TR dil seçeneğine tıklarsa
  Then Dil menüsü açılmalı ve seçilen dile göre arayüz metinleri güncellenmelidir

@positive @gallery
Scenario: Sayfa ilk açıldığında varsayılan filtrelerin kontrolü
  Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
  Then Tüm Tipler filtresi varsayılan olarak aktif olmalıdır

@positive @gallery
Scenario: Oda tipi filtrelerine tıklayarak galeri kartlarını listeleme
  Given Kullanıcı ana sayfadaki topluluk galerisi alanındadır
  When Kullanıcı Oturma Odası filtre seçeneğine tıklarsa
  Then Galeri sadece Oturma Odası filtreli kartları listelemelidir

@positive @gallery @pagination
Scenario: Daha fazla tasarım yükleme butonunun çalışması
  Given Kullanıcı galeridedir ve mevcut kartlar listelenmektedir
  When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklarsa
  Then Mevcut aktif filtre bozulmadan yeni kartlar listeye eklenmelidir

@positive @gallery @interaction
Scenario: Kullanıcı profiline ve beğeni butonuna tıklama
  Given Kullanıcı galerideki bir tasarım kartını incelemektedir
  When Kullanıcı tasarımın sahibi olan kullanıcı adını tıklarsa
  And Kullanıcı kart üzerindeki kalp ikonuna tıklarsa
  Then İlgili kullanıcı profil sayfasına yönlendirilmeli
  And Beğeni sayısı 1 artarak kalp ikonu aktif beğenildi hale gelmelidir

@positive @faq
Scenario: Sık sorulan sorular akordeon yapısının çalışması
  Given Kullanıcı ana sayfadaki FAQ Sık Sorulan Sorular bölümündedir
  When Kullanıcı birinci soru başlığına tıklarsa
  Then İlgili cevap alanı açılmalıdır
  When Kullanıcı ikinci soru başlığına tıklarsa
  Then İkinci sorunun cevabı açılmalı ve birinci sorunun cevabı otomatik olarak kapanmalıdır

@positive @newsletter
Scenario: Geçerli e-posta ile bülten aboneliği yapma
  Given Kullanıcı ana sayfanın footer bölümündedir
  When Kullanıcı bülten alanına geçerli bir "test@example.com" e-posta adresi girer ve gönder butonuna tıklar
  Then Bülten aboneliği başarılı mesajı gösterilmelidir

@negative @newsletter @edge_case
Scenario Outline: Geçersiz veya boş e-posta ile bülten aboneliği denemesi
  Given Kullanıcı ana sayfanın footer bölümündedir
  When Kullanıcı bülten alanına "<gecersiz_eposta>" girer ve gönder butonuna tıklar
  Then Uyarı veya hata mesajı gösterilmelidir

  Examples:
    | gecersiz_eposta |
    |                 |
    | invalid-email   |
    | test@.com       |

@positive @footer
Scenario: Footer yasal bağlantılar ve sosyal medya ikonlarının yönlendirmesi
  Given Kullanıcı ana sayfanın footer bölümündedir
  When Kullanıcı sosyal medya ikonlarından birine tıklarsa
  Then İlgili sosyal medya sayfası yeni sekmede new tab açılmalıdır
  When Kullanıcı yasal bağlantılara Gizlilik Politikası vb tıklarsa
  Then İlgili sayfaya yönlendirilmelidir

@positive @auth @login
Scenario: Geçerli kimlik bilgileri ile başarılı giriş yapma
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı geçerli bir e-posta "kullanici@example.com" ve şifre "ValidPass123!" girer
  And Kullanıcı Giriş Yap butonuna tıklar
  Then Kullanıcı başarıyla ana panele dashboard yönlendirilmelidir

@positive @auth @login @ui
Scenario: Şifre alanındaki Göz ikonunun çalışması
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı şifre alanına "SecretPass1" yazar
  And Kullanıcı şifre alanındaki Göz ikonuna tıklar
  Then Şifre karakterleri maskesiz görünür hale gelmelidir

@positive @auth @login @navigation
Scenario: Şifremi unuttum ve kayıt ol linklerinin yönlendirmesi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı "Şifremi unuttum?" linkine tıklarsa "Şifre Sıfırlama" sayfasına yönlendirilmelidir
  And Kullanıcı Kayıt ol linkine tıklarsa Kayıt Ol sayfasına yönlendirilmelidir

@positive @auth @login @oauth
Scenario: Google ile devam et butonunun tetiklenmesi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı Google ile devam et butonuna tıklar
  Then Google OAuth kimlik doğrulama penceresi açılmalıdır

@negative @auth @login @validation
Scenario Outline: Boş alan bırakıldığında zorunlu alan uyarısının verilmesi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı e-posta alanına "<eposta>" ve şifre alanına "<sifre>" girer
  And Kullanıcı Giriş Yap butonuna tıklar
  Then Bu alan zorunludur uyarı mesajı gösterilmelidir

  Examples:
    | eposta               | sifre         |
    |                      | ValidPass123! |
    | kullanici@example.com|               |
    |                      |               |

@negative @auth @login @validation
Scenario: Geçersiz e-posta formatı ile giriş denemesi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı e-posta alanına "hatali-format" ve şifre alanına "ValidPass123!" girer
  And Kullanıcı Giriş Yap butonuna tıklar
  Then Lütfen geçerli bir e-posta adresi girin uyarısı gösterilmelidir

@negative @auth @login @security
Scenario Outline: Hatalı şifre veya kayıtlı olmayan e-posta ile giriş denemesi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı e-posta alanına "<eposta>" ve şifre alanına "<sifre>" girer
  And Kullanıcı Giriş Yap butonuna tıklar
  Then E-posta veya şifre hatalı genel güvenlik mesajı gösterilmelidir

  Examples:
    | eposta                 | sifre          |
    | kayitli@example.com    | YanlisSifre1!  |
    | kayitliolmayan@test.com| ValidPass123!  |

@edge_case @auth @login @security
Scenario: SQL Injection veya zararlı karakter girdilerine karşı güvenlik testi
  Given Kullanıcı Giriş Yap sayfasındadır
  When Kullanıcı e-posta alanına "'OR '1'='1" ve şifre alanına "'OR '1'='1" girer
  And Kullanıcı Giriş Yap butonuna tıklar
  Then Sistem 500 hatası vermemeli, isteği reddetmeli ve E-posta veya şifre hatalı mesajı döndürmelidir

@positive @auth @register
Scenario: Yeni kullanıcı kuralına uygun bilgilerle başarıyla kayıt olabilmelidir
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı sistemde kayıtlı olmayan bir "yeni_kullanici@example.com" e-posta adresi girer
  And Kullanıcı kurallara uygun min. 8 karakter bir şifre "StrongPass1!" girer
  And Kullanıcı kullanıcı sözleşmesi onay kutucuğunu işaretler
  And Kullanıcı Kayıt Ol butonuna tıklar
  Then Kullanıcı başarıyla kaydedilmeli ve aktivasyon veya ana panel ekranına yönlendirilmelidir

@positive @auth @register @ui
Scenario: Kayıt formundaki şifre alanlarında göz ikonunun çalışması
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı şifre ve şifreyi onayla alanlarına "TestPass1!" yazar
  And Kullanıcı şifre alanındaki Göz ikonuna tıklar
  Then Şifre görünür hale gelmelidir

@positive @auth @register @navigation
Scenario: Kayıt sayfasından giriş sayfasına ve Google ile kayda yönlendirme
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı Giriş yap bağlantısına tıklarsa Giriş Yap sayfasına yönlendirilmelidir
  And Kullanıcı Google ile devam et butonuna tıklarsa Google OAuth kayıt penceresi açılmalıdır

@negative @auth @register @validation
Scenario: Eksik alan bırakıldığında zorunlu alan uyarısı verilmesi
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı tüm alanları boş bırakarak Kayıt Ol butonuna tıklar
  Then Bu alan zorunludur uyarı mesajı gösterilmelidir

@negative @auth @register @validation
Scenario: Hatalı e-posta formatı ile kayıt denemesi
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı e-posta alanına "yanlisformat.com" girer ve diğer alanları geçerli doldurur
  And Kullanıcı Kayıt Ol butonuna tıklar
  Then E-posta formatı için validasyon uyarısı gösterilmelidir

@negative @auth @register @business_rule
Scenario: Sistemde halihazırda var olan bir e-posta ile kayıt denemesi
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı sistemde kayıtlı olan "varolan@example.com" e-postasını girer
  And Geçerli şifre ve sözleşme onayını tamamlayıp Kayıt Ol butonuna tıklar
  Then Bu e-posta adresi zaten kullanımda hatası alınmalıdır

@negative @auth @register @edge_case
Scenario: Minimum karakter sınırının altında şifre girilmesi
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı şifre alanına 8 karakterden az olan "Abc1!" şifresini girer
  And Kullanıcı Kayıt Ol butonuna tıklar
  Then Şifrenin en az 8 karakter olması gerektiğine dair minimum uzunluk kuralı hatası tetiklenmelidir

@negative @auth @register @validation
Scenario: Şifre ve Şifreyi Onayla alanlarının uyuşmaması
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı şifre alanına "Password123!" ve şifreyi onayla alanına "DifferentPass123!" girer
  And Kullanıcı Kayıt Ol butonuna tıklar
  Then "Şifreler eşleşmiyor" uyarısı verilmelidir

@negative @auth @register @business_rule
Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt denemesi
  Given Kullanıcı Kayıt Ol sayfasındadır
  When Kullanıcı geçerli e-posta ve şifre girer ancak kullanıcı sözleşmesi kutucuğunu işaretlemez
  And Kullanıcı Kayıt Ol butonuna tıklar
  Then Sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir ve kayıt engellenmelidir