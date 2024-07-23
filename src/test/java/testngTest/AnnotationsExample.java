package testngTest;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsExample {
    /*
    In AnnotationsExample.java, implement the following methods with corresponding annotations:
    @BeforeSuite: Print out "Setting up the suite environment."
@BeforeTest: Print "Configuring test environment."
@BeforeClass: Print "Loading class resources."
@BeforeMethod: Print "Initializing test method setup."
@Test: Write at least three test methods. Each method should perform a simple assertion
or print a message.Example Test: Assert that the sum of two integers is correct.
@AfterMethod: Print "Cleaning up after test method."
@AfterClass: Print "Releasing class resources."
@AfterTest: Print "Tearing down test environment."
@AfterSuite: Print "Cleaning up the suite environment."
Step 3: Configure a TestNG XML file to run your tests.
     */

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Setting up the suite environment.");
    }
    @BeforeTest
    public static void beforeTest() {
        System.out.println("Configuring test environment.");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Loading class resources.");
    }
    @BeforeMethod
    public static void beforeMethod() {
        System.out.println("Initializing test method setup.");
    }
    @Test
    public static void testSum() {
        int a = 5;
        int b = 10;
        int sum = a + b;
        assert sum == 15 : "Sum test failed!";
        System.out.println("Sum test passed.");
    }
    @Test
    public void testStringLength() {
        String str = "TestNG";
        int length = str.length();
        assert length == 6 : "String length test failed!";
        System.out.println("String length test passed.");
    }

    @Test
    public void testBoolean() {
        boolean condition = true;
        assert condition : "Boolean test failed!";
        System.out.println("Boolean test passed.");
    }

    @AfterMethod
    public static void AfterMethod() {
        System.out.println("Cleaning up after test method.");
    }
    @AfterClass
    public static void AfterClass(){
        System.out.println("Releasing class resources.");
    }
    @AfterTest
    public static void AfterTest(){
        System.out.println("Tearing down test environment.");
    }
    @AfterSuite
    public static void AfterSuite(){
        System.out.println("Cleaning up the suite environment.");
    }


}
