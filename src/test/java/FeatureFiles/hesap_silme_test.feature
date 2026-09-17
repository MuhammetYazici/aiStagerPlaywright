Feature: Silinen Hesapla Yeniden Kayıt ve Welcome Credit Yönetimi
  Kullanıcı olarak, daha önce hesabımı silmiş olsam bile aynı e-posta ile yeniden kayıt olabilmek istiyorum,
  ancak sistemin kötüye kullanımı önlemek için hoş geldin kredisini ikinci kez vermemesi ve 
  yeni kullanıcıların hak ettikleri kredileri eksiksiz alması gerekmektedir.

  Background:
    Given Sistem aktif ve kayıt servisleri çalışır durumdadır

  @pozitif @ac-1 @tc-01
  Scenario: Yeni ve benzersiz bir kullanıcının sisteme ilk kez kayıt olması
    Given Sistemi daha önce hiç kullanmamış benzersiz bir e-posta adresi vardır
    When Kullanıcı kayıt formunu doldurur ve kayıt olur
    And E-posta doğrulama adımı tamamlanır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapar
    Then Kayıt işleminin başarılı olduğu görülmelidir
    And Kullanıcının başlangıç kredi bakiyesi tam olarak "2" Kredi olmalıdır

  @pozitif @ac-2 @tc-02
  Scenario: Daha önce hesabı silinmiş bir kullanıcının aynı e-posta ile yeniden kayıt olması
    Given Daha önceden hesabı veritabanından silinmiş bir e-posta adresi bulunur
    When Kullanıcı aynı e-posta adresi ile yeniden kayıt olur
    And E-posta doğrulama adımı tamamlanır
    And Kullanıcı sisteme başarılı bir şekilde giriş yapar
    Then Kayıt işlemi herhangi bir hata veya uyarı almaksızın başarılı bir şekilde tamamlanmalıdır
    And Hoş geldin kredisi kullanıcıya ikinci kez verilmemelidir
    And Kullanıcının güncel kredi bakiyesi "0" Kredi olmalıdır

  @edge_case @ac-3 @tc-03
  Scenario: Silinmiş hesap için farklı büyük ve küçük harf kombinasyonlarıyla yeniden kayıt (Email Normalization)
    Given Sistemde geçmişte silinmiş olan "ornek@mail.com" e-posta adresi kayıtlıdır
    When Kullanıcı bu adresi büyük/küçük harf varyasyonu olan "Ornek@Mail.COM" formatıyla yeniden kayda girer
    And Kayıt işlemi tamamlanır ve e-posta doğrulanarak giriş yapılır
    Then Sistem e-postayı normalize ederek mükerrer kaydı ve kredi istismarını engellemelidir
    And Kayıt işlemi başarılı olmalıdır
    And Kullanıcının kredi bakiyesi "0" Kredi olarak başlatılmalıdır

  @negatif @edge_case
  Scenario Outline: Eksik veya geçersiz e-posta formatı ile yeniden kayıt denemesi
    Given Daha önce silinmiş bir e-posta adresinin geçersiz bir formatı vardır
    When Kullanıcı "<gecersiz_email>" formatta bir e-posta ile kayıt olmayı dener
    Then Kayıt işlemi başarısız olmalıdır
    And Sistem kullanıcıya uygun bir hata mesajı göstermelidir
    And Hiçbir kredi tanımlaması yapılmamalıdır

    Examples:
      | gecersiz_email |
      | eksk@mail      |
      | hatali-format  |
      | @domain.com    |
      | test@          |