package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String home;
  private final String mobile;

  public ContactData(String firstname, String lastname, String nickname, String home, String mobile) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.home = home;
    this.mobile = mobile;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }
}
