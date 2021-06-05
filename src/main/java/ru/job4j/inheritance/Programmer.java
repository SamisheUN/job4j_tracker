package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String mainLanguage;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      String grade,
                      String mainLanguage) {
        super(name, surname, education, birthday, grade);
        this.mainLanguage = mainLanguage;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }
}
