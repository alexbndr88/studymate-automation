package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateCompany;
import pages.CreateTariff;
import pages.Tariff;
import utilities.Driver;

public class CompanyTest {

        WebDriver driver;

        @BeforeTest
        public void setUp() {
            driver = Driver.getDriver();
            driver.get("https://supplysync.us/login");
        }

        @Test
        public void testSignInToCompany() {
            Tariff tariff = new Tariff();
            tariff.signInToTariff("admin@codewise.com", "codewise123");
        }

        @Test
        public void createCompanyTest() {
            CreateCompany createCompany = new CreateCompany();
            createCompany.signInToCompany("admin@codewise.com", "codewise123");
            createCompany.createCompany("OlesTest", "oles@gmail.com", "123 Washington Ave", "1111111111");
        }

        @AfterTest
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
