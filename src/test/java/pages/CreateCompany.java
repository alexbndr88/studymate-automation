package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class CreateCompany {

    public CreateCompany() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedPrimary')]")
    public WebElement createButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement companyName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement Address;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement PhoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    public void createCompany(String companyname, String email, String address, String phonenumber) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
       createButton.click();
       companyName.sendKeys(companyname);
        Email.sendKeys(email);
        Address.sendKeys(address);
        PhoneNumber.click();
        PhoneNumber.sendKeys(phonenumber);
        submitButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='OlesTest']"))).isDisplayed());
    }

    @FindBy(id = "input")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='sc-fKVqWL bIUtrB']")
    public WebElement signInButton;



    public void signInToCompany(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

    }
}