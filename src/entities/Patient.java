package entities;

import enums.Sex;

public class Patient extends Person {
    private int id;
    private String city;
    private String street;
    private int house;
    private int apartment;
    private String complaint;

    public Patient() {

    }

    public Patient(String firstName, String secondName, int age, Sex sex,
                   String cyty, String street, int house, int apartment, String complaint) {
        super(firstName, secondName, age, sex);
        this.city = cyty;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + getLastName() + " " + this.getAge() + " "
                + this.getSex() + " " + this.getCity() + " " + this.getStreet() + " "
                + this.getHouse() + " " + this.getApartment() + "(" + this.getComplaint() + ")";
    }
}
