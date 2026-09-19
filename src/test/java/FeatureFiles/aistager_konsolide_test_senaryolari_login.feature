Feature: Ana Sayfa Etkileşimleri ve Navigasyon
  Kullanıcıların ana sayfadaki bileşenlerle (Slider, Header, Galeri, SSS ve Footer) 
  sorunsuz bir şekilde etkileşime girebilmesini sağlamak.

  Background:
    Given Kullanıcı ana sayfadayım ("/")

  Scenario: AC1 - Kullanıcı "Önce" ve "Sonra" görsellerini slider ile inceleyebilmeli
    When Kullanıcı "Öncesi ve sonrası sihri" görselinin ortasındaki iki yönlü oku sağa ve sola sürükler
    Then Oda içerisindeki "Önce" (boş oda) ve "Sonra" (mobilyalı oda) durumları pürüzsüz bir şekilde görünmelidir

  Scenario: AC1 - Kullanıcı yön okları ve carousel noktaları ile odalar arası geçiş yapabilmeli
    When Kullanıcı alt carousel üzerindeki farklı nokta ikonlarına tıklar
    Then Slider görseli ilgili odanın "Önce ve Sonra" versiyonuna güncellenmelidir

  Scenario: AC2 - Ziyaretçi konumundaki kullanıcı header menülerini doğru görmeli
    Given Kullanıcı henüz oturum açmamış bir ziyaretçidir
    Then Header alanında "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Header alanında "Üretimlerim" menüsü ve profil ikonu görünmemelidir

  Scenario: AC2 - Oturum açmış kullanıcı header menülerini doğru görmeli
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    Then Header alanında "Üretimlerim" menüsü, hızlı render paneli ve profil ikonu aktif olarak görünmelidir

  Scenario: AC2 - Ana sayfa ana menü yönlendirmeleri
    When Kullanıcı Header üzerindeki "Ürünler", "Çözümler", "Kaynaklar" veya "Fiyatlandırma" menülerine tıklar
    Then Kullanıcı ilgili alt sayfaya veya akışa yönlendirilmelidir

  Scenario: AC3 - Oda tiplerine göre filtreleme yapabilme
    When Kullanıcı topluluk galerisinde "Oturma Odası" filtre seçeneğine tıklar
    Then Galeri sadece "Oturma Odası" tipindeki tasarımları listelemelidir

  Scenario: AC3 - Topluluk üyelerinin profillerine gitme ve beğenme
    When Kullanıcı herhangi bir tasarım kartı üzerindeki profil adına tıklar
    Then İlgili topluluk üyesinin profil sayfasına yönlendirilmelidir
    And Kullanıcı kart üzerindeki kalp ikonuna tıklar
    Then Tasarımın beğeni sayısı 1 artmalıdır ve kalp ikonu aktif (dolu) hale gelmelidir

  Scenario: AC3 - Sonsuz kaydırma (Infinite Scroll) deneyimi
    When Kullanıcı galeri sayfasının en altına kadar kaydırır
    And "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Sayfa yenilenmeden yeni tasarım kartları listeye yüklenmelidir

  Scenario: AC4 - SSS alanında aynı anda sadece tek bir akordeon başlığı açık kalabilmeli
    When Kullanıcı SSS alanından birinci soruya tıklar ve akordeon açılır
    And Kullanıcı ikinci bir soruya tıklar
    Then İkinci sorunun akordeonu açılmalı ve birinci sorunun akordeonu otomatik olarak kapanmalıdır

  Scenario: AC5 - Geçerli e-posta ile bültene abone olma (Pozitif)
    When Kullanıcı bülten alanına geçerli bir "ornek@email.com" adresi girer
    And "Abone Ol" butonuna tıklar
    Then Başarılı abonelik mesajı ekranda gösterilmelidir

  Scenario: AC5 - Geçersiz e-posta ile bültene abone olma denemesi (Negatif)
    When Kullanıcı bülten alanına geçersiz bir "gecersiz-email" formatı girer
    And "Abone Ol" butonuna tıklar
    Then E-posta format hatası mesajı gösterilmelidir

  Scenario: AC5 - Footer linkleri ve sosyal medya ikonları yönlendirmesi
    When Kullanıcı footer alanındaki bir dış sosyal medya ikonuna tıklar
    Then İlgili sosyal medya sayfası tarayıcıda yeni bir sekmede açılmalıdır

