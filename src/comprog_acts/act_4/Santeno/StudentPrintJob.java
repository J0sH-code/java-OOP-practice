
public class StudentPrintJob {

    private String studentName;
    private String documentName;
    private Printer printer;

    // constructor
    public StudentPrintJob(String studentName, String documentName, Printer printer) {
        this.studentName = studentName;
        this.documentName = documentName;
        this.printer = printer;
    }

    // TODO: Override the run() method
    // Inside this method, call the printer's printDocument() method
}
