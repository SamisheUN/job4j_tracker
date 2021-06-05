package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String additEducations;

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   boolean vaccinated,
                   String additEducations) {
        super(name, surname, education, birthday, vaccinated);
        this.additEducations = additEducations;
    }

    public String getadditEducation() {
        return additEducations;
    }
}
