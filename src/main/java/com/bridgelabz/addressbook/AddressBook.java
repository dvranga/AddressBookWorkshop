package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);
    static List<AddressBookDetails> addressbookList = new ArrayList<AddressBookDetails>();
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
            addressbookList.add(addContact);
        System.out.println(addressbookList);

    }

    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter the first name ");
        String firstNameToCheck = scanner.nextLine();
        for (int index = 0; index < addressbookList.size(); index++) {
            if (addressbookList.get(index).getFirstName().equals(firstNameToCheck)) {
                System.out.println(addressbookList.get(index));
                @SuppressWarnings("resource")
                Scanner updateContact = new Scanner(System.in);
                System.out.println(" Enter a choice 	1.first name 2.last name 3. city 4.state 5.zip 6.phone 7.email ");
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println(" Enter first name ");
                        String first_Name = updateContact.nextLine();
                        addressbookList.get(index).setFirstName(first_Name);
                        System.out.println(addressbookList.get(index).getFirstName());
                        break;
                    case 2:
                        System.out.println(" Enter last name ");
                        String second_Name = updateContact.nextLine();
                        addressbookList.get(index).setLastName(second_Name);
                        break;
                    case 3:
                        System.out.println(" Enter city name ");
                        String input_City = updateContact.nextLine();
                        addressbookList.get(index).setCity(input_City);
                        break;
                    case 4:
                        System.out.println(" Enter State ");
                        String input_State = updateContact.nextLine();
                        addressbookList.get(index).setCity(input_State);
                        break;
                    case 5:
                        System.out.println(" Enter pincode ");
                        String input_Zip = updateContact.nextLine();
                        addressbookList.get(index).setCity(input_Zip);
                        break;
                    case 6:
                        System.out.println(" Enter Mobile number ");
                        String input_Phone = updateContact.nextLine();
                        addressbookList.get(index).setZip(input_Phone);
                        break;
                    case 7:
                        System.out.println(" Enter Email id ");
                        String input_Email = updateContact.nextLine();
                        addressbookList.get(index).setCity(input_Email);
                        break;
                    default:
                        System.out.println(" Enter valid input ");
                        break;
                }
            }
        }
        System.out.println(addressbookList);
    }

    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name : ");
        String firstName = sc.nextLine();
        for (int i = 0; i < addressbookList.size(); i++) {
            if (addressbookList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                addressbookList.remove(i);
            } else {
                System.out.println("No data found");
            }
        }
        sc.close();
    }
}