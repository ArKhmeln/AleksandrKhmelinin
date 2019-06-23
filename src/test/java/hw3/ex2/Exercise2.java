package hw3.ex2;

import hw3.hw3Base.Hw3BaseTest;
import hw3.steps.DifferentElementsPageSteps;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.DifferentElements.*;
import static hw3.enums.HeaderServiceDropdown.headerServiceDropdownText;
import static hw3.enums.LeftSectionServiceDropdown.leftSectionServiceDropdownText;
import static hw3.enums.LogTexts.*;

public class Exercise2 extends Hw3BaseTest {

    HomePageSteps homePageSteps;
    DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void ex2EpamSiteTests() {
        homePageSteps.login("epam", "1234");
        homePageSteps.assertUserNameTextField("PITER CHAILOVSKII");
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSteps.assertHeaderDropdownTextInService(headerServiceDropdownText());
        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSteps.assertLeftSectionDropdownTextInService(leftSectionServiceDropdownText());
        //7. Open through the header menu Service -> Different Elements Page
        homePageSteps.goToServiceDifferentElementsInHeader();
        //8. Check interface on Different elements page, it contains all needed elements
        differentElementsPageSteps.assertPageElementsPresence();
        //9. Assert that there is Right Section
        differentElementsPageSteps.assertRightSectionPresence();
        //10. Assert that there is Left Section
        differentElementsPageSteps.assertLeftSectionPresence();
        //11. Select checkboxes
        differentElementsPageSteps.selectAndClickCheckbox(WATER);
        differentElementsPageSteps.selectAndClickCheckbox(WIND);
        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status.
        differentElementsPageSteps.assertLogByText(WATER_TRUE);
        differentElementsPageSteps.assertLogByText(WIND_TRUE);
        //13. Select radio
        differentElementsPageSteps.selectAndClickRadiobutton(SELEN);
        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPageSteps.assertLogByText(METAL_SELEN);
        //15. Select in dropdown
        differentElementsPageSteps.selectAndClickDropdown(YELLOW);
        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.assertLogByText(COLORS_YELLOW);
        //17. Unselect and assert checkboxes
        differentElementsPageSteps.selectAndClickCheckbox(WATER);
        differentElementsPageSteps.selectAndClickCheckbox(WIND);
        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status.
        differentElementsPageSteps.assertLogByText(WATER_FALSE);
        differentElementsPageSteps.assertLogByText(WIND_FALSE);
    }
}
