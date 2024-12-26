package com.printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HPPrinterTest {

    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.printHP();
        String expected = "Ink Level: 9,0; Paper Count: 9";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenPrintCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0, 0);
        assertFalse(printer.isReady());
        printer.printHP();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.saveInkModeHP();
        String expected = "Ink Level: 9,5; Paper Count: 9";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0, 0);
        assertFalse(printer.isReady());
        printer.saveInkModeHP();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(0, 0);
        printer.performMaintenanceHP();
        String expected = "Ink Level: 5,0; Paper Count: 5";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        assertTrue(printer.isReady());
        printer.performMaintenanceHP();
        assertEquals("Ink Level: 15,0; Paper Count: 15", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenChecked_thenIsReadyReturnsTrue() {
        HPPrinter printer = new HPPrinter(10, 10);
        assertTrue(printer.isReady());
    }

    @Test
    public void givenPrinterWithoutResources_whenChecked_thenIsReadyReturnsFalse() {
        HPPrinter emptyPrinter = new HPPrinter(0, 0);
        assertFalse(emptyPrinter.isReady());
    }
}
