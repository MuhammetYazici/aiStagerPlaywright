Feature: Silinen Hesapla Yeniden Kayıt ve Kredi Politikası
  Kullanıcı olarak, hesabımı sildikten sonra aynı e-posta adresimle tekrar kayıt olabilmek istiyorum,
  ancak sistem politikası gereği ücretsiz hoş geldin kredilerinin tarafıma ikinci kez tanımlanmamasını istiyorum.

  Background:
    Given sistem erişime hazırdır

  @Pozitif @BR-02
  Scenario: Yeni kullanıcının başarıyla kayıt olması ve hoş geldin kredisi alması
    Given kullanıcı "yeni_kullanici@mail.com" e-posta adresi ile AIStager platformuna daha önce hiç kayıt olmamıştır
    When kullanıcı bu e-posta adresi ile kayıt olur ve e-posta doğrulamasını tamamlar
    And kullanıcı sisteme başarılı bir şekilde giriş yapar
    Then kayıt işlemi başarılı olmalıdır
    And kullanıcının cüzdanındaki kredi bakiyesi 2 olmalıdır

  @Pozitif @BR-01 @BR-03
  Scenario: Silinmiş hesapla aynı e-posta üzerinden yeniden kayıt olunması ve kredi verilmemesi
    Given "silinmis_kullanici@mail.com" adresli bir hesap daha önce oluşturulmuş ve "Hesabı Sil" özelliği ile silinmiştir
    When kullanıcı aynı "silinmis_kullanici@mail.com" e-posta adresi ile tekrar kayıt olur ve e-posta doğrulamasını tamamlar
    And kullanıcı sisteme başarılı bir şekilde giriş yapar
    Then kayıt işlemi başarılı olmalı ve herhangi bir hata veya blokaj mesajı gösterilmemelidir
    And kullanıcının cüzdanındaki kredi bakiyesi 0 olmalıdır

  @EdgeCase @BR-03 @BR-04
  Scenario: Büyük ve küçük harf farkı (Case Insensitivity) ile silinmiş hesaba yeniden kayıt
    Given "ornek@mail.com" adresli bir hesap daha önce oluşturulmuş ve silinmiştir
    When kullanıcı yeniden kayıt olurken e-posta adresini "Ornek@Mail.COM" şeklinde farklı harf kombinasyonuyla girer
    And kullanıcı e-posta doğrulamasını tamamlayıp sisteme giriş yapar
    Then kayıt başarılı olmalı ve sistem bu hesabı silinmiş kayıt ile eşleştirmelidir
    And kullanıcının cüzdanındaki kredi bakiyesi 0 olmalıdır

  @Negative @BR-01 @EdgeCase
  Scenario Outline: Aktif veya geçersiz e-posta senaryoları ile kayıt denemeleri
    Given "<eposta>" adresli bir hesap sistem durumuna sahiptir
    When kullanıcı bu e-posta adresi ile yeniden kayıt olmaya çalışır
    Then kayıt işlemi engellenmelidir
    And kullanıcıya uygun bir hata mesajı gösterilmelidir

    Examples:
      | eposta                    |
      | aktif_kullanici@mail.com  |

  @EdgeCase @BR-03
  Scenario: Silinmiş hesabın veritabanında soft-delete durumundayken kredi tablosu kontrolü
    Given "kredi_kontrol@mail.com" adresli hesap silindiğinde sistemde soft-delete olarak işaretlenmektedir
    When kullanıcı "kredi_kontrol@mail.com" ile sisteme tekrar kayıt olur
    Then yeni kullanıcı tablosunda hoş geldin bonusu tetiklenmemelidir
    And kullanıcının başlangıç kredi bakiyesi kesinlikle 0 olarak atanmalıdır