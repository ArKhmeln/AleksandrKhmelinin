package hw3.pages;

import hw3.enums.DifferentElements;
import hw3.enums.LogTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radiobuttons;

    @FindBy(css = ".colors>.uui-form-element")
    private List<WebElement> dropdown;

    @FindBy(css = ".colors>.uui-form-element")
    private WebElement dropdownMenu;

    @FindBy(css = ".main-content-hg>.uui-button")
    private List<WebElement> buttons;

    @FindBy(css = "[class~='right-fix-panel']")
    private WebElement rightSection;

    @FindBy(id = "mCSB_1_container")
    private WebElement leftSection;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> Logs;

    @FindBy(css = "select.uui-form-element option")
    private List<WebElement> dropdownMenuElements;

    //11, 15, 17 Select/unselect checkboxes, radiobutton, dropdown
    public void selectAndClickElementByName(List<WebElement> items, DifferentElements elementName) {
        for(WebElement element: items) {
            if (element.getText().equals(elementName.getName())) {
                element.click();
            }
        }
    }

    //12,14,16,18 Logo rows
    public boolean checkLogoText(List<WebElement> logoElements, LogTexts searchingText) {
        for (WebElement element : logoElements) {
            if (element.getText().endsWith(searchingText.getText())) {
                return true;
            }
        }
        return false;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadiobuttons() {
        return radiobuttons;
    }

    public List<WebElement> getDropdown() {
        return dropdown;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public List<WebElement> getLogs() {
        return Logs;
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }

    public List<WebElement> getDropdownMenuElements() {
        return dropdownMenuElements;
    }
}
