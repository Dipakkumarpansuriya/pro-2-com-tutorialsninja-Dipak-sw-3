package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        closeBrowser();
    }

    public void selectMenu(String menu) {

        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));
        selectMenu("Show All Desktops");
        String expText = "Desktops";
        String actText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("NotMatching",expText,actText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
        selectMenu("Show All Laptops & Notebooks");
        String expText = "Laptops & Notebooks";
        String actText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("NotMatching",expText,actText);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHoverToElementAndClick(By.linkText("Components"));
        selectMenu("Show All Components");
        String expText = "Components";
        String actText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("NotMatching",expText,actText);
    }
    public void closeBrowser(){
        driver.quit();
    }

}
