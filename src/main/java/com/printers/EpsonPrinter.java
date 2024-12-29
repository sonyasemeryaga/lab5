package com.printers;

import com.context.PrinterContext;
import com.states.MaintenanceState;
import com.states.NonWorkingState;
import com.states.PrintingState;
import com.states.SavingInkState;

public class EpsonPrinter {
    private final PrinterContext context;

    public EpsonPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public void connectEpson() {
        System.out.println("Connecting Epson Printer...");
        context.setState(new NonWorkingState());
        context.request();
    }

    public void printEpson() {
        System.out.println("Epson Printer is switching to PrintingState...");
        context.setState(new PrintingState());
        context.request();
    }

    public void saveInkPrintEpson() {
        System.out.println("Epson Printer is switching to InkSavingState...");
        context.setState(new SavingInkState());
        context.request();
    }

    public void maintainEpson() {
        System.out.println("Epson Printer is switching to MaintenanceState...");
        context.setState(new MaintenanceState());
        context.request();
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
