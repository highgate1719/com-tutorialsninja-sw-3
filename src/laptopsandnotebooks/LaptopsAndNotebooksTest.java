package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/**
 * Create package laptopsandnotebooks
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    @Test

    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/div[1]/a[1]"));
        // clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyElements("Price (High > Low)", By.xpath("//*[@id='input-sort']/option[5]"), "correct message");
        Thread.sleep(2000);

    }


    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a"));

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//img[@title='MacBook']"));

        //2.5 Verify the text “MacBook”
        verifyElements("MacBook", By.xpath("//a[normalize-space()='MacBook']"), "correct text");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyElements("Success: You have added MacBook to your shopping cart!\n" +
                "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"), "correct message");
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.9 Verify the text "Shopping Cart"
        verifyElements("Shopping Cart  (0.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"), "correct text");
        //2.10 Verify the Product name "MacBook"
        verifyElements("MacBook", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "correct text");
        //2.11 Change Quantity "2"
        WebElement qty = driver.findElement(By.cssSelector("input[value='1']"));
        qty.clear();
        sendTextToElement(By.cssSelector("input[value='1'"), "2");
        //2.12 Click on “Update”Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyElements("Success: You have modified your shopping cart!\n" + "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"), "correct text");
        //2.14 Verify the Total £1204
        verifyElements("$1,204.00", By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"), "correct total");
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //2.16 Verify the text “Checkout”
        verifyElements("Checkout", By.xpath("//h1[normalize-space()='Checkout']"), "correct message");
        //2.17 Verify the Text “New Customer”
        verifyElements("New Customer", By.xpath("//div[@class='col-sm-6']/h2[normalize-space()='New Customer']"), "correct text");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Geeta");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Joshi");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "gj123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "12345678901");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "10,PRINCESS AVENUE");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "NW9 9NE");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Greater London");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Hello,Please leave my order near the door");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        verifyElements("Warning: No Payment options are available. Please contact us for assistance!", By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"), "Correct Text");


    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
