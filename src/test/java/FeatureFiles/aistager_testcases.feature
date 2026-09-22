# language: en
@AiStager @CoreFeatures @E2E
Feature: AiStager.ai Core Features and Product Navigation Flows
  As a logged in user, I want to perform virtual staging, 
  AI image editing, and access other product pages such as Virtual Tour and API.

  Background:
    Given Kullanıcı sisteme giriş yapmış durumdadır

  @Positive @VirtualStaging
  Scenario: Desteklenen formatta görsel yükleme ve başarılı Sanal Dekorasyon üretimi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta .jpg veya .png bir boş oda görseli yükler
    Then Görselin önizlemesi ekranda görünmelidir
    And Mevcut mobilyaları kaldır toggle unsurunun varsayılan olarak açık geldiği görülmelidir
    And Kullanıcı Oda Türü olarak Oturma Odası seçer
    And Kullanıcı Tasarım Stili olarak Modern seçer
    And Kullanıcı görünürlük tercihlerini belirler
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then AI süreci başlamalı ve işlem tamamlandığında oda seçilen stil ve türde mobilyalandırılmış olarak sunulmalıdır

  @Negative @VirtualStaging @Validation
  Scenario: Zorunlu alanlar seçilmeden dekorasyon oluşturulamaması
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenen formatta bir boş oda görseli yükler
    And Kullanıcı Oda Türü veya Tasarım Stili seçimlerinden birini veya ikisini boş bırakır
    And Kullanıcı Dekorasyon Oluştur butonuna tıklar
    Then Sistem dekorasyon oluşturma işlemine izin vermemeli ve uyarı mesajı göstermelidir

  @EdgeCase @VirtualStaging
  Scenario: Desteklenmeyen dosya formatında görsel yüklenmesi
    Given Kullanıcı Virtual Staging sayfasındadır
    When Kullanıcı desteklenmeyen formatta örn .gif veya .bmp bir dosya yüklemeye çalışır
    Then Sistem dosyanın kabul edilmediğine dair bir hata mesajı göstermelidir

  @Positive @AIEdit
  Scenario: Varsayılan seçili görsel ile AI Edit üzerinden başarılı metin tabanlı modifikasyon
    Given Kullanıcı AI Edit sekmesindedir
    And Kaynak görsel olarak varsayılan seçili gelen Current image kullanılmaktadır
    When Kullanıcı Describe what to change alanına "Remove the chair" metin talimatını girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem girilen metin talimatını işlemelidir
    And Görsel üzerinde istenen değişiklikler uygulanarak güncel görsel kullanıcıya sunulmalıdır

  @Positive @AIEdit
  Scenario: Yeni görsel yükleyerek AI Edit üzerinden başarılı modifikasyon
    Given Kullanıcı AI Edit sekmesindedir
    When Kullanıcı AI Edit için yeni bir görsel yükler
    And Kullanıcı Describe what to change alanına geçerli bir metin talimatı girer
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem güncel görseli başarıyla oluşturup sunmalıdır

  @Negative @AIEdit @Validation
  Scenario: Boş talimat metni ile AI Edit tetiklenmesi
    Given Kullanıcı AI Edit sekmesindedir
    When Kullanıcı Describe what to change alanını boş bırakır
    And Kullanıcı Edit Photo butonuna tıklar
    Then Sistem işleme izin vermemeli ve metin girilmesi gerektiğini belirten bir uyarı göstermelidir

  @Positive @Navigation @VirtualTour
  Scenario: Ana menüden Yapay Zeka Sanal Tur sayfasına başarılı navigasyon
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler menüsüne hover yapar
    And Açılan listeden Yapay Zeka Sanal Tur seçeneğine tıklar
    Then Kullanıcı doğru hedef URL olan /tr/ai-virtual-tour sayfasına yönlendirilmelidir

  @Positive @VirtualTour @EarlyAccess
  Scenario: Sanal Tur sayfasından başarılı Erken Erişim başvurusu
    Given Kullanıcı /tr/ai-virtual-tour sayfasındadır
    When Kullanıcı sayfadaki Erken Erişim İsteyin butonuna tıklar
    And Açılan kayıt formunda zorunlu alan olan e-posta adresini girer
    And Formu gönderir
    Then Sistem başarılı kayıt onay mesajını göstermelidir

  @Negative @VirtualTour @Validation
  Scenario: Eksik e-posta bilgisi ile Erken Erişim talebinde bulunulması
    Given Kullanıcı /tr/ai-virtual-tour sayfasındadır
    When Kullanıcı Erken Erişim İsteyin butonuna tıklar
    And E-posta alanını boş bırakarak formu göndermeye çalışır
    Then Sistem hata mesajı vermeli ve formun gönderilmesini engellemelidir

  @Positive @Navigation @API
  Scenario: Ana menüden Sanal Dekorasyon API sayfasına başarılı navigasyon
    Given Kullanıcı ana sayfadadır
    When Kullanıcı header alanındaki Ürünler menüsüne hover yapar
    And Açılan listeden Sanal Dekorasyon API seçeneğine tıklar
    Then Kullanıcı doğru hedef URL olan /tr/api sayfasına yönlendirilmelidir

  @Positive @API @Contact
  Scenario: API sayfasından iletişim formu doldurularak başarılı mesaj gönderimi
    Given Kullanıcı /tr/api sayfasındadır
    When Kullanıcı sayfa üstündeki İletişime Geçin butonuna tıklar
    And İletişim formundaki ad, e-posta ve mesaj alanlarını eksiksiz doldurur
    And Formu gönderir
    Then Sistem başarılı gönderim mesajı göstermelidir

  @Negative @API @Contact @Validation
  Scenario: İletişim formunda zorunlu alanların eksik bırakılması
    Given Kullanıcı /tr/api sayfasındadır
    When Kullanıcı İletişime Geçin butonuna tıklar
    And Ad, e-posta veya mesaj alanlarından birini boş bırakarak formu gönderir
    Then Sistem eksik alanlar için validasyon uyarıları göstermelidir

  @Positive @API @Pricing
  Scenario: API sayfasından Fiyatlandırma sayfasına hatasız yönlendirme
    Given Kullanıcı /tr/api sayfasındadır
    When Kullanıcı sayfa altındaki Fiyatlandırmayı Görüntüle butonuna tıklar
    Then Kullanıcı hatasız bir şekilde Fiyatlandırma sayfasına yönlendirilmelidir