import java.time.LocalDate;

public class Admin extends User {

    public Admin(String title, String firstName, String surname, LocalDate birthday) {
        super(title, firstName, surname, birthday);
    }

    BScanner bs = new BScanner();
    User admin_User;
    Patient admin_Patient;

    @Override
    public char switch_Choice() {
        int choice = bs.nextInt();

        if(choice == 0) return 'a';
        if(choice == 1) return 'k';
        if(choice == 2) return 'l';
        if(choice == 3) return 'm';
        if(choice == 4) return 'n';
        if(choice == 5) return 'o';
        if(choice == 6) return 'p';
        if(choice == 7) return 'q';
        if(choice == 8) return 'r';
        if(choice == 9) return 'j';
        else return 'z';
    }

    @Override
    public void printMenu_withOptions() {
        System.out.format("%S%n", "[0] back");
        System.out.format("%S%n", "[1] add patient");
        System.out.format("%S%n", "[2] delete patient");
        System.out.format("%S%n", "[3] add user");
        System.out.format("%S%n", "[4] delete user");
        System.out.format("%S%n", "[5] add medication");
        System.out.format("%S%n", "[6] delete medication");
        System.out.format("%S%n", "[7] edit patientnumber");
        System.out.format("%S%n", "[8] delete mednote");
        System.out.format("%S%n", "[9] select user");
        System.out.print( "The choice is yours: " );
    }

    public void menu_Admin_Add_User(Data data) {
        System.out.format("%S%n", "[0] back");
        System.out.format("%S%n", "[1] add doctor");
        System.out.format("%S%n", "[2] add dentist");
        System.out.format("%S%n", "[3] add physiotherapist");
        System.out.format("%S%n", "[4] add admin");

        int choice = bs.nextInt();

        boolean nextCycle = true;
        while (nextCycle) {

            switch (choice) {
                case BACK ->
                    nextCycle=false;

                case 1 -> {
                    user_Add_Menu_("Doctor");
                    user_Add_Doctor_(data);
                    System.out.println("New user added: " + data.getUserMap().get(data.latest_NewHashMapKay).getFullName());
                    return;
                }

                case 2 -> {
                    user_Add_Menu_("Dentist");
                    user_Add_Dentist_(data);
                    System.out.println("New user added: " + data.getUserMap().get(data.latest_NewHashMapKay).getFullName());
                    return;
                }
                case 3 -> {
                    user_Add_Menu_("Physiotherapist");
                    user_Add_Physiotherapist_(data);
                    System.out.println("New user added: " + data.getUserMap().get(data.latest_NewHashMapKay).getFullName());
                    return;
                }
                case 4 -> {
                    user_Add_Menu_("Admin");
                    user_Add_Admin_(data);
                    System.out.println("New user added: " + data.getUserMap().get(data.latest_NewHashMapKay).getFullName());
                    return;
                }
                default -> System.out.println("Invalid input. Please enter a valid input: ");
            }
        }
    }

//==================================================
//====SELECTOR_=====================================
    private void patient_Selector(Data data) {
        System.out.format("%-4s %-20s %-20s %-15s\n", "#", "First name:", "Surname:", "Born:");
        for(Patient admin_Patient : data.getPatientList()) {
            System.out.format(" %-3s %-20s %-20s %-15s\n", admin_Patient.getPatientNumber(),
                    admin_Patient.getFirstName(),
                    admin_Patient.getSurname(),
                    admin_Patient.getBirthday().format(bs.y_MMM_d));
        }
        int select_Patient_Number = bs.nextInt();
        for(Patient admin_Patient : data.getPatientList()) {
            if(select_Patient_Number == admin_Patient.getPatientNumber()) {
                this.admin_Patient = admin_Patient;
                System.out.format("Selected patient: %s (%s)\n", admin_Patient.getFullName(), admin_Patient.getBirthday().format(bs.d_mm_y));
            }
        }
    }

    private void user_Selector(Data data) {
        System.out.format("%-10s %-15s %-15s\n", "Title:", "First name:", "Surname:");
        for(User admin_User : data.getUserMap().values()) {
            System.out.format("%-10s %-15s %-15s\n", admin_User.getTitle(),
                    admin_User.getFirstName(),
                    admin_User.getSurname());
        }
        String select_User_FirstName = bs.nextLine();
        for(User admin_User : data.getUserMap().values()) {
            if(select_User_FirstName.equals(admin_User.getFirstName())) {
                this.admin_User = admin_User;
                System.out.format("Selected user: %s (%s)\n", admin_User.getFullName(), admin_User.getBirthday());
            }
        }
    }


//==================================================
//====PATIENT_======================================
    String newFirstName;
    String newSurname;
    LocalDate newBirthday;
    float newWeight;
    float newLength;

