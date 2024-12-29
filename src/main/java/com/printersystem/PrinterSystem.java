package com.printersystem;

import com.adapters.CanonPrinterAdapter;
import com.adapters.EpsonPrinterAdapter;
import com.adapters.HPPrinterAdapter;
import com.printers.CanonPrinter;
import com.printers.EpsonPrinter;
import com.printers.HPPrinter;

public class PrinterSystem {
    public static void main(String[] args) {
        HPPrinter hpPrinter = new HPPrinter(20, 100);
        HPPrinterAdapter hpAdapter = new HPPrinterAdapter(hpPrinter);
        System.out.println("Demo for Normal HP Printer:");
        hpAdapter.connect();
        hpAdapter.print();
        hpAdapter.saveInkPrint();
        hpAdapter.maintain();
        System.out.println(hpPrinter);

        CanonPrinter canonPrinter = new CanonPrinter(0, 0);
        CanonPrinterAdapter canonAdapter = new CanonPrinterAdapter(canonPrinter);
        System.out.println("\nDemo for Canon Printer with Zero Values:");
        canonAdapter.connect();
        canonAdapter.print();
        canonAdapter.saveInkPrint();
        canonAdapter.maintain();
        canonAdapter.print();
        System.out.println(canonPrinter);

        EpsonPrinter epsonPrinter = new EpsonPrinter(-5, -10);
        EpsonPrinterAdapter epsonAdapter = new EpsonPrinterAdapter(epsonPrinter);
        System.out.println("\nDemo for Epson Printer with Negative Values:");
        epsonAdapter.connect();
        epsonAdapter.print();
        epsonAdapter.saveInkPrint();
        epsonAdapter.maintain();
        epsonAdapter.print();
        System.out.println(epsonPrinter);
    }
}
