package s1.lab2;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoiceFormatter formatter = new InvoiceFormatter();
        MessageSender emailSender = new EmailMessageSender(formatter);
        MessageSender whatsappSender = new WhatsAppMessageSender(formatter);

        InvoiceRepository dbRepository = new DatabaseInvoiceRepository();
        InvoiceService dbService = new InvoiceService(
                calculator, formatter, dbRepository, emailSender, whatsappSender);

        Invoice inv1 = new Invoice("INV-1", "lina@uni.edu");
        inv1.addItem("Book", 100.0, 2);

        dbService.printInvoice(inv1);
        dbService.saveInvoice(inv1);
        System.out.println("DATABASE: " + DatabaseInvoiceRepository.DATABASE);
        dbService.sendEmail(inv1);
        dbService.sendwhatsapp(inv1);
        System.out.println(String.format(Locale.US, "Calculated Total: %.2f", calculator.calculateTotal(inv1)));

        System.out.println();

        InvoiceRepository fileRepository = new FileInvoiceRepository();
        InvoiceService fileService = new InvoiceService(
                calculator, formatter, fileRepository, emailSender, whatsappSender);

        Invoice inv2 = new Invoice("INV-2", "omar@uni.edu");
        inv2.addItem("Laptop", 1200.0, 1);

        fileService.printInvoice(inv2);
        fileService.saveInvoice(inv2);
        System.out.println("FILES: " + FileInvoiceRepository.FILES);
        fileService.sendEmail(inv2);
        fileService.sendwhatsapp(inv2);
        System.out.println(String.format(Locale.US, "Calculated Total: %.2f", calculator.calculateTotal(inv2)));

        System.out.println();

        Invoice inv3 = new Invoice("INV-3", "sara@uni.edu");
        inv3.addItem("Item", 500.0, 2);

        dbService.printInvoice(inv3);
        dbService.saveInvoice(inv3);
        System.out.println("DATABASE: " + DatabaseInvoiceRepository.DATABASE);
        dbService.sendEmail(inv3);
        dbService.sendwhatsapp(inv3);
        System.out.println(String.format(Locale.US, "Calculated Total: %.2f", calculator.calculateTotal(inv3)));
    }
}
