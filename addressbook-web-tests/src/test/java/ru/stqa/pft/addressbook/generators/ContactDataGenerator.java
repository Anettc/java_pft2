package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анна on 20.12.2016.
 */
public class ContactDataGenerator {
    @Parameter(names = "-c" , description = "Contact count" )
    public  int count;

    @Parameter (names = "-f" , description = "Target file" )
    public String file;


    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }
        catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();


    }

    private void run() throws IOException {
        List<ContactData> contacts = generatsContacts(count);
        save(contacts, new File(file));

    }

    private void save(List<ContactData> contacts, File file) throws IOException{
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts ){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(),contact.getNickname(),
                                  contact.getHomePhone(), contact.getMobilePhone(),
                                  contact.getWorkPhone(), contact.getGroups(), contact.getPhoto()));

        }
        writer.close();
    }

    private List<ContactData> generatsContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++){
            File photo = new File("src/test/resources/191.jpg");
            contacts.add(new ContactData().withFirstname(String.format("name%s", i)).withLastname(String.format("lastname%s", i))
                    .withNickname(String.format("nickname%s", i)).withHomePhone(String.format("home%s", i)).withMobilePhone("mobile")
                                 .withWorkPhone(String.format("work%s", i)).withGroup(null)
                                  .withPhoto(photo));
        }
        return contacts;
    }
}


