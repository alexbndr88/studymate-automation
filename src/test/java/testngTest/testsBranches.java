package testngTest;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.Branches;
import utilities.Driver;

public class testsBranches {
    Branches branches = new Branches();
    @AfterClass
    public static void close(){
        Driver.getDriver().close();
    }
    @Test
    public void createBrunch ()  {
        branches.loginNavigate();
        branches.createBranchesMethod();
        Assert.assertEquals("Branches For Testing", branches.checkBranchName.getText());
    }

    @Test
    public void testsEdit(){
      //  branches.loginNavigate();
        branches.editMethod();
        Assert.assertEquals("aigul111@gmail.com", branches.checkEmail.getText());
    }







}
