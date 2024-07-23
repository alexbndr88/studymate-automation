package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClientsPage;
import pages.CommonPage;
import pages.HomePage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class ClientTest {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    ClientsPage clientsPage = new ClientsPage();
    CommonPage commonPage = new CommonPage();


    @Test
    public void verifyEmptyResults(){
        driver.get("https://cashwise.us/main");
        homePage.login("olesmakarenko@gmail.com", "12345678");

        SeleniumUtils.waitForSeconds(1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(commonPage.sales));

        commonPage.sales.click();

        clientsPage.search("apple");

        Assert.assertTrue(clientsPage.listIsEmptyText.isDisplayed());
    }


}
