package com.adapters;

import com.printers.CanonPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CanonPrinterAdapterTest {

    @Test
    public void givenCanonPrinterWithSufficientResources_whenConnectCalled_thenPrinterIsConnected() {
        CanonPrinter printer = new CanonPrinter(25, 30);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        assertEquals("Ink Level: 25,0; Paper Count: 30", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        CanonPrinter printer = new CanonPrinter(20, 25);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 19,0; Paper Count: 24", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithLowInk_whenPrintCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(0.5, 10);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 0,5; Paper Count: 10", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        CanonPrinter printer = new CanonPrinter(15, 20);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 14,5; Paper Count: 19", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithLowInk_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(0.2, 5);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 0,2; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithLowPaper_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(30, 0);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 30,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithLowResources_whenMaintenancePerformed_thenResourcesIncrease() {
        CanonPrinter printer = new CanonPrinter(0, 0);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithExcessiveResources_whenMaintenancePerformed_thenResourcesIncrease() {
        CanonPrinter printer = new CanonPrinter(60, 60);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 65,0; Paper Count: 65", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithNegativeInk_whenPrintCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(-5, 10);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: -5,0; Paper Count: 10", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithNegativePaper_whenPrintCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(10, -5);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 10,0; Paper Count: -5", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithNegativeInk_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(-0.5, 5);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: -0,5; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithNegativePaper_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(10, -1);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 10,0; Paper Count: -1", printer.toString());
    }

    @Test
    public void givenCanonPrinterWithNegativeResources_whenMaintenancePerformed_thenResourcesRemainUnchanged() {
        CanonPrinter printer = new CanonPrinter(-5, -5);
        CanonPrinterAdapter adapter = new CanonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: -5,0; Paper Count: -5", printer.toString());
    }
}
