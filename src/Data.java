import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Data {

Data() {
    }

    //When selecting a patient, it uses array-index number, not patient id

//instances=========
private HashMap<Integer, User> userMap = new HashMap<>();
private ArrayList<Patient> patientList = new ArrayList<>();
private ArrayList<Medication> medicationList = new ArrayList<>();


private ArrayList<Consult> doctor_Consult = new ArrayList<>();
private ArrayList<Consult> dentist_Consult = new ArrayList<>();
private ArrayList<Consult> physio_Consult = new ArrayList<>();

//users=============
{
    userMap.put(0, new Admin("a","Sem", "Koldewijn", LocalDate.of(1999, 6, 1)));
    userMap.put(1, new Dentist("DMD", "Robert", "Pikinsky", LocalDate.of(1999, 12, 13)));
    userMap.put(2, new Physiotherapist("Physio", "Joost", "Fox", LocalDate.of(1950, 2, 2)));
    userMap.put(3, new Dentist("DMD", "Peter", "Rensink", LocalDate.of(1999, 1, 15)));
    userMap.put(4, new Doctor("MD", "Dokter", "Snor", LocalDate.of(1967, 9, 26)));
    userMap.put(5, new Admin(" ", "Moot", " ", LocalDate.of(1988, 12, 22)));
    userMap.put(6, new Doctor("MD", "Johnny", "NoCash", LocalDate.of(1978, 12, 31)));
    userMap.put(7, new Dentist("DMD", "Dentist", "Van Roodewijn", LocalDate.of(1932, 1,23)));
    userMap.put(8, new Physiotherapist("Physio", "Flexi", "Papi", LocalDate.of(1988, 4, 20)));
}

//patients==========
{
    patientList.add(new Patient(0, "Patient", "Star", LocalDate.of(1950, 1, 1), 81f, 1.69f));
    patientList.add(new Patient(1, "Patient", "Zero", LocalDate.of(1950, 1, 1), 80f, 1.85f));
    patientList.add(new Patient(2, "Dildo", "Swaggins", LocalDate.of(1999, 6, 2), 75f, 1.83f));
    patientList.add(new Patient(3, "Barack", "Obama", LocalDate.of(1961, 8, 4), 80f, 1.86f));
    patientList.add(new Patient(4, "Steve", "Carell", LocalDate.of(1962, 8, 16), 78f, 1.75f));
    patientList.add(new Patient(5, "Xi", "Jinping", LocalDate.of(1953, 6, 15), 73f, 1.75f));
    patientList.add(new Patient(6, "Vladimir", "Putin", LocalDate.of(1952, 10, 7), 68f, 1.70f));
    patientList.add(new Patient(7, "Justin", "Bieber", LocalDate.of(1994, 3, 1), 67f, 1.72f));
    patientList.add(new Patient(8, "Donald", "Trump", LocalDate.of(1946, 6, 14), 107.5f, 1.90f));
    patientList.add(new Patient(9, "Felix", "Kjellberg", LocalDate.of(1989, 10, 24), 82.5f, 1.8f));
}

//medicationList====
{
    medicationList.add(new Medication(false, "Parazetamol", "Painkiller", "500 mg"));
    medicationList.add(new Medication(false, "Ibuprofen", "Painkiller", "400 mg"));
    medicationList.add(new Medication(true, "Oxycodon", "Painkiller", "10 mg"));
    medicationList.add(new Medication(true, "Methylfenidaat", "Stimulant", "5 mg"));
    medicationList.add(new Medication(true, "Penicilline", "Antibiotica", "10 tabletten"));
}

//patientMedicationNotes=======
{
    patientList.get(3).addMedNote(medicationList.get(3),"Behoefte aan focus", LocalDate.of(2023,3,6));
    patientList.get(3).addMedNote(medicationList.get(2),"Door zijn stressvolle baan heeft meneer behoeft aan wat ontspanning",LocalDate.of(2023,3,6));
    patientList.get(3).addMedNote(medicationList.get(4),"Gebeten door een hond",LocalDate.of(2023,3,31));
    patientList.get(3).addMedNote(medicationList.get(1),"virus opgelopen",LocalDate.of(2023,3,31));
    patientList.get(3).addMedNote(medicationList.get(3),"Spacen dit weekend, 3 doosjes 25mg",LocalDate.of(2023,3,31));
    patientList.get(3).addMedNote(medicationList.get(4),"Griep klachten",LocalDate.of(2022,6,12));
    patientList.get(3).addMedNote(medicationList.get(0),"Hoge bloeddruk 130-90",LocalDate.of(2022,5,5));

}

//ConsultList=========
{
    doctor_Consult.add(new Consult("Doctor", "Default", "Consult", 21.50f));
    doctor_Consult.add(new Consult("Doctor", "Extended", "Huisbezoek", 43.00f));
    doctor_Consult.add(new Consult("Doctor", "Extended", "Gezondheidsonderzoek", 43.00f));

    dentist_Consult.add(new Consult("Dentist", "Default", "Routine controle", 20.00f));
    dentist_Consult.add(new Consult("Dentist", "Simple", "Extractie", 30.00f));
    dentist_Consult.add(new Consult("Dentist","Simple", "Flouridebehandeling", 30.00f));
    dentist_Consult.add(new Consult("Dentist", "Complex", "Wortelkanaalbehandeling", 55.00f));
    dentist_Consult.add(new Consult("Dentist", "Complex", "Implantaat", 55.00f));

    physio_Consult.add(new Consult("Physiotherapist", "Default", "Standaard behandeling", 17.50f));
    physio_Consult.add(new Consult("Physiotherapist", "Short", "Tapen en bandageren", 25.00f));
    physio_Consult.add(new Consult("Physiotherapist", "Short", "Mobilisatie", 25.00f));
    physio_Consult.add(new Consult("Physiotherapist", "Short", "Massage", 25.00f));
    physio_Consult.add(new Consult("Physiotherapist", "Extended", "Manuele therapie", 50.00f));
    physio_Consult.add(new Consult("Physiotherapist", "Extended", "Dry needling", 50.00f));
    physio_Consult.add(new Consult("Physiotherapist", "Facilities", "Gebruik van oefenbad", 5.00f));
}

//patientConsultNotes========
{
    patientList.get(3).addConsultNote(doctor_Consult.get(2),"Kankerlijah hebt obesitas wss", LocalDate.of(2023,3,31));
    patientList.get(3).addConsultNote(doctor_Consult.get(0),"Gebroken hand, doorverwezen naar specialist", LocalDate.of(2023,3,31));
    patientList.get(3).addConsultNote(doctor_Consult.get(0),"Betonvlinder in oog, gedeeltelijk tijdelijke blindheid", LocalDate.of(2022,1,2));
    patientList.get(3).addConsultNote(doctor_Consult.get(0),"Bloeddruk meting, 110-80, prima", LocalDate.of(2021,7,14));
    patientList.get(3).addConsultNote(physio_Consult.get(3),"30 minuten shiatzu", LocalDate.of(2022,9,23));
    patientList.get(3).addConsultNote(dentist_Consult.get(1), "Zonder verdoving door verslavingsgeschiedenis", LocalDate.of(2020,6,2));
    patientList.get(3).addConsultNote(doctor_Consult.get(1),"Mannen maken moneyyyy jaja", LocalDate.of(2023,3,31));
    patientList.get(3).addConsultNote(doctor_Consult.get(1),"Alle Heil voor de China Communist Partij", LocalDate.of(2023,3,31));
    patientList.get(3).addConsultNote(doctor_Consult.get(0),"Klacht over pijn in linkerarm, geadviseerd om rust te nemen", LocalDate.of(2021,11,15));
    patientList.get(3).addConsultNote(physio_Consult.get(5),"45 minuten krachttraining", LocalDate.of(2022,4,17));
    patientList.get(3).addConsultNote(doctor_Consult.get(1),"Grieperig, medicatie voorgeschreven", LocalDate.of(2022,6,12));
    patientList.get(3).addConsultNote(physio_Consult.get(3),"60 minuten yoga", LocalDate.of(2023,2,14));
    patientList.get(3).addConsultNote(doctor_Consult.get(0),"Hoge bloeddruk, medicatie voorgeschreven", LocalDate.of(2022,5,5));
    patientList.get(3).addConsultNote(physio_Consult.get(5),"75 minuten aquarobics", LocalDate.of(2022,7,19));
    patientList.get(3).addConsultNote(dentist_Consult.get(0), "Op 3-4 lichte kalksteen, verder geen klachten", LocalDate.of(2023,3,31));
}

//patientStarNotes========
{
    patientList.get(3).addStarNote(4.3,"****",LocalDate.of(2023,3,25));
    patientList.get(3).addStarNote(4.4,"****",LocalDate.of(2023,3,26));
    patientList.get(3).addStarNote(4.6,"****",LocalDate.of(2023,3,27));
    patientList.get(3).addStarNote(5.1,"*****",LocalDate.of(2023,3,28));
    patientList.get(3).addStarNote(5.4,"*****",LocalDate.of(2023,3,29));
    patientList.get(3).addStarNote(4.9,"*****",LocalDate.of(2023,3,30));
    patientList.get(3).addStarNote(5.1,"*****",LocalDate.of(2023,3,31));
    patientList.get(3).addStarNote(7.8,"*******",LocalDate.of(2023,4,1));
}

//getters================
public HashMap<Integer, User> getUserMap() {
    return userMap;
    }

public ArrayList<Patient> getPatientList() {
    return patientList;
    }
    
public ArrayList<Medication> getMedicationList() {
    return medicationList;
    }

public ArrayList<Consult> getDoctor_Consult() {
    return doctor_Consult;
    }

public ArrayList<Consult> getDentist_Consult() {
    return dentist_Consult;
}

public ArrayList<Consult> getPhysio_Consult() {
    return physio_Consult;
}
//==================================================
//====FN_===========================================
public int newPatientNumber() {
    return patientList.size() + 1;
    }
public Integer newHashMapKey() {
    return userMap.size() + 1;
    }
    public int latest_NewPatientNumber = newPatientNumber();
    public Integer latest_NewHashMapKay = newHashMapKey();
}
