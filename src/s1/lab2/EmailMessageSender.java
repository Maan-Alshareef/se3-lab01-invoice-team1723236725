package s1.lab2;

public class EmailMessageSender implements MessageSender {
    private final InvoiceFormatter formatter;

    public EmailMessageSender(InvoiceFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String send(Invoice invoice, String invoiceText) {
        String message = formatter.formatMessage(invoice.getCustomerEmail(), invoice, invoiceText);
        System.out.println("Sending email...");
        return message;
    }
}
