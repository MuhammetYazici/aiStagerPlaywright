Feature: AiStager.ai Platform Fonksiyonel, Kullanılabilirlik ve Güvenlik Testleri

Background:
  Given Kullanıcı web tarayıcısını başlatır ve "https://aistager.ai" adresine erişir

Scenario: Before After slider tutamağı sürüklendiğinde görseller piksel kayması olmadan yeniden boyutlandırılmalı
  Given Ziyaretçi ana sayfada "Öncesi ve Sonrası Sihri" alanına gider
  When Kullanıcı slider tutamağını "sağ" yönüne doğru sürükler
  Then "Önce" ve "Sonra" görsel katmanları piksel kayması olmadan eşzamanlı olarak yeniden boyutlandırılmalıdır

Scenario Outline: Carousel yön okları ile odalar arası geçiş ve sayfa belirteci güncellemesi
  Given Ziyaretçi ana sayfada "Öncesi ve Sonrası Sihri" alanına gider
  When Kullanıcı carousel " Sayfa Yönü " butonuna tıklar
  Then Görsel seti " Hedef Oda " verileri ile yenilenmelidir
  And Alt belirteç noktası " Aktif Nokta Indeksi " için aktif ve belirgin durumda olmalıdır
  And Görsel geçişi akıcı bir efekt ile gerçekleşmelidir

Examples:
  | Sayfa Yönü | Hedef Oda     | Aktif Nokta Indeksi |
  | sağ        | Yatak Odası   | 2                   |
  | sol        | Oturma Odası  | 1                   |

Scenario Outline: Carousel noktalarına tıklayarak doğrudan ilgili odaya geçiş
  Given Ziyaretçi ana sayfada "Öncesi ve Sonrası Sihri" alanına gider
  When Kullanıcı carousel altındaki " Nokta Indeksi " numaralı belirteç noktasına tıklar
  Then Ekrana " Beklenen Oda " görsel seti gelmelidir
  And Seçilen " Nokta Indeksi " numaralı nokta koyu aktif renkle vurgulanmalıdır

Examples:
  | Nokta Indeksi | Beklenen Oda   |
  | 1             | Oturma Odası   |
  | 3             | Mutfak         |

Scenario Outline: Odanızı Yükleyin butonunun kullanıcı oturum durumuna göre yönlendirmesi
  Given Kullanıcı sisteme " Oturum Durumu " olarak erişim sağlar
  When Kullanıcı "Odanızı Yükleyin" butonuna tıklar
  Then Kullanıcı " Yönlendirilen Sayfa " adresine yönlendirilmelidir

Examples:
  | Oturum Durumu | Yönlendirilen Sayfa |
  | Ziyaretçi     | /login              |
  | Giriş Yapmış  | /upload-panel       |

Scenario Outline: Dil değiştiğinde slider alanındaki metinlerin anlık dönüşümü
  Given Ziyaretçi ana sayfada "Öncesi ve Sonrası Sihri" alanına gider
  When Kullanıcı header alanından dil seçeneğini " Seçilen Dil " olarak değiştirir
  Then Slider alanındaki başlık metni " Beklenen Metin " olarak güncellenmelidir

Examples:
  | Seçilen Dil | Beklenen Metin           |
  | EN          | Before and After Magic   |
  | TR          | Öncesi ve Sonrası Sihri  |

Scenario: Ziyaretçi kullanıcısının dinamik header elemanlarını ve buton yönlendirmelerini doğrulaması
  Given Ziyaretçi ana sayfaya erişim sağlar
  Then Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları görünür olmalıdır
  And Üst menüde "Üretimlerim" linki ve Profil alanı gizli olmalıdır
  When Kullanıcı "Giriş Yap" butonuna tıklar
  Then Kullanıcı "/login" sayfasına yönlendirilmelidir
  When Kullanıcı "Ücretsiz Dene" butonuna tıklar
  Then Kullanıcı "/register" sayfasına yönlendirilmelidir

Scenario: Oturum açmış kullanıcının header elemanlarını ve menülerini doğrulaması
  Given Oturum açmış kullanıcı ana sayfaya erişim sağlar
  Then Üst menüde "Üretimlerim" linki, hızlı render ikonu ve Profil ikonu görünür olmalıdır
  And Üst menüde "Giriş Yap" ve "Ücretsiz Dene" butonları gizli olmalıdır
  When Kullanıcı "Üretimlerim" linkine tıklar
  Then Kullanıcı tasarımlarının yer aldığı sayfaya yönlendirilmelidir
  When Kullanıcı hızlı render ikonuna tıklar
  Then Hızlı render ayarlar paneli açılmalıdır
  When Kullanıcı Profil ikonuna tıklar
  Then Profil alt menüsü açılmalıdır

