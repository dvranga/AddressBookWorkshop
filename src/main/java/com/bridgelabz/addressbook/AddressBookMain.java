package com.bridgelabz.addressbook;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        updateAddressBook();
    }


    public static void updateAddressBook() {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int count=1;
        while (count==1) {
            System.out.println("Welcome to address book program ");
            System.out.println(
                    "Enter choice \n1. AddContact  \n2.Edit \n3.Delete");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    if (AddressBook.addressbookList.isEmpty()) {
                        System.out.println(" Address book is empty ");
                        break;
                    }
                    addressBook.editContact();
                    break;
                case 3:
                    if (AddressBook.addressbookList.isEmpty()) {
                        System.out.println(" Address book is empty ");
                        break;
                    }
                    addressBook.deleteContact();
                    break;
                default:
                    System.out.println(" Enter a valid choice");
                    break;
            }
            count=0;
        }
    }
}