    public void patient_Add_New(Data data) {

        System.out.print("New firstname: ");
        newFirstName = scanner.nextLine();
        System.out.print("New surname: ");
        newSurname = scanner.nextLine();
        System.out.print("New birthday (dd-MM-yyyy): ");
        newBirthday = bs.nextDate(LocalDate.of(1991,01,01));
        System.out.print("New weight: ");
        newWeight = bs.nextFloat();
        System.out.print("New length (1.80): ");
        newLength = bs.nextFloat();

        data.getPatientList().add(new Patient(data.newPatientNumber(), newFirstName, newSurname, newBirthday, newWeight, newLength));

        System.out.format("New patient: %s (%s)\n",data.getPatientList().get(data.latest_NewPatientNumber - 1).getFullName(),
                data.getPatientList().get(data.latest_NewPatientNumber - 1).getBirthday().format(bs.d_mm_y));

    }

    public void patient_Delete(Data data) {
        patient_Selector(data);
        System.out.print("Delete patient: " + admin_Patient.getFullName());
        if(bs.yayNay()) {
            data.getPatientList().remove(admin_Patient);
        }
    }

    public void patient_Edit_PatientNumber(Data data) {
        patient_Selector(data);
        System.out.format("Selected patient: %s (%s)\n", admin_Patient.getFullName(), admin_Patient.getPatientNumber());
        System.out.print("New patientnumber: ");
        admin_Patient.setPatientNumber(bs.nextInt());
        System.out.format("Selected patient: %s (%s)\n", admin_Patient.getFullName(), admin_Patient.getPatientNumber());
    }
//==================================================
//====USER_=========================================
    private String nF;
    private String nS;
    private LocalDate nB;

    private void user_Add_Menu_(String userType) {
        System.out.format("New %s firstname: ", userType);
        this.nF = bs.nextLine();
        System.out.format("New %s surname: ", userType);
        this.nS = bs.nextLine();
        System.out.format("New %s birthday (dd-MM-yyyy): ", userType);
        this.nB = bs.nextDate(LocalDate.of(2000,01,01));
    }
    private void user_Add_Doctor_(Data data) {
        String title = "MD";
        data.getUserMap().put(data.newHashMapKey(), new Doctor(title, nF, nS, nB));
    }
    private void user_Add_Dentist_(Data data) {
        String title = "DMD";
        data.getUserMap().put(data.newHashMapKey(), new Dentist(title, nF, nS, nB));
    }
    private void user_Add_Physiotherapist_(Data data) {
        String title = "physio";
        data.getUserMap().put(data.newHashMapKey(), new Physiotherapist(title, nF, nS, nB));
    }
    private void user_Add_Admin_(Data data) {
        String title = "";
        data.getUserMap().put(data.newHashMapKey(), new Admin(title, nF, nS, nB));
    }

    public void user_Delete(Data data) {
        user_Selector(data);
        System.out.print("Delete user: " + admin_User.getFullName());
        if(bs.yayNay()) {
            data.getUserMap().values().remove(admin_User);
        }
    }

//==================================================
//====MEDICATION_===================================
    boolean mnR;
    String mnN;
    String mnT;
    String mnSD;

    public void medication_Add(Data data) {

        System.out.print("New medication restriction (true or false): ");
        mnR = scanner.nextBoolean();
        System.out.print("New medication name: ");
        mnN = bs.nextLine();
        System.out.print("New medication type: ");
        mnT = bs.nextLine();
        System.out.print("New medication standard dosis: ");
        mnSD = bs.nextLine();

        data.getMedicationList().add(new Medication(mnR, mnN, mnT, mnSD));
        System.out.println("New Medication successfully added");
        System.out.format(" %-19s %-20s %-15s %b\n", data.getMedicationList().get(data.getMedicationList().size() - 1).getMedicationName(),
                data.getMedicationList().get(data.getMedicationList().size() - 1).getMedicationType(),
                data.getMedicationList().get(data.getMedicationList().size() - 1).getMedicationStDose(),
                data.getMedicationList().get(data.getMedicationList().size() - 1).getRestricted());
    }
























}