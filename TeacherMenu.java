package Test5_23Sep2022;

import java.util.Scanner;

public class TeacherMenu {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n1.Create Table " +
                    "\n2.Insert Record" +
                    "\n3.Update Record" +
                    "\n4.Delete Records" +
                    "\n5.Fetch Records" +
                    "\n6.Display salary >= 10000 & city = Mumbai" +
                    "\n7.Sort By LastName" +
                    "\n Default : Exit ");

            System.out.println("\nPlease Enter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new TeacherCRUD().createRecord();
                    break;
                case 2:
                    new TeacherCRUD().insertRecords();
                    break;
                case 3:
                    new TeacherCRUD().updateRecords();
                    break;
                case 4:
                    new TeacherCRUD().deleteRecords();
                    break;
                case 5:
                    new TeacherCRUD().fetchRecords();
                    break;
                case 6:
                    new TeacherCRUD().salaryAndCity();
                    break;
                case 7:
                    new TeacherCRUD().sortByLastName();
                default:
                    System.exit(0);


            }
        }


    }
}
