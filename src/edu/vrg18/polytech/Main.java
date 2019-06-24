package edu.vrg18.polytech;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ArrayList<Teacher> teacherGroup = new ArrayList<>();
        teacherGroup.add(new MathTeacher());
        teacherGroup.add(new EnglishTeacher());
        teacherGroup.add(new GymTeacher());

        String[] fIOs = {
                "Новиков Адриан Георгиевич",
                "Устинов Нинель Яковлевич",
                "Дьячков Юрий Васильевич",
                "Мельников Ким Семенович",
                "Журавлёв Василий Лукьевич",
                "Рыбаков Макар Константинович",
                "Елисеев Владлен Геннадиевич",
                "Белоусов Агафон Ильяович",
                "Панов Герасим Альвианович",
                "Ефимов Кирилл Геннадьевич"
        };

        Student[] studentGroup = new Student[fIOs.length];
        for (int i = 0; i < fIOs.length; i++) {
            String[] fIO = fIOs[i].split(" +");
            studentGroup[i] = new Student(fIO[0], fIO[1], fIO[2]);
        }

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
                    .append(formatForHeadLine.format(dateNow))
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
}
