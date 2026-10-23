package Pages;

import Pages.BasePage;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AistagerTestcasesPage extends BasePage {

    public AistagerTestcasesPage() {
        super();
    }

    // Locators
    public Locator getAcceptCookiesButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getEmailInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getPasswordInput() {
        return page.getByPlaceholder("••••••••");
    }

    public Locator getLoginButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    public Locator getRemoveFurnitureCheckbox() {
        return page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Mevcut mobilyaları kaldır"));
    }

    public Locator getPublicVisibilityRadio() {
        return page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Herkese Açık"));
    }

    public Locator getUploadImageButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Görsel Yükle"));
    }

    public Locator getPreviewImage() {
        return page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Önizleme"));
    }

    public Locator getRoomTypeSelect() {
        return page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Oda Türü"));
    }

    public Locator getDesignStyleSelect() {
        return page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Tasarım Stili"));
    }

    public Locator getCreateDecorationButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dekorasyon Oluştur"));
    }

    public Locator getResultImage() {
        return page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Sonuç Görseli"));
    }

    public Locator getUnsupportedFormatAlert() {
        return page.getByRole(AriaRole.ALERT, new Page.GetByRoleOptions().setName("Desteklenmeyen dosya formatı"));
    }

    public Locator getAiEditTab() {
        return page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("AI Edit"));
    }

    public Locator getCurrentImageRadio() {
        return page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Current image"));
    }

    public Locator getPromptInput() {
        return page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Komut girin"));
    }

    public Locator getEditPhotoButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit Photo"));
    }

    public Locator getProcessingProgressBar() {
        return page.getByRole(AriaRole.PROGRESSBAR, new Page.GetByRoleOptions().setName("İşleniyor"));
    }

    public Locator getEditedImage() {
        return page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Düzenlenmiş Görsel"));
    }

    public Locator getMoreInfoLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Daha fazla bilgi"));
    }

    public Locator getProductsMenuButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ürünler"));
    }

    public Locator getAiVirtualTourLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yapay Zeka Sanal Tur"));
    }

    public Locator getVirtualStagingApiLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sanal Dekorasyon API"));
    }

    public Locator getFullNameInput() {
        return page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Ad Soyad"));
    }

    public Locator getRequestEarlyAccessButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Erken Erişim İsteyin"));
    }

    public Locator getEarlyAccessSuccessAlert() {
        return page.getByRole(AriaRole.ALERT, new Page.GetByRoleOptions().setName("Talebiniz başarıyla alındı"));
    }

    public Locator getEarlyAccessDialog() {
        return page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Erken Erişim Formu"));
    }

    public Locator getConfirmationStatus() {
        return page.getByRole(AriaRole.STATUS, new Page.GetByRoleOptions().setName("Talebiniz iletilmiştir"));
    }

    public Locator getSubmitButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Gönder"));
    }

    public Locator getInvalidEmailAlert() {
        return page.getByRole(AriaRole.ALERT, new Page.GetByRoleOptions().setName("Geçerli bir e-posta adresi giriniz"));
    }

    public Locator getRequiredFieldAlert() {
        return page.getByRole(AriaRole.ALERT, new Page.GetByRoleOptions().setName("Bu alan zorunludur"));
    }

    public Locator getContactDialog() {
        return page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("İletişime Geçin"));
    }

    public Locator getContactSuccessStatus() {
        return page.getByRole(AriaRole.STATUS, new Page.GetByRoleOptions().setName("Mesajınız başarıyla iletildi"));
    }

    public Locator getViewPricingLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fiyatlandırmayı Görüntüle"));
    }

    // Step Actions & Verifications
    public void acceptCookies() {
        myClick(getAcceptCookiesButton());
    }

    public void login(String email, String password) {
        mySendKeys(getEmailInput(), email);
        mySendKeys(getPasswordInput(), password);
        myClick(getLoginButton());
    }

    public void verifyRemoveFurnitureOptionChecked() {
        assertThat(getRemoveFurnitureCheckbox()).isChecked();
    }

    public void verifyPublicVisibilityChecked() {
        assertThat(getPublicVisibilityRadio()).isChecked();
    }

    public void uploadImage(String filePath) {
        getUploadImageButton().setInputFiles(Paths.get(filePath));
    }

    public void verifyPreviewImageDisplayed() {
        assertThat(getPreviewImage()).isVisible();
    }

    public void verifyPreviewImageHidden() {
        assertThat(getPreviewImage()).isHidden();
    }

    public void selectRoomType(String roomType) {
        getRoomTypeSelect().selectOption(roomType);
    }

    public void selectDesignStyle(String designStyle) {
        getDesignStyleSelect().selectOption(designStyle);
    }

    public void clickCreateDecoration() {
        myClick(getCreateDecorationButton());
    }

    public void verifyCreateDecorationButtonDisabled() {
        assertThat(getCreateDecorationButton()).isDisabled();
    }

    public void verifyResultImageDisplayed() {
        assertThat(getResultImage()).isVisible();
    }

    public void verifyUnsupportedFormatAlertDisplayed() {
        assertThat(getUnsupportedFormatAlert()).isVisible();
    }

    public void clickAiEditTab() {
        myClick(getAiEditTab());
    }

    public void verifyCurrentImageRadioChecked() {
        assertThat(getCurrentImageRadio()).isChecked();
    }

    public void enterEditPrompt(String prompt) {
        mySendKeys(getPromptInput(), prompt);
    }

    public void clearEditPrompt() {
        getPromptInput().fill("");
    }

    public void clickEditPhoto() {
        myClick(getEditPhotoButton());
    }

    public void verifyProcessingState() {
        assertThat(getProcessingProgressBar()).isVisible();
    }

    public void verifyEditedImageDisplayed() {
        assertThat(getEditedImage()).isVisible();
    }

    public void verifyEditPhotoButtonDisabled() {
        assertThat(getEditPhotoButton()).isDisabled();
    }

    public void verifyHomePageDisplayed() {
        assertThat(getMoreInfoLink()).isVisible();
    }

    public void openProductsMenu() {
        myClick(getProductsMenuButton());
    }

    public void clickAiVirtualTour() {
        myClick(getAiVirtualTourLink());
    }

    public void clickVirtualStagingApi() {
        myClick(getVirtualStagingApiLink());
    }

    public void verifyCurrentUrl(String expectedUrlFragment) {
        assertThat(page).hasURL(Pattern.compile(".*" + Pattern.quote(expectedUrlFragment) + ".*"));
    }

    public void fillEarlyAccessFullName(String fullName) {
        mySendKeys(getFullNameInput(), fullName);
    }

    public void fillEarlyAccessEmail(String email) {
        mySendKeys(getEmailInput(), email);
    }

    public void clickRequestEarlyAccess() {
        myClick(getRequestEarlyAccessButton());
    }

    public void verifyEarlyAccessRequestSuccess() {
        assertThat(getEarlyAccessSuccessAlert()).isVisible();
    }

    public void verifyEarlyAccessFormClosed() {
        assertThat(getEarlyAccessDialog()).isHidden();
    }

    public void verifyEarlyAccessFormVisible() {
        assertThat(getEarlyAccessDialog()).isVisible();
    }

    public void verifyConfirmationNotificationDisplayed() {
        assertThat(getConfirmationStatus()).isVisible();
    }

    public void clickSubmit() {
        myClick(getSubmitButton());
    }

    public void verifyInvalidEmailErrorDisplayed() {
        assertThat(getInvalidEmailAlert()).isVisible();
    }

    public void fillContactEmail(String email) {
        mySendKeys(getEmailInput(), email);
    }

    public void clearContactEmail() {
        getEmailInput().fill("");
    }

    public void verifyRequiredFieldErrorDisplayed() {
        assertThat(getRequiredFieldAlert()).isVisible();
    }

    public void verifyContactFormVisible() {
        assertThat(getContactDialog()).isVisible();
    }

    public void verifyContactSuccessMessageDisplayed() {
        assertThat(getContactSuccessStatus()).isVisible();
    }

    public void verifyContactFormClosed() {
        assertThat(getContactDialog()).isHidden();
    }

    public void clickViewPricing() {
        myClick(getViewPricingLink());
    }
}