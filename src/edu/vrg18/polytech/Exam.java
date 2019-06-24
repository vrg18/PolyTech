package edu.vrg18.polytech;

import java.util.ArrayList;

class Exam {

    private ArrayList<Student> studentGroup;
    private Teacher teacher;

    Exam(ArrayList<Student> studentGroup, Teacher teacher) {
        this.studentGroup = studentGroup;
        this.teacher = teacher;
    }

    StringBuilder start() {

        StringBuilder results = new StringBuilder();

        studentGroup.forEach(p -> results
                        .append(p.getFullName())
                        .append(" (IQ=")
                        .append(p.iq)
                        .append("): ")
                        .append(teacher.testStudent(p) ? "сдал" : "не сдал")
                        .append("\n"));

        return results;
    }
}
