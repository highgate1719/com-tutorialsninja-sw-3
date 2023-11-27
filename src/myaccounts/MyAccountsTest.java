package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 *Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)

 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()

 * 1.1 Click on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.

 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()

 * 2.1 Click on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.

 * 3. Test name verifyThatUserRegisterAccountSuccessfully()

 * 3.1 Click on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button

 * 3.14 Click on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button

 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()

 * 4.1 Click on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Click on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    public void selectMyAccountOptions(String option) throws InterruptedException {


        List<WebElement> name = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[1]"));
        System.out.println(name);
        for (WebElement name1 : name) {
            System.out.println(name1);
            String text1 = name1.getText();


            if (name1.getText().equalsIgnoreCase(option)) {
                Thread.sleep(2000);
                name1.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {

        //1.1 Click on My Account Link
        clickOnElement(By.xpath(" //span[normalize-space()='My Account']"));
        Thread.sleep(2000);

        //1.2 Method calling
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account
        verifyElements("Register Account", By.xpath(" //h1[normalize-space()='Register Account']"), "User has not navigated to the Register Page");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //2.1 Click on My Account Link.
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(3000);

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter'Login'
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        //2.3 Verify the text “Returning Customer”.
        verifyElements("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"), "Correct text");

    }


    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "viral");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Patel");

        //3.5 Enter Email
        sendTextToElement(By.xpath(" //input[@id='input-email']"), "patel1238@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "02080621538");

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abc123");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "abc123");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.cssSelector(" input[value='1'][name='newsletter']"));

        //3.10 Click on Privacy Policy check box
                clickOnElement(By.cssSelector("input[value='1'][name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        verifyElements("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Register unsuccessfull");

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        verifyElements("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"), "Not logout successfully");

        //3.17 Click on Continue button
        clickOnElement(By.xpath(" //a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        Thread.sleep(2000);
        //4.3 Enter Email address
        sendTextToElement(By.xpath(" //input[@id='input-email']"), "patel1237@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abc123");

        //4.6 Click on Login button
        clickOnElement(By.xpath(" //input[@value='Login']"));

        //4.7 Verify text “My Account”
        verifyElements("My Account", By.xpath(" //h2[normalize-space()='My Account']"), "Login not successfull");

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        //4.10 Verify the text “Account Logout”
        verifyElements("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"), "Not logout successfully");

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @After
    public void testDown() {
        closeBrowser();
    }



}
