import java.time.LocalDate;

public class ConsultNotes extends Notes {

    private Consult consult;

    public ConsultNotes(Consult consult, String note, LocalDate noteDate) {
        super(note, noteDate);
        this.consult = consult;
    }

    public Consult getConsult() {
        return consult;
    }

}
