package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create the package name desktops
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */


public class DeskTopTest extends Utility1 {
    static String month = "November 2023";
    static String date = "27";
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.linkText("Desktops"));

        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        // 1.4 Verify the Product will arrange in Descending order.
        ArrayList<String> actualList = new ArrayList<>();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        System.out.println("listOfElements=" + listOfElements);
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
            System.out.println(element.getText());
        }

        System.out.println("actual list = " + actualList);

        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
            System.out.println("expected list = " + element.getText());
        }

        System.out.println("expected list = " + expectedList);

        Thread.sleep(3000);
        // z -a
        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
        System.out.println("expected sort = " + expectedList);
        Collections.reverse(expectedList);

        System.out.println("expected reverse = " + expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);

    }

    @Test

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(2000);
        //2.1 Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.linkText("Desktops"));

        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.5 Verify the Text "HP LP3065"
        assertVerifyText(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");

        //2.6 Select Delivery Date "2022-11-30"
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); ////input[@id='input-option225']

        while (true) {
            WebElement element = driver.findElement(By.cssSelector(".picker-switch"));
            String text = element.getText().trim();

            if (text.equals(month)) {
                break;
            } else {
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")).click();
            }
        }

        List<WebElement> dateList = driver.findElements(By.xpath("//tbody//tr//td[@class='day']"));
        for (WebElement element : dateList) {
            if (element.getText().trim().equals(date)) {
                System.out.println("my day=" + element.getText().trim());
                element.click();
                break;
            }
        }

        //2.7.Enter Qty "1” using Select class.
        WebElement element = driver.findElement(By.xpath("//input[@id='input-quantity']"));
        element.clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”

        WebElement elementMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actual = elementMessage.getText();
        System.out.println(actual);
        String expected = "Success: You have added HP LP3065 to your shopping cart!";

        System.out.println(expected);
        boolean message = actual.contains(expected.trim());
        Assert.assertTrue(message);
        Thread.sleep(2000);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.11 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart  (1.00kg)");

        Thread.sleep(2000);

        //2.12 Verify the Product name "HP LP3065"
        By actualProduct = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
        System.out.println(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).getText());
        assertVerifyText(actualProduct, "HP LP3065");

        //2.13 Verify the Delivery Date "2023-11-27"
        By deliveryDate = By.xpath("//small[contains(text(),'Delivery Date:2023-11-27')]");
        System.out.println(driver.findElement(By.xpath("//small[contains(text(),'Delivery Date:2023-11-27')]")).getText());
        assertVerifyText(deliveryDate,"Delivery Date:2023-11-27");
        Thread.sleep(2000);

        //2.14 Verify the Model "Product21"
        By actualModel = By.xpath("//td[contains(text(),'Product 21')]");
        System.out.println(driver.findElement(By.xpath("//td[contains(text(),'Product 21')]")).getText());
        assertVerifyText(actualModel,"Product 21");

        //2.15 Verify the Todat "£74.73"
        By total = By.xpath("(//td[contains(text(),'$122.00')])[4]");
        String message3 = driver.findElement(By.xpath("(//td[contains(text(),'$122.00')])[4]")).getText();
        System.out.println(message3);
        assertVerifyText(total, "$122.00");

    }
    @After
    public void tearDown () {
        //closing the Browser
        driver.close();
    }

}
