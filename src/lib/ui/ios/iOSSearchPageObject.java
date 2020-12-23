package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {

        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField";
        //SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:Close";
        CLEAR_MINI = "id:clear mini";
        UNIVERSAL_TITLE = "id:{TITLE_OF_ARTICLE}";
        SEARCH_RESULT_BY_TITLE_TPL = "id:{TITLE}";
//"//XCUIElementTypeStaticText[@name="Object-oriented programming language"]"
        //SEARCH_RESULT_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']";
        //SEARCH_RESULT_BY_INDEX_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='{INDEX}']";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCell";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
