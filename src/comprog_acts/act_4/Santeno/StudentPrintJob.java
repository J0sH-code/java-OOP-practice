
public class StudentPrintJob implements Runnable {

    private final String studentName;
    private final String documentName;
    private final Printer printer;

    // constructor
    public StudentPrintJob(String studentName, String documentName, Printer printer) {
        this.studentName = studentName;
        this.documentName = documentName;
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printDocument(studentName, documentName);
    }

    // TODO: Override the run() method
    // Inside this method, call the printer's printDocument() method
}
