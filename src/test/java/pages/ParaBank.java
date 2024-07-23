package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class ParaBank {
    /*
    1. Go to the "https://parabank.parasoft.com/parabank"
2. Click on register
3. Fill out the fields to register(don't give your real info)
4. After registering, log out from your account
5. Log back in using the username and password
6. After logging in, check the balance if you have more than 0
7. Open new savings account by clicking Open New Account
8. And then transfer half of your checking account balance to your newly created savings account.
9. Lastly go back to your home page, and verify if that fund is in your savings account
     */

    WebDriver driver;

    public ParaBank() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Register")
    public WebElement register;

    @FindBy(id = "customer.firstName")
    public WebElement firstName;

    @FindBy(id = "customer.lastName")
    public WebElement lastName;

    @FindBy(id = "customer.address.street")
    public WebElement address;

    @FindBy(id = "customer.address.city")
    public WebElement city;

    @FindBy(id = "customer.address.state")
    public WebElement state;

    @FindBy(id = "customer.address.zipCode")
    public WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    public WebElement ssn;

    @FindBy(id = "customer.username")
    public WebElement username;

    @FindBy(id = "customer.password")
    public WebElement password;

    @FindBy(id = "repeatedPassword")
    public WebElement repPass;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(partialLinkText = "Log Out")
    public WebElement logout;

    @FindBy(name = "username")
    public WebElement loginUsername;

    @FindBy(name = "password")
    public WebElement loginPassword;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//table[@id='accountTable']//tr[contains(@class, 'ng-scope')]")
    public List<WebElement> accountRows;

    @FindBy(partialLinkText = "Open New Account")
    public WebElement openNewAccount;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountIdDropdown;

    @FindBy(id = "toAccountId")
    public WebElement toAccountIdDropdown;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transferButton;

    @FindBy(xpath = "//a[contains(text(),'Accounts Overview')]")
    public WebElement accountsOverview;

    @FindBy(xpath = "//h1[@class='title']")
    public WebElement title;

    public void registerNewAccount(String firstname, String lastname, String address, String city, String state, String zip, String phone, String ssn, String username, String password, String repPass) {
        register.click();
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        zipCode.sendKeys(zip);
        phoneNumber.sendKeys(phone);
        this.ssn.sendKeys(ssn);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.repPass.sendKeys(repPass);
        submit.click();
    }

    public void login(String username, String password) {
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        loginButton.click();
    }

    public double getCheckingBalance() {
        for (WebElement row : accountRows) {
            if (row.getText().contains("CHECKING")) {
                String balanceText = row.findElement(By.xpath(".//td[3]")).getText();
                return Double.parseDouble(balanceText.replace("$", ""));
            }
        }
        return 0.0;
    }

    public double getSavingsBalance() {
        for (WebElement row : accountRows) {
            if (row.getText().contains("SAVINGS")) {
                String balanceText = row.findElement(By.xpath(".//td[3]")).getText();
                return Double.parseDouble(balanceText.replace("$", ""));
            }
        }
        return 0.0;
    }

    public void openNewSavingsAccount() {
        openNewAccount.click();
        new Select(accountTypeDropdown).selectByVisibleText("SAVINGS");
        openNewAccountButton.click();
    }

    public void transferFunds(double amount, String fromAccount, String toAccount) {
        new Select(fromAccountIdDropdown).selectByVisibleText(fromAccount);
        new Select(toAccountIdDropdown).selectByVisibleText(toAccount);
        driver.findElement(By.id("amount")).sendKeys(String.valueOf(amount));
        transferButton.click();
    }

    public void verifySavingsBalance(double expectedBalance) {
        accountsOverview.click();
        double actualBalance = getSavingsBalance();
        Assert.assertEquals(actualBalance, expectedBalance, "Savings account balance did not match the expected value.");
    }
}