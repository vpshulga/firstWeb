package entities;

import enums.Educations;
import enums.Sex;

public class RegistryWorker extends MedWorker {
    private int id;

    public RegistryWorker() {
    }

    public RegistryWorker(String firstName, String secondName, int age, Sex sex,
                          Educations education, int experience, int id) {
        super(firstName, secondName, age, sex, education, experience);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
