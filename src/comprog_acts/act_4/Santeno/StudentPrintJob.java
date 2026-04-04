
/**
 * StudentPrintJob represents a print job submitted by a student.
 * Implements Runnable to execute printing tasks in separate threads.
 */
public class StudentPrintJob implements Runnable {

    private final String studentName;
    private final String documentName;
    private final Printer printer;

    /**
     * Constructs a StudentPrintJob with student and document information.
     * @param studentName the name of the student
     * @param documentName the name of the document to print
     * @param printer the shared Printer instance to use
     */
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
