//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.util.ArrayList;
import java.util.Objects;

public class Practise {
    //Initialise
    private ArrayList<Consultant> consultantList = new ArrayList<>();

    //Add a consultant to the arrayList
    public void addConsultant(Consultant consultantObject){
        consultantList.add(consultantObject);
    }

    //Show all the consultants in the array
    public void showConsultantList(){
        for (Consultant consultants: consultantList){
            System.out.println(consultants);
        }
    }

    //Show all consultants, their patients and patient's visits
    public void showConsultantPatientsVisits(){
        for (Consultant consultants: consultantList){
            System.out.println("\nConsultant:\n" + consultants.getName() + ",\tID: "
                    + consultants.getId() + ",\tExpertise: " + consultants.getExpertise() +"\nPatients:");

            consultants.showAllPatientsAndVisits();
        }
    }

    //Find a consultant using ID
    public Consultant findConsultant(String id){
        Consultant foundConsultant = null;                      //placeholder consultant object for return
        for (Consultant consultants: consultantList){           //Looping through consultantList
            if (consultants.getId().equals(id.toUpperCase())){
            foundConsultant = consultants;                      //foundConsultant = consultant if consultantID = id
            }
        }
        return foundConsultant;
    }

    //Find a patient using patientID
    public Patient findPatient(String id){
        Patient foundPatient = null;                            //placeholder Patient object for return
        for(Consultant consultant: consultantList){             //Nested for loop iterating through each consultant
            for (Patient patient: consultant.getPatientList()){ //Looping though each consultant's patientList
                if (patient.getId().equals(id)){
                    foundPatient = patient;                     //placeholder = patient if patientID = id
                }
            }
        }
        return foundPatient;
    }

    //Getters&Setter
    public ArrayList<Consultant> getConsultantList() {
        return consultantList;
    }

    public void setConsultantList(ArrayList<Consultant> consultantList) {
        this.consultantList = consultantList;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Practise practise = (Practise) o;
        return Objects.equals(consultantList, practise.consultantList);
    }
}
