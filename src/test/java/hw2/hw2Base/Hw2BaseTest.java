package hw2.hw2Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Hw2BaseTest {

    protected WebDriver driver;

    // TODO protected static final :) Please look to the Java code convention   -fixed
    protected static final List<String> expectedIconText = Arrays.asList("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project", "To be flexible and\n" +
            "customizable", "To be multiplatform", "Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    // TODO protected static final :) Please look to the Java code convention   -fixed
    protected static final List<String> expectedMainHeaderText = Arrays.asList("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT" +
            " ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
            " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT" +
            " NULLA PARIATUR.");

    @BeforeSuite
    protected void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("files/chromedriver.exe").getPath());
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goToWebsite("https://epam.github.io/JDI");
        login("epam", "1234");
    }

    @AfterMethod
    protected void tearDown() {
        driver.close();
    }

        //Some common methods

    //Open test site
    protected void goToWebsite(String URL) {
        driver.get(URL);
    }

    //Perform login
    protected void login(String login, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    //Assert browser title
    protected void assertBrowserTitle(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle);
    }

    //Assert user name
    protected void assertUsername(String expectedUsername) {
        WebElement actualUsername = driver.findElement(By.id("user-name"));
        assertTrue(actualUsername.isDisplayed());
        assertEquals(actualUsername.getText(), expectedUsername);
    }

    //Assert section presence
    protected void assertSectionPresence(By locator) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    //Get text from elements
    protected List<String> getTextFromElements(By elementsSelector) {
        List<String> actualElements = new ArrayList<>();
        List<WebElement> webElementsList = driver.findElements(elementsSelector);
        for(WebElement element: webElementsList) {
            actualElements.add(element.getText());
        }
        return actualElements;
    }

    //11, 15, 17 Select/unselect checkboxes, radiobutton, dropdown
    protected void selectAndClickElementByName(String buttonName, String elementName) {
        switch (buttonName) {
            case "checkbox":
                findElementByName(driver.findElements(By.className("label-checkbox")), elementName);
                break;
            case "radiobutton":
                findElementByName(driver.findElements(By.className("label-radio")), elementName);
                break;
            case "dropdown":
                findElementByName(driver.findElements(By.cssSelector("select.uui-form-element option")), elementName);
                break;
        }
    }

    protected void findElementByName(List<WebElement> buttons, String elementName) {
        for(WebElement element: buttons) {
            if (element.getText().equals(elementName)) {
                element.click();
                break;
            }
        }
    }

    //12,14,16,18 Logo rows
    protected boolean logoTextIsValid(String searchingText) {
        List<WebElement> logoElements = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        for (WebElement element : logoElements) {
            if (element.getText().endsWith(searchingText)) {
                return true;
            }
        }
        return false;
    }
}

