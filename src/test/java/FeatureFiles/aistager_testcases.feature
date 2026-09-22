Feature: AI Destekli Görsel Yönetimi Sanal Dekorasyon ve Ürün Keşfi

  Background:
    Given Kullanıcı AiStager platformundadır

  Scenario: Geçerli bilgilerle başarılı bir şekilde sanal dekorasyon oluşturma
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler .jpg veya .png
    And Kullanıcı Oda Türü ve Tasarım Stili seçimini yapar
    And Mevcut mobilyaları kaldır toggle ının varsayılan olarak açık olduğunu görür
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem görseli oda türünü ve stil parametrelerini işler
    And Kullanıcıya yeni ve gerçekçi bir mobilyalandırılmış görsel sunulur

  Scenario: Mevcut mobilyaları kaldır toggle ını kapalı konuma getirerek dekorasyon oluşturma
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler
    And Kullanıcı Oda Türü ve Tasarım Stili seçimini yapar
    And Kullanıcı Mevcut mobilyaları kaldır toggle ını kapatır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem mevcut mobilyaları koruyarak seçilen stilde dekorasyon uygular ve yeni görseli üretir

  Scenario: Oturum açmamış kullanıcının sanal dekorasyon oluşturmayı denemesi
    When Kullanıcı giriş yapmamış olarak Virtual Staging sayfasına erişmeye çalışır veya işlem yapmak ister
    Then Sistem kullanıcıyı giriş sayfasına yönlendirir ve işlem engellenir

  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturmaya çalışılması
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli formatta bir oda görseli yükler
    And Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Dekorasyon Oluştur butonu aktif olmamalı veya işlem gerçekleşmemelidir
    And Kullanıcıya zorunlu alanların doldurulması gerektiğine dair uyarı mesajı gösterilmelidir

  Scenario Outline: Desteklenmeyen dosya formatları ile görsel yükleme denemesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı geçerli olmayan "<dosya_formati>" formatında bir dosya yükler
    And Kullanıcı Oda Türü ve Tasarım Stili seçimlerini yapar
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem hata mesajı göstermeli ve işlemin yapılmasına izin vermemelidir

    Examples:
      | dosya_formati |
      | .gif          |
      | .bmp          |
      | .pdf          |
      | .webp         |

  Scenario: Varsayılan kaynak görsel üzerinde metinsel talimatla düzenleme yapma
    Given Kullanıcı AI Edit sekmesindedir
    When AI Edit sekmesinde mevcut görsel varsayılan olarak seçilidir
    And Kullanıcı Describe what to change alanına geçerli bir talimat yazar "Add a modern blue sofa"
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem metinsel talimatı analiz ederek kaynak görseli manipüle eder
    And Kullanıcıya güncellenmiş yeni görsel sunulur

  Scenario: Yeni bir görsel yükleyerek AI Edit ile düzenleme yapma
    Given Kullanıcı AI Edit sekmesindedir
    When Kullanıcı yeni bir kaynak görsel yükler
    And Kullanıcı Describe what to change alanına metinsel talimat girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem yeni yüklenen görsel üzerinde talimatı uygular ve güncellenmiş görseli gösterir

  Scenario: Talimat alanı boşken düzenleme yapmaya çalışılması
    Given Kullanıcı AI Edit sekmesindedir
    When Describe what to change alanı boş bırakılır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Edit Photo butonu aktif olmamalı veya işlem gerçekleşmemelidir
    And Kullanıcıya talimat girmesi gerektiğine dair uyarı mesajı gösterilmelidir

  Scenario: Header menüsünden Yapay Zeka Sanal Tur sayfasına yönlendirme
    When Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir
    And Açılan menünün 2 sırasındaki seçeneğe tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/ai-virtual-tour sayfasına yönlendirilir

  Scenario: Erken erişim talebinde bulunma ve başarı onayı alma
    Given Kullanıcı aistager.ai/tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And Açılan form içerisine geçerli e-posta adresini ve zorunlu bilgileri girer
    And Gönder butonuna tıklar
    Then Talep sistem üzerinden başarıyla kaydedilir
    And Kullanıcıya başarılı gönderim onay mesajı gösterilir

  Scenario: Header menüsünden Sanal Dekorasyon API sayfasına yönlendirme
    When Kullanıcı Header üzerindeki Ürünler alanı üzerine gelir
    And Açılan menünün 3 sırasındaki seçeneğe tıklar
    Then Kullanıcı başarıyla aistager.ai/tr/api sayfasına yönlendirilir

  Scenario: API sayfası üzerinden iletişim formu doldurma ve onay alma
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar
    And Açılan formdaki ad e-posta ve mesaj alanlarını geçerli bilgilerle doldurur
    And Formu gönderir
    Then Talebin iletildiğine dair kullanıcıya onay mesajı gösterilir

  Scenario: Fiyatlandırma sayfasına hatasız geçiş yapma
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Pricing sayfasına yönlendirilir

  Scenario: Eksik bilgilerle API iletişim formu gönderme denemesi
    Given Kullanıcı aistager.ai/tr/api sayfasındadır
    When Kullanıcı İletişime Geçin formundaki zorunlu alanları ad e-posta veya mesaj boş bırakarak gönderir
    Then Form gönderilmemelidir
    And Eksik alanlar için hata uyarıları görüntülenmelidir