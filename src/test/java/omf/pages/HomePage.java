package omf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"gatsby-focus-wrapper\"]/om-wc-config/div/om-page/div/div/main/om-product-carousel/div/om-section/div/div/div[2]/div/om-carousel-container/div/div[1]/ul/li[2]/om-refined-product-card/om-product-card/div/div[2]/div[2]/div[2]/om-button")
    public WebElement learnMoreBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gatsby-focus-wrapper\"]/om-wc-config/div/om-page/div/div/header/om-header-with-breadcrumbs/div/om-hero-banner/div/div[3]/div[2]/om-hero-banner-content/span/om-button[2]/a/span[1]")
    public WebElement calculateBtn;

}
