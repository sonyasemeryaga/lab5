package com.states;

import com.context.PrinterContext;

public abstract class PrinterState {

    public abstract void handle(PrinterContext context);

    protected void switchToNonWorkingState(PrinterContext context, String message) {
        System.out.println(message + " Switching to NonWorkingState.");
        context.setState(new NonWorkingState());
    }

    protected void switchToReadyState(PrinterContext context, String message) {
        System.out.println(message + " Switching to ReadyState.");
        context.setState(new ReadyState());
    }
}
