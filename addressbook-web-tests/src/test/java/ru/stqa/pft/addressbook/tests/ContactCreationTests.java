package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"name1", "lastname1", "nickname1", "home1", "mobile1", "work1"});
        list.add(new Object[]{"name2", "lastname2", "nickname2", "home2", "mobile2", "work2", "photo2"});
        list.add(new Object[]{"name3", "lastname3", "nickname3", "home3", "mobile3", "work3", "photo3"});

        return list.iterator();
    }

    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();

        File photo = new File("src/test/resources/191.jpg");
        contact = new ContactData().withFirstname("Anna").withLastname("Bulaeva")
                .withNickname("nickname").withHomePhone("home").withMobilePhone("mobile").withWorkPhone("work")
                .withGroup("test1").withPhoto(photo);
        app.contact().create(contact);
        app.contact().returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Anna'").withLastname("Bulaeva")
                .withNickname("nickname").withHomePhone("home").withMobilePhone("mobile").withWorkPhone("work").withGroup("test1");
        app.contact().create(contact);
        app.contact().returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
