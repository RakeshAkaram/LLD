package SOLID;

public class SingleResponsibility {
}

class Marker{
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, int price, int year, String color) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.color = color;
    }
}

class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal(){
        int price = marker.price*quantity;
        return price;
    }
}

class InvoicePrinter{
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice(){
        //print the Invoice
    }
}

class InvoiceDao1{
    private Invoice invoice;

    public InvoiceDao1(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB(){
        //save the data into DB
    }
    public void saveToFile(){
        //save the data into File
    }
}


