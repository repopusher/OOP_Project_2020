//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.util.ArrayList;
import java.util.Objects;

public class Patient extends Person{
    //Initialise
    private ArrayList<Visit> visitList = new ArrayList<>();
    private String illness;
    public enum Severity{           //Creating CONSTANT objects of class Severity
        ONE, TWO, THREE, FOUR, FIVE
    }
    Severity severity;   //Initialising

    //Constructor
    public Patient(Name name, String id, String phone, String illness, Severity severity){
        super(name, id, phone);
        this.illness = illness;
        this.severity = severity;

        }

    //toString
    public String toString(){
        String placeholder = "";
        switch (severity){          //Empowered switch statement that changes the different Severity constants into number strings.
            case ONE -> placeholder = "1";
            case TWO -> placeholder = "2";
            case THREE -> placeholder = "3";
            case FOUR -> placeholder = "4";
            case FIVE -> placeholder = "5";
        }
        return super.toString() + "\t\tIllness: " + this.illness + "\t\tSeverity: " + placeholder;
    }

    public void addVisit(Visit visitor){    //Adds visitor to arrayList
        this.visitList.add(visitor);
    }

    public void showAllVisit(){             //Loops through visit list and prints
        if(!visitList.isEmpty()){
            for (Visit visitors: visitList){
                System.out.println(visitors);
            }

        }else {
            System.out.println("Patient has no visits");
        }
    }

    //Getters&Setters
    public ArrayList<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(ArrayList<Visit> visitList) {
        this.visitList = visitList;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return this.getName() == patient.getName() && this.getId() == patient.getId() && this.getPhone() == patient.getPhone() &&
                Objects.equals(visitList, patient.visitList) && Objects.equals(illness, patient.illness) && severity == patient.severity;
    }
}



