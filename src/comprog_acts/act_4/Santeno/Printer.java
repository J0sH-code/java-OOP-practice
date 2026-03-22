
public class Printer {
    // TODO: Add the synchronized keyword to make sure only one thread
    // can access this method at a time

    public void printDocument(String studentName, String documentName) {

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
