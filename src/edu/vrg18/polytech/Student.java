package edu.vrg18.polytech;

class Student {

    private String lastName;
    private String firstName;
    private String middleName;
    int iq;

    Student(String fullName) {
        String[] fIO = fullName.split(" +");
        this.lastName = fIO[0];
        this.firstName = fIO[1];
        this.middleName = fIO[2];
        iq = (int) (Math.random() * 200);
    }

    String getFullName() {
        return String.join(" ", lastName, firstName, middleName);
    }
}
