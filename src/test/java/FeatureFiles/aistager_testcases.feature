# language: tr
Feature: AiStager.ai Temel Yetenekler ve Ürün Gezinimi

  Background:
    Given Kullanici AiStager platformundadir

  @virtual_staging @positive
  Scenario: Gecerli parametreler ve dosya ile basarili Sanal Dekorasyon olusturma
    Given Kullanici Virtual Staging sayfasindadir
    When "salon.jpg" formatinda gecerli bir bos oda gorseli yuklerim
    And Oda Turu olarak Yatak Odasi secerim
    And Tasarim Stili olarak Modern secerim
    And Mevcut mobilyalari kaldir toggle'inin varsayilan olarak acik oldugunu gorurum
    And Dekorasyon Olustur butonuna tiklarim
    Then sistem yuklenen odayi girilen parametrelere uygun olarak mobilyalandirilmis yeni bir gorsel uretmelidir

  @virtual_staging @negative
  Scenario: Desteklenmeyen dosya formati ile Sanal Dekorasyon yukleme denemesi
    Given Kullanici Virtual Staging sayfasindadir
    When yukleme alanina ".txt" veya ".pdf" formatinda bir dosya yuklemeye calisirim
    Then sistem "Geçersiz dosya formatı. Lütfen .jpg veya .png yükleyiniz" hata mesajini gostermelidir
    And Dekorasyon Olustur butonu pasif kalmalidir

  @virtual_staging @edge_case
  Scenario: Zorunlu parametreler secilmeden Sanal Dekorasyon olusturma denemesi
    Given Kullanici Virtual Staging sayfasindadir
    When gecerli bir ".png" gorseli yuklerim
    And Oda Turu veya Tasarim Stili secimlerinden birini bos birakarak Dekorasyon Olustur butonuna tiklarim
    Then sistem "Lütfen zorunlu alanları doldurun" uyarisi vermelidir
    And islem baslatilmamalidir

  @ai_edit @positive
  Scenario: Mevcut gorsel uzerinde metin komutu ile basarili AI Edit uygulama
    Given Kullanici AI Edit sayfasindadir
    When Current image seceneginin varsayilan olarak secili oldugunu gorurum
    And Describe what to change alanina "Remove the chair" metin komutunu girerim
    And Edit butonuna tiklarim
    Then sistem kaynak gorsel uzerinde sandalyenin kaldirildigi guncel gorseli uretmelidir

  @ai_edit @negative
  Scenario: Metin komutu girmeden AI Edit uygulama denemesi
    Given Kullanici AI Edit sayfasindadir
    When Describe what to change alanini bos birakarak Edit butonuna tiklarim
    Then sistem "Lütfen bir düzenleme talimatı girin" uyarisi vermelidir

  @virtual_tour @positive
  Scenario: Yapay Zeka Sanal Tur sayfasina giderek erken erisim talebi olusturma
    Given Kullanici ana sayfadadir
    When Urunler menusune gelip acilan dropdown listeden Yapay Zeka Sanal Tur secenegine tiklarim
    Then kullanici aistager.ai/tr/ai-virtual-tour sayfasina yonlendirilmelidir
    When sayfadaki Erken Erişim İsteyin butonuna tiklarim
    And zorunlu E-posta alanina "test@example.com" adresini girip formu gonderirim
    Then sistem uzerinde basari mesaji goruntulenmelidir

  @api_page @positive
  Scenario: Sanal Dekorasyon API sayfasi iletisim formu gonderimi ve fiyatlandirma yonlendirmesi
    Given Kullanici ana sayfadadir
    When Urunler dropdown menusunden Sanal Dekorasyon API secenegine tiklarim
    Then kullanici aistager.ai/tr/api sayfasina yonlendirilmelidir
    When sayfanin ust kismindaki İletişime Geçin butonuna tiklarim
    And ad, e-posta ve mesaj alanlarini doldurup formu basariyla gonderirim
    Then sistem basari onay mesaji gostermelidir
    When sayfanin alt kisminda bulunan Fiyatlandırmayı Görüntüle butonuna tiklarim
    Then kullanici hatasiz olarak Fiyatlandirma sayfasina yonlendirilmelidir