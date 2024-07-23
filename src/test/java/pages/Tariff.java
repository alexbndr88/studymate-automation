package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Tariff {
    WebDriver driver;

    public Tariff() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "input")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='sc-fKVqWL bIUtrB']")
    public WebElement signInButton;

    @FindBy(partialLinkText = "Tariffs")
    public WebElement changeToTariff;

    public void signInToTariff(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
        changeToTariff.click();
    }
}
