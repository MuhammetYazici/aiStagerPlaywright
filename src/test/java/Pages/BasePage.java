package Pages;

import com.microsoft.playwright.Page;
import Utilities.PD;

public class BasePage {
    protected Page page;

    public BasePage() {
        this.page = PD.getPage();
    }
}