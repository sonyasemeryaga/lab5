package com.printers;

import com.context.PrinterContext;

public class CanonPrinter {
    private final PrinterContext context;

    public CanonPrinter(double inkLevel, int paperCount) {
        this.context = new PrinterContext(inkLevel, paperCount);
    }

    public boolean isReady() {
        return context.isReady();
    }

    public void printCanon() {
        if (context.isReady()) {
            System.out.println("Canon printer is printing...");
            context.useResources(1, 1);
        }
    }

    public void saveInkModeCanon() {
        if (context.isReady()) {
            System.out.println("Canon printer is printing in saving ink mode...");
            context.useResources(0.5, 1);
        }
    }

    public void performMaintenanceCanon() {
        System.out.println("Canon printer is performing maintenance...");
        context.replenishResources(5, 5);
    }

    @Override
    public String toString() {
        return context.toString();
    }
}
