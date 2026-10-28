package s1.lab2;

public class WhatsAppMessageSender implements MessageSender {
    private final InvoiceFormatter formatter;

    public WhatsAppMessageSender(InvoiceFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String send(Invoice invoice, String invoiceText) {
        String message = formatter.formatMessage("sendwhatsapp", invoice, invoiceText);
        System.out.println("Sending sendwhatsapp...");
        return message;
    }
}
