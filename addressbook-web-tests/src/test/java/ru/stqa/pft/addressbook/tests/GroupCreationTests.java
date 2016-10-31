package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGrouPage(); //перейти на страницу групп
    app.initGroupCreation(); //создать новую группу
    app.fillGroupForm(new GroupData("test1", "test2", "test3")); // заполнить новую группу данными
    app.submitGroupCreation(); // подтвердить создание новой группы
    app.returnToGroupPage(); // вернуться на страницу отображения групп
  }

}
