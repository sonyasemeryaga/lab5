package com.printers;

import com.context.PrinterContext;

public class HPPrinter {
    private final PrinterContext context;

    public HPPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public boolean isReady() {
        return context.hasEnoughResources();
    }

    public void printHP() {
        if (isReady()) {
            System.out.println("HP printer is printing...");
            context.useResources(1, 1);
        }
    }

    public void saveInkModeHP() {
        if (isReady()) {
            System.out.println("HP printer is printing in saving ink mode...");
            context.useResources(0.5, 1);
        }
    }

    public void performMaintenanceHP() {
        System.out.println("HP printer is performing maintenance...");
        context.replenishResources(5, 5);
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
