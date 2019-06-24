package edu.vrg18.polytech;

public interface Teacher {


    default boolean testStudent(Student student) {

        double luckFactor = Math.random();
        return student.iq > getIqNeeded() || (double)(student.iq / getIqNeeded()) > (1 - getMoodFactor() * luckFactor);
    }

    int getIqNeeded();

    Double getMoodFactor();

    String getCourseName();

    StringBuilder getResultsFile();

    String getTeacherName();
}
