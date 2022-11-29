package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        // 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByContainsFromDropdown(By.xpath("//select[@id='input-sort']"));

        //1.4 Verify the Product will arrange in Descending order.
        String expText = "Name (Z - A)";
        String actText = getTextFromElement(By.xpath("//select/option[contains(text(), 'Name (Z - A)')]"));
        Assert.assertEquals("Not Matching", expText, actText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));

        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        String expText = "HP LP3065";
        String actText = getTextFromElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Not Matching", expText, actText);

        //2.6 Select Delivery Date "2022-11-30"
       // driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
       // sendTextTwoElement(By.xpath("//input[@id='input-option225']"), "2022-11-30");

        String monthAndYear = "November 2022";
        String day = "30";
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));
        while (true){
            String monYear= getTextFromElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]"));
            if(monYear.equalsIgnoreCase(monthAndYear)){break;
            }else {clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),'"+day+"')]"));

        //2.7.Enter Qty "1” using Select class
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextTwoElement(By.xpath("//input[@id='input-quantity']"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expMessageS = "Success: You have added HP LP3065 to your shopping cart!";
        String actMessageS = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 56);
        Assert.assertEquals("Not correct text", expMessageS, actMessageS);
        Thread.sleep(5000);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        String expMessageSc = "Shopping Cart";
        String actMessageSc = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        Assert.assertEquals("Not correct text", expMessageSc, actMessageSc);

        //2.12 Verify the Product name "HP LP3065"
        String expTextItem = "HP LP3065";
        String actTextItem = getTextFromElement(By.xpath("(//a[text()='HP LP3065'])[2]"));
        Assert.assertEquals("Not Matching", expTextItem, actTextItem);

        // 2.13 Verify the Delivery Date "2022-11-30"
        String expTextDate = "2022-11-30";
        String actTextDate = getTextFromElement(By.xpath("(//small[contains(text(), '2022-11-30')])[2]")).substring(15, 25);
        Assert.assertEquals("Not Matching", expTextDate, actTextDate);

        // 2.14 Verify the Model "Product21"
        String expTextModel = "Product 21";
        String actTextModel = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Not Matching", expTextModel, actTextModel);

        //2.15 Verify the Total "£74.73"
        clickOnElement(By.xpath("//form[@id='form-currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        String expTextTotal = "£74.73";
        String actTextTotal = getTextFromElement(By.xpath("(//td[@class='text-right' and text()='£74.73'])[5]"));
        Assert.assertEquals("Not Matching", expTextTotal, actTextTotal);

    }
    public void closeBrowser(){
        driver.quit();
    }
}


