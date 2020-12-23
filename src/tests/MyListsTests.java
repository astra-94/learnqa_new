package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveFirstArticleToMyList()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isIOS()) {
            MyListPageObject.closeSuggestToSync();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();


        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        //находим первую статью и кликаем по ней
        SearchPageObject.initSearchInput();
        String first_search_line = "Java";
        String full_first_title = "Java (programming language)";
        String full_second_title = "Python (programming language)";
        SearchPageObject.typeSearchLine(first_search_line);
        SearchPageObject.clickByArticleWithTitle(full_first_title);

        //проверяем что статья появилась
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElementUniversal(full_first_title);

        //добавляем её в закладки
        String article_title = ArticlePageObject.getArticleTitleUniversal(full_first_title);

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        //закрываем предложение синхронизации (только iOS)
        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isIOS()) {
            MyListPageObject.closeSuggestToSync();
        }

        //Закрываем первую статью
        ArticlePageObject.closeArticle();

        //Второй поиск - ищем аппиум
        SearchPageObject.initSearchInput();
        SearchPageObject.clearSearchField();
        String second_search_line = "Python";
        SearchPageObject.typeSearchLine(second_search_line);
        SearchPageObject.clickByArticleWithTitle(full_second_title);

        //дожидаемся загрузки
        ArticlePageObject.waitForTitleElementUniversal(full_second_title);


        //добавляем в закладки вторую статью

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }



        //закрываем вторую статью

        ArticlePageObject.closeArticle();

        //открываем закладки
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();


        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        //здесь надо удалить первую статью про Java
        MyListPageObject.swipeByArticleToDelete(article_title);

        //проверяем на месте ли вторая статья
        MyListPageObject.waitForArticleToAppearByTitle(full_second_title);
        MyListPageObject.waitForArticleToDisappearByTitle(full_first_title);


        //старый тест - может пригодится
//        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
//
//        SearchPageObject.initSearchInput();
//        String first_search_line = "Java";
//        SearchPageObject.typeSearchLine(first_search_line);
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
//        ArticlePageObject.waitForTitleElement();
//        String article_title = ArticlePageObject.getArticleTitle();
//        String name_of_folder = "Learning programming";
//        ArticlePageObject.addArticleToMyList(name_of_folder);
//        ArticlePageObject.closeArticle();
//
//        SearchPageObject.initSearchInput();
//        String second_search_line = "Appium";
//        SearchPageObject.typeSearchLine(second_search_line);
//        SearchPageObject.clickByArticleWithTitle(second_search_line);
//        ArticlePageObject.waitForTitleElement();
//        ArticlePageObject.addArticleToMyListNotFirstTime(name_of_folder);
//        ArticlePageObject.closeArticle();
//
//
//        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
//        NavigationUI.clickMyLists();
//
//        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
//        MyListPageObject.openFolderByName(name_of_folder);
//        MyListPageObject.swipeByArticleToDelete(article_title);
//        //убеждаемся, что вторая осталась
//        MyListPageObject.waitForArticleToAppearByTitle(second_search_line);
//        SearchPageObject.clickByArticleWithTitle(second_search_line);
//
//        //переход в статью и проверка тайтла
//        String article_second_title = ArticlePageObject.getArticleTitle();
//
//        assertEquals(
//                "We see unexpected title!",
//                second_search_line,
//                article_second_title
//        );
//
    }
}
