package s1.lab2;

public class InvoiceCalculator {
    public double calculateTotal(Invoice invoice) {
        double sum = 0;
        for (InvoiceItem item : invoice.getItems()) {
            sum += item.getPrice() * item.getQty();
        }
        if (sum > 1000) {
            sum = sum * 0.95;
        }
        return sum * 1.15;
    }
}
