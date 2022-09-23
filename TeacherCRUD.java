package Test5_23Sep2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class TeacherCRUD {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void createRecord() {
        Connection connection;
        Statement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            String sql = "Create table Teacher (teacherId int, fname varchar(20),lname varchar(20)," +
                    "flatNo int , city varchar(20),pin int, salary float(2));";

            statement.execute(sql);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRecords() {

        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "insert into Teacher values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Enter the number of records to be added");
            int numOfRecords = Integer.parseInt(bufferedReader.readLine());


            for (int i = 0; i < numOfRecords; i++) {
                System.out.println("Enter the id of Teacher : ");
                int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter the first Name of Teacher : ");
                String fName = bufferedReader.readLine();
                System.out.println("Enter the last Name of Teacher : ");
                String lName = bufferedReader.readLine();
                System.out.println("Enter the flat No. of Teacher : ");
                int flatNo = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter the city of Teacher : ");
                String city = bufferedReader.readLine();
                System.out.println("Enter the pin of Teacher : ");
                int pin = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter the salary of Teacher : ");
                float salary = Float.parseFloat(bufferedReader.readLine());


                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, fName);
                preparedStatement.setString(3, lName);
                preparedStatement.setInt(4, flatNo);
                preparedStatement.setString(5, city);
                preparedStatement.setInt(6, pin);
                preparedStatement.setFloat(7, salary);

                preparedStatement.execute();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRecords() {
        Connection connection;
        Statement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            String sql = "Update teacher set salary = (salary + 5000)";

            statement.execute(sql);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRecords() {
        Connection connection;
        Statement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            System.out.println("Enter the id of Teacher to be deleted :");
            int id = Integer.parseInt(bufferedReader.readLine());

            String sql = "Delete from teacher where teacherId = " + id;

            statement.execute(sql);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void fetchRecords() {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            String sql = "Select * from Teacher";

            resultSet = statement.executeQuery(sql);

            System.out.println("\nRECORDS : ");
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + ", " +
                        "First Name : " + resultSet.getString(2) + ", " +
                        "Last Name : " + resultSet.getString(3) + ", " +
                        "Flat No : " + resultSet.getInt(4) + ", " +
                        "City Name : " + resultSet.getString(5) + ", " +
                        " Pin : " + resultSet.getInt(6) + ", " +
                        "Salary : " + resultSet.getFloat(7));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void salaryAndCity() {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            String sql = "Select * from Teacher where salary >= 10000 and city = 'Mumbai';";

            resultSet = statement.executeQuery(sql);

            System.out.println("\nSalary >= 10000 & city = Mumbai : ");
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + ", " +
                        "First Name : " + resultSet.getString(2) + ", " +
                        "Last Name : " + resultSet.getString(3) + ", " +
                        "Flat No : " + resultSet.getInt(4) + ", " +
                        "City Name : " + resultSet.getString(5) + ", " +
                        " Pin : " + resultSet.getInt(6) + ", " +
                        "Salary : " + resultSet.getFloat(7));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void sortByLastName() {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            statement = connection.createStatement();

            String sql = "Select * from Teacher order by lname desc";

            resultSet = statement.executeQuery(sql);

            System.out.println("\nRECORDS : ");
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt(1) + ", " +
                        "First Name : " + resultSet.getString(2) + ", " +
                        "Last Name : " + resultSet.getString(3) + ", " +
                        "Flat No : " + resultSet.getInt(4) + ", " +
                        "City Name : " + resultSet.getString(5) + ", " +
                        " Pin : " + resultSet.getInt(6) + ", " +
                        "Salary : " + resultSet.getFloat(7));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
