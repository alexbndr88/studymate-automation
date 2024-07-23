package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage {

    WebDriver driver;

    public CommonPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Infographics")
    public WebElement infographics;

    @FindBy(xpath = "//li[text()='Sales']")
    public WebElement sales;

    @FindBy(xpath = "//aside[@id='sidebar']//li[text()='Expenses']")
    public WebElement expenses;

    @FindBy(xpath = "//aside[@id='sidebar']//li[text()='Reports']")
    public WebElement reports;


}
