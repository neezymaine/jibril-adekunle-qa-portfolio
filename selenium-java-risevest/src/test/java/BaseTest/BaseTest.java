package BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop = new Properties();
    protected Properties loc = new Properties();

    @BeforeMethod
    public void setup() throws IOException {
        String resources = System.getProperty("user.dir") + "/src/test/resources/Configfiles/";

        try (FileReader configReader = new FileReader(resources + "config.properties");
             FileReader locatorReader = new FileReader(resources + "locator.properties")) {
            prop.load(configReader);
            loc.load(locatorReader);
        }

        String browser = prop.getProperty("browser", "chrome");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get(prop.getProperty("testurl"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
