package map;

import map.Service.ContacService;
import map.Service.Impl.ContactServiceImpl;

public class Main {
    public static void main(String[] args) {

        ContacService contacService = new ContactServiceImpl();
        contacService.addContact("Ernis","0772767978");
        contacService.addContact("Saikal","0771212121");
        contacService.addContact("Ayana","0779898989");
        contacService.addContact("Sultan","0776121212");
        contacService.addContact("Ernis","0900060201");
        System.out.println(contacService.getAllContact());
        System.out.println(contacService.getContact("Beka"));
        contacService.removeContact("Saikal");


    }
}