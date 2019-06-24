package edu.vrg18.polytech;

public class MathTeacher implements Teacher {

    private static final String COURSE_NAME = "Математика";             // Предмет
    private static final String RESULT_FILE = "Mathematics";            // Файл для результатов
    private static final String TEACHER_NAME = "Иванов Иван Иваныч";    // Преподаватель математики
    private static final int IQ_NEEDED = 120;                           // Для математики тербуется такое значение IQ
    private double moodFactor;                                          // "настроение" преподавателя

    MathTeacher() {
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
