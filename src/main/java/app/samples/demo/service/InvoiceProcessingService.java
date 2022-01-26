package app.samples.demo.service;

import app.samples.demo.utils.IntSet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceProcessingService {
    
    private IntSet invoiceNumbers;
    
    public boolean isProcessed(int invoice) {
        return invoiceNumbers.contains(invoice);
    }

    public void process(int invoice) {
        invoiceNumbers.add(invoice);
    }
}
