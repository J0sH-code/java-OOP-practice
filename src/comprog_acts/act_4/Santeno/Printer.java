
/**
 * Printer handles document printing with thread synchronization.
 * Ensures only one student can print at a time.
 */
public class Printer {
    // TODO: Add the synchronized keyword to make sure only one thread
    // can access this method at a time

    /**
     * Prints a document for a student with thread-safe synchronization.
     * @param studentName the name of the student printing
     * @param documentName the name of the document to print
     */
    public synchronized void printDocument(String studentName, String documentName) {

        System.out.println(studentName + " started printing " + documentName);

        try {
            // simulate printing time
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(studentName + " finished printing " + documentName);
    }

}
