package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("firstname", "lastname", "nickname", "home", "mobile", "test1"));
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
   Assert.assertEquals(after, before + 1);
  }
}
