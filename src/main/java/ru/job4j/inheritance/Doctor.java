package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean vaccinated;

    public Doctor(String name,
                  String surname,
                  String education,
                  String birthday,
                  boolean vaccinated) {
        super(name, surname, education, birthday);
        this.vaccinated = vaccinated;
    }

    public boolean getVaccinated() {
        return vaccinated;
    }
}
