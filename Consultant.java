//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.util.ArrayList;
import java.util.Objects;

public class Consultant extends Person{
    //Initialise
    private ArrayList<Patient> patientList = new ArrayList<>();
    private String expertise;

    //Constructor
    public Consultant(Name name, String id, String phone, String expertise){
        super(name, id, phone);
        this.expertise = expertise;
    }

    public void showAllPatientsAndVisits(){
        if(!patientList.isEmpty()){
            for (Patient patient: patientList){
                System.out.println("\n" + patient);
                patient.showAllVisit();
            }
        }else {
            System.out.println("Consultant has no patients");
        }
    }

    //Empowered for loop iterating through patientList.
    public void showAllPatients(){
        if(!patientList.isEmpty()){
            for (Patient patient: patientList){
                System.out.println(patient);
            }
        }else {
            System.out.println("Consultant has no patients");
        }
    }

    //Takes a patient objects and adds to list
    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    //toString
    public String toString(){
        return super.toString() + " " + this.expertise;
    }

    //Setters&Getters
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Consultant that = (Consultant) o;
        return Objects.equals(patientList, that.patientList) && Objects.equals(expertise, that.expertise);
    }
}
