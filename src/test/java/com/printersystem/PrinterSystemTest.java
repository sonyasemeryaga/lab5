package com.printersystem;

import com.adapters.CanonPrinterAdapter;
import com.adapters.EpsonPrinterAdapter;
import com.adapters.HPPrinterAdapter;
import com.printers.CanonPrinter;
import com.printers.EpsonPrinter;
import com.printers.HPPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrinterSystemTest {

    @Test
    public void givenCanonPrinterWithSufficientResources_whenPrintAndSaveInkCalled_thenResourcesDecreaseCorrectly() {
        CanonPrinter printer = new CanonPrinter(10, 15);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 8,5; Paper Count: 13", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowResources_whenSaveInkAndPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0.2, 5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        adapter.print();
        assertEquals("Ink Level: 0,2; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenHPPrinterWithSufficientResources_whenMaintenanceAndPrintCalled_thenResourcesDecreaseAndIncrease() {
        HPPrinter printer = new HPPrinter(50, 50);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        adapter.print();
        assertEquals("Ink Level: 54,0; Paper Count: 54", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithExcessiveResources_whenMultiplePrintAndMaintenanceCalled_thenResourcesDecreaseAndIncreaseCorrectly() {
        EpsonPrinter printer = new EpsonPrinter(30, 40);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.print();
        adapter.maintain();
        assertEquals("Ink Level: 33,0; Paper Count: 43", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithLowResources_whenMultipleSaveInkAndPrintCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(0.5, 3);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        adapter.print();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 0,0; Paper Count: 2", printer.toString());
    }

    @Test
    public void givenHPPrinterWithNegativeInk_whenMaintenanceAndSaveInkCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(-5, 10);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        adapter.saveInkPrint();
        assertEquals("Ink Level: -5,0; Paper Count: 10", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowPaper_whenPrintAndSaveInkCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(10, 0);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 10,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenHPPrinterWithNegativeInk_whenMultiplePrintAndSaveInkCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(-10, 5);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.saveInkPrint();
        adapter.print();
        assertEquals("Ink Level: -10,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithInsufficientResources_whenPrintThenMaintenanceCalled_thenResourcesStaySame() {
        CanonPrinter printer = new CanonPrinter(0.5, 2);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.maintain();
        assertEquals("Ink Level: 5,5; Paper Count: 7", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithSufficientResources_whenPrintThenSaveInkThenMaintenanceCalled_thenResourcesDecreaseAndIncrease() {
        EpsonPrinter printer = new EpsonPrinter(20, 30);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        adapter.saveInkPrint();
        adapter.maintain();
        assertEquals("Ink Level: 23,5; Paper Count: 33", printer.toString());
    }
}
