package edu.vrg18.polytech;

class Exam {

    private Student[] studentGroup;
    private Teacher teacher;

    Exam(Student[] studentList, Teacher teacher) {
        this.studentGroup = studentList;
        this.teacher = teacher;
    }

    void start() {
        for (Student student : studentGroup) {
            boolean result = teacher.testStudent(student);
            System.out.println(student.getFullName() + " (IQ=" + student.iq + "): " + (result ? "сдал" : "не сдал"));
        }
    }
}
