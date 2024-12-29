package com.adapters;

import com.printers.EpsonPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpsonPrinterAdapterTest {

    @Test
    public void givenEpsonPrinterWithSufficientResources_whenConnectCalled_thenPrinterIsConnected() {
        EpsonPrinter printer = new EpsonPrinter(20, 30);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        assertEquals("Ink Level: 20,0; Paper Count: 30", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(10, 20);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 9,0; Paper Count: 19", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowInk_whenPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0.2, 5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 0,2; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        EpsonPrinter printer = new EpsonPrinter(15, 15);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 14,5; Paper Count: 14", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowInk_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(0.3, 5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 0,3; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowPaper_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(20, 0);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 20,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithLowResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(0, 0);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithExcessiveResources_whenMaintenancePerformed_thenResourcesIncrease() {
        EpsonPrinter printer = new EpsonPrinter(40, 50);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 45,0; Paper Count: 55", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithNegativeInk_whenPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(-3, 10);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: -3,0; Paper Count: 10", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithNegativePaper_whenPrintCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(10, -5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 10,0; Paper Count: -5", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithNegativeInk_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(-1.5, 5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: -1,5; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithNegativePaper_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(10, -2);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 10,0; Paper Count: -2", printer.toString());
    }

    @Test
    public void givenEpsonPrinterWithNegativeResources_whenMaintenancePerformed_thenResourcesRemainUnchanged() {
        EpsonPrinter printer = new EpsonPrinter(-5, -5);
        EpsonPrinterAdapter adapter = new EpsonPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: -5,0; Paper Count: -5", printer.toString());
    }
}
