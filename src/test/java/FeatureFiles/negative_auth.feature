Feature: AiStager Negatif Kimlik Doğrulama Test Senaryoları

  @negative_auth
  Scenario: TC_LOG_002_001 - Login sayfasında boş girdi ile oturum açmaya çalış
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    Then Zorunlu alan validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_002 - Login sayfasında geçersiz e-posta formatı ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | email    | hatali_email |
      | password | Sifre123!    |
    Then E-posta formatı validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_003 - Login sayfasında yanlış şifre ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | email    | muhammetyazici611@gmail.com |
      | password | yanlisSifre123!             |
    Then Hatalı e-posta veya şifre hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_004 - Login sayfasında kayıtsız kullanıcı deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | email    | fakerEmail |
      | password | fakerPassword |
    Then Kullanıcı bulunamadı hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_001 - Register sayfasında boş form ile hesap oluşturmaya çalış
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıt ol butonuna tıklar
      | kayit ol |
    And Kullanıcı boş form ile "Hesap Oluştur" butonuna tıklar
    Then Tüm zorunlu alan validasyon uyarıları görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_002 - Register sayfasında zaten kayıtlı e-posta ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıt ol butonuna tıklar
      | kayit ol |
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | email         | muhammetyazici611@gmail.com |
      | password      | Sifre123!.                  |
      | passwordRepeat| Sifre123!.                  |
    And Şartları kabul etme checkbox'ını işaretle
    Then Zaten kayıtlı e-posta hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_003 - Register sayfasında kısa şifre ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıt ol butonuna tıklar
      | kayit ol |
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | email         | fakerEmail |
      | password      | Sifre1!    |
      | passwordRepeat| Sifre1!    |
    And Şartları kabul etme checkbox'ını işaretle
    Then Şifre politikası validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_004 - Register sayfasında şifre uyuşmazlığı ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı kayıt ol butonuna tıklar
      | kayit ol |
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | email         | fakerEmail     |
      | password      | Sifre123!.     |
      | passwordRepeat| FarkliBirSifre |
    And Şartları kabul etme checkbox'ını işaretle
    Then Şifre uyuşmazlığı validasyon uyarısı görüntülenmelidir
