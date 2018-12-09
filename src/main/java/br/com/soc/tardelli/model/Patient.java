package br.com.soc.tardelli.model;

public class Patient {
    private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;

    public Patient(Integer id, String firstName, String lastName, String age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
