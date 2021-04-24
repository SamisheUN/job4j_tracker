package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String grade;

    public Engineer(String name,
                    String surname,
                    String education,
                    String birthday,
                    String grade) {
        super(name, surname, education, birthday);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
