package s1.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Invoice {
    private String number;
    private String customerEmail;
    private List<InvoiceItem> items;

    public static final List<String> DATABASE = new ArrayList<>();
    public static final List<String> FILES = new ArrayList<>();

    public Invoice(String number, String customerEmail) {
        this.number = number;
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int qty) {
        items.add(new InvoiceItem(name, price, qty));
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public String getNumber() {
        return number;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double calculateTotal() {
        double sum = 0;
        for (InvoiceItem item : items) {
            sum += item.getPrice() * item.getQty();
        }
        if (sum > 1000) {
            sum = sum * 0.95;
        }
        return sum * 1.15;
    }

    public String printInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE ").append(number).append("\n");
        for (InvoiceItem item : items) {
            double lineTotal = item.getPrice() * item.getQty();
            sb.append(String.format(Locale.US, "%s x%d = %.2f\n",
                    item.getName(), item.getQty(), lineTotal));
        }
        sb.append(String.format(Locale.US, "TOTAL: %.2f", calculateTotal()));
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public void saveToDatabase(String type) {
        String record = String.format(Locale.US, "%s;%s;%.2f",
                number, customerEmail, calculateTotal());
        if ("DATABASE".equals(type)) {
            DATABASE.add(record);
        } else {
            FILES.add(record);
        }
    }

    public String sendEmail() {
        String invoiceText = printInvoice();
        String message = "To: " + customerEmail + "\n"
                + "Subject: Invoice " + number + "\n\n"
                + invoiceText;
        System.out.println("Sending email...");
        return message;
    }

    public String sendwhatsapp() {
        String invoiceText = printInvoice();
        String message = "To: sendwhatsapp\n"
                + "Subject: Invoice " + number + "\n\n"
                + invoiceText;
        System.out.println("Sending sendwhatsapp...");
        return message;
    }
}
