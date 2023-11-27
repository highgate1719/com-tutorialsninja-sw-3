package broserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’
 * inside the
 * ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 */
public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();

        //Launch the url
        driver.get(baseUrl);

        //Maximise window
        driver.manage().window().maximize();

        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();

    }
}