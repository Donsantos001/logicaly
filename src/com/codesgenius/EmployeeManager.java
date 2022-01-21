package com.codesgenius;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeManager {
    static Scanner scan = new Scanner(System.in);
    static LinkedList<Employee> employees;
    static int employeesID;

    public static void main(String[] args) {
        employees = new LinkedList<>();
        employeesID = 1;
        int option = 0;

        System.out.println("Welcome to LOGICALY employees' record manager!");

        while(option != 7){
            System.out.println("============++ Operations Menu ++=================");
            System.out.println("1. Add a new employee");
            System.out.println("2. Update an employee");
            System.out.println("3. Search an employee");
            System.out.println("4. Display all employees' record");
            System.out.println("5. Delete an employee");
            System.out.println("6. Generate a file");
            System.out.println("7. Exit");
            option = scan.nextInt();
            switch (option){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    generateFile();
                    break;
                default:
                    break;
            }
            if(option == 7){
                System.out.println("See you next time on Logicaly Employees Manager");
            }
        }
    }

    public static void addEmployee(){
        Employee newEmp = new Employee();
        boolean valid = false;
        while(!valid){
            try{
                System.out.println("Enter Employee Number");
                newEmp.setEmployeeNum(scan.next());
                System.out.println("Enter Full Name");
                scan.nextLine();
                newEmp.setFullName(scan.nextLine());
                System.out.println("Enter Title");
                newEmp.setTitle(scan.nextLine());
                System.out.println("Enter Department");
                newEmp.setDepartment(scan.nextLine());
                System.out.println("Enter Phone Number");
                newEmp.setPhoneNumber(scan.nextLine());
                System.out.println("Enter Email address");
                newEmp.setEmailAddress(scan.nextLine());
                newEmp.setID(employeesID++);
                employees.add(newEmp);
                valid = true;
            }
            catch (Exception e){
                System.err.println(e);
            }
        }
    }

    public static void updateEmployee(){
        System.out.println("Enter Employee Number");
        String empNum = scan.next();

        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getEmployeeNum().equals(empNum)){
                System.out.println("Select the detail to update");
                System.out.println("1. Full Name");
                System.out.println("2. Title");
                System.out.println("3. Department");
                System.out.println("4. PhoneNumber");
                System.out.println("5. Email Address");
                int userOption = scan.nextInt();

                Employee empUpdate = employees.get(i);
                boolean valid;
                do {
                    valid = true;
                    try {
                        switch (userOption){
                            case 1:
                                System.out.println("Enter Full Name");
                                scan.nextLine();
                                empUpdate.setFullName(scan.nextLine());
                                break;
                            case 2:
                                System.out.println("Enter Title");
                                empUpdate.setTitle(scan.next());
                                break;
                            case  3:
                                System.out.println("Enter department");
                                empUpdate.setDepartment(scan.next());
                                break;
                            case 4:
                                System.out.println("Enter Phone Number");
                                empUpdate.setPhoneNumber(scan.next());
                                break;
                            case 5:
                                System.out.println("Enter Email Address");
                                empUpdate.setEmailAddress(scan.next());
                                break;
                            default:
                                System.out.println("Invalid Option");
                                break;
                        }
                        employees.set(i, empUpdate);
                        return;
                    }
                    catch (InvalidEmployeeDetailException e){
                        System.err.println(e);
                        valid = false;
                    }
                }
                while(!valid);
            }
        }
        System.out.println("Invalid Employee Number");
    }

    public static void searchEmployee(){
        System.out.println("Enter Employee Number");
        String empNum = scan.next();

        for(Employee e : employees){
            if (e.getEmployeeNum().equals(empNum)){
                System.out.println("ID :\t\t\t\t" + e.getID());
                System.out.println("Employee Number :\t" + e.getEmployeeNum());
                System.out.println("Full Name :\t\t\t" + e.getFullName());
                System.out.println("Title :\t\t\t\t" + e.getTitle());
                System.out.println("Department :\t\t" + e.getDepartment());
                System.out.println("Phone Number :\t\t" + e.getPhoneNumber());
                System.out.println("Email Address :\t\t" + e.getEmailAddress());
                return;
            }
        }
        System.err.println("Employee not found");
    }

    public static void displayEmployees(){
        System.out.println("Total Number of Employees : " + employees.size() + "\n");
        for(Employee e : employees){
            System.out.println("ID :\t\t\t\t" + e.getID());
            System.out.println("Employee Number :\t" + e.getEmployeeNum());
            System.out.println("Full Name :\t\t\t" + e.getFullName());
            System.out.println("Title :\t\t\t\t" + e.getTitle());
            System.out.println("Department :\t\t" + e.getDepartment());
            System.out.println("Phone Number :\t\t" + e.getPhoneNumber());
            System.out.println("Email Address :\t\t" + e.getEmailAddress() + "\n");
        }
    }

    public static void deleteEmployee(){
        System.out.println("Enter Employee Number");
        String empNum = scan.next();

        for(Employee e : employees){
            if(e.getEmployeeNum().equals(empNum)){
                employees.remove(e);
                return;
            }
        }

        System.err.println("Employee not found");
    }

    public static void generateFile(){
        File myFile = new File("logicaly.txt");
        try {
            myFile.createNewFile();
            FileWriter myWriter = new FileWriter(myFile);

            myWriter.write("Total Number of Employees : " + employees.size());
            myWriter.append("\n\n");
            for(Employee e : employees){
                myWriter.append("ID :\t\t\t\t" + e.getID());
                myWriter.append("\n");
                myWriter.append("Employee Number :\t" + e.getEmployeeNum());
                myWriter.append("\n");
                myWriter.append("Full Name :\t\t\t" + e.getFullName());
                myWriter.append("\n");
                myWriter.append("Title :\t\t\t\t" + e.getTitle());
                myWriter.append("\n");
                myWriter.append("Department :\t\t" + e.getDepartment());
                myWriter.append("\n");
                myWriter.append("Phone Number :\t\t" + e.getPhoneNumber());
                myWriter.append("\n");
                myWriter.append("Email Address :\t\t" + e.getEmailAddress());
                myWriter.append("\n\n");
            }
            myWriter.close();
            System.out.println("To access employee's record, please refer to the file located here : " + myFile.getAbsolutePath());
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
