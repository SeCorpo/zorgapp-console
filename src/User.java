import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;

class User extends Person {

   public static final int BACK = 0;
   private String title;
   public int index = 0;

   public User(String title, String firstName, String surname, LocalDate birthday) {
      super(firstName, surname, birthday);
      this.title = title;
   }

   //==================================================
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }

   Scanner scanner = new Scanner(System.in);
   BScanner bs = new BScanner();

   //static final ints==================================

   //printmenu()=======================================
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
      if(choice == 8) return 'i';
      if(choice == 9) return 'j';
      else return 'z';
   }
   public void printMenu_withOptions() {
      System.out.format("%S%n", "[0] back");
      System.out.format("%S%n", "[1] select patient");
      System.out.format("%S%n", "[2] view patient");
      System.out.format("%S%n", "[3] edit patient");
      System.out.format("%S%n", "[4] select medication");
      System.out.format("%S%n", "[5] settings");
      System.out.format("%S%n", "[6] add mednote");
      System.out.format("%S%n", "[7] add consult");
      System.out.format("%S%n", "[8] add lung-capacity");
      System.out.format("%S%n", "[9] select user");
      System.out.print( "The choice is yours: " );
   }

   public void viewPatientData(Patient currentPatient) {
      currentPatient.patient_View_Name_Number();
      currentPatient.patient_View_Age_Birthday();
      currentPatient.patient_View_ConsultNotes();
   }

   public void menu_Edit(Patient currentPatient) {
      System.out.println("==================================================");
      System.out.format("%S%n", "[0] back");
      System.out.format("%S%n", "[1] edit patient name");
      System.out.format("%S%n", "[2] edit patient birthday");
      System.out.format("%S%n", "[3] edit all");

         int choice = bs.nextInt();

         switch (choice) {
            case BACK -> {
               return;
            }
            case 1 -> {
               currentPatient.patient_Edit_Name();
               menu_Edit(currentPatient);
            }
            case 2 -> {
               currentPatient.patient_Edit_Birthday();
               menu_Edit(currentPatient);
            }
            case 3 -> {
               currentPatient.patient_Edit_Name();
               currentPatient.patient_Edit_Birthday();
            }
            default -> System.out.println("Invalid input. Please enter a valid input: ");
         }
   }

   @Override
   public String getFullName() {
      return String.format("%s %s %s", title, getFirstName(), getSurname());
   }

   public void editMedicationStDose(Medication medication) {
      System.out.println("Current user cannot change the standard dosis of medication");
   }

   public void writeMedicationToPatient(Patient currentPatient, Medication medication) {
      System.out.println("Current user cannot add MedNote to patient");
   }

   public void writeConsultToPatient(Patient currentPatient, Data data) {
      System.out.println("Current user cannot write consult to patient");
   }

   public void writeStarNotes(Patient currentPatient) {
      System.out.println("Current user cannot write lung-notes");
      //ask how to call
   }

   public void menu_Settings(Medication medication, Data data) {
      System.out.println("==================================================");
      System.out.format("%S%n", "[0] back");
      System.out.format("%S%n", "[1] edit medication standard dosis");
      System.out.format("%S%n", "[2] set sorting patients");
      System.out.format("%S%n", "[3] edit current user");

         int choice = bs.nextInt();

         switch (choice) {
            case BACK -> {
               return;
            }
            case 1 -> editMedicationStDose(medication);

            case 2 -> menu_Sort_Patient(data);

            case 3 -> edit_Current_User();
         }
      }

   public Data menu_Sort_Patient(Data data) {
      System.out.println("==================================================");
      System.out.format("%S%n", "[0] back");
      System.out.format("%S%n", "[1] sort by surname ascending (a > z)");
      System.out.format("%S%n", "[2] sort by surname descending (z > a)");
      System.out.format("%S%n", "[3] sort by birth year ascending (> higher)");
      System.out.format("%S%n", "[4] sort by birth year descending (> lower)");

      int set = bs.nextInt();

      if(set == BACK) {
         System.out.println("==================================================");
         System.out.format("%S%n", "[0] back");
         System.out.format("%S%n", "[1] edit medication standard dosis");
         System.out.format("%S%n", "[2] set sorting patients");
         System.out.format("%S%n", "[3] edit current user");
         return data;
      }
      if(set == 1) {
         Comparator<Patient> surname_az = Comparator.comparing(Patient::getSurname);
         data.getPatientList().sort(surname_az);
         System.out.println("Next time selecting a patient the list wil be sorted by surname ascending");
         return data;
      }
      if(set == 2) {
         Comparator<Patient> surname_za = Comparator.comparing(Patient::getSurname).reversed();
         data.getPatientList().sort(surname_za);
         System.out.println("Next time selecting a patient the list wil be sorted by surname descending");
         return data;
      }
      if(set == 3) {
         Comparator<Patient> year_lowToHigh = Comparator.comparing(Patient::getBirthday);
         data.getPatientList().sort(year_lowToHigh);
         System.out.println("Next time selecting a patient the list wil be sorted by birth year ascending");
         return data;
      }
      if(set == 4) {
         Comparator<Patient> year_HighToLow = Comparator.comparing(Patient::getBirthday).reversed();
         data.getPatientList().sort(year_HighToLow);
         System.out.println("Next time selecting a patient the list wil be sorted by birth year descending");
         return data;
      }
      else {
         System.out.print("Invalid input. Please enter a valid input: ");
      }
      return data;
   }
   public void edit_Current_User() {
      System.out.println("==================================================");
      System.out.format("%S%n", "[0] back");
      System.out.format("%S%n", "[1] change firstname");
      System.out.format("%S%n", "[2] change surname");
      System.out.format("%S%n", "[3] change birthday");
      System.out.format("%S%n", "[4] change title");
      int choice = bs.nextInt();

      if(choice == BACK) {
         return;
      }

      if(choice == 1) {
         System.out.print("Change firstname: ");
         String newFirstname = scanner.nextLine();
         setFirstName(newFirstname);
         System.out.println("Current user: " + getFullName() + " ("+ getBirthday().format(bs.d_mm_y) + ")");
         edit_Current_User();
      }
      if(choice == 2) {
         System.out.print("Change surname: ");
         String newSurname = scanner.nextLine();
         setSurname(newSurname);
         System.out.println("Current user: " + getFullName() + " ("+ getBirthday().format(bs.d_mm_y) + ")");
         edit_Current_User();
      }
      if(choice == 3) {
         System.out.print("Change birthday (dd-MM-yyyy): ");
         setBirthday(bs.nextDate(getBirthday()));
         System.out.println("Current user: " + getFullName() + " ("+ getBirthday().format(bs.d_mm_y) + ")");
         edit_Current_User();

      }
      if(choice == 4) {
         System.out.print("Change title: ");
         String newTitle = scanner.nextLine();
         setTitle(newTitle);
         System.out.println("Current user: " + getFullName() + " ("+ getBirthday().format(bs.d_mm_y) + ")");
         edit_Current_User();
      }
   }

}