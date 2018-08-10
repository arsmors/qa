package secondTest;

import firstTest.Ishop2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import secondTest.pages.BaseFunc;
import org.junit.Test;
import secondTest.pages.HomePage;
import secondTest.pages.SearchPage;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class SearchDelfiTest2 {

    BaseFunc baseFunc = new BaseFunc();

    private final String HOME_PAGE = "http://rus.delfi.lv";

    private final Logger LOGGER = LogManager.getLogger(SearchDelfiTest2.class);

    @Test
    public void checkArticleTitle() throws InterruptedException {
        baseFunc.openPage(HOME_PAGE);

        LOGGER.info("Open Browser");
        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("In search field enter search word");
        homePage.search("погода");

        LOGGER.info("Sorting results by Date");
        SearchPage searchPage = new SearchPage(baseFunc);
        searchPage.sort();

        Thread.sleep(5000);
        LOGGER.info("Go to page nr");
        searchPage.clickPageNumber(4);

        LOGGER.info("Verifying results are sorted by date");
        Thread.sleep(5000);
        searchPage.datesCheck();

    }
}
