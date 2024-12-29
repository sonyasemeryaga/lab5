package com.states;

import com.context.PrinterContext;

public class SavingInkState extends PrinterState {

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
        switchToReadyState(context, "Ink-saving printing completed.");
    }

    private void performInkSavingPrinting(PrinterContext context) {
        System.out.println("Printing in ink-saving mode...");
        context.useResources(0.5, 1);
    }
}
