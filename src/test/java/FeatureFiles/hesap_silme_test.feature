Feature: Silinen Hesapla Yeniden Kayıt ve Welcome Credit Kontrolü
  Kimlik doğrulama (Auth) sisteminde, yeni kullanıcıların hoş geldin kredisinden yararlanması,
  silinen hesapların tekrar kaydolabilmesi ancak kötüye kullanımın önlenmesi için
  kredi kısıtlarının ve e-posta normalizasyonunun test edilmesi.

  Background:
    Given kullanıcı kayıt ve kimlik doğrulama servisleri aktif durumdadır

  Scenario: Yepyeni bir kullanıcının sisteme ilk kez kayıt olması
    Given sistemde daha önce hiç kaydedilmemiş "yeni.kullanici@mail.com" e-posta adresi bulunmaktadır
    When kullanıcı "yeni.kullanici@mail.com" e-posta adresi ile kayıt formunu doldurur
    And e-posta doğrulama adımını başarıyla tamamlar
    And sisteme giriş yapar
    Then kayıt işlemi başarıyla tamamlanmalıdır
    And kullanıcının başlangıç kredi bakiyesi "2" olmalıdır (BR-01)

  Scenario: Daha önce hesabını silmiş kullanıcının aynı e-posta ile yeniden kayıt olması
    Given "silinen.kullanici@mail.com" adresine ait bir hesap geçmişte oluşturulmuş ve tamamen silinmiştir
    When kullanıcı "silinen.kullanici@mail.com" e-posta adresi ile yeniden kayıt formunu doldurur
    And kayıt sırasında herhangi bir hata veya uyarı mesajı gösterilmemelidir (BR-02)
    And e-posta doğrulama adımını başarıyla tamamlar
    And sisteme giriş yapar
    Then kayıt işlemi başarıyla tamamlanmalıdır
    And kullanıcının başlangıç kredi bakiyesi "0" olmalıdır (BR-03)

  Scenario: Silinmiş hesabın e-postasını büyük ve küçük harf kombinasyonuyla yeniden kaydetme
    Given "CaseSensitivity@Mail.COM" adresine ait bir hesap geçmişte oluşturulmuş ve silinmiştir
    When kullanıcı farklı yazım formatına sahip "casesensitivity@mail.com" e-posta adresiyle yeniden kayıt olur
    And kayıt işlemi engellenmeden başarıyla tamamlanmalıdır (BR-02)
    And e-posta doğrulama adımını tamamlar
    And sisteme giriş yapar
    Then sistem e-posta normalizasyonu uygulayarak geçmiş kaydı tanımalıdır (BR-04)
    And kullanıcının başlangıç kredi bakiyesi "0" olmalıdır (BR-03)

  Scenario: Silinen hesabın eski bakiye ve abonelik haklarının sıfırlanmış olarak gelmesi
    Given "eski.bakiye@mail.com" adresli hesabın silinmeden önce "15" kredisi bulunmaktadır
    And bu hesap kullanıcı tarafından silinmiştir
    When kullanıcı "eski.bakiye@mail.com" e-posta adresiyle sisteme tekrar kayıt olur ve doğrulamayı tamamlar
    And sisteme giriş yapar
    Then silinen hesaba ait eski bakiye, abonelik veya top-up hakları tamamen silinmiş olmalıdır (BR-03)
    And kullanıcının kredi bakiyesi sadece "0" olmalıdır

  Scenario: Aktif (silinmemiş) bir hesapla mükerrer kayıt denemesi yapılması
    Given "aktif.kullanici@mail.com" adresine ait halihazırda aktif bir hesap bulunmaktadır
    When kullanıcı aynı "aktif.kullanici@mail.com" adresi ile tekrar kayıt olmaya çalışır
    Then kayıt işlemi engellenmelidir
    And kullanıcıya e-posta adresinin kullanımda olduğuna dair uygun bir hata mesajı gösterilmelidir
    And yeni bir hesap oluşturulmamalıdır