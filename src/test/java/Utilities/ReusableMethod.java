package Utilities;

import Pages.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ReusableMethod{
    private final Page page;


    public ReusableMethod() {
        this.page = PD.getPage();
    }

    public  void myClick(Locator locator){
        locator.waitFor();
        locator.click();
    }

    public  void mySendKeys(Locator locator,String text){
        locator.waitFor();
        locator.fill(text);
    }

    public  void myDropDown(Locator locator, String value){
        locator.waitFor();
        locator.selectOption(value);
    }

    public  void veriyfyContainsText(Locator locator, String text){
        locator.waitFor();
        assertThat(locator).containsText(text);
    }

    public void myCheckBox(Locator locator){
        locator.waitFor();
        locator.check();
    }



}
