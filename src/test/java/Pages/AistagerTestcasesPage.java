package Pages;

import Pages.BasePage;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class AistagerTestcasesPage extends BasePage {

    public AistagerTestcasesPage() {
        super();
    }

    public void navigateToHomePage() {
        page.navigate("/");
    }

    public void navigateToVirtualTourPage() {
        page.navigate("/tr/ai-virtual-tour");
    }

    public void navigateToApiPage() {
        page.navigate("/tr/api");
    }

    public void clickVirtualStagingButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sanal Dekorasyon")).click();
    }

    public void uploadFile(String fileName) {
        page.locator("input[type='file']").setInputFiles(Paths.get(fileName));
    }

    public void verifyPreviewImageVisible() {
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Önizleme"))).isVisible();
    }

    public void verifyPreviewImageHidden() {
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Önizleme"))).isHidden();
    }

    public void verifyRemoveFurnitureSwitchChecked() {
        assertThat(page.getByRole(AriaRole.SWITCH, new Page.GetByRoleOptions().setName("on"))).isChecked();
    }

    public void selectRoomType(String roomType) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Oda türü seçin...")).selectOption(roomType);
    }

    public void selectDesignStyle(String designStyle) {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Tasarım stili seçin...")).selectOption(designStyle);
    }

    public void verifyRoomTypeDropdownEmpty() {
        assertThat(page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Oda türü seçin..."))).hasValue("");
    }

    public void clickCreateDecorationButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur")).click();
    }

    public void verifyCreateDecorationButtonDisabled() {
        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"))).isDisabled();
    }

    public void verifyProcessingStatusVisible() {
        assertThat(page.getByText("İşleniyor")).isVisible();
    }

    public void verifyResultImageVisible() {
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Sonuç Görseli"))).isVisible();
    }

    public void verifyInvalidFormatErrorMessage() {
        assertThat(page.getByText("Yalnızca JPG veya PNG formatları desteklenmektedir")).isVisible();
    }

    public void clickAiEditTab() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yapay Zeka Düzenleme")).click();
    }

    public void verifySourceImageVisible() {
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Kaynak Görsel"))).isVisible();
    }

    public void fillDescribeWhatToChange(String instruction) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe what to change")).fill(instruction);
    }

    public void clickEditPhotoButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo")).click();
    }

    public void verifyEditPhotoButtonDisabled() {
        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"))).isDisabled();
    }

    public void verifyEditedImageVisible() {
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("İşlenmiş Görsel"))).isVisible();
    }

    public void verifyInvalidCommandWarningVisible() {
        assertThat(page.getByText("Lütfen geçerli bir komut girin")).isVisible();
    }

    public void clickProductsMenuButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ürünler")).click();
    }

    public void clickAiVirtualTourLink() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yapay Zeka Sanal Tur")).click();
    }

    public void verifyVirtualTourUrl() {
        assertThat(page).hasURL(Pattern.compile(".*/tr/ai-virtual-tour.*"));
    }

    public void clickRequestEarlyAccessButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin")).click();
    }

    public void fillEmailField(String email) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-posta")).fill(email);
    }

    public void clickSubmitButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder")).click();
    }

    public void verifySubmitButtonEnabled() {
        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"))).isEnabled();
    }

    public void verifyRequestReceivedConfirmationMessage() {
        assertThat(page.getByText("Talebiniz başarıyla alındı")).isVisible();
    }

    public void verifyInvalidEmailErrorMessage() {
        assertThat(page.getByText("Geçerli bir e-posta adresi giriniz")).isVisible();
    }

    public void clickApiLink() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("API")).click();
    }

    public void verifyApiUrl() {
        assertThat(page).hasURL(Pattern.compile(".*/tr/api.*"));
    }

    public void clickContactUsButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("İletişime Geçin")).click();
    }

    public void fillFullNameField(String fullName) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Ad Soyad")).fill(fullName);
    }

    public void verifyFormSubmittedConfirmationMessage() {
        assertThat(page.getByText("Mesajınız başarıyla iletildi")).isVisible();
    }

    public void clickViewPricingLink() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fiyatlandırma")).click();
    }

    public void verifyPricingUrl() {
        assertThat(page).hasURL(Pattern.compile(".*/tr/pricing.*"));
    }

    public void verifyRequiredFieldErrorVisible() {
        assertThat(page.getByText("Bu alan zorunludur")).isVisible();
    }
}