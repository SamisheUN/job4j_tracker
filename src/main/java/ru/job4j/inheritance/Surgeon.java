package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean isPediatrician;

    public Surgeon(String name,
                   String surname,
                   String education,
                   String birthday,
                   boolean vaccinated,
                   boolean isPediatrician) {
        super(name, surname, education, birthday, vaccinated);
        this.isPediatrician = isPediatrician;
    }

    public Boolean getIsPediatrician() {
        return isPediatrician;
    }
}
