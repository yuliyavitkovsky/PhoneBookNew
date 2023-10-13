package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getHelperUser().isLogged()) app.getHelperUser().logOut();}
    @Test(groups = {"positive"})
   public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
          "buba_" + i + "@mail.com",
               "Pp35467$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        app.getHelperUser().logOut();
    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .email("buba_" + i + "mail.com")
                .password("Pp35467$")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User(user.getEmail(), user.getPassword()));
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(3000);
        logger.info("registrationNegativeTestWrongEmail starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = User.builder()
                .email("buba_" + i + "@mail.com")
                .password("Pp35467")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User(user.getEmail(), user.getPassword()));
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(3000);
        logger.info("registrationNegativeTestWrongPassword starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}