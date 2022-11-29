package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Random;

public class MyAccountsTest extends Utility {

    //String baseUrl = "http://tutorialsninja.com/demo/index.php?route=account/register";
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> list = driver.findElements(By.xpath("//body/nav/div/div/ul/li/ul/li"));
        for (WebElement options : list) {
            System.out.println(options.getText());
            if (options.getText().equalsIgnoreCase(option)) {
                options.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));
        selectMyAccountOptions("Register");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));
        selectMyAccountOptions("Login");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){

      // 3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

      // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

      // 3.3 Enter First Name
        String firstName = "Parmeshwaran";
        sendTextTwoElement(By.id("input-firstname"), firstName);

      // 3.4 Enter Last Name
        String lastName = "Hariharan";
        sendTextTwoElement(By.id("input-lastname"), lastName);
      // 3.5 Enter Email
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        sendTextTwoElement(By.id("input-email"), firstName + "." + lastName + emailNum + "@email.com");
        String email = firstName + "." + lastName + emailNum + "@email.com";
        System.out.println("Register email is = " + firstName + "." + lastName + emailNum + "@email.com");

        //3.6 Enter Telephone
        sendTextTwoElement(By.id("input-telephone"), "7848548899");

        //3.7 Enter Password
        int passNum = randomGenerator.nextInt(999);
        sendTextTwoElement(By.id("input-password"), lastName + "#" + passNum);
        String password = lastName + "#" + passNum;
        System.out.println("Password is " + lastName + "#" + passNum);

        // 3.8 Enter Password Confirm
        sendTextTwoElement(By.id("input-confirm"), lastName + "#" + passNum);

        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@type='radio'])[2]"));

        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));

        // 3.12 Verify the message “Your Account Has Been Created!”
        String expTextAccount = "Your Account Has Been Created!";
        String actTextAccount = getTextFromElement(By.xpath("//h1[contains(text(), 'Been Created')]"));
        Assert.assertEquals("Not Matching", expTextAccount, actTextAccount);


        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));

        // 3.14 Click on My Account Link
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // 3.16 Verify the text “Account Logout”
        String expTextLogout = "Account Logout";
        String actTextLogout = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        Assert.assertEquals("Not Logout", expTextLogout, actTextLogout);

        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

         //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextTwoElement(By.id("input-email"), "Parmeshwaran.Hariharan5229@email.com");

         //4.4 Enter Last Name

         //4.5 Enter Password
        sendTextTwoElement(By.id("input-password"), "Hariharan#239");

         //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        //4.7 Verify text “My Account”
        String expTextMyAccount = "My Account";
        String actTextMyAccount = getTextFromElement(By.xpath("//h2[text()='My Account']"));
        Assert.assertEquals("Not Logged in", expTextMyAccount, actTextMyAccount);

        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        String expTextLogout = "Account Logout";
        String actTextLogout = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        Assert.assertEquals("Not Logout", expTextLogout, actTextLogout);

         //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }
    public void closeBrowser(){
        driver.quit();
    }

}
