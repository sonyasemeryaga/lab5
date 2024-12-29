package com.adapters;

import com.printers.CanonPrinter;

public class CanonPrinterAdapter implements PrinterAdapter {
    private final CanonPrinter printer;

    public CanonPrinterAdapter(CanonPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void connect() {
        printer.connectCanon();
    }

    @Override
    public void print() {
        printer.printCanon();
    }

    @Override
    public void saveInkPrint() {
        printer.saveInkPrintCanon();
    }

    @Override
    public void maintain() {
        printer.maintainCanon();
    }
}
