package hw3.hw3Base;

import hw3.enums.WebsiteInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static hw3.enums.WebsiteInfo.*;
import static org.testng.AssertJUnit.assertEquals;

public class Hw3BaseTest {

    protected WebDriver driver;

    private Properties property = new Properties();

    protected String login;

    protected String password;

    @BeforeSuite
    protected void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToWebsite(LINK_MAIN);
        assertBrowserTitle(TITLE);
        userData();
    }

    @AfterMethod
    protected void tearDown() {
        driver.close();
    }


    //data from property file
    protected void userData() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            // TODO Is fis closed anywhere?     -fixed
            property.load(fis);
            login = property.getProperty("login");
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("ERROR: Property file not found!");
        }
    }

    //Open test site
    protected void goToWebsite(WebsiteInfo URL) {
        driver.get(URL.getText());
    }

    //Assert browser title
    protected void assertBrowserTitle(WebsiteInfo browserTitle) {
        assertEquals(driver.getTitle(), browserTitle.getText());
    }
}