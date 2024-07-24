package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateTariff;
import pages.Tariff;
import utilities.Driver;

public class TariffTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/login");
    }

    @Test
    public void testSignInToTariff() {
        Tariff tariff = new Tariff();
        tariff.signInToTariff("admin@codewise.com", "codewise123");
    }

    @Test
    public void createTarifftest(){
        Tariff tariff = new Tariff();
        tariff.signInToTariff("admin@codewise.com", "codewise123");

        CreateTariff createTariff = new CreateTariff();
        createTariff.createTariff(
                "Hawaii ",
                "Express Delivery",
                "24 hours",
                "Out of city",
                "50",
                "Alabama",
                "123,456",
                "No additional info",
                true
        );

    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}