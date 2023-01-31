package omf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalLoansPage {

    @FindBy(how = How.XPATH, using ="//*[@id=\"loanAmount\"]/div/div/div/om-form-dropdown-field/div/div[1]/span[1]")
    public WebElement howMuchDoYouNeedChevron;

    @FindBy(how = How.ID, using = "R50000")
    public WebElement amountSelection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"undefined\"]/button/span[1]")
    public WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"repaymentDuration\"]/div/div/div/om-form-dropdown-field/div/div[1]/span[1]")
    public WebElement repaymentDuration;

    @FindBy(how = How.ID, using = "60 Months")
    public WebElement durationSelection;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/om-wc-config/div/om-page/div/div/main/om-application-container/div/om-1-col-layout/div/om-section/div/div/div[2]/div/om-personal-loans-calculator/div/div[2]/div[1]/div[1]/div/om-button/button")
    public WebElement finalCalculateBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"blt9c764616951e6d18\"]/div/div[2]/div[2]/om-calculator-result/div[2]/h5/strong")
    public WebElement estimatedAmount;
}
