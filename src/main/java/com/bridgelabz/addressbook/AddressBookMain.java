package com.bridgelabz.addressbook;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        updateAddressBook();
    }


    public static void updateAddressBook() throws IOException {
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int count=1;
        while (count==1) {
            System.out.println("Welcome to address book program ");
            System.out.println(
                    "Enter choice \n1. AddContact ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    count=0;
                    break;
                default:
                    System.out.println(" Enter a valid choice");
                    break;
            }
        }
    }
}