package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Work on 01.11.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {

    super(wd);
  }

  public void gotoGrouPage() {

    click(By.linkText("groups"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }
}
