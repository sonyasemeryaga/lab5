package com.adapters;

import com.printers.HPPrinter;

public class HPPrinterAdapter implements PrinterAdapter {
    private final HPPrinter printer;

    public HPPrinterAdapter(HPPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void connect() {
        printer.connectHP();
    }

    @Override
    public void print() {
        printer.printHP();
    }

    @Override
    public void saveInkPrint() {
        printer.saveInkPrintHP();
    }

    @Override
    public void maintain() {
        printer.maintainHP();
    }
}
