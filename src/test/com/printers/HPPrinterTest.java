package com.printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HPPrinterTest {
    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.connectHP();
        printer.printHP();
        assertEquals("Ink Level: 9,0; Paper Count: 9", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenPrintCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0, 0);
        printer.connectHP();
        printer.printHP();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.connectHP();
        printer.saveInkPrintHP();
        assertEquals("Ink Level: 9,5; Paper Count: 9", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0, 0);
        printer.connectHP();
        printer.saveInkPrintHP();
        assertEquals("Ink Level: 0,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithoutResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(0, 0);
        printer.connectHP();
        printer.maintainHP();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.connectHP();
        printer.maintainHP();
        assertEquals("Ink Level: 15,0; Paper Count: 15", printer.toString());
    }
}
