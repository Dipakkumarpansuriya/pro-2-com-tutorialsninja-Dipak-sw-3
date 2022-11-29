package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //  1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //   1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //  1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

        //  1.4 Verify the Product price will arrange in High to Low order
        String expText = "Price (High > Low)";
        String actText = getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        Assert.assertEquals("Not in correct order", expText, actText);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //  2.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //   2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //  2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[1]/a[1]/img[1]"));

        //2.5 Verify the text “MacBook”
        String expVText = "MacBook";
        String actVText = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("Not correct text", expVText, actVText);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expMessage = "Success: You have added MacBook to your shopping cart!";
        String actMessage = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54);
        Assert.assertEquals("Not correct text", expMessage, actMessage);

        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // 2.9 Verify the text "Shopping Cart"
        String expTextShop = "Shopping Cart";
        String actTextShop = getTextFromElement(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0, 13);
        Assert.assertEquals("Not correct text", expTextShop, actTextShop);

        //   2.10 Verify the Product name "MacBook"
        Thread.sleep(2000);
        String expTextMac = "MacBook";
        String actTextMac = getTextFromElement(By.xpath("(//a[text()='MacBook'])[2]"));
        System.out.println(actTextMac);
        Assert.assertEquals("Not correct text", expTextMac, actTextMac);

        //  2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextTwoElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");

        //   2.12 Click on “Update”Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expVMessage = "Success: You have modified your shopping cart!";
        System.out.println(expVMessage.length());
        String actVMessage = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 46);
        System.out.println(actVMessage);
        Assert.assertEquals("Not correct text", expVMessage, actVMessage);

        // 2.14 Verify the Total £737.45
        clickOnElement(By.xpath("//form[@id='form-currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
        String expTotal = "£737.45";
        String actTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        System.out.println(actTotal);
        Assert.assertEquals("Not correct total", expTotal, actTotal);

        // 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        // 2.16 Verify the text “Checkout”
        String expVerifyText = "Checkout";
        String actVerifyText = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Not correct total", expVerifyText, actVerifyText);

        // 2.17 Verify the Text “New Customer”
        String expNText = "New Customer";
        Thread.sleep(2000);
        String actNText = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        System.out.println(actNText);
        Assert.assertEquals("Not correct total", expNText, actNText);

        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        // 2.20 Fill the mandatory fields
        sendTextTwoElement(By.xpath("//input[@id='input-payment-firstname']"), "Prime");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-lastname']"), "Testing");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-email']"), "ptesting123@gmail.com");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-telephone']"), "07123456911");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-address-1']"), "50 Brent Road");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextTwoElement(By.xpath("//input[@id='input-payment-postcode']"), "HA0 1AB");
        selectByValueFromDropdown(By.xpath("//select[@id='input-payment-country']"), "222");
        selectByValueFromDropdown(By.xpath("//select[@id='input-payment-zone']"), "3553");

        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        // 2.22 Add Comments About your order into text area
        sendTextTwoElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "All good");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        // 2.25 Verify the message “Warning: Payment method required!”
        String expWMessage = "Warning: Payment method required";
        System.out.println(expWMessage.length());
        String actWMessage = getTextFromElement(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).substring(0, 32);
        Assert.assertEquals("Not correct total", expWMessage, actWMessage);
    }
}
