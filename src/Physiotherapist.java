import java.time.LocalDate;
import java.util.Scanner;


public class Physiotherapist extends User {

    private Consult consult;
    private StarNotes starNotes;
    private String physiotherapist_Title = "physio";
    public Physiotherapist(String title, String firstName, String surname, LocalDate birthday) {
        super(title, firstName, surname, birthday);
    }
//==================================================

    @Override
    public void viewPatientData(Patient currentPatient) {
        currentPatient.patient_View_Name_Number();
        currentPatient.patient_View_Age_Birthday();
        currentPatient.patient_View_Length_Weight_Bmi();
        currentPatient.patient_View_MedNotes();
        currentPatient.patient_View_StarNotes();
        currentPatient.patient_View_ConsultNotes();
    }
    @Override
    public void writeConsultToPatient(Patient currentPatient, Data data) {
        //get consult from list > select consult > add note + date > write to patient
        System.out.format("%-15s %10s %-12s %s\n", "Specialty", "Category", "Tariff", "Type");
        for(Consult consult : data.getPhysio_Consult()) {
            index++;
            System.out.format("%-5d %-15s %10s %-12s %s\n", index, consult.getSpecialty(), consult.getCategory(),
                    consult.getTariff(), consult.getType());
        }
        int consultIndex;
        System.out.print("Please select a consult to continue, enter number: ");
        consultIndex = scanner.nextInt();
        if(consultIndex >= 0 && consultIndex <= data.getPhysio_Consult().size()) {
            this.consult = data.getPhysio_Consult().get(consultIndex - 1);

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

    @Override
    public void writeStarNotes(Patient currentPatient) {
        System.out.print("Measured lung capacity in liters (0.0): ");
        Scanner scan = new Scanner(System.in);

        LocalDate newNoteDate = LocalDate.now();
        double liters = scan.nextDouble();

            int stars = (int) liters;
            String star = "*";
            String newNote = star.repeat(stars);

        currentPatient.addStarNote(liters, newNote, newNoteDate);



    }
}