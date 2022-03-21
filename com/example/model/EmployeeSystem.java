package com.example.model;

import com.example.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class  CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomException(String str) {
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}

public class EmployeeSystem {

    public static Map<Integer, Employee> map =  new HashMap<Integer, Employee>();

    public static void addEmployee(String name, int age, int id) {
        Employee emp = new Employee(name, age, id);
        map.put(id, emp);

        operations();
    }

    public static void deleteEmployee(int EmpId) throws CustomException {
        if (map.containsKey(EmpId)) {
            map.remove(EmpId);
            System.out.println("Successfully Delete from the List !!");
        }else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void searchEmployee(int empId) throws CustomException {
        if (map.containsKey(empId)) {
            System.out.println("Employee Details: - " + map.get(empId));
        }else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void employeeList() {
        System.out.println(map.toString());
    }


    public static void operations() {
        System.out.println("\n ****** Employee management system ******");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee List");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Enter Employee Details(Name, age, Id)");
                Scanner scanner1 = new Scanner(System.in);

                String name = scanner1.next();
                int age = scanner1.nextInt();
                int id = scanner1.nextInt();
                if (!name.equals("") && age != 0 && id != 0){
                    addEmployee(name,age,id);
                }
                break;

            case 2:
                System.out.println("Enter Employee Id: ");
                Scanner scanner2 = new Scanner(System.in);

                int EmpId = scanner2.nextInt();
                try {
                    deleteEmployee(EmpId);
                }catch (CustomException e){
                    e.printStackTrace();
                }
                break;

            case 3:
                System.out.println("Enter Employee Id: ");
                Scanner scanner3 = new Scanner(System.in);

                int empId = scanner3.nextInt();
                try {
                    searchEmployee(empId);
                }catch (CustomException e){
                    e.printStackTrace();
                }
                operations();
                break;

            case 4:
                employeeList();

                operations();
                break;

            default:
                System.out.println("Please choose again");
        }
    }

    public static void main(String[] args) {
        operations();
    }

}
