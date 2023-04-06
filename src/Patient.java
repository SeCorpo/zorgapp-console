import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Patient extends Person {


   private int patientNumber;
   private float weight;
   private float length;
   private ArrayList<MedNotes> medNotesList;
   private ArrayList<ConsultNotes> consultNotesList;
   private ArrayList<StarNotes> starNotesList;



   public Patient(int patientNumber, String firstName, String surname, LocalDate birthday, float weight, float length) {
      super(firstName, surname, birthday);
      this.patientNumber = patientNumber;
      this.weight = weight;
      this.length = length;
      this.medNotesList = new ArrayList<>();
      this.consultNotesList = new ArrayList<>();
      this.starNotesList = new ArrayList<>();
   }
   Scanner scanner = new Scanner(System.in);
   BScanner bs = new BScanner();
//==================================================
//getters===========

   public int getPatientNumber() {
      return patientNumber;
   }
   public float getWeight() {
      return weight;
   }
   public float getLength() {
      return length;
   }
   public ArrayList<MedNotes> getMedNotesList() {
      return medNotesList;
   }
   public ArrayList<ConsultNotes> getConsultNotesList() {return consultNotesList;}
   public ArrayList<StarNotes> getStarNotesList() {return starNotesList;}
   //==================================================
//setters===========
   public void setPatientNumber(int patientNumber) {
      this.patientNumber = patientNumber;
   }

   public void setWeight(float weight) {
      this.weight = weight;
   }

   public void setLength(float length) {
      this.length = length;
   }
   //==================================================
   //====FN_===========================================
   public double calculateBmi() {
      return weight / (length * length);
   }

   public void addMedNote(Medication medication, String note, LocalDate noteDate) {
      medNotesList.add(new MedNotes(medication, note, noteDate));
   }

   public void addConsultNote(Consult consult, String note, LocalDate noteDate) {
      consultNotesList.add(new ConsultNotes(consult, note, noteDate));
   }

   public void addStarNote(double liters, String note, LocalDate noteDate) {
      starNotesList.add(new StarNotes(liters, note, noteDate));
   }

   ////////////////////////////////////////////////////////////////////////////////
   // Display patient data.
   ////////////////////////////////////////////////////////////////////////////////
   public void patient_View_Name_Number() {
      System.out.format("--------------------------------------------------%n");
      System.out.format("%-15S [%d]\n", "P-number: ", getPatientNumber());
      System.out.format("%-15S %s\n", "Patient: ", getFullName());
   }
   public void patient_View_Age_Birthday() {
      System.out.format("%-15S %d [%s]\n", "Age:", calculateAge(),
              getBirthday().format(bs.d_mm_y));
   }
   public void patient_View_Length_Weight_Bmi() {
      System.out.format("%-15S %.2f\n", "BodyMassIndex: ", calculateBmi());
      System.out.format("%-15S %.2f\n", "Length: ", getLength());
      System.out.format("%-15S %.2f\n", "Weight: ", getWeight());
      System.out.format("--------------------------------------------------%n");
   }
   public void patient_View_MedNotes() {
      System.out.format("%-20s %-20s %-12s %S\n", "Medication", "Dosis", "Date", "note");
      if(getMedNotesList().isEmpty()) {
         System.out.print(" Selected patient has never been prescribed medication\n");
      }
      else {
         for(int i = 0; i < getMedNotesList().size(); i++) {
            System.out.format(" %-19s %-20s [%-10s] %s\n",
                    getMedNotesList().get(i).getMedication().getMedicationName(),
                    getMedNotesList().get(i).getMedication().getMedicationStDose(),
                    getMedNotesList().get(i).getNoteDate().format(bs.d_mm_y),
                    getMedNotesList().get(i).getNote());
         }
      }
   }
   public void patient_View_ConsultNotes() {
      System.out.format("--------------------------------------------------%n");
      System.out.format("%-16s %-10s %-12s %s\n", "Specialty", "Category", "Tariff", "Type");
      if(getConsultNotesList().isEmpty()) {
         System.out.print(" Selected patient has never had a consult\n");
      }
      else {
         for(int i = 0; i < getConsultNotesList().size(); i++) {
            System.out.format(" %-15s %-10s %-12.2f %s\n",
                    getConsultNotesList().get(i).getConsult().getSpecialty(),
                    getConsultNotesList().get(i).getConsult().getCategory(),
                    getConsultNotesList().get(i).getConsult().getTariff(),
                    getConsultNotesList().get(i).getConsult().getType());
            System.out.format(" [%-10s] %s\n",
                    getConsultNotesList().get(i).getNoteDate().format(bs.d_mm_y),
                    getConsultNotesList().get(i).getNote());
            System.out.println();
         }
      }
      System.out.format("--------------------------------------------------%n");
   }
   public void patient_View_StarNotes() {
      System.out.format("--------------------------------------------------%n");
      System.out.format("%-14s %-10s %-5s\n", "Date", "Graph", "liter");
      if (getStarNotesList().isEmpty()) {
         System.out.print("Selected patient has no saved lung capacity measurements\n");
      }
      else {
         for(int i = 0; i < getStarNotesList().size(); i++) {
            System.out.format(" [%-11s] %-10s (%-5.2f)\n",
                    getStarNotesList().get(i).getNoteDate().format(bs.y_MMM_d),
                    getStarNotesList().get(i).getNote(),
                    getStarNotesList().get(i).getLiters());
         }
      }
   }
   ////////////////////////////////////////////////////////////////////////////////
   // Edit patient data.
   ////////////////////////////////////////////////////////////////////////////////
   public void patient_Edit_Name() {
      System.out.print("New firstname: ");
      setFirstName(scanner.nextLine());
      System.out.print("New surname: ");
      setSurname(scanner.nextLine());
      System.out.format("Current patients name: %s\n", getFullName());
   }
   public void patient_Edit_Birthday() {
      System.out.print("New birthday (dd-MM-yyyy): ");
      setBirthday(bs.nextDate(getBirthday()));
      System.out.format("Current patients birthday: %s\n", getBirthday().format(bs.d_mm_y));
   }
   public void patient_Edit_Length_Weight() {
      System.out.print("New length (1.80): ");
      setLength(Float.parseFloat(scanner.nextLine()));
      System.out.print("New weight: ");
      setWeight(Float.parseFloat(scanner.nextLine()));
      System.out.format("%s %.2f %s %.1f\n", "Current patients length: ", getLength(), " and weight: ", getWeight());
   }

}