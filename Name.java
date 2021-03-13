//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.util.Objects;

public class Name {
    //Initialise
    private String firstName;
    private String lastName;

    //Constructor
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //toString
    public String toString(){
        return this.firstName + " " + this.lastName;
    }


    //Getters&Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }
}
