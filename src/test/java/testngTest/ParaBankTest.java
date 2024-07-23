package testngTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ParaBank;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class ParaBankTest {
    WebDriver driver = Driver.getDriver();

    @Test
    public void TestRegistration() {
        ParaBank paraBank = new ParaBank();
        Driver.getDriver().get("https://parabank.parasoft.com/parabank");
        paraBank.registerNewAccount("alex", "hi", "123 Main St", "Anytown", "mn", "12345", "555-1234", "123-45-6789", "alex", "password", "password");
    }

    @Test
    public void TestLogin() {
        ParaBank paraBank = new ParaBank();
        Driver.getDriver().get("https://parabank.parasoft.com/parabank");
        paraBank.login("alex", "password");
        List<WebElement> balance=Driver.getDriver().findElements(By.xpath("//table[@id='accountTable']"));
        for (WebElement row:balance){
            String currentbalance=row.findElement(By.xpath("td[5]")).getText();
            System.out.println(currentbalance);
        }

//        double checkingBalance = Driver.getDriver().findElement(By.xpath(""));
//        Assert.assertTrue(checkingBalance > 0, "Balance is not greater than 0.");
//
//        paraBank.openNewSavingsAccount();
//
//        double transferAmount = checkingBalance / 2;
//        paraBank.transferFunds(transferAmount, "CHECKING", "SAVINGS");
//
//        paraBank.verifySavingsBalance(transferAmount);
    }
}
