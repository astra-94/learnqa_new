package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_XPATH = "xpath://*[contains(@name,'Learn more about Wikipedia')]",
    STEP_NEW_WAYS_XPATH = "xpath://*[contains(@name,'New ways to explore')]",
    STEP_ADD_OR_EDIT_LANGUAGES_XPATH = "xpath://*[contains(@name,'Add or edit preferred languages')]",
    STEP_LEARN_MORE_ABOUT_DATA_XPATH = "xpath://*[contains(@name,'Learn more about data collected')]",
    STEP_NEXT_XPATH = "xpath://*[contains(@name,'Next')]",
    STEP_GET_STARTED_XPATH = "xpath://*[contains(@name,'Get started')]";


    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_XPATH, "cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void waitForNewWaysToExplore()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_XPATH, "cannot find 'New ways to explore' link", 10);
    }

    public void waitForAddOrEditPreferredLanguages()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_LANGUAGES_XPATH, "cannot find 'Add or edit preferred languages' link", 10);
    }

    public void waitForLearnMoreAboutDataCollected()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_XPATH, "cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(STEP_NEXT_XPATH, "cannot find 'Next' link", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(STEP_GET_STARTED_XPATH, "cannot find 'Get started' link", 10);
    }

}
