import java.time.LocalDate;
import java.time.Period;

public class Person {

private String firstName;
private String surname;
private LocalDate birthday;

public Person(String firstName, String surname, LocalDate birthday) {
    this.firstName = firstName;
    this.surname = surname;
    this.birthday = birthday;
    }
//==================================================
//getters===========
public String getFirstName() {
    return firstName;
    }
public String getSurname() {
    return surname;
    }
public LocalDate getBirthday() {
    return birthday;
    }
//==================================================
//setters===========
public void setFirstName(String firstName) {
    this.firstName = firstName;
    }
public void setSurname(String surname) {
    this.surname = surname;
    }
public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    }
//==================================================
//====FN_===========================================
public int calculateAge() {
    return Period.between(birthday, LocalDate.now()).getYears();
    }

public String getFullName() {
    return String.format("%s %s", firstName, surname);
    }
}
