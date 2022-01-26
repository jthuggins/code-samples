package app.samples.demo.service;

import app.samples.demo.utils.IntSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class InvoiceProcessingServiceTest {

    @Mock
    private IntSet invoiceNumbers;

    @InjectMocks
    private InvoiceProcessingService testClass;

    @Test
    public void that_invoice_is_processed() {
        // given
        BDDMockito.given(invoiceNumbers.contains(1234567)).willReturn(true);

        // when
        boolean actual = testClass.isProcessed(1234567);

        // then
        assertTrue(actual);
    }

    @Test
    public void that_processing_adds_invoice_to_processed() {
        // given

        // when
        testClass.process(1234567);

        // then
        BDDMockito.then(invoiceNumbers).should().add(1234567);
    }
}

