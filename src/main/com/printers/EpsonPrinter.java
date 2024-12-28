package com.printers;

import com.context.PrinterContext;

public class EpsonPrinter {
    private final PrinterContext context;

    public EpsonPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public boolean isReady() {
        return context.isReady();
    }

    public void printEpson() {
        if (context.isReady()) {
            System.out.println("Canon printer is printing...");
            context.useResources(1, 1);
        }
    }

    public void saveInkModeEpson() {
        if (context.isReady()) {
            System.out.println("Canon printer is printing in saving ink mode...");
            context.useResources(0.5, 1);
        }
    }

    public void performMaintenanceEpson() {
        System.out.println("Canon printer is performing maintenance...");
        context.replenishResources(5, 5);
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
