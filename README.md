🤖 AI-Agent Test Automation Pipeline (Doc-to-Test)
Uçtan uca otonom test mühendisliği ekosistemi: Ham iş gereksinim dokümanlarını (.xlsx / .docx) analiz eden, canlı web sayfasını Playwright ile keşfeden, Java/Playwright BDD test kodlarını deterministik sözleşmelerle üreten, derleme hatalarını Maven seviyesinde kendi kendine onaran (Self-Healing) ve test paketini GitHub Actions'a aktaran çok ajanlı (multi-agent) otomasyon mimarisi.

📌 Projenin Doğuş Amacı ve Çözülen Sektörel Sorunlar
Geleneksel LLM tabanlı kod üreticileri, test otomasyonunda pratikte çalışmayan ve bakımı imkânsız kodlar üretir. Bu projenin çözdüğü temel problemler şunlardır:

Halüsinasyon Kaynaklı Sahte Sınıflar: Modellerin projede var olmayan sınıfları (DriverFactory, ReusableMethods, org.junit.*) çağırması engellendi; mimari tamamen TestNG, BasePage ve PicoContainer odaklı kilitlendi.

Kör Locator (Seçici) Üretimi: Sayfayı görmeden uydurulan kırılgan CSS/XPath seçicileri yerine, Playwright ile çalışan Planner Agent canlı tarayıcıda DOM ve Erişilebilirlik Ağacını (AOM) tarayarak semantik ve gerçek seçiciler (getByRole, getByPlaceholder) belirler.

IDE ve Cucumber Expression Uyuşmazlığı: Tırnak işaretlerinin kaçış hataları yüzünden IntelliJ/Eclipse üzerinde adımların sarı renkte tanımsız (Undefined Step) kalması, dinamik {string} sözleşmesiyle kökten çözüldü.

Derleme Döngüsü Yorgunluğu: Üretilen kodların Maven derleyicisi (mvn test-compile) çıktılarıyla beslenen Healer Agent sayesinde insan müdahalesine gerek kalmadan mikro-yamalarla (patch) kendi kendini iyileştirmesi sağlandı.

🏗️ Çok Ajanlı (Multi-Agent) Mimari Şeması

