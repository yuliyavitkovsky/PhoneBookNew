package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() {  //Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                User.builder()
                        .email("buba@mail.com")
                        .password("Pp35467$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("buba@mail.com")
                        .password("Pp35467$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("buba@mail.com")
                        .password("Pp35467$")
                        .build()
        });

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Jack")
                        .lastName("Rain")
                        .phone("0025852369")
                        .email("buba22@mail.com")
                        .address("Tel-Aviv")
                        .description("friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Jack")
                        .lastName("Rain")
                        .phone("0025852368")
                        .email("buba111@mail.com")
                        .address("Tel-Aviv")
                        .description("friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Jack")
                        .lastName("Rain")
                        .phone("0025852367")
                        .email("buba333@mail.com")
                        .address("Tel-Aviv")
                        .description("friend")
                        .build()
        });
        return list.iterator();
    }
}
