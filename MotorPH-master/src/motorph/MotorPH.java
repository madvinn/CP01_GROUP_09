package motorph;

import java.util.Scanner;

/**
 *
 * @author Group 09
 */
public class MotorPH {

    private static EmployeeModel employeeModel;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        employeeModel = new EmployeeModelFromFile();
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("***********************************************");
        System.out.println("        Motor PH Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: List of Employee Records");
        System.out.println("2: Calculate Net Salary");
        System.out.println("3: Calculate Salary based on Hours Worked");
        System.out.println("************************************************");

        System.out.print("Please choose the screen you would like to view: ");
        String option = input.nextLine();

        processOption(option);
    }

    private static void processOption(String option) {
        switch (option) {
            case "1":
                processListOfEmployees();
                break;
            case "2":
                calculateNetSalary();
                break;
            case "3":
                salaryOnHoursWorked();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayMainMenu();//display the main menu again
                break;
        }
    }

    private static void processListOfEmployees() {//this is a null checker
        Employee[] employeeList = employeeModel.getEmployeeModelList();

        if (employeeList == null || employeeList.length == 0) {
            System.out.println("Error: No employees found.");
            return;
        }

        System.out.println("***********************************************");
        System.out.println("        List of Employees        ");
        System.out.println("***********************************************");

        for (Employee employee : employeeList) {//this is a null checker
            if (employee == null) {
                System.out.println("Error: An employee record is missing.");
                continue;
            }

            System.out.println("Employee No: " + employee.getEmpNo());
            System.out.println("Name: " + employee.getLastName() + ", " + employee.getFirstName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Status: " + employee.getStatus());
            System.out.println("Basic Salary: " + employee.getBasicSalary());
            System.out.println("----------------------------------------------");
        }
    }

    private static void calculateNetSalary() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryDeductions salaryDeductions = new SalaryDeductions();

        System.out.println("***********************************************");
        System.out.println("        Employee Net Salaries      ");
        System.out.println("***********************************************");

        for (Employee employee : employeeList) {
            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Net Salary: " + (employee.getBasicSalary() - salaryDeductions.getTotalDeductions(employee.getBasicSalary())));
        }
    }

    private static void salaryOnHoursWorked() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryOnHoursWorked hoursWorked = new SalaryOnHoursWorked();

        System.out.println("***********************************************");
        System.out.println("     Salaries based on hours worked      ");
        System.out.println("***********************************************");

        for (Employee employee : employeeList) {
            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Salary Based on Hours Worked: " + hoursWorked.getSalaryOnHoursWorked(employee.getHourlyRate()));
        }
    }
}
