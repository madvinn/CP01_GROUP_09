/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph;

/**
 *
 * @author Ortega A class that manually holds employee data and returns the list
 * of employee thru getEmployeeModelList
 */
public class EmployeeModelFromClass extends EmployeeModel {

    public EmployeeModelFromClass() {
        Employee employee1 = new Employee();
        employee1.setEmpNo("10002");
        employee1.setLastName("Matador");
        employee1.setFirstName("Christian");
        employee1.setBirthday("10/21/1987");
        employee1.setAddress("90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu");
        employee1.setPhoneNo("783-776-744");
        employee1.setSssNo("49-2959312-6");
        employee1.setPhilHealthNo("824187961962");
        employee1.setTinNo("103-100-522-000");
        employee1.setPagibigNo("631052853464");
        employee1.setStatus("Regular");
        employee1.setPosition("Account Team Leader");
        employee1.setSupervisor("Romualdez, Fredrick");
        employee1.setBasicSalary(42975);
        employee1.setRiceSubsidy(1500);
        employee1.setPhoneAllowance(800);
        employee1.setClothingAllowance(800);
        employee1.setSemiMonthlyRate(21488);
        employee1.setHourlyRate(255.80);

        Employee employee2 = new Employee();
        employee2.setEmpNo("10012");
        employee2.setLastName("Gomez");
        employee2.setFirstName("Selena");
        employee2.setBirthday("02/20/1975");
        employee2.setAddress("89A Armstrong Trace, Compostela 7874 Maguindanao");
        employee2.setPhoneNo("975-432-139");
        employee2.setSssNo("27-2090208-8");
        employee2.setPhilHealthNo("587272469938");
        employee2.setTinNo("482-259-498-000");
        employee2.setPagibigNo("719007608464");
        employee2.setStatus("Regular");
        employee2.setPosition("Account Team Leader");
        employee2.setSupervisor("Romualdez, Fredrick");
        employee2.setBasicSalary(41850);
        employee2.setRiceSubsidy(1500);
        employee2.setPhoneAllowance(800);
        employee2.setClothingAllowance(800);
        employee2.setSemiMonthlyRate(20925);
        employee2.setHourlyRate(249.11);

        Employee employee3 = new Employee();
        employee3.setEmpNo("10009");
        employee3.setLastName("San Jose");
        employee3.setFirstName("Allison");
        employee3.setBirthday("06/24/1986");
        employee3.setAddress("08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union");
        employee3.setPhoneNo("179-075-129");
        employee3.setSssNo("45-3251383-0");
        employee3.setPhilHealthNo("745148459521");
        employee3.setTinNo("121-203-336-000");
        employee3.setPagibigNo("114901859343");
        employee3.setStatus("Regular");
        employee3.setPosition("Account Rank and File");
        employee3.setSupervisor("Garcia, Manuel III");
        employee3.setBasicSalary(22500);
        employee3.setRiceSubsidy(1500);
        employee3.setPhoneAllowance(500);
        employee3.setClothingAllowance(500);
        employee3.setSemiMonthlyRate(11250);
        employee3.setHourlyRate(133.93);

        //populating the Employee array
        employees = new Employee[]{employee1, employee2, employee3};
    }

    @Override
    public Employee[] getEmployeeModelList() {
        return employees;
    }
}
