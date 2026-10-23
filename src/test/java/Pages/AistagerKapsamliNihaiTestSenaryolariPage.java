package Pages;

import Pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AistagerKapsamliNihaiTestSenaryolariPage extends BasePage {

    public AistagerKapsamliNihaiTestSenaryolariPage() {
        super();
    }

    public Locator getAcceptCookiesButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tümünü Kabul Et"));
    }

    public Locator getBeforeAfterMagicText() {
        return page.getByText("Öncesi ve Sonrası Sihri");
    }

    public Locator getSliderHandle() {
        return page.getByRole(AriaRole.SLIDER, new Page.GetByRoleOptions().setName("Slider Handle"));
    }

    public Locator getBeforeText() {
        return page.getByText("Önce");
    }

    public Locator getNextRoomButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sonraki Oda"));
    }

    public Locator getPage1IndicatorButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sayfa 1"));
    }

    public Locator getUploadRoomButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Odanızı Yükleyin"));
    }

    public Locator getLoginLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Giriş yap"));
    }

    public Locator getTryForFreeLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ücretsiz Dene"));
    }

    public Locator getMyGenerationsLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Üretimlerim"));
    }

    public Locator getLivingRoomButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Oturma Odası"));
    }

    public Locator getLoadMoreDesignsButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Daha Fazla Tasarım Yükle"));
    }

    public Locator getContactUsLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bize ulaşın."));
    }

    public Locator getPrivacyPolicyLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gizlilik Politikası"));
    }

    public Locator getTermsOfServiceLink() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hizmet Şartları"));
    }

    public Locator getEmailInput() {
        return page.getByPlaceholder("you@example.com");
    }

    public Locator getPasswordInput() {
        return page.getByPlaceholder("Min. 8 karakter");
    }

    public Locator getConfirmPasswordInput() {
        return page.getByPlaceholder("Şifrenizi tekrar girin");
    }

    public Locator getGoogleContinueButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google ile devam et"));
    }

    public Locator getTermsCheckbox() {
        return page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("on"));
    }

    public Locator getCreateAccountButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hesap Oluştur"));
    }

    public void navigateToHomePage() {
        page.navigate("https://aistager.ai");
    }

    public void acceptCookies() {
        myClick(getAcceptCookiesButton());
    }

    public void verifyBeforeAfterMagicText() {
        verifyContainsText(getBeforeAfterMagicText(), "Öncesi ve Sonrası Sihri");
    }

    public void dragSliderHandleRight() {
        Locator slider = getSliderHandle();
        slider.dragTo(slider, new Locator.DragToOptions().setTargetPosition(100, 0));
    }

    public void verifyBeforeText() {
        verifyContainsText(getBeforeText(), "Önce");
    }

    public void clickNextRoomButton() {
        myClick(getNextRoomButton());
    }

    public void clickPage1Indicator() {
        myClick(getPage1IndicatorButton());
    }

    public void clickUploadRoomButton() {
        myClick(getUploadRoomButton());
    }

    public void clickLoginLink() {
        myClick(getLoginLink());
    }

    public void clickTryForFreeLink() {
        myClick(getTryForFreeLink());
    }

    public void clickMyGenerationsLink() {
        myClick(getMyGenerationsLink());
    }

    public void clickLivingRoomButton() {
        myClick(getLivingRoomButton());
    }

    public void clickLoadMoreDesignsButton() {
        myClick(getLoadMoreDesignsButton());
    }

    public void clickContactUsLink() {
        myClick(getContactUsLink());
    }

    public void clickPrivacyPolicyLink() {
        myClick(getPrivacyPolicyLink());
    }

    public void clickTermsOfServiceLink() {
        myClick(getTermsOfServiceLink());
    }

    public void navigateToLoginPage() {
        page.navigate("https://aistager.ai/login");
    }

    public void fillLoginEmail(String email) {
        mySendKeys(getEmailInput(), email);
    }

    public void fillLoginPassword(String password) {
        mySendKeys(getPasswordInput(), password);
    }

    public void clickGoogleContinueButton() {
        myClick(getGoogleContinueButton());
    }

    public void navigateToRegisterPage() {
        page.navigate("https://aistager.ai/register");
    }

    public void fillRegisterEmail(String email) {
        mySendKeys(getEmailInput(), email);
    }

    public void fillRegisterPassword(String password) {
        mySendKeys(getPasswordInput(), password);
    }

    public void fillRegisterConfirmPassword(String password) {
        mySendKeys(getConfirmPasswordInput(), password);
    }

    public void checkTermsCheckbox() {
        myCheckBox(getTermsCheckbox());
    }

    public void clickCreateAccountButton() {
        myClick(getCreateAccountButton());
    }
}