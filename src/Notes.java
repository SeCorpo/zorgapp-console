import java.time.LocalDate;

public class Notes {

public String note;
public LocalDate noteDate;

public Notes(String note, LocalDate noteDate) {
    this.note = note;
    this.noteDate = noteDate;
    }
//==================================================
//getters===========
public String getNote() {
    return note;
    }
public LocalDate getNoteDate() {
    return noteDate;
    }

//==================================================
//setters===========
public void setNote(String note) {
    this.note = note;
    }
public void setNoteDate(LocalDate noteDate) {
    this.noteDate = noteDate;
    }
    
}
