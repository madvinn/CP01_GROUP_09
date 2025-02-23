package motorph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * read from csv
 */
public class EmployeeModelFromFile extends EmployeeModel {

    public EmployeeModelFromFile() {
        File file = new File("C:/MotorPH-master/MotorPH-master/src/FilesToBeRead/MotorPH Employee Data.csv");
        getDataFromFile(file);
        if (employees == null) { 
            employees = new Employee[0]; //null check
        }
    }

    @Override
    public Employee[] getEmployeeModelList() {
        return employees;
    }

    private void getDataFromFile(File textFile) {
        try {
            if (!textFile.exists()) {//check if file exists to avoid FileNotFoundException
                System.out.println("Error: CSV file not found!");
                employees = new Employee[0];
                return;
            }

            Scanner lineCounter = new Scanner(textFile);
            int lines = 0;
            while (lineCounter.hasNextLine()) {
                lineCounter.nextLine();
                lines++;
            }
            lineCounter.close();
    
            //header wont be included in the array
            employees = new Employee[lines - 1];
    
            Scanner scannerToGetFile = new Scanner(textFile);
            
            if (scannerToGetFile.hasNextLine()) {
                scannerToGetFile.nextLine(); //skip line 1(header) on csv
            }
    
            int counter = 0;
            while (scannerToGetFile.hasNextLine()) {
                String data = scannerToGetFile.nextLine();
                Scanner scannerForParsing = new Scanner(data);
                parseDataFromScanner(scannerForParsing, counter);
                counter++;
            }
            scannerToGetFile.close();
    
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found.");
            employees = new Employee[0]; //null check
        }
    }
    

    private void parseDataFromScanner(Scanner scanner, int counter) {
        scanner.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); //handles commas inside quotes
    
        if (!scanner.hasNext()) {
            System.out.println("Error: Empty line detected!");
            return;
        }
    
        Employee employee = new Employee();
        employee.setEmpNo(cleanString(scanner.next()));
        employee.setLastName(cleanString(scanner.next()));
        employee.setFirstName(cleanString(scanner.next()));
        employee.setBirthday(cleanString(scanner.next()));
        employee.setAddress(cleanString(scanner.next()));
        employee.setPhoneNo(cleanString(scanner.next()));
        employee.setSssNo(cleanString(scanner.next()));
        employee.setPhilHealthNo(cleanString(scanner.next()));
        employee.setTinNo(cleanString(scanner.next()));
        employee.setPagibigNo(cleanString(scanner.next()));
        employee.setStatus(cleanString(scanner.next()));
        employee.setPosition(cleanString(scanner.next()));
        employee.setSupervisor(cleanString(scanner.next()));
    
        employee.setBasicSalary(parseDoubleOrZero(scanner.next()));
        employee.setRiceSubsidy(parseDoubleOrZero(scanner.next()));
        employee.setPhoneAllowance(parseDoubleOrZero(scanner.next()));
        employee.setClothingAllowance(parseDoubleOrZero(scanner.next()));
        employee.setSemiMonthlyRate(parseDoubleOrZero(scanner.next()));
        employee.setHourlyRate(parseDoubleOrZero(scanner.next()));
    
        employees[counter] = employee;
    }
    
    /**
     * trimming and removing quotes
     */
    private String cleanString(String value) {
        return value.replaceAll("^\"|\"$", "").trim();
    }
    
    private double parseDoubleOrZero(String value) {
        if (value.equalsIgnoreCase("N/A") || value.trim().isEmpty()) {
            return 0.0; //N/A to 0.0
        }
        value = value.replaceAll("^\"|\"$", "").replace(",", ""); //remove quotes and commas
        return Double.parseDouble(value);
    }    
}    