Scenario: Header logosu ve gezinti menülerinin doğrulanması
  Given Kullanıcı ana sayfaya erişim sağlar
  When Kullanıcı "Ürünler" menüsünün üzerine gelir
  Then Alt ürün listesi alt menüsü açılmalıdır
  When Kullanıcı "Çözümler" linkine tıklar
  Then Kullanıcı "/solutions" sayfasına yönlendirilmelidir
  When Kullanıcı "Kaynaklar" linkine tıklar
  Then Kullanıcı "/resources" sayfasına yönlendirilmelidir
  When Kullanıcı "Fiyatlandırma" linkine tıklar
  Then Kullanıcı "/pricing" sayfasına yönlendirilmelidir
  When Kullanıcı "AiStager.ai" logosuna tıklar
  Then Kullanıcı "/" kök dizin ana sayfasına yönlendirilmelidir

Scenario: Topluluk galerisinde varsayılan filtre ve filtre değişiminin doğrulanması
  Given Ziyaretçi ana sayfada Topluluk Tasarımları Galerisi alanına iner
  Then "Tüm Tipler" filtresi varsayılan olarak mor renkte aktif gelmelidir
  And Galeride karışık oda kartları listelenmelidir
  When Kullanıcı "Oturma Odası" kategori butonuna tıklar
  Then "Oturma Odası" butonu aktifleşmelidir
  And Galeri anlık olarak sadece oturma odası kategorisine ait kartları listelemelidir

Scenario: Seçili filtreye uygun olarak daha fazla tasarım yükleme ve profil yönlendirmesi
  Given Ziyaretçi topluluk galerisinde "Yatak Odası" filtresini seçer
  When Kullanıcı "Daha Fazla Tasarım Yükle" butonuna tıklar
  Then Eklenen yeni kartlar yalnızca "Yatak Odası" kategorisine ait olmalıdır
  And Sayfa yapısında görsel ve düzen bozulması olmamalıdır
  When Kullanıcı bir tasarım kartındaki kullanıcı adına tıklar
  Then Kullanıcı ilgili tasarımcının profil detay sayfasına yönlendirilmelidir

Scenario: Tasarım kartında beğeni butonuna tıklanması ve anlık arayüz güncellemesi
  Given Ziyaretçi topluluk galerisindeki bir tasarım kartını inceler
  When Kullanıcı tasarım kartı üzerindeki kalp ikonuna tıklar
  Then Beğeni sayısı anlık olarak bir artmalıdır
  And Kalp ikonu aktif renk durumuna geçmelidir

Scenario: SSS akordeon yapısında tekli genişleme kuralı ve içeriğin açılıp kapanması
  Given Ziyaretçi ana sayfada Sıkça Sorulan Sorular alanına gider
  When Kullanıcı kapalı durumdaki "Soru 1" başlığına tıklar
  Then "Soru 1" yanıt alanı aşağı doğru genişlemeli ve ok ikonu yukarı dönmelidir
  When Kullanıcı kapalı durumdaki "Soru 2" başlığına tıklar
  Then "Soru 1" yanıt alanı otomatik olarak kapanmalıdır
  And "Soru 2" yanıt alanı açılmalıdır ve ok ikonu yukarı dönmelidir
  When Kullanıcı açık durumdaki "Soru 2" başlığına tekrar tıklar
  Then "Soru 2" yanıt alanı kapanmalıdır

Scenario: SSS alanındaki destek bağlantısının doğru sayfaya yönlendirmesi
  Given Ziyaretçi Sıkça Sorulan Sorular alanına gider
  When Kullanıcı "Bize ulaşın." bağlantısına tıklar
  Then Kullanıcı iletişim ve destek sayfasına yönlendirilmelidir

Scenario Outline: Bülten aboneliğinde geçerli ve geçersiz e-posta senaryoları
  Given Ziyaretçi footer alanındaki bülten aboneliği formuna gider
  When Kullanıcı e-posta alanına " Eposta " değerini girer
  And Kullanıcı "Abone Ol" butonuna tıklar
  Then Ekranda " Beklenen Mesaj " uyarı bildirimi gösterilmelidir

Examples:
  | Eposta              | Beklenen Mesaj                      |
  | test@example.com    | Başarıyla abone oldunuz             |
  | hatali-eposta.com   | Geçerli bir e-posta adresi giriniz  |
  |                     | Geçerli bir e-posta adresi giriniz  |

Scenario: Footer yasal ve sosyal medya bağlantılarının doğrulanması
  Given Ziyaretçi footer alanına gider
  When Kullanıcı "Gizlilik Politikası" linkine tıklar
  Then İlgili resmi gizlilik politikası sayfası açılmalıdır
  When Kullanıcı "Kullanım Şartları" linkine tıklar
  Then İlgili resmi kullanım şartları sayfası açılmalıdır
  When Kullanıcı bir sosyal medya ikonuna tıklar
  Then Bağlantı yeni sekmede açılmalıdır

Scenario: Geçerli bilgilerle başarılı kullanıcı girişi
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı e-posta alanına "gecerli_kullanici@aistager.ai" yazar
  And Kullanıcı şifre alanına "GecerliSifre123" yazar
  And Kullanıcı "Giriş Yap" butonuna tıklar
  Then Kullanıcı başarıyla doğrulanmalı ve Dashboard sayfasına yönlendirilmelidir

