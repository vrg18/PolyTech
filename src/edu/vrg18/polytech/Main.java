package edu.vrg18.polytech;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Teacher> teacherGroup = new ArrayList<>();
        teacherGroup.add(new MathTeacher());
        teacherGroup.add(new EnglishTeacher());

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

        for (Teacher teacher : teacherGroup) {
            System.out.println(teacher.getCourseName() + " (Настроение преподавателя - " + teacher.getMoodFactor() + "):");
            Exam exam = new Exam(studentGroup, teacher);
            exam.start();
        }
    }
}
