package edu.vrg18.polytech;

class Student {

    private String lastName;
    private String firstName;
    private String middleName;
    int iq;

    Student(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        iq = (int) (Math.random() * 200);
    }

    String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }
}
