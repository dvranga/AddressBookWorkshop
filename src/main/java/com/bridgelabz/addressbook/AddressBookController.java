package com.bridgelabz.addressbook;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookController {

    public static void main(String[] args) throws IOException {
        updateAddressBook();
    }

    public static void updateAddressBook() throws IOException {
        AddressBookService addressBookService = new AddressBookService();
        Scanner scanner = new Scanner(System.in);
        int execute=1;
        while (execute==1) {
            System.out.println(
                    "Enter choice 1. add addressBook or contact  2.Edit 3.Delete 5 search in city 6 search in state");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addressBookService.addNewAddressBook();
                    break;
                case 2:
                    if (AddressBookService.addressBookList.isEmpty()) {
                        System.out.println(" Address book is empty ");
                        break;
                    }
                    addressBookService.editContact();
                    break;
                case 3:
                    if (AddressBookService.addressBookList.isEmpty()) {
                        System.out.println(" Address book is empty ");
                        break;
                    }
                    addressBookService.deleteContact();
                    execute=0;
                    break;
                default:
                    System.out.println(" Enter a valid choice");
                    break;
            }
        }
    }
}