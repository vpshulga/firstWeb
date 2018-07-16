package entities;

import enums.Educations;
import enums.Sex;
import enums.Specialties;

public class Doctor extends MedWorker {
    private int id;
    private Specialties spetialty;
    private int userId;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, int age, Sex sex,
                  Educations education, int experience, Specialties spetialty, int userId) {
        super(firstName, lastName, age, sex, education, experience);
        this.spetialty = spetialty;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + getLastName() + " " + this.getAge() + " "
                + this.getSex() + " " + this.getSpetialty();
    }
}
