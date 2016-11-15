package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Work on 02.11.2016.
 */
public class ContactHelper  extends HelperBase{

  public ContactHelper(WebDriver wd) { super(wd); }


  public void deleteSelectedContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

  public void selectContact(int index){
          wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("home"),contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else  {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void submitContactCreation() {  click(By.name("submit"));}

  public void returnToHomePage() { click(By.linkText("home"));}

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
}

