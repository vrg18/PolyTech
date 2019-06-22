package edu.vrg18.polytech;

import java.io.FileOutputStream;
import java.io.IOException;
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

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String endingFileName = "_" + formatForDateNow.format(dateNow) + ".txt";

        for (Teacher teacher : teacherGroup) {

            StringBuilder results = new StringBuilder(teacher.getCourseName() + " (Настроение преподавателя - " + teacher.getMoodFactor() + "): \n\n");
            Exam exam = new Exam(studentGroup, teacher);
            results.append(exam.start());

            try (FileOutputStream fos = new FileOutputStream(teacher.getResultsFile() + endingFileName)) {
                byte[] buffer = results.toString().getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
