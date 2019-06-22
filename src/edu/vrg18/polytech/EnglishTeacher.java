package edu.vrg18.polytech;

public class EnglishTeacher implements Teacher {

    private static final String COURSE_NAME = "Английский";             // Предмет
    private static final String RESULT_FILE = "English";                // Файл для результатов
    private static final String TEACHER_NAME = "Петров Петр Петрович";  // Преподаватель английского
    private static final int IQ_NEEDED = 80;                            // Для английского тербуется такое значение IQ
    private double moodFactor;                                          // "настроение" преподавателя

    EnglishTeacher() {
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
    public String getResultsFile() {
        return RESULT_FILE;
    }

    @Override
    public String getTeacherName() {
        return TEACHER_NAME;
    }
}
