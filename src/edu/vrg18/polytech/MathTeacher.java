package edu.vrg18.polytech;

public class MathTeacher implements Teacher {

    int iqNeeded = 120;

    @Override
    public boolean testStudent(Student student) {
        return false;
    }
}
