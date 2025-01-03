package com.printers;

import com.context.PrinterContext;
import com.states.NonWorkingState;
import com.states.PrintingState;
import com.states.SavingInkState;
import com.states.MaintenanceState;

public class HPPrinter {
    private final PrinterContext context;

    public HPPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public void connectHP() {
        System.out.println("Connecting HP Printer...");
        context.request();
    }

    public void printHP() {
        System.out.println("HP Printer is switching to PrintingState...");
        context.setState(new PrintingState());
        context.request();
    }

    public void saveInkPrintHP() {
        System.out.println("HP Printer is switching to InkSavingState...");
        context.setState(new SavingInkState());
        context.request();
    }

    public void maintainHP() {
        System.out.println("HP Printer is switching to MaintenanceState...");
        context.setState(new MaintenanceState());
        context.request();
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