Feature: Kullanıcı Girişi (Login)
  Kullanıcıların e-posta/şifre veya Google OAuth ile güvenli bir şekilde 
  sisteme giriş yapabilmesini sağlamak.

  Background:
    Given Kullanıcı giriş sayfasındadır ("/login")

  Scenario: Geçerli kimlik bilgileri ile başarıyla giriş yapma
    When Kullanıcı e-posta alanına "gecerli.kullanici@ornek.com" girer
    And Kullanıcı şifre alanına "GuvenliSifre123!" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then Kullanıcı ana panele ("/dashboard") yönlendirilmelidir

  Scenario Outline: Zorunlu alanların boş bırakılması
    When Kullanıcı e-posta alanına "<eposta>" girer
    And Kullanıcı şifre alanına "<sifre>" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then "Bu alan zorunludur" hata mesajı gösterilmelidir

    Examples:
      | eposta                     | sifre            |
      |                            | GuvenliSifre123! |
      | gecerli.kullanici@ornek.com|                  |
      |                            |                  |

  Scenario Outline: E-posta alanına yanlış formatta veri girilmesi
    When Kullanıcı e-posta alanına "<hatali_eposta>" girer
    And Kullanıcı şifre alanına "GuvenliSifre123!" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem anlık e-posta validasyon hatası vermelidir

    Examples:
      | hatali_eposta     |
      | eksikdomain@      |
      | @domainsiz.com    |
      | bosluk birakilmis |

  Scenario Outline: Kayıtlı olmayan e-posta veya yanlış şifre durumunda genel hata mesajı
    When Kullanıcı e-posta alanına "<eposta>" girer
    And Kullanıcı şifre alanına "<sifre>" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem genel olarak "E-posta veya şifre hatalı" mesajı döndürmelidir
    And Kullanıcıya e-postanın sistemde kayıtlı olup olmadığını belli eden ek bir ipucu verilmemelidir

    Examples:
      | eposta                     | sifre           |
      | kayitliolmayan@ornek.com   | YanlisSifre123! |
      | gecerli.kullanici@ornek.com| YanlisSifre123! |

  Scenario: Şifre alanındaki maskelemenin açılıp kapanması
    When Kullanıcı şifre alanına "GizliSifre1" yazar
    Then Şifre karakterleri maskelenmiş olarak görünmelidir
    When Kullanıcı şifre alanının yanındaki "Göz" ikonuna tıklar
    Then Şifre karakterleri düz metin olarak görünmelidir
    When Kullanıcı "Göz" ikonuna tekrar tıklar
    Then Şifre karakterleri tekrar maskelenmelidir

  Scenario: SQL Injection ve zararlı karakter denemeleri
    When Kullanıcı e-posta alanına "'OR '1'='1" girer
    And Kullanıcı şifre alanına "<script>alert('XSS')</script>" girer
    And Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem 500 hatası almamalı ve isteği güvenle reddederek "E-posta veya şifre hatalı" mesajı dönmelidir

  Scenario: Google OAuth ile giriş akışını tetikleme
    When Kullanıcı "Google ile devam et" butonuna tıklar
    Then Harici Google kimlik doğrulama penceresi açılmalıdır

  Scenario Outline: Giriş sayfasından diğer auth sayfalarına geçiş
    When Kullanıcı "<link_adi>" linkine tıklar
    Then Kullanıcı ilgili "<sayfa_yolu>" sayfasına yönlendirilmelidir

    Examples:
      | link_adi        | sayfa_yolu       |
      | Şifremi unuttum | /forgot-password |
      | Kayıt ol        | /register        |

Feature: Yeni Kullanıcı Kaydı (Registration)
  Yeni kullanıcıların kurallara uygun şekilde sisteme kayıt olabilmesini sağlamak.

  Background:
    Given Kullanıcı kayıt sayfasındadır ("/register")

  Scenario: Tüm kurallara uygun bilgilerle başarılı kayıt oluşturma
    When Kullanıcı e-posta alanına "yeni.kullanici@ornek.com" girer
    And Kullanıcı şifre alanına "GuvenliSifre1!" girer
    And Kullanıcı şifreyi onayla alanına "GuvenliSifre1!" girer
    And Kullanıcı yasal sözleşme onay kutucuğunu işaretler
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then Kullanıcı sisteme kaydedilmeli ve aktivasyon veya ana panel ekranına yönlendirilmelidir

  Scenario Outline: 8 karakterden kısa şifre girilmesi
    When Kullanıcı e-posta alanına "test@ornek.com" girer
    And Kullanıcı şifre alanına "<kisa_sifre>" girer
    And Kullanıcı şifreyi onayla alanına "<kisa_sifre>" girer
    And Kullanıcı sözleşme kutucuğunu işaretler
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then Şifrenin en az 8 karakter olması gerektiğine dair hata mesajı alınmalıdır

    Examples:
      | kisa_sifre |
      | Abc1!      |
      | Guv1!      |

  Scenario: 8 karakter şifre girilmesi
    When Kullanıcı e-posta alanına "test@ornek.com" girer
    And Kullanıcı şifre alanına "Guv1!abc" girer
    And Kullanıcı şifreyi onayla alanına "Guv1!abc" girer
    And Kullanıcı sözleşme kutucuğunu işaretler
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then Şifre uzunluğu kuralı geçerli sayılmalıdır

  Scenario: "Şifre" ve "Şifreyi Onayla" alanlarının uyuşmaması
    When Kullanıcı şifre alanına "GuvenliSifre1!" girer
    And Kullanıcı şifreyi onayla alanına "FarkliSifre2@" girer
    And Kullanıcı sözleşme kutucuğunu işaretler
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then "Şifreler eşleşmiyor" hata mesajı gösterilmelidir

  Scenario: Sistemde kayıtlı bir e-posta adresiyle tekrar kayıt olma denemesi
    When Kullanıcı e-posta alanına "kayitli.kullanici@ornek.com" girer
    And Kullanıcı şifre alanına "GuvenliSifre1!" girer
    And Kullanıcı şifreyi onayla alanına "GuvenliSifre1!" girer
    And Kullanıcı sözleşme kutucuğunu işaretler
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then "Bu e-posta adresi zaten kullanımda" uyarısı verilmelidir

  Scenario: Sözleşme kutucuğu işaretlenmeden kayıt olma denemesi
    When Kullanıcı tüm alanları kurallara uygun doldurur ancak yasal sözleşme kutucuğunu işaretlemez
    And Kullanıcı "Hesap Oluştur" butonuna tıklar
    Then Zorunlu sözleşme onay hata mesajı tetiklenmelidir

  Scenario: Google ile hızlı kayıt olma akışı
    When Kullanıcı kayıt sayfasındaki "Google ile kayıt ol" butonuna tıklar
    Then Harici Google kimlik doğrulama penceresi sorunsuz bir şekilde tetiklenmelidir

  Scenario: Kayıt formunda zorunlu alanların boş bırakılması
    When Kullanıcı formu hiç doldurmadan "Hesap Oluştur" butonuna tıklar
    Then İlgili tüm zorunlu alanlar için "Bu alan zorunludur" uyarıları gösterilmelidir