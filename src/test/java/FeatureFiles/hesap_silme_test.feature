Feature: Silinen Hesapla Yeniden Kayıt ve Kredi Hak Ediş Kontrolü
  Kullanıcı olarak, hesabımı sildikten sonra aynı e-posta ile yeniden kayıt olmak istiyorum,
  ancak sistemin daha önce bu e-posta ile kredi aldığını tespit ederek yeni hesaba 
  "Welcome Credit" (Hoş Geldin Kredisi) tanımlamamasını test ediyorum.

  Background:
    Given kullanıcı kayıt sayfasında bulunur

  @Pozitif @BR-02
  Scenario: Yeni kullanıcının kayıt ve hoş geldin kredisi hak edişi
    Given sistemde daha önce hiç kayıt olmamış "yeni.kullanici@mail.com" e-posta adresi vardır
    When kullanıcı "yeni.kullanici@mail.com" adresi ile yeni bir kayıt oluşturur
    And e-posta doğrulama adımı tamamlanır
    And kullanıcı sisteme giriş yapar
    Then kayıt işlemi başarılı olmalı
    And kullanıcı kredi bakiyesinin "2" olduğunu görmelidir

  @Pozitif @EdgeCase @BR-01 @BR-03
  Scenario: Silinmiş hesapla yeniden kayıt ve mükerrer kredi engeli
    Given daha önce açılıp "Hesabı Sil" özelliği ile silinmiş "silinmis.kullanici@mail.com" e-posta adresi vardır
    When kullanıcı silinmiş olan "silinmis.kullanici@mail.com" adresi ile yeniden kayıt oluşturur
    And e-posta doğrulama adımı tamamlanır
    And kullanıcı sisteme giriş yapar
    Then kayıt işlemi herhangi bir hata almadan başarılı olmalı
    And kullanıcı kredi bakiyesinin "0" olduğunu görmelidir

  @EdgeCase @BR-04
  Scenario Outline: E-posta büyük ve küçük harf normalizasyon kontrolü
    Given daha önce silinmiş olan "<orijinal_eposta>" e-posta adresi vardır
    When kullanıcı bu e-postanın farklı bir varyasyonu olan "<farkli_kasa_eposta>" ile yeniden kayıt oluşturur
    And e-posta doğrulama adımı tamamlanır
    And kullanıcı sisteme giriş yapar
    Then kayıt işlemi başarılı olmalı
    And kullanıcı kredi bakiyesinin "0" olduğunu görmelidir

    Examples:
      | orijinal_eposta      | farkli_kasa_eposta   |
      | ornek@mail.com       | Ornek@Mail.COM       |
      | test.user@domain.com | TEST.USER@DOMAIN.COM |
      | kucuk@harf.com       | KUCUK@harf.com       |