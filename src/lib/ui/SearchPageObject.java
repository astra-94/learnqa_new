package lib.ui;

import io.appium.java_client.AppiumDriver;


abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            CLEAR_MINI,
            UNIVERSAL_TITLE,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,

            SEARCH_RESULT_BY_TITLE_TPL,
            SEARCH_RESULT_BY_INDEX_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    /* TEMPLATES METHODS */
    private static String getResultSearchElementByTitle(String title)
    {
        return SEARCH_RESULT_BY_TITLE_TPL.replace("{TITLE}", title);
    }

    private static String getNameOfArticleTitle(String name_of_title)
    {
        return UNIVERSAL_TITLE.replace("{TITLE_OF_ARTICLE}", name_of_title);
    }
    /* TEMPLATES METHODS */

    /* TEMPLATES METHODS */
    private static String getResultSearchElementByIndex(String index)
    {
        return SEARCH_RESULT_BY_INDEX_TPL.replace("{INDEX}", index);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        //this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        //закомментила ради iOS
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void waitForSearchResultByIndex(String index)
    {
        String search_result_xpath = getResultSearchElementByIndex(index);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with index " + index);
    }

    public void waitForDisappearSearchResultByIndex(String index)
    {
        String search_result_xpath = getResultSearchElementByIndex(index);
        this.waitForElementNotPresent(search_result_xpath, "Search result with index " + index + "is still here", 5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }


    public void clickByArticleWithTitle(String title)
    {
        String search_result_xpath = getResultSearchElementByTitle(title);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with title " + title, 10);
    }

    public void clickByArticleWithTitleUniversal(String name_of_title)
    {
        String UNIVERSAL_TITLE = getNameOfArticleTitle(name_of_title);
        this.waitForElementAndClick(UNIVERSAL_TITLE, "Cannot find and click search result with title " + name_of_title, 10);
    }


    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15
        );

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    public void clearSearchField()
    {
        this.waitForElementAndClick(CLEAR_MINI, "Cannot clear search field", 5);
    }

}
