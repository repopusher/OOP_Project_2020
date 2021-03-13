//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.util.Objects;

public class Person {
    //Initialise
    protected Name name;
    protected String id;
    protected String phone;

    //Constructor
    public Person(Name name, String id, String phone){
        this.name = name;
        this.id = id;
        this.phone = phone;
    }

    //toString
    public String toString(){
        return "Name: " + this.name + "\t\tID: " + this.id + "\t\tPhone: " + this.phone;
    }

    //Getters&Setters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(id, person.id) && Objects.equals(phone, person.phone);
    }
}
