package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseClass {

    // This mathod will click on element
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextTwoElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();

    }

//*****************************Alert Methods**************************************************

    //this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //acceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //dismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //String getTextFromAlert
    public String getTextFromAlert(String text) {
        driver.switchTo().alert().getText();
        return text;
    }

    //sendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //********* Select class methods ******************************************************************


    //This method will select option by visible text
    public void selectByVisibleTextFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method will select the option by value
    public void selectByValueFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    // This method will select the option by index
    public void selectByIndexFromDropdown(By by, int i) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(i);
    }

    // This method will select the option by contains text
    public void selectByContainsFromDropdown(By by) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> List = select.getOptions();
    }
    //****************** Actrion Class **********************************************************

    //mouseHoverToElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

}

