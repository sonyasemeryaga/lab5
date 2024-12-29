package com.states;

import com.context.PrinterContext;

public class NonWorkingState extends PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (context.hasValidResources()) {
            switchToReadyState(context, "Printer successfully connected.");
        } else {
            System.out.println("Insufficient resources. Printer remains non-working.");
        }
    }
}
