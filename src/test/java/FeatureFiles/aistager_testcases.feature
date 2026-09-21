Feature: AiStager Platformu Fonksiyonel Testleri
  AiStager platformu üzerindeki Sanal Dekorasyon, AI Edit, Sanal Tur Erken Erişim Talebi ve API/Fiyatlandırma yönetimi özelliklerini kapsar.

Background:
  Given Kullanıcı AiStager platformundadır

Scenario: Geçerli parametreler ile başarılı sanal dekorasyon oluşturma
  Given Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
  When Kullanıcı desteklenen formatta bir görsel yükler "oda.jpg"
  And Kullanıcı Oda Türü olarak Yatak Odası seçer
  And Kullanıcı Tasarım Stili olarak Modern seçer
  Then Mevcut mobilyaları kaldır toggle seçeneğinin varsayılan olarak açık olduğu görülür
  When Kullanıcı görünürlük tercihi olarak Galeride Göster seçeneğini seçer
  And Kullanıcı Dekorasyon Oluştur butonuna tıklar
  Then Yapay zeka süreci başlatılır
  And Seçilen kriterlere uygun yeni dekore edilmiş görsel başarıyla üretilir

Scenario Outline: Zorunlu parametreler eksik olduğunda dekorasyon oluşturulamaması
  Given Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
  When Kullanıcı desteklenen formatta bir görsel yükler "salon.png"
  And Kullanıcı Oda Türü olarak "<OdaTuru>" seçer
  And Kullanıcı Tasarım Stili olarak "<TasarimStili>" seçer
  And Kullanıcı Dekorasyon Oluştur butonuna tıklar
  Then Sistem dekorasyon oluşturma işlemini engeller
  And Kullanıcıya zorunlu alanların doldurulması gerektiğine dair uyarı mesajı gösterilir

  Examples:
    | OdaTuru     | TasarimStili |
    | Boş         | Modern       |
    | Oturma Odası| Boş          |
    | Boş         | Boş          |

Scenario: Desteklenmeyen dosya formatında görsel yükleme denemesi
  Given Kullanıcı Sanal Dekorasyon oluşturma sayfasındadır
  When Kullanıcı desteklenmeyen formatta bir görsel yüklemeye çalışır "ev_plani.pdf"
  Then Sistem Geçersiz dosya formatı hata mesajı göstermelidir
  And Dekorasyon Oluştur butonu pasif kalmalıdır

Scenario: Varsayılan mevcut görsel ile başarılı metin tabanlı düzenleme yapma
  Given Kullanıcı AI Edit sekmesindedir
  Then AI Edit sekmesinde varsayılan olarak mevcut görselin Current image seçili olduğu görülür
  When Kullanıcı Describe what to change alanına "Köşeye gri bir berjer ekle" metnini yazar
  And Kullanıcı Edit Photo butonuna tıklar
  Then Sistem girilen talimatı işler
  And Görsel üzerinde istenen düzenleme başarıyla gerçekleştirilir

Scenario: Yeni görsel yükleyerek metinsel komut ile düzenleme yapma
  Given Kullanıcı AI Edit sekmesindedir
  When Kullanıcı düzenleme için yeni bir görsel yükler "mutfak.jpg"
  And Kullanıcı Describe what to change alanına "Tezgahtaki ekmek kızartma makinesini kaldır" metnini yazar
  And Kullanıcı Edit Photo butonuna tıklar
  Then Sistem yeni yüklenen görsel üzerinde düzenlemeyi başarıyla gerçekleştirir

Scenario: Metinsel komut alanı boş bırakılarak düzenleme yapma denemesi
  Given Kullanıcı AI Edit sekmesindedir
  When Kullanıcı mevcut görsel üzerinde Describe what to change alanını boş bırakır
  And Kullanıcı Edit Photo butonuna tıklar
  Then Sistem düzenleme işlemini gerçekleştirmez
  And Kullanıcıya komut girmesi gerektiğini belirten bir uyarı gösterilir

Scenario: Ana menüden Yapay Zeka Sanal Tur sayfasına başarılı navigasyon ve erken erişim talebi
  Given Kullanıcı ana sayfadadır
  When Kullanıcı Ürünler dropdown menüsü üzerine hover yapar
  And Açılan menüden 2. sırada yer alan Yapay Zeka Sanal Tur seçeneğine tıklar
  Then Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasına yönlendirilir
  When Kullanıcı sayfa üzerindeki Erken Erişim İsteyin butonuna tıklar
  And Açılan talep formunda zorunlu alan olan e-posta adresini girer "test@example.com"
  And Kullanıcı talebi gönderir
  Then Sistem talebi başarılı bir şekilde iletir
  And Kullanıcıya başarı mesajı gösterilir

Scenario: Geçersiz e-posta formatı ile erken erişim talebi gönderme
  Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır
  When Kullanıcı Erken Erişim İsteyin butonuna tıklar
  And Açılan talep formuna geçersiz bir e-posta adresi girer "gecersiz-eposta"
  And Kullanıcı talebi gönderir
  Then Sistem talebi iletmez
  And E-posta formatının hatalı olduğuna dair bir hata mesajı gösterilir

Scenario: Zorunlu e-posta alanı boş bırakılarak erken erişim talep etme
  Given Kullanıcı "aistager.ai/tr/ai-virtual-tour" sayfasındadır
  When Kullanıcı Erken Erişim İsteyin butonuna tıklar
  And E-posta alanını boş bırakarak gönder butonuna tıklar
  Then Sistem formun gönderilmesini engeller ve zorunlu alan uyarısı verir

Scenario: API sayfasına navigasyon, başarılı iletişim formu gönderimi ve fiyatlandırma yönlendirmesi
  Given Kullanıcı ana sayfadadır
  When Kullanıcı Ürünler dropdown menüsü üzerine hover yapar
  And Açılan menüden 3. sırada yer alan Sanal Dekorasyon API seçeneğine tıklar
  Then Kullanıcı "aistager.ai/tr/api" sayfasına yönlendirilir
  When Kullanıcı sayfanın üst kısmındaki İletişime Geçin butonuna tıklar
  And İletişim formundaki ad, e-posta ve mesaj alanlarını geçerli bilgilerle doldurur
  And Formu gönderir
  Then Sistem iletişim mesajını iletir ve başarı onay mesajı gösterir
  When Kullanıcı API sayfasının alt kısmına kaydırır
  And Fiyatlandırmayı Görüntüle butonuna tıklar
  Then Kullanıcı hatasız olarak Fiyatlandırma sayfasına yönlendirilir

Scenario: API iletişim formunda zorunlu alanlar eksikken gönderim yapma denemesi
  Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
  When Kullanıcı İletişime Geçin butonuna tıklar
  And İletişim formunda sadece Ad alanını doldurup e-posta ve mesaj alanlarını boş bırakır
  And Formu gönderir
  Then Sistem formun gönderilmesini engeller
  And Eksik zorunlu alanlar için uyarı mesajları gösterilir

Scenario: Fiyatlandırmayı Görüntüle butonuna hızlı ardışık tıklamalar
  Given Kullanıcı "aistager.ai/tr/api" sayfasındadır
  When Kullanıcı sayfanın alt kısmındaki Fiyatlandırmayı Görüntüle butonuna hızlıca iki kez tıklar
  Then Sistem birden fazla fiyatlandırma sayfası açmaz veya yönlendirme döngüsüne girmez
  And Kullanıcı başarıyla tek bir seferde Fiyatlandırma sayfasına yönlendirilir