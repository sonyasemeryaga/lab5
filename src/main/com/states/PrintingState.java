package com.states;

import com.context.PrinterContext;

public class PrintingState implements PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Cannot print. Resources are insufficient.");
            return;
        }
        performPrinting(context);
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Resources exhausted during printing.");
            return;
        }
        switchToReadyState(context);
    }

    private void performPrinting(PrinterContext context) {
        System.out.println("Printing document...");
        context.useResources(1, 1);
    }

    private void switchToNonWorkingState(PrinterContext context, String message) {
        System.out.println(message + " Switching to NonWorkingState.");
        context.setState(new NonWorkingState());
    }

    private void switchToReadyState(PrinterContext context) {
        System.out.println("Printing completed. Switching to ReadyState.");
        context.setState(new ReadyState());
    }
}
