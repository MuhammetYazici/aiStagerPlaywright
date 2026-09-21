Feature: AiStager.ai Temel Modüller ve Kimlik Doğrulama Akışları

  Background:
    Given Kullanıcı ana sayfadadır

  @smoke @positive
  Scenario: Ziyaretçi kullanıcının üst menü görünümü
    Given Kullanıcı giriş yapmamış ziyaretçi durumundadır
    When Kullanıcı https://aistager.ai/tr adresine gider
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünmelidir
    And Üst menüde profil ikonu ve Üretimlerim alanı görünmemelidir

  @positive
  Scenario: Giriş yapmış kullanıcının üst menü görünümü
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı ana sayfaya döner
    Then Üst menüde profil ikonu ve Üretimlerim alanı görünmelidir
    And Giriş Yap ve Ücretsiz Dene butonları görünmemelidir

  @positive
  Scenario: Öncesi ve Sonrası Sihri slider bileşeninin çalışması
    Given Kullanıcı https://aistager.ai/tr adresindedir
    When Kullanıcı Öncesi ve Sonrası Sihri slider alanını sağa ve sola kaydırır
    Then Görseller pürüzsüz bir şekilde değişmelidir
    When Kullanıcı alt ok veya nokta simgelerine tıklar
    Then İlgili görsel geçişi gerçekleşmelidir
    When Kullanıcı Odanızı Yükleyin butonuna tıklar
    Then İlgili yükleme veya yönlendirme sayfasına gitmelidir

  @positive
  Scenario: Galeri alanında oda tipi filtreleme ve daha fazla yükleme
    Given Kullanıcı https://aistager.ai/tr galeri alanındadır
    When Kullanıcı Oturma Odası oda tipini seçer
    Then Sadece Oturma Odası kategorisine ait tasarımlar listelenmelidir
    When Kullanıcı Daha Fazla Tasarım Yükle butonuna tıklar
    Then Seçilen Oturma Odası filtresi korunarak yeni tasarım kartları yüklenmeye devam etmelidir

  @positive
  Scenario: Sıkça Sorulan Sorular FAQ akordeon davranışı
    Given Kullanıcı ana sayfanın SSS FAQ alanındadır
    When Kullanıcı bir soru başlığına tıklar
    Then İlgili sorunun cevabı açılmalıdır
    When Kullanıcı farklı bir soru başlığına tıklar
    Then Yeni sorunun cevabı açılmalı ve önceki açık olan soru otomatik olarak kapanmalıdır

  @positive @smoke
  Scenario: Bültene geçerli e-posta ile başarıyla abone olma
    Given Kullanıcı ana sayfanın footer bülten alanındadır
    When Kullanıcı bülten e-posta alanına geçerli bir "kullanici@example.com" adresi girer
    And Abone Ol butonuna tıklar
    Then Başarıyla abone oldunuz başarı mesajı ekranda görünmelidir

  @negative @edge-case
  Scenario Outline: Bültene geçersiz veya boş e-posta ile abone olma denemesi
    Given Kullanıcı ana sayfanın footer bülten alanındadır
    When Kullanıcı bülten e-posta alanına "<gecersiz_email>" girer
    And Abone Ol butonuna tıklar
    Then Bülten alanında uygun bir validasyon hata mesajı alınmalıdır

    Examples:
      | gecersiz_email    |
      | boş bırakıldı     |
      | gecersizemail.com |
      | test@.com         |
      | @domain.com       |

  @positive @smoke
  Scenario: Kayıtlı kullanıcı ile başarılı giriş yapma
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı geçerli bir e-posta adresi girer
    And Kullanıcı geçerli şifresini girer
    And Giriş Yap butonuna tıklar
    Then Kullanıcı başarılı şekilde panele yönlendirilmelidir

  @negative
  Scenario Outline: Boş bırakılan zorunlu alanlar ile giriş yapma denemesi
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına "<email>" girer
    And Kullanıcı şifre alanına "<sifre>" girer
    And Giriş Yap butonuna tıklar
    Then Bu alan zorunludur hata mesajı ilgili alanın altında görünmelidir

    Examples:
      | email            | sifre           |
      | boş bırakıldı    | ValidPass123!   |
      | test@example.com | boş bırakıldı   |
      | boş bırakıldı    | boş bırakıldı   |

  @security @negative
  Scenario Outline: Hatalı kimlik bilgileri veya kayıtlı olmayan e-posta ile giriş denemesi User Enumeration Koruması
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına "<email>" girer
    And Kullanıcı şifre alanına "<sifre>" girer
    And Giriş Yap butonuna tıklar
    Then E-posta veya şifre hatalı genel hata mesajı görüntülenmelidir
    And Sistem arka planda e-posta adresinin kayıtlı olup olmadığını açık etmemelidir

    Examples:
      | email                 | sifre          |
      | kayitli@example.com   | YanlisSifre123 |
      | kayitliolsun@ornek.co | DogruSifre123! |

  @security @negative
  Scenario: Login formunda SQL Enjeksiyonu denemelerinin engellenmesi
    Given Kullanıcı /login sayfasındadır
    When Kullanıcı e-posta alanına ' OR '1'='1 girer
    And Kullanıcı şifre alanına ' OR '1'='1 girer
    And Giriş Yap butonuna tıklar
    Then Sistem SQL enjeksiyonunu engellemeli ve E-posta veya şifre hatalı veya validasyon hatası döndürmelidir
    And Kullanıcı panele giriş yapamamalıdır

  @positive @smoke
  Scenario: Yeni ve geçerli bilgilerle başarılı kayıt olma
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı sistemde benzersiz olan geçerli bir e-posta adresi girer
    And Kullanıcı kurallara uygun en az 8 karakter içeren bir şifre girer
    And Kullanıcı şifresini Şifreyi Onayla alanına aynı şekilde tekrar girer
    And Kullanıcı kullanıcı sözleşmesini onaylar
    And Kayıt Ol butonuna tıklar
    Then Hesap başarıyla oluşturulmalı ve kullanıcı aktivasyon veya panele yönlendirilmelidir

  @negative @edge-case
  Scenario Outline: Zaten kayıtlı e-posta adresi ile kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı sistemde halihazırda kayıtlı olan bir e-posta adresi girer
    And Kullanıcı kurallara uygun şifre ve eşleşen onay şifresini girer
    And Kullanıcı sözleşmeyi onaylar
    And Kayıt Ol butonuna tıklar
    Then İşlem engellenmeli ve Bu e-posta adresi zaten kullanımda hata mesajı gösterilmelidir

    Examples:
      | email                |
      | varolanuser@test.com |

  @negative @edge-case
  Scenario Outline: Şifre kurallarına uymayan veya eşleşmeyen şifreler ile kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı benzersiz bir e-posta girer
    And Kullanıcı şifre alanına "<sifre>" girer
    And Kullanıcı şifre onayla alanına "<sifre_tekrar>" girer
    And Kullanıcı sözleşmeyi onaylar
    And Kayıt Ol butonuna tıklar
    Then İşlem engellenmeli ve ilgili hata mesajı gösterilmelidir

    Examples:
      | sifre      | sifre_tekrar |
      | Ab1!       | Ab1!         |
      | ValidPass1 | OtherPass2   |

  @negative
  Scenario: Kullanıcı sözleşmesi onaylanmadan kayıt denemesi
    Given Kullanıcı /register sayfasındadır
    When Kullanıcı benzersiz geçerli bir e-posta girer
    And Kullanıcı kurallara uygun şifre ve eşleşen onay şifresini girer
    And Kullanıcı kullanıcı sözleşmesini ONAYLAMAZ
    And Kayıt Ol butonuna tıklar
    Then İşlem engellenmeli ve sözleşmenin onaylanması gerektiğine dair uyarı mesajı gösterilmelidir