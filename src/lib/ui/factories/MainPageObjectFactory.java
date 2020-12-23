package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.android.AndroidMainPageObject;
import lib.ui.ios.iOSArticlePageObject;
import lib.ui.ios.iOSMainPageObject;

public class MainPageObjectFactory
{
    public static MainPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMainPageObject(driver);
        } else {
            return new iOSMainPageObject(driver);
        }
    }
}
