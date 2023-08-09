package test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteTest {
    public String baseUrl = "https://www.google.com/";
    public WebDriver driver;

    @Test
    public void test2() throws InterruptedException, MalformedURLException {

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
        //WebDriver driver = new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"), capabilities);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("Connecting to server");

        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Google" , title);
    }

}
