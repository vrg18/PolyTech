package edu.vrg18.polytech;

public class MathTeacher implements Teacher {

    private double moodFactor;  // "настроение" преподавателя

    MathTeacher() {
        moodFactor = Math.random();  // генерируем "настроение" преподавателя
    }

    @Override
    public int getIqNeeded() {
        return 120; // Для математики тербуется такое значение IQ
    }

    @Override
    public Double getMoodFactor() {
        return moodFactor;
    }

    @Override
    public String getCourseName() {
        return "Математика";
    }
}
