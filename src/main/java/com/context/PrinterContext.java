package com.context;

import com.states.NonWorkingState;
import com.states.PrinterState;

public class PrinterContext {
    private PrinterState currentState;
    private double inkLevel;
    private int paperCount;

    public PrinterContext(double inkLevel, int paperCount) {
        this.inkLevel = inkLevel;
        this.paperCount = paperCount;
        this.currentState = new NonWorkingState();
    }

    public void setState(PrinterState state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }

    public boolean hasEnoughResources() {
        return inkLevel > 0 && paperCount > 0;
    }

    public boolean hasValidResources() {
        return inkLevel >= 0 && paperCount >= 0;
    }

    public boolean hasEnoughResourcesForCommonPrinting() {
        return inkLevel >= 1 && paperCount >= 1;
    }

    public void useResources(double ink, int paper) {
        if (paper <= paperCount && ink <= inkLevel) {
            paperCount -= paper;
            inkLevel -= ink;
        }
    }

    public void replenishResources(double ink, int paper) {
        paperCount += paper;
        inkLevel += ink;
    }

    @Override
    public String toString() {
        return String.format("Ink Level: %.1f; Paper Count: %d", inkLevel, paperCount);
    }
}
