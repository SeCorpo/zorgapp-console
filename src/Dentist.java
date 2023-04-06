import java.time.LocalDate;
import java.util.Scanner;

public class Dentist extends User {

    private Consult consult;
    private String dentist_Title = "DMD";
    public Dentist(String title, String firstName, String surname, LocalDate birthday) {
        super(title, firstName, surname, birthday);
    }
    @Override
    public char switch_Choice() {
        int choice = bs.nextInt();

        if(choice == 0) return 'a';
        if(choice == 1) return 'b';
        if(choice == 2) return 'c';
        if(choice == 3) return 'd';
        if(choice == 4) return 'e';
        if(choice == 5) return 'f';
        if(choice == 6) return 'g';
        if(choice == 7) return 'h';
        if(choice == 8) return 'j';
        else return 'a';
    }
    @Override
    public void printMenu_withOptions() {
        System.out.format("%S%n", "[0] back");
        System.out.format("%S%n", "[1] select patient");
        System.out.format("%S%n", "[2] view patient");
        System.out.format("%S%n", "[3] edit patient");
        System.out.format("%S%n", "[4] select medication");
        System.out.format("%S%n", "[5] settings");
        System.out.format("%S%n", "[6] add mednote");
        System.out.format("%S%n", "[7] add consult");
        System.out.format("%S%n", "[8] select user");
        System.out.print( "The choice is yours: " );
    }
    //==================================================
//==================================================

    @Override
    public void viewPatientData(Patient currentPatient) {
        currentPatient.patient_View_Name_Number();
        currentPatient.patient_View_Age_Birthday();
        currentPatient.patient_View_MedNotes();
        currentPatient.patient_View_ConsultNotes();
    }
    @Override
    public void editMedicationStDose(Medication medication) {
        medication.medication_Edit_StDose();
    }
    @Override
    public void writeMedicationToPatient(Patient currentPatient, Medication medication) {

        System.out.println("Medication for: " + currentPatient.getFullName() + " (" + currentPatient.calculateAge() + "): ");
        System.out.print(medication.getMedicationName() + " (" + medication.getMedicationStDose() + ") - add a note and/ or new dosis to the prescription: ");

        String newNote;
        LocalDate newNoteDate;

        newNote = scanner.nextLine();
        newNoteDate = LocalDate.now();

        currentPatient.addMedNote(medication,newNote,newNoteDate);
    }
    @Override
    public void writeConsultToPatient(Patient currentPatient, Data data) {
        //get consult from list > select consult > add note + date > write to patient
        System.out.format("%-15s %10s %-12s %s\n", "Specialty", "Category", "Tariff", "Type");
        for(Consult consult : data.getDentist_Consult()) {
            index++;
            System.out.format("%-5d %-15s %10s %-12s %s\n", index, consult.getSpecialty(), consult.getCategory(),
                    consult.getTariff(), consult.getType());
        }
        int consultIndex;
        System.out.print("Please select a consult to continue, enter number: ");
        consultIndex = scanner.nextInt();
        if(consultIndex >= 0 && consultIndex <= data.getDentist_Consult().size()) {
            this.consult = data.getDentist_Consult().get(consultIndex - 1);

            System.out.format("Selected consult: %s (%.2f)\n", consult.getType(), consult.getTariff());
        }
        else {
            System.out.print( "Invalid input. Please enter a valid input: ");
        }
        System.out.println("Consult for: " + currentPatient.getFullName());
        System.out.print("Add a note to the consult: ");

        Scanner note = new Scanner(System.in);
        String newNote;
        LocalDate newNoteDate;

        newNote = note.nextLine();
        newNoteDate = LocalDate.now();

        currentPatient.addConsultNote(consult,newNote,newNoteDate);
    }
}
