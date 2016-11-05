package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Work on 02.11.2016.
 */
public class ContactHelper  extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void deleteSelectedContact() {

    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    //click(By.xpath("//*[@id='content']/input[@value='Delete']"));

  }

  public void selectContact() {

    click(By.name("selected[]"));
  }

  public void returnToHomePage() {

    click(By.linkText("home"));
  }



  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }
}
