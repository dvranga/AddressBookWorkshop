package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);
    static List<AddressBookDetails> lst = new ArrayList<AddressBookDetails>();
    AddressBookDetails addContact;

    public void addContact() {
        System.out.println("Enter your firstName : ");
        String firstName = sc.nextLine();
        System.out.println("Enter your lastName : ");
        String lastName = sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        System.out.println("Enter your city : ");
        String city = sc.nextLine();
        System.out.println("Enter your state : ");
        String state = sc.nextLine();
        System.out.println("Enter your zipCode : ");
        String zip = sc.nextLine();
        System.out.println("Enter your phoneNo : ");
        String phoneNo = sc.nextLine();
        System.out.println("Enter your emailId : ");
        String email = sc.nextLine();
        addContact = new AddressBookDetails(firstName, lastName, address, city, state, zip, phoneNo, email);
            lst.add(addContact);

    }

}