Feature: Silinen Hesapla Yeniden Kayıt ve Welcome Credit Kontrolü
  Kullanıcıların kayıt süreçlerini, hesap silme durumlarını ve hoş geldin kredisi 
  kurallarının doğru çalışıp çalışmadığını test eder.

  @Pozitif @BR-01 @Test-A
  Scenario: Yepyeni bir kullanıcının sisteme ilk kez kaydolması ve hoş geldin kredisi alması
    Given Kullanıcı AIStager sisteminde daha önce hiç kayıt olmamış "yeni_kullanici@mail.com" adresine sahiptir
    When Kullanıcı kayıt formunu doldurarak "yeni_kullanici@mail.com" ile kayıt olur
    And E-posta doğrulama adımını başarıyla tamamlar ve sisteme giriş yapar
    Then Kayıt işlemi başarılı olmalıdır
    And Kullanıcının başlangıç kredi bakiyesi 2 olmalıdır

  @Pozitif @BR-02 @BR-03 @Test-B
  Scenario: Hesabını silmiş bir kullanıcının aynı e-posta ile yeniden kaydolması ve kredi alamaması
    Given "silinmis_kullanici@mail.com" adresine sahip bir kullanıcı daha önceden kayıt olup hesabını silmiştir
    When Kullanıcı aynı "silinmis_kullanici@mail.com" adresini kullanarak yeniden kayıt olur
    And E-posta doğrulama adımını tamamlar ve sisteme giriş yapar
    Then Kayıt işlemi başarıyla tamamlanmalı ve herhangi bir engelleme veya hata mesajı gösterilmemelidir
    And Kullanıcının başlangıç kredi bakiyesi 0 olmalıdır

  @ScenarioOutline @EdgeCase @BR-03 @Negatif
  Scenario Outline: Silinmiş bir hesabın farklı silme yöntemleri veya varyasyonları ile yeniden kaydı
    Given "<eposta>" adresine sahip kullanıcı hesabı "<silme_tipi>" yöntemiyle silinmiştir
    When Kullanıcı "<giris_epostasi>" adresini kullanarak tekrar kayıt olur
    And E-posta doğrulama sürecini tamamlar ve sisteme giriş yapar
    Then Kayıt işlemi başarılı olmalıdır
    And Kullanıcının başlangıç kredi bakiyesi 0 olmalıdır

    Examples:
      | eposta                   | silme_tipi           | giris_epostasi           |
      | ornek@mail.com           | normal               | Ornek@Mail.COM           |
      | soft_delete@mail.com     | soft-delete          | soft_delete@mail.com     |
      | hard_delete@mail.com     | hard-delete          | hard_delete@mail.com     |