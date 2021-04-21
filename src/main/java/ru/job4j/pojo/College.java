package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();

        student.setDate("03.11.2018");
        student.setFullname("Andrey Samoylychev");
        student.setGroup("trainee");

        System.out.println(student.getFullname() + " "
                + student.getGroup() + " since " + student.getDate());
    }
}
