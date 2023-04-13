import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.Assert;

public class AlmosaferTests extends Almosafer{
    @BeforeTest
    public void setup(){
        driver.get(URL);
    }
    @Test()
    public void check_default_language(){
        WebElement HTML_Page = driver.findElement(By.tagName("html"));
        String siteLanguage = HTML_Page.getAttribute("lang");
        Assert.assertTrue(siteLanguage.equals("en") || siteLanguage.equals("ar"), "Unexpected default language: " + siteLanguage);
    }
    @Test()
    public void check_default_currency(){
        WebElement selectedCurrency = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));
        Assert.assertEquals(selectedCurrency.getText(), "SAR", "Unexpected default currency: " + selectedCurrency);
    }
    @Test
    public void check_contact_number(){
        String contactNumber = driver.findElement(By.cssSelector("a[class='sc-gbOuXE bWmXTb'] strong")).getText();
        Assert.assertEquals(contactNumber,"+966554400000","Unexpected number");
    }
    @Test
    public void check_qitaf_logo_displayed_in_footer(){
        WebElement logo = driver.findElement(By.cssSelector("[data-testid=\"Footer__QitafLogo\"]"));
        Assert.assertTrue(logo.isDisplayed(),"Qitaf logo is not displayed");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
