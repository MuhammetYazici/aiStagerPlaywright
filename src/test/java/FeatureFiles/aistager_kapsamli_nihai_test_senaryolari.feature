İstediğiniz eksik adımlar, ilgili senaryolara en mantıklı ve doğru yerlerine, belirttiğiniz kurallara ve birebir aynı metinlerle eklenmiştir. Mevcut hiçbir adım silinmemiş veya değiştirilmemiştir.

İşte senaryonun TAM ve eksiksiz hali:

```gherkin
Feature: AiStager.ai Ana Sayfa, Kimlik Doğrulama ve Navigasyon Yönetimi

  Background:
    Given Kullanıcı AiStager platformundadır

  @positive @newsletter
  Scenario Outline: Kullanıcı geçerli bir e-posta adresi ile bültene başarılı bir şekilde abone olabilmelidir
    Given Kullanıcı AiStager.ai ana sayfadaki bülten bölümüne gelir
    When Bülten e-posta alanına "<gecerli_eposta>" adresi girilir
    And "Abone Ol" butonuna tıklanmalıdır
    And Abone Ol butonuna tıklanır
    Then Başarılı abonelik mesajı görüntülenmelidir

    Examples:
      | gecerli_eposta |
      | test@example.com |
      | user.name+tag@sub.domain.co.uk |

  @negative @newsletter
  Scenario Outline: Kullanıcı geçersiz veya boş e-posta adresi ile bültene abone olamamalıdır
    Given Kullanıcı AiStager.ai ana sayfadaki bülten bölümüne gelir
    When Bülten e-posta alanına "<gecersiz_eposta>" girilir
    And "Abone Ol" butonuna tıklanmalıdır
    And Abone Ol butonuna tıklanır
    Then Bülten alanında uygun bir hata veya uyarı mesajı gösterilmelidir

    Examples:
      | gecersiz_eposta |
      |                 |
      | gecersiz_email  |
      | @domain.com     |
      | test@.com       |

  @positive @login
  Scenario: Kullanıcı kayıtlı ve geçerli bilgileri ile başarılı bir şekilde giriş yapabilmelidir
    Given Kullanıcı Giriş Yap sayfasındadır
    When E-posta alanına "kayitli_kullanici@example.com" girilir
    And Şifre alanına "GecerliSifre123" girilir
    And "Giriş Yap" butonuna tıklanır
    And Giriş Yap butonuna tıklanır
    Then Kullanıcı başarılı bir şekilde oturum açarak ana sayfaya yönlendirilmelidir

  @negative @login
  Scenario Outline: Kullanıcı boş bırakılan zorunlu alanlar ile giriş yapamamalıdır
    Given Kullanıcı Giriş Yap sayfasındadır
    When E-posta alanına "<eposta>" girilir
    And Şifre alanına "<sifre>" girilir
    And "Giriş Yap" butonuna tıklanır
    And Giriş Yap butonuna tıklanır
    Then Zorunlu alanlar için Bu alan zorunludur uyarısı alınmalıdır

    Examples:
      | eposta | sifre |
      |        | GecerliSifre123 |
      | test@example.com | |
      |        |       |

  @negative @login
  Scenario: Kullanıcı geçersiz e-posta formatı ile giriş yapmaya çalıştığında validasyon uyarısı almalıdır
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When E-posta alanına "hatali-email-formati" girilir
    And Şifre alanına "GecerliSifre123" girilir
    And "Giriş Yap" butonuna tıklanır
    And Giriş Yap butonuna tıklanır
    Then E-posta formatının geçersiz olduğuna dair validasyon uyarısı gösterilmelidir

  @negative @login @security
  Scenario Outline: Hatalı şifre veya kayıtlı olmayan e-posta denemelerinde güvenlik için genel hata mesajı dönülmelidir
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When E-posta alanına "<eposta>" girilir
    And Şifre alanına "<sifre>" girilir
    And "Giriş Yap" butonuna tıklanmalıdır
    And Giriş Yap butonuna tıklanmalıdır
    Then Genel güvenlik uyarısı olarak E-posta veya şifre hatalı mesajı gösterilmelidir

    Examples:
      | eposta | sifre |
      | kayitli_kullanici@example.com | YanlisSifre999 |
      | kayitli_olmayan@example.com | GecerliSifre123 |

  @edge_case @login @security
  Scenario: Giriş formunda SQL enjeksiyon denemeleri güvenli bir şekilde filtrelenmelidir
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When E-posta alanına "' OR '1'='1" girilir
    And Şifre alanına "' OR '1'='1" girilir
    And "Giriş Yap" butonuna tıklanır
    And Giriş Yap butonuna tıklanır
    Then Sistem çökmemeli ve genel E-posta veya şifre hatalı hata mesajı gösterilmelidir

  @positive @login
  Scenario: Kullanıcı şifre alanındaki Göz ikonunu kullanarak şifreyi görünür veya maskeli yapabilmelidir
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When Şifre alanına "GizliSifre123" yazılır
    And Şifre alanındaki Göz ikonuna tıklanır
    Then Şifrenin düz metin olarak görünür olduğu doğrulanır
    When Göz ikonuna tekrar tıklanır
    Then Şifrenin maskelendiği yıldızlı veya noktalı doğrulanır

  @positive @register
  Scenario: Kullanıcı tüm kurallara uygun geçerli bilgilerle başarılı bir şekilde kayıt olabilmelidir
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When E-posta alanına "yeni_kullanici_123@example.com" girilir
    And Şifre alanına "GucluSifre1!" girilir
    And Şifreyi Onayla alanına "GucluSifre1!" girilir
    And Kullanıcı sözleşmesi onay kutusu seçilir
    And "Hesap Oluştur" butonuna tıklanır
    Then Kullanıcı başarıyla kaydedilmeli ve yönlendirme yapılmalıdır

  @negative @register @edge_case
  Scenario Outline: Kullanıcı geçersiz veya eksik kriterlerle kayıt olamamalıdır
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When E-posta alanına "<eposta>" girilir
    And Şifre alanına "<sifre>" girilir
    And Şifreyi Onayla alanına "<sifre_onay>" girilir
    And Kullanıcı sözleşmesi onay kutusu "<sozlesme_durumu>" durumunda bırakılır
    And "Hesap Oluştur" butonuna tıklanır
    Then İlgili hata mesajı kullanıcıya gösterilmelidir

    Examples:
      | eposta | sifre | sifre_onay | sozlesme_durumu | Açıklama |
      | kayitli_kullanici@example.com | GucluSifre1! | GucluSifre1! | işaretli | Halihazırda kullanımda olan e-posta |
      | yeni@example.com | kisa1! | kisa1! | işaretli | 8 karakterden kısa şifre (7 karakter) |
      | yeni@example.com | GucluSifre1! | FarkliSifre2@ | işaretli | Eşleşmeyen şifreler |
      | yeni@example.com | GucluSifre1! | GucluSifre1! | işaretsiz | Onaylanmamış kullanıcı sözleşmesi |

  @visitor @navigation
  Scenario: Ziyaretçi durumundaki kullanıcılar yalnızca izin verilen alanları ve aksiyonları görebilmelidir
    Given Kullanıcı siteye henüz giriş yapmamış bir ziyaretçidir
    When Kullanıcı AiStager.ai ana sayfasına gider
    Then Üst menüde Giriş Yap ve Ücretsiz Dene butonları görünür olmalıdır
    And Üst menüde Üretimlerim ve profil menüsünün gizli olduğu doğrulanmalıdır

  @logged_in @navigation
  Scenario: Oturum açmış kayıtlı kullanıcılar profil ve üretim sayfalarına erişebilmelidir
    Given Kullanıcı sisteme başarılı bir şekilde giriş yapmıştır
    When Kullanıcı AiStager.ai ana sayfasına gider
    Then Üst menüde profil menüsü ve Üretimlerim alanı görünür ve erişilebilir olmalıdır

  @homepage @slider
  Scenario: Öncesi ve Sonrası slider alanı pürüzsüz şekilde çalışmalıdır
    Given Kullanıcı ana sayfadaki Öncesi ve Sonrası slider bölümündedir
    When Kullanıcı slider üzerindeki iki yönlü oku sağa veya sola sürükler ya da yön oklarına tıklar
    Then Görsellerin geçişi pürüzsüz bir şekilde gerçekleşmelidir

  @homepage @localization
  Scenario: Üst menüden dil seçeneği değiştirildiğinde arayüz dili dinamik olarak güncellenmelidir
    Given Kullanıcı ana sayfadadır
    When Üst menüden dil seçeneği TR den farklı bir dile dönüştürülür
    Then Arayüz metinlerinin seçilen dile dinamik olarak güncellendiği doğrulanır

  @gallery @filtering
  Scenario: Galeri varsayılan olarak tüm tipleri listelemeli ve kategori filtreleri çalışmalıdır
    Given Kullanıcı ana sayfadaki Galeri bölümündedir
    When Sayfa ilk açıldığında Tüm Tipler filtresinin seçili olduğu görülür
    And Kullanıcı farklı bir oda tipi kategorisine tıklar
    Then Galeri yalnızca seçilen oda tipine ait tasarımları listelemelidir

  @gallery @interaction
  Scenario: Tasarım kartları Beğeni ve Daha Fazla Yükle fonksiyonlarını doğru çalıştırmalıdır
    Given Kullanıcı Galeri bölümündedir
    When Bir tasarım kartı üzerindeki Beğeni ikonuna tıklanır
    Then İlgili kartın sayaç değerinin bir arttığı görülür
    When Daha Fazla Tasarım Yükle butonuna tıklanır
    Then Mevcut filtreleme korunarak alt alta yeni tasarım kartlarının yüklendiği görülmelidir

  @faq @accordion
  Scenario: SSS akordeon yapısında bir soru açıldığında diğerleri otomatik kapanmalıdır
    Given Kullanıcı Sıkça Sorulan Sorular bölümündedir
    When Birinci soruya tıklanarak akordeon açılır
    And Kullanıcı farklı ikinci bir soruya tıklar
    Then İkinci soru açılırken birinci sorunun akordeon yapısının otomatik olarak kapandığı doğrulanmalıdır