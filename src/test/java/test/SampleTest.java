package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ISuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SampleTest {
    public String baseUrl = "https://www.google.com/";
    String driverPath = "executables/chromedriver.exe";
    public WebDriver driver;
    Reporter repo = new Reporter();

    @Test
    public void test1() {
        // set the system property for Chrome driver
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(driverPath).getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        // Create driver object for CHROME browser
        DesiredCapabilities capabilities = new DesiredCapabilities();
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("browserName", "chrome");
        }

        capabilities.setBrowserName("chrome");
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        // get the current URL of the page
        String URL = driver.getCurrentUrl();
        System.out.print(URL);
        // get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        
 
        
    }
    
    @Test
    public void repoOne () {
    	Assert.assertTrue(false);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test");
    }
}