```text
       [ İş Analizi Dokümanı (.xlsx / .docx) ]
                         │
                         ▼
             [ User Story & Kural Çıkarıcı ]
                         │
                         ▼
         [ Deterministik Gherkin Normalizasyonu ]
                         │
                         ▼
        ┌──────────────────────────────────┐
        │       1. PLANNER AGENT           │
        │  • Playwright Headless Keşif     │
        │  • DOM & AOM (Aria Ağacı) Analizi│
        │  • Eylem Planı (Action Plan JSON)│
        └──────────────────────────────────┘
                         │
                         ▼
        ┌──────────────────────────────────┐
        │      2. GENERATOR AGENT          │
        │  • Cucumber CLI Resmi Sözleşmesi │
        │  • Şablon Tabanlı Runner         │
        │  • BasePage & Playwright Pages   │
        │  • StepDef (PicoContainer Entegre│
        └──────────────────────────────────┘
                         │
                         ▼
        ┌──────────────────────────────────┐
        │       3. HEALER AGENT            │ ◄───┐
        │  • Maven 'test-compile' Analizi  │     │ Hata Varsa
        │  • Compiler Debugger Onarımı     │ ────┘ (Döngü: 1-3)
        │  • Canlı Dosya Yamalama (Patch)  │
        └──────────────────────────────────┘
                         │
                         ▼ (BUILD SUCCESS)
        ┌──────────────────────────────────┐
        │   Git Otonom Commit & Push       │
        └──────────────────────────────────┘
                         │
                         ▼
        [ GitHub Actions CI/CD Test Koşumu ]


🧩 Adım Adım Çalışma Yaşam Döngüsü
1. Doküman İşleme & User Story Çıkarımı (Aşama 0)
input_docs/ dizinine bırakılan .docx veya .xlsx dosyaları openpyxl ve python-docx motorlarıyla taranır.

Ham tablolardaki dağınık veriler ve revizyon notları filtrelenerek saf İş Kuralları (Business Rules) ve test edilebilir Kullanıcı Hikayesi (User Story) formatına dönüştürülür.

2. BDD Feature Üretimi & Regex Temizleme (Aşama 1)
Çıkarılan hikaye eksiksiz bir Gherkin .feature metnine dönüştürülür.

Deterministik Sanitizer: LLM'in üretebileceği parantez karmaşaları, markdown kalıntıları ve tırnak hataları sıfır token harcanarak Python Regex ile temizlenir.

3. Cucumber CLI Resmi Sözleşmesi (Aşama 2.5)
Feature dosyası diske kaydedildikten sonra arka planda mvn test -Dcucumber.execution.dry-run=true çalıştırılır.

Cucumber CLI motorunun ürettiği resmi Java metot imzaları ("Snippets") doğrudan CLI çıktısından çekilir. Bu liste sonraki aşamada model için bağlayıcı bir sözleşme (contract) görevi görür.

4. Planner Agent: Canlı Web Keşfi (Aşama 3)
Playwright Chromium headless olarak başlatılır ve senaryodaki ilgili URL'ye gider (ör. /login, /virtual-staging, /register).

Sayfanın AOM (Accessibility Object Model) ağacındaki butonlar, metin kutuları, linkler ve placeholder'lar ayıklanır.

Planner, Gherkin adımlarını canlı elementlerle eşleştirerek JSON formatında net bir Eylem Planı (Execution Plan) oluşturur.

5. Generator Agent: Java Test Sınıflarının Üretimi (Aşama 4)
Runner: Olası LLM sentaks hatalarını önlemek amacıyla TestNG Runner sınıfı deterministik saf Java şablonuyla diske yazılır.

Pages Sınıfı: BasePage sınıfını extends eden, AOM seçicileri (getByRole, getByPlaceholder) ve hazır framework metotlarını (myClick, mySendKeys) kullanan Page Object sınıfı üretilir.

Steps Sınıfı: Cucumber CLI sözleşmesini baz alır, nesneleri PicoContainer Constructor Injection (TestContext) ile bağlar ve dinamik verileri {string} parametreleriyle karşılar.

6. Healer Agent: Otonom Derleme & Mikro-Onarım (Aşama 5)
mvn test-compile komutu koşturulur.

Eğer derleme hatası (cannot find symbol, incompatible types vb.) alınırsa hata logunun son kısmı ayıklanır.

Healer Agent hatanın kaynağını analiz ederek sadece ilgili Page veya Step sınıfı için onarılmış kodu döndürür ve dosya üzerine yazar. Derleme BUILD SUCCESS olana kadar en fazla 3 deneme yapılır.

7. Git Senkronizasyonu & CI/CD Handoff (Aşama 6)
Yalnızca Maven derleme testinden başarıyla geçen kodlar git add ., otomatik zaman damgalı git commit ve git push origin main ile depoya aktarılır.

Tetiklenen GitHub Actions iş akışı, bulut üzerinde testleri headless modda koşturarak raporları üretir.

🛠️ Teknoloji Yığını ve Entegrasyonlar

| Katman | Araç / Teknoloji | Görevi / Rolü |
|---|---|---|
| **Ajan Çatısı** | Python 3.10+, Google GenAI SDK | Ajan orkestrasyonu, karar mekanizmaları ve API haberleşmesi |
| **Geliştirme & Protokol** | VS Code, PyCharm, Model Context Protocol (MCP) | Sanal ortam yönetimi, bağlam standardizasyonu ve dosya sistemi işlemleri |
| **Canlı Sayfa Analizi** | Playwright Python | DOM ve AOM ağacının headless taranması, element metadata çıkarımı |
| **Test Framework** | Java 11+, TestNG, Cucumber | BDD senaryoları, assertion yapıları ve koşum yönetimi |
| **Tarayıcı Otomasyonu** | Microsoft Playwright Java | Page Object modeli üzerinde uçtan uca UI test yürütümü |
| **Dependency Injection**| Cucumber PicoContainer | Thread-safe veri aktarımı ve senaryolar arası `TestContext` yönetimi |
| **Derleme & Doğrulama**| Apache Maven | CLI üzerinden derleme doğrulama ve CLI sözleşme çıkarımı |
| **Doküman Ayrıştırma** | `openpyxl`, `python-docx` | `.xlsx` ve `.docx` iş gereksinimlerinin okunması |
| **CI/CD** | Git, GitHub Actions | Doğrulanmış kodların otomatik commit, push ve uzaktan koşumu |


🛡️ Sağlamlık ve Hata Toleransı (Resilience Layer)
Exponential Backoff & API Koruması: 503 Unavailable veya 429 Resource Exhausted hatalarında istekler düşürülmez; süre katlanarak (5s, 10s, 15s...) beklenir ve API penceresi koruma altına alınır.

Model Fallback Katmanı: Yoğunluk anında sistem otomatik olarak sıradaki kararlı Gemini modeline geçiş yapar.

Bozuk Kod Engeli: Derleme aşamasını geçemeyen hiçbir senaryo depoya pushlanmaz; main branch her zaman çalışır durumda tutulur.

📁 Proje Dizin Yapısı

```text
.
├── input_docs/                   # Analiz edilecek .xlsx veya .docx dosyaları
├── scenario_pipeline.py          # Çok ajanlı ana orkestrasyon betiği
├── .env                          # API konfigürasyonları (GEMINI_API_KEY)
└── aiStagerPlaywright/           # Java TestNG + Playwright Hedef Projesi
    ├── pom.xml
    └── src/test/java/
        ├── FeatureFiles/         # Üretilen .feature senaryo dosyaları
        ├── Pages/                # Üretilen Page Object sınıfları (BasePage türevleri)
        ├── StepDefinations/      # Üretilen Cucumber adım tanımları (Steps)
        ├── Runners/              # Deterministik TestNG Runner sınıfları
        └── Utilities/            # TestContext, Playwright Driver (PD), Hooks
