package Pages;

import Utilities.PD;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage() {
        this.page = PD.getPage();
    }
}