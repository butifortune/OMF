import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import omf.helpers.Utils;
import omf.pages.HomePage;
import omf.pages.PersonalLoansPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends Utils {

   private final String homePageTitle = "Bank and Borrow Solutions | Old Mutual";
   private final String personalLoansTitle = "Personal Loan Calculator | Estimate Instalments | Old Mutual";
   private final String amount = "R1 656.43 - R1 810.05";
   private static Logger log = Logger.getLogger(MyStepdefs.class);

    @Given("I navigate to Old Mutual Finance Web site and verify that the title")
    public void iNavigateToOldMutualFinanceWebSiteAndVerifyThatTheTitle() {
        log.info("application started");
        setupWebDriver(getConfigPropertyValue("./Framework.properties", "Chrome"));
        String baseURL = getConfigPropertyValue("./Framework.properties", "URL");
        driver.get(baseURL);
        String expTitle = driver.getTitle();
        Assert.assertEquals(expTitle,homePageTitle);
    }

    @And("Navigate to PERSONAL LOANS page and verify that you are on the correct page")
    public void navigateToPERSONALLOANSPageAndVerifyThatYouAreOnTheCorrectPage() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,600)");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        homePage.learnMoreBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.calculateBtn.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(personalLoansTitle, expectedTitle);
    }

    @And("Navigate to CALCULATE, select R{int} {int} from the dropdown then click next.")
    public void navigateToCALCULATESelectRFromTheDropdownThenClickNext(int arg0, int arg1) {
        PersonalLoansPage personalLoansPage = PageFactory.initElements(driver, PersonalLoansPage.class);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        executor.executeScript("arguments[0].click();", personalLoansPage.howMuchDoYouNeedChevron);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        executor.executeScript("arguments[0].click();", personalLoansPage.amountSelection);
        executor.executeScript("arguments[0].click();", personalLoansPage.nextBtn);
    }

    @And("click and dropdown Select {int} MONTHS from the “How long do you need to repay it?”")
    public void clickAndDropdownSelectMONTHSFromTheHowLongDoYouNeedToRepayIt(int arg0) {
        PersonalLoansPage personalLoansPage = PageFactory.initElements(driver, PersonalLoansPage.class);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", personalLoansPage.repaymentDuration);
        executor.executeScript("window.scrollBy(0,600)");
        executor.executeScript("arguments[0].click();", personalLoansPage.durationSelection);
        executor.executeScript("arguments[0].click();", personalLoansPage.finalCalculateBtn);
    }

    @And("click calculate button")
    public void clickCalculateButton() {
        PersonalLoansPage personalLoansPage = PageFactory.initElements(driver, PersonalLoansPage.class);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", personalLoansPage.finalCalculateBtn);
    }

    @Then("Validate the amounts under the RESULT SUMMARY section.")
    public void validateTheAmountsUnderTheRESULTSUMMARYSection() {
        PersonalLoansPage personalLoansPage = PageFactory.initElements(driver, PersonalLoansPage.class);

        String amountEstimate = personalLoansPage.estimatedAmount.getText();
        Assert.assertEquals(amount, amountEstimate);
    }

}
