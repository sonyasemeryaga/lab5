package com.states;

import com.context.PrinterContext;

public class PrintingState extends PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Cannot print due to invalid resources.");
            return;
        }
        performPrinting(context);
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Resources exhausted during printing.");
            return;
        }
        switchToReadyState(context, "Printing completed.");
    }

    private void performPrinting(PrinterContext context) {
        System.out.println("Attempting to print document...");
        context.useResources(1, 1);
    }
}
