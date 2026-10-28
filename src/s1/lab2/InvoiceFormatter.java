package s1.lab2;

import java.util.Locale;

public class InvoiceFormatter {
    public String formatInvoice(Invoice invoice, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE ").append(invoice.getNumber()).append("\n");
        for (InvoiceItem item : invoice.getItems()) {
            double lineTotal = item.getPrice() * item.getQty();
            sb.append(String.format(Locale.US, "%s x%d = %.2f\n",
                    item.getName(), item.getQty(), lineTotal));
        }
        sb.append(String.format(Locale.US, "TOTAL: %.2f", total));
        return sb.toString();
    }

    public String formatRecord(Invoice invoice, double total) {
        return String.format(Locale.US, "%s;%s;%.2f",
                invoice.getNumber(), invoice.getCustomerEmail(), total);
    }

    public String formatMessage(String recipient, Invoice invoice, String invoiceText) {
        return "To: " + recipient + "\n"
                + "Subject: Invoice " + invoice.getNumber() + "\n\n"
                + invoiceText;
    }
}
