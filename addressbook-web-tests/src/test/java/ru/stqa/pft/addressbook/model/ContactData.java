package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  String firstname;
  private  String lastname;
  private  String nickname;
  private  String home;
  private  String mobile;
  private int id= Integer.MAX_VALUE;;
  private String group;


  public ContactData(String firstname, String lastname, String nickname, String home, String mobile, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.home = home;
    this.mobile = mobile;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname, Object o, Object o1, Object o2) {

  }

  public void setId(int id) {
    this.id = id;
  }

   public ContactData(int id, String firstname, String lastname, String nickname, String home, String mobile, String group) {
     this.id = id;
     this.firstname = firstname;
     this.lastname = lastname;

     this.nickname = nickname;
     this.home = home;
     this.mobile = mobile;
     this.group = group;
   }


  public int getId() {
    return id;
  }


  public ContactData(String id, String firstname, String lastname, Object home, Object mobile, Object group) {
    this.firstname = firstname;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}



