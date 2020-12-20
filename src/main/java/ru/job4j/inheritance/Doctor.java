package ru.job4j.inheritance;

public class Doctor extends Profession{
    private Diagnosis diag;

    public Diagnosis analyze(Pacient pacient) {
        return diag;
    }

    public Diagnosis getDiag() {
        return diag;
    }
}
