package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        //TITLE = "id:Linkin Park discography";
        TITLE = "xpath://XCUIElementTypeStaticText[@name='Appium']";
        UNIVERSAL_TITLE = "id:{TITLE_OF_ARTICLE}";
        TITLE_FOR_APPIUM_ARTICLE = "xpath://XCUIElementTypeStaticText[@name='Appium']";
     //хз пока   LOCATOR_TITLE = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']";
        FOOTER_ELEMENT = "id:View article in browser";
        // не нужнаOPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
//        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
//        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
//        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "id:Back";
       //хз пока CHOOSING_FOLDER_TPL = "xpath://*[@text='{NAME_OF_FOLDER}']";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
