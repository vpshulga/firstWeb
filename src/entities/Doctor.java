package entities;

import enums.Educations;
import enums.Sex;
import enums.Specialties;

public class Doctor extends MedWorker {
    private int id;
    private Specialties spetialty;

    public Doctor() {
    }

    public Doctor(String firstName, String secondName, int age, Sex sex,
                  Educations education, int experience, Specialties spetialty) {
        super(firstName, secondName, age, sex, education, experience);
        this.spetialty = spetialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialties getSpetialty() {
        return spetialty;
    }

    public void setSpetialty(Specialties spetialty) {
        this.spetialty = spetialty;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + getLastName() + " " + this.getAge() + " "
                + this.getSex() + " " + this.getSpetialty();
    }
}
