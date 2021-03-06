package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lib.Platform;

import java.util.List;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,

        UNIVERSAL_TITLE,
        LOCATOR_TITLE,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON,
        CHOOSING_FOLDER_TPL,
        TITLE_FOR_APPIUM_ARTICLE;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getNameOfList(String name_of_folder)
    {
        return CHOOSING_FOLDER_TPL.replace("{NAME_OF_FOLDER}", name_of_folder);
    }

    private static String getNameOfArticleTitle(String name_of_title)
    {
        return UNIVERSAL_TITLE.replace("{TITLE_OF_ARTICLE}", name_of_title);
    }
    /* TEMPLATES METHODS */

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }
//для двух статей
    public WebElement waitForTitleElementUniversal(String name_of_title)
    {
        String universal_title = getNameOfArticleTitle(name_of_title);
        return this.waitForElementPresent(universal_title, "Cannot find article title on page!", 15);
    }

    public String getArticleTitleUniversal(String name_of_title)
    {
        WebElement title_element = waitForTitleElementUniversal(name_of_title);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }

    public void waitForTitleOfArticle()
    {
        this.waitForElementPresent(TITLE_FOR_APPIUM_ARTICLE, "Cannot find article title on the page", 15);
    }


    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    100
            );
        } else {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
            "Cannot find the end of article",
            100
            );
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void addArticleToMyListNotFirstTime(String name_of_folder)
    {
        String CHOOSING_LIST = getNameOfList(name_of_folder);
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        waitForElementAndClick(
                CHOOSING_LIST,
                "Cannot find the folder" + name_of_folder,
                10
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                15
        );
    }

    public int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementPresent(String locator, String error_message)
    {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements == 0) {
            throw new AssertionError(error_message);
        }
    }

    public void assertThereIsTitleOnThePage()
    {
        this.assertElementPresent(LOCATOR_TITLE, "Cannot find title of article");
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

}
