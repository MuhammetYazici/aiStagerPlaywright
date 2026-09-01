Feature: AiStager Negatif Kimlik Doğrulama Test Senaryoları

  @negative_auth
  Scenario: TC_LOG_002_001 - Login sayfasında boş girdi ile oturum açmaya çalış
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    And The user clicks the button.
      | girisYapButton |
    Then Zorunlu alan validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_002 - Login sayfasında geçersiz e-posta formatı ile deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When On the registration page,enter a valid email and password.
      | email    | hatali_email |
      | password | Sifre123!    |
    And The user clicks the button.
      | girisYapButton |
    Then E-posta formatı validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_003 - Login sayfasında yanlış şifre ile deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When On the registration page,enter a valid email and password.
      | email    | muhammetyazici611@gmail.com |
      | password | yanlisSifre123!             |
    And The user clicks the button.
      | girisYapButton |
    Then Hatalı e-posta veya şifre hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_LOG_002_004 - Login sayfasında kayıtsız kullanıcı deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When On the registration page,enter a valid email and password.
      | email    | fakerEmail |
      | password | fakerPassword |
    And The user clicks the button.
      | girisYapButton |
    Then Kullanıcı bulunamadı hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_001 - Register sayfasında boş form ile hesap oluşturmaya çalış
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When The user clicks the register button on the login page.
      | kayit ol |
    And The user clicks the button.
      | creatAccount |
    Then Tüm zorunlu alan validasyon uyarıları görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_002 - Register sayfasında zaten kayıtlı e-posta ile deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When The user clicks the register button on the login page.
      | kayit ol |
    And On the registration page,enter a valid email and password.
      | email         | muhammetyazici611@gmail.com |
      | password      | Sifre123!.                  |
      | passwordRepeat| Sifre123!.                  |
    And The user checks the terms of acceptance box.
    And The user clicks the button.
      | creatAccount |
    Then Zaten kayıtlı e-posta hata mesajı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_003 - Register sayfasında kısa şifre ile deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When The user clicks the register button on the login page.
      | kayit ol |
    And On the registration page,enter a valid email and password.
      | email         | fakerEmail |
      | password      | Sifre1!    |
      | passwordRepeat| Sifre1!    |
    And The user checks the terms of acceptance box.
    And The user clicks the button.
      | creatAccount |
    Then Şifre politikası validasyon uyarısı görüntülenmelidir

  @negative_auth
  Scenario: TC_REG_002_004 - Register sayfasında şifre uyuşmazlığı ile deneme
    Given The user clicks the Log in button on the homepage.
      | giris Yap |
    When The user clicks the register button on the login page.
      | kayit ol |
    And On the registration page,enter a valid email and password.
      | email         | fakerEmail     |
      | password      | Sifre123!.     |
      | passwordRepeat| FarkliBirSifre |
    And The user checks the terms of acceptance box.
    And The user clicks the button.
      | creatAccount |
    Then Şifre uyuşmazlığı validasyon uyarısı görüntülenmelidir
