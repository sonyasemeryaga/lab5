package com.adapters;

import com.printers.HPPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HPPrinterAdapterTest {

    @Test
    public void givenPrinterWithSufficientResources_whenConnectCalled_thenPrinterIsConnected() {
        HPPrinter printer = new HPPrinter(15, 20);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        assertEquals("Ink Level: 15,0; Paper Count: 20", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenPrintCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 15);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 9,0; Paper Count: 14", printer.toString());
    }

    @Test
    public void givenPrinterWithLowInk_whenPrintCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0.5, 5);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.print();
        assertEquals("Ink Level: 0,5; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenSaveInkModeCalled_thenResourcesDecrease() {
        HPPrinter printer = new HPPrinter(10, 10);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 9,5; Paper Count: 9", printer.toString());
    }

    @Test
    public void givenPrinterWithLowInk_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(0.5, 5);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 0,5; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithLowPaper_whenSaveInkModeCalled_thenResourcesRemainUnchanged() {
        HPPrinter printer = new HPPrinter(10, 0);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.saveInkPrint();
        assertEquals("Ink Level: 10,0; Paper Count: 0", printer.toString());
    }

    @Test
    public void givenPrinterWithSufficientResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(0, 0);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 5,0; Paper Count: 5", printer.toString());
    }

    @Test
    public void givenPrinterWithExcessiveResources_whenMaintenancePerformed_thenResourcesIncrease() {
        HPPrinter printer = new HPPrinter(50, 50);
        HPPrinterAdapter adapter = new HPPrinterAdapter(printer);
        adapter.connect();
        adapter.maintain();
        assertEquals("Ink Level: 55,0; Paper Count: 55", printer.toString());
    }
}
