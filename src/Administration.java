import java.time.LocalDate;


class Administration {


   public static final char BACK = 'a';
   public static final char SELECT_PATIENT = 'b';
   public static final char VIEW_PATIENT = 'c';
   public static final char EDIT_PATIENT = 'd';
   public static final char SELECT_MEDICATION = 'e';
   public static final char SETTINGS = 'f';
   public static final char ADD_MEDNOTE = 'g';
   public static final char ADD_CONSULT = 'h';
   public static final char ADD_STARNOTE = 'i';
   public static final char SELECT_USER = 'j';

   public static final char ADD_PATIENT = 'k';
   public static final char DELETE_PATIENT = 'l';
   public static final char ADD_USER = 'm';
   public static final char DELETE_USER = 'n';
   public static final char ADD_MEDICATION = 'o';
   public static final char DELETE_MEDICATION = 'p';
   public static final char EDIT_PATIENTNUMBER = 'q';
   public static final char DELETE_MEDNOTE = 'r';
   public static final char CASE_DEFAULT = 'z';

   Patient currentPatient;            // The currently selected patient
   User    currentUser;               // the current user of the program.
   Medication medication;
   Data data = new Data();
   BScanner bs = new BScanner();

   /////////////////////////////////////////////////////////////////
   // Constructor
   /////////////////////////////////////////////////////////////////
   Administration( User user )
   {
      currentUser    = user;
      currentPatient = new Patient(0, "Patient", "Zero", LocalDate.of( 2000, 2, 29 ), 60f, 1.70f);

      System.out.format( "Current user:  %s\n", currentUser.getFullName() );
   }

   public void user_Selector() {
      String selectUserName;
      System.out.format("%-10s %-15s %-15s\n", "Title:", "First name:", "Surname:");
      for(User user : data.getUserMap().values()) {
         System.out.format(" %-9s %-15s %-15s\n", user.getTitle(), user.getFirstName(), user.getSurname());
      }
      System.out.print("Please select an user to continue, enter firstname: ");
      selectUserName = bs.nextLine();
      for(User user : data.getUserMap().values()) {
         if (user.getFirstName().equals(selectUserName)) {
            this.currentUser = user;
         }
      }
      System.out.println("Selected user: " + currentUser.getFullName());
   }

   public void patient_Selector() {
      System.out.println("==================================================");

      int selectPatientNumber;
      System.out.format("%-4s %-20s %-20s %-15s\n", "#", "First name:", "Surname:", "Born:");

      for (Patient patient : data.getPatientList()) {
         System.out.format(" %-3d %-20s %-20s [%10s]\n", patient.getPatientNumber(), patient.getFirstName(),
                 patient.getSurname(), patient.getBirthday().format(bs.d_mm_y));
      }
      System.out.print("Please select a patient to continue, enter patientnumber: ");
      selectPatientNumber = bs.nextInt();
      for (Patient patient : data.getPatientList()) {
         if (patient.getPatientNumber() == selectPatientNumber) {
            this.currentPatient = patient;
            System.out.println("Selected patient: " + currentPatient.getFullName());
            break;
         }
      }
   }


   public void medication_Selector() {
      System.out.println("==================================================");
      int index = 0;
      int medicationIndex;

      System.out.format("%-4s %-15s %-15s %-15s\n", "#", "Medication:", "Type:", "Standard Dosis:");

      for(Medication medication : data.getMedicationList()) {
         index++;
         System.out.format(" %-3d %-12b %-15s %-15s %-15s\n", index, medication.getRestricted(),
                 medication.getMedicationName(), medication.getMedicationType(), medication.getMedicationStDose());
      }
      System.out.print("Please select a medication to continue, enter number: ");
      medicationIndex = bs.nextInt();
      if(medicationIndex >= 0 && medicationIndex <= data.getMedicationList().size()) {
         this.medication = data.getMedicationList().get(medicationIndex - 1);

         System.out.println("Selected medication: " + medication.getMedicationName());
      }
      else {
         System.out.print( "Invalid input. Please enter a valid input: " );
         medication_Selector();
      }
   }
   /////////////////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////
   void menu() {

      boolean nextCycle = true;
      while (nextCycle)
      {
         currentUser.printMenu_withOptions();

         switch (currentUser.switch_Choice()) {
            case BACK:
               System.out.format("==================================================%n");
               System.out.format("|| Java Zorgapp AdSD by SeCorp :: 2023          ||%n");
               System.out.format("==================================================%n");

               if(bs.yayNay()) {
                  System.out.println("You probably thought you weren't gonna die today, surprise!");
                  nextCycle = false;
               }
               break;

            case SELECT_PATIENT:
               patient_Selector();
               break;

            case VIEW_PATIENT:
               currentUser.viewPatientData(currentPatient);
               break;

            case EDIT_PATIENT:
               currentUser.menu_Edit(currentPatient);
               break;

            case SELECT_MEDICATION:
               medication_Selector();
               break;

            case SETTINGS:
               currentUser.menu_Settings(medication, data);
               break;

            case ADD_MEDNOTE:
               if (medication == null) {
                  System.out.println("Select the medication you want to prescribe to " + currentPatient.getFullName() + " (" + currentPatient.calculateAge() + "): ");
                  medication_Selector();
               }
               else {
                  currentUser.writeMedicationToPatient(currentPatient, medication);
            }
               break;

            case ADD_CONSULT:
               currentUser.writeConsultToPatient(currentPatient, data);
               break;

            case ADD_STARNOTE:
               currentUser.writeStarNotes(currentPatient);
               break;

            case SELECT_USER:
               user_Selector();
               break;

//Admin menu
            case ADD_PATIENT:
               ((Admin) currentUser).patient_Add_New(data);
               break;

            case DELETE_PATIENT:
               ((Admin) currentUser).patient_Delete(data);
               break;

            case ADD_USER:
               ((Admin) currentUser).menu_Admin_Add_User(data);
               break;

            case DELETE_USER:
               ((Admin) currentUser).user_Delete(data);
               break;

            case ADD_MEDICATION:
               ((Admin) currentUser).medication_Add(data);
               break;

            case DELETE_MEDICATION:
               System.out.println("Function currently not available");
               break;

            case EDIT_PATIENTNUMBER:
               ((Admin) currentUser).patient_Edit_PatientNumber(data);
               break;

            case DELETE_MEDNOTE:
               System.out.println("Function currently not available");
               break;

            case CASE_DEFAULT:

            default:
               System.out.println("Invalid input. Please enter a valid input: ");
         }
      }
   }
//for lolz
   private boolean admin_Checker() {
      if(currentUser instanceof Admin) {
         return true;
      }
      return false;
   }
   boolean adminCheck() {
      return currentUser instanceof Admin;
   }
   boolean admin_Check() {
      return currentUser instanceof Admin ? true : false;
   }
}
