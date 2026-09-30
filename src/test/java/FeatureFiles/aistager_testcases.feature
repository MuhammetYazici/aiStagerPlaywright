İstenen adımlar ilgili senaryolara, doğru sıralamayla ve metinler birebir korunarak eklenmiştir. Güncellenmiş ve eksiksiz Gherkin senaryosunun tam metni aşağıdadır:

```gherkin
Feature: AiStager Platformu Fonksiyonel Testleri
  Kullanıcılar sanal dekorasyon oluşturma, AI edit ile görsel düzenleme, sanal tur erken erişim talebi 
  ve API iletişim işlemleri gibi özellikleri gerçekleştirebilmelidir.

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Geçerli formatta görsel yükleme ve başarılı dekorasyon oluşturma
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı sisteme giriş yapmıştır
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı yükleme alanına geçerli formatta .jpg veya .png oda fotoğrafını sürükleyip bırakır
    Then Yüklenen görselin önizlemesi kullanıcıya gösterilmelidir
    When Kullanıcı "Oda Türü" dropdown alanından "Oturma Odası" seçeneğini seçer
    And Kullanıcı Oda Türü dropdown alanından Oturma Odası seçeneğini seçer
    And Kullanıcı Tasarım Stili dropdown alanından Modern seçeneğini seçer
    And Mevcut mobilyaları kaldır toggle'ının varsayılan olarak açık olduğu doğrulanır
    And Kullanıcı görünürlük seçeneklerinden Herkese açık galeride göster radio butonunu seçer
    Then Dekorasyon Oluştur butonunun aktif olduğu görülür
    When Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then İşlem tamamlandığında odanın yapay zeka tarafından mobilyalandırılmış yeni hali ekranda gösterilmelidir

  Scenario Outline: Desteklenmeyen dosya formatı ile görsel yükleme denemesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı yükleme alanına "<gecersiz_format>" formatında dosya yükler
    Then Sistem hata mesajı göstermelidir ve görsel yüklenmemelidir
    And Dekorasyon Oluştur butonu pasif kalmalıdır

    Examples:
      | gecersiz_format |
      | .pdf            |
      | .exe            |
      | .txt            |
      | .gif            |

  Scenario: Zorunlu alanlar eksikken dekorasyon oluşturma butonunun pasif olması
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı geçerli bir görsel yükler
    And Kullanıcı Oda Türü seçimini boş bırakır
    And Kullanıcı Tasarım Stili seçimini boş bırakır
    Then Dekorasyon Oluştur butonunun pasif olduğu doğrulanır

  Scenario: Mevcut mobilyaları kaldır toggle durumunu değiştirme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı geçerli bir görsel yükler, Oda Türü ve Tasarım Stili seçer
    And Kullanıcı varsayılan olarak açık gelen Mevcut mobilyaları kaldır toggle'ını kapatır
    Then Toggle'ın kapalı duruma geldiği doğrulanır
    When Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then İşlem başarılı bir şekilde tamamlanır

  Scenario: İzin verilen maksimum dosya boyutundan büyük görsel yükleme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    When Kullanıcı izin verilen maksimum boyuttan büyük bir oda fotoğrafı yükler
    Then Sistem dosya boyutu hatası vermelidir ve görsel yüklenmemelidir

  Scenario: Varsayılan kaynak görsel ve geçerli metin ile AI Edit yapma
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif hale getirmiştir
    Then Edit photo source dropdown alanında varsayılan olarak Current image seçili olmalıdır
    And Seçilen görselin önizlemesi ekranda görünmelidir
    When Kullanıcı Describe what to change metin alanına Remove the chair yazar
    Then Edit Photo butonunun aktif olduğu görülür
    When Kullanıcı Edit Photo butonuna tıklar
    Then Sistem kullanıcının metinsel talimatına uygun şekilde düzenlenmiş yeni görseli ekranda sunmalıdır

  Scenario: Alternatif yeni görsel yükleyerek AI Edit yapma
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif hale getirmiştir
    When Kullanıcı Edit photo source alanından yeni bir kaynak görsel yükler
    Then Yeni yüklenen görselin önizlemesi ekranda görünmelidir
    When Kullanıcı Describe what to change metin alanına Add a modern sofa yazar
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem güncellenmiş yeni görseli ekranda sunmalıdır

  Scenario: Metin alanı boş bırakıldığında Edit Photo butonunun durumu
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif hale getirmiştir
    When Kullanıcı "Edit photo source" alanından "Current image" seçer
    And Kullanıcı Describe what to change metin alanını boş bırakır
    Then Edit Photo butonunun pasif olduğu doğrulanır

  Scenario: Çok uzun metinsel talimat girişi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif hale getirmiştir
    When Kullanıcı Describe what to change alanına sistemin karakter sınırını zorlayacak çok uzun bir açıklama metni yazar
    Then Metin alanının bu girdiyi kabul ettiği veya uygun bir sınırlama uyarısı verdiği doğrulanır
    And Edit Photo butonunun işlevselliği test edilir

  Scenario: Özel karakterler ve yabancı karakterler içeren metin girişi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı "Virtual Staging" sayfasındadır
    And Kullanıcı AI Edit sekmesini aktif hale getirmiştir
    When Kullanıcı "Describe what to change" alanına özel karakterler ve emojiler içeren bir talep yazar (örn. "Remove chair & table! 🪑")
    And Kullanıcı Edit Photo butonuna tıklar
    Then Yapay zekanın girdiyi işleyip görseli başarılı bir şekilde düzenlediği doğrulanır

  Scenario: Header menüsünden Yapay Zeka Sanal Tur sayfasına navigasyon ve erken erişim talebi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler dropdown menüsünün üzerine gelir
    Then Menünün açıldığı ve seçeneklerin listelendiği görülür
    When Kullanıcı listeden 2. sırada yer alan Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilmelidir
    When Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar
    Then İlgili form veya modal açılmalıdır
    When Kullanıcı form alanına geçerli bir e-posta adresi girer ve gönderir
    Then Sistem bilgileri kaydetmeli ve kullanıcıya başarılı iletim onay mesajı göstermelidir

  Scenario: Geçersiz e-posta adresi ile erken erişim talebi gönderme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Kullanıcı form alanına geçersiz bir e-posta adresi girer
    And Kullanıcı formu gönderme butonuna tıklar
    Then Sistem e-posta formatı hatası göstermelidir ve talep gönderilmemelidir

  Scenario: Boş e-posta alanı ile erken erişim talebi gönderme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Kullanıcı e-posta alanını boş bırakıp gönder butonuna tıklar
    Then Zorunlu alan uyarısı gösterilmelidir

  Scenario: Aynı e-posta adresi ile mükerrer erken erişim talebi gönderme
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    And Daha önce erken erişim talebinde bulunmuş bir e-posta adresi bilinmektedir
    When Kullanıcı Erken Erişim İsteyin formuna bu e-posta adresini tekrar girer ve gönderir
    Then Sistem mükerrer kaydı engellemeli veya kullanıcıya daha önce kayıt olduğuna dair uygun bir bilgi mesajı göstermelidir

  Scenario: Sanal Dekorasyon API sayfasına navigasyon, iletişim formu ve fiyatlandırma yönlendirmesi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler dropdown menüsünün üzerine gelir
    And Kullanıcı listedeki 3. eleman olan Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı aistager.ai/tr/api sayfasına yönlendirilmelidir
    When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
    Then İletişim formu açılmalıdır
    When Kullanıcı zorunlu alanları eksiksiz doldurur ve formu onaylar
    Then Talep başarıyla iletilmeli ve ekranda onay mesajı gösterilmelidir
    When Kullanıcı sayfanın alt kısmında yer alan Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir

  Scenario: İletişim formunda zorunlu alanlar eksikken gönderim yapma
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Kullanıcı zorunlu alanlardan bazılarını boş bırakarak formu onaylar
    Then Sistem zorunlu alan hatalarını göstermeli ve form gönderilmemelidir

  Scenario: İletişim formuna çok uzun metin girişi
    Given Kullanıcı giriş sayfasındadır
    When Kullanıcı sisteme giriş yapar
    And Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Kullanıcı mesaj alanına karakter sınırını aşan çok uzun bir metin girer
    Then Sistem karakter sınırını aşım uyarısı vermeli ya da metni sınıra göre kırpmalıdır