package com.states;

import com.context.PrinterContext;

public class ReadyState extends PrinterState {

    @Override
    public void handle(PrinterContext context) {
        if (!context.hasEnoughResources()) {
            switchToNonWorkingState(context, "Resources are insufficient.");
        } else {
            System.out.println("Printer is ready for operation.");
        }
    }
}
