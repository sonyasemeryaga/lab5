package com.states;

import com.context.PrinterContext;

public class MaintenanceState extends PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (!context.hasValidResources()) {
            switchToNonWorkingState(context, "Cannot perform maintenance due to insufficient or invalid resources.");
            return;
        }
        performMaintenance(context);
        switchToReadyState(context, "Maintenance completed.");
    }

    private void performMaintenance(PrinterContext context) {
        System.out.println("Performing maintenance...");
        context.replenishResources(5, 5);
    }
}
