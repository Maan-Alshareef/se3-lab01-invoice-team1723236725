package s1.lab2;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInvoiceRepository implements InvoiceRepository {
    public static final List<String> DATABASE = new ArrayList<>();

    @Override
    public void save(String record) {
        DATABASE.add(record);
    }
}
