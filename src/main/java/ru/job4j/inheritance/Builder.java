package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String knowCADs;

    public Builder(String name,
                   String surname,
                   String education,
                   String birthday,
                   String grade,
                   String knowCADs) {
        super(name, surname, education, birthday, grade);
        this.knowCADs = knowCADs;
    }

    public String getKnowCADs() {
        return knowCADs;
    }
}
