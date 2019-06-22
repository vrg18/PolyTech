package edu.vrg18.polytech;

public class GymTeacher implements Teacher {

    private double moodFactor;  // "настроение" преподавателя

    GymTeacher() {
        moodFactor = Math.random();  // генерируем "настроение" преподавателя
    }

    @Override
    public int getIqNeeded() {
        return 45; // Для физкультуры тербуется такое значение IQ
    }

    @Override
    public Double getMoodFactor() {
        return moodFactor;
    }

    @Override
    public String getCourseName() {
        return "Физкультура";
    }

    @Override
    public String getResultsFile() {
        return "Gym";
    }
}
