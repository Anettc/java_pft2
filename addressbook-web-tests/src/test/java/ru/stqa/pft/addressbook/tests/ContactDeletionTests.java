package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToHomePage();
 if (! app.getContactHelper().isThereAContact()){
 app.getContactHelper().createContact(new ContactData("firstname", "lastname", "nickname", "home", "mobile", "test1"));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().agreeContactDeletion();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}

