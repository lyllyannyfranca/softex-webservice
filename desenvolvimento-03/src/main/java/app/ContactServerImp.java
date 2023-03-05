package app;

import app.model.Contact;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "app.ContactServer")

public class ContactServerImp implements ContactServer {

    private final ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    public void createContact(String name, String phoneNumber) throws RuntimeException{
        try {
            contactList.add(new Contact(name, phoneNumber));
            System.out.println("Contato criado com sucesso!");
        } catch (RuntimeException error) {
            System.err.println("Erro: " + error.getMessage());
        }
    }

    @Override
    public ArrayList<Contact> getAllContact() {
        return contactList;
    }

    @Override
    public boolean thisContactExist(String phoneNumber) {
        for (Contact contacts:
             contactList) {
            if (contacts.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteContact(String phoneNumber) {
        contactList.removeIf(contacts -> contacts.getPhoneNumber().equals(phoneNumber));
        System.out.println("Contato apagado com sucesso!");
    }
}
