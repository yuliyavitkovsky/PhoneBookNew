package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!app.getHelperUser().isLogged())
            app.getHelperUser().login(
        User.builder()
                .email("buba@mail.com")
                .password("Pp35467$")
                .build()
  //  new User("buba@mail.com", "Pp35467$")
                    );

    }

    @Test(invocationCount = 2)
    public void AddNewContactPositive(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Silver")
                .phone("12345678" + i)
                .email("john" + i + "@mail.com")
                .address("Rehovot")
                .description("friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("AddNewContactPositive successfully added a new user: "+ contact.getName()+ " with a phone number: " + contact.getPhone());
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));

    }
}
