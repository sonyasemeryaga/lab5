package com.printers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpsonPrinterTest {

    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(15, 12);
        printer.printEpson();
        String expected = "Ink Level: 14.0; Paper Count: 11";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        assertFalse(printer.isReady());
        printer.printEpson();
        assertEquals("Ink Level: 0.0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(8, 20);
        printer.saveInkModeEpson();
        String expected = "Ink Level: 7.5; Paper Count: 19";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        assertFalse(printer.isReady());
        printer.saveInkModeEpson();
        assertEquals("Ink Level: 0.0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        printer.performMaintenanceEpson();
        String expected = "Ink Level: 5.0; Paper Count: 5";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(6, 15);
        assertTrue(printer.isReady());
        printer.performMaintenanceEpson();
        assertEquals("Ink Level: 11.0; Paper Count: 20", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenChecked_thenIsReadyReturnsTrue() {
        EpsonPrinter printer = new EpsonPrinter(10, 5);
        assertTrue(printer.isReady());
    }

    @Test
    public void givenPrinterWithoutResources_whenChecked_thenIsReadyReturnsFalse() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        assertFalse(printer.isReady());
    }
}
