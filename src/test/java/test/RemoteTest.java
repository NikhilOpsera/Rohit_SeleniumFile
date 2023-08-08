package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteTest {
    public String baseUrl = "https://www.google.com/";
    String driverPath = "executables/chromedriver.exe";
    public WebDriver driver;

    @Test
    public void test2() {

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
        Assert.assertTrue(true);
    }

}
