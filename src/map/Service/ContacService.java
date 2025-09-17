package map.Service;

import java.util.Map;

public interface ContacService {

    void  addContact (String name, String phoneNumber);
    String getContact(String name);
    void removeContact(String name);
    Map<String,String>  getAllContact();
}
