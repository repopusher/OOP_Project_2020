//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //---------------------------------------------------------TEST CODE-------------------------------------------------------

        //Creating practise class
        Practise practise1 = new Practise();

        //Names for consultants and patients
        Name name1 = new Name("Albert", "Hofmann");
        Name name2 = new Name("Alexander", "Shulgin");
        Name name3 = new Name("Hamilton", "Morris");
        Name name4 = new Name("Terry", "Davis");
        Name name5 = new Name("Tobias","Lennon");
        Name name6 = new Name("David", "Nichols");
        Name name7 = new Name("Dmitri", "Mendeleev");
        Name name8 = new Name("Linus", "Pauling");
        Name name9 = new Name("Con", "Joyce");
        Name name10 = new Name("John", "Smith");

        //Creating 4 consultants
        Consultant consultant1 = new Consultant(name1, "C1", "0877371553", "Otolaryngology");
        Consultant consultant2 = new Consultant(name2, "C2", "0291034181", "Cardiology");
        Consultant consultant3 = new Consultant(name3, "C3", "0834456983", "Surgeon");
        Consultant consultant4 = new Consultant(name4, "C4", "0071334998", "Cardiology");

        //Creating patients
        Patient patient1 = new Patient(name5,"P0", "0851034181", "Fracture", Patient.Severity.ONE);
        Patient patient2 = new Patient(name6,"P1", "0866261553", "Covid-19", Patient.Severity.ONE);
        Patient patient3 = new Patient(name7,"P2", "0051034181", "Covid-19", Patient.Severity.FIVE);
        Patient patient4 = new Patient(name8,"P3", "0856674883", "Covid-19", Patient.Severity.THREE);
        Patient patient5 = new Patient(name9,"P4", "180077564", "CAD", Patient.Severity.TWO);
        Patient patient6 = new Patient(name10,"P5", "029884775", "Leukemia", Patient.Severity.FOUR);

        //Creating dates
        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2020, 2, 10);
        LocalDate date3 = LocalDate.of(2020, 3, 16);
        LocalDate date4 = LocalDate.of(2020, 4, 2);
        LocalDate date5 = LocalDate.of(2020, 5, 11);
        LocalDate date6 = LocalDate.of(2020, 6, 21);
        LocalDate date7 = LocalDate.of(2020, 7, 13);

        //Creating visits
        Visit visit1 = new Visit(date1, "Patient prone to addiction");
        Visit visit2 = new Visit(date2, "Increase medication");
        Visit visit3 = new Visit(date3, "Recovering");
        Visit visit4 = new Visit(date4, "Medication dependency developed");
        Visit visit5 = new Visit(date5, "Not responding to medication");
        Visit visit6 = new Visit(date5, "Allergic to penicillin");
        Visit visit7 = new Visit(date6, "Nothing to note");
        Visit visit8 = new Visit(date7, "Recovering");

        //Adding visits to patients
        patient1.addVisit(visit1);
        patient2.addVisit(visit2);
        patient2.addVisit(visit3);
        patient3.addVisit(visit4);
        patient3.addVisit(visit5);
        patient4.addVisit(visit6);
        patient5.addVisit(visit7);
        patient6.addVisit(visit8);

        //Adding patients to consultants
        consultant2.addPatient(patient1);
        consultant3.addPatient(patient2);
        consultant3.addPatient(patient3);
        consultant4.addPatient(patient4);
        consultant4.addPatient(patient5);
        consultant4.addPatient(patient6);

        //Adding consultants to practise
        practise1.addConsultant(consultant1);
        practise1.addConsultant(consultant2);
        practise1.addConsultant(consultant3);
        practise1.addConsultant(consultant4);

        //Displaying all consultants, their list of patients and those patient's visits
        practise1.showConsultantPatientsVisits();

        //--------------------------------------------------APPLICATION CODE-------------------------------------------------------------

        //Initialising
        Scanner keyboard = new Scanner(System.in);
        String patientID, visitNote, consultantID;
        int option = 0, year, month, day;
        Consultant consultantPlaceholder = null;
        Visit visitPlaceholder;
        Patient patientPlaceholder = null;
        Name namePlaceholder;
        LocalDate datePlaceholder;
        FileReader fileReader;
        BufferedReader inputFile;
        Patient.Severity severityPlaceholder = Patient.Severity.ONE;

        System.out.println("\n\n\t\tHOSPITAL CONSULTANCY APPLICATION");
        try{
            while (option < 5){
                System.out.println("""
    
                        1. Record a Patient visit.
                        2. Display all patients of a particular Consultant.
                        3. Display all Consultants followed by their Patients followed by their visits.
                        4. Load information from a text file.
                        5. Quit.""");
                option = keyboard.nextInt();

                switch (option) {
                    case 1 -> {
                        try {
                            System.out.println("Patient ID >\n");
                            patientID = keyboard.next();
                            patientID = patientID.toUpperCase();   //Changing user input to uppercase so that data is uniform
                            System.out.println("Enter the date of visit\nYear > ");
                            year = keyboard.nextInt();
                            System.out.println("Month > ");
                            month = keyboard.nextInt();
                            System.out.println("Day > ");
                            day = keyboard.nextInt();
                            System.out.println("Visit notes >");
                            keyboard.nextLine();
                            visitNote = keyboard.nextLine();        //Using nextLine to include space in String

                            datePlaceholder = LocalDate.of(year, month, day);        //Initialising LocalDate
                            visitPlaceholder = new Visit(datePlaceholder, visitNote);//Initialising Visit to use for patient

                            patientPlaceholder = practise1.findPatient(patientID);   //findPatient() will return a patient into patientPlaceholder

                            patientPlaceholder.addVisit(visitPlaceholder);          //Adding visit for patient
                            System.out.println("Visit added for " + patientPlaceholder.getName());

                        }catch (DateTimeException e){
                            System.out.println(e.getMessage());
                        }
                        catch (NullPointerException e){
                            System.out.println("Patient does not exist");
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.println("Consultant ID > ");
                            consultantID = keyboard.next();

                            consultantPlaceholder = practise1.findConsultant(consultantID);
                            System.out.println("\nPatients for " + consultantPlaceholder.getName() + " are: \n");
                            consultantPlaceholder.showAllPatients();
                        }
                        catch(NullPointerException e){
                            System.out.println("Consultant does not exist");
                        }
                    }
                    case 3 -> practise1.showConsultantPatientsVisits();            //Calling method to show all consultants, their patients and those patient's visits

                    case 4 -> {
                        try {
                            fileReader = new FileReader("C:\\Users\\tobia\\IdeaProjects\\lab01\\src\\OOP_Project_2020\\newFile.txt");   //Absolute path of text file.
                            inputFile = new BufferedReader(fileReader);
                            String lineOfText = inputFile.readLine();

                            while(lineOfText != null){                             //looping each line of the file
                                String[] words = lineOfText.split(",");      //Putting each word from one line in the file into an array

                                switch (words[0].toLowerCase()){
                                    case "consultant" -> {
                                        namePlaceholder = new Name(words[2], words[1]);         //Getting name data from word array
                                        consultantPlaceholder = new Consultant(namePlaceholder, words[3], words[4], words[5]);  //Initialising Consultant with data word array
                                        practise1.addConsultant(consultantPlaceholder);         //Consultant is added to practise
                                    }
                                    case "patient" -> {
                                        namePlaceholder = new Name(words[2], words[1]);         //Puts the patient names in the file into a Name object.
                                        switch (words[6]) {         //Checking the number in the file and initialising a Severity object accordingly
                                            case "1":
                                                break;
                                            case "2":
                                                severityPlaceholder = Patient.Severity.TWO;
                                                break;
                                            case "3":
                                                severityPlaceholder = Patient.Severity.THREE;
                                                break;
                                            case "4":
                                                severityPlaceholder = Patient.Severity.FOUR;
                                                break;
                                            case "5":
                                                severityPlaceholder = Patient.Severity.FIVE;
                                        }
                                        patientPlaceholder = new Patient(namePlaceholder, words[3], words[4], words[5], severityPlaceholder);   //Initialising Patient with data from word array
                                        consultantPlaceholder.addPatient(patientPlaceholder);       //Patient is added to most recent consultant
                                    }
                                    case "visit" -> {
                                        String[] dates = words[1].split("/");       //Splitting date separated by '/' into array and assigning to variables for date
                                        day = Integer.parseInt(dates[0]);
                                        month = Integer.parseInt(dates[1]);
                                        year = Integer.parseInt(dates[2]);
                                        datePlaceholder = LocalDate.of(year, month, day);
                                        visitPlaceholder = new Visit(datePlaceholder, words[2]);
                                        patientPlaceholder.addVisit(visitPlaceholder);              //Visit added to most recent patient read
                                    }
                                }
                                lineOfText = inputFile.readLine();
                            }

                            inputFile.close();
                            System.out.println("Loaded data from text file.");

                        }catch (IOException | NullPointerException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Input mismatch error " + e.getMessage());
        }
    }
}
