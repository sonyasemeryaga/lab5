package com.states;

import com.context.PrinterContext;

public class SavingInkState implements PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Cannot print in ink-saving mode. Resources are insufficient.");
            return;
        }
        performInkSavingPrinting(context);
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Resources exhausted during ink-saving printing.");
            return;
        }
        switchToReadyState(context);
    }

    private void performInkSavingPrinting(PrinterContext context) {
        System.out.println("Printing in ink-saving mode...");
        context.useResources(0.5, 1);
    }

    private void switchToNonWorkingState(PrinterContext context, String message) {
        System.out.println(message + " Switching to NonWorkingState.");
        context.setState(new NonWorkingState());
    }

    private void switchToReadyState(PrinterContext context) {
        System.out.println("Ink-saving printing completed. Switching to ReadyState.");
        context.setState(new ReadyState());
    }
}
