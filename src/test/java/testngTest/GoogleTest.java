package testngTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;

import java.util.List;

public class GoogleTest  {

    @Test
    public void googleTest1() {
        System.out.println("this is google test 1");
        Assert.assertTrue(5>2);
        SeleniumUtils.waitForSeconds(10);
    }

    @Test
    public void googleTest3(){
        System.out.println("this is google test 3");
        Assert.assertTrue(5>2);
    }

}
