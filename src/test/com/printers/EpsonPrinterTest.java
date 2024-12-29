package com.printers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpsonPrinterTest {

    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(15, 12);
        printer.connectEpsonPrinter();
        printer.printEpson();
        assertEquals("Ink Level: 14,0; Paper Count: 11", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        printer.connectEpsonPrinter();
        printer.printEpson();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(8, 20);
        printer.connectEpsonPrinter();
        printer.saveInkPrintEpson();
        assertEquals("Ink Level: 7,5; Paper Count: 19", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        printer.connectEpsonPrinter();
        printer.saveInkPrintEpson();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        printer.connectEpsonPrinter();
        printer.maintainEpson();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(6, 15);
        printer.connectEpsonPrinter();
        printer.maintainEpson();
        assertEquals("Ink Level: 11,0; Paper Count: 20", printer.toString());
    }
}
