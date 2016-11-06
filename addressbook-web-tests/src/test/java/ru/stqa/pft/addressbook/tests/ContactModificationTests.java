package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Work on 02.11.2016.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Bulaeva", "Anettc", "Dubna", "+7(926) 340-53-27", null), false);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
