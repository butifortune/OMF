package omf;

import io.cucumber.java.After;
import omf.helpers.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class Hooks extends Utils {

    @After(order = 0)
    public void screenshot(io.cucumber.java.Scenario scenario) throws IOException {
        File file;

            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/"+scenario.getName()+"/";
            file = new File(screenshotPath);
            file.mkdir();
            try {
                final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(screenshotPath+"screenshot.png"));

            } catch (final Exception e) {
                e.printStackTrace();
            }
            String failedScreenShot = screenshotPath+"screenshot.png";
            String url = "<img src="+failedScreenShot+" alt='failed screenshot'>";
            scenario.attach(url.getBytes(),"png", "Click Here To See Screenshot");

    }
    @After(order = 1)
    public void tearDown(){
        driver.quit();
    }
}
