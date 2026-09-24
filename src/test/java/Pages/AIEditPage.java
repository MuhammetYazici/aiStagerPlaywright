package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Utilities.PD;

public class AIEditPage {
    private Page page;

    public AIEditPage() {
        this.page = PD.getPage();
    }

    public Locator getAIEditTab() {
        return page.locator("text='AI Edit', a:has-text('AI Edit')");
    }

    public Locator getCurrentImageOption() {
        return page.locator("text='Current image', input[value='current']");
    }

    public Locator getDescribeWhatToChangeInput() {
        return page.locator("textarea[placeholder*='Describe'], input[placeholder*='Describe'], #describe-change");
    }

    public Locator getEditPhotoButton() {
        return page.locator("button:has-text('Edit Photo')");
    }

    public Locator getEditedImageResult() {
        return page.locator(".edited-result-image, img[alt='edited']");
    }

    public Locator getNewImageUploadInput() {
        return page.locator("input[type='file'].edit-upload");
    }

    public Locator getWarningMessage() {
        return page.locator("text='Lütfen yapılacak değişikliği açıklayın', .alert-warning");
    }

    public Locator getErrorGenericMessage() {
        return page.locator("text='hata', text='anlayamadım', .error-box");
    }
}