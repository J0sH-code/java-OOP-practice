
public class PrintSystem {

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
