import java.util.ArrayList;
import java.util.Scanner;


public class Medication {

private boolean restricted;
private String name;
private String type;
private String stDose;

public Medication(boolean restricted, String name, String type, String stDose) {
    this.restricted = restricted;
    this.name = name;
    this.type = type;
    this.stDose = stDose;
    }

    Scanner scanner = new Scanner(System.in);
//==================================================
//getters===============
public boolean getRestricted() {
    return restricted;
    }
public String getMedicationName() {
    return name;
    }
public String getMedicationType() {
    return type;
    }
public String getMedicationStDose() {
    return stDose;
    }
//==================================================
//setters================
public void setRestricted(boolean restricted) {
    this.restricted = restricted;
    }
public void setMedicationName(String name) {
    this.name = name;
    }
public void setMedicationType(String type) {
    this.type = type;
    }
public void setMedicationStDose(String stDose) {
    this.stDose = stDose;
    }

    //first select a medication
    public void medication_Edit_StDose() {
        System.out.print("Change standard dosis of " + getMedicationName() + ": ");
        setMedicationStDose(scanner.nextLine());
    }
}
