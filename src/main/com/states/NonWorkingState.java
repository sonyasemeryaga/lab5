package com.states;

import com.context.PrinterContext;

public class NonWorkingState implements PrinterState {
    @Override
    public void handle(PrinterContext context) {
        if (context.hasEnoughResources()) {
            System.out.println("Printer initialized. Switching to ReadyState.");
            context.setState(new ReadyState());
        } else {
            System.out.println("Insufficient resources. Printer remains uninitialized.");
        }
    }
}
