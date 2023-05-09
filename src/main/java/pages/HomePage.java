package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage {
    private static WebDriver driver;
    private final By pageHTML = By.tagName("html");
    private final By pageCurrency = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");
    public String PAGE_URL = "https://www.almosafer.com/en";

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public String getSiteLanguage() {
        WebElement htmlPage = driver.findElement(pageHTML);
        return htmlPage.getAttribute("lang");
    }

    public String getSiteCurrency() {
        WebElement selectedCurrency = driver.findElement(pageCurrency);
        return selectedCurrency.getText();
    }

    public String getContactNumber() {
        WebElement contactNumber = driver.findElement(By.cssSelector("a[class='sc-gbOuXE bWmXTb'] strong"));
        return contactNumber.getText();
    }

    public boolean isQitafLogoDisplayedInFooter() {
        WebElement logo = driver.findElement(By.cssSelector("[data-testid=\"Footer__QitafLogo\"]"));
        return logo.isDisplayed();
    }

    public boolean getDefaultSearchTab() {
        WebElement SearchHotelsTab = driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
        return SearchHotelsTab.isSelected();
    }

}
