package map.Service.Impl;

import map.Service.ContacService;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContacService {
    Map<String,String> contacts = new HashMap<>();

    @Override
    public void addContact(String name, String phoneNumber) {
        contacts.put(name,phoneNumber);
        System.out.println(name + "Contact added");
    }

    @Override
    public String getContact(String name) {
       return contacts.get(name);
    }

    @Override
    public void removeContact(String name) {
        contacts.remove(name);
    }

    @Override
    public Map<String, String> getAllContact() {
        return Map.of();
    }


}
