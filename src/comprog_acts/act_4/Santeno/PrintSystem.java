
/**
 * PrintSystem demonstrates multi-threaded printing with multiple students.
 * Each student submits a print job that runs concurrently using separate threads.
 */
public class PrintSystem {

    /**
     * Main entry point that creates and starts multiple student print jobs.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread jacob = new Thread(new StudentPrintJob("Jacob", "c++-guide-book.pdf", printer));
        Thread roxanne = new Thread(new StudentPrintJob("Roxanne", "Mom's_cookbook.pdf", printer));
        Thread josh = new Thread(new StudentPrintJob("Josh", "NetpL2.pdf", printer));
        Thread zoey = new Thread(new StudentPrintJob("Zoey", "BTS-songbook.pdf", printer));

        jacob.start();
        roxanne.start();
        josh.start();
        zoey.start();
        // TODO: Create ONE shared Printer object
        // TODO: Create at least 4 StudentPrintJob thread objects
        // TODO: Start all threads using start()

    }

}
