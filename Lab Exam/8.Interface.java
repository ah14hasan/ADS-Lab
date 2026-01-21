// PROGRAM TO DEMONSTRATE INTERFACE IMPLEMENTATION

// Interface declaration
interface Printable {
    void print();
}

// Class implementing the Printable interface
class Document implements Printable {
    public void print() {
        System.out.println("Printing the document.");
    }
}

// Main class to test interface implementation
class InterfaceDemo {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.print(); // Calls the print() method from Printable interface, implemented in Document class
    }
}
