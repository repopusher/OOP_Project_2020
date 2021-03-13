//Tobias Lennon
//R00191512
//SDH2B
package OOP_Project_2020;

import java.time.LocalDate;
import java.util.Objects;

public class Visit {
    //Initialise
    private LocalDate visitDate;
    private String notes;

    //Constructor
    public Visit(LocalDate visitDate, String notes){
        this.visitDate = visitDate;
        this.notes = notes;
    }

    //toString
    public String toString(){
        return "Visit date: " + this.visitDate + "\t\tNotes: " + notes;
    }

    //Getters&Setters
    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(visitDate, visit.visitDate) && Objects.equals(notes, visit.notes);
    }
}
