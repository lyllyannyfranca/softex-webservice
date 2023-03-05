package app;

import app.model.Contact;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ContactServer {
    @WebMethod void createContact(String name, String phoneNumber);
    @WebMethod
    ArrayList<Contact> getAllContact();
    @WebMethod boolean thisContactExist(String phoneNumber);
    @WebMethod void deleteContact(String phoneNumber);
}
