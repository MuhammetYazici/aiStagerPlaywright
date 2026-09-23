Feature: AiStager Platformu Ana Sayfa Navigasyon Kimlik Doğrulama ve Yönetim Modülleri

  Background:
    Given Kullanici AiStager platformundadir

  Scenario: Oncesi ve Sonrasi Sihri slider alaninin sag sol ok butonlariyla kontrol edilmesi
    Given Kullanici ana sayfada Oncesi ve Sonrasi Sihri slider alanindadir
    When Kullanici sag ok butonuna tiklar
    Then Slider görseli bir sonraki adıma pürüzsüz bir şekilde geçmelidir
    When Kullanici sol ok butonuna tiklar
    Then Slider görseli bir önceki adıma geri dönmelidir

  Scenario: Oncesi ve Sonrasi Sihri slider alaninin surukleme hareketiyle kontrol edilmesi
    Given Kullanici ana sayfada Oncesi ve Sonrasi Sihri slider alanindadir
    When Kullanici slider tutamagini saga dogru surukler
    Then Görselin "Öncesi" ve "Sonrası" oranları sürükleme hareketiyle senkronize şekilde değişmelidir

  Scenario: Oncesi ve Sonrasi Sihri slider alaninin alt carousel noktalariyla kontrol edilmesi
    Given Kullanici ana sayfada Oncesi ve Sonrasi Sihri slider alanindadir
    When Kullanici alt kisimdaki ikinci carousel noktasina tiklar
    Then Slider dogrudan ilgili ikinci gorsel kombinasyonuna gecmelidir

  Scenario: Oturum acmamis ziyaretcinin ust menu gorunumu
    Given Ziyaretci sisteme giris yapmamistir
    When Ziyaretci ana sayfayi ziyaret eder
    Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünmelidir
    And Üst menüde "Üretimlerim" ve profil ikonları gizli olmalıdır

  Scenario: Oturum acmis kullanicinin ust menu gorunumu
    Given Kullanici gecerli kimlik bilgileriyle sisteme giris yapmistir
    When Kullanici ana sayfayi ziyaret eder
    Then Üst menüde "Üretimlerim", hızlı erişim araçları ve profil menüsü aktif olarak görünmelidir

  Scenario: Galeri alaninin varsayilan olarak Tum Tipler ile gelmesi ve oda tipine gore filtrelenmesi
    Given Kullanici ana sayfadaki galeri alanindadir
    Then Varsayılan olarak "Tüm Tipler" filtresinin aktif olduğu görülmelidir
    When Kullanici "Oturma Odası" filtre seçeneğine tıklar
    Then Galeri listesi yalnızca "Oturma Odası" kategorisine ait içerikleri göstermelidir

  Scenario: Daha Fazla Tasarim Yukle butonunun mevcut filtreyi korumasi
    Given Kullanici "Oturma Odası" filtresini seçmiştir ve galeri filtrelenmiştir
    When Kullanici "Daha Fazla Tasarım Yükle" butonuna tıklar
    Then Mevcut "Oturma Odası" filtresi korunarak yeni tasarım kartları listeye yüklenmelidir

  Scenario: SSS bolumunde ayni anda yalnizca bir akordeon basliginin acik kalmasi
    Given Kullanici SSS (Sıkça Sorulan Sorular) bölümündedir
    When Kullanici "Birinci Soru" başlıklı akordeona tıklar ve soru açılır
    And Kullanıcı ardından "İkinci Soru" başlıklı akordeona tıklar
    Then "İkinci Soru" açılmalı ve "Birinci Soru" otomatik olarak kapanmalıdır

  Scenario: Bulten aboneligine gecerli e-posta adresi ile kayit olma
    Given Kullanici footer alanindaki bulten abonelik formundadir
    When Kullanici e-posta alanina "test.kullanici@example.com" girer
    And Kullanici abone ol butonuna tiklar
    Then Başarılı abonelik mesajı görüntülenmelidir

  Scenario Outline: Bulten aboneligine gecersiz veya bos e-posta adresi girilmesi
    Given Kullanici footer alanindaki bulten abonelik formundadir
    When Kullanici e-posta alanina "<gecersiz_ep_osta>" girer
    And Kullanici abone ol butonuna tiklar
    Then Sistem hata mesaji tetiklemelidir

    Examples:
      | gecersiz_ep_osta |
      |                  |
      | eksik-format.com |
      | @domain.com      |
      | test@.com        |

  Scenario: Footer yasal metin baglantilarinin calismasi
    Given Kullanici footer alanindadir
    When Kullanici "Gizlilik Politikası" bağlantısına tıklar
    Then "Gizlilik Politikası" sayfası açılmalıdır
    When Kullanici ana sayfaya donup "Kullanım Şartları" bağlantısına tıklar
    Then "Kullanım Şartları" sayfası açılmalıdır

  Scenario: Sosyal medya ikonlarinin yeni sekmede acilmasi
    Given Kullanici footer alanindadir
    When Kullanıcı sosyal medya ikonlarından "Instagram" simgesine tıklar
    Then Platformun resmi Instagram sayfasi yeni bir tarayici sekmesinde acilmalidir

  Scenario: Giris ve kayit formlarinda zorunlu alanlarin bos birakilmasi
    Given Kullanici "Giriş Yap / Kayıt Ol" sayfasındadır
    When Kullanıcı tüm zorunlu alanları boş bırakarak formları gönderir
    Then Sistem tüm zorunlu alanlar için "Bu alan zorunludur" uyarısı vermelidir

  Scenario Outline: Kayit formunda gecersiz e-posta formati girilmesi
    Given Kullanici "Kayıt Ol" sayfasındadır
    When Kullanici e-posta alanina "<gecersiz_email>" girer
    And Kayit formunu gondermeye calisir
    Then E-posta formatinin gecersiz olduguna dair uyari mesaji alinmalidir

    Examples:
      | gecersiz_email |
      | kullanici      |
      | kullanici@     |
      | @domain.com    |

  Scenario: Sifre alaninda maskeleme Goz ikonu ozelliginin kullanilmasi
    Given Kullanıcı şifre alanına bir parola girmiştir ve parola maskelidir (gizlidir)
    When Kullanıcı "Göz" ikonuna tıklar
    Then Parola metin olarak gorunur hale gelmelidir
    When Kullanıcı tekrar "Göz" ikonuna tıklar
    Then Parola tekrar maskelenmelidir

  Scenario Outline: Kayit sirasinda zayif sifre veya uyusmayan sifre onayi girilmesi
    Given Kullanıcı "Kayıt Ol" sayfasındadır
    When Kullanıcı şifre alanına "<sifre>", şifreyi onayla alanına "<sifre_onay>" girer
    And Kayit ol butonuna tıklar
    Then Sistem sifre politikasi veya eslesme hatasi vermelidir

    Examples:
      | sifre     | sifre_onay |
      | 123456    | 123456     |
      | Password1 | Password2  |

  Scenario: Kayit sirasinda Kullanici Sozlesmesi onay kutucugunun isaretlenmemesi
    Given Kullanıcı "Kayıt Ol" sayfasında tüm zorunlu alanları ve geçerli şifreyi girmiştir
    When Kullanıcı "Kullanıcı Sözleşmesi" onay kutucuğunu işaretlemeden kayıt olmaya çalışır
    Then Sistem sözleşmenin onaylanması gerektiğine dair bir hata uyarısı vermelidir

  Scenario: Sistemde kayitli olmayan e-posta veya yanlis sifre ile giris denemesi
    Given Kullanıcı "Giriş Yap" sayfasındadır
    When Kullanici sisteme kayitli olmayan "bilinmeyen@example.com" ve yanlis sifre "YanlisSifre123" girer
    And Giriş yap butonuna tıklar
    Then Sistem güvenlik gereği spesifik bir açık vermeden genel *"E-posta veya şifre hatalı"* mesajı dönmelidir

  Scenario: Zaten kayitli bir e-posta adresi ile tekrar kayit olunmaya calisilmasi
    Given Sistemde "kayitli.kullanici@example.com" adresiyle halihazirda bir hesap bulunmaktadir
    When Kullanıcı "Kayıt Ol" sayfasında aynı e-posta adresini kullanarak yeni kayıt oluşturmaya çalışır
    Then Sistem Bu e-posta adresi zaten kullanimda uyarisi vermelidir

  Scenario Outline: Form alanlarina SQL Injection veya asiri uzun karakter girdilerinin denenmesi
    Given Kullanici "Giriş Yap / Kayıt Ol" sayfasındadır
    When Kullanıcı form alanlarına güvenlik tehditi içeren "<zararli_girdi>" karakterlerini girer
    And İşlemi gönderir
    Then Sistem bu girdileri güvenle filtrelemeli ve sunucu 500 hatası (Internal Server Error) üretmeden uygun bir validasyon hatası dönmelidir

    Examples:
      | zararli_girdi                                                                  |
      | ' OR '1'='1                                                                    |
      | <script>alert('test')</script>                                                 |
      | BuMetinFormSinirlariniTestEtmekAmaciylaAsiriDerecedeUzunTutulmusBirGirdidir... |