package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationPositiveTest() {
        //open login form
     //   wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();

        //fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("buba_" + i + "@mail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Pp35467$");
        app.getHelperUser().fillLoginRegistrationForm("buba_" + i + "@mail.com", "Pp35467$");

        //click registration-button
      //  wd.findElement(By.xpath("//button[2]")).click();
        app.getHelperUser().submitRegistration();

        //assert
//        pause(3000);
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        app.getHelperUser().logOut();
        app.getHelperUser().pause(3000);
    }

    @Test
    public void registrationNegativeTestWrongEmail() {
        //open login form
       // wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();

        //fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("bubamail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Pp35467$");
        app.getHelperUser().fillLoginRegistrationForm("bubamail.com", "Pp35467$");

        //click registration-button
       // wd.findElement(By.xpath("//button[2]")).click();
        app.getHelperUser().submitRegistration();

        //assert
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}