package com.states;

import com.context.PrinterContext;

public class SavingInkState implements PrinterState {
    @Override
    public void handle(PrinterContext context) {
        if (context.hasEnoughResources()) {
            System.out.println("Printing in ink-saving mode...");
            context.useResources(0.5, 1);
            if (!context.hasEnoughResources()) {
                System.out.println("Resources exhausted during ink-saving printing. Switching to NonWorkingState.");
                context.setState(new NonWorkingState());
            } else {
                System.out.println("Ink-saving printing completed. Switching to ReadyState.");
                context.setState(new ReadyState());
            }
        } else {
            System.out.println("Cannot print in ink-saving mode. Resources are insufficient. Switching to NonWorkingState.");
            context.setState(new NonWorkingState());
        }
    }
}
