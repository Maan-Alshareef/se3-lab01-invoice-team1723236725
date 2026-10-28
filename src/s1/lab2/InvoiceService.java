package s1.lab2;

public class InvoiceService {
    private final InvoiceCalculator calculator;
    private final InvoiceFormatter formatter;
    private final InvoiceRepository repository;
    private final MessageSender emailSender;
    private final MessageSender whatsappSender;

    public InvoiceService(
            InvoiceCalculator calculator,
            InvoiceFormatter formatter,
            InvoiceRepository repository,
            MessageSender emailSender,
            MessageSender whatsappSender) {
        this.calculator = calculator;
        this.formatter = formatter;
        this.repository = repository;
        this.emailSender = emailSender;
        this.whatsappSender = whatsappSender;
    }

    public String printInvoice(Invoice invoice) {
        double total = calculator.calculateTotal(invoice);
        String text = formatter.formatInvoice(invoice, total);
        System.out.println(text);
        return text;
    }

    public void saveInvoice(Invoice invoice) {
        double total = calculator.calculateTotal(invoice);
        String record = formatter.formatRecord(invoice, total);
        repository.save(record);
    }

    public String sendEmail(Invoice invoice) {
        double total = calculator.calculateTotal(invoice);
        String invoiceText = formatter.formatInvoice(invoice, total);
        System.out.println(invoiceText);
        return emailSender.send(invoice, invoiceText);
    }

    public String sendwhatsapp(Invoice invoice) {
        double total = calculator.calculateTotal(invoice);
        String invoiceText = formatter.formatInvoice(invoice, total);
        System.out.println(invoiceText);
        return whatsappSender.send(invoice, invoiceText);
    }
}
