package com.printers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HPPrinterTest {
    @Test
    public void testHPPrinterPrint() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.printHP();
        String expected = "Ink Level: 9,0; Paper Count: 9";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void testHPPrinterSaveInkMode() {
        HPPrinter printer = new HPPrinter(10, 10);
        printer.saveInkModeHP();
        String expected = "Ink Level: 9,5; Paper Count: 9";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void testHPPrinterMaintenance() {
        HPPrinter printer = new HPPrinter(0, 0);
        printer.performMaintenanceHP();
        String expected = "Ink Level: 5,0; Paper Count: 5";
        assertEquals(expected, printer.toString());
    }

    @Test
    public void testHPPrinterIsReady() {
        HPPrinter printer = new HPPrinter(10, 10);
        assertTrue(printer.isReady());
        HPPrinter emptyPrinter = new HPPrinter(0, 0);
        assertFalse(emptyPrinter.isReady());
    }
}
