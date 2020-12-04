package com.bridgelabz.addressbook.database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    private static AddressBookDBService addressBookDBService;
    private PreparedStatement addressBookDataStatement;

    public AddressBookDBService() {
    }

    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null) {
             addressBookDBService = new AddressBookDBService();
        }
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_db?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println(connection + " connection succesful");
        return connection;
    }

    public List<AddressBookData> readDate() {
        String query = "SELECT * from address_book";
        return this.getAddressBookDataUsingDB(query);
    }

    private List<AddressBookData> getAddressBookDataUsingDB(String query) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            addressBookList = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private List<AddressBookData> getAddressBookData(ResultSet resultSet) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int personId = resultSet.getInt("person_id");
                int typeId= resultSet.getInt("type_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                LocalDate date_added = resultSet.getDate("date_added").toLocalDate();
                addressBookList.add(new AddressBookData(id,personId,typeId,firstName,lastName,phoneNumber,email,city,state,zip,date_added ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    public int updateAddressBookRecord(String name, String phoneNumber) throws AddressBookException {
        String query = String.format("update address_book set phone_number = '%s' where first_name= '%s' ;", phoneNumber, name);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DatabaseException);
        }
    }
    private void prepareStatementForAddressBook() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE `first_name` = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AddressBookData> getAddressBookData(String first_name) {
        List<AddressBookData> addressBookDataList = null;
        if (this.addressBookDataStatement == null) {
            this.prepareStatementForAddressBook();
        }
        try {
            addressBookDataStatement.setString(1, first_name);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            addressBookDataList =this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookDataList;
    }


    public List<AddressBookData> getEmployeePayrollForDateRange(LocalDate startDate, LocalDate endDate) {
        String query = String.format("SELECT * FROM address_book WHERE date_added BETWEEN '%s' AND '%s';",
                Date.valueOf(startDate), Date.valueOf(endDate));
        return this.getAddressBookDataUsingDB(query);
    }
}
