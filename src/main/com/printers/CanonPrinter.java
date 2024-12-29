package com.printers;

import com.context.PrinterContext;
import com.states.MaintenanceState;
import com.states.NonWorkingState;
import com.states.PrintingState;
import com.states.SavingInkState;

public class CanonPrinter {
    private final PrinterContext context;

    public CanonPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public void connectCanonPrinter() {
        System.out.println("Connecting Canon Printer...");
        context.setState(new NonWorkingState());
        context.request();
    }

    public void printCanon() {
        System.out.println("Canon Printer is switching to PrintingState...");
        context.setState(new PrintingState());
        context.request();
    }

    public void saveInkPrintCanon() {
        System.out.println("Canon Printer is switching to InkSavingState...");
        context.setState(new SavingInkState());
        context.request();
    }

    public void maintainCanon() {
        System.out.println("Canon Printer is switching to MaintenanceState...");
        context.setState(new MaintenanceState());
        context.request();
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
