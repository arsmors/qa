package cucumber;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import secondTest.pages.BaseFunc;
import secondTest.pages.HomePage;
import secondTest.pages.SearchPage;

public class StepDefs {
    HomePage homePage;

    private final String HOME_PAGE = "http://rus.delfi.lv";
    BaseFunc baseFunc = new BaseFunc();

    @Given("Delfi home page")
    public void open_home_page() {
        baseFunc.openPage(HOME_PAGE);
        HomePage home_page = new HomePage(baseFunc);

    }

    @When("We are searching for (.*)")
    public void search(String toSearch) {
        homePage.search(toSearch);
        SearchPage searchPage = new SearchPage(baseFunc);
    }

 //   @Then("Search results appears")

}
