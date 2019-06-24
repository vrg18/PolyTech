package edu.vrg18.polytech;

public class GymTeacher implements Teacher {

    private static final String COURSE_NAME = "Физкультура";                // Предмет
    private static final String RESULT_FILE = "Gym";                        // Файл для результатов
    private static final String TEACHER_NAME = "Сидоров Сидор Сидорович";   // Преподаватель математики
    private static final int IQ_NEEDED = 45;                                // Для физкультуры тербуется такое значение IQ
    private double moodFactor;                                              // "настроение" преподавателя

    GymTeacher() {
        moodFactor = Math.random();  // генерируем "настроение" преподавателя
    }

    @Override
    public int getIqNeeded() {
        return IQ_NEEDED;
    }

    @Override
    public Double getMoodFactor() {
        return moodFactor;
    }

    @Override
    public String getCourseName() {
        return COURSE_NAME;
    }

    @Override
    public StringBuilder getResultsFile() {
        return new StringBuilder(RESULT_FILE);
    }

    @Override
    public String getTeacherName() {
        return TEACHER_NAME;
    }
}
