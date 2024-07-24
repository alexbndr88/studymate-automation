package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.LoginPage;
import utilities.Driver;

public class CompaniesTest {
    WebDriver driver;
    CompaniesPage companiesPage;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        driver = Driver.getDriver();
        loginPage = new LoginPage(driver);
        companiesPage = new CompaniesPage();
        driver.get("https://supplysync.us/login");
        loginPage.login("admin@codewise.com", "codewise123");
    }

    @Test
    public void testAddCompanyWithName() {
       companiesPage.createCompany();
       //Assert.assertEquals("BugBuster",companiesPage.checkCompanyName.getText());


    }

    @Test
    public void testAddCompanyWithoutName() {
       companiesPage.createCompany();

    }





}