package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Work on 02.11.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void create(ContactData contactt) {
    initContactCreation();
    fillContactForm(contactt, true);
    submitContactCreation();
  }

  public void modify(ContactData contact) {
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    agreeContactDeletion();
    returnToHomePage();
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = wd.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withNickname(nickname).withMobile(mobile).withHome(home).withHome(work);
  }

  private void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    //WebElement row = checkbox.findElement(By.xpath("./../.."));
    //List<WebElement> cells = row.findElement(By.tagName("td"));
    //cells.get(7).findElement(By.tagName("a")).click();

    //способы найти нужный элемент на странице:
   // wd.findElement(By.xpath(String.format("//input[@value='%s]/../../td[8]/a", id))).click();
   // wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s]/td[8]/a", id))).click();
   // wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }

}