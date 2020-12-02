package com.bridgelabz.addressbook;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        updateAddressBook();
    }

    static Map<String, AddressBookMain> addressBookMainHashMap = new HashMap<>();
    static AddressBookMain addressBookMain = new AddressBookMain();
    static Scanner scanner = new Scanner(System.in);
    static String addressBookName;
    int entry=0;
    public void addAddressBook() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter choice \n0.Creating new addressBook \n1.Adding contacts in existing register \n2.Exit ");
        entry = input.nextInt();
        if (entry != 2) {
            switch (entry) {
                case 0:
                    Scanner nameInput = new Scanner(System.in);
                    System.out.println(" Enter name of address book ");
                    String nameOfNewBook = nameInput.nextLine();
                    if (addressBookMainHashMap.containsKey(nameOfNewBook)) {
                        System.out.println(" address book already exists");
                        break;
                    }
                    addressBookMainHashMap.put(nameOfNewBook, addressBookMain);
                    System.out.println(" address  book" + " " + nameOfNewBook + " " + "has been added");
                    AddressBookMain.updateAddressBook();
                    break;
                case 1:
                    Scanner existingAddressName = new Scanner(System.in);
                    System.out.println(" Enter name of address book ");
                    String nameOfExistingRegister = existingAddressName.nextLine();
                    if (addressBookMainHashMap.containsKey(nameOfExistingRegister)) {
                        addressBookMainHashMap.get(nameOfExistingRegister);
                        AddressBookMain.updateAddressBook();
                    } else
                        System.out.println(" address book is not found ");
                case 2:
                    entry = 2;
                    break;
                default:
                    System.out.println(" Enter valid input ");
                    break;
            }
        }
    }

    public static void updateAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int count=1;
        while (count==1) {
            System.out.println("Welcome to address book program ");
            System.out.println(
                    "Enter choice \n1. AddContact  \n2.Edit \n3.Delete \n4 add addressBook");
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
                case 4:
                    addressBookMain.addAddressBook();
                    break;
                case 5:
                    if (addressBook.addressbookList.isEmpty()) {
                        System.out.println(" Address book is empty ");
                        break;
                    }
                    addressBook.searchByCity();
                    count = 0;
                    break;
                default:
                    System.out.println(" Enter a valid choice");
                    break;
            }
        }
    }
}