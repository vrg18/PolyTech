package edu.vrg18.polytech;

import com.sun.xml.internal.ws.util.StringUtils;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static final int NUMBER_OF_STUDENTS = 10;                               // Генерируем десяток студентов
    private static final String RANDUS_ORG_FIO_API = "https://randus.org/api.php";  // API для генерации ФИО
    private static final String FIO_API_LAST_NAME = "lname";
    private static final String FIO_API_FIRST_NAME = "fname";
    private static final String FIO_API_MIDDLE_NAME = "patronymic";

    public static void main(String[] args) throws IOException {

        ArrayList<Teacher> teacherGroup = new ArrayList<>();
        teacherGroup.add(new MathTeacher());
        teacherGroup.add(new EnglishTeacher());
        teacherGroup.add(new GymTeacher());

        ArrayList<Student> studentGroup = getStudentGroup(NUMBER_OF_STUDENTS);

        DecimalFormat formatForMoodFactor = new DecimalFormat("###.##");
        Date dateNow = new Date();
        SimpleDateFormat formatForHeadLine = new SimpleDateFormat("EEEE в HH:mm");
        SimpleDateFormat formatForFileName = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder endingFileName = new StringBuilder();
        endingFileName
                .append("_")
                .append(formatForFileName.format(dateNow))
                .append(".txt");

        for (Teacher teacher : teacherGroup) {

            Exam exam = new Exam(studentGroup, teacher);
            StringBuilder results = new StringBuilder(teacher.getCourseName())
                    .append(" / ")
                    .append(teacher.getTeacherName())
                    .append(" (настроение - ")
                    .append(formatForMoodFactor.format(teacher.getMoodFactor()))
                    .append("), ")
                    .append(StringUtils.capitalize(formatForHeadLine.format(dateNow)))
                    .append("\n\n")
                    .append(exam.start());

            try (FileOutputStream fos = new FileOutputStream(teacher.getResultsFile().append(endingFileName).toString())) {
                byte[] buffer = results.toString().getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static ArrayList<Student> getStudentGroup(int number) throws IOException {

        ArrayList<Student> studentGroup = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            JSONObject json = JsonReader.readJsonFromUrl(RANDUS_ORG_FIO_API);
            studentGroup.add(new Student(String.join(" ",
                    json.get(FIO_API_LAST_NAME).toString(),
                    json.get(FIO_API_FIRST_NAME).toString(),
                    json.get(FIO_API_MIDDLE_NAME).toString())));
        }
        return studentGroup;
    }
}
