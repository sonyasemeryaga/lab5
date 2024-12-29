package com.adapters;

import com.printers.EpsonPrinter;

public class EpsonPrinterAdapter implements PrinterAdapter {
    private final EpsonPrinter printer;

    public EpsonPrinterAdapter(EpsonPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void connect() {
        printer.connectEpson();
    }

    @Override
    public void print() {
        printer.printEpson();
    }

    @Override
    public void saveInkPrint() {
        printer.saveInkPrintEpson();
    }

    @Override
    public void maintain() {
        printer.maintainEpson();
    }
}
