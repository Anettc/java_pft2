package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Work on 01.11.2016.
 */
public class HelperBase {

  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
  public boolean isCheckBoxSelected(By by) {
    return findElement(by).isSelected();
  }

  public WebElement findElement(By locator) {
    return findElement(locator);
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    }
    catch (NoSuchElementException ex){
      return false;
    }
  }
}