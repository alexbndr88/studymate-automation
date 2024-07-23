package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class HomePageTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cashwise.us/main");


        HomePage homePage = new HomePage();

        homePage.login("olesmakarenko@gmail.com", "12345678");


    }
}
