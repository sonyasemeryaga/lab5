package com.states;

import com.context.PrinterContext;

public class MaintenanceState extends PrinterState {

    @Override
    public void handle(PrinterContext context) {
        performMaintenance(context);
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Maintenance completed, but resources are still insufficient.");
            return;
        }
        switchToReadyState(context, "Maintenance completed.");
    }

    private void performMaintenance(PrinterContext context) {
        System.out.println("Performing maintenance...");
        context.replenishResources(5, 5);
    }
}
