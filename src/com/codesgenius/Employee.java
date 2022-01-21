package com.codesgenius;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Employee {
    private int ID;
    private String employeeNum;
    private String fullName;
    private String Title;
    private String Department;
    private String phoneNumber;
    private String emailAddress;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) throws InvalidEmployeeDetailException {
        if(Pattern.matches("E01[0-9]{2}", employeeNum)) {
            this.employeeNum = employeeNum;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Number");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidEmployeeDetailException {
        if(Pattern.matches("[a-zA-z]{3,10}\\s[a-zA-z]{3,10}", fullName)) {
            this.fullName = fullName;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Full Name");
        }
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) throws InvalidEmployeeDetailException {
        if(Arrays.asList(new String[]{"Director", "Manager", "Assistant", "Supervisor", "Trainee"}).contains(title)) {
            this.Title = title;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Title");
        }
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) throws InvalidEmployeeDetailException {
        if(Arrays.asList(new String[]{"IT", "Sales", "R&D", "Prod", "HR"}).contains(department)) {
            Department = department;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Department");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidEmployeeDetailException {
        if(Pattern.matches("[0][6,7][5,6,7,9,0][0-9]{7}", phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Phone Number");
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws InvalidEmployeeDetailException {
        if(Pattern.matches("[a-zA-Z]{1,2}[.][a-zA-Z]{3,10}@logicaly.net", emailAddress)) {
            this.emailAddress = emailAddress;
        }
        else {
            throw new InvalidEmployeeDetailException("Invalid Employee Email Address");
        }
    }
}
