package com.states;

import com.context.PrinterContext;

public class MaintenanceState implements PrinterState {
    @Override
    public void handle(PrinterContext context) {
        System.out.println("Performing maintenance...");
        context.replenishResources(5, 5);
        if (context.hasEnoughResources()) {
            System.out.println("Maintenance completed. Switching to ReadyState.");
            context.setState(new ReadyState());
        } else {
            System.out.println("Maintenance completed, but resources are still insufficient. Switching to NonWorkingState.");
            context.setState(new NonWorkingState());
        }
    }
}
