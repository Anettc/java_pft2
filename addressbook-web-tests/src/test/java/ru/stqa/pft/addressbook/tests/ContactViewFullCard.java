package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Анна on 14.12.2016.
 */
public class ContactViewFullCard extends TestBase {
    @Test
    public void testContactViewFullCards() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);//сравнение данных, которые занесены при создании контакта и тех, что отображаются в карточке полной информации
        String ContactViewFull = cleaned(app.contact().contactInfoFromEditForm(contact));
        assertThat(ContactViewFull, equalTo(cleaned(mergeFullcard(contactInfoFromEditForm))));//сравниваем список заполненных данных и данных с краткой карточки
    }


    private String mergeFullcard(ContactData contact) { //склеиваем строки(важен порядок полей)
        return Arrays.asList(contact.getFirstname(),contact.getLastname(),contact.getNickname(),contact.getAddress()
                ,contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));

    }
    private static String cleaned(String s) { //убираем лишние символы

        return s.replaceAll("\\s", "").replaceAll("\n","").replaceAll("[HMW]","").replaceAll("[-():]","");
    }
}