Scenario: Şifre maskeleme ikonu kullanımı
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı şifre alanına "GizliSifre123" yazar
  And Kullanıcı şifre alanındaki "Göz" ikonuna tıklar
  Then Şifre karakterleri görünür metin formatına geçmelidir
  When Kullanıcı "Göz" ikonuna tekrar tıklar
  Then Şifre karakterleri yeniden maskelenmiş gizli formata geçmelidir

Scenario: Google hesabı ile sosyal giriş yapılması
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı "Google ile devam et" butonuna tıklar
  Then Google OAuth doğrulama penceresi açılmalıdır
  When Kullanıcı geçerli Google hesabını doğrular
  Then Kullanıcı platforma giriş yapmalı ve Dashboard sayfasına yönlendirilmelidir

Scenario Outline: Giriş formunda zorunlu alan ve hatalı kimlik bilgisi doğrulamaları
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı e-posta alanına " Eposta " yazar
  And Kullanıcı şifre alanına " Sifre " yazar
  And Kullanıcı "Giriş Yap" butonuna tıklar
  Then Ekranda " Hata Mesajı " uyarısı görüntülenmelidir

Examples:
  | Eposta                   | Sifre           | Hata Mesajı                            |
  |                          | GecerliSifre123 | Bu alan zorunludur                     |
  | gecerli@aistager.ai      |                 | Bu alan zorunludur                     |
  | hatali-format            | GecerliSifre123 | Lütfen geçerli bir e-posta adresi girin|
  | yanlis@aistager.ai       | YanlisSifre123  | E-posta veya şifre hatalı              |
  | kayitsiz_user@test.com   | GecerliSifre123 | E-posta veya şifre hatalı              |

Scenario Outline: Giriş formunda SQLi ve XSS güvenlik denemelerinin doğrulanması
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı e-posta alanına " Zararlı Girdi " yazar
  And Kullanıcı şifre alanına " Zararlı Girdi " yazar
  And Kullanıcı "Giriş Yap" butonuna tıklar
  Then Sistem sunucu hatası 500 vermemelidir
  And Ekranda güvenlik nedeniyle "E-posta veya şifre hatalı" mesajı gösterilmelidir

Examples:
  | Zararlı Girdi                         |
  | ' OR '1'='1                           |
  | <script>alert('xss')</script>         |
  | SELECT * FROM users WHERE '1'='1      |

Scenario: Giriş sayfasındaki yardımcı bağlantıların kontrolü
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı "Kayıt ol" bağlantısına tıklar
  Then Kullanıcı "/register" kayıt sayfasına yönlendirilmelidir
  Given Kullanıcı "/login" giriş sayfasına gider
  When Kullanıcı "Şifremi unuttum?" bağlantısına tıklar
  Then Kullanıcı şifre sıfırlama akışı sayfasına yönlendirilmelidir

Scenario: Geçerli bilgiler ve onaylanmış sözleşme ile başarılı yeni kullanıcı kaydı
  Given Kullanıcı "/register" kayıt sayfasına gider
  When Kullanıcı e-posta alanına "yeni_kullanici@aistager.ai" yazar
  And Kullanıcı şifre alanına "Guvenli123" yazar
  And Kullanıcı şifre tekrar alanına "Guvenli123" yazar
  And Kullanıcı Kullanıcı Sözleşmesi onay kutusunu işaretler
  And Kullanıcı "Hesap Oluştur" butonuna tıklar
  Then Yeni kullanıcı hesabı oluşturulmalı ve kullanıcı açılış paneline yönlendirilmelidir

Scenario Outline: Kayıt formunda validasyon ve iş kuralı hataları
  Given Kullanıcı "/register" kayıt sayfasına gider
  When Kullanıcı e-posta alanına " Eposta " yazar
  And Kullanıcı şifre alanına " Sifre " yazar
  And Kullanıcı şifre tekrar alanına " Sifre Tekrar " yazar
  And Kullanıcı sözleşme onay kutusunu " Sozlesme Durumu " olarak ayarlar
  And Kullanıcı "Hesap Oluştur" butonuna tıklar
  Then Ekranda " Beklenen Uyar " mesajı gösterilmelidir

Examples:
  | Eposta                   | Sifre      | Sifre Tekrar | Sozlesme Durumu | Beklenen Uyar                          |
  | yeni@aistager.ai         | Pass1234   | Pass5678     | Onaylı          | Şifreler eşleşmiyor                    |
  | yeni@aistager.ai         | Kisa1      | Kisa1        | Onaylı          | Şifre en az 8 karakter olmalıdır       |
  | mevcut_kullanici@test.com| Guvenli123 | Guvenli123   | Onaylı          | Bu e-posta adresi zaten kullanımda     |
  | yeni@aistager.ai         | Guvenli123 | Guvenli123   | Onaysız         | Sözleşmeyi kabul etmelisiniz           |

Scenario: Google hesabı ile hızlı kayıt olunması
  Given Kullanıcı "/register" kayıt sayfasına gider
  When Kullanıcı "Google ile devam et" butonuna tıklar
  Then Google OAuth hesabı ile hızlı kayıt gerçekleşmeli ve oturum açılmalıdır