package com.states;

import com.context.PrinterContext;

public class MaintenanceState implements PrinterState {

    @Override
    public void handle(PrinterContext context) {
        performMaintenance(context);
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Maintenance completed, but resources are still insufficient.");
            return;
        }
        switchToReadyState(context);
    }

    private void performMaintenance(PrinterContext context) {
        System.out.println("Performing maintenance...");
        context.replenishResources(5, 5);
    }

    private void switchToNonWorkingState(PrinterContext context, String message) {
        System.out.println(message + " Switching to NonWorkingState.");
        context.setState(new NonWorkingState());
    }

    private void switchToReadyState(PrinterContext context) {
        System.out.println("Maintenance completed. Switching to ReadyState.");
        context.setState(new ReadyState());
    }
}
