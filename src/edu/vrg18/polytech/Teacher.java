package edu.vrg18.polytech;

public interface Teacher {

    int iqNeeded = 0;
    double moodFactor = Math.random();

    default boolean testStudent(Student student) {

        double luckFactor = Math.random();
        return student.iq > iqNeeded || student.iq / iqNeeded > (1 - moodFactor * luckFactor);
    }
}
