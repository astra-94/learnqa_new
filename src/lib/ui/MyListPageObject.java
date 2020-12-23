package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListPageObject extends MainPageObject{

    protected static String

            FOLDER_BY_NAME_TMPL,
        BUTTON_CLOSE_SUGGEST_SYNC,
        ARTICLE_BY_TITLE_TPL;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TMPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void closeSuggestToSync()
    {
        //String button_close_suggest_sync_xpath = getFolderXpathByName(button_close_suggest_sync);
        this.waitForElementAndClick(BUTTON_CLOSE_SUGGEST_SYNC, "Cannot close suggest to sync", 5);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title "+ article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title "+ article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForArticleToAppearByTitle(article_title);


        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");

        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
