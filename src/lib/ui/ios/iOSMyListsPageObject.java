package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;

public class iOSMyListsPageObject extends MyListPageObject
{
        static {

        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        BUTTON_CLOSE_SUGGEST_SYNC = "id:places auth close";
        FOLDER_BY_NAME_TMPL= "xpath://*[@name='{FOLDER_NAME}']";
    }

    public iOSMyListsPageObject(AppiumDriver driver)
        {
            super(driver);
        }
}
