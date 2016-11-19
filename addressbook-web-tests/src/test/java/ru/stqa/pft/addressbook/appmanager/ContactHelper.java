package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work on 02.11.2016.
 */
public class ContactHelper  extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact(int index) {
    if (!isCheckBoxSelected(By.name("selected[]"))) {
      wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
    }
  }
  public void selectContactById(int id) {
    if (!isCheckBoxSelected(By.name("selected[]"))) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void createContact(ContactData contactt) {
    initContactCreation();
    fillContactForm(contactt, true);
    submitContactCreation();
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void agreeContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements =wd.findElements(By.cssSelector("entry"));
    for (WebElement element : elements ) {
      List<WebElement> names =wd.findElements(By.cssSelector("td"));
      String firstname =names.get(2).getText();
      String lastname =names.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname,lastname, null, null,null);
      contacts.add(contact);
    }
    return contacts;
  }

}