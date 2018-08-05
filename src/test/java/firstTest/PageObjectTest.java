package firstTest;

import firstTest.pages.ArticlePage;
import firstTest.pages.BaseFunc;
import firstTest.pages.CommentPage;
import firstTest.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class PageObjectTest {

    //В самом тесте больше никаких локаторов, только те переменные, что нужны самой логике теста
    //Сам Driver тепеь находится в BaseFunc и может использоваться отовсюду
    //Как только мы создаём копию объкта BaseFunc - принудительно срабатывает конструетор, где происходит открытие браузера
    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "http://rus.delfi.lv";

    @Test
    public void checkArticleTitle() {
        baseFunc.openPage(HOME_PAGE);

        //Указываем тесту, что находимся на конкретной странице - это позволяет нам использовать инструменты этой страницы
        HomePage homePage = new HomePage(baseFunc);
        String title = homePage.getTitleById(1);
        homePage.openArticlePage(1);

        ArticlePage articlePage = new ArticlePage(baseFunc);

        String pageTitle = articlePage.getTitle();
        //Все проверки именно характерные логике теста находятся в тесте
        Assert.assertEquals("Article title does not match", title, pageTitle);

        articlePage.openCommentPage();

        CommentPage commentPage = new CommentPage(baseFunc);

        String commentPageTitle = commentPage.getTitle();
        Assert.assertTrue("Article title does not match", commentPageTitle.contains(title));
    }
}