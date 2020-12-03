package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.IntStream;

public class AddressBookService {

    static Scanner scanner = new Scanner(System.in);
    static List<AddressBook> addressBookList = new ArrayList<AddressBook>();
    Map<String,List<AddressBook>> addressBookMap=new HashMap<String,List<AddressBook>>();
    AddressBook contact;


    public void editContact() {
        System.out.println(" Enter the book name ");
        String bookName = scanner.nextLine();
        List<AddressBook> addressBooks = addressBookMap.get(bookName);
        for (int index = 0; index < addressBooks.size(); index++) {
            if (addressBooks.get(index).getFirstName().equals(bookName)) {
                System.out.println(addressBooks.get(index));
                Scanner updateContact = new Scanner(System.in);
                System.out.println(" Enter a choice 	1.first name 2.last name 3. city 4.state 5.zip 6.phone 7.email ");
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println(" Enter first name ");
                        String first_Name = updateContact.nextLine();
                        addressBooks.get(index).setFirstName(first_Name);
                        System.out.println(addressBooks.get(index).getFirstName());
                        break;
                    case 2:
                        System.out.println(" Enter last name ");
                        String second_Name = updateContact.nextLine();
                        addressBooks.get(index).setLastName(second_Name);
                        break;
                    case 3:
                        System.out.println(" Enter city name ");
                        String input_City = updateContact.nextLine();
                        addressBooks.get(index).setCity(input_City);
                        break;
                    case 4:
                        System.out.println(" Enter State ");
                        String input_State = updateContact.nextLine();
                        addressBooks.get(index).setCity(input_State);
                        break;
                    case 5:
                        System.out.println(" Enter pincode ");
                        String input_Zip = updateContact.nextLine();
                        addressBooks.get(index).setCity(input_Zip);
                        break;
                    case 6:
                        System.out.println(" Enter Mobile number ");
                        String input_Phone = updateContact.nextLine();
                        addressBooks.get(index).setZip(input_Phone);
                        break;
                    case 7:
                        System.out.println(" Enter Email id ");
                        String input_Email = updateContact.nextLine();
                        addressBooks.get(index).setCity(input_Email);
                        break;
                    default:
                        System.out.println(" Enter valid input ");
                        break;
                }
                System.out.println(addressBookMap);
            }
        }
    }

    public void deleteContact() {
        System.out.println(" Enter the book name ");
        String bookName = scanner.nextLine();
        List<AddressBook> addressBooks = addressBookMap.get(bookName);
        IntStream.range(0, addressBooks.size()).forEach(index -> {
            System.out.println("Enter First Name : ");
            Scanner sc = new Scanner(System.in);
            String firstName = sc.nextLine();
            if (addressBooks.get(index).getFirstName().equalsIgnoreCase(firstName)) addressBooks.remove(index);
            else System.out.println("No Data Found");
        });
        System.out.println(addressBooks);
    }

    public void addNewAddressBook() {

        System.out.println("Enter the addressBook name");
        String addressBookName = scanner.nextLine();
        System.out.println("Enter 1 to add new addressBook 2 to existing addressBook 3 to Exit");
        int nextInt = scanner.nextInt();
        switch (nextInt){
            case 1:
                addNewContact(addressBookName);
                break;
            case 2:
                boolean containsKey = addressBookMap.containsKey(addressBookName);
                if (containsKey) {
                    System.out.println(addressBookMap);
                    AddressBook addressBook = addNewContact();
                    List<AddressBook> addressBooks = addressBookMap.get(addressBookName);

                    for (AddressBook details : addressBooks) {
                        if (addressBook.getFirstName().equals(details.firstName)) {
                            System.out.println("Contact " + details.firstName + " "+ " already exists");
                            break;
                        }
                    }
                    addressBooks.add(addressBook);
                    System.out.println(addressBookMap);
                }
                else{
                    System.out.println("No book is present");
                }
                break;
            default:
                break;

        }

    }

    private void addNewContact(String addressBookName) {
        AddressBook addressBook = addNewContact();
        List<AddressBook> addressBookList = new ArrayList<AddressBook>();
        addressBookList.add(addressBook);
        addressBookMap.put(addressBookName, addressBookList);
        System.out.println(addressBookMap);
    }

    private AddressBook addNewContact() {
        scanner.nextLine();
        System.out.println("Enter your firstName : ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your lastName : ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your address : ");
        String address = scanner.nextLine();
        System.out.println("Enter your city : ");
        String city = scanner.nextLine();
        System.out.println("Enter your state : ");
        String state = scanner.nextLine();
        System.out.println("Enter your zipCode : ");
        String zip = scanner.nextLine();
        System.out.println("Enter your phoneNo : ");
        String phoneNo = scanner.nextLine();
        System.out.println("Enter your emailId : ");
        String email = scanner.nextLine();
        AddressBook addressBook = new AddressBook(firstName, lastName, address, city, state, zip, phoneNo, email);
        return addressBook;
    }

}