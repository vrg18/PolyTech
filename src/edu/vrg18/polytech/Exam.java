package edu.vrg18.polytech;

class Exam {

    private Student[] studentGroup;
    private Teacher teacher;

    Exam(Student[] studentGroup, Teacher teacher) {
        this.studentGroup = studentGroup;
        this.teacher = teacher;
    }

    StringBuilder start() {
        StringBuilder results = new StringBuilder();
        for (Student student : studentGroup) {
            boolean result = teacher.testStudent(student);
            results
                    .append(student.getFullName())
                    .append(" (IQ=")
                    .append(student.iq)
                    .append("): ")
                    .append(result ? "сдал" : "не сдал")
                    .append("\n");
        }
        return results;
    }
}
