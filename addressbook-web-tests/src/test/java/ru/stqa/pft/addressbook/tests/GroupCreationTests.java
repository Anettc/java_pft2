package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGrouPage(); //перейти на страницу групп
    app.getGroupHelper().initGroupCreation(); //создать новую группу
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3")); // заполнить новую группу данными
    app.getGroupHelper().submitGroupCreation(); // подтвердить создание новой группы
    app.getGroupHelper().returnToGroupPage(); // вернуться на страницу отображения групп
  }

}
