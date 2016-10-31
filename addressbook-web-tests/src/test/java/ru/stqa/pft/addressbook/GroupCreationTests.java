package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGrouPage(); //перейти на страницу групп
    initGroupCreation(); //создать новую группу
    fillGroupForm(new GroupData("test1", "test2", "test3")); // заполнить новую группу данными
    submitGroupCreation(); // подтвердить создание новой группы
    returnToGroupPage(); // вернуться на страницу отображения групп
  }

}
