package edu.vrg18.polytech;

public class EnglishTeacher implements Teacher {

    private double moodFactor;  // "настроение" преподавателя

    EnglishTeacher() {
        moodFactor = Math.random();  // генерируем "настроение" преподавателя
    }

    @Override
    public int getIqNeeded() {
        return 80; // Для английского тербуется такое значение IQ
    }

    @Override
    public Double getMoodFactor() {
        return moodFactor;
    }

    @Override
    public String getCourseName() {
        return "Английский";
    }

    @Override
    public String getResultsFile() {
        return "English";
    }
}
