package com.states;

import com.context.PrinterContext;

public class PrintingState implements PrinterState {
    @Override
    public void handle(PrinterContext context) {
        if (context.hasEnoughResources()) {
            System.out.println("Printing document...");
            context.useResources(1, 1);
            if (!context.hasEnoughResources()) {
                System.out.println("Resources exhausted during printing. Switching to NonWorkingState.");
                context.setState(new NonWorkingState());
            } else {
                System.out.println("Printing completed. Switching to ReadyState.");
                context.setState(new ReadyState());
            }
        } else {
            System.out.println("Cannot print. Resources are insufficient. Switching to NonWorkingState.");
            context.setState(new NonWorkingState());
        }
    }
}
