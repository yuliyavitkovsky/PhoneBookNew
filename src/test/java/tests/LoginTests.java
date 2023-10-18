package tests;


import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)

public class LoginTests extends TestBase{

//    WebDriver wd;

//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
@BeforeMethod(alwaysRun = true)
public void precondition(){
    if(app.getHelperUser().isLogged()) app.getHelperUser().logout();
}
    @Test(groups = {"positive"})
    public  void loginPositiveTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User(
                "buba@mail.com",
                "Pp35467$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        logger.info("loginPositiveTest starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    //    app.getHelperUser().logout();
    }
    @Test(groups = {"positive"})
    public void loginPositiveTestModel(){

        User user = User.builder()
                .email("buba@mail.com")
                        .password("Pp35467$")
                                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User(user.getEmail(), user.getPassword()));
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        logger.info("loginPositiveTestModel starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
     //   app.getHelperUser().logout();
    }
    @Test(groups = {"positive"})
    public void loginPositiveTestProps(){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        logger.info("loginPositiveTestModel starts with: "+ app.getEmail()+ " & " + app.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
     //   app.getHelperUser().logout();
    }
    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User(user.getEmail(), user.getPassword()));
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(5000);
        logger.info("loginPositiveTestModel starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        //   app.getHelperUser().logout();
    }
    @Test(groups = {"negative", "smoke"})
    public  void loginNegativeTestWrongEmail(){

        User user = User.builder()
                .email("bubamail.com")
                .password("Pp35467$")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        logger.info("loginNegativeTestWrongEmail starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

    @Test(groups = {"negative"})
    public  void loginNegativeTestWrongPassword(){
        User user = User.builder()
                .email("buba@mail.com")
                .password("Pp35467")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
        logger.info("loginNegativeTestWrongPassword starts with: "+ user.getEmail()+ " & " + user.getPassword());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
//    @AfterMethod
//    public void tearDown(){
//        pause(5000);
//        wd.quit();
//    }

}
