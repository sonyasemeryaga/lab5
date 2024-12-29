package com.states;

import com.context.PrinterContext;

public interface PrinterState {
    void handle(PrinterContext context);
}
