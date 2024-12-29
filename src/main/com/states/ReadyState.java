package com.states;

import com.context.PrinterContext;

public class ReadyState implements PrinterState {
    @Override
    public void handle(PrinterContext context) {
        if (context.hasEnoughResources()) {
            System.out.println("Printer is ready for operation.");
        } else {
            System.out.println("Resources are insufficient. Switching to NonWorkingState.");
            context.setState(new NonWorkingState());
        }
    }
}
