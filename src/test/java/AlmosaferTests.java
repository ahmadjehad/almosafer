import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.HomePage;

public class AlmosaferTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get(homePage.PAGE_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkDefaultLanguage() {
        String siteLanguage = homePage.getSiteLanguage();
        Assert.assertTrue(siteLanguage.equals("en") || siteLanguage.equals("ar"), "Unexpected default language: " + siteLanguage);
    }

    @Test(priority = 2)
    public void checkDefaultCurrency() {
        String siteCurrency = homePage.getSiteCurrency();
        Assert.assertEquals(siteCurrency, "SAR", "Unexpected default currency: " + siteCurrency);
    }

    @Test(priority = 3)
    public void checkContactNumber() {
        String contactNumber = homePage.getContactNumber();
        Assert.assertEquals(contactNumber, "+966554400000", "Unexpected number: " + contactNumber);
    }

    @Test(priority = 4)
    public void checkQitafLogoDisplayedInFooter() {
        boolean isLogoDisplayed = homePage.isQitafLogoDisplayedInFooter();
        Assert.assertTrue(isLogoDisplayed, "Qitaf logo is not displayed");
    }

    @Test(priority = 5)
    public void checkSearchHotelsTabIsNotSelectedByDefault() {
        boolean isDefaultSelectedTabHotels = homePage.getDefaultSearchTab();
        Assert.assertFalse(isDefaultSelectedTabHotels, "Search Hotels Tab Is Selected By Default");
    }


}
