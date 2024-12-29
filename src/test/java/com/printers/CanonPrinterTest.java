package com.printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanonPrinterTest {
    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        CanonPrinter printer = new CanonPrinter(15, 20);
        printer.connectCanon();
        printer.printCanon();
        assertEquals("Ink Level: 14,0; Paper Count: 19", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenPrintCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(0, 0);
        printer.connectCanon();
        printer.printCanon();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        CanonPrinter printer = new CanonPrinter(12, 15);
        printer.connectCanon();
        printer.saveInkPrintCanon();
        assertEquals("Ink Level: 11,5; Paper Count: 14", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(0, 0);
        printer.connectCanon();
        printer.saveInkPrintCanon();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenMaintenancePerformed_thenResourcesIncrease() {
        CanonPrinter printer = new CanonPrinter(0, 0);
        printer.connectCanon();
        printer.maintainCanon();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        CanonPrinter printer = new CanonPrinter(8, 10);
        printer.connectCanon();
        printer.maintainCanon();
        assertEquals("Ink Level: 13,0; Paper Count: 15", printer.toString());
    }
}

