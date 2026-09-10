Feature: AiStager Negatif Kimlik Doğrulama Test Senaryoları

  @negative_auth @Regression
  Scenario: TC_LOG_002_001 - Login sayfasında boş girdi ile oturum açmaya çalış
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    Then Zorunlu alan validasyon uyarısı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_LOG_002_002 - Login sayfasında geçersiz e-posta formatı ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | hatali_email |
      | Sifre123!    |
    Then E-posta formatı validasyon uyarısı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_LOG_002_003 - Login sayfasında yanlış şifre ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | muhammetyazici611@gmail.com |
      | yanlisSifre123!             |
    Then Hatalı e-posta veya şifre hata mesajı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_LOG_002_004 - Login sayfasında kayıtsız kullanıcı deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı aşağıdaki bilgileri girerek "Giriş Yap" butonuna tıklar
      | fakerEmail    |
      | fakerPassword |
    Then Kullanıcı bulunamadı hata mesajı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_REG_002_001 - Register sayfasında boş form ile hesap oluşturmaya çalış
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı kayıt ol butonuna tıklar
    And Kullanıcı boş form ile "Hesap Oluştur" butonuna tıklanılabilir olmamalı


  @negative_auth @Regression
  Scenario: TC_REG_002_002 - Register sayfasında zaten kayıtlı e-posta ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı kayıt ol butonuna tıklar
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | muhammetyazici611@gmail.com |
      | Sifre123!.                  |
      | Sifre123!.                  |
    And Şartları kabul etme checkbox'ını işaretle
    Then Zaten kayıtlı e-posta hata mesajı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_REG_002_003 - Register sayfasında kısa şifre ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı kayıt ol butonuna tıklar
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | fakerEmail |
      | Sifre1!    |
      | Sifre1!    |
    And Şartları kabul etme checkbox'ını işaretle
    Then Şifre politikası validasyon uyarısı görüntülenmelidir

  @negative_auth @Regression
  Scenario: TC_REG_002_004 - Register sayfasında şifre uyuşmazlığı ile deneme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı boş e-posta ve boş şifre ile "Giriş Yap" butonuna tıklar
    When Kullanıcı kayıt ol butonuna tıklar
    And Kayıt ol sayfasında aşağıdaki bilgileri girerek "Hesap Oluştur" butonuna tıklar
      | fakerEmail     |
      | Sifre123!.     |
      | FarkliBirSifre |
    And Şartları kabul etme checkbox'ını işaretle
    Then Şifre uyuşmazlığı validasyon uyarısı görüntülenmelidir
